package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends k<PostData, h> implements View.OnClickListener {
    private TbRichTextView.f aSj;
    private com.baidu.tieba.pb.a.c aSk;
    private View.OnLongClickListener auu;
    private ArrayList<IconData> duX;
    private int ezL;
    private boolean ezM;
    private boolean ezN;
    private com.baidu.tieba.pb.data.f ezO;
    private com.baidu.tieba.pb.pb.sub.d ezP;
    private ArrayList<IconData> ezQ;
    private View.OnClickListener ezR;
    private View.OnClickListener ezS;
    private boolean ezT;
    private final boolean ezU;
    private int ezV;
    private int ezW;
    private com.baidu.tieba.vote.a ezX;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ezL = 0;
        this.ezM = true;
        this.ezN = true;
        this.ezO = null;
        this.mHostId = null;
        this.ezP = null;
        this.ezQ = null;
        this.duX = null;
        this.ezR = null;
        this.ezS = null;
        this.aSj = null;
        this.aSk = null;
        this.auu = null;
        this.ezT = false;
        this.ezU = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(hVar.eAw, d.e.common_color_10005, 1);
                aj.c(hVar.eAy, d.e.cp_link_tip_c, 3);
                aj.c(hVar.bHb, d.e.cp_cont_f, 1);
                aj.c(hVar.eAh, d.e.cp_cont_i, 1);
                aj.c(hVar.eAi, d.e.cp_cont_i, 1);
                aj.c(hVar.eAj, d.e.cp_cont_d, 1);
                aj.c(hVar.eAk, d.e.cp_cont_d, 1);
                aj.k(hVar.eAn, d.e.cp_bg_line_e);
                aj.k(hVar.eAo, d.e.cp_bg_line_e);
                aj.c(hVar.eAo, d.e.cp_bg_line_b);
                aj.k(hVar.eAr, d.e.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.ezV = getDimensionPixelSize(d.f.ds30);
        this.ezW = l.ad(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.ezM, this.ezL, false);
        a(hVar);
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, h hVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, hVar);
        a(hVar);
        c(hVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sm();
            a(hVar, postData2, view, i);
        }
        if (!this.ezT && this.ezU && hVar != null && hVar.eAm.Jm() && (listView = ((PbActivity) this.eDo.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ezT = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0895  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x08ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0abd  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0ac9  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0ae1  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(h hVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        String userId2;
        String userId3;
        if (hVar != null && postData != null) {
            aj.k(hVar.eAu, d.e.cp_bg_line_b);
            hVar.eAg.setTag(null);
            hVar.eAg.setUserId(null);
            hVar.bHb.setText((CharSequence) null);
            hVar.eAi.setVisibility(8);
            hVar.eAr.setVisibility(0);
            hVar.eAl.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.eAq.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.eAq.setTag(sparseArray);
                hVar.eAm.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(hVar.eAm, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ezM || f(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eAm.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eAm.setLayoutParams(layoutParams);
                hVar.eAm.setPadding(0, 0, 0, 0);
                hVar.eAm.gW(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                hVar.eAm.gW(postData.getBimg_url());
                if (postData.brq() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eAm.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    hVar.eAm.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eAm.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    hVar.eAm.setLayoutParams(layoutParams3);
                }
            }
            hVar.eAk.setText(am.r(postData.getTime()));
            hVar.eAp.setVisibility(8);
            if (postData.brq() == 1) {
                aj.k(hVar.eAc, d.e.cp_bg_line_d);
                hVar.eAd.setVisibility(8);
                hVar.eAu.setVisibility(8);
                hVar.eAq.setVisibility(8);
                hVar.eAk.setVisibility(8);
                hVar.eAp.setVisibility(0);
                hVar.eAs.setVisibility(8);
                hVar.eAt.setVisibility(8);
                hVar.eAJ.setVisibility(8);
                hVar.eAD.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                hVar.eAp.a(postData.brx(), str, str2, j, com.baidu.adp.lib.g.b.c(this.ezO.aMW().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                hVar.eAp.onChangeSkinType();
                if (this.ezN) {
                    PraiseData re = this.ezO.aMW().re();
                    if (re != null && re.getUser() != null && re.getUser().size() > 0) {
                        hVar.eAn.setVisibility(0);
                        hVar.eAo.setVisibility(0);
                        hVar.eAn.setIsFromPb(true);
                        hVar.eAn.a(re, this.ezO.aMW().getId(), re.getPostId(), true);
                        hVar.eAn.dD(this.mSkinType);
                    } else {
                        hVar.eAn.setVisibility(8);
                        hVar.eAo.setVisibility(8);
                    }
                    hVar.eAn.setVisibility(8);
                    hVar.eAo.setVisibility(0);
                } else {
                    hVar.eAn.setVisibility(8);
                    hVar.eAo.setVisibility(8);
                }
                a(hVar.eAm, getDimensionPixelSize(d.f.ds30));
                if (!this.eDo.aOO()) {
                    if (this.ezO.aNq() != null && this.ezO.aNq().size() <= 4) {
                        hVar.eAO.setVisibility(0);
                        List<bc> aNq = this.ezO.aNq();
                        for (int i2 = 0; i2 < aNq.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eAK, aNq);
                            } else if (i2 == 1) {
                                a(i2, hVar.eAL, aNq);
                            } else if (i2 == 2) {
                                a(i2, hVar.eAM, aNq);
                            } else if (i2 == 3) {
                                a(i2, hVar.eAN, aNq);
                            }
                        }
                    }
                } else {
                    hVar.eAO.setVisibility(8);
                }
            } else {
                hVar.eAO.setVisibility(8);
                hVar.eAu.setVisibility(0);
                aj.k(hVar.eAc, d.e.cp_bg_line_e);
                hVar.eAd.setVisibility(0);
                com.baidu.tbadk.data.g brt = postData.brt();
                hVar.eAD.setVisibility(8);
                if (brt != null && !TextUtils.isEmpty(brt.getName()) && !TextUtils.isEmpty(brt.getName().trim())) {
                    final String name = brt.getName();
                    final String lat = brt.getLat();
                    final String lng = brt.getLng();
                    hVar.eAH.setText(brt.getName());
                    aj.c(hVar.eAH, d.e.cp_cont_c, 1);
                    hVar.eAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.hh()) {
                                    g.this.eDo.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.O(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eAH.setVisibility(8);
                }
                hVar.eAn.setVisibility(8);
                hVar.eAo.setVisibility(8);
                hVar.eAq.setVisibility(0);
                hVar.eAk.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.brq()));
                hVar.eAj.setVisibility(0);
                hVar.eAj.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                hVar.eAl.setVisibility(0);
                aj.i(hVar.eAl, d.e.cp_link_tip_a);
            } else {
                hVar.eAl.setVisibility(8);
            }
            aj.j(hVar.eAe, d.g.bg_floor_new_middle);
            hVar.eAm.setVideoImageId(d.g.pic_video);
            hVar.eAm.setTextColor(aj.getColor(d.e.common_color_10039));
            hVar.eAm.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.brq()));
            if (postData.bru() > 0) {
                if (this.ezP == null) {
                    this.ezP = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.ezP.setIsFromCDN(this.mIsFromCDN);
                    this.ezP.E(this.ezR);
                    boolean z8 = false;
                    String userId4 = this.ezO.aMW().getAuthor().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.ezP.x(this.ezO.aNh(), z8);
                    this.ezP.U(this.ezO.aMW());
                }
                this.ezP.pl(postData.getId());
                hVar.eAr.setVisibility(0);
                hVar.eAr.a(postData, view);
                hVar.eAr.setChildOnClickListener(this.ezS);
                hVar.eAr.setChildOnLongClickListener(this.auu);
                hVar.eAr.setChildOnTouchListener(this.aSk);
                hVar.eAr.setSubPbAdapter(this.ezP);
                hVar.eAr.setVisibility(0);
                hVar.eAt.setPadding(0, 0, 0, l.f(this.mContext, d.f.ds24));
                hVar.eAJ.setVisibility(0);
            } else {
                hVar.eAt.setPadding(0, 0, 0, l.f(this.mContext, d.f.ds40));
                hVar.eAr.setVisibility(8);
                hVar.eAJ.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = u.gO(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gO = u.gO(name_show);
                if (i3 > 0) {
                    if (gO > 12) {
                        name_show = u.e(name_show, 0, 14) + "...";
                    }
                } else if (gO > 14) {
                    name_show = u.e(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bHb.setText(ag(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    hVar.bHb.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(hVar.bHb, d.e.cp_cont_h, 1);
                } else {
                    aj.c(hVar.bHb, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eAh.setVisibility(0);
                    aj.c(hVar.eAh, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eAh.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eAh.setOnClickListener(null);
                } else {
                    hVar.eAh.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(hVar.eAi, d.g.pb_manager);
                        hVar.eAh.setVisibility(8);
                        hVar.eAi.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(hVar.eAi, d.g.pb_assist);
                        hVar.eAh.setVisibility(8);
                        hVar.eAi.setVisibility(0);
                    }
                }
                int gO2 = u.gO(postData.getAuthor().getName_show());
                if (gO2 >= 14 && hVar.eAh.getVisibility() == 0 && hVar.eAl.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gO2 < 12 || hVar.eAh.getVisibility() != 0 || hVar.eAl.getVisibility() != 0) ? i4 : i4 - 1;
                this.ezQ = postData.getAuthor().getIconInfo();
                this.duX = postData.getAuthor().getTShowInfoNew();
                if (hVar.cJa != null) {
                    hVar.cJa.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    hVar.cJa.setOnClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.cBc);
                    hVar.cJa.a(this.ezQ, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (hVar.anO != null) {
                    hVar.anO.setOnClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.eOQ);
                    hVar.anO.a(this.duX, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pL())) {
                hVar.eAg.setVisibility(4);
                hVar.eAf.setVisibility(0);
                hVar.eAf.eh(postData.getAuthor().getPendantData().pL());
                hVar.eAf.getHeadView().c(portrait, 28, false);
                hVar.eAf.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                hVar.eAf.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                hVar.eAg.setVisibility(0);
                hVar.eAf.setVisibility(8);
                hVar.eAg.setUserId(postData.getAuthor().getUserId());
                hVar.eAg.setUserName(postData.getAuthor().getUserName());
                hVar.eAg.setImageDrawable(null);
                hVar.eAg.c(portrait, 28, false);
            }
            hVar.bHb.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            hVar.bHb.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            hVar.eAm.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            if (this.ezM) {
                hVar.eAm.setDefaultImageId(d.g.transparent_bg);
            } else {
                hVar.eAm.setDefaultImageId(d.g.icon_click);
            }
            hVar.eAm.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aBY();
            }
            if (this.ezT || !this.ezU) {
                hVar.eAm.a(tbRichText, false);
            } else {
                hVar.eAm.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.ezO.aNh() != 0) {
                if (this.ezO.aNh() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.getAuthor().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.ezO != null && this.ezO.aMW() != null && this.ezO.aMW().getAuthor() != null && postData.getAuthor() != null) {
                        userId2 = this.ezO.aMW().getAuthor().getUserId();
                        userId3 = postData.getAuthor().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.getAuthor().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (hVar.eAy != null) {
                                    hVar.eAy.setVisibility(0);
                                    hVar.eAy.setText(d.l.manage);
                                    hVar.eAy.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (hVar.eAy != null) {
                                    hVar.eAy.setVisibility(0);
                                    hVar.eAy.setText(d.l.delete);
                                    hVar.eAy.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (hVar.eAy != null) {
                                hVar.eAy.setVisibility(8);
                            }
                            int i6 = 1;
                            if (postData.brq() == 1) {
                                i6 = 0;
                            }
                            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.h.tag_should_manage_visible, true);
                                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.ezO.aNh()));
                                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                            } else {
                                sparseArray2.put(d.h.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.h.tag_user_mute_visible, true);
                                sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.getAuthor() != null) {
                                    sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                                    sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                                }
                                if (this.ezO.aMW() != null) {
                                    sparseArray2.put(d.h.tag_user_mute_thread_id, this.ezO.aMW().getId());
                                }
                                sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.h.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.h.tag_should_delete_visible, true);
                                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.ezO.aNh()));
                                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.h.tag_should_delete_visible, false);
                            }
                            a(hVar, postData, postData.brq() != 1, tbRichText);
                            b(hVar);
                            a(view, postData);
                            if (this.ezX == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.ezX.bxR();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.getAuthor().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i62 = 1;
                    if (postData.brq() == 1) {
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.brq() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.ezX == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.ezO != null) {
                userId2 = this.ezO.aMW().getAuthor().getUserId();
                userId3 = postData.getAuthor().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.getAuthor().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i622 = 1;
                    if (postData.brq() == 1) {
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.brq() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.ezX == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.getAuthor().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i6222 = 1;
            if (postData.brq() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(hVar, postData, postData.brq() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.ezX == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eAm.setTextViewOnTouchListener(this.aSk);
        hVar.eAm.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aTN() == null || f(postData)) {
            hVar.eAI.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aTN(), hVar.eAI, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ezW - (i - this.ezV));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean f(PostData postData) {
        return (this.ezO == null || this.ezO.aMW() == null || !this.ezO.aMW().sa() || this.ezO.aMW().rc() == null || postData.brq() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (f(postData) && view != null && this.eDo != null) {
            if (this.ezX == null) {
                this.ezX = new com.baidu.tieba.vote.a(this.eDo);
            }
            this.ezX.a(view, this.ezO);
        } else if (this.ezX != null) {
            this.ezX.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bHb.setOnClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.eOP);
        hVar.eAg.setOnClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.eOP);
        hVar.eAf.setOnClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.eOP);
        hVar.eAq.setOnLongClickListener(this.auu);
        hVar.eAm.setOnLongClickListener(this.auu);
        hVar.eAq.setOnTouchListener(this.aSk);
        hVar.eAm.setOnTouchListener(this.aSk);
        hVar.eAm.setOnImageClickListener(this.aSj);
        hVar.eAm.setOnEmotionClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.eOR);
        hVar.cJa.setOnClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.cBc);
        hVar.anO.setOnClickListener(((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF.eOQ);
        hVar.eAI.setOnClickListener(this.ezS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ezO = fVar;
    }

    public void oZ(int i) {
        this.ezL = i;
    }

    public void iD(boolean z) {
        this.ezM = z;
    }

    public void iE(boolean z) {
        this.ezN = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void C(View.OnClickListener onClickListener) {
        this.ezR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.ezS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSj = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auu = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eDo.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<bc> list) {
        if (textView != null) {
            bc bcVar = (bc) v.c(list, i);
            if (bcVar == null) {
                textView.setVisibility(8);
                return;
            }
            final String forumName = bcVar.getForumName();
            final String forumId = bcVar.getForumId();
            textView.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.oI(forumName);
                    TiebaStatic.log(new ak("c12041").ac("fid", forumId));
                }
            });
        }
    }

    public void oI(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eDo.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
