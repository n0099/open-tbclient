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
    private static LayerDrawable iDp;
    private static SparseArray<SoftReference<Drawable>> iDl = new SparseArray<>();
    private static SparseIntArray iDm = new SparseIntArray();
    public static final int dOe = getDimensionPixelSize(R.dimen.tbds12);
    public static final int iDn = getDimensionPixelSize(R.dimen.tbds16);
    public static final int iDo = getDimensionPixelSize(R.dimen.tbds40);
    public static final int aqI = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = iDm.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            iDm.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void clu() {
        Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(aqI).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(aqI).tM("#4D000000").aHd()});
        Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(aqI).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(aqI).tM("#4D000000").aHd()});
        iDp = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(aqI).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(aqI).tM("#4D000000").aHd()});
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
                am.setViewTextColor(kVar.fwB, R.color.cp_cont_f, 1);
                if (kVar.iFF.getTag() instanceof Integer) {
                    am.setBackgroundResource(kVar.iFF, ((Integer) kVar.iFF.getTag()).intValue());
                } else if (kVar.iFF.getTag() instanceof String) {
                    if (kVar.iFF.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = Nu;
                    } else if (kVar.iFF.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = Nv;
                    } else {
                        layerDrawable = kVar.iFF.getTag().equals("HOST") ? iDp : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(layerDrawable);
                    }
                }
                am.setViewTextColor(kVar.iFG, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iFH, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iFI, (int) R.color.cp_cont_d);
                am.setViewTextColor(kVar.iFR, R.color.cp_cont_d, 1);
                am.setViewTextColor(kVar.iFJ, R.color.cp_cont_d, 1);
                kVar.iFM.setTextColor(am.getColor(R.color.cp_cont_b));
                kVar.iFN.onChangeSkinType();
                if (eVar != null) {
                    am.setViewTextColor(kVar.iFP, (int) R.color.cp_cont_c);
                    kVar.iFP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    am.setViewTextColor(kVar.iFQ, (int) R.color.cp_cont_c);
                    am.setBackgroundColor(kVar.iFO, R.color.cp_bg_line_g);
                    kVar.iFO.onChangeSkinType();
                    am.setViewTextColor(kVar.iGa, R.color.cp_link_tip_c, 1);
                    am.setViewTextColor(kVar.iFY, R.color.cp_cont_f, 1);
                    am.setBackgroundResource(kVar.iFX, R.color.cp_bg_line_e);
                    am.setBackgroundResource(kVar.iFZ, R.color.cp_cont_d);
                    am.setImageResource(kVar.iGb, R.drawable.icon_arrow_more_gray);
                    am.setViewTextColor(kVar.iGe, (int) R.color.cp_cont_c);
                    if (kVar.iGc.getVisibility() == 8) {
                        kVar.iFP.setVisibility(8);
                        kVar.iFQ.setVisibility(8);
                        kVar.iGe.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.ckC())) {
                        kVar.iGe.setText(eVar.ckC());
                    } else {
                        kVar.iGe.setText(R.string.expand_content);
                    }
                } else {
                    kVar.iFO.setVisibility(8);
                    kVar.iFP.setVisibility(8);
                    kVar.iFQ.setVisibility(8);
                    kVar.iFX.setVisibility(8);
                    kVar.iGe.setVisibility(8);
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
                kVar.iFK.setAgreeAlone(true);
            }
            kVar.iFK.setData(postData.aEa());
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
            if (postData.khg) {
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
            kVar.iFL.setTag(null);
            kVar.iFL.setUserId(null);
            kVar.fwB.setText((CharSequence) null);
            kVar.iFT.getHeadView().setUserId(null);
            kVar.iFM.setIsHost(false);
            if (postData.aCo() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aCo().getUserId())) {
                    kVar.iFM.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCo().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCo().getTShowInfoNew();
                if (kVar.iFV != null) {
                    kVar.iFV.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                    kVar.iFV.setOnClickListener(aVar.clq().iSE);
                    kVar.iFV.a(iconInfo, 2, iDo, iDo, dOe);
                }
                if (kVar.iFU != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iFU.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.iFU.setOnClickListener(aVar.clq().iSF);
                    kVar.iFU.a(tShowInfoNew, 3, iDo, iDo, dOe, true);
                }
                if (!v.isEmpty(tShowInfoNew) || postData.aCo().isBigV()) {
                    am.setViewTextColor(kVar.fwB, R.color.cp_cont_h, 1);
                } else {
                    am.setViewTextColor(kVar.fwB, R.color.cp_cont_f, 1);
                }
                String avater = postData.aCo().getAvater();
                kVar.fwB.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                kVar.fwB.setTag(R.id.tag_user_name, postData.aCo().getUserName());
                kVar.fwB.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                String name_show = postData.aCo().getName_show();
                String userName = postData.aCo().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fwB.setText(c.ba(aVar.getPageContext().getPageActivity(), kVar.fwB.getText().toString()));
                    kVar.fwB.setGravity(16);
                    kVar.fwB.setTag(R.id.tag_nick_name_activity, c.ckd());
                    am.setViewTextColor(kVar.fwB, R.color.cp_other_f, 1);
                }
                if (postData.aCo().getPendantData() != null && !StringUtils.isNull(postData.aCo().getPendantData().aAG())) {
                    kVar.iFT.b(postData.aCo());
                    kVar.iFL.setVisibility(8);
                    kVar.iFT.setVisibility(0);
                    kVar.iFT.getHeadView().startLoad(avater, 28, false);
                    kVar.iFT.getHeadView().setUserId(postData.aCo().getUserId());
                    kVar.iFT.getHeadView().setUserName(postData.aCo().getUserName());
                    kVar.iFT.tS(postData.aCo().getPendantData().aAG());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iFL, postData.aCo(), 0);
                    kVar.iFL.setUserId(postData.aCo().getUserId());
                    kVar.iFL.setUserName(postData.aCo().getUserName(), postData.cLk());
                    kVar.iFL.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                    kVar.iFL.setImageDrawable(null);
                    kVar.iFL.startLoad(avater, 28, false);
                    kVar.iFL.setVisibility(0);
                    kVar.iFT.setVisibility(8);
                }
                if (bjVar != null && bjVar.aEi()) {
                    kVar.iFF.setVisibility(8);
                    kVar.iFF.setTag(null);
                } else if (postData.aCo() != null) {
                    MetaData aCo = postData.aCo();
                    int ku = postData.cKS() ? R.drawable.brand_official_btn : am.ku(R.drawable.bg_user_identity_btn);
                    int ku2 = postData.cKS() ? R.color.cp_cont_a : am.ku(R.color.cp_bg_line_d);
                    am.setBackgroundResource(kVar.iFF, ku);
                    am.setViewTextColor(kVar.iFF, ku2);
                    kVar.iFF.setTag(Integer.valueOf(ku));
                    if (str != null && !str.equals("0") && str.equals(aCo.getUserId())) {
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.host_name);
                        kVar.iFF.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (iDp != null && iDp.getDrawable(1) != null) {
                                iDp.getDrawable(1).setAlpha(255);
                            }
                        } else if (iDp != null && iDp.getDrawable(1) != null) {
                            iDp.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(iDp);
                    } else if (aCo.getIs_bawu() == 1 && postData.cKS()) {
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.brand_Official);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_member_bazhu_tip);
                        kVar.iFF.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nu != null && Nu.getDrawable(1) != null) {
                                Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nu != null && Nu.getDrawable(1) != null) {
                            Nu.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(Nu);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_member_xbazhu_tip);
                        kVar.iFF.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (Nv != null && Nv.getDrawable(1) != null) {
                                Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (Nv != null && Nv.getDrawable(1) != null) {
                            Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(Nv);
                    } else if (aCo.getIs_bawu() == 1 && "pri_content_assist".equals(aCo.getBawu_type())) {
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_content_assist_tip);
                    } else if (aCo.getIs_bawu() == 1 && "pri_manage_assist".equals(aCo.getBawu_type())) {
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iFF.setVisibility(8);
                        kVar.iFF.setTag(null);
                    }
                } else {
                    kVar.iFF.setVisibility(8);
                    kVar.iFF.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.clr() && postData.aCo() != null) {
                i2 = postData.aCo().getLevel_id();
            }
            if (bjVar != null && bjVar.aEi()) {
                i2 = 0;
            }
            if (i2 > 0) {
                kVar.iFS.setVisibility(0);
                am.setImageResource(kVar.iFS, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                kVar.iFS.setVisibility(8);
            }
            int i3 = 20;
            if (kVar.iFV.getChildCount() == 1) {
                i3 = 18;
            } else if (kVar.iFV.getChildCount() > 1) {
                i3 = 16;
            }
            if (kVar.iFF.getVisibility() == 0) {
                i3 -= 2;
            }
            if (kVar.iFU.getChildCount() > 0) {
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
                kVar.fwB.setText(a(aVar, postData.aCo().getSealPrefix(), name_show2));
            } else {
                kVar.fwB.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLa()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aCo() == null || StringUtils.isNull(postData.aCo().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bjVar != null && aVar.clt() != 0) {
                if (aVar.clt() != 1002 && aVar.clt() != 3) {
                    z8 = true;
                }
                if (aVar.clt() != 3 && !bjVar.isBjh()) {
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
                                if (postData.cLa() == 1) {
                                    i4 = 0;
                                }
                                if (bjVar != null && bjVar.aEi()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clt()));
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
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.clt()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iFM.setTag(sparseArray);
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
                        if (postData.cLa() == 1) {
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
                        kVar.iFM.setTag(sparseArray);
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
            if (postData.cLa() == 1) {
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
            kVar.iFM.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().dNZ = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nj((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, k kVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (kVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                kVar.iFM.wh(null);
                kVar.iFM.setBackgroundDrawable(null);
                kVar.iFM.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                kVar.iFM.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            kVar.iFM.getLayoutStrategy().nh(R.drawable.pic_video);
            a(kVar.iFM, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            kVar.iFM.setLayoutParams(layoutParams);
            kVar.iFM.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            kVar.iFM.setIsFromCDN(z2);
            TbRichText cLc = postData.cLc();
            kVar.iFM.setIsUseGridImage(postData.cLn());
            kVar.iFM.setText(cLc, true, cVar);
            SparseArray sparseArray = (SparseArray) kVar.iFM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            kVar.iFM.setTag(sparseArray);
            kVar.iFE.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, k kVar, PostData postData, bj bjVar) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cLa() > 0 && bjVar != null && !bjVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.cLa()));
                kVar.iFR.setVisibility(0);
                kVar.iFR.setText(format);
                z = true;
            } else {
                kVar.iFR.setVisibility(8);
                z = false;
            }
            f cLd = postData.cLd();
            boolean z2 = (cLd == null || StringUtils.isNull(cLd.getName()) || bjVar == null || bjVar.isBjh()) ? false : true;
            if (z) {
                kVar.iFH.setVisibility(0);
                i = iDn;
            } else {
                kVar.iFH.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iFI.setVisibility(0);
                i2 = iDn;
            } else {
                kVar.iFI.setVisibility(8);
                i2 = 0;
            }
            kVar.iFG.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iFG.setText(aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iFG.setText(aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iFJ.setVisibility(0);
                kVar.iFJ.setPadding(iDn, 0, 0, 0);
                kVar.iFJ.setText(cLd.getName());
                return;
            }
            kVar.iFJ.setVisibility(8);
        }
    }

    public static void a(k kVar, PostData postData) {
        if (postData == null || postData.crZ() == null) {
            kVar.iFW.setVisibility(8);
            return;
        }
        TbRichText cLc = postData.cLc();
        com.baidu.tieba.pb.view.b.a(postData.crZ(), kVar.iFW, false, false, cLc != null && StringUtils.isNull(cLc.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(k kVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iFM.setLayoutParams(layoutParams);
            kVar.iFM.setPadding(0, 0, 0, 0);
            kVar.iFM.wh(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iFM.setLayoutParams(layoutParams2);
            kVar.iFM.wh(postData.getBimg_url());
        }
        kVar.iFM.setTextViewCheckSelection(false);
    }
}
