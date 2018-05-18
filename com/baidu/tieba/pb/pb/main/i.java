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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private boolean aWu;
    private TbRichTextView.h aWx;
    private com.baidu.tieba.pb.a.c aWy;
    private View.OnLongClickListener axX;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> deO;
    private com.baidu.adp.lib.e.b<TbImageView> deP;
    private int fiH;
    private int fiI;
    private int fiJ;
    private TbRichTextView.c fiK;
    private com.baidu.tieba.pb.pb.sub.c fiL;
    private com.baidu.tieba.pb.a.c fiM;
    protected com.baidu.tieba.pb.data.d fig;
    private boolean fih;
    private View.OnClickListener fip;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData aW;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bsj() && this.mCommonClickListener != null && this.fhQ != null && (aW = this.fhQ.aW(findViewById)) != null) {
                TiebaStatic.log(this.fhQ.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, aW.bsj() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fiH = 0;
        this.fiI = 0;
        this.fiJ = 0;
        this.fiK = null;
        this.fih = true;
        this.mHostId = null;
        this.fig = null;
        this.fip = null;
        this.mCommonClickListener = null;
        this.aWx = null;
        this.aWy = null;
        this.axX = null;
        this.fiL = null;
        this.aWu = true;
        this.deO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: arT */
            public ConstrainImageLayout fo() {
                return new ConstrainImageLayout(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout o(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout p(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.deP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xh */
            public TbImageView fo() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView o(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView p(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fiM = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                if (view2 != null && (i.this.fhQ == null || i.this.fhQ.aWO() == null || i.this.fhQ.aWO().aZJ())) {
                    if (view2 instanceof NoPressedLinearLayout) {
                        i.this.a((NoPressedLinearLayout) view2);
                    } else {
                        ViewParent parent = view2.getParent();
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
            public boolean b(View view2, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view2, MotionEvent motionEvent) {
                if (i.this.aWy != null) {
                    if (!(view2 instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.aWy.aT(view2);
                        i.this.aWy.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    i.this.mCommonClickListener.onClick(view2);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.fhQ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fje.setConstrainLayoutPool(this.deO);
        jVar.fje.setImageViewPool(this.deP);
        a(jVar);
        this.fiH = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds12);
        this.fiI = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds20);
        this.fiJ = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds36);
        if (jVar.fjd != null) {
            jVar.fjd.setDuiEnabled(this.aWu);
        }
        return jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, j jVar) {
        super.onFillViewHolder(i, view2, viewGroup, postData, jVar);
        a(jVar);
        b(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            f(postData2);
            postData2.sJ();
            a(jVar, postData2, view2, i);
        }
        return view2;
    }

    public void setDuiEnabled(boolean z) {
        this.aWu = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    private void a(j jVar, PostData postData, View view2, int i) {
        if (jVar != null && postData != null) {
            b(jVar, postData, view2, i);
            e(jVar, postData);
            a(jVar, postData, view2);
            c(jVar, postData, view2, i);
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
            jVar.fjr.setVisibility(8);
            jVar.fjt.setText(d.k.expand_content);
            com.baidu.tbadk.core.util.ak.c(jVar.fju, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fjr.setVisibility(0);
        jVar.fjt.setText(d.k.close_content);
        com.baidu.tbadk.core.util.ak.c(jVar.fju, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bsl() == 2) {
            jVar.fjs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean z = jVar.fjr.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mo(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fhQ.aWO() != null && i.this.fhQ.aWO().baF() != null && i.this.fhQ.aWO().getListView() != null && !z && jVar.getView().getTop() < i.this.fhQ.aWO().baF().getMeasuredHeight()) {
                        i.this.fhQ.aWO().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fhQ.aWO().getListView().getData(), postData) + i.this.fhQ.aWO().getListView().getHeaderViewsCount(), i.this.fhQ.aWO().baF().getMeasuredHeight());
                    }
                }
            });
            jVar.fjt.setText(this.fig.aVA());
            jVar.fjs.setVisibility(0);
            a(jVar, postData.brS());
            a(true, jVar, postData);
        } else {
            jVar.fjs.setVisibility(8);
            jVar.fjr.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.w(postData.brU());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fjs.getLayoutParams();
        if (z) {
            jVar.fjd.getLayoutStrategy().fS(0);
            if (z2) {
                jVar.fjd.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                }
            } else {
                jVar.fjd.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fjs.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fjd.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fjd.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText brZ = postData.brZ();
        brZ.isChanged = true;
        jVar.fjd.setText(brZ, true, this.fiK);
    }

    private void f(PostData postData) {
        if (postData.aaD == 0 && postData.gya) {
            com.baidu.tbadk.core.util.al alVar = new com.baidu.tbadk.core.util.al("c12203");
            alVar.ac("post_id", postData.getId());
            alVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
            alVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            alVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(alVar);
        }
    }

    private void c(j jVar, PostData postData) {
        if (postData == null || postData.bbZ() == null) {
            jVar.fjl.setVisibility(8);
            return;
        }
        TbRichText brZ = postData.brZ();
        com.baidu.tieba.pb.view.d.a(postData.bbZ(), jVar.fjl, false, false, brZ != null && StringUtils.isNull(brZ.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fih) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fjd.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fjd.setLayoutParams(layoutParams);
            jVar.fjd.setPadding(0, 0, 0, 0);
            jVar.fjd.hv(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fjd.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fjd.setLayoutParams(layoutParams2);
            jVar.fjd.hv(postData.getBimg_url());
        }
        jVar.fjd.setTextViewOnTouchListener(this.fiM);
        jVar.fjd.setTextViewCheckSelection(false);
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
    private void b(j jVar, PostData postData, View view2, int i) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (jVar != null && postData != null) {
            if (postData.gyf) {
                com.baidu.tbadk.core.util.ak.j(jVar.azf, d.C0126d.cp_bg_line_c);
                jVar.azf.setVisibility(0);
            } else {
                jVar.azf.setVisibility(8);
            }
            jVar.fjc.setTag(null);
            jVar.fjc.setUserId(null);
            jVar.cjV.setText((CharSequence) null);
            jVar.fji.getHeadView().setUserId(null);
            jVar.fjd.setIsHost(false);
            if (postData.rP() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rP().getUserId())) {
                    jVar.fjd.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.rP().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rP().getTShowInfoNew();
                if (jVar.fjk != null) {
                    jVar.fjk.setTag(d.g.tag_user_id, postData.rP().getUserId());
                    jVar.fjk.setOnClickListener(this.fhQ.ffT.ftp);
                    jVar.fjk.a(iconInfo, 2, this.fiJ, this.fiJ, this.fiH);
                }
                if (jVar.fjj != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fjj.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fjj.setOnClickListener(this.fhQ.ffT.ftq);
                    jVar.fjj.a(tShowInfoNew, 3, this.fiJ, this.fiJ, this.fiH, true);
                }
                if (!com.baidu.tbadk.core.util.v.w(tShowInfoNew) || postData.rP().isBigV()) {
                    com.baidu.tbadk.core.util.ak.c(jVar.cjV, d.C0126d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ak.c(jVar.cjV, d.C0126d.cp_cont_f, 1);
                }
                String portrait = postData.rP().getPortrait();
                jVar.cjV.setTag(d.g.tag_user_id, postData.rP().getUserId());
                jVar.cjV.setTag(d.g.tag_user_name, postData.rP().getUserName());
                jVar.cjV.setTag(d.g.tag_virtual_user_url, postData.rP().getVirtualUserUrl());
                String name_show = postData.rP().getName_show();
                String userName = postData.rP().getUserName();
                if (com.baidu.tbadk.o.af.fz() && name_show != null && !name_show.equals(userName)) {
                    jVar.cjV.setText(com.baidu.tieba.pb.c.ah(this.mContext, jVar.cjV.getText().toString()));
                    jVar.cjV.setGravity(16);
                    jVar.cjV.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                    com.baidu.tbadk.core.util.ak.c(jVar.cjV, d.C0126d.cp_other_e, 1);
                }
                if (postData.rP().getPendantData() != null && !StringUtils.isNull(postData.rP().getPendantData().qF())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fji.getHeadView(), postData.rP());
                    jVar.fjc.setVisibility(8);
                    jVar.fji.setVisibility(0);
                    jVar.fji.getHeadView().startLoad(portrait, 28, false);
                    jVar.fji.getHeadView().setUserId(postData.rP().getUserId());
                    jVar.fji.getHeadView().setUserName(postData.rP().getUserName());
                    jVar.fji.eK(postData.rP().getPendantData().qF());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fjc, postData.rP());
                    jVar.fjc.setUserId(postData.rP().getUserId());
                    jVar.fjc.setUserName(postData.rP().getUserName(), postData.bsh());
                    jVar.fjc.setTag(d.g.tag_virtual_user_url, postData.rP().getVirtualUserUrl());
                    jVar.fjc.setImageDrawable(null);
                    jVar.fjc.startLoad(portrait, 28, false);
                    jVar.fjc.setVisibility(0);
                    jVar.fji.setVisibility(8);
                }
                if (postData.rP() != null) {
                    MetaData rP = postData.rP();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rP.getUserId())) {
                        jVar.fiV.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fiV, d.f.icon_id_louzhu);
                        jVar.fiV.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (rP.getIs_bawu() == 1 && "manager".equals(rP.getBawu_type())) {
                        jVar.fiV.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fiV, d.f.icon_id_bazhu);
                        jVar.fiV.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (rP.getIs_bawu() == 1 && "assist".equals(rP.getBawu_type())) {
                        jVar.fiV.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fiV, d.f.icon_id_xiaobazhu);
                        jVar.fiV.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        jVar.fiV.setVisibility(8);
                        jVar.fiV.setTag(null);
                    }
                } else {
                    jVar.fiV.setVisibility(8);
                    jVar.fiV.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fhQ.aXy()) {
                if (postData.rP() != null) {
                    i2 = postData.rP().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.fjh.setVisibility(0);
                com.baidu.tbadk.core.util.ak.c(jVar.fjh, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.fjh.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.fjk.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.fjk.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.fiV.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.fjj.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.rP().getName_show();
            int hm = com.baidu.tbadk.util.w.hm(name_show2);
            if (!StringUtils.isNull(postData.rP().getSealPrefix())) {
                if (hm > i3 - 2) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (hm > i3) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.rP().getSealPrefix())) {
                jVar.cjV.setText(ag(postData.rP().getSealPrefix(), str));
            } else {
                jVar.cjV.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view2);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.brX()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.rP() != null && !StringUtils.isNull(postData.rP().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fig != null && this.fig.aVE() != 0) {
                if (this.fig.aVE() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.rP() != null) {
                    String userId = postData.rP().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fig != null && this.fig.aVs() != null && this.fig.aVs().rP() != null && postData.rP() != null) {
                String userId2 = this.fig.aVs().rP().getUserId();
                String userId3 = postData.rP().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.rP() != null && UtilHelper.isCurrentAccount(postData.rP().getUserId())) {
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
                    if (postData.brX() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fig.aVE()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rP().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rP() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rP().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rP().getUserName());
                        }
                        if (this.fig.aVs() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fig.aVs().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fig.aVE()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fjb.setTag(sparseArray);
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
            if (postData.brX() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fjb.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fja.a(postData.bsj(), postData.bsi(), false);
            jVar.fja.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.brX() > 0) {
                String format = String.format(this.mContext.getString(d.k.is_floor), Integer.valueOf(postData.brX()));
                jVar.fjg.setVisibility(0);
                jVar.fjg.setText(format);
                z = true;
            } else {
                jVar.fjg.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bsa = postData.bsa();
            boolean z2 = (bsa == null || StringUtils.isNull(bsa.getName())) ? false : true;
            if (z) {
                jVar.fiX.setVisibility(0);
                i = this.fiI;
            } else {
                jVar.fiX.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fiY.setVisibility(0);
                i2 = this.fiI;
            } else {
                jVar.fiY.setVisibility(8);
                i2 = 0;
            }
            jVar.fiW.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fiW.setText(com.baidu.tbadk.core.util.an.t(postData.getTime()));
            } else {
                jVar.fiW.setText(com.baidu.tbadk.core.util.an.s(postData.getTime()));
            }
            if (z2) {
                final String name = bsa.getName();
                final String lat = bsa.getLat();
                final String lng = bsa.getLng();
                jVar.fiZ.setVisibility(0);
                jVar.fiZ.setPadding(this.fiI, 0, 0, 0);
                jVar.fiZ.setText(bsa.getName());
                jVar.fiZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.gP()) {
                                com.baidu.tbadk.browser.a.M(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.k.app_info_for_map)));
                            } else {
                                i.this.fhQ.showToast(d.k.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fiZ.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view2) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fjd.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fjd.setPadding(e, 0, e, 0);
            if (!this.fih) {
                jVar.fjd.getLayoutStrategy().fO(d.f.icon_click);
            } else {
                jVar.fjd.hv(null);
                jVar.fjd.setBackgroundDrawable(null);
                jVar.fjd.getLayoutStrategy().fO(d.f.transparent_bg);
            }
            jVar.fjd.getLayoutStrategy().fL(d.f.pic_video);
            a(jVar.fjd, view2, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fjd.setLayoutParams(layoutParams);
            jVar.fjd.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            jVar.fjd.setIsFromCDN(this.mIsFromCDN);
            jVar.fjd.setText(postData.brZ(), true, this.fiK);
            SparseArray sparseArray = (SparseArray) jVar.fjd.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fjd.setTag(sparseArray);
            jVar.fiT.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view2, boolean z) {
        if (tbRichTextView != null && view2 != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                af = (af - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fM(af - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fN((int) (af * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view2, int i) {
        if (jVar != null && postData != null) {
            if (postData.bsb() > 0 && postData.brU() != null && postData.brU().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fjf.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fjf.setLayoutParams(layoutParams);
                if (this.fiL == null) {
                    this.fiL = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fiL.setIsFromCDN(this.mIsFromCDN);
                    this.fiL.I(this.fip);
                    String str = null;
                    if (this.fig != null && this.fig.aVs() != null && this.fig.aVs().rP() != null) {
                        str = this.fig.aVs().rP().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fig != null) {
                        this.fiL.B(this.fig.aVE(), z);
                        this.fiL.T(this.fig.aVs());
                    }
                }
                this.fiL.qT(postData.getId());
                jVar.fjf.setSubPbAdapter(this.fiL);
                jVar.fjf.setVisibility(0);
                jVar.fjf.setData(postData, view2);
                jVar.fjf.setChildOnClickListener(this.mCommonClickListener);
                jVar.fjf.setChildOnLongClickListener(this.axX);
                jVar.fjf.setChildOnTouchListener(this.fiM);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fjf.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fjf.setLayoutParams(layoutParams2);
                jVar.fjf.setVisibility(8);
            }
            if (postData.gye) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fjp != null && jVar.fjm != null) {
            if (postData == null || postData.gyh == null || StringUtils.isNull(postData.gyh.liveTitle)) {
                jVar.fjm.setVisibility(8);
                return;
            }
            jVar.fjp.setText(postData.gyh.liveTitle);
            jVar.fjm.setTag(postData.gyh);
            jVar.fjm.setVisibility(0);
            com.baidu.tbadk.core.util.al alVar = new com.baidu.tbadk.core.util.al("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                alVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(alVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ak.c(jVar.cjV, d.C0126d.cp_cont_f, 1);
                if (jVar.fiV.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ak.c(jVar.fiV, ((Integer) jVar.fiV.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.ak.c(jVar.fiW, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.i(jVar.fiX, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.i(jVar.fiY, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.c(jVar.fjg, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.c(jVar.fiZ, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.j(jVar.mBottomLine, d.C0126d.cp_bg_line_c);
                com.baidu.tbadk.core.util.ak.c(jVar.fjb, d.f.icon_floor_more_selector);
                jVar.fjd.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_b));
                com.baidu.tbadk.core.util.ak.j(jVar.fjf, d.C0126d.cp_bg_line_e);
                jVar.fjf.onChangeSkinType();
                jVar.fje.onChangeSkinType();
                jVar.fja.onChangeSkinType();
                com.baidu.tbadk.core.util.ak.c(jVar.fjp, d.C0126d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ak.c(jVar.fjn, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.i(jVar.fjm, d.C0126d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ak.i(jVar.fjo, d.C0126d.cp_cont_d);
                com.baidu.tbadk.core.util.ak.c(jVar.fjq, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ak.h(jVar.fjt, d.C0126d.cp_cont_j);
                if (jVar.fjr.getVisibility() == 8) {
                    jVar.fjt.setText(d.k.close_content);
                    com.baidu.tbadk.core.util.ak.c(jVar.fju, d.f.icon_arrow_gray_up);
                } else if (this.fig != null && StringUtils.isNull(this.fig.aVA())) {
                    jVar.fjt.setText(this.fig.aVA());
                    com.baidu.tbadk.core.util.ak.c(jVar.fju, d.f.icon_arrow_gray_down);
                } else {
                    jVar.fjt.setText(d.k.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fiT.setOnTouchListener(this.fiM);
        jVar.fiT.setOnLongClickListener(this.axX);
        if (this.fhQ.getPageContext() != null && this.fhQ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fhQ.getPageContext().getOrignalPage()).ffT;
            jVar.cjV.setOnClickListener(aVar.fto);
            jVar.fjc.setOnClickListener(aVar.fto);
            jVar.fji.setOnClickListener(aVar.fto);
            jVar.fji.getHeadView().setOnClickListener(aVar.fto);
            jVar.fjd.setOnLongClickListener(this.axX);
            jVar.fjd.setOnTouchListener(this.fiM);
            jVar.fjd.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fjd.setOnImageClickListener(this.aWx);
            jVar.fjd.setOnImageTouchListener(this.fiM);
            jVar.fjd.setOnEmotionClickListener(aVar.ftr);
            jVar.fjb.setOnClickListener(this.mCommonClickListener);
            jVar.fja.setOnClickListener(this.mCommonClickListener);
            jVar.fjl.setOnClickListener(this.mCommonClickListener);
            jVar.fjm.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fiK = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fig = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jr(boolean z) {
        this.fih = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fhQ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fjd.setTextViewOnTouchListener(this.aWy);
        jVar.fjd.setTextViewCheckSelection(false);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fip = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWx = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aWy = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axX = onLongClickListener;
    }
}
