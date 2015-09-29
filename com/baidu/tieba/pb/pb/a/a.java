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
public class a extends bk<com.baidu.tieba.tbadkCore.data.k, e> implements View.OnClickListener {
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
        cgI.put(new Point(1, 1), Integer.valueOf(i.h.i_want_lottery));
        cgI.put(new Point(1, 2), Integer.valueOf(i.h.look_result));
        cgI.put(new Point(1, 4), Integer.valueOf(i.h.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
    /* renamed from: G */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item_lottery, viewGroup, false), this.cgA, this.cgz, this.cgy, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bk, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.k kVar, e eVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) kVar, (com.baidu.tieba.tbadkCore.data.k) eVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(eVar);
        com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) aA(i);
        am.j(eVar.cgU, i.c.cp_bg_line_b);
        am.j(eVar.cgV, i.c.cp_bg_line_b);
        am.b(eVar.chq, i.c.subpb_listitem_time, 1);
        am.b(eVar.chs, i.c.cp_link_tip_c, 3);
        am.b(eVar.aHN, i.c.cp_cont_f, 1);
        am.b((View) eVar.cgZ, i.c.cp_cont_i, 1);
        am.b(eVar.chb, i.c.cp_cont_d, 1);
        am.b(eVar.bpA, i.c.cp_cont_d, 1);
        am.c(eVar.chd, i.e.btn_pb_reply_selector);
        am.j(eVar.chh, i.c.cp_bg_line_b);
        am.j(eVar.chi, i.c.cp_bg_line_e);
        am.j(eVar.chj, i.c.cp_bg_line_e);
        am.c(eVar.chj, i.c.cp_bg_line_b);
        am.c(eVar.chm, i.c.cp_bg_line_b);
        int sw = this.cgC.aeO().sw();
        if (sw == 1 || sw == 4) {
            am.b(eVar.chf, i.c.cp_cont_i, 1);
            am.i((View) eVar.chf, i.e.buy_yinji_btn_bg);
        } else if (sw == 2) {
            am.b(eVar.chf, i.c.cp_cont_b, 1);
            am.i((View) eVar.chf, i.e.btn_pb_bottom_comment_selector);
        }
        if (kVar2 != null) {
            a(eVar, kVar2, view, false, i);
        }
        if (!this.cgJ && this.cgK && eVar != null && eVar.che.Fp() && (listView = ((PbActivity) this.ciJ.getPageContext().getOrignalPage()).getListView()) != null) {
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
    private void a(e eVar, com.baidu.tieba.tbadkCore.data.k kVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (eVar != null && kVar != null) {
            if (!z) {
                eVar.cgY.setTag(null);
                eVar.cgY.setUserId(null);
                eVar.aHN.setText((CharSequence) null);
                eVar.chn.setVisibility(0);
                eVar.chd.setVisibility(0);
                eVar.chc.setVisibility(8);
                if (kVar.awA() == null) {
                    eVar.cho.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && kVar.awA().zT() == 1) {
                    eVar.cho.changeSkinType(this.mSkinType);
                    eVar.cho.setVisibility(0);
                    eVar.cho.setData(kVar.awA());
                } else {
                    eVar.cho.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) eVar.chk.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    eVar.chk.setTag(sparseArray2);
                    eVar.che.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, kVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(eVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgz) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eVar.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    eVar.che.setLayoutParams(layoutParams);
                    eVar.che.setPadding(0, 0, 0, 0);
                    eVar.che.fS(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, kVar.getBimg_url());
                    eVar.che.fS(kVar.getBimg_url());
                    if (kVar.awy() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) eVar.che.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        eVar.che.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) eVar.che.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        eVar.che.setLayoutParams(layoutParams3);
                    }
                }
                eVar.bpA.setText(ar.o(kVar.getTime()));
                if (kVar.awy() == 1) {
                    am.j(eVar.cgT, i.c.cp_bg_line_d);
                    eVar.cgU.setVisibility(8);
                    eVar.cgV.setVisibility(8);
                    eVar.cgW.setVisibility(8);
                    eVar.chk.setVisibility(8);
                    eVar.bpA.setVisibility(8);
                    if (this.cgB) {
                        PraiseData praise = this.cgC.aeO().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            eVar.chi.setVisibility(0);
                            eVar.chh.setVisibility(0);
                            eVar.chj.setVisibility(0);
                            eVar.chi.setIsFromPb(true);
                            eVar.chi.a(praise, this.cgC.aeO().getId(), praise.getPostId(), true);
                            eVar.chi.cP(this.mSkinType);
                        } else {
                            eVar.chi.setVisibility(8);
                            eVar.chh.setVisibility(8);
                            eVar.chj.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d awB = kVar.awB();
                        if (awB != null && !TextUtils.isEmpty(awB.getName()) && !TextUtils.isEmpty(awB.getName().trim())) {
                            String name = awB.getName();
                            String lat = awB.getLat();
                            String lng = awB.getLng();
                            eVar.chx.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, eVar.chx, 0, 10, 0, 10);
                            eVar.chz.setText(awB.getName());
                            am.b(eVar.chz, i.c.cp_cont_c, 1);
                            am.c(eVar.chy, i.e.icon_frs_site);
                            eVar.chx.setOnClickListener(new b(this, lat, lng, name));
                        } else {
                            eVar.chx.setVisibility(8);
                        }
                    } else {
                        eVar.chi.setVisibility(8);
                        eVar.chh.setVisibility(8);
                        eVar.chj.setVisibility(8);
                        eVar.chx.setVisibility(8);
                    }
                    a(eVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) eVar.cho.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                }
                if (this.cgD != null && !this.cgD.equals("0") && this.cgD.equals(kVar.getAuthor().getUserId())) {
                    eVar.chc.setVisibility(0);
                    am.c(eVar.chc, i.e.icon_floorhost);
                }
            }
            am.i(eVar.cgX, i.e.bg_floor_new_middle);
            eVar.che.setVideoImageId(i.e.pic_video);
            eVar.che.setTextColor(am.getColor(i.c.pb_listitem_content));
            am.c(eVar.chd, i.e.btn_pb_reply_selector);
            eVar.che.setLinkTextColor(am.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) eVar.chd.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                eVar.chd.setTag(sparseArray4);
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
                eVar.chn.setVisibility(0);
                eVar.chm.setVisibility(0);
                eVar.chl.setVisibility(0);
                eVar.chn.a(kVar, view);
                eVar.chn.setChildOnClickListener(this.aZl);
                eVar.chn.setChildOnLongClickListener(this.ajT);
                eVar.chn.setChildOnTouchListener(this.cgH);
                eVar.chn.setSubPbAdapter(this.cgE);
                eVar.chn.setVisibility(0);
            } else {
                eVar.chn.setVisibility(8);
                eVar.chm.setVisibility(8);
                eVar.chl.setVisibility(8);
            }
            a(eVar, kVar, this.cgC.aeV(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    eVar.aHN.setText(kVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        am.b(eVar.aHN, i.c.cp_cont_h, 1);
                    } else {
                        am.b(eVar.aHN, i.c.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        eVar.cgZ.setVisibility(0);
                        am.c(eVar.cgZ, com.baidu.tbadk.core.util.c.ch(level_id));
                        i2 = 2;
                        eVar.cgZ.setOnClickListener(null);
                    } else {
                        eVar.cgZ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            am.c(eVar.cgZ, i.e.pb_manager);
                        } else if (bawu_type.equals("assist")) {
                            am.c(eVar.cgZ, i.e.pb_assist);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        am.c(eVar.cha, i.e.icon_pop_girl_square);
                        eVar.cha.setVisibility(0);
                    } else {
                        eVar.cha.setVisibility(8);
                    }
                    this.cgF = kVar.getAuthor().getIconInfo();
                    this.aSF = kVar.getAuthor().getTShowInfo();
                    if (eVar.bcC != null) {
                        eVar.bcC.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                        eVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
                        eVar.bcC.a(this.cgF, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (eVar.aSX != null) {
                        eVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
                        eVar.aSX.a(this.aSF, 3, this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                    }
                }
                eVar.cgY.setUserId(kVar.getAuthor().getUserId());
                eVar.cgY.setUserName(kVar.getAuthor().getUserName());
                eVar.cgY.setImageDrawable(null);
                eVar.aHN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                eVar.aHN.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
                eVar.cgY.d(portrait, 28, false);
            }
            eVar.che.setLinkTextColor(am.getColor(i.c.cp_link_tip_c));
            if (this.cgz) {
                eVar.che.setDefaultImageId(i.e.img_default_100);
            } else {
                eVar.che.setDefaultImageId(i.e.icon_click);
            }
            eVar.che.setIsFromCDN(this.mIsFromCDN);
            if (this.cgz) {
                eVar.chg.setDefaultImageId(i.e.img_default_100);
            } else {
                eVar.chg.setDefaultImageId(i.e.icon_click);
            }
            eVar.chg.setIsFromCDN(this.mIsFromCDN);
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
                            EY.setWidth(eVar.chg.getMaxImageWidth());
                            EY.setHeight(eVar.chg.getMaxImageHeight());
                            EY.bt(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                eVar.chf.setVisibility(8);
                eVar.chg.setVisibility(8);
                if (arrayList.size() >= 1) {
                    eVar.chg.setVisibility(0);
                }
                int sw = this.cgC.aeO().sw();
                if (sw == 1 || sw == 2 || sw == 4) {
                    eVar.chf.setVisibility(0);
                    eVar.chf.setOnClickListener(this.aZl);
                    eVar.chf.setEnabled(true);
                }
                Integer num = cgI.get(new Point(this.cgC.aeO().sx(), sw));
                if (num != null) {
                    eVar.chf.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                eVar.chf.setVisibility(8);
                eVar.chg.setVisibility(8);
            }
            if (aVar == null) {
                aVar = kVar.awz();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.cgJ || !this.cgK) {
                eVar.che.a(aVar, false);
                eVar.chg.a(aVar3, false);
            } else {
                eVar.che.a(aVar, true);
                eVar.chg.a(aVar3, true);
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
                        if (eVar.chs != null) {
                            eVar.chs.setVisibility(0);
                            eVar.chs.setText(i.h.manage);
                            eVar.chs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (eVar.chs != null) {
                            eVar.chs.setVisibility(0);
                            eVar.chs.setText(i.h.delete);
                            eVar.chs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (eVar.chs != null) {
                        eVar.chs.setVisibility(8);
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
                        eVar.chd.setVisibility(8);
                        am.b(eVar.chq, i.c.subpb_listitem_time, 1);
                        eVar.chq.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), ar.o(kVar.getTime())));
                        if (eVar.chs.getVisibility() == 0) {
                            am.b(eVar.chs, i.c.cp_link_tip_c, 3);
                            eVar.chs.setTag(sparseArray);
                            eVar.chs.setOnClickListener(this.cgG);
                        }
                    }
                    a(eVar, kVar, kVar.awy() != 1, aVar);
                    a(eVar, kVar);
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
            a(eVar, kVar, kVar.awy() != 1, aVar);
            a(eVar, kVar);
        }
    }

    private void a(e eVar, com.baidu.tieba.tbadkCore.data.k kVar) {
        if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgz) {
            eVar.che.setOnClickListener(null);
        } else {
            eVar.che.setOnClickListener(this.aZl);
        }
        eVar.che.setTextViewCheckSelection(false);
        eVar.che.setTextViewOnClickListener(new c(this));
    }

    private void a(e eVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (kVar == null || kVar.ahO() == null) {
            eVar.chA.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(kVar.ahO(), eVar.chA, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(kVar.getBimg_url()));
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

    private void a(e eVar, com.baidu.tieba.tbadkCore.data.k kVar, AdditionData additionData, int i) {
        if (kVar.awD() > 0 && kVar.awx() != null) {
            eVar.chp.setVisibility(0);
            eVar.chp.removeViews(0, eVar.chp.getChildCount() - 1);
            int size = kVar.awx().size();
            int awE = kVar.awE();
            for (int i2 = 0; i2 < awE; i2++) {
                com.baidu.tieba.tbadkCore.data.k kVar2 = kVar.awx().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) eVar.chp, false);
                e eVar2 = new e(inflate, this.cgA, this.cgz, this.cgy, true);
                a(eVar2);
                a(eVar2, kVar2, (View) eVar.chp, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, kVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.cgz) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    eVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eVar2.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    eVar2.che.setLayoutParams(layoutParams);
                    eVar2.che.setPadding(0, 0, 0, 0);
                    eVar.che.fS(null);
                } else {
                    eVar.che.fS(kVar.getBimg_url());
                    eVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) eVar2.che.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    eVar2.che.setLayoutParams(layoutParams2);
                }
                eVar.chp.addView(inflate, eVar.chp.getChildCount() - 1);
            }
            if (awE < size) {
                eVar.cht.setVisibility(0);
                am.i(eVar.chv, i.c.cp_bg_line_b);
                am.i(eVar.chw, i.c.cp_bg_line_b);
                am.b(eVar.chu, i.c.cp_cont_f, 1);
                eVar.cht.setOnClickListener(new d(this, awE, size, kVar));
                return;
            }
            eVar.cht.setVisibility(8);
            return;
        }
        eVar.chp.setVisibility(8);
    }

    private void a(e eVar) {
        eVar.aHN.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        eVar.chd.setOnClickListener(this.aZl);
        eVar.cgY.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        eVar.chk.setOnLongClickListener(this.ajT);
        eVar.che.setOnLongClickListener(this.ajT);
        eVar.chk.setOnTouchListener(this.cgH);
        eVar.che.setOnTouchListener(this.cgH);
        eVar.che.setOnImageClickListener(this.aCc);
        eVar.chg.setOnImageClickListener(this.aCc);
        eVar.che.setOnEmotionClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clE);
        eVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
        eVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
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
