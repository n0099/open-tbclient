package com.baidu.tieba.pb.pb;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.s.ao;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> hlr = new SparseArray<>();
    private static SparseIntArray hls = new SparseIntArray();
    public static final int hlt = getDimensionPixelSize(d.e.tbds12);
    public static final int hlu = getDimensionPixelSize(d.e.tbds16);
    public static final int hlv = getDimensionPixelSize(d.e.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hls.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hls.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return n.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(j jVar, com.baidu.tieba.pb.data.d dVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                al.d(jVar.dZu, d.C0277d.cp_cont_f, 1);
                if (jVar.hpU.getTag() instanceof Integer) {
                    al.k(jVar.hpU, ((Integer) jVar.hpU.getTag()).intValue());
                }
                al.d(jVar.hpV, d.C0277d.cp_cont_d, 1);
                al.j(jVar.hpW, d.C0277d.cp_cont_d);
                al.j(jVar.hpX, d.C0277d.cp_cont_d);
                al.d(jVar.hqg, d.C0277d.cp_cont_d, 1);
                al.d(jVar.hpY, d.C0277d.cp_cont_d, 1);
                jVar.hqb.setTextColor(al.getColor(d.C0277d.cp_cont_b));
                jVar.hqc.onChangeSkinType();
                if (dVar != null) {
                    al.j(jVar.hqe, d.C0277d.cp_cont_c);
                    jVar.hqe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                    al.j(jVar.hqf, d.C0277d.cp_cont_c);
                    al.l(jVar.hqd, d.C0277d.cp_bg_line_e);
                    jVar.hqd.onChangeSkinType();
                    al.d(jVar.hqp, d.C0277d.cp_link_tip_c, 1);
                    al.d(jVar.hqn, d.C0277d.cp_cont_f, 1);
                    al.k(jVar.hqm, d.C0277d.cp_bg_line_e);
                    al.k(jVar.hqo, d.C0277d.cp_cont_d);
                    al.c(jVar.hqq, d.f.icon_arrow_more_gray);
                    al.j(jVar.hqt, d.C0277d.cp_cont_c);
                    if (jVar.hqr.getVisibility() == 8) {
                        jVar.hqe.setVisibility(8);
                        jVar.hqf.setVisibility(8);
                        jVar.hqt.setText(d.j.close_content);
                    } else if (StringUtils.isNull(dVar.bIh())) {
                        jVar.hqt.setText(dVar.bIh());
                    } else {
                        jVar.hqt.setText(d.j.expand_content);
                    }
                } else {
                    jVar.hqd.setVisibility(8);
                    jVar.hqe.setVisibility(8);
                    jVar.hqf.setVisibility(8);
                    jVar.hqm.setVisibility(8);
                    jVar.hqt.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bg bgVar, int i) {
        if (jVar != null && postData != null && postData.aaH() != null) {
            if (bgVar != null) {
                postData.aaH().threadId = bgVar.getTid();
                postData.aaH().forumId = String.valueOf(bgVar.getFid());
            }
            if (i == 0) {
                postData.aaH().objType = 1;
            } else {
                postData.aaH().objType = 2;
            }
            postData.aaH().isInPost = true;
            jVar.hpZ.setData(postData.aaH());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0486 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x064a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(j jVar, PostData postData, View view, int i, a aVar, bg bgVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String userId;
        if (jVar != null && postData != null) {
            if (postData.iGL) {
                al.l(jVar.mTopLine, d.C0277d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bgVar == null || bgVar.YR() == null) {
                str = null;
            } else {
                str = bgVar.YR().getUserId();
            }
            jVar.hqa.setTag(null);
            jVar.hqa.setUserId(null);
            jVar.dZu.setText((CharSequence) null);
            jVar.hqi.getHeadView().setUserId(null);
            jVar.hqb.setIsHost(false);
            if (postData.YR() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.YR().getUserId())) {
                    jVar.hqb.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YR().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YR().getTShowInfoNew();
                if (jVar.hqk != null) {
                    jVar.hqk.setTag(d.g.tag_user_id, postData.YR().getUserId());
                    jVar.hqk.setOnClickListener(aVar.bIP().hAf);
                    jVar.hqk.a(iconInfo, 2, hlv, hlv, hlt);
                }
                if (jVar.hqj != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hqj.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hqj.setOnClickListener(aVar.bIP().hAg);
                    jVar.hqj.a(tShowInfoNew, 3, hlv, hlv, hlt, true);
                }
                if (!v.T(tShowInfoNew) || postData.YR().isBigV()) {
                    al.d(jVar.dZu, d.C0277d.cp_cont_h, 1);
                } else {
                    al.d(jVar.dZu, d.C0277d.cp_cont_f, 1);
                }
                String portrait = postData.YR().getPortrait();
                jVar.dZu.setTag(d.g.tag_user_id, postData.YR().getUserId());
                jVar.dZu.setTag(d.g.tag_user_name, postData.YR().getUserName());
                jVar.dZu.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                String name_show = postData.YR().getName_show();
                String userName = postData.YR().getUserName();
                if (ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dZu.setText(c.aP(aVar.getPageContext().getPageActivity(), jVar.dZu.getText().toString()));
                    jVar.dZu.setGravity(16);
                    jVar.dZu.setTag(d.g.tag_nick_name_activity, c.bHK());
                    al.d(jVar.dZu, d.C0277d.cp_other_e, 1);
                }
                if (postData.YR().getPendantData() != null && !StringUtils.isNull(postData.YR().getPendantData().Xn())) {
                    jVar.hqi.b(postData.YR());
                    jVar.hqa.setVisibility(8);
                    jVar.hqi.setVisibility(0);
                    jVar.hqi.getHeadView().startLoad(portrait, 28, false);
                    jVar.hqi.getHeadView().setUserId(postData.YR().getUserId());
                    jVar.hqi.getHeadView().setUserName(postData.YR().getUserName());
                    jVar.hqi.nm(postData.YR().getPendantData().Xn());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hqa, postData.YR());
                    jVar.hqa.setUserId(postData.YR().getUserId());
                    jVar.hqa.setUserName(postData.YR().getUserName(), postData.ceD());
                    jVar.hqa.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                    jVar.hqa.setImageDrawable(null);
                    jVar.hqa.startLoad(portrait, 28, false);
                    jVar.hqa.setVisibility(0);
                    jVar.hqi.setVisibility(8);
                }
                if (postData.YR() != null) {
                    MetaData YR = postData.YR();
                    int hu = postData.cel() ? d.f.brand_official_btn : al.hu(d.f.bg_user_identity_btn);
                    int hu2 = postData.cel() ? d.C0277d.cp_btn_a : al.hu(d.C0277d.cp_bg_line_d);
                    al.k(jVar.hpU, hu);
                    al.j(jVar.hpU, hu2);
                    jVar.hpU.setTag(Integer.valueOf(hu));
                    if (str != null && !str.equals("0") && str.equals(YR.getUserId())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.host_name);
                    } else if (YR.getIs_bawu() == 1 && postData.cel()) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.brand_Official);
                    } else if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_content_assist".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_content_assist_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_manage_assist".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hpU.setVisibility(8);
                        jVar.hpU.setTag(null);
                    }
                } else {
                    jVar.hpU.setVisibility(8);
                    jVar.hpU.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bIQ()) {
                if (postData.YR() != null) {
                    i2 = postData.YR().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hqh.setVisibility(0);
                al.c(jVar.hqh, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hqh.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hqk.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hqk.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hpU.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hqj.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.YR() != null ? postData.YR().getName_show() : "";
            int pN = ab.pN(name_show2);
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                if (pN > i3 - 2) {
                    name_show2 = ab.ah(name_show2, i3 - 2) + "...";
                }
            } else if (pN > i3) {
                name_show2 = ab.ah(name_show2, i3) + "...";
            }
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                jVar.dZu.setText(a(aVar, postData.YR().getSealPrefix(), name_show2));
            } else {
                jVar.dZu.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cet()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (postData.YR() == null || StringUtils.isNull(postData.YR().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bgVar != null && aVar.bIS() != 0) {
                if (aVar.bIS() != 1002 && aVar.bIS() != 3) {
                    z8 = true;
                }
                if (aVar.bIS() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.YR() != null) {
                    String userId2 = postData.YR().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bgVar != null && bgVar.YR() != null && postData.YR() != null) {
                            userId = bgVar.YR().getUserId();
                            String userId3 = postData.YR().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.YR() != null && UtilHelper.isCurrentAccount(postData.YR().getUserId())) {
                                    z6 = true;
                                    z7 = true;
                                } else {
                                    z6 = z10;
                                    z7 = z4;
                                }
                                if (z) {
                                    z2 = false;
                                    z7 = false;
                                    z5 = false;
                                }
                                int i4 = 1;
                                if (postData.cet() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(d.g.tag_should_manage_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(aVar.bIS()));
                                    if (postData.YR() != null) {
                                        sparseArray.put(d.g.tag_forbid_user_name, postData.YR().getUserName());
                                        sparseArray.put(d.g.tag_forbid_user_name_show, postData.YR().getName_show());
                                        sparseArray.put(d.g.tag_forbid_user_portrait, postData.YR().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(d.g.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(d.g.tag_user_mute_visible, true);
                                    sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.YR() != null) {
                                        sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YR().getUserId());
                                        sparseArray.put(d.g.tag_user_mute_mute_username, postData.YR().getUserName());
                                        sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YR().getName_show());
                                    }
                                    sparseArray.put(d.g.tag_user_mute_thread_id, bgVar.getId());
                                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_user_mute_visible, false);
                                }
                                if (!z7 && bgVar != null) {
                                    sparseArray.put(d.g.tag_should_delete_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(aVar.bIS()));
                                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_should_delete_visible, false);
                                }
                                jVar.hqb.setTag(sparseArray);
                            }
                        }
                        z4 = z3;
                        z5 = false;
                        if (postData == null) {
                        }
                        z6 = z10;
                        z7 = z4;
                        if (z) {
                        }
                        int i42 = 1;
                        if (postData.cet() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                        jVar.hqb.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bgVar != null) {
                userId = bgVar.YR().getUserId();
                String userId32 = postData.YR().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z4 = z3;
            z5 = false;
            if (postData == null) {
            }
            z6 = z10;
            z7 = z4;
            if (z) {
            }
            int i422 = 1;
            if (postData.cet() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(d.g.tag_should_delete_visible, false);
            jVar.hqb.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(d.e.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().kz(aO - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cCn = (aO - dimensionPixelSize) - getDimensionPixelSize(d.e.tbds122);
            tbRichTextView.getLayoutStrategy().kA((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqb.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.h(pageActivity, d.e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hqb.qb(null);
                jVar.hqb.setBackgroundDrawable(null);
                jVar.hqb.getLayoutStrategy().kB(d.f.transparent_bg);
            } else {
                jVar.hqb.getLayoutStrategy().kB(d.f.icon_click);
            }
            jVar.hqb.getLayoutStrategy().ky(d.f.pic_video);
            a(jVar.hqb, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hqb.setLayoutParams(layoutParams);
            jVar.hqb.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            jVar.hqb.setIsFromCDN(z2);
            TbRichText cev = postData.cev();
            jVar.hqb.setIsUseGridImage(postData.ceG());
            jVar.hqb.setText(cev, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hqb.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hqb.setTag(sparseArray);
            jVar.hpS.setTag(d.g.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cet() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(d.j.is_floor), Integer.valueOf(postData.cet()));
                jVar.hqg.setVisibility(0);
                jVar.hqg.setText(format);
                z = true;
            } else {
                jVar.hqg.setVisibility(8);
                z = false;
            }
            f cew = postData.cew();
            boolean z2 = (cew == null || StringUtils.isNull(cew.getName())) ? false : true;
            if (z) {
                jVar.hpW.setVisibility(0);
                i = hlu;
            } else {
                jVar.hpW.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hpX.setVisibility(0);
                i2 = hlu;
            } else {
                jVar.hpX.setVisibility(8);
                i2 = 0;
            }
            jVar.hpV.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hpV.setText(ap.aq(postData.getTime()));
            } else {
                jVar.hpV.setText(ap.ao(postData.getTime()));
            }
            if (z2) {
                jVar.hpY.setVisibility(0);
                jVar.hpY.setPadding(hlu, 0, 0, 0);
                jVar.hpY.setText(cew.getName());
                return;
            }
            jVar.hpY.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bOO() == null) {
            jVar.hql.setVisibility(8);
            return;
        }
        TbRichText cev = postData.cev();
        com.baidu.tieba.pb.view.b.a(postData.bOO(), jVar.hql, false, false, cev != null && StringUtils.isNull(cev.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqb.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hqb.setLayoutParams(layoutParams);
            jVar.hqb.setPadding(0, 0, 0, 0);
            jVar.hqb.qb(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqb.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hqb.setLayoutParams(layoutParams2);
            jVar.hqb.qb(postData.getBimg_url());
        }
        jVar.hqb.setTextViewCheckSelection(false);
    }
}
