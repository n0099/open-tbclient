package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dw extends cx<PostData, ec> implements View.OnClickListener {
    private TbRichTextView.e aNK;
    private boolean aiG;
    private View.OnLongClickListener atl;
    protected boolean cAb;
    private ArrayList<IconData> cVN;
    private View.OnClickListener cpI;
    protected int ehf;
    private boolean ehg;
    protected com.baidu.tieba.pb.data.f ehh;
    private com.baidu.tieba.pb.pb.sub.ba ehi;
    private ArrayList<IconData> ehj;
    private View.OnClickListener ehk;
    private com.baidu.tieba.pb.a.d ehl;
    private boolean ehm;
    private final boolean ehn;
    private int eho;
    private int ehp;
    private boolean eiH;
    private boolean ekF;
    private TbRichTextView.b enb;
    private boolean enc;
    private String mHostId;

    private void init() {
        this.eho = getDimensionPixelSize(w.f.ds30);
        this.ehp = com.baidu.adp.lib.util.k.af(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ehf = 0;
        this.cAb = true;
        this.ehg = true;
        this.ehh = null;
        this.mHostId = null;
        this.ehi = null;
        this.ehj = null;
        this.cVN = null;
        this.ehk = null;
        this.cpI = null;
        this.aNK = null;
        this.ehl = null;
        this.atl = null;
        this.enb = null;
        this.ehm = false;
        this.ehn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.ekF = false;
        this.enc = false;
        this.eiH = false;
        this.aiG = false;
        init();
    }

    private void a(ec ecVar) {
        if (ecVar != null) {
            if (ecVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.k(ecVar.ehv, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(ecVar.ehN, w.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.aq.c(ecVar.bsf, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c((View) ecVar.ehA, w.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.aq.c((View) ecVar.ehB, w.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ehC, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ehD, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.j(ecVar.ens, w.g.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.aq.c(ecVar.ens, w.g.icon_pb_more_n);
                com.baidu.tbadk.core.util.aq.j(ecVar.enu, w.g.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.aq.c(ecVar.enu, w.g.icon_pb_more_n);
                ecVar.enw.onChangeSkinType();
                com.baidu.tbadk.core.util.aq.k(ecVar.ehG, w.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.aq.k(ecVar.ehH, w.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.aq.c(ecVar.ehH, w.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.aq.j(ecVar.eny, w.g.btn_appdownload);
                com.baidu.tbadk.core.util.aq.c(ecVar.eny, w.e.cp_cont_i, 1);
                ecVar.ehF.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039));
                com.baidu.tbadk.core.util.aq.c(ecVar.eia, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ehZ, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ehY, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ehX, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.j(ecVar.ehx, w.g.bg_floor_new_middle);
                com.baidu.tbadk.core.util.aq.k(ecVar.ehK, w.e.cp_bg_line_e);
                c(ecVar);
            }
            ecVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public ec onCreateViewHolder(ViewGroup viewGroup) {
        ec ecVar = new ec(this.eig.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.cAb, this.ehf);
        a(ecVar);
        return ecVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cx, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, ec ecVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, ecVar);
        a(ecVar);
        e(ecVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.tm();
            a(ecVar, postData2, view, i);
        }
        if (!this.ehm && this.ehn && ecVar != null && ecVar.ehF.Jb() && (listView = ((PbActivity) this.eig.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ehm = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private boolean oo(int i) {
        if (getItem(0) instanceof PostData) {
            PostData postData = (PostData) getItem(0);
            if (postData.bio() == 1 && i == 1) {
                return true;
            }
            return postData.bio() != 1 && i == 0;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v59, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0ed5  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0ee1  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0eed  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0f31  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0f34  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ec ecVar, PostData postData, View view, int i) {
        SparseArray sparseArray;
        UserTbVipInfoData userTbVipInfoData;
        TbRichText awl;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bix;
        int i2;
        if (ecVar != null && postData != null) {
            ecVar.ehL.setVisibility(0);
            ecVar.ehz.setTag(null);
            ecVar.ehz.setUserId(null);
            ecVar.bsf.setText((CharSequence) null);
            ecVar.ehB.setVisibility(8);
            ecVar.ehK.setVisibility(0);
            ecVar.ehE.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) ecVar.ehJ.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                ecVar.ehJ.setTag(sparseArray3);
                ecVar.ehF.setTag(sparseArray3);
                ecVar.ehv.setTag(w.h.tag_from, sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar.ehF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            ecVar.ehF.setPadding(0, 0, 0, 0);
            if (!this.cAb) {
                if (postData.bio() == 1) {
                    ecVar.ehF.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                    ecVar.ehF.setIsSupportVitality(false);
                }
            } else if (TextUtils.isEmpty(postData.getBimg_url())) {
                this.enc = false;
                sparseArray.put(w.h.tag_richtext_bg, null);
                ecVar.ehF.gv(null);
                ecVar.ehF.setBackgroundDrawable(null);
                if (postData.bio() == 1) {
                    ecVar.ehF.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                    ecVar.ehF.setIsSupportVitality(false);
                }
            } else {
                this.enc = true;
                ecVar.ehF.setIsSupportVitality(false);
                if (postData.bio() == 1) {
                    layoutParams.leftMargin = getDimensionPixelSize(w.f.ds30);
                } else {
                    layoutParams.leftMargin = 0;
                }
                layoutParams.rightMargin = getDimensionPixelSize(w.f.ds30);
                if (postData.aPb() == null) {
                    layoutParams.bottomMargin = getDimensionPixelSize(w.f.ds24);
                } else {
                    layoutParams.bottomMargin = getDimensionPixelSize(w.f.ds32);
                }
                layoutParams.topMargin = getDimensionPixelSize(w.f.ds24);
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                ecVar.ehF.gv(postData.getBimg_url());
            }
            ecVar.ehF.setLayoutParams(layoutParams);
            if (postData.bio() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    ecVar.ehF.setOnClickListener(this.cpI);
                    ecVar.ehF.setTextViewOnClickListener(this.cpI);
                } else {
                    ecVar.ehF.setOnClickListener(null);
                    ecVar.ehF.setTextViewOnClickListener(null);
                }
                ecVar.ehv.setOnClickListener(this.cpI);
                ecVar.ehJ.setOnClickListener(this.cpI);
            } else {
                ecVar.ehv.setOnClickListener(null);
                ecVar.ehJ.setOnClickListener(null);
            }
            ecVar.ehD.setText(postData.biq());
            if (postData.bio() == 1) {
                a(ecVar.ehF, view, true, this.enc);
                ecVar.ehN.setVisibility(8);
                ecVar.ehw.setVisibility(8);
                ecVar.ehL.setVisibility(8);
                ecVar.ehJ.setVisibility(8);
                ecVar.ehD.setVisibility(8);
                ecVar.ehM.setVisibility(8);
                ecVar.eic.setVisibility(8);
                ecVar.ehI.setVisibility(0);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                if (this.ehh != null && this.ehh.aJx() != null) {
                    ecVar.ehI.a(postData.biv(), str, j, com.baidu.adp.lib.g.b.c(this.ehh.aJx().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                ecVar.ehI.onChangeSkinType();
                if (this.ehg) {
                    PraiseData praiseData = null;
                    if (this.ehh != null && this.ehh.aJx() != null) {
                        this.ehh.aJx().se();
                    }
                    if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                        ecVar.ehG.setVisibility(0);
                        ecVar.ehH.setVisibility(0);
                        ecVar.ehG.setIsFromPb(true);
                        ecVar.ehG.a(null, this.ehh.aJx().getId(), praiseData.getPostId(), true);
                        ecVar.ehG.m26do(this.mSkinType);
                    } else {
                        ecVar.ehG.setVisibility(8);
                        ecVar.ehH.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.al(ecVar.ehG);
                    com.baidu.tieba.graffiti.c.al(ecVar.ehH);
                    ecVar.ehW.setVisibility(0);
                    ecVar.ehY.setText(postData.biq());
                    com.baidu.tbadk.data.g bir = postData.bir();
                    ecVar.eia.setVisibility(8);
                    if (bir != null && !TextUtils.isEmpty(bir.getName()) && !TextUtils.isEmpty(bir.getName().trim())) {
                        String name = bir.getName();
                        String lat = bir.getLat();
                        String lng = bir.getLng();
                        ecVar.ehZ.setVisibility(0);
                        com.baidu.adp.lib.util.k.a(this.mContext, ecVar.ehZ, 0, 10, 0, 10);
                        ecVar.ehZ.setText(bir.getName());
                        ecVar.ehZ.setOnClickListener(new dx(this, lat, lng, name));
                    } else {
                        ecVar.ehZ.setVisibility(8);
                    }
                    if (this.ehh.aJO() != null && !StringUtils.isNull(this.ehh.aJO().qB(), true)) {
                        b(ecVar);
                    }
                } else {
                    ecVar.ehG.setVisibility(8);
                    ecVar.ehH.setVisibility(8);
                    if (postData.getAuthor() != null && postData.getAuthor().getGodInfo() != null) {
                        ecVar.ehI.je(false);
                    } else {
                        ecVar.ehG.setVisibility(8);
                        ecVar.ehH.setVisibility(8);
                        ecVar.ehZ.setVisibility(8);
                        ecVar.eia.setVisibility(8);
                    }
                    if (this.ehh.aJO() != null && !StringUtils.isNull(this.ehh.aJO().qB(), true) && ecVar.enk != null) {
                        ecVar.enk.setVisibility(8);
                        ecVar.enp.EG();
                    }
                }
                if (this.eig.aKq().aNM()) {
                    ecVar.ehF.setVisibility(8);
                }
                if (this.ehh.aJx() != null && this.ehh.aJx().sA() != null) {
                    com.baidu.tbadk.core.data.bs sA = this.ehh.aJx().sA();
                    String activityUrl = sA.getActivityUrl();
                    String tK = sA.tK();
                    String tL = sA.tL();
                    if (!StringUtils.isNull(tL)) {
                        ecVar.eny.setVisibility(0);
                        ecVar.eny.setText(tL);
                        ecVar.eny.setOnClickListener(new dy(this, activityUrl));
                        ecVar.enz.setOnClickListener(new dz(this, activityUrl));
                        if (!StringUtils.isNull(tK)) {
                            ecVar.bPk.setVisibility(0);
                            ecVar.bPk.c(tK, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    ecVar.eny.setVisibility(8);
                    ecVar.bPk.setVisibility(8);
                }
                if (ecVar.enD != null) {
                    ecVar.enD.setVisibility(8);
                }
                if (this.ehh != null && this.ehh.aJx() != null && this.ehh.aJx().tb()) {
                    ecVar.enG.d(postData.Iy());
                    ecVar.ehF.setVisibility(8);
                    ecVar.ehW.setVisibility(8);
                    ecVar.enG.esp.setVisibility(8);
                } else {
                    ecVar.enG.esp.setVisibility(8);
                    ecVar.ehW.setVisibility(0);
                }
            } else {
                if (this.ehh.aJO() != null && !StringUtils.isNull(this.ehh.aJO().qB(), true) && ecVar.enk != null) {
                    ecVar.enk.setVisibility(8);
                }
                ecVar.ehF.setVisibility(0);
                a(ecVar.ehF, view, false, this.enc);
                ecVar.ehw.setVisibility(0);
                ecVar.ehM.setVisibility(0);
                ecVar.bPk.setVisibility(8);
                ecVar.eny.setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = ecVar.ehN.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ecVar.ehL.getLayoutParams();
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) ecVar.ehJ.getLayoutParams();
                if (oo(i)) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20);
                    layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                    layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds6);
                } else {
                    layoutParams4.topMargin = 0;
                    layoutParams3.topMargin = 0;
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
                }
                ecVar.ehL.setLayoutParams(layoutParams3);
                ecVar.ehJ.setLayoutParams(layoutParams4);
                ecVar.ehN.setLayoutParams(layoutParams2);
                ecVar.ehN.setVisibility(0);
                ecVar.ehI.setVisibility(8);
                ecVar.ehG.setVisibility(8);
                ecVar.ehH.setVisibility(8);
                ecVar.ehJ.setVisibility(0);
                ecVar.ehL.setVisibility(0);
                ecVar.ehD.setVisibility(0);
                com.baidu.tbadk.data.g bir2 = postData.bir();
                ecVar.ehW.setVisibility(8);
                if (bir2 != null && !TextUtils.isEmpty(bir2.getName()) && !TextUtils.isEmpty(bir2.getName().trim())) {
                    String name2 = bir2.getName();
                    String lat2 = bir2.getLat();
                    String lng2 = bir2.getLng();
                    ecVar.eia.setVisibility(0);
                    ecVar.eia.setText(bir2.getName());
                    ecVar.eia.setOnClickListener(new ea(this, lat2, lng2, name2));
                } else {
                    ecVar.eia.setVisibility(8);
                }
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bio()));
                ecVar.ehC.setVisibility(0);
                ecVar.ehC.setText(format);
                if (ecVar.enD != null) {
                    if (postData.sJ() != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.ehL.getLayoutParams();
                        marginLayoutParams.topMargin = (int) this.eig.getResources().getDimension(w.f.ds16);
                        ecVar.ehL.setLayoutParams(marginLayoutParams);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ecVar.enE.getLayoutParams();
                        marginLayoutParams2.topMargin = (int) this.eig.getResources().getDimension(w.f.ds10);
                        ecVar.enE.setLayoutParams(marginLayoutParams2);
                        ecVar.enD.a(this.eig.getPageContext(), postData.sJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", this.ehh.aJw().getId(), this.ehh.aJw().getName(), this.ehh.aJx().getId(), null));
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) ecVar.enF.getLayoutParams();
                        marginLayoutParams3.leftMargin = (int) this.eig.getResources().getDimension(w.f.ds30);
                        marginLayoutParams3.rightMargin = (int) this.eig.getResources().getDimension(w.f.ds30);
                        ecVar.enF.setLayoutParams(marginLayoutParams3);
                    } else {
                        ecVar.enD.a(null, null, null);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) ecVar.enF.getLayoutParams();
                        marginLayoutParams4.leftMargin = 0;
                        marginLayoutParams4.rightMargin = 0;
                        ecVar.enF.setLayoutParams(marginLayoutParams4);
                    }
                }
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                ecVar.ehE.setVisibility(0);
                com.baidu.tbadk.core.util.aq.i(ecVar.ehE, w.e.cp_link_tip_a);
            } else {
                ecVar.ehE.setVisibility(8);
            }
            ecVar.ehF.setVideoImageId(w.g.pic_video);
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(w.h.tag_clip_board, postData);
            sparseArray4.put(w.h.tag_load_sub_data, postData);
            sparseArray4.put(w.h.tag_load_sub_view, view);
            sparseArray4.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray4.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bio()));
            if (postData.biA()) {
                ecVar.ent.setVisibility(8);
                ecVar.env.setVisibility(0);
                ecVar.enw.setVisibility(0);
                ecVar.enw.setTag(w.h.tag_clip_board, postData);
                ecVar.enu.setTag(sparseArray4);
                ecVar.env.setTag(sparseArray4);
                ecVar.enw.a(postData.biC(), postData.biB(), false);
            } else {
                ecVar.ent.setVisibility(0);
                ecVar.ens.setTag(sparseArray4);
                ecVar.ent.setTag(sparseArray4);
                ecVar.env.setVisibility(8);
                ecVar.enw.setVisibility(8);
            }
            if (postData.bis() > 0 && postData.bil() != null && postData.bil().size() > 0) {
                if (this.ehi == null) {
                    this.ehi = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.ehi.setIsFromCDN(this.mIsFromCDN);
                    this.ehi.I(this.ehk);
                    boolean z7 = false;
                    String userId = this.ehh.aJx().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.ehi.B(this.ehh.aJH(), z7);
                    this.ehi.h(this.ehh.aJx());
                }
                this.ehi.nP(postData.getId());
                ecVar.ehK.setVisibility(0);
                ecVar.ehK.a(postData, view);
                ecVar.ehK.setChildOnClickListener(this.cpI);
                ecVar.ehK.setChildOnLongClickListener(this.atl);
                ecVar.ehK.setChildOnTouchListener(this.ehl);
                ecVar.ehK.setSubPbAdapter(this.ehi);
                ecVar.ehK.setVisibility(0);
                ecVar.eic.setVisibility(0);
                ecVar.eic.invalidate();
                ecVar.ehM.setPadding(0, 0, 0, 0);
            } else {
                ecVar.ehM.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds26));
                ecVar.ehK.setVisibility(8);
                ecVar.eic.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gq = com.baidu.tbadk.util.u.gq(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gq > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 12)) + "...";
                    }
                } else if (gq > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    ecVar.bsf.setText(af(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    ecVar.bsf.setText(name_show);
                }
                if (ecVar.enj != null && postData.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = postData.getAuthor().getAlaUserData();
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        ecVar.enj.setVisibility(8);
                    } else {
                        ecVar.enj.setVisibility(0);
                        com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                        bVar.QP = alaUserData;
                        bVar.type = 3;
                        ecVar.enj.setTag(bVar);
                    }
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.aq.c(ecVar.bsf, w.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aq.c(ecVar.bsf, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                if (level_id != 0) {
                    ecVar.ehA.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.c(ecVar.ehA, BitmapHelper.getGradeResourceIdNew(level_id));
                    String biz = postData.biz();
                    if (StringUtils.isNull(biz)) {
                        biz = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id));
                    }
                    ecVar.ehA.setContentDescription(biz);
                    ecVar.ehA.setOnClickListener(null);
                } else {
                    ecVar.ehA.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.aq.c(ecVar.ehB, w.g.pb_manager);
                        ecVar.ehA.setVisibility(8);
                        ecVar.ehB.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.aq.c(ecVar.ehB, w.g.pb_assist);
                        ecVar.ehA.setVisibility(8);
                        ecVar.ehB.setVisibility(0);
                    }
                    if (ecVar.ehB.getVisibility() == 0) {
                        ecVar.ehB.setAlpha(179);
                    }
                }
                if (ecVar.ehA.getVisibility() == 0) {
                    ecVar.ehA.setAlpha(179);
                }
                int gq2 = com.baidu.tbadk.util.u.gq(postData.getAuthor().getName_show());
                if (gq2 < 14 || ecVar.ehA.getVisibility() != 0 || ecVar.ehE.getVisibility() != 0) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                int i3 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gq2 < 12 || ecVar.ehA.getVisibility() != 0 || ecVar.ehE.getVisibility() != 0) ? i2 : i2 - 1;
                this.ehj = postData.getAuthor().getIconInfo();
                this.cVN = postData.getAuthor().getTShowInfoNew();
                if (ecVar.cdi != null) {
                    if (com.baidu.tbadk.core.util.x.q(this.ehj)) {
                        ecVar.cdi.setVisibility(8);
                    } else {
                        ecVar.cdi.setVisibility(0);
                    }
                    ecVar.cdi.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    ecVar.cdi.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.bWF);
                    ecVar.cdi.xr();
                    ecVar.cdi.a(this.ehj, i3, getDimensionPixelSize(w.f.ds24), getDimensionPixelSize(w.f.ds24), getDimensionPixelSize(w.f.ds10));
                }
                if (ecVar.ams != null) {
                    ecVar.ams.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erJ);
                    if (this.cVN != null && this.cVN.size() > 0 && this.cVN.get(0) != null) {
                        ecVar.ams.setTag(this.cVN.get(0).getUrl());
                    }
                    ecVar.ams.a(this.cVN, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData.getAuthor() == null || postData.getAuthor().getUserTbVipInfoData() == null) {
                userTbVipInfoData = null;
            } else {
                userTbVipInfoData = postData.getAuthor().getUserTbVipInfoData();
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().qB())) {
                ecVar.ehz.setVisibility(4);
                ecVar.enx.setVisibility(8);
                ecVar.ehy.setVisibility(0);
                ecVar.enx.setVisibility(8);
                ecVar.ehy.getHeadView().setUserId(postData.getAuthor().getUserId());
                ecVar.ehy.getHeadView().ad(postData.getAuthor().getUserName(), postData.biy());
                ecVar.ehy.getHeadView().setImageDrawable(null);
                ecVar.ehy.getHeadView().c(portrait, 28, false);
                ecVar.ehy.dU(postData.getAuthor().getPendantData().qB());
                ecVar.ehy.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                ecVar.ehy.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
                ecVar.ehy.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
            } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                if (ecVar.bba != null) {
                    if (ecVar.bbb == null) {
                        ecVar.bba.inflate();
                        ecVar.bbb = (TbImageView) ecVar.getView().findViewById(w.h.user_head_mask);
                    }
                    if (ecVar.bbb != null) {
                        ecVar.bbb.c(userTbVipInfoData.getvipV_url(), 10, false);
                    }
                    ecVar.enx.setIsBigV(true);
                }
                ecVar.ehz.setVisibility(4);
                ecVar.enx.setVisibility(0);
                ecVar.ehy.setVisibility(8);
                ecVar.enx.setData(postData.getAuthor());
                ecVar.enx.setUserId(postData.getAuthor().getUserId());
                ecVar.enx.ad(postData.getAuthor().getUserName(), postData.biy());
            } else {
                ecVar.ehy.setVisibility(8);
                if (f(postData)) {
                    ecVar.ehz.setVisibility(4);
                    ecVar.enx.setVisibility(0);
                    ecVar.enx.c(portrait, 28, false);
                    ecVar.enx.setUserId(postData.getAuthor().getUserId());
                    ecVar.enx.ad(postData.getAuthor().getUserName(), postData.biy());
                    ecVar.enx.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erI);
                } else {
                    ecVar.ehz.setVisibility(0);
                    ecVar.enx.setVisibility(8);
                    ecVar.ehz.setUserId(postData.getAuthor().getUserId());
                    ecVar.ehz.ad(postData.getAuthor().getUserName(), postData.biy());
                    ecVar.ehz.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    ecVar.ehz.setImageDrawable(null);
                    ecVar.ehz.c(portrait, 28, false);
                }
            }
            ecVar.bsf.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            ecVar.bsf.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            ecVar.bsf.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
            ecVar.ehF.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            if (this.cAb) {
                ecVar.ehF.setDefaultImageId(w.g.transparent_bg);
            } else {
                ecVar.ehF.setDefaultImageId(w.g.icon_click);
            }
            ecVar.ehF.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                awl = null;
            } else {
                awl = postData.awl();
            }
            if (this.ehm || !this.ehn) {
                ecVar.ehF.a(awl, false, this.enb);
            } else {
                ecVar.ehF.a(awl, true, this.enb);
            }
            boolean z8 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (this.ehh != null && this.ehh.aJH() != 0) {
                z9 = true;
                z10 = true;
                if (postData != null && postData.getAuthor() != null) {
                    String userId2 = postData.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.ehh != null && this.ehh.aJx() != null && this.ehh.aJx().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.ehh.aJx().getAuthor().getUserId();
                String userId4 = postData.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId4)) {
                        z2 = false;
                        z11 = true;
                    }
                    if (postData == null && postData.getAuthor() != null && UtilHelper.isCurrentAccount(postData.getAuthor().getUserId())) {
                        z3 = true;
                        z4 = true;
                    } else {
                        boolean z12 = z11;
                        z3 = z;
                        z4 = z12;
                    }
                    if (z8) {
                        z5 = z2;
                        z6 = z3;
                    } else {
                        z9 = false;
                        z6 = false;
                        z5 = false;
                    }
                    int i4 = 1;
                    if (postData.bio() == 1) {
                        i4 = 0;
                    }
                    sparseArray4.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray4.put(w.h.tag_should_manage_visible, true);
                        sparseArray4.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ehh.aJH()));
                        sparseArray4.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray4.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray4.put(w.h.tag_user_mute_visible, true);
                        sparseArray4.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray4.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray4.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.ehh.aJx() != null) {
                            sparseArray4.put(w.h.tag_user_mute_thread_id, this.ehh.aJx().getId());
                        }
                        sparseArray4.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray4.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray4.put(w.h.tag_should_delete_visible, true);
                        sparseArray4.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ehh.aJH()));
                        sparseArray4.put(w.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray4.put(w.h.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray4.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray4.put(w.h.tag_should_delete_visible, false);
                    }
                    bix = postData.bix();
                    if (bix.size() > 0 || (postData.bio() == 1 && this.eig.aKq().aNM())) {
                        ecVar.enA.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar2 = bix.get(0);
                        if (!StringUtils.isNull(bVar2.getIconUrl())) {
                            a(ecVar, bVar2.getIconUrl());
                            if (!StringUtils.isNull(bVar2.Cy())) {
                                ecVar.enA.setTag(w.h.tag_pb_lottery_tail_link, bVar2.Cy());
                            }
                        } else {
                            ecVar.enA.setVisibility(8);
                        }
                    }
                    a(ecVar, postData, postData.bio() != 1, awl);
                    d(ecVar);
                }
            }
            z = z10;
            z2 = false;
            if (postData == null) {
            }
            boolean z122 = z11;
            z3 = z;
            z4 = z122;
            if (z8) {
            }
            int i42 = 1;
            if (postData.bio() == 1) {
            }
            sparseArray4.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z9) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            bix = postData.bix();
            if (bix.size() > 0) {
            }
            ecVar.enA.setVisibility(8);
            a(ecVar, postData, postData.bio() != 1, awl);
            d(ecVar);
        }
    }

    private void b(ec ecVar) {
        if (ecVar != null && this.ehh != null && this.ehh.aJO() != null) {
            ecVar.aMA();
            ecVar.enk.setOnClickListener(this.cpI);
            com.baidu.tieba.pb.data.h aJO = this.ehh.aJO();
            ecVar.enp.setSupportNoImage(true);
            ecVar.enp.setInterceptOnClick(true);
            if (this.cAb) {
                ecVar.enp.setDefaultResource(w.g.transparent_bg);
                ecVar.enp.c(aJO.qB(), 17, false);
            } else {
                ecVar.enp.setDefaultResource(w.g.icon_click);
            }
            ecVar.enp.setOnClickListener(this.cpI);
            ecVar.eno.setOnClickListener(this.cpI);
            int aJS = aJO.aJS();
            String aJT = StringUtils.isNull(aJO.aJT(), true) ? "" : aJO.aJT();
            String string = this.mContext.getString(w.l.yule_head_img);
            if (aJS <= 0) {
                ecVar.enn.setVisibility(8);
                ecVar.eno.setVisibility(8);
            } else {
                ecVar.enn.setVisibility(0);
                ecVar.eno.setVisibility(0);
                if (aJS > 20) {
                    string = String.format(this.mContext.getString(w.l.yule_head_img_rank), "20+");
                } else {
                    string = String.format(this.mContext.getString(w.l.yule_head_img_rank), new StringBuilder(String.valueOf(aJS)).toString());
                }
                ecVar.enn.setText(" " + aJT);
            }
            ecVar.enm.setText(string);
            if (aJO.qy()) {
                ecVar.enq.setVisibility(8);
            } else {
                ecVar.enq.setVisibility(0);
                ecVar.enq.setText(String.format(this.mContext.getString(w.l.star_cover_pic_author), aJO.qA()));
            }
            if (StringUtils.isNull(this.ehh.aJx().getAuthor().getName_show(), true)) {
                ecVar.enr.setVisibility(8);
            } else {
                ecVar.enr.setVisibility(0);
                ecVar.enr.setText(String.format(this.mContext.getString(w.l.star_cover_post_author), this.ehh.aJx().getAuthor().getName_show()));
            }
            if (ecVar.ehW.getVisibility() == 0) {
                View findViewById = ecVar.ehv.findViewById(w.h.yule_head_img_blank);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.ehW.getLayoutParams();
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams != null && marginLayoutParams != null && layoutParams.height == getDimensionPixelSize(w.f.ds72)) {
                    layoutParams.height -= marginLayoutParams.topMargin;
                }
            }
            c(ecVar);
        }
    }

    private void c(ec ecVar) {
        if (ecVar.enk != null) {
            com.baidu.tbadk.core.util.aq.k(ecVar.enl, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(ecVar.enm, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(ecVar.enn, w.e.cp_cont_e);
            com.baidu.tbadk.core.util.aq.i(ecVar.eno, w.e.cp_link_tip_a);
            com.baidu.tbadk.core.util.aq.i(ecVar.enq, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(ecVar.enr, w.e.cp_cont_i);
        }
    }

    private void a(ec ecVar, String str) {
        ecVar.enA.setVisibility(0);
        com.baidu.adp.lib.f.c.fL().a(str, 17, new eb(this, ecVar, str), this.eig.getUniqueId());
    }

    private void d(ec ecVar) {
        ecVar.ehF.setTextViewOnTouchListener(this.ehl);
        ecVar.ehF.setTextViewCheckSelection(false);
    }

    private void a(ec ecVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aPb() == null) {
            ecVar.eib.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aPb(), ecVar.eib, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1160=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int af = (((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i = 0;
        if (!z) {
            i = getDimensionPixelSize(w.f.ds132);
        } else if (z2) {
            i = getDimensionPixelSize(w.f.ds64);
        }
        int min = Math.min(af - i, this.ehf);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private boolean f(PostData postData) {
        return (postData == null || postData.getAuthor() == null || postData.getAuthor().getGodUserData() == null || postData.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void e(ec ecVar) {
        ecVar.ehv.setOnTouchListener(this.ehl);
        ecVar.ehv.setOnLongClickListener(this.atl);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT;
        ecVar.bsf.setOnClickListener(aVar.erI);
        ecVar.ehz.setOnClickListener(aVar.erI);
        ecVar.ehy.setOnClickListener(aVar.erI);
        ecVar.ehJ.setOnLongClickListener(this.atl);
        ecVar.ehF.setOnLongClickListener(this.atl);
        ecVar.ehJ.setOnTouchListener(this.ehl);
        ecVar.ehF.setOnTouchListener(this.ehl);
        ecVar.ehF.setCommonTextViewOnClickListener(this.cpI);
        ecVar.ehF.setOnImageClickListener(this.aNK);
        ecVar.ehF.setOnEmotionClickListener(aVar.erK);
        ecVar.cdi.setOnClickListener(aVar.bWF);
        ecVar.ams.setOnClickListener(aVar.erJ);
        ecVar.eib.setOnClickListener(this.cpI);
        ecVar.enA.setOnClickListener(this.cpI);
        ecVar.ens.setOnClickListener(this.cpI);
        ecVar.ent.setOnClickListener(this.cpI);
        ecVar.enu.setOnClickListener(this.cpI);
        ecVar.env.setOnClickListener(this.cpI);
        ecVar.enw.setOnClickListener(this.cpI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ehh = fVar;
    }

    public void oa(int i) {
        this.ehf = i;
    }

    public void ia(boolean z) {
        this.cAb = z;
    }

    public void ib(boolean z) {
        this.ehg = z;
    }

    public void ic(boolean z) {
        this.ekF = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ehk = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cpI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNK = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ehl = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atl = onLongClickListener;
    }

    public void ig(boolean z) {
        this.eiH = z;
    }

    public void a(TbRichTextView.b bVar) {
        this.enb = bVar;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.eig.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
