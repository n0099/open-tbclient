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
import com.baidu.tbadk.p.am;
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
/* loaded from: classes2.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> fBz = new SparseArray<>();
    private static SparseIntArray fBA = new SparseIntArray();
    public static final int fBB = getDimensionPixelSize(e.C0141e.tbds12);
    public static final int fBC = getDimensionPixelSize(e.C0141e.tbds20);
    public static final int fBD = getDimensionPixelSize(e.C0141e.tbds36);

    public static int getDimensionPixelSize(int i) {
        int i2 = fBA.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            fBA.put(i, dimensionPixelSize);
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
                al.c(jVar.cyw, e.d.cp_cont_f, 1);
                if (jVar.fFY.getTag() instanceof Integer) {
                    al.i(jVar.fFY, ((Integer) jVar.fFY.getTag()).intValue());
                }
                al.c(jVar.fFZ, e.d.cp_cont_d, 1);
                al.i(jVar.fGa, e.d.cp_cont_e);
                al.i(jVar.fGb, e.d.cp_cont_e);
                al.c(jVar.fGk, e.d.cp_cont_d, 1);
                al.c(jVar.fGc, e.d.cp_cont_d, 1);
                al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                al.c(jVar.fGd, e.f.icon_floor_more_selector);
                jVar.fGh.setTextColor(al.getColor(e.d.cp_cont_b));
                jVar.fGi.onChangeSkinType();
                if (dVar != null) {
                    jVar.fGj.setVisibility(0);
                    al.j(jVar.fGj, e.d.cp_bg_line_e);
                    jVar.fGj.onChangeSkinType();
                    al.c(jVar.fGt, e.d.cp_link_tip_c, 1);
                    al.c(jVar.fGr, e.d.cp_cont_f, 1);
                    al.i(jVar.fGq, e.d.cp_bg_line_e);
                    al.i(jVar.fGs, e.d.cp_cont_d);
                    al.c(jVar.fGu, e.f.icon_arrow_more_gray);
                    al.h(jVar.fGx, e.d.cp_cont_j);
                    if (jVar.fGv.getVisibility() == 8) {
                        jVar.fGx.setText(e.j.close_content);
                        al.c(jVar.fGy, e.f.icon_arrow_gray_up);
                    } else if (StringUtils.isNull(dVar.bbR())) {
                        jVar.fGx.setText(dVar.bbR());
                        al.c(jVar.fGy, e.f.icon_arrow_gray_down);
                    } else {
                        jVar.fGx.setText(e.j.expand_content);
                    }
                } else {
                    jVar.fGj.setVisibility(8);
                    jVar.fGq.setVisibility(8);
                    jVar.fGx.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bb bbVar, int i) {
        if (jVar != null && postData != null) {
            jVar.fGz.a(postData);
            jVar.fGe.setTag(e.g.tag_clip_board, postData);
            String valueOf = String.valueOf(bbVar.getFid());
            String id = postData.getId();
            String tid = bbVar.getTid();
            jVar.fGe.setForumId(valueOf);
            jVar.fGe.setThreadId(tid);
            jVar.fGe.setPostId(id);
            jVar.fGf.setForumId(valueOf);
            jVar.fGf.setThreadId(tid);
            jVar.fGf.setPostId(id);
            if (i == 0) {
                jVar.fGe.setObjType(1);
                jVar.fGf.setObjType(1);
                return;
            }
            jVar.fGe.setObjType(2);
            jVar.fGf.setObjType(2);
        }
    }

    public static void a(j jVar, PostData postData, View view, int i, a aVar, bb bbVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (jVar != null && postData != null) {
            if (postData.gWj) {
                al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bbVar == null || bbVar.wm() == null) {
                str = null;
            } else {
                str = bbVar.wm().getUserId();
            }
            jVar.fGg.setTag(null);
            jVar.fGg.setUserId(null);
            jVar.cyw.setText((CharSequence) null);
            jVar.fGm.getHeadView().setUserId(null);
            jVar.fGh.setIsHost(false);
            if (postData.wm() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.wm().getUserId())) {
                    jVar.fGh.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.wm().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.wm().getTShowInfoNew();
                if (jVar.fGo != null) {
                    jVar.fGo.setTag(e.g.tag_user_id, postData.wm().getUserId());
                    jVar.fGo.setOnClickListener(aVar.bcD().fQv);
                    jVar.fGo.a(iconInfo, 2, fBD, fBD, fBB);
                }
                if (jVar.fGn != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fGn.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fGn.setOnClickListener(aVar.bcD().fQw);
                    jVar.fGn.a(tShowInfoNew, 3, fBD, fBD, fBB, true);
                }
                if (!v.z(tShowInfoNew) || postData.wm().isBigV()) {
                    al.c(jVar.cyw, e.d.cp_cont_h, 1);
                } else {
                    al.c(jVar.cyw, e.d.cp_cont_f, 1);
                }
                String portrait = postData.wm().getPortrait();
                jVar.cyw.setTag(e.g.tag_user_id, postData.wm().getUserId());
                jVar.cyw.setTag(e.g.tag_user_name, postData.wm().getUserName());
                jVar.cyw.setTag(e.g.tag_virtual_user_url, postData.wm().getVirtualUserUrl());
                String name_show = postData.wm().getName_show();
                String userName = postData.wm().getUserName();
                if (am.jw() && name_show != null && !name_show.equals(userName)) {
                    jVar.cyw.setText(c.aB(aVar.getPageContext().getPageActivity(), jVar.cyw.getText().toString()));
                    jVar.cyw.setGravity(16);
                    jVar.cyw.setTag(e.g.tag_nick_name_activity, c.bbr());
                    al.c(jVar.cyw, e.d.cp_other_e, 1);
                }
                if (postData.wm().getPendantData() != null && !StringUtils.isNull(postData.wm().getPendantData().uW())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fGm.getHeadView(), postData.wm());
                    jVar.fGg.setVisibility(8);
                    jVar.fGm.setVisibility(0);
                    jVar.fGm.getHeadView().startLoad(portrait, 28, false);
                    jVar.fGm.getHeadView().setUserId(postData.wm().getUserId());
                    jVar.fGm.getHeadView().setUserName(postData.wm().getUserName());
                    jVar.fGm.fF(postData.wm().getPendantData().uW());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fGg, postData.wm());
                    jVar.fGg.setUserId(postData.wm().getUserId());
                    jVar.fGg.setUserName(postData.wm().getUserName(), postData.byW());
                    jVar.fGg.setTag(e.g.tag_virtual_user_url, postData.wm().getVirtualUserUrl());
                    jVar.fGg.setImageDrawable(null);
                    jVar.fGg.startLoad(portrait, 28, false);
                    jVar.fGg.setVisibility(0);
                    jVar.fGm.setVisibility(8);
                }
                if (postData.wm() != null) {
                    MetaData wm = postData.wm();
                    int i2 = postData.byE() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.byE() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    al.i(jVar.fFY, i2);
                    al.h(jVar.fFY, i3);
                    jVar.fFY.setTag(Integer.valueOf(i2));
                    if (str != null && !str.equals("0") && str.equals(wm.getUserId())) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.host_name);
                    } else if (wm.getIs_bawu() == 1 && postData.byE()) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.brand_Official);
                    } else if (wm.getIs_bawu() == 1 && "manager".equals(wm.getBawu_type())) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.bawu_member_bazhu_tip);
                    } else if (wm.getIs_bawu() == 1 && "assist".equals(wm.getBawu_type())) {
                        jVar.fFY.setVisibility(0);
                        jVar.fFY.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fFY.setVisibility(8);
                        jVar.fFY.setTag(null);
                    }
                } else {
                    jVar.fFY.setVisibility(8);
                    jVar.fFY.setTag(null);
                }
            }
            int i4 = 0;
            if (aVar.bcE()) {
                if (postData.wm() != null) {
                    i4 = postData.wm().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fGl.setVisibility(0);
                al.c(jVar.fGl, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fGl.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fGo.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fGo.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fFY.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fGn.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.wm() != null ? postData.wm().getName_show() : "";
            int ig = y.ig(name_show2);
            if (postData.wm() != null && !StringUtils.isNull(postData.wm().getSealPrefix())) {
                if (ig > i5 - 2) {
                    name_show2 = y.I(name_show2, i5 - 2) + "...";
                }
            } else if (ig > i5) {
                name_show2 = y.I(name_show2, i5) + "...";
            }
            if (postData.wm() != null && !StringUtils.isNull(postData.wm().getSealPrefix())) {
                jVar.cyw.setText(a(aVar, postData.wm().getSealPrefix(), name_show2));
            } else {
                jVar.cyw.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.byM()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            if (postData.wm() == null || StringUtils.isNull(postData.wm().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            if (bbVar != null && aVar.bcG() != 0) {
                if (aVar.bcG() != 1002) {
                    z4 = true;
                }
                z5 = true;
                if (postData != null && postData.wm() != null) {
                    String userId = postData.wm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z4 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z4 = false;
                    }
                }
            }
            if (bbVar != null && bbVar.wm() != null && postData.wm() != null) {
                String userId2 = bbVar.wm().getUserId();
                String userId3 = postData.wm().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z5 = true;
                    z6 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z6 = false;
                        z7 = true;
                    }
                }
            }
            if (postData == null || postData.wm() == null || !UtilHelper.isCurrentAccount(postData.wm().getUserId())) {
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
            if (postData.byM() == 1) {
                i6 = 0;
            }
            if (z4) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bcG()));
                if (postData.wm() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.wm().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.wm().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.wm().getPortrait());
                }
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            if (z6) {
                sparseArray.put(e.g.tag_user_mute_visible, true);
                sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.wm() != null) {
                    sparseArray.put(e.g.tag_user_mute_mute_userid, postData.wm().getUserId());
                    sparseArray.put(e.g.tag_user_mute_mute_username, postData.wm().getUserName());
                    sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.wm().getName_show());
                }
                sparseArray.put(e.g.tag_user_mute_thread_id, bbVar.getId());
                sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z3 && bbVar != null) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bcG()));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            jVar.fGh.setTag(sparseArray);
            jVar.fGd.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().ga(aO - (z ? getDimensionPixelSize(e.C0141e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gb((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fGh.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = l.h(pageActivity, e.C0141e.tbds50);
            layoutParams.rightMargin = l.h(pageActivity, e.C0141e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, e.C0141e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fGh.setPadding(h, 0, h, 0);
            if (z) {
                jVar.fGh.it(null);
                jVar.fGh.setBackgroundDrawable(null);
                jVar.fGh.getLayoutStrategy().gc(e.f.transparent_bg);
            } else {
                jVar.fGh.getLayoutStrategy().gc(e.f.icon_click);
            }
            jVar.fGh.getLayoutStrategy().fZ(e.f.pic_video);
            a(jVar.fGh, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.fGh.setLayoutParams(layoutParams);
            jVar.fGh.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            jVar.fGh.setIsFromCDN(z2);
            jVar.fGh.setText(postData.byO(), true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.fGh.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.fGh.setTag(sparseArray);
            jVar.fFW.setTag(e.g.tag_from, sparseArray);
        }
    }

    public static void a(final a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.byM() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(e.j.is_floor), Integer.valueOf(postData.byM()));
                jVar.fGk.setVisibility(0);
                jVar.fGk.setText(format);
                z = true;
            } else {
                jVar.fGk.setVisibility(8);
                z = false;
            }
            f byP = postData.byP();
            boolean z2 = (byP == null || StringUtils.isNull(byP.getName())) ? false : true;
            if (z) {
                jVar.fGa.setVisibility(0);
                i = fBC;
            } else {
                jVar.fGa.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fGb.setVisibility(0);
                i2 = fBC;
            } else {
                jVar.fGb.setVisibility(8);
                i2 = 0;
            }
            jVar.fFZ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.fFZ.setText(ao.C(postData.getTime()));
            } else {
                jVar.fFZ.setText(ao.A(postData.getTime()));
            }
            if (z2) {
                final String name = byP.getName();
                final String lat = byP.getLat();
                final String lng = byP.getLng();
                jVar.fGc.setVisibility(0);
                jVar.fGc.setPadding(fBC, 0, 0, 0);
                jVar.fGc.setText(byP.getName());
                jVar.fGc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (!com.baidu.adp.lib.util.j.kK()) {
                                aVar.getPageContext().showToast(e.j.neterror);
                            } else {
                                com.baidu.tbadk.browser.a.ae(aVar.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, TbadkApplication.getInst().getString(e.j.app_info_for_map)));
                            }
                        }
                    }
                });
                return;
            }
            jVar.fGc.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bix() == null) {
            jVar.fGp.setVisibility(8);
            return;
        }
        TbRichText byO = postData.byO();
        com.baidu.tieba.pb.view.c.a(postData.bix(), jVar.fGp, false, false, byO != null && StringUtils.isNull(byO.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fGh.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fGh.setLayoutParams(layoutParams);
            jVar.fGh.setPadding(0, 0, 0, 0);
            jVar.fGh.it(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fGh.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0141e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0141e.ds20);
            jVar.fGh.setLayoutParams(layoutParams2);
            jVar.fGh.it(postData.getBimg_url());
        }
        jVar.fGh.setTextViewCheckSelection(false);
    }
}
