package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class y extends c<com.baidu.tieba.person.data.m, com.baidu.tieba.person.b.j> {
    private static String cMI = "http://tieba.baidu.com/mo/q/godIntro";
    private a cMJ;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    private BaseFragmentActivity mActivity;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cMJ = new a(cMI);
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.person.b.j a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.j(LayoutInflater.from(this.mContext).inflate(n.g.person_info_user_god_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.b.j jVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(jVar);
        if (mVar != null && this.aRB) {
            a(jVar, mVar);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.m mVar) {
        if (jVar != null && mVar != null) {
            this.godType = mVar.aon();
            this.godDetailInfo = mVar.aoo();
            this.forumGodList = mVar.getForumGodList();
            String string = this.mActivity.getResources().getString(n.i.tb_user_god);
            if (this.godType == 2) {
                jVar.cPY.setVisibility(8);
                int k = com.baidu.tbadk.core.util.y.k(this.forumGodList);
                if (k == 1) {
                    jVar.cPL.setVisibility(0);
                    jVar.cPP.setVisibility(8);
                    ForumGodDetailInfo forumGodDetailInfo = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, 0);
                    String str = String.valueOf(forumGodDetailInfo.forum_name) + "吧";
                    String str2 = forumGodDetailInfo.avatar;
                    String str3 = forumGodDetailInfo.intro;
                    String str4 = forumGodDetailInfo.detail_intro;
                    jVar.cPM.d(str2, 10, false);
                    jVar.cPN.setText(ax.d(str, 7, "..."));
                    if (ax.isEmpty(str3)) {
                        jVar.cPO.setText(string);
                    } else {
                        jVar.cPO.setText(str3);
                    }
                } else if (k > 1) {
                    jVar.cPP.setVisibility(0);
                    jVar.cPL.setVisibility(8);
                    jVar.cPP.removeAllViews();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.ceil(k / 2.0d)) {
                            break;
                        }
                        View inflate = View.inflate(this.mActivity.getActivity(), n.g.person_info_user_god_card_multi_item, null);
                        if (i2 == 0) {
                            inflate.setPadding(0, 0, 0, 0);
                        }
                        jVar.cPQ = (RelativeLayout) inflate.findViewById(n.f.user_god_multi_item_line_left);
                        jVar.cPR = (HeadImageView) inflate.findViewById(n.f.user_god_multi_item_left_forum_avatar);
                        jVar.cPS = (TextView) inflate.findViewById(n.f.user_god_multi_item_left_forum_name);
                        jVar.cPT = (TextView) inflate.findViewById(n.f.user_god_multi_item_left_tag);
                        jVar.cPU = (RelativeLayout) inflate.findViewById(n.f.user_god_multi_item_line_right);
                        jVar.cPV = (HeadImageView) inflate.findViewById(n.f.user_god_multi_item_right_forum_avatar);
                        jVar.cPW = (TextView) inflate.findViewById(n.f.user_god_multi_item_right_forum_name);
                        jVar.cPX = (TextView) inflate.findViewById(n.f.user_god_multi_item_right_tag);
                        as.h((View) jVar.cPS, n.c.cp_cont_b);
                        as.h((View) jVar.cPW, n.c.cp_cont_b);
                        as.h((View) jVar.cPT, n.c.cp_cont_h);
                        as.h((View) jVar.cPX, n.c.cp_cont_h);
                        as.i((View) jVar.cPT, n.e.icon_shen);
                        as.i((View) jVar.cPX, n.e.icon_shen);
                        if (0 < k && i2 * 2 < k) {
                            jVar.cPQ.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo2 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, i2 * 2);
                            String str5 = String.valueOf(forumGodDetailInfo2.forum_name) + "吧";
                            String str6 = forumGodDetailInfo2.avatar;
                            String str7 = forumGodDetailInfo2.intro;
                            String str8 = forumGodDetailInfo2.detail_intro;
                            jVar.cPQ.setMinimumWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.d.ds60));
                            jVar.cPR.d(str6, 10, false);
                            jVar.cPS.setText(ax.d(str5, 7, "..."));
                            jVar.cPS.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.d.ds140));
                            jVar.cPT.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.d.ds140));
                            jVar.cPS.setWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.d.ds140));
                            if (ax.isEmpty(str7)) {
                                jVar.cPT.setText(string);
                            } else {
                                jVar.cPT.setText(str7);
                            }
                        }
                        if (0 < k && (i2 * 2) + 1 < k) {
                            jVar.cPU.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo3 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, (i2 * 2) + 1);
                            String str9 = String.valueOf(forumGodDetailInfo3.forum_name) + "吧";
                            String str10 = forumGodDetailInfo3.avatar;
                            String str11 = forumGodDetailInfo3.intro;
                            String str12 = forumGodDetailInfo3.detail_intro;
                            jVar.cPU.setMinimumWidth(com.baidu.adp.lib.util.k.K(this.mContext) / 2);
                            jVar.cPV.d(str10, 10, false);
                            jVar.cPW.setText(ax.d(str9, 7, "..."));
                            jVar.cPW.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.d.ds120));
                            jVar.cPX.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.d.ds120));
                            if (ax.isEmpty(str11)) {
                                jVar.cPX.setText(string);
                            } else {
                                jVar.cPX.setText(str11);
                            }
                        }
                        jVar.cPP.addView(inflate);
                        i = i2 + 1;
                    }
                }
            } else if (this.godType == 1) {
                jVar.cPL.setVisibility(8);
                jVar.cPP.setVisibility(8);
                jVar.cPY.setVisibility(0);
                String str13 = this.godDetailInfo.detail_intro;
                if (ax.isEmpty(str13)) {
                    jVar.cQa.setVisibility(8);
                } else {
                    jVar.cQa.setVisibility(0);
                    jVar.cQa.setText(str13);
                }
                String str14 = this.godDetailInfo.intro;
                if (ax.isEmpty(str14)) {
                    jVar.cPZ.setText(string);
                } else {
                    jVar.cPZ.setText(str14);
                }
            }
            jVar.cPK.setOnClickListener(this.cMJ);
        }
    }

    private void a(com.baidu.tieba.person.b.j jVar) {
        int skinType;
        if (jVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != jVar.mSkinType) {
            as.j(jVar.cOr, n.c.cp_bg_line_c);
            as.j(jVar.getView(), n.c.cp_bg_line_d);
            as.c(jVar.cPJ, n.e.pic_tiebadashen_bg);
            as.c(jVar.cPK, n.e.btn_shen_explain);
            as.j(jVar.cPL, n.c.cp_bg_line_d);
            as.h((View) jVar.cPN, n.c.cp_cont_b);
            as.h((View) jVar.cPO, n.c.cp_cont_h);
            as.i((View) jVar.cPO, n.e.icon_shen);
            as.j(jVar.cPP, n.c.cp_bg_line_d);
            as.j(jVar.cPY, n.c.cp_bg_line_d);
            as.h((View) jVar.cQa, n.c.cp_cont_f);
            as.h((View) jVar.cPZ, n.c.cp_cont_h);
            as.h((View) jVar.cQb, n.c.cp_cont_c);
            as.i((View) jVar.cPZ, n.e.icon_shen);
            jVar.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private String url;

        public a(String str) {
            this.url = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.url != null) {
                bf.vD().b(y.this.mActivity.getPageContext(), new String[]{this.url});
            }
        }
    }
}
