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
import com.baidu.tbadk.util.ae;
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
/* loaded from: classes16.dex */
public class b {
    private static LayerDrawable aiR;
    private static LayerDrawable aiS;
    private static LayerDrawable kyR;
    private static SparseArray<SoftReference<Drawable>> kyO = new SparseArray<>();
    private static SparseIntArray kyP = new SparseIntArray();
    public static final int feK = getDimensionPixelSize(R.dimen.tbds12);
    public static final int akg = getDimensionPixelSize(R.dimen.tbds16);
    public static final int kyQ = getDimensionPixelSize(R.dimen.tbds36);
    public static final int iAt = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = kyP.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            kyP.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cWx() {
        aiR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(iAt).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(iAt).Ax("#4D000000").bjT()});
        aiS = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(iAt).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(iAt).Ax("#4D000000").bjT()});
        kyR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(iAt).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(iAt).Ax("#4D000000").bjT()});
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
                ap.setViewTextColor(nVar.gVX, R.color.cp_cont_f, 1);
                if (nVar.kBp.getTag() instanceof Integer) {
                    ap.setBackgroundResource(nVar.kBp, ((Integer) nVar.kBp.getTag()).intValue());
                } else if (nVar.kBp.getTag() instanceof String) {
                    if (nVar.kBp.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = aiR;
                    } else if (nVar.kBp.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = aiS;
                    } else {
                        layerDrawable = nVar.kBp.getTag().equals("HOST") ? kyR : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(layerDrawable);
                    }
                }
                ap.setViewTextColor(nVar.kBq, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.kBr, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.kBs, R.color.cp_cont_d);
                ap.setViewTextColor(nVar.kBM, R.color.cp_cont_d, 1);
                ap.setViewTextColor(nVar.kBt, R.color.cp_cont_d, 1);
                nVar.kBw.setTextColor(ap.getColor(R.color.cp_cont_b));
                nVar.kBx.onChangeSkinType();
                if (z) {
                    SvgManager.bjq().a(nVar.kBR, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.kBJ, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.kBH, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.kBI, R.color.cp_cont_d);
                    ap.setViewTextColor(nVar.kBK, R.color.cp_cont_d);
                }
                SvgManager.bjq().a(nVar.kBC, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(nVar.iTV, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.kBA, R.color.cp_cont_c);
                    nVar.kBA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    ap.setViewTextColor(nVar.kBB, R.color.cp_cont_c);
                    ap.c(nVar.kBz, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                    nVar.kBz.onChangeSkinType();
                    ap.setViewTextColor(nVar.kBW, R.color.cp_link_tip_c, 1);
                    ap.setViewTextColor(nVar.kBU, R.color.cp_cont_f, 1);
                    ap.setBackgroundResource(nVar.kBT, R.color.cp_bg_line_e);
                    ap.setBackgroundResource(nVar.kBV, R.color.cp_cont_d);
                    ap.setImageResource(nVar.kBX, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.kCa, R.color.cp_cont_c);
                    if (nVar.kBY.getVisibility() == 8) {
                        nVar.kBA.setVisibility(8);
                        nVar.kBB.setVisibility(8);
                        nVar.kCa.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.cVx())) {
                        nVar.kCa.setText(fVar.cVx());
                    } else {
                        nVar.kCa.setText(R.string.expand_content);
                    }
                } else {
                    nVar.kBz.setVisibility(8);
                    nVar.kBA.setVisibility(8);
                    nVar.kBB.setVisibility(8);
                    nVar.kBT.setVisibility(8);
                    nVar.kCa.setVisibility(8);
                }
                ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(n nVar, PostData postData, bw bwVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.bgv() != null) {
            if (bwVar != null) {
                postData.bgv().threadId = bwVar.getTid();
                postData.bgv().forumId = String.valueOf(bwVar.getFid());
            }
            if (i == 0) {
                postData.bgv().objType = 1;
            } else {
                postData.bgv().objType = 2;
            }
            postData.bgv().isInPost = true;
            if (z) {
                nVar.kBL.setAgreeAlone(true);
                nVar.kBL.setData(postData.bgv());
            }
            if (bwVar != null && bwVar.bdo()) {
                nVar.kBu.setAgreeAlone(true);
            }
            nVar.kBu.setData(postData.bgv());
        }
    }

    public static void a(n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.iTV != null && postData != null) {
            if (z2) {
                nVar.iTV.setVisibility(8);
                if (z) {
                    if (d.aZW()) {
                        string = postData.dwO() > 0 ? String.valueOf(postData.dwO()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.kBK.setText(string);
                    return;
                }
                return;
            }
            nVar.iTV.setVisibility(z ? 0 : 8);
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
            if (postData.beE() == null || postData.beE().isBaijiahaoUser()) {
            }
            if (postData.mfN) {
                ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (bwVar == null || bwVar.beE() == null) {
                str = null;
            } else {
                str = bwVar.beE().getUserId();
            }
            nVar.kBv.setTag(null);
            nVar.kBv.setUserId(null);
            nVar.gVX.setText((CharSequence) null);
            nVar.kBO.getHeadView().setUserId(null);
            nVar.kBw.setIsHost(false);
            if (postData.beE() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.beE().getUserId())) {
                    nVar.kBw.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.beE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.beE().getTShowInfoNew();
                if (nVar.kBQ != null) {
                    nVar.kBQ.setTag(R.id.tag_user_id, postData.beE().getUserId());
                    nVar.kBQ.setOnClickListener(aVar.cWt().kPL);
                    nVar.kBQ.a(iconInfo, 2, kyQ, kyQ, feK);
                }
                if (nVar.kBP != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kBP.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.kBP.setOnClickListener(aVar.cWt().kPM);
                    nVar.kBP.a(tShowInfoNew, 3, kyQ, kyQ, feK, true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.beE().isBigV()) {
                    ap.setViewTextColor(nVar.gVX, R.color.cp_cont_h, 1);
                } else {
                    ap.setViewTextColor(nVar.gVX, R.color.cp_cont_f, 1);
                }
                String avater = postData.beE().getAvater();
                nVar.gVX.setTag(R.id.tag_user_id, postData.beE().getUserId());
                nVar.gVX.setTag(R.id.tag_user_name, postData.beE().getUserName());
                nVar.gVX.setTag(R.id.tag_virtual_user_url, postData.beE().getVirtualUserUrl());
                String name_show = postData.beE().getName_show();
                String userName = postData.beE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gVX.setText(c.aN(aVar.getPageContext().getPageActivity(), nVar.gVX.getText().toString()));
                    nVar.gVX.setGravity(16);
                    nVar.gVX.setTag(R.id.tag_nick_name_activity, c.cUW());
                    ap.setViewTextColor(nVar.gVX, R.color.cp_other_f, 1);
                }
                if (postData.beE().getPendantData() != null && !StringUtils.isNull(postData.beE().getPendantData().bcA())) {
                    nVar.kBO.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kBO.a(postData.beE(), 4);
                    nVar.kBv.setVisibility(8);
                    nVar.kBO.setVisibility(0);
                    nVar.kBO.getHeadView().startLoad(avater, 28, false);
                    nVar.kBO.getHeadView().setUserId(postData.beE().getUserId());
                    nVar.kBO.getHeadView().setUserName(postData.beE().getUserName());
                    nVar.kBO.AA(postData.beE().getPendantData().bcA());
                } else {
                    nVar.kBv.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.kBv, postData.beE(), 4);
                    nVar.kBv.setUserId(postData.beE().getUserId());
                    nVar.kBv.setUserName(postData.beE().getUserName(), postData.dwU());
                    nVar.kBv.setTag(R.id.tag_virtual_user_url, postData.beE().getVirtualUserUrl());
                    nVar.kBv.setImageDrawable(null);
                    nVar.kBv.startLoad(avater, 28, false);
                    nVar.kBv.setVisibility(0);
                    nVar.kBO.setVisibility(8);
                }
                if (bwVar != null && bwVar.bdo()) {
                    nVar.kBp.setVisibility(8);
                    nVar.kBp.setTag(null);
                } else if (postData.beE() != null) {
                    MetaData beE = postData.beE();
                    int nS = postData.dwC() ? R.drawable.brand_official_btn : ap.nS(R.drawable.bg_user_identity_btn);
                    int nS2 = postData.dwC() ? R.color.cp_cont_a : ap.nS(R.color.cp_bg_line_d);
                    ap.setBackgroundResource(nVar.kBp, nS);
                    ap.setViewTextColor(nVar.kBp, nS2);
                    nVar.kBp.setTag(Integer.valueOf(nS));
                    if (str != null && !str.equals("0") && str.equals(beE.getUserId())) {
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.host_name);
                        nVar.kBp.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (kyR != null && kyR.getDrawable(1) != null) {
                                kyR.getDrawable(1).setAlpha(255);
                            }
                        } else if (kyR != null && kyR.getDrawable(1) != null) {
                            kyR.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(kyR);
                    } else if (beE.getIs_bawu() == 1 && postData.dwC()) {
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.brand_Official);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_member_bazhu_tip);
                        nVar.kBp.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (aiR != null && aiR.getDrawable(1) != null) {
                                aiR.getDrawable(1).setAlpha(255);
                            }
                        } else if (aiR != null && aiR.getDrawable(1) != null) {
                            aiR.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(aiR);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_member_xbazhu_tip);
                        nVar.kBp.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (aiS != null && aiS.getDrawable(1) != null) {
                                aiS.getDrawable(1).setAlpha(255);
                            }
                        } else if (aiS != null && aiS.getDrawable(1) != null) {
                            aiS.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(aiS);
                    } else if (beE.getIs_bawu() == 1 && "pri_content_assist".equals(beE.getBawu_type())) {
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_content_assist_tip);
                    } else if (beE.getIs_bawu() == 1 && "pri_manage_assist".equals(beE.getBawu_type())) {
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.kBp.setVisibility(8);
                        nVar.kBp.setTag(null);
                    }
                } else {
                    nVar.kBp.setVisibility(8);
                    nVar.kBp.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cWu() && postData.beE() != null) {
                i2 = postData.beE().getLevel_id();
            }
            if (bwVar != null && bwVar.bdo()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.kBN.setVisibility(0);
                ap.setImageResource(nVar.kBN, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.kBN.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.kBQ.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.kBQ.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.kBp.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.kBP.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.beE() != null ? postData.beE().getName_show() : "";
            int textLengthWithEmoji = ae.getTextLengthWithEmoji(name_show2);
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ae.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ae.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getSealPrefix())) {
                nVar.gVX.setText(a(aVar, postData.beE().getSealPrefix(), name_show2));
            } else {
                nVar.gVX.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dwK()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.beE() == null || StringUtils.isNull(postData.beE().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (bwVar != null && aVar.cWw() != 0) {
                if (aVar.cWw() != 1002 && aVar.cWw() != 3) {
                    z9 = true;
                }
                if (aVar.cWw() != 3 && !bwVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.beE() != null) {
                    String userId2 = postData.beE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (bwVar != null && bwVar.beE() != null && postData.beE() != null) {
                            userId = bwVar.beE().getUserId();
                            String userId3 = postData.beE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.beE() != null && UtilHelper.isCurrentAccount(postData.beE().getUserId())) {
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
                                if (postData.dwK() == 1) {
                                    i4 = 0;
                                }
                                if (bwVar != null && bwVar.bdo()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cWw()));
                                    if (postData.beE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.beE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.beE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.beE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.beE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.beE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.beE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.beE().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bwVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && bwVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cWw()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.kBw.setTag(sparseArray);
                                if (z) {
                                    nVar.kBR.setTag(sparseArray);
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
                        if (postData.dwK() == 1) {
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
                        nVar.kBw.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (bwVar != null) {
                userId = bwVar.beE().getUserId();
                String userId32 = postData.beE().getUserId();
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
            if (postData.dwK() == 1) {
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
            nVar.kBw.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().rd(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().feF = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().re((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBw.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.kBw.CV(null);
                nVar.kBw.setBackgroundDrawable(null);
                nVar.kBw.getLayoutStrategy().rf(R.drawable.transparent_bg);
            } else {
                nVar.kBw.getLayoutStrategy().rf(R.drawable.icon_click);
            }
            nVar.kBw.getLayoutStrategy().rc(R.drawable.pic_video);
            a(nVar.kBw, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            nVar.kBw.setLayoutParams(layoutParams);
            nVar.kBw.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            nVar.kBw.setIsFromCDN(z2);
            nVar.kBw.setText(postData.dwM(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.kBw.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            nVar.kBw.setTag(sparseArray);
            nVar.kBo.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, n nVar, PostData postData, bw bwVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dwK() > 0 && bwVar != null && !bwVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dwK()));
                nVar.kBM.setVisibility(0);
                nVar.kBM.setText(format);
                z = true;
            } else {
                nVar.kBM.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dwN = postData.dwN();
            boolean z2 = (dwN == null || StringUtils.isNull(dwN.getName()) || bwVar == null || bwVar.isBjh()) ? false : true;
            if (z) {
                nVar.kBr.setVisibility(0);
                i = akg;
            } else {
                nVar.kBr.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.kBs.setVisibility(0);
                i2 = akg;
            } else {
                nVar.kBs.setVisibility(8);
                i2 = 0;
            }
            nVar.kBq.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.kBq.setText(at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.kBq.setText(at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.kBt.setVisibility(0);
                nVar.kBt.setPadding(akg, 0, 0, 0);
                nVar.kBt.setText(dwN.getName());
                return;
            }
            nVar.kBt.setVisibility(8);
        }
    }

    public static void a(n nVar, PostData postData) {
        if (postData == null || postData.ddk() == null) {
            nVar.kBS.setVisibility(8);
            return;
        }
        TbRichText dwM = postData.dwM();
        com.baidu.tieba.pb.view.b.a(postData.ddk(), nVar.kBS, false, false, dwM != null && StringUtils.isNull(dwM.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.kBw.setLayoutParams(layoutParams);
            nVar.kBw.setPadding(0, 0, 0, 0);
            nVar.kBw.CV(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kBw.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.kBw.setLayoutParams(layoutParams2);
            nVar.kBw.CV(postData.getBimg_url());
        }
        nVar.kBw.setTextViewCheckSelection(false);
    }
}
