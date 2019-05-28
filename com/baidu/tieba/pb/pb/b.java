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
    private static SparseArray<SoftReference<Drawable>> hCI = new SparseArray<>();
    private static SparseIntArray hCJ = new SparseIntArray();
    public static final int hCK = getDimensionPixelSize(R.dimen.tbds12);
    public static final int hCL = getDimensionPixelSize(R.dimen.tbds16);
    public static final int hCM = getDimensionPixelSize(R.dimen.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hCJ.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hCJ.put(i, dimensionPixelSize);
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
                al.f(jVar.ejs, R.color.cp_cont_f, 1);
                if (jVar.hHn.getTag() instanceof Integer) {
                    al.k(jVar.hHn, ((Integer) jVar.hHn.getTag()).intValue());
                }
                al.f(jVar.hHo, R.color.cp_cont_d, 1);
                al.j(jVar.hHp, R.color.cp_cont_d);
                al.j(jVar.hHq, R.color.cp_cont_d);
                al.f(jVar.hHz, R.color.cp_cont_d, 1);
                al.f(jVar.hHr, R.color.cp_cont_d, 1);
                jVar.hHu.setTextColor(al.getColor(R.color.cp_cont_b));
                jVar.hHv.onChangeSkinType();
                if (dVar != null) {
                    al.j(jVar.hHx, R.color.cp_cont_c);
                    jVar.hHx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    al.j(jVar.hHy, R.color.cp_cont_c);
                    al.l(jVar.hHw, R.color.cp_bg_line_e);
                    jVar.hHw.onChangeSkinType();
                    al.f(jVar.hHI, R.color.cp_link_tip_c, 1);
                    al.f(jVar.hHG, R.color.cp_cont_f, 1);
                    al.k(jVar.hHF, R.color.cp_bg_line_e);
                    al.k(jVar.hHH, R.color.cp_cont_d);
                    al.c(jVar.hHJ, (int) R.drawable.icon_arrow_more_gray);
                    al.j(jVar.hHM, R.color.cp_cont_c);
                    if (jVar.hHK.getVisibility() == 8) {
                        jVar.hHx.setVisibility(8);
                        jVar.hHy.setVisibility(8);
                        jVar.hHM.setText(R.string.close_content);
                    } else if (StringUtils.isNull(dVar.bPT())) {
                        jVar.hHM.setText(dVar.bPT());
                    } else {
                        jVar.hHM.setText(R.string.expand_content);
                    }
                } else {
                    jVar.hHw.setVisibility(8);
                    jVar.hHx.setVisibility(8);
                    jVar.hHy.setVisibility(8);
                    jVar.hHF.setVisibility(8);
                    jVar.hHM.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bg bgVar, int i) {
        if (jVar != null && postData != null && postData.afl() != null) {
            if (bgVar != null) {
                postData.afl().threadId = bgVar.getTid();
                postData.afl().forumId = String.valueOf(bgVar.getFid());
            }
            if (i == 0) {
                postData.afl().objType = 1;
            } else {
                postData.afl().objType = 2;
            }
            postData.afl().isInPost = true;
            jVar.hHs.setData(postData.afl());
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
            if (postData.iZn) {
                al.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bgVar == null || bgVar.adv() == null) {
                str = null;
            } else {
                str = bgVar.adv().getUserId();
            }
            jVar.hHt.setTag(null);
            jVar.hHt.setUserId(null);
            jVar.ejs.setText((CharSequence) null);
            jVar.hHB.getHeadView().setUserId(null);
            jVar.hHu.setIsHost(false);
            if (postData.adv() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.adv().getUserId())) {
                    jVar.hHu.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.adv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.adv().getTShowInfoNew();
                if (jVar.hHD != null) {
                    jVar.hHD.setTag(R.id.tag_user_id, postData.adv().getUserId());
                    jVar.hHD.setOnClickListener(aVar.bQG().hRF);
                    jVar.hHD.a(iconInfo, 2, hCM, hCM, hCK);
                }
                if (jVar.hHC != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hHC.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hHC.setOnClickListener(aVar.bQG().hRG);
                    jVar.hHC.a(tShowInfoNew, 3, hCM, hCM, hCK, true);
                }
                if (!v.aa(tShowInfoNew) || postData.adv().isBigV()) {
                    al.f(jVar.ejs, R.color.cp_cont_h, 1);
                } else {
                    al.f(jVar.ejs, R.color.cp_cont_f, 1);
                }
                String portrait = postData.adv().getPortrait();
                jVar.ejs.setTag(R.id.tag_user_id, postData.adv().getUserId());
                jVar.ejs.setTag(R.id.tag_user_name, postData.adv().getUserName());
                jVar.ejs.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                String name_show = postData.adv().getName_show();
                String userName = postData.adv().getUserName();
                if (as.iE() && name_show != null && !name_show.equals(userName)) {
                    jVar.ejs.setText(c.aD(aVar.getPageContext().getPageActivity(), jVar.ejs.getText().toString()));
                    jVar.ejs.setGravity(16);
                    jVar.ejs.setTag(R.id.tag_nick_name_activity, c.bPu());
                    al.f(jVar.ejs, R.color.cp_other_e, 1);
                }
                if (postData.adv().getPendantData() != null && !StringUtils.isNull(postData.adv().getPendantData().abS())) {
                    jVar.hHB.b(postData.adv());
                    jVar.hHt.setVisibility(8);
                    jVar.hHB.setVisibility(0);
                    jVar.hHB.getHeadView().startLoad(portrait, 28, false);
                    jVar.hHB.getHeadView().setUserId(postData.adv().getUserId());
                    jVar.hHB.getHeadView().setUserName(postData.adv().getUserName());
                    jVar.hHB.ox(postData.adv().getPendantData().abS());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hHt, postData.adv());
                    jVar.hHt.setUserId(postData.adv().getUserId());
                    jVar.hHt.setUserName(postData.adv().getUserName(), postData.cmG());
                    jVar.hHt.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                    jVar.hHt.setImageDrawable(null);
                    jVar.hHt.startLoad(portrait, 28, false);
                    jVar.hHt.setVisibility(0);
                    jVar.hHB.setVisibility(8);
                }
                if (postData.adv() != null) {
                    MetaData adv = postData.adv();
                    int ih = postData.cmo() ? R.drawable.brand_official_btn : al.ih(R.drawable.bg_user_identity_btn);
                    int ih2 = postData.cmo() ? R.color.cp_btn_a : al.ih(R.color.cp_bg_line_d);
                    al.k(jVar.hHn, ih);
                    al.j(jVar.hHn, ih2);
                    jVar.hHn.setTag(Integer.valueOf(ih));
                    if (str != null && !str.equals("0") && str.equals(adv.getUserId())) {
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.host_name);
                    } else if (adv.getIs_bawu() == 1 && postData.cmo()) {
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.brand_Official);
                    } else if (adv.getIs_bawu() == 1 && "manager".equals(adv.getBawu_type())) {
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_member_bazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "assist".equals(adv.getBawu_type())) {
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_content_assist".equals(adv.getBawu_type())) {
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_content_assist_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_manage_assist".equals(adv.getBawu_type())) {
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hHn.setVisibility(8);
                        jVar.hHn.setTag(null);
                    }
                } else {
                    jVar.hHn.setVisibility(8);
                    jVar.hHn.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bQH()) {
                if (postData.adv() != null) {
                    i2 = postData.adv().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hHA.setVisibility(0);
                al.c(jVar.hHA, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hHA.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hHD.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hHD.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hHn.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hHC.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.adv() != null ? postData.adv().getName_show() : "";
            int qX = ab.qX(name_show2);
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getSealPrefix())) {
                if (qX > i3 - 2) {
                    name_show2 = ab.ad(name_show2, i3 - 2) + "...";
                }
            } else if (qX > i3) {
                name_show2 = ab.ad(name_show2, i3) + "...";
            }
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getSealPrefix())) {
                jVar.ejs.setText(a(aVar, postData.adv().getSealPrefix(), name_show2));
            } else {
                jVar.ejs.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cmw()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.adv() == null || StringUtils.isNull(postData.adv().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bgVar != null && aVar.bQJ() != 0) {
                if (aVar.bQJ() != 1002 && aVar.bQJ() != 3) {
                    z8 = true;
                }
                if (aVar.bQJ() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.adv() != null) {
                    String userId2 = postData.adv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bgVar != null && bgVar.adv() != null && postData.adv() != null) {
                            userId = bgVar.adv().getUserId();
                            String userId3 = postData.adv().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.adv() != null && UtilHelper.isCurrentAccount(postData.adv().getUserId())) {
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
                                if (postData.cmw() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bQJ()));
                                    if (postData.adv() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.adv().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.adv().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.adv().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.adv() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.adv().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.adv().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.adv().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bgVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bgVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bQJ()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hHu.setTag(sparseArray);
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
                        if (postData.cmw() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        jVar.hHu.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bgVar != null) {
                userId = bgVar.adv().getUserId();
                String userId32 = postData.adv().getUserId();
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
            if (postData.cmw() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            jVar.hHu.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().ln(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cKy = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lo((int) (af * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHu.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.g(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.g(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hHu.rl(null);
                jVar.hHu.setBackgroundDrawable(null);
                jVar.hHu.getLayoutStrategy().lp(R.drawable.transparent_bg);
            } else {
                jVar.hHu.getLayoutStrategy().lp(R.drawable.icon_click);
            }
            jVar.hHu.getLayoutStrategy().lm(R.drawable.pic_video);
            a(jVar.hHu, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hHu.setLayoutParams(layoutParams);
            jVar.hHu.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            jVar.hHu.setIsFromCDN(z2);
            TbRichText cmy = postData.cmy();
            jVar.hHu.setIsUseGridImage(postData.cmJ());
            jVar.hHu.setText(cmy, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hHu.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hHu.setTag(sparseArray);
            jVar.hHl.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cmw() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cmw()));
                jVar.hHz.setVisibility(0);
                jVar.hHz.setText(format);
                z = true;
            } else {
                jVar.hHz.setVisibility(8);
                z = false;
            }
            f cmz = postData.cmz();
            boolean z2 = (cmz == null || StringUtils.isNull(cmz.getName())) ? false : true;
            if (z) {
                jVar.hHp.setVisibility(0);
                i = hCL;
            } else {
                jVar.hHp.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hHq.setVisibility(0);
                i2 = hCL;
            } else {
                jVar.hHq.setVisibility(8);
                i2 = 0;
            }
            jVar.hHo.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hHo.setText(ap.aE(postData.getTime()));
            } else {
                jVar.hHo.setText(ap.aC(postData.getTime()));
            }
            if (z2) {
                jVar.hHr.setVisibility(0);
                jVar.hHr.setPadding(hCL, 0, 0, 0);
                jVar.hHr.setText(cmz.getName());
                return;
            }
            jVar.hHr.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bWH() == null) {
            jVar.hHE.setVisibility(8);
            return;
        }
        TbRichText cmy = postData.cmy();
        com.baidu.tieba.pb.view.b.a(postData.bWH(), jVar.hHE, false, false, cmy != null && StringUtils.isNull(cmy.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHu.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hHu.setLayoutParams(layoutParams);
            jVar.hHu.setPadding(0, 0, 0, 0);
            jVar.hHu.rl(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hHu.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hHu.setLayoutParams(layoutParams2);
            jVar.hHu.rl(postData.getBimg_url());
        }
        jVar.hHu.setTextViewCheckSelection(false);
    }
}
