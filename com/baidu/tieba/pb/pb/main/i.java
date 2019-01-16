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
    private View.OnLongClickListener aTZ;
    private boolean bsA;
    private TbRichTextView.h bsD;
    private com.baidu.tieba.pb.a.c bsE;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQa;
    private com.baidu.adp.lib.e.b<TbImageView> dQb;
    private int fVh;
    private int fVi;
    private int fVj;
    protected com.baidu.tieba.pb.data.d fYY;
    private boolean fYZ;
    private View.OnClickListener fZh;
    private TbRichTextView.c fZw;
    private com.baidu.tieba.pb.pb.sub.c fZx;
    private com.baidu.tieba.pb.a.c fZy;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bw;
        if (noPressedLinearLayout.findViewById(e.g.view_floor_new_praise) != null && noPressedLinearLayout.findViewById(e.g.view_floor_new_praise).getTag(e.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(e.g.view_floor_new_praise);
            if (!((PostData) findViewById.getTag(e.g.tag_clip_board)).aEn() && this.mCommonClickListener != null && this.fYJ != null && (bw = this.fYJ.bw(findViewById)) != null) {
                TiebaStatic.log(this.fYJ.bja().y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).y("obj_locate", 5).y(VideoPlayActivityConfig.OBJ_ID, bw.aEn() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fVh = 0;
        this.fVi = 0;
        this.fVj = 0;
        this.fZw = null;
        this.fYZ = true;
        this.mHostId = null;
        this.fYY = null;
        this.fZh = null;
        this.mCommonClickListener = null;
        this.bsD = null;
        this.bsE = null;
        this.aTZ = null;
        this.fZx = null;
        this.bsA = true;
        this.dQa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
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
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
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
        this.fZy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fYJ == null || i.this.fYJ.biU() == null || i.this.fYJ.biU().blV())) {
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
                if (i.this.bsE != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bsE.bt(view);
                        i.this.bsE.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fYJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fZO.setConstrainLayoutPool(this.dQa);
        jVar.fZO.setImageViewPool(this.dQb);
        a(jVar);
        this.fVh = getDimensionPixelSize(e.C0210e.tbds12);
        this.fVi = getDimensionPixelSize(e.C0210e.tbds20);
        this.fVj = getDimensionPixelSize(e.C0210e.tbds36);
        if (jVar.fZN != null) {
            jVar.fZN.setDuiEnabled(this.bsA);
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
        this.bsA = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.I(postData.bEP())) {
            int i = 8;
            if (postData.hqt) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.fYY, postData, postData.locate, i, 6);
            postData.hqu = b;
            Iterator<PostData> it = postData.bEP().iterator();
            while (it.hasNext()) {
                it.next().hqu = b;
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
            jVar.gab.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.gad.setText(e.j.expand_content);
            } else {
                jVar.gad.setText(str);
            }
            com.baidu.tbadk.core.util.al.c(jVar.gae, e.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.gab.setVisibility(0);
        jVar.gad.setText(e.j.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.gae, e.f.icon_arrow_gray_up_n);
    }

    private void b(final j jVar, final PostData postData) {
        if (postData.bFe() == 2 || postData.bFe() == 4) {
            jVar.gac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.gab.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bhH());
                    postData.nv(z ? false : true);
                    i.this.c(jVar, postData);
                    if (i.this.fYJ.biU() != null && i.this.fYJ.biU().bmT() != null && i.this.fYJ.biU().getListView() != null && !z && jVar.getView().getTop() < i.this.fYJ.biU().bmT().getMeasuredHeight()) {
                        i.this.fYJ.biU().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fYJ.biU().getListView().getData(), postData) + i.this.fYJ.biU().getListView().getHeaderViewsCount(), i.this.fYJ.biU().bmT().getMeasuredHeight());
                    }
                }
            });
            jVar.gac.setVisibility(0);
            a(jVar, postData.bEN(), postData.bhH());
            a(true, jVar, postData);
        } else {
            jVar.gac.setVisibility(8);
            jVar.gab.setVisibility(0);
            a(false, jVar, postData);
        }
        c(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.I(postData.bEP());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.gac.getLayoutParams();
        if (z) {
            jVar.fZN.getLayoutStrategy().gS(0);
            if (z2) {
                jVar.fZN.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds26);
                }
            } else {
                jVar.fZN.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.gac.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fZN.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
        jVar.fZN.getLayoutStrategy().gS(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, PostData postData) {
        TbRichText bEU = postData.bEU();
        bEU.isChanged = true;
        jVar.fZN.setText(bEU, true, this.fZw);
    }

    private void h(PostData postData) {
        if (postData.auM == 0 && postData.dSk) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.aB("post_id", postData.getId());
            amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aB("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.aB("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.aB("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.i("exposure_time", System.currentTimeMillis());
            if (this.fYJ != null) {
                int blc = this.fYJ.biD().blc();
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
        com.baidu.tieba.pb.c.a.a(this.fYJ.getUniqueId(), this.fYY, postData, postData.locate, postData.hqt ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bor() == null) {
            jVar.fZV.setVisibility(8);
            return;
        }
        TbRichText bEU = postData.bEU();
        com.baidu.tieba.pb.view.c.a(postData.bor(), jVar.fZV, false, false, bEU != null && StringUtils.isNull(bEU.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fYZ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZN.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fZN.setLayoutParams(layoutParams);
            jVar.fZN.setPadding(0, 0, 0, 0);
            jVar.fZN.jr(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fZN.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0210e.ds20);
            jVar.fZN.setLayoutParams(layoutParams2);
            jVar.fZN.jr(postData.getBimg_url());
        }
        jVar.fZN.setTextViewOnTouchListener(this.fZy);
        jVar.fZN.setTextViewCheckSelection(false);
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
            if (postData.hqm) {
                com.baidu.tbadk.core.util.al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fZM.setTag(null);
            jVar.fZM.setUserId(null);
            jVar.cLW.setText((CharSequence) null);
            jVar.fZS.getHeadView().setUserId(null);
            jVar.fZN.setIsHost(false);
            if (postData.zT() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zT().getUserId())) {
                    jVar.fZN.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zT().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zT().getTShowInfoNew();
                if (jVar.fZU != null) {
                    jVar.fZU.setTag(e.g.tag_user_id, postData.zT().getUserId());
                    jVar.fZU.setOnClickListener(this.fYJ.fWN.gki);
                    jVar.fZU.a(iconInfo, 2, this.fVj, this.fVj, this.fVh);
                }
                if (jVar.fZT != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fZT.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fZT.setOnClickListener(this.fYJ.fWN.gkj);
                    jVar.fZT.a(tShowInfoNew, 3, this.fVj, this.fVj, this.fVh, true);
                }
                if (!com.baidu.tbadk.core.util.v.I(tShowInfoNew) || postData.zT().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.cLW, e.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.cLW, e.d.cp_cont_f, 1);
                }
                String portrait = postData.zT().getPortrait();
                int i2 = 8;
                if (postData.hqt) {
                    i2 = 2;
                }
                jVar.cLW.setTag(e.g.tag_user_id, postData.zT().getUserId());
                jVar.cLW.setTag(e.g.tag_user_name, postData.zT().getUserName());
                jVar.cLW.setTag(e.g.tag_virtual_user_url, postData.zT().getVirtualUserUrl());
                jVar.cLW.setTag(e.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.fYY, postData, postData.locate, i2, 2));
                String name_show = postData.zT().getName_show();
                String userName = postData.zT().getUserName();
                if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cLW.setText(com.baidu.tieba.pb.c.aC(this.mContext, jVar.cLW.getText().toString()));
                    jVar.cLW.setGravity(16);
                    jVar.cLW.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                    com.baidu.tbadk.core.util.al.c(jVar.cLW, e.d.cp_other_e, 1);
                }
                if (postData.zT().getPendantData() != null && !StringUtils.isNull(postData.zT().getPendantData().yF())) {
                    jVar.fZS.b(postData.zT());
                    jVar.fZM.setVisibility(8);
                    jVar.fZS.setVisibility(0);
                    jVar.fZS.getHeadView().startLoad(portrait, 28, false);
                    jVar.fZS.getHeadView().setUserId(postData.zT().getUserId());
                    jVar.fZS.getHeadView().setUserName(postData.zT().getUserName());
                    jVar.fZS.getHeadView().setFid(this.fYY != null ? this.fYY.getForumId() : "");
                    jVar.fZS.getHeadView().setTid(postData.getId());
                    jVar.fZS.getHeadView().setTag(e.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.fYY, postData, postData.locate, i2, 2));
                    jVar.fZS.gA(postData.zT().getPendantData().yF());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fZM, postData.zT());
                    jVar.fZM.setUserId(postData.zT().getUserId());
                    jVar.fZM.setFid(this.fYY != null ? this.fYY.getForumId() : "");
                    jVar.fZM.setTid(postData.getId());
                    jVar.fZM.setUserName(postData.zT().getUserName(), postData.bFc());
                    jVar.fZM.setTag(e.g.tag_virtual_user_url, postData.zT().getVirtualUserUrl());
                    jVar.fZM.setTag(e.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.fYY, postData, postData.locate, i2, 2));
                    jVar.fZM.setImageDrawable(null);
                    jVar.fZM.startLoad(portrait, 28, false);
                    jVar.fZM.setVisibility(0);
                    jVar.fZS.setVisibility(8);
                }
                if (postData.zT() != null) {
                    MetaData zT = postData.zT();
                    int i3 = postData.bEK() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i4 = postData.bEK() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    com.baidu.tbadk.core.util.al.i(jVar.fZE, i3);
                    com.baidu.tbadk.core.util.al.h(jVar.fZE, i4);
                    jVar.fZE.setTag(Integer.valueOf(i3));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(zT.getUserId())) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.host_name);
                    } else if (zT.getIs_bawu() == 1 && postData.bEK()) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.brand_Official);
                    } else if (zT.getIs_bawu() == 1 && "manager".equals(zT.getBawu_type())) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.bawu_member_bazhu_tip);
                    } else if (zT.getIs_bawu() == 1 && "assist".equals(zT.getBawu_type())) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fZE.setVisibility(8);
                        jVar.fZE.setTag(null);
                    }
                } else {
                    jVar.fZE.setVisibility(8);
                    jVar.fZE.setTag(null);
                }
            }
            int i5 = 0;
            if (this.fYJ.bit()) {
                if (postData.zT() != null) {
                    i5 = postData.zT().getLevel_id();
                }
            } else {
                i5 = 0;
            }
            if (i5 > 0) {
                jVar.fZR.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fZR, BitmapHelper.getGradeResourceIdInEnterForum(i5));
            } else {
                jVar.fZR.setVisibility(8);
            }
            int i6 = 15;
            if (jVar.fZU.getChildCount() == 1) {
                i6 = 13;
            } else if (jVar.fZU.getChildCount() > 1) {
                i6 = 11;
            }
            if (jVar.fZE.getVisibility() == 0) {
                i6 -= 2;
            }
            if (jVar.fZT.getChildCount() > 0) {
                i6 -= 2;
            }
            if (postData.Bg() > 1000) {
                i6 -= 2;
            }
            if (postData.Bg() > 10) {
                i6 -= 2;
            }
            if (i6 < 10) {
                jVar.fZU.setVisibility(8);
                if (jVar.fZU.getChildCount() == 1) {
                    i6 += 2;
                } else if (jVar.fZU.getChildCount() > 1) {
                    i6 += 4;
                }
                if (i6 < 10 && jVar.fZE.getVisibility() == 0) {
                    i6 += 2;
                    jVar.fZE.setVisibility(8);
                }
                if (i6 < 10 && jVar.fZR.getVisibility() == 0) {
                    i6 += 2;
                    jVar.fZR.setVisibility(8);
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
                jVar.cLW.setText(aF(postData.zT().getSealPrefix(), name_show2));
            } else {
                jVar.cLW.setText(name_show2);
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
            if (this.fYY != null && this.fYY.bhL() != 0) {
                if (this.fYY.bhL() != 1002) {
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
            if (this.fYY != null && this.fYY.bhz() != null && this.fYY.bhz().zT() != null && postData.zT() != null) {
                String userId2 = this.fYY.bhz().zT().getUserId();
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
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYY.bhL()));
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
                        if (this.fYY.bhz() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fYY.bhz().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYY.bhL()));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i7));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    jVar.fZN.setTag(sparseArray);
                    jVar.fZJ.setTag(sparseArray);
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
            jVar.fZN.setTag(sparseArray);
            jVar.fZJ.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.gaf.a(postData);
            jVar.fZK.setTag(e.g.tag_clip_board, postData);
            jVar.fZK.setPostId(postData.getId());
            jVar.fZK.setThreadId(this.fYJ.biD().bkt());
            jVar.fZK.setObjType(1);
            jVar.fZL.setThreadId(this.fYJ.biD().bkt());
            jVar.fZL.setPostId(postData.getId());
            jVar.fZL.setObjType(1);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bES() > 0) {
                String format = String.format(this.mContext.getString(e.j.is_floor), Integer.valueOf(postData.bES()));
                jVar.fZQ.setVisibility(0);
                jVar.fZQ.setText(format);
                z = true;
            } else {
                jVar.fZQ.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bEV = postData.bEV();
            boolean z2 = (bEV == null || StringUtils.isNull(bEV.getName())) ? false : true;
            if (z) {
                jVar.fZG.setVisibility(0);
                i = this.fVi;
            } else {
                jVar.fZG.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fZH.setVisibility(0);
                i2 = this.fVi;
            } else {
                jVar.fZH.setVisibility(8);
                i2 = 0;
            }
            jVar.fZF.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fZF.setText(com.baidu.tbadk.core.util.ao.O(postData.getTime()));
            } else {
                jVar.fZF.setText(com.baidu.tbadk.core.util.ao.M(postData.getTime()));
            }
            if (z2) {
                final String name = bEV.getName();
                final String lat = bEV.getLat();
                final String lng = bEV.getLng();
                jVar.fZI.setVisibility(0);
                jVar.fZI.setPadding(this.fVi, 0, 0, 0);
                jVar.fZI.setText(bEV.getName());
                jVar.fZI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kV()) {
                                com.baidu.tbadk.browser.a.ad(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(e.j.app_info_for_map)));
                            } else {
                                i.this.fYJ.showToast(e.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fZI.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZN.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fZN.setPadding(h, 0, h, 0);
            if (!this.fYZ) {
                jVar.fZN.getLayoutStrategy().gN(e.f.icon_click);
            } else {
                jVar.fZN.jr(null);
                jVar.fZN.setBackgroundDrawable(null);
                jVar.fZN.getLayoutStrategy().gN(e.f.transparent_bg);
            }
            jVar.fZN.getLayoutStrategy().gK(e.f.pic_video);
            a(jVar.fZN, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fZN.setLayoutParams(layoutParams);
            jVar.fZN.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            jVar.fZN.setIsFromCDN(this.mIsFromCDN);
            jVar.fZN.setText(postData.bEU(), true, this.fZw);
            SparseArray sparseArray = (SparseArray) jVar.fZN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            jVar.fZN.setTag(sparseArray);
            jVar.fZC.setTag(e.g.tag_from, sparseArray);
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
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZP.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fZP.setLayoutParams(layoutParams);
                if (this.fZx == null) {
                    this.fZx = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fZx.setIsFromCDN(this.mIsFromCDN);
                    this.fZx.setOnLongClickListener(this.aTZ);
                    this.fZx.M(this.fZh);
                    this.fZx.s(this.mCommonClickListener);
                    String str = null;
                    if (this.fYY != null && this.fYY.bhz() != null && this.fYY.bhz().zT() != null) {
                        str = this.fYY.bhz().zT().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fYY != null) {
                        this.fZx.B(this.fYY.bhL(), z);
                        this.fZx.aa(this.fYY.bhz());
                    }
                }
                this.fZx.tI(postData.getId());
                jVar.fZP.setSubPbAdapter(this.fZx);
                jVar.fZP.setVisibility(0);
                jVar.fZP.setData(postData, view);
                jVar.fZP.setChildOnClickListener(this.mCommonClickListener);
                jVar.fZP.setChildOnLongClickListener(this.aTZ);
                jVar.fZP.setChildOnTouchListener(this.fZy);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fZP.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fZP.setLayoutParams(layoutParams2);
                jVar.fZP.setVisibility(8);
            }
            if (postData.hql) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fZZ != null && jVar.fZW != null) {
            if (postData == null || postData.hqo == null || StringUtils.isNull(postData.hqo.liveTitle)) {
                jVar.fZW.setVisibility(8);
                return;
            }
            jVar.fZZ.setText(postData.hqo.liveTitle);
            jVar.fZW.setTag(postData.hqo);
            jVar.fZW.setVisibility(0);
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
                com.baidu.tbadk.core.util.al.c(jVar.cLW, e.d.cp_cont_f, 1);
                if (jVar.fZE.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.i(jVar.fZE, ((Integer) jVar.fZE.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fZF, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fZG, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fZH, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fZQ, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fZI, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fZJ, e.f.icon_floor_more_selector);
                jVar.fZN.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fZP, e.d.cp_bg_line_e);
                jVar.fZP.onChangeSkinType();
                jVar.fZO.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.fZZ, e.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fZX, e.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fZW, e.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fZY, e.d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.gaa, e.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.gad, e.d.cp_cont_j);
                if (jVar.gab.getVisibility() == 8) {
                    jVar.gad.setText(e.j.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.gae, e.f.icon_arrow_gray_up);
                } else if (this.fYY != null && StringUtils.isNull(this.fYY.bhH())) {
                    jVar.gad.setText(this.fYY.bhH());
                    com.baidu.tbadk.core.util.al.c(jVar.gae, e.f.icon_arrow_gray_down);
                } else {
                    jVar.gad.setText(e.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(final j jVar) {
        jVar.fZC.setOnTouchListener(this.fZy);
        jVar.fZC.setOnLongClickListener(this.aTZ);
        if (this.fYJ.getPageContext() != null && this.fYJ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fYJ.getPageContext().getOrignalPage()).fWN;
            jVar.cLW.setOnClickListener(aVar.elC);
            jVar.fZM.setOnClickListener(aVar.elC);
            jVar.fZS.setOnClickListener(aVar.elC);
            jVar.fZS.getHeadView().setOnClickListener(aVar.elC);
            jVar.fZN.setOnLongClickListener(this.aTZ);
            jVar.fZN.setOnTouchListener(this.fZy);
            jVar.fZN.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fZN.setOnImageClickListener(this.bsD);
            jVar.fZN.setOnImageTouchListener(this.fZy);
            jVar.fZN.setOnEmotionClickListener(aVar.gkk);
            jVar.fZJ.setOnClickListener(this.mCommonClickListener);
            jVar.fZK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fZK.L(jVar.fZC);
                }
            });
            jVar.fZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fZL.L(jVar.fZC);
                }
            });
            jVar.fZV.setOnClickListener(this.mCommonClickListener);
            jVar.fZW.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fZw = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fYY = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void kC(boolean z) {
        this.fYZ = z;
    }

    private SpannableStringBuilder aF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fYJ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fZN.setTextViewOnTouchListener(this.bsE);
        jVar.fZN.setTextViewCheckSelection(false);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fZh = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bsE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTZ = onLongClickListener;
    }
}
