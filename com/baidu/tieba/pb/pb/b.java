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
    private static LayerDrawable jFW;
    private static SparseArray<SoftReference<Drawable>> jFR = new SparseArray<>();
    private static SparseIntArray jFS = new SparseIntArray();
    public static final int eDj = getDimensionPixelSize(R.dimen.tbds12);
    public static final int jFT = getDimensionPixelSize(R.dimen.tbds16);
    public static final int jFU = getDimensionPixelSize(R.dimen.tbds36);
    public static final int jFV = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = jFS.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            jFS.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cDr() {
        agG = new LayerDrawable(new Drawable[]{c.aVz().ln(0).O(jFV).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVB(), c.aVz().ln(0).O(jFV).wJ("#4D000000").aVB()});
        agH = new LayerDrawable(new Drawable[]{c.aVz().ln(0).O(jFV).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVB(), c.aVz().ln(0).O(jFV).wJ("#4D000000").aVB()});
        jFW = new LayerDrawable(new Drawable[]{c.aVz().ln(0).O(jFV).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aVB(), c.aVz().ln(0).O(jFV).wJ("#4D000000").aVB()});
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
                am.setViewTextColor(lVar.gqT, R.color.cp_cont_f, 1);
                if (lVar.jIw.getTag() instanceof Integer) {
                    am.setBackgroundResource(lVar.jIw, ((Integer) lVar.jIw.getTag()).intValue());
                } else if (lVar.jIw.getTag() instanceof String) {
                    if (lVar.jIw.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = agG;
                    } else if (lVar.jIw.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = agH;
                    } else {
                        layerDrawable = lVar.jIw.getTag().equals("HOST") ? jFW : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(lVar.jIx, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.jIy, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.jIz, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.jIK, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.jIA, R.color.cp_cont_d, 1);
                lVar.jIE.setTextColor(am.getColor(R.color.cp_cont_b));
                lVar.jIF.onChangeSkinType();
                if (z) {
                    SvgManager.aUV().a(lVar.jIJ, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUV().a(lVar.igT, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (eVar != null) {
                    am.setViewTextColor(lVar.jIH, (int) R.color.cp_cont_c);
                    lVar.jIH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(lVar.jII, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(lVar.jIG, R.color.cp_bg_line_g);
                    lVar.jIG.onChangeSkinType();
                    am.setViewTextColor(lVar.jIT, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(lVar.jIR, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(lVar.jIQ, R.color.cp_bg_line_e);
                    am.setBackgroundResource(lVar.jIS, R.color.cp_cont_d);
                    am.setImageResource(lVar.jIU, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(lVar.jIX, (int) R.color.cp_cont_c);
                    if (lVar.jIV.getVisibility() == 8) {
                        lVar.jIH.setVisibility(8);
                        lVar.jII.setVisibility(8);
                        lVar.jIX.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.cCt())) {
                        lVar.jIX.setText(eVar.cCt());
                    } else {
                        lVar.jIX.setText(R.string.expand_content);
                    }
                } else {
                    lVar.jIG.setVisibility(8);
                    lVar.jIH.setVisibility(8);
                    lVar.jII.setVisibility(8);
                    lVar.jIQ.setVisibility(8);
                    lVar.jIX.setVisibility(8);
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
                lVar.jIB.setAgreeAlone(true);
            }
            lVar.jIB.setData(postData.aSp());
        }
    }

    public static void a(l lVar, boolean z) {
        if (lVar.igT != null) {
            lVar.igT.setVisibility(z ? 0 : 8);
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
            if (postData.llw) {
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
            lVar.jID.setTag(null);
            lVar.jID.setUserId(null);
            lVar.gqT.setText((CharSequence) null);
            lVar.jIM.getHeadView().setUserId(null);
            lVar.jIE.setIsHost(false);
            if (postData.aQx() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aQx().getUserId())) {
                    lVar.jIE.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aQx().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aQx().getTShowInfoNew();
                if (lVar.jIO != null) {
                    lVar.jIO.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                    lVar.jIO.setOnClickListener(aVar.cDn().jWd);
                    lVar.jIO.a(iconInfo, 2, jFU, jFU, eDj);
                }
                if (lVar.jIN != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.jIN.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.jIN.setOnClickListener(aVar.cDn().jWe);
                    lVar.jIN.a(tShowInfoNew, 3, jFU, jFU, eDj, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aQx().isBigV()) {
                    am.setViewTextColor(lVar.gqT, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(lVar.gqT, R.color.cp_cont_f, 1);
                }
                String avater = postData.aQx().getAvater();
                lVar.gqT.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                lVar.gqT.setTag(R.id.tag_user_name, postData.aQx().getUserName());
                lVar.gqT.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                String name_show = postData.aQx().getName_show();
                String userName = postData.aQx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.gqT.setText(com.baidu.tieba.pb.c.aK(aVar.getPageContext().getPageActivity(), lVar.gqT.getText().toString()));
                    lVar.gqT.setGravity(16);
                    lVar.gqT.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cBR());
                    am.setViewTextColor(lVar.gqT, R.color.cp_other_f, 1);
                }
                if (postData.aQx().getPendantData() != null && !StringUtils.isNull(postData.aQx().getPendantData().aOP())) {
                    lVar.jIM.a(postData.aQx(), 4);
                    lVar.jID.setVisibility(8);
                    lVar.jIM.setVisibility(0);
                    lVar.jIM.getHeadView().startLoad(avater, 28, false);
                    lVar.jIM.getHeadView().setUserId(postData.aQx().getUserId());
                    lVar.jIM.getHeadView().setUserName(postData.aQx().getUserName());
                    lVar.jIM.wP(postData.aQx().getPendantData().aOP());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.jID, postData.aQx(), 4);
                    lVar.jID.setUserId(postData.aQx().getUserId());
                    lVar.jID.setUserName(postData.aQx().getUserName(), postData.ddE());
                    lVar.jID.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                    lVar.jID.setImageDrawable(null);
                    lVar.jID.startLoad(avater, 28, false);
                    lVar.jID.setVisibility(0);
                    lVar.jIM.setVisibility(8);
                }
                if (bkVar != null && bkVar.aSx()) {
                    lVar.jIw.setVisibility(8);
                    lVar.jIw.setTag(null);
                } else if (postData.aQx() != null) {
                    MetaData aQx = postData.aQx();
                    int lb = postData.ddm() ? R.drawable.brand_official_btn : am.lb(R.drawable.bg_user_identity_btn);
                    int lb2 = postData.ddm() ? R.color.cp_cont_a : am.lb(R.color.cp_bg_line_d);
                    am.setBackgroundResource(lVar.jIw, lb);
                    am.setViewTextColor(lVar.jIw, lb2);
                    lVar.jIw.setTag(Integer.valueOf(lb));
                    if (str != null && !str.equals("0") && str.equals(aQx.getUserId())) {
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.host_name);
                        lVar.jIw.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (jFW != null && jFW.getDrawable(1) != null) {
                                jFW.getDrawable(1).setAlpha(255);
                            }
                        } else if (jFW != null && jFW.getDrawable(1) != null) {
                            jFW.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(jFW);
                    } else if (aQx.getIs_bawu() == 1 && postData.ddm()) {
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.brand_Official);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_member_bazhu_tip);
                        lVar.jIw.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (agG != null && agG.getDrawable(1) != null) {
                                agG.getDrawable(1).setAlpha(255);
                            }
                        } else if (agG != null && agG.getDrawable(1) != null) {
                            agG.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(agG);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_member_xbazhu_tip);
                        lVar.jIw.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (agH != null && agH.getDrawable(1) != null) {
                                agH.getDrawable(1).setAlpha(255);
                            }
                        } else if (agH != null && agH.getDrawable(1) != null) {
                            agH.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(agH);
                    } else if (aQx.getIs_bawu() == 1 && "pri_content_assist".equals(aQx.getBawu_type())) {
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_content_assist_tip);
                    } else if (aQx.getIs_bawu() == 1 && "pri_manage_assist".equals(aQx.getBawu_type())) {
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.jIw.setVisibility(8);
                        lVar.jIw.setTag(null);
                    }
                } else {
                    lVar.jIw.setVisibility(8);
                    lVar.jIw.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cDo() && postData.aQx() != null) {
                i2 = postData.aQx().getLevel_id();
            }
            if (bkVar != null && bkVar.aSx()) {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.jIL.setVisibility(0);
                am.setImageResource(lVar.jIL, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.jIL.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.jIO.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.jIO.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.jIw.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.jIN.getChildCount() > 0) {
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
                lVar.gqT.setText(a(aVar, postData.aQx().getSealPrefix(), name_show2));
            } else {
                lVar.gqT.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.ddu()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aQx() == null || StringUtils.isNull(postData.aQx().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bkVar != null && aVar.cDq() != 0) {
                if (aVar.cDq() != 1002 && aVar.cDq() != 3) {
                    z8 = true;
                }
                if (aVar.cDq() != 3 && !bkVar.isBjh()) {
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
                                if (postData.ddu() == 1) {
                                    i4 = 0;
                                }
                                if (bkVar != null && bkVar.aSx()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cDq()));
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
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cDq()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.jIE.setTag(sparseArray);
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
                        if (postData.ddu() == 1) {
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
                        lVar.jIE.setTag(sparseArray);
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
            if (postData.ddu() == 1) {
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
            lVar.jIE.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().nZ(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eDe = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oa((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, l lVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (lVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jIE.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                lVar.jIE.ze(null);
                lVar.jIE.setBackgroundDrawable(null);
                lVar.jIE.getLayoutStrategy().ob(R.drawable.transparent_bg);
            } else {
                lVar.jIE.getLayoutStrategy().ob(R.drawable.icon_click);
            }
            lVar.jIE.getLayoutStrategy().nY(R.drawable.pic_video);
            a(lVar.jIE, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            lVar.jIE.setLayoutParams(layoutParams);
            lVar.jIE.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            lVar.jIE.setIsFromCDN(z2);
            TbRichText ddw = postData.ddw();
            lVar.jIE.setIsUseGridImage(postData.ddH());
            lVar.jIE.setText(ddw, true, cVar);
            SparseArray sparseArray = (SparseArray) lVar.jIE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            lVar.jIE.setTag(sparseArray);
            lVar.jIv.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, l lVar, PostData postData, bk bkVar) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.ddu() > 0 && bkVar != null && !bkVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.ddu()));
                lVar.jIK.setVisibility(0);
                lVar.jIK.setText(format);
                z = true;
            } else {
                lVar.jIK.setVisibility(8);
                z = false;
            }
            f ddx = postData.ddx();
            boolean z2 = (ddx == null || StringUtils.isNull(ddx.getName()) || bkVar == null || bkVar.isBjh()) ? false : true;
            if (z) {
                lVar.jIy.setVisibility(0);
                i = jFT;
            } else {
                lVar.jIy.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.jIz.setVisibility(0);
                i2 = jFT;
            } else {
                lVar.jIz.setVisibility(8);
                i2 = 0;
            }
            lVar.jIx.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.jIx.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.jIx.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.jIA.setVisibility(0);
                lVar.jIA.setPadding(jFT, 0, 0, 0);
                lVar.jIA.setText(ddx.getName());
                return;
            }
            lVar.jIA.setVisibility(8);
        }
    }

    public static void a(l lVar, PostData postData) {
        if (postData == null || postData.cJX() == null) {
            lVar.jIP.setVisibility(8);
            return;
        }
        TbRichText ddw = postData.ddw();
        com.baidu.tieba.pb.view.b.a(postData.cJX(), lVar.jIP, false, false, ddw != null && StringUtils.isNull(ddw.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(l lVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jIE.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.jIE.setLayoutParams(layoutParams);
            lVar.jIE.setPadding(0, 0, 0, 0);
            lVar.jIE.ze(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.jIE.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.jIE.setLayoutParams(layoutParams2);
            lVar.jIE.ze(postData.getBimg_url());
        }
        lVar.jIE.setTextViewCheckSelection(false);
    }
}
