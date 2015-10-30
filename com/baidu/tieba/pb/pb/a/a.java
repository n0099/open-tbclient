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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
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
    private static HashMap<Point, Integer> cgT = new HashMap<>();
    private TbRichTextView.c aCn;
    private ArrayList<IconData> aSQ;
    private View.OnClickListener aZw;
    private View.OnLongClickListener ajU;
    private int cgJ;
    private boolean cgK;
    private boolean cgL;
    private boolean cgM;
    private com.baidu.tieba.pb.a.b cgN;
    private String cgO;
    private ai cgP;
    private ArrayList<IconData> cgQ;
    private View.OnClickListener cgR;
    private com.baidu.tieba.pb.b.c cgS;
    private boolean cgU;
    private final boolean cgV;
    private int cgW;
    private int cgX;

    static {
        cgT.put(new Point(1, 1), Integer.valueOf(i.h.i_want_lottery));
        cgT.put(new Point(1, 2), Integer.valueOf(i.h.look_result));
        cgT.put(new Point(1, 4), Integer.valueOf(i.h.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cgJ = 0;
        this.cgK = true;
        this.cgL = true;
        this.cgM = true;
        this.cgN = null;
        this.cgO = null;
        this.cgP = null;
        this.cgQ = null;
        this.aSQ = null;
        this.cgR = null;
        this.aZw = null;
        this.aCn = null;
        this.cgS = null;
        this.ajU = null;
        this.cgU = false;
        this.cgV = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cgW = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.cgX = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item_lottery, viewGroup, false), this.cgL, this.cgK, this.cgJ, false);
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
        an.j(eVar.chf, i.c.cp_bg_line_b);
        an.j(eVar.chg, i.c.cp_bg_line_b);
        an.b(eVar.chB, i.c.subpb_listitem_time, 1);
        an.b(eVar.chD, i.c.cp_link_tip_c, 3);
        an.b(eVar.aHY, i.c.cp_cont_f, 1);
        an.b((View) eVar.chk, i.c.cp_cont_i, 1);
        an.b(eVar.chm, i.c.cp_cont_d, 1);
        an.b(eVar.bpL, i.c.cp_cont_d, 1);
        an.c(eVar.cho, i.e.btn_pb_reply_selector);
        an.j(eVar.chs, i.c.cp_bg_line_b);
        an.j(eVar.cht, i.c.cp_bg_line_e);
        an.j(eVar.chu, i.c.cp_bg_line_e);
        an.c(eVar.chu, i.c.cp_bg_line_b);
        an.c(eVar.chx, i.c.cp_bg_line_b);
        int st = this.cgN.aeK().st();
        if (st == 1 || st == 4) {
            an.b(eVar.chq, i.c.cp_cont_i, 1);
            an.i((View) eVar.chq, i.e.buy_yinji_btn_bg);
        } else if (st == 2) {
            an.b(eVar.chq, i.c.cp_cont_b, 1);
            an.i((View) eVar.chq, i.e.btn_pb_bottom_comment_selector);
        }
        if (kVar2 != null) {
            a(eVar, kVar2, view, false, i);
        }
        if (!this.cgU && this.cgV && eVar != null && eVar.chp.Fl() && (listView = ((PbActivity) this.ciU.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cgU = true;
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
                eVar.chj.setTag(null);
                eVar.chj.setUserId(null);
                eVar.aHY.setText((CharSequence) null);
                eVar.chy.setVisibility(0);
                eVar.cho.setVisibility(0);
                eVar.chn.setVisibility(8);
                if (kVar.awG() == null) {
                    eVar.chz.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && kVar.awG().zQ() == 1) {
                    eVar.chz.changeSkinType(this.mSkinType);
                    eVar.chz.setVisibility(0);
                    eVar.chz.setData(kVar.awG());
                } else {
                    eVar.chz.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) eVar.chv.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    eVar.chv.setTag(sparseArray2);
                    eVar.chp.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, kVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(eVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgK) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eVar.chp.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    eVar.chp.setLayoutParams(layoutParams);
                    eVar.chp.setPadding(0, 0, 0, 0);
                    eVar.chp.fS(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, kVar.getBimg_url());
                    eVar.chp.fS(kVar.getBimg_url());
                    if (kVar.awE() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) eVar.chp.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        eVar.chp.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) eVar.chp.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        eVar.chp.setLayoutParams(layoutParams3);
                    }
                }
                eVar.bpL.setText(as.m(kVar.getTime()));
                if (kVar.awE() == 1) {
                    an.j(eVar.che, i.c.cp_bg_line_d);
                    eVar.chf.setVisibility(8);
                    eVar.chg.setVisibility(8);
                    eVar.chh.setVisibility(8);
                    eVar.chv.setVisibility(8);
                    eVar.bpL.setVisibility(8);
                    if (this.cgM) {
                        PraiseData praise = this.cgN.aeK().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            eVar.cht.setVisibility(0);
                            eVar.chs.setVisibility(0);
                            eVar.chu.setVisibility(0);
                            eVar.cht.setIsFromPb(true);
                            eVar.cht.a(praise, this.cgN.aeK().getId(), praise.getPostId(), true);
                            eVar.cht.cP(this.mSkinType);
                        } else {
                            eVar.cht.setVisibility(8);
                            eVar.chs.setVisibility(8);
                            eVar.chu.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d awH = kVar.awH();
                        if (awH != null && !TextUtils.isEmpty(awH.getName()) && !TextUtils.isEmpty(awH.getName().trim())) {
                            String name = awH.getName();
                            String lat = awH.getLat();
                            String lng = awH.getLng();
                            eVar.chI.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, eVar.chI, 0, 10, 0, 10);
                            eVar.chK.setText(awH.getName());
                            an.b(eVar.chK, i.c.cp_cont_c, 1);
                            an.c(eVar.chJ, i.e.icon_frs_site);
                            eVar.chI.setOnClickListener(new b(this, lat, lng, name));
                        } else {
                            eVar.chI.setVisibility(8);
                        }
                    } else {
                        eVar.cht.setVisibility(8);
                        eVar.chs.setVisibility(8);
                        eVar.chu.setVisibility(8);
                        eVar.chI.setVisibility(8);
                    }
                    a(eVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) eVar.chz.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                }
                if (this.cgO != null && !this.cgO.equals("0") && this.cgO.equals(kVar.getAuthor().getUserId())) {
                    eVar.chn.setVisibility(0);
                    an.c(eVar.chn, i.e.icon_floorhost);
                }
            }
            an.i(eVar.chi, i.e.bg_floor_new_middle);
            eVar.chp.setVideoImageId(i.e.pic_video);
            eVar.chp.setTextColor(an.getColor(i.c.pb_listitem_content));
            an.c(eVar.cho, i.e.btn_pb_reply_selector);
            eVar.chp.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) eVar.cho.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                eVar.cho.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_load_sub_data, kVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (kVar.awI() > 0) {
                if (this.cgP == null) {
                    this.cgP = new ai(this.mContext);
                    this.cgP.setIsFromCDN(this.mIsFromCDN);
                    this.cgP.D(this.cgR);
                    boolean z7 = false;
                    String userId2 = this.cgN.aeK().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cgP.p(this.cgN.aeO(), z7);
                    this.cgP.e(this.cgN.aeK());
                    this.cgP.eq(this.cgL);
                }
                eVar.chy.setVisibility(0);
                eVar.chx.setVisibility(0);
                eVar.chw.setVisibility(0);
                eVar.chy.a(kVar, view);
                eVar.chy.setChildOnClickListener(this.aZw);
                eVar.chy.setChildOnLongClickListener(this.ajU);
                eVar.chy.setChildOnTouchListener(this.cgS);
                eVar.chy.setSubPbAdapter(this.cgP);
                eVar.chy.setVisibility(0);
            } else {
                eVar.chy.setVisibility(8);
                eVar.chx.setVisibility(8);
                eVar.chw.setVisibility(8);
            }
            a(eVar, kVar, this.cgN.aeR(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    eVar.aHY.setText(kVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        an.b(eVar.aHY, i.c.cp_cont_h, 1);
                    } else {
                        an.b(eVar.aHY, i.c.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        eVar.chk.setVisibility(0);
                        an.c(eVar.chk, com.baidu.tbadk.core.util.c.ch(level_id));
                        i2 = 2;
                        eVar.chk.setOnClickListener(null);
                    } else {
                        eVar.chk.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            an.c(eVar.chk, i.e.pb_manager);
                        } else if (bawu_type.equals("assist")) {
                            an.c(eVar.chk, i.e.pb_assist);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        an.c(eVar.chl, i.e.icon_pop_girl_square);
                        eVar.chl.setVisibility(0);
                    } else {
                        eVar.chl.setVisibility(8);
                    }
                    this.cgQ = kVar.getAuthor().getIconInfo();
                    this.aSQ = kVar.getAuthor().getTShowInfo();
                    if (eVar.bcN != null) {
                        eVar.bcN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                        eVar.bcN.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.aXo);
                        eVar.bcN.a(this.cgQ, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (eVar.aTi != null) {
                        eVar.aTi.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clO);
                        eVar.aTi.a(this.aSQ, 3, this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                    }
                }
                eVar.chj.setUserId(kVar.getAuthor().getUserId());
                eVar.chj.setUserName(kVar.getAuthor().getUserName());
                eVar.chj.setImageDrawable(null);
                eVar.aHY.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                eVar.aHY.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
                eVar.chj.d(portrait, 28, false);
            }
            eVar.chp.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            if (this.cgK) {
                eVar.chp.setDefaultImageId(i.e.img_default_100);
            } else {
                eVar.chp.setDefaultImageId(i.e.icon_click);
            }
            eVar.chp.setIsFromCDN(this.mIsFromCDN);
            if (this.cgK) {
                eVar.chr.setDefaultImageId(i.e.img_default_100);
            } else {
                eVar.chr.setDefaultImageId(i.e.icon_click);
            }
            eVar.chr.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (kVar.awE() == 1 && this.cgN.aeK().sv()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a awF = kVar.awF();
                if (awF != null && awF.EP() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> EP = awF.EP();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= EP.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = EP.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.f EU = cVar.EU();
                            EU.setWidth(eVar.chr.getMaxImageWidth());
                            EU.setHeight(eVar.chr.getMaxImageHeight());
                            EU.bt(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                eVar.chq.setVisibility(8);
                eVar.chr.setVisibility(8);
                if (arrayList.size() >= 1) {
                    eVar.chr.setVisibility(0);
                }
                int st = this.cgN.aeK().st();
                if (st == 1 || st == 2 || st == 4) {
                    eVar.chq.setVisibility(0);
                    eVar.chq.setOnClickListener(this.aZw);
                    eVar.chq.setEnabled(true);
                }
                Integer num = cgT.get(new Point(this.cgN.aeK().su(), st));
                if (num != null) {
                    eVar.chq.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                eVar.chq.setVisibility(8);
                eVar.chr.setVisibility(8);
            }
            if (aVar == null) {
                aVar = kVar.awF();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.cgU || !this.cgV) {
                eVar.chp.a(aVar, false);
                eVar.chr.a(aVar3, false);
            } else {
                eVar.chp.a(aVar, true);
                eVar.chr.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cgN.aeO() != 0) {
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
            if (this.cgN != null && this.cgN.aeK() != null && this.cgN.aeK().getAuthor() != null && kVar.getAuthor() != null) {
                String userId4 = this.cgN.aeK().getAuthor().getUserId();
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
                        if (eVar.chD != null) {
                            eVar.chD.setVisibility(0);
                            eVar.chD.setText(i.h.manage);
                            eVar.chD.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (eVar.chD != null) {
                            eVar.chD.setVisibility(0);
                            eVar.chD.setText(i.h.delete);
                            eVar.chD.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (eVar.chD != null) {
                        eVar.chD.setVisibility(8);
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (kVar.awE() == 1) {
                        i5 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                    if (!z8) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgN.aeO()));
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
                        if (this.cgN.aeK() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cgN.aeK().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgN.aeO()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        eVar.cho.setVisibility(8);
                        an.b(eVar.chB, i.c.subpb_listitem_time, 1);
                        eVar.chB.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), as.m(kVar.getTime())));
                        if (eVar.chD.getVisibility() == 0) {
                            an.b(eVar.chD, i.c.cp_link_tip_c, 3);
                            eVar.chD.setTag(sparseArray);
                            eVar.chD.setOnClickListener(this.cgR);
                        }
                    }
                    a(eVar, kVar, kVar.awE() != 1, aVar);
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
            if (kVar.awE() == 1) {
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
            a(eVar, kVar, kVar.awE() != 1, aVar);
            a(eVar, kVar);
        }
    }

    private void a(e eVar, com.baidu.tieba.tbadkCore.data.k kVar) {
        if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgK) {
            eVar.chp.setOnClickListener(null);
        } else {
            eVar.chp.setOnClickListener(this.aZw);
        }
        eVar.chp.setTextViewCheckSelection(false);
        eVar.chp.setTextViewOnClickListener(new c(this));
    }

    private void a(e eVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (kVar == null || kVar.ahK() == null) {
            eVar.chL.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(kVar.ahK(), eVar.chL, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(kVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cgX - (i - this.cgW));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(e eVar, com.baidu.tieba.tbadkCore.data.k kVar, AdditionData additionData, int i) {
        if (kVar.awJ() > 0 && kVar.awD() != null) {
            eVar.chA.setVisibility(0);
            eVar.chA.removeViews(0, eVar.chA.getChildCount() - 1);
            int size = kVar.awD().size();
            int awK = kVar.awK();
            for (int i2 = 0; i2 < awK; i2++) {
                com.baidu.tieba.tbadkCore.data.k kVar2 = kVar.awD().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) eVar.chA, false);
                e eVar2 = new e(inflate, this.cgL, this.cgK, this.cgJ, true);
                a(eVar2);
                a(eVar2, kVar2, (View) eVar.chA, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, kVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.cgK) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    eVar2.chp.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eVar2.chp.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    eVar2.chp.setLayoutParams(layoutParams);
                    eVar2.chp.setPadding(0, 0, 0, 0);
                    eVar.chp.fS(null);
                } else {
                    eVar.chp.fS(kVar.getBimg_url());
                    eVar2.chp.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) eVar2.chp.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    eVar2.chp.setLayoutParams(layoutParams2);
                }
                eVar.chA.addView(inflate, eVar.chA.getChildCount() - 1);
            }
            if (awK < size) {
                eVar.chE.setVisibility(0);
                an.i(eVar.chG, i.c.cp_bg_line_b);
                an.i(eVar.chH, i.c.cp_bg_line_b);
                an.b(eVar.chF, i.c.cp_cont_f, 1);
                eVar.chE.setOnClickListener(new d(this, awK, size, kVar));
                return;
            }
            eVar.chE.setVisibility(8);
            return;
        }
        eVar.chA.setVisibility(8);
    }

    private void a(e eVar) {
        eVar.aHY.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clN);
        eVar.cho.setOnClickListener(this.aZw);
        eVar.chj.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clN);
        eVar.chv.setOnLongClickListener(this.ajU);
        eVar.chp.setOnLongClickListener(this.ajU);
        eVar.chv.setOnTouchListener(this.cgS);
        eVar.chp.setOnTouchListener(this.cgS);
        eVar.chp.setOnImageClickListener(this.aCn);
        eVar.chr.setOnImageClickListener(this.aCn);
        eVar.chp.setOnEmotionClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clP);
        eVar.bcN.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.aXo);
        eVar.aTi.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.b bVar) {
        this.cgN = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.cgJ = i;
    }

    public void ep(boolean z) {
        this.cgK = z;
    }

    public void eq(boolean z) {
        this.cgL = z;
    }

    public void er(boolean z) {
        this.cgM = z;
    }

    public void jH(String str) {
        this.cgO = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cgR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCn = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajU = onLongClickListener;
    }
}
