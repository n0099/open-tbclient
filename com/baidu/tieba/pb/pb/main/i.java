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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private View.OnLongClickListener aHj;
    private boolean bgb;
    private TbRichTextView.h bge;
    private com.baidu.tieba.pb.a.c bgf;
    private com.baidu.adp.lib.e.b<TbImageView> dqA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqz;
    protected com.baidu.tieba.pb.data.d fxB;
    private boolean fxC;
    private View.OnClickListener fxK;
    private int fxZ;
    private int fya;
    private int fyb;
    private TbRichTextView.c fyc;
    private com.baidu.tieba.pb.pb.sub.c fyd;
    private com.baidu.tieba.pb.a.c fye;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bd;
        if (noPressedLinearLayout.findViewById(f.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(f.g.view_floor_praise).getTag(f.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(f.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(f.g.tag_clip_board)).bws() && this.mCommonClickListener != null && this.fxm != null && (bd = this.fxm.bd(findViewById)) != null) {
                TiebaStatic.log(this.fxm.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, bd.bws() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fxZ = 0;
        this.fya = 0;
        this.fyb = 0;
        this.fyc = null;
        this.fxC = true;
        this.mHostId = null;
        this.fxB = null;
        this.fxK = null;
        this.mCommonClickListener = null;
        this.bge = null;
        this.bgf = null;
        this.aHj = null;
        this.fyd = null;
        this.bgb = true;
        this.dqz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avZ */
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
        this.dqA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AO */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.am.getColor(f.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1));
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
        this.fye = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fxm == null || i.this.fxm.baF() == null || i.this.fxm.baF().bdD())) {
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
                if (i.this.bgf != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bgf.ba(view);
                        i.this.bgf.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fxm.getPageContext(), LayoutInflater.from(this.mContext).inflate(f.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fyw.setConstrainLayoutPool(this.dqz);
        jVar.fyw.setImageViewPool(this.dqA);
        a(jVar);
        this.fxZ = getDimensionPixelSize(f.e.tbds12);
        this.fya = getDimensionPixelSize(f.e.tbds20);
        this.fyb = getDimensionPixelSize(f.e.tbds36);
        if (jVar.fyv != null) {
            jVar.fyv.setDuiEnabled(this.bgb);
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
            postData2.we();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bgb = z;
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
            jVar.fyJ.setVisibility(8);
            jVar.fyL.setText(f.j.expand_content);
            com.baidu.tbadk.core.util.am.c(jVar.fyM, f.C0146f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fyJ.setVisibility(0);
        jVar.fyL.setText(f.j.close_content);
        com.baidu.tbadk.core.util.am.c(jVar.fyM, f.C0146f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bwu() == 2) {
            jVar.fyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fyJ.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mq(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fxm.baF() != null && i.this.fxm.baF().bez() != null && i.this.fxm.baF().getListView() != null && !z && jVar.getView().getTop() < i.this.fxm.baF().bez().getMeasuredHeight()) {
                        i.this.fxm.baF().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.w.a(i.this.fxm.baF().getListView().getData(), postData) + i.this.fxm.baF().getListView().getHeaderViewsCount(), i.this.fxm.baF().bez().getMeasuredHeight());
                    }
                }
            });
            jVar.fyL.setText(this.fxB.aZq());
            jVar.fyK.setVisibility(0);
            a(jVar, postData.bwb());
            a(true, jVar, postData);
        } else {
            jVar.fyK.setVisibility(8);
            jVar.fyJ.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.w.z(postData.bwd());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyK.getLayoutParams();
        if (z) {
            jVar.fyv.getLayoutStrategy().fV(0);
            if (z2) {
                jVar.fyv.getLayoutStrategy().fU(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds26);
                }
            } else {
                jVar.fyv.getLayoutStrategy().fU(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fyK.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fyv.getLayoutStrategy().fU(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds30));
        jVar.fyv.getLayoutStrategy().fV(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bwi = postData.bwi();
        bwi.isChanged = true;
        jVar.fyv.setText(bwi, true, this.fyc);
    }

    private void f(PostData postData) {
        if (postData.aiA == 0 && postData.gOA) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.ae("post_id", postData.getId());
            anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.ae("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.ae("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.ae("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.f("exposure_time", System.currentTimeMillis());
            if (this.fxm != null) {
                int bcJ = this.fxm.bao().bcJ();
                if (1 == bcJ || 2 == bcJ) {
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bcJ) {
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void c(j jVar, PostData postData) {
        if (postData == null || postData.bfU() == null) {
            jVar.fyD.setVisibility(8);
            return;
        }
        TbRichText bwi = postData.bwi();
        com.baidu.tieba.pb.view.d.a(postData.bfU(), jVar.fyD, false, false, bwi != null && StringUtils.isNull(bwi.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxC) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyv.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fyv.setLayoutParams(layoutParams);
            jVar.fyv.setPadding(0, 0, 0, 0);
            jVar.fyv.hV(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyv.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(f.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(f.e.ds20);
            jVar.fyv.setLayoutParams(layoutParams2);
            jVar.fyv.hV(postData.getBimg_url());
        }
        jVar.fyv.setTextViewOnTouchListener(this.fye);
        jVar.fyv.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0646  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x066a  */
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
            if (postData.gOF) {
                com.baidu.tbadk.core.util.am.j(jVar.mTopLine, f.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fyu.setTag(null);
            jVar.fyu.setUserId(null);
            jVar.csG.setText((CharSequence) null);
            jVar.fyA.getHeadView().setUserId(null);
            jVar.fyv.setIsHost(false);
            if (postData.vj() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.vj().getUserId())) {
                    jVar.fyv.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.vj().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.vj().getTShowInfoNew();
                if (jVar.fyC != null) {
                    jVar.fyC.setTag(f.g.tag_user_id, postData.vj().getUserId());
                    jVar.fyC.setOnClickListener(this.fxm.fvp.fIP);
                    jVar.fyC.a(iconInfo, 2, this.fyb, this.fyb, this.fxZ);
                }
                if (jVar.fyB != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fyB.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fyB.setOnClickListener(this.fxm.fvp.fIQ);
                    jVar.fyB.a(tShowInfoNew, 3, this.fyb, this.fyb, this.fxZ, true);
                }
                if (!com.baidu.tbadk.core.util.w.z(tShowInfoNew) || postData.vj().isBigV()) {
                    com.baidu.tbadk.core.util.am.c(jVar.csG, f.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.c(jVar.csG, f.d.cp_cont_f, 1);
                }
                String portrait = postData.vj().getPortrait();
                jVar.csG.setTag(f.g.tag_user_id, postData.vj().getUserId());
                jVar.csG.setTag(f.g.tag_user_name, postData.vj().getUserName());
                jVar.csG.setTag(f.g.tag_virtual_user_url, postData.vj().getVirtualUserUrl());
                String name_show = postData.vj().getName_show();
                String userName = postData.vj().getUserName();
                if (com.baidu.tbadk.p.aj.iq() && name_show != null && !name_show.equals(userName)) {
                    jVar.csG.setText(com.baidu.tieba.pb.c.al(this.mContext, jVar.csG.getText().toString()));
                    jVar.csG.setGravity(16);
                    jVar.csG.setTag(f.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYQ());
                    com.baidu.tbadk.core.util.am.c(jVar.csG, f.d.cp_other_e, 1);
                }
                if (postData.vj().getPendantData() != null && !StringUtils.isNull(postData.vj().getPendantData().tT())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fyA.getHeadView(), postData.vj());
                    jVar.fyu.setVisibility(8);
                    jVar.fyA.setVisibility(0);
                    jVar.fyA.getHeadView().startLoad(portrait, 28, false);
                    jVar.fyA.getHeadView().setUserId(postData.vj().getUserId());
                    jVar.fyA.getHeadView().setUserName(postData.vj().getUserName());
                    jVar.fyA.getHeadView().setFid(this.fxB != null ? this.fxB.getForumId() : "");
                    jVar.fyA.getHeadView().setTid(postData.getId());
                    jVar.fyA.fl(postData.vj().getPendantData().tT());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fyu, postData.vj());
                    jVar.fyu.setUserId(postData.vj().getUserId());
                    jVar.fyu.setFid(this.fxB != null ? this.fxB.getForumId() : "");
                    jVar.fyu.setTid(postData.getId());
                    jVar.fyu.setUserName(postData.vj().getUserName(), postData.bwq());
                    jVar.fyu.setTag(f.g.tag_virtual_user_url, postData.vj().getVirtualUserUrl());
                    jVar.fyu.setImageDrawable(null);
                    jVar.fyu.startLoad(portrait, 28, false);
                    jVar.fyu.setVisibility(0);
                    jVar.fyA.setVisibility(8);
                }
                if (postData.vj() != null) {
                    MetaData vj = postData.vj();
                    int i2 = postData.bvY() ? f.C0146f.brand_official_btn : f.C0146f.user_identity_btn;
                    int i3 = postData.bvY() ? f.d.cp_link_tip_a : f.d.cp_cont_j;
                    com.baidu.tbadk.core.util.am.i(jVar.fyn, i2);
                    com.baidu.tbadk.core.util.am.h(jVar.fyn, i3);
                    jVar.fyn.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(vj.getUserId())) {
                        jVar.fyn.setVisibility(0);
                        jVar.fyn.setText(f.j.host_name);
                    } else if (vj.getIs_bawu() == 1 && postData.bvY()) {
                        jVar.fyn.setVisibility(0);
                        jVar.fyn.setText(f.j.brand_Official);
                    } else if (vj.getIs_bawu() == 1 && "manager".equals(vj.getBawu_type())) {
                        jVar.fyn.setVisibility(0);
                        jVar.fyn.setText(f.j.bawu_member_bazhu_tip);
                    } else if (vj.getIs_bawu() == 1 && "assist".equals(vj.getBawu_type())) {
                        jVar.fyn.setVisibility(0);
                        jVar.fyn.setText(f.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fyn.setVisibility(8);
                        jVar.fyn.setTag(null);
                    }
                } else {
                    jVar.fyn.setVisibility(8);
                    jVar.fyn.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fxm.bbp()) {
                if (postData.vj() != null) {
                    i4 = postData.vj().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fyz.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(jVar.fyz, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fyz.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fyC.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fyC.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fyn.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fyB.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.vj() != null ? postData.vj().getName_show() : "";
            int hI = com.baidu.tbadk.util.w.hI(name_show2);
            if (postData.vj() != null && !StringUtils.isNull(postData.vj().getSealPrefix())) {
                if (hI > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.w.D(name_show2, i5 - 2) + "...";
                }
            } else if (hI > i5) {
                name_show2 = com.baidu.tbadk.util.w.D(name_show2, i5) + "...";
            }
            if (postData.vj() != null && !StringUtils.isNull(postData.vj().getSealPrefix())) {
                jVar.csG.setText(ah(postData.vj().getSealPrefix(), name_show2));
            } else {
                jVar.csG.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(f.g.tag_clip_board, postData);
            sparseArray.put(f.g.tag_load_sub_data, postData);
            sparseArray.put(f.g.tag_load_sub_view, view);
            sparseArray.put(f.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(f.g.tag_pb_floor_number, Integer.valueOf(postData.bwg()));
            sparseArray.put(f.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.vj() != null && !StringUtils.isNull(postData.vj().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fxB != null && this.fxB.aZu() != 0) {
                if (this.fxB.aZu() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.vj() != null) {
                    String userId = postData.vj().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fxB != null && this.fxB.aZi() != null && this.fxB.aZi().vj() != null && postData.vj() != null) {
                String userId2 = this.fxB.aZi().vj().getUserId();
                String userId3 = postData.vj().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.vj() != null && UtilHelper.isCurrentAccount(postData.vj().getUserId())) {
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
                    if (postData.bwg() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(f.g.tag_should_manage_visible, true);
                        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(this.fxB.aZu()));
                        if (postData.vj() != null) {
                            sparseArray.put(f.g.tag_forbid_user_name, postData.vj().getUserName());
                            sparseArray.put(f.g.tag_forbid_user_name_show, postData.vj().getName_show());
                            sparseArray.put(f.g.tag_forbid_user_portrait, postData.vj().getPortrait());
                        }
                    } else {
                        sparseArray.put(f.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(f.g.tag_user_mute_visible, true);
                        sparseArray.put(f.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vj() != null) {
                            sparseArray.put(f.g.tag_user_mute_mute_userid, postData.vj().getUserId());
                            sparseArray.put(f.g.tag_user_mute_mute_username, postData.vj().getUserName());
                            sparseArray.put(f.g.tag_user_mute_mute_nameshow, postData.vj().getName_show());
                        }
                        if (this.fxB.aZi() != null) {
                            sparseArray.put(f.g.tag_user_mute_thread_id, this.fxB.aZi().getId());
                        }
                        sparseArray.put(f.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(f.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(f.g.tag_should_delete_visible, true);
                        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(this.fxB.aZu()));
                        sparseArray.put(f.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(f.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(f.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(f.g.tag_should_delete_visible, false);
                    }
                    jVar.fyt.setTag(sparseArray);
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
            if (postData.bwg() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fyt.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fys.a(postData.bws(), postData.bwr(), false);
            jVar.fys.setTag(f.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bwg() > 0) {
                String format = String.format(this.mContext.getString(f.j.is_floor), Integer.valueOf(postData.bwg()));
                jVar.fyy.setVisibility(0);
                jVar.fyy.setText(format);
                z = true;
            } else {
                jVar.fyy.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bwj = postData.bwj();
            boolean z2 = (bwj == null || StringUtils.isNull(bwj.getName())) ? false : true;
            if (z) {
                jVar.fyp.setVisibility(0);
                i = this.fya;
            } else {
                jVar.fyp.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fyq.setVisibility(0);
                i2 = this.fya;
            } else {
                jVar.fyq.setVisibility(8);
                i2 = 0;
            }
            jVar.fyo.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fyo.setText(com.baidu.tbadk.core.util.ap.y(postData.getTime()));
            } else {
                jVar.fyo.setText(com.baidu.tbadk.core.util.ap.w(postData.getTime()));
            }
            if (z2) {
                final String name = bwj.getName();
                final String lat = bwj.getLat();
                final String lng = bwj.getLng();
                jVar.fyr.setVisibility(0);
                jVar.fyr.setPadding(this.fya, 0, 0, 0);
                jVar.fyr.setText(bwj.getName());
                jVar.fyr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.jE()) {
                                com.baidu.tbadk.browser.a.Q(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(f.j.app_info_for_map)));
                            } else {
                                i.this.fxm.showToast(f.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fyr.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyv.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int f = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fyv.setPadding(f, 0, f, 0);
            if (!this.fxC) {
                jVar.fyv.getLayoutStrategy().fQ(f.C0146f.icon_click);
            } else {
                jVar.fyv.hV(null);
                jVar.fyv.setBackgroundDrawable(null);
                jVar.fyv.getLayoutStrategy().fQ(f.C0146f.transparent_bg);
            }
            jVar.fyv.getLayoutStrategy().fN(f.C0146f.pic_video);
            a(jVar.fyv, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fyv.setLayoutParams(layoutParams);
            jVar.fyv.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_link_tip_c));
            jVar.fyv.setIsFromCDN(this.mIsFromCDN);
            jVar.fyv.setText(postData.bwi(), true, this.fyc);
            SparseArray sparseArray = (SparseArray) jVar.fyv.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(f.g.tag_clip_board, postData);
            sparseArray.put(f.g.tag_is_subpb, false);
            jVar.fyv.setTag(sparseArray);
            jVar.fyl.setTag(f.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ah = (ah - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fO(ah - (z ? getDimensionPixelSize(f.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fP((int) (ah * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bwk() > 0 && postData.bwd() != null && postData.bwd().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fyx.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fyx.setLayoutParams(layoutParams);
                if (this.fyd == null) {
                    this.fyd = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fyd.setIsFromCDN(this.mIsFromCDN);
                    this.fyd.K(this.fxK);
                    String str = null;
                    if (this.fxB != null && this.fxB.aZi() != null && this.fxB.aZi().vj() != null) {
                        str = this.fxB.aZi().vj().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fxB != null) {
                        this.fyd.A(this.fxB.aZu(), z);
                        this.fyd.Z(this.fxB.aZi());
                    }
                }
                this.fyd.rF(postData.getId());
                jVar.fyx.setSubPbAdapter(this.fyd);
                jVar.fyx.setVisibility(0);
                jVar.fyx.setData(postData, view);
                jVar.fyx.setChildOnClickListener(this.mCommonClickListener);
                jVar.fyx.setChildOnLongClickListener(this.aHj);
                jVar.fyx.setChildOnTouchListener(this.fye);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fyx.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fyx.setLayoutParams(layoutParams2);
                jVar.fyx.setVisibility(8);
            }
            if (postData.gOE) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fyH != null && jVar.fyE != null) {
            if (postData == null || postData.gOH == null || StringUtils.isNull(postData.gOH.liveTitle)) {
                jVar.fyE.setVisibility(8);
                return;
            }
            jVar.fyH.setText(postData.gOH.liveTitle);
            jVar.fyE.setTag(postData.gOH);
            jVar.fyE.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.c(jVar.csG, f.d.cp_cont_f, 1);
                if (jVar.fyn.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.i(jVar.fyn, ((Integer) jVar.fyn.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.c(jVar.fyo, f.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.i(jVar.fyp, f.d.cp_cont_e);
                com.baidu.tbadk.core.util.am.i(jVar.fyq, f.d.cp_cont_e);
                com.baidu.tbadk.core.util.am.c(jVar.fyy, f.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.c(jVar.fyr, f.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.j(jVar.mBottomLine, f.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.am.c(jVar.fyt, f.C0146f.icon_floor_more_selector);
                jVar.fyv.setTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_cont_b));
                com.baidu.tbadk.core.util.am.j(jVar.fyx, f.d.cp_bg_line_e);
                jVar.fyx.onChangeSkinType();
                jVar.fyw.onChangeSkinType();
                jVar.fys.onChangeSkinType();
                com.baidu.tbadk.core.util.am.c(jVar.fyH, f.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.c(jVar.fyF, f.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.i(jVar.fyE, f.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.i(jVar.fyG, f.d.cp_cont_d);
                com.baidu.tbadk.core.util.am.c(jVar.fyI, f.C0146f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.h(jVar.fyL, f.d.cp_cont_j);
                if (jVar.fyJ.getVisibility() == 8) {
                    jVar.fyL.setText(f.j.close_content);
                    com.baidu.tbadk.core.util.am.c(jVar.fyM, f.C0146f.icon_arrow_gray_up);
                } else if (this.fxB != null && StringUtils.isNull(this.fxB.aZq())) {
                    jVar.fyL.setText(this.fxB.aZq());
                    com.baidu.tbadk.core.util.am.c(jVar.fyM, f.C0146f.icon_arrow_gray_down);
                } else {
                    jVar.fyL.setText(f.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fyl.setOnTouchListener(this.fye);
        jVar.fyl.setOnLongClickListener(this.aHj);
        if (this.fxm.getPageContext() != null && this.fxm.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fxm.getPageContext().getOrignalPage()).fvp;
            jVar.csG.setOnClickListener(aVar.fIO);
            jVar.fyu.setOnClickListener(aVar.fIO);
            jVar.fyA.setOnClickListener(aVar.fIO);
            jVar.fyA.getHeadView().setOnClickListener(aVar.fIO);
            jVar.fyv.setOnLongClickListener(this.aHj);
            jVar.fyv.setOnTouchListener(this.fye);
            jVar.fyv.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fyv.setOnImageClickListener(this.bge);
            jVar.fyv.setOnImageTouchListener(this.fye);
            jVar.fyv.setOnEmotionClickListener(aVar.fIR);
            jVar.fyt.setOnClickListener(this.mCommonClickListener);
            jVar.fys.setOnClickListener(this.mCommonClickListener);
            jVar.fyD.setOnClickListener(this.mCommonClickListener);
            jVar.fyE.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fyc = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxB = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jt(boolean z) {
        this.fxC = z;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, f.C0146f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fxm.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fyv.setTextViewOnTouchListener(this.bgf);
        jVar.fyv.setTextViewCheckSelection(false);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fxK = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bge = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bgf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHj = onLongClickListener;
    }
}
