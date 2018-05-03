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
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ddG;
    private com.baidu.adp.lib.e.b<TbImageView> ddH;
    protected com.baidu.tieba.pb.data.d fgY;
    private boolean fgZ;
    private int fhA;
    private TbRichTextView.c fhB;
    private com.baidu.tieba.pb.pb.sub.c fhC;
    private com.baidu.tieba.pb.a.c fhD;
    private View.OnClickListener fhh;
    private int fhy;
    private int fhz;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData aW;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bsl() && this.mCommonClickListener != null && this.fgJ != null && (aW = this.fgJ.aW(findViewById)) != null) {
                TiebaStatic.log(this.fgJ.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, aW.bsl() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fhy = 0;
        this.fhz = 0;
        this.fhA = 0;
        this.fhB = null;
        this.fgZ = true;
        this.mHostId = null;
        this.fgY = null;
        this.fhh = null;
        this.mCommonClickListener = null;
        this.aWw = null;
        this.aWx = null;
        this.axW = null;
        this.fhC = null;
        this.aWt = true;
        this.ddG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
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
        this.ddH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
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
        this.fhD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                if (view2 != null && (i.this.fgJ == null || i.this.fgJ.aWO() == null || i.this.fgJ.aWO().aZJ())) {
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
        j jVar = new j(this.fgJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fhV.setConstrainLayoutPool(this.ddG);
        jVar.fhV.setImageViewPool(this.ddH);
        a(jVar);
        this.fhy = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds12);
        this.fhz = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds20);
        this.fhA = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds36);
        if (jVar.fhU != null) {
            jVar.fhU.setDuiEnabled(this.aWt);
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
            jVar.fij.setVisibility(8);
            jVar.fil.setText(d.k.expand_content);
            com.baidu.tbadk.core.util.ak.c(jVar.fim, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fij.setVisibility(0);
        jVar.fil.setText(d.k.close_content);
        com.baidu.tbadk.core.util.ak.c(jVar.fim, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bsn() == 2) {
            jVar.fik.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean z = jVar.fij.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mn(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.fgJ.aWO() != null && i.this.fgJ.aWO().baF() != null && i.this.fgJ.aWO().getListView() != null && !z && jVar.getView().getTop() < i.this.fgJ.aWO().baF().getMeasuredHeight()) {
                        i.this.fgJ.aWO().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fgJ.aWO().getListView().getData(), postData) + i.this.fgJ.aWO().getListView().getHeaderViewsCount(), i.this.fgJ.aWO().baF().getMeasuredHeight());
                    }
                }
            });
            jVar.fil.setText(this.fgY.aVA());
            jVar.fik.setVisibility(0);
            a(jVar, postData.brU());
            a(true, jVar, postData);
        } else {
            jVar.fik.setVisibility(8);
            jVar.fij.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.w(postData.brW());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fik.getLayoutParams();
        if (z) {
            jVar.fhU.getLayoutStrategy().fR(0);
            if (z2) {
                jVar.fhU.getLayoutStrategy().fQ(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                }
            } else {
                jVar.fhU.getLayoutStrategy().fQ(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fik.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fhU.getLayoutStrategy().fQ(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fhU.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bsb = postData.bsb();
        bsb.isChanged = true;
        jVar.fhU.setText(bsb, true, this.fhB);
    }

    private void f(PostData postData) {
        if (postData.aaC == 0 && postData.gwW) {
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
            jVar.fic.setVisibility(8);
            return;
        }
        TbRichText bsb = postData.bsb();
        com.baidu.tieba.pb.view.d.a(postData.bbZ(), jVar.fic, false, false, bsb != null && StringUtils.isNull(bsb.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fgZ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fhU.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fhU.setLayoutParams(layoutParams);
            jVar.fhU.setPadding(0, 0, 0, 0);
            jVar.fhU.hu(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fhU.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fhU.setLayoutParams(layoutParams2);
            jVar.fhU.hu(postData.getBimg_url());
        }
        jVar.fhU.setTextViewOnTouchListener(this.fhD);
        jVar.fhU.setTextViewCheckSelection(false);
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
            if (postData.gxb) {
                com.baidu.tbadk.core.util.ak.j(jVar.aze, d.C0126d.cp_bg_line_c);
                jVar.aze.setVisibility(0);
            } else {
                jVar.aze.setVisibility(8);
            }
            jVar.fhT.setTag(null);
            jVar.fhT.setUserId(null);
            jVar.ciX.setText((CharSequence) null);
            jVar.fhZ.getHeadView().setUserId(null);
            jVar.fhU.setIsHost(false);
            if (postData.rQ() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rQ().getUserId())) {
                    jVar.fhU.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.rQ().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rQ().getTShowInfoNew();
                if (jVar.fib != null) {
                    jVar.fib.setTag(d.g.tag_user_id, postData.rQ().getUserId());
                    jVar.fib.setOnClickListener(this.fgJ.feM.fsi);
                    jVar.fib.a(iconInfo, 2, this.fhA, this.fhA, this.fhy);
                }
                if (jVar.fia != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fia.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fia.setOnClickListener(this.fgJ.feM.fsj);
                    jVar.fia.a(tShowInfoNew, 3, this.fhA, this.fhA, this.fhy, true);
                }
                if (!com.baidu.tbadk.core.util.v.w(tShowInfoNew) || postData.rQ().isBigV()) {
                    com.baidu.tbadk.core.util.ak.c(jVar.ciX, d.C0126d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ak.c(jVar.ciX, d.C0126d.cp_cont_f, 1);
                }
                String portrait = postData.rQ().getPortrait();
                jVar.ciX.setTag(d.g.tag_user_id, postData.rQ().getUserId());
                jVar.ciX.setTag(d.g.tag_user_name, postData.rQ().getUserName());
                jVar.ciX.setTag(d.g.tag_virtual_user_url, postData.rQ().getVirtualUserUrl());
                String name_show = postData.rQ().getName_show();
                String userName = postData.rQ().getUserName();
                if (com.baidu.tbadk.o.af.fz() && name_show != null && !name_show.equals(userName)) {
                    jVar.ciX.setText(com.baidu.tieba.pb.c.ah(this.mContext, jVar.ciX.getText().toString()));
                    jVar.ciX.setGravity(16);
                    jVar.ciX.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                    com.baidu.tbadk.core.util.ak.c(jVar.ciX, d.C0126d.cp_other_e, 1);
                }
                if (postData.rQ().getPendantData() != null && !StringUtils.isNull(postData.rQ().getPendantData().qG())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fhZ.getHeadView(), postData.rQ());
                    jVar.fhT.setVisibility(8);
                    jVar.fhZ.setVisibility(0);
                    jVar.fhZ.getHeadView().startLoad(portrait, 28, false);
                    jVar.fhZ.getHeadView().setUserId(postData.rQ().getUserId());
                    jVar.fhZ.getHeadView().setUserName(postData.rQ().getUserName());
                    jVar.fhZ.eK(postData.rQ().getPendantData().qG());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fhT, postData.rQ());
                    jVar.fhT.setUserId(postData.rQ().getUserId());
                    jVar.fhT.setUserName(postData.rQ().getUserName(), postData.bsj());
                    jVar.fhT.setTag(d.g.tag_virtual_user_url, postData.rQ().getVirtualUserUrl());
                    jVar.fhT.setImageDrawable(null);
                    jVar.fhT.startLoad(portrait, 28, false);
                    jVar.fhT.setVisibility(0);
                    jVar.fhZ.setVisibility(8);
                }
                if (postData.rQ() != null) {
                    MetaData rQ = postData.rQ();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rQ.getUserId())) {
                        jVar.fhM.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fhM, d.f.icon_id_louzhu);
                        jVar.fhM.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (rQ.getIs_bawu() == 1 && "manager".equals(rQ.getBawu_type())) {
                        jVar.fhM.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fhM, d.f.icon_id_bazhu);
                        jVar.fhM.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (rQ.getIs_bawu() == 1 && "assist".equals(rQ.getBawu_type())) {
                        jVar.fhM.setVisibility(0);
                        com.baidu.tbadk.core.util.ak.c(jVar.fhM, d.f.icon_id_xiaobazhu);
                        jVar.fhM.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        jVar.fhM.setVisibility(8);
                        jVar.fhM.setTag(null);
                    }
                } else {
                    jVar.fhM.setVisibility(8);
                    jVar.fhM.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fgJ.aXy()) {
                if (postData.rQ() != null) {
                    i2 = postData.rQ().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.fhY.setVisibility(0);
                com.baidu.tbadk.core.util.ak.c(jVar.fhY, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.fhY.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.fib.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.fib.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.fhM.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.fia.getChildCount() > 0) {
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
                jVar.ciX.setText(ag(postData.rQ().getSealPrefix(), str));
            } else {
                jVar.ciX.setText(str);
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
            if (this.fgY != null && this.fgY.aVE() != 0) {
                if (this.fgY.aVE() != 1002) {
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
            if (this.fgY != null && this.fgY.aVs() != null && this.fgY.aVs().rQ() != null && postData.rQ() != null) {
                String userId2 = this.fgY.aVs().rQ().getUserId();
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
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fgY.aVE()));
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
                        if (this.fgY.aVs() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fgY.aVs().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fgY.aVE()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fhS.setTag(sparseArray);
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
            jVar.fhS.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fhR.a(postData.bsl(), postData.bsk(), false);
            jVar.fhR.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.brZ() > 0) {
                String format = String.format(this.mContext.getString(d.k.is_floor), Integer.valueOf(postData.brZ()));
                jVar.fhX.setVisibility(0);
                jVar.fhX.setText(format);
                z = true;
            } else {
                jVar.fhX.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bsc = postData.bsc();
            boolean z2 = (bsc == null || StringUtils.isNull(bsc.getName())) ? false : true;
            if (z) {
                jVar.fhO.setVisibility(0);
                i = this.fhz;
            } else {
                jVar.fhO.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fhP.setVisibility(0);
                i2 = this.fhz;
            } else {
                jVar.fhP.setVisibility(8);
                i2 = 0;
            }
            jVar.fhN.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fhN.setText(com.baidu.tbadk.core.util.an.t(postData.getTime()));
            } else {
                jVar.fhN.setText(com.baidu.tbadk.core.util.an.s(postData.getTime()));
            }
            if (z2) {
                final String name = bsc.getName();
                final String lat = bsc.getLat();
                final String lng = bsc.getLng();
                jVar.fhQ.setVisibility(0);
                jVar.fhQ.setPadding(this.fhz, 0, 0, 0);
                jVar.fhQ.setText(bsc.getName());
                jVar.fhQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.gP()) {
                                com.baidu.tbadk.browser.a.M(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.k.app_info_for_map)));
                            } else {
                                i.this.fgJ.showToast(d.k.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fhQ.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view2) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fhU.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fhU.setPadding(e, 0, e, 0);
            if (!this.fgZ) {
                jVar.fhU.getLayoutStrategy().fN(d.f.icon_click);
            } else {
                jVar.fhU.hu(null);
                jVar.fhU.setBackgroundDrawable(null);
                jVar.fhU.getLayoutStrategy().fN(d.f.transparent_bg);
            }
            jVar.fhU.getLayoutStrategy().fK(d.f.pic_video);
            a(jVar.fhU, view2, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fhU.setLayoutParams(layoutParams);
            jVar.fhU.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            jVar.fhU.setIsFromCDN(this.mIsFromCDN);
            jVar.fhU.setText(postData.bsb(), true, this.fhB);
            SparseArray sparseArray = (SparseArray) jVar.fhU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fhU.setTag(sparseArray);
            jVar.fhK.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view2, boolean z) {
        if (tbRichTextView != null && view2 != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                af = (af - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fL(af - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fM((int) (af * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view2, int i) {
        if (jVar != null && postData != null) {
            if (postData.bsd() > 0 && postData.brW() != null && postData.brW().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fhW.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fhW.setLayoutParams(layoutParams);
                if (this.fhC == null) {
                    this.fhC = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fhC.setIsFromCDN(this.mIsFromCDN);
                    this.fhC.I(this.fhh);
                    String str = null;
                    if (this.fgY != null && this.fgY.aVs() != null && this.fgY.aVs().rQ() != null) {
                        str = this.fgY.aVs().rQ().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fgY != null) {
                        this.fhC.B(this.fgY.aVE(), z);
                        this.fhC.T(this.fgY.aVs());
                    }
                }
                this.fhC.qQ(postData.getId());
                jVar.fhW.setSubPbAdapter(this.fhC);
                jVar.fhW.setVisibility(0);
                jVar.fhW.setData(postData, view2);
                jVar.fhW.setChildOnClickListener(this.mCommonClickListener);
                jVar.fhW.setChildOnLongClickListener(this.axW);
                jVar.fhW.setChildOnTouchListener(this.fhD);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fhW.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fhW.setLayoutParams(layoutParams2);
                jVar.fhW.setVisibility(8);
            }
            if (postData.gxa) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fih != null && jVar.fie != null) {
            if (postData == null || postData.gxd == null || StringUtils.isNull(postData.gxd.liveTitle)) {
                jVar.fie.setVisibility(8);
                return;
            }
            jVar.fih.setText(postData.gxd.liveTitle);
            jVar.fie.setTag(postData.gxd);
            jVar.fie.setVisibility(0);
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
                com.baidu.tbadk.core.util.ak.c(jVar.ciX, d.C0126d.cp_cont_f, 1);
                if (jVar.fhM.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ak.c(jVar.fhM, ((Integer) jVar.fhM.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.ak.c(jVar.fhN, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.i(jVar.fhO, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.i(jVar.fhP, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.c(jVar.fhX, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.c(jVar.fhQ, d.C0126d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ak.j(jVar.mBottomLine, d.C0126d.cp_bg_line_c);
                com.baidu.tbadk.core.util.ak.c(jVar.fhS, d.f.icon_floor_more_selector);
                jVar.fhU.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_b));
                com.baidu.tbadk.core.util.ak.j(jVar.fhW, d.C0126d.cp_bg_line_e);
                jVar.fhW.onChangeSkinType();
                jVar.fhV.onChangeSkinType();
                jVar.fhR.onChangeSkinType();
                com.baidu.tbadk.core.util.ak.c(jVar.fih, d.C0126d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ak.c(jVar.fif, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.i(jVar.fie, d.C0126d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ak.i(jVar.fig, d.C0126d.cp_cont_d);
                com.baidu.tbadk.core.util.ak.c(jVar.fii, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ak.h(jVar.fil, d.C0126d.cp_cont_j);
                if (jVar.fij.getVisibility() == 8) {
                    jVar.fil.setText(d.k.close_content);
                    com.baidu.tbadk.core.util.ak.c(jVar.fim, d.f.icon_arrow_gray_up);
                } else if (this.fgY != null && StringUtils.isNull(this.fgY.aVA())) {
                    jVar.fil.setText(this.fgY.aVA());
                    com.baidu.tbadk.core.util.ak.c(jVar.fim, d.f.icon_arrow_gray_down);
                } else {
                    jVar.fil.setText(d.k.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fhK.setOnTouchListener(this.fhD);
        jVar.fhK.setOnLongClickListener(this.axW);
        if (this.fgJ.getPageContext() != null && this.fgJ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fgJ.getPageContext().getOrignalPage()).feM;
            jVar.ciX.setOnClickListener(aVar.fsh);
            jVar.fhT.setOnClickListener(aVar.fsh);
            jVar.fhZ.setOnClickListener(aVar.fsh);
            jVar.fhZ.getHeadView().setOnClickListener(aVar.fsh);
            jVar.fhU.setOnLongClickListener(this.axW);
            jVar.fhU.setOnTouchListener(this.fhD);
            jVar.fhU.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fhU.setOnImageClickListener(this.aWw);
            jVar.fhU.setOnImageTouchListener(this.fhD);
            jVar.fhU.setOnEmotionClickListener(aVar.fsk);
            jVar.fhS.setOnClickListener(this.mCommonClickListener);
            jVar.fhR.setOnClickListener(this.mCommonClickListener);
            jVar.fic.setOnClickListener(this.mCommonClickListener);
            jVar.fie.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fhB = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fgY = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jq(boolean z) {
        this.fgZ = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fgJ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fhU.setTextViewOnTouchListener(this.aWx);
        jVar.fhU.setTextViewCheckSelection(false);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fhh = onClickListener;
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
