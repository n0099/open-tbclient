package com.baidu.tieba.pb.pb.main;

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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public class ci extends cl<com.baidu.tieba.tbadkCore.data.r, ck> implements View.OnClickListener {
    private TbRichTextView.d aGi;
    private final TbRichTextView.e aGj;
    private View.OnLongClickListener anJ;
    private ArrayList<IconData> beA;
    private View.OnClickListener bmy;
    private int cJW;
    private boolean cJX;
    private boolean cJY;
    private com.baidu.tieba.pb.a.c cJZ;
    private boolean cKa;
    private com.baidu.tieba.pb.b.c cKb;
    private int cKc;
    private int cKd;
    private boolean cKe;
    private final boolean cKf;
    private String cLq;
    private com.baidu.tieba.pb.pb.sub.am cLr;
    private ArrayList<IconData> cLs;
    private View.OnClickListener cLt;
    private HashSet<Long> cOg;
    private long cOh;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cOg = new HashSet<>();
        this.cJW = 0;
        this.cJX = true;
        this.cJY = true;
        this.cKa = true;
        this.cJZ = null;
        this.cLq = null;
        this.cLr = null;
        this.cLs = null;
        this.beA = null;
        this.cLt = null;
        this.bmy = null;
        this.cKb = null;
        this.anJ = null;
        this.aGi = null;
        this.cKe = false;
        this.cKf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.cOh = 0L;
        this.aGj = new cj(this);
        init();
    }

    private void init() {
        this.cKc = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.cKd = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public ck b(ViewGroup viewGroup) {
        return new ck(LayoutInflater.from(this.mContext).inflate(t.h.pb_chudian_item, viewGroup, false), this.cJY, this.cJX, this.cJW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, ck ckVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) ckVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(ckVar);
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) aG(i);
        com.baidu.tbadk.core.util.ar.l(ckVar.cLz, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.l(ckVar.cLA, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.b(ckVar.aMu, t.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ar.b((View) ckVar.cLE, t.d.cp_cont_i, 1);
        com.baidu.tbadk.core.util.ar.b(ckVar.cLH, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ar.b(ckVar.cLI, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ar.c(ckVar.cLK, t.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.ar.c(ckVar.cOj, t.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.ar.c(ckVar.cLN, t.d.cp_bg_line_b);
        if (rVar2 != null) {
            a(ckVar, rVar2, view, false, i);
        }
        if (!this.cKe && this.cKf && ckVar != null && ckVar.cKi.HB() && (listView = ((PbActivity) this.cNL.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cKe = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0819  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0825  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x083d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ck ckVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        if (ckVar != null && rVar != null) {
            com.baidu.tieba.tbadkCore.data.h aMF = rVar.aMF();
            if (aMF != null && this.cOg.add(Long.valueOf(aMF.getTemplateId()))) {
                this.cOh = aMF.getTemplateId();
                if (this.cOh != 0) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "PB", "locate", "c0114", "action_type", "VIEW_TRUE", "task", "tpoint", "obj_id", String.valueOf(this.cOh), "obj_name", String.valueOf(this.cOh), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.cJZ.aoE().getId(), ImageViewerConfig.FORUM_NAME, this.cJZ.aoE().getName(), "tid", this.cJZ.aoF().getTid(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
                }
            }
            ckVar.cKi.setOnLinkImageClickListener(this.aGj);
            ckVar.cLD.setTag(null);
            ckVar.cLD.setUserId(null);
            ckVar.aMu.setText((CharSequence) null);
            ckVar.cLO.setVisibility(0);
            ckVar.cLK.setVisibility(0);
            ckVar.cLJ.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) ckVar.cLL.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                ckVar.cLL.setTag(sparseArray2);
                ckVar.cKi.setTag(sparseArray2);
            }
            sparseArray2.put(t.g.tag_clip_board, rVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            a(ckVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cJX) {
                sparseArray2.put(t.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ckVar.cKi.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                ckVar.cKi.setLayoutParams(layoutParams);
                ckVar.cKi.setPadding(0, 0, 0, 0);
                ckVar.cKi.gi(null);
            } else {
                sparseArray2.put(t.g.tag_richtext_bg, rVar.getBimg_url());
                ckVar.cKi.gi(rVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ckVar.cKi.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                ckVar.cKi.setLayoutParams(layoutParams2);
            }
            ckVar.cLI.setText(com.baidu.tbadk.core.util.aw.t(rVar.getTime()));
            com.baidu.tbadk.core.util.ar.l(ckVar.cLy, t.d.cp_bg_line_e);
            if (i == 1) {
                if (this.cKa) {
                    ckVar.cLz.setVisibility(8);
                    ckVar.cLA.setVisibility(8);
                    PraiseData praise = this.cJZ.aoF().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        ckVar.cLA.setVisibility(8);
                        ckVar.cLz.setVisibility(0);
                    } else {
                        ckVar.cLA.setVisibility(0);
                        ckVar.cLz.setVisibility(8);
                    }
                } else {
                    ckVar.cLz.setVisibility(0);
                    ckVar.cLA.setVisibility(8);
                }
            } else {
                ckVar.cLz.setVisibility(0);
                ckVar.cLA.setVisibility(8);
            }
            ckVar.cLB.setVisibility(0);
            ckVar.cLL.setVisibility(0);
            ckVar.cLI.setVisibility(0);
            String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(rVar.aMw()));
            ckVar.cLH.setVisibility(0);
            ckVar.cLH.setText(format);
            if (!this.cJY) {
                a(ckVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds74));
            } else {
                a(ckVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ckVar.cLM.getLayoutParams();
            if (!this.cJY) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(t.e.ds30);
            }
            if (this.cLq != null && !this.cLq.equals("0") && this.cLq.equals(rVar.getAuthor().getUserId())) {
                ckVar.cLJ.setVisibility(0);
                com.baidu.tbadk.core.util.ar.c(ckVar.cLJ, t.f.icon_floorhost);
            }
            com.baidu.tbadk.core.util.ar.k(ckVar.cLC, t.f.bg_floor_new_middle);
            ckVar.cKi.setVideoImageId(t.f.pic_video);
            ckVar.cKi.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.ar.c(ckVar.cLK, t.f.btn_pb_more_selector);
            com.baidu.tbadk.core.util.ar.c(ckVar.cOj, t.f.btn_pb_reply_btn_selector);
            ckVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) ckVar.cLK.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                ckVar.cLK.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, rVar);
            sparseArray.put(t.g.tag_load_sub_data, rVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            SparseArray sparseArray5 = (SparseArray) ckVar.cOj.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                ckVar.cOj.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, rVar);
            sparseArray5.put(t.g.tag_load_sub_data, rVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            if (rVar.aMz() > 0) {
                if (this.cLr == null) {
                    this.cLr = new com.baidu.tieba.pb.pb.sub.am(this.mContext);
                    this.cLr.setIsFromCDN(this.mIsFromCDN);
                    this.cLr.J(this.cLt);
                    boolean z5 = false;
                    String userId2 = this.cJZ.aoF().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                    }
                    this.cLr.t(this.cJZ.aoJ(), z5);
                    this.cLr.h(this.cJZ.aoF());
                    this.cLr.fh(this.cJY);
                }
                ckVar.cLO.setVisibility(0);
                ckVar.cLN.setVisibility(0);
                ckVar.cLM.setVisibility(0);
                ckVar.cLO.a(rVar, view);
                ckVar.cLO.setChildOnClickListener(this.bmy);
                ckVar.cLO.setChildOnLongClickListener(this.anJ);
                ckVar.cLO.setChildOnTouchListener(this.cKb);
                ckVar.cLO.setSubPbAdapter(this.cLr);
                ckVar.cLO.setVisibility(0);
            } else {
                ckVar.cLO.setVisibility(8);
                ckVar.cLN.setVisibility(8);
                ckVar.cLM.setVisibility(8);
            }
            String portrait = rVar.getAuthor().getPortrait();
            if (rVar.getAuthor() != null) {
                ckVar.aMu.setText(rVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.ar.b(ckVar.aMu, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ar.b(ckVar.aMu, t.d.cp_cont_f, 1);
                }
                int level_id = rVar.getAuthor().getLevel_id();
                int is_bawu = rVar.getAuthor().getIs_bawu();
                String bawu_type = rVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    ckVar.cLE.setVisibility(0);
                    com.baidu.tbadk.core.util.ar.c(ckVar.cLE, BitmapHelper.getGradeResourceIdNew(level_id));
                    i2 = 2;
                    ckVar.cLE.setOnClickListener(null);
                } else {
                    ckVar.cLE.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ar.c(ckVar.cLE, t.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ar.c(ckVar.cLE, t.f.pb_assist);
                    }
                }
                if (rVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ar.c(ckVar.cLG, t.f.icon_pop_girl_square);
                    ckVar.cLG.setVisibility(0);
                } else {
                    ckVar.cLG.setVisibility(8);
                }
                this.cLs = rVar.getAuthor().getIconInfo();
                this.beA = rVar.getAuthor().getTShowInfo();
                if (ckVar.bqH != null) {
                    ckVar.bqH.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                    ckVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
                    ckVar.bqH.a(this.cLs, i2, this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (ckVar.ahI != null) {
                    ckVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
                    ckVar.ahI.a(this.beA, 3, this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
                }
            }
            ckVar.cLD.setUserId(rVar.getAuthor().getUserId());
            ckVar.cLD.setUserName(rVar.getAuthor().getUserName());
            ckVar.cLD.setImageDrawable(null);
            ckVar.aMu.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
            ckVar.aMu.setTag(t.g.tag_user_name, rVar.getAuthor().getUserName());
            ckVar.cLD.d(portrait, 28, false);
            ckVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            if (this.cJX) {
                ckVar.cKi.setDefaultImageId(t.f.img_default_100);
            } else {
                ckVar.cKi.setDefaultImageId(t.f.icon_click);
            }
            ckVar.cKi.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aiT();
            }
            if (this.cKe || !this.cKf) {
                ckVar.cKi.a(aVar, false);
            } else {
                ckVar.cKi.a(aVar, true);
            }
            boolean z6 = false;
            boolean z7 = false;
            if (this.cJZ.aoJ() != 0) {
                z6 = true;
                z7 = true;
                String userId3 = rVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z6 = false;
                }
            }
            if (this.cJZ != null && this.cJZ.aoF() != null && this.cJZ.aoF().getAuthor() != null && rVar.getAuthor() != null) {
                String userId4 = this.cJZ.aoF().getAuthor().getUserId();
                String userId5 = rVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = rVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z4 = true;
                    }
                    int i3 = 1;
                    if (rVar.aMw() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
                    if (!z6) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cJZ.aoJ()));
                        sparseArray.put(t.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                        }
                        if (this.cJZ.aoF() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.cJZ.aoF().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, rVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cJZ.aoJ()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, rVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    a(ckVar, rVar, rVar.aMw() != 1, aVar);
                    a(ckVar);
                    if (!this.cJY) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) ckVar.cOk.getLayoutParams();
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(t.e.ds74);
                        ckVar.cOk.setLayoutParams(layoutParams4);
                    }
                    ckVar.cOk.setVisibility(0);
                    ckVar.cOo.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_tuiguang));
                    if (aMF == null && !TextUtils.isEmpty(aMF.getPosition())) {
                        String position = aMF.getPosition();
                        ckVar.cOl.setVisibility(0);
                        ckVar.cOn.setText(position);
                        return;
                    }
                }
            }
            z2 = false;
            z3 = z7;
            z4 = false;
            userId = rVar.getAuthor().getUserId();
            if (userId != null) {
                z3 = true;
                z4 = true;
            }
            int i32 = 1;
            if (rVar.aMw() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
            if (!z6) {
            }
            if (!z2) {
            }
            if (!z3) {
            }
            a(ckVar, rVar, rVar.aMw() != 1, aVar);
            a(ckVar);
            if (!this.cJY) {
            }
            ckVar.cOk.setVisibility(0);
            ckVar.cOo.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_tuiguang));
            if (aMF == null) {
            }
        }
    }

    private void a(ck ckVar) {
        ckVar.cKi.setTextViewOnTouchListener(this.cKb);
        ckVar.cKi.setTextViewCheckSelection(false);
    }

    private void a(ck ckVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar == null || rVar.asK() == null) {
            ckVar.cMe.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar.asK(), ckVar.cMe, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cKd - (i - this.cKc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(ck ckVar) {
        ckVar.aMu.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        ckVar.cLK.setOnClickListener(this.bmy);
        ckVar.cOj.setOnClickListener(this.bmy);
        ckVar.cLD.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        ckVar.cLL.setOnLongClickListener(this.anJ);
        ckVar.cKi.setOnLongClickListener(this.anJ);
        ckVar.cLL.setOnTouchListener(this.cKb);
        ckVar.cKi.setOnTouchListener(this.cKb);
        ckVar.cKi.setOnImageClickListener(this.aGi);
        ckVar.cKi.setOnEmotionClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSG);
        ckVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
        ckVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
        ckVar.cMe.setOnClickListener(this.bmy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cJZ = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cJW = i;
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void fh(boolean z) {
        this.cJY = z;
    }

    public void fi(boolean z) {
        this.cKa = z;
    }

    public void kz(String str) {
        this.cLq = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.cLt = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
    }
}
