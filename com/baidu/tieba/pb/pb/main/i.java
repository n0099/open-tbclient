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
    private View.OnLongClickListener aTr;
    private boolean brM;
    private TbRichTextView.h brP;
    private com.baidu.tieba.pb.a.c brQ;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dPr;
    private com.baidu.adp.lib.e.b<TbImageView> dPs;
    private int fUk;
    private int fUl;
    private int fUm;
    private com.baidu.tieba.pb.pb.sub.c fYA;
    private com.baidu.tieba.pb.a.c fYB;
    protected com.baidu.tieba.pb.data.d fYb;
    private boolean fYc;
    private View.OnClickListener fYk;
    private TbRichTextView.c fYz;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bw;
        if (noPressedLinearLayout.findViewById(e.g.view_floor_new_praise) != null && noPressedLinearLayout.findViewById(e.g.view_floor_new_praise).getTag(e.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(e.g.view_floor_new_praise);
            if (!((PostData) findViewById.getTag(e.g.tag_clip_board)).aDQ() && this.mCommonClickListener != null && this.fXM != null && (bw = this.fXM.bw(findViewById)) != null) {
                TiebaStatic.log(this.fXM.biw().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 5).x(VideoPlayActivityConfig.OBJ_ID, bw.aDQ() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fUk = 0;
        this.fUl = 0;
        this.fUm = 0;
        this.fYz = null;
        this.fYc = true;
        this.mHostId = null;
        this.fYb = null;
        this.fYk = null;
        this.mCommonClickListener = null;
        this.brP = null;
        this.brQ = null;
        this.aTr = null;
        this.fYA = null;
        this.brM = true;
        this.dPr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDC */
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
        this.dPs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Fu */
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
        this.fYB = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fXM == null || i.this.fXM.biq() == null || i.this.fXM.biq().bln())) {
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
                if (i.this.brQ != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.brQ.bt(view);
                        i.this.brQ.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fXM.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fYR.setConstrainLayoutPool(this.dPr);
        jVar.fYR.setImageViewPool(this.dPs);
        a(jVar);
        this.fUk = getDimensionPixelSize(e.C0210e.tbds12);
        this.fUl = getDimensionPixelSize(e.C0210e.tbds20);
        this.fUm = getDimensionPixelSize(e.C0210e.tbds36);
        if (jVar.fYQ != null) {
            jVar.fYQ.setDuiEnabled(this.brM);
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
            postData2.AD();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.brM = z;
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
            jVar.fZe.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.fZg.setText(e.j.expand_content);
            } else {
                jVar.fZg.setText(str);
            }
            com.baidu.tbadk.core.util.al.c(jVar.fZh, e.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fZe.setVisibility(0);
        jVar.fZg.setText(e.j.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.fZh, e.f.icon_arrow_gray_up_n);
    }

    private void b(final j jVar, final PostData postData) {
        if (postData.bEv() == 2 || postData.bEv() == 4) {
            jVar.fZf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fZe.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bhd());
                    postData.nu(z ? false : true);
                    i.this.c(jVar, postData);
                    if (i.this.fXM.biq() != null && i.this.fXM.biq().bml() != null && i.this.fXM.biq().getListView() != null && !z && jVar.getView().getTop() < i.this.fXM.biq().bml().getMeasuredHeight()) {
                        i.this.fXM.biq().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fXM.biq().getListView().getData(), postData) + i.this.fXM.biq().getListView().getHeaderViewsCount(), i.this.fXM.biq().bml().getMeasuredHeight());
                    }
                }
            });
            jVar.fZf.setVisibility(0);
            a(jVar, postData.bEe(), postData.bhd());
            a(true, jVar, postData);
        } else {
            jVar.fZf.setVisibility(8);
            jVar.fZe.setVisibility(0);
            a(false, jVar, postData);
        }
        c(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.I(postData.bEg());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fZf.getLayoutParams();
        if (z) {
            jVar.fYQ.getLayoutStrategy().gS(0);
            if (z2) {
                jVar.fYQ.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds26);
                }
            } else {
                jVar.fYQ.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fZf.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fYQ.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
        jVar.fYQ.getLayoutStrategy().gS(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, PostData postData) {
        TbRichText bEl = postData.bEl();
        bEl.isChanged = true;
        jVar.fYQ.setText(bEl, true, this.fYz);
    }

    private void g(PostData postData) {
        if (postData.auk == 0 && postData.dRB) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.aA("post_id", postData.getId());
            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aA("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.aA("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.aA("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.i("exposure_time", System.currentTimeMillis());
            if (this.fXM != null) {
                int bku = this.fXM.bhZ().bku();
                if (1 == bku || 2 == bku) {
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bku) {
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bnJ() == null) {
            jVar.fYY.setVisibility(8);
            return;
        }
        TbRichText bEl = postData.bEl();
        com.baidu.tieba.pb.view.c.a(postData.bnJ(), jVar.fYY, false, false, bEl != null && StringUtils.isNull(bEl.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fYc) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fYQ.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fYQ.setLayoutParams(layoutParams);
            jVar.fYQ.setPadding(0, 0, 0, 0);
            jVar.fYQ.jb(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fYQ.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0210e.ds20);
            jVar.fYQ.setLayoutParams(layoutParams2);
            jVar.fYQ.jb(postData.getBimg_url());
        }
        jVar.fYQ.setTextViewOnTouchListener(this.fYB);
        jVar.fYQ.setTextViewCheckSelection(false);
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
            if (postData.hph) {
                com.baidu.tbadk.core.util.al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fYP.setTag(null);
            jVar.fYP.setUserId(null);
            jVar.cLl.setText((CharSequence) null);
            jVar.fYV.getHeadView().setUserId(null);
            jVar.fYQ.setIsHost(false);
            if (postData.zG() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zG().getUserId())) {
                    jVar.fYQ.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zG().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zG().getTShowInfoNew();
                if (jVar.fYX != null) {
                    jVar.fYX.setTag(e.g.tag_user_id, postData.zG().getUserId());
                    jVar.fYX.setOnClickListener(this.fXM.fVQ.gjf);
                    jVar.fYX.a(iconInfo, 2, this.fUm, this.fUm, this.fUk);
                }
                if (jVar.fYW != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fYW.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fYW.setOnClickListener(this.fXM.fVQ.gjg);
                    jVar.fYW.a(tShowInfoNew, 3, this.fUm, this.fUm, this.fUk, true);
                }
                if (!com.baidu.tbadk.core.util.v.I(tShowInfoNew) || postData.zG().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.cLl, e.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.cLl, e.d.cp_cont_f, 1);
                }
                String portrait = postData.zG().getPortrait();
                jVar.cLl.setTag(e.g.tag_user_id, postData.zG().getUserId());
                jVar.cLl.setTag(e.g.tag_user_name, postData.zG().getUserName());
                jVar.cLl.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                String name_show = postData.zG().getName_show();
                String userName = postData.zG().getUserName();
                if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cLl.setText(com.baidu.tieba.pb.c.aE(this.mContext, jVar.cLl.getText().toString()));
                    jVar.cLl.setGravity(16);
                    jVar.cLl.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bgE());
                    com.baidu.tbadk.core.util.al.c(jVar.cLl, e.d.cp_other_e, 1);
                }
                if (postData.zG().getPendantData() != null && !StringUtils.isNull(postData.zG().getPendantData().ys())) {
                    jVar.fYV.b(postData.zG());
                    jVar.fYP.setVisibility(8);
                    jVar.fYV.setVisibility(0);
                    jVar.fYV.getHeadView().startLoad(portrait, 28, false);
                    jVar.fYV.getHeadView().setUserId(postData.zG().getUserId());
                    jVar.fYV.getHeadView().setUserName(postData.zG().getUserName());
                    jVar.fYV.getHeadView().setFid(this.fYb != null ? this.fYb.getForumId() : "");
                    jVar.fYV.getHeadView().setTid(postData.getId());
                    jVar.fYV.gm(postData.zG().getPendantData().ys());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fYP, postData.zG());
                    jVar.fYP.setUserId(postData.zG().getUserId());
                    jVar.fYP.setFid(this.fYb != null ? this.fYb.getForumId() : "");
                    jVar.fYP.setTid(postData.getId());
                    jVar.fYP.setUserName(postData.zG().getUserName(), postData.bEt());
                    jVar.fYP.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                    jVar.fYP.setImageDrawable(null);
                    jVar.fYP.startLoad(portrait, 28, false);
                    jVar.fYP.setVisibility(0);
                    jVar.fYV.setVisibility(8);
                }
                if (postData.zG() != null) {
                    MetaData zG = postData.zG();
                    int i2 = postData.bEb() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bEb() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    com.baidu.tbadk.core.util.al.i(jVar.fYH, i2);
                    com.baidu.tbadk.core.util.al.h(jVar.fYH, i3);
                    jVar.fYH.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(zG.getUserId())) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.host_name);
                    } else if (zG.getIs_bawu() == 1 && postData.bEb()) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.brand_Official);
                    } else if (zG.getIs_bawu() == 1 && "manager".equals(zG.getBawu_type())) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.bawu_member_bazhu_tip);
                    } else if (zG.getIs_bawu() == 1 && "assist".equals(zG.getBawu_type())) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fYH.setVisibility(8);
                        jVar.fYH.setTag(null);
                    }
                } else {
                    jVar.fYH.setVisibility(8);
                    jVar.fYH.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fXM.bhP()) {
                if (postData.zG() != null) {
                    i4 = postData.zG().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fYU.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fYU, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fYU.setVisibility(8);
            }
            int i5 = 15;
            if (jVar.fYX.getChildCount() == 1) {
                i5 = 13;
            } else if (jVar.fYX.getChildCount() > 1) {
                i5 = 11;
            }
            if (jVar.fYH.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fYW.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.AT() > 1000) {
                i5 -= 2;
            }
            if (postData.AT() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                jVar.fYX.setVisibility(8);
                if (jVar.fYX.getChildCount() == 1) {
                    i5 += 2;
                } else if (jVar.fYX.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && jVar.fYH.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fYH.setVisibility(8);
                }
                if (i5 < 10 && jVar.fYU.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fYU.setVisibility(8);
                }
            }
            String name_show2 = postData.zG() != null ? postData.zG().getName_show() : "";
            int iN = com.baidu.tbadk.util.y.iN(name_show2);
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                if (iN > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.y.K(name_show2, i5 - 2) + "...";
                }
            } else if (iN > i5) {
                name_show2 = com.baidu.tbadk.util.y.K(name_show2, i5) + "...";
            }
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                jVar.cLl.setText(aE(postData.zG().getSealPrefix(), name_show2));
            } else {
                jVar.cLl.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bEj()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fYb != null && this.fYb.bhh() != 0) {
                if (this.fYb.bhh() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.zG() != null) {
                    String userId = postData.zG().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fYb != null && this.fYb.bgV() != null && this.fYb.bgV().zG() != null && postData.zG() != null) {
                String userId2 = this.fYb.bgV().zG().getUserId();
                String userId3 = postData.zG().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.zG() != null && UtilHelper.isCurrentAccount(postData.zG().getUserId())) {
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
                    if (postData.bEj() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYb.bhh()));
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zG().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zG().getName_show());
                        }
                        if (this.fYb.bgV() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fYb.bgV().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYb.bhh()));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    jVar.fYQ.setTag(sparseArray);
                    jVar.fYM.setTag(sparseArray);
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
            if (postData.bEj() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fYQ.setTag(sparseArray);
            jVar.fYM.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fZi.a(postData);
            jVar.fYN.setTag(e.g.tag_clip_board, postData);
            jVar.fYN.setPostId(postData.getId());
            jVar.fYN.setThreadId(this.fXM.bhZ().bjP());
            jVar.fYN.setObjType(1);
            jVar.fYO.setThreadId(this.fXM.bhZ().bjP());
            jVar.fYO.setPostId(postData.getId());
            jVar.fYO.setObjType(1);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bEj() > 0) {
                String format = String.format(this.mContext.getString(e.j.is_floor), Integer.valueOf(postData.bEj()));
                jVar.fYT.setVisibility(0);
                jVar.fYT.setText(format);
                z = true;
            } else {
                jVar.fYT.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bEm = postData.bEm();
            boolean z2 = (bEm == null || StringUtils.isNull(bEm.getName())) ? false : true;
            if (z) {
                jVar.fYJ.setVisibility(0);
                i = this.fUl;
            } else {
                jVar.fYJ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fYK.setVisibility(0);
                i2 = this.fUl;
            } else {
                jVar.fYK.setVisibility(8);
                i2 = 0;
            }
            jVar.fYI.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fYI.setText(com.baidu.tbadk.core.util.ao.O(postData.getTime()));
            } else {
                jVar.fYI.setText(com.baidu.tbadk.core.util.ao.M(postData.getTime()));
            }
            if (z2) {
                final String name = bEm.getName();
                final String lat = bEm.getLat();
                final String lng = bEm.getLng();
                jVar.fYL.setVisibility(0);
                jVar.fYL.setPadding(this.fUl, 0, 0, 0);
                jVar.fYL.setText(bEm.getName());
                jVar.fYL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kV()) {
                                com.baidu.tbadk.browser.a.ad(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(e.j.app_info_for_map)));
                            } else {
                                i.this.fXM.showToast(e.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fYL.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fYQ.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fYQ.setPadding(h, 0, h, 0);
            if (!this.fYc) {
                jVar.fYQ.getLayoutStrategy().gN(e.f.icon_click);
            } else {
                jVar.fYQ.jb(null);
                jVar.fYQ.setBackgroundDrawable(null);
                jVar.fYQ.getLayoutStrategy().gN(e.f.transparent_bg);
            }
            jVar.fYQ.getLayoutStrategy().gK(e.f.pic_video);
            a(jVar.fYQ, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fYQ.setLayoutParams(layoutParams);
            jVar.fYQ.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            jVar.fYQ.setIsFromCDN(this.mIsFromCDN);
            jVar.fYQ.setText(postData.bEl(), true, this.fYz);
            SparseArray sparseArray = (SparseArray) jVar.fYQ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            jVar.fYQ.setTag(sparseArray);
            jVar.fYF.setTag(e.g.tag_from, sparseArray);
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
            if (postData.bEn() > 0 && postData.bEg() != null && postData.bEg().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fYS.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fYS.setLayoutParams(layoutParams);
                if (this.fYA == null) {
                    this.fYA = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fYA.setIsFromCDN(this.mIsFromCDN);
                    this.fYA.setOnLongClickListener(this.aTr);
                    this.fYA.M(this.fYk);
                    this.fYA.s(this.mCommonClickListener);
                    String str = null;
                    if (this.fYb != null && this.fYb.bgV() != null && this.fYb.bgV().zG() != null) {
                        str = this.fYb.bgV().zG().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fYb != null) {
                        this.fYA.B(this.fYb.bhh(), z);
                        this.fYA.aa(this.fYb.bgV());
                    }
                }
                this.fYA.ts(postData.getId());
                jVar.fYS.setSubPbAdapter(this.fYA);
                jVar.fYS.setVisibility(0);
                jVar.fYS.setData(postData, view);
                jVar.fYS.setChildOnClickListener(this.mCommonClickListener);
                jVar.fYS.setChildOnLongClickListener(this.aTr);
                jVar.fYS.setChildOnTouchListener(this.fYB);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fYS.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fYS.setLayoutParams(layoutParams2);
                jVar.fYS.setVisibility(8);
            }
            if (postData.hpg) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fZc != null && jVar.fYZ != null) {
            if (postData == null || postData.hpj == null || StringUtils.isNull(postData.hpj.liveTitle)) {
                jVar.fYZ.setVisibility(8);
                return;
            }
            jVar.fZc.setText(postData.hpj.liveTitle);
            jVar.fYZ.setTag(postData.hpj);
            jVar.fYZ.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.c(jVar.cLl, e.d.cp_cont_f, 1);
                if (jVar.fYH.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.i(jVar.fYH, ((Integer) jVar.fYH.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fYI, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fYJ, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fYK, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fYT, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fYL, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fYM, e.f.icon_floor_more_selector);
                jVar.fYQ.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fYS, e.d.cp_bg_line_e);
                jVar.fYS.onChangeSkinType();
                jVar.fYR.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.fZc, e.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fZa, e.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fYZ, e.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fZb, e.d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.fZd, e.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.fZg, e.d.cp_cont_j);
                if (jVar.fZe.getVisibility() == 8) {
                    jVar.fZg.setText(e.j.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.fZh, e.f.icon_arrow_gray_up);
                } else if (this.fYb != null && StringUtils.isNull(this.fYb.bhd())) {
                    jVar.fZg.setText(this.fYb.bhd());
                    com.baidu.tbadk.core.util.al.c(jVar.fZh, e.f.icon_arrow_gray_down);
                } else {
                    jVar.fZg.setText(e.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(final j jVar) {
        jVar.fYF.setOnTouchListener(this.fYB);
        jVar.fYF.setOnLongClickListener(this.aTr);
        if (this.fXM.getPageContext() != null && this.fXM.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fXM.getPageContext().getOrignalPage()).fVQ;
            jVar.cLl.setOnClickListener(aVar.ekW);
            jVar.fYP.setOnClickListener(aVar.ekW);
            jVar.fYV.setOnClickListener(aVar.ekW);
            jVar.fYV.getHeadView().setOnClickListener(aVar.ekW);
            jVar.fYQ.setOnLongClickListener(this.aTr);
            jVar.fYQ.setOnTouchListener(this.fYB);
            jVar.fYQ.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fYQ.setOnImageClickListener(this.brP);
            jVar.fYQ.setOnImageTouchListener(this.fYB);
            jVar.fYQ.setOnEmotionClickListener(aVar.gjh);
            jVar.fYM.setOnClickListener(this.mCommonClickListener);
            jVar.fYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fYN.L(jVar.fYF);
                }
            });
            jVar.fYO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fYO.L(jVar.fYF);
                }
            });
            jVar.fYY.setOnClickListener(this.mCommonClickListener);
            jVar.fYZ.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fYz = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fYb = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void kC(boolean z) {
        this.fYc = z;
    }

    private SpannableStringBuilder aE(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fXM.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fYQ.setTextViewOnTouchListener(this.brQ);
        jVar.fYQ.setTextViewCheckSelection(false);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fYk = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brP = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.brQ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTr = onLongClickListener;
    }
}
