package com.baidu.tieba.pb.pb;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.p.an;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> fKA = new SparseArray<>();
    private static SparseIntArray fKB = new SparseIntArray();
    public static final int fKC = getDimensionPixelSize(e.C0200e.tbds12);
    public static final int fKD = getDimensionPixelSize(e.C0200e.tbds20);
    public static final int fKE = getDimensionPixelSize(e.C0200e.tbds36);

    public static int getDimensionPixelSize(int i) {
        int i2 = fKB.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            fKB.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(j jVar, d dVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                al.c(jVar.cIi, e.d.cp_cont_f, 1);
                if (jVar.fOZ.getTag() instanceof Integer) {
                    al.i(jVar.fOZ, ((Integer) jVar.fOZ.getTag()).intValue());
                }
                al.c(jVar.fPa, e.d.cp_cont_d, 1);
                al.i(jVar.fPb, e.d.cp_cont_e);
                al.i(jVar.fPc, e.d.cp_cont_e);
                al.c(jVar.fPl, e.d.cp_cont_d, 1);
                al.c(jVar.fPd, e.d.cp_cont_d, 1);
                al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                al.c(jVar.fPe, e.f.icon_floor_more_selector);
                jVar.fPi.setTextColor(al.getColor(e.d.cp_cont_b));
                jVar.fPj.onChangeSkinType();
                if (dVar != null) {
                    jVar.fPk.setVisibility(0);
                    al.j(jVar.fPk, e.d.cp_bg_line_e);
                    jVar.fPk.onChangeSkinType();
                    al.c(jVar.fPu, e.d.cp_link_tip_c, 1);
                    al.c(jVar.fPs, e.d.cp_cont_f, 1);
                    al.i(jVar.fPr, e.d.cp_bg_line_e);
                    al.i(jVar.fPt, e.d.cp_cont_d);
                    al.c(jVar.fPv, e.f.icon_arrow_more_gray);
                    al.h(jVar.fPy, e.d.cp_cont_j);
                    if (jVar.fPw.getVisibility() == 8) {
                        jVar.fPy.setText(e.j.close_content);
                        al.c(jVar.fPz, e.f.icon_arrow_gray_up);
                    } else if (StringUtils.isNull(dVar.beB())) {
                        jVar.fPy.setText(dVar.beB());
                        al.c(jVar.fPz, e.f.icon_arrow_gray_down);
                    } else {
                        jVar.fPy.setText(e.j.expand_content);
                    }
                } else {
                    jVar.fPk.setVisibility(8);
                    jVar.fPr.setVisibility(8);
                    jVar.fPy.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bb bbVar, int i) {
        if (jVar != null && postData != null) {
            jVar.fPA.a(postData);
            jVar.fPf.setTag(e.g.tag_clip_board, postData);
            String valueOf = String.valueOf(bbVar.getFid());
            String id = postData.getId();
            String tid = bbVar.getTid();
            jVar.fPf.setForumId(valueOf);
            jVar.fPf.setThreadId(tid);
            jVar.fPf.setPostId(id);
            jVar.fPg.setForumId(valueOf);
            jVar.fPg.setThreadId(tid);
            jVar.fPg.setPostId(id);
            if (i == 0) {
                jVar.fPf.setObjType(1);
                jVar.fPg.setObjType(1);
                return;
            }
            jVar.fPf.setObjType(2);
            jVar.fPg.setObjType(2);
        }
    }

    public static void a(j jVar, PostData postData, View view, int i, a aVar, bb bbVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (jVar != null && postData != null) {
            if (postData.hfc) {
                al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bbVar == null || bbVar.yC() == null) {
                str = null;
            } else {
                str = bbVar.yC().getUserId();
            }
            jVar.fPh.setTag(null);
            jVar.fPh.setUserId(null);
            jVar.cIi.setText((CharSequence) null);
            jVar.fPn.getHeadView().setUserId(null);
            jVar.fPi.setIsHost(false);
            if (postData.yC() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.yC().getUserId())) {
                    jVar.fPi.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.yC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.yC().getTShowInfoNew();
                if (jVar.fPp != null) {
                    jVar.fPp.setTag(e.g.tag_user_id, postData.yC().getUserId());
                    jVar.fPp.setOnClickListener(aVar.bfm().fZv);
                    jVar.fPp.a(iconInfo, 2, fKE, fKE, fKC);
                }
                if (jVar.fPo != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fPo.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fPo.setOnClickListener(aVar.bfm().fZw);
                    jVar.fPo.a(tShowInfoNew, 3, fKE, fKE, fKC, true);
                }
                if (!v.I(tShowInfoNew) || postData.yC().isBigV()) {
                    al.c(jVar.cIi, e.d.cp_cont_h, 1);
                } else {
                    al.c(jVar.cIi, e.d.cp_cont_f, 1);
                }
                String portrait = postData.yC().getPortrait();
                jVar.cIi.setTag(e.g.tag_user_id, postData.yC().getUserId());
                jVar.cIi.setTag(e.g.tag_user_name, postData.yC().getUserName());
                jVar.cIi.setTag(e.g.tag_virtual_user_url, postData.yC().getVirtualUserUrl());
                String name_show = postData.yC().getName_show();
                String userName = postData.yC().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cIi.setText(c.aB(aVar.getPageContext().getPageActivity(), jVar.cIi.getText().toString()));
                    jVar.cIi.setGravity(16);
                    jVar.cIi.setTag(e.g.tag_nick_name_activity, c.bec());
                    al.c(jVar.cIi, e.d.cp_other_e, 1);
                }
                if (postData.yC().getPendantData() != null && !StringUtils.isNull(postData.yC().getPendantData().xn())) {
                    jVar.fPn.b(postData.yC());
                    jVar.fPh.setVisibility(8);
                    jVar.fPn.setVisibility(0);
                    jVar.fPn.getHeadView().startLoad(portrait, 28, false);
                    jVar.fPn.getHeadView().setUserId(postData.yC().getUserId());
                    jVar.fPn.getHeadView().setUserName(postData.yC().getUserName());
                    jVar.fPn.fT(postData.yC().getPendantData().xn());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fPh, postData.yC());
                    jVar.fPh.setUserId(postData.yC().getUserId());
                    jVar.fPh.setUserName(postData.yC().getUserName(), postData.bBH());
                    jVar.fPh.setTag(e.g.tag_virtual_user_url, postData.yC().getVirtualUserUrl());
                    jVar.fPh.setImageDrawable(null);
                    jVar.fPh.startLoad(portrait, 28, false);
                    jVar.fPh.setVisibility(0);
                    jVar.fPn.setVisibility(8);
                }
                if (postData.yC() != null) {
                    MetaData yC = postData.yC();
                    int i2 = postData.bBp() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bBp() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    al.i(jVar.fOZ, i2);
                    al.h(jVar.fOZ, i3);
                    jVar.fOZ.setTag(Integer.valueOf(i2));
                    if (str != null && !str.equals("0") && str.equals(yC.getUserId())) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.host_name);
                    } else if (yC.getIs_bawu() == 1 && postData.bBp()) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.brand_Official);
                    } else if (yC.getIs_bawu() == 1 && "manager".equals(yC.getBawu_type())) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.bawu_member_bazhu_tip);
                    } else if (yC.getIs_bawu() == 1 && "assist".equals(yC.getBawu_type())) {
                        jVar.fOZ.setVisibility(0);
                        jVar.fOZ.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fOZ.setVisibility(8);
                        jVar.fOZ.setTag(null);
                    }
                } else {
                    jVar.fOZ.setVisibility(8);
                    jVar.fOZ.setTag(null);
                }
            }
            int i4 = 0;
            if (aVar.bfn()) {
                if (postData.yC() != null) {
                    i4 = postData.yC().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fPm.setVisibility(0);
                al.c(jVar.fPm, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fPm.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fPp.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fPp.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fOZ.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fPo.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.yC() != null ? postData.yC().getName_show() : "";
            int iu = y.iu(name_show2);
            if (postData.yC() != null && !StringUtils.isNull(postData.yC().getSealPrefix())) {
                if (iu > i5 - 2) {
                    name_show2 = y.J(name_show2, i5 - 2) + "...";
                }
            } else if (iu > i5) {
                name_show2 = y.J(name_show2, i5) + "...";
            }
            if (postData.yC() != null && !StringUtils.isNull(postData.yC().getSealPrefix())) {
                jVar.cIi.setText(a(aVar, postData.yC().getSealPrefix(), name_show2));
            } else {
                jVar.cIi.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bBx()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            if (postData.yC() == null || StringUtils.isNull(postData.yC().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            if (bbVar != null && aVar.bfp() != 0) {
                if (aVar.bfp() != 1002) {
                    z4 = true;
                }
                z5 = true;
                if (postData != null && postData.yC() != null) {
                    String userId = postData.yC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z4 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z4 = false;
                    }
                }
            }
            if (bbVar != null && bbVar.yC() != null && postData.yC() != null) {
                String userId2 = bbVar.yC().getUserId();
                String userId3 = postData.yC().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z5 = true;
                    z6 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z6 = false;
                        z7 = true;
                    }
                }
            }
            if (postData == null || postData.yC() == null || !UtilHelper.isCurrentAccount(postData.yC().getUserId())) {
                z2 = z7;
                z3 = z5;
            } else {
                z2 = true;
                z3 = true;
            }
            if (z) {
                z4 = false;
                z3 = false;
                z6 = false;
            }
            int i6 = 1;
            if (postData.bBx() == 1) {
                i6 = 0;
            }
            if (z4) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bfp()));
                if (postData.yC() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.yC().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.yC().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.yC().getPortrait());
                }
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            if (z6) {
                sparseArray.put(e.g.tag_user_mute_visible, true);
                sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.yC() != null) {
                    sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yC().getUserId());
                    sparseArray.put(e.g.tag_user_mute_mute_username, postData.yC().getUserName());
                    sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yC().getName_show());
                }
                sparseArray.put(e.g.tag_user_mute_thread_id, bbVar.getId());
                sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z3 && bbVar != null) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bfp()));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            jVar.fPi.setTag(sparseArray);
            jVar.fPe.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gw(aO - (z ? getDimensionPixelSize(e.C0200e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gx((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fPi.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = l.h(pageActivity, e.C0200e.tbds50);
            layoutParams.rightMargin = l.h(pageActivity, e.C0200e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, e.C0200e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fPi.setPadding(h, 0, h, 0);
            if (z) {
                jVar.fPi.iI(null);
                jVar.fPi.setBackgroundDrawable(null);
                jVar.fPi.getLayoutStrategy().gy(e.f.transparent_bg);
            } else {
                jVar.fPi.getLayoutStrategy().gy(e.f.icon_click);
            }
            jVar.fPi.getLayoutStrategy().gv(e.f.pic_video);
            a(jVar.fPi, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.fPi.setLayoutParams(layoutParams);
            jVar.fPi.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            jVar.fPi.setIsFromCDN(z2);
            jVar.fPi.setText(postData.bBz(), true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.fPi.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.fPi.setTag(sparseArray);
            jVar.fOX.setTag(e.g.tag_from, sparseArray);
        }
    }

    public static void a(final a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bBx() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(e.j.is_floor), Integer.valueOf(postData.bBx()));
                jVar.fPl.setVisibility(0);
                jVar.fPl.setText(format);
                z = true;
            } else {
                jVar.fPl.setVisibility(8);
                z = false;
            }
            f bBA = postData.bBA();
            boolean z2 = (bBA == null || StringUtils.isNull(bBA.getName())) ? false : true;
            if (z) {
                jVar.fPb.setVisibility(0);
                i = fKD;
            } else {
                jVar.fPb.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fPc.setVisibility(0);
                i2 = fKD;
            } else {
                jVar.fPc.setVisibility(8);
                i2 = 0;
            }
            jVar.fPa.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fPa.setText(ao.G(postData.getTime()));
            } else {
                jVar.fPa.setText(ao.E(postData.getTime()));
            }
            if (z2) {
                final String name = bBA.getName();
                final String lat = bBA.getLat();
                final String lng = bBA.getLng();
                jVar.fPd.setVisibility(0);
                jVar.fPd.setPadding(fKD, 0, 0, 0);
                jVar.fPd.setText(bBA.getName());
                jVar.fPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (!com.baidu.adp.lib.util.j.kV()) {
                                aVar.getPageContext().showToast(e.j.neterror);
                            } else {
                                com.baidu.tbadk.browser.a.ac(aVar.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, TbadkApplication.getInst().getString(e.j.app_info_for_map)));
                            }
                        }
                    }
                });
                return;
            }
            jVar.fPd.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.blf() == null) {
            jVar.fPq.setVisibility(8);
            return;
        }
        TbRichText bBz = postData.bBz();
        com.baidu.tieba.pb.view.c.a(postData.blf(), jVar.fPq, false, false, bBz != null && StringUtils.isNull(bBz.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fPi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fPi.setLayoutParams(layoutParams);
            jVar.fPi.setPadding(0, 0, 0, 0);
            jVar.fPi.iI(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fPi.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0200e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0200e.ds20);
            jVar.fPi.setLayoutParams(layoutParams2);
            jVar.fPi.iI(postData.getBimg_url());
        }
        jVar.fPi.setTextViewCheckSelection(false);
    }
}
