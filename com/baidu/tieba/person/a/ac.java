package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class ac extends c<com.baidu.tieba.person.data.p, com.baidu.tieba.person.b.m> {
    private static String daJ = "http://tieba.baidu.com/mo/q/godIntro";
    private BaseFragmentActivity cZG;
    private b daK;
    private List<a> daL;
    private a daM;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.daK = new b(daJ);
        this.cZG = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public com.baidu.tieba.person.b.m b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.m(LayoutInflater.from(this.mContext).inflate(t.h.person_info_user_god_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.p pVar, com.baidu.tieba.person.b.m mVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(mVar);
        if (pVar != null && this.aXE) {
            a(mVar, pVar);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.p pVar) {
        if (mVar != null && pVar != null) {
            this.godType = pVar.aur();
            this.godDetailInfo = pVar.aus();
            this.forumGodList = pVar.getForumGodList();
            String string = this.cZG.getResources().getString(t.j.tb_user_god);
            if (this.godType == 2) {
                mVar.dfZ.setVisibility(8);
                int o = com.baidu.tbadk.core.util.x.o(this.forumGodList);
                if (o == 1) {
                    mVar.dfU.setVisibility(0);
                    mVar.dfY.setVisibility(8);
                    ForumGodDetailInfo forumGodDetailInfo = (ForumGodDetailInfo) com.baidu.tbadk.core.util.x.b(this.forumGodList, 0);
                    String str = String.valueOf(forumGodDetailInfo.forum_name) + "吧";
                    String str2 = forumGodDetailInfo.avatar;
                    String str3 = forumGodDetailInfo.intro;
                    mVar.dfV.d(str2, 10, false);
                    mVar.dfW.setText(aw.d(str, 7, "..."));
                    if (aw.isEmpty(str3)) {
                        mVar.dfX.setText(string);
                    } else {
                        mVar.dfX.setText(str3);
                    }
                } else if (o > 1) {
                    mVar.dfY.setVisibility(0);
                    mVar.dfU.setVisibility(8);
                    mVar.dfY.removeAllViews();
                    this.daL = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.ceil(o / 2.0d)) {
                            break;
                        }
                        View inflate = View.inflate(this.cZG.getActivity(), t.h.person_info_user_god_card_multi_item, null);
                        if (i2 == 0) {
                            inflate.setPadding(0, 0, 0, 0);
                        }
                        this.daM = new a(this, null);
                        this.daM.daN = (RelativeLayout) inflate.findViewById(t.g.user_god_multi_item_line_left);
                        this.daM.daO = (HeadImageView) inflate.findViewById(t.g.user_god_multi_item_left_forum_avatar);
                        this.daM.daP = (TextView) inflate.findViewById(t.g.user_god_multi_item_left_forum_name);
                        this.daM.daQ = (TextView) inflate.findViewById(t.g.user_god_multi_item_left_tag);
                        this.daM.daR = (RelativeLayout) inflate.findViewById(t.g.user_god_multi_item_line_right);
                        this.daM.daS = (HeadImageView) inflate.findViewById(t.g.user_god_multi_item_right_forum_avatar);
                        this.daM.daT = (TextView) inflate.findViewById(t.g.user_god_multi_item_right_forum_name);
                        this.daM.daU = (TextView) inflate.findViewById(t.g.user_god_multi_item_right_tag);
                        ar.j((View) this.daM.daP, t.d.cp_cont_b);
                        ar.j((View) this.daM.daT, t.d.cp_cont_b);
                        ar.j((View) this.daM.daQ, t.d.cp_cont_h);
                        ar.j((View) this.daM.daU, t.d.cp_cont_h);
                        ar.k(this.daM.daQ, t.f.icon_shen);
                        ar.k(this.daM.daU, t.f.icon_shen);
                        if (0 < o && i2 * 2 < o) {
                            this.daM.daN.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo2 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.x.b(this.forumGodList, i2 * 2);
                            String str4 = String.valueOf(forumGodDetailInfo2.forum_name) + "吧";
                            String str5 = forumGodDetailInfo2.avatar;
                            String str6 = forumGodDetailInfo2.intro;
                            this.daM.daN.setMinimumWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.cZG.getResources().getDimensionPixelSize(t.e.ds60));
                            this.daM.daO.d(str5, 10, false);
                            this.daM.daP.setText(aw.d(str4, 7, "..."));
                            this.daM.daP.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.cZG.getResources().getDimensionPixelSize(t.e.ds140));
                            this.daM.daQ.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.cZG.getResources().getDimensionPixelSize(t.e.ds140));
                            this.daM.daP.setWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.cZG.getResources().getDimensionPixelSize(t.e.ds140));
                            if (aw.isEmpty(str6)) {
                                this.daM.daQ.setText(string);
                            } else {
                                this.daM.daQ.setText(str6);
                            }
                        }
                        if (0 < o && (i2 * 2) + 1 < o) {
                            this.daM.daR.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo3 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.x.b(this.forumGodList, (i2 * 2) + 1);
                            String str7 = String.valueOf(forumGodDetailInfo3.forum_name) + "吧";
                            String str8 = forumGodDetailInfo3.avatar;
                            String str9 = forumGodDetailInfo3.intro;
                            this.daM.daR.setMinimumWidth(com.baidu.adp.lib.util.k.K(this.mContext) / 2);
                            this.daM.daS.d(str8, 10, false);
                            this.daM.daT.setText(aw.d(str7, 7, "..."));
                            this.daM.daT.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.cZG.getResources().getDimensionPixelSize(t.e.ds120));
                            this.daM.daU.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.cZG.getResources().getDimensionPixelSize(t.e.ds120));
                            if (aw.isEmpty(str9)) {
                                this.daM.daU.setText(string);
                            } else {
                                this.daM.daU.setText(str9);
                            }
                        }
                        this.daL.add(this.daM);
                        mVar.dfY.addView(inflate);
                        i = i2 + 1;
                    }
                }
            } else if (this.godType == 1) {
                mVar.dfU.setVisibility(8);
                mVar.dfY.setVisibility(8);
                mVar.dfZ.setVisibility(0);
                String str10 = this.godDetailInfo.detail_intro;
                if (aw.isEmpty(str10)) {
                    mVar.dgb.setVisibility(8);
                } else {
                    mVar.dgb.setVisibility(0);
                    mVar.dgb.setText(str10);
                }
                String str11 = this.godDetailInfo.intro;
                if (aw.isEmpty(str11)) {
                    mVar.dga.setText(string);
                } else {
                    mVar.dga.setText(str11);
                }
            }
            mVar.dfT.setOnClickListener(this.daK);
        }
    }

    private void a(com.baidu.tieba.person.b.m mVar) {
        int skinType;
        if (mVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != mVar.mSkinType) {
            ar.l(mVar.deo, t.d.cp_bg_line_c);
            ar.l(mVar.getView(), t.d.cp_bg_line_d);
            ar.c(mVar.dfS, t.f.pic_tiebadashen_bg);
            ar.c(mVar.dfT, t.f.btn_shen_explain);
            ar.l(mVar.dfU, t.d.cp_bg_line_d);
            ar.j((View) mVar.dfW, t.d.cp_cont_b);
            ar.j((View) mVar.dfX, t.d.cp_cont_h);
            ar.k(mVar.dfX, t.f.icon_shen);
            ar.l(mVar.dfY, t.d.cp_bg_line_d);
            if (com.baidu.tbadk.core.util.x.o(this.daL) > 0) {
                for (a aVar : this.daL) {
                    if (aVar != null) {
                        ar.j((View) aVar.daP, t.d.cp_cont_b);
                        ar.j((View) aVar.daT, t.d.cp_cont_b);
                        ar.j((View) aVar.daQ, t.d.cp_cont_h);
                        ar.j((View) aVar.daU, t.d.cp_cont_h);
                        ar.k(aVar.daQ, t.f.icon_shen);
                        ar.k(aVar.daU, t.f.icon_shen);
                    }
                }
            }
            ar.l(mVar.dfZ, t.d.cp_bg_line_d);
            ar.j((View) mVar.dgb, t.d.cp_cont_f);
            ar.j((View) mVar.dga, t.d.cp_cont_h);
            ar.j((View) mVar.dgc, t.d.cp_cont_c);
            ar.k(mVar.dga, t.f.icon_shen);
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
                be.wt().c(ac.this.cZG.getPageContext(), new String[]{this.url});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public RelativeLayout daN;
        public HeadImageView daO;
        public TextView daP;
        public TextView daQ;
        public RelativeLayout daR;
        public HeadImageView daS;
        public TextView daT;
        public TextView daU;

        private a() {
            this.daN = null;
            this.daO = null;
            this.daP = null;
            this.daQ = null;
            this.daR = null;
            this.daS = null;
            this.daT = null;
            this.daU = null;
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
