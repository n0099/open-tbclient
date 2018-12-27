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
    private static SparseArray<SoftReference<Drawable>> fUi = new SparseArray<>();
    private static SparseIntArray fUj = new SparseIntArray();
    public static final int fUk = getDimensionPixelSize(e.C0210e.tbds12);
    public static final int fUl = getDimensionPixelSize(e.C0210e.tbds20);
    public static final int fUm = getDimensionPixelSize(e.C0210e.tbds36);

    public static int getDimensionPixelSize(int i) {
        int i2 = fUj.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            fUj.put(i, dimensionPixelSize);
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
                al.c(jVar.cLl, e.d.cp_cont_f, 1);
                if (jVar.fYH.getTag() instanceof Integer) {
                    al.i(jVar.fYH, ((Integer) jVar.fYH.getTag()).intValue());
                }
                al.c(jVar.fYI, e.d.cp_cont_d, 1);
                al.i(jVar.fYJ, e.d.cp_cont_e);
                al.i(jVar.fYK, e.d.cp_cont_e);
                al.c(jVar.fYT, e.d.cp_cont_d, 1);
                al.c(jVar.fYL, e.d.cp_cont_d, 1);
                al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                al.c(jVar.fYM, e.f.icon_floor_more_selector);
                jVar.fYQ.setTextColor(al.getColor(e.d.cp_cont_b));
                jVar.fYR.onChangeSkinType();
                if (dVar != null) {
                    jVar.fYS.setVisibility(0);
                    al.j(jVar.fYS, e.d.cp_bg_line_e);
                    jVar.fYS.onChangeSkinType();
                    al.c(jVar.fZc, e.d.cp_link_tip_c, 1);
                    al.c(jVar.fZa, e.d.cp_cont_f, 1);
                    al.i(jVar.fYZ, e.d.cp_bg_line_e);
                    al.i(jVar.fZb, e.d.cp_cont_d);
                    al.c(jVar.fZd, e.f.icon_arrow_more_gray);
                    al.h(jVar.fZg, e.d.cp_cont_j);
                    if (jVar.fZe.getVisibility() == 8) {
                        jVar.fZg.setText(e.j.close_content);
                        al.c(jVar.fZh, e.f.icon_arrow_gray_up);
                    } else if (StringUtils.isNull(dVar.bhd())) {
                        jVar.fZg.setText(dVar.bhd());
                        al.c(jVar.fZh, e.f.icon_arrow_gray_down);
                    } else {
                        jVar.fZg.setText(e.j.expand_content);
                    }
                } else {
                    jVar.fYS.setVisibility(8);
                    jVar.fYZ.setVisibility(8);
                    jVar.fZg.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bb bbVar, int i) {
        if (jVar != null && postData != null) {
            jVar.fZi.a(postData);
            jVar.fYN.setTag(e.g.tag_clip_board, postData);
            String valueOf = String.valueOf(bbVar.getFid());
            String id = postData.getId();
            String tid = bbVar.getTid();
            jVar.fYN.setForumId(valueOf);
            jVar.fYN.setThreadId(tid);
            jVar.fYN.setPostId(id);
            jVar.fYO.setForumId(valueOf);
            jVar.fYO.setThreadId(tid);
            jVar.fYO.setPostId(id);
            if (i == 0) {
                jVar.fYN.setObjType(1);
                jVar.fYO.setObjType(1);
                return;
            }
            jVar.fYN.setObjType(2);
            jVar.fYO.setObjType(2);
        }
    }

    public static void a(j jVar, PostData postData, View view, int i, a aVar, bb bbVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (jVar != null && postData != null) {
            if (postData.hph) {
                al.j(jVar.mTopLine, e.d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bbVar == null || bbVar.zG() == null) {
                str = null;
            } else {
                str = bbVar.zG().getUserId();
            }
            jVar.fYP.setTag(null);
            jVar.fYP.setUserId(null);
            jVar.cLl.setText((CharSequence) null);
            jVar.fYV.getHeadView().setUserId(null);
            jVar.fYQ.setIsHost(false);
            if (postData.zG() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.zG().getUserId())) {
                    jVar.fYQ.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zG().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zG().getTShowInfoNew();
                if (jVar.fYX != null) {
                    jVar.fYX.setTag(e.g.tag_user_id, postData.zG().getUserId());
                    jVar.fYX.setOnClickListener(aVar.bhO().gjf);
                    jVar.fYX.a(iconInfo, 2, fUm, fUm, fUk);
                }
                if (jVar.fYW != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fYW.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fYW.setOnClickListener(aVar.bhO().gjg);
                    jVar.fYW.a(tShowInfoNew, 3, fUm, fUm, fUk, true);
                }
                if (!v.I(tShowInfoNew) || postData.zG().isBigV()) {
                    al.c(jVar.cLl, e.d.cp_cont_h, 1);
                } else {
                    al.c(jVar.cLl, e.d.cp_cont_f, 1);
                }
                String portrait = postData.zG().getPortrait();
                jVar.cLl.setTag(e.g.tag_user_id, postData.zG().getUserId());
                jVar.cLl.setTag(e.g.tag_user_name, postData.zG().getUserName());
                jVar.cLl.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                String name_show = postData.zG().getName_show();
                String userName = postData.zG().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cLl.setText(c.aE(aVar.getPageContext().getPageActivity(), jVar.cLl.getText().toString()));
                    jVar.cLl.setGravity(16);
                    jVar.cLl.setTag(e.g.tag_nick_name_activity, c.bgE());
                    al.c(jVar.cLl, e.d.cp_other_e, 1);
                }
                if (postData.zG().getPendantData() != null && !StringUtils.isNull(postData.zG().getPendantData().ys())) {
                    jVar.fYV.b(postData.zG());
                    jVar.fYP.setVisibility(8);
                    jVar.fYV.setVisibility(0);
                    jVar.fYV.getHeadView().startLoad(portrait, 28, false);
                    jVar.fYV.getHeadView().setUserId(postData.zG().getUserId());
                    jVar.fYV.getHeadView().setUserName(postData.zG().getUserName());
                    jVar.fYV.gm(postData.zG().getPendantData().ys());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fYP, postData.zG());
                    jVar.fYP.setUserId(postData.zG().getUserId());
                    jVar.fYP.setUserName(postData.zG().getUserName(), postData.bEt());
                    jVar.fYP.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                    jVar.fYP.setImageDrawable(null);
                    jVar.fYP.startLoad(portrait, 28, false);
                    jVar.fYP.setVisibility(0);
                    jVar.fYV.setVisibility(8);
                }
                if (postData.zG() != null) {
                    MetaData zG = postData.zG();
                    int i2 = postData.bEb() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bEb() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    al.i(jVar.fYH, i2);
                    al.h(jVar.fYH, i3);
                    jVar.fYH.setTag(Integer.valueOf(i2));
                    if (str != null && !str.equals("0") && str.equals(zG.getUserId())) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.host_name);
                    } else if (zG.getIs_bawu() == 1 && postData.bEb()) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.brand_Official);
                    } else if (zG.getIs_bawu() == 1 && "manager".equals(zG.getBawu_type())) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.bawu_member_bazhu_tip);
                    } else if (zG.getIs_bawu() == 1 && "assist".equals(zG.getBawu_type())) {
                        jVar.fYH.setVisibility(0);
                        jVar.fYH.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fYH.setVisibility(8);
                        jVar.fYH.setTag(null);
                    }
                } else {
                    jVar.fYH.setVisibility(8);
                    jVar.fYH.setTag(null);
                }
            }
            int i4 = 0;
            if (aVar.bhP()) {
                if (postData.zG() != null) {
                    i4 = postData.zG().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fYU.setVisibility(0);
                al.c(jVar.fYU, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fYU.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fYX.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fYX.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fYH.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fYW.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.zG() != null ? postData.zG().getName_show() : "";
            int iN = y.iN(name_show2);
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                if (iN > i5 - 2) {
                    name_show2 = y.K(name_show2, i5 - 2) + "...";
                }
            } else if (iN > i5) {
                name_show2 = y.K(name_show2, i5) + "...";
            }
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                jVar.cLl.setText(a(aVar, postData.zG().getSealPrefix(), name_show2));
            } else {
                jVar.cLl.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bEj()));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            if (postData.zG() == null || StringUtils.isNull(postData.zG().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            if (bbVar != null && aVar.bhR() != 0) {
                if (aVar.bhR() != 1002) {
                    z4 = true;
                }
                z5 = true;
                if (postData != null && postData.zG() != null) {
                    String userId = postData.zG().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z4 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z4 = false;
                    }
                }
            }
            if (bbVar != null && bbVar.zG() != null && postData.zG() != null) {
                String userId2 = bbVar.zG().getUserId();
                String userId3 = postData.zG().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z5 = true;
                    z6 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z6 = false;
                        z7 = true;
                    }
                }
            }
            if (postData == null || postData.zG() == null || !UtilHelper.isCurrentAccount(postData.zG().getUserId())) {
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
            if (postData.bEj() == 1) {
                i6 = 0;
            }
            if (z4) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bhR()));
                if (postData.zG() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                }
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            if (z6) {
                sparseArray.put(e.g.tag_user_mute_visible, true);
                sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.zG() != null) {
                    sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zG().getUserId());
                    sparseArray.put(e.g.tag_user_mute_mute_username, postData.zG().getUserName());
                    sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zG().getName_show());
                }
                sparseArray.put(e.g.tag_user_mute_thread_id, bbVar.getId());
                sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z3 && bbVar != null) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bhR()));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            jVar.fYQ.setTag(sparseArray);
            jVar.fYM.setTag(sparseArray);
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
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fYQ.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = l.h(pageActivity, e.C0210e.tbds50);
            layoutParams.rightMargin = l.h(pageActivity, e.C0210e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, e.C0210e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fYQ.setPadding(h, 0, h, 0);
            if (z) {
                jVar.fYQ.jb(null);
                jVar.fYQ.setBackgroundDrawable(null);
                jVar.fYQ.getLayoutStrategy().gN(e.f.transparent_bg);
            } else {
                jVar.fYQ.getLayoutStrategy().gN(e.f.icon_click);
            }
            jVar.fYQ.getLayoutStrategy().gK(e.f.pic_video);
            a(jVar.fYQ, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.fYQ.setLayoutParams(layoutParams);
            jVar.fYQ.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            jVar.fYQ.setIsFromCDN(z2);
            jVar.fYQ.setText(postData.bEl(), true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.fYQ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.fYQ.setTag(sparseArray);
            jVar.fYF.setTag(e.g.tag_from, sparseArray);
        }
    }

    public static void a(final a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bEj() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(e.j.is_floor), Integer.valueOf(postData.bEj()));
                jVar.fYT.setVisibility(0);
                jVar.fYT.setText(format);
                z = true;
            } else {
                jVar.fYT.setVisibility(8);
                z = false;
            }
            f bEm = postData.bEm();
            boolean z2 = (bEm == null || StringUtils.isNull(bEm.getName())) ? false : true;
            if (z) {
                jVar.fYJ.setVisibility(0);
                i = fUl;
            } else {
                jVar.fYJ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fYK.setVisibility(0);
                i2 = fUl;
            } else {
                jVar.fYK.setVisibility(8);
                i2 = 0;
            }
            jVar.fYI.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fYI.setText(ao.O(postData.getTime()));
            } else {
                jVar.fYI.setText(ao.M(postData.getTime()));
            }
            if (z2) {
                final String name = bEm.getName();
                final String lat = bEm.getLat();
                final String lng = bEm.getLng();
                jVar.fYL.setVisibility(0);
                jVar.fYL.setPadding(fUl, 0, 0, 0);
                jVar.fYL.setText(bEm.getName());
                jVar.fYL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.b.1
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
            jVar.fYL.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bnJ() == null) {
            jVar.fYY.setVisibility(8);
            return;
        }
        TbRichText bEl = postData.bEl();
        com.baidu.tieba.pb.view.c.a(postData.bnJ(), jVar.fYY, false, false, bEl != null && StringUtils.isNull(bEl.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fYQ.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fYQ.setLayoutParams(layoutParams);
            jVar.fYQ.setPadding(0, 0, 0, 0);
            jVar.fYQ.jb(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fYQ.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0210e.ds20);
            jVar.fYQ.setLayoutParams(layoutParams2);
            jVar.fYQ.jb(postData.getBimg_url());
        }
        jVar.fYQ.setTextViewCheckSelection(false);
    }
}
