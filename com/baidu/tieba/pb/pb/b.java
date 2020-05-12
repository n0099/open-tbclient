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
    private static LayerDrawable agj;
    private static LayerDrawable agk;
    private static LayerDrawable jpn;
    private static SparseArray<SoftReference<Drawable>> jpi = new SparseArray<>();
    private static SparseIntArray jpj = new SparseIntArray();
    public static final int eoH = getDimensionPixelSize(R.dimen.tbds12);
    public static final int jpk = getDimensionPixelSize(R.dimen.tbds16);
    public static final int jpl = getDimensionPixelSize(R.dimen.tbds40);
    public static final int jpm = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = jpj.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            jpj.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cwu() {
        agj = new LayerDrawable(new Drawable[]{c.aPv().kL(0).P(jpm).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPx(), c.aPv().kL(0).P(jpm).vd("#4D000000").aPx()});
        agk = new LayerDrawable(new Drawable[]{c.aPv().kL(0).P(jpm).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPx(), c.aPv().kL(0).P(jpm).vd("#4D000000").aPx()});
        jpn = new LayerDrawable(new Drawable[]{c.aPv().kL(0).P(jpm).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aPx(), c.aPv().kL(0).P(jpm).vd("#4D000000").aPx()});
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
                am.setViewTextColor(kVar.gbZ, R.color.cp_cont_f, 1);
                if (kVar.jrD.getTag() instanceof Integer) {
                    am.setBackgroundResource(kVar.jrD, ((Integer) kVar.jrD.getTag()).intValue());
                } else if (kVar.jrD.getTag() instanceof String) {
                    if (kVar.jrD.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = agj;
                    } else if (kVar.jrD.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = agk;
                    } else {
                        layerDrawable = kVar.jrD.getTag().equals("HOST") ? jpn : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(kVar.jrE, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.jrF, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.jrG, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.jrP, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.jrH, R.color.cp_cont_d, 1);
                kVar.jrK.setTextColor(am.getColor(R.color.cp_cont_b));
                kVar.jrL.onChangeSkinType();
                if (eVar != null) {
                    am.setViewTextColor(kVar.jrN, (int) R.color.cp_cont_c);
                    kVar.jrN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(kVar.jrO, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(kVar.jrM, R.color.cp_bg_line_g);
                    kVar.jrM.onChangeSkinType();
                    am.setViewTextColor(kVar.jrY, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(kVar.jrW, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(kVar.jrV, R.color.cp_bg_line_e);
                    am.setBackgroundResource(kVar.jrX, R.color.cp_cont_d);
                    am.setImageResource(kVar.jrZ, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(kVar.jsc, (int) R.color.cp_cont_c);
                    if (kVar.jsa.getVisibility() == 8) {
                        kVar.jrN.setVisibility(8);
                        kVar.jrO.setVisibility(8);
                        kVar.jsc.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.cvA())) {
                        kVar.jsc.setText(eVar.cvA());
                    } else {
                        kVar.jsc.setText(R.string.expand_content);
                    }
                } else {
                    kVar.jrM.setVisibility(8);
                    kVar.jrN.setVisibility(8);
                    kVar.jrO.setVisibility(8);
                    kVar.jrV.setVisibility(8);
                    kVar.jsc.setVisibility(8);
                }
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(k kVar, PostData postData, bj bjVar, int i) {
        if (kVar != null && postData != null && postData.aMq() != null) {
            if (bjVar != null) {
                postData.aMq().threadId = bjVar.getTid();
                postData.aMq().forumId = String.valueOf(bjVar.getFid());
            }
            if (i == 0) {
                postData.aMq().objType = 1;
            } else {
                postData.aMq().objType = 2;
            }
            postData.aMq().isInPost = true;
            if (bjVar != null && bjVar.aMy()) {
                kVar.jrI.setAgreeAlone(true);
            }
            kVar.jrI.setData(postData.aMq());
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
            if (postData.aKC() == null || postData.aKC().isBaijiahaoUser()) {
            }
            if (postData.kTf) {
                am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            if (bjVar == null || bjVar.aKC() == null) {
                str = null;
            } else {
                str = bjVar.aKC().getUserId();
            }
            kVar.jrJ.setTag(null);
            kVar.jrJ.setUserId(null);
            kVar.gbZ.setText((CharSequence) null);
            kVar.jrR.getHeadView().setUserId(null);
            kVar.jrK.setIsHost(false);
            if (postData.aKC() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aKC().getUserId())) {
                    kVar.jrK.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aKC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aKC().getTShowInfoNew();
                if (kVar.jrT != null) {
                    kVar.jrT.setTag(R.id.tag_user_id, postData.aKC().getUserId());
                    kVar.jrT.setOnClickListener(aVar.cwq().jEE);
                    kVar.jrT.a(iconInfo, 2, jpl, jpl, eoH);
                }
                if (kVar.jrS != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.jrS.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.jrS.setOnClickListener(aVar.cwq().jEF);
                    kVar.jrS.a(tShowInfoNew, 3, jpl, jpl, eoH, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aKC().isBigV()) {
                    am.setViewTextColor(kVar.gbZ, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(kVar.gbZ, R.color.cp_cont_f, 1);
                }
                String avater = postData.aKC().getAvater();
                kVar.gbZ.setTag(R.id.tag_user_id, postData.aKC().getUserId());
                kVar.gbZ.setTag(R.id.tag_user_name, postData.aKC().getUserName());
                kVar.gbZ.setTag(R.id.tag_virtual_user_url, postData.aKC().getVirtualUserUrl());
                String name_show = postData.aKC().getName_show();
                String userName = postData.aKC().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.gbZ.setText(com.baidu.tieba.pb.c.aJ(aVar.getPageContext().getPageActivity(), kVar.gbZ.getText().toString()));
                    kVar.gbZ.setGravity(16);
                    kVar.gbZ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvb());
                    am.setViewTextColor(kVar.gbZ, R.color.cp_other_f, 1);
                }
                if (postData.aKC().getPendantData() != null && !StringUtils.isNull(postData.aKC().getPendantData().aIU())) {
                    kVar.jrR.b(postData.aKC());
                    kVar.jrJ.setVisibility(8);
                    kVar.jrR.setVisibility(0);
                    kVar.jrR.getHeadView().startLoad(avater, 28, false);
                    kVar.jrR.getHeadView().setUserId(postData.aKC().getUserId());
                    kVar.jrR.getHeadView().setUserName(postData.aKC().getUserName());
                    kVar.jrR.vj(postData.aKC().getPendantData().aIU());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.jrJ, postData.aKC(), 0);
                    kVar.jrJ.setUserId(postData.aKC().getUserId());
                    kVar.jrJ.setUserName(postData.aKC().getUserName(), postData.cWz());
                    kVar.jrJ.setTag(R.id.tag_virtual_user_url, postData.aKC().getVirtualUserUrl());
                    kVar.jrJ.setImageDrawable(null);
                    kVar.jrJ.startLoad(avater, 28, false);
                    kVar.jrJ.setVisibility(0);
                    kVar.jrR.setVisibility(8);
                }
                if (bjVar != null && bjVar.aMy()) {
                    kVar.jrD.setVisibility(8);
                    kVar.jrD.setTag(null);
                } else if (postData.aKC() != null) {
                    MetaData aKC = postData.aKC();
                    int kB = postData.cWh() ? R.drawable.brand_official_btn : am.kB(R.drawable.bg_user_identity_btn);
                    int kB2 = postData.cWh() ? R.color.cp_cont_a : am.kB(R.color.cp_bg_line_d);
                    am.setBackgroundResource(kVar.jrD, kB);
                    am.setViewTextColor(kVar.jrD, kB2);
                    kVar.jrD.setTag(Integer.valueOf(kB));
                    if (str != null && !str.equals("0") && str.equals(aKC.getUserId())) {
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.host_name);
                        kVar.jrD.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (jpn != null && jpn.getDrawable(1) != null) {
                                jpn.getDrawable(1).setAlpha(255);
                            }
                        } else if (jpn != null && jpn.getDrawable(1) != null) {
                            jpn.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(jpn);
                    } else if (aKC.getIs_bawu() == 1 && postData.cWh()) {
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.brand_Official);
                    } else if (aKC.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aKC.getBawu_type())) {
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_member_bazhu_tip);
                        kVar.jrD.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (agj != null && agj.getDrawable(1) != null) {
                                agj.getDrawable(1).setAlpha(255);
                            }
                        } else if (agj != null && agj.getDrawable(1) != null) {
                            agj.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(agj);
                    } else if (aKC.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aKC.getBawu_type())) {
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_member_xbazhu_tip);
                        kVar.jrD.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (agk != null && agk.getDrawable(1) != null) {
                                agk.getDrawable(1).setAlpha(255);
                            }
                        } else if (agk != null && agk.getDrawable(1) != null) {
                            agk.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(agk);
                    } else if (aKC.getIs_bawu() == 1 && "pri_content_assist".equals(aKC.getBawu_type())) {
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_content_assist_tip);
                    } else if (aKC.getIs_bawu() == 1 && "pri_manage_assist".equals(aKC.getBawu_type())) {
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.jrD.setVisibility(8);
                        kVar.jrD.setTag(null);
                    }
                } else {
                    kVar.jrD.setVisibility(8);
                    kVar.jrD.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cwr() && postData.aKC() != null) {
                i2 = postData.aKC().getLevel_id();
            }
            if (bjVar != null && bjVar.aMy()) {
                i2 = 0;
            }
            if (i2 > 0) {
                kVar.jrQ.setVisibility(0);
                am.setImageResource(kVar.jrQ, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                kVar.jrQ.setVisibility(8);
            }
            int i3 = 20;
            if (kVar.jrT.getChildCount() == 1) {
                i3 = 18;
            } else if (kVar.jrT.getChildCount() > 1) {
                i3 = 16;
            }
            if (kVar.jrD.getVisibility() == 0) {
                i3 -= 2;
            }
            if (kVar.jrS.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aKC() != null ? postData.aKC().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.aKC() != null && !StringUtils.isNull(postData.aKC().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aKC() != null && !StringUtils.isNull(postData.aKC().getSealPrefix())) {
                kVar.gbZ.setText(a(aVar, postData.aKC().getSealPrefix(), name_show2));
            } else {
                kVar.gbZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cWp()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aKC() == null || StringUtils.isNull(postData.aKC().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.cwt() != 0) {
                if (aVar.cwt() != 1002 && aVar.cwt() != 3) {
                    z8 = true;
                }
                if (aVar.cwt() != 3 && !bjVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.aKC() != null) {
                    String userId2 = postData.aKC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bjVar != null && bjVar.aKC() != null && postData.aKC() != null) {
                            userId = bjVar.aKC().getUserId();
                            String userId3 = postData.aKC().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aKC() != null && UtilHelper.isCurrentAccount(postData.aKC().getUserId())) {
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
                                if (postData.cWp() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aMy()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cwt()));
                                    if (postData.aKC() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aKC().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKC().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKC().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aKC() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKC().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKC().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKC().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bjVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bjVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cwt()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.jrK.setTag(sparseArray);
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
                        if (postData.cWp() == 1) {
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
                        kVar.jrK.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bjVar != null) {
                userId = bjVar.aKC().getUserId();
                String userId32 = postData.aKC().getUserId();
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
            if (postData.cWp() == 1) {
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
            kVar.jrK.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().eoC = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nx((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, k kVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (kVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                kVar.jrK.xy(null);
                kVar.jrK.setBackgroundDrawable(null);
                kVar.jrK.getLayoutStrategy().ny(R.drawable.transparent_bg);
            } else {
                kVar.jrK.getLayoutStrategy().ny(R.drawable.icon_click);
            }
            kVar.jrK.getLayoutStrategy().nv(R.drawable.pic_video);
            a(kVar.jrK, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            kVar.jrK.setLayoutParams(layoutParams);
            kVar.jrK.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            kVar.jrK.setIsFromCDN(z2);
            TbRichText cWr = postData.cWr();
            kVar.jrK.setIsUseGridImage(postData.cWC());
            kVar.jrK.setText(cWr, true, cVar);
            SparseArray sparseArray = (SparseArray) kVar.jrK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            kVar.jrK.setTag(sparseArray);
            kVar.jrC.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, k kVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cWp() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cWp()));
                kVar.jrP.setVisibility(0);
                kVar.jrP.setText(format);
                z = true;
            } else {
                kVar.jrP.setVisibility(8);
                z = false;
            }
            f cWs = postData.cWs();
            boolean z2 = (cWs == null || StringUtils.isNull(cWs.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                kVar.jrF.setVisibility(0);
                i = jpk;
            } else {
                kVar.jrF.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.jrG.setVisibility(0);
                i2 = jpk;
            } else {
                kVar.jrG.setVisibility(8);
                i2 = 0;
            }
            kVar.jrE.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                kVar.jrE.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.jrE.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.jrH.setVisibility(0);
                kVar.jrH.setPadding(jpk, 0, 0, 0);
                kVar.jrH.setText(cWs.getName());
                return;
            }
            kVar.jrH.setVisibility(8);
        }
    }

    public static void a(k kVar, PostData postData) {
        if (postData == null || postData.cCZ() == null) {
            kVar.jrU.setVisibility(8);
            return;
        }
        TbRichText cWr = postData.cWr();
        com.baidu.tieba.pb.view.b.a(postData.cCZ(), kVar.jrU, false, false, cWr != null && StringUtils.isNull(cWr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(k kVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.jrK.setLayoutParams(layoutParams);
            kVar.jrK.setPadding(0, 0, 0, 0);
            kVar.jrK.xy(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.jrK.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.jrK.setLayoutParams(layoutParams2);
            kVar.jrK.xy(postData.getBimg_url());
        }
        kVar.jrK.setTextViewCheckSelection(false);
    }
}
