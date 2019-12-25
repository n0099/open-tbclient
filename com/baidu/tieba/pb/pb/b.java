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
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.d;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class b {
    private static LayerDrawable MR;
    private static LayerDrawable MS;
    private static LayerDrawable ixQ;
    private static SparseArray<SoftReference<Drawable>> ixM = new SparseArray<>();
    private static SparseIntArray ixN = new SparseIntArray();
    public static final int dJR = getDimensionPixelSize(R.dimen.tbds12);
    public static final int ixO = getDimensionPixelSize(R.dimen.tbds16);
    public static final int ixP = getDimensionPixelSize(R.dimen.tbds40);
    public static final int amD = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = ixN.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            ixN.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void ciM() {
        MR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(amD).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(amD).ts("#4D000000").aEw()});
        MS = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(amD).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(amD).ts("#4D000000").aEw()});
        ixQ = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(amD).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(amD).ts("#4D000000").aEw()});
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

    public static void a(com.baidu.tieba.pb.pb.main.l lVar, f fVar) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                am.setViewTextColor(lVar.fqP, R.color.cp_cont_f, 1);
                if (lVar.iAv.getTag() instanceof Integer) {
                    am.setBackgroundResource(lVar.iAv, ((Integer) lVar.iAv.getTag()).intValue());
                } else if (lVar.iAv.getTag() instanceof String) {
                    if (lVar.iAv.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = MR;
                    } else if (lVar.iAv.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = MS;
                    } else {
                        layerDrawable = lVar.iAv.getTag().equals("HOST") ? ixQ : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(lVar.iAw, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.iAx, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.iAy, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.iAH, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.iAz, R.color.cp_cont_d, 1);
                lVar.iAC.setTextColor(am.getColor(R.color.cp_cont_b));
                lVar.iAD.onChangeSkinType();
                if (fVar != null) {
                    am.setViewTextColor(lVar.iAF, (int) R.color.cp_cont_c);
                    lVar.iAF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(lVar.iAG, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(lVar.iAE, R.color.cp_bg_line_g);
                    lVar.iAE.onChangeSkinType();
                    am.setViewTextColor(lVar.iAQ, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(lVar.iAO, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(lVar.iAN, R.color.cp_bg_line_e);
                    am.setBackgroundResource(lVar.iAP, R.color.cp_cont_d);
                    am.setImageResource(lVar.iAR, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(lVar.iAU, (int) R.color.cp_cont_c);
                    if (lVar.iAS.getVisibility() == 8) {
                        lVar.iAF.setVisibility(8);
                        lVar.iAG.setVisibility(8);
                        lVar.iAU.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.chS())) {
                        lVar.iAU.setText(fVar.chS());
                    } else {
                        lVar.iAU.setText(R.string.expand_content);
                    }
                } else {
                    lVar.iAE.setVisibility(8);
                    lVar.iAF.setVisibility(8);
                    lVar.iAG.setVisibility(8);
                    lVar.iAN.setVisibility(8);
                    lVar.iAU.setVisibility(8);
                }
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.l lVar, PostData postData, bj bjVar, int i) {
        if (lVar != null && postData != null && postData.aBt() != null) {
            if (bjVar != null) {
                postData.aBt().threadId = bjVar.getTid();
                postData.aBt().forumId = String.valueOf(bjVar.getFid());
            }
            if (i == 0) {
                postData.aBt().objType = 1;
            } else {
                postData.aBt().objType = 2;
            }
            postData.aBt().isInPost = true;
            if (bjVar != null && bjVar.aBC()) {
                lVar.iAA.setAgreeAlone(true);
            }
            lVar.iAA.setData(postData.aBt());
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
    public static void a(com.baidu.tieba.pb.pb.main.l lVar, PostData postData, View view, int i, a aVar, bj bjVar) {
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
            if (postData.azE() == null || postData.azE().getBaijiahaoInfo() != null) {
            }
            if (postData.kcv) {
                am.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            if (bjVar == null || bjVar.azE() == null) {
                str = null;
            } else {
                str = bjVar.azE().getUserId();
            }
            lVar.iAB.setTag(null);
            lVar.iAB.setUserId(null);
            lVar.fqP.setText((CharSequence) null);
            lVar.iAJ.getHeadView().setUserId(null);
            lVar.iAC.setIsHost(false);
            if (postData.azE() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.azE().getUserId())) {
                    lVar.iAC.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.azE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.azE().getTShowInfoNew();
                if (lVar.iAL != null) {
                    lVar.iAL.setTag(R.id.tag_user_id, postData.azE().getUserId());
                    lVar.iAL.setOnClickListener(aVar.ciI().iND);
                    lVar.iAL.a(iconInfo, 2, ixP, ixP, dJR);
                }
                if (lVar.iAK != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.iAK.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.iAK.setOnClickListener(aVar.ciI().iNE);
                    lVar.iAK.a(tShowInfoNew, 3, ixP, ixP, dJR, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.azE().isBigV()) {
                    am.setViewTextColor(lVar.fqP, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(lVar.fqP, R.color.cp_cont_f, 1);
                }
                String avater = postData.azE().getAvater();
                lVar.fqP.setTag(R.id.tag_user_id, postData.azE().getUserId());
                lVar.fqP.setTag(R.id.tag_user_name, postData.azE().getUserName());
                lVar.fqP.setTag(R.id.tag_virtual_user_url, postData.azE().getVirtualUserUrl());
                String name_show = postData.azE().getName_show();
                String userName = postData.azE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.fqP.setText(d.aZ(aVar.getPageContext().getPageActivity(), lVar.fqP.getText().toString()));
                    lVar.fqP.setGravity(16);
                    lVar.fqP.setTag(R.id.tag_nick_name_activity, d.chp());
                    am.setViewTextColor(lVar.fqP, R.color.cp_other_f, 1);
                }
                if (postData.azE().getPendantData() != null && !StringUtils.isNull(postData.azE().getPendantData().axX())) {
                    lVar.iAJ.b(postData.azE());
                    lVar.iAB.setVisibility(8);
                    lVar.iAJ.setVisibility(0);
                    lVar.iAJ.getHeadView().startLoad(avater, 28, false);
                    lVar.iAJ.getHeadView().setUserId(postData.azE().getUserId());
                    lVar.iAJ.getHeadView().setUserName(postData.azE().getUserName());
                    lVar.iAJ.ty(postData.azE().getPendantData().axX());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.iAB, postData.azE(), 0);
                    lVar.iAB.setUserId(postData.azE().getUserId());
                    lVar.iAB.setUserName(postData.azE().getUserName(), postData.cID());
                    lVar.iAB.setTag(R.id.tag_virtual_user_url, postData.azE().getVirtualUserUrl());
                    lVar.iAB.setImageDrawable(null);
                    lVar.iAB.startLoad(avater, 28, false);
                    lVar.iAB.setVisibility(0);
                    lVar.iAJ.setVisibility(8);
                }
                if (bjVar != null && bjVar.aBC()) {
                    lVar.iAv.setVisibility(8);
                    lVar.iAv.setTag(null);
                } else if (postData.azE() != null) {
                    MetaData azE = postData.azE();
                    int kd = postData.cIl() ? R.drawable.brand_official_btn : am.kd(R.drawable.bg_user_identity_btn);
                    int kd2 = postData.cIl() ? R.color.cp_cont_a : am.kd(R.color.cp_bg_line_d);
                    am.setBackgroundResource(lVar.iAv, kd);
                    am.setViewTextColor(lVar.iAv, kd2);
                    lVar.iAv.setTag(Integer.valueOf(kd));
                    if (str != null && !str.equals("0") && str.equals(azE.getUserId())) {
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.host_name);
                        lVar.iAv.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (ixQ != null && ixQ.getDrawable(1) != null) {
                                ixQ.getDrawable(1).setAlpha(255);
                            }
                        } else if (ixQ != null && ixQ.getDrawable(1) != null) {
                            ixQ.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(ixQ);
                    } else if (azE.getIs_bawu() == 1 && postData.cIl()) {
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.brand_Official);
                    } else if (azE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(azE.getBawu_type())) {
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_member_bazhu_tip);
                        lVar.iAv.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (MR != null && MR.getDrawable(1) != null) {
                                MR.getDrawable(1).setAlpha(255);
                            }
                        } else if (MR != null && MR.getDrawable(1) != null) {
                            MR.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(MR);
                    } else if (azE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(azE.getBawu_type())) {
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_member_xbazhu_tip);
                        lVar.iAv.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (MS != null && MS.getDrawable(1) != null) {
                                MS.getDrawable(1).setAlpha(255);
                            }
                        } else if (MS != null && MS.getDrawable(1) != null) {
                            MS.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(MS);
                    } else if (azE.getIs_bawu() == 1 && "pri_content_assist".equals(azE.getBawu_type())) {
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_content_assist_tip);
                    } else if (azE.getIs_bawu() == 1 && "pri_manage_assist".equals(azE.getBawu_type())) {
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.iAv.setVisibility(8);
                        lVar.iAv.setTag(null);
                    }
                } else {
                    lVar.iAv.setVisibility(8);
                    lVar.iAv.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.ciJ() && postData.azE() != null) {
                i2 = postData.azE().getLevel_id();
            }
            if (bjVar != null && bjVar.aBC()) {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.iAI.setVisibility(0);
                am.setImageResource(lVar.iAI, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.iAI.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.iAL.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.iAL.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.iAv.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.iAK.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.azE() != null ? postData.azE().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.azE() != null && !StringUtils.isNull(postData.azE().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.azE() != null && !StringUtils.isNull(postData.azE().getSealPrefix())) {
                lVar.fqP.setText(a(aVar, postData.azE().getSealPrefix(), name_show2));
            } else {
                lVar.fqP.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cIt()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.azE() == null || StringUtils.isNull(postData.azE().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.ciL() != 0) {
                if (aVar.ciL() != 1002 && aVar.ciL() != 3) {
                    z8 = true;
                }
                if (aVar.ciL() != 3 && !bjVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.azE() != null) {
                    String userId2 = postData.azE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bjVar != null && bjVar.azE() != null && postData.azE() != null) {
                            userId = bjVar.azE().getUserId();
                            String userId3 = postData.azE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.azE() != null && UtilHelper.isCurrentAccount(postData.azE().getUserId())) {
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
                                if (postData.cIt() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aBC()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.ciL()));
                                    if (postData.azE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.azE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.azE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.azE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.azE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.azE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azE().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bjVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bjVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.ciL()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.iAC.setTag(sparseArray);
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
                        if (postData.cIt() == 1) {
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
                        lVar.iAC.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bjVar != null) {
                userId = bjVar.azE().getUserId();
                String userId32 = postData.azE().getUserId();
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
            if (postData.cIt() == 1) {
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
            lVar.iAC.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().mR(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().dJK = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().mS((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.l lVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (lVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iAC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                lVar.iAC.vJ(null);
                lVar.iAC.setBackgroundDrawable(null);
                lVar.iAC.getLayoutStrategy().mT(R.drawable.transparent_bg);
            } else {
                lVar.iAC.getLayoutStrategy().mT(R.drawable.icon_click);
            }
            lVar.iAC.getLayoutStrategy().mQ(R.drawable.pic_video);
            a(lVar.iAC, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            lVar.iAC.setLayoutParams(layoutParams);
            lVar.iAC.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            lVar.iAC.setIsFromCDN(z2);
            TbRichText cIv = postData.cIv();
            lVar.iAC.setIsUseGridImage(postData.cIG());
            lVar.iAC.setText(cIv, true, cVar);
            SparseArray sparseArray = (SparseArray) lVar.iAC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            lVar.iAC.setTag(sparseArray);
            lVar.iAu.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.l lVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.cIt() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cIt()));
                lVar.iAH.setVisibility(0);
                lVar.iAH.setText(format);
                z = true;
            } else {
                lVar.iAH.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cIw = postData.cIw();
            boolean z2 = (cIw == null || StringUtils.isNull(cIw.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                lVar.iAx.setVisibility(0);
                i = ixO;
            } else {
                lVar.iAx.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.iAy.setVisibility(0);
                i2 = ixO;
            } else {
                lVar.iAy.setVisibility(8);
                i2 = 0;
            }
            lVar.iAw.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                lVar.iAw.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.iAw.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.iAz.setVisibility(0);
                lVar.iAz.setPadding(ixO, 0, 0, 0);
                lVar.iAz.setText(cIw.getName());
                return;
            }
            lVar.iAz.setVisibility(8);
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.l lVar, PostData postData) {
        if (postData == null || postData.cpy() == null) {
            lVar.iAM.setVisibility(8);
            return;
        }
        TbRichText cIv = postData.cIv();
        com.baidu.tieba.pb.view.b.a(postData.cpy(), lVar.iAM, false, false, cIv != null && StringUtils.isNull(cIv.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(com.baidu.tieba.pb.pb.main.l lVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iAC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.iAC.setLayoutParams(layoutParams);
            lVar.iAC.setPadding(0, 0, 0, 0);
            lVar.iAC.vJ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.iAC.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.iAC.setLayoutParams(layoutParams2);
            lVar.iAC.vJ(postData.getBimg_url());
        }
        lVar.iAC.setTextViewCheckSelection(false);
    }
}
