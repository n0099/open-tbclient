package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class o extends k<PostData, p> implements View.OnClickListener {
    private TbRichTextView.h bLS;
    private com.baidu.tieba.pb.a.c bLT;
    private View.OnLongClickListener bmu;
    private int cHW;
    protected int fIM;
    protected boolean fIN;
    protected com.baidu.tieba.pb.data.d fIP;
    private com.baidu.tieba.pb.pb.sub.d fIQ;
    private View.OnClickListener fIS;
    private boolean fIT;
    private final boolean fIU;
    private TbRichTextView.c fNO;
    private final int fOD;
    private boolean fOE;
    private boolean fOF;
    private int fOG;
    private int fOH;
    private com.baidu.tieba.pb.a.c fOI;
    private OriginalThreadCardView.a fOJ;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fOD = 3;
        this.fIM = 0;
        this.fIN = true;
        this.fOE = true;
        this.fIP = null;
        this.fIQ = null;
        this.fIS = null;
        this.mCommonClickListener = null;
        this.bLS = null;
        this.bLT = null;
        this.bmu = null;
        this.fNO = null;
        this.fIT = false;
        this.fIU = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fOF = false;
        this.fOG = 0;
        this.fOH = 0;
        this.cHW = 0;
        this.pageFromType = 0;
        this.fOI = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean e(View view, MotionEvent motionEvent) {
                if (o.this.bLT != null) {
                    o.this.bLT.cn(view);
                    o.this.bLT.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fOJ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fIP != null) {
                    String threadId = o.this.fIP.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12602").ab("tid", threadId).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).s("obj_type", i));
                    }
                }
            }
        };
        this.fOH = com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds60);
        this.cHW = com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.bbA() != null) {
            this.pageFromType = pbActivity.bbA().bdS();
        }
        this.fOG = com.baidu.adp.lib.util.l.ao(pbActivity) - com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds130);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.t(pVar.fJc, d.C0140d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.t(pVar.egZ, d.C0140d.cp_bg_line_c);
                pVar.fJm.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.e(pVar.bey, d.C0140d.cp_cont_f, 1);
                pVar.bey.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                pVar.cYC.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(pVar.fOR, d.C0140d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOS, d.C0140d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOT, d.C0140d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOU, d.C0140d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.t(pVar.fOV, d.C0140d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.t(pVar.fOW, d.C0140d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(pVar.fOZ, d.C0140d.cp_cont_d, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fNb.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.fIN, this.fIM);
        a(pVar);
        if (pVar.cYC != null) {
            pVar.cYC.cZh = this.pageFromType;
        }
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, p pVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, pVar);
        a(pVar);
        c(pVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.Ai();
            b(pVar, postData2, view, i);
        }
        if (!this.fIT && this.fIU && pVar != null && pVar.fJm.RX() && (listView = ((PbActivity) this.fNb.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fIT = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x07c6  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07d2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x07ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(p pVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        com.baidu.tbadk.core.data.t tVar;
        if (this.fIP != null) {
            if (postData.bwU() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fJm.setOnClickListener(this.mCommonClickListener);
                    pVar.fJm.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fJm.setOnClickListener(null);
                    pVar.fJm.setTextViewOnClickListener(null);
                }
                pVar.fJc.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fJc.setOnClickListener(null);
            }
            if (postData.bwU() == 1) {
                pVar.fOZ.setVisibility(8);
                StringBuilder sb = null;
                List<ay> baO = this.fIP.baO();
                if (com.baidu.tbadk.core.util.v.D(baO) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (ay ayVar : baO) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aOl) != null && tVar.isDeleted && ((tVar.aMt && (tVar.type == 1 || tVar.type == 2)) || (this.fIP.bau() != null && this.fIP.bau().zn() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fIP.bau().zn().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fNb.getString(d.j.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    pVar.fOZ.setVisibility(0);
                    pVar.fOZ.setText(String.format(this.fNb.getString(d.j.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
                if (!this.fNb.bcA()) {
                    pVar.bey.setVisibility(8);
                    if (com.baidu.tbadk.core.util.v.E(this.fIP.baO())) {
                        pVar.fOQ.setVisibility(8);
                        pVar.fOZ.setVisibility(8);
                    } else {
                        int D = com.baidu.tbadk.core.util.v.D(this.fIP.baO());
                        if (D > 3) {
                            D = 3;
                        }
                        int i2 = this.fOG / D;
                        switch (D) {
                            case 1:
                                pVar.fOS.setMaxWidth(i2);
                                pVar.fOS.setText(this.fNb.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 0)).getForumName()}));
                                pVar.fOS.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 0)).getForumName());
                                pVar.fOS.setVisibility(0);
                                pVar.fOT.setVisibility(0);
                                pVar.fOU.setVisibility(0);
                                pVar.fOV.setVisibility(8);
                                pVar.fOW.setVisibility(8);
                                break;
                            case 2:
                                pVar.fOS.setMaxWidth(i2);
                                pVar.fOS.setText(this.fNb.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 0)).getForumName()}));
                                pVar.fOS.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 0)).getForumName());
                                pVar.fOS.setVisibility(0);
                                pVar.fOT.setMaxWidth(i2);
                                pVar.fOT.setText(this.fNb.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 1)).getForumName()}));
                                pVar.fOT.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 1)).getForumName());
                                pVar.fOT.setVisibility(0);
                                pVar.fOU.setVisibility(8);
                                pVar.fOV.setVisibility(0);
                                pVar.fOW.setVisibility(8);
                                break;
                            case 3:
                                pVar.fOS.setMaxWidth(i2);
                                pVar.fOS.setText(this.fNb.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 0)).getForumName()}));
                                pVar.fOS.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 0)).getForumName());
                                pVar.fOS.setVisibility(0);
                                pVar.fOT.setMaxWidth(i2);
                                pVar.fOT.setText(this.fNb.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 1)).getForumName()}));
                                pVar.fOT.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 1)).getForumName());
                                pVar.fOT.setVisibility(0);
                                pVar.fOU.setMaxWidth(i2);
                                pVar.fOU.setText(this.fNb.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 2)).getForumName()}));
                                pVar.fOU.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIP.baO(), 2)).getForumName());
                                pVar.fOU.setVisibility(0);
                                pVar.fOV.setVisibility(0);
                                pVar.fOW.setVisibility(0);
                                break;
                        }
                        pVar.fOQ.setVisibility(0);
                    }
                } else {
                    pVar.fOQ.setVisibility(8);
                    pVar.fOZ.setVisibility(8);
                    if (this.fIP.bas() != null && !StringUtils.isNull(this.fIP.bas().getName()) && !bcW()) {
                        pVar.bey.setVisibility(0);
                        pVar.bey.setText(this.fNb.getResources().getString(d.j.pb_original_bar_from, this.fIP.bas().getName()));
                    } else {
                        pVar.bey.setVisibility(8);
                    }
                }
                a(pVar.fJm, view, this.fOF);
                pVar.fJd.setVisibility(8);
                pVar.fJp.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                if (this.fIP != null && this.fIP.bau() != null) {
                    pVar.fJp.a(postData.bxd(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIP.bau().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.fJp.onChangeSkinType();
                if (this.fNb.bbR().bfL()) {
                    pVar.fJm.setVisibility(8);
                }
                if (this.fIP != null && this.fIP.bau() != null && this.fIP.bau().zA() != null) {
                    bn zA = this.fIP.bau().zA();
                    final String activityUrl = zA.getActivityUrl();
                    String AO = zA.AO();
                    if (!StringUtils.isNull(zA.AP())) {
                        pVar.fOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.pa()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.b.S(o.this.fNb.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(AO)) {
                            pVar.fON.setVisibility(0);
                            pVar.fON.startLoad(AO, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fON.setVisibility(8);
                }
                if (pVar.fOP != null) {
                    pVar.fOP.setVisibility(8);
                }
            }
            pVar.fJm.getLayoutStrategy().iK(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwU()));
            if (postData.bwZ() > 0 && postData.bwR() != null && postData.bwR().size() > 0) {
                if (this.fIQ == null) {
                    this.fIQ = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIQ.setIsFromCDN(this.mIsFromCDN);
                    this.fIQ.H(this.fIS);
                    if (this.fIP != null) {
                        this.fIQ.P(this.fIP.baG(), TextUtils.equals(this.fIP.bau().zn().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fIQ.T(this.fIP.bau());
                    }
                }
                this.fIQ.qK(postData.getId());
            }
            pVar.fJm.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_link_tip_c));
            if (this.fIN) {
                pVar.fJm.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                pVar.fJm.getLayoutStrategy().iN(d.f.icon_click);
            }
            pVar.fJm.setIsFromCDN(this.mIsFromCDN);
            if (this.fIP != null && this.fIP.bau() != null && this.fIP.bau().isLinkThread()) {
                a(pVar, this.fIP.bau().AB());
            }
            a(pVar, postData);
            TbRichText bwX = postData.bwX();
            if (this.fIP != null && this.fIP.baR()) {
                bwX = null;
            }
            if (this.fIT || !this.fIU) {
                pVar.fJm.a(bwX, false, this.fNO);
            } else {
                pVar.fJm.a(bwX, true, this.fNO);
            }
            a(pVar, postData, bwX);
            boolean z7 = !StringUtils.isNull(postData.zn().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fIP != null && this.fIP.baG() != 0) {
                z8 = true;
                z9 = true;
                if (postData.zn() != null) {
                    String userId = postData.zn().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fIP != null && this.fIP.bau() != null && this.fIP.bau().zn() != null && postData.zn() != null) {
                String userId2 = this.fIP.bau().zn().getUserId();
                String userId3 = postData.zn().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.zn() == null && UtilHelper.isCurrentAccount(postData.zn().getUserId())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        boolean z10 = z3;
                        z4 = z2;
                        z5 = z10;
                    }
                    if (z7) {
                        z6 = z4;
                    } else {
                        z8 = false;
                        z6 = false;
                        z = false;
                    }
                    int i3 = 1;
                    if (postData.bwU() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.zn() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                        }
                        if (this.fIP != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIP.baG()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zn() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                        }
                        if (this.fIP != null && this.fIP.bau() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fIP.bau().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        if (this.fIP != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIP.baG()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    b(pVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.zn() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.bwU() == 1) {
            }
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(pVar);
        }
    }

    private void b(final p pVar, final PostData postData, final View view, final int i) {
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.fJm.setTag(sparseArray);
            pVar.fJc.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fJm.setIsHost(true);
            if (this.fOE) {
                pVar.egZ.setVisibility(0);
            } else {
                pVar.egZ.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIN) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fJm.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fJm.setLayoutParams(layoutParams);
                pVar.fJm.hB(null);
                this.fOF = false;
                a(pVar, postData, view, i);
                return;
            }
            this.fOF = true;
            pVar.fJm.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                public void Sc() {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fJm.getLayoutParams();
                    layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                    int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                    layoutParams2.bottomMargin = dimensionPixelSize;
                    layoutParams2.leftMargin = dimensionPixelSize;
                    layoutParams2.rightMargin = dimensionPixelSize;
                    pVar.fJm.setLayoutParams(layoutParams2);
                    o.this.a(pVar, postData, view, i);
                }
            });
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bxi() == null) {
                pVar.cYC.setVisibility(8);
                pVar.fJm.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            pVar.cYC.b(postData.bxi());
            pVar.cYC.setVisibility(0);
            if (pVar.cYC.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.cYC.getLayoutParams();
                if (pVar.bey.getVisibility() != 0 && pVar.fOQ.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.fOH;
                } else {
                    layoutParams.bottomMargin = this.cHW;
                }
                pVar.cYC.setLayoutParams(layoutParams);
            }
            pVar.fJm.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !pVar.fOY.getIsLoaded() && adVar.yl() == com.baidu.tbadk.core.data.ad.aNd) {
            if (adVar.ym()) {
                pVar.fOX.setVisibility(8);
                pVar.fOY.setVisibility(8);
                return;
            }
            pVar.fJm.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds48));
            pVar.fOX.setVisibility(0);
            com.baidu.tbadk.core.util.aj.t(pVar.fOX, d.C0140d.cp_bg_line_c);
            pVar.fOY.setVisibility(0);
            pVar.fOY.setFocusable(false);
            pVar.fOY.setBackgroundColor(0);
            pVar.fOY.getSettings().setCacheMode(-1);
            pVar.fOY.setVerticalScrollBarEnabled(false);
            pVar.fOY.setHorizontalScrollBarEnabled(false);
            pVar.fOY.getSettings().setAllowFileAccess(true);
            pVar.fOY.getSettings().setAppCacheEnabled(true);
            pVar.fOY.getSettings().setDomStorageEnabled(true);
            pVar.fOY.getSettings().setDatabaseEnabled(true);
            pVar.fOY.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.fOY.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.fOY.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bha() == null) {
            pVar.fJH.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.bha(), pVar.fJH, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fJm.setTextViewOnTouchListener(this.fOI);
        pVar.fJm.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ao - i, this.fIM);
            tbRichTextView.getLayoutStrategy().iL(min);
            tbRichTextView.getLayoutStrategy().iM((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fJc.setOnTouchListener(this.bLT);
        pVar.fJc.setOnLongClickListener(this.bmu);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf;
        pVar.fJm.setOnLongClickListener(this.bmu);
        pVar.fJm.setOnTouchListener(this.fOI);
        pVar.fJm.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fJm.setOnImageClickListener(this.bLS);
        pVar.fJm.setOnImageTouchListener(this.fOI);
        pVar.fJm.setOnEmotionClickListener(aVar.fYc);
        pVar.fJH.setOnClickListener(this.mCommonClickListener);
        pVar.bey.setOnClickListener(this.mCommonClickListener);
        pVar.fOS.setOnClickListener(this);
        pVar.fOT.setOnClickListener(this);
        pVar.fOU.setOnClickListener(this);
        pVar.cYC.setSubClickListener(this.fOJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fNb.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fNb).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIP = dVar;
    }

    public void sE(int i) {
        this.fIM = i;
    }

    public void jP(boolean z) {
        this.fIN = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIS = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLS = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLT = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmu = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fNO = cVar;
    }

    public void kh(boolean z) {
        this.fOE = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).fOY != null) {
            ((p) this.viewholder).fOY.removeAllViews();
            ((p) this.viewholder).fOY.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).fOY.setVisibility(8);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).fOY != null) {
                            ((p) o.this.viewholder).fOY.destroy();
                            ((p) o.this.viewholder).fOY = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).fOY != null) {
            ((p) this.viewholder).fOY.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).fOY != null) {
            ((p) this.viewholder).fOY.onPause();
        }
    }

    private boolean bcW() {
        return (this.fIP == null || this.fIP.bau() == null || !this.fIP.bau().Aa() || this.fIP.bau().zF() == null) ? false : true;
    }
}
