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
    private boolean aWt;
    private TbRichTextView.h aWw;
    private com.baidu.tieba.pb.a.c aWx;
    private View.OnLongClickListener axW;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ddJ;
    private com.baidu.adp.lib.e.b<TbImageView> ddK;
    private int fhB;
    private int fhC;
    private int fhD;
    private TbRichTextView.c fhE;
    private com.baidu.tieba.pb.pb.sub.c fhF;
    private com.baidu.tieba.pb.a.c fhG;
    protected com.baidu.tieba.pb.data.d fhb;
    private boolean fhc;
    private View.OnClickListener fhk;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData aW;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bsl() && this.mCommonClickListener != null && this.fgM != null && (aW = this.fgM.aW(findViewById)) != null) {
                TiebaStatic.log(this.fgM.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, aW.bsl() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fhB = 0;
        this.fhC = 0;
        this.fhD = 0;
        this.fhE = null;
        this.fhc = true;
        this.mHostId = null;
        this.fhb = null;
        this.fhk = null;
        this.mCommonClickListener = null;
        this.aWw = null;
        this.aWx = null;
        this.axW = null;
        this.fhF = null;
        this.aWt = true;
        this.ddJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: arU */
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
        this.ddK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xi */
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
        this.fhG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                if (view2 != null && (i.this.fgM == null || i.this.fgM.aWO() == null || i.this.fgM.aWO().aZJ())) {
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
                if (i.this.aWx != null) {
                    if (!(view2 instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.aWx.aT(view2);
                        i.this.aWx.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fgM.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fhY.setConstrainLayoutPool(this.ddJ);
        jVar.fhY.setImageViewPool(this.ddK);
        a(jVar);
        this.fhB = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds12);
        this.fhC = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds20);
        this.fhD = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds36);
        if (jVar.fhX != null) {
            jVar.fhX.setDuiEnabled(this.aWt);
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
            postData2.sK();
            a(jVar, postData2, view2, i);
        }
        return view2;
    }

    public void setDuiEnabled(boolean z) {
        this.aWt = z;
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
            jVar.fim.setVisibility(8);
            jVar.fio.setText(d.k.expand_content);
            com.baidu.tbadk.core.util.ak.c(jVar.fip, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fim.setVisibility(0);
        jVar.fio.setText(d.k.close_content);
        com.baidu.tbadk.core.util.ak.c(jVar.fip, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bsn() == 2) {
            jVar.fin.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean z = jVar.fim.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mn(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fgM.aWO() != null && i.this.fgM.aWO().baF() != null && i.this.fgM.aWO().getListView() != null && !z && jVar.getView().getTop() < i.this.fgM.aWO().baF().getMeasuredHeight()) {
                        i.this.fgM.aWO().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fgM.aWO().getListView().getData(), postData) + i.this.fgM.aWO().getListView().getHeaderViewsCount(), i.this.fgM.aWO().baF().getMeasuredHeight());
                    }
                }
            });
            jVar.fio.setText(this.fhb.aVA());
            jVar.fin.setVisibility(0);
            a(jVar, postData.brU());
            a(true, jVar, postData);
        } else {
            jVar.fin.setVisibility(8);
            jVar.fim.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.w(postData.brW());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fin.getLayoutParams();
        if (z) {
            jVar.fhX.getLayoutStrategy().fS(0);
            if (z2) {
                jVar.fhX.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                }
            } else {
                jVar.fhX.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fin.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fhX.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fhX.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bsb = postData.bsb();
        bsb.isChanged = true;
        jVar.fhX.setText(bsb, true, this.fhE);
    }

    private void f(PostData postData) {
        if (postData.aaC == 0 && postData.gwZ) {
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
            jVar.fig.setVisibility(8);
            return;
        }
        TbRichText bsb = postData.bsb();
        com.baidu.tieba.pb.view.d.a(postData.bbZ(), jVar.fig, false, false, bsb != null && StringUtils.isNull(bsb.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fhc) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fhX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fhX.setLayoutParams(layoutParams);
            jVar.fhX.setPadding(0, 0, 0, 0);
            jVar.fhX.hu(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fhX.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fhX.setLayoutParams(layoutParams2);
            jVar.fhX.hu(postData.getBimg_url());
        }
        jVar.fhX.setTextViewOnTouchListener(this.fhG);
        jVar.fhX.setTextViewCheckSelection(false);
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
            if (postData.gxe) {
                com.baidu.tbadk.core.util.ak.j(jVar.aze, d.C0126d.cp_bg_line_c);
                jVar.aze.setVisibility(0);
            } else {
                jVar.aze.setVisibility(8);
            }
            jVar.fhW.setTag(null);
            jVar.fhW.setUserId(null);
            jVar.cja.setText((CharSequence) null);
            jVar.fic.getHeadView().setUserId(null);
            jVar.fhX.setIsHost(false);
            if (postData.rQ() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rQ().getUserId())) {
                    jVar.fhX.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.rQ().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rQ().getTShowInfoNew();
                if (jVar.fif != null) {
                    jVar.fif.setTag(d.g.tag_user_id, postData.rQ().getUserId());
                    jVar.fif.setOnClickListener(this.fgM.feP.fsl);
                    jVar.fif.a(iconInfo, 2, this.fhD, this.fhD, this.fhB);
                }
                if (jVar.fie != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fie.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fie.setOnClickListener(this.fgM.feP.fsm);
                    jVar.fie.a(tShowInfoNew, 3, this.fhD, this.fhD, this.fhB, true);
                }
                if (!com.baidu.tbadk.core.util.v.w(tShowInfoNew) || postData.rQ().isBigV()) {
                    com.baidu.tbadk.core.util.ak.c(jVar.cja, d.C0126d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ak.c(jVar.cja, d.C0126d.cp_cont_f, 1);
                }
                String portrait = postData.rQ().getPortrait();
                jVar.cja.setTag(d.g.tag_user_id, postData.rQ().getUserId());
                jVar.cja.setTag(d.g.tag_user_name, postData.rQ().getUserName());
                jVar.cja.setTag(d.g.tag_virtual_user_url, postData.rQ().getVirtualUserUrl());
                String name_show = postData.rQ().getName_show();
                String userName = postData.rQ().getUserName();
                if (com.baidu.tbadk.o.af.fz() && name_show != null && !name_show.equals(userName)) {
                    jVar.cja.setText(com.baidu.tieba.pb.c.ah(this.mContext, jVar.cja.getText().toString()));
                    jVar.cja.setGravity(16);
                    jVar.cja.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                    com.baidu.tbadk.core.util.ak.c(jVar.cja, d.C0126d.cp_other_e, 1);
                }
                if (postData.rQ().getPendantData() != null && !StringUtils.isNull(postData.rQ().getPendantData().qG())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fic.getHeadView(), postData.rQ());
                    jVar.fhW.setVisibility(8);
                    jVar.fic.setVisibility(0);
                    jVar.fic.getHeadView().startLoad(portrait, 28, false);
                    jVar.fic.getHeadView().setUserId(postData.rQ().getUserId());
                    jVar.fic.getHeadView().setUserName(postData.rQ().getUserName());
                    jVar.fic.eK(postData.rQ().getPendantData().qG());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fhW, postData.rQ());
                    jVar.fhW.setUserId(postData.rQ().getUserId());
                    jVar.fhW.setUserName(postData.rQ().getUserName(), postData.bsj());
                    jVar.fhW.setTag(d.g.tag_virtual_user_url, postData.rQ().getVirtualUserUrl());
                    jVar.fhW.setImageDrawable(null);
                    jVar.fhW.startLoad(portrait, 28, false);
                    jVar.fhW.setVisibility(0);
                    jVar.fic.setVisibility(8);
                }
                if (postData.rQ() != null) {
                    MetaData rQ = postData.rQ();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rQ.getUserId())) {
                        jVar.fhP.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fhP, d.f.icon_id_louzhu);
                        jVar.fhP.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (rQ.getIs_bawu() == 1 && "manager".equals(rQ.getBawu_type())) {
                        jVar.fhP.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fhP, d.f.icon_id_bazhu);
                        jVar.fhP.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (rQ.getIs_bawu() == 1 && "assist".equals(rQ.getBawu_type())) {
                        jVar.fhP.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fhP, d.f.icon_id_xiaobazhu);
                        jVar.fhP.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        jVar.fhP.setVisibility(8);
                        jVar.fhP.setTag(null);
                    }
                } else {
                    jVar.fhP.setVisibility(8);
                    jVar.fhP.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fgM.aXy()) {
                if (postData.rQ() != null) {
                    i2 = postData.rQ().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.fib.setVisibility(0);
                com.baidu.tbadk.core.util.ak.c(jVar.fib, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.fib.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.fif.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.fif.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.fhP.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.fie.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.rQ().getName_show();
            int hl = com.baidu.tbadk.util.w.hl(name_show2);
            if (!StringUtils.isNull(postData.rQ().getSealPrefix())) {
                if (hl > i3 - 2) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (hl > i3) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.rQ().getSealPrefix())) {
                jVar.cja.setText(ag(postData.rQ().getSealPrefix(), str));
            } else {
                jVar.cja.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view2);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.brZ()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.rQ() != null && !StringUtils.isNull(postData.rQ().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fhb != null && this.fhb.aVE() != 0) {
                if (this.fhb.aVE() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.rQ() != null) {
                    String userId = postData.rQ().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fhb != null && this.fhb.aVs() != null && this.fhb.aVs().rQ() != null && postData.rQ() != null) {
                String userId2 = this.fhb.aVs().rQ().getUserId();
                String userId3 = postData.rQ().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.rQ() != null && UtilHelper.isCurrentAccount(postData.rQ().getUserId())) {
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
                    if (postData.brZ() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fhb.aVE()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rQ().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rQ() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rQ().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rQ().getUserName());
                        }
                        if (this.fhb.aVs() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fhb.aVs().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fhb.aVE()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fhV.setTag(sparseArray);
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
            if (postData.brZ() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fhV.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fhU.a(postData.bsl(), postData.bsk(), false);
            jVar.fhU.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.brZ() > 0) {
                String format = String.format(this.mContext.getString(d.k.is_floor), Integer.valueOf(postData.brZ()));
                jVar.fia.setVisibility(0);
                jVar.fia.setText(format);
                z = true;
            } else {
                jVar.fia.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bsc = postData.bsc();
            boolean z2 = (bsc == null || StringUtils.isNull(bsc.getName())) ? false : true;
            if (z) {
                jVar.fhR.setVisibility(0);
                i = this.fhC;
            } else {
                jVar.fhR.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fhS.setVisibility(0);
                i2 = this.fhC;
            } else {
                jVar.fhS.setVisibility(8);
                i2 = 0;
            }
            jVar.fhQ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fhQ.setText(com.baidu.tbadk.core.util.an.t(postData.getTime()));
            } else {
                jVar.fhQ.setText(com.baidu.tbadk.core.util.an.s(postData.getTime()));
            }
            if (z2) {
                final String name = bsc.getName();
                final String lat = bsc.getLat();
                final String lng = bsc.getLng();
                jVar.fhT.setVisibility(0);
                jVar.fhT.setPadding(this.fhC, 0, 0, 0);
                jVar.fhT.setText(bsc.getName());
                jVar.fhT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.gP()) {
                                com.baidu.tbadk.browser.a.M(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.k.app_info_for_map)));
                            } else {
                                i.this.fgM.showToast(d.k.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fhT.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view2) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fhX.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fhX.setPadding(e, 0, e, 0);
            if (!this.fhc) {
                jVar.fhX.getLayoutStrategy().fO(d.f.icon_click);
            } else {
                jVar.fhX.hu(null);
                jVar.fhX.setBackgroundDrawable(null);
                jVar.fhX.getLayoutStrategy().fO(d.f.transparent_bg);
            }
            jVar.fhX.getLayoutStrategy().fL(d.f.pic_video);
            a(jVar.fhX, view2, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fhX.setLayoutParams(layoutParams);
            jVar.fhX.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            jVar.fhX.setIsFromCDN(this.mIsFromCDN);
            jVar.fhX.setText(postData.bsb(), true, this.fhE);
            SparseArray sparseArray = (SparseArray) jVar.fhX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fhX.setTag(sparseArray);
            jVar.fhN.setTag(d.g.tag_from, sparseArray);
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
            if (postData.bsd() > 0 && postData.brW() != null && postData.brW().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fhZ.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fhZ.setLayoutParams(layoutParams);
                if (this.fhF == null) {
                    this.fhF = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fhF.setIsFromCDN(this.mIsFromCDN);
                    this.fhF.I(this.fhk);
                    String str = null;
                    if (this.fhb != null && this.fhb.aVs() != null && this.fhb.aVs().rQ() != null) {
                        str = this.fhb.aVs().rQ().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fhb != null) {
                        this.fhF.B(this.fhb.aVE(), z);
                        this.fhF.T(this.fhb.aVs());
                    }
                }
                this.fhF.qQ(postData.getId());
                jVar.fhZ.setSubPbAdapter(this.fhF);
                jVar.fhZ.setVisibility(0);
                jVar.fhZ.setData(postData, view2);
                jVar.fhZ.setChildOnClickListener(this.mCommonClickListener);
                jVar.fhZ.setChildOnLongClickListener(this.axW);
                jVar.fhZ.setChildOnTouchListener(this.fhG);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fhZ.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fhZ.setLayoutParams(layoutParams2);
                jVar.fhZ.setVisibility(8);
            }
            if (postData.gxd) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fik != null && jVar.fih != null) {
            if (postData == null || postData.gxg == null || StringUtils.isNull(postData.gxg.liveTitle)) {
                jVar.fih.setVisibility(8);
                return;
            }
            jVar.fik.setText(postData.gxg.liveTitle);
            jVar.fih.setTag(postData.gxg);
            jVar.fih.setVisibility(0);
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
                com.baidu.tbadk.core.util.ak.c(jVar.cja, d.C0126d.cp_cont_f, 1);
                if (jVar.fhP.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ak.c(jVar.fhP, ((Integer) jVar.fhP.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.ak.c(jVar.fhQ, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.i(jVar.fhR, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.i(jVar.fhS, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.c(jVar.fia, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.c(jVar.fhT, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.j(jVar.mBottomLine, d.C0126d.cp_bg_line_c);
                com.baidu.tbadk.core.util.ak.c(jVar.fhV, d.f.icon_floor_more_selector);
                jVar.fhX.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_b));
                com.baidu.tbadk.core.util.ak.j(jVar.fhZ, d.C0126d.cp_bg_line_e);
                jVar.fhZ.onChangeSkinType();
                jVar.fhY.onChangeSkinType();
                jVar.fhU.onChangeSkinType();
                com.baidu.tbadk.core.util.ak.c(jVar.fik, d.C0126d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ak.c(jVar.fii, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.i(jVar.fih, d.C0126d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ak.i(jVar.fij, d.C0126d.cp_cont_d);
                com.baidu.tbadk.core.util.ak.c(jVar.fil, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ak.h(jVar.fio, d.C0126d.cp_cont_j);
                if (jVar.fim.getVisibility() == 8) {
                    jVar.fio.setText(d.k.close_content);
                    com.baidu.tbadk.core.util.ak.c(jVar.fip, d.f.icon_arrow_gray_up);
                } else if (this.fhb != null && StringUtils.isNull(this.fhb.aVA())) {
                    jVar.fio.setText(this.fhb.aVA());
                    com.baidu.tbadk.core.util.ak.c(jVar.fip, d.f.icon_arrow_gray_down);
                } else {
                    jVar.fio.setText(d.k.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fhN.setOnTouchListener(this.fhG);
        jVar.fhN.setOnLongClickListener(this.axW);
        if (this.fgM.getPageContext() != null && this.fgM.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fgM.getPageContext().getOrignalPage()).feP;
            jVar.cja.setOnClickListener(aVar.fsk);
            jVar.fhW.setOnClickListener(aVar.fsk);
            jVar.fic.setOnClickListener(aVar.fsk);
            jVar.fic.getHeadView().setOnClickListener(aVar.fsk);
            jVar.fhX.setOnLongClickListener(this.axW);
            jVar.fhX.setOnTouchListener(this.fhG);
            jVar.fhX.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fhX.setOnImageClickListener(this.aWw);
            jVar.fhX.setOnImageTouchListener(this.fhG);
            jVar.fhX.setOnEmotionClickListener(aVar.fsn);
            jVar.fhV.setOnClickListener(this.mCommonClickListener);
            jVar.fhU.setOnClickListener(this.mCommonClickListener);
            jVar.fig.setOnClickListener(this.mCommonClickListener);
            jVar.fih.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fhE = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fhb = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jq(boolean z) {
        this.fhc = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fgM.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fhX.setTextViewOnTouchListener(this.aWx);
        jVar.fhX.setTextViewCheckSelection(false);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fhk = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWw = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aWx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axW = onLongClickListener;
    }
}
