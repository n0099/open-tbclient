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
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private boolean aVB;
    private TbRichTextView.f aVE;
    private com.baidu.tieba.pb.a.c aVF;
    private View.OnLongClickListener avA;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNv;
    private com.baidu.adp.lib.e.b<TbImageView> cNw;
    private boolean ePM;
    protected com.baidu.tieba.pb.data.f ePO;
    private com.baidu.tieba.pb.pb.sub.d ePP;
    private View.OnClickListener ePR;
    private int eUV;
    private int eUW;
    private int eUX;
    private TbRichTextView.b eUY;
    private com.baidu.tieba.pb.a.c eUZ;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData ba;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bwC() && this.mCommonClickListener != null && this.eUm != null && (ba = this.eUm.ba(findViewById)) != null) {
                TiebaStatic.log(this.eUm.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", ba.bwC() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eUV = 0;
        this.eUW = 0;
        this.eUX = 0;
        this.eUY = null;
        this.ePM = true;
        this.mHostId = null;
        this.ePO = null;
        this.ePR = null;
        this.mCommonClickListener = null;
        this.aVE = null;
        this.aVF = null;
        this.avA = null;
        this.ePP = null;
        this.aVB = true;
        this.cNv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anD */
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
        this.cNw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wN */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.common_color_10043));
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
        this.eUZ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.eUm == null || k.this.eUm.aSI() == null || k.this.eUm.aSI().aVG())) {
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
                if (k.this.aVF != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.aVF.aX(view);
                        k.this.aVF.onSingleTapConfirmed(motionEvent);
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
        l lVar = new l(this.eUm.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.eVl.setConstrainLayoutPool(this.cNv);
        lVar.eVl.setImageViewPool(this.cNw);
        a(lVar);
        this.eUV = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds12);
        this.eUW = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds20);
        this.eUX = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds36);
        if (lVar.eVk != null) {
            lVar.eVk.setDuiEnabled(this.aVB);
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
            postData2.sw();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.aVB = z;
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
        if (postData.ZA == 0 && postData.gzL) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ac("post_id", postData.getId());
            akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.aXW() == null) {
            lVar.eQG.setVisibility(8);
            return;
        }
        TbRichText bwr = postData.bwr();
        com.baidu.tieba.pb.view.g.a(postData.aXW(), lVar.eQG, false, false, bwr != null && StringUtils.isNull(bwr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ePM) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eVk.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.eVk.setLayoutParams(layoutParams);
            lVar.eVk.setPadding(0, 0, 0, 0);
            lVar.eVk.hi(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eVk.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.eVk.setLayoutParams(layoutParams2);
            lVar.eVk.hi(postData.getBimg_url());
        }
        lVar.eVk.setTextViewOnTouchListener(this.eUZ);
        lVar.eVk.setTextViewCheckSelection(false);
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
            if (postData.cSS) {
                com.baidu.tbadk.core.util.aj.k(lVar.axX, d.C0082d.cp_bg_line_c);
                lVar.axX.setVisibility(0);
            } else {
                lVar.axX.setVisibility(8);
            }
            lVar.eVj.setTag(null);
            lVar.eVj.setUserId(null);
            lVar.bcu.setText((CharSequence) null);
            lVar.eVp.getHeadView().setUserId(null);
            if (postData.rx() != null) {
                ArrayList<IconData> iconInfo = postData.rx().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rx().getTShowInfoNew();
                if (lVar.eVr != null) {
                    lVar.eVr.setTag(d.g.tag_user_id, postData.rx().getUserId());
                    lVar.eVr.setOnClickListener(this.eUm.eSr.cSI);
                    lVar.eVr.a(iconInfo, 2, this.eUX, this.eUX, this.eUV);
                }
                if (lVar.eVq != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.eVq.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.eVq.setOnClickListener(this.eUm.eSr.feS);
                    lVar.eVq.a(tShowInfoNew, 3, this.eUX, this.eUX, this.eUV, true);
                }
                if (!com.baidu.tbadk.core.util.v.w(tShowInfoNew) || postData.rx().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(lVar.bcu, d.C0082d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(lVar.bcu, d.C0082d.cp_cont_f, 1);
                }
                String portrait = postData.rx().getPortrait();
                lVar.bcu.setTag(d.g.tag_user_id, postData.rx().getUserId());
                lVar.bcu.setTag(d.g.tag_user_name, postData.rx().getUserName());
                lVar.bcu.setTag(d.g.tag_virtual_user_url, postData.rx().getVirtualUserUrl());
                String name_show = postData.rx().getName_show();
                String userName = postData.rx().getUserName();
                if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                    lVar.bcu.setText(com.baidu.tieba.pb.c.ak(this.mContext, lVar.bcu.getText().toString()));
                    lVar.bcu.setGravity(16);
                    lVar.bcu.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQJ());
                    com.baidu.tbadk.core.util.aj.c(lVar.bcu, d.C0082d.cp_other_e, 1);
                }
                if (postData.rx().getPendantData() != null && !StringUtils.isNull(postData.rx().getPendantData().pT())) {
                    UtilHelper.showHeadImageViewBigV(lVar.eVp.getHeadView(), postData.rx());
                    lVar.eVj.setVisibility(8);
                    lVar.eVp.setVisibility(0);
                    lVar.eVp.getHeadView().startLoad(portrait, 28, false);
                    lVar.eVp.getHeadView().setUserId(postData.rx().getUserId());
                    lVar.eVp.getHeadView().setUserName(postData.rx().getUserName());
                    lVar.eVp.es(postData.rx().getPendantData().pT());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.eVj, postData.rx());
                    lVar.eVj.setUserId(postData.rx().getUserId());
                    lVar.eVj.ae(postData.rx().getUserName(), postData.bwz());
                    lVar.eVj.setTag(d.g.tag_virtual_user_url, postData.rx().getVirtualUserUrl());
                    lVar.eVj.setImageDrawable(null);
                    lVar.eVj.startLoad(portrait, 28, false);
                    lVar.eVj.setVisibility(0);
                    lVar.eVp.setVisibility(8);
                }
                if (postData.rx() != null) {
                    MetaData rx = postData.rx();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rx.getUserId())) {
                        lVar.eVc.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eVc, d.f.icon_id_louzhu);
                        lVar.eVc.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (rx.getIs_bawu() == 1 && "manager".equals(rx.getBawu_type())) {
                        lVar.eVc.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eVc, d.f.icon_id_bazhu);
                        lVar.eVc.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (rx.getIs_bawu() == 1 && "assist".equals(rx.getBawu_type())) {
                        lVar.eVc.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eVc, d.f.icon_id_xiaobazhu);
                        lVar.eVc.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        lVar.eVc.setVisibility(8);
                        lVar.eVc.setTag(null);
                    }
                } else {
                    lVar.eVc.setVisibility(8);
                    lVar.eVc.setTag(null);
                }
            }
            int i2 = 0;
            if (this.eUm.aTu()) {
                if (postData.rx() != null) {
                    i2 = postData.rx().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.eVo.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.eVo, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.eVo.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.eVr.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.eVr.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.eVc.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.eVq.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.rx().getName_show();
            int ha = com.baidu.tbadk.util.w.ha(name_show2);
            if (!StringUtils.isNull(postData.rx().getSealPrefix())) {
                if (ha > i3 - 2) {
                    str = com.baidu.tbadk.util.w.H(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (ha > i3) {
                    str = com.baidu.tbadk.util.w.H(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.rx().getSealPrefix())) {
                lVar.bcu.setText(ag(postData.rx().getSealPrefix(), str));
            } else {
                lVar.bcu.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwo()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.rx() != null && !StringUtils.isNull(postData.rx().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.ePO != null && this.ePO.aRs() != 0) {
                if (this.ePO.aRs() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.rx() != null) {
                    String userId = postData.rx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.ePO != null && this.ePO.aRh() != null && this.ePO.aRh().rx() != null && postData.rx() != null) {
                String userId2 = this.ePO.aRh().rx().getUserId();
                String userId3 = postData.rx().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.rx() != null && UtilHelper.isCurrentAccount(postData.rx().getUserId())) {
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
                    if (postData.bwo() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ePO.aRs()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rx().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rx() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rx().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rx().getUserName());
                        }
                        if (this.ePO.aRh() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.ePO.aRh().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ePO.aRs()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.eVi.setTag(sparseArray);
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
            if (postData.bwo() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.eVi.setTag(sparseArray);
        }
    }

    private void c(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.eVh.a(postData.bwC(), postData.bwB(), false);
            lVar.eVh.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void d(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.bwo() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwo()));
                lVar.eVn.setVisibility(0);
                lVar.eVn.setText(format);
                z = true;
            } else {
                lVar.eVn.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.i bws = postData.bws();
            boolean z2 = (bws == null || StringUtils.isNull(bws.getName())) ? false : true;
            if (z) {
                lVar.eVe.setVisibility(0);
                i = this.eUW;
            } else {
                lVar.eVe.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.eVf.setVisibility(0);
                i2 = this.eUW;
            } else {
                lVar.eVf.setVisibility(8);
                i2 = 0;
            }
            lVar.eVd.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.eVd.setText(com.baidu.tbadk.core.util.am.s(postData.getTime()));
            } else {
                lVar.eVd.setText(com.baidu.tbadk.core.util.am.r(postData.getTime()));
            }
            if (z2) {
                final String name = bws.getName();
                final String lat = bws.getLat();
                final String lng = bws.getLng();
                lVar.eVg.setVisibility(0);
                lVar.eVg.setPadding(this.eUW, 0, 0, 0);
                lVar.eVg.setText(bws.getName());
                lVar.eVg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.hh()) {
                                com.baidu.tbadk.browser.a.P(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.eUm.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            lVar.eVg.setVisibility(8);
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eVk.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.eVk.setPadding(0, 0, 0, 0);
            if (!this.ePM) {
                lVar.eVk.getLayoutStrategy().fV(d.f.icon_click);
            } else {
                lVar.eVk.hi(null);
                lVar.eVk.setBackgroundDrawable(null);
                lVar.eVk.getLayoutStrategy().fV(d.f.transparent_bg);
            }
            lVar.eVk.getLayoutStrategy().fS(d.f.pic_video);
            a(lVar.eVk, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.eVk.setLayoutParams(layoutParams);
            lVar.eVk.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_link_tip_c));
            lVar.eVk.setIsFromCDN(this.mIsFromCDN);
            lVar.eVk.a(postData.bwr(), true, this.eUY);
            SparseArray sparseArray = (SparseArray) lVar.eVk.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.eVk.setTag(sparseArray);
            lVar.eQb.setTag(d.g.tag_from, sparseArray);
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
            if (postData.bwt() > 0 && postData.bwl() != null && postData.bwl().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eVm.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                lVar.eVm.setLayoutParams(layoutParams);
                if (this.ePP == null) {
                    this.ePP = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.ePP.setIsFromCDN(this.mIsFromCDN);
                    this.ePP.G(this.ePR);
                    String str = null;
                    if (this.ePO != null && this.ePO.aRh() != null && this.ePO.aRh().rx() != null) {
                        str = this.ePO.aRh().rx().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.ePO != null) {
                        this.ePP.y(this.ePO.aRs(), z);
                        this.ePP.P(this.ePO.aRh());
                    }
                }
                this.ePP.qh(postData.getId());
                lVar.eVm.setSubPbAdapter(this.ePP);
                lVar.eVm.setVisibility(0);
                lVar.eVm.a(postData, view);
                lVar.eVm.setChildOnClickListener(this.mCommonClickListener);
                lVar.eVm.setChildOnLongClickListener(this.avA);
                lVar.eVm.setChildOnTouchListener(this.eUZ);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eVm.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.eVm.setLayoutParams(layoutParams2);
                lVar.eVm.setVisibility(8);
            }
            if (postData.gzP) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void e(l lVar, PostData postData) {
        if (lVar != null && lVar.eVv != null && lVar.eVs != null) {
            if (postData == null || postData.gzR == null || StringUtils.isNull(postData.gzR.liveTitle)) {
                lVar.eVs.setVisibility(8);
                return;
            }
            lVar.eVv.setText(postData.gzR.liveTitle);
            lVar.eVs.setTag(postData.gzR);
            lVar.eVs.setVisibility(0);
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(lVar.bcu, d.C0082d.cp_cont_f, 1);
                if (lVar.eVc.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(lVar.eVc, ((Integer) lVar.eVc.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.c(lVar.eVd, d.C0082d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eVe, d.C0082d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.j(lVar.eVf, d.C0082d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(lVar.eVn, d.C0082d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eVg, d.C0082d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.k(lVar.mBottomLine, d.C0082d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.eVi, d.f.icon_floor_more_selector);
                lVar.eVk.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(lVar.eVm, d.C0082d.cp_bg_line_e);
                lVar.eVm.onChangeSkinType();
                lVar.eVl.onChangeSkinType();
                lVar.eVh.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.c(lVar.eVv, d.C0082d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eVt, d.C0082d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eVs, d.C0082d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.j(lVar.eVu, d.C0082d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(lVar.eVw, d.f.icon_arrow_more_gray);
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.eQb.setOnTouchListener(this.eUZ);
        lVar.eQb.setOnLongClickListener(this.avA);
        if (this.eUm.getPageContext() != null && this.eUm.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr;
            lVar.bcu.setOnClickListener(aVar.feR);
            lVar.eVj.setOnClickListener(aVar.feR);
            lVar.eVp.setOnClickListener(aVar.feR);
            lVar.eVp.getHeadView().setOnClickListener(aVar.feR);
            lVar.eVk.setOnLongClickListener(this.avA);
            lVar.eVk.setOnTouchListener(this.eUZ);
            lVar.eVk.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.eVk.setOnImageClickListener(this.aVE);
            lVar.eVk.setOnImageTouchListener(this.eUZ);
            lVar.eVk.setOnEmotionClickListener(aVar.feT);
            lVar.eVi.setOnClickListener(this.mCommonClickListener);
            lVar.eVh.setOnClickListener(this.mCommonClickListener);
            lVar.eQG.setOnClickListener(this.mCommonClickListener);
            lVar.eVs.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eUY = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ePO = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iX(boolean z) {
        this.ePM = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.eUm.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.eVk.setTextViewOnTouchListener(this.aVF);
        lVar.eVk.setTextViewCheckSelection(false);
    }

    public void D(View.OnClickListener onClickListener) {
        this.ePR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aVE = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avA = onLongClickListener;
    }
}
