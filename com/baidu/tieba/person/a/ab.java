package com.baidu.tieba.person.a;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.DealMediaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.b.m;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
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
public class ab extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.p, com.baidu.tieba.person.b.m> {
    private View.OnClickListener aew;
    private String egA;
    private b egB;
    private com.baidu.tbadk.data.j egq;
    private PersonTainInfo egr;
    private List<PersonInfoPostList> egz;
    private boolean isSelf;
    protected int mSkinType;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.egz = new ArrayList();
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public com.baidu.tieba.person.b.m a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.m(LayoutInflater.from(this.mContext).inflate(u.h.person_info_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.p pVar, com.baidu.tieba.person.b.m mVar) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.mSkinType != mVar.aeK) {
            this.aMF = true;
        }
        if (pVar != null && this.aMF) {
            a(mVar, pVar);
            this.aMF = false;
        }
        a(mVar);
        return view;
    }

    private void a(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.p pVar) {
        if (pVar != null && pVar.getUserData() != null && mVar != null) {
            this.egq = pVar.aLh();
            this.egr = pVar.aLg();
            this.aew = new a(pVar.getUserId(), pVar.getSex(), pVar.getPortrait());
            this.isSelf = pVar.getIsSelf();
            this.userId = pVar.getUserId();
            int AN = this.egq != null ? this.egq.AN() : 1;
            int isFriend = this.egr != null ? this.egr.getIsFriend() : 1;
            if (this.isSelf) {
                b(mVar, pVar);
            } else if (AN == 1 || (AN == 2 && isFriend == 1)) {
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
            this.egA = this.mContext.getResources().getString(u.j.my_threads);
            this.egz = pVar.aLk();
            if (!this.isSelf && pVar.getSex() == 2) {
                this.egA = this.mContext.getResources().getString(u.j.her_threads);
            } else if (!this.isSelf && (pVar.getSex() == 1 || pVar.getSex() == 0)) {
                this.egA = this.mContext.getResources().getString(u.j.his_threads);
            }
            if (com.baidu.tbadk.core.util.y.s(this.egz) <= 0) {
                mVar.eks.setVisibility(8);
                mVar.elw.setVisibility(8);
                mVar.elA.setVisibility(0);
                mVar.elB.setText(this.egA);
                mVar.elA.setOnClickListener(this.aew);
                return;
            }
            mVar.eks.setVisibility(0);
            mVar.elw.setVisibility(0);
            mVar.ekD.setVisibility(0);
            mVar.elw.setVisibility(0);
            mVar.elA.setVisibility(8);
            mVar.elx.setText(this.egA);
            mVar.elz.setText(ba.B(pVar.getPostNum()));
            int s = com.baidu.tbadk.core.util.y.s(this.egz);
            if (s >= 2) {
                mVar.ekq.setVisibility(0);
            }
            for (int i = 0; i < s && i < 2; i++) {
                PersonInfoPostList personInfoPostList = (PersonInfoPostList) com.baidu.tbadk.core.util.y.c(this.egz, i);
                if (personInfoPostList != null) {
                    if (personInfoPostList.isEcommThread() && EcommSwitchStatic.Fq()) {
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
                                    mVar.elW.setVisibility(0);
                                    str2 = thumbnailUrl;
                                } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getType() == 5) {
                                    String vpic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getVpic();
                                    mVar.elW.setVisibility(0);
                                    str2 = vpic;
                                } else {
                                    String smallPic = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getSmallPic();
                                    mVar.elW.setVisibility(8);
                                    str2 = smallPic;
                                }
                                mVar.elE.setVisibility(0);
                                mVar.elJ.setVisibility(8);
                                mVar.elO.setVisibility(8);
                                mVar.elS.setVisibility(8);
                                this.egB = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.elE.setOnClickListener(this.egB);
                                mVar.elF.c(str2, 10, false);
                                mVar.elF.setGifIconSupport(false);
                                mVar.elF.setDrawBorder(true);
                                mVar.elF.setBorderWidth(1);
                                mVar.elI.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                mVar.elG.setText(personInfoPostList.getTitle());
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.elH.setText(ba.c(abstractThread.get(0).getText(), 24, "..."));
                                } else {
                                    mVar.elH.setText("");
                                }
                            } else {
                                mVar.elE.setVisibility(8);
                                mVar.elJ.setVisibility(8);
                                mVar.elO.setVisibility(0);
                                mVar.elS.setVisibility(8);
                                this.egB = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.elO.setOnClickListener(this.egB);
                                mVar.elP.setText(personInfoPostList.getTitle());
                                mVar.elR.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.elQ.setVisibility(0);
                                    mVar.elQ.setText(abstractThread.get(0).getText());
                                } else {
                                    mVar.elQ.setVisibility(8);
                                }
                            }
                            if (personInfoPostList.getThreadType() == 33) {
                                mVar.elY.setVisibility(0);
                                mVar.ema.setVisibility(0);
                            } else {
                                mVar.elY.setVisibility(8);
                                mVar.ema.setVisibility(8);
                            }
                            if (mVar.emd != null) {
                                mVar.emd.emg.setVisibility(8);
                            }
                        } else if (i == 1) {
                            if (threadType != 36 && (threadType == 40 || !(media == null || com.baidu.tbadk.core.util.y.s(media) <= 0 || com.baidu.tbadk.core.util.y.c(media, 0) == null))) {
                                if (threadType == 40) {
                                    String thumbnailUrl2 = videoInfo.getThumbnailUrl();
                                    mVar.elX.setVisibility(0);
                                    str = thumbnailUrl2;
                                } else if (((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getType() == 5) {
                                    String vpic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getVpic();
                                    mVar.elX.setVisibility(0);
                                    str = vpic2;
                                } else {
                                    String smallPic2 = ((PersonInfoMedia) com.baidu.tbadk.core.util.y.c(media, 0)).getSmallPic();
                                    mVar.elX.setVisibility(8);
                                    str = smallPic2;
                                }
                                mVar.elJ.setVisibility(0);
                                this.egB = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.elJ.setOnClickListener(this.egB);
                                mVar.elK.setGifIconSupport(false);
                                mVar.elK.c(str, 10, false);
                                mVar.elK.setDrawBorder(true);
                                mVar.elK.setBorderWidth(1);
                                mVar.elN.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                mVar.elL.setText(personInfoPostList.getTitle());
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.elM.setText(ba.c(abstractThread.get(0).getText(), 24, "..."));
                                } else {
                                    mVar.elM.setText("");
                                }
                            } else {
                                mVar.elS.setVisibility(0);
                                this.egB = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
                                mVar.elS.setOnClickListener(this.egB);
                                mVar.elT.setText(personInfoPostList.getTitle());
                                mVar.elV.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
                                if (abstractThread != null && com.baidu.tbadk.core.util.y.s(abstractThread) > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                                    mVar.elU.setVisibility(0);
                                    mVar.elU.setText(abstractThread.get(0).getText());
                                } else {
                                    mVar.elU.setVisibility(8);
                                }
                            }
                            if (personInfoPostList.getThreadType() == 33) {
                                mVar.elZ.setVisibility(0);
                                mVar.emb.setVisibility(0);
                            } else {
                                mVar.elZ.setVisibility(8);
                                mVar.emb.setVisibility(8);
                            }
                            if (mVar.emf != null) {
                                mVar.emf.emg.setVisibility(8);
                            }
                        }
                    }
                }
            }
            mVar.elw.setOnClickListener(this.aew);
            f(mVar.eks);
        }
    }

    private void a(com.baidu.tieba.person.b.m mVar, int i, PersonInfoPostList personInfoPostList) {
        if (personInfoPostList != null && personInfoPostList.dealInfoData != null) {
            if (i == 0) {
                mVar.aLK();
                mVar.elE.setVisibility(8);
                mVar.elO.setVisibility(8);
                a(mVar.emd, personInfoPostList);
            } else if (i == 1) {
                mVar.aLL();
                mVar.elJ.setVisibility(8);
                mVar.elU.setVisibility(8);
                a(mVar.emf, personInfoPostList);
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
            aVar.emh.setVisibility(8);
        } else {
            aVar.emh.c(str, 10, false);
        }
        String str2 = dealInfoData.title;
        if (!StringUtils.isNull(str2)) {
            String string = this.mContext.getString(u.j.ecomm_description, str2);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, str2, new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_b)));
            aVar.emi.setVisibility(0);
            aVar.emi.setText(spannableString);
        } else {
            aVar.emi.setVisibility(4);
        }
        aVar.emj.setText(String.valueOf(ba.c(personInfoPostList.getForumName(), 7, "...")) + "吧");
        double d = dealInfoData.unitPrice;
        if (d < 0.0d) {
            d = 0.0d;
        }
        if (d > 9999999.0d) {
            aVar.emk.setText("¥" + ba.H((long) d));
        } else {
            aVar.emk.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
        }
        this.egB = new b(personInfoPostList.getThreadId(), personInfoPostList.getPostId(), personInfoPostList.getThreadType());
        aVar.emg.setOnClickListener(this.egB);
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
        if (s instanceof TbPageContext) {
            com.baidu.tbadk.j.a.a((TbPageContext) s, aVar.emg);
        }
    }

    private void c(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.p pVar) {
        if (!this.isSelf && pVar.getSex() == 2) {
            this.egA = this.mContext.getResources().getString(u.j.her_threads);
        } else if (!this.isSelf && (pVar.getSex() == 1 || pVar.getSex() == 0)) {
            this.egA = this.mContext.getResources().getString(u.j.his_threads);
        }
        mVar.elw.setVisibility(8);
        mVar.ekD.setVisibility(8);
        mVar.eks.setVisibility(8);
        mVar.elA.setVisibility(0);
        mVar.elD.setVisibility(0);
        mVar.elB.setText(this.egA);
        mVar.elC.setText(u.j.set_private);
        mVar.elA.setOnClickListener(new ac(this));
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

    private void a(com.baidu.tieba.person.b.m mVar) {
        if (mVar != null && mVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(mVar.elO, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(mVar.elS, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(mVar.elE, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(mVar.elJ, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(mVar.elA, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(mVar.getView(), u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(mVar.eky, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(mVar.ekD, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(mVar.ekq, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(mVar.elx, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elz, u.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elP, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elQ, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elR, u.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.av.k(mVar.elR, u.f.label_bg_tie);
            com.baidu.tbadk.core.util.av.c(mVar.elT, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elU, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elV, u.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.av.k(mVar.elV, u.f.label_bg_tie);
            com.baidu.tbadk.core.util.av.c(mVar.elG, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elH, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elI, u.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.av.k(mVar.elI, u.f.label_bg_tie);
            com.baidu.tbadk.core.util.av.c(mVar.elL, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elM, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elN, u.d.cp_cont_n, 1);
            com.baidu.tbadk.core.util.av.k(mVar.elN, u.f.label_bg_tie);
            com.baidu.tbadk.core.util.av.c(mVar.elB, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(mVar.elC, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(mVar.ely, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.c(mVar.elD, u.f.icon_mycenter_lock);
            com.baidu.tbadk.core.util.av.c(mVar.elW, u.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.av.c(mVar.elX, u.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.av.c(mVar.elY, u.f.icon_zhibo);
            com.baidu.tbadk.core.util.av.c(mVar.elZ, u.f.icon_zhibo);
            com.baidu.tbadk.core.util.av.c(mVar.ema, u.f.icon_zhibo);
            com.baidu.tbadk.core.util.av.c(mVar.emb, u.f.icon_zhibo);
            mVar.aeK = TbadkCoreApplication.m9getInst().getSkinType();
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
            if (this.id != null && this.userPortrait != null && bn.ab(ab.this.mContext)) {
                if (!ab.this.isSelf) {
                    if (ab.this.userId != null) {
                        if (view.getId() == u.g.thread_head) {
                            TiebaStatic.log(new ay("c10618").s("obj_type", 1).ab("obj_id", ab.this.userId));
                        } else if (view.getId() == u.g.thread_none) {
                            TiebaStatic.log(new ay("c10618").s("obj_type", 3).ab("obj_id", ab.this.userId));
                        }
                    }
                } else if (view.getId() == u.g.thread_head) {
                    TiebaStatic.log(new ay("c10594").s("obj_type", 1));
                } else if (view.getId() == u.g.thread_none) {
                    TiebaStatic.log(new ay("c10594").s("obj_type", 3));
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
            if (this.threadID != null && this.postID != null && bn.ab(ab.this.mContext)) {
                if (!ab.this.isSelf) {
                    if (ab.this.userId != null) {
                        TiebaStatic.log(new ay("c10618").s("obj_type", 2).ab("obj_id", ab.this.userId));
                    }
                } else {
                    TiebaStatic.log(new ay("c10594").s("obj_type", 2));
                }
                if (this.threadType != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(ab.this.mContext).createCfgForPersonCenter(this.threadID, this.postID, "person_post", 18005)));
                } else if (!ab.this.Lf()) {
                    UtilHelper.showToast(ab.this.mContext, u.j.plugin_config_not_found);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(ab.this.mContext, this.threadID).cg(this.postID).ol()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lf() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }
}
