package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.r, com.baidu.tieba.person.b.o> {
    private static String egE = "http://tieba.baidu.com/mo/q/godIntro";
    private BaseFragmentActivity bfw;
    private b egF;
    private List<a> egG;
    private a egH;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public af(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.egF = new b(egE);
        this.bfw = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public com.baidu.tieba.person.b.o a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.o(LayoutInflater.from(this.mContext).inflate(u.h.person_info_user_god_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.r rVar, com.baidu.tieba.person.b.o oVar) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        a(oVar);
        if (rVar != null && this.aMF) {
            a(oVar, rVar);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.o oVar, com.baidu.tieba.person.data.r rVar) {
        if (oVar != null && rVar != null) {
            this.godType = rVar.aLl();
            this.godDetailInfo = rVar.aLm();
            this.forumGodList = rVar.getForumGodList();
            String string = this.bfw.getResources().getString(u.j.tb_user_god);
            if (this.godType == 2) {
                oVar.ems.setVisibility(8);
                int s = com.baidu.tbadk.core.util.y.s(this.forumGodList);
                if (s == 1) {
                    oVar.emn.setVisibility(0);
                    oVar.emr.setVisibility(8);
                    ForumGodDetailInfo forumGodDetailInfo = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, 0);
                    String str = String.valueOf(forumGodDetailInfo.forum_name) + "吧";
                    String str2 = forumGodDetailInfo.avatar;
                    String str3 = forumGodDetailInfo.intro;
                    oVar.emo.c(str2, 10, false);
                    oVar.emp.setText(ba.c(str, 7, "..."));
                    if (ba.isEmpty(str3)) {
                        oVar.emq.setText(string);
                    } else {
                        oVar.emq.setText(str3);
                    }
                } else if (s > 1) {
                    oVar.emr.setVisibility(0);
                    oVar.emn.setVisibility(8);
                    oVar.emr.removeAllViews();
                    this.egG = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.ceil(s / 2.0d)) {
                            break;
                        }
                        View inflate = View.inflate(this.bfw.getActivity(), u.h.person_info_user_god_card_multi_item, null);
                        if (i2 == 0) {
                            inflate.setPadding(0, 0, 0, 0);
                        }
                        this.egH = new a(this, null);
                        this.egH.egI = (RelativeLayout) inflate.findViewById(u.g.user_god_multi_item_line_left);
                        this.egH.egJ = (HeadImageView) inflate.findViewById(u.g.user_god_multi_item_left_forum_avatar);
                        this.egH.egK = (TextView) inflate.findViewById(u.g.user_god_multi_item_left_forum_name);
                        this.egH.egL = (TextView) inflate.findViewById(u.g.user_god_multi_item_left_tag);
                        this.egH.egM = (RelativeLayout) inflate.findViewById(u.g.user_god_multi_item_line_right);
                        this.egH.egN = (HeadImageView) inflate.findViewById(u.g.user_god_multi_item_right_forum_avatar);
                        this.egH.egO = (TextView) inflate.findViewById(u.g.user_god_multi_item_right_forum_name);
                        this.egH.egP = (TextView) inflate.findViewById(u.g.user_god_multi_item_right_tag);
                        com.baidu.tbadk.core.util.av.j((View) this.egH.egK, u.d.cp_cont_b);
                        com.baidu.tbadk.core.util.av.j((View) this.egH.egO, u.d.cp_cont_b);
                        com.baidu.tbadk.core.util.av.j((View) this.egH.egL, u.d.cp_cont_h);
                        com.baidu.tbadk.core.util.av.j((View) this.egH.egP, u.d.cp_cont_h);
                        com.baidu.tbadk.core.util.av.k(this.egH.egL, u.f.icon_shen);
                        com.baidu.tbadk.core.util.av.k(this.egH.egP, u.f.icon_shen);
                        if (0 < s && i2 * 2 < s) {
                            this.egH.egI.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo2 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, i2 * 2);
                            String str4 = String.valueOf(forumGodDetailInfo2.forum_name) + "吧";
                            String str5 = forumGodDetailInfo2.avatar;
                            String str6 = forumGodDetailInfo2.intro;
                            this.egH.egI.setMinimumWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bfw.getResources().getDimensionPixelSize(u.e.ds60));
                            this.egH.egJ.c(str5, 10, false);
                            this.egH.egK.setText(ba.c(str4, 7, "..."));
                            this.egH.egK.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bfw.getResources().getDimensionPixelSize(u.e.ds140));
                            this.egH.egL.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bfw.getResources().getDimensionPixelSize(u.e.ds140));
                            this.egH.egK.setWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bfw.getResources().getDimensionPixelSize(u.e.ds140));
                            if (ba.isEmpty(str6)) {
                                this.egH.egL.setText(string);
                            } else {
                                this.egH.egL.setText(str6);
                            }
                        }
                        if (0 < s && (i2 * 2) + 1 < s) {
                            this.egH.egM.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo3 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, (i2 * 2) + 1);
                            String str7 = String.valueOf(forumGodDetailInfo3.forum_name) + "吧";
                            String str8 = forumGodDetailInfo3.avatar;
                            String str9 = forumGodDetailInfo3.intro;
                            this.egH.egM.setMinimumWidth(com.baidu.adp.lib.util.k.A(this.mContext) / 2);
                            this.egH.egN.c(str8, 10, false);
                            this.egH.egO.setText(ba.c(str7, 7, "..."));
                            this.egH.egO.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bfw.getResources().getDimensionPixelSize(u.e.ds120));
                            this.egH.egP.setMaxWidth((com.baidu.adp.lib.util.k.A(this.mContext) / 2) - this.bfw.getResources().getDimensionPixelSize(u.e.ds120));
                            if (ba.isEmpty(str9)) {
                                this.egH.egP.setText(string);
                            } else {
                                this.egH.egP.setText(str9);
                            }
                        }
                        this.egG.add(this.egH);
                        oVar.emr.addView(inflate);
                        i = i2 + 1;
                    }
                }
            } else if (this.godType == 1) {
                oVar.emn.setVisibility(8);
                oVar.emr.setVisibility(8);
                oVar.ems.setVisibility(0);
                String str10 = this.godDetailInfo.detail_intro;
                if (ba.isEmpty(str10)) {
                    oVar.emu.setVisibility(8);
                } else {
                    oVar.emu.setVisibility(0);
                    oVar.emu.setText(str10);
                }
                String str11 = this.godDetailInfo.intro;
                if (ba.isEmpty(str11)) {
                    oVar.emt.setText(string);
                } else {
                    oVar.emt.setText(str11);
                }
            }
            oVar.emm.setOnClickListener(this.egF);
        }
    }

    private void a(com.baidu.tieba.person.b.o oVar) {
        int skinType;
        if (oVar != null && (skinType = TbadkCoreApplication.m9getInst().getSkinType()) != oVar.mSkinType) {
            com.baidu.tbadk.core.util.av.l(oVar.eky, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(oVar.getView(), u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(oVar.eml, u.f.pic_tiebadashen_bg);
            com.baidu.tbadk.core.util.av.c(oVar.emm, u.f.btn_shen_explain);
            com.baidu.tbadk.core.util.av.l(oVar.emn, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.j((View) oVar.emp, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) oVar.emq, u.d.cp_cont_h);
            com.baidu.tbadk.core.util.av.k(oVar.emq, u.f.icon_shen);
            com.baidu.tbadk.core.util.av.l(oVar.emr, u.d.cp_bg_line_d);
            if (com.baidu.tbadk.core.util.y.s(this.egG) > 0) {
                for (a aVar : this.egG) {
                    if (aVar != null) {
                        com.baidu.tbadk.core.util.av.j((View) aVar.egK, u.d.cp_cont_b);
                        com.baidu.tbadk.core.util.av.j((View) aVar.egO, u.d.cp_cont_b);
                        com.baidu.tbadk.core.util.av.j((View) aVar.egL, u.d.cp_cont_h);
                        com.baidu.tbadk.core.util.av.j((View) aVar.egP, u.d.cp_cont_h);
                        com.baidu.tbadk.core.util.av.k(aVar.egL, u.f.icon_shen);
                        com.baidu.tbadk.core.util.av.k(aVar.egP, u.f.icon_shen);
                    }
                }
            }
            com.baidu.tbadk.core.util.av.l(oVar.ems, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.j((View) oVar.emu, u.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) oVar.emt, u.d.cp_cont_h);
            com.baidu.tbadk.core.util.av.j((View) oVar.emv, u.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.k(oVar.emt, u.f.icon_shen);
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
                bi.us().c(af.this.bfw.getPageContext(), new String[]{this.url});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public RelativeLayout egI;
        public HeadImageView egJ;
        public TextView egK;
        public TextView egL;
        public RelativeLayout egM;
        public HeadImageView egN;
        public TextView egO;
        public TextView egP;

        private a() {
            this.egI = null;
            this.egJ = null;
            this.egK = null;
            this.egL = null;
            this.egM = null;
            this.egN = null;
            this.egO = null;
            this.egP = null;
        }

        /* synthetic */ a(af afVar, a aVar) {
            this();
        }
    }
}
