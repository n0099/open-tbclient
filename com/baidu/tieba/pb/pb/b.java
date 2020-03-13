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
    private static LayerDrawable Nu;
    private static LayerDrawable Nv;
    private static LayerDrawable iDB;
    private static SparseArray<SoftReference<Drawable>> iDx = new SparseArray<>();
    private static SparseIntArray iDy = new SparseIntArray();
    public static final int dOr = getDimensionPixelSize(R.dimen.tbds12);
    public static final int iDz = getDimensionPixelSize(R.dimen.tbds16);
    public static final int iDA = getDimensionPixelSize(R.dimen.tbds40);
    public static final int aqJ = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = iDy.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            iDy.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void clv() {
        Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(aqJ).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(aqJ).tN("#4D000000").aHe()});
        Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(aqJ).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(aqJ).tN("#4D000000").aHe()});
        iDB = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(aqJ).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(aqJ).tN("#4D000000").aHe()});
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
                am.setViewTextColor(kVar.fwO, R.color.cp_cont_f, 1);
                if (kVar.iFR.getTag() instanceof Integer) {
                    am.setBackgroundResource(kVar.iFR, ((Integer) kVar.iFR.getTag()).intValue());
                } else if (kVar.iFR.getTag() instanceof String) {
                    if (kVar.iFR.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = Nu;
                    } else if (kVar.iFR.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = Nv;
                    } else {
                        layerDrawable = kVar.iFR.getTag().equals("HOST") ? iDB : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(kVar.iFS, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iFT, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iFU, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iGd, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iFV, R.color.cp_cont_d, 1);
                kVar.iFY.setTextColor(am.getColor(R.color.cp_cont_b));
                kVar.iFZ.onChangeSkinType();
                if (eVar != null) {
                    am.setViewTextColor(kVar.iGb, (int) R.color.cp_cont_c);
                    kVar.iGb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(kVar.iGc, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(kVar.iGa, R.color.cp_bg_line_g);
                    kVar.iGa.onChangeSkinType();
                    am.setViewTextColor(kVar.iGm, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(kVar.iGk, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(kVar.iGj, R.color.cp_bg_line_e);
                    am.setBackgroundResource(kVar.iGl, R.color.cp_cont_d);
                    am.setImageResource(kVar.iGn, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(kVar.iGq, (int) R.color.cp_cont_c);
                    if (kVar.iGo.getVisibility() == 8) {
                        kVar.iGb.setVisibility(8);
                        kVar.iGc.setVisibility(8);
                        kVar.iGq.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.ckD())) {
                        kVar.iGq.setText(eVar.ckD());
                    } else {
                        kVar.iGq.setText(R.string.expand_content);
                    }
                } else {
                    kVar.iGa.setVisibility(8);
                    kVar.iGb.setVisibility(8);
                    kVar.iGc.setVisibility(8);
                    kVar.iGj.setVisibility(8);
                    kVar.iGq.setVisibility(8);
                }
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(k kVar, PostData postData, bj bjVar, int i) {
        if (kVar != null && postData != null && postData.aEa() != null) {
            if (bjVar != null) {
                postData.aEa().threadId = bjVar.getTid();
                postData.aEa().forumId = String.valueOf(bjVar.getFid());
            }
            if (i == 0) {
                postData.aEa().objType = 1;
            } else {
                postData.aEa().objType = 2;
            }
            postData.aEa().isInPost = true;
            if (bjVar != null && bjVar.aEi()) {
                kVar.iFW.setAgreeAlone(true);
            }
            kVar.iFW.setData(postData.aEa());
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
            if (postData.aCo() == null || postData.aCo().isBaijiahaoUser()) {
            }
            if (postData.khs) {
                am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            if (bjVar == null || bjVar.aCo() == null) {
                str = null;
            } else {
                str = bjVar.aCo().getUserId();
            }
            kVar.iFX.setTag(null);
            kVar.iFX.setUserId(null);
            kVar.fwO.setText((CharSequence) null);
            kVar.iGf.getHeadView().setUserId(null);
            kVar.iFY.setIsHost(false);
            if (postData.aCo() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aCo().getUserId())) {
                    kVar.iFY.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCo().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCo().getTShowInfoNew();
                if (kVar.iGh != null) {
                    kVar.iGh.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                    kVar.iGh.setOnClickListener(aVar.clr().iSQ);
                    kVar.iGh.a(iconInfo, 2, iDA, iDA, dOr);
                }
                if (kVar.iGg != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iGg.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.iGg.setOnClickListener(aVar.clr().iSR);
                    kVar.iGg.a(tShowInfoNew, 3, iDA, iDA, dOr, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aCo().isBigV()) {
                    am.setViewTextColor(kVar.fwO, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(kVar.fwO, R.color.cp_cont_f, 1);
                }
                String avater = postData.aCo().getAvater();
                kVar.fwO.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                kVar.fwO.setTag(R.id.tag_user_name, postData.aCo().getUserName());
                kVar.fwO.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                String name_show = postData.aCo().getName_show();
                String userName = postData.aCo().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fwO.setText(c.ba(aVar.getPageContext().getPageActivity(), kVar.fwO.getText().toString()));
                    kVar.fwO.setGravity(16);
                    kVar.fwO.setTag(R.id.tag_nick_name_activity, c.cke());
                    am.setViewTextColor(kVar.fwO, R.color.cp_other_f, 1);
                }
                if (postData.aCo().getPendantData() != null && !StringUtils.isNull(postData.aCo().getPendantData().aAG())) {
                    kVar.iGf.b(postData.aCo());
                    kVar.iFX.setVisibility(8);
                    kVar.iGf.setVisibility(0);
                    kVar.iGf.getHeadView().startLoad(avater, 28, false);
                    kVar.iGf.getHeadView().setUserId(postData.aCo().getUserId());
                    kVar.iGf.getHeadView().setUserName(postData.aCo().getUserName());
                    kVar.iGf.tT(postData.aCo().getPendantData().aAG());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iFX, postData.aCo(), 0);
                    kVar.iFX.setUserId(postData.aCo().getUserId());
                    kVar.iFX.setUserName(postData.aCo().getUserName(), postData.cLl());
                    kVar.iFX.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                    kVar.iFX.setImageDrawable(null);
                    kVar.iFX.startLoad(avater, 28, false);
                    kVar.iFX.setVisibility(0);
                    kVar.iGf.setVisibility(8);
                }
                if (bjVar != null && bjVar.aEi()) {
                    kVar.iFR.setVisibility(8);
                    kVar.iFR.setTag(null);
                } else if (postData.aCo() != null) {
                    MetaData aCo = postData.aCo();
                    int ku = postData.cKT() ? R.drawable.brand_official_btn : am.ku(R.drawable.bg_user_identity_btn);
                    int ku2 = postData.cKT() ? R.color.cp_cont_a : am.ku(R.color.cp_bg_line_d);
                    am.setBackgroundResource(kVar.iFR, ku);
                    am.setViewTextColor(kVar.iFR, ku2);
                    kVar.iFR.setTag(Integer.valueOf(ku));
                    if (str != null && !str.equals("0") && str.equals(aCo.getUserId())) {
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.host_name);
                        kVar.iFR.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (iDB != null && iDB.getDrawable(1) != null) {
                                iDB.getDrawable(1).setAlpha(255);
                            }
                        } else if (iDB != null && iDB.getDrawable(1) != null) {
                            iDB.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(iDB);
                    } else if (aCo.getIs_bawu() == 1 && postData.cKT()) {
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.brand_Official);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_member_bazhu_tip);
                        kVar.iFR.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nu != null && Nu.getDrawable(1) != null) {
                                Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nu != null && Nu.getDrawable(1) != null) {
                            Nu.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(Nu);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_member_xbazhu_tip);
                        kVar.iFR.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nv != null && Nv.getDrawable(1) != null) {
                                Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nv != null && Nv.getDrawable(1) != null) {
                            Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(Nv);
                    } else if (aCo.getIs_bawu() == 1 && "pri_content_assist".equals(aCo.getBawu_type())) {
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_content_assist_tip);
                    } else if (aCo.getIs_bawu() == 1 && "pri_manage_assist".equals(aCo.getBawu_type())) {
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iFR.setVisibility(8);
                        kVar.iFR.setTag(null);
                    }
                } else {
                    kVar.iFR.setVisibility(8);
                    kVar.iFR.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cls() && postData.aCo() != null) {
                i2 = postData.aCo().getLevel_id();
            }
            if (bjVar != null && bjVar.aEi()) {
                i2 = 0;
            }
            if (i2 > 0) {
                kVar.iGe.setVisibility(0);
                am.setImageResource(kVar.iGe, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                kVar.iGe.setVisibility(8);
            }
            int i3 = 20;
            if (kVar.iGh.getChildCount() == 1) {
                i3 = 18;
            } else if (kVar.iGh.getChildCount() > 1) {
                i3 = 16;
            }
            if (kVar.iFR.getVisibility() == 0) {
                i3 -= 2;
            }
            if (kVar.iGg.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aCo() != null ? postData.aCo().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.aCo() != null && !StringUtils.isNull(postData.aCo().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aCo() != null && !StringUtils.isNull(postData.aCo().getSealPrefix())) {
                kVar.fwO.setText(a(aVar, postData.aCo().getSealPrefix(), name_show2));
            } else {
                kVar.fwO.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLb()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aCo() == null || StringUtils.isNull(postData.aCo().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.clu() != 0) {
                if (aVar.clu() != 1002 && aVar.clu() != 3) {
                    z8 = true;
                }
                if (aVar.clu() != 3 && !bjVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.aCo() != null) {
                    String userId2 = postData.aCo().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bjVar != null && bjVar.aCo() != null && postData.aCo() != null) {
                            userId = bjVar.aCo().getUserId();
                            String userId3 = postData.aCo().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aCo() != null && UtilHelper.isCurrentAccount(postData.aCo().getUserId())) {
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
                                if (postData.cLb() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aEi()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clu()));
                                    if (postData.aCo() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aCo() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCo().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCo().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCo().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bjVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bjVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clu()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iFY.setTag(sparseArray);
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
                        if (postData.cLb() == 1) {
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
                        kVar.iFY.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bjVar != null) {
                userId = bjVar.aCo().getUserId();
                String userId32 = postData.aCo().getUserId();
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
            if (postData.cLb() == 1) {
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
            kVar.iFY.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().ni(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().dOm = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nj((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, k kVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (kVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFY.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                kVar.iFY.wi(null);
                kVar.iFY.setBackgroundDrawable(null);
                kVar.iFY.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                kVar.iFY.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            kVar.iFY.getLayoutStrategy().nh(R.drawable.pic_video);
            a(kVar.iFY, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            kVar.iFY.setLayoutParams(layoutParams);
            kVar.iFY.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            kVar.iFY.setIsFromCDN(z2);
            TbRichText cLd = postData.cLd();
            kVar.iFY.setIsUseGridImage(postData.cLo());
            kVar.iFY.setText(cLd, true, cVar);
            SparseArray sparseArray = (SparseArray) kVar.iFY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            kVar.iFY.setTag(sparseArray);
            kVar.iFQ.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, k kVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cLb() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cLb()));
                kVar.iGd.setVisibility(0);
                kVar.iGd.setText(format);
                z = true;
            } else {
                kVar.iGd.setVisibility(8);
                z = false;
            }
            f cLe = postData.cLe();
            boolean z2 = (cLe == null || StringUtils.isNull(cLe.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                kVar.iFT.setVisibility(0);
                i = iDz;
            } else {
                kVar.iFT.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iFU.setVisibility(0);
                i2 = iDz;
            } else {
                kVar.iFU.setVisibility(8);
                i2 = 0;
            }
            kVar.iFS.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iFS.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iFS.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iFV.setVisibility(0);
                kVar.iFV.setPadding(iDz, 0, 0, 0);
                kVar.iFV.setText(cLe.getName());
                return;
            }
            kVar.iFV.setVisibility(8);
        }
    }

    public static void a(k kVar, PostData postData) {
        if (postData == null || postData.csa() == null) {
            kVar.iGi.setVisibility(8);
            return;
        }
        TbRichText cLd = postData.cLd();
        com.baidu.tieba.pb.view.b.a(postData.csa(), kVar.iGi, false, false, cLd != null && StringUtils.isNull(cLd.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(k kVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFY.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iFY.setLayoutParams(layoutParams);
            kVar.iFY.setPadding(0, 0, 0, 0);
            kVar.iFY.wi(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFY.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iFY.setLayoutParams(layoutParams2);
            kVar.iFY.wi(postData.getBimg_url());
        }
        kVar.iFY.setTextViewCheckSelection(false);
    }
}
