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
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class b {
    private static LayerDrawable Nv;
    private static LayerDrawable Nw;
    private static LayerDrawable iFc;
    private static SparseArray<SoftReference<Drawable>> iEY = new SparseArray<>();
    private static SparseIntArray iEZ = new SparseIntArray();
    public static final int dOI = getDimensionPixelSize(R.dimen.tbds12);
    public static final int iFa = getDimensionPixelSize(R.dimen.tbds16);
    public static final int iFb = getDimensionPixelSize(R.dimen.tbds40);
    public static final int aqT = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = iEZ.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            iEZ.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void clQ() {
        Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(aqT).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(aqT).tM("#4D000000").aHi()});
        Nw = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(aqT).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(aqT).tM("#4D000000").aHi()});
        iFc = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(aqT).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(aqT).tM("#4D000000").aHi()});
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return l.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(k kVar, e eVar) {
        LayerDrawable layerDrawable;
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                am.setViewTextColor(kVar.fxu, R.color.cp_cont_f, 1);
                if (kVar.iHs.getTag() instanceof Integer) {
                    am.setBackgroundResource(kVar.iHs, ((Integer) kVar.iHs.getTag()).intValue());
                } else if (kVar.iHs.getTag() instanceof String) {
                    if (kVar.iHs.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = Nv;
                    } else if (kVar.iHs.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = Nw;
                    } else {
                        layerDrawable = kVar.iHs.getTag().equals("HOST") ? iFc : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(kVar.iHt, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iHu, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iHv, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iHE, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iHw, R.color.cp_cont_d, 1);
                kVar.iHz.setTextColor(am.getColor(R.color.cp_cont_b));
                kVar.iHA.onChangeSkinType();
                if (eVar != null) {
                    am.setViewTextColor(kVar.iHC, (int) R.color.cp_cont_c);
                    kVar.iHC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(kVar.iHD, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(kVar.iHB, R.color.cp_bg_line_g);
                    kVar.iHB.onChangeSkinType();
                    am.setViewTextColor(kVar.iHN, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(kVar.iHL, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(kVar.iHK, R.color.cp_bg_line_e);
                    am.setBackgroundResource(kVar.iHM, R.color.cp_cont_d);
                    am.setImageResource(kVar.iHO, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(kVar.iHR, (int) R.color.cp_cont_c);
                    if (kVar.iHP.getVisibility() == 8) {
                        kVar.iHC.setVisibility(8);
                        kVar.iHD.setVisibility(8);
                        kVar.iHR.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.ckX())) {
                        kVar.iHR.setText(eVar.ckX());
                    } else {
                        kVar.iHR.setText(R.string.expand_content);
                    }
                } else {
                    kVar.iHB.setVisibility(8);
                    kVar.iHC.setVisibility(8);
                    kVar.iHD.setVisibility(8);
                    kVar.iHK.setVisibility(8);
                    kVar.iHR.setVisibility(8);
                }
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(k kVar, PostData postData, bj bjVar, int i) {
        if (kVar != null && postData != null && postData.aEe() != null) {
            if (bjVar != null) {
                postData.aEe().threadId = bjVar.getTid();
                postData.aEe().forumId = String.valueOf(bjVar.getFid());
            }
            if (i == 0) {
                postData.aEe().objType = 1;
            } else {
                postData.aEe().objType = 2;
            }
            postData.aEe().isInPost = true;
            if (bjVar != null && bjVar.aEm()) {
                kVar.iHx.setAgreeAlone(true);
            }
            kVar.iHx.setData(postData.aEe());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x048e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0783  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(k kVar, PostData postData, View view, int i, a aVar, bj bjVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String userId;
        if (kVar != null && postData != null) {
            if (postData.aCr() == null || postData.aCr().isBaijiahaoUser()) {
            }
            if (postData.kiV) {
                am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            if (bjVar == null || bjVar.aCr() == null) {
                str = null;
            } else {
                str = bjVar.aCr().getUserId();
            }
            kVar.iHy.setTag(null);
            kVar.iHy.setUserId(null);
            kVar.fxu.setText((CharSequence) null);
            kVar.iHG.getHeadView().setUserId(null);
            kVar.iHz.setIsHost(false);
            if (postData.aCr() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aCr().getUserId())) {
                    kVar.iHz.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCr().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCr().getTShowInfoNew();
                if (kVar.iHI != null) {
                    kVar.iHI.setTag(R.id.tag_user_id, postData.aCr().getUserId());
                    kVar.iHI.setOnClickListener(aVar.clM().iUr);
                    kVar.iHI.a(iconInfo, 2, iFb, iFb, dOI);
                }
                if (kVar.iHH != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iHH.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.iHH.setOnClickListener(aVar.clM().iUs);
                    kVar.iHH.a(tShowInfoNew, 3, iFb, iFb, dOI, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aCr().isBigV()) {
                    am.setViewTextColor(kVar.fxu, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(kVar.fxu, R.color.cp_cont_f, 1);
                }
                String avater = postData.aCr().getAvater();
                kVar.fxu.setTag(R.id.tag_user_id, postData.aCr().getUserId());
                kVar.fxu.setTag(R.id.tag_user_name, postData.aCr().getUserName());
                kVar.fxu.setTag(R.id.tag_virtual_user_url, postData.aCr().getVirtualUserUrl());
                String name_show = postData.aCr().getName_show();
                String userName = postData.aCr().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fxu.setText(c.ba(aVar.getPageContext().getPageActivity(), kVar.fxu.getText().toString()));
                    kVar.fxu.setGravity(16);
                    kVar.fxu.setTag(R.id.tag_nick_name_activity, c.cky());
                    am.setViewTextColor(kVar.fxu, R.color.cp_other_f, 1);
                }
                if (postData.aCr().getPendantData() != null && !StringUtils.isNull(postData.aCr().getPendantData().aAJ())) {
                    kVar.iHG.b(postData.aCr());
                    kVar.iHy.setVisibility(8);
                    kVar.iHG.setVisibility(0);
                    kVar.iHG.getHeadView().startLoad(avater, 28, false);
                    kVar.iHG.getHeadView().setUserId(postData.aCr().getUserId());
                    kVar.iHG.getHeadView().setUserName(postData.aCr().getUserName());
                    kVar.iHG.tS(postData.aCr().getPendantData().aAJ());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iHy, postData.aCr(), 0);
                    kVar.iHy.setUserId(postData.aCr().getUserId());
                    kVar.iHy.setUserName(postData.aCr().getUserName(), postData.cLF());
                    kVar.iHy.setTag(R.id.tag_virtual_user_url, postData.aCr().getVirtualUserUrl());
                    kVar.iHy.setImageDrawable(null);
                    kVar.iHy.startLoad(avater, 28, false);
                    kVar.iHy.setVisibility(0);
                    kVar.iHG.setVisibility(8);
                }
                if (bjVar != null && bjVar.aEm()) {
                    kVar.iHs.setVisibility(8);
                    kVar.iHs.setTag(null);
                } else if (postData.aCr() != null) {
                    MetaData aCr = postData.aCr();
                    int ku = postData.cLn() ? R.drawable.brand_official_btn : am.ku(R.drawable.bg_user_identity_btn);
                    int ku2 = postData.cLn() ? R.color.cp_cont_a : am.ku(R.color.cp_bg_line_d);
                    am.setBackgroundResource(kVar.iHs, ku);
                    am.setViewTextColor(kVar.iHs, ku2);
                    kVar.iHs.setTag(Integer.valueOf(ku));
                    if (str != null && !str.equals("0") && str.equals(aCr.getUserId())) {
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.host_name);
                        kVar.iHs.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (iFc != null && iFc.getDrawable(1) != null) {
                                iFc.getDrawable(1).setAlpha(255);
                            }
                        } else if (iFc != null && iFc.getDrawable(1) != null) {
                            iFc.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(iFc);
                    } else if (aCr.getIs_bawu() == 1 && postData.cLn()) {
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.brand_Official);
                    } else if (aCr.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCr.getBawu_type())) {
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_member_bazhu_tip);
                        kVar.iHs.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nv != null && Nv.getDrawable(1) != null) {
                                Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nv != null && Nv.getDrawable(1) != null) {
                            Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(Nv);
                    } else if (aCr.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCr.getBawu_type())) {
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_member_xbazhu_tip);
                        kVar.iHs.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nw != null && Nw.getDrawable(1) != null) {
                                Nw.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nw != null && Nw.getDrawable(1) != null) {
                            Nw.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(Nw);
                    } else if (aCr.getIs_bawu() == 1 && "pri_content_assist".equals(aCr.getBawu_type())) {
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_content_assist_tip);
                    } else if (aCr.getIs_bawu() == 1 && "pri_manage_assist".equals(aCr.getBawu_type())) {
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iHs.setVisibility(8);
                        kVar.iHs.setTag(null);
                    }
                } else {
                    kVar.iHs.setVisibility(8);
                    kVar.iHs.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.clN() && postData.aCr() != null) {
                i2 = postData.aCr().getLevel_id();
            }
            if (bjVar != null && bjVar.aEm()) {
                i2 = 0;
            }
            if (i2 > 0) {
                kVar.iHF.setVisibility(0);
                am.setImageResource(kVar.iHF, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                kVar.iHF.setVisibility(8);
            }
            int i3 = 20;
            if (kVar.iHI.getChildCount() == 1) {
                i3 = 18;
            } else if (kVar.iHI.getChildCount() > 1) {
                i3 = 16;
            }
            if (kVar.iHs.getVisibility() == 0) {
                i3 -= 2;
            }
            if (kVar.iHH.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aCr() != null ? postData.aCr().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.aCr() != null && !StringUtils.isNull(postData.aCr().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aCr() != null && !StringUtils.isNull(postData.aCr().getSealPrefix())) {
                kVar.fxu.setText(a(aVar, postData.aCr().getSealPrefix(), name_show2));
            } else {
                kVar.fxu.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLv()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aCr() == null || StringUtils.isNull(postData.aCr().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.clP() != 0) {
                if (aVar.clP() != 1002 && aVar.clP() != 3) {
                    z8 = true;
                }
                if (aVar.clP() != 3 && !bjVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.aCr() != null) {
                    String userId2 = postData.aCr().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bjVar != null && bjVar.aCr() != null && postData.aCr() != null) {
                            userId = bjVar.aCr().getUserId();
                            String userId3 = postData.aCr().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aCr() != null && UtilHelper.isCurrentAccount(postData.aCr().getUserId())) {
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
                                if (postData.cLv() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aEm()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clP()));
                                    if (postData.aCr() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aCr().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCr().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCr().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aCr() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCr().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCr().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCr().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bjVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bjVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clP()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iHz.setTag(sparseArray);
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
                        if (postData.cLv() == 1) {
                        }
                        if (bjVar != null) {
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
                        kVar.iHz.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bjVar != null) {
                userId = bjVar.aCr().getUserId();
                String userId32 = postData.aCr().getUserId();
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
            if (postData.cLv() == 1) {
            }
            if (bjVar != null) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            kVar.iHz.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().nk(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().dOD = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nl((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, k kVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (kVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iHz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                kVar.iHz.wi(null);
                kVar.iHz.setBackgroundDrawable(null);
                kVar.iHz.getLayoutStrategy().nm(R.drawable.transparent_bg);
            } else {
                kVar.iHz.getLayoutStrategy().nm(R.drawable.icon_click);
            }
            kVar.iHz.getLayoutStrategy().nj(R.drawable.pic_video);
            a(kVar.iHz, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            kVar.iHz.setLayoutParams(layoutParams);
            kVar.iHz.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            kVar.iHz.setIsFromCDN(z2);
            TbRichText cLx = postData.cLx();
            kVar.iHz.setIsUseGridImage(postData.cLI());
            kVar.iHz.setText(cLx, true, cVar);
            SparseArray sparseArray = (SparseArray) kVar.iHz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            kVar.iHz.setTag(sparseArray);
            kVar.iHr.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, k kVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cLv() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cLv()));
                kVar.iHE.setVisibility(0);
                kVar.iHE.setText(format);
                z = true;
            } else {
                kVar.iHE.setVisibility(8);
                z = false;
            }
            f cLy = postData.cLy();
            boolean z2 = (cLy == null || StringUtils.isNull(cLy.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                kVar.iHu.setVisibility(0);
                i = iFa;
            } else {
                kVar.iHu.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iHv.setVisibility(0);
                i2 = iFa;
            } else {
                kVar.iHv.setVisibility(8);
                i2 = 0;
            }
            kVar.iHt.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iHt.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iHt.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iHw.setVisibility(0);
                kVar.iHw.setPadding(iFa, 0, 0, 0);
                kVar.iHw.setText(cLy.getName());
                return;
            }
            kVar.iHw.setVisibility(8);
        }
    }

    public static void a(k kVar, PostData postData) {
        if (postData == null || postData.csv() == null) {
            kVar.iHJ.setVisibility(8);
            return;
        }
        TbRichText cLx = postData.cLx();
        com.baidu.tieba.pb.view.b.a(postData.csv(), kVar.iHJ, false, false, cLx != null && StringUtils.isNull(cLx.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(k kVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iHz.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iHz.setLayoutParams(layoutParams);
            kVar.iHz.setPadding(0, 0, 0, 0);
            kVar.iHz.wi(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iHz.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iHz.setLayoutParams(layoutParams2);
            kVar.iHz.wi(postData.getBimg_url());
        }
        kVar.iHz.setTextViewCheckSelection(false);
    }
}
