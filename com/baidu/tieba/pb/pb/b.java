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
    private static SparseArray<SoftReference<Drawable>> fRq = new SparseArray<>();
    private static SparseIntArray fRr = new SparseIntArray();
    public static final int fRs = getDimensionPixelSize(e.C0210e.tbds12);
    public static final int fRt = getDimensionPixelSize(e.C0210e.tbds20);
    public static final int fRu = getDimensionPixelSize(e.C0210e.tbds36);

    public static int getDimensionPixelSize(int i) {
        int i2 = fRr.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            fRr.put(i, dimensionPixelSize);
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
                al.c(jVar.cKl, e.d.cp_cont_f, 1);
                if (jVar.fVP.getTag() instanceof Integer) {
                    al.i(jVar.fVP, ((Integer) jVar.fVP.getTag()).intValue());
                }
                al.c(jVar.fVQ, e.d.cp_cont_d, 1);
                al.i(jVar.fVR, e.d.cp_cont_e);
                al.i(jVar.fVS, e.d.cp_cont_e);
                al.c(jVar.fWb, e.d.cp_cont_d, 1);
                al.c(jVar.fVT, e.d.cp_cont_d, 1);
                al.j(jVar.mBottomLine, e.d.cp_bg_line_c);
                al.c(jVar.fVU, e.f.icon_floor_more_selector);
                jVar.fVY.setTextColor(al.getColor(e.d.cp_cont_b));
                jVar.fVZ.onChangeSkinType();
                if (dVar != null) {
                    jVar.fWa.setVisibility(0);
                    al.j(jVar.fWa, e.d.cp_bg_line_e);
                    jVar.fWa.onChangeSkinType();
                    al.c(jVar.fWk, e.d.cp_link_tip_c, 1);
                    al.c(jVar.fWi, e.d.cp_cont_f, 1);
                    al.i(jVar.fWh, e.d.cp_bg_line_e);
                    al.i(jVar.fWj, e.d.cp_cont_d);
                    al.c(jVar.fWl, e.f.icon_arrow_more_gray);
                    al.h(jVar.fWo, e.d.cp_cont_j);
                    if (jVar.fWm.getVisibility() == 8) {
                        jVar.fWo.setText(e.j.close_content);
                        al.c(jVar.fWp, e.f.icon_arrow_gray_up);
                    } else if (StringUtils.isNull(dVar.bgs())) {
                        jVar.fWo.setText(dVar.bgs());
                        al.c(jVar.fWp, e.f.icon_arrow_gray_down);
                    } else {
                        jVar.fWo.setText(e.j.expand_content);
                    }
                } else {
                    jVar.fWa.setVisibility(8);
                    jVar.fWh.setVisibility(8);
                    jVar.fWo.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bb bbVar, int i) {
        if (jVar != null && postData != null) {
            jVar.fWq.a(postData);
            jVar.fVV.setTag(e.g.tag_clip_board, postData);
            String valueOf = String.valueOf(bbVar.getFid());
            String id = postData.getId();
            String tid = bbVar.getTid();
            jVar.fVV.setForumId(valueOf);
            jVar.fVV.setThreadId(tid);
            jVar.fVV.setPostId(id);
            jVar.fVW.setForumId(valueOf);
            jVar.fVW.setThreadId(tid);
            jVar.fVW.setPostId(id);
            if (i == 0) {
                jVar.fVV.setObjType(1);
                jVar.fVW.setObjType(1);
                return;
            }
            jVar.fVV.setObjType(2);
            jVar.fVW.setObjType(2);
        }
    }

    public static void a(j jVar, PostData postData, View view, int i, a aVar, bb bbVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (jVar != null && postData != null) {
            if (postData.hlW) {
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
            jVar.fVX.setTag(null);
            jVar.fVX.setUserId(null);
            jVar.cKl.setText((CharSequence) null);
            jVar.fWd.getHeadView().setUserId(null);
            jVar.fVY.setIsHost(false);
            if (postData.zG() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.zG().getUserId())) {
                    jVar.fVY.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.zG().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.zG().getTShowInfoNew();
                if (jVar.fWf != null) {
                    jVar.fWf.setTag(e.g.tag_user_id, postData.zG().getUserId());
                    jVar.fWf.setOnClickListener(aVar.bhd().ggm);
                    jVar.fWf.a(iconInfo, 2, fRu, fRu, fRs);
                }
                if (jVar.fWe != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.fWe.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.fWe.setOnClickListener(aVar.bhd().ggn);
                    jVar.fWe.a(tShowInfoNew, 3, fRu, fRu, fRs, true);
                }
                if (!v.I(tShowInfoNew) || postData.zG().isBigV()) {
                    al.c(jVar.cKl, e.d.cp_cont_h, 1);
                } else {
                    al.c(jVar.cKl, e.d.cp_cont_f, 1);
                }
                String portrait = postData.zG().getPortrait();
                jVar.cKl.setTag(e.g.tag_user_id, postData.zG().getUserId());
                jVar.cKl.setTag(e.g.tag_user_name, postData.zG().getUserName());
                jVar.cKl.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                String name_show = postData.zG().getName_show();
                String userName = postData.zG().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    jVar.cKl.setText(c.aE(aVar.getPageContext().getPageActivity(), jVar.cKl.getText().toString()));
                    jVar.cKl.setGravity(16);
                    jVar.cKl.setTag(e.g.tag_nick_name_activity, c.bfT());
                    al.c(jVar.cKl, e.d.cp_other_e, 1);
                }
                if (postData.zG().getPendantData() != null && !StringUtils.isNull(postData.zG().getPendantData().ys())) {
                    jVar.fWd.b(postData.zG());
                    jVar.fVX.setVisibility(8);
                    jVar.fWd.setVisibility(0);
                    jVar.fWd.getHeadView().startLoad(portrait, 28, false);
                    jVar.fWd.getHeadView().setUserId(postData.zG().getUserId());
                    jVar.fWd.getHeadView().setUserName(postData.zG().getUserName());
                    jVar.fWd.gl(postData.zG().getPendantData().ys());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.fVX, postData.zG());
                    jVar.fVX.setUserId(postData.zG().getUserId());
                    jVar.fVX.setUserName(postData.zG().getUserName(), postData.bDC());
                    jVar.fVX.setTag(e.g.tag_virtual_user_url, postData.zG().getVirtualUserUrl());
                    jVar.fVX.setImageDrawable(null);
                    jVar.fVX.startLoad(portrait, 28, false);
                    jVar.fVX.setVisibility(0);
                    jVar.fWd.setVisibility(8);
                }
                if (postData.zG() != null) {
                    MetaData zG = postData.zG();
                    int i2 = postData.bDk() ? e.f.brand_official_btn : e.f.user_identity_btn;
                    int i3 = postData.bDk() ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                    al.i(jVar.fVP, i2);
                    al.h(jVar.fVP, i3);
                    jVar.fVP.setTag(Integer.valueOf(i2));
                    if (str != null && !str.equals("0") && str.equals(zG.getUserId())) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.host_name);
                    } else if (zG.getIs_bawu() == 1 && postData.bDk()) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.brand_Official);
                    } else if (zG.getIs_bawu() == 1 && "manager".equals(zG.getBawu_type())) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.bawu_member_bazhu_tip);
                    } else if (zG.getIs_bawu() == 1 && "assist".equals(zG.getBawu_type())) {
                        jVar.fVP.setVisibility(0);
                        jVar.fVP.setText(e.j.bawu_member_xbazhu_tip);
                    } else {
                        jVar.fVP.setVisibility(8);
                        jVar.fVP.setTag(null);
                    }
                } else {
                    jVar.fVP.setVisibility(8);
                    jVar.fVP.setTag(null);
                }
            }
            int i4 = 0;
            if (aVar.bhe()) {
                if (postData.zG() != null) {
                    i4 = postData.zG().getLevel_id();
                }
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                jVar.fWc.setVisibility(0);
                al.c(jVar.fWc, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.fWc.setVisibility(8);
            }
            int i5 = 20;
            if (jVar.fWf.getChildCount() == 1) {
                i5 = 18;
            } else if (jVar.fWf.getChildCount() > 1) {
                i5 = 16;
            }
            if (jVar.fVP.getVisibility() == 0) {
                i5 -= 2;
            }
            if (jVar.fWe.getChildCount() > 0) {
                i5 -= 2;
            }
            String name_show2 = postData.zG() != null ? postData.zG().getName_show() : "";
            int iM = y.iM(name_show2);
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                if (iM > i5 - 2) {
                    name_show2 = y.J(name_show2, i5 - 2) + "...";
                }
            } else if (iM > i5) {
                name_show2 = y.J(name_show2, i5) + "...";
            }
            if (postData.zG() != null && !StringUtils.isNull(postData.zG().getSealPrefix())) {
                jVar.cKl.setText(a(aVar, postData.zG().getSealPrefix(), name_show2));
            } else {
                jVar.cKl.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bDs()));
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
            if (bbVar != null && aVar.bhg() != 0) {
                if (aVar.bhg() != 1002) {
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
            if (postData.bDs() == 1) {
                i6 = 0;
            }
            if (z4) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bhg()));
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
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(aVar.bhg()));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i6));
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            jVar.fVY.setTag(sparseArray);
            jVar.fVU.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().gK(aO - (z ? getDimensionPixelSize(e.C0210e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().gL((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fVY.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int h = l.h(pageActivity, e.C0210e.tbds50);
            layoutParams.rightMargin = l.h(pageActivity, e.C0210e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, e.C0210e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.fVY.setPadding(h, 0, h, 0);
            if (z) {
                jVar.fVY.ja(null);
                jVar.fVY.setBackgroundDrawable(null);
                jVar.fVY.getLayoutStrategy().gM(e.f.transparent_bg);
            } else {
                jVar.fVY.getLayoutStrategy().gM(e.f.icon_click);
            }
            jVar.fVY.getLayoutStrategy().gJ(e.f.pic_video);
            a(jVar.fVY, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.fVY.setLayoutParams(layoutParams);
            jVar.fVY.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            jVar.fVY.setIsFromCDN(z2);
            jVar.fVY.setText(postData.bDu(), true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.fVY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.fVY.setTag(sparseArray);
            jVar.fVN.setTag(e.g.tag_from, sparseArray);
        }
    }

    public static void a(final a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.bDs() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(e.j.is_floor), Integer.valueOf(postData.bDs()));
                jVar.fWb.setVisibility(0);
                jVar.fWb.setText(format);
                z = true;
            } else {
                jVar.fWb.setVisibility(8);
                z = false;
            }
            f bDv = postData.bDv();
            boolean z2 = (bDv == null || StringUtils.isNull(bDv.getName())) ? false : true;
            if (z) {
                jVar.fVR.setVisibility(0);
                i = fRt;
            } else {
                jVar.fVR.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.fVS.setVisibility(0);
                i2 = fRt;
            } else {
                jVar.fVS.setVisibility(8);
                i2 = 0;
            }
            jVar.fVQ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                jVar.fVQ.setText(ao.N(postData.getTime()));
            } else {
                jVar.fVQ.setText(ao.L(postData.getTime()));
            }
            if (z2) {
                final String name = bDv.getName();
                final String lat = bDv.getLat();
                final String lng = bDv.getLng();
                jVar.fVT.setVisibility(0);
                jVar.fVT.setPadding(fRt, 0, 0, 0);
                jVar.fVT.setText(bDv.getName());
                jVar.fVT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.b.1
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
            jVar.fVT.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bmY() == null) {
            jVar.fWg.setVisibility(8);
            return;
        }
        TbRichText bDu = postData.bDu();
        com.baidu.tieba.pb.view.c.a(postData.bmY(), jVar.fWg, false, false, bDu != null && StringUtils.isNull(bDu.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.fVY.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.fVY.setLayoutParams(layoutParams);
            jVar.fVY.setPadding(0, 0, 0, 0);
            jVar.fVY.ja(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.fVY.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(e.C0210e.ds20);
            jVar.fVY.setLayoutParams(layoutParams2);
            jVar.fVY.ja(postData.getBimg_url());
        }
        jVar.fVY.setTextViewCheckSelection(false);
    }
}
