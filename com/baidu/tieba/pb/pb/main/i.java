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
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private View.OnLongClickListener aGs;
    private boolean beA;
    private TbRichTextView.h beD;
    private com.baidu.tieba.pb.a.c beE;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dod;
    private com.baidu.adp.lib.e.b<TbImageView> doe;
    protected com.baidu.tieba.pb.data.d ftE;
    private boolean ftF;
    private View.OnClickListener ftN;
    private int fuc;
    private int fud;
    private int fue;
    private TbRichTextView.c fuf;
    private com.baidu.tieba.pb.pb.sub.c fug;
    private com.baidu.tieba.pb.a.c fuh;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData aZ;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bxl() && this.mCommonClickListener != null && this.ftp != null && (aZ = this.ftp.aZ(findViewById)) != null) {
                TiebaStatic.log(this.ftp.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, aZ.bxl() ? 0 : 1));
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fuc = 0;
        this.fud = 0;
        this.fue = 0;
        this.fuf = null;
        this.ftF = true;
        this.mHostId = null;
        this.ftE = null;
        this.ftN = null;
        this.mCommonClickListener = null;
        this.beD = null;
        this.beE = null;
        this.aGs = null;
        this.fug = null;
        this.beA = true;
        this.dod = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avY */
            public ConstrainImageLayout mo9if() {
                return new ConstrainImageLayout(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.doe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AI */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fuh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.ftp == null || i.this.ftp.bbK() == null || i.this.ftp.bbK().beH())) {
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
                if (i.this.beE != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.beE.aW(view);
                        i.this.beE.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bm */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.ftp.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_reply_floor_item_layout, viewGroup, false));
        jVar.fuz.setConstrainLayoutPool(this.dod);
        jVar.fuz.setImageViewPool(this.doe);
        a(jVar);
        this.fuc = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds12);
        this.fud = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds20);
        this.fue = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds36);
        if (jVar.fuy != null) {
            jVar.fuy.setDuiEnabled(this.beA);
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
            f(postData2);
            postData2.wg();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.beA = z;
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
            jVar.fuM.setVisibility(8);
            jVar.fuO.setText(d.k.expand_content);
            com.baidu.tbadk.core.util.al.c(jVar.fuP, d.f.icon_arrow_gray_down_n);
            return;
        }
        jVar.fuM.setVisibility(0);
        jVar.fuO.setText(d.k.close_content);
        com.baidu.tbadk.core.util.al.c(jVar.fuP, d.f.icon_arrow_gray_up_n);
    }

    private void a(final j jVar, final PostData postData) {
        if (postData.bxn() == 2) {
            jVar.fuN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.fuM.getVisibility() == 8;
                    i.this.a(jVar, !z);
                    postData.mu(z ? false : true);
                    i.this.b(jVar, postData);
                    if (i.this.ftp.bbK() != null && i.this.ftp.bbK().bfD() != null && i.this.ftp.bbK().getListView() != null && !z && jVar.getView().getTop() < i.this.ftp.bbK().bfD().getMeasuredHeight()) {
                        i.this.ftp.bbK().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.w.a(i.this.ftp.bbK().getListView().getData(), postData) + i.this.ftp.bbK().getListView().getHeaderViewsCount(), i.this.ftp.bbK().bfD().getMeasuredHeight());
                    }
                }
            });
            jVar.fuO.setText(this.ftE.baw());
            jVar.fuN.setVisibility(0);
            a(jVar, postData.bwU());
            a(true, jVar, postData);
        } else {
            jVar.fuN.setVisibility(8);
            jVar.fuM.setVisibility(0);
            a(false, jVar, postData);
        }
        b(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.w.z(postData.bwW());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fuN.getLayoutParams();
        if (z) {
            jVar.fuy.getLayoutStrategy().fT(0);
            if (z2) {
                jVar.fuy.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                }
            } else {
                jVar.fuy.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            jVar.fuN.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                jVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        jVar.fuy.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        jVar.fuy.getLayoutStrategy().fT(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            jVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, PostData postData) {
        TbRichText bxb = postData.bxb();
        bxb.isChanged = true;
        jVar.fuy.setText(bxb, true, this.fuf);
    }

    private void f(PostData postData) {
        if (postData.aiI == 0 && postData.gJz) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.ah("post_id", postData.getId());
            amVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.ah("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.f("exposure_time", System.currentTimeMillis());
            if (this.ftp != null) {
                int bdN = this.ftp.bbt().bdN();
                if (1 == bdN || 2 == bdN) {
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bdN) {
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void c(j jVar, PostData postData) {
        if (postData == null || postData.bgZ() == null) {
            jVar.fuG.setVisibility(8);
            return;
        }
        TbRichText bxb = postData.bxb();
        com.baidu.tieba.pb.view.d.a(postData.bgZ(), jVar.fuG, false, false, bxb != null && StringUtils.isNull(bxb.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ftF) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fuy.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fuy.setLayoutParams(layoutParams);
            jVar.fuy.setPadding(0, 0, 0, 0);
            jVar.fuy.hT(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fuy.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.fuy.setLayoutParams(layoutParams2);
            jVar.fuy.hT(postData.getBimg_url());
        }
        jVar.fuy.setTextViewOnTouchListener(this.fuh);
        jVar.fuy.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05d9  */
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
            if (postData.gJE) {
                com.baidu.tbadk.core.util.al.j(jVar.aHA, d.C0141d.cp_bg_line_c);
                jVar.aHA.setVisibility(0);
            } else {
                jVar.aHA.setVisibility(8);
            }
            jVar.fux.setTag(null);
            jVar.fux.setUserId(null);
            jVar.csb.setText((CharSequence) null);
            jVar.fuD.getHeadView().setUserId(null);
            jVar.fuy.setIsHost(false);
            if (postData.vm() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.vm().getUserId())) {
                    jVar.fuy.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.vm().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.vm().getTShowInfoNew();
                if (jVar.fuF != null) {
                    jVar.fuF.setTag(d.g.tag_user_id, postData.vm().getUserId());
                    jVar.fuF.setOnClickListener(this.ftp.frr.fEG);
                    jVar.fuF.a(iconInfo, 2, this.fue, this.fue, this.fuc);
                }
                if (jVar.fuE != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fuE.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fuE.setOnClickListener(this.ftp.frr.fEH);
                    jVar.fuE.a(tShowInfoNew, 3, this.fue, this.fue, this.fuc, true);
                }
                if (!com.baidu.tbadk.core.util.w.z(tShowInfoNew) || postData.vm().isBigV()) {
                    com.baidu.tbadk.core.util.al.c(jVar.csb, d.C0141d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.c(jVar.csb, d.C0141d.cp_cont_f, 1);
                }
                String portrait = postData.vm().getPortrait();
                jVar.csb.setTag(d.g.tag_user_id, postData.vm().getUserId());
                jVar.csb.setTag(d.g.tag_user_name, postData.vm().getUserName());
                jVar.csb.setTag(d.g.tag_virtual_user_url, postData.vm().getVirtualUserUrl());
                String name_show = postData.vm().getName_show();
                String userName = postData.vm().getUserName();
                if (com.baidu.tbadk.o.ah.ip() && name_show != null && !name_show.equals(userName)) {
                    jVar.csb.setText(com.baidu.tieba.pb.c.aj(this.mContext, jVar.csb.getText().toString()));
                    jVar.csb.setGravity(16);
                    jVar.csb.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aZW());
                    com.baidu.tbadk.core.util.al.c(jVar.csb, d.C0141d.cp_other_e, 1);
                }
                if (postData.vm().getPendantData() != null && !StringUtils.isNull(postData.vm().getPendantData().ub())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fuD.getHeadView(), postData.vm());
                    jVar.fux.setVisibility(8);
                    jVar.fuD.setVisibility(0);
                    jVar.fuD.getHeadView().startLoad(portrait, 28, false);
                    jVar.fuD.getHeadView().setUserId(postData.vm().getUserId());
                    jVar.fuD.getHeadView().setUserName(postData.vm().getUserName());
                    jVar.fuD.fj(postData.vm().getPendantData().ub());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fux, postData.vm());
                    jVar.fux.setUserId(postData.vm().getUserId());
                    jVar.fux.setUserName(postData.vm().getUserName(), postData.bxj());
                    jVar.fux.setTag(d.g.tag_virtual_user_url, postData.vm().getVirtualUserUrl());
                    jVar.fux.setImageDrawable(null);
                    jVar.fux.startLoad(portrait, 28, false);
                    jVar.fux.setVisibility(0);
                    jVar.fuD.setVisibility(8);
                }
                if (postData.vm() != null) {
                    MetaData vm = postData.vm();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(vm.getUserId())) {
                        jVar.fuq.setVisibility(0);
                        com.baidu.tbadk.core.util.al.c(jVar.fuq, d.f.icon_id_louzhu);
                        jVar.fuq.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (vm.getIs_bawu() == 1 && "manager".equals(vm.getBawu_type())) {
                        jVar.fuq.setVisibility(0);
                        com.baidu.tbadk.core.util.al.c(jVar.fuq, d.f.icon_id_bazhu);
                        jVar.fuq.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (vm.getIs_bawu() == 1 && "assist".equals(vm.getBawu_type())) {
                        jVar.fuq.setVisibility(0);
                        com.baidu.tbadk.core.util.al.c(jVar.fuq, d.f.icon_id_xiaobazhu);
                        jVar.fuq.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        jVar.fuq.setVisibility(8);
                        jVar.fuq.setTag(null);
                    }
                } else {
                    jVar.fuq.setVisibility(8);
                    jVar.fuq.setTag(null);
                }
            }
            int i2 = 0;
            if (this.ftp.bcu()) {
                if (postData.vm() != null) {
                    i2 = postData.vm().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.fuC.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.fuC, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.fuC.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.fuF.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.fuF.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.fuq.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.fuE.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.vm().getName_show();
            int hH = com.baidu.tbadk.util.x.hH(name_show2);
            if (!StringUtils.isNull(postData.vm().getSealPrefix())) {
                if (hH > i3 - 2) {
                    str = com.baidu.tbadk.util.x.I(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (hH > i3) {
                    str = com.baidu.tbadk.util.x.I(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.vm().getSealPrefix())) {
                jVar.csb.setText(ak(postData.vm().getSealPrefix(), str));
            } else {
                jVar.csb.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwZ()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.vm() != null && !StringUtils.isNull(postData.vm().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.ftE != null && this.ftE.baA() != 0) {
                if (this.ftE.baA() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.vm() != null) {
                    String userId = postData.vm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.ftE != null && this.ftE.bao() != null && this.ftE.bao().vm() != null && postData.vm() != null) {
                String userId2 = this.ftE.bao().vm().getUserId();
                String userId3 = postData.vm().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.vm() != null && UtilHelper.isCurrentAccount(postData.vm().getUserId())) {
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
                    if (postData.bwZ() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ftE.baA()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.vm().getUserName());
                        sparseArray.put(d.g.tag_forbid_user_name_show, postData.vm().getName_show());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vm() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vm().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vm().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vm().getName_show());
                        }
                        if (this.ftE.bao() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.ftE.bao().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ftE.baA()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    jVar.fuw.setTag(sparseArray);
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
            if (postData.bwZ() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.fuw.setTag(sparseArray);
        }
    }

    private void e(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.fuv.a(postData.bxl(), postData.bxk(), false);
            jVar.fuv.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bwZ() > 0) {
                String format = String.format(this.mContext.getString(d.k.is_floor), Integer.valueOf(postData.bwZ()));
                jVar.fuB.setVisibility(0);
                jVar.fuB.setText(format);
                z = true;
            } else {
                jVar.fuB.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bxc = postData.bxc();
            boolean z2 = (bxc == null || StringUtils.isNull(bxc.getName())) ? false : true;
            if (z) {
                jVar.fus.setVisibility(0);
                i = this.fud;
            } else {
                jVar.fus.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fut.setVisibility(0);
                i2 = this.fud;
            } else {
                jVar.fut.setVisibility(8);
                i2 = 0;
            }
            jVar.fur.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fur.setText(com.baidu.tbadk.core.util.ao.w(postData.getTime()));
            } else {
                jVar.fur.setText(com.baidu.tbadk.core.util.ao.v(postData.getTime()));
            }
            if (z2) {
                final String name = bxc.getName();
                final String lat = bxc.getLat();
                final String lng = bxc.getLng();
                jVar.fuu.setVisibility(0);
                jVar.fuu.setPadding(this.fud, 0, 0, 0);
                jVar.fuu.setText(bxc.getName());
                jVar.fuu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.jD()) {
                                com.baidu.tbadk.browser.a.O(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, i.this.mContext.getString(d.k.app_info_for_map)));
                            } else {
                                i.this.ftp.showToast(d.k.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.fuu.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fuy.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fuy.setPadding(e, 0, e, 0);
            if (!this.ftF) {
                jVar.fuy.getLayoutStrategy().fP(d.f.icon_click);
            } else {
                jVar.fuy.hT(null);
                jVar.fuy.setBackgroundDrawable(null);
                jVar.fuy.getLayoutStrategy().fP(d.f.transparent_bg);
            }
            jVar.fuy.getLayoutStrategy().fM(d.f.pic_video);
            a(jVar.fuy, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.fuy.setLayoutParams(layoutParams);
            jVar.fuy.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_link_tip_c));
            jVar.fuy.setIsFromCDN(this.mIsFromCDN);
            jVar.fuy.setText(postData.bxb(), true, this.fuf);
            SparseArray sparseArray = (SparseArray) jVar.fuy.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.fuy.setTag(sparseArray);
            jVar.fuo.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ah = (ah - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fN(ah - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fO((int) (ah * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.bxd() > 0 && postData.bwW() != null && postData.bwW().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fuA.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                jVar.fuA.setLayoutParams(layoutParams);
                if (this.fug == null) {
                    this.fug = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fug.setIsFromCDN(this.mIsFromCDN);
                    this.fug.I(this.ftN);
                    String str = null;
                    if (this.ftE != null && this.ftE.bao() != null && this.ftE.bao().vm() != null) {
                        str = this.ftE.bao().vm().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.ftE != null) {
                        this.fug.B(this.ftE.baA(), z);
                        this.fug.T(this.ftE.bao());
                    }
                }
                this.fug.rJ(postData.getId());
                jVar.fuA.setSubPbAdapter(this.fug);
                jVar.fuA.setVisibility(0);
                jVar.fuA.setData(postData, view);
                jVar.fuA.setChildOnClickListener(this.mCommonClickListener);
                jVar.fuA.setChildOnLongClickListener(this.aGs);
                jVar.fuA.setChildOnTouchListener(this.fuh);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fuA.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.fuA.setLayoutParams(layoutParams2);
                jVar.fuA.setVisibility(8);
            }
            if (postData.gJD) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(j jVar, PostData postData) {
        if (jVar != null && jVar.fuK != null && jVar.fuH != null) {
            if (postData == null || postData.gJG == null || StringUtils.isNull(postData.gJG.liveTitle)) {
                jVar.fuH.setVisibility(8);
                return;
            }
            jVar.fuK.setText(postData.gJG.liveTitle);
            jVar.fuH.setTag(postData.gJG);
            jVar.fuH.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.c(jVar.csb, d.C0141d.cp_cont_f, 1);
                if (jVar.fuq.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.c(jVar.fuq, ((Integer) jVar.fuq.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.c(jVar.fur, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fus, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.al.i(jVar.fut, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(jVar.fuB, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fuu, d.C0141d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.mBottomLine, d.C0141d.cp_bg_line_c);
                com.baidu.tbadk.core.util.al.c(jVar.fuw, d.f.icon_floor_more_selector);
                jVar.fuy.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_cont_b));
                com.baidu.tbadk.core.util.al.j(jVar.fuA, d.C0141d.cp_bg_line_e);
                jVar.fuA.onChangeSkinType();
                jVar.fuz.onChangeSkinType();
                jVar.fuv.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(jVar.fuK, d.C0141d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.c(jVar.fuI, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.i(jVar.fuH, d.C0141d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.i(jVar.fuJ, d.C0141d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.fuL, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.h(jVar.fuO, d.C0141d.cp_cont_j);
                if (jVar.fuM.getVisibility() == 8) {
                    jVar.fuO.setText(d.k.close_content);
                    com.baidu.tbadk.core.util.al.c(jVar.fuP, d.f.icon_arrow_gray_up);
                } else if (this.ftE != null && StringUtils.isNull(this.ftE.baw())) {
                    jVar.fuO.setText(this.ftE.baw());
                    com.baidu.tbadk.core.util.al.c(jVar.fuP, d.f.icon_arrow_gray_down);
                } else {
                    jVar.fuO.setText(d.k.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.fuo.setOnTouchListener(this.fuh);
        jVar.fuo.setOnLongClickListener(this.aGs);
        if (this.ftp.getPageContext() != null && this.ftp.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.ftp.getPageContext().getOrignalPage()).frr;
            jVar.csb.setOnClickListener(aVar.fEF);
            jVar.fux.setOnClickListener(aVar.fEF);
            jVar.fuD.setOnClickListener(aVar.fEF);
            jVar.fuD.getHeadView().setOnClickListener(aVar.fEF);
            jVar.fuy.setOnLongClickListener(this.aGs);
            jVar.fuy.setOnTouchListener(this.fuh);
            jVar.fuy.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.fuy.setOnImageClickListener(this.beD);
            jVar.fuy.setOnImageTouchListener(this.fuh);
            jVar.fuy.setOnEmotionClickListener(aVar.fEI);
            jVar.fuw.setOnClickListener(this.mCommonClickListener);
            jVar.fuv.setOnClickListener(this.mCommonClickListener);
            jVar.fuG.setOnClickListener(this.mCommonClickListener);
            jVar.fuH.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fuf = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.ftE = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jx(boolean z) {
        this.ftF = z;
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a((Context) this.ftp.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.fuy.setTextViewOnTouchListener(this.beE);
        jVar.fuy.setTextViewCheckSelection(false);
    }

    public void F(View.OnClickListener onClickListener) {
        this.ftN = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.beD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.beE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aGs = onLongClickListener;
    }
}
