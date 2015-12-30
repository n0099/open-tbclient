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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public class cb extends ce<com.baidu.tieba.tbadkCore.data.r, cd> implements View.OnClickListener {
    private TbRichTextView.d aFq;
    private final TbRichTextView.e aFr;
    private View.OnLongClickListener amQ;
    private ArrayList<IconData> bcl;
    private View.OnClickListener bjD;
    private boolean cDQ;
    private com.baidu.tieba.pb.a.c cDR;
    private String cDX;
    private com.baidu.tieba.pb.pb.sub.am cDY;
    private ArrayList<IconData> cDZ;
    private int cDq;
    private boolean cDr;
    private boolean cDs;
    private com.baidu.tieba.pb.b.c cDu;
    private boolean cDw;
    private final boolean cDx;
    private int cDy;
    private int cDz;
    private View.OnClickListener cEa;
    private HashSet<Long> cGC;
    private long cGD;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cGC = new HashSet<>();
        this.cDq = 0;
        this.cDr = true;
        this.cDQ = true;
        this.cDs = true;
        this.cDR = null;
        this.cDX = null;
        this.cDY = null;
        this.cDZ = null;
        this.bcl = null;
        this.cEa = null;
        this.bjD = null;
        this.cDu = null;
        this.amQ = null;
        this.aFq = null;
        this.cDw = false;
        this.cDx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.cGD = 0L;
        this.aFr = new cc(this);
        init();
    }

    private void init() {
        this.cDy = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds30);
        this.cDz = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public cd a(ViewGroup viewGroup) {
        return new cd(LayoutInflater.from(this.mContext).inflate(n.h.pb_chudian_item, viewGroup, false), this.cDQ, this.cDr, this.cDq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, cd cdVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) cdVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(cdVar);
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) au(i);
        com.baidu.tbadk.core.util.as.j(cdVar.cEj, n.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(cdVar.cEk, n.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.b(cdVar.aLp, n.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.as.b((View) cdVar.cEo, n.d.cp_cont_i, 1);
        com.baidu.tbadk.core.util.as.b(cdVar.cEr, n.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.b(cdVar.bIB, n.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.c(cdVar.cEt, n.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.as.c(cdVar.cGF, n.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.as.c(cdVar.cEw, n.d.cp_bg_line_b);
        if (rVar2 != null) {
            a(cdVar, rVar2, view, false, i);
        }
        if (!this.cDw && this.cDx && cdVar != null && cdVar.cDC.Gc() && (listView = ((PbActivity) this.cGj.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cDw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0810  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0834  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(cd cdVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        if (cdVar != null && rVar != null) {
            com.baidu.tieba.tbadkCore.data.h aFA = rVar.aFA();
            if (aFA != null && this.cGC.add(Long.valueOf(aFA.getTemplateId()))) {
                this.cGD = aFA.getTemplateId();
                if (this.cGD != 0) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "PB", "locate", "c0114", "action_type", "VIEW_TRUE", "task", "tpoint", "obj_id", String.valueOf(this.cGD), "obj_name", String.valueOf(this.cGD), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.cDR.akG().getId(), ImageViewerConfig.FORUM_NAME, this.cDR.akG().getName(), "tid", this.cDR.akH().getTid(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
                }
            }
            cdVar.cDC.setOnLinkImageClickListener(this.aFr);
            cdVar.cEn.setTag(null);
            cdVar.cEn.setUserId(null);
            cdVar.aLp.setText((CharSequence) null);
            cdVar.cEx.setVisibility(0);
            cdVar.cEt.setVisibility(0);
            cdVar.cEs.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) cdVar.cEu.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                cdVar.cEu.setTag(sparseArray2);
                cdVar.cDC.setTag(sparseArray2);
            }
            sparseArray2.put(n.g.tag_clip_board, rVar);
            sparseArray2.put(n.g.tag_is_subpb, false);
            a(cdVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds30));
            if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cDr) {
                sparseArray2.put(n.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cdVar.cDC.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                cdVar.cDC.setLayoutParams(layoutParams);
                cdVar.cDC.setPadding(0, 0, 0, 0);
                cdVar.cDC.gl(null);
            } else {
                sparseArray2.put(n.g.tag_richtext_bg, rVar.getBimg_url());
                cdVar.cDC.gl(rVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cdVar.cDC.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(n.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(n.e.ds20);
                cdVar.cDC.setLayoutParams(layoutParams2);
            }
            cdVar.bIB.setText(com.baidu.tbadk.core.util.ax.s(rVar.getTime()));
            com.baidu.tbadk.core.util.as.j(cdVar.cEi, n.d.cp_bg_line_e);
            if (i == 1) {
                if (this.cDs) {
                    cdVar.cEj.setVisibility(8);
                    cdVar.cEk.setVisibility(8);
                    PraiseData praise = this.cDR.akH().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        cdVar.cEk.setVisibility(8);
                        cdVar.cEj.setVisibility(0);
                    } else {
                        cdVar.cEk.setVisibility(0);
                        cdVar.cEj.setVisibility(8);
                    }
                } else {
                    cdVar.cEj.setVisibility(0);
                    cdVar.cEk.setVisibility(8);
                }
            } else {
                cdVar.cEj.setVisibility(0);
                cdVar.cEk.setVisibility(8);
            }
            cdVar.cEl.setVisibility(0);
            cdVar.cEu.setVisibility(0);
            cdVar.bIB.setVisibility(0);
            String format = String.format(this.mContext.getString(n.j.is_floor), Integer.valueOf(rVar.aFq()));
            cdVar.cEr.setVisibility(0);
            cdVar.cEr.setText(format);
            if (!this.cDQ) {
                a(cdVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds74));
            } else {
                a(cdVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) cdVar.cEv.getLayoutParams();
            if (!this.cDQ) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(n.e.ds30);
            }
            if (this.cDX != null && !this.cDX.equals("0") && this.cDX.equals(rVar.getAuthor().getUserId())) {
                cdVar.cEs.setVisibility(0);
                com.baidu.tbadk.core.util.as.c(cdVar.cEs, n.f.icon_floorhost);
            }
            com.baidu.tbadk.core.util.as.i(cdVar.cEm, n.f.bg_floor_new_middle);
            cdVar.cDC.setVideoImageId(n.f.pic_video);
            cdVar.cDC.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.pb_listitem_content));
            com.baidu.tbadk.core.util.as.c(cdVar.cEt, n.f.btn_pb_more_selector);
            com.baidu.tbadk.core.util.as.c(cdVar.cGF, n.f.btn_pb_reply_btn_selector);
            cdVar.cDC.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) cdVar.cEt.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                cdVar.cEt.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(n.g.tag_clip_board, rVar);
            sparseArray.put(n.g.tag_load_sub_data, rVar);
            sparseArray.put(n.g.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) cdVar.cGF.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                cdVar.cGF.setTag(sparseArray5);
            }
            sparseArray5.put(n.g.tag_clip_board, rVar);
            sparseArray5.put(n.g.tag_load_sub_data, rVar);
            sparseArray5.put(n.g.tag_load_sub_view, view);
            if (rVar.aFu() > 0) {
                if (this.cDY == null) {
                    this.cDY = new com.baidu.tieba.pb.pb.sub.am(this.mContext);
                    this.cDY.setIsFromCDN(this.mIsFromCDN);
                    this.cDY.D(this.cEa);
                    boolean z5 = false;
                    String userId2 = this.cDR.akH().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                    }
                    this.cDY.r(this.cDR.akL(), z5);
                    this.cDY.g(this.cDR.akH());
                    this.cDY.eU(this.cDQ);
                }
                cdVar.cEx.setVisibility(0);
                cdVar.cEw.setVisibility(0);
                cdVar.cEv.setVisibility(0);
                cdVar.cEx.a(rVar, view);
                cdVar.cEx.setChildOnClickListener(this.bjD);
                cdVar.cEx.setChildOnLongClickListener(this.amQ);
                cdVar.cEx.setChildOnTouchListener(this.cDu);
                cdVar.cEx.setSubPbAdapter(this.cDY);
                cdVar.cEx.setVisibility(0);
            } else {
                cdVar.cEx.setVisibility(8);
                cdVar.cEw.setVisibility(8);
                cdVar.cEv.setVisibility(8);
            }
            String portrait = rVar.getAuthor().getPortrait();
            if (rVar.getAuthor() != null) {
                cdVar.aLp.setText(rVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.as.b(cdVar.aLp, n.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(cdVar.aLp, n.d.cp_cont_f, 1);
                }
                int level_id = rVar.getAuthor().getLevel_id();
                int is_bawu = rVar.getAuthor().getIs_bawu();
                String bawu_type = rVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    cdVar.cEo.setVisibility(0);
                    com.baidu.tbadk.core.util.as.c(cdVar.cEo, com.baidu.tbadk.core.util.c.ci(level_id));
                    i2 = 2;
                    cdVar.cEo.setOnClickListener(null);
                } else {
                    cdVar.cEo.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.as.c(cdVar.cEo, n.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.as.c(cdVar.cEo, n.f.pb_assist);
                    }
                }
                if (rVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.as.c(cdVar.cEq, n.f.icon_pop_girl_square);
                    cdVar.cEq.setVisibility(0);
                } else {
                    cdVar.cEq.setVisibility(8);
                }
                this.cDZ = rVar.getAuthor().getIconInfo();
                this.bcl = rVar.getAuthor().getTShowInfo();
                if (cdVar.bnP != null) {
                    cdVar.bnP.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
                    cdVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
                    cdVar.bnP.a(this.cDZ, i2, this.mContext.getResources().getDimensionPixelSize(n.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.pb_icon_margin));
                }
                if (cdVar.agT != null) {
                    cdVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
                    cdVar.agT.a(this.bcl, 3, this.mContext.getResources().getDimensionPixelSize(n.e.big_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.big_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.big_icon_margin), true);
                }
            }
            cdVar.cEn.setUserId(rVar.getAuthor().getUserId());
            cdVar.cEn.setUserName(rVar.getAuthor().getUserName());
            cdVar.cEn.setImageDrawable(null);
            cdVar.aLp.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
            cdVar.aLp.setTag(n.g.tag_user_name, rVar.getAuthor().getUserName());
            cdVar.cEn.d(portrait, 28, false);
            cdVar.cDC.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_c));
            if (this.cDr) {
                cdVar.cDC.setDefaultImageId(n.f.img_default_100);
            } else {
                cdVar.cDC.setDefaultImageId(n.f.icon_click);
            }
            cdVar.cDC.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aFr();
            }
            if (this.cDw || !this.cDx) {
                cdVar.cDC.a(aVar, false);
            } else {
                cdVar.cDC.a(aVar, true);
            }
            boolean z6 = false;
            boolean z7 = false;
            if (this.cDR.akL() != 0) {
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
            if (this.cDR != null && this.cDR.akH() != null && this.cDR.akH().getAuthor() != null && rVar.getAuthor() != null) {
                String userId4 = this.cDR.akH().getAuthor().getUserId();
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
                    if (rVar.aFq() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(n.g.tag_forbid_user_post_id, rVar.getId());
                    if (!z6) {
                        sparseArray.put(n.g.tag_should_manage_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cDR.akL()));
                        sparseArray.put(n.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(n.g.tag_user_mute_visible, true);
                        sparseArray.put(n.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar.getAuthor() != null) {
                            sparseArray.put(n.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                            sparseArray.put(n.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                        }
                        if (this.cDR.akH() != null) {
                            sparseArray.put(n.g.tag_user_mute_thread_id, this.cDR.akH().getId());
                        }
                        sparseArray.put(n.g.tag_user_mute_post_id, rVar.getId());
                    } else {
                        sparseArray.put(n.g.tag_user_mute_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(n.g.tag_should_delete_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cDR.akL()));
                        sparseArray.put(n.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(n.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(n.g.tag_del_post_id, rVar.getId());
                    } else {
                        sparseArray.put(n.g.tag_should_delete_visible, false);
                    }
                    a(cdVar, rVar, rVar.aFq() != 1, aVar);
                    a(cdVar);
                    if (!this.cDQ) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) cdVar.cGG.getLayoutParams();
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(n.e.ds74);
                        cdVar.cGG.setLayoutParams(layoutParams4);
                    }
                    cdVar.cGG.setVisibility(0);
                    cdVar.cGK.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_tuiguang));
                    if (aFA == null && !TextUtils.isEmpty(aFA.getPosition())) {
                        String position = aFA.getPosition();
                        cdVar.cGH.setVisibility(0);
                        cdVar.cGJ.setText(position);
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
            if (rVar.aFq() == 1) {
            }
            sparseArray.put(n.g.tag_forbid_user_post_id, rVar.getId());
            if (!z6) {
            }
            if (!z2) {
            }
            if (!z3) {
            }
            a(cdVar, rVar, rVar.aFq() != 1, aVar);
            a(cdVar);
            if (!this.cDQ) {
            }
            cdVar.cGG.setVisibility(0);
            cdVar.cGK.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_tuiguang));
            if (aFA == null) {
            }
        }
    }

    private void a(cd cdVar) {
        cdVar.cDC.setTextViewOnTouchListener(this.cDu);
        cdVar.cDC.setTextViewCheckSelection(false);
    }

    private void a(cd cdVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar == null || rVar.aoe() == null) {
            cdVar.cEN.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar.aoe(), cdVar.cEN, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cDz - (i - this.cDy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(cd cdVar) {
        cdVar.aLp.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        cdVar.cEt.setOnClickListener(this.bjD);
        cdVar.cGF.setOnClickListener(this.bjD);
        cdVar.cEn.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        cdVar.cEu.setOnLongClickListener(this.amQ);
        cdVar.cDC.setOnLongClickListener(this.amQ);
        cdVar.cEu.setOnTouchListener(this.cDu);
        cdVar.cDC.setOnTouchListener(this.cDu);
        cdVar.cDC.setOnImageClickListener(this.aFq);
        cdVar.cDC.setOnEmotionClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKo);
        cdVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
        cdVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
        cdVar.cEN.setOnClickListener(this.bjD);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cDR = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cDq = i;
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void eU(boolean z) {
        this.cDQ = z;
    }

    public void eT(boolean z) {
        this.cDs = z;
    }

    public void ku(String str) {
        this.cDX = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cEa = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bjD = onClickListener;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cDu = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFq = dVar;
    }
}
