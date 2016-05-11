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
public class ch extends cm<com.baidu.tieba.tbadkCore.data.s, cl> implements View.OnClickListener {
    private TbRichTextView.d aFe;
    private final TbRichTextView.e aFf;
    private View.OnLongClickListener ajO;
    private ArrayList<IconData> bfm;
    private View.OnClickListener bnn;
    private int dfH;
    private boolean dfI;
    private boolean dfJ;
    private com.baidu.tieba.pb.data.e dfK;
    private boolean dfL;
    private com.baidu.tieba.pb.a.d dfM;
    private int dfN;
    private int dfO;
    private boolean dfP;
    private final boolean dfQ;
    private String dgZ;
    private com.baidu.tieba.pb.pb.sub.an dha;
    private ArrayList<IconData> dhb;
    private View.OnClickListener dhc;
    private HashSet<Long> dkw;
    private long dkx;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dkw = new HashSet<>();
        this.dfH = 0;
        this.dfI = true;
        this.dfJ = true;
        this.dfL = true;
        this.dfK = null;
        this.dgZ = null;
        this.dha = null;
        this.dhb = null;
        this.bfm = null;
        this.dhc = null;
        this.bnn = null;
        this.dfM = null;
        this.ajO = null;
        this.aFe = null;
        this.dfP = false;
        this.dfQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.dkx = 0L;
        this.aFf = new ci(this);
        init();
    }

    private void init() {
        this.dfN = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.dfO = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public cl b(ViewGroup viewGroup) {
        return new cl(LayoutInflater.from(this.mContext).inflate(t.h.pb_chudian_item, viewGroup, false), this.dfJ, this.dfI, this.dfH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, cl clVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) clVar);
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        b(clVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) at(i);
        com.baidu.tbadk.core.util.at.l(clVar.dhh, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(clVar.dhi, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.l(clVar.dhj, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.c(clVar.aLz, t.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.at.c(clVar.dhn, t.d.cp_cont_i, 1);
        com.baidu.tbadk.core.util.at.c(clVar.dhq, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.c(clVar.dhr, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.c(clVar.dht, t.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.at.c(clVar.dkC, t.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.at.c(clVar.dhw, t.d.cp_bg_line_b);
        if (sVar2 != null) {
            a(clVar, sVar2, view, false, i);
        }
        if (!this.dfP && this.dfQ && clVar != null && clVar.dfT.Hn() && (listView = ((PbActivity) this.dhY.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dfP = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0822  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x082e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x083a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0846  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(cl clVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        if (clVar != null && sVar != null) {
            com.baidu.tieba.tbadkCore.data.i aUc = sVar.aUc();
            if (aUc != null && this.dkw.add(Long.valueOf(aUc.getTemplateId()))) {
                this.dkx = aUc.getTemplateId();
                if (this.dkx != 0) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "PB", "locate", "c0114", "action_type", "VIEW_TRUE", "task", "tpoint", "obj_id", String.valueOf(this.dkx), "obj_name", String.valueOf(this.dkx), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", "fid", this.dfK.avA().getId(), ImageViewerConfig.FORUM_NAME, this.dfK.avA().getName(), "tid", this.dfK.avB().getTid(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
                }
            }
            clVar.dfT.setOnLinkImageClickListener(this.aFf);
            clVar.dhm.setTag(null);
            clVar.dhm.setUserId(null);
            clVar.dhm.setIsRound(true);
            clVar.aLz.setText((CharSequence) null);
            clVar.dhx.setVisibility(0);
            clVar.dht.setVisibility(0);
            clVar.dhs.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) clVar.dhu.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                clVar.dhu.setTag(sparseArray2);
                clVar.dfT.setTag(sparseArray2);
            }
            sparseArray2.put(t.g.tag_clip_board, sVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            a(clVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.dfI) {
                sparseArray2.put(t.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) clVar.dfT.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                clVar.dfT.setLayoutParams(layoutParams);
                clVar.dfT.setPadding(0, 0, 0, 0);
                clVar.dfT.gv(null);
            } else {
                sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                clVar.dfT.gv(sVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) clVar.dfT.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                clVar.dfT.setLayoutParams(layoutParams2);
            }
            clVar.dhr.setText(com.baidu.tbadk.core.util.ay.x(sVar.getTime()));
            if (i == 1) {
                if (this.dfL) {
                    clVar.dhi.setVisibility(8);
                    clVar.dhj.setVisibility(8);
                    PraiseData praise = this.dfK.avB().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        clVar.dhj.setVisibility(8);
                        clVar.dhi.setVisibility(0);
                    } else {
                        clVar.dhj.setVisibility(0);
                        clVar.dhi.setVisibility(8);
                    }
                } else {
                    clVar.dhi.setVisibility(0);
                    clVar.dhj.setVisibility(8);
                }
            } else {
                clVar.dhi.setVisibility(0);
                clVar.dhj.setVisibility(8);
            }
            clVar.dhk.setVisibility(0);
            clVar.dhu.setVisibility(0);
            clVar.dhr.setVisibility(0);
            String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTS()));
            clVar.dhq.setVisibility(0);
            clVar.dhq.setText(format);
            if (!this.dfJ) {
                a(clVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds74));
            } else {
                a(clVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds104));
            }
            if (this.dgZ != null && !this.dgZ.equals("0") && this.dgZ.equals(sVar.getAuthor().getUserId())) {
                clVar.dhs.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(clVar.dhs, t.f.icon_floorhost);
            }
            com.baidu.tbadk.core.util.at.k(clVar.dhl, t.f.bg_floor_new_middle);
            clVar.dfT.setVideoImageId(t.f.pic_video);
            clVar.dfT.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.at.c(clVar.dht, t.f.btn_pb_more_selector);
            com.baidu.tbadk.core.util.at.c(clVar.dkC, t.f.btn_pb_reply_btn_selector);
            clVar.dfT.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) clVar.dht.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                clVar.dht.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            SparseArray sparseArray5 = (SparseArray) clVar.dkC.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                clVar.dkC.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, sVar);
            sparseArray5.put(t.g.tag_load_sub_data, sVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_number, Integer.valueOf(sVar.aTS()));
            if (sVar.aTW() > 0) {
                if (this.dha == null) {
                    this.dha = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.dha.setIsFromCDN(this.mIsFromCDN);
                    this.dha.J(this.dhc);
                    boolean z5 = false;
                    String userId2 = this.dfK.avB().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                    }
                    this.dha.v(this.dfK.avH(), z5);
                    this.dha.l(this.dfK.avB());
                    this.dha.gr(this.dfJ);
                }
                clVar.dhx.setVisibility(0);
                clVar.dhw.setVisibility(0);
                clVar.dhv.setVisibility(0);
                clVar.dhx.a(sVar, view);
                clVar.dhx.setChildOnClickListener(this.bnn);
                clVar.dhx.setChildOnLongClickListener(this.ajO);
                clVar.dhx.setChildOnTouchListener(this.dfM);
                clVar.dhx.setSubPbAdapter(this.dha);
                clVar.dhx.setVisibility(0);
            } else {
                clVar.dhx.setVisibility(8);
                clVar.dhw.setVisibility(8);
                clVar.dhv.setVisibility(8);
            }
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                clVar.aLz.setText(sVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.at.c(clVar.aLz, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.at.c(clVar.aLz, t.d.cp_cont_f, 1);
                }
                int level_id = sVar.getAuthor().getLevel_id();
                int is_bawu = sVar.getAuthor().getIs_bawu();
                String bawu_type = sVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    clVar.dhn.setVisibility(0);
                    com.baidu.tbadk.core.util.at.c(clVar.dhn, BitmapHelper.getGradeResourceIdNew(level_id));
                    clVar.dhn.setContentDescription(String.format(TbadkCoreApplication.m11getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                    i2 = 2;
                    clVar.dhn.setOnClickListener(null);
                } else {
                    clVar.dhn.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.at.c(clVar.dhn, t.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.at.c(clVar.dhn, t.f.pb_assist);
                    }
                }
                if (sVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.at.c(clVar.dhp, t.f.icon_pop_girl_square);
                    clVar.dhp.setVisibility(0);
                } else {
                    clVar.dhp.setVisibility(8);
                }
                this.dhb = sVar.getAuthor().getIconInfo();
                this.bfm = sVar.getAuthor().getTShowInfo();
                if (clVar.bvy != null) {
                    clVar.bvy.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                    clVar.bvy.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.bkL);
                    clVar.bvy.a(this.dhb, i2, this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (clVar.adH != null) {
                    clVar.adH.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpK);
                    clVar.adH.a(this.bfm, 3, this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
                }
            }
            clVar.dhm.setUserId(sVar.getAuthor().getUserId());
            clVar.dhm.setUserName(sVar.getAuthor().getUserName());
            clVar.dhm.setImageDrawable(null);
            clVar.aLz.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
            clVar.aLz.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            clVar.dhm.c(portrait, 28, false);
            clVar.dfT.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            if (this.dfI) {
                clVar.dfT.setDefaultImageId(t.f.img_default_100);
            } else {
                clVar.dfT.setDefaultImageId(t.f.icon_click);
            }
            clVar.dfT.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amw();
            }
            if (this.dfP || !this.dfQ) {
                clVar.dfT.a(aVar, false);
            } else {
                clVar.dfT.a(aVar, true);
            }
            boolean z6 = false;
            boolean z7 = false;
            if (this.dfK.avH() != 0) {
                z6 = true;
                z7 = true;
                String userId3 = sVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z6 = false;
                }
            }
            if (this.dfK != null && this.dfK.avB() != null && this.dfK.avB().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.dfK.avB().getAuthor().getUserId();
                String userId5 = sVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = sVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z4 = true;
                    }
                    int i3 = 1;
                    if (sVar.aTS() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z6) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dfK.avH()));
                        sparseArray.put(t.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                        }
                        if (this.dfK.avB() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.dfK.avB().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dfK.avH()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    a(clVar, sVar, sVar.aTS() != 1, aVar);
                    a(clVar);
                    if (!this.dfJ) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) clVar.dkD.getLayoutParams();
                        layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(t.e.ds74);
                        clVar.dkD.setLayoutParams(layoutParams3);
                    }
                    clVar.dkD.setVisibility(0);
                    clVar.dkH.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_tuiguang));
                    if (aUc == null && !TextUtils.isEmpty(aUc.getPosition())) {
                        String position = aUc.getPosition();
                        clVar.dkE.setVisibility(0);
                        clVar.dkG.setText(position);
                        return;
                    }
                }
            }
            z2 = false;
            z3 = z7;
            z4 = false;
            userId = sVar.getAuthor().getUserId();
            if (userId != null) {
                z3 = true;
                z4 = true;
            }
            int i32 = 1;
            if (sVar.aTS() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
            if (!z6) {
            }
            if (!z2) {
            }
            if (!z3) {
            }
            a(clVar, sVar, sVar.aTS() != 1, aVar);
            a(clVar);
            if (!this.dfJ) {
            }
            clVar.dkD.setVisibility(0);
            clVar.dkH.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_tuiguang));
            if (aUc == null) {
            }
        }
    }

    private void a(cl clVar) {
        clVar.dfT.setTextViewOnTouchListener(this.dfM);
        clVar.dfT.setTextViewCheckSelection(false);
    }

    private void a(cl clVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAC() == null) {
            clVar.dhP.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.n.a(sVar.aAC(), clVar.dhP, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dfO - (i - this.dfN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(cl clVar) {
        clVar.aLz.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpJ);
        clVar.dht.setOnClickListener(this.bnn);
        clVar.dkC.setOnClickListener(this.bnn);
        clVar.dhm.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpJ);
        clVar.dhu.setOnLongClickListener(this.ajO);
        clVar.dfT.setOnLongClickListener(this.ajO);
        clVar.dhu.setOnTouchListener(this.dfM);
        clVar.dfT.setOnTouchListener(this.dfM);
        clVar.dfT.setOnImageClickListener(this.aFe);
        clVar.dfT.setOnEmotionClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpL);
        clVar.bvy.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.bkL);
        clVar.adH.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpK);
        clVar.dhP.setOnClickListener(this.bnn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfK = eVar;
    }

    public void lE(int i) {
        this.dfH = i;
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void gr(boolean z) {
        this.dfJ = z;
    }

    public void gs(boolean z) {
        this.dfL = z;
    }

    public void lQ(String str) {
        this.dgZ = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dhc = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
    }
}
