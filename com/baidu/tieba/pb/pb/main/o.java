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
    private TbRichTextView.h bLI;
    private com.baidu.tieba.pb.a.c bLJ;
    private View.OnLongClickListener bmk;
    private int cHN;
    protected int fIR;
    protected boolean fIS;
    protected com.baidu.tieba.pb.data.d fIU;
    private com.baidu.tieba.pb.pb.sub.d fIV;
    private View.OnClickListener fIX;
    private boolean fIY;
    private final boolean fIZ;
    private TbRichTextView.c fNT;
    private final int fOI;
    private boolean fOJ;
    private boolean fOK;
    private int fOL;
    private int fOM;
    private com.baidu.tieba.pb.a.c fON;
    private OriginalThreadCardView.a fOO;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fOI = 3;
        this.fIR = 0;
        this.fIS = true;
        this.fOJ = true;
        this.fIU = null;
        this.fIV = null;
        this.fIX = null;
        this.mCommonClickListener = null;
        this.bLI = null;
        this.bLJ = null;
        this.bmk = null;
        this.fNT = null;
        this.fIY = false;
        this.fIZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fOK = false;
        this.fOL = 0;
        this.fOM = 0;
        this.cHN = 0;
        this.pageFromType = 0;
        this.fON = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bLJ != null) {
                    o.this.bLJ.cn(view);
                    o.this.bLJ.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fOO = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fIU != null) {
                    String threadId = o.this.fIU.getThreadId();
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
        this.fOM = com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds60);
        this.cHN = com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.bbA() != null) {
            this.pageFromType = pbActivity.bbA().bdS();
        }
        this.fOL = com.baidu.adp.lib.util.l.ao(pbActivity) - com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds130);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.t(pVar.fJh, d.C0141d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.t(pVar.ehd, d.C0141d.cp_bg_line_c);
                pVar.fJr.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.e(pVar.beo, d.C0141d.cp_cont_f, 1);
                pVar.beo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                pVar.cYt.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(pVar.fOW, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOX, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOY, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOZ, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.t(pVar.fPa, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.t(pVar.fPb, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(pVar.fPe, d.C0141d.cp_cont_d, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fNg.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.fIS, this.fIR);
        a(pVar);
        if (pVar.cYt != null) {
            pVar.cYt.cYY = this.pageFromType;
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
        if (!this.fIY && this.fIZ && pVar != null && pVar.fJr.RX() && (listView = ((PbActivity) this.fNg.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fIY = true;
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
        if (this.fIU != null) {
            if (postData.bwY() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fJr.setOnClickListener(this.mCommonClickListener);
                    pVar.fJr.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fJr.setOnClickListener(null);
                    pVar.fJr.setTextViewOnClickListener(null);
                }
                pVar.fJh.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fJh.setOnClickListener(null);
            }
            if (postData.bwY() == 1) {
                pVar.fPe.setVisibility(8);
                StringBuilder sb = null;
                List<ay> baO = this.fIU.baO();
                if (com.baidu.tbadk.core.util.v.D(baO) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (ay ayVar : baO) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aOb) != null && tVar.isDeleted && ((tVar.aMj && (tVar.type == 1 || tVar.type == 2)) || (this.fIU.bau() != null && this.fIU.bau().zn() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fIU.bau().zn().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fNg.getString(d.j.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    pVar.fPe.setVisibility(0);
                    pVar.fPe.setText(String.format(this.fNg.getString(d.j.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
                if (!this.fNg.bcA()) {
                    pVar.beo.setVisibility(8);
                    if (com.baidu.tbadk.core.util.v.E(this.fIU.baO())) {
                        pVar.fOV.setVisibility(8);
                        pVar.fPe.setVisibility(8);
                    } else {
                        int D = com.baidu.tbadk.core.util.v.D(this.fIU.baO());
                        if (D > 3) {
                            D = 3;
                        }
                        int i2 = this.fOL / D;
                        switch (D) {
                            case 1:
                                pVar.fOX.setMaxWidth(i2);
                                pVar.fOX.setText(this.fNg.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 0)).getForumName()}));
                                pVar.fOX.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 0)).getForumName());
                                pVar.fOX.setVisibility(0);
                                pVar.fOY.setVisibility(0);
                                pVar.fOZ.setVisibility(0);
                                pVar.fPa.setVisibility(8);
                                pVar.fPb.setVisibility(8);
                                break;
                            case 2:
                                pVar.fOX.setMaxWidth(i2);
                                pVar.fOX.setText(this.fNg.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 0)).getForumName()}));
                                pVar.fOX.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 0)).getForumName());
                                pVar.fOX.setVisibility(0);
                                pVar.fOY.setMaxWidth(i2);
                                pVar.fOY.setText(this.fNg.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 1)).getForumName()}));
                                pVar.fOY.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 1)).getForumName());
                                pVar.fOY.setVisibility(0);
                                pVar.fOZ.setVisibility(8);
                                pVar.fPa.setVisibility(0);
                                pVar.fPb.setVisibility(8);
                                break;
                            case 3:
                                pVar.fOX.setMaxWidth(i2);
                                pVar.fOX.setText(this.fNg.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 0)).getForumName()}));
                                pVar.fOX.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 0)).getForumName());
                                pVar.fOX.setVisibility(0);
                                pVar.fOY.setMaxWidth(i2);
                                pVar.fOY.setText(this.fNg.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 1)).getForumName()}));
                                pVar.fOY.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 1)).getForumName());
                                pVar.fOY.setVisibility(0);
                                pVar.fOZ.setMaxWidth(i2);
                                pVar.fOZ.setText(this.fNg.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 2)).getForumName()}));
                                pVar.fOZ.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIU.baO(), 2)).getForumName());
                                pVar.fOZ.setVisibility(0);
                                pVar.fPa.setVisibility(0);
                                pVar.fPb.setVisibility(0);
                                break;
                        }
                        pVar.fOV.setVisibility(0);
                    }
                } else {
                    pVar.fOV.setVisibility(8);
                    pVar.fPe.setVisibility(8);
                    if (this.fIU.bas() != null && !StringUtils.isNull(this.fIU.bas().getName()) && !bcW()) {
                        pVar.beo.setVisibility(0);
                        pVar.beo.setText(this.fNg.getResources().getString(d.j.pb_original_bar_from, this.fIU.bas().getName()));
                    } else {
                        pVar.beo.setVisibility(8);
                    }
                }
                a(pVar.fJr, view, this.fOK);
                pVar.fJi.setVisibility(8);
                pVar.fJu.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                if (this.fIU != null && this.fIU.bau() != null) {
                    pVar.fJu.a(postData.bxh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIU.bau().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.fJu.onChangeSkinType();
                if (this.fNg.bbR().bfL()) {
                    pVar.fJr.setVisibility(8);
                }
                if (this.fIU != null && this.fIU.bau() != null && this.fIU.bau().zA() != null) {
                    bn zA = this.fIU.bau().zA();
                    final String activityUrl = zA.getActivityUrl();
                    String AP = zA.AP();
                    if (!StringUtils.isNull(zA.AQ())) {
                        pVar.fOT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.pa()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.b.S(o.this.fNg.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(AP)) {
                            pVar.fOS.setVisibility(0);
                            pVar.fOS.startLoad(AP, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fOS.setVisibility(8);
                }
                if (pVar.fOU != null) {
                    pVar.fOU.setVisibility(8);
                }
            }
            pVar.fJr.getLayoutStrategy().iK(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwY()));
            if (postData.bxd() > 0 && postData.bwV() != null && postData.bwV().size() > 0) {
                if (this.fIV == null) {
                    this.fIV = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIV.setIsFromCDN(this.mIsFromCDN);
                    this.fIV.H(this.fIX);
                    if (this.fIU != null) {
                        this.fIV.P(this.fIU.baG(), TextUtils.equals(this.fIU.bau().zn().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fIV.T(this.fIU.bau());
                    }
                }
                this.fIV.qK(postData.getId());
            }
            pVar.fJr.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            if (this.fIS) {
                pVar.fJr.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                pVar.fJr.getLayoutStrategy().iN(d.f.icon_click);
            }
            pVar.fJr.setIsFromCDN(this.mIsFromCDN);
            if (this.fIU != null && this.fIU.bau() != null && this.fIU.bau().isLinkThread()) {
                a(pVar, this.fIU.bau().AB());
            }
            a(pVar, postData);
            TbRichText bxb = postData.bxb();
            if (this.fIU != null && this.fIU.baR()) {
                bxb = null;
            }
            if (this.fIY || !this.fIZ) {
                pVar.fJr.a(bxb, false, this.fNT);
            } else {
                pVar.fJr.a(bxb, true, this.fNT);
            }
            a(pVar, postData, bxb);
            boolean z7 = !StringUtils.isNull(postData.zn().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fIU != null && this.fIU.baG() != 0) {
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
            if (this.fIU != null && this.fIU.bau() != null && this.fIU.bau().zn() != null && postData.zn() != null) {
                String userId2 = this.fIU.bau().zn().getUserId();
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
                    if (postData.bwY() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.zn() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                        }
                        if (this.fIU != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIU.baG()));
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
                        if (this.fIU != null && this.fIU.bau() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fIU.bau().getId());
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
                        if (this.fIU != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIU.baG()));
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
            if (postData.bwY() == 1) {
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
            pVar.fJr.setTag(sparseArray);
            pVar.fJh.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fJr.setIsHost(true);
            if (this.fOJ) {
                pVar.ehd.setVisibility(0);
            } else {
                pVar.ehd.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIS) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fJr.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fJr.setLayoutParams(layoutParams);
                pVar.fJr.hB(null);
                this.fOK = false;
                a(pVar, postData, view, i);
                return;
            }
            this.fOK = true;
            pVar.fJr.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                public void Sc() {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fJr.getLayoutParams();
                    layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                    int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                    layoutParams2.bottomMargin = dimensionPixelSize;
                    layoutParams2.leftMargin = dimensionPixelSize;
                    layoutParams2.rightMargin = dimensionPixelSize;
                    pVar.fJr.setLayoutParams(layoutParams2);
                    o.this.a(pVar, postData, view, i);
                }
            });
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bxm() == null) {
                pVar.cYt.setVisibility(8);
                pVar.fJr.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            pVar.cYt.b(postData.bxm());
            pVar.cYt.setVisibility(0);
            if (pVar.cYt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.cYt.getLayoutParams();
                if (pVar.beo.getVisibility() != 0 && pVar.fOV.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.fOM;
                } else {
                    layoutParams.bottomMargin = this.cHN;
                }
                pVar.cYt.setLayoutParams(layoutParams);
            }
            pVar.fJr.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !pVar.fPd.getIsLoaded() && adVar.yl() == com.baidu.tbadk.core.data.ad.aMT) {
            if (adVar.ym()) {
                pVar.fPc.setVisibility(8);
                pVar.fPd.setVisibility(8);
                return;
            }
            pVar.fJr.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds48));
            pVar.fPc.setVisibility(0);
            com.baidu.tbadk.core.util.aj.t(pVar.fPc, d.C0141d.cp_bg_line_c);
            pVar.fPd.setVisibility(0);
            pVar.fPd.setFocusable(false);
            pVar.fPd.setBackgroundColor(0);
            pVar.fPd.getSettings().setCacheMode(-1);
            pVar.fPd.setVerticalScrollBarEnabled(false);
            pVar.fPd.setHorizontalScrollBarEnabled(false);
            pVar.fPd.getSettings().setAllowFileAccess(true);
            pVar.fPd.getSettings().setAppCacheEnabled(true);
            pVar.fPd.getSettings().setDomStorageEnabled(true);
            pVar.fPd.getSettings().setDatabaseEnabled(true);
            pVar.fPd.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.fPd.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.fPd.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bha() == null) {
            pVar.fJM.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.bha(), pVar.fJM, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fJr.setTextViewOnTouchListener(this.fON);
        pVar.fJr.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ao - i, this.fIR);
            tbRichTextView.getLayoutStrategy().iL(min);
            tbRichTextView.getLayoutStrategy().iM((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fJh.setOnTouchListener(this.bLJ);
        pVar.fJh.setOnLongClickListener(this.bmk);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk;
        pVar.fJr.setOnLongClickListener(this.bmk);
        pVar.fJr.setOnTouchListener(this.fON);
        pVar.fJr.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fJr.setOnImageClickListener(this.bLI);
        pVar.fJr.setOnImageTouchListener(this.fON);
        pVar.fJr.setOnEmotionClickListener(aVar.fYh);
        pVar.fJM.setOnClickListener(this.mCommonClickListener);
        pVar.beo.setOnClickListener(this.mCommonClickListener);
        pVar.fOX.setOnClickListener(this);
        pVar.fOY.setOnClickListener(this);
        pVar.fOZ.setOnClickListener(this);
        pVar.cYt.setSubClickListener(this.fOO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fNg.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fNg).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIU = dVar;
    }

    public void sF(int i) {
        this.fIR = i;
    }

    public void jU(boolean z) {
        this.fIS = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIX = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLI = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLJ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmk = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fNT = cVar;
    }

    public void km(boolean z) {
        this.fOJ = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).fPd != null) {
            ((p) this.viewholder).fPd.removeAllViews();
            ((p) this.viewholder).fPd.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).fPd.setVisibility(8);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).fPd != null) {
                            ((p) o.this.viewholder).fPd.destroy();
                            ((p) o.this.viewholder).fPd = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).fPd != null) {
            ((p) this.viewholder).fPd.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).fPd != null) {
            ((p) this.viewholder).fPd.onPause();
        }
    }

    private boolean bcW() {
        return (this.fIU == null || this.fIU.bau() == null || !this.fIU.bau().Aa() || this.fIU.bau().zF() == null) ? false : true;
    }
}
