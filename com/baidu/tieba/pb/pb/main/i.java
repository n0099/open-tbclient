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
import java.util.Iterator;
/* loaded from: classes6.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private View.OnLongClickListener aUa;
    private boolean bsB;
    private TbRichTextView.h bsE;
    private com.baidu.tieba.pb.a.c bsF;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQb;
    private com.baidu.adp.lib.e.b<TbImageView> dQc;
    private int fVi;
    private int fVj;
    private int fVk;
    protected com.baidu.tieba.pb.data.d fYZ;
    private boolean fZa;
    private View.OnClickListener fZi;
    private TbRichTextView.c fZx;
    private com.baidu.tieba.pb.pb.sub.c fZy;
    private com.baidu.tieba.pb.a.c fZz;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bw;
        if (noPressedLinearLayout.findViewById(e.g.view_floor_new_praise) != null && noPressedLinearLayout.findViewById(e.g.view_floor_new_praise).getTag(e.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(e.g.view_floor_new_praise);
            if (!((PostData) findViewById.getTag(e.g.tag_clip_board)).aEn() && this.mCommonClickListener != null && this.fYK != null && (bw = this.fYK.bw(findViewById)) != null) {
                TiebaStatic.log(this.fYK.bja().y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).y("obj_locate", 5).y(VideoPlayActivityConfig.OBJ_ID, bw.aEn() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fVi = 0;
        this.fVj = 0;
        this.fVk = 0;
        this.fZx = null;
        this.fZa = true;
        this.mHostId = null;
        this.fYZ = null;
        this.fZi = null;
        this.mCommonClickListener = null;
        this.bsE = null;
        this.bsF = null;
        this.aUa = null;
        this.fZy = null;
        this.bsB = true;
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDZ */
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
        this.dQc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: FH */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
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
        this.fZz = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fYK == null || i.this.fYK.biU() == null || i.this.fYK.biU().blV())) {
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
                if (i.this.bsF != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bsF.bt(view);
                        i.this.bsF.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fYK.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fZP.setConstrainLayoutPool(this.dQb);
        jVar.fZP.setImageViewPool(this.dQc);
        a(jVar);
        this.fVi = getDimensionPixelSize(e.C0210e.tbds12);
        this.fVj = getDimensionPixelSize(e.C0210e.tbds20);
        this.fVk = getDimensionPixelSize(e.C0210e.tbds36);
        if (jVar.fZO != null) {
            jVar.fZO.setDuiEnabled(this.bsB);
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
            postData2.locate = i + 1;
            h(postData2);
            i(postData2);
            postData2.AQ();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bsB = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.I(postData.bEP())) {
            int i = 8;
            if (postData.hqu) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.fYZ, postData, postData.locate, i, 6);
            postData.hqv = b;
            Iterator<PostData> it = postData.bEP().iterator();
            while (it.hasNext()) {
                it.next().hqv = b;
            }
        }
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
            jVar.gac.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.gae.setText(e.j.expand_content);
            } else {
                jVar.gae.setText(str);
            }
            com.baidu.tbadk.core.util.al.c(jVar.gaf, e.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.gac.setVisibility(0);
        jVar.gae.setText(e.j.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.gaf, e.f.icon_arrow_gray_up_n);
    }

    private void b(final j jVar, final PostData postData) {
        if (postData.bFe() == 2 || postData.bFe() == 4) {
            jVar.gad.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.gac.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bhH());
                    postData.nv(z ? false : true);
                    i.this.c(jVar, postData);
                    if (i.this.fYK.biU() != null && i.this.fYK.biU().bmT() != null && i.this.fYK.biU().getListView() != null && !z && jVar.getView().getTop() < i.this.fYK.biU().bmT().getMeasuredHeight()) {
                        i.this.fYK.biU().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fYK.biU().getListView().getData(), postData) + i.this.fYK.biU().getListView().getHeaderViewsCount(), i.this.fYK.biU().bmT().getMeasuredHeight());
                    }
                }
            });
            jVar.gad.setVisibility(0);
            a(jVar, postData.bEN(), postData.bhH());
            a(true, jVar, postData);
        } else {
            jVar.gad.setVisibility(8);
            jVar.gac.setVisibility(0);
            a(false, jVar, postData);
        }
        c(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.I(postData.bEP());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.gad.getLayoutParams();
        if (z) {
            jVar.fZO.getLayoutStrategy().gS(0);
            if (z2) {
                jVar.fZO.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds26);
                }
            } else {
                jVar.fZO.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.gad.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fZO.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
        jVar.fZO.getLayoutStrategy().gS(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, PostData postData) {
        TbRichText bEU = postData.bEU();
        bEU.isChanged = true;
        jVar.fZO.setText(bEU, true, this.fZx);
    }

    private void h(PostData postData) {
        if (postData.auN == 0 && postData.dSl) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.aB("post_id", postData.getId());
            amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aB("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.aB("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.aB("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.i("exposure_time", System.currentTimeMillis());
            if (this.fYK != null) {
                int blc = this.fYK.biD().blc();
                if (1 == blc || 2 == blc) {
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == blc) {
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.fYK.getUniqueId(), this.fYZ, postData, postData.locate, postData.hqu ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bor() == null) {
            jVar.fZW.setVisibility(8);
            return;
        }
        TbRichText bEU = postData.bEU();
        com.baidu.tieba.pb.view.c.a(postData.bor(), jVar.fZW, false, false, bEU != null && StringUtils.isNull(bEU.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fZa) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZO.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fZO.setLayoutParams(layoutParams);
            jVar.fZO.setPadding(0, 0, 0, 0);
            jVar.fZO.jr(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fZO.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0210e.ds20);
            jVar.fZO.setLayoutParams(layoutParams2);
            jVar.fZO.jr(postData.getBimg_url());
        }
        jVar.fZO.setTextViewOnTouchListener(this.fZz);
        jVar.fZO.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x070b  */
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
            if (postData.hqn) {
                com.baidu.tbadk.core.util.al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fZN.setTag(null);
            jVar.fZN.setUserId(null);
            jVar.cLX.setText((CharSequence) null);
            jVar.fZT.getHeadView().setUserId(null);
            jVar.fZO.setIsHost(false);
            if (postData.zT() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zT().getUserId())) {
                    jVar.fZO.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zT().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zT().getTShowInfoNew();
                if (jVar.fZV != null) {
                    jVar.fZV.setTag(e.g.tag_user_id, postData.zT().getUserId());
                    jVar.fZV.setOnClickListener(this.fYK.fWO.gkj);
                    jVar.fZV.a(iconInfo, 2, this.fVk, this.fVk, this.fVi);
                }
                if (jVar.fZU != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fZU.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fZU.setOnClickListener(this.fYK.fWO.gkk);
                    jVar.fZU.a(tShowInfoNew, 3, this.fVk, this.fVk, this.fVi, true);
                }
                if (!com.baidu.tbadk.core.util.v.I(tShowInfoNew) || postData.zT().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.cLX, e.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.cLX, e.d.cp_cont_f, 1);
                }
                String portrait = postData.zT().getPortrait();
                int i2 = 8;
                if (postData.hqu) {
                    i2 = 2;
                }
                jVar.cLX.setTag(e.g.tag_user_id, postData.zT().getUserId());
                jVar.cLX.setTag(e.g.tag_user_name, postData.zT().getUserName());
                jVar.cLX.setTag(e.g.tag_virtual_user_url, postData.zT().getVirtualUserUrl());
                jVar.cLX.setTag(e.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.fYZ, postData, postData.locate, i2, 2));
                String name_show = postData.zT().getName_show();
                String userName = postData.zT().getUserName();
                if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cLX.setText(com.baidu.tieba.pb.c.aC(this.mContext, jVar.cLX.getText().toString()));
                    jVar.cLX.setGravity(16);
                    jVar.cLX.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                    com.baidu.tbadk.core.util.al.c(jVar.cLX, e.d.cp_other_e, 1);
                }
                if (postData.zT().getPendantData() != null && !StringUtils.isNull(postData.zT().getPendantData().yF())) {
                    jVar.fZT.b(postData.zT());
                    jVar.fZN.setVisibility(8);
                    jVar.fZT.setVisibility(0);
                    jVar.fZT.getHeadView().startLoad(portrait, 28, false);
                    jVar.fZT.getHeadView().setUserId(postData.zT().getUserId());
                    jVar.fZT.getHeadView().setUserName(postData.zT().getUserName());
                    jVar.fZT.getHeadView().setFid(this.fYZ != null ? this.fYZ.getForumId() : "");
                    jVar.fZT.getHeadView().setTid(postData.getId());
                    jVar.fZT.getHeadView().setTag(e.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.fYZ, postData, postData.locate, i2, 2));
                    jVar.fZT.gA(postData.zT().getPendantData().yF());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fZN, postData.zT());
                    jVar.fZN.setUserId(postData.zT().getUserId());
                    jVar.fZN.setFid(this.fYZ != null ? this.fYZ.getForumId() : "");
                    jVar.fZN.setTid(postData.getId());
                    jVar.fZN.setUserName(postData.zT().getUserName(), postData.bFc());
                    jVar.fZN.setTag(e.g.tag_virtual_user_url, postData.zT().getVirtualUserUrl());
                    jVar.fZN.setTag(e.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.fYZ, postData, postData.locate, i2, 2));
                    jVar.fZN.setImageDrawable(null);
                    jVar.fZN.startLoad(portrait, 28, false);
                    jVar.fZN.setVisibility(0);
                    jVar.fZT.setVisibility(8);
                }
                if (postData.zT() != null) {
                    MetaData zT = postData.zT();
                    int i3 = postData.bEK() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i4 = postData.bEK() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    com.baidu.tbadk.core.util.al.i(jVar.fZF, i3);
                    com.baidu.tbadk.core.util.al.h(jVar.fZF, i4);
                    jVar.fZF.setTag(Integer.valueOf(i3));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(zT.getUserId())) {
                        jVar.fZF.setVisibility(0);
                        jVar.fZF.setText(e.j.host_name);
                    } else if (zT.getIs_bawu() == 1 && postData.bEK()) {
                        jVar.fZF.setVisibility(0);
                        jVar.fZF.setText(e.j.brand_Official);
                    } else if (zT.getIs_bawu() == 1 && "manager".equals(zT.getBawu_type())) {
                        jVar.fZF.setVisibility(0);
                        jVar.fZF.setText(e.j.bawu_member_bazhu_tip);
                    } else if (zT.getIs_bawu() == 1 && "assist".equals(zT.getBawu_type())) {
                        jVar.fZF.setVisibility(0);
                        jVar.fZF.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fZF.setVisibility(8);
                        jVar.fZF.setTag(null);
                    }
                } else {
                    jVar.fZF.setVisibility(8);
                    jVar.fZF.setTag(null);
                }
            }
            int i5 = 0;
            if (this.fYK.bit()) {
                if (postData.zT() != null) {
                    i5 = postData.zT().getLevel_id();
                }
            } else {
                i5 = 0;
            }
            if (i5 > 0) {
                jVar.fZS.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fZS, BitmapHelper.getGradeResourceIdInEnterForum(i5));
            } else {
                jVar.fZS.setVisibility(8);
            }
            int i6 = 15;
            if (jVar.fZV.getChildCount() == 1) {
                i6 = 13;
            } else if (jVar.fZV.getChildCount() > 1) {
                i6 = 11;
            }
            if (jVar.fZF.getVisibility() == 0) {
                i6 -= 2;
            }
            if (jVar.fZU.getChildCount() > 0) {
                i6 -= 2;
            }
            if (postData.Bg() > 1000) {
                i6 -= 2;
            }
            if (postData.Bg() > 10) {
                i6 -= 2;
            }
            if (i6 < 10) {
                jVar.fZV.setVisibility(8);
                if (jVar.fZV.getChildCount() == 1) {
                    i6 += 2;
                } else if (jVar.fZV.getChildCount() > 1) {
                    i6 += 4;
                }
                if (i6 < 10 && jVar.fZF.getVisibility() == 0) {
                    i6 += 2;
                    jVar.fZF.setVisibility(8);
                }
                if (i6 < 10 && jVar.fZS.getVisibility() == 0) {
                    i6 += 2;
                    jVar.fZS.setVisibility(8);
                }
            }
            String name_show2 = postData.zT() != null ? postData.zT().getName_show() : "";
            int jd = com.baidu.tbadk.util.z.jd(name_show2);
            if (postData.zT() != null && !StringUtils.isNull(postData.zT().getSealPrefix())) {
                if (jd > i6 - 2) {
                    name_show2 = com.baidu.tbadk.util.z.K(name_show2, i6 - 2) + "...";
                }
            } else if (jd > i6) {
                name_show2 = com.baidu.tbadk.util.z.K(name_show2, i6) + "...";
            }
            if (postData.zT() != null && !StringUtils.isNull(postData.zT().getSealPrefix())) {
                jVar.cLX.setText(aF(postData.zT().getSealPrefix(), name_show2));
            } else {
                jVar.cLX.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bES()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.zT() != null && !StringUtils.isNull(postData.zT().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fYZ != null && this.fYZ.bhL() != 0) {
                if (this.fYZ.bhL() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.zT() != null) {
                    String userId = postData.zT().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fYZ != null && this.fYZ.bhz() != null && this.fYZ.bhz().zT() != null && postData.zT() != null) {
                String userId2 = this.fYZ.bhz().zT().getUserId();
                String userId3 = postData.zT().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.zT() != null && UtilHelper.isCurrentAccount(postData.zT().getUserId())) {
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
                    int i7 = 1;
                    if (postData.bES() == 1) {
                        i7 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYZ.bhL()));
                        if (postData.zT() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zT().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zT().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zT().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zT() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zT().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zT().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zT().getName_show());
                        }
                        if (this.fYZ.bhz() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fYZ.bhz().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYZ.bhL()));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i7));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    jVar.fZO.setTag(sparseArray);
                    jVar.fZK.setTag(sparseArray);
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
            int i72 = 1;
            if (postData.bES() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fZO.setTag(sparseArray);
            jVar.fZK.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.gag.a(postData);
            jVar.fZL.setTag(e.g.tag_clip_board, postData);
            jVar.fZL.setPostId(postData.getId());
            jVar.fZL.setThreadId(this.fYK.biD().bkt());
            jVar.fZL.setObjType(1);
            jVar.fZM.setThreadId(this.fYK.biD().bkt());
            jVar.fZM.setPostId(postData.getId());
            jVar.fZM.setObjType(1);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bES() > 0) {
                String format = String.format(this.mContext.getString(e.j.is_floor), Integer.valueOf(postData.bES()));
                jVar.fZR.setVisibility(0);
                jVar.fZR.setText(format);
                z = true;
            } else {
                jVar.fZR.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bEV = postData.bEV();
            boolean z2 = (bEV == null || StringUtils.isNull(bEV.getName())) ? false : true;
            if (z) {
                jVar.fZH.setVisibility(0);
                i = this.fVj;
            } else {
                jVar.fZH.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fZI.setVisibility(0);
                i2 = this.fVj;
            } else {
                jVar.fZI.setVisibility(8);
                i2 = 0;
            }
            jVar.fZG.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fZG.setText(com.baidu.tbadk.core.util.ao.O(postData.getTime()));
            } else {
                jVar.fZG.setText(com.baidu.tbadk.core.util.ao.M(postData.getTime()));
            }
            if (z2) {
                final String name = bEV.getName();
                final String lat = bEV.getLat();
                final String lng = bEV.getLng();
                jVar.fZJ.setVisibility(0);
                jVar.fZJ.setPadding(this.fVj, 0, 0, 0);
                jVar.fZJ.setText(bEV.getName());
                jVar.fZJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kV()) {
                                com.baidu.tbadk.browser.a.ad(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(e.j.app_info_for_map)));
                            } else {
                                i.this.fYK.showToast(e.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fZJ.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZO.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fZO.setPadding(h, 0, h, 0);
            if (!this.fZa) {
                jVar.fZO.getLayoutStrategy().gN(e.f.icon_click);
            } else {
                jVar.fZO.jr(null);
                jVar.fZO.setBackgroundDrawable(null);
                jVar.fZO.getLayoutStrategy().gN(e.f.transparent_bg);
            }
            jVar.fZO.getLayoutStrategy().gK(e.f.pic_video);
            a(jVar.fZO, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fZO.setLayoutParams(layoutParams);
            jVar.fZO.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            jVar.fZO.setIsFromCDN(this.mIsFromCDN);
            jVar.fZO.setText(postData.bEU(), true, this.fZx);
            SparseArray sparseArray = (SparseArray) jVar.fZO.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            jVar.fZO.setTag(sparseArray);
            jVar.fZD.setTag(e.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gL(aO - (z ? getDimensionPixelSize(e.C0210e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gM((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bEW() > 0 && postData.bEP() != null && postData.bEP().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZQ.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fZQ.setLayoutParams(layoutParams);
                if (this.fZy == null) {
                    this.fZy = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fZy.setIsFromCDN(this.mIsFromCDN);
                    this.fZy.setOnLongClickListener(this.aUa);
                    this.fZy.M(this.fZi);
                    this.fZy.s(this.mCommonClickListener);
                    String str = null;
                    if (this.fYZ != null && this.fYZ.bhz() != null && this.fYZ.bhz().zT() != null) {
                        str = this.fYZ.bhz().zT().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fYZ != null) {
                        this.fZy.B(this.fYZ.bhL(), z);
                        this.fZy.aa(this.fYZ.bhz());
                    }
                }
                this.fZy.tI(postData.getId());
                jVar.fZQ.setSubPbAdapter(this.fZy);
                jVar.fZQ.setVisibility(0);
                jVar.fZQ.setData(postData, view);
                jVar.fZQ.setChildOnClickListener(this.mCommonClickListener);
                jVar.fZQ.setChildOnLongClickListener(this.aUa);
                jVar.fZQ.setChildOnTouchListener(this.fZz);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fZQ.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fZQ.setLayoutParams(layoutParams2);
                jVar.fZQ.setVisibility(8);
            }
            if (postData.hqm) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.gaa != null && jVar.fZX != null) {
            if (postData == null || postData.hqp == null || StringUtils.isNull(postData.hqp.liveTitle)) {
                jVar.fZX.setVisibility(8);
                return;
            }
            jVar.gaa.setText(postData.hqp.liveTitle);
            jVar.fZX.setTag(postData.hqp);
            jVar.fZX.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.c(jVar.cLX, e.d.cp_cont_f, 1);
                if (jVar.fZF.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.i(jVar.fZF, ((Integer) jVar.fZF.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fZG, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fZH, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fZI, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fZR, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fZJ, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fZK, e.f.icon_floor_more_selector);
                jVar.fZO.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fZQ, e.d.cp_bg_line_e);
                jVar.fZQ.onChangeSkinType();
                jVar.fZP.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.gaa, e.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fZY, e.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fZX, e.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fZZ, e.d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.gab, e.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.gae, e.d.cp_cont_j);
                if (jVar.gac.getVisibility() == 8) {
                    jVar.gae.setText(e.j.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.gaf, e.f.icon_arrow_gray_up);
                } else if (this.fYZ != null && StringUtils.isNull(this.fYZ.bhH())) {
                    jVar.gae.setText(this.fYZ.bhH());
                    com.baidu.tbadk.core.util.al.c(jVar.gaf, e.f.icon_arrow_gray_down);
                } else {
                    jVar.gae.setText(e.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(final j jVar) {
        jVar.fZD.setOnTouchListener(this.fZz);
        jVar.fZD.setOnLongClickListener(this.aUa);
        if (this.fYK.getPageContext() != null && this.fYK.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fYK.getPageContext().getOrignalPage()).fWO;
            jVar.cLX.setOnClickListener(aVar.elD);
            jVar.fZN.setOnClickListener(aVar.elD);
            jVar.fZT.setOnClickListener(aVar.elD);
            jVar.fZT.getHeadView().setOnClickListener(aVar.elD);
            jVar.fZO.setOnLongClickListener(this.aUa);
            jVar.fZO.setOnTouchListener(this.fZz);
            jVar.fZO.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fZO.setOnImageClickListener(this.bsE);
            jVar.fZO.setOnImageTouchListener(this.fZz);
            jVar.fZO.setOnEmotionClickListener(aVar.gkl);
            jVar.fZK.setOnClickListener(this.mCommonClickListener);
            jVar.fZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fZL.L(jVar.fZD);
                }
            });
            jVar.fZM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fZM.L(jVar.fZD);
                }
            });
            jVar.fZW.setOnClickListener(this.mCommonClickListener);
            jVar.fZX.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fZx = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fYZ = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void kC(boolean z) {
        this.fZa = z;
    }

    private SpannableStringBuilder aF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fYK.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fZO.setTextViewOnTouchListener(this.bsF);
        jVar.fZO.setTextViewCheckSelection(false);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fZi = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bsF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aUa = onLongClickListener;
    }
}
