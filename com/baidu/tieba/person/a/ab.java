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
public class ab extends c<com.baidu.tieba.person.data.p, com.baidu.tieba.person.b.m> {
    private View.OnClickListener Fn;
    private com.baidu.tbadk.data.h dxU;
    private PersonTainInfo dxV;
    private List<PersonInfoPostList> dyd;
    private String dye;
    private b dyf;
    private boolean isSelf;
    protected int mSkinType;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.dyd = new ArrayList();
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public com.baidu.tieba.person.b.m b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.m(LayoutInflater.from(this.mContext).inflate(t.h.person_info_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.p pVar, com.baidu.tieba.person.b.m mVar) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        a(mVar);
        if (pVar != null && this.bUL) {
            a(mVar, pVar);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.p pVar) {
        if (pVar != null && pVar.getUserData() != null && mVar != null) {
            this.dxU = pVar.aCo();
            this.dxV = pVar.aCn();
            this.Fn = new a(pVar.getUserId(), pVar.getSex(), pVar.getPortrait());
            this.isSelf = pVar.getIsSelf();
            this.userId = pVar.getUserId();
            int AE = this.dxU != null ? this.dxU.AE() : 1;
            int isFriend = this.dxV != null ? this.dxV.getIsFriend() : 1;
            if (this.isSelf) {
                b(mVar, pVar);
            } else if (AE == 1 || (AE == 2 && isFriend == 1)) {
                b(mVar, pVar);
            } else {
                c(mVar, pVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.p pVar) {
        String str;
        String str2;
        if (mVar != null && pVar != null) {
            this.isSelf = pVar.getIsSelf();
            this.dye = this.mContext.getResources().getString(t.j.my_threads);
            this.dyd = pVar.aCr();
            if (!this.isSelf && pVar.getSex() == 2) {
                this.dye = this.mContext.getResources().getString(t.j.her_threads);
            } else if (!this.isSelf && (pVar.getSex() == 1 || pVar.getSex() == 0)) {
                this.dye = this.mContext.getResources().getString(t.j.his_threads);
            }
            if (com.baidu.tbadk.core.util.y.r(this.dyd) <= 0) {
                mVar.dBP.setVisibility(8);
                mVar.dCT.setVisibility(8);
                mVar.dCX.setVisibility(0);
                mVar.dCY.setText(this.dye);
                mVar.dCX.setOnClickListener(this.Fn);
                return;
            }
            mVar.dBP.setVisibility(0);
            mVar.dCT.setVisibility(0);
            mVar.dCa.setVisibility(0);
            mVar.dCT.setVisibility(0);
            mVar.dCX.setVisibility(8);
            mVar.dCU.setText(this.dye);
            mVar.dCW.setText(ay.A(pVar.getPostNum()));
            int r = com.baidu.tbadk.core.util.y.r(this.dyd);
            for (int i = 0; i < r && i < 2; i++) {
                PersonInfoPostList personInfoPostList = (PersonInfoPostList) com.baidu.tbadk.core.util.y.c(this.dyd, i);
                if (personInfoPostList != null) {
                    List<PersonInfoAbstract> abstractThread = personInfoPostList.getAbstractThread();
                    List<PersonInfoMedia> media = personInfoPostList.getMedia();
                    PersonInfoVideo videoInfo = personInfoPostList.getVideoInfo();
                    long threadType = personInfoPostList.getThreadType();
                    if (i == 0 && personInfoPostList.getIsThread() == 1) {
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.r(media) <= 0 || com.baidu.tbadk.core.util.y.c(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl = videoInfo.getThumbnailUrl();
                                mVar.dDt.setVisibility(0);
                                str2 = thumbnailUrl;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getType() == 5) {
                                String vpic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getVpic();
                                mVar.dDt.setVisibility(0);
                                str2 = vpic;
                            } else {
                                String smallPic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getSmallPic();
                                mVar.dDt.setVisibility(8);
                                str2 = smallPic;
                            }
                            mVar.dDb.setVisibility(0);
                            mVar.dDg.setVisibility(8);
                            mVar.dDl.setVisibility(8);
                            mVar.dDp.setVisibility(8);
                            this.dyf = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            mVar.dDb.setOnClickListener(this.dyf);
                            mVar.dDc.c(str2, 10, false);
                            mVar.dDc.setGifIconSupport(false);
                            mVar.dDc.setDrawBorder(true);
                            mVar.dDc.setBorderWidth(1);
                            mVar.dDf.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            mVar.dDd.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.r(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                mVar.dDe.setText(ay.c(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                mVar.dDe.setText("");
                            }
                        } else {
                            mVar.dDb.setVisibility(8);
                            mVar.dDg.setVisibility(8);
                            mVar.dDl.setVisibility(0);
                            mVar.dDp.setVisibility(8);
                            this.dyf = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            mVar.dDl.setOnClickListener(this.dyf);
                            mVar.dDm.setText(personInfoPostList.getTitle());
                            mVar.dDo.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.r(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                mVar.dDn.setVisibility(0);
                                mVar.dDn.setText(abstractThread.get(0).getText());
                            } else {
                                mVar.dDn.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            mVar.dDv.setVisibility(0);
                            mVar.dDx.setVisibility(0);
                        } else {
                            mVar.dDv.setVisibility(8);
                            mVar.dDx.setVisibility(8);
                        }
                    } else if (i == 1) {
                        mVar.dBN.setVisibility(0);
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.r(media) <= 0 || com.baidu.tbadk.core.util.y.c(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl2 = videoInfo.getThumbnailUrl();
                                mVar.dDu.setVisibility(0);
                                str = thumbnailUrl2;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getType() == 5) {
                                String vpic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getVpic();
                                mVar.dDu.setVisibility(0);
                                str = vpic2;
                            } else {
                                String smallPic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getSmallPic();
                                mVar.dDu.setVisibility(8);
                                str = smallPic2;
                            }
                            mVar.dDg.setVisibility(0);
                            this.dyf = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            mVar.dDg.setOnClickListener(this.dyf);
                            mVar.dDh.setGifIconSupport(false);
                            mVar.dDh.c(str, 10, false);
                            mVar.dDh.setDrawBorder(true);
                            mVar.dDh.setBorderWidth(1);
                            mVar.dDk.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            mVar.dDi.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.r(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                mVar.dDj.setText(ay.c(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                mVar.dDj.setText("");
                            }
                        } else {
                            mVar.dDp.setVisibility(0);
                            this.dyf = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            mVar.dDp.setOnClickListener(this.dyf);
                            mVar.dDq.setText(personInfoPostList.getTitle());
                            mVar.dDs.setText(String.valueOf(ay.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.r(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                mVar.dDr.setVisibility(0);
                                mVar.dDr.setText(abstractThread.get(0).getText());
                            } else {
                                mVar.dDr.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            mVar.dDw.setVisibility(0);
                            mVar.dDy.setVisibility(0);
                        } else {
                            mVar.dDw.setVisibility(8);
                            mVar.dDy.setVisibility(8);
                        }
                    }
                }
            }
            mVar.dCT.setOnClickListener(this.Fn);
            e(mVar.dBP);
        }
    }

    private void c(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.p pVar) {
        if (!this.isSelf && pVar.getSex() == 2) {
            this.dye = this.mContext.getResources().getString(t.j.her_threads);
        } else if (!this.isSelf && (pVar.getSex() == 1 || pVar.getSex() == 0)) {
            this.dye = this.mContext.getResources().getString(t.j.his_threads);
        }
        mVar.dCT.setVisibility(8);
        mVar.dCa.setVisibility(8);
        mVar.dBP.setVisibility(8);
        mVar.dCX.setVisibility(0);
        mVar.dDa.setVisibility(0);
        mVar.dCY.setText(this.dye);
        mVar.dCZ.setText(t.j.set_private);
        mVar.dCX.setOnClickListener(new ac(this));
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

    private void a(com.baidu.tieba.person.b.m mVar) {
        if (mVar != null && mVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(mVar.dDl, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(mVar.dDp, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(mVar.dDb, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(mVar.dDg, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(mVar.dCX, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(mVar.getView(), t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(mVar.dBV, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(mVar.dCa, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(mVar.dBN, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(mVar.dCU, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dCW, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDm, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDn, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDo, t.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.at.k(mVar.dDo, t.f.label_bg_tie);
            com.baidu.tbadk.core.util.at.c(mVar.dDq, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDr, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDs, t.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.at.k(mVar.dDs, t.f.label_bg_tie);
            com.baidu.tbadk.core.util.at.c(mVar.dDd, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDe, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDf, t.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.at.k(mVar.dDf, t.f.label_bg_tie);
            com.baidu.tbadk.core.util.at.c(mVar.dDi, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDj, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dDk, t.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.at.k(mVar.dDk, t.f.label_bg_tie);
            com.baidu.tbadk.core.util.at.c(mVar.dCY, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dCZ, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(mVar.dCV, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.c(mVar.dDa, t.f.icon_mycenter_lock);
            com.baidu.tbadk.core.util.at.c(mVar.dDt, t.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.at.c(mVar.dDu, t.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.at.c(mVar.dDv, t.f.icon_zhibo);
            com.baidu.tbadk.core.util.at.c(mVar.dDw, t.f.icon_zhibo);
            com.baidu.tbadk.core.util.at.c(mVar.dDx, t.f.icon_zhibo);
            com.baidu.tbadk.core.util.at.c(mVar.dDy, t.f.icon_zhibo);
            mVar.aej = TbadkCoreApplication.m11getInst().getSkinType();
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
            if (this.id != null && this.userPortrait != null && bl.ac(ab.this.mContext)) {
                if (!ab.this.isSelf) {
                    if (ab.this.userId != null) {
                        if (view.getId() == t.g.thread_head) {
                            TiebaStatic.log(new aw("c10618").s("obj_type", 1).ac("obj_id", ab.this.userId));
                        } else if (view.getId() == t.g.thread_none) {
                            TiebaStatic.log(new aw("c10618").s("obj_type", 3).ac("obj_id", ab.this.userId));
                        }
                    }
                } else if (view.getId() == t.g.thread_head) {
                    TiebaStatic.log(new aw("c10594").s("obj_type", 1));
                } else if (view.getId() == t.g.thread_none) {
                    TiebaStatic.log(new aw("c10594").s("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(ab.this.mContext, this.id, this.sex, this.userPortrait)));
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
            if (this.threadID != null && this.postID != null && bl.ac(ab.this.mContext)) {
                if (!ab.this.isSelf) {
                    if (ab.this.userId != null) {
                        TiebaStatic.log(new aw("c10618").s("obj_type", 2).ac("obj_id", ab.this.userId));
                    }
                } else {
                    TiebaStatic.log(new aw("c10594").s("obj_type", 2));
                }
                if (this.threadType != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(ab.this.mContext).createCfgForPersonCenter(this.threadID, this.postID, "person_post", 18005)));
                } else if (!ab.this.Kh()) {
                    UtilHelper.showToast(ab.this.mContext, t.j.plugin_config_not_found);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(ab.this.mContext, this.threadID).ch(this.postID).oq()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kh() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }
}
