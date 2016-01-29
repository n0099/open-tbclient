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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bi;
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
    private View.OnClickListener OS;
    private List<PersonInfoPostList> daF;
    private String daG;
    private b daH;
    private com.baidu.tbadk.data.f dav;
    private PersonTainInfo daw;
    private boolean isSelf;
    protected int mSkinType;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.daF = new ArrayList();
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.tieba.person.b.l b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.l(LayoutInflater.from(this.mContext).inflate(t.h.person_info_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.o oVar, com.baidu.tieba.person.b.l lVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(lVar);
        if (oVar != null && this.aXE) {
            a(lVar, oVar);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.o oVar) {
        if (oVar != null && oVar.getUserData() != null && lVar != null) {
            this.dav = oVar.aun();
            this.daw = oVar.aum();
            this.OS = new a(oVar.getUserId(), oVar.getSex(), oVar.getPortrait());
            this.isSelf = oVar.getIsSelf();
            this.userId = oVar.getUserId();
            int Ce = this.dav != null ? this.dav.Ce() : 1;
            int isFriend = this.daw != null ? this.daw.getIsFriend() : 1;
            if (this.isSelf) {
                b(lVar, oVar);
            } else if (Ce == 1 || (Ce == 2 && isFriend == 1)) {
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
            this.daG = this.mContext.getResources().getString(t.j.my_threads);
            this.daF = oVar.auq();
            if (!this.isSelf && oVar.getSex() == 2) {
                this.daG = this.mContext.getResources().getString(t.j.her_threads);
            } else if (!this.isSelf && (oVar.getSex() == 1 || oVar.getSex() == 0)) {
                this.daG = this.mContext.getResources().getString(t.j.his_threads);
            }
            if (com.baidu.tbadk.core.util.x.o(this.daF) <= 0) {
                lVar.deh.setVisibility(8);
                lVar.dfm.setVisibility(8);
                lVar.dfq.setVisibility(0);
                lVar.dfr.setText(this.daG);
                lVar.dfq.setOnClickListener(this.OS);
                return;
            }
            lVar.deh.setVisibility(0);
            lVar.dfm.setVisibility(0);
            lVar.det.setVisibility(0);
            lVar.dfm.setVisibility(0);
            lVar.dfq.setVisibility(8);
            lVar.dfn.setText(this.daG);
            lVar.dfp.setText(aw.x(oVar.getPostNum()));
            int o = com.baidu.tbadk.core.util.x.o(this.daF);
            for (int i = 0; i < o && i < 2; i++) {
                PersonInfoPostList personInfoPostList = (PersonInfoPostList) com.baidu.tbadk.core.util.x.b(this.daF, i);
                if (personInfoPostList != null) {
                    List<PersonInfoAbstract> abstractThread = personInfoPostList.getAbstractThread();
                    List<PersonInfoMedia> media = personInfoPostList.getMedia();
                    PersonInfoVideo videoInfo = personInfoPostList.getVideoInfo();
                    long threadType = personInfoPostList.getThreadType();
                    if (i == 0 && personInfoPostList.getIsThread() == 1) {
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.x.o(media) <= 0 || com.baidu.tbadk.core.util.x.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl = videoInfo.getThumbnailUrl();
                                lVar.dfM.setVisibility(0);
                                str2 = thumbnailUrl;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.x.b(media, 0)).getType() == 5) {
                                String vpic = ((PersonInfoMedia) com.baidu.tbadk.core.util.x.b(media, 0)).getVpic();
                                lVar.dfM.setVisibility(0);
                                str2 = vpic;
                            } else {
                                String smallPic = ((PersonInfoMedia) com.baidu.tbadk.core.util.x.b(media, 0)).getSmallPic();
                                lVar.dfM.setVisibility(8);
                                str2 = smallPic;
                            }
                            lVar.dfu.setVisibility(0);
                            lVar.dfz.setVisibility(8);
                            lVar.dfE.setVisibility(8);
                            lVar.dfI.setVisibility(8);
                            this.daH = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dfu.setOnClickListener(this.daH);
                            lVar.dfv.d(str2, 10, false);
                            lVar.dfv.setGifIconSupport(false);
                            lVar.dfv.setDrawBorder(true);
                            lVar.dfv.setBorderWidth(1);
                            lVar.dfy.setText(String.valueOf(aw.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            lVar.dfw.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.x.o(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dfx.setText(aw.d(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                lVar.dfx.setText("");
                            }
                        } else {
                            lVar.dfu.setVisibility(8);
                            lVar.dfz.setVisibility(8);
                            lVar.dfE.setVisibility(0);
                            lVar.dfI.setVisibility(8);
                            this.daH = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dfE.setOnClickListener(this.daH);
                            lVar.dfF.setText(personInfoPostList.getTitle());
                            lVar.dfH.setText(String.valueOf(aw.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.x.o(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dfG.setVisibility(0);
                                lVar.dfG.setText(abstractThread.get(0).getText());
                            } else {
                                lVar.dfG.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            lVar.dfO.setVisibility(0);
                            lVar.dfQ.setVisibility(0);
                        } else {
                            lVar.dfO.setVisibility(8);
                            lVar.dfQ.setVisibility(8);
                        }
                    } else if (i == 1) {
                        lVar.def.setVisibility(0);
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.x.o(media) <= 0 || com.baidu.tbadk.core.util.x.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl2 = videoInfo.getThumbnailUrl();
                                lVar.dfN.setVisibility(0);
                                str = thumbnailUrl2;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.x.b(media, 0)).getType() == 5) {
                                String vpic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.x.b(media, 0)).getVpic();
                                lVar.dfN.setVisibility(0);
                                str = vpic2;
                            } else {
                                String smallPic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.x.b(media, 0)).getSmallPic();
                                lVar.dfN.setVisibility(8);
                                str = smallPic2;
                            }
                            lVar.dfz.setVisibility(0);
                            this.daH = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dfz.setOnClickListener(this.daH);
                            lVar.dfA.setGifIconSupport(false);
                            lVar.dfA.d(str, 10, false);
                            lVar.dfA.setDrawBorder(true);
                            lVar.dfA.setBorderWidth(1);
                            lVar.dfD.setText(String.valueOf(aw.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            lVar.dfB.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.x.o(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dfC.setText(aw.d(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                lVar.dfC.setText("");
                            }
                        } else {
                            lVar.dfI.setVisibility(0);
                            this.daH = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            lVar.dfI.setOnClickListener(this.daH);
                            lVar.dfJ.setText(personInfoPostList.getTitle());
                            lVar.dfL.setText(String.valueOf(aw.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.x.o(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                lVar.dfK.setVisibility(0);
                                lVar.dfK.setText(abstractThread.get(0).getText());
                            } else {
                                lVar.dfK.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            lVar.dfP.setVisibility(0);
                            lVar.dfR.setVisibility(0);
                        } else {
                            lVar.dfP.setVisibility(8);
                            lVar.dfR.setVisibility(8);
                        }
                    }
                }
            }
            lVar.dfm.setOnClickListener(this.OS);
            e(lVar.deh);
        }
    }

    private void c(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.o oVar) {
        if (!this.isSelf && oVar.getSex() == 2) {
            this.daG = this.mContext.getResources().getString(t.j.her_threads);
        } else if (!this.isSelf && (oVar.getSex() == 1 || oVar.getSex() == 0)) {
            this.daG = this.mContext.getResources().getString(t.j.his_threads);
        }
        lVar.dfm.setVisibility(8);
        lVar.det.setVisibility(8);
        lVar.deh.setVisibility(8);
        lVar.dfq.setVisibility(0);
        lVar.dft.setVisibility(0);
        lVar.dfr.setText(this.daG);
        lVar.dfs.setText(t.j.set_private);
        lVar.dfq.setOnClickListener(new ab(this));
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
        if (lVar != null && lVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(lVar.dfE, t.f.addresslist_item_bg);
            ar.k(lVar.dfI, t.f.addresslist_item_bg);
            ar.k(lVar.dfu, t.f.addresslist_item_bg);
            ar.k(lVar.dfz, t.f.addresslist_item_bg);
            ar.k(lVar.dfq, t.f.addresslist_item_bg);
            ar.l(lVar.getView(), t.d.cp_bg_line_d);
            ar.l(lVar.deo, t.d.cp_bg_line_c);
            ar.l(lVar.det, t.d.cp_bg_line_c);
            ar.l(lVar.def, t.d.cp_bg_line_c);
            ar.b(lVar.dfn, t.d.cp_cont_f, 1);
            ar.b(lVar.dfp, t.d.cp_cont_c, 1);
            ar.b(lVar.dfF, t.d.cp_cont_b, 1);
            ar.b(lVar.dfG, t.d.cp_cont_d, 1);
            ar.b(lVar.dfH, t.d.cp_cont_n, 1);
            ar.k(lVar.dfH, t.f.label_bg_tie);
            ar.b(lVar.dfJ, t.d.cp_cont_b, 1);
            ar.b(lVar.dfK, t.d.cp_cont_d, 1);
            ar.b(lVar.dfL, t.d.cp_cont_n, 1);
            ar.k(lVar.dfL, t.f.label_bg_tie);
            ar.b(lVar.dfw, t.d.cp_cont_b, 1);
            ar.b(lVar.dfx, t.d.cp_cont_d, 1);
            ar.b(lVar.dfy, t.d.cp_cont_n, 1);
            ar.k(lVar.dfy, t.f.label_bg_tie);
            ar.b(lVar.dfB, t.d.cp_cont_b, 1);
            ar.b(lVar.dfC, t.d.cp_cont_d, 1);
            ar.b(lVar.dfD, t.d.cp_cont_n, 1);
            ar.k(lVar.dfD, t.f.label_bg_tie);
            ar.b(lVar.dfr, t.d.cp_cont_f, 1);
            ar.b(lVar.dfs, t.d.cp_cont_d, 1);
            ar.c(lVar.dfo, t.f.icon_arrow_tab);
            ar.c(lVar.dft, t.f.icon_mycenter_lock);
            ar.c(lVar.dfM, t.f.btn_icon_play_video_n);
            ar.c(lVar.dfN, t.f.btn_icon_play_video_n);
            ar.c(lVar.dfO, t.f.icon_zhibo);
            ar.c(lVar.dfP, t.f.icon_zhibo);
            ar.c(lVar.dfQ, t.f.icon_zhibo);
            ar.c(lVar.dfR, t.f.icon_zhibo);
            lVar.ahU = TbadkCoreApplication.m411getInst().getSkinType();
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
            if (this.id != null && this.userPortrait != null && bi.ah(aa.this.mContext)) {
                if (!aa.this.isSelf) {
                    if (aa.this.userId != null) {
                        if (view.getId() == t.g.thread_head) {
                            TiebaStatic.log(new au("c10618").r("obj_type", 1).aa("obj_id", aa.this.userId));
                        } else if (view.getId() == t.g.thread_none) {
                            TiebaStatic.log(new au("c10618").r("obj_type", 3).aa("obj_id", aa.this.userId));
                        }
                    }
                } else if (view.getId() == t.g.thread_head) {
                    TiebaStatic.log(new au("c10594").r("obj_type", 1));
                } else if (view.getId() == t.g.thread_none) {
                    TiebaStatic.log(new au("c10594").r("obj_type", 3));
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
            if (this.threadID != null && this.postID != null && bi.ah(aa.this.mContext)) {
                if (!aa.this.isSelf) {
                    if (aa.this.userId != null) {
                        TiebaStatic.log(new au("c10618").r("obj_type", 2).aa("obj_id", aa.this.userId));
                    }
                } else {
                    TiebaStatic.log(new au("c10594").r("obj_type", 2));
                }
                if (this.threadType != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(aa.this.mContext).createCfgForPersonCenter(this.threadID, this.postID, "person_post", 18005)));
                } else if (!aa.this.Kb()) {
                    UtilHelper.showToast(aa.this.mContext, t.j.plugin_config_not_found);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(aa.this.mContext, this.threadID).cm(this.postID).rC()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kb() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }
}
