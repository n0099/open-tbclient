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
/* loaded from: classes22.dex */
public class b {
    private static LayerDrawable ajD;
    private static LayerDrawable ajE;
    private static LayerDrawable kWz;
    private static SparseArray<SoftReference<Drawable>> kWw = new SparseArray<>();
    private static SparseIntArray kWx = new SparseIntArray();
    public static final int agr = getDimensionPixelSize(R.dimen.tbds12);
    public static final int akX = getDimensionPixelSize(R.dimen.tbds16);
    public static final int kWy = getDimensionPixelSize(R.dimen.tbds36);
    public static final int iWE = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = kWx.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            kWx.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void ddJ() {
        ajD = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(iWE).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(iWE).BF("#4D000000").bny()});
        ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(iWE).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(iWE).BF("#4D000000").bny()});
        kWz = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(iWE).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(iWE).BF("#4D000000").bny()});
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
                ap.setViewTextColor(nVar.hoF, R.color.cp_cont_f, 1);
                if (nVar.kYY.getTag() instanceof Integer) {
                    ap.setBackgroundResource(nVar.kYY, ((Integer) nVar.kYY.getTag()).intValue());
                } else if (nVar.kYY.getTag() instanceof String) {
                    if (nVar.kYY.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = ajD;
                    } else if (nVar.kYY.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = ajE;
                    } else {
                        layerDrawable = nVar.kYY.getTag().equals("HOST") ? kWz : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(layerDrawable);
                    }
                }
                ap.setViewTextColor(nVar.kYZ, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.kZa, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.kZb, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.kZv, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.kZc, R.color.cp_cont_d, 1);
                nVar.kZf.setTextColor(ap.getColor(R.color.cp_cont_b));
                nVar.kZg.onChangeSkinType();
                if (z) {
                    SvgManager.bmU().a(nVar.kZA, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(nVar.kZs, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(nVar.kZq, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.kZr, R.color.cp_cont_d);
                    ap.setViewTextColor(nVar.kZt, R.color.cp_cont_d);
                }
                SvgManager.bmU().a(nVar.kZl, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bmU().a(nVar.jrA, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.kZj, R.color.cp_cont_c);
                    nVar.kZj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    ap.setViewTextColor(nVar.kZk, R.color.cp_cont_c);
                    ap.c(nVar.kZi, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                    nVar.kZi.onChangeSkinType();
                    ap.setViewTextColor(nVar.kZF, R.color.cp_link_tip_c, 1);
                    ap.setViewTextColor(nVar.kZD, R.color.cp_cont_f, 1);
                    ap.setBackgroundResource(nVar.kZC, R.color.cp_bg_line_e);
                    ap.setBackgroundResource(nVar.kZE, R.color.cp_cont_d);
                    ap.setImageResource(nVar.kZG, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.kZJ, R.color.cp_cont_c);
                    if (nVar.kZH.getVisibility() == 8) {
                        nVar.kZj.setVisibility(8);
                        nVar.kZk.setVisibility(8);
                        nVar.kZJ.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dcL())) {
                        nVar.kZJ.setText(fVar.dcL());
                    } else {
                        nVar.kZJ.setText(R.string.expand_content);
                    }
                } else {
                    nVar.kZi.setVisibility(8);
                    nVar.kZj.setVisibility(8);
                    nVar.kZk.setVisibility(8);
                    nVar.kZC.setVisibility(8);
                    nVar.kZJ.setVisibility(8);
                }
                ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(n nVar, PostData postData, bw bwVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.bjY() != null) {
            if (bwVar != null) {
                postData.bjY().threadId = bwVar.getTid();
                postData.bjY().forumId = String.valueOf(bwVar.getFid());
            }
            if (i == 0) {
                postData.bjY().objType = 1;
            } else {
                postData.bjY().objType = 2;
            }
            postData.bjY().isInPost = true;
            if (z) {
                nVar.kZu.setAgreeAlone(true);
                nVar.kZu.setData(postData.bjY());
            }
            if (bwVar != null && bwVar.bgR()) {
                nVar.kZd.setAgreeAlone(true);
            }
            nVar.kZd.setData(postData.bjY());
        }
    }

    public static void a(n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.jrA != null && postData != null) {
            if (z2) {
                nVar.jrA.setVisibility(8);
                if (z) {
                    if (d.bdt()) {
                        string = postData.dEt() > 0 ? String.valueOf(postData.dEt()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.kZt.setText(string);
                    return;
                }
                return;
            }
            nVar.jrA.setVisibility(z ? 0 : 8);
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
            if (postData.bih() == null || postData.bih().isBaijiahaoUser()) {
            }
            if (postData.mES) {
                ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (bwVar == null || bwVar.bih() == null) {
                str = null;
            } else {
                str = bwVar.bih().getUserId();
            }
            nVar.kZe.setTag(null);
            nVar.kZe.setUserId(null);
            nVar.hoF.setText((CharSequence) null);
            nVar.kZx.getHeadView().setUserId(null);
            nVar.kZf.setIsHost(false);
            if (postData.bih() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.bih().getUserId())) {
                    nVar.kZf.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bih().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bih().getTShowInfoNew();
                if (nVar.kZz != null) {
                    nVar.kZz.setTag(R.id.tag_user_id, postData.bih().getUserId());
                    nVar.kZz.setOnClickListener(aVar.ddF().lnB);
                    nVar.kZz.a(iconInfo, 2, kWy, kWy, agr);
                }
                if (nVar.kZy != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kZy.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.kZy.setOnClickListener(aVar.ddF().lnC);
                    nVar.kZy.a(tShowInfoNew, 3, kWy, kWy, agr, true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.bih().isBigV()) {
                    ap.setViewTextColor(nVar.hoF, R.color.cp_cont_h, 1);
                } else {
                    ap.setViewTextColor(nVar.hoF, R.color.cp_cont_f, 1);
                }
                String avater = postData.bih().getAvater();
                nVar.hoF.setTag(R.id.tag_user_id, postData.bih().getUserId());
                nVar.hoF.setTag(R.id.tag_user_name, postData.bih().getUserName());
                nVar.hoF.setTag(R.id.tag_virtual_user_url, postData.bih().getVirtualUserUrl());
                String name_show = postData.bih().getName_show();
                String userName = postData.bih().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hoF.setText(c.aS(aVar.getPageContext().getPageActivity(), nVar.hoF.getText().toString()));
                    nVar.hoF.setGravity(16);
                    nVar.hoF.setTag(R.id.tag_nick_name_activity, c.dck());
                    ap.setViewTextColor(nVar.hoF, R.color.cp_other_f, 1);
                }
                if (postData.bih().getPendantData() != null && !StringUtils.isNull(postData.bih().getPendantData().bgd())) {
                    nVar.kZx.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kZx.a(postData.bih(), 4);
                    nVar.kZe.setVisibility(8);
                    nVar.kZx.setVisibility(0);
                    nVar.kZx.getHeadView().startLoad(avater, 28, false);
                    nVar.kZx.getHeadView().setUserId(postData.bih().getUserId());
                    nVar.kZx.getHeadView().setUserName(postData.bih().getUserName());
                    nVar.kZx.BI(postData.bih().getPendantData().bgd());
                } else {
                    nVar.kZe.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.kZe, postData.bih(), 4);
                    nVar.kZe.setUserId(postData.bih().getUserId());
                    nVar.kZe.setUserName(postData.bih().getUserName(), postData.dEz());
                    nVar.kZe.setTag(R.id.tag_virtual_user_url, postData.bih().getVirtualUserUrl());
                    nVar.kZe.setImageDrawable(null);
                    nVar.kZe.startLoad(avater, 28, false);
                    nVar.kZe.setVisibility(0);
                    nVar.kZx.setVisibility(8);
                }
                if (bwVar != null && bwVar.bgR()) {
                    nVar.kYY.setVisibility(8);
                    nVar.kYY.setTag(null);
                } else if (postData.bih() != null) {
                    MetaData bih = postData.bih();
                    int oB = postData.dEh() ? R.drawable.brand_official_btn : ap.oB(R.drawable.bg_user_identity_btn);
                    int oB2 = postData.dEh() ? R.color.cp_cont_a : ap.oB(R.color.cp_bg_line_d);
                    ap.setBackgroundResource(nVar.kYY, oB);
                    ap.setViewTextColor(nVar.kYY, oB2);
                    nVar.kYY.setTag(Integer.valueOf(oB));
                    if (str != null && !str.equals("0") && str.equals(bih.getUserId())) {
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.host_name);
                        nVar.kYY.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (kWz != null && kWz.getDrawable(1) != null) {
                                kWz.getDrawable(1).setAlpha(255);
                            }
                        } else if (kWz != null && kWz.getDrawable(1) != null) {
                            kWz.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(kWz);
                    } else if (bih.getIs_bawu() == 1 && postData.dEh()) {
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.brand_Official);
                    } else if (bih.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bih.getBawu_type())) {
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_member_bazhu_tip);
                        nVar.kYY.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajD != null && ajD.getDrawable(1) != null) {
                                ajD.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajD != null && ajD.getDrawable(1) != null) {
                            ajD.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(ajD);
                    } else if (bih.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bih.getBawu_type())) {
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_member_xbazhu_tip);
                        nVar.kYY.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajE != null && ajE.getDrawable(1) != null) {
                                ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajE != null && ajE.getDrawable(1) != null) {
                            ajE.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(ajE);
                    } else if (bih.getIs_bawu() == 1 && "pri_content_assist".equals(bih.getBawu_type())) {
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_content_assist_tip);
                    } else if (bih.getIs_bawu() == 1 && "pri_manage_assist".equals(bih.getBawu_type())) {
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.kYY.setVisibility(8);
                        nVar.kYY.setTag(null);
                    }
                } else {
                    nVar.kYY.setVisibility(8);
                    nVar.kYY.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.ddG() && postData.bih() != null) {
                i2 = postData.bih().getLevel_id();
            }
            if (bwVar != null && bwVar.bgR()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.kZw.setVisibility(0);
                ap.setImageResource(nVar.kZw, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.kZw.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.kZz.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.kZz.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.kYY.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.kZy.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.bih() != null ? postData.bih().getName_show() : "";
            int textLengthWithEmoji = af.getTextLengthWithEmoji(name_show2);
            if (postData.bih() != null && !StringUtils.isNull(postData.bih().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = af.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = af.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.bih() != null && !StringUtils.isNull(postData.bih().getSealPrefix())) {
                nVar.hoF.setText(a(aVar, postData.bih().getSealPrefix(), name_show2));
            } else {
                nVar.hoF.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dEp()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.bih() == null || StringUtils.isNull(postData.bih().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (bwVar != null && aVar.ddI() != 0) {
                if (aVar.ddI() != 1002 && aVar.ddI() != 3) {
                    z9 = true;
                }
                if (aVar.ddI() != 3 && !bwVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.bih() != null) {
                    String userId2 = postData.bih().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (bwVar != null && bwVar.bih() != null && postData.bih() != null) {
                            userId = bwVar.bih().getUserId();
                            String userId3 = postData.bih().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.bih() != null && UtilHelper.isCurrentAccount(postData.bih().getUserId())) {
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
                                if (postData.dEp() == 1) {
                                    i4 = 0;
                                }
                                if (bwVar != null && bwVar.bgR()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.ddI()));
                                    if (postData.bih() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bih().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bih().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bih().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bih() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bih().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bih().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bih().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bwVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && bwVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.ddI()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.kZf.setTag(sparseArray);
                                if (z) {
                                    nVar.kZA.setTag(sparseArray);
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
                        if (postData.dEp() == 1) {
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
                        nVar.kZf.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (bwVar != null) {
                userId = bwVar.bih().getUserId();
                String userId32 = postData.bih().getUserId();
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
            if (postData.dEp() == 1) {
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
            nVar.kZf.setTag(sparseArray);
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
                tbRichTextView.getLayoutStrategy().rS(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().rS(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().ftO = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (z2) {
                tbRichTextView.getLayoutStrategy().rT((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().rT((int) (equipmentWidth * 1.618f));
            }
        }
    }

    public static void a(a aVar, n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, boolean z4, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kZf.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.kZf.Ed(null);
                nVar.kZf.setBackgroundDrawable(null);
                nVar.kZf.getLayoutStrategy().rU(R.drawable.transparent_bg);
            } else {
                nVar.kZf.getLayoutStrategy().rU(R.drawable.icon_click);
            }
            nVar.kZf.getLayoutStrategy().rR(R.drawable.pic_video);
            a(nVar.kZf, view, StringUtils.isNull(postData.getBimg_url()) ? false : true, z2);
            nVar.kZf.setLayoutParams(layoutParams);
            nVar.kZf.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            nVar.kZf.setIsFromCDN(z3);
            nVar.kZf.setText(postData.dEr(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.kZf.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z4));
            nVar.kZf.setTag(sparseArray);
            nVar.kYX.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, n nVar, PostData postData, bw bwVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dEp() > 0 && bwVar != null && !bwVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dEp()));
                nVar.kZv.setVisibility(0);
                nVar.kZv.setText(format);
                z = true;
            } else {
                nVar.kZv.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dEs = postData.dEs();
            boolean z2 = (dEs == null || StringUtils.isNull(dEs.getName()) || bwVar == null || bwVar.isBjh()) ? false : true;
            if (z) {
                nVar.kZa.setVisibility(0);
                i = akX;
            } else {
                nVar.kZa.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.kZb.setVisibility(0);
                i2 = akX;
            } else {
                nVar.kZb.setVisibility(8);
                i2 = 0;
            }
            nVar.kYZ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.kYZ.setText(at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.kYZ.setText(at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.kZc.setVisibility(0);
                nVar.kZc.setPadding(akX, 0, 0, 0);
                nVar.kZc.setText(dEs.getName());
                return;
            }
            nVar.kZc.setVisibility(8);
        }
    }

    public static void a(n nVar, PostData postData) {
        if (postData == null || postData.dkx() == null) {
            nVar.kZB.setVisibility(8);
            return;
        }
        TbRichText dEr = postData.dEr();
        com.baidu.tieba.pb.view.b.a(postData.dkx(), nVar.kZB, false, false, dEr != null && StringUtils.isNull(dEr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kZf.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.kZf.setLayoutParams(layoutParams);
            nVar.kZf.setPadding(0, 0, 0, 0);
            nVar.kZf.Ed(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kZf.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.kZf.setLayoutParams(layoutParams2);
            nVar.kZf.Ed(postData.getBimg_url());
        }
        nVar.kZf.setTextViewCheckSelection(false);
    }
}
