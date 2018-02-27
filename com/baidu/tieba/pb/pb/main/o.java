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
    private TbRichTextView.h bLF;
    private com.baidu.tieba.pb.a.c bLG;
    private View.OnLongClickListener bmh;
    private int cHK;
    protected int fIB;
    protected boolean fIC;
    protected com.baidu.tieba.pb.data.d fIE;
    private com.baidu.tieba.pb.pb.sub.d fIF;
    private View.OnClickListener fIH;
    private boolean fII;
    private final boolean fIJ;
    private TbRichTextView.c fND;
    private final int fOs;
    private boolean fOt;
    private boolean fOu;
    private int fOv;
    private int fOw;
    private com.baidu.tieba.pb.a.c fOx;
    private OriginalThreadCardView.a fOy;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fOs = 3;
        this.fIB = 0;
        this.fIC = true;
        this.fOt = true;
        this.fIE = null;
        this.fIF = null;
        this.fIH = null;
        this.mCommonClickListener = null;
        this.bLF = null;
        this.bLG = null;
        this.bmh = null;
        this.fND = null;
        this.fII = false;
        this.fIJ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fOu = false;
        this.fOv = 0;
        this.fOw = 0;
        this.cHK = 0;
        this.pageFromType = 0;
        this.fOx = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bLG != null) {
                    o.this.bLG.cn(view);
                    o.this.bLG.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fOy = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fIE != null) {
                    String threadId = o.this.fIE.getThreadId();
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
        this.fOw = com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds60);
        this.cHK = com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.bbz() != null) {
            this.pageFromType = pbActivity.bbz().bdR();
        }
        this.fOv = com.baidu.adp.lib.util.l.ao(pbActivity) - com.baidu.adp.lib.util.l.t(pbActivity, d.e.ds130);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.t(pVar.fIR, d.C0141d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.t(pVar.egN, d.C0141d.cp_bg_line_c);
                pVar.fJb.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.e(pVar.bel, d.C0141d.cp_cont_f, 1);
                pVar.bel.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                pVar.cYq.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(pVar.fOG, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOH, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOI, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(pVar.fOJ, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.t(pVar.fOK, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.t(pVar.fOL, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(pVar.fOO, d.C0141d.cp_cont_d, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fMQ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.fIC, this.fIB);
        a(pVar);
        if (pVar.cYq != null) {
            pVar.cYq.cYV = this.pageFromType;
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
        if (!this.fII && this.fIJ && pVar != null && pVar.fJb.RW() && (listView = ((PbActivity) this.fMQ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fII = true;
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
        if (this.fIE != null) {
            if (postData.bwT() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fJb.setOnClickListener(this.mCommonClickListener);
                    pVar.fJb.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fJb.setOnClickListener(null);
                    pVar.fJb.setTextViewOnClickListener(null);
                }
                pVar.fIR.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fIR.setOnClickListener(null);
            }
            if (postData.bwT() == 1) {
                pVar.fOO.setVisibility(8);
                StringBuilder sb = null;
                List<ay> baN = this.fIE.baN();
                if (com.baidu.tbadk.core.util.v.D(baN) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (ay ayVar : baN) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aOa) != null && tVar.isDeleted && ((tVar.aMi && (tVar.type == 1 || tVar.type == 2)) || (this.fIE.bat() != null && this.fIE.bat().zn() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fIE.bat().zn().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fMQ.getString(d.j.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    pVar.fOO.setVisibility(0);
                    pVar.fOO.setText(String.format(this.fMQ.getString(d.j.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
                if (!this.fMQ.bcz()) {
                    pVar.bel.setVisibility(8);
                    if (com.baidu.tbadk.core.util.v.E(this.fIE.baN())) {
                        pVar.fOF.setVisibility(8);
                        pVar.fOO.setVisibility(8);
                    } else {
                        int D = com.baidu.tbadk.core.util.v.D(this.fIE.baN());
                        if (D > 3) {
                            D = 3;
                        }
                        int i2 = this.fOv / D;
                        switch (D) {
                            case 1:
                                pVar.fOH.setMaxWidth(i2);
                                pVar.fOH.setText(this.fMQ.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 0)).getForumName()}));
                                pVar.fOH.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 0)).getForumName());
                                pVar.fOH.setVisibility(0);
                                pVar.fOI.setVisibility(0);
                                pVar.fOJ.setVisibility(0);
                                pVar.fOK.setVisibility(8);
                                pVar.fOL.setVisibility(8);
                                break;
                            case 2:
                                pVar.fOH.setMaxWidth(i2);
                                pVar.fOH.setText(this.fMQ.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 0)).getForumName()}));
                                pVar.fOH.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 0)).getForumName());
                                pVar.fOH.setVisibility(0);
                                pVar.fOI.setMaxWidth(i2);
                                pVar.fOI.setText(this.fMQ.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 1)).getForumName()}));
                                pVar.fOI.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 1)).getForumName());
                                pVar.fOI.setVisibility(0);
                                pVar.fOJ.setVisibility(8);
                                pVar.fOK.setVisibility(0);
                                pVar.fOL.setVisibility(8);
                                break;
                            case 3:
                                pVar.fOH.setMaxWidth(i2);
                                pVar.fOH.setText(this.fMQ.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 0)).getForumName()}));
                                pVar.fOH.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 0)).getForumName());
                                pVar.fOH.setVisibility(0);
                                pVar.fOI.setMaxWidth(i2);
                                pVar.fOI.setText(this.fMQ.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 1)).getForumName()}));
                                pVar.fOI.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 1)).getForumName());
                                pVar.fOI.setVisibility(0);
                                pVar.fOJ.setMaxWidth(i2);
                                pVar.fOJ.setText(this.fMQ.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 2)).getForumName()}));
                                pVar.fOJ.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fIE.baN(), 2)).getForumName());
                                pVar.fOJ.setVisibility(0);
                                pVar.fOK.setVisibility(0);
                                pVar.fOL.setVisibility(0);
                                break;
                        }
                        pVar.fOF.setVisibility(0);
                    }
                } else {
                    pVar.fOF.setVisibility(8);
                    pVar.fOO.setVisibility(8);
                    if (this.fIE.bar() != null && !StringUtils.isNull(this.fIE.bar().getName()) && !bcV()) {
                        pVar.bel.setVisibility(0);
                        pVar.bel.setText(this.fMQ.getResources().getString(d.j.pb_original_bar_from, this.fIE.bar().getName()));
                    } else {
                        pVar.bel.setVisibility(8);
                    }
                }
                a(pVar.fJb, view, this.fOu);
                pVar.fIS.setVisibility(8);
                pVar.fJe.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                if (this.fIE != null && this.fIE.bat() != null) {
                    pVar.fJe.a(postData.bxc(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIE.bat().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.fJe.onChangeSkinType();
                if (this.fMQ.bbQ().bfK()) {
                    pVar.fJb.setVisibility(8);
                }
                if (this.fIE != null && this.fIE.bat() != null && this.fIE.bat().zA() != null) {
                    bn zA = this.fIE.bat().zA();
                    final String activityUrl = zA.getActivityUrl();
                    String AO = zA.AO();
                    if (!StringUtils.isNull(zA.AP())) {
                        pVar.fOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.pa()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.b.S(o.this.fMQ.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(AO)) {
                            pVar.fOC.setVisibility(0);
                            pVar.fOC.startLoad(AO, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fOC.setVisibility(8);
                }
                if (pVar.fOE != null) {
                    pVar.fOE.setVisibility(8);
                }
            }
            pVar.fJb.getLayoutStrategy().iK(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwT()));
            if (postData.bwY() > 0 && postData.bwQ() != null && postData.bwQ().size() > 0) {
                if (this.fIF == null) {
                    this.fIF = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIF.setIsFromCDN(this.mIsFromCDN);
                    this.fIF.H(this.fIH);
                    if (this.fIE != null) {
                        this.fIF.P(this.fIE.baF(), TextUtils.equals(this.fIE.bat().zn().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fIF.T(this.fIE.bat());
                    }
                }
                this.fIF.qK(postData.getId());
            }
            pVar.fJb.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            if (this.fIC) {
                pVar.fJb.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                pVar.fJb.getLayoutStrategy().iN(d.f.icon_click);
            }
            pVar.fJb.setIsFromCDN(this.mIsFromCDN);
            if (this.fIE != null && this.fIE.bat() != null && this.fIE.bat().isLinkThread()) {
                a(pVar, this.fIE.bat().AB());
            }
            a(pVar, postData);
            TbRichText bwW = postData.bwW();
            if (this.fIE != null && this.fIE.baQ()) {
                bwW = null;
            }
            if (this.fII || !this.fIJ) {
                pVar.fJb.a(bwW, false, this.fND);
            } else {
                pVar.fJb.a(bwW, true, this.fND);
            }
            a(pVar, postData, bwW);
            boolean z7 = !StringUtils.isNull(postData.zn().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fIE != null && this.fIE.baF() != 0) {
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
            if (this.fIE != null && this.fIE.bat() != null && this.fIE.bat().zn() != null && postData.zn() != null) {
                String userId2 = this.fIE.bat().zn().getUserId();
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
                    if (postData.bwT() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.zn() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                        }
                        if (this.fIE != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIE.baF()));
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
                        if (this.fIE != null && this.fIE.bat() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fIE.bat().getId());
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
                        if (this.fIE != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIE.baF()));
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
            if (postData.bwT() == 1) {
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
            pVar.fJb.setTag(sparseArray);
            pVar.fIR.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fJb.setIsHost(true);
            if (this.fOt) {
                pVar.egN.setVisibility(0);
            } else {
                pVar.egN.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIC) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fJb.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fJb.setLayoutParams(layoutParams);
                pVar.fJb.hB(null);
                this.fOu = false;
                a(pVar, postData, view, i);
                return;
            }
            this.fOu = true;
            pVar.fJb.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                public void Sb() {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fJb.getLayoutParams();
                    layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                    int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                    layoutParams2.bottomMargin = dimensionPixelSize;
                    layoutParams2.leftMargin = dimensionPixelSize;
                    layoutParams2.rightMargin = dimensionPixelSize;
                    pVar.fJb.setLayoutParams(layoutParams2);
                    o.this.a(pVar, postData, view, i);
                }
            });
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bxh() == null) {
                pVar.cYq.setVisibility(8);
                pVar.fJb.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            pVar.cYq.b(postData.bxh());
            pVar.cYq.setVisibility(0);
            if (pVar.cYq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.cYq.getLayoutParams();
                if (pVar.bel.getVisibility() != 0 && pVar.fOF.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.fOw;
                } else {
                    layoutParams.bottomMargin = this.cHK;
                }
                pVar.cYq.setLayoutParams(layoutParams);
            }
            pVar.fJb.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !pVar.fON.getIsLoaded() && adVar.yl() == com.baidu.tbadk.core.data.ad.aMS) {
            if (adVar.ym()) {
                pVar.fOM.setVisibility(8);
                pVar.fON.setVisibility(8);
                return;
            }
            pVar.fJb.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds48));
            pVar.fOM.setVisibility(0);
            com.baidu.tbadk.core.util.aj.t(pVar.fOM, d.C0141d.cp_bg_line_c);
            pVar.fON.setVisibility(0);
            pVar.fON.setFocusable(false);
            pVar.fON.setBackgroundColor(0);
            pVar.fON.getSettings().setCacheMode(-1);
            pVar.fON.setVerticalScrollBarEnabled(false);
            pVar.fON.setHorizontalScrollBarEnabled(false);
            pVar.fON.getSettings().setAllowFileAccess(true);
            pVar.fON.getSettings().setAppCacheEnabled(true);
            pVar.fON.getSettings().setDomStorageEnabled(true);
            pVar.fON.getSettings().setDatabaseEnabled(true);
            pVar.fON.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.fON.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.fON.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bgZ() == null) {
            pVar.fJw.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.bgZ(), pVar.fJw, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fJb.setTextViewOnTouchListener(this.fOx);
        pVar.fJb.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ao - i, this.fIB);
            tbRichTextView.getLayoutStrategy().iL(min);
            tbRichTextView.getLayoutStrategy().iM((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fIR.setOnTouchListener(this.bLG);
        pVar.fIR.setOnLongClickListener(this.bmh);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU;
        pVar.fJb.setOnLongClickListener(this.bmh);
        pVar.fJb.setOnTouchListener(this.fOx);
        pVar.fJb.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fJb.setOnImageClickListener(this.bLF);
        pVar.fJb.setOnImageTouchListener(this.fOx);
        pVar.fJb.setOnEmotionClickListener(aVar.fXR);
        pVar.fJw.setOnClickListener(this.mCommonClickListener);
        pVar.bel.setOnClickListener(this.mCommonClickListener);
        pVar.fOH.setOnClickListener(this);
        pVar.fOI.setOnClickListener(this);
        pVar.fOJ.setOnClickListener(this);
        pVar.cYq.setSubClickListener(this.fOy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fMQ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fMQ).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIE = dVar;
    }

    public void sF(int i) {
        this.fIB = i;
    }

    public void jP(boolean z) {
        this.fIC = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIH = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLF = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmh = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fND = cVar;
    }

    public void kh(boolean z) {
        this.fOt = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).fON != null) {
            ((p) this.viewholder).fON.removeAllViews();
            ((p) this.viewholder).fON.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).fON.setVisibility(8);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).fON != null) {
                            ((p) o.this.viewholder).fON.destroy();
                            ((p) o.this.viewholder).fON = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).fON != null) {
            ((p) this.viewholder).fON.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).fON != null) {
            ((p) this.viewholder).fON.onPause();
        }
    }

    private boolean bcV() {
        return (this.fIE == null || this.fIE.bat() == null || !this.fIE.bat().Aa() || this.fIE.bat().zF() == null) ? false : true;
    }
}
