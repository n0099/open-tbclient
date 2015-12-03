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
public class by extends cb<com.baidu.tieba.tbadkCore.data.o, ca> implements View.OnClickListener {
    private TbRichTextView.d aDR;
    private final TbRichTextView.e aDS;
    private ArrayList<IconData> aYm;
    private View.OnLongClickListener alK;
    private View.OnClickListener bfL;
    private boolean cAl;
    private com.baidu.tieba.pb.a.c cAm;
    private String cAs;
    private com.baidu.tieba.pb.pb.sub.al cAt;
    private ArrayList<IconData> cAu;
    private View.OnClickListener cAv;
    private HashSet<Long> cCP;
    private long cCQ;
    private int czL;
    private boolean czM;
    private boolean czN;
    private com.baidu.tieba.pb.b.c czP;
    private boolean czR;
    private final boolean czS;
    private int czT;
    private int czU;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cCP = new HashSet<>();
        this.czL = 0;
        this.czM = true;
        this.cAl = true;
        this.czN = true;
        this.cAm = null;
        this.cAs = null;
        this.cAt = null;
        this.cAu = null;
        this.aYm = null;
        this.cAv = null;
        this.bfL = null;
        this.czP = null;
        this.alK = null;
        this.aDR = null;
        this.czR = false;
        this.czS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.cCQ = 0L;
        this.aDS = new bz(this);
        init();
    }

    private void init() {
        this.czT = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds30);
        this.czU = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public ca a(ViewGroup viewGroup) {
        return new ca(LayoutInflater.from(this.mContext).inflate(n.g.pb_chudian_item, viewGroup, false), this.cAl, this.czM, this.czL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cb, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, ca caVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) caVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(caVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aB(i);
        com.baidu.tbadk.core.util.as.j(caVar.cAE, n.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(caVar.cAF, n.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.b(caVar.aJR, n.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.as.b((View) caVar.cAJ, n.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.as.b(caVar.cAM, n.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.b(caVar.bEX, n.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.c(caVar.cAO, n.e.btn_pb_more_selector);
        com.baidu.tbadk.core.util.as.c(caVar.cCS, n.e.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.as.c(caVar.cAR, n.c.cp_bg_line_b);
        if (oVar2 != null) {
            a(caVar, oVar2, view, false, i);
        }
        if (!this.czR && this.czS && caVar != null && caVar.czX.Gn() && (listView = ((PbActivity) this.cCy.getPageContext().getOrignalPage()).getListView()) != null) {
            this.czR = true;
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
    private void a(ca caVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        if (caVar != null && oVar != null) {
            com.baidu.tieba.tbadkCore.data.g aDn = oVar.aDn();
            if (aDn != null && this.cCP.add(Long.valueOf(aDn.aCJ()))) {
                this.cCQ = aDn.aCJ();
                if (this.cCQ != 0) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "PB", "locate", "c0114", "action_type", "VIEW_TRUE", "task", "tpoint", "obj_id", String.valueOf(this.cCQ), "obj_name", String.valueOf(this.cCQ), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, this.cAm.ajy().getId(), ImageViewerConfig.FORUM_NAME, this.cAm.ajy().getName(), "tid", this.cAm.ajz().getTid(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
                }
            }
            caVar.czX.setOnLinkImageClickListener(this.aDS);
            caVar.cAI.setTag(null);
            caVar.cAI.setUserId(null);
            caVar.aJR.setText((CharSequence) null);
            caVar.cAS.setVisibility(0);
            caVar.cAO.setVisibility(0);
            caVar.cAN.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) caVar.cAP.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                caVar.cAP.setTag(sparseArray2);
                caVar.czX.setTag(sparseArray2);
            }
            sparseArray2.put(n.f.tag_clip_board, oVar);
            sparseArray2.put(n.f.tag_is_subpb, false);
            a(caVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
            if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.czM) {
                sparseArray2.put(n.f.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) caVar.czX.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                caVar.czX.setLayoutParams(layoutParams);
                caVar.czX.setPadding(0, 0, 0, 0);
                caVar.czX.gh(null);
            } else {
                sparseArray2.put(n.f.tag_richtext_bg, oVar.getBimg_url());
                caVar.czX.gh(oVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) caVar.czX.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(n.d.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(n.d.ds20);
                caVar.czX.setLayoutParams(layoutParams2);
            }
            caVar.bEX.setText(com.baidu.tbadk.core.util.ax.s(oVar.getTime()));
            com.baidu.tbadk.core.util.as.j(caVar.cAD, n.c.cp_bg_line_e);
            if (i == 1) {
                if (this.czN) {
                    caVar.cAE.setVisibility(8);
                    caVar.cAF.setVisibility(8);
                    PraiseData praise = this.cAm.ajz().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        caVar.cAF.setVisibility(8);
                        caVar.cAE.setVisibility(0);
                    } else {
                        caVar.cAF.setVisibility(0);
                        caVar.cAE.setVisibility(8);
                    }
                } else {
                    caVar.cAE.setVisibility(0);
                    caVar.cAF.setVisibility(8);
                }
            } else {
                caVar.cAE.setVisibility(0);
                caVar.cAF.setVisibility(8);
            }
            caVar.cAG.setVisibility(0);
            caVar.cAP.setVisibility(0);
            caVar.bEX.setVisibility(0);
            String format = String.format(this.mContext.getString(n.i.is_floor), Integer.valueOf(oVar.aDd()));
            caVar.cAM.setVisibility(0);
            caVar.cAM.setText(format);
            if (!this.cAl) {
                a(caVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds74));
            } else {
                a(caVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) caVar.cAQ.getLayoutParams();
            if (!this.cAl) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds30);
            }
            if (this.cAs != null && !this.cAs.equals("0") && this.cAs.equals(oVar.getAuthor().getUserId())) {
                caVar.cAN.setVisibility(0);
                com.baidu.tbadk.core.util.as.c(caVar.cAN, n.e.icon_floorhost);
            }
            com.baidu.tbadk.core.util.as.i(caVar.cAH, n.e.bg_floor_new_middle);
            caVar.czX.setVideoImageId(n.e.pic_video);
            caVar.czX.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.pb_listitem_content));
            com.baidu.tbadk.core.util.as.c(caVar.cAO, n.e.btn_pb_more_selector);
            com.baidu.tbadk.core.util.as.c(caVar.cCS, n.e.btn_pb_reply_btn_selector);
            caVar.czX.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) caVar.cAO.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                caVar.cAO.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(n.f.tag_clip_board, oVar);
            sparseArray.put(n.f.tag_load_sub_data, oVar);
            sparseArray.put(n.f.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) caVar.cCS.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                caVar.cCS.setTag(sparseArray5);
            }
            sparseArray5.put(n.f.tag_clip_board, oVar);
            sparseArray5.put(n.f.tag_load_sub_data, oVar);
            sparseArray5.put(n.f.tag_load_sub_view, view);
            if (oVar.aDh() > 0) {
                if (this.cAt == null) {
                    this.cAt = new com.baidu.tieba.pb.pb.sub.al(this.mContext);
                    this.cAt.setIsFromCDN(this.mIsFromCDN);
                    this.cAt.D(this.cAv);
                    boolean z5 = false;
                    String userId2 = this.cAm.ajz().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                    }
                    this.cAt.q(this.cAm.ajD(), z5);
                    this.cAt.e(this.cAm.ajz());
                    this.cAt.eV(this.cAl);
                }
                caVar.cAS.setVisibility(0);
                caVar.cAR.setVisibility(0);
                caVar.cAQ.setVisibility(0);
                caVar.cAS.a(oVar, view);
                caVar.cAS.setChildOnClickListener(this.bfL);
                caVar.cAS.setChildOnLongClickListener(this.alK);
                caVar.cAS.setChildOnTouchListener(this.czP);
                caVar.cAS.setSubPbAdapter(this.cAt);
                caVar.cAS.setVisibility(0);
            } else {
                caVar.cAS.setVisibility(8);
                caVar.cAR.setVisibility(8);
                caVar.cAQ.setVisibility(8);
            }
            String portrait = oVar.getAuthor().getPortrait();
            if (oVar.getAuthor() != null) {
                caVar.aJR.setText(oVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfoNew = oVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.as.b(caVar.aJR, n.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(caVar.aJR, n.c.cp_cont_f, 1);
                }
                int level_id = oVar.getAuthor().getLevel_id();
                int is_bawu = oVar.getAuthor().getIs_bawu();
                String bawu_type = oVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    caVar.cAJ.setVisibility(0);
                    com.baidu.tbadk.core.util.as.c(caVar.cAJ, com.baidu.tbadk.core.util.c.cp(level_id));
                    i2 = 2;
                    caVar.cAJ.setOnClickListener(null);
                } else {
                    caVar.cAJ.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.as.c(caVar.cAJ, n.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.as.c(caVar.cAJ, n.e.pb_assist);
                    }
                }
                if (oVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.as.c(caVar.cAL, n.e.icon_pop_girl_square);
                    caVar.cAL.setVisibility(0);
                } else {
                    caVar.cAL.setVisibility(8);
                }
                this.cAu = oVar.getAuthor().getIconInfo();
                this.aYm = oVar.getAuthor().getTShowInfo();
                if (caVar.bjY != null) {
                    caVar.bjY.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
                    caVar.bjY.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.bdv);
                    caVar.bjY.a(this.cAu, i2, this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_margin));
                }
                if (caVar.aYE != null) {
                    caVar.aYE.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGo);
                    caVar.aYE.a(this.aYm, 3, this.mContext.getResources().getDimensionPixelSize(n.d.big_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.big_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.big_icon_margin), true);
                }
            }
            caVar.cAI.setUserId(oVar.getAuthor().getUserId());
            caVar.cAI.setUserName(oVar.getAuthor().getUserName());
            caVar.cAI.setImageDrawable(null);
            caVar.aJR.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
            caVar.aJR.setTag(n.f.tag_user_name, oVar.getAuthor().getUserName());
            caVar.cAI.d(portrait, 28, false);
            caVar.czX.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_link_tip_c));
            if (this.czM) {
                caVar.czX.setDefaultImageId(n.e.img_default_100);
            } else {
                caVar.czX.setDefaultImageId(n.e.icon_click);
            }
            caVar.czX.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = oVar.aDe();
            }
            if (this.czR || !this.czS) {
                caVar.czX.a(aVar, false);
            } else {
                caVar.czX.a(aVar, true);
            }
            boolean z6 = false;
            boolean z7 = false;
            if (this.cAm.ajD() != 0) {
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
            if (this.cAm != null && this.cAm.ajz() != null && this.cAm.ajz().getAuthor() != null && oVar.getAuthor() != null) {
                String userId4 = this.cAm.ajz().getAuthor().getUserId();
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
                    if (oVar.aDd() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
                    if (!z6) {
                        sparseArray.put(n.f.tag_should_manage_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cAm.ajD()));
                        sparseArray.put(n.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(n.f.tag_user_mute_visible, true);
                        sparseArray.put(n.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (oVar.getAuthor() != null) {
                            sparseArray.put(n.f.tag_user_mute_mute_userid, oVar.getAuthor().getUserId());
                            sparseArray.put(n.f.tag_user_mute_mute_username, oVar.getAuthor().getUserName());
                        }
                        if (this.cAm.ajz() != null) {
                            sparseArray.put(n.f.tag_user_mute_thread_id, this.cAm.ajz().getId());
                        }
                        sparseArray.put(n.f.tag_user_mute_post_id, oVar.getId());
                    } else {
                        sparseArray.put(n.f.tag_user_mute_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(n.f.tag_should_delete_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cAm.ajD()));
                        sparseArray.put(n.f.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(n.f.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(n.f.tag_del_post_id, oVar.getId());
                    } else {
                        sparseArray.put(n.f.tag_should_delete_visible, false);
                    }
                    a(caVar, oVar, oVar.aDd() != 1, aVar);
                    a(caVar);
                    if (!this.cAl) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) caVar.cCT.getLayoutParams();
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds74);
                        caVar.cCT.setLayoutParams(layoutParams4);
                    }
                    caVar.cCT.setVisibility(0);
                    caVar.cCX.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_tuiguang));
                    if (aDn == null && !TextUtils.isEmpty(aDn.getPosition())) {
                        String position = aDn.getPosition();
                        caVar.cCU.setVisibility(0);
                        caVar.cCW.setText(position);
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
            if (oVar.aDd() == 1) {
            }
            sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
            if (!z6) {
            }
            if (!z2) {
            }
            if (!z3) {
            }
            a(caVar, oVar, oVar.aDd() != 1, aVar);
            a(caVar);
            if (!this.cAl) {
            }
            caVar.cCT.setVisibility(0);
            caVar.cCX.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_tuiguang));
            if (aDn == null) {
            }
        }
    }

    private void a(ca caVar) {
        caVar.czX.setTextViewOnTouchListener(this.czP);
        caVar.czX.setTextViewCheckSelection(false);
    }

    private void a(ca caVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (oVar == null || oVar.amT() == null) {
            caVar.cBi.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.e.a(oVar.amT(), caVar.cBi, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(oVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.czU - (i - this.czT));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(ca caVar) {
        caVar.aJR.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGn);
        caVar.cAO.setOnClickListener(this.bfL);
        caVar.cCS.setOnClickListener(this.bfL);
        caVar.cAI.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGn);
        caVar.cAP.setOnLongClickListener(this.alK);
        caVar.czX.setOnLongClickListener(this.alK);
        caVar.cAP.setOnTouchListener(this.czP);
        caVar.czX.setOnTouchListener(this.czP);
        caVar.czX.setOnImageClickListener(this.aDR);
        caVar.czX.setOnEmotionClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGp);
        caVar.bjY.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.bdv);
        caVar.aYE.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGo);
        caVar.cBi.setOnClickListener(this.bfL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cAm = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.czL = i;
    }

    public void eT(boolean z) {
        this.czM = z;
    }

    public void eV(boolean z) {
        this.cAl = z;
    }

    public void eU(boolean z) {
        this.czN = z;
    }

    public void ky(String str) {
        this.cAs = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cAv = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bfL = onClickListener;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.czP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alK = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aDR = dVar;
    }
}
