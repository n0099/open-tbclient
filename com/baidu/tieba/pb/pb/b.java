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
    private static SparseArray<SoftReference<Drawable>> hJP = new SparseArray<>();
    private static SparseIntArray hJQ = new SparseIntArray();
    public static final int hJR = getDimensionPixelSize(R.dimen.tbds12);
    public static final int hJS = getDimensionPixelSize(R.dimen.tbds16);
    public static final int hJT = getDimensionPixelSize(R.dimen.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hJQ.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hJQ.put(i, dimensionPixelSize);
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
                am.f(jVar.eog, R.color.cp_cont_f, 1);
                if (jVar.hOv.getTag() instanceof Integer) {
                    am.k(jVar.hOv, ((Integer) jVar.hOv.getTag()).intValue());
                }
                am.f(jVar.hOw, R.color.cp_cont_d, 1);
                am.j(jVar.hOx, R.color.cp_cont_d);
                am.j(jVar.hOy, R.color.cp_cont_d);
                am.f(jVar.hOH, R.color.cp_cont_d, 1);
                am.f(jVar.hOz, R.color.cp_cont_d, 1);
                jVar.hOC.setTextColor(am.getColor(R.color.cp_cont_b));
                jVar.hOD.onChangeSkinType();
                if (dVar != null) {
                    am.j(jVar.hOF, R.color.cp_cont_c);
                    jVar.hOF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.j(jVar.hOG, R.color.cp_cont_c);
                    am.l(jVar.hOE, R.color.cp_bg_line_e);
                    jVar.hOE.onChangeSkinType();
                    am.f(jVar.hOQ, R.color.cp_link_tip_c, 1);
                    am.f(jVar.hOO, R.color.cp_cont_f, 1);
                    am.k(jVar.hON, R.color.cp_bg_line_e);
                    am.k(jVar.hOP, R.color.cp_cont_d);
                    am.c(jVar.hOR, (int) R.drawable.icon_arrow_more_gray);
                    am.j(jVar.hOU, R.color.cp_cont_c);
                    if (jVar.hOS.getVisibility() == 8) {
                        jVar.hOF.setVisibility(8);
                        jVar.hOG.setVisibility(8);
                        jVar.hOU.setText(R.string.close_content);
                    } else if (StringUtils.isNull(dVar.bST())) {
                        jVar.hOU.setText(dVar.bST());
                    } else {
                        jVar.hOU.setText(R.string.expand_content);
                    }
                } else {
                    jVar.hOE.setVisibility(8);
                    jVar.hOF.setVisibility(8);
                    jVar.hOG.setVisibility(8);
                    jVar.hON.setVisibility(8);
                    jVar.hOU.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bh bhVar, int i) {
        if (jVar != null && postData != null && postData.ago() != null) {
            if (bhVar != null) {
                postData.ago().threadId = bhVar.getTid();
                postData.ago().forumId = String.valueOf(bhVar.getFid());
            }
            if (i == 0) {
                postData.ago().objType = 1;
            } else {
                postData.ago().objType = 2;
            }
            postData.ago().isInPost = true;
            jVar.hOA.setData(postData.ago());
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
            if (postData.jgP) {
                am.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bhVar == null || bhVar.aey() == null) {
                str = null;
            } else {
                str = bhVar.aey().getUserId();
            }
            jVar.hOB.setTag(null);
            jVar.hOB.setUserId(null);
            jVar.eog.setText((CharSequence) null);
            jVar.hOJ.getHeadView().setUserId(null);
            jVar.hOC.setIsHost(false);
            if (postData.aey() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aey().getUserId())) {
                    jVar.hOC.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aey().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aey().getTShowInfoNew();
                if (jVar.hOL != null) {
                    jVar.hOL.setTag(R.id.tag_user_id, postData.aey().getUserId());
                    jVar.hOL.setOnClickListener(aVar.bTG().hYP);
                    jVar.hOL.a(iconInfo, 2, hJT, hJT, hJR);
                }
                if (jVar.hOK != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hOK.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hOK.setOnClickListener(aVar.bTG().hYQ);
                    jVar.hOK.a(tShowInfoNew, 3, hJT, hJT, hJR, true);
                }
                if (!v.aa(tShowInfoNew) || postData.aey().isBigV()) {
                    am.f(jVar.eog, R.color.cp_cont_h, 1);
                } else {
                    am.f(jVar.eog, R.color.cp_cont_f, 1);
                }
                String portrait = postData.aey().getPortrait();
                jVar.eog.setTag(R.id.tag_user_id, postData.aey().getUserId());
                jVar.eog.setTag(R.id.tag_user_name, postData.aey().getUserName());
                jVar.eog.setTag(R.id.tag_virtual_user_url, postData.aey().getVirtualUserUrl());
                String name_show = postData.aey().getName_show();
                String userName = postData.aey().getUserName();
                if (as.iN() && name_show != null && !name_show.equals(userName)) {
                    jVar.eog.setText(c.aE(aVar.getPageContext().getPageActivity(), jVar.eog.getText().toString()));
                    jVar.eog.setGravity(16);
                    jVar.eog.setTag(R.id.tag_nick_name_activity, c.bSu());
                    am.f(jVar.eog, R.color.cp_other_e, 1);
                }
                if (postData.aey().getPendantData() != null && !StringUtils.isNull(postData.aey().getPendantData().acV())) {
                    jVar.hOJ.b(postData.aey());
                    jVar.hOB.setVisibility(8);
                    jVar.hOJ.setVisibility(0);
                    jVar.hOJ.getHeadView().startLoad(portrait, 28, false);
                    jVar.hOJ.getHeadView().setUserId(postData.aey().getUserId());
                    jVar.hOJ.getHeadView().setUserName(postData.aey().getUserName());
                    jVar.hOJ.oN(postData.aey().getPendantData().acV());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hOB, postData.aey());
                    jVar.hOB.setUserId(postData.aey().getUserId());
                    jVar.hOB.setUserName(postData.aey().getUserName(), postData.cpV());
                    jVar.hOB.setTag(R.id.tag_virtual_user_url, postData.aey().getVirtualUserUrl());
                    jVar.hOB.setImageDrawable(null);
                    jVar.hOB.startLoad(portrait, 28, false);
                    jVar.hOB.setVisibility(0);
                    jVar.hOJ.setVisibility(8);
                }
                if (postData.aey() != null) {
                    MetaData aey = postData.aey();
                    int in = postData.cpD() ? R.drawable.brand_official_btn : am.in(R.drawable.bg_user_identity_btn);
                    int in2 = postData.cpD() ? R.color.cp_btn_a : am.in(R.color.cp_bg_line_d);
                    am.k(jVar.hOv, in);
                    am.j(jVar.hOv, in2);
                    jVar.hOv.setTag(Integer.valueOf(in));
                    if (str != null && !str.equals("0") && str.equals(aey.getUserId())) {
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.host_name);
                    } else if (aey.getIs_bawu() == 1 && postData.cpD()) {
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.brand_Official);
                    } else if (aey.getIs_bawu() == 1 && "manager".equals(aey.getBawu_type())) {
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aey.getIs_bawu() == 1 && "assist".equals(aey.getBawu_type())) {
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aey.getIs_bawu() == 1 && "pri_content_assist".equals(aey.getBawu_type())) {
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_content_assist_tip);
                    } else if (aey.getIs_bawu() == 1 && "pri_manage_assist".equals(aey.getBawu_type())) {
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hOv.setVisibility(8);
                        jVar.hOv.setTag(null);
                    }
                } else {
                    jVar.hOv.setVisibility(8);
                    jVar.hOv.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bTH()) {
                if (postData.aey() != null) {
                    i2 = postData.aey().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hOI.setVisibility(0);
                am.c(jVar.hOI, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hOI.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hOL.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hOL.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hOv.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hOK.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aey() != null ? postData.aey().getName_show() : "";
            int ro = ab.ro(name_show2);
            if (postData.aey() != null && !StringUtils.isNull(postData.aey().getSealPrefix())) {
                if (ro > i3 - 2) {
                    name_show2 = ab.ad(name_show2, i3 - 2) + "...";
                }
            } else if (ro > i3) {
                name_show2 = ab.ad(name_show2, i3) + "...";
            }
            if (postData.aey() != null && !StringUtils.isNull(postData.aey().getSealPrefix())) {
                jVar.eog.setText(a(aVar, postData.aey().getSealPrefix(), name_show2));
            } else {
                jVar.eog.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cpL()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aey() == null || StringUtils.isNull(postData.aey().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bhVar != null && aVar.bTJ() != 0) {
                if (aVar.bTJ() != 1002 && aVar.bTJ() != 3) {
                    z8 = true;
                }
                if (aVar.bTJ() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.aey() != null) {
                    String userId2 = postData.aey().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bhVar != null && bhVar.aey() != null && postData.aey() != null) {
                            userId = bhVar.aey().getUserId();
                            String userId3 = postData.aey().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aey() != null && UtilHelper.isCurrentAccount(postData.aey().getUserId())) {
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
                                if (postData.cpL() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bTJ()));
                                    if (postData.aey() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aey().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aey().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aey().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aey() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aey().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aey().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aey().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bhVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bhVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bTJ()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hOC.setTag(sparseArray);
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
                        if (postData.cpL() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        jVar.hOC.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bhVar != null) {
                userId = bhVar.aey().getUserId();
                String userId32 = postData.aey().getUserId();
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
            if (postData.cpL() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            jVar.hOC.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().lu(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cMa = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lv((int) (af * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.g(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.g(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hOC.rC(null);
                jVar.hOC.setBackgroundDrawable(null);
                jVar.hOC.getLayoutStrategy().lw(R.drawable.transparent_bg);
            } else {
                jVar.hOC.getLayoutStrategy().lw(R.drawable.icon_click);
            }
            jVar.hOC.getLayoutStrategy().lt(R.drawable.pic_video);
            a(jVar.hOC, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hOC.setLayoutParams(layoutParams);
            jVar.hOC.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            jVar.hOC.setIsFromCDN(z2);
            TbRichText cpN = postData.cpN();
            jVar.hOC.setIsUseGridImage(postData.cpY());
            jVar.hOC.setText(cpN, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hOC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hOC.setTag(sparseArray);
            jVar.hOt.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cpL() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cpL()));
                jVar.hOH.setVisibility(0);
                jVar.hOH.setText(format);
                z = true;
            } else {
                jVar.hOH.setVisibility(8);
                z = false;
            }
            f cpO = postData.cpO();
            boolean z2 = (cpO == null || StringUtils.isNull(cpO.getName())) ? false : true;
            if (z) {
                jVar.hOx.setVisibility(0);
                i = hJS;
            } else {
                jVar.hOx.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hOy.setVisibility(0);
                i2 = hJS;
            } else {
                jVar.hOy.setVisibility(8);
                i2 = 0;
            }
            jVar.hOw.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hOw.setText(aq.aF(postData.getTime()));
            } else {
                jVar.hOw.setText(aq.aD(postData.getTime()));
            }
            if (z2) {
                jVar.hOz.setVisibility(0);
                jVar.hOz.setPadding(hJS, 0, 0, 0);
                jVar.hOz.setText(cpO.getName());
                return;
            }
            jVar.hOz.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bZO() == null) {
            jVar.hOM.setVisibility(8);
            return;
        }
        TbRichText cpN = postData.cpN();
        com.baidu.tieba.pb.view.b.a(postData.bZO(), jVar.hOM, false, false, cpN != null && StringUtils.isNull(cpN.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hOC.setLayoutParams(layoutParams);
            jVar.hOC.setPadding(0, 0, 0, 0);
            jVar.hOC.rC(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hOC.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hOC.setLayoutParams(layoutParams2);
            jVar.hOC.rC(postData.getBimg_url());
        }
        jVar.hOC.setTextViewCheckSelection(false);
    }
}
