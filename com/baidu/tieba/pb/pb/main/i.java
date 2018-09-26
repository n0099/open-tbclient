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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private View.OnLongClickListener aKx;
    private com.baidu.tieba.pb.a.c bjA;
    private boolean bjw;
    private TbRichTextView.h bjz;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dwN;
    private com.baidu.adp.lib.e.b<TbImageView> dwO;
    private int fBB;
    private int fBC;
    private int fBD;
    private View.OnClickListener fFB;
    private TbRichTextView.c fFQ;
    private com.baidu.tieba.pb.pb.sub.c fFR;
    private com.baidu.tieba.pb.a.c fFS;
    protected com.baidu.tieba.pb.data.d fFs;
    private boolean fFt;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData br;
        if (noPressedLinearLayout.findViewById(e.g.view_floor_new_praise) != null && noPressedLinearLayout.findViewById(e.g.view_floor_new_praise).getTag(e.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(e.g.view_floor_new_praise);
            if (!((PostData) findViewById.getTag(e.g.tag_clip_board)).ayA() && this.mCommonClickListener != null && this.fFd != null && (br = this.fFd.br(findViewById)) != null) {
                TiebaStatic.log(this.fFd.bdl().w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).w("obj_locate", 5).w(VideoPlayActivityConfig.OBJ_ID, br.ayA() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fBB = 0;
        this.fBC = 0;
        this.fBD = 0;
        this.fFQ = null;
        this.fFt = true;
        this.mHostId = null;
        this.fFs = null;
        this.fFB = null;
        this.mCommonClickListener = null;
        this.bjz = null;
        this.bjA = null;
        this.aKx = null;
        this.fFR = null;
        this.bjw = true;
        this.dwN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ayk */
            public ConstrainImageLayout jm() {
                return new ConstrainImageLayout(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void r(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout t(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dwO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ca */
            public TbImageView jm() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void r(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView s(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView t(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fFS = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.fFd == null || i.this.fFd.bdf() == null || i.this.fFd.bdf().bgb())) {
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
                if (i.this.bjA != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.bjA.bo(view);
                        i.this.bjA.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bi */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.fFd.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fGi.setConstrainLayoutPool(this.dwN);
        jVar.fGi.setImageViewPool(this.dwO);
        a(jVar);
        this.fBB = getDimensionPixelSize(e.C0141e.tbds12);
        this.fBC = getDimensionPixelSize(e.C0141e.tbds20);
        this.fBD = getDimensionPixelSize(e.C0141e.tbds36);
        if (jVar.fGh != null) {
            jVar.fGh.setDuiEnabled(this.bjw);
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
            postData2.xj();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bjw = z;
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
    public void a(j jVar, boolean z) {
        if (z) {
            jVar.fGv.setVisibility(8);
            jVar.fGx.setText(e.j.expand_content);
            com.baidu.tbadk.core.util.al.c(jVar.fGy, e.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fGv.setVisibility(0);
        jVar.fGx.setText(e.j.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.fGy, e.f.icon_arrow_gray_up_n);
    }

    private void b(final j jVar, final PostData postData) {
        if (postData.byY() == 2) {
            jVar.fGw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fGv.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mN(z ? false : true);
                    i.this.c(jVar, postData);
                    if (i.this.fFd.bdf() != null && i.this.fFd.bdf().bgY() != null && i.this.fFd.bdf().getListView() != null && !z && jVar.getView().getTop() < i.this.fFd.bdf().bgY().getMeasuredHeight()) {
                        i.this.fFd.bdf().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.fFd.bdf().getListView().getData(), postData) + i.this.fFd.bdf().getListView().getHeaderViewsCount(), i.this.fFd.bdf().bgY().getMeasuredHeight());
                    }
                }
            });
            jVar.fGx.setText(this.fFs.bbR());
            jVar.fGw.setVisibility(0);
            a(jVar, postData.byH());
            a(true, jVar, postData);
        } else {
            jVar.fGw.setVisibility(8);
            jVar.fGv.setVisibility(0);
            a(false, jVar, postData);
        }
        c(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.z(postData.byJ());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fGw.getLayoutParams();
        if (z) {
            jVar.fGh.getLayoutStrategy().gh(0);
            if (z2) {
                jVar.fGh.getLayoutStrategy().gg(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds26);
                }
            } else {
                jVar.fGh.getLayoutStrategy().gg(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fGw.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fGh.getLayoutStrategy().gg(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds30));
        jVar.fGh.getLayoutStrategy().gh(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, PostData postData) {
        TbRichText byO = postData.byO();
        byO.isChanged = true;
        jVar.fGh.setText(byO, true, this.fFQ);
    }

    private void g(PostData postData) {
        if (postData.alb == 0 && postData.dyT) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.al("post_id", postData.getId());
            amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.al("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.al("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.al("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.g("exposure_time", System.currentTimeMillis());
            if (this.fFd != null) {
                int bfi = this.fFd.bcO().bfi();
                if (1 == bfi || 2 == bfi) {
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bfi) {
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bix() == null) {
            jVar.fGp.setVisibility(8);
            return;
        }
        TbRichText byO = postData.byO();
        com.baidu.tieba.pb.view.c.a(postData.bix(), jVar.fGp, false, false, byO != null && StringUtils.isNull(byO.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fFt) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fGh.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fGh.setLayoutParams(layoutParams);
            jVar.fGh.setPadding(0, 0, 0, 0);
            jVar.fGh.it(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fGh.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0141e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0141e.ds20);
            jVar.fGh.setLayoutParams(layoutParams2);
            jVar.fGh.it(postData.getBimg_url());
        }
        jVar.fGh.setTextViewOnTouchListener(this.fFS);
        jVar.fGh.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x06d4  */
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
            if (postData.gWj) {
                com.baidu.tbadk.core.util.al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.fGg.setTag(null);
            jVar.fGg.setUserId(null);
            jVar.cyw.setText((CharSequence) null);
            jVar.fGm.getHeadView().setUserId(null);
            jVar.fGh.setIsHost(false);
            if (postData.wm() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.wm().getUserId())) {
                    jVar.fGh.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.wm().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.wm().getTShowInfoNew();
                if (jVar.fGo != null) {
                    jVar.fGo.setTag(e.g.tag_user_id, postData.wm().getUserId());
                    jVar.fGo.setOnClickListener(this.fFd.fDh.fQv);
                    jVar.fGo.a(iconInfo, 2, this.fBD, this.fBD, this.fBB);
                }
                if (jVar.fGn != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fGn.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fGn.setOnClickListener(this.fFd.fDh.fQw);
                    jVar.fGn.a(tShowInfoNew, 3, this.fBD, this.fBD, this.fBB, true);
                }
                if (!com.baidu.tbadk.core.util.v.z(tShowInfoNew) || postData.wm().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.cyw, e.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.cyw, e.d.cp_cont_f, 1);
                }
                String portrait = postData.wm().getPortrait();
                jVar.cyw.setTag(e.g.tag_user_id, postData.wm().getUserId());
                jVar.cyw.setTag(e.g.tag_user_name, postData.wm().getUserName());
                jVar.cyw.setTag(e.g.tag_virtual_user_url, postData.wm().getVirtualUserUrl());
                String name_show = postData.wm().getName_show();
                String userName = postData.wm().getUserName();
                if (com.baidu.tbadk.p.am.jw() && name_show != null && !name_show.equals(userName)) {
                    jVar.cyw.setText(com.baidu.tieba.pb.c.aB(this.mContext, jVar.cyw.getText().toString()));
                    jVar.cyw.setGravity(16);
                    jVar.cyw.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bbr());
                    com.baidu.tbadk.core.util.al.c(jVar.cyw, e.d.cp_other_e, 1);
                }
                if (postData.wm().getPendantData() != null && !StringUtils.isNull(postData.wm().getPendantData().uW())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fGm.getHeadView(), postData.wm());
                    jVar.fGg.setVisibility(8);
                    jVar.fGm.setVisibility(0);
                    jVar.fGm.getHeadView().startLoad(portrait, 28, false);
                    jVar.fGm.getHeadView().setUserId(postData.wm().getUserId());
                    jVar.fGm.getHeadView().setUserName(postData.wm().getUserName());
                    jVar.fGm.getHeadView().setFid(this.fFs != null ? this.fFs.getForumId() : "");
                    jVar.fGm.getHeadView().setTid(postData.getId());
                    jVar.fGm.fF(postData.wm().getPendantData().uW());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fGg, postData.wm());
                    jVar.fGg.setUserId(postData.wm().getUserId());
                    jVar.fGg.setFid(this.fFs != null ? this.fFs.getForumId() : "");
                    jVar.fGg.setTid(postData.getId());
                    jVar.fGg.setUserName(postData.wm().getUserName(), postData.byW());
                    jVar.fGg.setTag(e.g.tag_virtual_user_url, postData.wm().getVirtualUserUrl());
                    jVar.fGg.setImageDrawable(null);
                    jVar.fGg.startLoad(portrait, 28, false);
                    jVar.fGg.setVisibility(0);
                    jVar.fGm.setVisibility(8);
                }
                if (postData.wm() != null) {
                    MetaData wm = postData.wm();
                    int i2 = postData.byE() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.byE() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    com.baidu.tbadk.core.util.al.i(jVar.fFY, i2);
                    com.baidu.tbadk.core.util.al.h(jVar.fFY, i3);
                    jVar.fFY.setTag(Integer.valueOf(i2));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(wm.getUserId())) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.host_name);
                    } else if (wm.getIs_bawu() == 1 && postData.byE()) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.brand_Official);
                    } else if (wm.getIs_bawu() == 1 && "manager".equals(wm.getBawu_type())) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.bawu_member_bazhu_tip);
                    } else if (wm.getIs_bawu() == 1 && "assist".equals(wm.getBawu_type())) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fFY.setVisibility(8);
                        jVar.fFY.setTag(null);
                    }
                } else {
                    jVar.fFY.setVisibility(8);
                    jVar.fFY.setTag(null);
                }
            }
            int i4 = 0;
            if (this.fFd.bcE()) {
                if (postData.wm() != null) {
                    i4 = postData.wm().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fGl.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fGl, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fGl.setVisibility(8);
            }
            int i5 = 15;
            if (jVar.fGo.getChildCount() == 1) {
                i5 = 13;
            } else if (jVar.fGo.getChildCount() > 1) {
                i5 = 11;
            }
            if (jVar.fFY.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fGn.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.xz() > 1000) {
                i5 -= 2;
            }
            if (postData.xz() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                jVar.fGo.setVisibility(8);
                if (jVar.fGo.getChildCount() == 1) {
                    i5 += 2;
                } else if (jVar.fGo.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && jVar.fFY.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fFY.setVisibility(8);
                }
                if (i5 < 10 && jVar.fGl.getVisibility() == 0) {
                    i5 += 2;
                    jVar.fGl.setVisibility(8);
                }
            }
            String name_show2 = postData.wm() != null ? postData.wm().getName_show() : "";
            int ig = com.baidu.tbadk.util.y.ig(name_show2);
            if (postData.wm() != null && !StringUtils.isNull(postData.wm().getSealPrefix())) {
                if (ig > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.y.I(name_show2, i5 - 2) + "...";
                }
            } else if (ig > i5) {
                name_show2 = com.baidu.tbadk.util.y.I(name_show2, i5) + "...";
            }
            if (postData.wm() != null && !StringUtils.isNull(postData.wm().getSealPrefix())) {
                jVar.cyw.setText(ap(postData.wm().getSealPrefix(), name_show2));
            } else {
                jVar.cyw.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.byM()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.wm() != null && !StringUtils.isNull(postData.wm().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fFs != null && this.fFs.bbV() != 0) {
                if (this.fFs.bbV() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.wm() != null) {
                    String userId = postData.wm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fFs != null && this.fFs.bbJ() != null && this.fFs.bbJ().wm() != null && postData.wm() != null) {
                String userId2 = this.fFs.bbJ().wm().getUserId();
                String userId3 = postData.wm().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.wm() != null && UtilHelper.isCurrentAccount(postData.wm().getUserId())) {
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
                    if (postData.byM() == 1) {
                        i6 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fFs.bbV()));
                        if (postData.wm() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.wm().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.wm().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.wm().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.wm() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.wm().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.wm().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.wm().getName_show());
                        }
                        if (this.fFs.bbJ() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fFs.bbJ().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fFs.bbV()));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    jVar.fGh.setTag(sparseArray);
                    jVar.fGd.setTag(sparseArray);
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
            if (postData.byM() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fGh.setTag(sparseArray);
            jVar.fGd.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fGz.a(postData);
            jVar.fGe.setTag(e.g.tag_clip_board, postData);
            jVar.fGe.setPostId(postData.getId());
            jVar.fGe.setThreadId(this.fFd.bcO().beD());
            jVar.fGe.setObjType(1);
            jVar.fGf.setThreadId(this.fFd.bcO().beD());
            jVar.fGf.setPostId(postData.getId());
            jVar.fGf.setObjType(1);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.byM() > 0) {
                String format = String.format(this.mContext.getString(e.j.is_floor), Integer.valueOf(postData.byM()));
                jVar.fGk.setVisibility(0);
                jVar.fGk.setText(format);
                z = true;
            } else {
                jVar.fGk.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f byP = postData.byP();
            boolean z2 = (byP == null || StringUtils.isNull(byP.getName())) ? false : true;
            if (z) {
                jVar.fGa.setVisibility(0);
                i = this.fBC;
            } else {
                jVar.fGa.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fGb.setVisibility(0);
                i2 = this.fBC;
            } else {
                jVar.fGb.setVisibility(8);
                i2 = 0;
            }
            jVar.fFZ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fFZ.setText(com.baidu.tbadk.core.util.ao.C(postData.getTime()));
            } else {
                jVar.fFZ.setText(com.baidu.tbadk.core.util.ao.A(postData.getTime()));
            }
            if (z2) {
                final String name = byP.getName();
                final String lat = byP.getLat();
                final String lng = byP.getLng();
                jVar.fGc.setVisibility(0);
                jVar.fGc.setPadding(this.fBC, 0, 0, 0);
                jVar.fGc.setText(byP.getName());
                jVar.fGc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kK()) {
                                com.baidu.tbadk.browser.a.ae(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(e.j.app_info_for_map)));
                            } else {
                                i.this.fFd.showToast(e.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fGc.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fGh.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fGh.setPadding(h, 0, h, 0);
            if (!this.fFt) {
                jVar.fGh.getLayoutStrategy().gc(e.f.icon_click);
            } else {
                jVar.fGh.it(null);
                jVar.fGh.setBackgroundDrawable(null);
                jVar.fGh.getLayoutStrategy().gc(e.f.transparent_bg);
            }
            jVar.fGh.getLayoutStrategy().fZ(e.f.pic_video);
            a(jVar.fGh, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fGh.setLayoutParams(layoutParams);
            jVar.fGh.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            jVar.fGh.setIsFromCDN(this.mIsFromCDN);
            jVar.fGh.setText(postData.byO(), true, this.fFQ);
            SparseArray sparseArray = (SparseArray) jVar.fGh.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            jVar.fGh.setTag(sparseArray);
            jVar.fFW.setTag(e.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().ga(aO - (z ? getDimensionPixelSize(e.C0141e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gb((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.byQ() > 0 && postData.byJ() != null && postData.byJ().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fGj.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fGj.setLayoutParams(layoutParams);
                if (this.fFR == null) {
                    this.fFR = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fFR.setIsFromCDN(this.mIsFromCDN);
                    this.fFR.setOnLongClickListener(this.aKx);
                    this.fFR.K(this.fFB);
                    this.fFR.q(this.mCommonClickListener);
                    String str = null;
                    if (this.fFs != null && this.fFs.bbJ() != null && this.fFs.bbJ().wm() != null) {
                        str = this.fFs.bbJ().wm().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fFs != null) {
                        this.fFR.B(this.fFs.bbV(), z);
                        this.fFR.aa(this.fFs.bbJ());
                    }
                }
                this.fFR.sl(postData.getId());
                jVar.fGj.setSubPbAdapter(this.fFR);
                jVar.fGj.setVisibility(0);
                jVar.fGj.setData(postData, view);
                jVar.fGj.setChildOnClickListener(this.mCommonClickListener);
                jVar.fGj.setChildOnLongClickListener(this.aKx);
                jVar.fGj.setChildOnTouchListener(this.fFS);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fGj.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fGj.setLayoutParams(layoutParams2);
                jVar.fGj.setVisibility(8);
            }
            if (postData.gWi) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fGt != null && jVar.fGq != null) {
            if (postData == null || postData.gWl == null || StringUtils.isNull(postData.gWl.liveTitle)) {
                jVar.fGq.setVisibility(8);
                return;
            }
            jVar.fGt.setText(postData.gWl.liveTitle);
            jVar.fGq.setTag(postData.gWl);
            jVar.fGq.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.c(jVar.cyw, e.d.cp_cont_f, 1);
                if (jVar.fFY.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.i(jVar.fFY, ((Integer) jVar.fFY.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fFZ, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fGa, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fGb, e.d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fGk, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fGc, e.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fGd, e.f.icon_floor_more_selector);
                jVar.fGh.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fGj, e.d.cp_bg_line_e);
                jVar.fGj.onChangeSkinType();
                jVar.fGi.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.fGt, e.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fGr, e.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fGq, e.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fGs, e.d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.fGu, e.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.fGx, e.d.cp_cont_j);
                if (jVar.fGv.getVisibility() == 8) {
                    jVar.fGx.setText(e.j.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.fGy, e.f.icon_arrow_gray_up);
                } else if (this.fFs != null && StringUtils.isNull(this.fFs.bbR())) {
                    jVar.fGx.setText(this.fFs.bbR());
                    com.baidu.tbadk.core.util.al.c(jVar.fGy, e.f.icon_arrow_gray_down);
                } else {
                    jVar.fGx.setText(e.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(final j jVar) {
        jVar.fFW.setOnTouchListener(this.fFS);
        jVar.fFW.setOnLongClickListener(this.aKx);
        if (this.fFd.getPageContext() != null && this.fFd.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fFd.getPageContext().getOrignalPage()).fDh;
            jVar.cyw.setOnClickListener(aVar.dSp);
            jVar.fGg.setOnClickListener(aVar.dSp);
            jVar.fGm.setOnClickListener(aVar.dSp);
            jVar.fGm.getHeadView().setOnClickListener(aVar.dSp);
            jVar.fGh.setOnLongClickListener(this.aKx);
            jVar.fGh.setOnTouchListener(this.fFS);
            jVar.fGh.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fGh.setOnImageClickListener(this.bjz);
            jVar.fGh.setOnImageTouchListener(this.fFS);
            jVar.fGh.setOnEmotionClickListener(aVar.fQx);
            jVar.fGd.setOnClickListener(this.mCommonClickListener);
            jVar.fGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fGe.L(jVar.fFW);
                }
            });
            jVar.fGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    jVar.fGf.L(jVar.fFW);
                }
            });
            jVar.fGp.setOnClickListener(this.mCommonClickListener);
            jVar.fGq.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fFQ = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fFs = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jU(boolean z) {
        this.fFt = z;
    }

    private SpannableStringBuilder ap(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.fFd.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fGh.setTextViewOnTouchListener(this.bjA);
        jVar.fGh.setTextViewCheckSelection(false);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fFB = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bjz = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bjA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aKx = onLongClickListener;
    }
}
