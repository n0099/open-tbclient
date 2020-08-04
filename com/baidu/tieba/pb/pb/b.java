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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes16.dex */
public class b {
    private static LayerDrawable ahB;
    private static LayerDrawable ahC;
    private static LayerDrawable kjs;
    private static SparseArray<SoftReference<Drawable>> kjp = new SparseArray<>();
    private static SparseIntArray kjq = new SparseIntArray();
    public static final int eTZ = getDimensionPixelSize(R.dimen.tbds12);
    public static final int aiP = getDimensionPixelSize(R.dimen.tbds16);
    public static final int kjr = getDimensionPixelSize(R.dimen.tbds36);
    public static final int iml = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = kjq.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            kjq.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cLI() {
        ahB = new LayerDrawable(new Drawable[]{c.bbv().ma(0).Q(iml).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bbx(), c.bbv().ma(0).Q(iml).yi("#4D000000").bbx()});
        ahC = new LayerDrawable(new Drawable[]{c.bbv().ma(0).Q(iml).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bbx(), c.bbv().ma(0).Q(iml).yi("#4D000000").bbx()});
        kjs = new LayerDrawable(new Drawable[]{c.bbv().ma(0).Q(iml).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bbx(), c.bbv().ma(0).Q(iml).yi("#4D000000").bbx()});
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
                ao.setViewTextColor(nVar.gJq, R.color.cp_cont_f, 1);
                if (nVar.klQ.getTag() instanceof Integer) {
                    ao.setBackgroundResource(nVar.klQ, ((Integer) nVar.klQ.getTag()).intValue());
                } else if (nVar.klQ.getTag() instanceof String) {
                    if (nVar.klQ.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = ahB;
                    } else if (nVar.klQ.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = ahC;
                    } else {
                        layerDrawable = nVar.klQ.getTag().equals("HOST") ? kjs : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(layerDrawable);
                    }
                }
                ao.setViewTextColor(nVar.klR, R.color.cp_cont_d, 1);
                ao.setViewTextColor(nVar.klS, R.color.cp_cont_d);
                ao.setViewTextColor(nVar.klT, R.color.cp_cont_d);
                ao.setViewTextColor(nVar.kmn, R.color.cp_cont_d, 1);
                ao.setViewTextColor(nVar.klU, R.color.cp_cont_d, 1);
                nVar.klX.setTextColor(ao.getColor(R.color.cp_cont_b));
                nVar.klY.onChangeSkinType();
                if (z) {
                    SvgManager.baR().a(nVar.kms, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.kmk, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.kmi, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ao.setViewTextColor(nVar.kmj, R.color.cp_cont_d);
                    ao.setViewTextColor(nVar.kml, R.color.cp_cont_d);
                }
                SvgManager.baR().a(nVar.kmd, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.baR().a(nVar.iER, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ao.setViewTextColor(nVar.kmb, R.color.cp_cont_c);
                    nVar.kmb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    ao.setViewTextColor(nVar.kmc, R.color.cp_cont_c);
                    ao.c(nVar.kma, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                    nVar.kma.onChangeSkinType();
                    ao.setViewTextColor(nVar.kmx, R.color.cp_link_tip_c, 1);
                    ao.setViewTextColor(nVar.kmv, R.color.cp_cont_f, 1);
                    ao.setBackgroundResource(nVar.kmu, R.color.cp_bg_line_e);
                    ao.setBackgroundResource(nVar.kmw, R.color.cp_cont_d);
                    ao.setImageResource(nVar.kmy, R.drawable.icon_arrow_more_gray);
                    ao.setViewTextColor(nVar.kmB, R.color.cp_cont_c);
                    if (nVar.kmz.getVisibility() == 8) {
                        nVar.kmb.setVisibility(8);
                        nVar.kmc.setVisibility(8);
                        nVar.kmB.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.cKI())) {
                        nVar.kmB.setText(fVar.cKI());
                    } else {
                        nVar.kmB.setText(R.string.expand_content);
                    }
                } else {
                    nVar.kma.setVisibility(8);
                    nVar.kmb.setVisibility(8);
                    nVar.kmc.setVisibility(8);
                    nVar.kmu.setVisibility(8);
                    nVar.kmB.setVisibility(8);
                }
                ao.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(n nVar, PostData postData, bv bvVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.aYc() != null) {
            if (bvVar != null) {
                postData.aYc().threadId = bvVar.getTid();
                postData.aYc().forumId = String.valueOf(bvVar.getFid());
            }
            if (i == 0) {
                postData.aYc().objType = 1;
            } else {
                postData.aYc().objType = 2;
            }
            postData.aYc().isInPost = true;
            if (z) {
                nVar.kmm.setAgreeAlone(true);
                nVar.kmm.setData(postData.aYc());
            }
            if (bvVar != null && bvVar.aUV()) {
                nVar.klV.setAgreeAlone(true);
            }
            nVar.klV.setData(postData.aYc());
        }
    }

    public static void a(n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.iER != null && postData != null) {
            if (z2) {
                nVar.iER.setVisibility(8);
                if (z) {
                    if (d.aRG()) {
                        string = postData.dlm() > 0 ? String.valueOf(postData.dlm()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.kml.setText(string);
                    return;
                }
                return;
            }
            nVar.iER.setVisibility(z ? 0 : 8);
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
    public static void a(n nVar, PostData postData, View view, int i, a aVar, bv bvVar, boolean z) {
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
            if (postData.aWl() == null || postData.aWl().isBaijiahaoUser()) {
            }
            if (postData.lNO) {
                ao.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (bvVar == null || bvVar.aWl() == null) {
                str = null;
            } else {
                str = bvVar.aWl().getUserId();
            }
            nVar.klW.setTag(null);
            nVar.klW.setUserId(null);
            nVar.gJq.setText((CharSequence) null);
            nVar.kmp.getHeadView().setUserId(null);
            nVar.klX.setIsHost(false);
            if (postData.aWl() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aWl().getUserId())) {
                    nVar.klX.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aWl().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aWl().getTShowInfoNew();
                if (nVar.kmr != null) {
                    nVar.kmr.setTag(R.id.tag_user_id, postData.aWl().getUserId());
                    nVar.kmr.setOnClickListener(aVar.cLE().kzZ);
                    nVar.kmr.a(iconInfo, 2, kjr, kjr, eTZ);
                }
                if (nVar.kmq != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kmq.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.kmq.setOnClickListener(aVar.cLE().kAa);
                    nVar.kmq.a(tShowInfoNew, 3, kjr, kjr, eTZ, true);
                }
                if (!x.isEmpty(tShowInfoNew) || postData.aWl().isBigV()) {
                    ao.setViewTextColor(nVar.gJq, R.color.cp_cont_h, 1);
                } else {
                    ao.setViewTextColor(nVar.gJq, R.color.cp_cont_f, 1);
                }
                String avater = postData.aWl().getAvater();
                nVar.gJq.setTag(R.id.tag_user_id, postData.aWl().getUserId());
                nVar.gJq.setTag(R.id.tag_user_name, postData.aWl().getUserName());
                nVar.gJq.setTag(R.id.tag_virtual_user_url, postData.aWl().getVirtualUserUrl());
                String name_show = postData.aWl().getName_show();
                String userName = postData.aWl().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gJq.setText(com.baidu.tieba.pb.c.aJ(aVar.getPageContext().getPageActivity(), nVar.gJq.getText().toString()));
                    nVar.gJq.setGravity(16);
                    nVar.gJq.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                    ao.setViewTextColor(nVar.gJq, R.color.cp_other_f, 1);
                }
                if (postData.aWl().getPendantData() != null && !StringUtils.isNull(postData.aWl().getPendantData().aUh())) {
                    nVar.kmp.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kmp.a(postData.aWl(), 4);
                    nVar.klW.setVisibility(8);
                    nVar.kmp.setVisibility(0);
                    nVar.kmp.getHeadView().startLoad(avater, 28, false);
                    nVar.kmp.getHeadView().setUserId(postData.aWl().getUserId());
                    nVar.kmp.getHeadView().setUserName(postData.aWl().getUserName());
                    nVar.kmp.yl(postData.aWl().getPendantData().aUh());
                } else {
                    nVar.klW.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.klW, postData.aWl(), 4);
                    nVar.klW.setUserId(postData.aWl().getUserId());
                    nVar.klW.setUserName(postData.aWl().getUserName(), postData.dls());
                    nVar.klW.setTag(R.id.tag_virtual_user_url, postData.aWl().getVirtualUserUrl());
                    nVar.klW.setImageDrawable(null);
                    nVar.klW.startLoad(avater, 28, false);
                    nVar.klW.setVisibility(0);
                    nVar.kmp.setVisibility(8);
                }
                if (bvVar != null && bvVar.aUV()) {
                    nVar.klQ.setVisibility(8);
                    nVar.klQ.setTag(null);
                } else if (postData.aWl() != null) {
                    MetaData aWl = postData.aWl();
                    int lL = postData.dla() ? R.drawable.brand_official_btn : ao.lL(R.drawable.bg_user_identity_btn);
                    int lL2 = postData.dla() ? R.color.cp_cont_a : ao.lL(R.color.cp_bg_line_d);
                    ao.setBackgroundResource(nVar.klQ, lL);
                    ao.setViewTextColor(nVar.klQ, lL2);
                    nVar.klQ.setTag(Integer.valueOf(lL));
                    if (str != null && !str.equals("0") && str.equals(aWl.getUserId())) {
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.host_name);
                        nVar.klQ.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (kjs != null && kjs.getDrawable(1) != null) {
                                kjs.getDrawable(1).setAlpha(255);
                            }
                        } else if (kjs != null && kjs.getDrawable(1) != null) {
                            kjs.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(kjs);
                    } else if (aWl.getIs_bawu() == 1 && postData.dla()) {
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.brand_Official);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aWl.getBawu_type())) {
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_member_bazhu_tip);
                        nVar.klQ.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ahB != null && ahB.getDrawable(1) != null) {
                                ahB.getDrawable(1).setAlpha(255);
                            }
                        } else if (ahB != null && ahB.getDrawable(1) != null) {
                            ahB.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(ahB);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aWl.getBawu_type())) {
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_member_xbazhu_tip);
                        nVar.klQ.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ahC != null && ahC.getDrawable(1) != null) {
                                ahC.getDrawable(1).setAlpha(255);
                            }
                        } else if (ahC != null && ahC.getDrawable(1) != null) {
                            ahC.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(ahC);
                    } else if (aWl.getIs_bawu() == 1 && "pri_content_assist".equals(aWl.getBawu_type())) {
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_content_assist_tip);
                    } else if (aWl.getIs_bawu() == 1 && "pri_manage_assist".equals(aWl.getBawu_type())) {
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.klQ.setVisibility(8);
                        nVar.klQ.setTag(null);
                    }
                } else {
                    nVar.klQ.setVisibility(8);
                    nVar.klQ.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cLF() && postData.aWl() != null) {
                i2 = postData.aWl().getLevel_id();
            }
            if (bvVar != null && bvVar.aUV()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.kmo.setVisibility(0);
                ao.setImageResource(nVar.kmo, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.kmo.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.kmr.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.kmr.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.klQ.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.kmq.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aWl() != null ? postData.aWl().getName_show() : "";
            int textLengthWithEmoji = ae.getTextLengthWithEmoji(name_show2);
            if (postData.aWl() != null && !StringUtils.isNull(postData.aWl().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ae.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ae.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aWl() != null && !StringUtils.isNull(postData.aWl().getSealPrefix())) {
                nVar.gJq.setText(a(aVar, postData.aWl().getSealPrefix(), name_show2));
            } else {
                nVar.gJq.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dli()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aWl() == null || StringUtils.isNull(postData.aWl().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (bvVar != null && aVar.cLH() != 0) {
                if (aVar.cLH() != 1002 && aVar.cLH() != 3) {
                    z9 = true;
                }
                if (aVar.cLH() != 3 && !bvVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.aWl() != null) {
                    String userId2 = postData.aWl().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (bvVar != null && bvVar.aWl() != null && postData.aWl() != null) {
                            userId = bvVar.aWl().getUserId();
                            String userId3 = postData.aWl().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.aWl() != null && UtilHelper.isCurrentAccount(postData.aWl().getUserId())) {
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
                                if (postData.dli() == 1) {
                                    i4 = 0;
                                }
                                if (bvVar != null && bvVar.aUV()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cLH()));
                                    if (postData.aWl() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aWl().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aWl().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aWl().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aWl() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aWl().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aWl().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aWl().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bvVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && bvVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cLH()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.klX.setTag(sparseArray);
                                if (z) {
                                    nVar.kms.setTag(sparseArray);
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
                        if (postData.dli() == 1) {
                        }
                        if (bvVar != null) {
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
                        nVar.klX.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (bvVar != null) {
                userId = bvVar.aWl().getUserId();
                String userId32 = postData.aWl().getUserId();
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
            if (postData.dli() == 1) {
            }
            if (bvVar != null) {
            }
            if (z3) {
            }
            if (z6) {
            }
            if (!z8) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            nVar.klX.setTag(sparseArray);
            if (z) {
            }
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
            tbRichTextView.getLayoutStrategy().oR(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eTU = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oS((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.klX.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.klX.AF(null);
                nVar.klX.setBackgroundDrawable(null);
                nVar.klX.getLayoutStrategy().oT(R.drawable.transparent_bg);
            } else {
                nVar.klX.getLayoutStrategy().oT(R.drawable.icon_click);
            }
            nVar.klX.getLayoutStrategy().oQ(R.drawable.pic_video);
            a(nVar.klX, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            nVar.klX.setLayoutParams(layoutParams);
            nVar.klX.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            nVar.klX.setIsFromCDN(z2);
            nVar.klX.setText(postData.dlk(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.klX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            nVar.klX.setTag(sparseArray);
            nVar.klP.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, n nVar, PostData postData, bv bvVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dli() > 0 && bvVar != null && !bvVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dli()));
                nVar.kmn.setVisibility(0);
                nVar.kmn.setText(format);
                z = true;
            } else {
                nVar.kmn.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dll = postData.dll();
            boolean z2 = (dll == null || StringUtils.isNull(dll.getName()) || bvVar == null || bvVar.isBjh()) ? false : true;
            if (z) {
                nVar.klS.setVisibility(0);
                i = aiP;
            } else {
                nVar.klS.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.klT.setVisibility(0);
                i2 = aiP;
            } else {
                nVar.klT.setVisibility(8);
                i2 = 0;
            }
            nVar.klR.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.klR.setText(as.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.klR.setText(as.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.klU.setVisibility(0);
                nVar.klU.setPadding(aiP, 0, 0, 0);
                nVar.klU.setText(dll.getName());
                return;
            }
            nVar.klU.setVisibility(8);
        }
    }

    public static void a(n nVar, PostData postData) {
        if (postData == null || postData.cSs() == null) {
            nVar.kmt.setVisibility(8);
            return;
        }
        TbRichText dlk = postData.dlk();
        com.baidu.tieba.pb.view.b.a(postData.cSs(), nVar.kmt, false, false, dlk != null && StringUtils.isNull(dlk.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.klX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.klX.setLayoutParams(layoutParams);
            nVar.klX.setPadding(0, 0, 0, 0);
            nVar.klX.AF(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.klX.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.klX.setLayoutParams(layoutParams2);
            nVar.klX.AF(postData.getBimg_url());
        }
        nVar.klX.setTextViewCheckSelection(false);
    }
}
