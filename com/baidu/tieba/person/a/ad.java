package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.q, com.baidu.tieba.person.holder.o> {
    private static String eqD = "http://tieba.baidu.com/mo/q/godIntro";
    private BaseFragmentActivity bgI;
    private b eqE;
    private List<a> eqF;
    private a eqG;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.eqE = new b(eqD);
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
    public com.baidu.tieba.person.holder.o a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.o(LayoutInflater.from(this.mContext).inflate(u.h.person_info_user_god_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.q qVar, com.baidu.tieba.person.holder.o oVar) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        a(oVar);
        if (qVar != null && this.aNz) {
            a(oVar, qVar);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.o oVar, com.baidu.tieba.person.data.q qVar) {
        if (oVar != null && qVar != null) {
            this.godType = qVar.aNO();
            this.godDetailInfo = qVar.aNP();
            this.forumGodList = qVar.getForumGodList();
            String string = this.bgI.getResources().getString(u.j.tb_user_god);
            if (this.godType == 2) {
                oVar.ewR.setVisibility(8);
                int s = com.baidu.tbadk.core.util.y.s(this.forumGodList);
                if (s == 1) {
                    oVar.ewM.setVisibility(0);
                    oVar.ewQ.setVisibility(8);
                    ForumGodDetailInfo forumGodDetailInfo = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, 0);
                    String str = String.valueOf(forumGodDetailInfo.forum_name) + "吧";
                    String str2 = forumGodDetailInfo.avatar;
                    String str3 = forumGodDetailInfo.intro;
                    oVar.ewN.c(str2, 10, false);
                    oVar.ewO.setText(ba.c(str, 7, "..."));
                    if (ba.isEmpty(str3)) {
                        oVar.ewP.setText(string);
                    } else {
                        oVar.ewP.setText(str3);
                    }
                } else if (s > 1) {
                    oVar.ewQ.setVisibility(0);
                    oVar.ewM.setVisibility(8);
                    oVar.ewQ.removeAllViews();
                    this.eqF = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.ceil(s / 2.0d)) {
                            break;
                        }
                        View inflate = View.inflate(this.bgI.getActivity(), u.h.person_info_user_god_card_multi_item, null);
                        if (i2 == 0) {
                            inflate.setPadding(0, 0, 0, 0);
                        }
                        this.eqG = new a(this, null);
                        this.eqG.eqH = (RelativeLayout) inflate.findViewById(u.g.user_god_multi_item_line_left);
                        this.eqG.eqI = (HeadImageView) inflate.findViewById(u.g.user_god_multi_item_left_forum_avatar);
                        this.eqG.eqJ = (TextView) inflate.findViewById(u.g.user_god_multi_item_left_forum_name);
                        this.eqG.eqK = (TextView) inflate.findViewById(u.g.user_god_multi_item_left_tag);
                        this.eqG.eqL = (RelativeLayout) inflate.findViewById(u.g.user_god_multi_item_line_right);
                        this.eqG.eqM = (HeadImageView) inflate.findViewById(u.g.user_god_multi_item_right_forum_avatar);
                        this.eqG.eqN = (TextView) inflate.findViewById(u.g.user_god_multi_item_right_forum_name);
                        this.eqG.eqO = (TextView) inflate.findViewById(u.g.user_god_multi_item_right_tag);
                        av.j((View) this.eqG.eqJ, u.d.cp_cont_b);
                        av.j((View) this.eqG.eqN, u.d.cp_cont_b);
                        av.j((View) this.eqG.eqK, u.d.cp_cont_h);
                        av.j((View) this.eqG.eqO, u.d.cp_cont_h);
                        av.k(this.eqG.eqK, u.f.icon_shen);
                        av.k(this.eqG.eqO, u.f.icon_shen);
                        if (0 < s && i2 * 2 < s) {
                            this.eqG.eqH.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo2 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, i2 * 2);
                            String str4 = String.valueOf(forumGodDetailInfo2.forum_name) + "吧";
                            String str5 = forumGodDetailInfo2.avatar;
                            String str6 = forumGodDetailInfo2.intro;
                            this.eqG.eqH.setMinimumWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bgI.getResources().getDimensionPixelSize(u.e.ds60));
                            this.eqG.eqI.c(str5, 10, false);
                            this.eqG.eqJ.setText(ba.c(str4, 7, "..."));
                            this.eqG.eqJ.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bgI.getResources().getDimensionPixelSize(u.e.ds140));
                            this.eqG.eqK.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bgI.getResources().getDimensionPixelSize(u.e.ds140));
                            this.eqG.eqJ.setWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bgI.getResources().getDimensionPixelSize(u.e.ds140));
                            if (ba.isEmpty(str6)) {
                                this.eqG.eqK.setText(string);
                            } else {
                                this.eqG.eqK.setText(str6);
                            }
                        }
                        if (0 < s && (i2 * 2) + 1 < s) {
                            this.eqG.eqL.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo3 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, (i2 * 2) + 1);
                            String str7 = String.valueOf(forumGodDetailInfo3.forum_name) + "吧";
                            String str8 = forumGodDetailInfo3.avatar;
                            String str9 = forumGodDetailInfo3.intro;
                            this.eqG.eqL.setMinimumWidth(com.baidu.adp.lib.util.k.A(this.mContext) / 2);
                            this.eqG.eqM.c(str8, 10, false);
                            this.eqG.eqN.setText(ba.c(str7, 7, "..."));
                            this.eqG.eqN.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bgI.getResources().getDimensionPixelSize(u.e.ds120));
                            this.eqG.eqO.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bgI.getResources().getDimensionPixelSize(u.e.ds120));
                            if (ba.isEmpty(str9)) {
                                this.eqG.eqO.setText(string);
                            } else {
                                this.eqG.eqO.setText(str9);
                            }
                        }
                        this.eqF.add(this.eqG);
                        oVar.ewQ.addView(inflate);
                        i = i2 + 1;
                    }
                }
            } else if (this.godType == 1) {
                oVar.ewM.setVisibility(8);
                oVar.ewQ.setVisibility(8);
                oVar.ewR.setVisibility(0);
                String str10 = this.godDetailInfo.detail_intro;
                if (ba.isEmpty(str10)) {
                    oVar.ewT.setVisibility(8);
                } else {
                    oVar.ewT.setVisibility(0);
                    oVar.ewT.setText(str10);
                }
                String str11 = this.godDetailInfo.intro;
                if (ba.isEmpty(str11)) {
                    oVar.ewS.setText(string);
                } else {
                    oVar.ewS.setText(str11);
                }
            }
            oVar.ewL.setOnClickListener(this.eqE);
        }
    }

    private void a(com.baidu.tieba.person.holder.o oVar) {
        int skinType;
        if (oVar != null && (skinType = TbadkCoreApplication.m10getInst().getSkinType()) != oVar.mSkinType) {
            av.l(oVar.euV, u.d.cp_bg_line_c);
            av.l(oVar.getView(), u.d.cp_bg_line_d);
            av.c(oVar.ewK, u.f.pic_tiebadashen_bg);
            av.c(oVar.ewL, u.f.btn_shen_explain);
            av.l(oVar.ewM, u.d.cp_bg_line_d);
            av.j((View) oVar.ewO, u.d.cp_cont_b);
            av.j((View) oVar.ewP, u.d.cp_cont_h);
            av.k(oVar.ewP, u.f.icon_shen);
            av.l(oVar.ewQ, u.d.cp_bg_line_d);
            if (com.baidu.tbadk.core.util.y.s(this.eqF) > 0) {
                for (a aVar : this.eqF) {
                    if (aVar != null) {
                        av.j((View) aVar.eqJ, u.d.cp_cont_b);
                        av.j((View) aVar.eqN, u.d.cp_cont_b);
                        av.j((View) aVar.eqK, u.d.cp_cont_h);
                        av.j((View) aVar.eqO, u.d.cp_cont_h);
                        av.k(aVar.eqK, u.f.icon_shen);
                        av.k(aVar.eqO, u.f.icon_shen);
                    }
                }
            }
            av.l(oVar.ewR, u.d.cp_bg_line_d);
            av.j((View) oVar.ewT, u.d.cp_cont_f);
            av.j((View) oVar.ewS, u.d.cp_cont_h);
            av.j((View) oVar.ewU, u.d.cp_cont_c);
            av.k(oVar.ewS, u.f.icon_shen);
            oVar.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private String url;

        public b(String str) {
            this.url = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.url != null) {
                bi.us().c(ad.this.bgI.getPageContext(), new String[]{this.url});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public RelativeLayout eqH;
        public HeadImageView eqI;
        public TextView eqJ;
        public TextView eqK;
        public RelativeLayout eqL;
        public HeadImageView eqM;
        public TextView eqN;
        public TextView eqO;

        private a() {
            this.eqH = null;
            this.eqI = null;
            this.eqJ = null;
            this.eqK = null;
            this.eqL = null;
            this.eqM = null;
            this.eqN = null;
            this.eqO = null;
        }

        /* synthetic */ a(ad adVar, a aVar) {
            this();
        }
    }
}
