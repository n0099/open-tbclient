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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private boolean bLP;
    private TbRichTextView.h bLS;
    private com.baidu.tieba.pb.a.c bLT;
    private View.OnLongClickListener bmu;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKN;
    private com.baidu.adp.lib.e.b<TbImageView> dKO;
    private boolean fIN;
    protected com.baidu.tieba.pb.data.d fIP;
    private com.baidu.tieba.pb.pb.sub.d fIQ;
    private View.OnClickListener fIS;
    private int fNL;
    private int fNM;
    private int fNN;
    private TbRichTextView.c fNO;
    private com.baidu.tieba.pb.a.c fNP;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData cq;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bxh() && this.mCommonClickListener != null && this.fNb != null && (cq = this.fNb.cq(findViewById)) != null) {
                TiebaStatic.log(this.fNb.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 5).s("obj_id", cq.bxh() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fNL = 0;
        this.fNM = 0;
        this.fNN = 0;
        this.fNO = null;
        this.fIN = true;
        this.mHostId = null;
        this.fIP = null;
        this.fIS = null;
        this.mCommonClickListener = null;
        this.bLS = null;
        this.bLT = null;
        this.bmu = null;
        this.fIQ = null;
        this.bLP = true;
        this.dKN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axw */
            public com.baidu.tbadk.widget.layout.b nl() {
                return new com.baidu.tbadk.widget.layout.b(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b at(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b au(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.dKO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView at(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView au(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fNP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fNb == null || i.this.fNb.bbR() == null || i.this.fNb.bbR().beM())) {
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
            public boolean d(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean e(View view, MotionEvent motionEvent) {
                if (i.this.bLT != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bLT.cn(view);
                        i.this.bLT.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bo */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.fNb.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fOd.setConstrainLayoutPool(this.dKN);
        jVar.fOd.setImageViewPool(this.dKO);
        a(jVar);
        this.fNL = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds12);
        this.fNM = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds20);
        this.fNN = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds36);
        if (jVar.fOc != null) {
            jVar.fOc.setDuiEnabled(this.bLP);
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
            postData2.Ai();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bLP = z;
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
            jVar.fOq.setVisibility(0);
            jVar.fOp.setVisibility(8);
            jVar.fOs.setText(d.j.expand_content);
            com.baidu.tbadk.core.util.aj.c(jVar.fOt, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fOq.setVisibility(8);
        jVar.fOp.setVisibility(0);
        jVar.fOs.setText(d.j.close_content);
        com.baidu.tbadk.core.util.aj.c(jVar.fOt, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bxj() == 2) {
            jVar.fOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fOp.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mG(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fNb.bbR() != null && i.this.fNb.bbR().bfJ() != null && i.this.fNb.bbR().getListView() != null && !z && jVar.getView().getTop() < i.this.fNb.bbR().bfJ().getMeasuredHeight()) {
                        i.this.fNb.bbR().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fNb.bbR().getListView().getData(), postData) + i.this.fNb.bbR().getListView().getHeaderViewsCount(), i.this.fNb.bbR().bfJ().getMeasuredHeight());
                    }
                }
            });
            jVar.fOq.setClickable(true);
            jVar.fOq.setText(this.fIP.baC());
            jVar.fOr.setVisibility(0);
            a(jVar, postData.bwP());
            a(true, jVar, postData);
        } else {
            jVar.fOq.setVisibility(8);
            jVar.fOr.setVisibility(8);
            jVar.fOp.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.E(postData.bwR());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fOr.getLayoutParams();
        if (z) {
            jVar.fOc.getLayoutStrategy().iR(0);
            if (z2) {
                jVar.fOc.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds6);
                }
            } else {
                jVar.fOc.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fOr.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds22);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fOc.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fOc.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bwX = postData.bwX();
        bwX.isChanged = true;
        jVar.fOc.a(bwX, true, this.fNO);
    }

    private void g(PostData postData) {
        if (postData.aPo == 0 && postData.hbu) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ab("post_id", postData.getId());
            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ab("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void c(j jVar, PostData postData) {
        if (postData == null || postData.bha() == null) {
            jVar.fJH.setVisibility(8);
            return;
        }
        TbRichText bwX = postData.bwX();
        com.baidu.tieba.pb.view.g.a(postData.bha(), jVar.fJH, false, false, bwX != null && StringUtils.isNull(bwX.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIN) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fOc.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fOc.setLayoutParams(layoutParams);
            jVar.fOc.setPadding(0, 0, 0, 0);
            jVar.fOc.hB(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fOc.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fOc.setLayoutParams(layoutParams2);
            jVar.fOc.hB(postData.getBimg_url());
        }
        jVar.fOc.setTextViewOnTouchListener(this.fNP);
        jVar.fOc.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(j jVar, PostData postData, View view, int i) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (jVar != null && postData != null) {
            if (postData.hbz) {
                com.baidu.tbadk.core.util.aj.t(jVar.boP, d.C0140d.cp_bg_line_c);
                jVar.boP.setVisibility(0);
            } else {
                jVar.boP.setVisibility(8);
            }
            jVar.fOb.setTag(null);
            jVar.fOb.setUserId(null);
            jVar.cSX.setText((CharSequence) null);
            jVar.fOh.getHeadView().setUserId(null);
            jVar.fOc.setIsHost(false);
            if (postData.zn() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zn().getUserId())) {
                    jVar.fOc.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zn().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zn().getTShowInfoNew();
                if (jVar.fOj != null) {
                    jVar.fOj.setTag(d.g.tag_user_id, postData.zn().getUserId());
                    jVar.fOj.setOnClickListener(this.fNb.fLf.fYa);
                    jVar.fOj.a(iconInfo, 2, this.fNN, this.fNN, this.fNL);
                }
                if (jVar.fOi != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fOi.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fOi.setOnClickListener(this.fNb.fLf.fYb);
                    jVar.fOi.a(tShowInfoNew, 3, this.fNN, this.fNN, this.fNL, true);
                }
                if (!com.baidu.tbadk.core.util.v.E(tShowInfoNew) || postData.zn().isBigV()) {
                    com.baidu.tbadk.core.util.aj.e(jVar.cSX, d.C0140d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.e(jVar.cSX, d.C0140d.cp_cont_f, 1);
                }
                String portrait = postData.zn().getPortrait();
                jVar.cSX.setTag(d.g.tag_user_id, postData.zn().getUserId());
                jVar.cSX.setTag(d.g.tag_user_name, postData.zn().getUserName());
                jVar.cSX.setTag(d.g.tag_virtual_user_url, postData.zn().getVirtualUserUrl());
                String name_show = postData.zn().getName_show();
                String userName = postData.zn().getUserName();
                if (com.baidu.tbadk.o.af.nv() && name_show != null && !name_show.equals(userName)) {
                    jVar.cSX.setText(com.baidu.tieba.pb.c.am(this.mContext, jVar.cSX.getText().toString()));
                    jVar.cSX.setGravity(16);
                    jVar.cSX.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                    com.baidu.tbadk.core.util.aj.e(jVar.cSX, d.C0140d.cp_other_e, 1);
                }
                if (postData.zn().getPendantData() != null && !StringUtils.isNull(postData.zn().getPendantData().ya())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fOh.getHeadView(), postData.zn());
                    jVar.fOb.setVisibility(8);
                    jVar.fOh.setVisibility(0);
                    jVar.fOh.getHeadView().startLoad(portrait, 28, false);
                    jVar.fOh.getHeadView().setUserId(postData.zn().getUserId());
                    jVar.fOh.getHeadView().setUserName(postData.zn().getUserName());
                    jVar.fOh.eS(postData.zn().getPendantData().ya());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fOb, postData.zn());
                    jVar.fOb.setUserId(postData.zn().getUserId());
                    jVar.fOb.ad(postData.zn().getUserName(), postData.bxf());
                    jVar.fOb.setTag(d.g.tag_virtual_user_url, postData.zn().getVirtualUserUrl());
                    jVar.fOb.setImageDrawable(null);
                    jVar.fOb.startLoad(portrait, 28, false);
                    jVar.fOb.setVisibility(0);
                    jVar.fOh.setVisibility(8);
                }
                if (postData.zn() != null) {
                    MetaData zn = postData.zn();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(zn.getUserId())) {
                        jVar.fNU.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNU, d.f.icon_id_louzhu);
                        jVar.fNU.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (zn.getIs_bawu() == 1 && "manager".equals(zn.getBawu_type())) {
                        jVar.fNU.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNU, d.f.icon_id_bazhu);
                        jVar.fNU.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (zn.getIs_bawu() == 1 && "assist".equals(zn.getBawu_type())) {
                        jVar.fNU.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNU, d.f.icon_id_xiaobazhu);
                        jVar.fNU.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        jVar.fNU.setVisibility(8);
                        jVar.fNU.setTag(null);
                    }
                } else {
                    jVar.fNU.setVisibility(8);
                    jVar.fNU.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fNb.bcA()) {
                if (postData.zn() != null) {
                    i2 = postData.zn().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.fOg.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(jVar.fOg, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.fOg.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.fOj.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.fOj.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.fNU.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.fOi.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.zn().getName_show();
            int ht = com.baidu.tbadk.util.w.ht(name_show2);
            if (!StringUtils.isNull(postData.zn().getSealPrefix())) {
                if (ht > i3 - 2) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (ht > i3) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.zn().getSealPrefix())) {
                jVar.cSX.setText(af(postData.zn().getSealPrefix(), str));
            } else {
                jVar.cSX.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwU()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.zn() != null && !StringUtils.isNull(postData.zn().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fIP != null && this.fIP.baG() != 0) {
                if (this.fIP.baG() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.zn() != null) {
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
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.zn() != null && UtilHelper.isCurrentAccount(postData.zn().getUserId())) {
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
                    int i4 = 1;
                    if (postData.bwU() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIP.baG()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zn() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                        }
                        if (this.fIP.bau() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fIP.bau().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIP.baG()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fOa.setTag(sparseArray);
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
            int i42 = 1;
            if (postData.bwU() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fOa.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fNZ.a(postData.bxh(), postData.bxg(), false);
            jVar.fNZ.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bwU() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwU()));
                jVar.fOf.setVisibility(0);
                jVar.fOf.setText(format);
                z = true;
            } else {
                jVar.fOf.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bwY = postData.bwY();
            boolean z2 = (bwY == null || StringUtils.isNull(bwY.getName())) ? false : true;
            if (z) {
                jVar.fNW.setVisibility(0);
                i = this.fNM;
            } else {
                jVar.fNW.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fNX.setVisibility(0);
                i2 = this.fNM;
            } else {
                jVar.fNX.setVisibility(8);
                i2 = 0;
            }
            jVar.fNV.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fNV.setText(com.baidu.tbadk.core.util.am.A(postData.getTime()));
            } else {
                jVar.fNV.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            }
            if (z2) {
                final String name = bwY.getName();
                final String lat = bwY.getLat();
                final String lng = bwY.getLng();
                jVar.fNY.setVisibility(0);
                jVar.fNY.setPadding(this.fNM, 0, 0, 0);
                jVar.fNY.setText(bwY.getName());
                jVar.fNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.oJ()) {
                                com.baidu.tbadk.browser.b.R(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                i.this.fNb.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fNY.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fOc.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fOc.setPadding(t, 0, t, 0);
            if (!this.fIN) {
                jVar.fOc.getLayoutStrategy().iN(d.f.icon_click);
            } else {
                jVar.fOc.hB(null);
                jVar.fOc.setBackgroundDrawable(null);
                jVar.fOc.getLayoutStrategy().iN(d.f.transparent_bg);
            }
            jVar.fOc.getLayoutStrategy().iK(d.f.pic_video);
            a(jVar.fOc, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fOc.setLayoutParams(layoutParams);
            jVar.fOc.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_link_tip_c));
            jVar.fOc.setIsFromCDN(this.mIsFromCDN);
            jVar.fOc.a(postData.bwX(), true, this.fNO);
            SparseArray sparseArray = (SparseArray) jVar.fOc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fOc.setTag(sparseArray);
            jVar.fJc.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ao = (ao - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().iL(ao - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().iM((int) (ao * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bwZ() > 0 && postData.bwR() != null && postData.bwR().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fOe.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fOe.setLayoutParams(layoutParams);
                if (this.fIQ == null) {
                    this.fIQ = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIQ.setIsFromCDN(this.mIsFromCDN);
                    this.fIQ.H(this.fIS);
                    String str = null;
                    if (this.fIP != null && this.fIP.bau() != null && this.fIP.bau().zn() != null) {
                        str = this.fIP.bau().zn().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fIP != null) {
                        this.fIQ.P(this.fIP.baG(), z);
                        this.fIQ.T(this.fIP.bau());
                    }
                }
                this.fIQ.qK(postData.getId());
                jVar.fOe.setSubPbAdapter(this.fIQ);
                jVar.fOe.setVisibility(0);
                jVar.fOe.a(postData, view);
                jVar.fOe.setChildOnClickListener(this.mCommonClickListener);
                jVar.fOe.setChildOnLongClickListener(this.bmu);
                jVar.fOe.setChildOnTouchListener(this.fNP);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fOe.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fOe.setLayoutParams(layoutParams2);
                jVar.fOe.setVisibility(8);
            }
            if (postData.hby) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fOn != null && jVar.fOk != null) {
            if (postData == null || postData.hbB == null || StringUtils.isNull(postData.hbB.liveTitle)) {
                jVar.fOk.setVisibility(8);
                return;
            }
            jVar.fOn.setText(postData.hbB.liveTitle);
            jVar.fOk.setTag(postData.hbB);
            jVar.fOk.setVisibility(0);
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(akVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.e(jVar.cSX, d.C0140d.cp_cont_f, 1);
                if (jVar.fNU.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(jVar.fNU, ((Integer) jVar.fNU.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.e(jVar.fNV, d.C0140d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.s(jVar.fNW, d.C0140d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.s(jVar.fNX, d.C0140d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(jVar.fOf, d.C0140d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.e(jVar.fNY, d.C0140d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.t(jVar.mBottomLine, d.C0140d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(jVar.fOa, d.f.icon_floor_more_selector);
                jVar.fOc.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.t(jVar.fOe, d.C0140d.cp_bg_line_e);
                jVar.fOe.onChangeSkinType();
                jVar.fOd.onChangeSkinType();
                jVar.fNZ.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(jVar.fOn, d.C0140d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.e(jVar.fOl, d.C0140d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.s(jVar.fOk, d.C0140d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.s(jVar.fOm, d.C0140d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(jVar.fOo, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.aj.r(jVar.fOq, d.C0140d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.r(jVar.fOs, d.C0140d.cp_cont_j);
                if (jVar.fOp.getVisibility() == 8) {
                    jVar.fOs.setText(d.j.close_content);
                    com.baidu.tbadk.core.util.aj.c(jVar.fOt, d.f.icon_arrow_gray_up);
                } else {
                    jVar.fOs.setText(d.j.expand_content);
                    com.baidu.tbadk.core.util.aj.c(jVar.fOt, d.f.icon_arrow_gray_down);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fJc.setOnTouchListener(this.fNP);
        jVar.fJc.setOnLongClickListener(this.bmu);
        if (this.fNb.getPageContext() != null && this.fNb.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf;
            jVar.cSX.setOnClickListener(aVar.fXZ);
            jVar.fOb.setOnClickListener(aVar.fXZ);
            jVar.fOh.setOnClickListener(aVar.fXZ);
            jVar.fOh.getHeadView().setOnClickListener(aVar.fXZ);
            jVar.fOc.setOnLongClickListener(this.bmu);
            jVar.fOc.setOnTouchListener(this.fNP);
            jVar.fOc.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fOc.setOnImageClickListener(this.bLS);
            jVar.fOc.setOnImageTouchListener(this.fNP);
            jVar.fOc.setOnEmotionClickListener(aVar.fYc);
            jVar.fOa.setOnClickListener(this.mCommonClickListener);
            jVar.fNZ.setOnClickListener(this.mCommonClickListener);
            jVar.fJH.setOnClickListener(this.mCommonClickListener);
            jVar.fOk.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fNO = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIP = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jP(boolean z) {
        this.fIN = z;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.j.a((Context) this.fNb.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fOc.setTextViewOnTouchListener(this.bLT);
        jVar.fOc.setTextViewCheckSelection(false);
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
}
