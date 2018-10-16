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
/* loaded from: classes6.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> fJa = new SparseArray<>();
    private static SparseIntArray fJb = new SparseIntArray();
    public static final int fJc = getDimensionPixelSize(e.C0175e.tbds12);
    public static final int fJd = getDimensionPixelSize(e.C0175e.tbds20);
    public static final int fJe = getDimensionPixelSize(e.C0175e.tbds36);

    public static int getDimensionPixelSize(int i) {
        int i2 = fJb.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            fJb.put(i, dimensionPixelSize);
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
                al.c(jVar.cGZ, e.d.cp_cont_f, 1);
                if (jVar.fNz.getTag() instanceof Integer) {
                    al.i(jVar.fNz, ((Integer) jVar.fNz.getTag()).intValue());
                }
                al.c(jVar.fNA, e.d.cp_cont_d, 1);
                al.i(jVar.fNB, e.d.cp_cont_e);
                al.i(jVar.fNC, e.d.cp_cont_e);
                al.c(jVar.fNL, e.d.cp_cont_d, 1);
                al.c(jVar.fND, e.d.cp_cont_d, 1);
                al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                al.c(jVar.fNE, e.f.icon_floor_more_selector);
                jVar.fNI.setTextColor(al.getColor(e.d.cp_cont_b));
                jVar.fNJ.onChangeSkinType();
                if (dVar != null) {
                    jVar.fNK.setVisibility(0);
                    al.j(jVar.fNK, e.d.cp_bg_line_e);
                    jVar.fNK.onChangeSkinType();
                    al.c(jVar.fNU, e.d.cp_link_tip_c, 1);
                    al.c(jVar.fNS, e.d.cp_cont_f, 1);
                    al.i(jVar.fNR, e.d.cp_bg_line_e);
                    al.i(jVar.fNT, e.d.cp_cont_d);
                    al.c(jVar.fNV, e.f.icon_arrow_more_gray);
                    al.h(jVar.fNY, e.d.cp_cont_j);
                    if (jVar.fNW.getVisibility() == 8) {
                        jVar.fNY.setText(e.j.close_content);
                        al.c(jVar.fNZ, e.f.icon_arrow_gray_up);
                    } else if (StringUtils.isNull(dVar.bfd())) {
                        jVar.fNY.setText(dVar.bfd());
                        al.c(jVar.fNZ, e.f.icon_arrow_gray_down);
                    } else {
                        jVar.fNY.setText(e.j.expand_content);
                    }
                } else {
                    jVar.fNK.setVisibility(8);
                    jVar.fNR.setVisibility(8);
                    jVar.fNY.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bb bbVar, int i) {
        if (jVar != null && postData != null) {
            jVar.fOa.a(postData);
            jVar.fNF.setTag(e.g.tag_clip_board, postData);
            String valueOf = String.valueOf(bbVar.getFid());
            String id = postData.getId();
            String tid = bbVar.getTid();
            jVar.fNF.setForumId(valueOf);
            jVar.fNF.setThreadId(tid);
            jVar.fNF.setPostId(id);
            jVar.fNG.setForumId(valueOf);
            jVar.fNG.setThreadId(tid);
            jVar.fNG.setPostId(id);
            if (i == 0) {
                jVar.fNF.setObjType(1);
                jVar.fNG.setObjType(1);
                return;
            }
            jVar.fNF.setObjType(2);
            jVar.fNG.setObjType(2);
        }
    }

    public static void a(j jVar, PostData postData, View view, int i, a aVar, bb bbVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (jVar != null && postData != null) {
            if (postData.hdE) {
                al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bbVar == null || bbVar.yv() == null) {
                str = null;
            } else {
                str = bbVar.yv().getUserId();
            }
            jVar.fNH.setTag(null);
            jVar.fNH.setUserId(null);
            jVar.cGZ.setText((CharSequence) null);
            jVar.fNN.getHeadView().setUserId(null);
            jVar.fNI.setIsHost(false);
            if (postData.yv() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.yv().getUserId())) {
                    jVar.fNI.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.yv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.yv().getTShowInfoNew();
                if (jVar.fNP != null) {
                    jVar.fNP.setTag(e.g.tag_user_id, postData.yv().getUserId());
                    jVar.fNP.setOnClickListener(aVar.bfP().fXV);
                    jVar.fNP.a(iconInfo, 2, fJe, fJe, fJc);
                }
                if (jVar.fNO != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fNO.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fNO.setOnClickListener(aVar.bfP().fXW);
                    jVar.fNO.a(tShowInfoNew, 3, fJe, fJe, fJc, true);
                }
                if (!v.J(tShowInfoNew) || postData.yv().isBigV()) {
                    al.c(jVar.cGZ, e.d.cp_cont_h, 1);
                } else {
                    al.c(jVar.cGZ, e.d.cp_cont_f, 1);
                }
                String portrait = postData.yv().getPortrait();
                jVar.cGZ.setTag(e.g.tag_user_id, postData.yv().getUserId());
                jVar.cGZ.setTag(e.g.tag_user_name, postData.yv().getUserName());
                jVar.cGZ.setTag(e.g.tag_virtual_user_url, postData.yv().getVirtualUserUrl());
                String name_show = postData.yv().getName_show();
                String userName = postData.yv().getUserName();
                if (am.jL() && name_show != null && !name_show.equals(userName)) {
                    jVar.cGZ.setText(c.aD(aVar.getPageContext().getPageActivity(), jVar.cGZ.getText().toString()));
                    jVar.cGZ.setGravity(16);
                    jVar.cGZ.setTag(e.g.tag_nick_name_activity, c.beD());
                    al.c(jVar.cGZ, e.d.cp_other_e, 1);
                }
                if (postData.yv().getPendantData() != null && !StringUtils.isNull(postData.yv().getPendantData().xf())) {
                    UtilHelper.showHeadImageViewBigV(jVar.fNN.getHeadView(), postData.yv());
                    jVar.fNH.setVisibility(8);
                    jVar.fNN.setVisibility(0);
                    jVar.fNN.getHeadView().startLoad(portrait, 28, false);
                    jVar.fNN.getHeadView().setUserId(postData.yv().getUserId());
                    jVar.fNN.getHeadView().setUserName(postData.yv().getUserName());
                    jVar.fNN.fT(postData.yv().getPendantData().xf());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fNH, postData.yv());
                    jVar.fNH.setUserId(postData.yv().getUserId());
                    jVar.fNH.setUserName(postData.yv().getUserName(), postData.bCl());
                    jVar.fNH.setTag(e.g.tag_virtual_user_url, postData.yv().getVirtualUserUrl());
                    jVar.fNH.setImageDrawable(null);
                    jVar.fNH.startLoad(portrait, 28, false);
                    jVar.fNH.setVisibility(0);
                    jVar.fNN.setVisibility(8);
                }
                if (postData.yv() != null) {
                    MetaData yv = postData.yv();
                    int i2 = postData.bBT() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bBT() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    al.i(jVar.fNz, i2);
                    al.h(jVar.fNz, i3);
                    jVar.fNz.setTag(Integer.valueOf(i2));
                    if (str != null && !str.equals("0") && str.equals(yv.getUserId())) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.host_name);
                    } else if (yv.getIs_bawu() == 1 && postData.bBT()) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.brand_Official);
                    } else if (yv.getIs_bawu() == 1 && "manager".equals(yv.getBawu_type())) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.bawu_member_bazhu_tip);
                    } else if (yv.getIs_bawu() == 1 && "assist".equals(yv.getBawu_type())) {
                        jVar.fNz.setVisibility(0);
                        jVar.fNz.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fNz.setVisibility(8);
                        jVar.fNz.setTag(null);
                    }
                } else {
                    jVar.fNz.setVisibility(8);
                    jVar.fNz.setTag(null);
                }
            }
            int i4 = 0;
            if (aVar.bfQ()) {
                if (postData.yv() != null) {
                    i4 = postData.yv().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fNM.setVisibility(0);
                al.c(jVar.fNM, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fNM.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fNP.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fNP.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fNz.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fNO.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.yv() != null ? postData.yv().getName_show() : "";
            int it = y.it(name_show2);
            if (postData.yv() != null && !StringUtils.isNull(postData.yv().getSealPrefix())) {
                if (it > i5 - 2) {
                    name_show2 = y.J(name_show2, i5 - 2) + "...";
                }
            } else if (it > i5) {
                name_show2 = y.J(name_show2, i5) + "...";
            }
            if (postData.yv() != null && !StringUtils.isNull(postData.yv().getSealPrefix())) {
                jVar.cGZ.setText(a(aVar, postData.yv().getSealPrefix(), name_show2));
            } else {
                jVar.cGZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bCb()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            if (postData.yv() == null || StringUtils.isNull(postData.yv().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            if (bbVar != null && aVar.bfS() != 0) {
                if (aVar.bfS() != 1002) {
                    z4 = true;
                }
                z5 = true;
                if (postData != null && postData.yv() != null) {
                    String userId = postData.yv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z4 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z4 = false;
                    }
                }
            }
            if (bbVar != null && bbVar.yv() != null && postData.yv() != null) {
                String userId2 = bbVar.yv().getUserId();
                String userId3 = postData.yv().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z5 = true;
                    z6 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z6 = false;
                        z7 = true;
                    }
                }
            }
            if (postData == null || postData.yv() == null || !UtilHelper.isCurrentAccount(postData.yv().getUserId())) {
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
            if (postData.bCb() == 1) {
                i6 = 0;
            }
            if (z4) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bfS()));
                if (postData.yv() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.yv().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.yv().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.yv().getPortrait());
                }
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            if (z6) {
                sparseArray.put(e.g.tag_user_mute_visible, true);
                sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.yv() != null) {
                    sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yv().getUserId());
                    sparseArray.put(e.g.tag_user_mute_mute_username, postData.yv().getUserName());
                    sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yv().getName_show());
                }
                sparseArray.put(e.g.tag_user_mute_thread_id, bbVar.getId());
                sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z3 && bbVar != null) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bfS()));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            jVar.fNI.setTag(sparseArray);
            jVar.fNE.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gi(aO - (z ? getDimensionPixelSize(e.C0175e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gj((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = l.h(pageActivity, e.C0175e.tbds50);
            layoutParams.rightMargin = l.h(pageActivity, e.C0175e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, e.C0175e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fNI.setPadding(h, 0, h, 0);
            if (z) {
                jVar.fNI.iG(null);
                jVar.fNI.setBackgroundDrawable(null);
                jVar.fNI.getLayoutStrategy().gk(e.f.transparent_bg);
            } else {
                jVar.fNI.getLayoutStrategy().gk(e.f.icon_click);
            }
            jVar.fNI.getLayoutStrategy().gh(e.f.pic_video);
            a(jVar.fNI, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.fNI.setLayoutParams(layoutParams);
            jVar.fNI.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            jVar.fNI.setIsFromCDN(z2);
            jVar.fNI.setText(postData.bCd(), true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.fNI.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.fNI.setTag(sparseArray);
            jVar.fNx.setTag(e.g.tag_from, sparseArray);
        }
    }

    public static void a(final a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bCb() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(e.j.is_floor), Integer.valueOf(postData.bCb()));
                jVar.fNL.setVisibility(0);
                jVar.fNL.setText(format);
                z = true;
            } else {
                jVar.fNL.setVisibility(8);
                z = false;
            }
            f bCe = postData.bCe();
            boolean z2 = (bCe == null || StringUtils.isNull(bCe.getName())) ? false : true;
            if (z) {
                jVar.fNB.setVisibility(0);
                i = fJd;
            } else {
                jVar.fNB.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fNC.setVisibility(0);
                i2 = fJd;
            } else {
                jVar.fNC.setVisibility(8);
                i2 = 0;
            }
            jVar.fNA.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fNA.setText(ao.E(postData.getTime()));
            } else {
                jVar.fNA.setText(ao.C(postData.getTime()));
            }
            if (z2) {
                final String name = bCe.getName();
                final String lat = bCe.getLat();
                final String lng = bCe.getLng();
                jVar.fND.setVisibility(0);
                jVar.fND.setPadding(fJd, 0, 0, 0);
                jVar.fND.setText(bCe.getName());
                jVar.fND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (!com.baidu.adp.lib.util.j.kX()) {
                                aVar.getPageContext().showToast(e.j.neterror);
                            } else {
                                com.baidu.tbadk.browser.a.ae(aVar.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, TbadkApplication.getInst().getString(e.j.app_info_for_map)));
                            }
                        }
                    }
                });
                return;
            }
            jVar.fND.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.blJ() == null) {
            jVar.fNQ.setVisibility(8);
            return;
        }
        TbRichText bCd = postData.bCd();
        com.baidu.tieba.pb.view.c.a(postData.blJ(), jVar.fNQ, false, false, bCd != null && StringUtils.isNull(bCd.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fNI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fNI.setLayoutParams(layoutParams);
            jVar.fNI.setPadding(0, 0, 0, 0);
            jVar.fNI.iG(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fNI.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0175e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0175e.ds20);
            jVar.fNI.setLayoutParams(layoutParams2);
            jVar.fNI.iG(postData.getBimg_url());
        }
        jVar.fNI.setTextViewCheckSelection(false);
    }
}
