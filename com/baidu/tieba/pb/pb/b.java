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
import com.xiaomi.mipush.sdk.Constants;
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
                al.d(jVar.dZy, d.C0236d.cp_cont_f, 1);
                if (jVar.hqa.getTag() instanceof Integer) {
                    al.k(jVar.hqa, ((Integer) jVar.hqa.getTag()).intValue());
                }
                al.d(jVar.hqb, d.C0236d.cp_cont_d, 1);
                al.j(jVar.hqc, d.C0236d.cp_cont_d);
                al.j(jVar.hqd, d.C0236d.cp_cont_d);
                al.d(jVar.hqm, d.C0236d.cp_cont_d, 1);
                al.d(jVar.hqe, d.C0236d.cp_cont_d, 1);
                jVar.hqh.setTextColor(al.getColor(d.C0236d.cp_cont_b));
                jVar.hqi.onChangeSkinType();
                if (dVar != null) {
                    al.j(jVar.hqk, d.C0236d.cp_cont_c);
                    jVar.hqk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                    al.j(jVar.hql, d.C0236d.cp_cont_c);
                    al.l(jVar.hqj, d.C0236d.cp_bg_line_e);
                    jVar.hqj.onChangeSkinType();
                    al.d(jVar.hqv, d.C0236d.cp_link_tip_c, 1);
                    al.d(jVar.hqt, d.C0236d.cp_cont_f, 1);
                    al.k(jVar.hqs, d.C0236d.cp_bg_line_e);
                    al.k(jVar.hqu, d.C0236d.cp_cont_d);
                    al.c(jVar.hqw, d.f.icon_arrow_more_gray);
                    al.j(jVar.hqz, d.C0236d.cp_cont_c);
                    if (jVar.hqx.getVisibility() == 8) {
                        jVar.hqk.setVisibility(8);
                        jVar.hql.setVisibility(8);
                        jVar.hqz.setText(d.j.close_content);
                    } else if (StringUtils.isNull(dVar.bIh())) {
                        jVar.hqz.setText(dVar.bIh());
                    } else {
                        jVar.hqz.setText(d.j.expand_content);
                    }
                } else {
                    jVar.hqj.setVisibility(8);
                    jVar.hqk.setVisibility(8);
                    jVar.hql.setVisibility(8);
                    jVar.hqs.setVisibility(8);
                    jVar.hqz.setVisibility(8);
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
            jVar.hqf.setData(postData.aaH());
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
            if (postData.iGS) {
                al.l(jVar.mTopLine, d.C0236d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bgVar == null || bgVar.YR() == null) {
                str = null;
            } else {
                str = bgVar.YR().getUserId();
            }
            jVar.hqg.setTag(null);
            jVar.hqg.setUserId(null);
            jVar.dZy.setText((CharSequence) null);
            jVar.hqo.getHeadView().setUserId(null);
            jVar.hqh.setIsHost(false);
            if (postData.YR() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.YR().getUserId())) {
                    jVar.hqh.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YR().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YR().getTShowInfoNew();
                if (jVar.hqq != null) {
                    jVar.hqq.setTag(d.g.tag_user_id, postData.YR().getUserId());
                    jVar.hqq.setOnClickListener(aVar.bIP().hAk);
                    jVar.hqq.a(iconInfo, 2, hlv, hlv, hlt);
                }
                if (jVar.hqp != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hqp.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hqp.setOnClickListener(aVar.bIP().hAl);
                    jVar.hqp.a(tShowInfoNew, 3, hlv, hlv, hlt, true);
                }
                if (!v.T(tShowInfoNew) || postData.YR().isBigV()) {
                    al.d(jVar.dZy, d.C0236d.cp_cont_h, 1);
                } else {
                    al.d(jVar.dZy, d.C0236d.cp_cont_f, 1);
                }
                String portrait = postData.YR().getPortrait();
                jVar.dZy.setTag(d.g.tag_user_id, postData.YR().getUserId());
                jVar.dZy.setTag(d.g.tag_user_name, postData.YR().getUserName());
                jVar.dZy.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                String name_show = postData.YR().getName_show();
                String userName = postData.YR().getUserName();
                if (ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dZy.setText(c.aQ(aVar.getPageContext().getPageActivity(), jVar.dZy.getText().toString()));
                    jVar.dZy.setGravity(16);
                    jVar.dZy.setTag(d.g.tag_nick_name_activity, c.bHK());
                    al.d(jVar.dZy, d.C0236d.cp_other_e, 1);
                }
                if (postData.YR().getPendantData() != null && !StringUtils.isNull(postData.YR().getPendantData().Xn())) {
                    jVar.hqo.b(postData.YR());
                    jVar.hqg.setVisibility(8);
                    jVar.hqo.setVisibility(0);
                    jVar.hqo.getHeadView().startLoad(portrait, 28, false);
                    jVar.hqo.getHeadView().setUserId(postData.YR().getUserId());
                    jVar.hqo.getHeadView().setUserName(postData.YR().getUserName());
                    jVar.hqo.nm(postData.YR().getPendantData().Xn());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hqg, postData.YR());
                    jVar.hqg.setUserId(postData.YR().getUserId());
                    jVar.hqg.setUserName(postData.YR().getUserName(), postData.ceA());
                    jVar.hqg.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                    jVar.hqg.setImageDrawable(null);
                    jVar.hqg.startLoad(portrait, 28, false);
                    jVar.hqg.setVisibility(0);
                    jVar.hqo.setVisibility(8);
                }
                if (postData.YR() != null) {
                    MetaData YR = postData.YR();
                    int hu = postData.cei() ? d.f.brand_official_btn : al.hu(d.f.bg_user_identity_btn);
                    int hu2 = postData.cei() ? d.C0236d.cp_btn_a : al.hu(d.C0236d.cp_bg_line_d);
                    al.k(jVar.hqa, hu);
                    al.j(jVar.hqa, hu2);
                    jVar.hqa.setTag(Integer.valueOf(hu));
                    if (str != null && !str.equals("0") && str.equals(YR.getUserId())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.host_name);
                    } else if (YR.getIs_bawu() == 1 && postData.cei()) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.brand_Official);
                    } else if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_content_assist".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_content_assist_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_manage_assist".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hqa.setVisibility(8);
                        jVar.hqa.setTag(null);
                    }
                } else {
                    jVar.hqa.setVisibility(8);
                    jVar.hqa.setTag(null);
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
                jVar.hqn.setVisibility(0);
                al.c(jVar.hqn, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hqn.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hqq.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hqq.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hqa.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hqp.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.YR() != null ? postData.YR().getName_show() : "";
            int pO = ab.pO(name_show2);
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                if (pO > i3 - 2) {
                    name_show2 = ab.ah(name_show2, i3 - 2) + "...";
                }
            } else if (pO > i3) {
                name_show2 = ab.ah(name_show2, i3) + "...";
            }
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                jVar.dZy.setText(a(aVar, postData.YR().getSealPrefix(), name_show2));
            } else {
                jVar.dZy.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.ceq()));
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
                                if (postData.ceq() == 1) {
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
                                jVar.hqh.setTag(sparseArray);
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
                        if (postData.ceq() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                        jVar.hqh.setTag(sparseArray);
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
            if (postData.ceq() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(d.g.tag_should_delete_visible, false);
            jVar.hqh.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().cCq = (aO - dimensionPixelSize) - getDimensionPixelSize(d.e.tbds122);
            tbRichTextView.getLayoutStrategy().kA((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqh.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.h(pageActivity, d.e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hqh.qc(null);
                jVar.hqh.setBackgroundDrawable(null);
                jVar.hqh.getLayoutStrategy().kB(d.f.transparent_bg);
            } else {
                jVar.hqh.getLayoutStrategy().kB(d.f.icon_click);
            }
            jVar.hqh.getLayoutStrategy().ky(d.f.pic_video);
            a(jVar.hqh, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hqh.setLayoutParams(layoutParams);
            jVar.hqh.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
            jVar.hqh.setIsFromCDN(z2);
            TbRichText ces = postData.ces();
            jVar.hqh.setIsUseGridImage(postData.ceD());
            jVar.hqh.setText(ces, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hqh.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hqh.setTag(sparseArray);
            jVar.hpY.setTag(d.g.tag_from, sparseArray);
        }
    }

    public static void a(final a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.ceq() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(d.j.is_floor), Integer.valueOf(postData.ceq()));
                jVar.hqm.setVisibility(0);
                jVar.hqm.setText(format);
                z = true;
            } else {
                jVar.hqm.setVisibility(8);
                z = false;
            }
            f cet = postData.cet();
            boolean z2 = (cet == null || StringUtils.isNull(cet.getName())) ? false : true;
            if (z) {
                jVar.hqc.setVisibility(0);
                i = hlu;
            } else {
                jVar.hqc.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hqd.setVisibility(0);
                i2 = hlu;
            } else {
                jVar.hqd.setVisibility(8);
                i2 = 0;
            }
            jVar.hqb.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hqb.setText(ap.aq(postData.getTime()));
            } else {
                jVar.hqb.setText(ap.ao(postData.getTime()));
            }
            if (z2) {
                final String name = cet.getName();
                final String lat = cet.getLat();
                final String lng = cet.getLng();
                jVar.hqe.setVisibility(0);
                jVar.hqe.setPadding(hlu, 0, 0, 0);
                jVar.hqe.setText(cet.getName());
                jVar.hqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (!com.baidu.adp.lib.util.j.kY()) {
                                aVar.getPageContext().showToast(d.j.neterror);
                            } else {
                                com.baidu.tbadk.browser.a.ar(aVar.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, TbadkApplication.getInst().getString(d.j.app_info_for_map)));
                            }
                        }
                    }
                });
                return;
            }
            jVar.hqe.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bON() == null) {
            jVar.hqr.setVisibility(8);
            return;
        }
        TbRichText ces = postData.ces();
        com.baidu.tieba.pb.view.b.a(postData.bON(), jVar.hqr, false, false, ces != null && StringUtils.isNull(ces.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqh.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hqh.setLayoutParams(layoutParams);
            jVar.hqh.setPadding(0, 0, 0, 0);
            jVar.hqh.qc(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqh.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hqh.setLayoutParams(layoutParams2);
            jVar.hqh.qc(postData.getBimg_url());
        }
        jVar.hqh.setTextViewCheckSelection(false);
    }
}
