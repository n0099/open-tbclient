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
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private boolean aVG;
    private TbRichTextView.g aVJ;
    private com.baidu.tieba.pb.a.c aVK;
    private View.OnLongClickListener avI;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNK;
    private com.baidu.adp.lib.e.b<TbImageView> cNL;
    private boolean eQU;
    protected com.baidu.tieba.pb.data.f eQW;
    private com.baidu.tieba.pb.pb.sub.d eQX;
    private View.OnClickListener eQZ;
    private int eWd;
    private int eWe;
    private int eWf;
    private TbRichTextView.c eWg;
    private com.baidu.tieba.pb.a.c eWh;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData be;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bxj() && this.mCommonClickListener != null && this.eVu != null && (be = this.eVu.be(findViewById)) != null) {
                TiebaStatic.log(this.eVu.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", be.bxj() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eWd = 0;
        this.eWe = 0;
        this.eWf = 0;
        this.eWg = null;
        this.eQU = true;
        this.mHostId = null;
        this.eQW = null;
        this.eQZ = null;
        this.mCommonClickListener = null;
        this.aVJ = null;
        this.aVK = null;
        this.avI = null;
        this.eQX = null;
        this.aVG = true;
        this.cNK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anM */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(k.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cNL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.common_color_10043));
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
        this.eWh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.eVu == null || k.this.eVu.aSR() == null || k.this.eVu.aSR().aVP())) {
                    if (view instanceof NoPressedLinearLayout) {
                        k.this.a((NoPressedLinearLayout) view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof NoPressedLinearLayout) {
                                k.this.a((NoPressedLinearLayout) parent);
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
                if (k.this.aVK != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.aVK.bb(view);
                        k.this.aVK.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.mCommonClickListener.onClick(view);
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
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(this.eVu.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.eWt.setConstrainLayoutPool(this.cNK);
        lVar.eWt.setImageViewPool(this.cNL);
        a(lVar);
        this.eWd = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds12);
        this.eWe = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds20);
        this.eWf = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds36);
        if (lVar.eWs != null) {
            lVar.eWs.setDuiEnabled(this.aVG);
        }
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, lVar);
        a(lVar);
        b(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            g(postData2);
            postData2.su();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.aVG = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            b(lVar, postData, view, i);
            c(lVar, postData);
            c(lVar, postData, view, i);
            d(lVar, postData, view, i);
            d(lVar, postData);
            b(lVar, postData);
            a(lVar, postData);
            e(lVar, postData);
        }
    }

    private void g(PostData postData) {
        if (postData.Zx == 0 && postData.gCz) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ac("post_id", postData.getId());
            akVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.aYe() == null) {
            lVar.eRO.setVisibility(8);
            return;
        }
        TbRichText bwY = postData.bwY();
        com.baidu.tieba.pb.view.g.a(postData.aYe(), lVar.eRO, false, false, bwY != null && StringUtils.isNull(bwY.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eQU) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eWs.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.eWs.setLayoutParams(layoutParams);
            lVar.eWs.setPadding(0, 0, 0, 0);
            lVar.eWs.hg(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eWs.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.eWs.setLayoutParams(layoutParams2);
            lVar.eWs.hg(postData.getBimg_url());
        }
        lVar.eWs.setTextViewOnTouchListener(this.eWh);
        lVar.eWs.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0594  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(l lVar, PostData postData, View view, int i) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (lVar != null && postData != null) {
            if (postData.cTh) {
                com.baidu.tbadk.core.util.aj.k(lVar.ayf, d.C0095d.cp_bg_line_c);
                lVar.ayf.setVisibility(0);
            } else {
                lVar.ayf.setVisibility(8);
            }
            lVar.eWr.setTag(null);
            lVar.eWr.setUserId(null);
            lVar.bcz.setText((CharSequence) null);
            lVar.eWx.getHeadView().setUserId(null);
            if (postData.rv() != null) {
                ArrayList<IconData> iconInfo = postData.rv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rv().getTShowInfoNew();
                if (lVar.eWz != null) {
                    lVar.eWz.setTag(d.g.tag_user_id, postData.rv().getUserId());
                    lVar.eWz.setOnClickListener(this.eVu.eTz.cSX);
                    lVar.eWz.a(iconInfo, 2, this.eWf, this.eWf, this.eWd);
                }
                if (lVar.eWy != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.eWy.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.eWy.setOnClickListener(this.eVu.eTz.ffY);
                    lVar.eWy.a(tShowInfoNew, 3, this.eWf, this.eWf, this.eWd, true);
                }
                if (!com.baidu.tbadk.core.util.v.w(tShowInfoNew) || postData.rv().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(lVar.bcz, d.C0095d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(lVar.bcz, d.C0095d.cp_cont_f, 1);
                }
                String portrait = postData.rv().getPortrait();
                lVar.bcz.setTag(d.g.tag_user_id, postData.rv().getUserId());
                lVar.bcz.setTag(d.g.tag_user_name, postData.rv().getUserName());
                lVar.bcz.setTag(d.g.tag_virtual_user_url, postData.rv().getVirtualUserUrl());
                String name_show = postData.rv().getName_show();
                String userName = postData.rv().getUserName();
                if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                    lVar.bcz.setText(com.baidu.tieba.pb.c.aj(this.mContext, lVar.bcz.getText().toString()));
                    lVar.bcz.setGravity(16);
                    lVar.bcz.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQS());
                    com.baidu.tbadk.core.util.aj.c(lVar.bcz, d.C0095d.cp_other_e, 1);
                }
                if (postData.rv().getPendantData() != null && !StringUtils.isNull(postData.rv().getPendantData().pR())) {
                    UtilHelper.showHeadImageViewBigV(lVar.eWx.getHeadView(), postData.rv());
                    lVar.eWr.setVisibility(8);
                    lVar.eWx.setVisibility(0);
                    lVar.eWx.getHeadView().startLoad(portrait, 28, false);
                    lVar.eWx.getHeadView().setUserId(postData.rv().getUserId());
                    lVar.eWx.getHeadView().setUserName(postData.rv().getUserName());
                    lVar.eWx.es(postData.rv().getPendantData().pR());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.eWr, postData.rv());
                    lVar.eWr.setUserId(postData.rv().getUserId());
                    lVar.eWr.ae(postData.rv().getUserName(), postData.bxg());
                    lVar.eWr.setTag(d.g.tag_virtual_user_url, postData.rv().getVirtualUserUrl());
                    lVar.eWr.setImageDrawable(null);
                    lVar.eWr.startLoad(portrait, 28, false);
                    lVar.eWr.setVisibility(0);
                    lVar.eWx.setVisibility(8);
                }
                if (postData.rv() != null) {
                    MetaData rv = postData.rv();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rv.getUserId())) {
                        lVar.eWk.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eWk, d.f.icon_id_louzhu);
                        lVar.eWk.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (rv.getIs_bawu() == 1 && "manager".equals(rv.getBawu_type())) {
                        lVar.eWk.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eWk, d.f.icon_id_bazhu);
                        lVar.eWk.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (rv.getIs_bawu() == 1 && "assist".equals(rv.getBawu_type())) {
                        lVar.eWk.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eWk, d.f.icon_id_xiaobazhu);
                        lVar.eWk.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        lVar.eWk.setVisibility(8);
                        lVar.eWk.setTag(null);
                    }
                } else {
                    lVar.eWk.setVisibility(8);
                    lVar.eWk.setTag(null);
                }
            }
            int i2 = 0;
            if (this.eVu.aTD()) {
                if (postData.rv() != null) {
                    i2 = postData.rv().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.eWw.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.eWw, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.eWw.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.eWz.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.eWz.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.eWk.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.eWy.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.rv().getName_show();
            int gY = com.baidu.tbadk.util.w.gY(name_show2);
            if (!StringUtils.isNull(postData.rv().getSealPrefix())) {
                if (gY > i3 - 2) {
                    str = com.baidu.tbadk.util.w.H(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (gY > i3) {
                    str = com.baidu.tbadk.util.w.H(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.rv().getSealPrefix())) {
                lVar.bcz.setText(ag(postData.rv().getSealPrefix(), str));
            } else {
                lVar.bcz.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwV()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.rv() != null && !StringUtils.isNull(postData.rv().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eQW != null && this.eQW.aRB() != 0) {
                if (this.eQW.aRB() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.rv() != null) {
                    String userId = postData.rv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eQW != null && this.eQW.aRq() != null && this.eQW.aRq().rv() != null && postData.rv() != null) {
                String userId2 = this.eQW.aRq().rv().getUserId();
                String userId3 = postData.rv().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.rv() != null && UtilHelper.isCurrentAccount(postData.rv().getUserId())) {
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
                    if (postData.bwV() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQW.aRB()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rv() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rv().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rv().getUserName());
                        }
                        if (this.eQW.aRq() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.eQW.aRq().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQW.aRB()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.eWq.setTag(sparseArray);
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
            if (postData.bwV() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.eWq.setTag(sparseArray);
        }
    }

    private void c(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.eWp.a(postData.bxj(), postData.bxi(), false);
            lVar.eWp.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void d(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.bwV() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwV()));
                lVar.eWv.setVisibility(0);
                lVar.eWv.setText(format);
                z = true;
            } else {
                lVar.eWv.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.i bwZ = postData.bwZ();
            boolean z2 = (bwZ == null || StringUtils.isNull(bwZ.getName())) ? false : true;
            if (z) {
                lVar.eWm.setVisibility(0);
                i = this.eWe;
            } else {
                lVar.eWm.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.eWn.setVisibility(0);
                i2 = this.eWe;
            } else {
                lVar.eWn.setVisibility(8);
                i2 = 0;
            }
            lVar.eWl.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.eWl.setText(com.baidu.tbadk.core.util.am.s(postData.getTime()));
            } else {
                lVar.eWl.setText(com.baidu.tbadk.core.util.am.r(postData.getTime()));
            }
            if (z2) {
                final String name = bwZ.getName();
                final String lat = bwZ.getLat();
                final String lng = bwZ.getLng();
                lVar.eWo.setVisibility(0);
                lVar.eWo.setPadding(this.eWe, 0, 0, 0);
                lVar.eWo.setText(bwZ.getName());
                lVar.eWo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.hh()) {
                                com.baidu.tbadk.browser.a.O(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.eVu.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            lVar.eWo.setVisibility(8);
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eWs.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.eWs.setPadding(0, 0, 0, 0);
            if (!this.eQU) {
                lVar.eWs.getLayoutStrategy().fV(d.f.icon_click);
            } else {
                lVar.eWs.hg(null);
                lVar.eWs.setBackgroundDrawable(null);
                lVar.eWs.getLayoutStrategy().fV(d.f.transparent_bg);
            }
            lVar.eWs.getLayoutStrategy().fS(d.f.pic_video);
            a(lVar.eWs, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.eWs.setLayoutParams(layoutParams);
            lVar.eWs.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_link_tip_c));
            lVar.eWs.setIsFromCDN(this.mIsFromCDN);
            lVar.eWs.a(postData.bwY(), true, this.eWg);
            SparseArray sparseArray = (SparseArray) lVar.eWs.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.eWs.setTag(sparseArray);
            lVar.eRj.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ac = (ac - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fT(ac - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fU((int) (ac * 1.618f));
        }
    }

    private void d(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.bxa() > 0 && postData.bwS() != null && postData.bwS().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eWu.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                lVar.eWu.setLayoutParams(layoutParams);
                if (this.eQX == null) {
                    this.eQX = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eQX.setIsFromCDN(this.mIsFromCDN);
                    this.eQX.G(this.eQZ);
                    String str = null;
                    if (this.eQW != null && this.eQW.aRq() != null && this.eQW.aRq().rv() != null) {
                        str = this.eQW.aRq().rv().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eQW != null) {
                        this.eQX.y(this.eQW.aRB(), z);
                        this.eQX.R(this.eQW.aRq());
                    }
                }
                this.eQX.qh(postData.getId());
                lVar.eWu.setSubPbAdapter(this.eQX);
                lVar.eWu.setVisibility(0);
                lVar.eWu.a(postData, view);
                lVar.eWu.setChildOnClickListener(this.mCommonClickListener);
                lVar.eWu.setChildOnLongClickListener(this.avI);
                lVar.eWu.setChildOnTouchListener(this.eWh);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eWu.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.eWu.setLayoutParams(layoutParams2);
                lVar.eWu.setVisibility(8);
            }
            if (postData.gCD) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void e(l lVar, PostData postData) {
        if (lVar != null && lVar.eWD != null && lVar.eWA != null) {
            if (postData == null || postData.gCF == null || StringUtils.isNull(postData.gCF.liveTitle)) {
                lVar.eWA.setVisibility(8);
                return;
            }
            lVar.eWD.setText(postData.gCF.liveTitle);
            lVar.eWA.setTag(postData.gCF);
            lVar.eWA.setVisibility(0);
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                akVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(lVar.bcz, d.C0095d.cp_cont_f, 1);
                if (lVar.eWk.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(lVar.eWk, ((Integer) lVar.eWk.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.c(lVar.eWl, d.C0095d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eWm, d.C0095d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.j(lVar.eWn, d.C0095d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(lVar.eWv, d.C0095d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eWo, d.C0095d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.k(lVar.mBottomLine, d.C0095d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.eWq, d.f.icon_floor_more_selector);
                lVar.eWs.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(lVar.eWu, d.C0095d.cp_bg_line_e);
                lVar.eWu.onChangeSkinType();
                lVar.eWt.onChangeSkinType();
                lVar.eWp.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.c(lVar.eWD, d.C0095d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eWB, d.C0095d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eWA, d.C0095d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.j(lVar.eWC, d.C0095d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(lVar.eWE, d.f.icon_arrow_more_gray);
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.eRj.setOnTouchListener(this.eWh);
        lVar.eRj.setOnLongClickListener(this.avI);
        if (this.eVu.getPageContext() != null && this.eVu.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz;
            lVar.bcz.setOnClickListener(aVar.ffX);
            lVar.eWr.setOnClickListener(aVar.ffX);
            lVar.eWx.setOnClickListener(aVar.ffX);
            lVar.eWx.getHeadView().setOnClickListener(aVar.ffX);
            lVar.eWs.setOnLongClickListener(this.avI);
            lVar.eWs.setOnTouchListener(this.eWh);
            lVar.eWs.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.eWs.setOnImageClickListener(this.aVJ);
            lVar.eWs.setOnImageTouchListener(this.eWh);
            lVar.eWs.setOnEmotionClickListener(aVar.ffZ);
            lVar.eWq.setOnClickListener(this.mCommonClickListener);
            lVar.eWp.setOnClickListener(this.mCommonClickListener);
            lVar.eRO.setOnClickListener(this.mCommonClickListener);
            lVar.eWA.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.eWg = cVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eQW = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iY(boolean z) {
        this.eQU = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.eVu.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.eWs.setTextViewOnTouchListener(this.aVK);
        lVar.eWs.setTextViewCheckSelection(false);
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQZ = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVJ = gVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avI = onLongClickListener;
    }
}
