package com.baidu.tieba.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.pb.sub.SubPbLayout;
import com.baidu.tieba.view.BaobaoTailView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class bh extends BaseAdapter {
    private final CustomMessageListener aBn;
    private PbActivity bvI;
    private final boolean bvT;
    private com.baidu.tieba.data.ah bvH = null;
    private boolean bvJ = true;
    private boolean bvK = true;
    private boolean bvL = true;
    private int bvM = 0;
    private String bvN = null;
    private View.OnClickListener aEP = null;
    private com.baidu.tbadk.widget.richText.s ack = null;
    private com.baidu.tieba.pb.sub.a bvO = null;
    private View.OnLongClickListener NY = null;
    private com.baidu.tieba.c.d bvP = null;
    private View.OnClickListener bvQ = null;
    private int width = -1;
    private int RH = 0;
    private ArrayList<IconData> bvR = null;
    private ArrayList<IconData> ayZ = null;
    private boolean mIsFromCDN = false;
    private boolean bvS = false;

    public bh(PbActivity pbActivity) {
        boolean z = true;
        this.bvI = null;
        this.bvT = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.aBn = new bi(this, 2001122);
        this.bvI = pbActivity;
        init();
    }

    private void init() {
        this.bvM = Math.min(com.baidu.adp.lib.util.m.dip2px(this.bvI, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.RH = TbadkApplication.m251getInst().getSkinType();
        if (this.bvI instanceof BaseActivity) {
            this.bvI.registerListener(this.aBn);
        }
    }

    public void b(com.baidu.tieba.data.ah ahVar) {
        boolean z;
        if (this.bvH != ahVar) {
            z = true;
            if (ahVar != null && !ahVar.zK()) {
                z = false;
            }
        } else {
            z = false;
        }
        this.bvH = ahVar;
        if (z) {
            WD();
            if (ahVar != null) {
                ahVar.br(false);
            }
        }
        if (ahVar != null && ahVar.zM() != null && ahVar.zM().getAuthor() != null) {
            this.bvN = ahVar.zM().getAuthor().getUserId();
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.bvQ = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aEP = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.NY = onLongClickListener;
    }

    public View.OnLongClickListener WA() {
        return this.NY;
    }

    public void a(com.baidu.tieba.c.d dVar) {
        this.bvP = dVar;
    }

    public void dW(boolean z) {
        this.bvL = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bvH == null || this.bvH.zN() == null || this.bvH.zN().size() < 1) {
            return 0;
        }
        com.baidu.tieba.data.ak akVar = this.bvH.zN().get(this.bvH.zN().size() - 1);
        if (!this.bvL && akVar.Ag() == 1) {
            return this.bvH.zN().size() - 1;
        }
        return this.bvH.zN().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bvH == null || this.bvH.zN() == null || i < 0 || i >= this.bvH.zN().size()) {
            return null;
        }
        return this.bvH.zN().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void dX(boolean z) {
        this.bvJ = z;
    }

    public void dY(boolean z) {
        this.bvK = z;
    }

    public boolean WB() {
        return this.bvJ;
    }

    public boolean WC() {
        return this.bvK;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return c(view, viewGroup, i);
        }
        if (itemViewType == 1) {
            return a(view, viewGroup, i);
        }
        if (itemViewType == 2) {
            return b(view, viewGroup, i);
        }
        return null;
    }

    private View a(View view, ViewGroup viewGroup, int i) {
        com.baidu.tieba.d.c.a aVar;
        this.RH = TbadkApplication.m251getInst().getSkinType();
        com.baidu.tieba.d.a.f fVar = (com.baidu.tieba.d.a.f) getItem(i);
        if (view == null) {
            aVar = com.baidu.tieba.d.a.abm().ah(this.bvI);
            view = aVar.getRootView();
        } else {
            aVar = (com.baidu.tieba.d.c.a) view.getTag();
        }
        this.bvI.getLayoutMode().L(this.RH == 1);
        this.bvI.getLayoutMode().h(view);
        aVar.a(fVar, i, this.mIsFromCDN);
        return view;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        com.baidu.tieba.d.c.a aVar;
        this.RH = TbadkApplication.m251getInst().getSkinType();
        com.baidu.tieba.d.a.f fVar = (com.baidu.tieba.d.a.f) getItem(i);
        if (view == null) {
            aVar = com.baidu.tieba.d.a.abm().ag(this.bvI);
            view = aVar.getRootView();
        } else {
            aVar = (com.baidu.tieba.d.c.a) view.getTag();
        }
        this.bvI.getLayoutMode().L(this.RH == 1);
        this.bvI.getLayoutMode().h(view);
        aVar.a(fVar, i, this.mIsFromCDN);
        return view;
    }

    private View c(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView listView;
        this.RH = TbadkApplication.m251getInst().getSkinType();
        View a = view == null ? a(viewGroup, false) : view;
        bl blVar = (bl) a.getTag();
        com.baidu.tieba.data.ak akVar = (com.baidu.tieba.data.ak) getItem(i);
        PbActivity pbActivity = this.bvI;
        com.baidu.tbadk.core.util.aw.i(blVar.bvY, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.aw.i(blVar.bvZ, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.aw.b(blVar.bws, com.baidu.tieba.s.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bwu, com.baidu.tieba.s.common_link_text, 3);
        com.baidu.tbadk.core.util.aw.b(blVar.aEq, com.baidu.tieba.s.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bwc, com.baidu.tieba.s.cp_cont_i, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bwe, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bwf, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aw.c(blVar.bwh, com.baidu.tieba.u.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.aw.i(blVar.bwj, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.aw.i(blVar.bwk, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.aw.i(blVar.bwl, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.aw.c(blVar.bwl, com.baidu.tieba.s.cp_bg_line_b);
        imageView = blVar.bwo;
        com.baidu.tbadk.core.util.aw.c(imageView, com.baidu.tieba.s.cp_bg_line_b);
        if (akVar != null) {
            a(blVar, akVar, a, false, i);
        }
        if (!this.bvS && this.bvT && blVar != null && blVar.bwi.vV() && (listView = pbActivity.getListView()) != null) {
            this.bvS = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return a;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bl blVar = new bl(this, null);
        View a = com.baidu.adp.lib.g.b.ek().a(this.bvI, com.baidu.tieba.w.new_pb_list_item, viewGroup, false);
        blVar.bwa = a.findViewById(com.baidu.tieba.v.sub_pb_more);
        blVar.bwb = (HeadImageView) a.findViewById(com.baidu.tieba.v.photo);
        blVar.aEq = (TextView) a.findViewById(com.baidu.tieba.v.user_name);
        blVar.bwc = (TextView) a.findViewById(com.baidu.tieba.v.user_rank);
        blVar.bwd = (ImageView) a.findViewById(com.baidu.tieba.v.user_gender);
        blVar.bwh = (ImageView) a.findViewById(com.baidu.tieba.v.reply);
        blVar.bwi = (TbRichTextView) a.findViewById(com.baidu.tieba.v.richText);
        blVar.bwj = a.findViewById(com.baidu.tieba.v.pb_item_praise_topline);
        blVar.bwk = (FrsPraiseView) a.findViewById(com.baidu.tieba.v.pb_item_praise_view);
        blVar.bwl = (ImageView) a.findViewById(com.baidu.tieba.v.pb_item_praise_bottomline);
        blVar.bwz = (LinearLayout) a.findViewById(com.baidu.tieba.v.pb_item_location_container);
        blVar.bwB = (TextView) a.findViewById(com.baidu.tieba.v.pb_item_location_address);
        blVar.bwA = (ImageView) a.findViewById(com.baidu.tieba.v.pb_item_location_img);
        blVar.bwC = (LinearLayout) a.findViewById(com.baidu.tieba.v.pb_reply_location_container);
        blVar.bwE = (TextView) a.findViewById(com.baidu.tieba.v.pb_reply_location_address);
        blVar.bwD = (ImageView) a.findViewById(com.baidu.tieba.v.pb_reply_location_img);
        blVar.bwg = (ImageView) a.findViewById(com.baidu.tieba.v.floor_owner);
        blVar.bwe = (TextView) a.findViewById(com.baidu.tieba.v.floor);
        blVar.bwf = (TextView) a.findViewById(com.baidu.tieba.v.time);
        blVar.bwm = (RelativeLayout) a.findViewById(com.baidu.tieba.v.pb_post_header_layout);
        blVar.bwp = (SubPbLayout) a.findViewById(com.baidu.tieba.v.pb_post_footer_layout);
        blVar.bwn = (LinearLayout) a.findViewById(com.baidu.tieba.v.pb_subpb_layout_root);
        blVar.bwo = (ImageView) a.findViewById(com.baidu.tieba.v.pb_post_footer_layout_line_top);
        blVar.aEq.setOnClickListener(this.bvI.bva.bzi);
        blVar.bwh.setOnClickListener(this.aEP);
        blVar.bwb.setOnClickListener(this.bvI.bva.bzi);
        blVar.bvX = a;
        blVar.bvY = a.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top);
        blVar.bvZ = a.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top_full);
        blVar.bwm.setOnLongClickListener(this.NY);
        blVar.bwi.setOnLongClickListener(this.NY);
        if (this.width < 0) {
            this.width = (((com.baidu.adp.lib.util.m.n(this.bvI) - a.getPaddingLeft()) - a.getPaddingRight()) - blVar.bwi.getPaddingLeft()) - blVar.bwi.getPaddingRight();
        }
        blVar.bwm.setOnTouchListener(this.bvP);
        blVar.bwi.setOnTouchListener(this.bvP);
        this.width = this.bvM > this.width ? this.width : this.bvM;
        int dimension = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds104);
        if (this.width > dimension) {
            blVar.bwi.setMaxImageWidth(this.width - dimension);
        } else {
            blVar.bwi.setMaxImageWidth(this.width);
        }
        blVar.bwi.setMaxImageHeight((int) (this.width * 1.618f));
        blVar.bwi.setTextSize(TbConfig.getContentSize());
        if (!this.bvK) {
            ViewGroup.LayoutParams layoutParams = blVar.bwb.getLayoutParams();
            layoutParams.width = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds30);
            blVar.bwb.setLayoutParams(layoutParams);
            blVar.bwb.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = blVar.bwb.getLayoutParams();
            layoutParams2.width = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds60);
            blVar.bwb.setLayoutParams(layoutParams2);
            blVar.bwb.setVisibility(0);
        }
        blVar.bwi.b(this.bvJ, false);
        blVar.bwi.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
        blVar.bwi.setOnImageClickListener(this.ack);
        blVar.bwi.setOnEmotionClickListener(this.bvI.bva.bzl);
        blVar.aSO = (UserIconBox) a.findViewById(com.baidu.tieba.v.user_icon_box);
        blVar.aSO.setOnClickListener(this.bvI.bva.bzj);
        blVar.azs = (UserIconBox) a.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        blVar.azs.setOnClickListener(this.bvI.bva.bzk);
        blVar.bwr = (LinearLayout) a.findViewById(com.baidu.tieba.v.add_post_footer_layout);
        a.setTag(blVar);
        if (z) {
            blVar.bwm.setVisibility(8);
            blVar.bwh.setVisibility(8);
            blVar.bwi.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) blVar.bwi.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            blVar.bwi.setLayoutParams(layoutParams3);
            a.findViewById(com.baidu.tieba.v.pb_list_item_layout).setPadding(0, 0, 0, 0);
            blVar.bwt = (LinearLayout) a.findViewById(com.baidu.tieba.v.add_time_container);
            blVar.bws = (TextView) a.findViewById(com.baidu.tieba.v.add_time);
            blVar.bwu = (Button) a.findViewById(com.baidu.tieba.v.manage_btn);
            blVar.bwt.setVisibility(0);
        }
        blVar.bwv = (LinearLayout) a.findViewById(com.baidu.tieba.v.addition_more_container);
        blVar.bww = (TextView) blVar.bwv.findViewById(com.baidu.tieba.v.addition_more);
        blVar.bwx = blVar.bwv.findViewById(com.baidu.tieba.v.addition_divider1);
        blVar.bwy = blVar.bwv.findViewById(com.baidu.tieba.v.addition_divider2);
        blVar.bwq = (BaobaoTailView) a.findViewById(com.baidu.tieba.v.baobao_tail);
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0482 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x085c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0889  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x08a2  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x08be  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bl blVar, com.baidu.tieba.data.ak akVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        ImageView imageView;
        LinearLayout linearLayout;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ImageView imageView2;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        if (blVar != null && akVar != null) {
            if (!z) {
                blVar.bwb.setTag(null);
                blVar.bwb.setUserId(null);
                blVar.aEq.setText((CharSequence) null);
                blVar.bwc.setText((CharSequence) null);
                blVar.bwc.setBackgroundDrawable(null);
                blVar.bwp.setVisibility(0);
                blVar.bwh.setVisibility(0);
                blVar.bwg.setVisibility(8);
                if (akVar.Ai() == null) {
                    blVar.bwq.setVisibility(8);
                } else if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && akVar.Ai().ys() == 1) {
                    blVar.bwq.changeSkinType(this.RH);
                    blVar.bwq.setVisibility(0);
                    blVar.bwq.setData(akVar.Ai());
                } else {
                    blVar.bwq.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) blVar.bwm.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    blVar.bwm.setTag(sparseArray2);
                    blVar.bwi.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.v.tag_clip_board, akVar);
                sparseArray2.put(com.baidu.tieba.v.tag_is_subpb, false);
                if (TextUtils.isEmpty(akVar.getBimg_url()) || !this.bvJ) {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar.bwi.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    blVar.bwi.setLayoutParams(layoutParams);
                    blVar.bwi.setPadding(0, 0, 0, 0);
                    blVar.bwi.dS(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, akVar.getBimg_url());
                    blVar.bwi.dS(akVar.getBimg_url());
                    if (akVar.Ag() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) blVar.bwi.getLayoutParams();
                        layoutParams2.topMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds16);
                        layoutParams2.bottomMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds40);
                        blVar.bwi.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) blVar.bwi.getLayoutParams();
                        layoutParams3.topMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds20);
                        layoutParams3.bottomMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds20);
                        blVar.bwi.setLayoutParams(layoutParams3);
                    }
                }
                blVar.bwf.setText(com.baidu.tbadk.core.util.az.j(akVar.getTime()));
                if (akVar.Ag() == 1) {
                    com.baidu.tbadk.core.util.aw.i(blVar.bvX, com.baidu.tieba.s.cp_bg_line_d);
                    blVar.bvY.setVisibility(8);
                    blVar.bvZ.setVisibility(8);
                    blVar.bwm.setVisibility(8);
                    blVar.bwf.setVisibility(8);
                    if (this.bvL) {
                        PraiseData praise = this.bvH.zM().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            blVar.bwk.setVisibility(0);
                            blVar.bwj.setVisibility(0);
                            blVar.bwl.setVisibility(0);
                            blVar.bwk.setIsFromPb(true);
                            blVar.bwk.a(praise, this.bvH.zM().getId(), praise.getPostId(), true);
                            blVar.bwk.bN(this.RH);
                        } else {
                            blVar.bwk.setVisibility(8);
                            blVar.bwj.setVisibility(8);
                            blVar.bwl.setVisibility(8);
                        }
                        com.baidu.tieba.data.ab Aj = akVar.Aj();
                        blVar.bwC.setVisibility(8);
                        if (Aj != null && !TextUtils.isEmpty(Aj.getName()) && !TextUtils.isEmpty(Aj.getName().trim())) {
                            blVar.bwz.setVisibility(0);
                            blVar.bwB.setText(Aj.getName());
                            com.baidu.tbadk.core.util.aw.b(blVar.bwB, com.baidu.tieba.s.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.aw.c(blVar.bwA, com.baidu.tieba.u.icon_posts_pin_gray);
                        } else {
                            blVar.bwz.setVisibility(8);
                        }
                    } else {
                        blVar.bwk.setVisibility(8);
                        blVar.bwj.setVisibility(8);
                        blVar.bwl.setVisibility(8);
                        blVar.bwz.setVisibility(8);
                        blVar.bwC.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) blVar.bwi.getLayoutParams()).leftMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds30);
                    ((LinearLayout.LayoutParams) blVar.bwq.getLayoutParams()).leftMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds30);
                } else {
                    com.baidu.tbadk.core.util.aw.i(blVar.bvX, com.baidu.tieba.s.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bvL) {
                            blVar.bvY.setVisibility(8);
                            blVar.bvZ.setVisibility(8);
                            PraiseData praise2 = this.bvH.zM().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                blVar.bvZ.setVisibility(8);
                                blVar.bvY.setVisibility(0);
                            } else {
                                blVar.bvZ.setVisibility(0);
                                blVar.bvY.setVisibility(8);
                            }
                        } else {
                            blVar.bvY.setVisibility(0);
                            blVar.bvZ.setVisibility(8);
                        }
                    } else {
                        blVar.bvY.setVisibility(0);
                        blVar.bvZ.setVisibility(8);
                    }
                    com.baidu.tieba.data.ab Aj2 = akVar.Aj();
                    blVar.bwz.setVisibility(8);
                    if (Aj2 != null && !TextUtils.isEmpty(Aj2.getName()) && !TextUtils.isEmpty(Aj2.getName().trim())) {
                        blVar.bwC.setVisibility(0);
                        blVar.bwE.setText(Aj2.getName());
                        com.baidu.tbadk.core.util.aw.b(blVar.bwE, com.baidu.tieba.s.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.aw.c(blVar.bwD, com.baidu.tieba.u.icon_pb_site);
                    } else {
                        blVar.bwC.setVisibility(8);
                    }
                    blVar.bwk.setVisibility(8);
                    blVar.bwj.setVisibility(8);
                    blVar.bwl.setVisibility(8);
                    blVar.bwm.setVisibility(0);
                    blVar.bwf.setVisibility(0);
                    String format = String.format(this.bvI.getString(com.baidu.tieba.y.is_floor), Integer.valueOf(akVar.Ag()));
                    blVar.bwe.setVisibility(0);
                    blVar.bwe.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) blVar.bwi.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) blVar.bwq.getLayoutParams();
                    if (!this.bvK) {
                        layoutParams4.leftMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds74);
                        layoutParams5.leftMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds104);
                        layoutParams5.leftMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds104);
                    }
                    linearLayout3 = blVar.bwn;
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.bvK) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds30);
                    }
                }
                if (this.bvN != null && !this.bvN.equals("0") && this.bvN.equals(akVar.getAuthor().getUserId())) {
                    blVar.bwg.setVisibility(0);
                    com.baidu.tbadk.core.util.aw.c(blVar.bwg, com.baidu.tieba.u.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.aw.h(blVar.bwa, com.baidu.tieba.u.bg_floor_new_middle);
            blVar.bwi.setVideoImageId(com.baidu.tieba.u.pic_video);
            blVar.bwi.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.pb_listitem_content));
            com.baidu.tbadk.core.util.aw.c(blVar.bwh, com.baidu.tieba.u.btn_pb_reply_selector);
            blVar.bwi.setLinkTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.common_link_text));
            SparseArray sparseArray3 = (SparseArray) blVar.bwh.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                blVar.bwh.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, akVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_data, akVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_view, view);
            if (akVar.Ak() > 0) {
                if (this.bvO == null) {
                    this.bvO = new com.baidu.tieba.pb.sub.a(this.bvI, this.bvI.bva.bzi);
                    this.bvO.setIsFromCDN(this.mIsFromCDN);
                    this.bvO.u(this.bvQ);
                    boolean z7 = false;
                    String userId = this.bvH.zM().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bvO.t(this.bvH.zS(), z7);
                    this.bvO.dY(this.bvK);
                }
                blVar.bwp.setVisibility(0);
                imageView2 = blVar.bwo;
                imageView2.setVisibility(0);
                linearLayout2 = blVar.bwn;
                linearLayout2.setVisibility(0);
                blVar.bwp.a(akVar, view);
                blVar.bwp.setChildOnClickListener(this.aEP);
                blVar.bwp.setChildOnLongClickListener(this.NY);
                blVar.bwp.setChildOnTouchListener(this.bvP);
                blVar.bwp.setSubPbAdapter(this.bvO);
                blVar.bwp.setVisibility(0);
            } else {
                blVar.bwp.setVisibility(8);
                imageView = blVar.bwo;
                imageView.setVisibility(8);
                linearLayout = blVar.bwn;
                linearLayout.setVisibility(8);
            }
            a(blVar, akVar, this.bvH.zT(), i);
            if (!z) {
                String portrait = akVar.getAuthor().getPortrait();
                if (akVar.getAuthor() != null) {
                    blVar.aEq.setText(akVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = akVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.aw.b(blVar.aEq, com.baidu.tieba.s.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aw.b(blVar.aEq, com.baidu.tieba.s.cp_cont_f, 1);
                    }
                    int level_id = akVar.getAuthor().getLevel_id();
                    int is_bawu = akVar.getAuthor().getIs_bawu();
                    String bawu_type = akVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        blVar.bwc.setVisibility(0);
                        blVar.bwc.setText(String.valueOf(level_id));
                        com.baidu.tbadk.core.util.aw.h((View) blVar.bwc, com.baidu.tbadk.core.util.d.bn(level_id));
                        i2 = 2;
                        blVar.bwc.setOnClickListener(null);
                    } else {
                        blVar.bwc.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            blVar.bwc.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.aw.h((View) blVar.bwc, com.baidu.tieba.u.pb_manager);
                            blVar.bwc.setOnClickListener(this.bvI.bva.bzj);
                        } else if (bawu_type.equals("assist")) {
                            blVar.bwc.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.aw.h((View) blVar.bwc, com.baidu.tieba.u.pb_assist);
                            blVar.bwc.setOnClickListener(this.bvI.bva.bzj);
                        }
                    }
                    if (akVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.aw.c(blVar.bwd, com.baidu.tieba.u.icon_pop_girl_square);
                        blVar.bwd.setVisibility(0);
                    } else {
                        blVar.bwd.setVisibility(8);
                    }
                    this.bvR = akVar.getAuthor().getIconInfo();
                    this.ayZ = akVar.getAuthor().getTShowInfo();
                    if (blVar.aSO != null) {
                        blVar.aSO.setOnClickListener(this.bvI.bva.bzj);
                        blVar.aSO.a(this.bvR, i2, this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                    }
                    if (blVar.azs != null) {
                        blVar.azs.setOnClickListener(this.bvI.bva.bzk);
                        blVar.azs.a(this.ayZ, 3, this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                    }
                }
                blVar.bwb.setUserId(akVar.getAuthor().getUserId());
                blVar.bwb.setUserName(akVar.getAuthor().getUserName());
                blVar.bwb.setImageDrawable(null);
                blVar.aEq.setTag(akVar.getAuthor().getUserId());
                blVar.bwb.c(portrait, 28, false);
            }
            blVar.bwi.setLinkTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.common_link_text));
            if (this.bvJ) {
                blVar.bwi.setDefaultImageId(com.baidu.tieba.u.img_default_100);
            } else {
                blVar.bwi.setDefaultImageId(com.baidu.tieba.u.icon_click);
            }
            blVar.bwi.setIsFromCDN(this.mIsFromCDN);
            if (this.bvS || !this.bvT) {
                blVar.bwi.a(akVar.Ah(), false);
            } else {
                blVar.bwi.a(akVar.Ah(), true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bvH.zS() != 0) {
                z8 = true;
                z9 = true;
                String userId2 = akVar.getAuthor().getUserId();
                if (userId2 != null && userId2.equals(TbadkApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                    if (!z2 && z3) {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                        if (blVar.bwu != null) {
                            blVar.bwu.setVisibility(0);
                            blVar.bwu.setText(com.baidu.tieba.y.manage);
                            blVar.bwu.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                            if (blVar.bwu != null) {
                                blVar.bwu.setVisibility(0);
                                blVar.bwu.setText(com.baidu.tieba.y.delete);
                                blVar.bwu.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                            if (blVar.bwu != null) {
                                blVar.bwu.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (akVar.Ag() == 1) {
                        i3 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.bvH.zS()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, akVar.getId());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, akVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, "");
                    }
                    if (z) {
                        blVar.bwh.setVisibility(8);
                        com.baidu.tbadk.core.util.aw.b(blVar.bws, com.baidu.tieba.s.subpb_listitem_time, 1);
                        blVar.bws.setText(String.format(this.bvI.getResources().getString(com.baidu.tieba.y.write_addition_update), com.baidu.tbadk.core.util.az.j(akVar.getTime())));
                        if (blVar.bwu.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.aw.b(blVar.bwu, com.baidu.tieba.s.common_link_text, 3);
                            blVar.bwu.setTag(sparseArray);
                            blVar.bwu.setOnClickListener(this.bvQ);
                            return;
                        }
                        return;
                    }
                    return;
                }
                z2 = z9;
                z3 = z8;
                z4 = false;
                if (!z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i32 = 1;
                if (z) {
                }
                if (akVar.Ag() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                if (z3) {
                }
                if (z) {
                }
            } else {
                String userId3 = this.bvH.zM().getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = akVar.getAuthor().getUserId();
                    if (userId4 != null && userId4.equals(TbadkApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = false;
                        z4 = true;
                    }
                    z2 = z9;
                    z3 = z8;
                    z4 = false;
                }
                if (!z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i322 = 1;
                if (z) {
                }
                if (akVar.Ag() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                if (z3) {
                }
                if (z) {
                }
            }
        }
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.ack = sVar;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.aw.b(textView, com.baidu.tieba.s.sub_pb_more_text, 1);
        textView.setText(spannableString);
    }

    private void a(bl blVar, com.baidu.tieba.data.ak akVar, AdditionData additionData, int i) {
        if (akVar.Al() > 0 && akVar.Af() != null) {
            blVar.bwr.setVisibility(0);
            blVar.bwr.removeViews(0, blVar.bwr.getChildCount() - 1);
            int size = akVar.Af().size();
            int Am = akVar.Am();
            for (int i2 = 0; i2 < Am; i2++) {
                com.baidu.tieba.data.ak akVar2 = akVar.Af().get(i2);
                View a = a(blVar.bwr, true);
                bl blVar2 = (bl) a.getTag();
                a(blVar2, akVar2, blVar.bwr, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, akVar2);
                sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
                if (TextUtils.isEmpty(akVar2.getBimg_url()) || !this.bvJ) {
                    sparseArray.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    blVar2.bwi.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar2.bwi.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    blVar2.bwi.setLayoutParams(layoutParams);
                    blVar2.bwi.setPadding(0, 0, 0, 0);
                    blVar.bwi.dS(null);
                } else {
                    blVar.bwi.dS(akVar.getBimg_url());
                    blVar2.bwi.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) blVar2.bwi.getLayoutParams();
                    layoutParams2.topMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds16);
                    layoutParams2.bottomMargin = (int) this.bvI.getResources().getDimension(com.baidu.tieba.t.ds36);
                    blVar2.bwi.setLayoutParams(layoutParams2);
                }
                blVar.bwr.addView(a, blVar.bwr.getChildCount() - 1);
            }
            if (Am < size) {
                blVar.bwv.setVisibility(0);
                com.baidu.tbadk.core.util.aw.h(blVar.bwx, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.aw.h(blVar.bwy, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.aw.b(blVar.bww, com.baidu.tieba.s.cp_cont_f, 1);
                blVar.bwv.setOnClickListener(new bj(this, Am, size, akVar));
                return;
            }
            blVar.bwv.setVisibility(8);
            return;
        }
        blVar.bwr.setVisibility(8);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tieba.data.ak akVar = (com.baidu.tieba.data.ak) getItem(i);
        if (akVar instanceof com.baidu.tieba.d.a.f) {
            return ((com.baidu.tieba.d.a.f) akVar).getShowType() == 1 ? 1 : 2;
        }
        return 0;
    }

    private void WD() {
        com.baidu.tieba.d.a.f fVar;
        int position;
        if (this.bvH != null) {
            ArrayList<com.baidu.tieba.data.ak> zN = this.bvH.zN();
            ArrayList<com.baidu.tieba.d.a.f> zU = this.bvH.zU();
            if (zU != null) {
                int size = zU.size();
                if (zN != null && zN.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.d.a.f> it = zU.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.d.a.f next = it.next();
                        if (next != null && next.abu() != null) {
                            sb.append(next.abu());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.d.a.f> it2 = zU.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.d.a.f next2 = it2.next();
                        if (next2 != null) {
                            next2.aAD = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.d.a.f> it3 = zU.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.d.a.f next3 = it3.next();
                        if (next3.abt() != null && next3.abt().jF() && !com.baidu.tieba.d.b.E(com.baidu.tieba.aj.wm().getContext(), next3.abt().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.d.a.f fVar2 = (com.baidu.tieba.d.a.f) sparseArray.get(sparseArray.keyAt(i));
                        if (fVar2 != null) {
                            hashMap.put(fVar2.abu(), fVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (fVar = (com.baidu.tieba.d.a.f) entry.getValue()) != null) {
                            sparseArray.put(fVar.getPosition(), fVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bk(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.d.a.f fVar3 = (com.baidu.tieba.d.a.f) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = fVar3.getPosition();
                        if (position2 + i3 < zN.size()) {
                            if (this.bvH.zL() != null) {
                                fVar3.bHE = this.bvH.zL().getId();
                            }
                            if (this.bvH.zM() != null) {
                                fVar3.threadId = com.baidu.adp.lib.g.c.a(this.bvH.zM().getId(), 0L);
                            }
                            zN.add(position2 + i3, fVar3);
                            TiebaStatic.eventStat(this.bvI, "pb_show_app", "", 1, "app_name", fVar3.abt().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
