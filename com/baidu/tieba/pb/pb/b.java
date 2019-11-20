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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
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
    private static SparseArray<SoftReference<Drawable>> hJz = new SparseArray<>();
    private static SparseIntArray hJA = new SparseIntArray();
    public static final int hJB = getDimensionPixelSize(R.dimen.tbds12);
    public static final int hJC = getDimensionPixelSize(R.dimen.tbds16);
    public static final int hJD = getDimensionPixelSize(R.dimen.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hJA.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hJA.put(i, dimensionPixelSize);
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
                am.setViewTextColor(jVar.ezp, R.color.cp_cont_f, 1);
                if (jVar.hOg.getTag() instanceof Integer) {
                    am.setBackgroundResource(jVar.hOg, ((Integer) jVar.hOg.getTag()).intValue());
                }
                am.setViewTextColor(jVar.hOh, R.color.cp_cont_d, 1);
                am.setViewTextColor(jVar.hOi, (int) R.color.cp_cont_d);
                am.setViewTextColor(jVar.hOj, (int) R.color.cp_cont_d);
                am.setViewTextColor(jVar.hOs, R.color.cp_cont_d, 1);
                am.setViewTextColor(jVar.hOk, R.color.cp_cont_d, 1);
                jVar.hOn.setTextColor(am.getColor(R.color.cp_cont_b));
                jVar.hOo.onChangeSkinType();
                if (dVar != null) {
                    am.setViewTextColor(jVar.hOq, (int) R.color.cp_cont_c);
                    jVar.hOq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(jVar.hOr, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(jVar.hOp, R.color.cp_bg_line_g);
                    jVar.hOp.onChangeSkinType();
                    am.setViewTextColor(jVar.hOB, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(jVar.hOz, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(jVar.hOy, R.color.cp_bg_line_e);
                    am.setBackgroundResource(jVar.hOA, R.color.cp_cont_d);
                    am.setImageResource(jVar.hOC, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(jVar.hOF, (int) R.color.cp_cont_c);
                    if (jVar.hOD.getVisibility() == 8) {
                        jVar.hOq.setVisibility(8);
                        jVar.hOr.setVisibility(8);
                        jVar.hOF.setText(R.string.close_content);
                    } else if (StringUtils.isNull(dVar.bQF())) {
                        jVar.hOF.setText(dVar.bQF());
                    } else {
                        jVar.hOF.setText(R.string.expand_content);
                    }
                } else {
                    jVar.hOp.setVisibility(8);
                    jVar.hOq.setVisibility(8);
                    jVar.hOr.setVisibility(8);
                    jVar.hOy.setVisibility(8);
                    jVar.hOF.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bh bhVar, int i) {
        if (jVar != null && postData != null && postData.akt() != null) {
            if (bhVar != null) {
                postData.akt().threadId = bhVar.getTid();
                postData.akt().forumId = String.valueOf(bhVar.getFid());
            }
            if (i == 0) {
                postData.akt().objType = 1;
            } else {
                postData.akt().objType = 2;
            }
            postData.akt().isInPost = true;
            jVar.hOl.setData(postData.akt());
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
            if (postData.jii) {
                am.setBackgroundColor(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bhVar == null || bhVar.aiE() == null) {
                str = null;
            } else {
                str = bhVar.aiE().getUserId();
            }
            jVar.hOm.setTag(null);
            jVar.hOm.setUserId(null);
            jVar.ezp.setText((CharSequence) null);
            jVar.hOu.getHeadView().setUserId(null);
            jVar.hOn.setIsHost(false);
            if (postData.aiE() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aiE().getUserId())) {
                    jVar.hOn.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aiE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aiE().getTShowInfoNew();
                if (jVar.hOw != null) {
                    jVar.hOw.setTag(R.id.tag_user_id, postData.aiE().getUserId());
                    jVar.hOw.setOnClickListener(aVar.bRs().hYC);
                    jVar.hOw.a(iconInfo, 2, hJD, hJD, hJB);
                }
                if (jVar.hOv != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hOv.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hOv.setOnClickListener(aVar.bRs().hYD);
                    jVar.hOv.a(tShowInfoNew, 3, hJD, hJD, hJB, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aiE().isBigV()) {
                    am.setViewTextColor(jVar.ezp, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(jVar.ezp, R.color.cp_cont_f, 1);
                }
                String portrait = postData.aiE().getPortrait();
                jVar.ezp.setTag(R.id.tag_user_id, postData.aiE().getUserId());
                jVar.ezp.setTag(R.id.tag_user_name, postData.aiE().getUserName());
                jVar.ezp.setTag(R.id.tag_virtual_user_url, postData.aiE().getVirtualUserUrl());
                String name_show = postData.aiE().getName_show();
                String userName = postData.aiE().getUserName();
                if (as.isOn() && name_show != null && !name_show.equals(userName)) {
                    jVar.ezp.setText(c.aI(aVar.getPageContext().getPageActivity(), jVar.ezp.getText().toString()));
                    jVar.ezp.setGravity(16);
                    jVar.ezp.setTag(R.id.tag_nick_name_activity, c.bQe());
                    am.setViewTextColor(jVar.ezp, R.color.cp_other_e, 1);
                }
                if (postData.aiE().getPendantData() != null && !StringUtils.isNull(postData.aiE().getPendantData().ahd())) {
                    jVar.hOu.b(postData.aiE());
                    jVar.hOm.setVisibility(8);
                    jVar.hOu.setVisibility(0);
                    jVar.hOu.getHeadView().startLoad(portrait, 28, false);
                    jVar.hOu.getHeadView().setUserId(postData.aiE().getUserId());
                    jVar.hOu.getHeadView().setUserName(postData.aiE().getUserName());
                    jVar.hOu.ou(postData.aiE().getPendantData().ahd());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hOm, postData.aiE());
                    jVar.hOm.setUserId(postData.aiE().getUserId());
                    jVar.hOm.setUserName(postData.aiE().getUserName(), postData.cox());
                    jVar.hOm.setTag(R.id.tag_virtual_user_url, postData.aiE().getVirtualUserUrl());
                    jVar.hOm.setImageDrawable(null);
                    jVar.hOm.startLoad(portrait, 28, false);
                    jVar.hOm.setVisibility(0);
                    jVar.hOu.setVisibility(8);
                }
                if (postData.aiE() != null) {
                    MetaData aiE = postData.aiE();
                    int ir = postData.cof() ? R.drawable.brand_official_btn : am.ir(R.drawable.bg_user_identity_btn);
                    int ir2 = postData.cof() ? R.color.cp_cont_a : am.ir(R.color.cp_bg_line_d);
                    am.setBackgroundResource(jVar.hOg, ir);
                    am.setViewTextColor(jVar.hOg, ir2);
                    jVar.hOg.setTag(Integer.valueOf(ir));
                    if (str != null && !str.equals("0") && str.equals(aiE.getUserId())) {
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.host_name);
                    } else if (aiE.getIs_bawu() == 1 && postData.cof()) {
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.brand_Official);
                    } else if (aiE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aiE.getBawu_type())) {
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aiE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aiE.getBawu_type())) {
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aiE.getIs_bawu() == 1 && "pri_content_assist".equals(aiE.getBawu_type())) {
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_content_assist_tip);
                    } else if (aiE.getIs_bawu() == 1 && "pri_manage_assist".equals(aiE.getBawu_type())) {
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hOg.setVisibility(8);
                        jVar.hOg.setTag(null);
                    }
                } else {
                    jVar.hOg.setVisibility(8);
                    jVar.hOg.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bRt()) {
                if (postData.aiE() != null) {
                    i2 = postData.aiE().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hOt.setVisibility(0);
                am.setImageResource(jVar.hOt, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hOt.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hOw.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hOw.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hOg.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hOv.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aiE() != null ? postData.aiE().getName_show() : "";
            int textLengthWithEmoji = aa.getTextLengthWithEmoji(name_show2);
            if (postData.aiE() != null && !StringUtils.isNull(postData.aiE().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = aa.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = aa.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aiE() != null && !StringUtils.isNull(postData.aiE().getSealPrefix())) {
                jVar.ezp.setText(a(aVar, postData.aiE().getSealPrefix(), name_show2));
            } else {
                jVar.ezp.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.con()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aiE() == null || StringUtils.isNull(postData.aiE().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bhVar != null && aVar.bRv() != 0) {
                if (aVar.bRv() != 1002 && aVar.bRv() != 3) {
                    z8 = true;
                }
                if (aVar.bRv() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.aiE() != null) {
                    String userId2 = postData.aiE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bhVar != null && bhVar.aiE() != null && postData.aiE() != null) {
                            userId = bhVar.aiE().getUserId();
                            String userId3 = postData.aiE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aiE() != null && UtilHelper.isCurrentAccount(postData.aiE().getUserId())) {
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
                                if (postData.con() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bRv()));
                                    if (postData.aiE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aiE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aiE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiE().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bhVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bhVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bRv()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hOn.setTag(sparseArray);
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
                        if (postData.con() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        jVar.hOn.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bhVar != null) {
                userId = bhVar.aiE().getUserId();
                String userId32 = postData.aiE().getUserId();
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
            if (postData.con() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            jVar.hOn.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().kC(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cVr = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().kD((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOn.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hOn.qx(null);
                jVar.hOn.setBackgroundDrawable(null);
                jVar.hOn.getLayoutStrategy().kE(R.drawable.transparent_bg);
            } else {
                jVar.hOn.getLayoutStrategy().kE(R.drawable.icon_click);
            }
            jVar.hOn.getLayoutStrategy().kB(R.drawable.pic_video);
            a(jVar.hOn, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hOn.setLayoutParams(layoutParams);
            jVar.hOn.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            jVar.hOn.setIsFromCDN(z2);
            TbRichText cop = postData.cop();
            jVar.hOn.setIsUseGridImage(postData.coA());
            jVar.hOn.setText(cop, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hOn.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hOn.setTag(sparseArray);
            jVar.hOe.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.con() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.con()));
                jVar.hOs.setVisibility(0);
                jVar.hOs.setText(format);
                z = true;
            } else {
                jVar.hOs.setVisibility(8);
                z = false;
            }
            f coq = postData.coq();
            boolean z2 = (coq == null || StringUtils.isNull(coq.getName())) ? false : true;
            if (z) {
                jVar.hOi.setVisibility(0);
                i = hJC;
            } else {
                jVar.hOi.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hOj.setVisibility(0);
                i2 = hJC;
            } else {
                jVar.hOj.setVisibility(8);
                i2 = 0;
            }
            jVar.hOh.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hOh.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                jVar.hOh.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                jVar.hOk.setVisibility(0);
                jVar.hOk.setPadding(hJC, 0, 0, 0);
                jVar.hOk.setText(coq.getName());
                return;
            }
            jVar.hOk.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bXD() == null) {
            jVar.hOx.setVisibility(8);
            return;
        }
        TbRichText cop = postData.cop();
        com.baidu.tieba.pb.view.b.a(postData.bXD(), jVar.hOx, false, false, cop != null && StringUtils.isNull(cop.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOn.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hOn.setLayoutParams(layoutParams);
            jVar.hOn.setPadding(0, 0, 0, 0);
            jVar.hOn.qx(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hOn.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hOn.setLayoutParams(layoutParams2);
            jVar.hOn.qx(postData.getBimg_url());
        }
        jVar.hOn.setTextViewCheckSelection(false);
    }
}
