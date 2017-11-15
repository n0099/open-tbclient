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
import com.baidu.sapi2.SapiAccountManager;
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
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private int DS20;
    private int DS8;
    private boolean aSA;
    private TbRichTextView.f aSD;
    private com.baidu.tieba.pb.a.c aSE;
    private View.OnLongClickListener auZ;
    private int bGT;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cEr;
    private com.baidu.adp.lib.e.b<TbImageView> cEs;
    private boolean eIj;
    protected com.baidu.tieba.pb.data.f eIl;
    private com.baidu.tieba.pb.pb.sub.d eIm;
    private View.OnClickListener eIo;
    private TbRichTextView.b eNo;
    private com.baidu.tieba.pb.a.c eNp;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bj;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).buT() && this.mCommonClickListener != null && this.eMB != null && (bj = this.eMB.bj(findViewById)) != null) {
                TiebaStatic.log(this.eMB.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", bj.buT() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.DS8 = 0;
        this.DS20 = 0;
        this.bGT = 0;
        this.eNo = null;
        this.eIj = true;
        this.mHostId = null;
        this.eIl = null;
        this.eIo = null;
        this.mCommonClickListener = null;
        this.aSD = null;
        this.aSE = null;
        this.auZ = null;
        this.eIm = null;
        this.aSA = true;
        this.cEr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alI */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(k.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cEs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.common_color_10043));
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
        this.eNp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.eMB == null || k.this.eMB.aRs() == null || k.this.eMB.aRs().aUf())) {
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
                if (k.this.aSE != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.aSE.bg(view);
                        k.this.aSE.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bp */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(this.eMB.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.eNA.setConstrainLayoutPool(this.cEr);
        lVar.eNA.setImageViewPool(this.cEs);
        a(lVar);
        this.DS8 = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds8);
        this.DS20 = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds20);
        this.bGT = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds34);
        if (lVar.eNz != null) {
            lVar.eNz.setDuiEnabled(this.aSA);
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
            postData2.st();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.aSA = z;
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
        }
    }

    private void g(PostData postData) {
        if (postData.Zh == 0 && postData.gqS) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ac("post_id", postData.getId());
            akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.aWX() == null) {
            lVar.eJd.setVisibility(8);
            return;
        }
        TbRichText aEx = postData.aEx();
        com.baidu.tieba.pb.view.g.a(postData.aWX(), lVar.eJd, false, false, aEx != null && StringUtils.isNull(aEx.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eIj) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eNz.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.eNz.setLayoutParams(layoutParams);
            lVar.eNz.setPadding(0, 0, 0, 0);
            lVar.eNz.hf(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eNz.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.eNz.setLayoutParams(layoutParams2);
            lVar.eNz.hf(postData.getBimg_url());
        }
        lVar.eNz.setTextViewOnTouchListener(this.eNp);
        lVar.eNz.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x063c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(l lVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (lVar != null && postData != null) {
            if (postData.cJv) {
                com.baidu.tbadk.core.util.aj.k(lVar.axw, d.C0080d.cp_bg_line_c);
                lVar.axw.setVisibility(0);
            } else {
                lVar.axw.setVisibility(8);
            }
            lVar.eNy.setTag(null);
            lVar.eNy.setUserId(null);
            lVar.aZi.setText((CharSequence) null);
            lVar.eNE.getHeadView().setUserId(null);
            if (postData.rt() != null) {
                String name_show = postData.rt().getName_show();
                int gX = com.baidu.tbadk.util.w.gX(name_show);
                if (!StringUtils.isNull(postData.rt().getSealPrefix())) {
                    if (gX > 12) {
                        name_show = com.baidu.tbadk.util.w.H(name_show, 12) + "...";
                    }
                } else if (gX > 14) {
                    name_show = com.baidu.tbadk.util.w.H(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.rt().getSealPrefix())) {
                    lVar.aZi.setText(ag(postData.rt().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.k.aP(postData.rt().getSealPrefix()) + 2;
                } else {
                    lVar.aZi.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aP = com.baidu.adp.lib.util.k.aP(postData.rt().getName_show());
                    if (aP + i2 > 14) {
                        i3 = 0;
                    } else if (aP + i2 >= 12) {
                        i3 = 1;
                    } else if (aP + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.rt().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rt().getTShowInfoNew();
                if (lVar.eNG != null) {
                    lVar.eNG.setTag(d.g.tag_user_id, postData.rt().getUserId());
                    lVar.eNG.setOnClickListener(this.eMB.eKN.cJk);
                    lVar.eNG.a(iconInfo, i3, this.eMB.getResources().getDimensionPixelSize(d.e.ds26), this.eMB.getResources().getDimensionPixelSize(d.e.ds26), this.eMB.getResources().getDimensionPixelSize(d.e.ds8));
                }
                if (lVar.eNF != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.eNF.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.eNF.setOnClickListener(this.eMB.eKN.eYd);
                    lVar.eNF.a(tShowInfoNew, 3, this.eMB.getResources().getDimensionPixelSize(d.e.ds36), this.eMB.getResources().getDimensionPixelSize(d.e.ds36), this.eMB.getResources().getDimensionPixelSize(d.e.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.v.v(tShowInfoNew) || postData.rt().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(lVar.aZi, d.C0080d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(lVar.aZi, d.C0080d.cp_cont_j, 1);
                }
                String portrait = postData.rt().getPortrait();
                lVar.aZi.setTag(d.g.tag_user_id, postData.rt().getUserId());
                lVar.aZi.setTag(d.g.tag_user_name, postData.rt().getUserName());
                lVar.aZi.setTag(d.g.tag_virtual_user_url, postData.rt().getVirtualUserUrl());
                String name_show2 = postData.rt().getName_show();
                String userName = postData.rt().getUserName();
                if (com.baidu.tbadk.p.ac.fS() && name_show2 != null && !name_show2.equals(userName)) {
                    lVar.aZi.setText(com.baidu.tieba.pb.c.al(this.mContext, lVar.aZi.getText().toString()));
                    lVar.aZi.setGravity(16);
                    lVar.aZi.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPy());
                    com.baidu.tbadk.core.util.aj.c(lVar.aZi, d.C0080d.cp_other_e, 1);
                }
                if (postData.rt().getPendantData() != null && !StringUtils.isNull(postData.rt().getPendantData().pQ())) {
                    UtilHelper.showHeadImageViewBigV(lVar.eNE.getHeadView(), postData.rt());
                    lVar.eNy.setVisibility(8);
                    lVar.eNE.setVisibility(0);
                    lVar.eNE.getHeadView().startLoad(portrait, 28, false);
                    lVar.eNE.getHeadView().setUserId(postData.rt().getUserId());
                    lVar.eNE.getHeadView().setUserName(postData.rt().getUserName());
                    lVar.eNE.en(postData.rt().getPendantData().pQ());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.eNy, postData.rt());
                    lVar.eNy.setUserId(postData.rt().getUserId());
                    lVar.eNy.ae(postData.rt().getUserName(), postData.buQ());
                    lVar.eNy.setTag(d.g.tag_virtual_user_url, postData.rt().getVirtualUserUrl());
                    lVar.eNy.setImageDrawable(null);
                    lVar.eNy.startLoad(portrait, 28, false);
                    lVar.eNy.setVisibility(0);
                    lVar.eNE.setVisibility(8);
                }
                if (postData.rt() != null) {
                    MetaData rt = postData.rt();
                    lVar.eNs.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(lVar.eNs, d.C0080d.cp_link_tip_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rt.getUserId())) {
                        lVar.eNs.setText(d.j.host_name);
                    } else if (rt.getIs_bawu() == 1 && "manager".equals(rt.getBawu_type())) {
                        lVar.eNs.setText(d.j.bawu_manager);
                    } else if (rt.getIs_bawu() == 1 && "assist".equals(rt.getBawu_type())) {
                        lVar.eNs.setText(d.j.bawu_assist);
                    } else {
                        lVar.eNs.setVisibility(8);
                    }
                } else {
                    lVar.eNs.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.i buJ = postData.buJ();
            if (buJ != null && !StringUtils.isNull(buJ.getName())) {
                final String name = buJ.getName();
                final String lat = buJ.getLat();
                final String lng = buJ.getLng();
                lVar.eNv.setVisibility(0);
                lVar.eNv.setText(buJ.getName());
                lVar.eNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.hh()) {
                                com.baidu.tbadk.browser.a.O(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.eMB.showToast(d.j.neterror);
                            }
                        }
                    }
                });
            } else {
                lVar.eNv.setVisibility(8);
            }
            if (postData.buU() != null && !StringUtils.isNull(postData.buU().getForumName())) {
                lVar.cmn.setText(this.mContext.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.buU().getForumName(), 5, true)));
                lVar.cmn.setVisibility(0);
            } else {
                lVar.cmn.setVisibility(8);
            }
            int i4 = 0;
            if (this.eMB.aSd()) {
                if (postData.rt() != null) {
                    i4 = postData.rt().getLevel_id();
                }
            } else if (postData.buU() != null) {
                i4 = postData.buU().qO();
            }
            if (i4 > 0) {
                lVar.eND.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.eND, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                lVar.eND.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.buG()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.rt() != null && !StringUtils.isNull(postData.rt().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eIl != null && this.eIl.aQh() != 0) {
                if (this.eIl.aQh() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.rt() != null) {
                    String userId = postData.rt().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eIl != null && this.eIl.aPW() != null && this.eIl.aPW().rt() != null && postData.rt() != null) {
                String userId2 = this.eIl.aPW().rt().getUserId();
                String userId3 = postData.rt().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.rt() != null && UtilHelper.isCurrentAccount(postData.rt().getUserId())) {
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
                    int i5 = 1;
                    if (postData.buG() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eIl.aQh()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rt() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                        }
                        if (this.eIl.aPW() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.eIl.aPW().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eIl.aQh()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.eNx.setTag(sparseArray);
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
            int i52 = 1;
            if (postData.buG() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.eNx.setTag(sparseArray);
        }
    }

    private void c(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.eNw.a(postData.buT(), postData.buS(), false);
            lVar.eNw.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void d(l lVar, PostData postData) {
        boolean z = true;
        if (lVar != null && postData != null) {
            if (postData.buG() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.buG()));
                lVar.eNC.setVisibility(0);
                lVar.eNC.setText(format);
            } else {
                lVar.eNC.setVisibility(8);
                z = false;
            }
            if (z) {
                lVar.eNu.setVisibility(0);
                lVar.eNt.setPadding(this.DS8, 0, 0, 0);
            } else {
                lVar.eNu.setVisibility(8);
                lVar.eNt.setPadding(0, 0, 0, 0);
            }
            lVar.eNt.setText(postData.buI());
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eNz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds120);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.eNz.setPadding(0, 0, 0, 0);
            if (!this.eIj) {
                lVar.eNz.getLayoutStrategy().fO(d.f.icon_click);
            } else {
                lVar.eNz.hf(null);
                lVar.eNz.setBackgroundDrawable(null);
                lVar.eNz.getLayoutStrategy().fO(d.f.transparent_bg);
            }
            lVar.eNz.getLayoutStrategy().fL(d.f.pic_video);
            a(lVar.eNz, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.eNz.setLayoutParams(layoutParams);
            lVar.eNz.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            lVar.eNz.setIsFromCDN(this.mIsFromCDN);
            lVar.eNz.a(postData.aEx(), true, this.eNo);
            SparseArray sparseArray = (SparseArray) lVar.eNz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.eNz.setTag(sparseArray);
            lVar.eIy.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ac = (ac - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fM(ac - (z ? getDimensionPixelSize(d.e.ds70) : 0));
            tbRichTextView.getLayoutStrategy().fN((int) (ac * 1.618f));
        }
    }

    private void d(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.buK() > 0 && postData.buD() != null && postData.buD().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eNB.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds10);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds120);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds34);
                layoutParams.bottomMargin = 0;
                lVar.eNB.setLayoutParams(layoutParams);
                if (this.eIm == null) {
                    this.eIm = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eIm.setIsFromCDN(this.mIsFromCDN);
                    this.eIm.F(this.eIo);
                    String str = null;
                    if (this.eIl != null && this.eIl.aPW() != null && this.eIl.aPW().rt() != null) {
                        str = this.eIl.aPW().rt().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eIl != null) {
                        this.eIm.z(this.eIl.aQh(), z);
                        this.eIm.M(this.eIl.aPW());
                    }
                }
                this.eIm.pU(postData.getId());
                lVar.eNB.setSubPbAdapter(this.eIm);
                lVar.eNB.setVisibility(0);
                lVar.eNB.a(postData, view);
                lVar.eNB.setChildOnClickListener(this.mCommonClickListener);
                lVar.eNB.setChildOnLongClickListener(this.auZ);
                lVar.eNB.setChildOnTouchListener(this.eNp);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eNB.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.eNB.setLayoutParams(layoutParams2);
                lVar.eNB.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
            layoutParams3.topMargin = this.DS20;
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.bottomMargin = 0;
            if (lVar.eNB.getVisibility() == 0) {
                layoutParams3.topMargin = this.bGT;
            } else if (lVar.eNv.getVisibility() == 0) {
                layoutParams3.topMargin = this.bGT;
            }
            lVar.mBottomLine.setLayoutParams(layoutParams3);
            if (postData.gqW) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(lVar.aZi, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eNs, d.C0080d.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eNt, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eNu, d.C0080d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(lVar.eNC, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.cmn, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eNv, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.k(lVar.mBottomLine, d.C0080d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.eNx, d.f.icon_floor_more_selector);
                lVar.eNz.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(lVar.eNB, d.C0080d.cp_bg_line_e);
                lVar.eNA.onChangeSkinType();
                lVar.eNw.onChangeSkinType();
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.eIy.setOnTouchListener(this.eNp);
        lVar.eIy.setOnLongClickListener(this.auZ);
        if (this.eMB.getPageContext() != null && this.eMB.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN;
            lVar.aZi.setOnClickListener(aVar.eYc);
            lVar.eNy.setOnClickListener(aVar.eYc);
            lVar.eNE.setOnClickListener(aVar.eYc);
            lVar.eNE.getHeadView().setOnClickListener(aVar.eYc);
            lVar.eNz.setOnLongClickListener(this.auZ);
            lVar.eNz.setOnTouchListener(this.eNp);
            lVar.eNz.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.eNz.setOnImageClickListener(this.aSD);
            lVar.eNz.setOnImageTouchListener(this.eNp);
            lVar.eNz.setOnEmotionClickListener(aVar.eYe);
            lVar.eNx.setOnClickListener(this.mCommonClickListener);
            lVar.eNw.setOnClickListener(this.mCommonClickListener);
            lVar.eJd.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eNo = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eIl = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iE(boolean z) {
        this.eIj = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eMB.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.eNz.setTextViewOnTouchListener(this.aSE);
        lVar.eNz.setTextViewCheckSelection(false);
    }

    public void D(View.OnClickListener onClickListener) {
        this.eIo = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSD = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auZ = onLongClickListener;
    }
}
