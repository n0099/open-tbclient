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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.s.ao;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> hlf = new SparseArray<>();
    private static SparseIntArray hlg = new SparseIntArray();
    public static final int hlh = getDimensionPixelSize(d.e.tbds12);
    public static final int hli = getDimensionPixelSize(d.e.tbds16);
    public static final int hlj = getDimensionPixelSize(d.e.tbds40);

    public static int getDimensionPixelSize(int i) {
        int i2 = hlg.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            hlg.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return n.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(j jVar, com.baidu.tieba.pb.data.d dVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                al.d(jVar.dYS, d.C0277d.cp_cont_f, 1);
                if (jVar.hpI.getTag() instanceof Integer) {
                    al.k(jVar.hpI, ((Integer) jVar.hpI.getTag()).intValue());
                }
                al.d(jVar.hpJ, d.C0277d.cp_cont_d, 1);
                al.j(jVar.hpK, d.C0277d.cp_cont_d);
                al.j(jVar.hpL, d.C0277d.cp_cont_d);
                al.d(jVar.hpU, d.C0277d.cp_cont_d, 1);
                al.d(jVar.hpM, d.C0277d.cp_cont_d, 1);
                jVar.hpP.setTextColor(al.getColor(d.C0277d.cp_cont_b));
                jVar.hpQ.onChangeSkinType();
                if (dVar != null) {
                    al.j(jVar.hpS, d.C0277d.cp_cont_c);
                    jVar.hpS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                    al.j(jVar.hpT, d.C0277d.cp_cont_c);
                    al.l(jVar.hpR, d.C0277d.cp_bg_line_e);
                    jVar.hpR.onChangeSkinType();
                    al.d(jVar.hqd, d.C0277d.cp_link_tip_c, 1);
                    al.d(jVar.hqb, d.C0277d.cp_cont_f, 1);
                    al.k(jVar.hqa, d.C0277d.cp_bg_line_e);
                    al.k(jVar.hqc, d.C0277d.cp_cont_d);
                    al.c(jVar.hqe, d.f.icon_arrow_more_gray);
                    al.j(jVar.hqh, d.C0277d.cp_cont_c);
                    if (jVar.hqf.getVisibility() == 8) {
                        jVar.hpS.setVisibility(8);
                        jVar.hpT.setVisibility(8);
                        jVar.hqh.setText(d.j.close_content);
                    } else if (StringUtils.isNull(dVar.bIe())) {
                        jVar.hqh.setText(dVar.bIe());
                    } else {
                        jVar.hqh.setText(d.j.expand_content);
                    }
                } else {
                    jVar.hpR.setVisibility(8);
                    jVar.hpS.setVisibility(8);
                    jVar.hpT.setVisibility(8);
                    jVar.hqa.setVisibility(8);
                    jVar.hqh.setVisibility(8);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(j jVar, PostData postData, bg bgVar, int i) {
        if (jVar != null && postData != null && postData.aaE() != null) {
            if (bgVar != null) {
                postData.aaE().threadId = bgVar.getTid();
                postData.aaE().forumId = String.valueOf(bgVar.getFid());
            }
            if (i == 0) {
                postData.aaE().objType = 1;
            } else {
                postData.aaE().objType = 2;
            }
            postData.aaE().isInPost = true;
            jVar.hpN.setData(postData.aaE());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0486 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x064a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(j jVar, PostData postData, View view, int i, a aVar, bg bgVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String userId;
        if (jVar != null && postData != null) {
            if (postData.iGw) {
                al.l(jVar.mTopLine, d.C0277d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            if (bgVar == null || bgVar.YO() == null) {
                str = null;
            } else {
                str = bgVar.YO().getUserId();
            }
            jVar.hpO.setTag(null);
            jVar.hpO.setUserId(null);
            jVar.dYS.setText((CharSequence) null);
            jVar.hpW.getHeadView().setUserId(null);
            jVar.hpP.setIsHost(false);
            if (postData.YO() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.YO().getUserId())) {
                    jVar.hpP.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YO().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YO().getTShowInfoNew();
                if (jVar.hpY != null) {
                    jVar.hpY.setTag(d.g.tag_user_id, postData.YO().getUserId());
                    jVar.hpY.setOnClickListener(aVar.bIM().hzS);
                    jVar.hpY.a(iconInfo, 2, hlj, hlj, hlh);
                }
                if (jVar.hpX != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hpX.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hpX.setOnClickListener(aVar.bIM().hzT);
                    jVar.hpX.a(tShowInfoNew, 3, hlj, hlj, hlh, true);
                }
                if (!v.T(tShowInfoNew) || postData.YO().isBigV()) {
                    al.d(jVar.dYS, d.C0277d.cp_cont_h, 1);
                } else {
                    al.d(jVar.dYS, d.C0277d.cp_cont_f, 1);
                }
                String portrait = postData.YO().getPortrait();
                jVar.dYS.setTag(d.g.tag_user_id, postData.YO().getUserId());
                jVar.dYS.setTag(d.g.tag_user_name, postData.YO().getUserName());
                jVar.dYS.setTag(d.g.tag_virtual_user_url, postData.YO().getVirtualUserUrl());
                String name_show = postData.YO().getName_show();
                String userName = postData.YO().getUserName();
                if (ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dYS.setText(c.aP(aVar.getPageContext().getPageActivity(), jVar.dYS.getText().toString()));
                    jVar.dYS.setGravity(16);
                    jVar.dYS.setTag(d.g.tag_nick_name_activity, c.bHH());
                    al.d(jVar.dYS, d.C0277d.cp_other_e, 1);
                }
                if (postData.YO().getPendantData() != null && !StringUtils.isNull(postData.YO().getPendantData().Xk())) {
                    jVar.hpW.b(postData.YO());
                    jVar.hpO.setVisibility(8);
                    jVar.hpW.setVisibility(0);
                    jVar.hpW.getHeadView().startLoad(portrait, 28, false);
                    jVar.hpW.getHeadView().setUserId(postData.YO().getUserId());
                    jVar.hpW.getHeadView().setUserName(postData.YO().getUserName());
                    jVar.hpW.nn(postData.YO().getPendantData().Xk());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hpO, postData.YO());
                    jVar.hpO.setUserId(postData.YO().getUserId());
                    jVar.hpO.setUserName(postData.YO().getUserName(), postData.cez());
                    jVar.hpO.setTag(d.g.tag_virtual_user_url, postData.YO().getVirtualUserUrl());
                    jVar.hpO.setImageDrawable(null);
                    jVar.hpO.startLoad(portrait, 28, false);
                    jVar.hpO.setVisibility(0);
                    jVar.hpW.setVisibility(8);
                }
                if (postData.YO() != null) {
                    MetaData YO = postData.YO();
                    int ht = postData.ceh() ? d.f.brand_official_btn : al.ht(d.f.bg_user_identity_btn);
                    int ht2 = postData.ceh() ? d.C0277d.cp_btn_a : al.ht(d.C0277d.cp_bg_line_d);
                    al.k(jVar.hpI, ht);
                    al.j(jVar.hpI, ht2);
                    jVar.hpI.setTag(Integer.valueOf(ht));
                    if (str != null && !str.equals("0") && str.equals(YO.getUserId())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.host_name);
                    } else if (YO.getIs_bawu() == 1 && postData.ceh()) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.brand_Official);
                    } else if (YO.getIs_bawu() == 1 && "manager".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YO.getIs_bawu() == 1 && "assist".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YO.getIs_bawu() == 1 && "pri_content_assist".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_content_assist_tip);
                    } else if (YO.getIs_bawu() == 1 && "pri_manage_assist".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hpI.setVisibility(8);
                        jVar.hpI.setTag(null);
                    }
                } else {
                    jVar.hpI.setVisibility(8);
                    jVar.hpI.setTag(null);
                }
            }
            int i2 = 0;
            if (aVar.bIN()) {
                if (postData.YO() != null) {
                    i2 = postData.YO().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                jVar.hpV.setVisibility(0);
                al.c(jVar.hpV, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                jVar.hpV.setVisibility(8);
            }
            int i3 = 20;
            if (jVar.hpY.getChildCount() == 1) {
                i3 = 18;
            } else if (jVar.hpY.getChildCount() > 1) {
                i3 = 16;
            }
            if (jVar.hpI.getVisibility() == 0) {
                i3 -= 2;
            }
            if (jVar.hpX.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.YO() != null ? postData.YO().getName_show() : "";
            int pO = ab.pO(name_show2);
            if (postData.YO() != null && !StringUtils.isNull(postData.YO().getSealPrefix())) {
                if (pO > i3 - 2) {
                    name_show2 = ab.ah(name_show2, i3 - 2) + "...";
                }
            } else if (pO > i3) {
                name_show2 = ab.ah(name_show2, i3) + "...";
            }
            if (postData.YO() != null && !StringUtils.isNull(postData.YO().getSealPrefix())) {
                jVar.dYS.setText(a(aVar, postData.YO().getSealPrefix(), name_show2));
            } else {
                jVar.dYS.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cep()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (postData.YO() == null || StringUtils.isNull(postData.YO().getVirtualUserUrl())) {
                z = false;
            } else {
                z = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (bgVar != null && aVar.bIP() != 0) {
                if (aVar.bIP() != 1002 && aVar.bIP() != 3) {
                    z8 = true;
                }
                if (aVar.bIP() != 3) {
                    z9 = true;
                }
                if (postData != null && postData.YO() != null) {
                    String userId2 = postData.YO().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z11 = z9;
                        z2 = false;
                        z3 = z11;
                        if (bgVar != null && bgVar.YO() != null && postData.YO() != null) {
                            userId = bgVar.YO().getUserId();
                            String userId3 = postData.YO().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z4 = true;
                                z5 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z5 = false;
                                    z10 = true;
                                }
                                if (postData == null && postData.YO() != null && UtilHelper.isCurrentAccount(postData.YO().getUserId())) {
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
                                if (postData.cep() == 1) {
                                    i4 = 0;
                                }
                                if (z2) {
                                    sparseArray.put(d.g.tag_should_manage_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(aVar.bIP()));
                                    if (postData.YO() != null) {
                                        sparseArray.put(d.g.tag_forbid_user_name, postData.YO().getUserName());
                                        sparseArray.put(d.g.tag_forbid_user_name_show, postData.YO().getName_show());
                                        sparseArray.put(d.g.tag_forbid_user_portrait, postData.YO().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(d.g.tag_should_manage_visible, false);
                                }
                                if (z5) {
                                    sparseArray.put(d.g.tag_user_mute_visible, true);
                                    sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.YO() != null) {
                                        sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YO().getUserId());
                                        sparseArray.put(d.g.tag_user_mute_mute_username, postData.YO().getUserName());
                                        sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YO().getName_show());
                                    }
                                    sparseArray.put(d.g.tag_user_mute_thread_id, bgVar.getId());
                                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_user_mute_visible, false);
                                }
                                if (!z7 && bgVar != null) {
                                    sparseArray.put(d.g.tag_should_delete_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(aVar.bIP()));
                                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_should_delete_visible, false);
                                }
                                jVar.hpP.setTag(sparseArray);
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
                        if (postData.cep() == 1) {
                        }
                        if (z2) {
                        }
                        if (z5) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                        jVar.hpP.setTag(sparseArray);
                    }
                }
            }
            boolean z12 = z9;
            z2 = z8;
            z3 = z12;
            if (bgVar != null) {
                userId = bgVar.YO().getUserId();
                String userId32 = postData.YO().getUserId();
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
            if (postData.cep() == 1) {
            }
            if (z2) {
            }
            if (z5) {
            }
            if (!z7) {
            }
            sparseArray.put(d.g.tag_should_delete_visible, false);
            jVar.hpP.setTag(sparseArray);
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(d.e.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().ky(aO - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cCq = (aO - dimensionPixelSize) - getDimensionPixelSize(d.e.tbds122);
            tbRichTextView.getLayoutStrategy().kz((int) (aO * 1.618f));
        }
    }

    public static void a(a aVar, j jVar, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (jVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpP.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.h(pageActivity, d.e.tbds44);
            layoutParams.leftMargin = l.h(pageActivity, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                jVar.hpP.qc(null);
                jVar.hpP.setBackgroundDrawable(null);
                jVar.hpP.getLayoutStrategy().kA(d.f.transparent_bg);
            } else {
                jVar.hpP.getLayoutStrategy().kA(d.f.icon_click);
            }
            jVar.hpP.getLayoutStrategy().kx(d.f.pic_video);
            a(jVar.hpP, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            jVar.hpP.setLayoutParams(layoutParams);
            jVar.hpP.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            jVar.hpP.setIsFromCDN(z2);
            TbRichText cer = postData.cer();
            jVar.hpP.setIsUseGridImage(postData.ceC());
            jVar.hpP.setText(cer, true, cVar);
            SparseArray sparseArray = (SparseArray) jVar.hpP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, Boolean.valueOf(z3));
            jVar.hpP.setTag(sparseArray);
            jVar.hpG.setTag(d.g.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cep() > 0) {
                String format = String.format(TbadkApplication.getInst().getString(d.j.is_floor), Integer.valueOf(postData.cep()));
                jVar.hpU.setVisibility(0);
                jVar.hpU.setText(format);
                z = true;
            } else {
                jVar.hpU.setVisibility(8);
                z = false;
            }
            f ces = postData.ces();
            boolean z2 = (ces == null || StringUtils.isNull(ces.getName())) ? false : true;
            if (z) {
                jVar.hpK.setVisibility(0);
                i = hli;
            } else {
                jVar.hpK.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hpL.setVisibility(0);
                i2 = hli;
            } else {
                jVar.hpL.setVisibility(8);
                i2 = 0;
            }
            jVar.hpJ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hpJ.setText(ap.aq(postData.getTime()));
            } else {
                jVar.hpJ.setText(ap.ao(postData.getTime()));
            }
            if (z2) {
                jVar.hpM.setVisibility(0);
                jVar.hpM.setPadding(hli, 0, 0, 0);
                jVar.hpM.setText(ces.getName());
                return;
            }
            jVar.hpM.setVisibility(8);
        }
    }

    public static void a(j jVar, PostData postData) {
        if (postData == null || postData.bOL() == null) {
            jVar.hpZ.setVisibility(8);
            return;
        }
        TbRichText cer = postData.cer();
        com.baidu.tieba.pb.view.b.a(postData.bOL(), jVar.hpZ, false, false, cer != null && StringUtils.isNull(cer.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(j jVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpP.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hpP.setLayoutParams(layoutParams);
            jVar.hpP.setPadding(0, 0, 0, 0);
            jVar.hpP.qc(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hpP.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hpP.setLayoutParams(layoutParams2);
            jVar.hpP.qc(postData.getBimg_url());
        }
        jVar.hpP.setTextViewCheckSelection(false);
    }
}
