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
    private boolean bLF;
    private TbRichTextView.h bLI;
    private com.baidu.tieba.pb.a.c bLJ;
    private View.OnLongClickListener bmk;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKG;
    private com.baidu.adp.lib.e.b<TbImageView> dKH;
    private boolean fIS;
    protected com.baidu.tieba.pb.data.d fIU;
    private com.baidu.tieba.pb.pb.sub.d fIV;
    private View.OnClickListener fIX;
    private int fNQ;
    private int fNR;
    private int fNS;
    private TbRichTextView.c fNT;
    private com.baidu.tieba.pb.a.c fNU;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData cq;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bxl() && this.mCommonClickListener != null && this.fNg != null && (cq = this.fNg.cq(findViewById)) != null) {
                TiebaStatic.log(this.fNg.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 5).s("obj_id", cq.bxl() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fNQ = 0;
        this.fNR = 0;
        this.fNS = 0;
        this.fNT = null;
        this.fIS = true;
        this.mHostId = null;
        this.fIU = null;
        this.fIX = null;
        this.mCommonClickListener = null;
        this.bLI = null;
        this.bLJ = null;
        this.bmk = null;
        this.fIV = null;
        this.bLF = true;
        this.dKG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axx */
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
        this.dKH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.common_color_10043));
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
        this.fNU = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fNg == null || i.this.fNg.bbR() == null || i.this.fNg.bbR().beM())) {
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
                if (i.this.bLJ != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bLJ.cn(view);
                        i.this.bLJ.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fNg.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fOi.setConstrainLayoutPool(this.dKG);
        jVar.fOi.setImageViewPool(this.dKH);
        a(jVar);
        this.fNQ = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds12);
        this.fNR = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds20);
        this.fNS = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds36);
        if (jVar.fOh != null) {
            jVar.fOh.setDuiEnabled(this.bLF);
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
        this.bLF = z;
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
            jVar.fOv.setVisibility(0);
            jVar.fOu.setVisibility(8);
            jVar.fOx.setText(d.j.expand_content);
            com.baidu.tbadk.core.util.aj.c(jVar.fOy, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fOv.setVisibility(8);
        jVar.fOu.setVisibility(0);
        jVar.fOx.setText(d.j.close_content);
        com.baidu.tbadk.core.util.aj.c(jVar.fOy, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bxn() == 2) {
            jVar.fOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fOu.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mL(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fNg.bbR() != null && i.this.fNg.bbR().bfJ() != null && i.this.fNg.bbR().getListView() != null && !z && jVar.getView().getTop() < i.this.fNg.bbR().bfJ().getMeasuredHeight()) {
                        i.this.fNg.bbR().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fNg.bbR().getListView().getData(), postData) + i.this.fNg.bbR().getListView().getHeaderViewsCount(), i.this.fNg.bbR().bfJ().getMeasuredHeight());
                    }
                }
            });
            jVar.fOv.setClickable(true);
            jVar.fOv.setText(this.fIU.baC());
            jVar.fOw.setVisibility(0);
            a(jVar, postData.bwT());
            a(true, jVar, postData);
        } else {
            jVar.fOv.setVisibility(8);
            jVar.fOw.setVisibility(8);
            jVar.fOu.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.E(postData.bwV());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fOw.getLayoutParams();
        if (z) {
            jVar.fOh.getLayoutStrategy().iR(0);
            if (z2) {
                jVar.fOh.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds6);
                }
            } else {
                jVar.fOh.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fOw.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds22);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fOh.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fOh.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bxb = postData.bxb();
        bxb.isChanged = true;
        jVar.fOh.a(bxb, true, this.fNT);
    }

    private void g(PostData postData) {
        if (postData.aPe == 0 && postData.hbD) {
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
            jVar.fJM.setVisibility(8);
            return;
        }
        TbRichText bxb = postData.bxb();
        com.baidu.tieba.pb.view.g.a(postData.bha(), jVar.fJM, false, false, bxb != null && StringUtils.isNull(bxb.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIS) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fOh.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fOh.setLayoutParams(layoutParams);
            jVar.fOh.setPadding(0, 0, 0, 0);
            jVar.fOh.hB(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fOh.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fOh.setLayoutParams(layoutParams2);
            jVar.fOh.hB(postData.getBimg_url());
        }
        jVar.fOh.setTextViewOnTouchListener(this.fNU);
        jVar.fOh.setTextViewCheckSelection(false);
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
            if (postData.hbI) {
                com.baidu.tbadk.core.util.aj.t(jVar.boF, d.C0141d.cp_bg_line_c);
                jVar.boF.setVisibility(0);
            } else {
                jVar.boF.setVisibility(8);
            }
            jVar.fOg.setTag(null);
            jVar.fOg.setUserId(null);
            jVar.cSO.setText((CharSequence) null);
            jVar.fOm.getHeadView().setUserId(null);
            jVar.fOh.setIsHost(false);
            if (postData.zn() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zn().getUserId())) {
                    jVar.fOh.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zn().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zn().getTShowInfoNew();
                if (jVar.fOo != null) {
                    jVar.fOo.setTag(d.g.tag_user_id, postData.zn().getUserId());
                    jVar.fOo.setOnClickListener(this.fNg.fLk.fYf);
                    jVar.fOo.a(iconInfo, 2, this.fNS, this.fNS, this.fNQ);
                }
                if (jVar.fOn != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fOn.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fOn.setOnClickListener(this.fNg.fLk.fYg);
                    jVar.fOn.a(tShowInfoNew, 3, this.fNS, this.fNS, this.fNQ, true);
                }
                if (!com.baidu.tbadk.core.util.v.E(tShowInfoNew) || postData.zn().isBigV()) {
                    com.baidu.tbadk.core.util.aj.e(jVar.cSO, d.C0141d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.e(jVar.cSO, d.C0141d.cp_cont_f, 1);
                }
                String portrait = postData.zn().getPortrait();
                jVar.cSO.setTag(d.g.tag_user_id, postData.zn().getUserId());
                jVar.cSO.setTag(d.g.tag_user_name, postData.zn().getUserName());
                jVar.cSO.setTag(d.g.tag_virtual_user_url, postData.zn().getVirtualUserUrl());
                String name_show = postData.zn().getName_show();
                String userName = postData.zn().getUserName();
                if (com.baidu.tbadk.o.af.nv() && name_show != null && !name_show.equals(userName)) {
                    jVar.cSO.setText(com.baidu.tieba.pb.c.am(this.mContext, jVar.cSO.getText().toString()));
                    jVar.cSO.setGravity(16);
                    jVar.cSO.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                    com.baidu.tbadk.core.util.aj.e(jVar.cSO, d.C0141d.cp_other_e, 1);
                }
                if (postData.zn().getPendantData() != null && !StringUtils.isNull(postData.zn().getPendantData().ya())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fOm.getHeadView(), postData.zn());
                    jVar.fOg.setVisibility(8);
                    jVar.fOm.setVisibility(0);
                    jVar.fOm.getHeadView().startLoad(portrait, 28, false);
                    jVar.fOm.getHeadView().setUserId(postData.zn().getUserId());
                    jVar.fOm.getHeadView().setUserName(postData.zn().getUserName());
                    jVar.fOm.eS(postData.zn().getPendantData().ya());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fOg, postData.zn());
                    jVar.fOg.setUserId(postData.zn().getUserId());
                    jVar.fOg.ad(postData.zn().getUserName(), postData.bxj());
                    jVar.fOg.setTag(d.g.tag_virtual_user_url, postData.zn().getVirtualUserUrl());
                    jVar.fOg.setImageDrawable(null);
                    jVar.fOg.startLoad(portrait, 28, false);
                    jVar.fOg.setVisibility(0);
                    jVar.fOm.setVisibility(8);
                }
                if (postData.zn() != null) {
                    MetaData zn = postData.zn();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(zn.getUserId())) {
                        jVar.fNZ.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNZ, d.f.icon_id_louzhu);
                        jVar.fNZ.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (zn.getIs_bawu() == 1 && "manager".equals(zn.getBawu_type())) {
                        jVar.fNZ.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNZ, d.f.icon_id_bazhu);
                        jVar.fNZ.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (zn.getIs_bawu() == 1 && "assist".equals(zn.getBawu_type())) {
                        jVar.fNZ.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNZ, d.f.icon_id_xiaobazhu);
                        jVar.fNZ.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        jVar.fNZ.setVisibility(8);
                        jVar.fNZ.setTag(null);
                    }
                } else {
                    jVar.fNZ.setVisibility(8);
                    jVar.fNZ.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fNg.bcA()) {
                if (postData.zn() != null) {
                    i2 = postData.zn().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.fOl.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(jVar.fOl, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.fOl.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.fOo.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.fOo.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.fNZ.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.fOn.getChildCount() > 0) {
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
                jVar.cSO.setText(af(postData.zn().getSealPrefix(), str));
            } else {
                jVar.cSO.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwY()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.zn() != null && !StringUtils.isNull(postData.zn().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fIU != null && this.fIU.baG() != 0) {
                if (this.fIU.baG() != 1002) {
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
            if (this.fIU != null && this.fIU.bau() != null && this.fIU.bau().zn() != null && postData.zn() != null) {
                String userId2 = this.fIU.bau().zn().getUserId();
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
                    if (postData.bwY() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIU.baG()));
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
                        if (this.fIU.bau() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fIU.bau().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIU.baG()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fOf.setTag(sparseArray);
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
            if (postData.bwY() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fOf.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fOe.a(postData.bxl(), postData.bxk(), false);
            jVar.fOe.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bwY() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwY()));
                jVar.fOk.setVisibility(0);
                jVar.fOk.setText(format);
                z = true;
            } else {
                jVar.fOk.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bxc = postData.bxc();
            boolean z2 = (bxc == null || StringUtils.isNull(bxc.getName())) ? false : true;
            if (z) {
                jVar.fOb.setVisibility(0);
                i = this.fNR;
            } else {
                jVar.fOb.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fOc.setVisibility(0);
                i2 = this.fNR;
            } else {
                jVar.fOc.setVisibility(8);
                i2 = 0;
            }
            jVar.fOa.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fOa.setText(com.baidu.tbadk.core.util.am.A(postData.getTime()));
            } else {
                jVar.fOa.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            }
            if (z2) {
                final String name = bxc.getName();
                final String lat = bxc.getLat();
                final String lng = bxc.getLng();
                jVar.fOd.setVisibility(0);
                jVar.fOd.setPadding(this.fNR, 0, 0, 0);
                jVar.fOd.setText(bxc.getName());
                jVar.fOd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.oJ()) {
                                com.baidu.tbadk.browser.b.R(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                i.this.fNg.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fOd.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fOh.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fOh.setPadding(t, 0, t, 0);
            if (!this.fIS) {
                jVar.fOh.getLayoutStrategy().iN(d.f.icon_click);
            } else {
                jVar.fOh.hB(null);
                jVar.fOh.setBackgroundDrawable(null);
                jVar.fOh.getLayoutStrategy().iN(d.f.transparent_bg);
            }
            jVar.fOh.getLayoutStrategy().iK(d.f.pic_video);
            a(jVar.fOh, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fOh.setLayoutParams(layoutParams);
            jVar.fOh.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            jVar.fOh.setIsFromCDN(this.mIsFromCDN);
            jVar.fOh.a(postData.bxb(), true, this.fNT);
            SparseArray sparseArray = (SparseArray) jVar.fOh.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fOh.setTag(sparseArray);
            jVar.fJh.setTag(d.g.tag_from, sparseArray);
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
            if (postData.bxd() > 0 && postData.bwV() != null && postData.bwV().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fOj.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fOj.setLayoutParams(layoutParams);
                if (this.fIV == null) {
                    this.fIV = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIV.setIsFromCDN(this.mIsFromCDN);
                    this.fIV.H(this.fIX);
                    String str = null;
                    if (this.fIU != null && this.fIU.bau() != null && this.fIU.bau().zn() != null) {
                        str = this.fIU.bau().zn().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fIU != null) {
                        this.fIV.P(this.fIU.baG(), z);
                        this.fIV.T(this.fIU.bau());
                    }
                }
                this.fIV.qK(postData.getId());
                jVar.fOj.setSubPbAdapter(this.fIV);
                jVar.fOj.setVisibility(0);
                jVar.fOj.a(postData, view);
                jVar.fOj.setChildOnClickListener(this.mCommonClickListener);
                jVar.fOj.setChildOnLongClickListener(this.bmk);
                jVar.fOj.setChildOnTouchListener(this.fNU);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fOj.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fOj.setLayoutParams(layoutParams2);
                jVar.fOj.setVisibility(8);
            }
            if (postData.hbH) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fOs != null && jVar.fOp != null) {
            if (postData == null || postData.hbK == null || StringUtils.isNull(postData.hbK.liveTitle)) {
                jVar.fOp.setVisibility(8);
                return;
            }
            jVar.fOs.setText(postData.hbK.liveTitle);
            jVar.fOp.setTag(postData.hbK);
            jVar.fOp.setVisibility(0);
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
                com.baidu.tbadk.core.util.aj.e(jVar.cSO, d.C0141d.cp_cont_f, 1);
                if (jVar.fNZ.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(jVar.fNZ, ((Integer) jVar.fNZ.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.e(jVar.fOa, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.s(jVar.fOb, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.s(jVar.fOc, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(jVar.fOk, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.e(jVar.fOd, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.t(jVar.mBottomLine, d.C0141d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(jVar.fOf, d.f.icon_floor_more_selector);
                jVar.fOh.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.t(jVar.fOj, d.C0141d.cp_bg_line_e);
                jVar.fOj.onChangeSkinType();
                jVar.fOi.onChangeSkinType();
                jVar.fOe.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(jVar.fOs, d.C0141d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.e(jVar.fOq, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.s(jVar.fOp, d.C0141d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.s(jVar.fOr, d.C0141d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(jVar.fOt, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.aj.r(jVar.fOv, d.C0141d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.r(jVar.fOx, d.C0141d.cp_cont_j);
                if (jVar.fOu.getVisibility() == 8) {
                    jVar.fOx.setText(d.j.close_content);
                    com.baidu.tbadk.core.util.aj.c(jVar.fOy, d.f.icon_arrow_gray_up);
                } else {
                    jVar.fOx.setText(d.j.expand_content);
                    com.baidu.tbadk.core.util.aj.c(jVar.fOy, d.f.icon_arrow_gray_down);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fJh.setOnTouchListener(this.fNU);
        jVar.fJh.setOnLongClickListener(this.bmk);
        if (this.fNg.getPageContext() != null && this.fNg.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk;
            jVar.cSO.setOnClickListener(aVar.fYe);
            jVar.fOg.setOnClickListener(aVar.fYe);
            jVar.fOm.setOnClickListener(aVar.fYe);
            jVar.fOm.getHeadView().setOnClickListener(aVar.fYe);
            jVar.fOh.setOnLongClickListener(this.bmk);
            jVar.fOh.setOnTouchListener(this.fNU);
            jVar.fOh.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fOh.setOnImageClickListener(this.bLI);
            jVar.fOh.setOnImageTouchListener(this.fNU);
            jVar.fOh.setOnEmotionClickListener(aVar.fYh);
            jVar.fOf.setOnClickListener(this.mCommonClickListener);
            jVar.fOe.setOnClickListener(this.mCommonClickListener);
            jVar.fJM.setOnClickListener(this.mCommonClickListener);
            jVar.fOp.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fNT = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIU = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jU(boolean z) {
        this.fIS = z;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.j.a((Context) this.fNg.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fOh.setTextViewOnTouchListener(this.bLJ);
        jVar.fOh.setTextViewCheckSelection(false);
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
}
