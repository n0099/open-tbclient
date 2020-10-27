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
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes22.dex */
public class b {
    private static LayerDrawable ajE;
    private static LayerDrawable ajF;
    private static LayerDrawable liY;
    private static SparseArray<SoftReference<Drawable>> liV = new SparseArray<>();
    private static SparseIntArray liW = new SparseIntArray();
    public static final int ags = getDimensionPixelSize(R.dimen.tbds12);
    public static final int akY = getDimensionPixelSize(R.dimen.tbds16);
    public static final int liX = getDimensionPixelSize(R.dimen.tbds36);
    public static final int jjb = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = liW.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            liW.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void dgR() {
        ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(jjb).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(jjb).BY("#4D000000").bpr()});
        ajF = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(jjb).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(jjb).BY("#4D000000").bpr()});
        liY = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(jjb).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(jjb).BY("#4D000000").bpr()});
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

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, f fVar, boolean z) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            if (nVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ap.setViewTextColor(nVar.hAA, R.color.cp_cont_f, 1);
                if (nVar.llx.getTag() instanceof Integer) {
                    ap.setBackgroundResource(nVar.llx, ((Integer) nVar.llx.getTag()).intValue());
                } else if (nVar.llx.getTag() instanceof String) {
                    if (nVar.llx.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = ajE;
                    } else if (nVar.llx.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = ajF;
                    } else {
                        layerDrawable = nVar.llx.getTag().equals("HOST") ? liY : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(layerDrawable);
                    }
                }
                ap.setViewTextColor(nVar.lly, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.llz, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.llA, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.llU, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.llB, R.color.cp_cont_d, 1);
                nVar.llE.setTextColor(ap.getColor(R.color.cp_cont_b));
                nVar.llF.onChangeSkinType();
                if (z) {
                    SvgManager.boN().a(nVar.llZ, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(nVar.llR, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(nVar.llP, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.llQ, R.color.cp_cont_d);
                    ap.setViewTextColor(nVar.llS, R.color.cp_cont_d);
                }
                SvgManager.boN().a(nVar.llK, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.boN().a(nVar.jEa, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.llI, R.color.cp_cont_c);
                    nVar.llI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    ap.setViewTextColor(nVar.llJ, R.color.cp_cont_c);
                    ap.c(nVar.llH, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                    nVar.llH.onChangeSkinType();
                    ap.setViewTextColor(nVar.lme, R.color.cp_link_tip_c, 1);
                    ap.setViewTextColor(nVar.lmc, R.color.cp_cont_f, 1);
                    ap.setBackgroundResource(nVar.lmb, R.color.cp_bg_line_e);
                    ap.setBackgroundResource(nVar.lmd, R.color.cp_cont_d);
                    ap.setImageResource(nVar.lmf, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.lmi, R.color.cp_cont_c);
                    if (nVar.lmg.getVisibility() == 8) {
                        nVar.llI.setVisibility(8);
                        nVar.llJ.setVisibility(8);
                        nVar.lmi.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dfT())) {
                        nVar.lmi.setText(fVar.dfT());
                    } else {
                        nVar.lmi.setText(R.string.expand_content);
                    }
                } else {
                    nVar.llH.setVisibility(8);
                    nVar.llI.setVisibility(8);
                    nVar.llJ.setVisibility(8);
                    nVar.lmb.setVisibility(8);
                    nVar.lmi.setVisibility(8);
                }
                ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, bw bwVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.blR() != null) {
            if (bwVar != null) {
                postData.blR().threadId = bwVar.getTid();
                postData.blR().forumId = String.valueOf(bwVar.getFid());
            }
            if (i == 0) {
                postData.blR().objType = 1;
            } else {
                postData.blR().objType = 2;
            }
            postData.blR().isInPost = true;
            if (z) {
                nVar.llT.setAgreeAlone(true);
                nVar.llT.setData(postData.blR());
            }
            if (bwVar != null && bwVar.biK()) {
                nVar.llC.setAgreeAlone(true);
            }
            nVar.llC.setData(postData.blR());
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.jEa != null && postData != null) {
            if (z2) {
                nVar.jEa.setVisibility(8);
                if (z) {
                    if (d.bfm()) {
                        string = postData.dHB() > 0 ? String.valueOf(postData.dHB()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.llS.setText(string);
                    return;
                }
                return;
            }
            nVar.jEa.setVisibility(z ? 0 : 8);
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
    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, View view, int i, a aVar, bw bwVar, boolean z) {
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
            if (postData.bka() == null || postData.bka().isBaijiahaoUser()) {
            }
            if (postData.mRz) {
                ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (bwVar == null || bwVar.bka() == null) {
                str = null;
            } else {
                str = bwVar.bka().getUserId();
            }
            nVar.llD.setTag(null);
            nVar.llD.setUserId(null);
            nVar.hAA.setText((CharSequence) null);
            nVar.llW.getHeadView().setUserId(null);
            nVar.llE.setIsHost(false);
            if (postData.bka() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.bka().getUserId())) {
                    nVar.llE.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bka().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bka().getTShowInfoNew();
                if (nVar.llY != null) {
                    nVar.llY.setTag(R.id.tag_user_id, postData.bka().getUserId());
                    nVar.llY.setOnClickListener(aVar.dgN().lAe);
                    nVar.llY.a(iconInfo, 2, liX, liX, ags);
                }
                if (nVar.llX != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.llX.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.llX.setOnClickListener(aVar.dgN().lAf);
                    nVar.llX.a(tShowInfoNew, 3, liX, liX, ags, true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.bka().isBigV()) {
                    ap.setViewTextColor(nVar.hAA, R.color.cp_cont_h, 1);
                } else {
                    ap.setViewTextColor(nVar.hAA, R.color.cp_cont_f, 1);
                }
                String avater = postData.bka().getAvater();
                nVar.hAA.setTag(R.id.tag_user_id, postData.bka().getUserId());
                nVar.hAA.setTag(R.id.tag_user_name, postData.bka().getUserName());
                nVar.hAA.setTag(R.id.tag_virtual_user_url, postData.bka().getVirtualUserUrl());
                String name_show = postData.bka().getName_show();
                String userName = postData.bka().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hAA.setText(c.aU(aVar.getPageContext().getPageActivity(), nVar.hAA.getText().toString()));
                    nVar.hAA.setGravity(16);
                    nVar.hAA.setTag(R.id.tag_nick_name_activity, c.dfs());
                    ap.setViewTextColor(nVar.hAA, R.color.cp_other_f, 1);
                }
                if (postData.bka().getPendantData() != null && !StringUtils.isNull(postData.bka().getPendantData().bhW())) {
                    nVar.llW.setBigVDimenSize(R.dimen.tbds32);
                    nVar.llW.a(postData.bka(), 4);
                    nVar.llD.setVisibility(8);
                    nVar.llW.setVisibility(0);
                    nVar.llW.getHeadView().startLoad(avater, 28, false);
                    nVar.llW.getHeadView().setUserId(postData.bka().getUserId());
                    nVar.llW.getHeadView().setUserName(postData.bka().getUserName());
                    nVar.llW.Cb(postData.bka().getPendantData().bhW());
                } else {
                    nVar.llD.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.llD, postData.bka(), 4);
                    nVar.llD.setUserId(postData.bka().getUserId());
                    nVar.llD.setUserName(postData.bka().getUserName(), postData.dHH());
                    nVar.llD.setTag(R.id.tag_virtual_user_url, postData.bka().getVirtualUserUrl());
                    nVar.llD.setImageDrawable(null);
                    nVar.llD.startLoad(avater, 28, false);
                    nVar.llD.setVisibility(0);
                    nVar.llW.setVisibility(8);
                }
                if (bwVar != null && bwVar.biK()) {
                    nVar.llx.setVisibility(8);
                    nVar.llx.setTag(null);
                } else if (postData.bka() != null) {
                    MetaData bka = postData.bka();
                    int oM = postData.dHp() ? R.drawable.brand_official_btn : ap.oM(R.drawable.bg_user_identity_btn);
                    int oM2 = postData.dHp() ? R.color.cp_cont_a : ap.oM(R.color.cp_bg_line_d);
                    ap.setBackgroundResource(nVar.llx, oM);
                    ap.setViewTextColor(nVar.llx, oM2);
                    nVar.llx.setTag(Integer.valueOf(oM));
                    if (str != null && !str.equals("0") && str.equals(bka.getUserId())) {
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.host_name);
                        nVar.llx.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (liY != null && liY.getDrawable(1) != null) {
                                liY.getDrawable(1).setAlpha(255);
                            }
                        } else if (liY != null && liY.getDrawable(1) != null) {
                            liY.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(liY);
                    } else if (bka.getIs_bawu() == 1 && postData.dHp()) {
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.brand_Official);
                    } else if (bka.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bka.getBawu_type())) {
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_member_bazhu_tip);
                        nVar.llx.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajE != null && ajE.getDrawable(1) != null) {
                                ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajE != null && ajE.getDrawable(1) != null) {
                            ajE.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(ajE);
                    } else if (bka.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bka.getBawu_type())) {
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_member_xbazhu_tip);
                        nVar.llx.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajF != null && ajF.getDrawable(1) != null) {
                                ajF.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajF != null && ajF.getDrawable(1) != null) {
                            ajF.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(ajF);
                    } else if (bka.getIs_bawu() == 1 && "pri_content_assist".equals(bka.getBawu_type())) {
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_content_assist_tip);
                    } else if (bka.getIs_bawu() == 1 && "pri_manage_assist".equals(bka.getBawu_type())) {
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.llx.setVisibility(8);
                        nVar.llx.setTag(null);
                    }
                } else {
                    nVar.llx.setVisibility(8);
                    nVar.llx.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.dgO() && postData.bka() != null) {
                i2 = postData.bka().getLevel_id();
            }
            if (bwVar != null && bwVar.biK()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.llV.setVisibility(0);
                ap.setImageResource(nVar.llV, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.llV.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.llY.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.llY.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.llx.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.llX.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.bka() != null ? postData.bka().getName_show() : "";
            int textLengthWithEmoji = af.getTextLengthWithEmoji(name_show2);
            if (postData.bka() != null && !StringUtils.isNull(postData.bka().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = af.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = af.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.bka() != null && !StringUtils.isNull(postData.bka().getSealPrefix())) {
                nVar.hAA.setText(a(aVar, postData.bka().getSealPrefix(), name_show2));
            } else {
                nVar.hAA.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dHx()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.bka() == null || StringUtils.isNull(postData.bka().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (bwVar != null && aVar.dgQ() != 0) {
                if (aVar.dgQ() != 1002 && aVar.dgQ() != 3) {
                    z9 = true;
                }
                if (aVar.dgQ() != 3 && !bwVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.bka() != null) {
                    String userId2 = postData.bka().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (bwVar != null && bwVar.bka() != null && postData.bka() != null) {
                            userId = bwVar.bka().getUserId();
                            String userId3 = postData.bka().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.bka() != null && UtilHelper.isCurrentAccount(postData.bka().getUserId())) {
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
                                if (postData.dHx() == 1) {
                                    i4 = 0;
                                }
                                if (bwVar != null && bwVar.biK()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dgQ()));
                                    if (postData.bka() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bka().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bka().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bka().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bka() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bka().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bka().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bka().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bwVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && bwVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dgQ()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.llE.setTag(sparseArray);
                                if (z) {
                                    nVar.llZ.setTag(sparseArray);
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
                        if (postData.dHx() == 1) {
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
                        nVar.llE.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (bwVar != null) {
                userId = bwVar.bka().getUserId();
                String userId32 = postData.bka().getUserId();
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
            if (postData.dHx() == 1) {
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
            nVar.llE.setTag(sparseArray);
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
                tbRichTextView.getLayoutStrategy().sd(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().sd(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fCj = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (z2) {
                tbRichTextView.getLayoutStrategy().se((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().se((int) (equipmentWidth * 1.618f));
            }
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, boolean z4, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.llE.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.llE.Ew(null);
                nVar.llE.setBackgroundDrawable(null);
                nVar.llE.getLayoutStrategy().sf(R.drawable.transparent_bg);
            } else {
                nVar.llE.getLayoutStrategy().sf(R.drawable.icon_click);
            }
            nVar.llE.getLayoutStrategy().sc(R.drawable.pic_video);
            a(nVar.llE, view, StringUtils.isNull(postData.getBimg_url()) ? false : true, z2);
            nVar.llE.setLayoutParams(layoutParams);
            nVar.llE.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            nVar.llE.setIsFromCDN(z3);
            nVar.llE.setText(postData.dHz(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.llE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z4));
            nVar.llE.setTag(sparseArray);
            nVar.llw.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, bw bwVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dHx() > 0 && bwVar != null && !bwVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dHx()));
                nVar.llU.setVisibility(0);
                nVar.llU.setText(format);
                z = true;
            } else {
                nVar.llU.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dHA = postData.dHA();
            boolean z2 = (dHA == null || StringUtils.isNull(dHA.getName()) || bwVar == null || bwVar.isBjh()) ? false : true;
            if (z) {
                nVar.llz.setVisibility(0);
                i = akY;
            } else {
                nVar.llz.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.llA.setVisibility(0);
                i2 = akY;
            } else {
                nVar.llA.setVisibility(8);
                i2 = 0;
            }
            nVar.lly.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lly.setText(at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lly.setText(at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.llB.setVisibility(0);
                nVar.llB.setPadding(akY, 0, 0, 0);
                nVar.llB.setText(dHA.getName());
                return;
            }
            nVar.llB.setVisibility(8);
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData) {
        if (postData == null || postData.dnF() == null) {
            nVar.lma.setVisibility(8);
            return;
        }
        TbRichText dHz = postData.dHz();
        com.baidu.tieba.pb.view.b.a(postData.dnF(), nVar.lma, false, false, dHz != null && StringUtils.isNull(dHz.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.llE.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.llE.setLayoutParams(layoutParams);
            nVar.llE.setPadding(0, 0, 0, 0);
            nVar.llE.Ew(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.llE.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.llE.setLayoutParams(layoutParams2);
            nVar.llE.Ew(postData.getBimg_url());
        }
        nVar.llE.setTextViewCheckSelection(false);
    }
}
