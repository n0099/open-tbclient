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
/* loaded from: classes7.dex */
public class b {
    private static LayerDrawable MV;
    private static LayerDrawable MW;
    private static LayerDrawable iBu;
    private static SparseArray<SoftReference<Drawable>> iBq = new SparseArray<>();
    private static SparseIntArray iBr = new SparseIntArray();
    public static final int dJY = getDimensionPixelSize(R.dimen.tbds12);
    public static final int iBs = getDimensionPixelSize(R.dimen.tbds16);
    public static final int iBt = getDimensionPixelSize(R.dimen.tbds40);
    public static final int anq = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = iBr.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            iBr.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cjU() {
        MV = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(anq).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(anq).tw("#4D000000").aEP()});
        MW = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(anq).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(anq).tw("#4D000000").aEP()});
        iBu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(anq).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(anq).tw("#4D000000").aEP()});
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
                am.setViewTextColor(lVar.ftZ, R.color.cp_cont_f, 1);
                if (lVar.iDZ.getTag() instanceof Integer) {
                    am.setBackgroundResource(lVar.iDZ, ((Integer) lVar.iDZ.getTag()).intValue());
                } else if (lVar.iDZ.getTag() instanceof String) {
                    if (lVar.iDZ.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = MV;
                    } else if (lVar.iDZ.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = MW;
                    } else {
                        layerDrawable = lVar.iDZ.getTag().equals("HOST") ? iBu : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(lVar.iEa, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.iEb, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.iEc, (int) R.color.cp_cont_d);
                am.setViewTextColor(lVar.iEl, R.color.cp_cont_d, 1);
                am.setViewTextColor(lVar.iEd, R.color.cp_cont_d, 1);
                lVar.iEg.setTextColor(am.getColor(R.color.cp_cont_b));
                lVar.iEh.onChangeSkinType();
                if (fVar != null) {
                    am.setViewTextColor(lVar.iEj, (int) R.color.cp_cont_c);
                    lVar.iEj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(lVar.iEk, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(lVar.iEi, R.color.cp_bg_line_g);
                    lVar.iEi.onChangeSkinType();
                    am.setViewTextColor(lVar.iEu, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(lVar.iEs, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(lVar.iEr, R.color.cp_bg_line_e);
                    am.setBackgroundResource(lVar.iEt, R.color.cp_cont_d);
                    am.setImageResource(lVar.iEv, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(lVar.iEy, (int) R.color.cp_cont_c);
                    if (lVar.iEw.getVisibility() == 8) {
                        lVar.iEj.setVisibility(8);
                        lVar.iEk.setVisibility(8);
                        lVar.iEy.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.cja())) {
                        lVar.iEy.setText(fVar.cja());
                    } else {
                        lVar.iEy.setText(R.string.expand_content);
                    }
                } else {
                    lVar.iEi.setVisibility(8);
                    lVar.iEj.setVisibility(8);
                    lVar.iEk.setVisibility(8);
                    lVar.iEr.setVisibility(8);
                    lVar.iEy.setVisibility(8);
                }
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.l lVar, PostData postData, bj bjVar, int i) {
        if (lVar != null && postData != null && postData.aBM() != null) {
            if (bjVar != null) {
                postData.aBM().threadId = bjVar.getTid();
                postData.aBM().forumId = String.valueOf(bjVar.getFid());
            }
            if (i == 0) {
                postData.aBM().objType = 1;
            } else {
                postData.aBM().objType = 2;
            }
            postData.aBM().isInPost = true;
            if (bjVar != null && bjVar.aBV()) {
                lVar.iEe.setAgreeAlone(true);
            }
            lVar.iEe.setData(postData.aBM());
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
            if (postData.azX() == null || postData.azX().getBaijiahaoInfo() != null) {
            }
            if (postData.kgd) {
                am.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            if (bjVar == null || bjVar.azX() == null) {
                str = null;
            } else {
                str = bjVar.azX().getUserId();
            }
            lVar.iEf.setTag(null);
            lVar.iEf.setUserId(null);
            lVar.ftZ.setText((CharSequence) null);
            lVar.iEn.getHeadView().setUserId(null);
            lVar.iEg.setIsHost(false);
            if (postData.azX() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.azX().getUserId())) {
                    lVar.iEg.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.azX().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.azX().getTShowInfoNew();
                if (lVar.iEp != null) {
                    lVar.iEp.setTag(R.id.tag_user_id, postData.azX().getUserId());
                    lVar.iEp.setOnClickListener(aVar.cjQ().iRh);
                    lVar.iEp.a(iconInfo, 2, iBt, iBt, dJY);
                }
                if (lVar.iEo != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.iEo.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.iEo.setOnClickListener(aVar.cjQ().iRi);
                    lVar.iEo.a(tShowInfoNew, 3, iBt, iBt, dJY, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.azX().isBigV()) {
                    am.setViewTextColor(lVar.ftZ, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(lVar.ftZ, R.color.cp_cont_f, 1);
                }
                String avater = postData.azX().getAvater();
                lVar.ftZ.setTag(R.id.tag_user_id, postData.azX().getUserId());
                lVar.ftZ.setTag(R.id.tag_user_name, postData.azX().getUserName());
                lVar.ftZ.setTag(R.id.tag_virtual_user_url, postData.azX().getVirtualUserUrl());
                String name_show = postData.azX().getName_show();
                String userName = postData.azX().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.ftZ.setText(d.ba(aVar.getPageContext().getPageActivity(), lVar.ftZ.getText().toString()));
                    lVar.ftZ.setGravity(16);
                    lVar.ftZ.setTag(R.id.tag_nick_name_activity, d.cix());
                    am.setViewTextColor(lVar.ftZ, R.color.cp_other_f, 1);
                }
                if (postData.azX().getPendantData() != null && !StringUtils.isNull(postData.azX().getPendantData().ayq())) {
                    lVar.iEn.b(postData.azX());
                    lVar.iEf.setVisibility(8);
                    lVar.iEn.setVisibility(0);
                    lVar.iEn.getHeadView().startLoad(avater, 28, false);
                    lVar.iEn.getHeadView().setUserId(postData.azX().getUserId());
                    lVar.iEn.getHeadView().setUserName(postData.azX().getUserName());
                    lVar.iEn.tC(postData.azX().getPendantData().ayq());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.iEf, postData.azX(), 0);
                    lVar.iEf.setUserId(postData.azX().getUserId());
                    lVar.iEf.setUserName(postData.azX().getUserName(), postData.cJJ());
                    lVar.iEf.setTag(R.id.tag_virtual_user_url, postData.azX().getVirtualUserUrl());
                    lVar.iEf.setImageDrawable(null);
                    lVar.iEf.startLoad(avater, 28, false);
                    lVar.iEf.setVisibility(0);
                    lVar.iEn.setVisibility(8);
                }
                if (bjVar != null && bjVar.aBV()) {
                    lVar.iDZ.setVisibility(8);
                    lVar.iDZ.setTag(null);
                } else if (postData.azX() != null) {
                    MetaData azX = postData.azX();
                    int kd = postData.cJr() ? R.drawable.brand_official_btn : am.kd(R.drawable.bg_user_identity_btn);
                    int kd2 = postData.cJr() ? R.color.cp_cont_a : am.kd(R.color.cp_bg_line_d);
                    am.setBackgroundResource(lVar.iDZ, kd);
                    am.setViewTextColor(lVar.iDZ, kd2);
                    lVar.iDZ.setTag(Integer.valueOf(kd));
                    if (str != null && !str.equals("0") && str.equals(azX.getUserId())) {
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.host_name);
                        lVar.iDZ.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (iBu != null && iBu.getDrawable(1) != null) {
                                iBu.getDrawable(1).setAlpha(255);
                            }
                        } else if (iBu != null && iBu.getDrawable(1) != null) {
                            iBu.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(iBu);
                    } else if (azX.getIs_bawu() == 1 && postData.cJr()) {
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.brand_Official);
                    } else if (azX.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(azX.getBawu_type())) {
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_member_bazhu_tip);
                        lVar.iDZ.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (MV != null && MV.getDrawable(1) != null) {
                                MV.getDrawable(1).setAlpha(255);
                            }
                        } else if (MV != null && MV.getDrawable(1) != null) {
                            MV.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(MV);
                    } else if (azX.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(azX.getBawu_type())) {
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_member_xbazhu_tip);
                        lVar.iDZ.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (MW != null && MW.getDrawable(1) != null) {
                                MW.getDrawable(1).setAlpha(255);
                            }
                        } else if (MW != null && MW.getDrawable(1) != null) {
                            MW.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(MW);
                    } else if (azX.getIs_bawu() == 1 && "pri_content_assist".equals(azX.getBawu_type())) {
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_content_assist_tip);
                    } else if (azX.getIs_bawu() == 1 && "pri_manage_assist".equals(azX.getBawu_type())) {
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.iDZ.setVisibility(8);
                        lVar.iDZ.setTag(null);
                    }
                } else {
                    lVar.iDZ.setVisibility(8);
                    lVar.iDZ.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cjR() && postData.azX() != null) {
                i2 = postData.azX().getLevel_id();
            }
            if (bjVar != null && bjVar.aBV()) {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.iEm.setVisibility(0);
                am.setImageResource(lVar.iEm, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.iEm.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.iEp.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.iEp.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.iDZ.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.iEo.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.azX() != null ? postData.azX().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.azX() != null && !StringUtils.isNull(postData.azX().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.azX() != null && !StringUtils.isNull(postData.azX().getSealPrefix())) {
                lVar.ftZ.setText(a(aVar, postData.azX().getSealPrefix(), name_show2));
            } else {
                lVar.ftZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cJz()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.azX() == null || StringUtils.isNull(postData.azX().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.cjT() != 0) {
                if (aVar.cjT() != 1002 && aVar.cjT() != 3) {
                    z8 = true;
                }
                if (aVar.cjT() != 3 && !bjVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.azX() != null) {
                    String userId2 = postData.azX().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bjVar != null && bjVar.azX() != null && postData.azX() != null) {
                            userId = bjVar.azX().getUserId();
                            String userId3 = postData.azX().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.azX() != null && UtilHelper.isCurrentAccount(postData.azX().getUserId())) {
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
                                if (postData.cJz() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aBV()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cjT()));
                                    if (postData.azX() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.azX().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.azX().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.azX().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.azX() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azX().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.azX().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azX().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bjVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bjVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cjT()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.iEg.setTag(sparseArray);
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
                        if (postData.cJz() == 1) {
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
                        lVar.iEg.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bjVar != null) {
                userId = bjVar.azX().getUserId();
                String userId32 = postData.azX().getUserId();
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
            if (postData.cJz() == 1) {
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
            lVar.iEg.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().dJT = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().mS((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.l lVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (lVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iEg.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                lVar.iEg.vN(null);
                lVar.iEg.setBackgroundDrawable(null);
                lVar.iEg.getLayoutStrategy().mT(R.drawable.transparent_bg);
            } else {
                lVar.iEg.getLayoutStrategy().mT(R.drawable.icon_click);
            }
            lVar.iEg.getLayoutStrategy().mQ(R.drawable.pic_video);
            a(lVar.iEg, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            lVar.iEg.setLayoutParams(layoutParams);
            lVar.iEg.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            lVar.iEg.setIsFromCDN(z2);
            TbRichText cJB = postData.cJB();
            lVar.iEg.setIsUseGridImage(postData.cJM());
            lVar.iEg.setText(cJB, true, cVar);
            SparseArray sparseArray = (SparseArray) lVar.iEg.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            lVar.iEg.setTag(sparseArray);
            lVar.iDY.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.l lVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.cJz() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cJz()));
                lVar.iEl.setVisibility(0);
                lVar.iEl.setText(format);
                z = true;
            } else {
                lVar.iEl.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cJC = postData.cJC();
            boolean z2 = (cJC == null || StringUtils.isNull(cJC.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                lVar.iEb.setVisibility(0);
                i = iBs;
            } else {
                lVar.iEb.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.iEc.setVisibility(0);
                i2 = iBs;
            } else {
                lVar.iEc.setVisibility(8);
                i2 = 0;
            }
            lVar.iEa.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                lVar.iEa.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.iEa.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.iEd.setVisibility(0);
                lVar.iEd.setPadding(iBs, 0, 0, 0);
                lVar.iEd.setText(cJC.getName());
                return;
            }
            lVar.iEd.setVisibility(8);
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.l lVar, PostData postData) {
        if (postData == null || postData.cqG() == null) {
            lVar.iEq.setVisibility(8);
            return;
        }
        TbRichText cJB = postData.cJB();
        com.baidu.tieba.pb.view.b.a(postData.cqG(), lVar.iEq, false, false, cJB != null && StringUtils.isNull(cJB.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(com.baidu.tieba.pb.pb.main.l lVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iEg.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.iEg.setLayoutParams(layoutParams);
            lVar.iEg.setPadding(0, 0, 0, 0);
            lVar.iEg.vN(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.iEg.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.iEg.setLayoutParams(layoutParams2);
            lVar.iEg.vN(postData.getBimg_url());
        }
        lVar.iEg.setTextViewCheckSelection(false);
    }
}
