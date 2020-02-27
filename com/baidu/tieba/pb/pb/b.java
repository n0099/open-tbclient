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
    private static LayerDrawable iDn;
    private static SparseArray<SoftReference<Drawable>> iDj = new SparseArray<>();
    private static SparseIntArray iDk = new SparseIntArray();
    public static final int dOd = getDimensionPixelSize(R.dimen.tbds12);
    public static final int iDl = getDimensionPixelSize(R.dimen.tbds16);
    public static final int iDm = getDimensionPixelSize(R.dimen.tbds40);
    public static final int aqI = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = iDk.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            iDk.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cls() {
        Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(aqI).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(aqI).tM("#4D000000").aHb()});
        Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(aqI).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(aqI).tM("#4D000000").aHb()});
        iDn = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(aqI).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(aqI).tM("#4D000000").aHb()});
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
                am.setViewTextColor(kVar.fwA, R.color.cp_cont_f, 1);
                if (kVar.iFD.getTag() instanceof Integer) {
                    am.setBackgroundResource(kVar.iFD, ((Integer) kVar.iFD.getTag()).intValue());
                } else if (kVar.iFD.getTag() instanceof String) {
                    if (kVar.iFD.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = Nu;
                    } else if (kVar.iFD.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = Nv;
                    } else {
                        layerDrawable = kVar.iFD.getTag().equals("HOST") ? iDn : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(kVar.iFE, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iFF, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iFG, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iFP, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iFH, R.color.cp_cont_d, 1);
                kVar.iFK.setTextColor(am.getColor(R.color.cp_cont_b));
                kVar.iFL.onChangeSkinType();
                if (eVar != null) {
                    am.setViewTextColor(kVar.iFN, (int) R.color.cp_cont_c);
                    kVar.iFN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(kVar.iFO, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(kVar.iFM, R.color.cp_bg_line_g);
                    kVar.iFM.onChangeSkinType();
                    am.setViewTextColor(kVar.iFY, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(kVar.iFW, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(kVar.iFV, R.color.cp_bg_line_e);
                    am.setBackgroundResource(kVar.iFX, R.color.cp_cont_d);
                    am.setImageResource(kVar.iFZ, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(kVar.iGc, (int) R.color.cp_cont_c);
                    if (kVar.iGa.getVisibility() == 8) {
                        kVar.iFN.setVisibility(8);
                        kVar.iFO.setVisibility(8);
                        kVar.iGc.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.ckA())) {
                        kVar.iGc.setText(eVar.ckA());
                    } else {
                        kVar.iGc.setText(R.string.expand_content);
                    }
                } else {
                    kVar.iFM.setVisibility(8);
                    kVar.iFN.setVisibility(8);
                    kVar.iFO.setVisibility(8);
                    kVar.iFV.setVisibility(8);
                    kVar.iGc.setVisibility(8);
                }
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(k kVar, PostData postData, bj bjVar, int i) {
        if (kVar != null && postData != null && postData.aDY() != null) {
            if (bjVar != null) {
                postData.aDY().threadId = bjVar.getTid();
                postData.aDY().forumId = String.valueOf(bjVar.getFid());
            }
            if (i == 0) {
                postData.aDY().objType = 1;
            } else {
                postData.aDY().objType = 2;
            }
            postData.aDY().isInPost = true;
            if (bjVar != null && bjVar.aEg()) {
                kVar.iFI.setAgreeAlone(true);
            }
            kVar.iFI.setData(postData.aDY());
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
            if (postData.aCm() == null || postData.aCm().isBaijiahaoUser()) {
            }
            if (postData.khe) {
                am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            if (bjVar == null || bjVar.aCm() == null) {
                str = null;
            } else {
                str = bjVar.aCm().getUserId();
            }
            kVar.iFJ.setTag(null);
            kVar.iFJ.setUserId(null);
            kVar.fwA.setText((CharSequence) null);
            kVar.iFR.getHeadView().setUserId(null);
            kVar.iFK.setIsHost(false);
            if (postData.aCm() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aCm().getUserId())) {
                    kVar.iFK.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCm().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCm().getTShowInfoNew();
                if (kVar.iFT != null) {
                    kVar.iFT.setTag(R.id.tag_user_id, postData.aCm().getUserId());
                    kVar.iFT.setOnClickListener(aVar.clo().iSC);
                    kVar.iFT.a(iconInfo, 2, iDm, iDm, dOd);
                }
                if (kVar.iFS != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iFS.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.iFS.setOnClickListener(aVar.clo().iSD);
                    kVar.iFS.a(tShowInfoNew, 3, iDm, iDm, dOd, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aCm().isBigV()) {
                    am.setViewTextColor(kVar.fwA, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(kVar.fwA, R.color.cp_cont_f, 1);
                }
                String avater = postData.aCm().getAvater();
                kVar.fwA.setTag(R.id.tag_user_id, postData.aCm().getUserId());
                kVar.fwA.setTag(R.id.tag_user_name, postData.aCm().getUserName());
                kVar.fwA.setTag(R.id.tag_virtual_user_url, postData.aCm().getVirtualUserUrl());
                String name_show = postData.aCm().getName_show();
                String userName = postData.aCm().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fwA.setText(c.ba(aVar.getPageContext().getPageActivity(), kVar.fwA.getText().toString()));
                    kVar.fwA.setGravity(16);
                    kVar.fwA.setTag(R.id.tag_nick_name_activity, c.ckb());
                    am.setViewTextColor(kVar.fwA, R.color.cp_other_f, 1);
                }
                if (postData.aCm().getPendantData() != null && !StringUtils.isNull(postData.aCm().getPendantData().aAE())) {
                    kVar.iFR.b(postData.aCm());
                    kVar.iFJ.setVisibility(8);
                    kVar.iFR.setVisibility(0);
                    kVar.iFR.getHeadView().startLoad(avater, 28, false);
                    kVar.iFR.getHeadView().setUserId(postData.aCm().getUserId());
                    kVar.iFR.getHeadView().setUserName(postData.aCm().getUserName());
                    kVar.iFR.tS(postData.aCm().getPendantData().aAE());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iFJ, postData.aCm(), 0);
                    kVar.iFJ.setUserId(postData.aCm().getUserId());
                    kVar.iFJ.setUserName(postData.aCm().getUserName(), postData.cLi());
                    kVar.iFJ.setTag(R.id.tag_virtual_user_url, postData.aCm().getVirtualUserUrl());
                    kVar.iFJ.setImageDrawable(null);
                    kVar.iFJ.startLoad(avater, 28, false);
                    kVar.iFJ.setVisibility(0);
                    kVar.iFR.setVisibility(8);
                }
                if (bjVar != null && bjVar.aEg()) {
                    kVar.iFD.setVisibility(8);
                    kVar.iFD.setTag(null);
                } else if (postData.aCm() != null) {
                    MetaData aCm = postData.aCm();
                    int ku = postData.cKQ() ? R.drawable.brand_official_btn : am.ku(R.drawable.bg_user_identity_btn);
                    int ku2 = postData.cKQ() ? R.color.cp_cont_a : am.ku(R.color.cp_bg_line_d);
                    am.setBackgroundResource(kVar.iFD, ku);
                    am.setViewTextColor(kVar.iFD, ku2);
                    kVar.iFD.setTag(Integer.valueOf(ku));
                    if (str != null && !str.equals("0") && str.equals(aCm.getUserId())) {
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.host_name);
                        kVar.iFD.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (iDn != null && iDn.getDrawable(1) != null) {
                                iDn.getDrawable(1).setAlpha(255);
                            }
                        } else if (iDn != null && iDn.getDrawable(1) != null) {
                            iDn.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(iDn);
                    } else if (aCm.getIs_bawu() == 1 && postData.cKQ()) {
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.brand_Official);
                    } else if (aCm.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCm.getBawu_type())) {
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_member_bazhu_tip);
                        kVar.iFD.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nu != null && Nu.getDrawable(1) != null) {
                                Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nu != null && Nu.getDrawable(1) != null) {
                            Nu.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(Nu);
                    } else if (aCm.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCm.getBawu_type())) {
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_member_xbazhu_tip);
                        kVar.iFD.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nv != null && Nv.getDrawable(1) != null) {
                                Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nv != null && Nv.getDrawable(1) != null) {
                            Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(Nv);
                    } else if (aCm.getIs_bawu() == 1 && "pri_content_assist".equals(aCm.getBawu_type())) {
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_content_assist_tip);
                    } else if (aCm.getIs_bawu() == 1 && "pri_manage_assist".equals(aCm.getBawu_type())) {
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iFD.setVisibility(8);
                        kVar.iFD.setTag(null);
                    }
                } else {
                    kVar.iFD.setVisibility(8);
                    kVar.iFD.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.clp() && postData.aCm() != null) {
                i2 = postData.aCm().getLevel_id();
            }
            if (bjVar != null && bjVar.aEg()) {
                i2 = 0;
            }
            if (i2 > 0) {
                kVar.iFQ.setVisibility(0);
                am.setImageResource(kVar.iFQ, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                kVar.iFQ.setVisibility(8);
            }
            int i3 = 20;
            if (kVar.iFT.getChildCount() == 1) {
                i3 = 18;
            } else if (kVar.iFT.getChildCount() > 1) {
                i3 = 16;
            }
            if (kVar.iFD.getVisibility() == 0) {
                i3 -= 2;
            }
            if (kVar.iFS.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aCm() != null ? postData.aCm().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.aCm() != null && !StringUtils.isNull(postData.aCm().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aCm() != null && !StringUtils.isNull(postData.aCm().getSealPrefix())) {
                kVar.fwA.setText(a(aVar, postData.aCm().getSealPrefix(), name_show2));
            } else {
                kVar.fwA.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cKY()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aCm() == null || StringUtils.isNull(postData.aCm().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.clr() != 0) {
                if (aVar.clr() != 1002 && aVar.clr() != 3) {
                    z8 = true;
                }
                if (aVar.clr() != 3 && !bjVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.aCm() != null) {
                    String userId2 = postData.aCm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bjVar != null && bjVar.aCm() != null && postData.aCm() != null) {
                            userId = bjVar.aCm().getUserId();
                            String userId3 = postData.aCm().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aCm() != null && UtilHelper.isCurrentAccount(postData.aCm().getUserId())) {
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
                                if (postData.cKY() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aEg()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clr()));
                                    if (postData.aCm() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aCm().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCm().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCm().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aCm() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCm().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCm().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCm().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bjVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bjVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clr()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iFK.setTag(sparseArray);
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
                        if (postData.cKY() == 1) {
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
                        kVar.iFK.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bjVar != null) {
                userId = bjVar.aCm().getUserId();
                String userId32 = postData.aCm().getUserId();
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
            if (postData.cKY() == 1) {
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
            kVar.iFK.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().dNY = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nj((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, k kVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (kVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                kVar.iFK.wh(null);
                kVar.iFK.setBackgroundDrawable(null);
                kVar.iFK.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                kVar.iFK.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            kVar.iFK.getLayoutStrategy().nh(R.drawable.pic_video);
            a(kVar.iFK, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            kVar.iFK.setLayoutParams(layoutParams);
            kVar.iFK.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            kVar.iFK.setIsFromCDN(z2);
            TbRichText cLa = postData.cLa();
            kVar.iFK.setIsUseGridImage(postData.cLl());
            kVar.iFK.setText(cLa, true, cVar);
            SparseArray sparseArray = (SparseArray) kVar.iFK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            kVar.iFK.setTag(sparseArray);
            kVar.iFC.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, k kVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cKY() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cKY()));
                kVar.iFP.setVisibility(0);
                kVar.iFP.setText(format);
                z = true;
            } else {
                kVar.iFP.setVisibility(8);
                z = false;
            }
            f cLb = postData.cLb();
            boolean z2 = (cLb == null || StringUtils.isNull(cLb.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                kVar.iFF.setVisibility(0);
                i = iDl;
            } else {
                kVar.iFF.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iFG.setVisibility(0);
                i2 = iDl;
            } else {
                kVar.iFG.setVisibility(8);
                i2 = 0;
            }
            kVar.iFE.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iFE.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iFE.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iFH.setVisibility(0);
                kVar.iFH.setPadding(iDl, 0, 0, 0);
                kVar.iFH.setText(cLb.getName());
                return;
            }
            kVar.iFH.setVisibility(8);
        }
    }

    public static void a(k kVar, PostData postData) {
        if (postData == null || postData.crX() == null) {
            kVar.iFU.setVisibility(8);
            return;
        }
        TbRichText cLa = postData.cLa();
        com.baidu.tieba.pb.view.b.a(postData.crX(), kVar.iFU, false, false, cLa != null && StringUtils.isNull(cLa.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(k kVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iFK.setLayoutParams(layoutParams);
            kVar.iFK.setPadding(0, 0, 0, 0);
            kVar.iFK.wh(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFK.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iFK.setLayoutParams(layoutParams2);
            kVar.iFK.wh(postData.getBimg_url());
        }
        kVar.iFK.setTextViewCheckSelection(false);
    }
}
