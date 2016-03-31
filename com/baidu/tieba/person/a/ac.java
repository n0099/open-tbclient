package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class ac extends c<com.baidu.tieba.person.data.p, com.baidu.tieba.person.b.m> {
    private static String dvl = "http://tieba.baidu.com/mo/q/godIntro";
    private BaseFragmentActivity duj;
    private b dvm;
    private List<a> dvn;
    private a dvo;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.dvm = new b(dvl);
        this.duj = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public com.baidu.tieba.person.b.m b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.m(LayoutInflater.from(this.mContext).inflate(t.h.person_info_user_god_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.p pVar, com.baidu.tieba.person.b.m mVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(mVar);
        if (pVar != null && this.bcn) {
            a(mVar, pVar);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.p pVar) {
        if (mVar != null && pVar != null) {
            this.godType = pVar.aBX();
            this.godDetailInfo = pVar.aBY();
            this.forumGodList = pVar.getForumGodList();
            String string = this.duj.getResources().getString(t.j.tb_user_god);
            if (this.godType == 2) {
                mVar.dAy.setVisibility(8);
                int p = com.baidu.tbadk.core.util.y.p(this.forumGodList);
                if (p == 1) {
                    mVar.dAt.setVisibility(0);
                    mVar.dAx.setVisibility(8);
                    ForumGodDetailInfo forumGodDetailInfo = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, 0);
                    String str = String.valueOf(forumGodDetailInfo.forum_name) + "吧";
                    String str2 = forumGodDetailInfo.avatar;
                    String str3 = forumGodDetailInfo.intro;
                    mVar.dAu.c(str2, 10, false);
                    mVar.dAv.setText(ay.c(str, 7, "..."));
                    if (ay.isEmpty(str3)) {
                        mVar.dAw.setText(string);
                    } else {
                        mVar.dAw.setText(str3);
                    }
                } else if (p > 1) {
                    mVar.dAx.setVisibility(0);
                    mVar.dAt.setVisibility(8);
                    mVar.dAx.removeAllViews();
                    this.dvn = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.ceil(p / 2.0d)) {
                            break;
                        }
                        View inflate = View.inflate(this.duj.getActivity(), t.h.person_info_user_god_card_multi_item, null);
                        if (i2 == 0) {
                            inflate.setPadding(0, 0, 0, 0);
                        }
                        this.dvo = new a(this, null);
                        this.dvo.dvp = (RelativeLayout) inflate.findViewById(t.g.user_god_multi_item_line_left);
                        this.dvo.dvq = (HeadImageView) inflate.findViewById(t.g.user_god_multi_item_left_forum_avatar);
                        this.dvo.dvr = (TextView) inflate.findViewById(t.g.user_god_multi_item_left_forum_name);
                        this.dvo.dvs = (TextView) inflate.findViewById(t.g.user_god_multi_item_left_tag);
                        this.dvo.dvt = (RelativeLayout) inflate.findViewById(t.g.user_god_multi_item_line_right);
                        this.dvo.dvu = (HeadImageView) inflate.findViewById(t.g.user_god_multi_item_right_forum_avatar);
                        this.dvo.dvv = (TextView) inflate.findViewById(t.g.user_god_multi_item_right_forum_name);
                        this.dvo.dvw = (TextView) inflate.findViewById(t.g.user_god_multi_item_right_tag);
                        at.j((View) this.dvo.dvr, t.d.cp_cont_b);
                        at.j((View) this.dvo.dvv, t.d.cp_cont_b);
                        at.j((View) this.dvo.dvs, t.d.cp_cont_h);
                        at.j((View) this.dvo.dvw, t.d.cp_cont_h);
                        at.k(this.dvo.dvs, t.f.icon_shen);
                        at.k(this.dvo.dvw, t.f.icon_shen);
                        if (0 < p && i2 * 2 < p) {
                            this.dvo.dvp.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo2 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, i2 * 2);
                            String str4 = String.valueOf(forumGodDetailInfo2.forum_name) + "吧";
                            String str5 = forumGodDetailInfo2.avatar;
                            String str6 = forumGodDetailInfo2.intro;
                            this.dvo.dvp.setMinimumWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.duj.getResources().getDimensionPixelSize(t.e.ds60));
                            this.dvo.dvq.c(str5, 10, false);
                            this.dvo.dvr.setText(ay.c(str4, 7, "..."));
                            this.dvo.dvr.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.duj.getResources().getDimensionPixelSize(t.e.ds140));
                            this.dvo.dvs.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.duj.getResources().getDimensionPixelSize(t.e.ds140));
                            this.dvo.dvr.setWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.duj.getResources().getDimensionPixelSize(t.e.ds140));
                            if (ay.isEmpty(str6)) {
                                this.dvo.dvs.setText(string);
                            } else {
                                this.dvo.dvs.setText(str6);
                            }
                        }
                        if (0 < p && (i2 * 2) + 1 < p) {
                            this.dvo.dvt.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo3 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, (i2 * 2) + 1);
                            String str7 = String.valueOf(forumGodDetailInfo3.forum_name) + "吧";
                            String str8 = forumGodDetailInfo3.avatar;
                            String str9 = forumGodDetailInfo3.intro;
                            this.dvo.dvt.setMinimumWidth(com.baidu.adp.lib.util.k.B(this.mContext) / 2);
                            this.dvo.dvu.c(str8, 10, false);
                            this.dvo.dvv.setText(ay.c(str7, 7, "..."));
                            this.dvo.dvv.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.duj.getResources().getDimensionPixelSize(t.e.ds120));
                            this.dvo.dvw.setMaxWidth((com.baidu.adp.lib.util.k.B(this.mContext) / 2) - this.duj.getResources().getDimensionPixelSize(t.e.ds120));
                            if (ay.isEmpty(str9)) {
                                this.dvo.dvw.setText(string);
                            } else {
                                this.dvo.dvw.setText(str9);
                            }
                        }
                        this.dvn.add(this.dvo);
                        mVar.dAx.addView(inflate);
                        i = i2 + 1;
                    }
                }
            } else if (this.godType == 1) {
                mVar.dAt.setVisibility(8);
                mVar.dAx.setVisibility(8);
                mVar.dAy.setVisibility(0);
                String str10 = this.godDetailInfo.detail_intro;
                if (ay.isEmpty(str10)) {
                    mVar.dAA.setVisibility(8);
                } else {
                    mVar.dAA.setVisibility(0);
                    mVar.dAA.setText(str10);
                }
                String str11 = this.godDetailInfo.intro;
                if (ay.isEmpty(str11)) {
                    mVar.dAz.setText(string);
                } else {
                    mVar.dAz.setText(str11);
                }
            }
            mVar.dAs.setOnClickListener(this.dvm);
        }
    }

    private void a(com.baidu.tieba.person.b.m mVar) {
        int skinType;
        if (mVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != mVar.mSkinType) {
            at.l(mVar.dyN, t.d.cp_bg_line_c);
            at.l(mVar.getView(), t.d.cp_bg_line_d);
            at.c(mVar.dAr, t.f.pic_tiebadashen_bg);
            at.c(mVar.dAs, t.f.btn_shen_explain);
            at.l(mVar.dAt, t.d.cp_bg_line_d);
            at.j((View) mVar.dAv, t.d.cp_cont_b);
            at.j((View) mVar.dAw, t.d.cp_cont_h);
            at.k(mVar.dAw, t.f.icon_shen);
            at.l(mVar.dAx, t.d.cp_bg_line_d);
            if (com.baidu.tbadk.core.util.y.p(this.dvn) > 0) {
                for (a aVar : this.dvn) {
                    if (aVar != null) {
                        at.j((View) aVar.dvr, t.d.cp_cont_b);
                        at.j((View) aVar.dvv, t.d.cp_cont_b);
                        at.j((View) aVar.dvs, t.d.cp_cont_h);
                        at.j((View) aVar.dvw, t.d.cp_cont_h);
                        at.k(aVar.dvs, t.f.icon_shen);
                        at.k(aVar.dvw, t.f.icon_shen);
                    }
                }
            }
            at.l(mVar.dAy, t.d.cp_bg_line_d);
            at.j((View) mVar.dAA, t.d.cp_cont_f);
            at.j((View) mVar.dAz, t.d.cp_cont_h);
            at.j((View) mVar.dAB, t.d.cp_cont_c);
            at.k(mVar.dAz, t.f.icon_shen);
            mVar.mSkinType = skinType;
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
                bg.wM().c(ac.this.duj.getPageContext(), new String[]{this.url});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public RelativeLayout dvp;
        public HeadImageView dvq;
        public TextView dvr;
        public TextView dvs;
        public RelativeLayout dvt;
        public HeadImageView dvu;
        public TextView dvv;
        public TextView dvw;

        private a() {
            this.dvp = null;
            this.dvq = null;
            this.dvr = null;
            this.dvs = null;
            this.dvt = null;
            this.dvu = null;
            this.dvv = null;
            this.dvw = null;
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
