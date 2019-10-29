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
    private static SparseArray<SoftReference<Drawable>> hKq = new SparseArray<>();
    private static SparseIntArray hKr = new SparseIntArray();
    public static final int hKs = getDimensionPixelSize(R.dimen.tbds12);
    public static final int hKt = getDimensionPixelSize(R.dimen.tbds16);
    public static final int hKu = getDimensionPixelSize(R.dimen.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hKr.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hKr.put(i, dimensionPixelSize);
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
                am.setViewTextColor(jVar.eAg, R.color.cp_cont_f, 1);
                if (jVar.hOX.getTag() instanceof Integer) {
                    am.setBackgroundResource(jVar.hOX, ((Integer) jVar.hOX.getTag()).intValue());
                }
                am.setViewTextColor(jVar.hOY, R.color.cp_cont_d, 1);
                am.setViewTextColor(jVar.hOZ, (int) R.color.cp_cont_d);
                am.setViewTextColor(jVar.hPa, (int) R.color.cp_cont_d);
                am.setViewTextColor(jVar.hPj, R.color.cp_cont_d, 1);
                am.setViewTextColor(jVar.hPb, R.color.cp_cont_d, 1);
                jVar.hPe.setTextColor(am.getColor(R.color.cp_cont_b));
                jVar.hPf.onChangeSkinType();
                if (dVar != null) {
                    am.setViewTextColor(jVar.hPh, (int) R.color.cp_cont_c);
                    jVar.hPh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(jVar.hPi, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(jVar.hPg, R.color.cp_bg_line_g);
                    jVar.hPg.onChangeSkinType();
                    am.setViewTextColor(jVar.hPs, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(jVar.hPq, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(jVar.hPp, R.color.cp_bg_line_e);
                    am.setBackgroundResource(jVar.hPr, R.color.cp_cont_d);
                    am.setImageResource(jVar.hPt, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(jVar.hPw, (int) R.color.cp_cont_c);
                    if (jVar.hPu.getVisibility() == 8) {
                        jVar.hPh.setVisibility(8);
                        jVar.hPi.setVisibility(8);
                        jVar.hPw.setText(R.string.close_content);
                    } else if (StringUtils.isNull(dVar.bQH())) {
                        jVar.hPw.setText(dVar.bQH());
                    } else {
                        jVar.hPw.setText(R.string.expand_content);
                    }
                } else {
                    jVar.hPg.setVisibility(8);
                    jVar.hPh.setVisibility(8);
                    jVar.hPi.setVisibility(8);
                    jVar.hPp.setVisibility(8);
                    jVar.hPw.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bh bhVar, int i) {
        if (jVar != null && postData != null && postData.akv() != null) {
            if (bhVar != null) {
                postData.akv().threadId = bhVar.getTid();
                postData.akv().forumId = String.valueOf(bhVar.getFid());
            }
            if (i == 0) {
                postData.akv().objType = 1;
            } else {
                postData.akv().objType = 2;
            }
            postData.akv().isInPost = true;
            jVar.hPc.setData(postData.akv());
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
            if (postData.jiZ) {
                am.setBackgroundColor(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bhVar == null || bhVar.aiG() == null) {
                str = null;
            } else {
                str = bhVar.aiG().getUserId();
            }
            jVar.hPd.setTag(null);
            jVar.hPd.setUserId(null);
            jVar.eAg.setText((CharSequence) null);
            jVar.hPl.getHeadView().setUserId(null);
            jVar.hPe.setIsHost(false);
            if (postData.aiG() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aiG().getUserId())) {
                    jVar.hPe.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aiG().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aiG().getTShowInfoNew();
                if (jVar.hPn != null) {
                    jVar.hPn.setTag(R.id.tag_user_id, postData.aiG().getUserId());
                    jVar.hPn.setOnClickListener(aVar.bRu().hZt);
                    jVar.hPn.a(iconInfo, 2, hKu, hKu, hKs);
                }
                if (jVar.hPm != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hPm.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hPm.setOnClickListener(aVar.bRu().hZu);
                    jVar.hPm.a(tShowInfoNew, 3, hKu, hKu, hKs, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aiG().isBigV()) {
                    am.setViewTextColor(jVar.eAg, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(jVar.eAg, R.color.cp_cont_f, 1);
                }
                String portrait = postData.aiG().getPortrait();
                jVar.eAg.setTag(R.id.tag_user_id, postData.aiG().getUserId());
                jVar.eAg.setTag(R.id.tag_user_name, postData.aiG().getUserName());
                jVar.eAg.setTag(R.id.tag_virtual_user_url, postData.aiG().getVirtualUserUrl());
                String name_show = postData.aiG().getName_show();
                String userName = postData.aiG().getUserName();
                if (as.isOn() && name_show != null && !name_show.equals(userName)) {
                    jVar.eAg.setText(c.aI(aVar.getPageContext().getPageActivity(), jVar.eAg.getText().toString()));
                    jVar.eAg.setGravity(16);
                    jVar.eAg.setTag(R.id.tag_nick_name_activity, c.bQg());
                    am.setViewTextColor(jVar.eAg, R.color.cp_other_e, 1);
                }
                if (postData.aiG().getPendantData() != null && !StringUtils.isNull(postData.aiG().getPendantData().ahf())) {
                    jVar.hPl.b(postData.aiG());
                    jVar.hPd.setVisibility(8);
                    jVar.hPl.setVisibility(0);
                    jVar.hPl.getHeadView().startLoad(portrait, 28, false);
                    jVar.hPl.getHeadView().setUserId(postData.aiG().getUserId());
                    jVar.hPl.getHeadView().setUserName(postData.aiG().getUserName());
                    jVar.hPl.ou(postData.aiG().getPendantData().ahf());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hPd, postData.aiG());
                    jVar.hPd.setUserId(postData.aiG().getUserId());
                    jVar.hPd.setUserName(postData.aiG().getUserName(), postData.coz());
                    jVar.hPd.setTag(R.id.tag_virtual_user_url, postData.aiG().getVirtualUserUrl());
                    jVar.hPd.setImageDrawable(null);
                    jVar.hPd.startLoad(portrait, 28, false);
                    jVar.hPd.setVisibility(0);
                    jVar.hPl.setVisibility(8);
                }
                if (postData.aiG() != null) {
                    MetaData aiG = postData.aiG();
                    int is = postData.coh() ? R.drawable.brand_official_btn : am.is(R.drawable.bg_user_identity_btn);
                    int is2 = postData.coh() ? R.color.cp_cont_a : am.is(R.color.cp_bg_line_d);
                    am.setBackgroundResource(jVar.hOX, is);
                    am.setViewTextColor(jVar.hOX, is2);
                    jVar.hOX.setTag(Integer.valueOf(is));
                    if (str != null && !str.equals("0") && str.equals(aiG.getUserId())) {
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.host_name);
                    } else if (aiG.getIs_bawu() == 1 && postData.coh()) {
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.brand_Official);
                    } else if (aiG.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aiG.getBawu_type())) {
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aiG.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aiG.getBawu_type())) {
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aiG.getIs_bawu() == 1 && "pri_content_assist".equals(aiG.getBawu_type())) {
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_content_assist_tip);
                    } else if (aiG.getIs_bawu() == 1 && "pri_manage_assist".equals(aiG.getBawu_type())) {
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hOX.setVisibility(8);
                        jVar.hOX.setTag(null);
                    }
                } else {
                    jVar.hOX.setVisibility(8);
                    jVar.hOX.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bRv()) {
                if (postData.aiG() != null) {
                    i2 = postData.aiG().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hPk.setVisibility(0);
                am.setImageResource(jVar.hPk, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hPk.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hPn.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hPn.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hOX.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hPm.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aiG() != null ? postData.aiG().getName_show() : "";
            int textLengthWithEmoji = aa.getTextLengthWithEmoji(name_show2);
            if (postData.aiG() != null && !StringUtils.isNull(postData.aiG().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = aa.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = aa.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aiG() != null && !StringUtils.isNull(postData.aiG().getSealPrefix())) {
                jVar.eAg.setText(a(aVar, postData.aiG().getSealPrefix(), name_show2));
            } else {
                jVar.eAg.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cop()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aiG() == null || StringUtils.isNull(postData.aiG().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bhVar != null && aVar.bRx() != 0) {
                if (aVar.bRx() != 1002 && aVar.bRx() != 3) {
                    z8 = true;
                }
                if (aVar.bRx() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.aiG() != null) {
                    String userId2 = postData.aiG().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bhVar != null && bhVar.aiG() != null && postData.aiG() != null) {
                            userId = bhVar.aiG().getUserId();
                            String userId3 = postData.aiG().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aiG() != null && UtilHelper.isCurrentAccount(postData.aiG().getUserId())) {
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
                                if (postData.cop() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bRx()));
                                    if (postData.aiG() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aiG().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiG().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiG().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aiG() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiG().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiG().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiG().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bhVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bhVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.bRx()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hPe.setTag(sparseArray);
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
                        if (postData.cop() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        jVar.hPe.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bhVar != null) {
                userId = bhVar.aiG().getUserId();
                String userId32 = postData.aiG().getUserId();
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
            if (postData.cop() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            jVar.hPe.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().kD(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cWi = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().kE((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hPe.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hPe.qx(null);
                jVar.hPe.setBackgroundDrawable(null);
                jVar.hPe.getLayoutStrategy().kF(R.drawable.transparent_bg);
            } else {
                jVar.hPe.getLayoutStrategy().kF(R.drawable.icon_click);
            }
            jVar.hPe.getLayoutStrategy().kC(R.drawable.pic_video);
            a(jVar.hPe, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hPe.setLayoutParams(layoutParams);
            jVar.hPe.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            jVar.hPe.setIsFromCDN(z2);
            TbRichText cor = postData.cor();
            jVar.hPe.setIsUseGridImage(postData.coC());
            jVar.hPe.setText(cor, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hPe.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hPe.setTag(sparseArray);
            jVar.hOV.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cop() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cop()));
                jVar.hPj.setVisibility(0);
                jVar.hPj.setText(format);
                z = true;
            } else {
                jVar.hPj.setVisibility(8);
                z = false;
            }
            f cos = postData.cos();
            boolean z2 = (cos == null || StringUtils.isNull(cos.getName())) ? false : true;
            if (z) {
                jVar.hOZ.setVisibility(0);
                i = hKt;
            } else {
                jVar.hOZ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hPa.setVisibility(0);
                i2 = hKt;
            } else {
                jVar.hPa.setVisibility(8);
                i2 = 0;
            }
            jVar.hOY.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hOY.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                jVar.hOY.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                jVar.hPb.setVisibility(0);
                jVar.hPb.setPadding(hKt, 0, 0, 0);
                jVar.hPb.setText(cos.getName());
                return;
            }
            jVar.hPb.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bXF() == null) {
            jVar.hPo.setVisibility(8);
            return;
        }
        TbRichText cor = postData.cor();
        com.baidu.tieba.pb.view.b.a(postData.bXF(), jVar.hPo, false, false, cor != null && StringUtils.isNull(cor.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hPe.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hPe.setLayoutParams(layoutParams);
            jVar.hPe.setPadding(0, 0, 0, 0);
            jVar.hPe.qx(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hPe.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hPe.setLayoutParams(layoutParams2);
            jVar.hPe.qx(postData.getBimg_url());
        }
        jVar.hPe.setTextViewCheckSelection(false);
    }
}
