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
import com.baidu.tbadk.util.z;
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
    private static SparseArray<SoftReference<Drawable>> fVf = new SparseArray<>();
    private static SparseIntArray fVg = new SparseIntArray();
    public static final int fVh = getDimensionPixelSize(e.C0210e.tbds12);
    public static final int fVi = getDimensionPixelSize(e.C0210e.tbds20);
    public static final int fVj = getDimensionPixelSize(e.C0210e.tbds36);

    public static int getDimensionPixelSize(int i) {
        int i2 = fVg.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            fVg.put(i, dimensionPixelSize);
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
                al.c(jVar.cLW, e.d.cp_cont_f, 1);
                if (jVar.fZE.getTag() instanceof Integer) {
                    al.i(jVar.fZE, ((Integer) jVar.fZE.getTag()).intValue());
                }
                al.c(jVar.fZF, e.d.cp_cont_d, 1);
                al.i(jVar.fZG, e.d.cp_cont_e);
                al.i(jVar.fZH, e.d.cp_cont_e);
                al.c(jVar.fZQ, e.d.cp_cont_d, 1);
                al.c(jVar.fZI, e.d.cp_cont_d, 1);
                al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                al.c(jVar.fZJ, e.f.icon_floor_more_selector);
                jVar.fZN.setTextColor(al.getColor(e.d.cp_cont_b));
                jVar.fZO.onChangeSkinType();
                if (dVar != null) {
                    jVar.fZP.setVisibility(0);
                    al.j(jVar.fZP, e.d.cp_bg_line_e);
                    jVar.fZP.onChangeSkinType();
                    al.c(jVar.fZZ, e.d.cp_link_tip_c, 1);
                    al.c(jVar.fZX, e.d.cp_cont_f, 1);
                    al.i(jVar.fZW, e.d.cp_bg_line_e);
                    al.i(jVar.fZY, e.d.cp_cont_d);
                    al.c(jVar.gaa, e.f.icon_arrow_more_gray);
                    al.h(jVar.gad, e.d.cp_cont_j);
                    if (jVar.gab.getVisibility() == 8) {
                        jVar.gad.setText(e.j.close_content);
                        al.c(jVar.gae, e.f.icon_arrow_gray_up);
                    } else if (StringUtils.isNull(dVar.bhH())) {
                        jVar.gad.setText(dVar.bhH());
                        al.c(jVar.gae, e.f.icon_arrow_gray_down);
                    } else {
                        jVar.gad.setText(e.j.expand_content);
                    }
                } else {
                    jVar.fZP.setVisibility(8);
                    jVar.fZW.setVisibility(8);
                    jVar.gad.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bb bbVar, int i) {
        if (jVar != null && postData != null) {
            jVar.gaf.a(postData);
            jVar.fZK.setTag(e.g.tag_clip_board, postData);
            String valueOf = String.valueOf(bbVar.getFid());
            String id = postData.getId();
            String tid = bbVar.getTid();
            jVar.fZK.setForumId(valueOf);
            jVar.fZK.setThreadId(tid);
            jVar.fZK.setPostId(id);
            jVar.fZL.setForumId(valueOf);
            jVar.fZL.setThreadId(tid);
            jVar.fZL.setPostId(id);
            if (i == 0) {
                jVar.fZK.setObjType(1);
                jVar.fZL.setObjType(1);
                return;
            }
            jVar.fZK.setObjType(2);
            jVar.fZL.setObjType(2);
        }
    }

    public static void a(j jVar, PostData postData, View view, int i, a aVar, bb bbVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (jVar != null && postData != null) {
            if (postData.hqm) {
                al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bbVar == null || bbVar.zT() == null) {
                str = null;
            } else {
                str = bbVar.zT().getUserId();
            }
            jVar.fZM.setTag(null);
            jVar.fZM.setUserId(null);
            jVar.cLW.setText((CharSequence) null);
            jVar.fZS.getHeadView().setUserId(null);
            jVar.fZN.setIsHost(false);
            if (postData.zT() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.zT().getUserId())) {
                    jVar.fZN.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zT().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zT().getTShowInfoNew();
                if (jVar.fZU != null) {
                    jVar.fZU.setTag(e.g.tag_user_id, postData.zT().getUserId());
                    jVar.fZU.setOnClickListener(aVar.bis().gki);
                    jVar.fZU.a(iconInfo, 2, fVj, fVj, fVh);
                }
                if (jVar.fZT != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fZT.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fZT.setOnClickListener(aVar.bis().gkj);
                    jVar.fZT.a(tShowInfoNew, 3, fVj, fVj, fVh, true);
                }
                if (!v.I(tShowInfoNew) || postData.zT().isBigV()) {
                    al.c(jVar.cLW, e.d.cp_cont_h, 1);
                } else {
                    al.c(jVar.cLW, e.d.cp_cont_f, 1);
                }
                String portrait = postData.zT().getPortrait();
                jVar.cLW.setTag(e.g.tag_user_id, postData.zT().getUserId());
                jVar.cLW.setTag(e.g.tag_user_name, postData.zT().getUserName());
                jVar.cLW.setTag(e.g.tag_virtual_user_url, postData.zT().getVirtualUserUrl());
                String name_show = postData.zT().getName_show();
                String userName = postData.zT().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cLW.setText(c.aC(aVar.getPageContext().getPageActivity(), jVar.cLW.getText().toString()));
                    jVar.cLW.setGravity(16);
                    jVar.cLW.setTag(e.g.tag_nick_name_activity, c.bhi());
                    al.c(jVar.cLW, e.d.cp_other_e, 1);
                }
                if (postData.zT().getPendantData() != null && !StringUtils.isNull(postData.zT().getPendantData().yF())) {
                    jVar.fZS.b(postData.zT());
                    jVar.fZM.setVisibility(8);
                    jVar.fZS.setVisibility(0);
                    jVar.fZS.getHeadView().startLoad(portrait, 28, false);
                    jVar.fZS.getHeadView().setUserId(postData.zT().getUserId());
                    jVar.fZS.getHeadView().setUserName(postData.zT().getUserName());
                    jVar.fZS.gA(postData.zT().getPendantData().yF());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fZM, postData.zT());
                    jVar.fZM.setUserId(postData.zT().getUserId());
                    jVar.fZM.setUserName(postData.zT().getUserName(), postData.bFc());
                    jVar.fZM.setTag(e.g.tag_virtual_user_url, postData.zT().getVirtualUserUrl());
                    jVar.fZM.setImageDrawable(null);
                    jVar.fZM.startLoad(portrait, 28, false);
                    jVar.fZM.setVisibility(0);
                    jVar.fZS.setVisibility(8);
                }
                if (postData.zT() != null) {
                    MetaData zT = postData.zT();
                    int i2 = postData.bEK() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bEK() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    al.i(jVar.fZE, i2);
                    al.h(jVar.fZE, i3);
                    jVar.fZE.setTag(Integer.valueOf(i2));
                    if (str != null && !str.equals("0") && str.equals(zT.getUserId())) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.host_name);
                    } else if (zT.getIs_bawu() == 1 && postData.bEK()) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.brand_Official);
                    } else if (zT.getIs_bawu() == 1 && "manager".equals(zT.getBawu_type())) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.bawu_member_bazhu_tip);
                    } else if (zT.getIs_bawu() == 1 && "assist".equals(zT.getBawu_type())) {
                        jVar.fZE.setVisibility(0);
                        jVar.fZE.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fZE.setVisibility(8);
                        jVar.fZE.setTag(null);
                    }
                } else {
                    jVar.fZE.setVisibility(8);
                    jVar.fZE.setTag(null);
                }
            }
            int i4 = 0;
            if (aVar.bit()) {
                if (postData.zT() != null) {
                    i4 = postData.zT().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fZR.setVisibility(0);
                al.c(jVar.fZR, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fZR.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fZU.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fZU.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fZE.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fZT.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.zT() != null ? postData.zT().getName_show() : "";
            int jd = z.jd(name_show2);
            if (postData.zT() != null && !StringUtils.isNull(postData.zT().getSealPrefix())) {
                if (jd > i5 - 2) {
                    name_show2 = z.K(name_show2, i5 - 2) + "...";
                }
            } else if (jd > i5) {
                name_show2 = z.K(name_show2, i5) + "...";
            }
            if (postData.zT() != null && !StringUtils.isNull(postData.zT().getSealPrefix())) {
                jVar.cLW.setText(a(aVar, postData.zT().getSealPrefix(), name_show2));
            } else {
                jVar.cLW.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bES()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            if (postData.zT() == null || StringUtils.isNull(postData.zT().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            if (bbVar != null && aVar.biv() != 0) {
                if (aVar.biv() != 1002) {
                    z4 = true;
                }
                z5 = true;
                if (postData != null && postData.zT() != null) {
                    String userId = postData.zT().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z4 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z4 = false;
                    }
                }
            }
            if (bbVar != null && bbVar.zT() != null && postData.zT() != null) {
                String userId2 = bbVar.zT().getUserId();
                String userId3 = postData.zT().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z5 = true;
                    z6 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z6 = false;
                        z7 = true;
                    }
                }
            }
            if (postData == null || postData.zT() == null || !UtilHelper.isCurrentAccount(postData.zT().getUserId())) {
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
            if (postData.bES() == 1) {
                i6 = 0;
            }
            if (z4) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.biv()));
                if (postData.zT() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.zT().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.zT().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.zT().getPortrait());
                }
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            if (z6) {
                sparseArray.put(e.g.tag_user_mute_visible, true);
                sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.zT() != null) {
                    sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zT().getUserId());
                    sparseArray.put(e.g.tag_user_mute_mute_username, postData.zT().getUserName());
                    sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zT().getName_show());
                }
                sparseArray.put(e.g.tag_user_mute_thread_id, bbVar.getId());
                sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z3 && bbVar != null) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.biv()));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            jVar.fZN.setTag(sparseArray);
            jVar.fZJ.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gL(aO - (z ? getDimensionPixelSize(e.C0210e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gM((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZN.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = l.h(pageActivity, e.C0210e.tbds50);
            layoutParams.rightMargin = l.h(pageActivity, e.C0210e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, e.C0210e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fZN.setPadding(h, 0, h, 0);
            if (z) {
                jVar.fZN.jr(null);
                jVar.fZN.setBackgroundDrawable(null);
                jVar.fZN.getLayoutStrategy().gN(e.f.transparent_bg);
            } else {
                jVar.fZN.getLayoutStrategy().gN(e.f.icon_click);
            }
            jVar.fZN.getLayoutStrategy().gK(e.f.pic_video);
            a(jVar.fZN, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.fZN.setLayoutParams(layoutParams);
            jVar.fZN.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            jVar.fZN.setIsFromCDN(z2);
            jVar.fZN.setText(postData.bEU(), true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.fZN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.fZN.setTag(sparseArray);
            jVar.fZC.setTag(e.g.tag_from, sparseArray);
        }
    }

    public static void a(final a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bES() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(e.j.is_floor), Integer.valueOf(postData.bES()));
                jVar.fZQ.setVisibility(0);
                jVar.fZQ.setText(format);
                z = true;
            } else {
                jVar.fZQ.setVisibility(8);
                z = false;
            }
            f bEV = postData.bEV();
            boolean z2 = (bEV == null || StringUtils.isNull(bEV.getName())) ? false : true;
            if (z) {
                jVar.fZG.setVisibility(0);
                i = fVi;
            } else {
                jVar.fZG.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fZH.setVisibility(0);
                i2 = fVi;
            } else {
                jVar.fZH.setVisibility(8);
                i2 = 0;
            }
            jVar.fZF.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fZF.setText(ao.O(postData.getTime()));
            } else {
                jVar.fZF.setText(ao.M(postData.getTime()));
            }
            if (z2) {
                final String name = bEV.getName();
                final String lat = bEV.getLat();
                final String lng = bEV.getLng();
                jVar.fZI.setVisibility(0);
                jVar.fZI.setPadding(fVi, 0, 0, 0);
                jVar.fZI.setText(bEV.getName());
                jVar.fZI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (!com.baidu.adp.lib.util.j.kV()) {
                                aVar.getPageContext().showToast(e.j.neterror);
                            } else {
                                com.baidu.tbadk.browser.a.ad(aVar.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, TbadkApplication.getInst().getString(e.j.app_info_for_map)));
                            }
                        }
                    }
                });
                return;
            }
            jVar.fZI.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bor() == null) {
            jVar.fZV.setVisibility(8);
            return;
        }
        TbRichText bEU = postData.bEU();
        com.baidu.tieba.pb.view.c.a(postData.bor(), jVar.fZV, false, false, bEU != null && StringUtils.isNull(bEU.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fZN.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fZN.setLayoutParams(layoutParams);
            jVar.fZN.setPadding(0, 0, 0, 0);
            jVar.fZN.jr(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fZN.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0210e.ds20);
            jVar.fZN.setLayoutParams(layoutParams2);
            jVar.fZN.jr(postData.getBimg_url());
        }
        jVar.fZN.setTextViewCheckSelection(false);
    }
}
