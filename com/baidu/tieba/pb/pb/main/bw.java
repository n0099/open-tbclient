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
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public class bw extends bz<com.baidu.tieba.tbadkCore.data.o, by> implements View.OnClickListener {
    private TbRichTextView.d aBf;
    private final TbRichTextView.e aBg;
    private ArrayList<IconData> aSY;
    private View.OnClickListener aZI;
    private View.OnLongClickListener ajZ;
    private boolean chO;
    private com.baidu.tieba.pb.a.c chP;
    private String chV;
    private com.baidu.tieba.pb.pb.sub.ak chW;
    private ArrayList<IconData> chX;
    private View.OnClickListener chY;
    private int cho;
    private boolean chp;
    private boolean chq;
    private com.baidu.tieba.pb.b.c chs;
    private boolean chu;
    private final boolean chv;
    private int chw;
    private int chx;
    private HashSet<Long> ckq;
    private long ckr;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ckq = new HashSet<>();
        this.cho = 0;
        this.chp = true;
        this.chO = true;
        this.chq = true;
        this.chP = null;
        this.chV = null;
        this.chW = null;
        this.chX = null;
        this.aSY = null;
        this.chY = null;
        this.aZI = null;
        this.chs = null;
        this.ajZ = null;
        this.aBf = null;
        this.chu = false;
        this.chv = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.ckr = 0L;
        this.aBg = new bx(this);
        init();
    }

    private void init() {
        this.chw = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.chx = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public by a(ViewGroup viewGroup) {
        return new by(LayoutInflater.from(this.mContext).inflate(i.g.pb_chudian_item, viewGroup, false), this.chO, this.chp, this.cho);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bz, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, by byVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) byVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(byVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aA(i);
        com.baidu.tbadk.core.util.an.j(byVar.cii, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.j(byVar.cij, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.b(byVar.aGS, i.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.b((View) byVar.cin, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.an.b(byVar.ciq, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.an.b(byVar.bqp, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.an.c(byVar.cis, i.e.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.an.c(byVar.civ, i.c.cp_bg_line_b);
        if (oVar2 != null) {
            a(byVar, oVar2, view, false, i);
        }
        if (!this.chu && this.chv && byVar != null && byVar.chB.Fi() && (listView = ((PbActivity) this.cjZ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.chu = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x080a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(by byVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        if (byVar != null && oVar != null) {
            com.baidu.tieba.tbadkCore.data.g axC = oVar.axC();
            if (axC != null && this.ckq.add(Long.valueOf(axC.awX()))) {
                this.ckr = axC.awX();
                if (this.ckr != 0) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "PB", "locate", "c0114", "action_type", "VIEW_TRUE", "task", "tpoint", "obj_id", String.valueOf(this.ckr), "obj_name", String.valueOf(this.ckr), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.chP.afg().getId(), ImageViewerConfig.FORUM_NAME, this.chP.afg().getName(), "tid", this.chP.afh().getTid(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
                }
            }
            byVar.chB.setOnLinkImageClickListener(this.aBg);
            byVar.cim.setTag(null);
            byVar.cim.setUserId(null);
            byVar.aGS.setText((CharSequence) null);
            byVar.ciw.setVisibility(0);
            byVar.cis.setVisibility(0);
            byVar.cir.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) byVar.cit.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                byVar.cit.setTag(sparseArray2);
                byVar.chB.setTag(sparseArray2);
            }
            sparseArray2.put(i.f.tag_clip_board, oVar);
            sparseArray2.put(i.f.tag_is_subpb, false);
            a(byVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
            if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.chp) {
                sparseArray2.put(i.f.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) byVar.chB.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                byVar.chB.setLayoutParams(layoutParams);
                byVar.chB.setPadding(0, 0, 0, 0);
                byVar.chB.fU(null);
            } else {
                sparseArray2.put(i.f.tag_richtext_bg, oVar.getBimg_url());
                byVar.chB.fU(oVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) byVar.chB.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                byVar.chB.setLayoutParams(layoutParams2);
            }
            byVar.bqp.setText(com.baidu.tbadk.core.util.as.m(oVar.getTime()));
            com.baidu.tbadk.core.util.an.j(byVar.cih, i.c.cp_bg_line_e);
            if (i == 1) {
                if (this.chq) {
                    byVar.cii.setVisibility(8);
                    byVar.cij.setVisibility(8);
                    PraiseData praise = this.chP.afh().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        byVar.cij.setVisibility(8);
                        byVar.cii.setVisibility(0);
                    } else {
                        byVar.cij.setVisibility(0);
                        byVar.cii.setVisibility(8);
                    }
                } else {
                    byVar.cii.setVisibility(0);
                    byVar.cij.setVisibility(8);
                }
            } else {
                byVar.cii.setVisibility(0);
                byVar.cij.setVisibility(8);
            }
            byVar.cik.setVisibility(0);
            byVar.cit.setVisibility(0);
            byVar.bqp.setVisibility(0);
            String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(oVar.axt()));
            byVar.ciq.setVisibility(0);
            byVar.ciq.setText(format);
            if (!this.chO) {
                a(byVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds74));
            } else {
                a(byVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) byVar.ciu.getLayoutParams();
            if (!this.chO) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
            }
            if (this.chV != null && !this.chV.equals("0") && this.chV.equals(oVar.getAuthor().getUserId())) {
                byVar.cir.setVisibility(0);
                com.baidu.tbadk.core.util.an.c(byVar.cir, i.e.icon_floorhost);
            }
            com.baidu.tbadk.core.util.an.i(byVar.cil, i.e.bg_floor_new_middle);
            byVar.chB.setVideoImageId(i.e.pic_video);
            byVar.chB.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.pb_listitem_content));
            com.baidu.tbadk.core.util.an.c(byVar.cis, i.e.btn_pb_reply_selector);
            byVar.chB.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) byVar.cis.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                byVar.cis.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, oVar);
            sparseArray.put(i.f.tag_load_sub_data, oVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (oVar.axx() > 0) {
                if (this.chW == null) {
                    this.chW = new com.baidu.tieba.pb.pb.sub.ak(this.mContext);
                    this.chW.setIsFromCDN(this.mIsFromCDN);
                    this.chW.D(this.chY);
                    boolean z5 = false;
                    String userId2 = this.chP.afh().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                    }
                    this.chW.p(this.chP.afl(), z5);
                    this.chW.e(this.chP.afh());
                    this.chW.et(this.chO);
                }
                byVar.ciw.setVisibility(0);
                byVar.civ.setVisibility(0);
                byVar.ciu.setVisibility(0);
                byVar.ciw.a(oVar, view);
                byVar.ciw.setChildOnClickListener(this.aZI);
                byVar.ciw.setChildOnLongClickListener(this.ajZ);
                byVar.ciw.setChildOnTouchListener(this.chs);
                byVar.ciw.setSubPbAdapter(this.chW);
                byVar.ciw.setVisibility(0);
            } else {
                byVar.ciw.setVisibility(8);
                byVar.civ.setVisibility(8);
                byVar.ciu.setVisibility(8);
            }
            String portrait = oVar.getAuthor().getPortrait();
            if (oVar.getAuthor() != null) {
                byVar.aGS.setText(oVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = oVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.an.b(byVar.aGS, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(byVar.aGS, i.c.cp_cont_f, 1);
                }
                int level_id = oVar.getAuthor().getLevel_id();
                int is_bawu = oVar.getAuthor().getIs_bawu();
                String bawu_type = oVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    byVar.cin.setVisibility(0);
                    com.baidu.tbadk.core.util.an.c(byVar.cin, com.baidu.tbadk.core.util.c.ch(level_id));
                    i2 = 2;
                    byVar.cin.setOnClickListener(null);
                } else {
                    byVar.cin.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.an.c(byVar.cin, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.an.c(byVar.cin, i.e.pb_assist);
                    }
                }
                if (oVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.an.c(byVar.cip, i.e.icon_pop_girl_square);
                    byVar.cip.setVisibility(0);
                } else {
                    byVar.cip.setVisibility(8);
                }
                this.chX = oVar.getAuthor().getIconInfo();
                this.aSY = oVar.getAuthor().getTShowInfo();
                if (byVar.bds != null) {
                    byVar.bds.setTag(i.f.tag_user_id, oVar.getAuthor().getUserId());
                    byVar.bds.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.aXx);
                    byVar.bds.a(this.chX, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (byVar.aTq != null) {
                    byVar.aTq.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnd);
                    byVar.aTq.a(this.aSY, 3, this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
            }
            byVar.cim.setUserId(oVar.getAuthor().getUserId());
            byVar.cim.setUserName(oVar.getAuthor().getUserName());
            byVar.cim.setImageDrawable(null);
            byVar.aGS.setTag(i.f.tag_user_id, oVar.getAuthor().getUserId());
            byVar.aGS.setTag(i.f.tag_user_name, oVar.getAuthor().getUserName());
            byVar.cim.d(portrait, 28, false);
            byVar.chB.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_c));
            if (this.chp) {
                byVar.chB.setDefaultImageId(i.e.img_default_100);
            } else {
                byVar.chB.setDefaultImageId(i.e.icon_click);
            }
            byVar.chB.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = oVar.axu();
            }
            if (this.chu || !this.chv) {
                byVar.chB.a(aVar, false);
            } else {
                byVar.chB.a(aVar, true);
            }
            boolean z6 = false;
            boolean z7 = false;
            if (this.chP.afl() != 0) {
                z6 = true;
                z7 = true;
                String userId3 = oVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z6 = false;
                }
            }
            if (this.chP != null && this.chP.afh() != null && this.chP.afh().getAuthor() != null && oVar.getAuthor() != null) {
                String userId4 = this.chP.afh().getAuthor().getUserId();
                String userId5 = oVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = oVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z4 = true;
                    }
                    int i3 = 1;
                    if (oVar.axt() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, oVar.getId());
                    if (!z6) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.chP.afl()));
                        sparseArray.put(i.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (oVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, oVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, oVar.getAuthor().getUserName());
                        }
                        if (this.chP.afh() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.chP.afh().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, oVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.chP.afl()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(i.f.tag_del_post_id, oVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    a(byVar, oVar, oVar.axt() != 1, aVar);
                    a(byVar);
                    if (!this.chO) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) byVar.ckt.getLayoutParams();
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                        byVar.ckt.setLayoutParams(layoutParams4);
                    }
                    byVar.ckt.setVisibility(0);
                    byVar.ckx.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_tuiguang));
                    if (axC == null && !TextUtils.isEmpty(axC.getPosition())) {
                        String position = axC.getPosition();
                        byVar.cku.setVisibility(0);
                        byVar.ckw.setText(position);
                        return;
                    }
                }
            }
            z2 = false;
            z3 = z7;
            z4 = false;
            userId = oVar.getAuthor().getUserId();
            if (userId != null) {
                z3 = true;
                z4 = true;
            }
            int i32 = 1;
            if (oVar.axt() == 1) {
            }
            sparseArray.put(i.f.tag_forbid_user_post_id, oVar.getId());
            if (!z6) {
            }
            if (!z2) {
            }
            if (!z3) {
            }
            a(byVar, oVar, oVar.axt() != 1, aVar);
            a(byVar);
            if (!this.chO) {
            }
            byVar.ckt.setVisibility(0);
            byVar.ckx.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_tuiguang));
            if (axC == null) {
            }
        }
    }

    private void a(by byVar) {
        byVar.chB.setTextViewOnTouchListener(this.chs);
        byVar.chB.setTextViewCheckSelection(false);
    }

    private void a(by byVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (oVar == null || oVar.aiq() == null) {
            byVar.ciM.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(oVar.aiq(), byVar.ciM, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(oVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.chx - (i - this.chw));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(by byVar) {
        byVar.aGS.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnc);
        byVar.cis.setOnClickListener(this.aZI);
        byVar.cim.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnc);
        byVar.cit.setOnLongClickListener(this.ajZ);
        byVar.chB.setOnLongClickListener(this.ajZ);
        byVar.cit.setOnTouchListener(this.chs);
        byVar.chB.setOnTouchListener(this.chs);
        byVar.chB.setOnImageClickListener(this.aBf);
        byVar.chB.setOnEmotionClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cne);
        byVar.bds.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.aXx);
        byVar.aTq.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnd);
        byVar.ciM.setOnClickListener(this.aZI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.chP = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cho = i;
    }

    public void er(boolean z) {
        this.chp = z;
    }

    public void et(boolean z) {
        this.chO = z;
    }

    public void es(boolean z) {
        this.chq = z;
    }

    public void jJ(String str) {
        this.chV = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.chY = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZI = onClickListener;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.chs = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajZ = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aBf = dVar;
    }
}
