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
public class cy extends db<com.baidu.tieba.tbadkCore.data.s, da> implements View.OnClickListener {
    private TbRichTextView.d aJc;
    private final TbRichTextView.e aJd;
    private View.OnLongClickListener aoa;
    private ArrayList<IconData> bjm;
    private View.OnClickListener brL;
    private int ddn;
    private boolean ddo;
    private boolean ddp;
    private com.baidu.tieba.pb.data.e ddq;
    private boolean ddr;
    private com.baidu.tieba.pb.a.c dds;
    private int ddt;
    private int ddv;
    private boolean ddw;
    private final boolean ddx;
    private String deG;
    private com.baidu.tieba.pb.pb.sub.an deH;
    private ArrayList<IconData> deI;
    private View.OnClickListener deJ;
    private HashSet<Long> din;
    private long dio;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.din = new HashSet<>();
        this.ddn = 0;
        this.ddo = true;
        this.ddp = true;
        this.ddr = true;
        this.ddq = null;
        this.deG = null;
        this.deH = null;
        this.deI = null;
        this.bjm = null;
        this.deJ = null;
        this.brL = null;
        this.dds = null;
        this.aoa = null;
        this.aJc = null;
        this.ddw = false;
        this.ddx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.dio = 0L;
        this.aJd = new cz(this);
        init();
    }

    private void init() {
        this.ddt = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.ddv = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public da b(ViewGroup viewGroup) {
        return new da(LayoutInflater.from(this.mContext).inflate(t.h.pb_chudian_item, viewGroup, false), this.ddp, this.ddo, this.ddn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, da daVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) daVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(daVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) aF(i);
        com.baidu.tbadk.core.util.at.l(daVar.deP, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.l(daVar.deQ, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.b(daVar.aPp, t.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.at.b((View) daVar.deU, t.d.cp_cont_i, 1);
        com.baidu.tbadk.core.util.at.b(daVar.deX, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.b(daVar.deY, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.c(daVar.dfa, t.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.at.c(daVar.diq, t.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.at.c(daVar.dfd, t.d.cp_bg_line_b);
        if (sVar2 != null) {
            a(daVar, sVar2, view, false, i);
        }
        if (!this.ddw && this.ddx && daVar != null && daVar.ddA.IX() && (listView = ((PbActivity) this.dfw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ddw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0836  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x085a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(da daVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        if (daVar != null && sVar != null) {
            com.baidu.tieba.tbadkCore.data.i aTC = sVar.aTC();
            if (aTC != null && this.din.add(Long.valueOf(aTC.getTemplateId()))) {
                this.dio = aTC.getTemplateId();
                if (this.dio != 0) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "PB", "locate", "c0114", "action_type", "VIEW_TRUE", "task", "tpoint", "obj_id", String.valueOf(this.dio), "obj_name", String.valueOf(this.dio), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", "fid", this.ddq.avu().getId(), ImageViewerConfig.FORUM_NAME, this.ddq.avu().getName(), "tid", this.ddq.avv().getTid(), "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE);
                }
            }
            daVar.ddA.setOnLinkImageClickListener(this.aJd);
            daVar.deT.setTag(null);
            daVar.deT.setUserId(null);
            daVar.aPp.setText((CharSequence) null);
            daVar.dfe.setVisibility(0);
            daVar.dfa.setVisibility(0);
            daVar.deZ.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) daVar.dfb.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                daVar.dfb.setTag(sparseArray2);
                daVar.ddA.setTag(sparseArray2);
            }
            sparseArray2.put(t.g.tag_clip_board, sVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            a(daVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ddo) {
                sparseArray2.put(t.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) daVar.ddA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                daVar.ddA.setLayoutParams(layoutParams);
                daVar.ddA.setPadding(0, 0, 0, 0);
                daVar.ddA.gu(null);
            } else {
                sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                daVar.ddA.gu(sVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) daVar.ddA.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                daVar.ddA.setLayoutParams(layoutParams2);
            }
            daVar.deY.setText(com.baidu.tbadk.core.util.ay.w(sVar.getTime()));
            com.baidu.tbadk.core.util.at.l(daVar.deO, t.d.cp_bg_line_e);
            if (i == 1) {
                if (this.ddr) {
                    daVar.deP.setVisibility(8);
                    daVar.deQ.setVisibility(8);
                    PraiseData praise = this.ddq.avv().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        daVar.deQ.setVisibility(8);
                        daVar.deP.setVisibility(0);
                    } else {
                        daVar.deQ.setVisibility(0);
                        daVar.deP.setVisibility(8);
                    }
                } else {
                    daVar.deP.setVisibility(0);
                    daVar.deQ.setVisibility(8);
                }
            } else {
                daVar.deP.setVisibility(0);
                daVar.deQ.setVisibility(8);
            }
            daVar.deR.setVisibility(0);
            daVar.dfb.setVisibility(0);
            daVar.deY.setVisibility(0);
            String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTs()));
            daVar.deX.setVisibility(0);
            daVar.deX.setText(format);
            if (!this.ddp) {
                a(daVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds74));
            } else {
                a(daVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) daVar.dfc.getLayoutParams();
            if (!this.ddp) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(t.e.ds30);
            }
            if (this.deG != null && !this.deG.equals("0") && this.deG.equals(sVar.getAuthor().getUserId())) {
                daVar.deZ.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(daVar.deZ, t.f.icon_floorhost);
            }
            com.baidu.tbadk.core.util.at.k(daVar.deS, t.f.bg_floor_new_middle);
            daVar.ddA.setVideoImageId(t.f.pic_video);
            daVar.ddA.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.at.c(daVar.dfa, t.f.btn_pb_more_selector);
            com.baidu.tbadk.core.util.at.c(daVar.diq, t.f.btn_pb_reply_btn_selector);
            daVar.ddA.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) daVar.dfa.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                daVar.dfa.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            SparseArray sparseArray5 = (SparseArray) daVar.diq.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                daVar.diq.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, sVar);
            sparseArray5.put(t.g.tag_load_sub_data, sVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            if (sVar.aTw() > 0) {
                if (this.deH == null) {
                    this.deH = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.deH.setIsFromCDN(this.mIsFromCDN);
                    this.deH.N(this.deJ);
                    boolean z5 = false;
                    String userId2 = this.ddq.avv().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                    }
                    this.deH.t(this.ddq.avB(), z5);
                    this.deH.h(this.ddq.avv());
                    this.deH.fR(this.ddp);
                }
                daVar.dfe.setVisibility(0);
                daVar.dfd.setVisibility(0);
                daVar.dfc.setVisibility(0);
                daVar.dfe.a(sVar, view);
                daVar.dfe.setChildOnClickListener(this.brL);
                daVar.dfe.setChildOnLongClickListener(this.aoa);
                daVar.dfe.setChildOnTouchListener(this.dds);
                daVar.dfe.setSubPbAdapter(this.deH);
                daVar.dfe.setVisibility(0);
            } else {
                daVar.dfe.setVisibility(8);
                daVar.dfd.setVisibility(8);
                daVar.dfc.setVisibility(8);
            }
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                daVar.aPp.setText(sVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.at.b(daVar.aPp, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.at.b(daVar.aPp, t.d.cp_cont_f, 1);
                }
                int level_id = sVar.getAuthor().getLevel_id();
                int is_bawu = sVar.getAuthor().getIs_bawu();
                String bawu_type = sVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    daVar.deU.setVisibility(0);
                    com.baidu.tbadk.core.util.at.c(daVar.deU, BitmapHelper.getGradeResourceIdNew(level_id));
                    daVar.deU.setContentDescription(String.format(TbadkCoreApplication.m411getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                    i2 = 2;
                    daVar.deU.setOnClickListener(null);
                } else {
                    daVar.deU.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.at.c(daVar.deU, t.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.at.c(daVar.deU, t.f.pb_assist);
                    }
                }
                if (sVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.at.c(daVar.deW, t.f.icon_pop_girl_square);
                    daVar.deW.setVisibility(0);
                } else {
                    daVar.deW.setVisibility(8);
                }
                this.deI = sVar.getAuthor().getIconInfo();
                this.bjm = sVar.getAuthor().getTShowInfo();
                if (daVar.bvK != null) {
                    daVar.bvK.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                    daVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
                    daVar.bvK.a(this.deI, i2, this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (daVar.ahN != null) {
                    daVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
                    daVar.ahN.a(this.bjm, 3, this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
                }
            }
            daVar.deT.setUserId(sVar.getAuthor().getUserId());
            daVar.deT.setUserName(sVar.getAuthor().getUserName());
            daVar.deT.setImageDrawable(null);
            daVar.aPp.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
            daVar.aPp.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            daVar.deT.c(portrait, 28, false);
            daVar.ddA.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            if (this.ddo) {
                daVar.ddA.setDefaultImageId(t.f.img_default_100);
            } else {
                daVar.ddA.setDefaultImageId(t.f.icon_click);
            }
            daVar.ddA.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amn();
            }
            if (this.ddw || !this.ddx) {
                daVar.ddA.a(aVar, false);
            } else {
                daVar.ddA.a(aVar, true);
            }
            boolean z6 = false;
            boolean z7 = false;
            if (this.ddq.avB() != 0) {
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
            if (this.ddq != null && this.ddq.avv() != null && this.ddq.avv().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.ddq.avv().getAuthor().getUserId();
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
                    if (sVar.aTs() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z6) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ddq.avB()));
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
                        if (this.ddq.avv() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.ddq.avv().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ddq.avB()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    a(daVar, sVar, sVar.aTs() != 1, aVar);
                    a(daVar);
                    if (!this.ddp) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) daVar.dir.getLayoutParams();
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(t.e.ds74);
                        daVar.dir.setLayoutParams(layoutParams4);
                    }
                    daVar.dir.setVisibility(0);
                    daVar.div.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_tuiguang));
                    if (aTC == null && !TextUtils.isEmpty(aTC.getPosition())) {
                        String position = aTC.getPosition();
                        daVar.dis.setVisibility(0);
                        daVar.diu.setText(position);
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
            if (sVar.aTs() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
            if (!z6) {
            }
            if (!z2) {
            }
            if (!z3) {
            }
            a(daVar, sVar, sVar.aTs() != 1, aVar);
            a(daVar);
            if (!this.ddp) {
            }
            daVar.dir.setVisibility(0);
            daVar.div.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_tuiguang));
            if (aTC == null) {
            }
        }
    }

    private void a(da daVar) {
        daVar.ddA.setTextViewOnTouchListener(this.dds);
        daVar.ddA.setTextViewCheckSelection(false);
    }

    private void a(da daVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAu() == null) {
            daVar.dfu.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(sVar.aAu(), daVar.dfu, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ddv - (i - this.ddt));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(da daVar) {
        daVar.aPp.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        daVar.dfa.setOnClickListener(this.brL);
        daVar.diq.setOnClickListener(this.brL);
        daVar.deT.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        daVar.dfb.setOnLongClickListener(this.aoa);
        daVar.ddA.setOnLongClickListener(this.aoa);
        daVar.dfb.setOnTouchListener(this.dds);
        daVar.ddA.setOnTouchListener(this.dds);
        daVar.ddA.setOnImageClickListener(this.aJc);
        daVar.ddA.setOnEmotionClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dny);
        daVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
        daVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
        daVar.dfu.setOnClickListener(this.brL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.ddq = eVar;
    }

    public void lP(int i) {
        this.ddn = i;
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void fR(boolean z) {
        this.ddp = z;
    }

    public void fS(boolean z) {
        this.ddr = z;
    }

    public void lM(String str) {
        this.deG = str;
    }

    public void L(View.OnClickListener onClickListener) {
        this.deJ = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
    }
}
