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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.t.as;
import com.baidu.tbadk.util.aa;
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
    private static SparseArray<SoftReference<Drawable>> hLM = new SparseArray<>();
    private static SparseIntArray hLN = new SparseIntArray();
    public static final int hLO = getDimensionPixelSize(R.dimen.tbds12);
    public static final int hLP = getDimensionPixelSize(R.dimen.tbds16);
    public static final int hLQ = getDimensionPixelSize(R.dimen.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hLN.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hLN.put(i, dimensionPixelSize);
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
                am.f(jVar.epQ, R.color.cp_cont_f, 1);
                if (jVar.hQs.getTag() instanceof Integer) {
                    am.k(jVar.hQs, ((Integer) jVar.hQs.getTag()).intValue());
                }
                am.f(jVar.hQt, R.color.cp_cont_d, 1);
                am.j(jVar.hQu, R.color.cp_cont_d);
                am.j(jVar.hQv, R.color.cp_cont_d);
                am.f(jVar.hQE, R.color.cp_cont_d, 1);
                am.f(jVar.hQw, R.color.cp_cont_d, 1);
                jVar.hQz.setTextColor(am.getColor(R.color.cp_cont_b));
                jVar.hQA.onChangeSkinType();
                if (dVar != null) {
                    am.j(jVar.hQC, R.color.cp_cont_c);
                    jVar.hQC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.j(jVar.hQD, R.color.cp_cont_c);
                    am.l(jVar.hQB, R.color.cp_bg_line_g);
                    jVar.hQB.onChangeSkinType();
                    am.f(jVar.hQN, R.color.cp_link_tip_c, 1);
                    am.f(jVar.hQL, R.color.cp_cont_f, 1);
                    am.k(jVar.hQK, R.color.cp_bg_line_e);
                    am.k(jVar.hQM, R.color.cp_cont_d);
                    am.c(jVar.hQO, (int) R.drawable.icon_arrow_more_gray);
                    am.j(jVar.hQR, R.color.cp_cont_c);
                    if (jVar.hQP.getVisibility() == 8) {
                        jVar.hQC.setVisibility(8);
                        jVar.hQD.setVisibility(8);
                        jVar.hQR.setText(R.string.close_content);
                    } else if (StringUtils.isNull(dVar.bTG())) {
                        jVar.hQR.setText(dVar.bTG());
                    } else {
                        jVar.hQR.setText(R.string.expand_content);
                    }
                } else {
                    jVar.hQB.setVisibility(8);
                    jVar.hQC.setVisibility(8);
                    jVar.hQD.setVisibility(8);
                    jVar.hQK.setVisibility(8);
                    jVar.hQR.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bh bhVar, int i) {
        if (jVar != null && postData != null && postData.ags() != null) {
            if (bhVar != null) {
                postData.ags().threadId = bhVar.getTid();
                postData.ags().forumId = String.valueOf(bhVar.getFid());
            }
            if (i == 0) {
                postData.ags().objType = 1;
            } else {
                postData.ags().objType = 2;
            }
            postData.ags().isInPost = true;
            jVar.hQx.setData(postData.ags());
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
    public static void a(j jVar, PostData postData, View view, int i, a aVar, bh bhVar) {
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
            if (postData.jjl) {
                am.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bhVar == null || bhVar.aeC() == null) {
                str = null;
            } else {
                str = bhVar.aeC().getUserId();
            }
            jVar.hQy.setTag(null);
            jVar.hQy.setUserId(null);
            jVar.epQ.setText((CharSequence) null);
            jVar.hQG.getHeadView().setUserId(null);
            jVar.hQz.setIsHost(false);
            if (postData.aeC() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aeC().getUserId())) {
                    jVar.hQz.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aeC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aeC().getTShowInfoNew();
                if (jVar.hQI != null) {
                    jVar.hQI.setTag(R.id.tag_user_id, postData.aeC().getUserId());
                    jVar.hQI.setOnClickListener(aVar.bUt().iaM);
                    jVar.hQI.a(iconInfo, 2, hLQ, hLQ, hLO);
                }
                if (jVar.hQH != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hQH.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hQH.setOnClickListener(aVar.bUt().iaN);
                    jVar.hQH.a(tShowInfoNew, 3, hLQ, hLQ, hLO, true);
                }
                if (!v.aa(tShowInfoNew) || postData.aeC().isBigV()) {
                    am.f(jVar.epQ, R.color.cp_cont_h, 1);
                } else {
                    am.f(jVar.epQ, R.color.cp_cont_f, 1);
                }
                String portrait = postData.aeC().getPortrait();
                jVar.epQ.setTag(R.id.tag_user_id, postData.aeC().getUserId());
                jVar.epQ.setTag(R.id.tag_user_name, postData.aeC().getUserName());
                jVar.epQ.setTag(R.id.tag_virtual_user_url, postData.aeC().getVirtualUserUrl());
                String name_show = postData.aeC().getName_show();
                String userName = postData.aeC().getUserName();
                if (as.iN() && name_show != null && !name_show.equals(userName)) {
                    jVar.epQ.setText(c.aL(aVar.getPageContext().getPageActivity(), jVar.epQ.getText().toString()));
                    jVar.epQ.setGravity(16);
                    jVar.epQ.setTag(R.id.tag_nick_name_activity, c.bTh());
                    am.f(jVar.epQ, R.color.cp_other_e, 1);
                }
                if (postData.aeC().getPendantData() != null && !StringUtils.isNull(postData.aeC().getPendantData().acZ())) {
                    jVar.hQG.b(postData.aeC());
                    jVar.hQy.setVisibility(8);
                    jVar.hQG.setVisibility(0);
                    jVar.hQG.getHeadView().startLoad(portrait, 28, false);
                    jVar.hQG.getHeadView().setUserId(postData.aeC().getUserId());
                    jVar.hQG.getHeadView().setUserName(postData.aeC().getUserName());
                    jVar.hQG.oV(postData.aeC().getPendantData().acZ());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hQy, postData.aeC());
                    jVar.hQy.setUserId(postData.aeC().getUserId());
                    jVar.hQy.setUserName(postData.aeC().getUserName(), postData.cqJ());
                    jVar.hQy.setTag(R.id.tag_virtual_user_url, postData.aeC().getVirtualUserUrl());
                    jVar.hQy.setImageDrawable(null);
                    jVar.hQy.startLoad(portrait, 28, false);
                    jVar.hQy.setVisibility(0);
                    jVar.hQG.setVisibility(8);
                }
                if (postData.aeC() != null) {
                    MetaData aeC = postData.aeC();
                    int in = postData.cqr() ? R.drawable.brand_official_btn : am.in(R.drawable.bg_user_identity_btn);
                    int in2 = postData.cqr() ? R.color.cp_cont_a : am.in(R.color.cp_bg_line_d);
                    am.k(jVar.hQs, in);
                    am.j(jVar.hQs, in2);
                    jVar.hQs.setTag(Integer.valueOf(in));
                    if (str != null && !str.equals("0") && str.equals(aeC.getUserId())) {
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.host_name);
                    } else if (aeC.getIs_bawu() == 1 && postData.cqr()) {
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.brand_Official);
                    } else if (aeC.getIs_bawu() == 1 && "manager".equals(aeC.getBawu_type())) {
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aeC.getIs_bawu() == 1 && "assist".equals(aeC.getBawu_type())) {
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aeC.getIs_bawu() == 1 && "pri_content_assist".equals(aeC.getBawu_type())) {
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_content_assist_tip);
                    } else if (aeC.getIs_bawu() == 1 && "pri_manage_assist".equals(aeC.getBawu_type())) {
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hQs.setVisibility(8);
                        jVar.hQs.setTag(null);
                    }
                } else {
                    jVar.hQs.setVisibility(8);
                    jVar.hQs.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bUu()) {
                if (postData.aeC() != null) {
                    i2 = postData.aeC().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hQF.setVisibility(0);
                am.c(jVar.hQF, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hQF.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hQI.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hQI.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hQs.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hQH.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aeC() != null ? postData.aeC().getName_show() : "";
            int rz = aa.rz(name_show2);
            if (postData.aeC() != null && !StringUtils.isNull(postData.aeC().getSealPrefix())) {
                if (rz > i3 - 2) {
                    name_show2 = aa.ad(name_show2, i3 - 2) + "...";
                }
            } else if (rz > i3) {
                name_show2 = aa.ad(name_show2, i3) + "...";
            }
            if (postData.aeC() != null && !StringUtils.isNull(postData.aeC().getSealPrefix())) {
                jVar.epQ.setText(a(aVar, postData.aeC().getSealPrefix(), name_show2));
            } else {
                jVar.epQ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cqz()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aeC() == null || StringUtils.isNull(postData.aeC().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bhVar != null && aVar.bUw() != 0) {
                if (aVar.bUw() != 1002 && aVar.bUw() != 3) {
                    z8 = true;
                }
                if (aVar.bUw() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.aeC() != null) {
                    String userId2 = postData.aeC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bhVar != null && bhVar.aeC() != null && postData.aeC() != null) {
                            userId = bhVar.aeC().getUserId();
                            String userId3 = postData.aeC().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aeC() != null && UtilHelper.isCurrentAccount(postData.aeC().getUserId())) {
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
                                if (postData.cqz() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bUw()));
                                    if (postData.aeC() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aeC().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aeC().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aeC().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aeC() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aeC().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aeC().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aeC().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bhVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bhVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bUw()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hQz.setTag(sparseArray);
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
                        if (postData.cqz() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        jVar.hQz.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bhVar != null) {
                userId = bhVar.aeC().getUserId();
                String userId32 = postData.aeC().getUserId();
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
            if (postData.cqz() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            jVar.hQz.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().ly(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cMQ = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lz((int) (af * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hQz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.g(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.g(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hQz.rN(null);
                jVar.hQz.setBackgroundDrawable(null);
                jVar.hQz.getLayoutStrategy().lA(R.drawable.transparent_bg);
            } else {
                jVar.hQz.getLayoutStrategy().lA(R.drawable.icon_click);
            }
            jVar.hQz.getLayoutStrategy().lx(R.drawable.pic_video);
            a(jVar.hQz, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hQz.setLayoutParams(layoutParams);
            jVar.hQz.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            jVar.hQz.setIsFromCDN(z2);
            TbRichText cqB = postData.cqB();
            jVar.hQz.setIsUseGridImage(postData.cqM());
            jVar.hQz.setText(cqB, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hQz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hQz.setTag(sparseArray);
            jVar.hQq.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cqz() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cqz()));
                jVar.hQE.setVisibility(0);
                jVar.hQE.setText(format);
                z = true;
            } else {
                jVar.hQE.setVisibility(8);
                z = false;
            }
            f cqC = postData.cqC();
            boolean z2 = (cqC == null || StringUtils.isNull(cqC.getName())) ? false : true;
            if (z) {
                jVar.hQu.setVisibility(0);
                i = hLP;
            } else {
                jVar.hQu.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hQv.setVisibility(0);
                i2 = hLP;
            } else {
                jVar.hQv.setVisibility(8);
                i2 = 0;
            }
            jVar.hQt.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hQt.setText(aq.aF(postData.getTime()));
            } else {
                jVar.hQt.setText(aq.aD(postData.getTime()));
            }
            if (z2) {
                jVar.hQw.setVisibility(0);
                jVar.hQw.setPadding(hLP, 0, 0, 0);
                jVar.hQw.setText(cqC.getName());
                return;
            }
            jVar.hQw.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.caC() == null) {
            jVar.hQJ.setVisibility(8);
            return;
        }
        TbRichText cqB = postData.cqB();
        com.baidu.tieba.pb.view.b.a(postData.caC(), jVar.hQJ, false, false, cqB != null && StringUtils.isNull(cqB.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hQz.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hQz.setLayoutParams(layoutParams);
            jVar.hQz.setPadding(0, 0, 0, 0);
            jVar.hQz.rN(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hQz.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hQz.setLayoutParams(layoutParams2);
            jVar.hQz.rN(postData.getBimg_url());
        }
        jVar.hQz.setTextViewCheckSelection(false);
    }
}
