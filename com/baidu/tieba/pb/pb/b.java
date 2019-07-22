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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.t.as;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> hIW = new SparseArray<>();
    private static SparseIntArray hIX = new SparseIntArray();
    public static final int hIY = getDimensionPixelSize(R.dimen.tbds12);
    public static final int hIZ = getDimensionPixelSize(R.dimen.tbds16);
    public static final int hJa = getDimensionPixelSize(R.dimen.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hIX.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hIX.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(j jVar, d dVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                am.f(jVar.enZ, R.color.cp_cont_f, 1);
                if (jVar.hNB.getTag() instanceof Integer) {
                    am.k(jVar.hNB, ((Integer) jVar.hNB.getTag()).intValue());
                }
                am.f(jVar.hNC, R.color.cp_cont_d, 1);
                am.j(jVar.hND, R.color.cp_cont_d);
                am.j(jVar.hNE, R.color.cp_cont_d);
                am.f(jVar.hNN, R.color.cp_cont_d, 1);
                am.f(jVar.hNF, R.color.cp_cont_d, 1);
                jVar.hNI.setTextColor(am.getColor(R.color.cp_cont_b));
                jVar.hNJ.onChangeSkinType();
                if (dVar != null) {
                    am.j(jVar.hNL, R.color.cp_cont_c);
                    jVar.hNL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.j(jVar.hNM, R.color.cp_cont_c);
                    am.l(jVar.hNK, R.color.cp_bg_line_e);
                    jVar.hNK.onChangeSkinType();
                    am.f(jVar.hNW, R.color.cp_link_tip_c, 1);
                    am.f(jVar.hNU, R.color.cp_cont_f, 1);
                    am.k(jVar.hNT, R.color.cp_bg_line_e);
                    am.k(jVar.hNV, R.color.cp_cont_d);
                    am.c(jVar.hNX, (int) R.drawable.icon_arrow_more_gray);
                    am.j(jVar.hOa, R.color.cp_cont_c);
                    if (jVar.hNY.getVisibility() == 8) {
                        jVar.hNL.setVisibility(8);
                        jVar.hNM.setVisibility(8);
                        jVar.hOa.setText(R.string.close_content);
                    } else if (StringUtils.isNull(dVar.bSF())) {
                        jVar.hOa.setText(dVar.bSF());
                    } else {
                        jVar.hOa.setText(R.string.expand_content);
                    }
                } else {
                    jVar.hNK.setVisibility(8);
                    jVar.hNL.setVisibility(8);
                    jVar.hNM.setVisibility(8);
                    jVar.hNT.setVisibility(8);
                    jVar.hOa.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bg bgVar, int i) {
        if (jVar != null && postData != null && postData.agn() != null) {
            if (bgVar != null) {
                postData.agn().threadId = bgVar.getTid();
                postData.agn().forumId = String.valueOf(bgVar.getFid());
            }
            if (i == 0) {
                postData.agn().objType = 1;
            } else {
                postData.agn().objType = 2;
            }
            postData.agn().isInPost = true;
            jVar.hNG.setData(postData.agn());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0676  */
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
            if (postData.jfI) {
                am.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bgVar == null || bgVar.aex() == null) {
                str = null;
            } else {
                str = bgVar.aex().getUserId();
            }
            jVar.hNH.setTag(null);
            jVar.hNH.setUserId(null);
            jVar.enZ.setText((CharSequence) null);
            jVar.hNP.getHeadView().setUserId(null);
            jVar.hNI.setIsHost(false);
            if (postData.aex() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aex().getUserId())) {
                    jVar.hNI.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aex().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aex().getTShowInfoNew();
                if (jVar.hNR != null) {
                    jVar.hNR.setTag(R.id.tag_user_id, postData.aex().getUserId());
                    jVar.hNR.setOnClickListener(aVar.bTs().hXT);
                    jVar.hNR.a(iconInfo, 2, hJa, hJa, hIY);
                }
                if (jVar.hNQ != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hNQ.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hNQ.setOnClickListener(aVar.bTs().hXU);
                    jVar.hNQ.a(tShowInfoNew, 3, hJa, hJa, hIY, true);
                }
                if (!v.aa(tShowInfoNew) || postData.aex().isBigV()) {
                    am.f(jVar.enZ, R.color.cp_cont_h, 1);
                } else {
                    am.f(jVar.enZ, R.color.cp_cont_f, 1);
                }
                String portrait = postData.aex().getPortrait();
                jVar.enZ.setTag(R.id.tag_user_id, postData.aex().getUserId());
                jVar.enZ.setTag(R.id.tag_user_name, postData.aex().getUserName());
                jVar.enZ.setTag(R.id.tag_virtual_user_url, postData.aex().getVirtualUserUrl());
                String name_show = postData.aex().getName_show();
                String userName = postData.aex().getUserName();
                if (as.iN() && name_show != null && !name_show.equals(userName)) {
                    jVar.enZ.setText(c.aE(aVar.getPageContext().getPageActivity(), jVar.enZ.getText().toString()));
                    jVar.enZ.setGravity(16);
                    jVar.enZ.setTag(R.id.tag_nick_name_activity, c.bSg());
                    am.f(jVar.enZ, R.color.cp_other_e, 1);
                }
                if (postData.aex().getPendantData() != null && !StringUtils.isNull(postData.aex().getPendantData().acU())) {
                    jVar.hNP.b(postData.aex());
                    jVar.hNH.setVisibility(8);
                    jVar.hNP.setVisibility(0);
                    jVar.hNP.getHeadView().startLoad(portrait, 28, false);
                    jVar.hNP.getHeadView().setUserId(postData.aex().getUserId());
                    jVar.hNP.getHeadView().setUserName(postData.aex().getUserName());
                    jVar.hNP.oN(postData.aex().getPendantData().acU());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hNH, postData.aex());
                    jVar.hNH.setUserId(postData.aex().getUserId());
                    jVar.hNH.setUserName(postData.aex().getUserName(), postData.cpz());
                    jVar.hNH.setTag(R.id.tag_virtual_user_url, postData.aex().getVirtualUserUrl());
                    jVar.hNH.setImageDrawable(null);
                    jVar.hNH.startLoad(portrait, 28, false);
                    jVar.hNH.setVisibility(0);
                    jVar.hNP.setVisibility(8);
                }
                if (postData.aex() != null) {
                    MetaData aex = postData.aex();
                    int in = postData.cph() ? R.drawable.brand_official_btn : am.in(R.drawable.bg_user_identity_btn);
                    int in2 = postData.cph() ? R.color.cp_btn_a : am.in(R.color.cp_bg_line_d);
                    am.k(jVar.hNB, in);
                    am.j(jVar.hNB, in2);
                    jVar.hNB.setTag(Integer.valueOf(in));
                    if (str != null && !str.equals("0") && str.equals(aex.getUserId())) {
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.host_name);
                    } else if (aex.getIs_bawu() == 1 && postData.cph()) {
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.brand_Official);
                    } else if (aex.getIs_bawu() == 1 && "manager".equals(aex.getBawu_type())) {
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aex.getIs_bawu() == 1 && "assist".equals(aex.getBawu_type())) {
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aex.getIs_bawu() == 1 && "pri_content_assist".equals(aex.getBawu_type())) {
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_content_assist_tip);
                    } else if (aex.getIs_bawu() == 1 && "pri_manage_assist".equals(aex.getBawu_type())) {
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hNB.setVisibility(8);
                        jVar.hNB.setTag(null);
                    }
                } else {
                    jVar.hNB.setVisibility(8);
                    jVar.hNB.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bTt()) {
                if (postData.aex() != null) {
                    i2 = postData.aex().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hNO.setVisibility(0);
                am.c(jVar.hNO, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hNO.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hNR.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hNR.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hNB.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hNQ.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aex() != null ? postData.aex().getName_show() : "";
            int ro = ab.ro(name_show2);
            if (postData.aex() != null && !StringUtils.isNull(postData.aex().getSealPrefix())) {
                if (ro > i3 - 2) {
                    name_show2 = ab.ad(name_show2, i3 - 2) + "...";
                }
            } else if (ro > i3) {
                name_show2 = ab.ad(name_show2, i3) + "...";
            }
            if (postData.aex() != null && !StringUtils.isNull(postData.aex().getSealPrefix())) {
                jVar.enZ.setText(a(aVar, postData.aex().getSealPrefix(), name_show2));
            } else {
                jVar.enZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cpp()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aex() == null || StringUtils.isNull(postData.aex().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bgVar != null && aVar.bTv() != 0) {
                if (aVar.bTv() != 1002 && aVar.bTv() != 3) {
                    z8 = true;
                }
                if (aVar.bTv() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.aex() != null) {
                    String userId2 = postData.aex().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bgVar != null && bgVar.aex() != null && postData.aex() != null) {
                            userId = bgVar.aex().getUserId();
                            String userId3 = postData.aex().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aex() != null && UtilHelper.isCurrentAccount(postData.aex().getUserId())) {
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
                                if (postData.cpp() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bTv()));
                                    if (postData.aex() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aex().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aex().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aex().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aex() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aex().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aex().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aex().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bgVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bgVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bTv()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hNI.setTag(sparseArray);
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
                        if (postData.cpp() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        jVar.hNI.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bgVar != null) {
                userId = bgVar.aex().getUserId();
                String userId32 = postData.aex().getUserId();
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
            if (postData.cpp() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            jVar.hNI.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int af = (((l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                af = (af - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().lt(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cLT = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lu((int) (af * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hNI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.g(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.g(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hNI.rC(null);
                jVar.hNI.setBackgroundDrawable(null);
                jVar.hNI.getLayoutStrategy().lv(R.drawable.transparent_bg);
            } else {
                jVar.hNI.getLayoutStrategy().lv(R.drawable.icon_click);
            }
            jVar.hNI.getLayoutStrategy().ls(R.drawable.pic_video);
            a(jVar.hNI, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hNI.setLayoutParams(layoutParams);
            jVar.hNI.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            jVar.hNI.setIsFromCDN(z2);
            TbRichText cpr = postData.cpr();
            jVar.hNI.setIsUseGridImage(postData.cpC());
            jVar.hNI.setText(cpr, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hNI.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hNI.setTag(sparseArray);
            jVar.hNz.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cpp() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cpp()));
                jVar.hNN.setVisibility(0);
                jVar.hNN.setText(format);
                z = true;
            } else {
                jVar.hNN.setVisibility(8);
                z = false;
            }
            f cps = postData.cps();
            boolean z2 = (cps == null || StringUtils.isNull(cps.getName())) ? false : true;
            if (z) {
                jVar.hND.setVisibility(0);
                i = hIZ;
            } else {
                jVar.hND.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hNE.setVisibility(0);
                i2 = hIZ;
            } else {
                jVar.hNE.setVisibility(8);
                i2 = 0;
            }
            jVar.hNC.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hNC.setText(aq.aF(postData.getTime()));
            } else {
                jVar.hNC.setText(aq.aD(postData.getTime()));
            }
            if (z2) {
                jVar.hNF.setVisibility(0);
                jVar.hNF.setPadding(hIZ, 0, 0, 0);
                jVar.hNF.setText(cps.getName());
                return;
            }
            jVar.hNF.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bZx() == null) {
            jVar.hNS.setVisibility(8);
            return;
        }
        TbRichText cpr = postData.cpr();
        com.baidu.tieba.pb.view.b.a(postData.bZx(), jVar.hNS, false, false, cpr != null && StringUtils.isNull(cpr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hNI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hNI.setLayoutParams(layoutParams);
            jVar.hNI.setPadding(0, 0, 0, 0);
            jVar.hNI.rC(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hNI.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hNI.setLayoutParams(layoutParams2);
            jVar.hNI.rC(postData.getBimg_url());
        }
        jVar.hNI.setTextViewCheckSelection(false);
    }
}
