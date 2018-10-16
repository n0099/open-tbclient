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
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private View.OnLongClickListener aOZ;
    private boolean bnA;
    private TbRichTextView.h bnD;
    private com.baidu.tieba.pb.a.c bnE;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dEO;
    private com.baidu.adp.lib.e.b<TbImageView> dEP;
    private int fJc;
    private int fJd;
    private int fJe;
    protected com.baidu.tieba.pb.data.d fMT;
    private boolean fMU;
    private View.OnClickListener fNc;
    private TbRichTextView.c fNr;
    private com.baidu.tieba.pb.pb.sub.c fNs;
    private com.baidu.tieba.pb.a.c fNt;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData br;
        if (noPressedLinearLayout.findViewById(e.g.view_floor_new_praise) != null && noPressedLinearLayout.findViewById(e.g.view_floor_new_praise).getTag(e.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(e.g.view_floor_new_praise);
            if (!((PostData) findViewById.getTag(e.g.tag_clip_board)).aBT() && this.mCommonClickListener != null && this.fME != null && (br = this.fME.br(findViewById)) != null) {
                TiebaStatic.log(this.fME.bgx().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 5).x(VideoPlayActivityConfig.OBJ_ID, br.aBT() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fJc = 0;
        this.fJd = 0;
        this.fJe = 0;
        this.fNr = null;
        this.fMU = true;
        this.mHostId = null;
        this.fMT = null;
        this.fNc = null;
        this.mCommonClickListener = null;
        this.bnD = null;
        this.bnE = null;
        this.aOZ = null;
        this.fNs = null;
        this.bnA = true;
        this.dEO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBF */
            public ConstrainImageLayout jB() {
                return new ConstrainImageLayout(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dEP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ef */
            public TbImageView jB() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fNt = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fME == null || i.this.fME.bgr() == null || i.this.fME.bgr().bjn())) {
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
                if (i.this.bnE != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bnE.bo(view);
                        i.this.bnE.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fME.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fNJ.setConstrainLayoutPool(this.dEO);
        jVar.fNJ.setImageViewPool(this.dEP);
        a(jVar);
        this.fJc = getDimensionPixelSize(e.C0175e.tbds12);
        this.fJd = getDimensionPixelSize(e.C0175e.tbds20);
        this.fJe = getDimensionPixelSize(e.C0175e.tbds36);
        if (jVar.fNI != null) {
            jVar.fNI.setDuiEnabled(this.bnA);
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
            g(postData2);
            postData2.zs();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bnA = z;
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
            a(jVar, postData);
            g(jVar, postData);
            b(jVar, postData);
            d(jVar, postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z) {
        if (z) {
            jVar.fNW.setVisibility(8);
            jVar.fNY.setText(e.j.expand_content);
            com.baidu.tbadk.core.util.al.c(jVar.fNZ, e.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fNW.setVisibility(0);
        jVar.fNY.setText(e.j.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.fNZ, e.f.icon_arrow_gray_up_n);
    }

    private void b(final j jVar, final PostData postData) {
        if (postData.bCn() == 2) {
            jVar.fNX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fNW.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.ne(z ? false : true);
                    i.this.c(jVar, postData);
                    if (i.this.fME.bgr() != null && i.this.fME.bgr().bkk() != null && i.this.fME.bgr().getListView() != null && !z && jVar.getView().getTop() < i.this.fME.bgr().bkk().getMeasuredHeight()) {
                        i.this.fME.bgr().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fME.bgr().getListView().getData(), postData) + i.this.fME.bgr().getListView().getHeaderViewsCount(), i.this.fME.bgr().bkk().getMeasuredHeight());
                    }
                }
            });
            jVar.fNY.setText(this.fMT.bfd());
            jVar.fNX.setVisibility(0);
            a(jVar, postData.bBW());
            a(true, jVar, postData);
        } else {
            jVar.fNX.setVisibility(8);
            jVar.fNW.setVisibility(0);
            a(false, jVar, postData);
        }
        c(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.J(postData.bBY());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fNX.getLayoutParams();
        if (z) {
            jVar.fNI.getLayoutStrategy().gp(0);
            if (z2) {
                jVar.fNI.getLayoutStrategy().go(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds26);
                }
            } else {
                jVar.fNI.getLayoutStrategy().go(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fNX.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fNI.getLayoutStrategy().go(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds30));
        jVar.fNI.getLayoutStrategy().gp(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, PostData postData) {
        TbRichText bCd = postData.bCd();
        bCd.isChanged = true;
        jVar.fNI.setText(bCd, true, this.fNr);
    }

    private void g(PostData postData) {
        if (postData.apX == 0 && postData.dGT) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.ax("post_id", postData.getId());
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.ax("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.ax("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.ax("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.h("exposure_time", System.currentTimeMillis());
            if (this.fME != null) {
                int biu = this.fME.bga().biu();
                if (1 == biu || 2 == biu) {
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == biu) {
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.blJ() == null) {
            jVar.fNQ.setVisibility(8);
            return;
        }
        TbRichText bCd = postData.bCd();
        com.baidu.tieba.pb.view.c.a(postData.blJ(), jVar.fNQ, false, false, bCd != null && StringUtils.isNull(bCd.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fMU) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fNI.setLayoutParams(layoutParams);
            jVar.fNI.setPadding(0, 0, 0, 0);
            jVar.fNI.iG(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fNI.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0175e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0175e.ds20);
            jVar.fNI.setLayoutParams(layoutParams2);
            jVar.fNI.iG(postData.getBimg_url());
        }
        jVar.fNI.setTextViewOnTouchListener(this.fNt);
        jVar.fNI.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x06d4  */
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
            if (postData.hdE) {
                com.baidu.tbadk.core.util.al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fNH.setTag(null);
            jVar.fNH.setUserId(null);
            jVar.cGZ.setText((CharSequence) null);
            jVar.fNN.getHeadView().setUserId(null);
            jVar.fNI.setIsHost(false);
            if (postData.yv() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yv().getUserId())) {
                    jVar.fNI.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.yv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.yv().getTShowInfoNew();
                if (jVar.fNP != null) {
                    jVar.fNP.setTag(e.g.tag_user_id, postData.yv().getUserId());
                    jVar.fNP.setOnClickListener(this.fME.fKI.fXV);
                    jVar.fNP.a(iconInfo, 2, this.fJe, this.fJe, this.fJc);
                }
                if (jVar.fNO != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fNO.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fNO.setOnClickListener(this.fME.fKI.fXW);
                    jVar.fNO.a(tShowInfoNew, 3, this.fJe, this.fJe, this.fJc, true);
                }
                if (!com.baidu.tbadk.core.util.v.J(tShowInfoNew) || postData.yv().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.cGZ, e.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.cGZ, e.d.cp_cont_f, 1);
                }
                String portrait = postData.yv().getPortrait();
                jVar.cGZ.setTag(e.g.tag_user_id, postData.yv().getUserId());
                jVar.cGZ.setTag(e.g.tag_user_name, postData.yv().getUserName());
                jVar.cGZ.setTag(e.g.tag_virtual_user_url, postData.yv().getVirtualUserUrl());
                String name_show = postData.yv().getName_show();
                String userName = postData.yv().getUserName();
                if (com.baidu.tbadk.p.am.jL() && name_show != null && !name_show.equals(userName)) {
                    jVar.cGZ.setText(com.baidu.tieba.pb.c.aD(this.mContext, jVar.cGZ.getText().toString()));
                    jVar.cGZ.setGravity(16);
                    jVar.cGZ.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.beD());
                    com.baidu.tbadk.core.util.al.c(jVar.cGZ, e.d.cp_other_e, 1);
                }
                if (postData.yv().getPendantData() != null && !StringUtils.isNull(postData.yv().getPendantData().xf())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fNN.getHeadView(), postData.yv());
                    jVar.fNH.setVisibility(8);
                    jVar.fNN.setVisibility(0);
                    jVar.fNN.getHeadView().startLoad(portrait, 28, false);
                    jVar.fNN.getHeadView().setUserId(postData.yv().getUserId());
                    jVar.fNN.getHeadView().setUserName(postData.yv().getUserName());
                    jVar.fNN.getHeadView().setFid(this.fMT != null ? this.fMT.getForumId() : "");
                    jVar.fNN.getHeadView().setTid(postData.getId());
                    jVar.fNN.fT(postData.yv().getPendantData().xf());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fNH, postData.yv());
                    jVar.fNH.setUserId(postData.yv().getUserId());
                    jVar.fNH.setFid(this.fMT != null ? this.fMT.getForumId() : "");
                    jVar.fNH.setTid(postData.getId());
                    jVar.fNH.setUserName(postData.yv().getUserName(), postData.bCl());
                    jVar.fNH.setTag(e.g.tag_virtual_user_url, postData.yv().getVirtualUserUrl());
                    jVar.fNH.setImageDrawable(null);
                    jVar.fNH.startLoad(portrait, 28, false);
                    jVar.fNH.setVisibility(0);
                    jVar.fNN.setVisibility(8);
                }
                if (postData.yv() != null) {
                    MetaData yv = postData.yv();
                    int i2 = postData.bBT() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bBT() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    com.baidu.tbadk.core.util.al.i(jVar.fNz, i2);
                    com.baidu.tbadk.core.util.al.h(jVar.fNz, i3);
                    jVar.fNz.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(yv.getUserId())) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.host_name);
                    } else if (yv.getIs_bawu() == 1 && postData.bBT()) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.brand_Official);
                    } else if (yv.getIs_bawu() == 1 && "manager".equals(yv.getBawu_type())) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.bawu_member_bazhu_tip);
                    } else if (yv.getIs_bawu() == 1 && "assist".equals(yv.getBawu_type())) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fNz.setVisibility(8);
                        jVar.fNz.setTag(null);
                    }
                } else {
                    jVar.fNz.setVisibility(8);
                    jVar.fNz.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fME.bfQ()) {
                if (postData.yv() != null) {
                    i4 = postData.yv().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fNM.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fNM, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fNM.setVisibility(8);
            }
            int i5 = 15;
            if (jVar.fNP.getChildCount() == 1) {
                i5 = 13;
            } else if (jVar.fNP.getChildCount() > 1) {
                i5 = 11;
            }
            if (jVar.fNz.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fNO.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.zI() > 1000) {
                i5 -= 2;
            }
            if (postData.zI() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                jVar.fNP.setVisibility(8);
                if (jVar.fNP.getChildCount() == 1) {
                    i5 += 2;
                } else if (jVar.fNP.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && jVar.fNz.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fNz.setVisibility(8);
                }
                if (i5 < 10 && jVar.fNM.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fNM.setVisibility(8);
                }
            }
            String name_show2 = postData.yv() != null ? postData.yv().getName_show() : "";
            int it = com.baidu.tbadk.util.y.it(name_show2);
            if (postData.yv() != null && !StringUtils.isNull(postData.yv().getSealPrefix())) {
                if (it > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.y.J(name_show2, i5 - 2) + "...";
                }
            } else if (it > i5) {
                name_show2 = com.baidu.tbadk.util.y.J(name_show2, i5) + "...";
            }
            if (postData.yv() != null && !StringUtils.isNull(postData.yv().getSealPrefix())) {
                jVar.cGZ.setText(aB(postData.yv().getSealPrefix(), name_show2));
            } else {
                jVar.cGZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bCb()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.yv() != null && !StringUtils.isNull(postData.yv().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fMT != null && this.fMT.bfh() != 0) {
                if (this.fMT.bfh() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.yv() != null) {
                    String userId = postData.yv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fMT != null && this.fMT.beV() != null && this.fMT.beV().yv() != null && postData.yv() != null) {
                String userId2 = this.fMT.beV().yv().getUserId();
                String userId3 = postData.yv().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.yv() != null && UtilHelper.isCurrentAccount(postData.yv().getUserId())) {
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
                    if (postData.bCb() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fMT.bfh()));
                        if (postData.yv() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yv().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yv().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yv().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yv() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yv().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.yv().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yv().getName_show());
                        }
                        if (this.fMT.beV() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fMT.beV().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fMT.bfh()));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    jVar.fNI.setTag(sparseArray);
                    jVar.fNE.setTag(sparseArray);
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
            if (postData.bCb() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fNI.setTag(sparseArray);
            jVar.fNE.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fOa.a(postData);
            jVar.fNF.setTag(e.g.tag_clip_board, postData);
            jVar.fNF.setPostId(postData.getId());
            jVar.fNF.setThreadId(this.fME.bga().bhP());
            jVar.fNF.setObjType(1);
            jVar.fNG.setThreadId(this.fME.bga().bhP());
            jVar.fNG.setPostId(postData.getId());
            jVar.fNG.setObjType(1);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bCb() > 0) {
                String format = String.format(this.mContext.getString(e.j.is_floor), Integer.valueOf(postData.bCb()));
                jVar.fNL.setVisibility(0);
                jVar.fNL.setText(format);
                z = true;
            } else {
                jVar.fNL.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bCe = postData.bCe();
            boolean z2 = (bCe == null || StringUtils.isNull(bCe.getName())) ? false : true;
            if (z) {
                jVar.fNB.setVisibility(0);
                i = this.fJd;
            } else {
                jVar.fNB.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fNC.setVisibility(0);
                i2 = this.fJd;
            } else {
                jVar.fNC.setVisibility(8);
                i2 = 0;
            }
            jVar.fNA.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fNA.setText(com.baidu.tbadk.core.util.ao.E(postData.getTime()));
            } else {
                jVar.fNA.setText(com.baidu.tbadk.core.util.ao.C(postData.getTime()));
            }
            if (z2) {
                final String name = bCe.getName();
                final String lat = bCe.getLat();
                final String lng = bCe.getLng();
                jVar.fND.setVisibility(0);
                jVar.fND.setPadding(this.fJd, 0, 0, 0);
                jVar.fND.setText(bCe.getName());
                jVar.fND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kX()) {
                                com.baidu.tbadk.browser.a.ae(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(e.j.app_info_for_map)));
                            } else {
                                i.this.fME.showToast(e.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fND.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fNI.setPadding(h, 0, h, 0);
            if (!this.fMU) {
                jVar.fNI.getLayoutStrategy().gk(e.f.icon_click);
            } else {
                jVar.fNI.iG(null);
                jVar.fNI.setBackgroundDrawable(null);
                jVar.fNI.getLayoutStrategy().gk(e.f.transparent_bg);
            }
            jVar.fNI.getLayoutStrategy().gh(e.f.pic_video);
            a(jVar.fNI, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fNI.setLayoutParams(layoutParams);
            jVar.fNI.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            jVar.fNI.setIsFromCDN(this.mIsFromCDN);
            jVar.fNI.setText(postData.bCd(), true, this.fNr);
            SparseArray sparseArray = (SparseArray) jVar.fNI.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            jVar.fNI.setTag(sparseArray);
            jVar.fNx.setTag(e.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gi(aO - (z ? getDimensionPixelSize(e.C0175e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gj((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bCf() > 0 && postData.bBY() != null && postData.bBY().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNK.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fNK.setLayoutParams(layoutParams);
                if (this.fNs == null) {
                    this.fNs = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fNs.setIsFromCDN(this.mIsFromCDN);
                    this.fNs.setOnLongClickListener(this.aOZ);
                    this.fNs.K(this.fNc);
                    this.fNs.q(this.mCommonClickListener);
                    String str = null;
                    if (this.fMT != null && this.fMT.beV() != null && this.fMT.beV().yv() != null) {
                        str = this.fMT.beV().yv().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fMT != null) {
                        this.fNs.B(this.fMT.bfh(), z);
                        this.fNs.aa(this.fMT.beV());
                    }
                }
                this.fNs.sM(postData.getId());
                jVar.fNK.setSubPbAdapter(this.fNs);
                jVar.fNK.setVisibility(0);
                jVar.fNK.setData(postData, view);
                jVar.fNK.setChildOnClickListener(this.mCommonClickListener);
                jVar.fNK.setChildOnLongClickListener(this.aOZ);
                jVar.fNK.setChildOnTouchListener(this.fNt);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fNK.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fNK.setLayoutParams(layoutParams2);
                jVar.fNK.setVisibility(8);
            }
            if (postData.hdD) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fNU != null && jVar.fNR != null) {
            if (postData == null || postData.hdG == null || StringUtils.isNull(postData.hdG.liveTitle)) {
                jVar.fNR.setVisibility(8);
                return;
            }
            jVar.fNU.setText(postData.hdG.liveTitle);
            jVar.fNR.setTag(postData.hdG);
            jVar.fNR.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.c(jVar.cGZ, e.d.cp_cont_f, 1);
                if (jVar.fNz.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.i(jVar.fNz, ((Integer) jVar.fNz.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fNA, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fNB, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fNC, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fNL, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fND, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fNE, e.f.icon_floor_more_selector);
                jVar.fNI.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fNK, e.d.cp_bg_line_e);
                jVar.fNK.onChangeSkinType();
                jVar.fNJ.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.fNU, e.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fNS, e.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fNR, e.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fNT, e.d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.fNV, e.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.fNY, e.d.cp_cont_j);
                if (jVar.fNW.getVisibility() == 8) {
                    jVar.fNY.setText(e.j.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.fNZ, e.f.icon_arrow_gray_up);
                } else if (this.fMT != null && StringUtils.isNull(this.fMT.bfd())) {
                    jVar.fNY.setText(this.fMT.bfd());
                    com.baidu.tbadk.core.util.al.c(jVar.fNZ, e.f.icon_arrow_gray_down);
                } else {
                    jVar.fNY.setText(e.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(final j jVar) {
        jVar.fNx.setOnTouchListener(this.fNt);
        jVar.fNx.setOnLongClickListener(this.aOZ);
        if (this.fME.getPageContext() != null && this.fME.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fME.getPageContext().getOrignalPage()).fKI;
            jVar.cGZ.setOnClickListener(aVar.eaj);
            jVar.fNH.setOnClickListener(aVar.eaj);
            jVar.fNN.setOnClickListener(aVar.eaj);
            jVar.fNN.getHeadView().setOnClickListener(aVar.eaj);
            jVar.fNI.setOnLongClickListener(this.aOZ);
            jVar.fNI.setOnTouchListener(this.fNt);
            jVar.fNI.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fNI.setOnImageClickListener(this.bnD);
            jVar.fNI.setOnImageTouchListener(this.fNt);
            jVar.fNI.setOnEmotionClickListener(aVar.fXX);
            jVar.fNE.setOnClickListener(this.mCommonClickListener);
            jVar.fNF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fNF.L(jVar.fNx);
                }
            });
            jVar.fNG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fNG.L(jVar.fNx);
                }
            });
            jVar.fNQ.setOnClickListener(this.mCommonClickListener);
            jVar.fNR.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fNr = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fMT = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void kl(boolean z) {
        this.fMU = z;
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fME.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fNI.setTextViewOnTouchListener(this.bnE);
        jVar.fNI.setTextViewCheckSelection(false);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fNc = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bnD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bnE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
    }
}
