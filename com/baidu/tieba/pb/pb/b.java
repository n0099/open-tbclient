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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class b {
    private static LayerDrawable agg;
    private static LayerDrawable agh;
    private static LayerDrawable jpj;
    private static SparseArray<SoftReference<Drawable>> jpe = new SparseArray<>();
    private static SparseIntArray jpf = new SparseIntArray();
    public static final int eoC = getDimensionPixelSize(R.dimen.tbds12);
    public static final int jpg = getDimensionPixelSize(R.dimen.tbds16);
    public static final int jph = getDimensionPixelSize(R.dimen.tbds40);
    public static final int jpi = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = jpf.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            jpf.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cww() {
        agg = new LayerDrawable(new Drawable[]{c.aPy().kL(0).P(jpi).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPA(), c.aPy().kL(0).P(jpi).va("#4D000000").aPA()});
        agh = new LayerDrawable(new Drawable[]{c.aPy().kL(0).P(jpi).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPA(), c.aPy().kL(0).P(jpi).va("#4D000000").aPA()});
        jpj = new LayerDrawable(new Drawable[]{c.aPy().kL(0).P(jpi).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aPA(), c.aPy().kL(0).P(jpi).va("#4D000000").aPA()});
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
                am.setViewTextColor(kVar.gbU, R.color.cp_cont_f, 1);
                if (kVar.jrz.getTag() instanceof Integer) {
                    am.setBackgroundResource(kVar.jrz, ((Integer) kVar.jrz.getTag()).intValue());
                } else if (kVar.jrz.getTag() instanceof String) {
                    if (kVar.jrz.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = agg;
                    } else if (kVar.jrz.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = agh;
                    } else {
                        layerDrawable = kVar.jrz.getTag().equals("HOST") ? jpj : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(kVar.jrA, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.jrB, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.jrC, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.jrL, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.jrD, R.color.cp_cont_d, 1);
                kVar.jrG.setTextColor(am.getColor(R.color.cp_cont_b));
                kVar.jrH.onChangeSkinType();
                if (eVar != null) {
                    am.setViewTextColor(kVar.jrJ, (int) R.color.cp_cont_c);
                    kVar.jrJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(kVar.jrK, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(kVar.jrI, R.color.cp_bg_line_g);
                    kVar.jrI.onChangeSkinType();
                    am.setViewTextColor(kVar.jrU, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(kVar.jrS, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(kVar.jrR, R.color.cp_bg_line_e);
                    am.setBackgroundResource(kVar.jrT, R.color.cp_cont_d);
                    am.setImageResource(kVar.jrV, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(kVar.jrY, (int) R.color.cp_cont_c);
                    if (kVar.jrW.getVisibility() == 8) {
                        kVar.jrJ.setVisibility(8);
                        kVar.jrK.setVisibility(8);
                        kVar.jrY.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.cvC())) {
                        kVar.jrY.setText(eVar.cvC());
                    } else {
                        kVar.jrY.setText(R.string.expand_content);
                    }
                } else {
                    kVar.jrI.setVisibility(8);
                    kVar.jrJ.setVisibility(8);
                    kVar.jrK.setVisibility(8);
                    kVar.jrR.setVisibility(8);
                    kVar.jrY.setVisibility(8);
                }
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(k kVar, PostData postData, bj bjVar, int i) {
        if (kVar != null && postData != null && postData.aMs() != null) {
            if (bjVar != null) {
                postData.aMs().threadId = bjVar.getTid();
                postData.aMs().forumId = String.valueOf(bjVar.getFid());
            }
            if (i == 0) {
                postData.aMs().objType = 1;
            } else {
                postData.aMs().objType = 2;
            }
            postData.aMs().isInPost = true;
            if (bjVar != null && bjVar.aMA()) {
                kVar.jrE.setAgreeAlone(true);
            }
            kVar.jrE.setData(postData.aMs());
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
            if (postData.aKE() == null || postData.aKE().isBaijiahaoUser()) {
            }
            if (postData.kTb) {
                am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            if (bjVar == null || bjVar.aKE() == null) {
                str = null;
            } else {
                str = bjVar.aKE().getUserId();
            }
            kVar.jrF.setTag(null);
            kVar.jrF.setUserId(null);
            kVar.gbU.setText((CharSequence) null);
            kVar.jrN.getHeadView().setUserId(null);
            kVar.jrG.setIsHost(false);
            if (postData.aKE() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aKE().getUserId())) {
                    kVar.jrG.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aKE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aKE().getTShowInfoNew();
                if (kVar.jrP != null) {
                    kVar.jrP.setTag(R.id.tag_user_id, postData.aKE().getUserId());
                    kVar.jrP.setOnClickListener(aVar.cws().jEA);
                    kVar.jrP.a(iconInfo, 2, jph, jph, eoC);
                }
                if (kVar.jrO != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.jrO.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.jrO.setOnClickListener(aVar.cws().jEB);
                    kVar.jrO.a(tShowInfoNew, 3, jph, jph, eoC, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aKE().isBigV()) {
                    am.setViewTextColor(kVar.gbU, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(kVar.gbU, R.color.cp_cont_f, 1);
                }
                String avater = postData.aKE().getAvater();
                kVar.gbU.setTag(R.id.tag_user_id, postData.aKE().getUserId());
                kVar.gbU.setTag(R.id.tag_user_name, postData.aKE().getUserName());
                kVar.gbU.setTag(R.id.tag_virtual_user_url, postData.aKE().getVirtualUserUrl());
                String name_show = postData.aKE().getName_show();
                String userName = postData.aKE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.gbU.setText(com.baidu.tieba.pb.c.aV(aVar.getPageContext().getPageActivity(), kVar.gbU.getText().toString()));
                    kVar.gbU.setGravity(16);
                    kVar.gbU.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvd());
                    am.setViewTextColor(kVar.gbU, R.color.cp_other_f, 1);
                }
                if (postData.aKE().getPendantData() != null && !StringUtils.isNull(postData.aKE().getPendantData().aIW())) {
                    kVar.jrN.b(postData.aKE());
                    kVar.jrF.setVisibility(8);
                    kVar.jrN.setVisibility(0);
                    kVar.jrN.getHeadView().startLoad(avater, 28, false);
                    kVar.jrN.getHeadView().setUserId(postData.aKE().getUserId());
                    kVar.jrN.getHeadView().setUserName(postData.aKE().getUserName());
                    kVar.jrN.vg(postData.aKE().getPendantData().aIW());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.jrF, postData.aKE(), 0);
                    kVar.jrF.setUserId(postData.aKE().getUserId());
                    kVar.jrF.setUserName(postData.aKE().getUserName(), postData.cWB());
                    kVar.jrF.setTag(R.id.tag_virtual_user_url, postData.aKE().getVirtualUserUrl());
                    kVar.jrF.setImageDrawable(null);
                    kVar.jrF.startLoad(avater, 28, false);
                    kVar.jrF.setVisibility(0);
                    kVar.jrN.setVisibility(8);
                }
                if (bjVar != null && bjVar.aMA()) {
                    kVar.jrz.setVisibility(8);
                    kVar.jrz.setTag(null);
                } else if (postData.aKE() != null) {
                    MetaData aKE = postData.aKE();
                    int kB = postData.cWj() ? R.drawable.brand_official_btn : am.kB(R.drawable.bg_user_identity_btn);
                    int kB2 = postData.cWj() ? R.color.cp_cont_a : am.kB(R.color.cp_bg_line_d);
                    am.setBackgroundResource(kVar.jrz, kB);
                    am.setViewTextColor(kVar.jrz, kB2);
                    kVar.jrz.setTag(Integer.valueOf(kB));
                    if (str != null && !str.equals("0") && str.equals(aKE.getUserId())) {
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.host_name);
                        kVar.jrz.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (jpj != null && jpj.getDrawable(1) != null) {
                                jpj.getDrawable(1).setAlpha(255);
                            }
                        } else if (jpj != null && jpj.getDrawable(1) != null) {
                            jpj.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(jpj);
                    } else if (aKE.getIs_bawu() == 1 && postData.cWj()) {
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.brand_Official);
                    } else if (aKE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aKE.getBawu_type())) {
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_member_bazhu_tip);
                        kVar.jrz.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (agg != null && agg.getDrawable(1) != null) {
                                agg.getDrawable(1).setAlpha(255);
                            }
                        } else if (agg != null && agg.getDrawable(1) != null) {
                            agg.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(agg);
                    } else if (aKE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aKE.getBawu_type())) {
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_member_xbazhu_tip);
                        kVar.jrz.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (agh != null && agh.getDrawable(1) != null) {
                                agh.getDrawable(1).setAlpha(255);
                            }
                        } else if (agh != null && agh.getDrawable(1) != null) {
                            agh.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(agh);
                    } else if (aKE.getIs_bawu() == 1 && "pri_content_assist".equals(aKE.getBawu_type())) {
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_content_assist_tip);
                    } else if (aKE.getIs_bawu() == 1 && "pri_manage_assist".equals(aKE.getBawu_type())) {
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.jrz.setVisibility(8);
                        kVar.jrz.setTag(null);
                    }
                } else {
                    kVar.jrz.setVisibility(8);
                    kVar.jrz.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cwt() && postData.aKE() != null) {
                i2 = postData.aKE().getLevel_id();
            }
            if (bjVar != null && bjVar.aMA()) {
                i2 = 0;
            }
            if (i2 > 0) {
                kVar.jrM.setVisibility(0);
                am.setImageResource(kVar.jrM, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                kVar.jrM.setVisibility(8);
            }
            int i3 = 20;
            if (kVar.jrP.getChildCount() == 1) {
                i3 = 18;
            } else if (kVar.jrP.getChildCount() > 1) {
                i3 = 16;
            }
            if (kVar.jrz.getVisibility() == 0) {
                i3 -= 2;
            }
            if (kVar.jrO.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aKE() != null ? postData.aKE().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.aKE() != null && !StringUtils.isNull(postData.aKE().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aKE() != null && !StringUtils.isNull(postData.aKE().getSealPrefix())) {
                kVar.gbU.setText(a(aVar, postData.aKE().getSealPrefix(), name_show2));
            } else {
                kVar.gbU.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cWr()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aKE() == null || StringUtils.isNull(postData.aKE().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.cwv() != 0) {
                if (aVar.cwv() != 1002 && aVar.cwv() != 3) {
                    z8 = true;
                }
                if (aVar.cwv() != 3 && !bjVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.aKE() != null) {
                    String userId2 = postData.aKE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bjVar != null && bjVar.aKE() != null && postData.aKE() != null) {
                            userId = bjVar.aKE().getUserId();
                            String userId3 = postData.aKE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aKE() != null && UtilHelper.isCurrentAccount(postData.aKE().getUserId())) {
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
                                if (postData.cWr() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aMA()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cwv()));
                                    if (postData.aKE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aKE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aKE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKE().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bjVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bjVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cwv()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.jrG.setTag(sparseArray);
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
                        if (postData.cWr() == 1) {
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
                        kVar.jrG.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bjVar != null) {
                userId = bjVar.aKE().getUserId();
                String userId32 = postData.aKE().getUserId();
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
            if (postData.cWr() == 1) {
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
            kVar.jrG.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().nw(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eox = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nx((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, k kVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (kVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrG.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                kVar.jrG.xv(null);
                kVar.jrG.setBackgroundDrawable(null);
                kVar.jrG.getLayoutStrategy().ny(R.drawable.transparent_bg);
            } else {
                kVar.jrG.getLayoutStrategy().ny(R.drawable.icon_click);
            }
            kVar.jrG.getLayoutStrategy().nv(R.drawable.pic_video);
            a(kVar.jrG, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            kVar.jrG.setLayoutParams(layoutParams);
            kVar.jrG.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            kVar.jrG.setIsFromCDN(z2);
            TbRichText cWt = postData.cWt();
            kVar.jrG.setIsUseGridImage(postData.cWE());
            kVar.jrG.setText(cWt, true, cVar);
            SparseArray sparseArray = (SparseArray) kVar.jrG.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            kVar.jrG.setTag(sparseArray);
            kVar.jry.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, k kVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cWr() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cWr()));
                kVar.jrL.setVisibility(0);
                kVar.jrL.setText(format);
                z = true;
            } else {
                kVar.jrL.setVisibility(8);
                z = false;
            }
            f cWu = postData.cWu();
            boolean z2 = (cWu == null || StringUtils.isNull(cWu.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                kVar.jrB.setVisibility(0);
                i = jpg;
            } else {
                kVar.jrB.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.jrC.setVisibility(0);
                i2 = jpg;
            } else {
                kVar.jrC.setVisibility(8);
                i2 = 0;
            }
            kVar.jrA.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                kVar.jrA.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.jrA.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.jrD.setVisibility(0);
                kVar.jrD.setPadding(jpg, 0, 0, 0);
                kVar.jrD.setText(cWu.getName());
                return;
            }
            kVar.jrD.setVisibility(8);
        }
    }

    public static void a(k kVar, PostData postData) {
        if (postData == null || postData.cDb() == null) {
            kVar.jrQ.setVisibility(8);
            return;
        }
        TbRichText cWt = postData.cWt();
        com.baidu.tieba.pb.view.b.a(postData.cDb(), kVar.jrQ, false, false, cWt != null && StringUtils.isNull(cWt.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(k kVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrG.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.jrG.setLayoutParams(layoutParams);
            kVar.jrG.setPadding(0, 0, 0, 0);
            kVar.jrG.xv(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.jrG.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.jrG.setLayoutParams(layoutParams2);
            kVar.jrG.xv(postData.getBimg_url());
        }
        kVar.jrG.setTextViewCheckSelection(false);
    }
}
