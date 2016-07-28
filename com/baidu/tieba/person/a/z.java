package com.baidu.tieba.person.a;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.DealMediaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.holder.m;
import com.baidu.tieba.personInfo.PersonInfoAbstract;
import com.baidu.tieba.personInfo.PersonInfoMedia;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonInfoVideo;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class z extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.o, com.baidu.tieba.person.holder.m> {
    private View.OnClickListener afk;
    private b eqA;
    private com.baidu.tbadk.data.j eqp;
    private PersonTainInfo eqq;
    private List<PersonInfoPostList> eqy;
    private String eqz;
    private boolean isSelf;
    protected int mSkinType;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.eqy = new ArrayList();
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public com.baidu.tieba.person.holder.m a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.m(LayoutInflater.from(this.mContext).inflate(u.h.person_info_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.o oVar, com.baidu.tieba.person.holder.m mVar) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (this.mSkinType != mVar.afy) {
            this.aNz = true;
        }
        if (oVar != null && this.aNz) {
            a(mVar, oVar);
            this.aNz = false;
        }
        a(mVar);
        return view;
    }

    private void a(com.baidu.tieba.person.holder.m mVar, com.baidu.tieba.person.data.o oVar) {
        if (oVar != null && oVar.getUserData() != null && mVar != null) {
            this.eqp = oVar.aNK();
            this.eqq = oVar.aNJ();
            this.afk = new a(oVar.getUserId(), oVar.getSex(), oVar.getPortrait());
            this.isSelf = oVar.getIsSelf();
            this.userId = oVar.getUserId();
            int AN = this.eqp != null ? this.eqp.AN() : 1;
            int isFriend = this.eqq != null ? this.eqq.getIsFriend() : 1;
            if (this.isSelf) {
                b(mVar, oVar);
            } else if (AN == 1 || (AN == 2 && isFriend == 1)) {
                b(mVar, oVar);
            } else {
                c(mVar, oVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.holder.m mVar, com.baidu.tieba.person.data.o oVar) {
        String str;
        String str2;
        if (mVar != null && oVar != null) {
            this.isSelf = oVar.getIsSelf();
            this.eqz = this.mContext.getResources().getString(u.j.my_threads);
            this.eqy = oVar.aNN();
            if (!this.isSelf && oVar.getSex() == 2) {
                this.eqz = this.mContext.getResources().getString(u.j.her_threads);
            } else if (!this.isSelf && (oVar.getSex() == 1 || oVar.getSex() == 0)) {
                this.eqz = this.mContext.getResources().getString(u.j.his_threads);
            }
            if (com.baidu.tbadk.core.util.y.s(this.eqy) <= 0) {
                mVar.euP.setVisibility(8);
                mVar.evT.setVisibility(8);
                mVar.evX.setVisibility(0);
                mVar.evY.setText(this.eqz);
                mVar.evX.setOnClickListener(this.afk);
                return;
            }
            mVar.euP.setVisibility(0);
            mVar.evT.setVisibility(0);
            mVar.eva.setVisibility(0);
            mVar.evT.setVisibility(0);
            mVar.evX.setVisibility(8);
            mVar.evU.setText(this.eqz);
            mVar.evW.setText(ba.w(oVar.getPostNum()));
            int s = com.baidu.tbadk.core.util.y.s(this.eqy);
            if (s >= 2) {
                mVar.euN.setVisibility(0);
            }
            for (int i = 0; i < s && i < 2; i++) {
                PersonInfoPostList personInfoPostList = (PersonInfoPostList) com.baidu.tbadk.core.util.y.c(this.eqy, i);
                if (personInfoPostList != null) {
                    if (personInfoPostList.isEcommThread() && EcommSwitchStatic.Fr()) {
                        a(mVar, i, personInfoPostList);
                    } else {
                        List<PersonInfoAbstract> abstractThread = personInfoPostList.getAbstractThread();
                        List<PersonInfoMedia> media = personInfoPostList.getMedia();
                        PersonInfoVideo videoInfo = personInfoPostList.getVideoInfo();
                        long threadType = personInfoPostList.getThreadType();
                        if (i == 0 && personInfoPostList.getIsThread() == 1) {
                            if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.s(media) <= 0 || com.baidu.tbadk.core.util.y.c(media, 0) == null))) {
                                if (threadType == 40) {
                                    String thumbnailUrl = videoInfo.getThumbnailUrl();
                                    mVar.ewt.setVisibility(0);
                                    str2 = thumbnailUrl;
                                } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getType() == 5) {
                                    String vpic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getVpic();
                                    mVar.ewt.setVisibility(0);
                                    str2 = vpic;
                                } else {
                                    String smallPic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getSmallPic();
                                    mVar.ewt.setVisibility(8);
                                    str2 = smallPic;
                                }
                                mVar.ewb.setVisibility(0);
                                mVar.ewg.setVisibility(8);
                                mVar.ewl.setVisibility(8);
                                mVar.ewp.setVisibility(8);
                                this.eqA = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.ewb.setOnClickListener(this.eqA);
                                mVar.ewc.c(str2, 10, false);
                                mVar.ewc.setGifIconSupport(false);
                                mVar.ewc.setDrawBorder(true);
                                mVar.ewc.setBorderWidth(1);
                                mVar.ewf.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                mVar.ewd.setText(personInfoPostList.getTitle());
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.ewe.setText(ba.c(abstractThread.get(0).getText(), 24, "..."));
                                } else {
                                    mVar.ewe.setText("");
                                }
                            } else {
                                mVar.ewb.setVisibility(8);
                                mVar.ewg.setVisibility(8);
                                mVar.ewl.setVisibility(0);
                                mVar.ewp.setVisibility(8);
                                this.eqA = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.ewl.setOnClickListener(this.eqA);
                                mVar.ewm.setText(personInfoPostList.getTitle());
                                mVar.ewo.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.ewn.setVisibility(0);
                                    mVar.ewn.setText(abstractThread.get(0).getText());
                                } else {
                                    mVar.ewn.setVisibility(8);
                                }
                            }
                            if (personInfoPostList.getThreadType() == 33) {
                                mVar.ewv.setVisibility(0);
                                mVar.ewx.setVisibility(0);
                            } else {
                                mVar.ewv.setVisibility(8);
                                mVar.ewx.setVisibility(8);
                            }
                            if (mVar.ewA != null) {
                                mVar.ewA.ewD.setVisibility(8);
                            }
                        } else if (i == 1) {
                            if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.s(media) <= 0 || com.baidu.tbadk.core.util.y.c(media, 0) == null))) {
                                if (threadType == 40) {
                                    String thumbnailUrl2 = videoInfo.getThumbnailUrl();
                                    mVar.ewu.setVisibility(0);
                                    str = thumbnailUrl2;
                                } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getType() == 5) {
                                    String vpic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getVpic();
                                    mVar.ewu.setVisibility(0);
                                    str = vpic2;
                                } else {
                                    String smallPic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getSmallPic();
                                    mVar.ewu.setVisibility(8);
                                    str = smallPic2;
                                }
                                mVar.ewg.setVisibility(0);
                                this.eqA = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.ewg.setOnClickListener(this.eqA);
                                mVar.ewh.setGifIconSupport(false);
                                mVar.ewh.c(str, 10, false);
                                mVar.ewh.setDrawBorder(true);
                                mVar.ewh.setBorderWidth(1);
                                mVar.ewk.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                mVar.ewi.setText(personInfoPostList.getTitle());
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.ewj.setText(ba.c(abstractThread.get(0).getText(), 24, "..."));
                                } else {
                                    mVar.ewj.setText("");
                                }
                            } else {
                                mVar.ewp.setVisibility(0);
                                this.eqA = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.ewp.setOnClickListener(this.eqA);
                                mVar.ewq.setText(personInfoPostList.getTitle());
                                mVar.ews.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.ewr.setVisibility(0);
                                    mVar.ewr.setText(abstractThread.get(0).getText());
                                } else {
                                    mVar.ewr.setVisibility(8);
                                }
                            }
                            if (personInfoPostList.getThreadType() == 33) {
                                mVar.eww.setVisibility(0);
                                mVar.ewy.setVisibility(0);
                            } else {
                                mVar.eww.setVisibility(8);
                                mVar.ewy.setVisibility(8);
                            }
                            if (mVar.ewC != null) {
                                mVar.ewC.ewD.setVisibility(8);
                            }
                        }
                    }
                }
            }
            mVar.evT.setOnClickListener(this.afk);
            f(mVar.euP);
        }
    }

    private void a(com.baidu.tieba.person.holder.m mVar, int i, PersonInfoPostList personInfoPostList) {
        if (personInfoPostList != null && personInfoPostList.dealInfoData != null) {
            if (i == 0) {
                mVar.aOn();
                mVar.ewb.setVisibility(8);
                mVar.ewl.setVisibility(8);
                a(mVar.ewA, personInfoPostList);
            } else if (i == 1) {
                mVar.aOo();
                mVar.ewg.setVisibility(8);
                mVar.ewr.setVisibility(8);
                a(mVar.ewC, personInfoPostList);
            }
        }
    }

    private void a(m.a aVar, PersonInfoPostList personInfoPostList) {
        DealInfoData dealInfoData = personInfoPostList.dealInfoData;
        String str = null;
        ArrayList<DealMediaData> arrayList = dealInfoData.media;
        if (arrayList != null && arrayList.size() > 0) {
            str = arrayList.get(0).smallPic;
        }
        if (StringUtils.isNull(str)) {
            aVar.ewE.setVisibility(8);
        } else {
            aVar.ewE.c(str, 10, false);
        }
        String str2 = dealInfoData.title;
        if (!StringUtils.isNull(str2)) {
            String string = this.mContext.getString(u.j.ecomm_description, str2);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, str2, new ForegroundColorSpan(av.getColor(u.d.cp_cont_b)));
            aVar.ewF.setVisibility(0);
            aVar.ewF.setText(spannableString);
        } else {
            aVar.ewF.setVisibility(4);
        }
        aVar.ewG.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
        double d = dealInfoData.unitPrice;
        if (d < 0.0d) {
            d = 0.0d;
        }
        if (d > 9999999.0d) {
            aVar.ewH.setText("¥" + ba.C((long) d));
        } else {
            aVar.ewH.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
        }
        this.eqA = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
        aVar.ewD.setOnClickListener(this.eqA);
        h<?> s = com.baidu.adp.base.l.s(this.mContext);
        if (s instanceof TbPageContext) {
            com.baidu.tbadk.j.a.a((TbPageContext) s, aVar.ewD);
        }
    }

    private void c(com.baidu.tieba.person.holder.m mVar, com.baidu.tieba.person.data.o oVar) {
        if (!this.isSelf && oVar.getSex() == 2) {
            this.eqz = this.mContext.getResources().getString(u.j.her_threads);
        } else if (!this.isSelf && (oVar.getSex() == 1 || oVar.getSex() == 0)) {
            this.eqz = this.mContext.getResources().getString(u.j.his_threads);
        }
        mVar.evT.setVisibility(8);
        mVar.eva.setVisibility(8);
        mVar.euP.setVisibility(8);
        mVar.evX.setVisibility(0);
        mVar.ewa.setVisibility(0);
        mVar.evY.setText(this.eqz);
        mVar.evZ.setText(u.j.set_private);
        mVar.evX.setOnClickListener(new aa(this));
    }

    private void f(LinearLayout linearLayout) {
        if (linearLayout != null) {
            for (int childCount = linearLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = linearLayout.getChildAt(childCount);
                if ((childAt instanceof RelativeLayout) && childAt.getVisibility() == 0) {
                    childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(u.e.ds40));
                    return;
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.holder.m mVar) {
        if (mVar != null && mVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(mVar.ewl, u.f.addresslist_item_bg);
            av.k(mVar.ewp, u.f.addresslist_item_bg);
            av.k(mVar.ewb, u.f.addresslist_item_bg);
            av.k(mVar.ewg, u.f.addresslist_item_bg);
            av.k(mVar.evX, u.f.addresslist_item_bg);
            av.l(mVar.getView(), u.d.cp_bg_line_d);
            av.l(mVar.euV, u.d.cp_bg_line_c);
            av.l(mVar.eva, u.d.cp_bg_line_c);
            av.l(mVar.euN, u.d.cp_bg_line_c);
            av.c(mVar.evU, u.d.cp_cont_f, 1);
            av.c(mVar.evW, u.d.cp_cont_c, 1);
            av.c(mVar.ewm, u.d.cp_cont_b, 1);
            av.c(mVar.ewn, u.d.cp_cont_d, 1);
            av.c(mVar.ewo, u.d.cp_cont_n, 1);
            av.k(mVar.ewo, u.f.label_bg_tie);
            av.c(mVar.ewq, u.d.cp_cont_b, 1);
            av.c(mVar.ewr, u.d.cp_cont_d, 1);
            av.c(mVar.ews, u.d.cp_cont_n, 1);
            av.k(mVar.ews, u.f.label_bg_tie);
            av.c(mVar.ewd, u.d.cp_cont_b, 1);
            av.c(mVar.ewe, u.d.cp_cont_d, 1);
            av.c(mVar.ewf, u.d.cp_cont_n, 1);
            av.k(mVar.ewf, u.f.label_bg_tie);
            av.c(mVar.ewi, u.d.cp_cont_b, 1);
            av.c(mVar.ewj, u.d.cp_cont_d, 1);
            av.c(mVar.ewk, u.d.cp_cont_n, 1);
            av.k(mVar.ewk, u.f.label_bg_tie);
            av.c(mVar.evY, u.d.cp_cont_f, 1);
            av.c(mVar.evZ, u.d.cp_cont_d, 1);
            av.c(mVar.evV, u.f.icon_arrow_tab);
            av.c(mVar.ewa, u.f.icon_mycenter_lock);
            av.c(mVar.ewt, u.f.btn_icon_play_video_n);
            av.c(mVar.ewu, u.f.btn_icon_play_video_n);
            av.c(mVar.ewv, u.f.icon_zhibo);
            av.c(mVar.eww, u.f.icon_zhibo);
            av.c(mVar.ewx, u.f.icon_zhibo);
            av.c(mVar.ewy, u.f.icon_zhibo);
            mVar.afy = TbadkCoreApplication.m10getInst().getSkinType();
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
            if (this.id != null && this.userPortrait != null && bn.ab(z.this.mContext)) {
                if (!z.this.isSelf) {
                    if (z.this.userId != null) {
                        if (view.getId() == u.g.thread_head) {
                            TiebaStatic.log(new ay("c10618").s("obj_type", 1).ab("obj_id", z.this.userId));
                        } else if (view.getId() == u.g.thread_none) {
                            TiebaStatic.log(new ay("c10618").s("obj_type", 3).ab("obj_id", z.this.userId));
                        }
                    }
                } else if (view.getId() == u.g.thread_head) {
                    TiebaStatic.log(new ay("c10594").s("obj_type", 1));
                } else if (view.getId() == u.g.thread_none) {
                    TiebaStatic.log(new ay("c10594").s("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(z.this.mContext, this.id, this.sex, this.userPortrait)));
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
            if (this.threadID != null && this.postID != null && bn.ab(z.this.mContext)) {
                if (!z.this.isSelf) {
                    if (z.this.userId != null) {
                        TiebaStatic.log(new ay("c10618").s("obj_type", 2).ab("obj_id", z.this.userId));
                    }
                } else {
                    TiebaStatic.log(new ay("c10594").s("obj_type", 2));
                }
                if (this.threadType != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(z.this.mContext).createCfgForPersonCenter(this.threadID, this.postID, "person_post", 18005)));
                } else if (!z.this.Le()) {
                    UtilHelper.showToast(z.this.mContext, u.j.plugin_config_not_found);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(z.this.mContext, this.threadID).ch(this.postID).oa()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Le() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }
}
