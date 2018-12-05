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
    private View.OnLongClickListener aTo;
    private boolean brJ;
    private TbRichTextView.h brM;
    private com.baidu.tieba.pb.a.c brN;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dMD;
    private com.baidu.adp.lib.e.b<TbImageView> dME;
    private int fRs;
    private int fRt;
    private int fRu;
    private TbRichTextView.c fVH;
    private com.baidu.tieba.pb.pb.sub.c fVI;
    private com.baidu.tieba.pb.a.c fVJ;
    protected com.baidu.tieba.pb.data.d fVj;
    private boolean fVk;
    private View.OnClickListener fVs;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bt;
        if (noPressedLinearLayout.findViewById(e.g.view_floor_new_praise) != null && noPressedLinearLayout.findViewById(e.g.view_floor_new_praise).getTag(e.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(e.g.view_floor_new_praise);
            if (!((PostData) findViewById.getTag(e.g.tag_clip_board)).aDb() && this.mCommonClickListener != null && this.fUU != null && (bt = this.fUU.bt(findViewById)) != null) {
                TiebaStatic.log(this.fUU.bhL().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 5).x(VideoPlayActivityConfig.OBJ_ID, bt.aDb() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fRs = 0;
        this.fRt = 0;
        this.fRu = 0;
        this.fVH = null;
        this.fVk = true;
        this.mHostId = null;
        this.fVj = null;
        this.fVs = null;
        this.mCommonClickListener = null;
        this.brM = null;
        this.brN = null;
        this.aTo = null;
        this.fVI = null;
        this.brJ = true;
        this.dMD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aCN */
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
        this.dME = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ft */
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
        this.fVJ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fUU == null || i.this.fUU.bhF() == null || i.this.fUU.bhF().bkC())) {
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
                if (i.this.brN != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.brN.bq(view);
                        i.this.brN.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.fUU.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fVZ.setConstrainLayoutPool(this.dMD);
        jVar.fVZ.setImageViewPool(this.dME);
        a(jVar);
        this.fRs = getDimensionPixelSize(e.C0210e.tbds12);
        this.fRt = getDimensionPixelSize(e.C0210e.tbds20);
        this.fRu = getDimensionPixelSize(e.C0210e.tbds36);
        if (jVar.fVY != null) {
            jVar.fVY.setDuiEnabled(this.brJ);
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
        this.brJ = z;
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
            jVar.fWm.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.fWo.setText(e.j.expand_content);
            } else {
                jVar.fWo.setText(str);
            }
            com.baidu.tbadk.core.util.al.c(jVar.fWp, e.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fWm.setVisibility(0);
        jVar.fWo.setText(e.j.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.fWp, e.f.icon_arrow_gray_up_n);
    }

    private void b(final j jVar, final PostData postData) {
        if (postData.bDE() == 2 || postData.bDE() == 4) {
            jVar.fWn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fWm.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bgs());
                    postData.nr(z ? false : true);
                    i.this.c(jVar, postData);
                    if (i.this.fUU.bhF() != null && i.this.fUU.bhF().blA() != null && i.this.fUU.bhF().getListView() != null && !z && jVar.getView().getTop() < i.this.fUU.bhF().blA().getMeasuredHeight()) {
                        i.this.fUU.bhF().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fUU.bhF().getListView().getData(), postData) + i.this.fUU.bhF().getListView().getHeaderViewsCount(), i.this.fUU.bhF().blA().getMeasuredHeight());
                    }
                }
            });
            jVar.fWn.setVisibility(0);
            a(jVar, postData.bDn(), postData.bgs());
            a(true, jVar, postData);
        } else {
            jVar.fWn.setVisibility(8);
            jVar.fWm.setVisibility(0);
            a(false, jVar, postData);
        }
        c(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.I(postData.bDp());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fWn.getLayoutParams();
        if (z) {
            jVar.fVY.getLayoutStrategy().gR(0);
            if (z2) {
                jVar.fVY.getLayoutStrategy().gQ(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds26);
                }
            } else {
                jVar.fVY.getLayoutStrategy().gQ(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fWn.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fVY.getLayoutStrategy().gQ(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
        jVar.fVY.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, PostData postData) {
        TbRichText bDu = postData.bDu();
        bDu.isChanged = true;
        jVar.fVY.setText(bDu, true, this.fVH);
    }

    private void g(PostData postData) {
        if (postData.auk == 0 && postData.dON) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.aA("post_id", postData.getId());
            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aA("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.aA("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.aA("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.i("exposure_time", System.currentTimeMillis());
            if (this.fUU != null) {
                int bjJ = this.fUU.bho().bjJ();
                if (1 == bjJ || 2 == bjJ) {
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bjJ) {
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bmY() == null) {
            jVar.fWg.setVisibility(8);
            return;
        }
        TbRichText bDu = postData.bDu();
        com.baidu.tieba.pb.view.c.a(postData.bmY(), jVar.fWg, false, false, bDu != null && StringUtils.isNull(bDu.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fVk) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fVY.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fVY.setLayoutParams(layoutParams);
            jVar.fVY.setPadding(0, 0, 0, 0);
            jVar.fVY.ja(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fVY.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0210e.ds20);
            jVar.fVY.setLayoutParams(layoutParams2);
            jVar.fVY.ja(postData.getBimg_url());
        }
        jVar.fVY.setTextViewOnTouchListener(this.fVJ);
        jVar.fVY.setTextViewCheckSelection(false);
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
            if (postData.hlW) {
                com.baidu.tbadk.core.util.al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fVX.setTag(null);
            jVar.fVX.setUserId(null);
            jVar.cKl.setText((CharSequence) null);
            jVar.fWd.getHeadView().setUserId(null);
            jVar.fVY.setIsHost(false);
            if (postData.zG() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zG().getUserId())) {
                    jVar.fVY.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zG().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zG().getTShowInfoNew();
                if (jVar.fWf != null) {
                    jVar.fWf.setTag(e.g.tag_user_id, postData.zG().getUserId());
                    jVar.fWf.setOnClickListener(this.fUU.fSY.ggm);
                    jVar.fWf.a(iconInfo, 2, this.fRu, this.fRu, this.fRs);
                }
                if (jVar.fWe != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fWe.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fWe.setOnClickListener(this.fUU.fSY.ggn);
                    jVar.fWe.a(tShowInfoNew, 3, this.fRu, this.fRu, this.fRs, true);
                }
                if (!com.baidu.tbadk.core.util.v.I(tShowInfoNew) || postData.zG().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.cKl, e.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.cKl, e.d.cp_cont_f, 1);
                }
                String portrait = postData.zG().getPortrait();
                jVar.cKl.setTag(e.g.tag_user_id, postData.zG().getUserId());
                jVar.cKl.setTag(e.g.tag_user_name, postData.zG().getUserName());
                jVar.cKl.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                String name_show = postData.zG().getName_show();
                String userName = postData.zG().getUserName();
                if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cKl.setText(com.baidu.tieba.pb.c.aE(this.mContext, jVar.cKl.getText().toString()));
                    jVar.cKl.setGravity(16);
                    jVar.cKl.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bfT());
                    com.baidu.tbadk.core.util.al.c(jVar.cKl, e.d.cp_other_e, 1);
                }
                if (postData.zG().getPendantData() != null && !StringUtils.isNull(postData.zG().getPendantData().ys())) {
                    jVar.fWd.b(postData.zG());
                    jVar.fVX.setVisibility(8);
                    jVar.fWd.setVisibility(0);
                    jVar.fWd.getHeadView().startLoad(portrait, 28, false);
                    jVar.fWd.getHeadView().setUserId(postData.zG().getUserId());
                    jVar.fWd.getHeadView().setUserName(postData.zG().getUserName());
                    jVar.fWd.getHeadView().setFid(this.fVj != null ? this.fVj.getForumId() : "");
                    jVar.fWd.getHeadView().setTid(postData.getId());
                    jVar.fWd.gl(postData.zG().getPendantData().ys());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fVX, postData.zG());
                    jVar.fVX.setUserId(postData.zG().getUserId());
                    jVar.fVX.setFid(this.fVj != null ? this.fVj.getForumId() : "");
                    jVar.fVX.setTid(postData.getId());
                    jVar.fVX.setUserName(postData.zG().getUserName(), postData.bDC());
                    jVar.fVX.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                    jVar.fVX.setImageDrawable(null);
                    jVar.fVX.startLoad(portrait, 28, false);
                    jVar.fVX.setVisibility(0);
                    jVar.fWd.setVisibility(8);
                }
                if (postData.zG() != null) {
                    MetaData zG = postData.zG();
                    int i2 = postData.bDk() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bDk() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    com.baidu.tbadk.core.util.al.i(jVar.fVP, i2);
                    com.baidu.tbadk.core.util.al.h(jVar.fVP, i3);
                    jVar.fVP.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(zG.getUserId())) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.host_name);
                    } else if (zG.getIs_bawu() == 1 && postData.bDk()) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.brand_Official);
                    } else if (zG.getIs_bawu() == 1 && "manager".equals(zG.getBawu_type())) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.bawu_member_bazhu_tip);
                    } else if (zG.getIs_bawu() == 1 && "assist".equals(zG.getBawu_type())) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fVP.setVisibility(8);
                        jVar.fVP.setTag(null);
                    }
                } else {
                    jVar.fVP.setVisibility(8);
                    jVar.fVP.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fUU.bhe()) {
                if (postData.zG() != null) {
                    i4 = postData.zG().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fWc.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fWc, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fWc.setVisibility(8);
            }
            int i5 = 15;
            if (jVar.fWf.getChildCount() == 1) {
                i5 = 13;
            } else if (jVar.fWf.getChildCount() > 1) {
                i5 = 11;
            }
            if (jVar.fVP.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fWe.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.AT() > 1000) {
                i5 -= 2;
            }
            if (postData.AT() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                jVar.fWf.setVisibility(8);
                if (jVar.fWf.getChildCount() == 1) {
                    i5 += 2;
                } else if (jVar.fWf.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && jVar.fVP.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fVP.setVisibility(8);
                }
                if (i5 < 10 && jVar.fWc.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fWc.setVisibility(8);
                }
            }
            String name_show2 = postData.zG() != null ? postData.zG().getName_show() : "";
            int iM = com.baidu.tbadk.util.y.iM(name_show2);
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                if (iM > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.y.J(name_show2, i5 - 2) + "...";
                }
            } else if (iM > i5) {
                name_show2 = com.baidu.tbadk.util.y.J(name_show2, i5) + "...";
            }
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                jVar.cKl.setText(aE(postData.zG().getSealPrefix(), name_show2));
            } else {
                jVar.cKl.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bDs()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fVj != null && this.fVj.bgw() != 0) {
                if (this.fVj.bgw() != 1002) {
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
            if (this.fVj != null && this.fVj.bgk() != null && this.fVj.bgk().zG() != null && postData.zG() != null) {
                String userId2 = this.fVj.bgk().zG().getUserId();
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
                    if (postData.bDs() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fVj.bgw()));
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
                        if (this.fVj.bgk() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fVj.bgk().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fVj.bgw()));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    jVar.fVY.setTag(sparseArray);
                    jVar.fVU.setTag(sparseArray);
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
            if (postData.bDs() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fVY.setTag(sparseArray);
            jVar.fVU.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fWq.a(postData);
            jVar.fVV.setTag(e.g.tag_clip_board, postData);
            jVar.fVV.setPostId(postData.getId());
            jVar.fVV.setThreadId(this.fUU.bho().bje());
            jVar.fVV.setObjType(1);
            jVar.fVW.setThreadId(this.fUU.bho().bje());
            jVar.fVW.setPostId(postData.getId());
            jVar.fVW.setObjType(1);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bDs() > 0) {
                String format = String.format(this.mContext.getString(e.j.is_floor), Integer.valueOf(postData.bDs()));
                jVar.fWb.setVisibility(0);
                jVar.fWb.setText(format);
                z = true;
            } else {
                jVar.fWb.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bDv = postData.bDv();
            boolean z2 = (bDv == null || StringUtils.isNull(bDv.getName())) ? false : true;
            if (z) {
                jVar.fVR.setVisibility(0);
                i = this.fRt;
            } else {
                jVar.fVR.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fVS.setVisibility(0);
                i2 = this.fRt;
            } else {
                jVar.fVS.setVisibility(8);
                i2 = 0;
            }
            jVar.fVQ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fVQ.setText(com.baidu.tbadk.core.util.ao.N(postData.getTime()));
            } else {
                jVar.fVQ.setText(com.baidu.tbadk.core.util.ao.L(postData.getTime()));
            }
            if (z2) {
                final String name = bDv.getName();
                final String lat = bDv.getLat();
                final String lng = bDv.getLng();
                jVar.fVT.setVisibility(0);
                jVar.fVT.setPadding(this.fRt, 0, 0, 0);
                jVar.fVT.setText(bDv.getName());
                jVar.fVT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kV()) {
                                com.baidu.tbadk.browser.a.ad(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(e.j.app_info_for_map)));
                            } else {
                                i.this.fUU.showToast(e.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fVT.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fVY.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fVY.setPadding(h, 0, h, 0);
            if (!this.fVk) {
                jVar.fVY.getLayoutStrategy().gM(e.f.icon_click);
            } else {
                jVar.fVY.ja(null);
                jVar.fVY.setBackgroundDrawable(null);
                jVar.fVY.getLayoutStrategy().gM(e.f.transparent_bg);
            }
            jVar.fVY.getLayoutStrategy().gJ(e.f.pic_video);
            a(jVar.fVY, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fVY.setLayoutParams(layoutParams);
            jVar.fVY.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            jVar.fVY.setIsFromCDN(this.mIsFromCDN);
            jVar.fVY.setText(postData.bDu(), true, this.fVH);
            SparseArray sparseArray = (SparseArray) jVar.fVY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            jVar.fVY.setTag(sparseArray);
            jVar.fVN.setTag(e.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gK(aO - (z ? getDimensionPixelSize(e.C0210e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gL((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bDw() > 0 && postData.bDp() != null && postData.bDp().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fWa.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fWa.setLayoutParams(layoutParams);
                if (this.fVI == null) {
                    this.fVI = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fVI.setIsFromCDN(this.mIsFromCDN);
                    this.fVI.setOnLongClickListener(this.aTo);
                    this.fVI.M(this.fVs);
                    this.fVI.s(this.mCommonClickListener);
                    String str = null;
                    if (this.fVj != null && this.fVj.bgk() != null && this.fVj.bgk().zG() != null) {
                        str = this.fVj.bgk().zG().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fVj != null) {
                        this.fVI.B(this.fVj.bgw(), z);
                        this.fVI.aa(this.fVj.bgk());
                    }
                }
                this.fVI.tp(postData.getId());
                jVar.fWa.setSubPbAdapter(this.fVI);
                jVar.fWa.setVisibility(0);
                jVar.fWa.setData(postData, view);
                jVar.fWa.setChildOnClickListener(this.mCommonClickListener);
                jVar.fWa.setChildOnLongClickListener(this.aTo);
                jVar.fWa.setChildOnTouchListener(this.fVJ);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fWa.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fWa.setLayoutParams(layoutParams2);
                jVar.fWa.setVisibility(8);
            }
            if (postData.hlV) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fWk != null && jVar.fWh != null) {
            if (postData == null || postData.hlY == null || StringUtils.isNull(postData.hlY.liveTitle)) {
                jVar.fWh.setVisibility(8);
                return;
            }
            jVar.fWk.setText(postData.hlY.liveTitle);
            jVar.fWh.setTag(postData.hlY);
            jVar.fWh.setVisibility(0);
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
                com.baidu.tbadk.core.util.al.c(jVar.cKl, e.d.cp_cont_f, 1);
                if (jVar.fVP.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.i(jVar.fVP, ((Integer) jVar.fVP.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fVQ, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fVR, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fVS, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fWb, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fVT, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fVU, e.f.icon_floor_more_selector);
                jVar.fVY.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fWa, e.d.cp_bg_line_e);
                jVar.fWa.onChangeSkinType();
                jVar.fVZ.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.fWk, e.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fWi, e.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fWh, e.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fWj, e.d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.fWl, e.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.fWo, e.d.cp_cont_j);
                if (jVar.fWm.getVisibility() == 8) {
                    jVar.fWo.setText(e.j.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.fWp, e.f.icon_arrow_gray_up);
                } else if (this.fVj != null && StringUtils.isNull(this.fVj.bgs())) {
                    jVar.fWo.setText(this.fVj.bgs());
                    com.baidu.tbadk.core.util.al.c(jVar.fWp, e.f.icon_arrow_gray_down);
                } else {
                    jVar.fWo.setText(e.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(final j jVar) {
        jVar.fVN.setOnTouchListener(this.fVJ);
        jVar.fVN.setOnLongClickListener(this.aTo);
        if (this.fUU.getPageContext() != null && this.fUU.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fUU.getPageContext().getOrignalPage()).fSY;
            jVar.cKl.setOnClickListener(aVar.eig);
            jVar.fVX.setOnClickListener(aVar.eig);
            jVar.fWd.setOnClickListener(aVar.eig);
            jVar.fWd.getHeadView().setOnClickListener(aVar.eig);
            jVar.fVY.setOnLongClickListener(this.aTo);
            jVar.fVY.setOnTouchListener(this.fVJ);
            jVar.fVY.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fVY.setOnImageClickListener(this.brM);
            jVar.fVY.setOnImageTouchListener(this.fVJ);
            jVar.fVY.setOnEmotionClickListener(aVar.ggo);
            jVar.fVU.setOnClickListener(this.mCommonClickListener);
            jVar.fVV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fVV.L(jVar.fVN);
                }
            });
            jVar.fVW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fVW.L(jVar.fVN);
                }
            });
            jVar.fWg.setOnClickListener(this.mCommonClickListener);
            jVar.fWh.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fVH = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fVj = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void kz(boolean z) {
        this.fVk = z;
    }

    private SpannableStringBuilder aE(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fUU.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fVY.setTextViewOnTouchListener(this.brN);
        jVar.fVY.setTextViewCheckSelection(false);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fVs = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brM = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.brN = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTo = onLongClickListener;
    }
}
