package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.du;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.pb.view.aa;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends du<PostData, l> implements View.OnClickListener {
    private TbRichTextView.e aPr;
    private com.baidu.tieba.pb.a.d aPs;
    private View.OnLongClickListener aue;
    private View.OnClickListener cDj;
    private ArrayList<IconData> dfE;
    private int esX;
    private boolean esY;
    private boolean esZ;
    private com.baidu.tieba.pb.data.f eta;
    private ba etb;
    private ArrayList<IconData> etd;
    private View.OnClickListener ete;
    private boolean etf;
    private final boolean etg;
    private int eth;
    private int eti;
    private com.baidu.tieba.vote.a etj;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.esX = 0;
        this.esY = true;
        this.esZ = true;
        this.eta = null;
        this.mHostId = null;
        this.etb = null;
        this.etd = null;
        this.dfE = null;
        this.ete = null;
        this.cDj = null;
        this.aPr = null;
        this.aPs = null;
        this.aue = null;
        this.etf = false;
        this.etg = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                as.c(lVar.etI, w.e.common_color_10005, 1);
                as.c(lVar.etK, w.e.cp_link_tip_c, 3);
                as.c(lVar.bBa, w.e.cp_cont_f, 1);
                as.c((View) lVar.ett, w.e.cp_cont_i, 1);
                as.c((View) lVar.etu, w.e.cp_cont_i, 1);
                as.c(lVar.etv, w.e.cp_cont_d, 1);
                as.c(lVar.etw, w.e.cp_cont_d, 1);
                as.k(lVar.etz, w.e.cp_bg_line_e);
                as.k(lVar.etA, w.e.cp_bg_line_e);
                as.c(lVar.etA, w.e.cp_bg_line_b);
                as.k(lVar.etD, w.e.cp_bg_line_c);
            }
            lVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.eth = getDimensionPixelSize(w.f.ds30);
        this.eti = com.baidu.adp.lib.util.k.af(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.esY, this.esX, false);
        a(lVar);
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, lVar);
        a(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sp();
            a(lVar, postData2, view, i);
        }
        if (!this.etf && this.etg && lVar != null && lVar.ety.II() && (listView = ((PbActivity) this.euf.getPageContext().getOrignalPage()).getListView()) != null) {
            this.etf = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x062c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0981  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x098d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(l lVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (lVar != null && postData != null) {
            as.k(lVar.etG, w.e.cp_bg_line_b);
            lVar.ets.setTag(null);
            lVar.ets.setUserId(null);
            lVar.bBa.setText((CharSequence) null);
            lVar.etu.setVisibility(8);
            lVar.etD.setVisibility(0);
            lVar.etx.setVisibility(8);
            SparseArray sparseArray = (SparseArray) lVar.etC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                lVar.etC.setTag(sparseArray);
                lVar.ety.setTag(sparseArray);
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(lVar.ety, getDimensionPixelSize(w.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.esY || g(postData)) {
                sparseArray.put(w.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.ety.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                lVar.ety.setLayoutParams(layoutParams);
                lVar.ety.setPadding(0, 0, 0, 0);
                lVar.ety.gP(null);
            } else {
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                lVar.ety.gP(postData.getBimg_url());
                if (postData.bmu() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.ety.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds40);
                    lVar.ety.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) lVar.ety.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(w.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(w.f.ds20);
                    lVar.ety.setLayoutParams(layoutParams3);
                }
            }
            lVar.etw.setText(aw.q(postData.getTime()));
            lVar.etB.setVisibility(8);
            if (postData.bmu() == 1) {
                as.k(lVar.eto, w.e.cp_bg_line_d);
                lVar.etp.setVisibility(8);
                lVar.etG.setVisibility(8);
                lVar.etC.setVisibility(8);
                lVar.etw.setVisibility(8);
                lVar.etB.setVisibility(0);
                lVar.etE.setVisibility(8);
                lVar.etF.setVisibility(8);
                lVar.etV.setVisibility(8);
                lVar.etP.setVisibility(8);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                lVar.etB.a(postData.bmB(), str, j, com.baidu.adp.lib.g.b.c(this.eta.aMv().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                lVar.etB.onChangeSkinType();
                if (this.esZ) {
                    PraiseData rh = this.eta.aMv().rh();
                    if (rh != null && rh.getUser() != null && rh.getUser().size() > 0) {
                        lVar.etz.setVisibility(0);
                        lVar.etA.setVisibility(0);
                        lVar.etz.setIsFromPb(true);
                        lVar.etz.a(rh, this.eta.aMv().getId(), rh.getPostId(), true);
                        lVar.etz.dp(this.mSkinType);
                    } else {
                        lVar.etz.setVisibility(8);
                        lVar.etA.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.al(lVar.etz);
                    com.baidu.tieba.graffiti.c.al(lVar.etA);
                } else {
                    lVar.etz.setVisibility(8);
                    lVar.etA.setVisibility(8);
                }
                a(lVar.ety, getDimensionPixelSize(w.f.ds30));
                if (!this.euf.aOi()) {
                    if (this.eta.aMQ() != null && this.eta.aMQ().size() <= 4) {
                        lVar.eua.setVisibility(0);
                        List<bf> aMQ = this.eta.aMQ();
                        for (int i2 = 0; i2 < aMQ.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, lVar.etW, aMQ);
                            } else if (i2 == 1) {
                                a(i2, lVar.etX, aMQ);
                            } else if (i2 == 2) {
                                a(i2, lVar.etY, aMQ);
                            } else if (i2 == 3) {
                                a(i2, lVar.etZ, aMQ);
                            }
                        }
                    }
                } else {
                    lVar.eua.setVisibility(8);
                }
            } else {
                lVar.eua.setVisibility(8);
                lVar.etG.setVisibility(0);
                as.k(lVar.eto, w.e.cp_bg_line_e);
                lVar.etp.setVisibility(0);
                com.baidu.tbadk.data.g bmx = postData.bmx();
                lVar.etP.setVisibility(8);
                if (bmx != null && !TextUtils.isEmpty(bmx.getName()) && !TextUtils.isEmpty(bmx.getName().trim())) {
                    String name = bmx.getName();
                    String lat = bmx.getLat();
                    String lng = bmx.getLng();
                    lVar.etT.setText(bmx.getName());
                    as.c(lVar.etT, w.e.cp_cont_c, 1);
                    lVar.etT.setOnClickListener(new j(this, lat, lng, name));
                } else {
                    lVar.etT.setVisibility(8);
                }
                lVar.etz.setVisibility(8);
                lVar.etA.setVisibility(8);
                lVar.etC.setVisibility(0);
                lVar.etw.setVisibility(0);
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bmu()));
                lVar.etv.setVisibility(0);
                lVar.etv.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                lVar.etx.setVisibility(0);
                as.i(lVar.etx, w.e.cp_link_tip_a);
            } else {
                lVar.etx.setVisibility(8);
            }
            as.j(lVar.etq, w.g.bg_floor_new_middle);
            lVar.ety.setVideoImageId(w.g.pic_video);
            lVar.ety.setTextColor(as.getColor(w.e.common_color_10039));
            lVar.ety.setLinkTextColor(as.getColor(w.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bmu()));
            if (postData.bmy() > 0) {
                if (this.etb == null) {
                    this.etb = new ba(this.mContext);
                    this.etb.setIsFromCDN(this.mIsFromCDN);
                    this.etb.K(this.ete);
                    boolean z6 = false;
                    String userId2 = this.eta.aMv().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.etb.A(this.eta.aMG(), z6);
                    this.etb.O(this.eta.aMv());
                }
                this.etb.pe(postData.getId());
                lVar.etD.setVisibility(0);
                lVar.etD.a(postData, view);
                lVar.etD.setChildOnClickListener(this.cDj);
                lVar.etD.setChildOnLongClickListener(this.aue);
                lVar.etD.setChildOnTouchListener(this.aPs);
                lVar.etD.setSubPbAdapter(this.etb);
                lVar.etD.setVisibility(0);
                lVar.etF.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds24));
                lVar.etV.setVisibility(0);
            } else {
                lVar.etF.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
                lVar.etD.setVisibility(8);
                lVar.etV.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = y.gI(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gI = y.gI(name_show);
                if (i3 > 0) {
                    if (gI > 12) {
                        name_show = String.valueOf(y.d(name_show, 0, 14)) + "...";
                    }
                } else if (gI > 14) {
                    name_show = String.valueOf(y.d(name_show, 0, 14)) + "...";
                }
                if (i3 > 0) {
                    lVar.bBa.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    lVar.bBa.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    as.c(lVar.bBa, w.e.cp_cont_h, 1);
                } else {
                    as.c(lVar.bBa, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    lVar.ett.setVisibility(0);
                    as.c(lVar.ett, BitmapHelper.getGradeResourceIdNew(level_id));
                    lVar.ett.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id)));
                    lVar.ett.setOnClickListener(null);
                } else {
                    lVar.ett.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        as.c(lVar.etu, w.g.pb_manager);
                        lVar.ett.setVisibility(8);
                        lVar.etu.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        as.c(lVar.etu, w.g.pb_assist);
                        lVar.ett.setVisibility(8);
                        lVar.etu.setVisibility(0);
                    }
                }
                int gI2 = y.gI(postData.getAuthor().getName_show());
                if (gI2 >= 14 && lVar.ett.getVisibility() == 0 && lVar.etx.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gI2 < 12 || lVar.ett.getVisibility() != 0 || lVar.etx.getVisibility() != 0) ? i4 : i4 - 1;
                this.etd = postData.getAuthor().getIconInfo();
                this.dfE = postData.getAuthor().getTShowInfoNew();
                if (lVar.cqK != null) {
                    lVar.cqK.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    lVar.cqK.setOnClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.clh);
                    lVar.cqK.a(this.etd, i5, getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds10));
                }
                if (lVar.ani != null) {
                    lVar.ani.setOnClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.eFX);
                    lVar.ani.a(this.dfE, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds32), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pI())) {
                lVar.ets.setVisibility(4);
                lVar.etr.setVisibility(0);
                lVar.etr.ek(postData.getAuthor().getPendantData().pI());
                lVar.etr.getHeadView().c(portrait, 28, false);
                lVar.etr.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                lVar.etr.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                lVar.ets.setVisibility(0);
                lVar.etr.setVisibility(8);
                lVar.ets.setUserId(postData.getAuthor().getUserId());
                lVar.ets.setUserName(postData.getAuthor().getUserName());
                lVar.ets.setImageDrawable(null);
                lVar.ets.c(portrait, 28, false);
            }
            lVar.bBa.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            lVar.bBa.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            lVar.ety.setLinkTextColor(as.getColor(w.e.cp_link_tip_c));
            if (this.esY) {
                lVar.ety.setDefaultImageId(w.g.transparent_bg);
            } else {
                lVar.ety.setDefaultImageId(w.g.icon_click);
            }
            lVar.ety.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.azb();
            }
            if (this.etf || !this.etg) {
                lVar.ety.a(tbRichText, false);
            } else {
                lVar.ety.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eta.aMG() != 0) {
                z7 = true;
                z8 = true;
                String userId3 = postData.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z7 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z7 = false;
                }
            }
            if (this.eta != null && this.eta.aMv() != null && this.eta.aMv().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eta.aMv().getAuthor().getUserId();
                String userId5 = postData.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        z4 = z2;
                        z5 = z3;
                    }
                    if (!z7) {
                        if (lVar.etK != null) {
                            lVar.etK.setVisibility(0);
                            lVar.etK.setText(w.l.manage);
                            lVar.etK.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (lVar.etK != null) {
                            lVar.etK.setVisibility(0);
                            lVar.etK.setText(w.l.delete);
                            lVar.etK.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (lVar.etK != null) {
                        lVar.etK.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.bmu() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eta.aMG()));
                        sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray2.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(w.h.tag_user_mute_visible, true);
                        sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eta.aMv() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.eta.aMv().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eta.aMG()));
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    a(lVar, postData, postData.bmu() != 1, tbRichText);
                    b(lVar);
                    a(view, postData);
                    if (this.etj == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.etj.bqH();
                        return;
                    }
                    return;
                }
            }
            z = false;
            z2 = z8;
            z3 = false;
            userId = postData.getAuthor().getUserId();
            if (userId == null) {
            }
            z4 = z2;
            z5 = z3;
            if (!z7) {
            }
            int i62 = 1;
            if (postData.bmu() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(lVar, postData, postData.bmu() != 1, tbRichText);
            b(lVar);
            a(view, postData);
            if (this.etj == null) {
            }
        }
    }

    private void b(l lVar) {
        lVar.ety.setTextViewOnTouchListener(this.aPs);
        lVar.ety.setTextViewCheckSelection(false);
    }

    private void a(l lVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aSA() == null || g(postData)) {
            lVar.etU.setVisibility(8);
        } else {
            aa.a(postData.aSA(), lVar.etU, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eti - (i - this.eth));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean g(PostData postData) {
        return (this.eta == null || this.eta.aMv() == null || !this.eta.aMv().sd() || this.eta.aMv().rg() == null || postData.bmu() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (g(postData) && view != null && this.euf != null) {
            if (this.etj == null) {
                this.etj = new com.baidu.tieba.vote.a(this.euf);
            }
            this.etj.a(view, this.eta);
        } else if (this.etj != null) {
            this.etj.setVisibility(8);
        }
    }

    private void c(l lVar) {
        lVar.bBa.setOnClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.eFW);
        lVar.ets.setOnClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.eFW);
        lVar.etr.setOnClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.eFW);
        lVar.etC.setOnLongClickListener(this.aue);
        lVar.ety.setOnLongClickListener(this.aue);
        lVar.etC.setOnTouchListener(this.aPs);
        lVar.ety.setOnTouchListener(this.aPs);
        lVar.ety.setOnImageClickListener(this.aPr);
        lVar.ety.setOnEmotionClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.eFY);
        lVar.cqK.setOnClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.clh);
        lVar.ani.setOnClickListener(((PbActivity) this.euf.getPageContext().getOrignalPage()).euV.eFX);
        lVar.etU.setOnClickListener(this.cDj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eta = fVar;
    }

    public void oF(int i) {
        this.esX = i;
    }

    public void iv(boolean z) {
        this.esY = z;
    }

    public void iw(boolean z) {
        this.esZ = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void I(View.OnClickListener onClickListener) {
        this.ete = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cDj = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aPr = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aue = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return at.a((Context) this.euf.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<bf> list) {
        if (textView != null) {
            bf bfVar = (bf) z.c(list, i);
            if (bfVar == null) {
                textView.setVisibility(8);
                return;
            }
            String forumName = bfVar.getForumName();
            String forumId = bfVar.getForumId();
            textView.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new k(this, forumName, forumId));
        }
    }

    public void oG(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.euf.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
