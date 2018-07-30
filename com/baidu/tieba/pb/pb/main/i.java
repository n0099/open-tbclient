package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private View.OnLongClickListener aHk;
    private boolean bga;
    private TbRichTextView.h bgd;
    private com.baidu.tieba.pb.a.c bge;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqB;
    private com.baidu.adp.lib.e.b<TbImageView> dqC;
    protected com.baidu.tieba.pb.data.d fxI;
    private boolean fxJ;
    private View.OnClickListener fxR;
    private int fyg;
    private int fyh;
    private int fyi;
    private TbRichTextView.c fyj;
    private com.baidu.tieba.pb.pb.sub.c fyk;
    private com.baidu.tieba.pb.a.c fyl;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bd;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bwr() && this.mCommonClickListener != null && this.fxt != null && (bd = this.fxt.bd(findViewById)) != null) {
                TiebaStatic.log(this.fxt.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, bd.bwr() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fyg = 0;
        this.fyh = 0;
        this.fyi = 0;
        this.fyj = null;
        this.fxJ = true;
        this.mHostId = null;
        this.fxI = null;
        this.fxR = null;
        this.mCommonClickListener = null;
        this.bgd = null;
        this.bge = null;
        this.aHk = null;
        this.fyk = null;
        this.bga = true;
        this.dqB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awa */
            public ConstrainImageLayout ig() {
                return new ConstrainImageLayout(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dqC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AR */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fyl = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fxt == null || i.this.fxt.baK() == null || i.this.fxt.baK().bdI())) {
                    if (view instanceof NoPressedLinearLayout) {
                        i.this.a((NoPressedLinearLayout) view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof NoPressedLinearLayout) {
                                i.this.a((NoPressedLinearLayout) parent);
                                break;
                            } else {
                                i++;
                                parent = parent.getParent();
                            }
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (i.this.bge != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bge.ba(view);
                        i.this.bge.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    i.this.mCommonClickListener.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.fxt.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fyD.setConstrainLayoutPool(this.dqB);
        jVar.fyD.setImageViewPool(this.dqC);
        a(jVar);
        this.fyg = getDimensionPixelSize(d.e.tbds12);
        this.fyh = getDimensionPixelSize(d.e.tbds20);
        this.fyi = getDimensionPixelSize(d.e.tbds36);
        if (jVar.fyC != null) {
            jVar.fyC.setDuiEnabled(this.bga);
        }
        return jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, j jVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, jVar);
        a(jVar);
        b(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            f(postData2);
            postData2.wf();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bga = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            b(jVar, postData, view, i);
            e(jVar, postData);
            a(jVar, postData, view);
            c(jVar, postData, view, i);
            f(jVar, postData);
            c(jVar, postData);
            g(jVar, postData);
            a(jVar, postData);
            d(jVar, postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z) {
        if (z) {
            jVar.fyQ.setVisibility(8);
            jVar.fyS.setText(d.j.expand_content);
            com.baidu.tbadk.core.util.am.c(jVar.fyT, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fyQ.setVisibility(0);
        jVar.fyS.setText(d.j.close_content);
        com.baidu.tbadk.core.util.am.c(jVar.fyT, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bwt() == 2) {
            jVar.fyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fyQ.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mq(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fxt.baK() != null && i.this.fxt.baK().beE() != null && i.this.fxt.baK().getListView() != null && !z && jVar.getView().getTop() < i.this.fxt.baK().beE().getMeasuredHeight()) {
                        i.this.fxt.baK().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.w.a(i.this.fxt.baK().getListView().getData(), postData) + i.this.fxt.baK().getListView().getHeaderViewsCount(), i.this.fxt.baK().beE().getMeasuredHeight());
                    }
                }
            });
            jVar.fyS.setText(this.fxI.aZv());
            jVar.fyR.setVisibility(0);
            a(jVar, postData.bwa());
            a(true, jVar, postData);
        } else {
            jVar.fyR.setVisibility(8);
            jVar.fyQ.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.w.z(postData.bwc());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyR.getLayoutParams();
        if (z) {
            jVar.fyC.getLayoutStrategy().fW(0);
            if (z2) {
                jVar.fyC.getLayoutStrategy().fV(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                }
            } else {
                jVar.fyC.getLayoutStrategy().fV(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fyR.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fyC.getLayoutStrategy().fV(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fyC.getLayoutStrategy().fW(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bwh = postData.bwh();
        bwh.isChanged = true;
        jVar.fyC.setText(bwh, true, this.fyj);
    }

    private void f(PostData postData) {
        if (postData.aiA == 0 && postData.gOy) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.af("post_id", postData.getId());
            anVar.af("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.af("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.af("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.af("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.f("exposure_time", System.currentTimeMillis());
            if (this.fxt != null) {
                int bcO = this.fxt.bat().bcO();
                if (1 == bcO || 2 == bcO) {
                    anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bcO) {
                    anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void c(j jVar, PostData postData) {
        if (postData == null || postData.bfZ() == null) {
            jVar.fyK.setVisibility(8);
            return;
        }
        TbRichText bwh = postData.bwh();
        com.baidu.tieba.pb.view.d.a(postData.bfZ(), jVar.fyK, false, false, bwh != null && StringUtils.isNull(bwh.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxJ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fyC.setLayoutParams(layoutParams);
            jVar.fyC.setPadding(0, 0, 0, 0);
            jVar.fyC.hU(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyC.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fyC.setLayoutParams(layoutParams2);
            jVar.fyC.hU(postData.getBimg_url());
        }
        jVar.fyC.setTextViewOnTouchListener(this.fyl);
        jVar.fyC.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0629  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(j jVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (jVar != null && postData != null) {
            if (postData.gOD) {
                com.baidu.tbadk.core.util.am.j(jVar.aIx, d.C0140d.cp_bg_line_c);
                jVar.aIx.setVisibility(0);
            } else {
                jVar.aIx.setVisibility(8);
            }
            jVar.fyB.setTag(null);
            jVar.fyB.setUserId(null);
            jVar.csJ.setText((CharSequence) null);
            jVar.fyH.getHeadView().setUserId(null);
            jVar.fyC.setIsHost(false);
            if (postData.vk() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.vk().getUserId())) {
                    jVar.fyC.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.vk().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.vk().getTShowInfoNew();
                if (jVar.fyJ != null) {
                    jVar.fyJ.setTag(d.g.tag_user_id, postData.vk().getUserId());
                    jVar.fyJ.setOnClickListener(this.fxt.fvw.fIW);
                    jVar.fyJ.a(iconInfo, 2, this.fyi, this.fyi, this.fyg);
                }
                if (jVar.fyI != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fyI.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fyI.setOnClickListener(this.fxt.fvw.fIX);
                    jVar.fyI.a(tShowInfoNew, 3, this.fyi, this.fyi, this.fyg, true);
                }
                if (!com.baidu.tbadk.core.util.w.z(tShowInfoNew) || postData.vk().isBigV()) {
                    com.baidu.tbadk.core.util.am.c(jVar.csJ, d.C0140d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.c(jVar.csJ, d.C0140d.cp_cont_f, 1);
                }
                String portrait = postData.vk().getPortrait();
                jVar.csJ.setTag(d.g.tag_user_id, postData.vk().getUserId());
                jVar.csJ.setTag(d.g.tag_user_name, postData.vk().getUserName());
                jVar.csJ.setTag(d.g.tag_virtual_user_url, postData.vk().getVirtualUserUrl());
                String name_show = postData.vk().getName_show();
                String userName = postData.vk().getUserName();
                if (com.baidu.tbadk.p.aj.iq() && name_show != null && !name_show.equals(userName)) {
                    jVar.csJ.setText(com.baidu.tieba.pb.c.al(this.mContext, jVar.csJ.getText().toString()));
                    jVar.csJ.setGravity(16);
                    jVar.csJ.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYV());
                    com.baidu.tbadk.core.util.am.c(jVar.csJ, d.C0140d.cp_other_e, 1);
                }
                if (postData.vk().getPendantData() != null && !StringUtils.isNull(postData.vk().getPendantData().tU())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fyH.getHeadView(), postData.vk());
                    jVar.fyB.setVisibility(8);
                    jVar.fyH.setVisibility(0);
                    jVar.fyH.getHeadView().startLoad(portrait, 28, false);
                    jVar.fyH.getHeadView().setUserId(postData.vk().getUserId());
                    jVar.fyH.getHeadView().setUserName(postData.vk().getUserName());
                    jVar.fyH.fl(postData.vk().getPendantData().tU());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fyB, postData.vk());
                    jVar.fyB.setUserId(postData.vk().getUserId());
                    jVar.fyB.setUserName(postData.vk().getUserName(), postData.bwp());
                    jVar.fyB.setTag(d.g.tag_virtual_user_url, postData.vk().getVirtualUserUrl());
                    jVar.fyB.setImageDrawable(null);
                    jVar.fyB.startLoad(portrait, 28, false);
                    jVar.fyB.setVisibility(0);
                    jVar.fyH.setVisibility(8);
                }
                if (postData.vk() != null) {
                    MetaData vk = postData.vk();
                    int i2 = postData.bvX() ? d.f.brand_official_btn : d.f.user_identity_btn;
                    int i3 = postData.bvX() ? d.C0140d.cp_link_tip_a : d.C0140d.cp_cont_j;
                    com.baidu.tbadk.core.util.am.i(jVar.fyu, i2);
                    com.baidu.tbadk.core.util.am.h(jVar.fyu, i3);
                    jVar.fyu.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(vk.getUserId())) {
                        jVar.fyu.setVisibility(0);
                        jVar.fyu.setText(d.j.host_name);
                    } else if (vk.getIs_bawu() == 1 && postData.bvX()) {
                        jVar.fyu.setVisibility(0);
                        jVar.fyu.setText(d.j.brand_Official);
                    } else if (vk.getIs_bawu() == 1 && "manager".equals(vk.getBawu_type())) {
                        jVar.fyu.setVisibility(0);
                        jVar.fyu.setText(d.j.bawu_member_bazhu_tip);
                    } else if (vk.getIs_bawu() == 1 && "assist".equals(vk.getBawu_type())) {
                        jVar.fyu.setVisibility(0);
                        jVar.fyu.setText(d.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fyu.setVisibility(8);
                        jVar.fyu.setTag(null);
                    }
                } else {
                    jVar.fyu.setVisibility(8);
                    jVar.fyu.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fxt.bbu()) {
                if (postData.vk() != null) {
                    i4 = postData.vk().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fyG.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(jVar.fyG, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fyG.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fyJ.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fyJ.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fyu.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fyI.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.vk() != null ? postData.vk().getName_show() : "";
            int hI = com.baidu.tbadk.util.w.hI(name_show2);
            if (postData.vk() != null && !StringUtils.isNull(postData.vk().getSealPrefix())) {
                if (hI > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.w.D(name_show2, i5 - 2) + "...";
                }
            } else if (hI > i5) {
                name_show2 = com.baidu.tbadk.util.w.D(name_show2, i5) + "...";
            }
            if (postData.vk() != null && !StringUtils.isNull(postData.vk().getSealPrefix())) {
                jVar.csJ.setText(ai(postData.vk().getSealPrefix(), name_show2));
            } else {
                jVar.csJ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwf()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.vk() != null && !StringUtils.isNull(postData.vk().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fxI != null && this.fxI.aZz() != 0) {
                if (this.fxI.aZz() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.vk() != null) {
                    String userId = postData.vk().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fxI != null && this.fxI.aZn() != null && this.fxI.aZn().vk() != null && postData.vk() != null) {
                String userId2 = this.fxI.aZn().vk().getUserId();
                String userId3 = postData.vk().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.vk() != null && UtilHelper.isCurrentAccount(postData.vk().getUserId())) {
                        z3 = true;
                        z4 = true;
                    } else {
                        boolean z11 = z10;
                        z3 = z;
                        z4 = z11;
                    }
                    if (z7) {
                        z5 = z2;
                        z6 = z3;
                    } else {
                        z8 = false;
                        z6 = false;
                        z5 = false;
                    }
                    int i6 = 1;
                    if (postData.bwf() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxI.aZz()));
                        if (postData.vk() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vk().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vk().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vk().getPortrait());
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vk() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vk().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vk().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vk().getName_show());
                        }
                        if (this.fxI.aZn() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fxI.aZn().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxI.aZz()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fyA.setTag(sparseArray);
                }
            }
            z = z9;
            z2 = false;
            if (postData == null) {
            }
            boolean z112 = z10;
            z3 = z;
            z4 = z112;
            if (z7) {
            }
            int i62 = 1;
            if (postData.bwf() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fyA.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fyz.a(postData.bwr(), postData.bwq(), false);
            jVar.fyz.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bwf() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwf()));
                jVar.fyF.setVisibility(0);
                jVar.fyF.setText(format);
                z = true;
            } else {
                jVar.fyF.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bwi = postData.bwi();
            boolean z2 = (bwi == null || StringUtils.isNull(bwi.getName())) ? false : true;
            if (z) {
                jVar.fyw.setVisibility(0);
                i = this.fyh;
            } else {
                jVar.fyw.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fyx.setVisibility(0);
                i2 = this.fyh;
            } else {
                jVar.fyx.setVisibility(8);
                i2 = 0;
            }
            jVar.fyv.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fyv.setText(com.baidu.tbadk.core.util.ap.y(postData.getTime()));
            } else {
                jVar.fyv.setText(com.baidu.tbadk.core.util.ap.w(postData.getTime()));
            }
            if (z2) {
                final String name = bwi.getName();
                final String lat = bwi.getLat();
                final String lng = bwi.getLng();
                jVar.fyy.setVisibility(0);
                jVar.fyy.setPadding(this.fyh, 0, 0, 0);
                jVar.fyy.setText(bwi.getName());
                jVar.fyy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.jE()) {
                                com.baidu.tbadk.browser.a.Q(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                i.this.fxt.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fyy.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int f = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fyC.setPadding(f, 0, f, 0);
            if (!this.fxJ) {
                jVar.fyC.getLayoutStrategy().fR(d.f.icon_click);
            } else {
                jVar.fyC.hU(null);
                jVar.fyC.setBackgroundDrawable(null);
                jVar.fyC.getLayoutStrategy().fR(d.f.transparent_bg);
            }
            jVar.fyC.getLayoutStrategy().fO(d.f.pic_video);
            a(jVar.fyC, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fyC.setLayoutParams(layoutParams);
            jVar.fyC.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_link_tip_c));
            jVar.fyC.setIsFromCDN(this.mIsFromCDN);
            jVar.fyC.setText(postData.bwh(), true, this.fyj);
            SparseArray sparseArray = (SparseArray) jVar.fyC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fyC.setTag(sparseArray);
            jVar.fys.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ah = (ah - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fP(ah - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fQ((int) (ah * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bwj() > 0 && postData.bwc() != null && postData.bwc().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyE.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fyE.setLayoutParams(layoutParams);
                if (this.fyk == null) {
                    this.fyk = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fyk.setIsFromCDN(this.mIsFromCDN);
                    this.fyk.K(this.fxR);
                    String str = null;
                    if (this.fxI != null && this.fxI.aZn() != null && this.fxI.aZn().vk() != null) {
                        str = this.fxI.aZn().vk().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fxI != null) {
                        this.fyk.A(this.fxI.aZz(), z);
                        this.fyk.Z(this.fxI.aZn());
                    }
                }
                this.fyk.rC(postData.getId());
                jVar.fyE.setSubPbAdapter(this.fyk);
                jVar.fyE.setVisibility(0);
                jVar.fyE.setData(postData, view);
                jVar.fyE.setChildOnClickListener(this.mCommonClickListener);
                jVar.fyE.setChildOnLongClickListener(this.aHk);
                jVar.fyE.setChildOnTouchListener(this.fyl);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyE.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fyE.setLayoutParams(layoutParams2);
                jVar.fyE.setVisibility(8);
            }
            if (postData.gOC) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fyO != null && jVar.fyL != null) {
            if (postData == null || postData.gOF == null || StringUtils.isNull(postData.gOF.liveTitle)) {
                jVar.fyL.setVisibility(8);
                return;
            }
            jVar.fyO.setText(postData.gOF.liveTitle);
            jVar.fyL.setTag(postData.gOF);
            jVar.fyL.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.af("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.c(jVar.csJ, d.C0140d.cp_cont_f, 1);
                if (jVar.fyu.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.i(jVar.fyu, ((Integer) jVar.fyu.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.c(jVar.fyv, d.C0140d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.i(jVar.fyw, d.C0140d.cp_cont_e);
                com.baidu.tbadk.core.util.am.i(jVar.fyx, d.C0140d.cp_cont_e);
                com.baidu.tbadk.core.util.am.c(jVar.fyF, d.C0140d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.c(jVar.fyy, d.C0140d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.j(jVar.mBottomLine, d.C0140d.cp_bg_line_c);
                com.baidu.tbadk.core.util.am.c(jVar.fyA, d.f.icon_floor_more_selector);
                jVar.fyC.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_cont_b));
                com.baidu.tbadk.core.util.am.j(jVar.fyE, d.C0140d.cp_bg_line_e);
                jVar.fyE.onChangeSkinType();
                jVar.fyD.onChangeSkinType();
                jVar.fyz.onChangeSkinType();
                com.baidu.tbadk.core.util.am.c(jVar.fyO, d.C0140d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.c(jVar.fyM, d.C0140d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.i(jVar.fyL, d.C0140d.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.i(jVar.fyN, d.C0140d.cp_cont_d);
                com.baidu.tbadk.core.util.am.c(jVar.fyP, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.h(jVar.fyS, d.C0140d.cp_cont_j);
                if (jVar.fyQ.getVisibility() == 8) {
                    jVar.fyS.setText(d.j.close_content);
                    com.baidu.tbadk.core.util.am.c(jVar.fyT, d.f.icon_arrow_gray_up);
                } else if (this.fxI != null && StringUtils.isNull(this.fxI.aZv())) {
                    jVar.fyS.setText(this.fxI.aZv());
                    com.baidu.tbadk.core.util.am.c(jVar.fyT, d.f.icon_arrow_gray_down);
                } else {
                    jVar.fyS.setText(d.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fys.setOnTouchListener(this.fyl);
        jVar.fys.setOnLongClickListener(this.aHk);
        if (this.fxt.getPageContext() != null && this.fxt.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fxt.getPageContext().getOrignalPage()).fvw;
            jVar.csJ.setOnClickListener(aVar.fIV);
            jVar.fyB.setOnClickListener(aVar.fIV);
            jVar.fyH.setOnClickListener(aVar.fIV);
            jVar.fyH.getHeadView().setOnClickListener(aVar.fIV);
            jVar.fyC.setOnLongClickListener(this.aHk);
            jVar.fyC.setOnTouchListener(this.fyl);
            jVar.fyC.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fyC.setOnImageClickListener(this.bgd);
            jVar.fyC.setOnImageTouchListener(this.fyl);
            jVar.fyC.setOnEmotionClickListener(aVar.fIY);
            jVar.fyA.setOnClickListener(this.mCommonClickListener);
            jVar.fyz.setOnClickListener(this.mCommonClickListener);
            jVar.fyK.setOnClickListener(this.mCommonClickListener);
            jVar.fyL.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fyj = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxI = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jt(boolean z) {
        this.fxJ = z;
    }

    private SpannableStringBuilder ai(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fxt.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fyC.setTextViewOnTouchListener(this.bge);
        jVar.fyC.setTextViewCheckSelection(false);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fxR = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bgd = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bge = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }
}
