package com.baidu.tieba.pb.pb;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class b {
    private static LayerDrawable agG;
    private static LayerDrawable agH;
    private static LayerDrawable jHc;
    private static SparseArray<SoftReference<Drawable>> jGX = new SparseArray<>();
    private static SparseIntArray jGY = new SparseIntArray();
    public static final int eDu = getDimensionPixelSize(R.dimen.tbds12);
    public static final int jGZ = getDimensionPixelSize(R.dimen.tbds16);
    public static final int jHa = getDimensionPixelSize(R.dimen.tbds36);
    public static final int jHb = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = jGY.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            jGY.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cDH() {
        agG = new LayerDrawable(new Drawable[]{c.aVA().lp(0).O(jHb).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVC(), c.aVA().lp(0).O(jHb).wJ("#4D000000").aVC()});
        agH = new LayerDrawable(new Drawable[]{c.aVA().lp(0).O(jHb).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVC(), c.aVA().lp(0).O(jHb).wJ("#4D000000").aVC()});
        jHc = new LayerDrawable(new Drawable[]{c.aVA().lp(0).O(jHb).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aVC(), c.aVA().lp(0).O(jHb).wJ("#4D000000").aVC()});
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(l lVar, e eVar, boolean z) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                am.setViewTextColor(lVar.gre, R.color.cp_cont_f, 1);
                if (lVar.jJC.getTag() instanceof Integer) {
                    am.setBackgroundResource(lVar.jJC, ((Integer) lVar.jJC.getTag()).intValue());
                } else if (lVar.jJC.getTag() instanceof String) {
                    if (lVar.jJC.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = agG;
                    } else if (lVar.jJC.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = agH;
                    } else {
                        layerDrawable = lVar.jJC.getTag().equals("HOST") ? jHc : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(lVar.jJD, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.jJE, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.jJF, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.jJQ, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.jJG, R.color.cp_cont_d, 1);
                lVar.jJK.setTextColor(am.getColor(R.color.cp_cont_b));
                lVar.jJL.onChangeSkinType();
                if (z) {
                    SvgManager.aUW().a(lVar.jJP, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUW().a(lVar.ihG, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (eVar != null) {
                    am.setViewTextColor(lVar.jJN, (int) R.color.cp_cont_c);
                    lVar.jJN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(lVar.jJO, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(lVar.jJM, R.color.cp_bg_line_g);
                    lVar.jJM.onChangeSkinType();
                    am.setViewTextColor(lVar.jJZ, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(lVar.jJX, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(lVar.jJW, R.color.cp_bg_line_e);
                    am.setBackgroundResource(lVar.jJY, R.color.cp_cont_d);
                    am.setImageResource(lVar.jKa, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(lVar.jKd, (int) R.color.cp_cont_c);
                    if (lVar.jKb.getVisibility() == 8) {
                        lVar.jJN.setVisibility(8);
                        lVar.jJO.setVisibility(8);
                        lVar.jKd.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.cCJ())) {
                        lVar.jKd.setText(eVar.cCJ());
                    } else {
                        lVar.jKd.setText(R.string.expand_content);
                    }
                } else {
                    lVar.jJM.setVisibility(8);
                    lVar.jJN.setVisibility(8);
                    lVar.jJO.setVisibility(8);
                    lVar.jJW.setVisibility(8);
                    lVar.jKd.setVisibility(8);
                }
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(l lVar, PostData postData, bk bkVar, int i) {
        if (lVar != null && postData != null && postData.aSp() != null) {
            if (bkVar != null) {
                postData.aSp().threadId = bkVar.getTid();
                postData.aSp().forumId = String.valueOf(bkVar.getFid());
            }
            if (i == 0) {
                postData.aSp().objType = 1;
            } else {
                postData.aSp().objType = 2;
            }
            postData.aSp().isInPost = true;
            if (bkVar != null && bkVar.aSx()) {
                lVar.jJH.setAgreeAlone(true);
            }
            lVar.jJH.setData(postData.aSp());
        }
    }

    public static void a(l lVar, boolean z) {
        if (lVar.ihG != null) {
            lVar.ihG.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x048f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0784  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(l lVar, PostData postData, View view, int i, a aVar, bk bkVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String userId;
        if (lVar != null && postData != null) {
            if (postData.aQx() == null || postData.aQx().isBaijiahaoUser()) {
            }
            if (postData.lmF) {
                am.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            if (bkVar == null || bkVar.aQx() == null) {
                str = null;
            } else {
                str = bkVar.aQx().getUserId();
            }
            lVar.jJJ.setTag(null);
            lVar.jJJ.setUserId(null);
            lVar.gre.setText((CharSequence) null);
            lVar.jJS.getHeadView().setUserId(null);
            lVar.jJK.setIsHost(false);
            if (postData.aQx() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aQx().getUserId())) {
                    lVar.jJK.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aQx().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aQx().getTShowInfoNew();
                if (lVar.jJU != null) {
                    lVar.jJU.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                    lVar.jJU.setOnClickListener(aVar.cDD().jXj);
                    lVar.jJU.a(iconInfo, 2, jHa, jHa, eDu);
                }
                if (lVar.jJT != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.jJT.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.jJT.setOnClickListener(aVar.cDD().jXk);
                    lVar.jJT.a(tShowInfoNew, 3, jHa, jHa, eDu, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aQx().isBigV()) {
                    am.setViewTextColor(lVar.gre, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(lVar.gre, R.color.cp_cont_f, 1);
                }
                String avater = postData.aQx().getAvater();
                lVar.gre.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                lVar.gre.setTag(R.id.tag_user_name, postData.aQx().getUserName());
                lVar.gre.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                String name_show = postData.aQx().getName_show();
                String userName = postData.aQx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.gre.setText(com.baidu.tieba.pb.c.aK(aVar.getPageContext().getPageActivity(), lVar.gre.getText().toString()));
                    lVar.gre.setGravity(16);
                    lVar.gre.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cCh());
                    am.setViewTextColor(lVar.gre, R.color.cp_other_f, 1);
                }
                if (postData.aQx().getPendantData() != null && !StringUtils.isNull(postData.aQx().getPendantData().aOP())) {
                    lVar.jJS.a(postData.aQx(), 4);
                    lVar.jJJ.setVisibility(8);
                    lVar.jJS.setVisibility(0);
                    lVar.jJS.getHeadView().startLoad(avater, 28, false);
                    lVar.jJS.getHeadView().setUserId(postData.aQx().getUserId());
                    lVar.jJS.getHeadView().setUserName(postData.aQx().getUserName());
                    lVar.jJS.wP(postData.aQx().getPendantData().aOP());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.jJJ, postData.aQx(), 4);
                    lVar.jJJ.setUserId(postData.aQx().getUserId());
                    lVar.jJJ.setUserName(postData.aQx().getUserName(), postData.ddT());
                    lVar.jJJ.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                    lVar.jJJ.setImageDrawable(null);
                    lVar.jJJ.startLoad(avater, 28, false);
                    lVar.jJJ.setVisibility(0);
                    lVar.jJS.setVisibility(8);
                }
                if (bkVar != null && bkVar.aSx()) {
                    lVar.jJC.setVisibility(8);
                    lVar.jJC.setTag(null);
                } else if (postData.aQx() != null) {
                    MetaData aQx = postData.aQx();
                    int ld = postData.ddB() ? R.drawable.brand_official_btn : am.ld(R.drawable.bg_user_identity_btn);
                    int ld2 = postData.ddB() ? R.color.cp_cont_a : am.ld(R.color.cp_bg_line_d);
                    am.setBackgroundResource(lVar.jJC, ld);
                    am.setViewTextColor(lVar.jJC, ld2);
                    lVar.jJC.setTag(Integer.valueOf(ld));
                    if (str != null && !str.equals("0") && str.equals(aQx.getUserId())) {
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.host_name);
                        lVar.jJC.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (jHc != null && jHc.getDrawable(1) != null) {
                                jHc.getDrawable(1).setAlpha(255);
                            }
                        } else if (jHc != null && jHc.getDrawable(1) != null) {
                            jHc.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(jHc);
                    } else if (aQx.getIs_bawu() == 1 && postData.ddB()) {
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.brand_Official);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_member_bazhu_tip);
                        lVar.jJC.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (agG != null && agG.getDrawable(1) != null) {
                                agG.getDrawable(1).setAlpha(255);
                            }
                        } else if (agG != null && agG.getDrawable(1) != null) {
                            agG.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(agG);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_member_xbazhu_tip);
                        lVar.jJC.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (agH != null && agH.getDrawable(1) != null) {
                                agH.getDrawable(1).setAlpha(255);
                            }
                        } else if (agH != null && agH.getDrawable(1) != null) {
                            agH.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(agH);
                    } else if (aQx.getIs_bawu() == 1 && "pri_content_assist".equals(aQx.getBawu_type())) {
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_content_assist_tip);
                    } else if (aQx.getIs_bawu() == 1 && "pri_manage_assist".equals(aQx.getBawu_type())) {
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.jJC.setVisibility(8);
                        lVar.jJC.setTag(null);
                    }
                } else {
                    lVar.jJC.setVisibility(8);
                    lVar.jJC.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cDE() && postData.aQx() != null) {
                i2 = postData.aQx().getLevel_id();
            }
            if (bkVar != null && bkVar.aSx()) {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.jJR.setVisibility(0);
                am.setImageResource(lVar.jJR, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.jJR.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.jJU.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.jJU.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.jJC.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.jJT.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aQx() != null ? postData.aQx().getName_show() : "";
            int textLengthWithEmoji = ae.getTextLengthWithEmoji(name_show2);
            if (postData.aQx() != null && !StringUtils.isNull(postData.aQx().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ae.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ae.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aQx() != null && !StringUtils.isNull(postData.aQx().getSealPrefix())) {
                lVar.gre.setText(a(aVar, postData.aQx().getSealPrefix(), name_show2));
            } else {
                lVar.gre.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.ddJ()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aQx() == null || StringUtils.isNull(postData.aQx().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bkVar != null && aVar.cDG() != 0) {
                if (aVar.cDG() != 1002 && aVar.cDG() != 3) {
                    z8 = true;
                }
                if (aVar.cDG() != 3 && !bkVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.aQx() != null) {
                    String userId2 = postData.aQx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bkVar != null && bkVar.aQx() != null && postData.aQx() != null) {
                            userId = bkVar.aQx().getUserId();
                            String userId3 = postData.aQx().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aQx() != null && UtilHelper.isCurrentAccount(postData.aQx().getUserId())) {
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
                                if (postData.ddJ() == 1) {
                                    i4 = 0;
                                }
                                if (bkVar != null && bkVar.aSx()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cDG()));
                                    if (postData.aQx() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aQx() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aQx().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aQx().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aQx().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bkVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bkVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cDG()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.jJK.setTag(sparseArray);
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
                        if (postData.ddJ() == 1) {
                        }
                        if (bkVar != null) {
                            z2 = false;
                            z5 = false;
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        lVar.jJK.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bkVar != null) {
                userId = bkVar.aQx().getUserId();
                String userId32 = postData.aQx().getUserId();
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
            if (postData.ddJ() == 1) {
            }
            if (bkVar != null) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            lVar.jJK.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().ob(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eDp = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oc((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, l lVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (lVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jJK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                lVar.jJK.ze(null);
                lVar.jJK.setBackgroundDrawable(null);
                lVar.jJK.getLayoutStrategy().od(R.drawable.transparent_bg);
            } else {
                lVar.jJK.getLayoutStrategy().od(R.drawable.icon_click);
            }
            lVar.jJK.getLayoutStrategy().oa(R.drawable.pic_video);
            a(lVar.jJK, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            lVar.jJK.setLayoutParams(layoutParams);
            lVar.jJK.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            lVar.jJK.setIsFromCDN(z2);
            TbRichText ddL = postData.ddL();
            lVar.jJK.setIsUseGridImage(postData.ddW());
            lVar.jJK.setText(ddL, true, cVar);
            SparseArray sparseArray = (SparseArray) lVar.jJK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            lVar.jJK.setTag(sparseArray);
            lVar.jJB.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, l lVar, PostData postData, bk bkVar) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.ddJ() > 0 && bkVar != null && !bkVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.ddJ()));
                lVar.jJQ.setVisibility(0);
                lVar.jJQ.setText(format);
                z = true;
            } else {
                lVar.jJQ.setVisibility(8);
                z = false;
            }
            f ddM = postData.ddM();
            boolean z2 = (ddM == null || StringUtils.isNull(ddM.getName()) || bkVar == null || bkVar.isBjh()) ? false : true;
            if (z) {
                lVar.jJE.setVisibility(0);
                i = jGZ;
            } else {
                lVar.jJE.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.jJF.setVisibility(0);
                i2 = jGZ;
            } else {
                lVar.jJF.setVisibility(8);
                i2 = 0;
            }
            lVar.jJD.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.jJD.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.jJD.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.jJG.setVisibility(0);
                lVar.jJG.setPadding(jGZ, 0, 0, 0);
                lVar.jJG.setText(ddM.getName());
                return;
            }
            lVar.jJG.setVisibility(8);
        }
    }

    public static void a(l lVar, PostData postData) {
        if (postData == null || postData.cKn() == null) {
            lVar.jJV.setVisibility(8);
            return;
        }
        TbRichText ddL = postData.ddL();
        com.baidu.tieba.pb.view.b.a(postData.cKn(), lVar.jJV, false, false, ddL != null && StringUtils.isNull(ddL.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(l lVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jJK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.jJK.setLayoutParams(layoutParams);
            lVar.jJK.setPadding(0, 0, 0, 0);
            lVar.jJK.ze(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.jJK.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.jJK.setLayoutParams(layoutParams2);
            lVar.jJK.ze(postData.getBimg_url());
        }
        lVar.jJK.setTextViewCheckSelection(false);
    }
}
