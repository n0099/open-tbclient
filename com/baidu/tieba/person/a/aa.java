package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.personInfo.PersonInfoAbstract;
import com.baidu.tieba.personInfo.PersonInfoMedia;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonInfoVideo;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aa extends c<com.baidu.tieba.person.data.o, com.baidu.tieba.person.b.l> {
    private View.OnClickListener OZ;
    private com.baidu.tbadk.data.g duY;
    private PersonTainInfo duZ;
    private List<PersonInfoPostList> dvh;
    private String dvi;
    private b dvj;
    private boolean isSelf;
    protected int mSkinType;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.dvh = new ArrayList();
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.person.b.l b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.l(LayoutInflater.from(this.mContext).inflate(t.h.person_info_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.o oVar, com.baidu.tieba.person.b.l lVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(lVar);
        if (oVar != null && this.bcn) {
            a(lVar, oVar);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.o oVar) {
        if (oVar != null && oVar.getUserData() != null && lVar != null) {
            this.duY = oVar.aBT();
            this.duZ = oVar.aBS();
            this.OZ = new a(oVar.getUserId(), oVar.getSex(), oVar.getPortrait());
            this.isSelf = oVar.getIsSelf();
            this.userId = oVar.getUserId();
            int CJ = this.duY != null ? this.duY.CJ() : 1;
            int isFriend = this.duZ != null ? this.duZ.getIsFriend() : 1;
            if (this.isSelf) {
                b(lVar, oVar);
            } else if (CJ == 1 || (CJ == 2 && isFriend == 1)) {
                b(lVar, oVar);
            } else {
                c(lVar, oVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.o oVar) {
        String str;
        String str2;
        if (lVar != null && oVar != null) {
            this.isSelf = oVar.getIsSelf();
            this.dvi = this.mContext.getResources().getString(t.j.my_threads);
            this.dvh = oVar.aBW();
            if (!this.isSelf && oVar.getSex() == 2) {
                this.dvi = this.mContext.getResources().getString(t.j.her_threads);
            } else if (!this.isSelf && (oVar.getSex() == 1 || oVar.getSex() == 0)) {
                this.dvi = this.mContext.getResources().getString(t.j.his_threads);
            }
            if (com.baidu.tbadk.core.util.y.p(this.dvh) <= 0) {
                lVar.dyH.setVisibility(8);
                lVar.dzL.setVisibility(8);
                lVar.dzP.setVisibility(0);
                lVar.dzQ.setText(this.dvi);
                lVar.dzP.setOnClickListener(this.OZ);
                return;
            }
            lVar.dyH.setVisibility(0);
            lVar.dzL.setVisibility(0);
            lVar.dyS.setVisibility(0);
            lVar.dzL.setVisibility(0);
            lVar.dzP.setVisibility(8);
            lVar.dzM.setText(this.dvi);
            lVar.dzO.setText(ay.z(oVar.getPostNum()));
            int p = com.baidu.tbadk.core.util.y.p(this.dvh);
            for (int i = 0; i < p && i < 2; i++) {
                PersonInfoPostList personInfoPostList = (PersonInfoPostList) com.baidu.tbadk.core.util.y.b(this.dvh, i);
                if (personInfoPostList != null) {
                    List<PersonInfoAbstract> abstractThread = personInfoPostList.getAbstractThread();
                    List<PersonInfoMedia> media = personInfoPostList.getMedia();
                    PersonInfoVideo videoInfo = personInfoPostList.getVideoInfo();
                    long threadType = personInfoPostList.getThreadType();
                    if (i == 0 && personInfoPostList.getIsThread() == 1) {
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.p(media) <= 0 || com.baidu.tbadk.core.util.y.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl = videoInfo.getThumbnailUrl();
                                lVar.dAl.setVisibility(0);
                                str2 = thumbnailUrl;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getType() == 5) {
                                String vpic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getVpic();
                                lVar.dAl.setVisibility(0);
                                str2 = vpic;
                            } else {
                                String smallPic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getSmallPic();
                                lVar.dAl.setVisibility(8);
                                str2 = smallPic;
                            }
                            lVar.dzT.setVisibility(0);
                            lVar.dzY.setVisibility(8);
                            lVar.dAd.setVisibility(8);
                            lVar.dAh.setVisibility(8);
                            this.dvj = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dzT.setOnClickListener(this.dvj);
                            lVar.dzU.c(str2, 10, false);
                            lVar.dzU.setGifIconSupport(false);
                            lVar.dzU.setDrawBorder(true);
                            lVar.dzU.setBorderWidth(1);
                            lVar.dzX.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            lVar.dzV.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.p(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dzW.setText(ay.c(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                lVar.dzW.setText("");
                            }
                        } else {
                            lVar.dzT.setVisibility(8);
                            lVar.dzY.setVisibility(8);
                            lVar.dAd.setVisibility(0);
                            lVar.dAh.setVisibility(8);
                            this.dvj = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dAd.setOnClickListener(this.dvj);
                            lVar.dAe.setText(personInfoPostList.getTitle());
                            lVar.dAg.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.p(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dAf.setVisibility(0);
                                lVar.dAf.setText(abstractThread.get(0).getText());
                            } else {
                                lVar.dAf.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            lVar.dAn.setVisibility(0);
                            lVar.dAp.setVisibility(0);
                        } else {
                            lVar.dAn.setVisibility(8);
                            lVar.dAp.setVisibility(8);
                        }
                    } else if (i == 1) {
                        lVar.dyF.setVisibility(0);
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.p(media) <= 0 || com.baidu.tbadk.core.util.y.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl2 = videoInfo.getThumbnailUrl();
                                lVar.dAm.setVisibility(0);
                                str = thumbnailUrl2;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getType() == 5) {
                                String vpic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getVpic();
                                lVar.dAm.setVisibility(0);
                                str = vpic2;
                            } else {
                                String smallPic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getSmallPic();
                                lVar.dAm.setVisibility(8);
                                str = smallPic2;
                            }
                            lVar.dzY.setVisibility(0);
                            this.dvj = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dzY.setOnClickListener(this.dvj);
                            lVar.dzZ.setGifIconSupport(false);
                            lVar.dzZ.c(str, 10, false);
                            lVar.dzZ.setDrawBorder(true);
                            lVar.dzZ.setBorderWidth(1);
                            lVar.dAc.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            lVar.dAa.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.p(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dAb.setText(ay.c(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                lVar.dAb.setText("");
                            }
                        } else {
                            lVar.dAh.setVisibility(0);
                            this.dvj = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dAh.setOnClickListener(this.dvj);
                            lVar.dAi.setText(personInfoPostList.getTitle());
                            lVar.dAk.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.p(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dAj.setVisibility(0);
                                lVar.dAj.setText(abstractThread.get(0).getText());
                            } else {
                                lVar.dAj.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            lVar.dAo.setVisibility(0);
                            lVar.dAq.setVisibility(0);
                        } else {
                            lVar.dAo.setVisibility(8);
                            lVar.dAq.setVisibility(8);
                        }
                    }
                }
            }
            lVar.dzL.setOnClickListener(this.OZ);
            e(lVar.dyH);
        }
    }

    private void c(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.o oVar) {
        if (!this.isSelf && oVar.getSex() == 2) {
            this.dvi = this.mContext.getResources().getString(t.j.her_threads);
        } else if (!this.isSelf && (oVar.getSex() == 1 || oVar.getSex() == 0)) {
            this.dvi = this.mContext.getResources().getString(t.j.his_threads);
        }
        lVar.dzL.setVisibility(8);
        lVar.dyS.setVisibility(8);
        lVar.dyH.setVisibility(8);
        lVar.dzP.setVisibility(0);
        lVar.dzS.setVisibility(0);
        lVar.dzQ.setText(this.dvi);
        lVar.dzR.setText(t.j.set_private);
        lVar.dzP.setOnClickListener(new ab(this));
    }

    private void e(LinearLayout linearLayout) {
        if (linearLayout != null) {
            for (int childCount = linearLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = linearLayout.getChildAt(childCount);
                if ((childAt instanceof RelativeLayout) && childAt.getVisibility() == 0) {
                    childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds40));
                    return;
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.b.l lVar) {
        if (lVar != null && lVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(lVar.dAd, t.f.addresslist_item_bg);
            at.k(lVar.dAh, t.f.addresslist_item_bg);
            at.k(lVar.dzT, t.f.addresslist_item_bg);
            at.k(lVar.dzY, t.f.addresslist_item_bg);
            at.k(lVar.dzP, t.f.addresslist_item_bg);
            at.l(lVar.getView(), t.d.cp_bg_line_d);
            at.l(lVar.dyN, t.d.cp_bg_line_c);
            at.l(lVar.dyS, t.d.cp_bg_line_c);
            at.l(lVar.dyF, t.d.cp_bg_line_c);
            at.b(lVar.dzM, t.d.cp_cont_f, 1);
            at.b(lVar.dzO, t.d.cp_cont_c, 1);
            at.b(lVar.dAe, t.d.cp_cont_b, 1);
            at.b(lVar.dAf, t.d.cp_cont_d, 1);
            at.b(lVar.dAg, t.d.cp_cont_n, 1);
            at.k(lVar.dAg, t.f.label_bg_tie);
            at.b(lVar.dAi, t.d.cp_cont_b, 1);
            at.b(lVar.dAj, t.d.cp_cont_d, 1);
            at.b(lVar.dAk, t.d.cp_cont_n, 1);
            at.k(lVar.dAk, t.f.label_bg_tie);
            at.b(lVar.dzV, t.d.cp_cont_b, 1);
            at.b(lVar.dzW, t.d.cp_cont_d, 1);
            at.b(lVar.dzX, t.d.cp_cont_n, 1);
            at.k(lVar.dzX, t.f.label_bg_tie);
            at.b(lVar.dAa, t.d.cp_cont_b, 1);
            at.b(lVar.dAb, t.d.cp_cont_d, 1);
            at.b(lVar.dAc, t.d.cp_cont_n, 1);
            at.k(lVar.dAc, t.f.label_bg_tie);
            at.b(lVar.dzQ, t.d.cp_cont_f, 1);
            at.b(lVar.dzR, t.d.cp_cont_d, 1);
            at.c(lVar.dzN, t.f.icon_arrow_tab);
            at.c(lVar.dzS, t.f.icon_mycenter_lock);
            at.c(lVar.dAl, t.f.btn_icon_play_video_n);
            at.c(lVar.dAm, t.f.btn_icon_play_video_n);
            at.c(lVar.dAn, t.f.icon_zhibo);
            at.c(lVar.dAo, t.f.icon_zhibo);
            at.c(lVar.dAp, t.f.icon_zhibo);
            at.c(lVar.dAq, t.f.icon_zhibo);
            lVar.aik = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private String id;
        private int sex;
        private String userPortrait;

        public a(String str, int i, String str2) {
            this.id = str;
            this.sex = i;
            this.userPortrait = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.id != null && this.userPortrait != null && bl.ad(aa.this.mContext)) {
                if (!aa.this.isSelf) {
                    if (aa.this.userId != null) {
                        if (view.getId() == t.g.thread_head) {
                            TiebaStatic.log(new aw("c10618").r("obj_type", 1).ac("obj_id", aa.this.userId));
                        } else if (view.getId() == t.g.thread_none) {
                            TiebaStatic.log(new aw("c10618").r("obj_type", 3).ac("obj_id", aa.this.userId));
                        }
                    }
                } else if (view.getId() == t.g.thread_head) {
                    TiebaStatic.log(new aw("c10594").r("obj_type", 1));
                } else if (view.getId() == t.g.thread_none) {
                    TiebaStatic.log(new aw("c10594").r("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(aa.this.mContext, this.id, this.sex, this.userPortrait)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private String postID;
        private String threadID;
        private long threadType;

        public b(long j, long j2, long j3) {
            this.threadType = 0L;
            this.threadID = String.valueOf(j);
            this.postID = String.valueOf(j2);
            this.threadType = j3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.threadID != null && this.postID != null && bl.ad(aa.this.mContext)) {
                if (!aa.this.isSelf) {
                    if (aa.this.userId != null) {
                        TiebaStatic.log(new aw("c10618").r("obj_type", 2).ac("obj_id", aa.this.userId));
                    }
                } else {
                    TiebaStatic.log(new aw("c10594").r("obj_type", 2));
                }
                if (this.threadType != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(aa.this.mContext).createCfgForPersonCenter(this.threadID, this.postID, "person_post", 18005)));
                } else if (!aa.this.Lw()) {
                    UtilHelper.showToast(aa.this.mContext, t.j.plugin_config_not_found);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(aa.this.mContext, this.threadID).cj(this.postID).qT()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lw() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }
}
