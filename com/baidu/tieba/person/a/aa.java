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
public class aa extends c<com.baidu.tieba.person.data.n, com.baidu.tieba.person.b.k> {
    private com.baidu.tbadk.data.f cQP;
    private PersonTainInfo cQQ;
    private List<PersonInfoPostList> cQY;
    private String cQZ;
    private b cRa;
    private boolean isSelf;
    private View.OnClickListener mClickListener;
    protected int mSkinType;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cQY = new ArrayList();
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.person.b.k a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.k(LayoutInflater.from(this.mContext).inflate(n.h.person_info_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.n nVar, com.baidu.tieba.person.b.k kVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(kVar);
        if (nVar != null && this.aVr) {
            a(kVar, nVar);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.n nVar) {
        if (nVar != null && nVar.getUserData() != null && kVar != null) {
            this.cQP = nVar.apu();
            this.cQQ = nVar.apt();
            this.mClickListener = new a(nVar.getUserId(), nVar.getSex(), nVar.getPortrait());
            this.isSelf = nVar.getIsSelf();
            this.userId = nVar.getUserId();
            int AO = this.cQP != null ? this.cQP.AO() : 1;
            int isFriend = this.cQQ != null ? this.cQQ.getIsFriend() : 1;
            if (this.isSelf) {
                b(kVar, nVar);
            } else if (AO == 1 || (AO == 2 && isFriend == 1)) {
                b(kVar, nVar);
            } else {
                c(kVar, nVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.n nVar) {
        String str;
        String str2;
        if (kVar != null && nVar != null) {
            this.isSelf = nVar.getIsSelf();
            this.cQZ = this.mContext.getResources().getString(n.j.my_threads);
            this.cQY = nVar.apw();
            if (!this.isSelf && nVar.getSex() == 2) {
                this.cQZ = this.mContext.getResources().getString(n.j.her_threads);
            } else if (!this.isSelf && (nVar.getSex() == 1 || nVar.getSex() == 0)) {
                this.cQZ = this.mContext.getResources().getString(n.j.his_threads);
            }
            if (com.baidu.tbadk.core.util.y.l(this.cQY) <= 0) {
                kVar.cSU.setVisibility(8);
                kVar.cTN.setVisibility(8);
                kVar.cTR.setVisibility(0);
                kVar.cTS.setText(this.cQZ);
                kVar.cTR.setOnClickListener(this.mClickListener);
                return;
            }
            kVar.cSU.setVisibility(0);
            kVar.cTN.setVisibility(0);
            kVar.cSR.setVisibility(0);
            kVar.cTN.setVisibility(0);
            kVar.cTR.setVisibility(8);
            kVar.cTO.setText(this.cQZ);
            kVar.cTQ.setText(ax.w(nVar.getPostNum()));
            int l = com.baidu.tbadk.core.util.y.l(this.cQY);
            for (int i = 0; i < l && i < 2; i++) {
                PersonInfoPostList personInfoPostList = (PersonInfoPostList) com.baidu.tbadk.core.util.y.b(this.cQY, i);
                if (personInfoPostList != null) {
                    List<PersonInfoAbstract> abstractThread = personInfoPostList.getAbstractThread();
                    List<PersonInfoMedia> media = personInfoPostList.getMedia();
                    PersonInfoVideo videoInfo = personInfoPostList.getVideoInfo();
                    long threadType = personInfoPostList.getThreadType();
                    if (i == 0 && personInfoPostList.getIsThread() == 1) {
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.l(media) <= 0 || com.baidu.tbadk.core.util.y.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl = videoInfo.getThumbnailUrl();
                                kVar.cUn.setVisibility(0);
                                str2 = thumbnailUrl;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getType() == 5) {
                                String vpic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getVpic();
                                kVar.cUn.setVisibility(0);
                                str2 = vpic;
                            } else {
                                String smallPic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getSmallPic();
                                kVar.cUn.setVisibility(8);
                                str2 = smallPic;
                            }
                            kVar.cTV.setVisibility(0);
                            kVar.cUa.setVisibility(8);
                            kVar.cUf.setVisibility(8);
                            kVar.cUj.setVisibility(8);
                            this.cRa = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            kVar.cTV.setOnClickListener(this.cRa);
                            kVar.cTW.d(str2, 10, false);
                            kVar.cTW.setGifIconSupport(false);
                            kVar.cTW.setDrawBorder(true);
                            kVar.cTW.setBorderWidth(1);
                            kVar.cTZ.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            kVar.cTX.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.l(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                kVar.cTY.setText(ax.d(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                kVar.cTY.setText("");
                            }
                        } else {
                            kVar.cTV.setVisibility(8);
                            kVar.cUa.setVisibility(8);
                            kVar.cUf.setVisibility(0);
                            kVar.cUj.setVisibility(8);
                            this.cRa = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            kVar.cUf.setOnClickListener(this.cRa);
                            kVar.cUg.setText(personInfoPostList.getTitle());
                            kVar.cUi.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.l(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                kVar.cUh.setVisibility(0);
                                kVar.cUh.setText(abstractThread.get(0).getText());
                            } else {
                                kVar.cUh.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            kVar.cUp.setVisibility(0);
                            kVar.cUr.setVisibility(0);
                        } else {
                            kVar.cUp.setVisibility(8);
                            kVar.cUr.setVisibility(8);
                        }
                    } else if (i == 1) {
                        kVar.cSS.setVisibility(0);
                        if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.l(media) <= 0 || com.baidu.tbadk.core.util.y.b(media, 0) == null))) {
                            if (threadType == 40) {
                                String thumbnailUrl2 = videoInfo.getThumbnailUrl();
                                kVar.cUo.setVisibility(0);
                                str = thumbnailUrl2;
                            } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getType() == 5) {
                                String vpic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getVpic();
                                kVar.cUo.setVisibility(0);
                                str = vpic2;
                            } else {
                                String smallPic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.b(media, 0)).getSmallPic();
                                kVar.cUo.setVisibility(8);
                                str = smallPic2;
                            }
                            kVar.cUa.setVisibility(0);
                            this.cRa = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            kVar.cUa.setOnClickListener(this.cRa);
                            kVar.cUb.setGifIconSupport(false);
                            kVar.cUb.d(str, 10, false);
                            kVar.cUb.setDrawBorder(true);
                            kVar.cUb.setBorderWidth(1);
                            kVar.cUe.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            kVar.cUc.setText(personInfoPostList.getTitle());
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.l(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                kVar.cUd.setText(ax.d(abstractThread.get(0).getText(), 24, "..."));
                            } else {
                                kVar.cUd.setText("");
                            }
                        } else {
                            kVar.cUj.setVisibility(0);
                            this.cRa = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                            kVar.cUj.setOnClickListener(this.cRa);
                            kVar.cUk.setText(personInfoPostList.getTitle());
                            kVar.cUm.setText(String.valueOf(ax.d(personInfoPostList.getForumName(), 7, "...")) + "吧");
                            if (abstractThread != null && com.baidu.tbadk.core.util.y.l(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                kVar.cUl.setVisibility(0);
                                kVar.cUl.setText(abstractThread.get(0).getText());
                            } else {
                                kVar.cUl.setVisibility(8);
                            }
                        }
                        if (personInfoPostList.getThreadType() == 33) {
                            kVar.cUq.setVisibility(0);
                            kVar.cUs.setVisibility(0);
                        } else {
                            kVar.cUq.setVisibility(8);
                            kVar.cUs.setVisibility(8);
                        }
                    }
                }
            }
            kVar.cTN.setOnClickListener(this.mClickListener);
            j(kVar.cSU);
        }
    }

    private void c(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.n nVar) {
        if (!this.isSelf && nVar.getSex() == 2) {
            this.cQZ = this.mContext.getResources().getString(n.j.her_threads);
        } else if (!this.isSelf && (nVar.getSex() == 1 || nVar.getSex() == 0)) {
            this.cQZ = this.mContext.getResources().getString(n.j.his_threads);
        }
        kVar.cTN.setVisibility(8);
        kVar.cSR.setVisibility(8);
        kVar.cSU.setVisibility(8);
        kVar.cTR.setVisibility(0);
        kVar.cTU.setVisibility(0);
        kVar.cTS.setText(this.cQZ);
        kVar.cTT.setText(n.j.set_private);
        kVar.cTR.setOnClickListener(new ab(this));
    }

    private void j(LinearLayout linearLayout) {
        if (linearLayout != null) {
            for (int childCount = linearLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = linearLayout.getChildAt(childCount);
                if ((childAt instanceof RelativeLayout) && childAt.getVisibility() == 0) {
                    childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.e.ds40));
                    return;
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.b.k kVar) {
        if (kVar != null && kVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(kVar.cUf, n.f.addresslist_item_bg);
            as.i(kVar.cUj, n.f.addresslist_item_bg);
            as.i(kVar.cTV, n.f.addresslist_item_bg);
            as.i(kVar.cUa, n.f.addresslist_item_bg);
            as.i(kVar.cTR, n.f.addresslist_item_bg);
            as.j(kVar.getView(), n.d.cp_bg_line_d);
            as.j(kVar.cTb, n.d.cp_bg_line_c);
            as.j(kVar.cSR, n.d.cp_bg_line_c);
            as.j(kVar.cSS, n.d.cp_bg_line_c);
            as.b(kVar.cTO, n.d.cp_cont_f, 1);
            as.b(kVar.cTQ, n.d.cp_cont_c, 1);
            as.b(kVar.cUg, n.d.cp_cont_b, 1);
            as.b(kVar.cUh, n.d.cp_cont_d, 1);
            as.b(kVar.cUi, n.d.cp_cont_n, 1);
            as.i((View) kVar.cUi, n.f.label_bg_tie);
            as.b(kVar.cUk, n.d.cp_cont_b, 1);
            as.b(kVar.cUl, n.d.cp_cont_d, 1);
            as.b(kVar.cUm, n.d.cp_cont_n, 1);
            as.i((View) kVar.cUm, n.f.label_bg_tie);
            as.b(kVar.cTX, n.d.cp_cont_b, 1);
            as.b(kVar.cTY, n.d.cp_cont_d, 1);
            as.b(kVar.cTZ, n.d.cp_cont_n, 1);
            as.i((View) kVar.cTZ, n.f.label_bg_tie);
            as.b(kVar.cUc, n.d.cp_cont_b, 1);
            as.b(kVar.cUd, n.d.cp_cont_d, 1);
            as.b(kVar.cUe, n.d.cp_cont_n, 1);
            as.i((View) kVar.cUe, n.f.label_bg_tie);
            as.b(kVar.cTS, n.d.cp_cont_f, 1);
            as.b(kVar.cTT, n.d.cp_cont_d, 1);
            as.c(kVar.cTP, n.f.icon_arrow_tab);
            as.c(kVar.cTU, n.f.icon_mycenter_lock);
            as.c(kVar.cUn, n.f.btn_icon_play_video_n);
            as.c(kVar.cUo, n.f.btn_icon_play_video_n);
            as.c(kVar.cUp, n.f.icon_zhibo);
            as.c(kVar.cUq, n.f.icon_zhibo);
            as.c(kVar.cUr, n.f.icon_zhibo);
            as.c(kVar.cUs, n.f.icon_zhibo);
            kVar.ahf = TbadkCoreApplication.m411getInst().getSkinType();
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
            if (this.id != null && this.userPortrait != null && bj.ah(aa.this.mContext)) {
                if (!aa.this.isSelf) {
                    if (aa.this.userId != null) {
                        if (view.getId() == n.g.thread_head) {
                            TiebaStatic.log(new av("c10618").r("obj_type", 1).aa("obj_id", aa.this.userId));
                        } else if (view.getId() == n.g.thread_none) {
                            TiebaStatic.log(new av("c10618").r("obj_type", 3).aa("obj_id", aa.this.userId));
                        }
                    }
                } else if (view.getId() == n.g.thread_head) {
                    TiebaStatic.log(new av("c10594").r("obj_type", 1));
                } else if (view.getId() == n.g.thread_none) {
                    TiebaStatic.log(new av("c10594").r("obj_type", 3));
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
            if (this.threadID != null && this.postID != null && bj.ah(aa.this.mContext)) {
                if (!aa.this.isSelf) {
                    if (aa.this.userId != null) {
                        TiebaStatic.log(new av("c10618").r("obj_type", 2).aa("obj_id", aa.this.userId));
                    }
                } else {
                    TiebaStatic.log(new av("c10594").r("obj_type", 2));
                }
                if (this.threadType != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(aa.this.mContext).createCfgForPersonCenter(this.threadID, this.postID, "person_post", 18005)));
                } else if (!aa.this.Ip()) {
                    UtilHelper.showToast(aa.this.mContext, n.j.plugin_config_not_found);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(aa.this.mContext, this.threadID).cn(this.postID).rf()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ip() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }
}
