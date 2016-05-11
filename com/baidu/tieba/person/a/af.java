package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class af extends c<com.baidu.tieba.person.data.r, com.baidu.tieba.person.b.o> {
    private static String dyi = "http://tieba.baidu.com/mo/q/godIntro";
    private BaseFragmentActivity cSp;
    private b dyj;
    private List<a> dyk;
    private a dyl;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public af(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.dyj = new b(dyi);
        this.cSp = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public com.baidu.tieba.person.b.o b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.o(LayoutInflater.from(this.mContext).inflate(t.h.person_info_user_god_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.r rVar, com.baidu.tieba.person.b.o oVar) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        a(oVar);
        if (rVar != null && this.bUL) {
            a(oVar, rVar);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.o oVar, com.baidu.tieba.person.data.r rVar) {
        if (oVar != null && rVar != null) {
            this.godType = rVar.aCp();
            this.godDetailInfo = rVar.aCq();
            this.forumGodList = rVar.getForumGodList();
            String string = this.cSp.getResources().getString(t.j.tb_user_god);
            if (this.godType == 2) {
                oVar.dDG.setVisibility(8);
                int r = com.baidu.tbadk.core.util.y.r(this.forumGodList);
                if (r == 1) {
                    oVar.dDB.setVisibility(0);
                    oVar.dDF.setVisibility(8);
                    ForumGodDetailInfo forumGodDetailInfo = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, 0);
                    String str = String.valueOf(forumGodDetailInfo.forum_name) + "吧";
                    String str2 = forumGodDetailInfo.avatar;
                    String str3 = forumGodDetailInfo.intro;
                    oVar.dDC.c(str2, 10, false);
                    oVar.dDD.setText(ay.c(str, 7, "..."));
                    if (ay.isEmpty(str3)) {
                        oVar.dDE.setText(string);
                    } else {
                        oVar.dDE.setText(str3);
                    }
                } else if (r > 1) {
                    oVar.dDF.setVisibility(0);
                    oVar.dDB.setVisibility(8);
                    oVar.dDF.removeAllViews();
                    this.dyk = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.ceil(r / 2.0d)) {
                            break;
                        }
                        View inflate = View.inflate(this.cSp.getActivity(), t.h.person_info_user_god_card_multi_item, null);
                        if (i2 == 0) {
                            inflate.setPadding(0, 0, 0, 0);
                        }
                        this.dyl = new a(this, null);
                        this.dyl.dym = (RelativeLayout) inflate.findViewById(t.g.user_god_multi_item_line_left);
                        this.dyl.dyn = (HeadImageView) inflate.findViewById(t.g.user_god_multi_item_left_forum_avatar);
                        this.dyl.dyo = (TextView) inflate.findViewById(t.g.user_god_multi_item_left_forum_name);
                        this.dyl.dyp = (TextView) inflate.findViewById(t.g.user_god_multi_item_left_tag);
                        this.dyl.dyq = (RelativeLayout) inflate.findViewById(t.g.user_god_multi_item_line_right);
                        this.dyl.dyr = (HeadImageView) inflate.findViewById(t.g.user_god_multi_item_right_forum_avatar);
                        this.dyl.dys = (TextView) inflate.findViewById(t.g.user_god_multi_item_right_forum_name);
                        this.dyl.dyt = (TextView) inflate.findViewById(t.g.user_god_multi_item_right_tag);
                        com.baidu.tbadk.core.util.at.j((View) this.dyl.dyo, t.d.cp_cont_b);
                        com.baidu.tbadk.core.util.at.j((View) this.dyl.dys, t.d.cp_cont_b);
                        com.baidu.tbadk.core.util.at.j((View) this.dyl.dyp, t.d.cp_cont_h);
                        com.baidu.tbadk.core.util.at.j((View) this.dyl.dyt, t.d.cp_cont_h);
                        com.baidu.tbadk.core.util.at.k(this.dyl.dyp, t.f.icon_shen);
                        com.baidu.tbadk.core.util.at.k(this.dyl.dyt, t.f.icon_shen);
                        if (0 < r && i2 * 2 < r) {
                            this.dyl.dym.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo2 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, i2 * 2);
                            String str4 = String.valueOf(forumGodDetailInfo2.forum_name) + "吧";
                            String str5 = forumGodDetailInfo2.avatar;
                            String str6 = forumGodDetailInfo2.intro;
                            this.dyl.dym.setMinimumWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.cSp.getResources().getDimensionPixelSize(t.e.ds60));
                            this.dyl.dyn.c(str5, 10, false);
                            this.dyl.dyo.setText(ay.c(str4, 7, "..."));
                            this.dyl.dyo.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.cSp.getResources().getDimensionPixelSize(t.e.ds140));
                            this.dyl.dyp.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.cSp.getResources().getDimensionPixelSize(t.e.ds140));
                            this.dyl.dyo.setWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.cSp.getResources().getDimensionPixelSize(t.e.ds140));
                            if (ay.isEmpty(str6)) {
                                this.dyl.dyp.setText(string);
                            } else {
                                this.dyl.dyp.setText(str6);
                            }
                        }
                        if (0 < r && (i2 * 2) + 1 < r) {
                            this.dyl.dyq.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo3 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.c(this.forumGodList, (i2 * 2) + 1);
                            String str7 = String.valueOf(forumGodDetailInfo3.forum_name) + "吧";
                            String str8 = forumGodDetailInfo3.avatar;
                            String str9 = forumGodDetailInfo3.intro;
                            this.dyl.dyq.setMinimumWidth(com.baidu.adp.lib.util.k.B(this.mContext) / 2);
                            this.dyl.dyr.c(str8, 10, false);
                            this.dyl.dys.setText(ay.c(str7, 7, "..."));
                            this.dyl.dys.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.cSp.getResources().getDimensionPixelSize(t.e.ds120));
                            this.dyl.dyt.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.cSp.getResources().getDimensionPixelSize(t.e.ds120));
                            if (ay.isEmpty(str9)) {
                                this.dyl.dyt.setText(string);
                            } else {
                                this.dyl.dyt.setText(str9);
                            }
                        }
                        this.dyk.add(this.dyl);
                        oVar.dDF.addView(inflate);
                        i = i2 + 1;
                    }
                }
            } else if (this.godType == 1) {
                oVar.dDB.setVisibility(8);
                oVar.dDF.setVisibility(8);
                oVar.dDG.setVisibility(0);
                String str10 = this.godDetailInfo.detail_intro;
                if (ay.isEmpty(str10)) {
                    oVar.dDI.setVisibility(8);
                } else {
                    oVar.dDI.setVisibility(0);
                    oVar.dDI.setText(str10);
                }
                String str11 = this.godDetailInfo.intro;
                if (ay.isEmpty(str11)) {
                    oVar.dDH.setText(string);
                } else {
                    oVar.dDH.setText(str11);
                }
            }
            oVar.dDA.setOnClickListener(this.dyj);
        }
    }

    private void a(com.baidu.tieba.person.b.o oVar) {
        int skinType;
        if (oVar != null && (skinType = TbadkCoreApplication.m11getInst().getSkinType()) != oVar.mSkinType) {
            com.baidu.tbadk.core.util.at.l(oVar.dBV, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(oVar.getView(), t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.c(oVar.dDz, t.f.pic_tiebadashen_bg);
            com.baidu.tbadk.core.util.at.c(oVar.dDA, t.f.btn_shen_explain);
            com.baidu.tbadk.core.util.at.l(oVar.dDB, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.j((View) oVar.dDD, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) oVar.dDE, t.d.cp_cont_h);
            com.baidu.tbadk.core.util.at.k(oVar.dDE, t.f.icon_shen);
            com.baidu.tbadk.core.util.at.l(oVar.dDF, t.d.cp_bg_line_d);
            if (com.baidu.tbadk.core.util.y.r(this.dyk) > 0) {
                for (a aVar : this.dyk) {
                    if (aVar != null) {
                        com.baidu.tbadk.core.util.at.j((View) aVar.dyo, t.d.cp_cont_b);
                        com.baidu.tbadk.core.util.at.j((View) aVar.dys, t.d.cp_cont_b);
                        com.baidu.tbadk.core.util.at.j((View) aVar.dyp, t.d.cp_cont_h);
                        com.baidu.tbadk.core.util.at.j((View) aVar.dyt, t.d.cp_cont_h);
                        com.baidu.tbadk.core.util.at.k(aVar.dyp, t.f.icon_shen);
                        com.baidu.tbadk.core.util.at.k(aVar.dyt, t.f.icon_shen);
                    }
                }
            }
            com.baidu.tbadk.core.util.at.l(oVar.dDG, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.j((View) oVar.dDI, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.j((View) oVar.dDH, t.d.cp_cont_h);
            com.baidu.tbadk.core.util.at.j((View) oVar.dDJ, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.k(oVar.dDH, t.f.icon_shen);
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
                bg.us().c(af.this.cSp.getPageContext(), new String[]{this.url});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public RelativeLayout dym;
        public HeadImageView dyn;
        public TextView dyo;
        public TextView dyp;
        public RelativeLayout dyq;
        public HeadImageView dyr;
        public TextView dys;
        public TextView dyt;

        private a() {
            this.dym = null;
            this.dyn = null;
            this.dyo = null;
            this.dyp = null;
            this.dyq = null;
            this.dyr = null;
            this.dys = null;
            this.dyt = null;
        }

        /* synthetic */ a(af afVar, a aVar) {
            this();
        }
    }
}
