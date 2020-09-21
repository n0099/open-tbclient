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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes21.dex */
public class b {
    private static LayerDrawable ajl;
    private static LayerDrawable ajm;
    private static LayerDrawable kHo;
    private static SparseArray<SoftReference<Drawable>> kHl = new SparseArray<>();
    private static SparseIntArray kHm = new SparseIntArray();
    public static final int afZ = getDimensionPixelSize(R.dimen.tbds12);
    public static final int akF = getDimensionPixelSize(R.dimen.tbds16);
    public static final int kHn = getDimensionPixelSize(R.dimen.tbds36);
    public static final int iHO = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = kHm.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            kHm.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void daa() {
        ajl = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(iHO).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(iHO).AT("#4D000000").bkO()});
        ajm = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(iHO).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(iHO).AT("#4D000000").bkO()});
        kHo = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(iHO).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(iHO).AT("#4D000000").bkO()});
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

    public static void a(n nVar, f fVar, boolean z) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            if (nVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ap.setViewTextColor(nVar.gZE, R.color.cp_cont_f, 1);
                if (nVar.kJN.getTag() instanceof Integer) {
                    ap.setBackgroundResource(nVar.kJN, ((Integer) nVar.kJN.getTag()).intValue());
                } else if (nVar.kJN.getTag() instanceof String) {
                    if (nVar.kJN.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = ajl;
                    } else if (nVar.kJN.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = ajm;
                    } else {
                        layerDrawable = nVar.kJN.getTag().equals("HOST") ? kHo : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(layerDrawable);
                    }
                }
                ap.setViewTextColor(nVar.kJO, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.kJP, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.kJQ, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.kKk, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.kJR, R.color.cp_cont_d, 1);
                nVar.kJU.setTextColor(ap.getColor(R.color.cp_cont_b));
                nVar.kJV.onChangeSkinType();
                if (z) {
                    SvgManager.bkl().a(nVar.kKp, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(nVar.kKh, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(nVar.kKf, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.kKg, R.color.cp_cont_d);
                    ap.setViewTextColor(nVar.kKi, R.color.cp_cont_d);
                }
                SvgManager.bkl().a(nVar.kKa, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bkl().a(nVar.jcB, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.kJY, R.color.cp_cont_c);
                    nVar.kJY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    ap.setViewTextColor(nVar.kJZ, R.color.cp_cont_c);
                    ap.c(nVar.kJX, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                    nVar.kJX.onChangeSkinType();
                    ap.setViewTextColor(nVar.kKu, R.color.cp_link_tip_c, 1);
                    ap.setViewTextColor(nVar.kKs, R.color.cp_cont_f, 1);
                    ap.setBackgroundResource(nVar.kKr, R.color.cp_bg_line_e);
                    ap.setBackgroundResource(nVar.kKt, R.color.cp_cont_d);
                    ap.setImageResource(nVar.kKv, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.kKy, R.color.cp_cont_c);
                    if (nVar.kKw.getVisibility() == 8) {
                        nVar.kJY.setVisibility(8);
                        nVar.kJZ.setVisibility(8);
                        nVar.kKy.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.cZc())) {
                        nVar.kKy.setText(fVar.cZc());
                    } else {
                        nVar.kKy.setText(R.string.expand_content);
                    }
                } else {
                    nVar.kJX.setVisibility(8);
                    nVar.kJY.setVisibility(8);
                    nVar.kJZ.setVisibility(8);
                    nVar.kKr.setVisibility(8);
                    nVar.kKy.setVisibility(8);
                }
                ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(n nVar, PostData postData, bw bwVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.bhp() != null) {
            if (bwVar != null) {
                postData.bhp().threadId = bwVar.getTid();
                postData.bhp().forumId = String.valueOf(bwVar.getFid());
            }
            if (i == 0) {
                postData.bhp().objType = 1;
            } else {
                postData.bhp().objType = 2;
            }
            postData.bhp().isInPost = true;
            if (z) {
                nVar.kKj.setAgreeAlone(true);
                nVar.kKj.setData(postData.bhp());
            }
            if (bwVar != null && bwVar.bei()) {
                nVar.kJS.setAgreeAlone(true);
            }
            nVar.kJS.setData(postData.bhp());
        }
    }

    public static void a(n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.jcB != null && postData != null) {
            if (z2) {
                nVar.jcB.setVisibility(8);
                if (z) {
                    if (d.baL()) {
                        string = postData.dAH() > 0 ? String.valueOf(postData.dAH()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.kKi.setText(string);
                    return;
                }
                return;
            }
            nVar.jcB.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x047c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:263:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(n nVar, PostData postData, View view, int i, a aVar, bw bwVar, boolean z) {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (nVar != null && postData != null) {
            if (postData.bfy() == null || postData.bfy().isBaijiahaoUser()) {
            }
            if (postData.mpm) {
                ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (bwVar == null || bwVar.bfy() == null) {
                str = null;
            } else {
                str = bwVar.bfy().getUserId();
            }
            nVar.kJT.setTag(null);
            nVar.kJT.setUserId(null);
            nVar.gZE.setText((CharSequence) null);
            nVar.kKm.getHeadView().setUserId(null);
            nVar.kJU.setIsHost(false);
            if (postData.bfy() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.bfy().getUserId())) {
                    nVar.kJU.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bfy().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bfy().getTShowInfoNew();
                if (nVar.kKo != null) {
                    nVar.kKo.setTag(R.id.tag_user_id, postData.bfy().getUserId());
                    nVar.kKo.setOnClickListener(aVar.cZW().kYn);
                    nVar.kKo.a(iconInfo, 2, kHn, kHn, afZ);
                }
                if (nVar.kKn != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kKn.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.kKn.setOnClickListener(aVar.cZW().kYo);
                    nVar.kKn.a(tShowInfoNew, 3, kHn, kHn, afZ, true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.bfy().isBigV()) {
                    ap.setViewTextColor(nVar.gZE, R.color.cp_cont_h, 1);
                } else {
                    ap.setViewTextColor(nVar.gZE, R.color.cp_cont_f, 1);
                }
                String avater = postData.bfy().getAvater();
                nVar.gZE.setTag(R.id.tag_user_id, postData.bfy().getUserId());
                nVar.gZE.setTag(R.id.tag_user_name, postData.bfy().getUserName());
                nVar.gZE.setTag(R.id.tag_virtual_user_url, postData.bfy().getVirtualUserUrl());
                String name_show = postData.bfy().getName_show();
                String userName = postData.bfy().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gZE.setText(c.aQ(aVar.getPageContext().getPageActivity(), nVar.gZE.getText().toString()));
                    nVar.gZE.setGravity(16);
                    nVar.gZE.setTag(R.id.tag_nick_name_activity, c.cYB());
                    ap.setViewTextColor(nVar.gZE, R.color.cp_other_f, 1);
                }
                if (postData.bfy().getPendantData() != null && !StringUtils.isNull(postData.bfy().getPendantData().bdu())) {
                    nVar.kKm.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kKm.a(postData.bfy(), 4);
                    nVar.kJT.setVisibility(8);
                    nVar.kKm.setVisibility(0);
                    nVar.kKm.getHeadView().startLoad(avater, 28, false);
                    nVar.kKm.getHeadView().setUserId(postData.bfy().getUserId());
                    nVar.kKm.getHeadView().setUserName(postData.bfy().getUserName());
                    nVar.kKm.AW(postData.bfy().getPendantData().bdu());
                } else {
                    nVar.kJT.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.kJT, postData.bfy(), 4);
                    nVar.kJT.setUserId(postData.bfy().getUserId());
                    nVar.kJT.setUserName(postData.bfy().getUserName(), postData.dAN());
                    nVar.kJT.setTag(R.id.tag_virtual_user_url, postData.bfy().getVirtualUserUrl());
                    nVar.kJT.setImageDrawable(null);
                    nVar.kJT.startLoad(avater, 28, false);
                    nVar.kJT.setVisibility(0);
                    nVar.kKm.setVisibility(8);
                }
                if (bwVar != null && bwVar.bei()) {
                    nVar.kJN.setVisibility(8);
                    nVar.kJN.setTag(null);
                } else if (postData.bfy() != null) {
                    MetaData bfy = postData.bfy();
                    int oe = postData.dAv() ? R.drawable.brand_official_btn : ap.oe(R.drawable.bg_user_identity_btn);
                    int oe2 = postData.dAv() ? R.color.cp_cont_a : ap.oe(R.color.cp_bg_line_d);
                    ap.setBackgroundResource(nVar.kJN, oe);
                    ap.setViewTextColor(nVar.kJN, oe2);
                    nVar.kJN.setTag(Integer.valueOf(oe));
                    if (str != null && !str.equals("0") && str.equals(bfy.getUserId())) {
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.host_name);
                        nVar.kJN.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (kHo != null && kHo.getDrawable(1) != null) {
                                kHo.getDrawable(1).setAlpha(255);
                            }
                        } else if (kHo != null && kHo.getDrawable(1) != null) {
                            kHo.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(kHo);
                    } else if (bfy.getIs_bawu() == 1 && postData.dAv()) {
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.brand_Official);
                    } else if (bfy.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bfy.getBawu_type())) {
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_member_bazhu_tip);
                        nVar.kJN.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajl != null && ajl.getDrawable(1) != null) {
                                ajl.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajl != null && ajl.getDrawable(1) != null) {
                            ajl.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(ajl);
                    } else if (bfy.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bfy.getBawu_type())) {
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_member_xbazhu_tip);
                        nVar.kJN.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajm != null && ajm.getDrawable(1) != null) {
                                ajm.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajm != null && ajm.getDrawable(1) != null) {
                            ajm.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(ajm);
                    } else if (bfy.getIs_bawu() == 1 && "pri_content_assist".equals(bfy.getBawu_type())) {
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_content_assist_tip);
                    } else if (bfy.getIs_bawu() == 1 && "pri_manage_assist".equals(bfy.getBawu_type())) {
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.kJN.setVisibility(8);
                        nVar.kJN.setTag(null);
                    }
                } else {
                    nVar.kJN.setVisibility(8);
                    nVar.kJN.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cZX() && postData.bfy() != null) {
                i2 = postData.bfy().getLevel_id();
            }
            if (bwVar != null && bwVar.bei()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.kKl.setVisibility(0);
                ap.setImageResource(nVar.kKl, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.kKl.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.kKo.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.kKo.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.kJN.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.kKn.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.bfy() != null ? postData.bfy().getName_show() : "";
            int textLengthWithEmoji = af.getTextLengthWithEmoji(name_show2);
            if (postData.bfy() != null && !StringUtils.isNull(postData.bfy().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = af.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = af.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.bfy() != null && !StringUtils.isNull(postData.bfy().getSealPrefix())) {
                nVar.gZE.setText(a(aVar, postData.bfy().getSealPrefix(), name_show2));
            } else {
                nVar.gZE.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dAD()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.bfy() == null || StringUtils.isNull(postData.bfy().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (bwVar != null && aVar.cZZ() != 0) {
                if (aVar.cZZ() != 1002 && aVar.cZZ() != 3) {
                    z9 = true;
                }
                if (aVar.cZZ() != 3 && !bwVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.bfy() != null) {
                    String userId2 = postData.bfy().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (bwVar != null && bwVar.bfy() != null && postData.bfy() != null) {
                            userId = bwVar.bfy().getUserId();
                            String userId3 = postData.bfy().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.bfy() != null && UtilHelper.isCurrentAccount(postData.bfy().getUserId())) {
                                    z7 = true;
                                    z8 = true;
                                } else {
                                    z7 = z11;
                                    z8 = z5;
                                }
                                if (z2) {
                                    z3 = false;
                                    z8 = false;
                                    z6 = false;
                                }
                                int i4 = 1;
                                if (postData.dAD() == 1) {
                                    i4 = 0;
                                }
                                if (bwVar != null && bwVar.bei()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cZZ()));
                                    if (postData.bfy() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bfy().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bfy().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bfy().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bfy() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bfy().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bfy().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bfy().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bwVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && bwVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cZZ()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.kJU.setTag(sparseArray);
                                if (z) {
                                    nVar.kKp.setTag(sparseArray);
                                    return;
                                }
                                return;
                            }
                        }
                        z5 = z4;
                        z6 = false;
                        if (postData == null) {
                        }
                        z7 = z11;
                        z8 = z5;
                        if (z2) {
                        }
                        int i42 = 1;
                        if (postData.dAD() == 1) {
                        }
                        if (bwVar != null) {
                            z3 = false;
                            z6 = false;
                        }
                        if (z3) {
                        }
                        if (z6) {
                        }
                        if (!z8) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        nVar.kJU.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (bwVar != null) {
                userId = bwVar.bfy().getUserId();
                String userId32 = postData.bfy().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z5 = z4;
            z6 = false;
            if (postData == null) {
            }
            z7 = z11;
            z8 = z5;
            if (z2) {
            }
            int i422 = 1;
            if (postData.dAD() == 1) {
            }
            if (bwVar != null) {
            }
            if (z3) {
            }
            if (z6) {
            }
            if (!z8) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            nVar.kJU.setTag(sparseArray);
            if (z) {
            }
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            if (z2) {
                tbRichTextView.getLayoutStrategy().ru(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().ru(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fhx = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (z2) {
                tbRichTextView.getLayoutStrategy().rv((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().rv((int) (equipmentWidth * 1.618f));
            }
        }
    }

    public static void a(a aVar, n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, boolean z4, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kJU.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.kJU.Dr(null);
                nVar.kJU.setBackgroundDrawable(null);
                nVar.kJU.getLayoutStrategy().rw(R.drawable.transparent_bg);
            } else {
                nVar.kJU.getLayoutStrategy().rw(R.drawable.icon_click);
            }
            nVar.kJU.getLayoutStrategy().rt(R.drawable.pic_video);
            a(nVar.kJU, view, StringUtils.isNull(postData.getBimg_url()) ? false : true, z2);
            nVar.kJU.setLayoutParams(layoutParams);
            nVar.kJU.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            nVar.kJU.setIsFromCDN(z3);
            nVar.kJU.setText(postData.dAF(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.kJU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z4));
            nVar.kJU.setTag(sparseArray);
            nVar.kJM.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, n nVar, PostData postData, bw bwVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dAD() > 0 && bwVar != null && !bwVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dAD()));
                nVar.kKk.setVisibility(0);
                nVar.kKk.setText(format);
                z = true;
            } else {
                nVar.kKk.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dAG = postData.dAG();
            boolean z2 = (dAG == null || StringUtils.isNull(dAG.getName()) || bwVar == null || bwVar.isBjh()) ? false : true;
            if (z) {
                nVar.kJP.setVisibility(0);
                i = akF;
            } else {
                nVar.kJP.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.kJQ.setVisibility(0);
                i2 = akF;
            } else {
                nVar.kJQ.setVisibility(8);
                i2 = 0;
            }
            nVar.kJO.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.kJO.setText(at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.kJO.setText(at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.kJR.setVisibility(0);
                nVar.kJR.setPadding(akF, 0, 0, 0);
                nVar.kJR.setText(dAG.getName());
                return;
            }
            nVar.kJR.setVisibility(8);
        }
    }

    public static void a(n nVar, PostData postData) {
        if (postData == null || postData.dgO() == null) {
            nVar.kKq.setVisibility(8);
            return;
        }
        TbRichText dAF = postData.dAF();
        com.baidu.tieba.pb.view.b.a(postData.dgO(), nVar.kKq, false, false, dAF != null && StringUtils.isNull(dAF.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kJU.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.kJU.setLayoutParams(layoutParams);
            nVar.kJU.setPadding(0, 0, 0, 0);
            nVar.kJU.Dr(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kJU.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.kJU.setLayoutParams(layoutParams2);
            nVar.kJU.Dr(postData.getBimg_url());
        }
        nVar.kJU.setTextViewCheckSelection(false);
    }
}
