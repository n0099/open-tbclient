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
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class ac extends c<com.baidu.tieba.person.data.o, com.baidu.tieba.person.b.l> {
    private static String cRc = "http://tieba.baidu.com/mo/q/godIntro";
    private b cRd;
    private List<a> cRe;
    private a cRf;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    private BaseFragmentActivity mActivity;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cRd = new b(cRc);
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public com.baidu.tieba.person.b.l a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.l(LayoutInflater.from(this.mContext).inflate(n.h.person_info_user_god_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.o oVar, com.baidu.tieba.person.b.l lVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(lVar);
        if (oVar != null && this.aVr) {
            a(lVar, oVar);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.o oVar) {
        if (lVar != null && oVar != null) {
            this.godType = oVar.apx();
            this.godDetailInfo = oVar.apy();
            this.forumGodList = oVar.getForumGodList();
            String string = this.mActivity.getResources().getString(n.j.tb_user_god);
            if (this.godType == 2) {
                lVar.cUA.setVisibility(8);
                int l = com.baidu.tbadk.core.util.y.l(this.forumGodList);
                if (l == 1) {
                    lVar.cUv.setVisibility(0);
                    lVar.cUz.setVisibility(8);
                    ForumGodDetailInfo forumGodDetailInfo = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, 0);
                    String str = String.valueOf(forumGodDetailInfo.forum_name) + "吧";
                    String str2 = forumGodDetailInfo.avatar;
                    String str3 = forumGodDetailInfo.intro;
                    lVar.cUw.d(str2, 10, false);
                    lVar.cUx.setText(ax.d(str, 7, "..."));
                    if (ax.isEmpty(str3)) {
                        lVar.cUy.setText(string);
                    } else {
                        lVar.cUy.setText(str3);
                    }
                } else if (l > 1) {
                    lVar.cUz.setVisibility(0);
                    lVar.cUv.setVisibility(8);
                    lVar.cUz.removeAllViews();
                    this.cRe = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.ceil(l / 2.0d)) {
                            break;
                        }
                        View inflate = View.inflate(this.mActivity.getActivity(), n.h.person_info_user_god_card_multi_item, null);
                        if (i2 == 0) {
                            inflate.setPadding(0, 0, 0, 0);
                        }
                        this.cRf = new a(this, null);
                        this.cRf.cRg = (RelativeLayout) inflate.findViewById(n.g.user_god_multi_item_line_left);
                        this.cRf.cRh = (HeadImageView) inflate.findViewById(n.g.user_god_multi_item_left_forum_avatar);
                        this.cRf.cRi = (TextView) inflate.findViewById(n.g.user_god_multi_item_left_forum_name);
                        this.cRf.cRj = (TextView) inflate.findViewById(n.g.user_god_multi_item_left_tag);
                        this.cRf.cRk = (RelativeLayout) inflate.findViewById(n.g.user_god_multi_item_line_right);
                        this.cRf.cRl = (HeadImageView) inflate.findViewById(n.g.user_god_multi_item_right_forum_avatar);
                        this.cRf.cRm = (TextView) inflate.findViewById(n.g.user_god_multi_item_right_forum_name);
                        this.cRf.cRn = (TextView) inflate.findViewById(n.g.user_god_multi_item_right_tag);
                        as.h((View) this.cRf.cRi, n.d.cp_cont_b);
                        as.h((View) this.cRf.cRm, n.d.cp_cont_b);
                        as.h((View) this.cRf.cRj, n.d.cp_cont_h);
                        as.h((View) this.cRf.cRn, n.d.cp_cont_h);
                        as.i((View) this.cRf.cRj, n.f.icon_shen);
                        as.i((View) this.cRf.cRn, n.f.icon_shen);
                        if (0 < l && i2 * 2 < l) {
                            this.cRf.cRg.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo2 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, i2 * 2);
                            String str4 = String.valueOf(forumGodDetailInfo2.forum_name) + "吧";
                            String str5 = forumGodDetailInfo2.avatar;
                            String str6 = forumGodDetailInfo2.intro;
                            this.cRf.cRg.setMinimumWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.e.ds60));
                            this.cRf.cRh.d(str5, 10, false);
                            this.cRf.cRi.setText(ax.d(str4, 7, "..."));
                            this.cRf.cRi.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.e.ds140));
                            this.cRf.cRj.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.e.ds140));
                            this.cRf.cRi.setWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.e.ds140));
                            if (ax.isEmpty(str6)) {
                                this.cRf.cRj.setText(string);
                            } else {
                                this.cRf.cRj.setText(str6);
                            }
                        }
                        if (0 < l && (i2 * 2) + 1 < l) {
                            this.cRf.cRk.setVisibility(0);
                            ForumGodDetailInfo forumGodDetailInfo3 = (ForumGodDetailInfo) com.baidu.tbadk.core.util.y.b(this.forumGodList, (i2 * 2) + 1);
                            String str7 = String.valueOf(forumGodDetailInfo3.forum_name) + "吧";
                            String str8 = forumGodDetailInfo3.avatar;
                            String str9 = forumGodDetailInfo3.intro;
                            this.cRf.cRk.setMinimumWidth(com.baidu.adp.lib.util.k.K(this.mContext) / 2);
                            this.cRf.cRl.d(str8, 10, false);
                            this.cRf.cRm.setText(ax.d(str7, 7, "..."));
                            this.cRf.cRm.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.e.ds120));
                            this.cRf.cRn.setMaxWidth((com.baidu.adp.lib.util.k.K(this.mContext) / 2) - this.mActivity.getResources().getDimensionPixelSize(n.e.ds120));
                            if (ax.isEmpty(str9)) {
                                this.cRf.cRn.setText(string);
                            } else {
                                this.cRf.cRn.setText(str9);
                            }
                        }
                        this.cRe.add(this.cRf);
                        lVar.cUz.addView(inflate);
                        i = i2 + 1;
                    }
                }
            } else if (this.godType == 1) {
                lVar.cUv.setVisibility(8);
                lVar.cUz.setVisibility(8);
                lVar.cUA.setVisibility(0);
                String str10 = this.godDetailInfo.detail_intro;
                if (ax.isEmpty(str10)) {
                    lVar.cUC.setVisibility(8);
                } else {
                    lVar.cUC.setVisibility(0);
                    lVar.cUC.setText(str10);
                }
                String str11 = this.godDetailInfo.intro;
                if (ax.isEmpty(str11)) {
                    lVar.cUB.setText(string);
                } else {
                    lVar.cUB.setText(str11);
                }
            }
            lVar.cUu.setOnClickListener(this.cRd);
        }
    }

    private void a(com.baidu.tieba.person.b.l lVar) {
        int skinType;
        if (lVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != lVar.mSkinType) {
            as.j(lVar.cTb, n.d.cp_bg_line_c);
            as.j(lVar.getView(), n.d.cp_bg_line_d);
            as.c(lVar.cUt, n.f.pic_tiebadashen_bg);
            as.c(lVar.cUu, n.f.btn_shen_explain);
            as.j(lVar.cUv, n.d.cp_bg_line_d);
            as.h((View) lVar.cUx, n.d.cp_cont_b);
            as.h((View) lVar.cUy, n.d.cp_cont_h);
            as.i((View) lVar.cUy, n.f.icon_shen);
            as.j(lVar.cUz, n.d.cp_bg_line_d);
            if (com.baidu.tbadk.core.util.y.l(this.cRe) > 0) {
                for (a aVar : this.cRe) {
                    if (aVar != null) {
                        as.h((View) aVar.cRi, n.d.cp_cont_b);
                        as.h((View) aVar.cRm, n.d.cp_cont_b);
                        as.h((View) aVar.cRj, n.d.cp_cont_h);
                        as.h((View) aVar.cRn, n.d.cp_cont_h);
                        as.i((View) aVar.cRj, n.f.icon_shen);
                        as.i((View) aVar.cRn, n.f.icon_shen);
                    }
                }
            }
            as.j(lVar.cUA, n.d.cp_bg_line_d);
            as.h((View) lVar.cUC, n.d.cp_cont_f);
            as.h((View) lVar.cUB, n.d.cp_cont_h);
            as.h((View) lVar.cUD, n.d.cp_cont_c);
            as.i((View) lVar.cUB, n.f.icon_shen);
            lVar.mSkinType = skinType;
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
                bf.vn().b(ac.this.mActivity.getPageContext(), new String[]{this.url});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public RelativeLayout cRg;
        public HeadImageView cRh;
        public TextView cRi;
        public TextView cRj;
        public RelativeLayout cRk;
        public HeadImageView cRl;
        public TextView cRm;
        public TextView cRn;

        private a() {
            this.cRg = null;
            this.cRh = null;
            this.cRi = null;
            this.cRj = null;
            this.cRk = null;
            this.cRl = null;
            this.cRm = null;
            this.cRn = null;
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
