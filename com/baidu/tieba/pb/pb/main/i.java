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
    private boolean bfO;
    private TbRichTextView.h bfR;
    private com.baidu.tieba.pb.a.c bfS;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dnI;
    private com.baidu.adp.lib.e.b<TbImageView> dnJ;
    private View.OnClickListener fxF;
    private int fxU;
    private int fxV;
    private int fxW;
    private TbRichTextView.c fxX;
    private com.baidu.tieba.pb.pb.sub.c fxY;
    private com.baidu.tieba.pb.a.c fxZ;
    protected com.baidu.tieba.pb.data.d fxw;
    private boolean fxx;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData ba;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bxO() && this.mCommonClickListener != null && this.fxh != null && (ba = this.fxh.ba(findViewById)) != null) {
                TiebaStatic.log(this.fxh.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, ba.bxO() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fxU = 0;
        this.fxV = 0;
        this.fxW = 0;
        this.fxX = null;
        this.fxx = true;
        this.mHostId = null;
        this.fxw = null;
        this.fxF = null;
        this.mCommonClickListener = null;
        this.bfR = null;
        this.bfS = null;
        this.aHk = null;
        this.fxY = null;
        this.bfO = true;
        this.dnI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avv */
            public ConstrainImageLayout mo9if() {
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
        this.dnJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ba */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.common_color_10043));
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
        this.fxZ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fxh == null || i.this.fxh.bcr() == null || i.this.fxh.bcr().bfp())) {
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
                if (i.this.bfS != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bfS.aX(view);
                        i.this.bfS.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bk */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.fxh.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fyr.setConstrainLayoutPool(this.dnI);
        jVar.fyr.setImageViewPool(this.dnJ);
        a(jVar);
        this.fxU = getDimensionPixelSize(d.e.tbds12);
        this.fxV = getDimensionPixelSize(d.e.tbds20);
        this.fxW = getDimensionPixelSize(d.e.tbds36);
        if (jVar.fyq != null) {
            jVar.fyq.setDuiEnabled(this.bfO);
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
            postData2.wq();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bfO = z;
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
            d(jVar, postData);
            c(jVar, postData);
            g(jVar, postData);
            a(jVar, postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z) {
        if (z) {
            jVar.fyE.setVisibility(8);
            jVar.fyG.setText(d.k.expand_content);
            com.baidu.tbadk.core.util.am.c(jVar.fyH, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fyE.setVisibility(0);
        jVar.fyG.setText(d.k.close_content);
        com.baidu.tbadk.core.util.am.c(jVar.fyH, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bxQ() == 2) {
            jVar.fyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fyE.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mF(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fxh.bcr() != null && i.this.fxh.bcr().bgl() != null && i.this.fxh.bcr().getListView() != null && !z && jVar.getView().getTop() < i.this.fxh.bcr().bgl().getMeasuredHeight()) {
                        i.this.fxh.bcr().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.w.a(i.this.fxh.bcr().getListView().getData(), postData) + i.this.fxh.bcr().getListView().getHeaderViewsCount(), i.this.fxh.bcr().bgl().getMeasuredHeight());
                    }
                }
            });
            jVar.fyG.setText(this.fxw.bbd());
            jVar.fyF.setVisibility(0);
            a(jVar, postData.bxx());
            a(true, jVar, postData);
        } else {
            jVar.fyF.setVisibility(8);
            jVar.fyE.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.w.A(postData.bxz());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyF.getLayoutParams();
        if (z) {
            jVar.fyq.getLayoutStrategy().fU(0);
            if (z2) {
                jVar.fyq.getLayoutStrategy().fT(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                }
            } else {
                jVar.fyq.getLayoutStrategy().fT(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fyF.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fyq.getLayoutStrategy().fT(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fyq.getLayoutStrategy().fU(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bxE = postData.bxE();
        bxE.isChanged = true;
        jVar.fyq.setText(bxE, true, this.fxX);
    }

    private void f(PostData postData) {
        if (postData.ajd == 0 && postData.gNA) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.ah("post_id", postData.getId());
            anVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.ah("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.ah("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.ah("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.f("exposure_time", System.currentTimeMillis());
            if (this.fxh != null) {
                int bev = this.fxh.bca().bev();
                if (1 == bev || 2 == bev) {
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bev) {
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void c(j jVar, PostData postData) {
        if (postData == null || postData.bhG() == null) {
            jVar.fyy.setVisibility(8);
            return;
        }
        TbRichText bxE = postData.bxE();
        com.baidu.tieba.pb.view.d.a(postData.bhG(), jVar.fyy, false, false, bxE != null && StringUtils.isNull(bxE.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxx) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyq.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fyq.setLayoutParams(layoutParams);
            jVar.fyq.setPadding(0, 0, 0, 0);
            jVar.fyq.hX(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyq.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fyq.setLayoutParams(layoutParams2);
            jVar.fyq.hX(postData.getBimg_url());
        }
        jVar.fyq.setTextViewOnTouchListener(this.fxZ);
        jVar.fyq.setTextViewCheckSelection(false);
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
            if (postData.gNF) {
                com.baidu.tbadk.core.util.am.j(jVar.aIx, d.C0142d.cp_bg_line_c);
                jVar.aIx.setVisibility(0);
            } else {
                jVar.aIx.setVisibility(8);
            }
            jVar.fyp.setTag(null);
            jVar.fyp.setUserId(null);
            jVar.cqi.setText((CharSequence) null);
            jVar.fyv.getHeadView().setUserId(null);
            jVar.fyq.setIsHost(false);
            if (postData.vw() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.vw().getUserId())) {
                    jVar.fyq.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.vw().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.vw().getTShowInfoNew();
                if (jVar.fyx != null) {
                    jVar.fyx.setTag(d.g.tag_user_id, postData.vw().getUserId());
                    jVar.fyx.setOnClickListener(this.fxh.fvk.fIH);
                    jVar.fyx.a(iconInfo, 2, this.fxW, this.fxW, this.fxU);
                }
                if (jVar.fyw != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fyw.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fyw.setOnClickListener(this.fxh.fvk.fII);
                    jVar.fyw.a(tShowInfoNew, 3, this.fxW, this.fxW, this.fxU, true);
                }
                if (!com.baidu.tbadk.core.util.w.A(tShowInfoNew) || postData.vw().isBigV()) {
                    com.baidu.tbadk.core.util.am.c(jVar.cqi, d.C0142d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.c(jVar.cqi, d.C0142d.cp_cont_f, 1);
                }
                String portrait = postData.vw().getPortrait();
                jVar.cqi.setTag(d.g.tag_user_id, postData.vw().getUserId());
                jVar.cqi.setTag(d.g.tag_user_name, postData.vw().getUserName());
                jVar.cqi.setTag(d.g.tag_virtual_user_url, postData.vw().getVirtualUserUrl());
                String name_show = postData.vw().getName_show();
                String userName = postData.vw().getUserName();
                if (com.baidu.tbadk.o.ai.ip() && name_show != null && !name_show.equals(userName)) {
                    jVar.cqi.setText(com.baidu.tieba.pb.c.aj(this.mContext, jVar.cqi.getText().toString()));
                    jVar.cqi.setGravity(16);
                    jVar.cqi.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baD());
                    com.baidu.tbadk.core.util.am.c(jVar.cqi, d.C0142d.cp_other_e, 1);
                }
                if (postData.vw().getPendantData() != null && !StringUtils.isNull(postData.vw().getPendantData().uh())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fyv.getHeadView(), postData.vw());
                    jVar.fyp.setVisibility(8);
                    jVar.fyv.setVisibility(0);
                    jVar.fyv.getHeadView().startLoad(portrait, 28, false);
                    jVar.fyv.getHeadView().setUserId(postData.vw().getUserId());
                    jVar.fyv.getHeadView().setUserName(postData.vw().getUserName());
                    jVar.fyv.fn(postData.vw().getPendantData().uh());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fyp, postData.vw());
                    jVar.fyp.setUserId(postData.vw().getUserId());
                    jVar.fyp.setUserName(postData.vw().getUserName(), postData.bxM());
                    jVar.fyp.setTag(d.g.tag_virtual_user_url, postData.vw().getVirtualUserUrl());
                    jVar.fyp.setImageDrawable(null);
                    jVar.fyp.startLoad(portrait, 28, false);
                    jVar.fyp.setVisibility(0);
                    jVar.fyv.setVisibility(8);
                }
                if (postData.vw() != null) {
                    MetaData vw = postData.vw();
                    int i2 = postData.bxu() ? d.f.brand_official_btn : d.f.user_identity_btn;
                    int i3 = postData.bxu() ? d.C0142d.cp_link_tip_a : d.C0142d.cp_cont_j;
                    com.baidu.tbadk.core.util.am.i(jVar.fyi, i2);
                    com.baidu.tbadk.core.util.am.h(jVar.fyi, i3);
                    jVar.fyi.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(vw.getUserId())) {
                        jVar.fyi.setVisibility(0);
                        jVar.fyi.setText(d.k.host_name);
                    } else if (vw.getIs_bawu() == 1 && postData.bxu()) {
                        jVar.fyi.setVisibility(0);
                        jVar.fyi.setText(d.k.brand_Official);
                    } else if (vw.getIs_bawu() == 1 && "manager".equals(vw.getBawu_type())) {
                        jVar.fyi.setVisibility(0);
                        jVar.fyi.setText(d.k.bawu_member_bazhu_tip);
                    } else if (vw.getIs_bawu() == 1 && "assist".equals(vw.getBawu_type())) {
                        jVar.fyi.setVisibility(0);
                        jVar.fyi.setText(d.k.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fyi.setVisibility(8);
                        jVar.fyi.setTag(null);
                    }
                } else {
                    jVar.fyi.setVisibility(8);
                    jVar.fyi.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fxh.bdb()) {
                if (postData.vw() != null) {
                    i4 = postData.vw().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fyu.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(jVar.fyu, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fyu.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fyx.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fyx.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fyi.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fyw.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.vw() != null ? postData.vw().getName_show() : "";
            int hL = com.baidu.tbadk.util.x.hL(name_show2);
            if (postData.vw() != null && !StringUtils.isNull(postData.vw().getSealPrefix())) {
                if (hL > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.x.I(name_show2, i5 - 2) + "...";
                }
            } else if (hL > i5) {
                name_show2 = com.baidu.tbadk.util.x.I(name_show2, i5) + "...";
            }
            if (postData.vw() != null && !StringUtils.isNull(postData.vw().getSealPrefix())) {
                jVar.cqi.setText(ak(postData.vw().getSealPrefix(), name_show2));
            } else {
                jVar.cqi.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bxC()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.vw() != null && !StringUtils.isNull(postData.vw().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fxw != null && this.fxw.bbh() != 0) {
                if (this.fxw.bbh() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.vw() != null) {
                    String userId = postData.vw().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fxw != null && this.fxw.baV() != null && this.fxw.baV().vw() != null && postData.vw() != null) {
                String userId2 = this.fxw.baV().vw().getUserId();
                String userId3 = postData.vw().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.vw() != null && UtilHelper.isCurrentAccount(postData.vw().getUserId())) {
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
                    if (postData.bxC() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxw.bbh()));
                        if (postData.vw() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vw().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vw().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vw().getPortrait());
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vw() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vw().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vw().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vw().getName_show());
                        }
                        if (this.fxw.baV() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fxw.baV().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxw.bbh()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fyo.setTag(sparseArray);
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
            if (postData.bxC() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fyo.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fyn.a(postData.bxO(), postData.bxN(), false);
            jVar.fyn.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bxC() > 0) {
                String format = String.format(this.mContext.getString(d.k.is_floor), Integer.valueOf(postData.bxC()));
                jVar.fyt.setVisibility(0);
                jVar.fyt.setText(format);
                z = true;
            } else {
                jVar.fyt.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bxF = postData.bxF();
            boolean z2 = (bxF == null || StringUtils.isNull(bxF.getName())) ? false : true;
            if (z) {
                jVar.fyk.setVisibility(0);
                i = this.fxV;
            } else {
                jVar.fyk.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fyl.setVisibility(0);
                i2 = this.fxV;
            } else {
                jVar.fyl.setVisibility(8);
                i2 = 0;
            }
            jVar.fyj.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fyj.setText(com.baidu.tbadk.core.util.ap.x(postData.getTime()));
            } else {
                jVar.fyj.setText(com.baidu.tbadk.core.util.ap.w(postData.getTime()));
            }
            if (z2) {
                final String name = bxF.getName();
                final String lat = bxF.getLat();
                final String lng = bxF.getLng();
                jVar.fym.setVisibility(0);
                jVar.fym.setPadding(this.fxV, 0, 0, 0);
                jVar.fym.setText(bxF.getName());
                jVar.fym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.jD()) {
                                com.baidu.tbadk.browser.a.O(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(d.k.app_info_for_map)));
                            } else {
                                i.this.fxh.showToast(d.k.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fym.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyq.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fyq.setPadding(e, 0, e, 0);
            if (!this.fxx) {
                jVar.fyq.getLayoutStrategy().fQ(d.f.icon_click);
            } else {
                jVar.fyq.hX(null);
                jVar.fyq.setBackgroundDrawable(null);
                jVar.fyq.getLayoutStrategy().fQ(d.f.transparent_bg);
            }
            jVar.fyq.getLayoutStrategy().fN(d.f.pic_video);
            a(jVar.fyq, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fyq.setLayoutParams(layoutParams);
            jVar.fyq.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_link_tip_c));
            jVar.fyq.setIsFromCDN(this.mIsFromCDN);
            jVar.fyq.setText(postData.bxE(), true, this.fxX);
            SparseArray sparseArray = (SparseArray) jVar.fyq.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fyq.setTag(sparseArray);
            jVar.fyg.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ah = (ah - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fO(ah - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fP((int) (ah * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bxG() > 0 && postData.bxz() != null && postData.bxz().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fys.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fys.setLayoutParams(layoutParams);
                if (this.fxY == null) {
                    this.fxY = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fxY.setIsFromCDN(this.mIsFromCDN);
                    this.fxY.M(this.fxF);
                    String str = null;
                    if (this.fxw != null && this.fxw.baV() != null && this.fxw.baV().vw() != null) {
                        str = this.fxw.baV().vw().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fxw != null) {
                        this.fxY.B(this.fxw.bbh(), z);
                        this.fxY.X(this.fxw.baV());
                    }
                }
                this.fxY.rI(postData.getId());
                jVar.fys.setSubPbAdapter(this.fxY);
                jVar.fys.setVisibility(0);
                jVar.fys.setData(postData, view);
                jVar.fys.setChildOnClickListener(this.mCommonClickListener);
                jVar.fys.setChildOnLongClickListener(this.aHk);
                jVar.fys.setChildOnTouchListener(this.fxZ);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fys.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fys.setLayoutParams(layoutParams2);
                jVar.fys.setVisibility(8);
            }
            if (postData.gNE) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fyC != null && jVar.fyz != null) {
            if (postData == null || postData.gNH == null || StringUtils.isNull(postData.gNH.liveTitle)) {
                jVar.fyz.setVisibility(8);
                return;
            }
            jVar.fyC.setText(postData.gNH.liveTitle);
            jVar.fyz.setTag(postData.gNH);
            jVar.fyz.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.c(jVar.cqi, d.C0142d.cp_cont_f, 1);
                if (jVar.fyi.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.i(jVar.fyi, ((Integer) jVar.fyi.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.c(jVar.fyj, d.C0142d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.i(jVar.fyk, d.C0142d.cp_cont_e);
                com.baidu.tbadk.core.util.am.i(jVar.fyl, d.C0142d.cp_cont_e);
                com.baidu.tbadk.core.util.am.c(jVar.fyt, d.C0142d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.c(jVar.fym, d.C0142d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.j(jVar.mBottomLine, d.C0142d.cp_bg_line_c);
                com.baidu.tbadk.core.util.am.c(jVar.fyo, d.f.icon_floor_more_selector);
                jVar.fyq.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_cont_b));
                com.baidu.tbadk.core.util.am.j(jVar.fys, d.C0142d.cp_bg_line_e);
                jVar.fys.onChangeSkinType();
                jVar.fyr.onChangeSkinType();
                jVar.fyn.onChangeSkinType();
                com.baidu.tbadk.core.util.am.c(jVar.fyC, d.C0142d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.c(jVar.fyA, d.C0142d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.i(jVar.fyz, d.C0142d.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.i(jVar.fyB, d.C0142d.cp_cont_d);
                com.baidu.tbadk.core.util.am.c(jVar.fyD, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.h(jVar.fyG, d.C0142d.cp_cont_j);
                if (jVar.fyE.getVisibility() == 8) {
                    jVar.fyG.setText(d.k.close_content);
                    com.baidu.tbadk.core.util.am.c(jVar.fyH, d.f.icon_arrow_gray_up);
                } else if (this.fxw != null && StringUtils.isNull(this.fxw.bbd())) {
                    jVar.fyG.setText(this.fxw.bbd());
                    com.baidu.tbadk.core.util.am.c(jVar.fyH, d.f.icon_arrow_gray_down);
                } else {
                    jVar.fyG.setText(d.k.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fyg.setOnTouchListener(this.fxZ);
        jVar.fyg.setOnLongClickListener(this.aHk);
        if (this.fxh.getPageContext() != null && this.fxh.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fxh.getPageContext().getOrignalPage()).fvk;
            jVar.cqi.setOnClickListener(aVar.fIG);
            jVar.fyp.setOnClickListener(aVar.fIG);
            jVar.fyv.setOnClickListener(aVar.fIG);
            jVar.fyv.getHeadView().setOnClickListener(aVar.fIG);
            jVar.fyq.setOnLongClickListener(this.aHk);
            jVar.fyq.setOnTouchListener(this.fxZ);
            jVar.fyq.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fyq.setOnImageClickListener(this.bfR);
            jVar.fyq.setOnImageTouchListener(this.fxZ);
            jVar.fyq.setOnEmotionClickListener(aVar.fIJ);
            jVar.fyo.setOnClickListener(this.mCommonClickListener);
            jVar.fyn.setOnClickListener(this.mCommonClickListener);
            jVar.fyy.setOnClickListener(this.mCommonClickListener);
            jVar.fyz.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fxX = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxw = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jH(boolean z) {
        this.fxx = z;
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fxh.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fyq.setTextViewOnTouchListener(this.bfS);
        jVar.fyq.setTextViewCheckSelection(false);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fxF = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bfR = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bfS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }
}
