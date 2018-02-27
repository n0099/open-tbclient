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
    private boolean bLC;
    private TbRichTextView.h bLF;
    private com.baidu.tieba.pb.a.c bLG;
    private View.OnLongClickListener bmh;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKB;
    private com.baidu.adp.lib.e.b<TbImageView> dKC;
    private boolean fIC;
    protected com.baidu.tieba.pb.data.d fIE;
    private com.baidu.tieba.pb.pb.sub.d fIF;
    private View.OnClickListener fIH;
    private int fNA;
    private int fNB;
    private int fNC;
    private TbRichTextView.c fND;
    private com.baidu.tieba.pb.a.c fNE;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData cq;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bxg() && this.mCommonClickListener != null && this.fMQ != null && (cq = this.fMQ.cq(findViewById)) != null) {
                TiebaStatic.log(this.fMQ.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 5).s("obj_id", cq.bxg() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fNA = 0;
        this.fNB = 0;
        this.fNC = 0;
        this.fND = null;
        this.fIC = true;
        this.mHostId = null;
        this.fIE = null;
        this.fIH = null;
        this.mCommonClickListener = null;
        this.bLF = null;
        this.bLG = null;
        this.bmh = null;
        this.fIF = null;
        this.bLC = true;
        this.dKB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axv */
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
        this.dKC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ex */
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
        this.fNE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fMQ == null || i.this.fMQ.bbQ() == null || i.this.fMQ.bbQ().beL())) {
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
                if (i.this.bLG != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bLG.cn(view);
                        i.this.bLG.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fMQ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fNS.setConstrainLayoutPool(this.dKB);
        jVar.fNS.setImageViewPool(this.dKC);
        a(jVar);
        this.fNA = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds12);
        this.fNB = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds20);
        this.fNC = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds36);
        if (jVar.fNR != null) {
            jVar.fNR.setDuiEnabled(this.bLC);
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
        this.bLC = z;
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
            jVar.fOf.setVisibility(0);
            jVar.fOe.setVisibility(8);
            jVar.fOh.setText(d.j.expand_content);
            com.baidu.tbadk.core.util.aj.c(jVar.fOi, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fOf.setVisibility(8);
        jVar.fOe.setVisibility(0);
        jVar.fOh.setText(d.j.close_content);
        com.baidu.tbadk.core.util.aj.c(jVar.fOi, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bxi() == 2) {
            jVar.fOg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fOe.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mG(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fMQ.bbQ() != null && i.this.fMQ.bbQ().bfI() != null && i.this.fMQ.bbQ().getListView() != null && !z && jVar.getView().getTop() < i.this.fMQ.bbQ().bfI().getMeasuredHeight()) {
                        i.this.fMQ.bbQ().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fMQ.bbQ().getListView().getData(), postData) + i.this.fMQ.bbQ().getListView().getHeaderViewsCount(), i.this.fMQ.bbQ().bfI().getMeasuredHeight());
                    }
                }
            });
            jVar.fOf.setClickable(true);
            jVar.fOf.setText(this.fIE.baB());
            jVar.fOg.setVisibility(0);
            a(jVar, postData.bwO());
            a(true, jVar, postData);
        } else {
            jVar.fOf.setVisibility(8);
            jVar.fOg.setVisibility(8);
            jVar.fOe.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.E(postData.bwQ());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fOg.getLayoutParams();
        if (z) {
            jVar.fNR.getLayoutStrategy().iR(0);
            if (z2) {
                jVar.fNR.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds6);
                }
            } else {
                jVar.fNR.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fOg.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds22);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fNR.getLayoutStrategy().iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fNR.getLayoutStrategy().iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bwW = postData.bwW();
        bwW.isChanged = true;
        jVar.fNR.a(bwW, true, this.fND);
    }

    private void g(PostData postData) {
        if (postData.aPd == 0 && postData.hbf) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ab("post_id", postData.getId());
            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ab("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void c(j jVar, PostData postData) {
        if (postData == null || postData.bgZ() == null) {
            jVar.fJw.setVisibility(8);
            return;
        }
        TbRichText bwW = postData.bwW();
        com.baidu.tieba.pb.view.g.a(postData.bgZ(), jVar.fJw, false, false, bwW != null && StringUtils.isNull(bwW.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIC) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNR.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fNR.setLayoutParams(layoutParams);
            jVar.fNR.setPadding(0, 0, 0, 0);
            jVar.fNR.hB(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fNR.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fNR.setLayoutParams(layoutParams2);
            jVar.fNR.hB(postData.getBimg_url());
        }
        jVar.fNR.setTextViewOnTouchListener(this.fNE);
        jVar.fNR.setTextViewCheckSelection(false);
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
            if (postData.hbk) {
                com.baidu.tbadk.core.util.aj.t(jVar.boC, d.C0141d.cp_bg_line_c);
                jVar.boC.setVisibility(0);
            } else {
                jVar.boC.setVisibility(8);
            }
            jVar.fNQ.setTag(null);
            jVar.fNQ.setUserId(null);
            jVar.cSL.setText((CharSequence) null);
            jVar.fNW.getHeadView().setUserId(null);
            jVar.fNR.setIsHost(false);
            if (postData.zn() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zn().getUserId())) {
                    jVar.fNR.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zn().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zn().getTShowInfoNew();
                if (jVar.fNY != null) {
                    jVar.fNY.setTag(d.g.tag_user_id, postData.zn().getUserId());
                    jVar.fNY.setOnClickListener(this.fMQ.fKU.fXP);
                    jVar.fNY.a(iconInfo, 2, this.fNC, this.fNC, this.fNA);
                }
                if (jVar.fNX != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fNX.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fNX.setOnClickListener(this.fMQ.fKU.fXQ);
                    jVar.fNX.a(tShowInfoNew, 3, this.fNC, this.fNC, this.fNA, true);
                }
                if (!com.baidu.tbadk.core.util.v.E(tShowInfoNew) || postData.zn().isBigV()) {
                    com.baidu.tbadk.core.util.aj.e(jVar.cSL, d.C0141d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.e(jVar.cSL, d.C0141d.cp_cont_f, 1);
                }
                String portrait = postData.zn().getPortrait();
                jVar.cSL.setTag(d.g.tag_user_id, postData.zn().getUserId());
                jVar.cSL.setTag(d.g.tag_user_name, postData.zn().getUserName());
                jVar.cSL.setTag(d.g.tag_virtual_user_url, postData.zn().getVirtualUserUrl());
                String name_show = postData.zn().getName_show();
                String userName = postData.zn().getUserName();
                if (com.baidu.tbadk.o.af.nv() && name_show != null && !name_show.equals(userName)) {
                    jVar.cSL.setText(com.baidu.tieba.pb.c.am(this.mContext, jVar.cSL.getText().toString()));
                    jVar.cSL.setGravity(16);
                    jVar.cSL.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baa());
                    com.baidu.tbadk.core.util.aj.e(jVar.cSL, d.C0141d.cp_other_e, 1);
                }
                if (postData.zn().getPendantData() != null && !StringUtils.isNull(postData.zn().getPendantData().ya())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fNW.getHeadView(), postData.zn());
                    jVar.fNQ.setVisibility(8);
                    jVar.fNW.setVisibility(0);
                    jVar.fNW.getHeadView().startLoad(portrait, 28, false);
                    jVar.fNW.getHeadView().setUserId(postData.zn().getUserId());
                    jVar.fNW.getHeadView().setUserName(postData.zn().getUserName());
                    jVar.fNW.eS(postData.zn().getPendantData().ya());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fNQ, postData.zn());
                    jVar.fNQ.setUserId(postData.zn().getUserId());
                    jVar.fNQ.ad(postData.zn().getUserName(), postData.bxe());
                    jVar.fNQ.setTag(d.g.tag_virtual_user_url, postData.zn().getVirtualUserUrl());
                    jVar.fNQ.setImageDrawable(null);
                    jVar.fNQ.startLoad(portrait, 28, false);
                    jVar.fNQ.setVisibility(0);
                    jVar.fNW.setVisibility(8);
                }
                if (postData.zn() != null) {
                    MetaData zn = postData.zn();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(zn.getUserId())) {
                        jVar.fNJ.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNJ, d.f.icon_id_louzhu);
                        jVar.fNJ.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (zn.getIs_bawu() == 1 && "manager".equals(zn.getBawu_type())) {
                        jVar.fNJ.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNJ, d.f.icon_id_bazhu);
                        jVar.fNJ.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (zn.getIs_bawu() == 1 && "assist".equals(zn.getBawu_type())) {
                        jVar.fNJ.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(jVar.fNJ, d.f.icon_id_xiaobazhu);
                        jVar.fNJ.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        jVar.fNJ.setVisibility(8);
                        jVar.fNJ.setTag(null);
                    }
                } else {
                    jVar.fNJ.setVisibility(8);
                    jVar.fNJ.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fMQ.bcz()) {
                if (postData.zn() != null) {
                    i2 = postData.zn().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.fNV.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(jVar.fNV, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.fNV.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.fNY.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.fNY.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.fNJ.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.fNX.getChildCount() > 0) {
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
                jVar.cSL.setText(af(postData.zn().getSealPrefix(), str));
            } else {
                jVar.cSL.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwT()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.zn() != null && !StringUtils.isNull(postData.zn().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fIE != null && this.fIE.baF() != 0) {
                if (this.fIE.baF() != 1002) {
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
            if (this.fIE != null && this.fIE.bat() != null && this.fIE.bat().zn() != null && postData.zn() != null) {
                String userId2 = this.fIE.bat().zn().getUserId();
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
                    if (postData.bwT() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIE.baF()));
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
                        if (this.fIE.bat() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fIE.bat().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIE.baF()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fNP.setTag(sparseArray);
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
            if (postData.bwT() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fNP.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fNO.a(postData.bxg(), postData.bxf(), false);
            jVar.fNO.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bwT() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwT()));
                jVar.fNU.setVisibility(0);
                jVar.fNU.setText(format);
                z = true;
            } else {
                jVar.fNU.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bwX = postData.bwX();
            boolean z2 = (bwX == null || StringUtils.isNull(bwX.getName())) ? false : true;
            if (z) {
                jVar.fNL.setVisibility(0);
                i = this.fNB;
            } else {
                jVar.fNL.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fNM.setVisibility(0);
                i2 = this.fNB;
            } else {
                jVar.fNM.setVisibility(8);
                i2 = 0;
            }
            jVar.fNK.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fNK.setText(com.baidu.tbadk.core.util.am.A(postData.getTime()));
            } else {
                jVar.fNK.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            }
            if (z2) {
                final String name = bwX.getName();
                final String lat = bwX.getLat();
                final String lng = bwX.getLng();
                jVar.fNN.setVisibility(0);
                jVar.fNN.setPadding(this.fNB, 0, 0, 0);
                jVar.fNN.setText(bwX.getName());
                jVar.fNN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.oJ()) {
                                com.baidu.tbadk.browser.b.R(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                i.this.fMQ.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fNN.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNR.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fNR.setPadding(t, 0, t, 0);
            if (!this.fIC) {
                jVar.fNR.getLayoutStrategy().iN(d.f.icon_click);
            } else {
                jVar.fNR.hB(null);
                jVar.fNR.setBackgroundDrawable(null);
                jVar.fNR.getLayoutStrategy().iN(d.f.transparent_bg);
            }
            jVar.fNR.getLayoutStrategy().iK(d.f.pic_video);
            a(jVar.fNR, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fNR.setLayoutParams(layoutParams);
            jVar.fNR.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            jVar.fNR.setIsFromCDN(this.mIsFromCDN);
            jVar.fNR.a(postData.bwW(), true, this.fND);
            SparseArray sparseArray = (SparseArray) jVar.fNR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fNR.setTag(sparseArray);
            jVar.fIR.setTag(d.g.tag_from, sparseArray);
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
            if (postData.bwY() > 0 && postData.bwQ() != null && postData.bwQ().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNT.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fNT.setLayoutParams(layoutParams);
                if (this.fIF == null) {
                    this.fIF = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIF.setIsFromCDN(this.mIsFromCDN);
                    this.fIF.H(this.fIH);
                    String str = null;
                    if (this.fIE != null && this.fIE.bat() != null && this.fIE.bat().zn() != null) {
                        str = this.fIE.bat().zn().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fIE != null) {
                        this.fIF.P(this.fIE.baF(), z);
                        this.fIF.T(this.fIE.bat());
                    }
                }
                this.fIF.qK(postData.getId());
                jVar.fNT.setSubPbAdapter(this.fIF);
                jVar.fNT.setVisibility(0);
                jVar.fNT.a(postData, view);
                jVar.fNT.setChildOnClickListener(this.mCommonClickListener);
                jVar.fNT.setChildOnLongClickListener(this.bmh);
                jVar.fNT.setChildOnTouchListener(this.fNE);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fNT.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fNT.setLayoutParams(layoutParams2);
                jVar.fNT.setVisibility(8);
            }
            if (postData.hbj) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fOc != null && jVar.fNZ != null) {
            if (postData == null || postData.hbm == null || StringUtils.isNull(postData.hbm.liveTitle)) {
                jVar.fNZ.setVisibility(8);
                return;
            }
            jVar.fOc.setText(postData.hbm.liveTitle);
            jVar.fNZ.setTag(postData.hbm);
            jVar.fNZ.setVisibility(0);
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
                com.baidu.tbadk.core.util.aj.e(jVar.cSL, d.C0141d.cp_cont_f, 1);
                if (jVar.fNJ.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(jVar.fNJ, ((Integer) jVar.fNJ.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.e(jVar.fNK, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.s(jVar.fNL, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.s(jVar.fNM, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(jVar.fNU, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.e(jVar.fNN, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.t(jVar.mBottomLine, d.C0141d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(jVar.fNP, d.f.icon_floor_more_selector);
                jVar.fNR.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.t(jVar.fNT, d.C0141d.cp_bg_line_e);
                jVar.fNT.onChangeSkinType();
                jVar.fNS.onChangeSkinType();
                jVar.fNO.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(jVar.fOc, d.C0141d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.e(jVar.fOa, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.s(jVar.fNZ, d.C0141d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.s(jVar.fOb, d.C0141d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(jVar.fOd, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.aj.r(jVar.fOf, d.C0141d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.r(jVar.fOh, d.C0141d.cp_cont_j);
                if (jVar.fOe.getVisibility() == 8) {
                    jVar.fOh.setText(d.j.close_content);
                    com.baidu.tbadk.core.util.aj.c(jVar.fOi, d.f.icon_arrow_gray_up);
                } else {
                    jVar.fOh.setText(d.j.expand_content);
                    com.baidu.tbadk.core.util.aj.c(jVar.fOi, d.f.icon_arrow_gray_down);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fIR.setOnTouchListener(this.fNE);
        jVar.fIR.setOnLongClickListener(this.bmh);
        if (this.fMQ.getPageContext() != null && this.fMQ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU;
            jVar.cSL.setOnClickListener(aVar.fXO);
            jVar.fNQ.setOnClickListener(aVar.fXO);
            jVar.fNW.setOnClickListener(aVar.fXO);
            jVar.fNW.getHeadView().setOnClickListener(aVar.fXO);
            jVar.fNR.setOnLongClickListener(this.bmh);
            jVar.fNR.setOnTouchListener(this.fNE);
            jVar.fNR.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fNR.setOnImageClickListener(this.bLF);
            jVar.fNR.setOnImageTouchListener(this.fNE);
            jVar.fNR.setOnEmotionClickListener(aVar.fXR);
            jVar.fNP.setOnClickListener(this.mCommonClickListener);
            jVar.fNO.setOnClickListener(this.mCommonClickListener);
            jVar.fJw.setOnClickListener(this.mCommonClickListener);
            jVar.fNZ.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fND = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIE = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jP(boolean z) {
        this.fIC = z;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.j.a((Context) this.fMQ.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fNR.setTextViewOnTouchListener(this.bLG);
        jVar.fNR.setTextViewCheckSelection(false);
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
}
