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
    private View.OnLongClickListener aPP;
    private boolean bom;
    private TbRichTextView.h bop;
    private com.baidu.tieba.pb.a.c boq;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dGe;
    private com.baidu.adp.lib.e.b<TbImageView> dGf;
    private int fKC;
    private int fKD;
    private int fKE;
    private View.OnClickListener fOC;
    private TbRichTextView.c fOR;
    private com.baidu.tieba.pb.pb.sub.c fOS;
    private com.baidu.tieba.pb.a.c fOT;
    protected com.baidu.tieba.pb.data.d fOt;
    private boolean fOu;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bt;
        if (noPressedLinearLayout.findViewById(e.g.view_floor_new_praise) != null && noPressedLinearLayout.findViewById(e.g.view_floor_new_praise).getTag(e.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(e.g.view_floor_new_praise);
            if (!((PostData) findViewById.getTag(e.g.tag_clip_board)).aBr() && this.mCommonClickListener != null && this.fOe != null && (bt = this.fOe.bt(findViewById)) != null) {
                TiebaStatic.log(this.fOe.bfU().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 5).x(VideoPlayActivityConfig.OBJ_ID, bt.aBr() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fKC = 0;
        this.fKD = 0;
        this.fKE = 0;
        this.fOR = null;
        this.fOu = true;
        this.mHostId = null;
        this.fOt = null;
        this.fOC = null;
        this.mCommonClickListener = null;
        this.bop = null;
        this.boq = null;
        this.aPP = null;
        this.fOS = null;
        this.bom = true;
        this.dGe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBd */
            public ConstrainImageLayout jz() {
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
        this.dGf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ep */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds1));
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
        this.fOT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fOe == null || i.this.fOe.bfO() == null || i.this.fOe.bfO().biK())) {
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
                if (i.this.boq != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.boq.bq(view);
                        i.this.boq.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bj */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.fOe.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fPj.setConstrainLayoutPool(this.dGe);
        jVar.fPj.setImageViewPool(this.dGf);
        a(jVar);
        this.fKC = getDimensionPixelSize(e.C0200e.tbds12);
        this.fKD = getDimensionPixelSize(e.C0200e.tbds20);
        this.fKE = getDimensionPixelSize(e.C0200e.tbds36);
        if (jVar.fPi != null) {
            jVar.fPi.setDuiEnabled(this.bom);
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
            postData2.zz();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bom = z;
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
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.fPw.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.fPy.setText(e.j.expand_content);
            } else {
                jVar.fPy.setText(str);
            }
            com.baidu.tbadk.core.util.al.c(jVar.fPz, e.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fPw.setVisibility(0);
        jVar.fPy.setText(e.j.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.fPz, e.f.icon_arrow_gray_up_n);
    }

    private void b(final j jVar, final PostData postData) {
        if (postData.bBJ() == 2 || postData.bBJ() == 4) {
            jVar.fPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fPw.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.beB());
                    postData.np(z ? false : true);
                    i.this.c(jVar, postData);
                    if (i.this.fOe.bfO() != null && i.this.fOe.bfO().bjH() != null && i.this.fOe.bfO().getListView() != null && !z && jVar.getView().getTop() < i.this.fOe.bfO().bjH().getMeasuredHeight()) {
                        i.this.fOe.bfO().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fOe.bfO().getListView().getData(), postData) + i.this.fOe.bfO().getListView().getHeaderViewsCount(), i.this.fOe.bfO().bjH().getMeasuredHeight());
                    }
                }
            });
            jVar.fPx.setVisibility(0);
            a(jVar, postData.bBs(), postData.beB());
            a(true, jVar, postData);
        } else {
            jVar.fPx.setVisibility(8);
            jVar.fPw.setVisibility(0);
            a(false, jVar, postData);
        }
        c(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.I(postData.bBu());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fPx.getLayoutParams();
        if (z) {
            jVar.fPi.getLayoutStrategy().gD(0);
            if (z2) {
                jVar.fPi.getLayoutStrategy().gC(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds26);
                }
            } else {
                jVar.fPi.getLayoutStrategy().gC(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fPx.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fPi.getLayoutStrategy().gC(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds30));
        jVar.fPi.getLayoutStrategy().gD(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, PostData postData) {
        TbRichText bBz = postData.bBz();
        bBz.isChanged = true;
        jVar.fPi.setText(bBz, true, this.fOR);
    }

    private void g(PostData postData) {
        if (postData.aqK == 0 && postData.dIo) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.ax("post_id", postData.getId());
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.ax("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.ax("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.ax("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.h("exposure_time", System.currentTimeMillis());
            if (this.fOe != null) {
                int bhR = this.fOe.bfx().bhR();
                if (1 == bhR || 2 == bhR) {
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bhR) {
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.blf() == null) {
            jVar.fPq.setVisibility(8);
            return;
        }
        TbRichText bBz = postData.bBz();
        com.baidu.tieba.pb.view.c.a(postData.blf(), jVar.fPq, false, false, bBz != null && StringUtils.isNull(bBz.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fOu) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fPi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fPi.setLayoutParams(layoutParams);
            jVar.fPi.setPadding(0, 0, 0, 0);
            jVar.fPi.iI(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fPi.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0200e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0200e.ds20);
            jVar.fPi.setLayoutParams(layoutParams2);
            jVar.fPi.iI(postData.getBimg_url());
        }
        jVar.fPi.setTextViewOnTouchListener(this.fOT);
        jVar.fPi.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x06d0  */
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
            if (postData.hfc) {
                com.baidu.tbadk.core.util.al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fPh.setTag(null);
            jVar.fPh.setUserId(null);
            jVar.cIi.setText((CharSequence) null);
            jVar.fPn.getHeadView().setUserId(null);
            jVar.fPi.setIsHost(false);
            if (postData.yC() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yC().getUserId())) {
                    jVar.fPi.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.yC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.yC().getTShowInfoNew();
                if (jVar.fPp != null) {
                    jVar.fPp.setTag(e.g.tag_user_id, postData.yC().getUserId());
                    jVar.fPp.setOnClickListener(this.fOe.fMi.fZv);
                    jVar.fPp.a(iconInfo, 2, this.fKE, this.fKE, this.fKC);
                }
                if (jVar.fPo != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fPo.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fPo.setOnClickListener(this.fOe.fMi.fZw);
                    jVar.fPo.a(tShowInfoNew, 3, this.fKE, this.fKE, this.fKC, true);
                }
                if (!com.baidu.tbadk.core.util.v.I(tShowInfoNew) || postData.yC().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.cIi, e.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.cIi, e.d.cp_cont_f, 1);
                }
                String portrait = postData.yC().getPortrait();
                jVar.cIi.setTag(e.g.tag_user_id, postData.yC().getUserId());
                jVar.cIi.setTag(e.g.tag_user_name, postData.yC().getUserName());
                jVar.cIi.setTag(e.g.tag_virtual_user_url, postData.yC().getVirtualUserUrl());
                String name_show = postData.yC().getName_show();
                String userName = postData.yC().getUserName();
                if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cIi.setText(com.baidu.tieba.pb.c.aB(this.mContext, jVar.cIi.getText().toString()));
                    jVar.cIi.setGravity(16);
                    jVar.cIi.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bec());
                    com.baidu.tbadk.core.util.al.c(jVar.cIi, e.d.cp_other_e, 1);
                }
                if (postData.yC().getPendantData() != null && !StringUtils.isNull(postData.yC().getPendantData().xn())) {
                    jVar.fPn.b(postData.yC());
                    jVar.fPh.setVisibility(8);
                    jVar.fPn.setVisibility(0);
                    jVar.fPn.getHeadView().startLoad(portrait, 28, false);
                    jVar.fPn.getHeadView().setUserId(postData.yC().getUserId());
                    jVar.fPn.getHeadView().setUserName(postData.yC().getUserName());
                    jVar.fPn.getHeadView().setFid(this.fOt != null ? this.fOt.getForumId() : "");
                    jVar.fPn.getHeadView().setTid(postData.getId());
                    jVar.fPn.fT(postData.yC().getPendantData().xn());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fPh, postData.yC());
                    jVar.fPh.setUserId(postData.yC().getUserId());
                    jVar.fPh.setFid(this.fOt != null ? this.fOt.getForumId() : "");
                    jVar.fPh.setTid(postData.getId());
                    jVar.fPh.setUserName(postData.yC().getUserName(), postData.bBH());
                    jVar.fPh.setTag(e.g.tag_virtual_user_url, postData.yC().getVirtualUserUrl());
                    jVar.fPh.setImageDrawable(null);
                    jVar.fPh.startLoad(portrait, 28, false);
                    jVar.fPh.setVisibility(0);
                    jVar.fPn.setVisibility(8);
                }
                if (postData.yC() != null) {
                    MetaData yC = postData.yC();
                    int i2 = postData.bBp() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bBp() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    com.baidu.tbadk.core.util.al.i(jVar.fOZ, i2);
                    com.baidu.tbadk.core.util.al.h(jVar.fOZ, i3);
                    jVar.fOZ.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(yC.getUserId())) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.host_name);
                    } else if (yC.getIs_bawu() == 1 && postData.bBp()) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.brand_Official);
                    } else if (yC.getIs_bawu() == 1 && "manager".equals(yC.getBawu_type())) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.bawu_member_bazhu_tip);
                    } else if (yC.getIs_bawu() == 1 && "assist".equals(yC.getBawu_type())) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fOZ.setVisibility(8);
                        jVar.fOZ.setTag(null);
                    }
                } else {
                    jVar.fOZ.setVisibility(8);
                    jVar.fOZ.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fOe.bfn()) {
                if (postData.yC() != null) {
                    i4 = postData.yC().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fPm.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fPm, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fPm.setVisibility(8);
            }
            int i5 = 15;
            if (jVar.fPp.getChildCount() == 1) {
                i5 = 13;
            } else if (jVar.fPp.getChildCount() > 1) {
                i5 = 11;
            }
            if (jVar.fOZ.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fPo.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.zP() > 1000) {
                i5 -= 2;
            }
            if (postData.zP() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                jVar.fPp.setVisibility(8);
                if (jVar.fPp.getChildCount() == 1) {
                    i5 += 2;
                } else if (jVar.fPp.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && jVar.fOZ.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fOZ.setVisibility(8);
                }
                if (i5 < 10 && jVar.fPm.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fPm.setVisibility(8);
                }
            }
            String name_show2 = postData.yC() != null ? postData.yC().getName_show() : "";
            int iu = com.baidu.tbadk.util.y.iu(name_show2);
            if (postData.yC() != null && !StringUtils.isNull(postData.yC().getSealPrefix())) {
                if (iu > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.y.J(name_show2, i5 - 2) + "...";
                }
            } else if (iu > i5) {
                name_show2 = com.baidu.tbadk.util.y.J(name_show2, i5) + "...";
            }
            if (postData.yC() != null && !StringUtils.isNull(postData.yC().getSealPrefix())) {
                jVar.cIi.setText(aB(postData.yC().getSealPrefix(), name_show2));
            } else {
                jVar.cIi.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bBx()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.yC() != null && !StringUtils.isNull(postData.yC().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fOt != null && this.fOt.beF() != 0) {
                if (this.fOt.beF() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.yC() != null) {
                    String userId = postData.yC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fOt != null && this.fOt.bet() != null && this.fOt.bet().yC() != null && postData.yC() != null) {
                String userId2 = this.fOt.bet().yC().getUserId();
                String userId3 = postData.yC().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.yC() != null && UtilHelper.isCurrentAccount(postData.yC().getUserId())) {
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
                    if (postData.bBx() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fOt.beF()));
                        if (postData.yC() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yC().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yC().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yC().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yC() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yC().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.yC().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yC().getName_show());
                        }
                        if (this.fOt.bet() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fOt.bet().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fOt.beF()));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    jVar.fPi.setTag(sparseArray);
                    jVar.fPe.setTag(sparseArray);
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
            if (postData.bBx() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fPi.setTag(sparseArray);
            jVar.fPe.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fPA.a(postData);
            jVar.fPf.setTag(e.g.tag_clip_board, postData);
            jVar.fPf.setPostId(postData.getId());
            jVar.fPf.setThreadId(this.fOe.bfx().bhm());
            jVar.fPf.setObjType(1);
            jVar.fPg.setThreadId(this.fOe.bfx().bhm());
            jVar.fPg.setPostId(postData.getId());
            jVar.fPg.setObjType(1);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bBx() > 0) {
                String format = String.format(this.mContext.getString(e.j.is_floor), Integer.valueOf(postData.bBx()));
                jVar.fPl.setVisibility(0);
                jVar.fPl.setText(format);
                z = true;
            } else {
                jVar.fPl.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bBA = postData.bBA();
            boolean z2 = (bBA == null || StringUtils.isNull(bBA.getName())) ? false : true;
            if (z) {
                jVar.fPb.setVisibility(0);
                i = this.fKD;
            } else {
                jVar.fPb.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fPc.setVisibility(0);
                i2 = this.fKD;
            } else {
                jVar.fPc.setVisibility(8);
                i2 = 0;
            }
            jVar.fPa.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fPa.setText(com.baidu.tbadk.core.util.ao.G(postData.getTime()));
            } else {
                jVar.fPa.setText(com.baidu.tbadk.core.util.ao.E(postData.getTime()));
            }
            if (z2) {
                final String name = bBA.getName();
                final String lat = bBA.getLat();
                final String lng = bBA.getLng();
                jVar.fPd.setVisibility(0);
                jVar.fPd.setPadding(this.fKD, 0, 0, 0);
                jVar.fPd.setText(bBA.getName());
                jVar.fPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kV()) {
                                com.baidu.tbadk.browser.a.ac(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(e.j.app_info_for_map)));
                            } else {
                                i.this.fOe.showToast(e.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fPd.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fPi.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fPi.setPadding(h, 0, h, 0);
            if (!this.fOu) {
                jVar.fPi.getLayoutStrategy().gy(e.f.icon_click);
            } else {
                jVar.fPi.iI(null);
                jVar.fPi.setBackgroundDrawable(null);
                jVar.fPi.getLayoutStrategy().gy(e.f.transparent_bg);
            }
            jVar.fPi.getLayoutStrategy().gv(e.f.pic_video);
            a(jVar.fPi, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fPi.setLayoutParams(layoutParams);
            jVar.fPi.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            jVar.fPi.setIsFromCDN(this.mIsFromCDN);
            jVar.fPi.setText(postData.bBz(), true, this.fOR);
            SparseArray sparseArray = (SparseArray) jVar.fPi.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            jVar.fPi.setTag(sparseArray);
            jVar.fOX.setTag(e.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gw(aO - (z ? getDimensionPixelSize(e.C0200e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gx((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bBB() > 0 && postData.bBu() != null && postData.bBu().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fPk.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fPk.setLayoutParams(layoutParams);
                if (this.fOS == null) {
                    this.fOS = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fOS.setIsFromCDN(this.mIsFromCDN);
                    this.fOS.setOnLongClickListener(this.aPP);
                    this.fOS.M(this.fOC);
                    this.fOS.s(this.mCommonClickListener);
                    String str = null;
                    if (this.fOt != null && this.fOt.bet() != null && this.fOt.bet().yC() != null) {
                        str = this.fOt.bet().yC().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fOt != null) {
                        this.fOS.B(this.fOt.beF(), z);
                        this.fOS.aa(this.fOt.bet());
                    }
                }
                this.fOS.sN(postData.getId());
                jVar.fPk.setSubPbAdapter(this.fOS);
                jVar.fPk.setVisibility(0);
                jVar.fPk.setData(postData, view);
                jVar.fPk.setChildOnClickListener(this.mCommonClickListener);
                jVar.fPk.setChildOnLongClickListener(this.aPP);
                jVar.fPk.setChildOnTouchListener(this.fOT);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fPk.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fPk.setLayoutParams(layoutParams2);
                jVar.fPk.setVisibility(8);
            }
            if (postData.hfb) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fPu != null && jVar.fPr != null) {
            if (postData == null || postData.hfe == null || StringUtils.isNull(postData.hfe.liveTitle)) {
                jVar.fPr.setVisibility(8);
                return;
            }
            jVar.fPu.setText(postData.hfe.liveTitle);
            jVar.fPr.setTag(postData.hfe);
            jVar.fPr.setVisibility(0);
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
                com.baidu.tbadk.core.util.al.c(jVar.cIi, e.d.cp_cont_f, 1);
                if (jVar.fOZ.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.i(jVar.fOZ, ((Integer) jVar.fOZ.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fPa, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fPb, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fPc, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fPl, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fPd, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fPe, e.f.icon_floor_more_selector);
                jVar.fPi.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fPk, e.d.cp_bg_line_e);
                jVar.fPk.onChangeSkinType();
                jVar.fPj.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.fPu, e.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fPs, e.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fPr, e.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fPt, e.d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.fPv, e.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.fPy, e.d.cp_cont_j);
                if (jVar.fPw.getVisibility() == 8) {
                    jVar.fPy.setText(e.j.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.fPz, e.f.icon_arrow_gray_up);
                } else if (this.fOt != null && StringUtils.isNull(this.fOt.beB())) {
                    jVar.fPy.setText(this.fOt.beB());
                    com.baidu.tbadk.core.util.al.c(jVar.fPz, e.f.icon_arrow_gray_down);
                } else {
                    jVar.fPy.setText(e.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(final j jVar) {
        jVar.fOX.setOnTouchListener(this.fOT);
        jVar.fOX.setOnLongClickListener(this.aPP);
        if (this.fOe.getPageContext() != null && this.fOe.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fOe.getPageContext().getOrignalPage()).fMi;
            jVar.cIi.setOnClickListener(aVar.ebD);
            jVar.fPh.setOnClickListener(aVar.ebD);
            jVar.fPn.setOnClickListener(aVar.ebD);
            jVar.fPn.getHeadView().setOnClickListener(aVar.ebD);
            jVar.fPi.setOnLongClickListener(this.aPP);
            jVar.fPi.setOnTouchListener(this.fOT);
            jVar.fPi.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fPi.setOnImageClickListener(this.bop);
            jVar.fPi.setOnImageTouchListener(this.fOT);
            jVar.fPi.setOnEmotionClickListener(aVar.fZx);
            jVar.fPe.setOnClickListener(this.mCommonClickListener);
            jVar.fPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fPf.L(jVar.fOX);
                }
            });
            jVar.fPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fPg.L(jVar.fOX);
                }
            });
            jVar.fPq.setOnClickListener(this.mCommonClickListener);
            jVar.fPr.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fOR = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fOt = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void kw(boolean z) {
        this.fOu = z;
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fOe.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fPi.setTextViewOnTouchListener(this.boq);
        jVar.fPi.setTextViewCheckSelection(false);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fOC = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bop = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.boq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
    }
}
