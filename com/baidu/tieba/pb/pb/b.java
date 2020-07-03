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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class b {
    private static LayerDrawable ahK;
    private static LayerDrawable ahL;
    private static LayerDrawable kaM;
    private static SparseArray<SoftReference<Drawable>> kaI = new SparseArray<>();
    private static SparseIntArray kaJ = new SparseIntArray();
    public static final int eNE = getDimensionPixelSize(R.dimen.tbds12);
    public static final int kaK = getDimensionPixelSize(R.dimen.tbds16);
    public static final int kaL = getDimensionPixelSize(R.dimen.tbds36);
    public static final int igf = getDimensionPixelSize(R.dimen.tbds6);

    public static int getDimensionPixelSize(int i) {
        int i2 = kaJ.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            kaJ.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    public static void cHX() {
        ahK = new LayerDrawable(new Drawable[]{c.aXu().lG(0).Q(igf).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aXw(), c.aXu().lG(0).Q(igf).xa("#4D000000").aXw()});
        ahL = new LayerDrawable(new Drawable[]{c.aXu().lG(0).Q(igf).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aXw(), c.aXu().lG(0).Q(igf).xa("#4D000000").aXw()});
        kaM = new LayerDrawable(new Drawable[]{c.aXu().lG(0).Q(igf).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aXw(), c.aXu().lG(0).Q(igf).xa("#4D000000").aXw()});
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

    public static void a(l lVar, e eVar, boolean z) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                an.setViewTextColor(lVar.gDT, R.color.cp_cont_f, 1);
                if (lVar.kdk.getTag() instanceof Integer) {
                    an.setBackgroundResource(lVar.kdk, ((Integer) lVar.kdk.getTag()).intValue());
                } else if (lVar.kdk.getTag() instanceof String) {
                    if (lVar.kdk.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = ahK;
                    } else if (lVar.kdk.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = ahL;
                    } else {
                        layerDrawable = lVar.kdk.getTag().equals("HOST") ? kaM : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(layerDrawable);
                    }
                }
                an.setViewTextColor(lVar.kdl, R.color.cp_cont_d, 1);
                an.setViewTextColor(lVar.kdm, (int) R.color.cp_cont_d);
                an.setViewTextColor(lVar.kdn, (int) R.color.cp_cont_d);
                an.setViewTextColor(lVar.kdy, R.color.cp_cont_d, 1);
                an.setViewTextColor(lVar.kdo, R.color.cp_cont_d, 1);
                lVar.kds.setTextColor(an.getColor(R.color.cp_cont_b));
                lVar.kdt.onChangeSkinType();
                if (z) {
                    SvgManager.aWQ().a(lVar.kdx, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aWQ().a(lVar.iyL, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (eVar != null) {
                    an.setViewTextColor(lVar.kdv, (int) R.color.cp_cont_c);
                    lVar.kdv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                    an.setViewTextColor(lVar.kdw, (int) R.color.cp_cont_c);
                    an.setBackgroundColor(lVar.kdu, R.color.cp_bg_line_g);
                    lVar.kdu.onChangeSkinType();
                    an.setViewTextColor(lVar.kdH, R.color.cp_link_tip_c, 1);
                    an.setViewTextColor(lVar.kdF, R.color.cp_cont_f, 1);
                    an.setBackgroundResource(lVar.kdE, R.color.cp_bg_line_e);
                    an.setBackgroundResource(lVar.kdG, R.color.cp_cont_d);
                    an.setImageResource(lVar.kdI, R.drawable.icon_arrow_more_gray);
                    an.setViewTextColor(lVar.kdL, (int) R.color.cp_cont_c);
                    if (lVar.kdJ.getVisibility() == 8) {
                        lVar.kdv.setVisibility(8);
                        lVar.kdw.setVisibility(8);
                        lVar.kdL.setText(R.string.close_content);
                    } else if (StringUtils.isNull(eVar.cGY())) {
                        lVar.kdL.setText(eVar.cGY());
                    } else {
                        lVar.kdL.setText(R.string.expand_content);
                    }
                } else {
                    lVar.kdu.setVisibility(8);
                    lVar.kdv.setVisibility(8);
                    lVar.kdw.setVisibility(8);
                    lVar.kdE.setVisibility(8);
                    lVar.kdL.setVisibility(8);
                }
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(l lVar, PostData postData, bu buVar, int i) {
        if (lVar != null && postData != null && postData.aUg() != null) {
            if (buVar != null) {
                postData.aUg().threadId = buVar.getTid();
                postData.aUg().forumId = String.valueOf(buVar.getFid());
            }
            if (i == 0) {
                postData.aUg().objType = 1;
            } else {
                postData.aUg().objType = 2;
            }
            postData.aUg().isInPost = true;
            if (buVar != null && buVar.aQZ()) {
                lVar.kdp.setAgreeAlone(true);
            }
            lVar.kdp.setData(postData.aUg());
        }
    }

    public static void a(l lVar, boolean z) {
        if (lVar.iyL != null) {
            lVar.iyL.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0497 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0794  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(l lVar, PostData postData, View view, int i, a aVar, bu buVar) {
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
            if (postData.aSp() == null || postData.aSp().isBaijiahaoUser()) {
            }
            if (postData.lGy) {
                an.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            if (buVar == null || buVar.aSp() == null) {
                str = null;
            } else {
                str = buVar.aSp().getUserId();
            }
            lVar.kdr.setTag(null);
            lVar.kdr.setUserId(null);
            lVar.gDT.setText((CharSequence) null);
            lVar.kdA.getHeadView().setUserId(null);
            lVar.kds.setIsHost(false);
            if (postData.aSp() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.aSp().getUserId())) {
                    lVar.kds.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aSp().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aSp().getTShowInfoNew();
                if (lVar.kdC != null) {
                    lVar.kdC.setTag(R.id.tag_user_id, postData.aSp().getUserId());
                    lVar.kdC.setOnClickListener(aVar.cHT().kqZ);
                    lVar.kdC.a(iconInfo, 2, kaL, kaL, eNE);
                }
                if (lVar.kdB != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.kdB.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.kdB.setOnClickListener(aVar.cHT().kra);
                    lVar.kdB.a(tShowInfoNew, 3, kaL, kaL, eNE, true);
                }
                if (!w.isEmpty(tShowInfoNew) || postData.aSp().isBigV()) {
                    an.setViewTextColor(lVar.gDT, R.color.cp_cont_h, 1);
                } else {
                    an.setViewTextColor(lVar.gDT, R.color.cp_cont_f, 1);
                }
                String avater = postData.aSp().getAvater();
                lVar.gDT.setTag(R.id.tag_user_id, postData.aSp().getUserId());
                lVar.gDT.setTag(R.id.tag_user_name, postData.aSp().getUserName());
                lVar.gDT.setTag(R.id.tag_virtual_user_url, postData.aSp().getVirtualUserUrl());
                String name_show = postData.aSp().getName_show();
                String userName = postData.aSp().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.gDT.setText(com.baidu.tieba.pb.c.aK(aVar.getPageContext().getPageActivity(), lVar.gDT.getText().toString()));
                    lVar.gDT.setGravity(16);
                    lVar.gDT.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cGx());
                    an.setViewTextColor(lVar.gDT, R.color.cp_other_f, 1);
                }
                if (postData.aSp().getPendantData() != null && !StringUtils.isNull(postData.aSp().getPendantData().aQl())) {
                    lVar.kdA.setBigVDimenSize(R.dimen.tbds32);
                    lVar.kdA.a(postData.aSp(), 4);
                    lVar.kdr.setVisibility(8);
                    lVar.kdA.setVisibility(0);
                    lVar.kdA.getHeadView().startLoad(avater, 28, false);
                    lVar.kdA.getHeadView().setUserId(postData.aSp().getUserId());
                    lVar.kdA.getHeadView().setUserName(postData.aSp().getUserName());
                    lVar.kdA.xg(postData.aSp().getPendantData().aQl());
                } else {
                    lVar.kdr.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(lVar.kdr, postData.aSp(), 4);
                    lVar.kdr.setUserId(postData.aSp().getUserId());
                    lVar.kdr.setUserName(postData.aSp().getUserName(), postData.dii());
                    lVar.kdr.setTag(R.id.tag_virtual_user_url, postData.aSp().getVirtualUserUrl());
                    lVar.kdr.setImageDrawable(null);
                    lVar.kdr.startLoad(avater, 28, false);
                    lVar.kdr.setVisibility(0);
                    lVar.kdA.setVisibility(8);
                }
                if (buVar != null && buVar.aQZ()) {
                    lVar.kdk.setVisibility(8);
                    lVar.kdk.setTag(null);
                } else if (postData.aSp() != null) {
                    MetaData aSp = postData.aSp();
                    int lr = postData.dhQ() ? R.drawable.brand_official_btn : an.lr(R.drawable.bg_user_identity_btn);
                    int lr2 = postData.dhQ() ? R.color.cp_cont_a : an.lr(R.color.cp_bg_line_d);
                    an.setBackgroundResource(lVar.kdk, lr);
                    an.setViewTextColor(lVar.kdk, lr2);
                    lVar.kdk.setTag(Integer.valueOf(lr));
                    if (str != null && !str.equals("0") && str.equals(aSp.getUserId())) {
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.host_name);
                        lVar.kdk.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (kaM != null && kaM.getDrawable(1) != null) {
                                kaM.getDrawable(1).setAlpha(255);
                            }
                        } else if (kaM != null && kaM.getDrawable(1) != null) {
                            kaM.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(kaM);
                    } else if (aSp.getIs_bawu() == 1 && postData.dhQ()) {
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.brand_Official);
                    } else if (aSp.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aSp.getBawu_type())) {
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_member_bazhu_tip);
                        lVar.kdk.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (ahK != null && ahK.getDrawable(1) != null) {
                                ahK.getDrawable(1).setAlpha(255);
                            }
                        } else if (ahK != null && ahK.getDrawable(1) != null) {
                            ahK.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(ahK);
                    } else if (aSp.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aSp.getBawu_type())) {
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_member_xbazhu_tip);
                        lVar.kdk.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (ahL != null && ahL.getDrawable(1) != null) {
                                ahL.getDrawable(1).setAlpha(255);
                            }
                        } else if (ahL != null && ahL.getDrawable(1) != null) {
                            ahL.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(ahL);
                    } else if (aSp.getIs_bawu() == 1 && "pri_content_assist".equals(aSp.getBawu_type())) {
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_content_assist_tip);
                    } else if (aSp.getIs_bawu() == 1 && "pri_manage_assist".equals(aSp.getBawu_type())) {
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.kdk.setVisibility(8);
                        lVar.kdk.setTag(null);
                    }
                } else {
                    lVar.kdk.setVisibility(8);
                    lVar.kdk.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.cHU() && postData.aSp() != null) {
                i2 = postData.aSp().getLevel_id();
            }
            if (buVar != null && buVar.aQZ()) {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.kdz.setVisibility(0);
                an.setImageResource(lVar.kdz, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.kdz.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.kdC.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.kdC.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.kdk.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.kdB.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.aSp() != null ? postData.aSp().getName_show() : "";
            int textLengthWithEmoji = ae.getTextLengthWithEmoji(name_show2);
            if (postData.aSp() != null && !StringUtils.isNull(postData.aSp().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ae.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ae.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.aSp() != null && !StringUtils.isNull(postData.aSp().getSealPrefix())) {
                lVar.gDT.setText(a(aVar, postData.aSp().getSealPrefix(), name_show2));
            } else {
                lVar.gDT.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dhY()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.aSp() == null || StringUtils.isNull(postData.aSp().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (buVar != null && aVar.cHW() != 0) {
                if (aVar.cHW() != 1002 && aVar.cHW() != 3) {
                    z8 = true;
                }
                if (aVar.cHW() != 3 && !buVar.isBjh()) {
                    z9 = true;
                }
                if (postData != null && postData.aSp() != null) {
                    String userId2 = postData.aSp().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (buVar != null && buVar.aSp() != null && postData.aSp() != null) {
                            userId = buVar.aSp().getUserId();
                            String userId3 = postData.aSp().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.aSp() != null && UtilHelper.isCurrentAccount(postData.aSp().getUserId())) {
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
                                if (postData.dhY() == 1) {
                                    i4 = 0;
                                }
                                if (buVar != null && buVar.aQZ()) {
                                    z2 = false;
                                    z5 = false;
                                }
                                if (z2) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cHW()));
                                    if (postData.aSp() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aSp().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aSp().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aSp().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aSp() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aSp().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aSp().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aSp().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, buVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && buVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.cHW()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.kds.setTag(sparseArray);
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
                        if (postData.dhY() == 1) {
                        }
                        if (buVar != null) {
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
                        lVar.kds.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (buVar != null) {
                userId = buVar.aSp().getUserId();
                String userId32 = postData.aSp().getUserId();
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
            if (postData.dhY() == 1) {
            }
            if (buVar != null) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            lVar.kds.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().oy(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eNz = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oz((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, l lVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (lVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.kds.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                lVar.kds.zx(null);
                lVar.kds.setBackgroundDrawable(null);
                lVar.kds.getLayoutStrategy().oA(R.drawable.transparent_bg);
            } else {
                lVar.kds.getLayoutStrategy().oA(R.drawable.icon_click);
            }
            lVar.kds.getLayoutStrategy().ox(R.drawable.pic_video);
            a(lVar.kds, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            lVar.kds.setLayoutParams(layoutParams);
            lVar.kds.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
            lVar.kds.setIsFromCDN(z2);
            lVar.kds.setText(postData.dia(), true, cVar);
            SparseArray sparseArray = (SparseArray) lVar.kds.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            lVar.kds.setTag(sparseArray);
            lVar.kdj.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, l lVar, PostData postData, bu buVar) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.dhY() > 0 && buVar != null && !buVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dhY()));
                lVar.kdy.setVisibility(0);
                lVar.kdy.setText(format);
                z = true;
            } else {
                lVar.kdy.setVisibility(8);
                z = false;
            }
            f dib = postData.dib();
            boolean z2 = (dib == null || StringUtils.isNull(dib.getName()) || buVar == null || buVar.isBjh()) ? false : true;
            if (z) {
                lVar.kdm.setVisibility(0);
                i = kaK;
            } else {
                lVar.kdm.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.kdn.setVisibility(0);
                i2 = kaK;
            } else {
                lVar.kdn.setVisibility(8);
                i2 = 0;
            }
            lVar.kdl.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.kdl.setText(ar.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.kdl.setText(ar.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.kdo.setVisibility(0);
                lVar.kdo.setPadding(kaK, 0, 0, 0);
                lVar.kdo.setText(dib.getName());
                return;
            }
            lVar.kdo.setVisibility(8);
        }
    }

    public static void a(l lVar, PostData postData) {
        if (postData == null || postData.cOE() == null) {
            lVar.kdD.setVisibility(8);
            return;
        }
        TbRichText dia = postData.dia();
        com.baidu.tieba.pb.view.b.a(postData.cOE(), lVar.kdD, false, false, dia != null && StringUtils.isNull(dia.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(l lVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.kds.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.kds.setLayoutParams(layoutParams);
            lVar.kds.setPadding(0, 0, 0, 0);
            lVar.kds.zx(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.kds.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.kds.setLayoutParams(layoutParams2);
            lVar.kds.zx(postData.getBimg_url());
        }
        lVar.kds.setTextViewCheckSelection(false);
    }
}
