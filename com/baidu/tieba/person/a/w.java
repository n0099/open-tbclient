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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.personInfo.PersonInfoAbstract;
import com.baidu.tieba.personInfo.PersonInfoMedia;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonInfoVideo;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends c<com.baidu.tieba.person.data.l, com.baidu.tieba.person.b.i> {
    private List<PersonInfoPostList> cME;
    private String cMF;
    private b cMG;
    private com.baidu.tbadk.data.f cMv;
    private PersonTainInfo cMw;
    private boolean isSelf;
    private View.OnClickListener mClickListener;
    protected int mSkinType;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cME = new ArrayList();
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public com.baidu.tieba.person.b.i a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.i(LayoutInflater.from(this.mContext).inflate(n.g.person_info_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.b.i iVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(iVar);
        if (lVar != null && this.aRB) {
            a(iVar, lVar);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.l lVar) {
        if (lVar != null && lVar.getUserData() != null && iVar != null) {
            this.cMv = lVar.aok();
            this.cMw = lVar.aoj();
            this.mClickListener = new a(lVar.getUserId(), lVar.getSex(), lVar.getPortrait());
            this.isSelf = lVar.getIsSelf();
            this.userId = lVar.getUserId();
            int AY = this.cMv != null ? this.cMv.AY() : 1;
            int isFriend = this.cMw != null ? this.cMw.getIsFriend() : 1;
            if (this.isSelf) {
                b(iVar, lVar);
            } else if (AY == 1 || (AY == 2 && isFriend == 1)) {
                b(iVar, lVar);
            } else {
                c(iVar, lVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.l lVar) {
        String str;
        String str2;
        if (iVar != null && lVar != null) {
            this.isSelf = lVar.getIsSelf();
            this.cMF = this.mContext.getResources().getString(n.i.my_threads);
            this.cME = lVar.aom();
            if (!this.isSelf && lVar.getSex() == 2) {
                this.cMF = this.mContext.getResources().getString(n.i.her_threads);
            } else if (!this.isSelf && (lVar.getSex() == 1 || lVar.getSex() == 0)) {
                this.cMF = this.mContext.getResources().getString(n.i.his_threads);
            }
            if (com.baidu.tbadk.core.util.y.k(this.cME) <= 0) {
                iVar.cOl.setVisibility(8);
                iVar.cPd.setVisibility(8);
                iVar.cPh.setVisibility(0);
                iVar.cPi.setText(this.cMF);
                iVar.cPh.setOnClickListener(this.mClickListener);
                return;
            }
            iVar.cOl.setVisibility(0);
            iVar.cPd.setVisibility(0);
            iVar.cOi.setVisibility(0);
            iVar.cPd.setVisibility(0);
            iVar.cPh.setVisibility(8);
            iVar.cPe.setText(this.cMF);
            iVar.cPg.setText(ax.v(lVar.getPostNum()));
            int k = com.baidu.tbadk.core.util.y.k(this.cME);
            for (int i = 0; i < k && i < 2; i++) {
                PersonInfoPostList personInfoPostList = (PersonInfoPostList) com.baidu.tbadk.core.util.y.b(this.cME, i);
                if (personInfoPostList != null) {
                    List<PersonInfoAbstract> abstractThread = personInfoPostList.getAbstractThread();
                    List<PersonInfoMedia> media = personInfoPostList.getMedia();
                    PersonInfoVideo videoInfo = personInfoPostList.getVideoInfo();
                    long threadType = personInfoPostList.getThreadType();
                    if (i == 0 && personInfoPostList.getIsThread() == 1) {
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.k(media) <= 0 || com.baidu.tbadk.core.util.y.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl = videoInfo.getThumbnailUrl();
                                iVar.cPD.setVisibility(0);
                                str2 = thumbnailUrl;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getType() == 5) {
                                String vpic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getVpic();
                                iVar.cPD.setVisibility(0);
                                str2 = vpic;
                            } else {
                                String smallPic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getSmallPic();
                                iVar.cPD.setVisibility(8);
                                str2 = smallPic;
                            }
                            iVar.cPl.setVisibility(0);
                            iVar.cPq.setVisibility(8);
                            iVar.cPv.setVisibility(8);
                            iVar.cPz.setVisibility(8);
                            this.cMG = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            iVar.cPl.setOnClickListener(this.cMG);
                            iVar.cPm.d(str2, 10, false);
                            iVar.cPm.setGifIconSupport(false);
                            iVar.cPm.setDrawBorder(true);
                            iVar.cPm.setBorderWidth(1);
                            iVar.cPp.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            iVar.cPn.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.k(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                iVar.cPo.setText(ax.d(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                iVar.cPo.setText("");
                            }
                        } else {
                            iVar.cPl.setVisibility(8);
                            iVar.cPq.setVisibility(8);
                            iVar.cPv.setVisibility(0);
                            iVar.cPz.setVisibility(8);
                            this.cMG = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            iVar.cPv.setOnClickListener(this.cMG);
                            iVar.cPw.setText(personInfoPostList.getTitle());
                            iVar.cPy.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.k(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                iVar.cPx.setVisibility(0);
                                iVar.cPx.setText(abstractThread.get(0).getText());
                            } else {
                                iVar.cPx.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            iVar.cPF.setVisibility(0);
                            iVar.cPH.setVisibility(0);
                        } else {
                            iVar.cPF.setVisibility(8);
                            iVar.cPH.setVisibility(8);
                        }
                    } else if (i == 1) {
                        iVar.cOj.setVisibility(0);
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.k(media) <= 0 || com.baidu.tbadk.core.util.y.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl2 = videoInfo.getThumbnailUrl();
                                iVar.cPE.setVisibility(0);
                                str = thumbnailUrl2;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getType() == 5) {
                                String vpic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getVpic();
                                iVar.cPE.setVisibility(0);
                                str = vpic2;
                            } else {
                                String smallPic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getSmallPic();
                                iVar.cPE.setVisibility(8);
                                str = smallPic2;
                            }
                            iVar.cPq.setVisibility(0);
                            this.cMG = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            iVar.cPq.setOnClickListener(this.cMG);
                            iVar.cPr.setGifIconSupport(false);
                            iVar.cPr.d(str, 10, false);
                            iVar.cPr.setDrawBorder(true);
                            iVar.cPr.setBorderWidth(1);
                            iVar.cPu.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            iVar.cPs.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.k(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                iVar.cPt.setText(ax.d(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                iVar.cPt.setText("");
                            }
                        } else {
                            iVar.cPz.setVisibility(0);
                            this.cMG = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            iVar.cPz.setOnClickListener(this.cMG);
                            iVar.cPA.setText(personInfoPostList.getTitle());
                            iVar.cPC.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.k(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                iVar.cPB.setVisibility(0);
                                iVar.cPB.setText(abstractThread.get(0).getText());
                            } else {
                                iVar.cPB.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            iVar.cPG.setVisibility(0);
                            iVar.cPI.setVisibility(0);
                        } else {
                            iVar.cPG.setVisibility(8);
                            iVar.cPI.setVisibility(8);
                        }
                    }
                }
            }
            iVar.cPd.setOnClickListener(this.mClickListener);
            j(iVar.cOl);
        }
    }

    private void c(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.l lVar) {
        if (!this.isSelf && lVar.getSex() == 2) {
            this.cMF = this.mContext.getResources().getString(n.i.her_threads);
        } else if (!this.isSelf && (lVar.getSex() == 1 || lVar.getSex() == 0)) {
            this.cMF = this.mContext.getResources().getString(n.i.his_threads);
        }
        iVar.cPd.setVisibility(8);
        iVar.cOi.setVisibility(8);
        iVar.cOl.setVisibility(8);
        iVar.cPh.setVisibility(0);
        iVar.cPk.setVisibility(0);
        iVar.cPi.setText(this.cMF);
        iVar.cPj.setText(n.i.set_private);
        iVar.cPh.setOnClickListener(new x(this));
    }

    private void j(LinearLayout linearLayout) {
        if (linearLayout != null) {
            for (int childCount = linearLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = linearLayout.getChildAt(childCount);
                if ((childAt instanceof RelativeLayout) && childAt.getVisibility() == 0) {
                    childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.d.ds40));
                    return;
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.b.i iVar) {
        if (iVar != null && iVar.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(iVar.cPv, n.e.addresslist_item_bg);
            as.i(iVar.cPz, n.e.addresslist_item_bg);
            as.i(iVar.cPl, n.e.addresslist_item_bg);
            as.i(iVar.cPq, n.e.addresslist_item_bg);
            as.i(iVar.cPh, n.e.addresslist_item_bg);
            as.j(iVar.getView(), n.c.cp_bg_line_d);
            as.j(iVar.cOr, n.c.cp_bg_line_c);
            as.j(iVar.cOi, n.c.cp_bg_line_c);
            as.j(iVar.cOj, n.c.cp_bg_line_c);
            as.b(iVar.cPe, n.c.cp_cont_f, 1);
            as.b(iVar.cPg, n.c.cp_cont_c, 1);
            as.b(iVar.cPw, n.c.cp_cont_b, 1);
            as.b(iVar.cPx, n.c.cp_cont_d, 1);
            as.b(iVar.cPy, n.c.cp_cont_n, 1);
            as.i((View) iVar.cPy, n.e.label_bg_tie);
            as.b(iVar.cPA, n.c.cp_cont_b, 1);
            as.b(iVar.cPB, n.c.cp_cont_d, 1);
            as.b(iVar.cPC, n.c.cp_cont_n, 1);
            as.i((View) iVar.cPC, n.e.label_bg_tie);
            as.b(iVar.cPn, n.c.cp_cont_b, 1);
            as.b(iVar.cPo, n.c.cp_cont_d, 1);
            as.b(iVar.cPp, n.c.cp_cont_n, 1);
            as.i((View) iVar.cPp, n.e.label_bg_tie);
            as.b(iVar.cPs, n.c.cp_cont_b, 1);
            as.b(iVar.cPt, n.c.cp_cont_d, 1);
            as.b(iVar.cPu, n.c.cp_cont_n, 1);
            as.i((View) iVar.cPu, n.e.label_bg_tie);
            as.b(iVar.cPi, n.c.cp_cont_f, 1);
            as.b(iVar.cPj, n.c.cp_cont_d, 1);
            as.c(iVar.cPf, n.e.icon_arrow_tab);
            as.c(iVar.cPk, n.e.icon_mycenter_lock);
            as.c(iVar.cPD, n.e.btn_icon_play_video_n);
            as.c(iVar.cPE, n.e.btn_icon_play_video_n);
            as.c(iVar.cPF, n.e.icon_zhibo);
            as.c(iVar.cPG, n.e.icon_zhibo);
            as.c(iVar.cPH, n.e.icon_zhibo);
            as.c(iVar.cPI, n.e.icon_zhibo);
            iVar.afY = TbadkCoreApplication.m411getInst().getSkinType();
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
            if (this.id != null && this.userPortrait != null && bj.ah(w.this.mContext)) {
                if (!w.this.isSelf) {
                    if (w.this.userId != null) {
                        if (view.getId() == n.f.thread_head) {
                            TiebaStatic.log(new av("c10618").r("obj_type", 1).ab("obj_id", w.this.userId));
                        } else if (view.getId() == n.f.thread_none) {
                            TiebaStatic.log(new av("c10618").r("obj_type", 3).ab("obj_id", w.this.userId));
                        }
                    }
                } else if (view.getId() == n.f.thread_head) {
                    TiebaStatic.log(new av("c10594").r("obj_type", 1));
                } else if (view.getId() == n.f.thread_none) {
                    TiebaStatic.log(new av("c10594").r("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(w.this.mContext, this.id, this.sex, this.userPortrait)));
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
            if (this.threadID != null && this.postID != null && bj.ah(w.this.mContext)) {
                if (!w.this.isSelf) {
                    if (w.this.userId != null) {
                        TiebaStatic.log(new av("c10618").r("obj_type", 2).ab("obj_id", w.this.userId));
                    }
                } else {
                    TiebaStatic.log(new av("c10594").r("obj_type", 2));
                }
                if (this.threadType != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(w.this.mContext).createCfgForPersonCenter(this.threadID, this.postID, "person_post", 18005)));
                } else if (!w.this.anZ()) {
                    UtilHelper.showToast(w.this.mContext, n.i.plugin_config_not_found);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(w.this.mContext, this.threadID).cl(this.postID).rw()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anZ() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }
}
