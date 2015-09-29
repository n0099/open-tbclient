package com.baidu.tieba.pb.pb.a;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.bk;
import com.baidu.tieba.pb.pb.sub.ai;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f extends bk<com.baidu.tieba.tbadkCore.data.k, j> implements View.OnClickListener {
    private static HashMap<Point, Integer> cgI = new HashMap<>();
    private TbRichTextView.c aCc;
    private ArrayList<IconData> aSF;
    private View.OnClickListener aZl;
    private View.OnLongClickListener ajT;
    private boolean cgA;
    private boolean cgB;
    private com.baidu.tieba.pb.a.b cgC;
    private String cgD;
    private ai cgE;
    private ArrayList<IconData> cgF;
    private View.OnClickListener cgG;
    private com.baidu.tieba.pb.b.c cgH;
    private boolean cgJ;
    private final boolean cgK;
    private int cgL;
    private int cgM;
    private int cgy;
    private boolean cgz;

    static {
        cgI.put(new Point(2, 1), Integer.valueOf(i.h.i_want_share_picture));
        cgI.put(new Point(2, 2), Integer.valueOf(i.h.look_result));
        cgI.put(new Point(2, 4), Integer.valueOf(i.h.i_want_share_picture));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cgy = 0;
        this.cgz = true;
        this.cgA = true;
        this.cgB = true;
        this.cgC = null;
        this.cgD = null;
        this.cgE = null;
        this.cgF = null;
        this.aSF = null;
        this.cgG = null;
        this.aZl = null;
        this.aCc = null;
        this.cgH = null;
        this.ajT = null;
        this.cgJ = false;
        this.cgK = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cgL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.cgM = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public j a(ViewGroup viewGroup) {
        return new j(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item_show_pic, viewGroup, false), this.cgA, this.cgz, this.cgy, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bk, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.k kVar, j jVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) kVar, (com.baidu.tieba.tbadkCore.data.k) jVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(jVar);
        com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) aA(i);
        am.j(jVar.cgU, i.c.cp_bg_line_b);
        am.j(jVar.cgV, i.c.cp_bg_line_b);
        am.b(jVar.chq, i.c.subpb_listitem_time, 1);
        am.b(jVar.chs, i.c.cp_link_tip_c, 3);
        am.b(jVar.aHN, i.c.cp_cont_f, 1);
        am.b((View) jVar.cgZ, i.c.cp_cont_i, 1);
        am.b(jVar.chb, i.c.cp_cont_d, 1);
        am.b(jVar.bpA, i.c.cp_cont_d, 1);
        am.c(jVar.chd, i.e.btn_pb_reply_selector);
        am.j(jVar.chh, i.c.cp_bg_line_b);
        am.j(jVar.chi, i.c.cp_bg_line_e);
        am.j(jVar.chj, i.c.cp_bg_line_e);
        am.c(jVar.chj, i.c.cp_bg_line_b);
        am.c(jVar.chm, i.c.cp_bg_line_b);
        int sw = this.cgC.aeO().sw();
        if (sw == 1 || sw == 4) {
            am.b(jVar.chf, i.c.cp_cont_i, 1);
            am.i((View) jVar.chf, i.e.buy_yinji_btn_bg);
        } else if (sw == 2) {
            am.b(jVar.chf, i.c.cp_cont_b, 1);
            am.i((View) jVar.chf, i.e.btn_pb_bottom_comment_selector);
        }
        if (kVar2 != null) {
            a(jVar, kVar2, view, false, i);
        }
        if (!this.cgJ && this.cgK && jVar != null && jVar.che.Fp() && (listView = ((PbActivity) this.ciJ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cgJ = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x090d  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0931  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(j jVar, com.baidu.tieba.tbadkCore.data.k kVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (jVar != null && kVar != null) {
            if (!z) {
                jVar.cgY.setTag(null);
                jVar.cgY.setUserId(null);
                jVar.aHN.setText((CharSequence) null);
                jVar.chn.setVisibility(0);
                jVar.chd.setVisibility(0);
                jVar.chc.setVisibility(8);
                if (kVar.awA() == null) {
                    jVar.cho.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && kVar.awA().zT() == 1) {
                    jVar.cho.changeSkinType(this.mSkinType);
                    jVar.cho.setVisibility(0);
                    jVar.cho.setData(kVar.awA());
                } else {
                    jVar.cho.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) jVar.chk.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    jVar.chk.setTag(sparseArray2);
                    jVar.che.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, kVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(jVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgz) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    jVar.che.setLayoutParams(layoutParams);
                    jVar.che.setPadding(0, 0, 0, 0);
                    jVar.che.fS(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, kVar.getBimg_url());
                    jVar.che.fS(kVar.getBimg_url());
                    if (kVar.awy() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.che.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        jVar.che.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) jVar.che.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        jVar.che.setLayoutParams(layoutParams3);
                    }
                }
                jVar.bpA.setText(ar.o(kVar.getTime()));
                if (kVar.awy() == 1) {
                    am.j(jVar.cgT, i.c.cp_bg_line_d);
                    jVar.cgU.setVisibility(8);
                    jVar.cgV.setVisibility(8);
                    jVar.cgW.setVisibility(8);
                    jVar.chk.setVisibility(8);
                    jVar.bpA.setVisibility(8);
                    if (this.cgB) {
                        PraiseData praise = this.cgC.aeO().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            jVar.chi.setVisibility(0);
                            jVar.chh.setVisibility(0);
                            jVar.chj.setVisibility(0);
                            jVar.chi.setIsFromPb(true);
                            jVar.chi.a(praise, this.cgC.aeO().getId(), praise.getPostId(), true);
                            jVar.chi.cP(this.mSkinType);
                        } else {
                            jVar.chi.setVisibility(8);
                            jVar.chh.setVisibility(8);
                            jVar.chj.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d awB = kVar.awB();
                        if (awB != null && !TextUtils.isEmpty(awB.getName()) && !TextUtils.isEmpty(awB.getName().trim())) {
                            String name = awB.getName();
                            String lat = awB.getLat();
                            String lng = awB.getLng();
                            jVar.chx.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, jVar.chx, 0, 10, 0, 10);
                            jVar.chz.setText(awB.getName());
                            am.b(jVar.chz, i.c.cp_cont_c, 1);
                            am.c(jVar.chy, i.e.icon_frs_site);
                            jVar.chx.setOnClickListener(new g(this, lat, lng, name));
                        } else {
                            jVar.chx.setVisibility(8);
                        }
                    } else {
                        jVar.chi.setVisibility(8);
                        jVar.chh.setVisibility(8);
                        jVar.chj.setVisibility(8);
                        jVar.chx.setVisibility(8);
                    }
                    a(jVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) jVar.cho.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                }
                if (this.cgD != null && !this.cgD.equals("0") && this.cgD.equals(kVar.getAuthor().getUserId())) {
                    jVar.chc.setVisibility(0);
                    am.c(jVar.chc, i.e.icon_floorhost);
                }
            }
            am.i(jVar.cgX, i.e.bg_floor_new_middle);
            jVar.che.setVideoImageId(i.e.pic_video);
            jVar.che.setTextColor(am.getColor(i.c.pb_listitem_content));
            am.c(jVar.chd, i.e.btn_pb_reply_selector);
            jVar.che.setLinkTextColor(am.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) jVar.chd.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                jVar.chd.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_load_sub_data, kVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (kVar.awC() > 0) {
                if (this.cgE == null) {
                    this.cgE = new ai(this.mContext);
                    this.cgE.setIsFromCDN(this.mIsFromCDN);
                    this.cgE.D(this.cgG);
                    boolean z7 = false;
                    String userId2 = this.cgC.aeO().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cgE.p(this.cgC.aeS(), z7);
                    this.cgE.e(this.cgC.aeO());
                    this.cgE.eq(this.cgA);
                }
                jVar.chn.setVisibility(0);
                jVar.chm.setVisibility(0);
                jVar.chl.setVisibility(0);
                jVar.chn.a(kVar, view);
                jVar.chn.setChildOnClickListener(this.aZl);
                jVar.chn.setChildOnLongClickListener(this.ajT);
                jVar.chn.setChildOnTouchListener(this.cgH);
                jVar.chn.setSubPbAdapter(this.cgE);
                jVar.chn.setVisibility(0);
            } else {
                jVar.chn.setVisibility(8);
                jVar.chm.setVisibility(8);
                jVar.chl.setVisibility(8);
            }
            a(jVar, kVar, this.cgC.aeV(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    jVar.aHN.setText(kVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        am.b(jVar.aHN, i.c.cp_cont_h, 1);
                    } else {
                        am.b(jVar.aHN, i.c.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        jVar.cgZ.setVisibility(0);
                        am.c(jVar.cgZ, com.baidu.tbadk.core.util.c.ch(level_id));
                        i2 = 2;
                        jVar.cgZ.setOnClickListener(null);
                    } else {
                        jVar.cgZ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            am.c(jVar.cgZ, i.e.pb_manager);
                        } else if (bawu_type.equals("assist")) {
                            am.c(jVar.cgZ, i.e.pb_assist);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        am.c(jVar.cha, i.e.icon_pop_girl_square);
                        jVar.cha.setVisibility(0);
                    } else {
                        jVar.cha.setVisibility(8);
                    }
                    this.cgF = kVar.getAuthor().getIconInfo();
                    this.aSF = kVar.getAuthor().getTShowInfo();
                    if (jVar.bcC != null) {
                        jVar.bcC.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                        jVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
                        jVar.bcC.a(this.cgF, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (jVar.aSX != null) {
                        jVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
                        jVar.aSX.a(this.aSF, 3, this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                    }
                }
                jVar.cgY.setUserId(kVar.getAuthor().getUserId());
                jVar.cgY.setUserName(kVar.getAuthor().getUserName());
                jVar.cgY.setImageDrawable(null);
                jVar.aHN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                jVar.aHN.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
                jVar.cgY.d(portrait, 28, false);
            }
            jVar.che.setLinkTextColor(am.getColor(i.c.cp_link_tip_c));
            if (this.cgz) {
                jVar.che.setDefaultImageId(i.e.img_default_100);
            } else {
                jVar.che.setDefaultImageId(i.e.icon_click);
            }
            jVar.che.setIsFromCDN(this.mIsFromCDN);
            if (this.cgz) {
                jVar.chg.setDefaultImageId(i.e.img_default_100);
            } else {
                jVar.chg.setDefaultImageId(i.e.icon_click);
            }
            jVar.chg.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (kVar.awy() == 1 && this.cgC.aeO().sy()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a awz = kVar.awz();
                if (awz != null && awz.ET() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> ET = awz.ET();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= ET.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = ET.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.f EY = cVar.EY();
                            EY.setWidth(jVar.chg.getMaxImageWidth());
                            EY.setHeight(jVar.chg.getMaxImageHeight());
                            EY.bt(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                jVar.chf.setVisibility(8);
                jVar.chg.setVisibility(8);
                if (arrayList.size() >= 1) {
                    jVar.chg.setVisibility(0);
                }
                int sw = this.cgC.aeO().sw();
                if (sw == 1 || sw == 2 || sw == 4) {
                    jVar.chf.setVisibility(0);
                    jVar.chf.setOnClickListener(this.aZl);
                    jVar.chf.setEnabled(true);
                }
                Integer num = cgI.get(new Point(this.cgC.aeO().sx(), sw));
                if (num != null) {
                    jVar.chf.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                jVar.chf.setVisibility(8);
                jVar.chg.setVisibility(8);
            }
            if (aVar == null) {
                aVar = kVar.awz();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.cgJ || !this.cgK) {
                jVar.che.a(aVar, false);
                jVar.chg.a(aVar3, false);
            } else {
                jVar.che.a(aVar, true);
                jVar.chg.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cgC.aeS() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = kVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.cgC != null && this.cgC.aeO() != null && this.cgC.aeO().getAuthor() != null && kVar.getAuthor() != null) {
                String userId4 = this.cgC.aeO().getAuthor().getUserId();
                String userId5 = kVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = kVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (jVar.chs != null) {
                            jVar.chs.setVisibility(0);
                            jVar.chs.setText(i.h.manage);
                            jVar.chs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (jVar.chs != null) {
                            jVar.chs.setVisibility(0);
                            jVar.chs.setText(i.h.delete);
                            jVar.chs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (jVar.chs != null) {
                        jVar.chs.setVisibility(8);
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (kVar.awy() == 1) {
                        i5 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                    if (!z8) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgC.aeS()));
                        sparseArray.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (kVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, kVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, kVar.getAuthor().getUserName());
                        }
                        if (this.cgC.aeO() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cgC.aeO().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgC.aeS()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        jVar.chd.setVisibility(8);
                        am.b(jVar.chq, i.c.subpb_listitem_time, 1);
                        jVar.chq.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), ar.o(kVar.getTime())));
                        if (jVar.chs.getVisibility() == 0) {
                            am.b(jVar.chs, i.c.cp_link_tip_c, 3);
                            jVar.chs.setTag(sparseArray);
                            jVar.chs.setOnClickListener(this.cgG);
                        }
                    }
                    a(jVar, kVar, kVar.awy() != 1, aVar);
                    a(jVar, kVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = kVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i52 = 1;
            if (z) {
            }
            if (kVar.awy() == 1) {
            }
            sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(jVar, kVar, kVar.awy() != 1, aVar);
            a(jVar, kVar);
        }
    }

    private void a(j jVar, com.baidu.tieba.tbadkCore.data.k kVar) {
        if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgz) {
            jVar.che.setOnClickListener(null);
        } else {
            jVar.che.setOnClickListener(this.aZl);
        }
        jVar.che.setTextViewCheckSelection(false);
        jVar.che.setTextViewOnClickListener(new h(this));
    }

    private void a(j jVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (kVar == null || kVar.ahO() == null) {
            jVar.chA.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(kVar.ahO(), jVar.chA, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(kVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cgM - (i - this.cgL));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(j jVar, com.baidu.tieba.tbadkCore.data.k kVar, AdditionData additionData, int i) {
        if (kVar.awD() > 0 && kVar.awx() != null) {
            jVar.chp.setVisibility(0);
            jVar.chp.removeViews(0, jVar.chp.getChildCount() - 1);
            int size = kVar.awx().size();
            int awE = kVar.awE();
            for (int i2 = 0; i2 < awE; i2++) {
                com.baidu.tieba.tbadkCore.data.k kVar2 = kVar.awx().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) jVar.chp, false);
                j jVar2 = new j(inflate, this.cgA, this.cgz, this.cgy, true);
                a(jVar2);
                a(jVar2, kVar2, (View) jVar.chp, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, kVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.cgz) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    jVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar2.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    jVar2.che.setLayoutParams(layoutParams);
                    jVar2.che.setPadding(0, 0, 0, 0);
                    jVar.che.fS(null);
                } else {
                    jVar.che.fS(kVar.getBimg_url());
                    jVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar2.che.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    jVar2.che.setLayoutParams(layoutParams2);
                }
                jVar.chp.addView(inflate, jVar.chp.getChildCount() - 1);
            }
            if (awE < size) {
                jVar.cht.setVisibility(0);
                am.i(jVar.chv, i.c.cp_bg_line_b);
                am.i(jVar.chw, i.c.cp_bg_line_b);
                am.b(jVar.chu, i.c.cp_cont_f, 1);
                jVar.cht.setOnClickListener(new i(this, awE, size, kVar));
                return;
            }
            jVar.cht.setVisibility(8);
            return;
        }
        jVar.chp.setVisibility(8);
    }

    private void a(j jVar) {
        jVar.aHN.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        jVar.chd.setOnClickListener(this.aZl);
        jVar.cgY.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        jVar.chk.setOnLongClickListener(this.ajT);
        jVar.che.setOnLongClickListener(this.ajT);
        jVar.chk.setOnTouchListener(this.cgH);
        jVar.che.setOnTouchListener(this.cgH);
        jVar.che.setOnImageClickListener(this.aCc);
        jVar.chg.setOnImageClickListener(this.aCc);
        jVar.che.setOnEmotionClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clE);
        jVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
        jVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.b bVar) {
        this.cgC = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.cgy = i;
    }

    public void ep(boolean z) {
        this.cgz = z;
    }

    public void eq(boolean z) {
        this.cgA = z;
    }

    public void er(boolean z) {
        this.cgB = z;
    }

    public void jH(String str) {
        this.cgD = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cgG = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZl = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCc = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cgH = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajT = onLongClickListener;
    }
}
