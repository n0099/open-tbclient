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
    private static LayerDrawable loZ;
    private static SparseArray<SoftReference<Drawable>> loW = new SparseArray<>();
    private static SparseIntArray loX = new SparseIntArray();
    public static final int ags = getDimensionPixelSize(R.dimen.tbds12);
    public static final int akY = getDimensionPixelSize(R.dimen.tbds16);
    public static final int loY = getDimensionPixelSize(R.dimen.tbds36);
    public static final int joZ = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = loX.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            loX.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void djt() {
        ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(joZ).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(joZ).Cm("#4D000000").brR()});
        ajF = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(joZ).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(joZ).Cm("#4D000000").brR()});
        loZ = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(joZ).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(joZ).Cm("#4D000000").brR()});
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
                ap.setViewTextColor(nVar.hGx, R.color.cp_cont_f, 1);
                if (nVar.lry.getTag() instanceof Integer) {
                    ap.setBackgroundResource(nVar.lry, ((Integer) nVar.lry.getTag()).intValue());
                } else if (nVar.lry.getTag() instanceof String) {
                    if (nVar.lry.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = ajE;
                    } else if (nVar.lry.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = ajF;
                    } else {
                        layerDrawable = nVar.lry.getTag().equals("HOST") ? loZ : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(layerDrawable);
                    }
                }
                ap.setViewTextColor(nVar.lrz, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.lrA, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.lrB, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.lrV, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.lrC, R.color.cp_cont_d, 1);
                nVar.lrF.setTextColor(ap.getColor(R.color.cp_cont_b));
                nVar.lrG.onChangeSkinType();
                if (z) {
                    SvgManager.brn().a(nVar.lsa, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(nVar.lrS, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(nVar.lrQ, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.lrR, R.color.cp_cont_d);
                    ap.setViewTextColor(nVar.lrT, R.color.cp_cont_d);
                }
                SvgManager.brn().a(nVar.lrL, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.brn().a(nVar.jJY, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.lrJ, R.color.cp_cont_c);
                    nVar.lrJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    ap.setViewTextColor(nVar.lrK, R.color.cp_cont_c);
                    ap.c(nVar.lrI, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                    nVar.lrI.onChangeSkinType();
                    ap.setViewTextColor(nVar.lsf, R.color.cp_link_tip_c, 1);
                    ap.setViewTextColor(nVar.lsd, R.color.cp_cont_f, 1);
                    ap.setBackgroundResource(nVar.lsc, R.color.cp_bg_line_e);
                    ap.setBackgroundResource(nVar.lse, R.color.cp_cont_d);
                    ap.setImageResource(nVar.lsg, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.lsj, R.color.cp_cont_c);
                    if (nVar.lsh.getVisibility() == 8) {
                        nVar.lrJ.setVisibility(8);
                        nVar.lrK.setVisibility(8);
                        nVar.lsj.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.div())) {
                        nVar.lsj.setText(fVar.div());
                    } else {
                        nVar.lsj.setText(R.string.expand_content);
                    }
                } else {
                    nVar.lrI.setVisibility(8);
                    nVar.lrJ.setVisibility(8);
                    nVar.lrK.setVisibility(8);
                    nVar.lsc.setVisibility(8);
                    nVar.lsj.setVisibility(8);
                }
                ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, bw bwVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.bor() != null) {
            if (bwVar != null) {
                postData.bor().threadId = bwVar.getTid();
                postData.bor().forumId = String.valueOf(bwVar.getFid());
            }
            if (i == 0) {
                postData.bor().objType = 1;
            } else {
                postData.bor().objType = 2;
            }
            postData.bor().isInPost = true;
            if (z) {
                nVar.lrU.setAgreeAlone(true);
                nVar.lrU.setData(postData.bor());
            }
            if (bwVar != null && bwVar.blk()) {
                nVar.lrD.setAgreeAlone(true);
            }
            nVar.lrD.setData(postData.bor());
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.jJY != null && postData != null) {
            if (z2) {
                nVar.jJY.setVisibility(8);
                if (z) {
                    if (d.bhM()) {
                        string = postData.dKd() > 0 ? String.valueOf(postData.dKd()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.lrT.setText(string);
                    return;
                }
                return;
            }
            nVar.jJY.setVisibility(z ? 0 : 8);
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
            if (postData.bmA() == null || postData.bmA().isBaijiahaoUser()) {
            }
            if (postData.mXC) {
                ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (bwVar == null || bwVar.bmA() == null) {
                str = null;
            } else {
                str = bwVar.bmA().getUserId();
            }
            nVar.lrE.setTag(null);
            nVar.lrE.setUserId(null);
            nVar.hGx.setText((CharSequence) null);
            nVar.lrX.getHeadView().setUserId(null);
            nVar.lrF.setIsHost(false);
            if (postData.bmA() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.bmA().getUserId())) {
                    nVar.lrF.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bmA().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bmA().getTShowInfoNew();
                if (nVar.lrZ != null) {
                    nVar.lrZ.setTag(R.id.tag_user_id, postData.bmA().getUserId());
                    nVar.lrZ.setOnClickListener(aVar.djp().lGa);
                    nVar.lrZ.a(iconInfo, 2, loY, loY, ags);
                }
                if (nVar.lrY != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lrY.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.lrY.setOnClickListener(aVar.djp().lGb);
                    nVar.lrY.a(tShowInfoNew, 3, loY, loY, ags, true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.bmA().isBigV()) {
                    ap.setViewTextColor(nVar.hGx, R.color.cp_cont_h, 1);
                } else {
                    ap.setViewTextColor(nVar.hGx, R.color.cp_cont_f, 1);
                }
                String avater = postData.bmA().getAvater();
                nVar.hGx.setTag(R.id.tag_user_id, postData.bmA().getUserId());
                nVar.hGx.setTag(R.id.tag_user_name, postData.bmA().getUserName());
                nVar.hGx.setTag(R.id.tag_virtual_user_url, postData.bmA().getVirtualUserUrl());
                String name_show = postData.bmA().getName_show();
                String userName = postData.bmA().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hGx.setText(c.aU(aVar.getPageContext().getPageActivity(), nVar.hGx.getText().toString()));
                    nVar.hGx.setGravity(16);
                    nVar.hGx.setTag(R.id.tag_nick_name_activity, c.dhU());
                    ap.setViewTextColor(nVar.hGx, R.color.cp_other_f, 1);
                }
                if (postData.bmA().getPendantData() != null && !StringUtils.isNull(postData.bmA().getPendantData().bkw())) {
                    nVar.lrX.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lrX.a(postData.bmA(), 4);
                    nVar.lrE.setVisibility(8);
                    nVar.lrX.setVisibility(0);
                    nVar.lrX.getHeadView().startLoad(avater, 28, false);
                    nVar.lrX.getHeadView().setUserId(postData.bmA().getUserId());
                    nVar.lrX.getHeadView().setUserName(postData.bmA().getUserName());
                    nVar.lrX.Cp(postData.bmA().getPendantData().bkw());
                } else {
                    nVar.lrE.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lrE, postData.bmA(), 4);
                    nVar.lrE.setUserId(postData.bmA().getUserId());
                    nVar.lrE.setUserName(postData.bmA().getUserName(), postData.dKj());
                    nVar.lrE.setTag(R.id.tag_virtual_user_url, postData.bmA().getVirtualUserUrl());
                    nVar.lrE.setImageDrawable(null);
                    nVar.lrE.startLoad(avater, 28, false);
                    nVar.lrE.setVisibility(0);
                    nVar.lrX.setVisibility(8);
                }
                if (bwVar != null && bwVar.blk()) {
                    nVar.lry.setVisibility(8);
                    nVar.lry.setTag(null);
                } else if (postData.bmA() != null) {
                    MetaData bmA = postData.bmA();
                    int oW = postData.dJR() ? R.drawable.brand_official_btn : ap.oW(R.drawable.bg_user_identity_btn);
                    int oW2 = postData.dJR() ? R.color.cp_cont_a : ap.oW(R.color.cp_bg_line_d);
                    ap.setBackgroundResource(nVar.lry, oW);
                    ap.setViewTextColor(nVar.lry, oW2);
                    nVar.lry.setTag(Integer.valueOf(oW));
                    if (str != null && !str.equals("0") && str.equals(bmA.getUserId())) {
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.host_name);
                        nVar.lry.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (loZ != null && loZ.getDrawable(1) != null) {
                                loZ.getDrawable(1).setAlpha(255);
                            }
                        } else if (loZ != null && loZ.getDrawable(1) != null) {
                            loZ.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(loZ);
                    } else if (bmA.getIs_bawu() == 1 && postData.dJR()) {
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.brand_Official);
                    } else if (bmA.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bmA.getBawu_type())) {
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_member_bazhu_tip);
                        nVar.lry.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajE != null && ajE.getDrawable(1) != null) {
                                ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajE != null && ajE.getDrawable(1) != null) {
                            ajE.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(ajE);
                    } else if (bmA.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bmA.getBawu_type())) {
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_member_xbazhu_tip);
                        nVar.lry.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (ajF != null && ajF.getDrawable(1) != null) {
                                ajF.getDrawable(1).setAlpha(255);
                            }
                        } else if (ajF != null && ajF.getDrawable(1) != null) {
                            ajF.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(ajF);
                    } else if (bmA.getIs_bawu() == 1 && "pri_content_assist".equals(bmA.getBawu_type())) {
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_content_assist_tip);
                    } else if (bmA.getIs_bawu() == 1 && "pri_manage_assist".equals(bmA.getBawu_type())) {
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.lry.setVisibility(8);
                        nVar.lry.setTag(null);
                    }
                } else {
                    nVar.lry.setVisibility(8);
                    nVar.lry.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.djq() && postData.bmA() != null) {
                i2 = postData.bmA().getLevel_id();
            }
            if (bwVar != null && bwVar.blk()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.lrW.setVisibility(0);
                ap.setImageResource(nVar.lrW, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.lrW.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.lrZ.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.lrZ.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.lry.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.lrY.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.bmA() != null ? postData.bmA().getName_show() : "";
            int textLengthWithEmoji = af.getTextLengthWithEmoji(name_show2);
            if (postData.bmA() != null && !StringUtils.isNull(postData.bmA().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = af.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = af.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.bmA() != null && !StringUtils.isNull(postData.bmA().getSealPrefix())) {
                nVar.hGx.setText(a(aVar, postData.bmA().getSealPrefix(), name_show2));
            } else {
                nVar.hGx.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dJZ()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.bmA() == null || StringUtils.isNull(postData.bmA().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (bwVar != null && aVar.djs() != 0) {
                if (aVar.djs() != 1002 && aVar.djs() != 3) {
                    z9 = true;
                }
                if (aVar.djs() != 3 && !bwVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.bmA() != null) {
                    String userId2 = postData.bmA().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (bwVar != null && bwVar.bmA() != null && postData.bmA() != null) {
                            userId = bwVar.bmA().getUserId();
                            String userId3 = postData.bmA().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.bmA() != null && UtilHelper.isCurrentAccount(postData.bmA().getUserId())) {
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
                                if (postData.dJZ() == 1) {
                                    i4 = 0;
                                }
                                if (bwVar != null && bwVar.blk()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.djs()));
                                    if (postData.bmA() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bmA().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bmA().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bmA().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bmA() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bmA().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bmA().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bmA().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bwVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && bwVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.djs()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lrF.setTag(sparseArray);
                                if (z) {
                                    nVar.lsa.setTag(sparseArray);
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
                        if (postData.dJZ() == 1) {
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
                        nVar.lrF.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (bwVar != null) {
                userId = bwVar.bmA().getUserId();
                String userId32 = postData.bmA().getUserId();
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
            if (postData.dJZ() == 1) {
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
            nVar.lrF.setTag(sparseArray);
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
                tbRichTextView.getLayoutStrategy().sn(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().sn(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fHZ = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (z2) {
                tbRichTextView.getLayoutStrategy().so((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().so((int) (equipmentWidth * 1.618f));
            }
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, boolean z4, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.lrF.EK(null);
                nVar.lrF.setBackgroundDrawable(null);
                nVar.lrF.getLayoutStrategy().sp(R.drawable.transparent_bg);
            } else {
                nVar.lrF.getLayoutStrategy().sp(R.drawable.icon_click);
            }
            nVar.lrF.getLayoutStrategy().sm(R.drawable.pic_video);
            a(nVar.lrF, view, StringUtils.isNull(postData.getBimg_url()) ? false : true, z2);
            nVar.lrF.setLayoutParams(layoutParams);
            nVar.lrF.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            nVar.lrF.setIsFromCDN(z3);
            nVar.lrF.setText(postData.dKb(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.lrF.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z4));
            nVar.lrF.setTag(sparseArray);
            nVar.lrx.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, bw bwVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dJZ() > 0 && bwVar != null && !bwVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dJZ()));
                nVar.lrV.setVisibility(0);
                nVar.lrV.setText(format);
                z = true;
            } else {
                nVar.lrV.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dKc = postData.dKc();
            boolean z2 = (dKc == null || StringUtils.isNull(dKc.getName()) || bwVar == null || bwVar.isBjh()) ? false : true;
            if (z) {
                nVar.lrA.setVisibility(0);
                i = akY;
            } else {
                nVar.lrA.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lrB.setVisibility(0);
                i2 = akY;
            } else {
                nVar.lrB.setVisibility(8);
                i2 = 0;
            }
            nVar.lrz.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lrz.setText(at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lrz.setText(at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lrC.setVisibility(0);
                nVar.lrC.setPadding(akY, 0, 0, 0);
                nVar.lrC.setText(dKc.getName());
                return;
            }
            nVar.lrC.setVisibility(8);
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData) {
        if (postData == null || postData.dqh() == null) {
            nVar.lsb.setVisibility(8);
            return;
        }
        TbRichText dKb = postData.dKb();
        com.baidu.tieba.pb.view.b.a(postData.dqh(), nVar.lsb, false, false, dKb != null && StringUtils.isNull(dKb.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrF.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lrF.setLayoutParams(layoutParams);
            nVar.lrF.setPadding(0, 0, 0, 0);
            nVar.lrF.EK(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lrF.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lrF.setLayoutParams(layoutParams2);
            nVar.lrF.EK(postData.getBimg_url());
        }
        nVar.lrF.setTextViewCheckSelection(false);
    }
}
