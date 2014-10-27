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
    private final CustomMessageListener aBd;
    private final boolean bvF;
    private PbActivity bvu;
    private com.baidu.tieba.data.ah bvt = null;
    private boolean bvv = true;
    private boolean bvw = true;
    private boolean bvx = true;
    private int bvy = 0;
    private String bvz = null;
    private View.OnClickListener aEF = null;
    private com.baidu.tbadk.widget.richText.s acf = null;
    private com.baidu.tieba.pb.sub.a bvA = null;
    private View.OnLongClickListener NU = null;
    private com.baidu.tieba.c.d bvB = null;
    private View.OnClickListener bvC = null;
    private int width = -1;
    private int RD = 0;
    private ArrayList<IconData> bvD = null;
    private ArrayList<IconData> ayQ = null;
    private boolean mIsFromCDN = false;
    private boolean bvE = false;

    public bh(PbActivity pbActivity) {
        boolean z = true;
        this.bvu = null;
        this.bvF = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.aBd = new bi(this, 2001122);
        this.bvu = pbActivity;
        init();
    }

    private void init() {
        this.bvy = Math.min(com.baidu.adp.lib.util.m.dip2px(this.bvu, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.RD = TbadkApplication.m251getInst().getSkinType();
        if (this.bvu instanceof BaseActivity) {
            this.bvu.registerListener(this.aBd);
        }
    }

    public void b(com.baidu.tieba.data.ah ahVar) {
        boolean z;
        if (this.bvt != ahVar) {
            z = true;
            if (ahVar != null && !ahVar.zI()) {
                z = false;
            }
        } else {
            z = false;
        }
        this.bvt = ahVar;
        if (z) {
            WA();
            if (ahVar != null) {
                ahVar.br(false);
            }
        }
        if (ahVar != null && ahVar.zK() != null && ahVar.zK().getAuthor() != null) {
            this.bvz = ahVar.zK().getAuthor().getUserId();
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.bvC = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aEF = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.NU = onLongClickListener;
    }

    public View.OnLongClickListener Wx() {
        return this.NU;
    }

    public void a(com.baidu.tieba.c.d dVar) {
        this.bvB = dVar;
    }

    public void dW(boolean z) {
        this.bvx = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bvt == null || this.bvt.zL() == null || this.bvt.zL().size() < 1) {
            return 0;
        }
        com.baidu.tieba.data.ak akVar = this.bvt.zL().get(this.bvt.zL().size() - 1);
        if (!this.bvx && akVar.Ae() == 1) {
            return this.bvt.zL().size() - 1;
        }
        return this.bvt.zL().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bvt == null || this.bvt.zL() == null || i < 0 || i >= this.bvt.zL().size()) {
            return null;
        }
        return this.bvt.zL().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void dX(boolean z) {
        this.bvv = z;
    }

    public void dY(boolean z) {
        this.bvw = z;
    }

    public boolean Wy() {
        return this.bvv;
    }

    public boolean Wz() {
        return this.bvw;
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
        this.RD = TbadkApplication.m251getInst().getSkinType();
        com.baidu.tieba.d.a.f fVar = (com.baidu.tieba.d.a.f) getItem(i);
        if (view == null) {
            aVar = com.baidu.tieba.d.a.abj().ah(this.bvu);
            view = aVar.getRootView();
        } else {
            aVar = (com.baidu.tieba.d.c.a) view.getTag();
        }
        this.bvu.getLayoutMode().L(this.RD == 1);
        this.bvu.getLayoutMode().h(view);
        aVar.a(fVar, i, this.mIsFromCDN);
        return view;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        com.baidu.tieba.d.c.a aVar;
        this.RD = TbadkApplication.m251getInst().getSkinType();
        com.baidu.tieba.d.a.f fVar = (com.baidu.tieba.d.a.f) getItem(i);
        if (view == null) {
            aVar = com.baidu.tieba.d.a.abj().ag(this.bvu);
            view = aVar.getRootView();
        } else {
            aVar = (com.baidu.tieba.d.c.a) view.getTag();
        }
        this.bvu.getLayoutMode().L(this.RD == 1);
        this.bvu.getLayoutMode().h(view);
        aVar.a(fVar, i, this.mIsFromCDN);
        return view;
    }

    private View c(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView listView;
        this.RD = TbadkApplication.m251getInst().getSkinType();
        View a = view == null ? a(viewGroup, false) : view;
        bl blVar = (bl) a.getTag();
        com.baidu.tieba.data.ak akVar = (com.baidu.tieba.data.ak) getItem(i);
        PbActivity pbActivity = this.bvu;
        com.baidu.tbadk.core.util.aw.i(blVar.bvK, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.aw.i(blVar.bvL, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.aw.b(blVar.bwe, com.baidu.tieba.s.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bwg, com.baidu.tieba.s.common_link_text, 3);
        com.baidu.tbadk.core.util.aw.b(blVar.aEg, com.baidu.tieba.s.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bvO, com.baidu.tieba.s.cp_cont_i, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bvQ, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aw.b(blVar.bvR, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aw.c(blVar.bvT, com.baidu.tieba.u.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.aw.i(blVar.bvV, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.aw.i(blVar.bvW, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.aw.i(blVar.bvX, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.aw.c(blVar.bvX, com.baidu.tieba.s.cp_bg_line_b);
        imageView = blVar.bwa;
        com.baidu.tbadk.core.util.aw.c(imageView, com.baidu.tieba.s.cp_bg_line_b);
        if (akVar != null) {
            a(blVar, akVar, a, false, i);
        }
        if (!this.bvE && this.bvF && blVar != null && blVar.bvU.vT() && (listView = pbActivity.getListView()) != null) {
            this.bvE = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return a;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bl blVar = new bl(this, null);
        View a = com.baidu.adp.lib.g.b.ek().a(this.bvu, com.baidu.tieba.w.new_pb_list_item, viewGroup, false);
        blVar.bvM = a.findViewById(com.baidu.tieba.v.sub_pb_more);
        blVar.bvN = (HeadImageView) a.findViewById(com.baidu.tieba.v.photo);
        blVar.aEg = (TextView) a.findViewById(com.baidu.tieba.v.user_name);
        blVar.bvO = (TextView) a.findViewById(com.baidu.tieba.v.user_rank);
        blVar.bvP = (ImageView) a.findViewById(com.baidu.tieba.v.user_gender);
        blVar.bvT = (ImageView) a.findViewById(com.baidu.tieba.v.reply);
        blVar.bvU = (TbRichTextView) a.findViewById(com.baidu.tieba.v.richText);
        blVar.bvV = a.findViewById(com.baidu.tieba.v.pb_item_praise_topline);
        blVar.bvW = (FrsPraiseView) a.findViewById(com.baidu.tieba.v.pb_item_praise_view);
        blVar.bvX = (ImageView) a.findViewById(com.baidu.tieba.v.pb_item_praise_bottomline);
        blVar.bwl = (LinearLayout) a.findViewById(com.baidu.tieba.v.pb_item_location_container);
        blVar.bwn = (TextView) a.findViewById(com.baidu.tieba.v.pb_item_location_address);
        blVar.bwm = (ImageView) a.findViewById(com.baidu.tieba.v.pb_item_location_img);
        blVar.bwo = (LinearLayout) a.findViewById(com.baidu.tieba.v.pb_reply_location_container);
        blVar.bwq = (TextView) a.findViewById(com.baidu.tieba.v.pb_reply_location_address);
        blVar.bwp = (ImageView) a.findViewById(com.baidu.tieba.v.pb_reply_location_img);
        blVar.bvS = (ImageView) a.findViewById(com.baidu.tieba.v.floor_owner);
        blVar.bvQ = (TextView) a.findViewById(com.baidu.tieba.v.floor);
        blVar.bvR = (TextView) a.findViewById(com.baidu.tieba.v.time);
        blVar.bvY = (RelativeLayout) a.findViewById(com.baidu.tieba.v.pb_post_header_layout);
        blVar.bwb = (SubPbLayout) a.findViewById(com.baidu.tieba.v.pb_post_footer_layout);
        blVar.bvZ = (LinearLayout) a.findViewById(com.baidu.tieba.v.pb_subpb_layout_root);
        blVar.bwa = (ImageView) a.findViewById(com.baidu.tieba.v.pb_post_footer_layout_line_top);
        blVar.aEg.setOnClickListener(this.bvu.buM.byU);
        blVar.bvT.setOnClickListener(this.aEF);
        blVar.bvN.setOnClickListener(this.bvu.buM.byU);
        blVar.bvJ = a;
        blVar.bvK = a.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top);
        blVar.bvL = a.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top_full);
        blVar.bvY.setOnLongClickListener(this.NU);
        blVar.bvU.setOnLongClickListener(this.NU);
        if (this.width < 0) {
            this.width = (((com.baidu.adp.lib.util.m.n(this.bvu) - a.getPaddingLeft()) - a.getPaddingRight()) - blVar.bvU.getPaddingLeft()) - blVar.bvU.getPaddingRight();
        }
        blVar.bvY.setOnTouchListener(this.bvB);
        blVar.bvU.setOnTouchListener(this.bvB);
        this.width = this.bvy > this.width ? this.width : this.bvy;
        int dimension = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds104);
        if (this.width > dimension) {
            blVar.bvU.setMaxImageWidth(this.width - dimension);
        } else {
            blVar.bvU.setMaxImageWidth(this.width);
        }
        blVar.bvU.setMaxImageHeight((int) (this.width * 1.618f));
        blVar.bvU.setTextSize(TbConfig.getContentSize());
        if (!this.bvw) {
            ViewGroup.LayoutParams layoutParams = blVar.bvN.getLayoutParams();
            layoutParams.width = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds30);
            blVar.bvN.setLayoutParams(layoutParams);
            blVar.bvN.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = blVar.bvN.getLayoutParams();
            layoutParams2.width = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds60);
            blVar.bvN.setLayoutParams(layoutParams2);
            blVar.bvN.setVisibility(0);
        }
        blVar.bvU.b(this.bvv, false);
        blVar.bvU.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
        blVar.bvU.setOnImageClickListener(this.acf);
        blVar.bvU.setOnEmotionClickListener(this.bvu.buM.byX);
        blVar.aSA = (UserIconBox) a.findViewById(com.baidu.tieba.v.user_icon_box);
        blVar.aSA.setOnClickListener(this.bvu.buM.byV);
        blVar.azj = (UserIconBox) a.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        blVar.azj.setOnClickListener(this.bvu.buM.byW);
        blVar.bwd = (LinearLayout) a.findViewById(com.baidu.tieba.v.add_post_footer_layout);
        a.setTag(blVar);
        if (z) {
            blVar.bvY.setVisibility(8);
            blVar.bvT.setVisibility(8);
            blVar.bvU.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) blVar.bvU.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            blVar.bvU.setLayoutParams(layoutParams3);
            a.findViewById(com.baidu.tieba.v.pb_list_item_layout).setPadding(0, 0, 0, 0);
            blVar.bwf = (LinearLayout) a.findViewById(com.baidu.tieba.v.add_time_container);
            blVar.bwe = (TextView) a.findViewById(com.baidu.tieba.v.add_time);
            blVar.bwg = (Button) a.findViewById(com.baidu.tieba.v.manage_btn);
            blVar.bwf.setVisibility(0);
        }
        blVar.bwh = (LinearLayout) a.findViewById(com.baidu.tieba.v.addition_more_container);
        blVar.bwi = (TextView) blVar.bwh.findViewById(com.baidu.tieba.v.addition_more);
        blVar.bwj = blVar.bwh.findViewById(com.baidu.tieba.v.addition_divider1);
        blVar.bwk = blVar.bwh.findViewById(com.baidu.tieba.v.addition_divider2);
        blVar.bwc = (BaobaoTailView) a.findViewById(com.baidu.tieba.v.baobao_tail);
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
                blVar.bvN.setTag(null);
                blVar.bvN.setUserId(null);
                blVar.aEg.setText((CharSequence) null);
                blVar.bvO.setText((CharSequence) null);
                blVar.bvO.setBackgroundDrawable(null);
                blVar.bwb.setVisibility(0);
                blVar.bvT.setVisibility(0);
                blVar.bvS.setVisibility(8);
                if (akVar.Ag() == null) {
                    blVar.bwc.setVisibility(8);
                } else if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && akVar.Ag().yq() == 1) {
                    blVar.bwc.changeSkinType(this.RD);
                    blVar.bwc.setVisibility(0);
                    blVar.bwc.setData(akVar.Ag());
                } else {
                    blVar.bwc.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) blVar.bvY.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    blVar.bvY.setTag(sparseArray2);
                    blVar.bvU.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.v.tag_clip_board, akVar);
                sparseArray2.put(com.baidu.tieba.v.tag_is_subpb, false);
                if (TextUtils.isEmpty(akVar.getBimg_url()) || !this.bvv) {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar.bvU.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    blVar.bvU.setLayoutParams(layoutParams);
                    blVar.bvU.setPadding(0, 0, 0, 0);
                    blVar.bvU.dS(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, akVar.getBimg_url());
                    blVar.bvU.dS(akVar.getBimg_url());
                    if (akVar.Ae() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) blVar.bvU.getLayoutParams();
                        layoutParams2.topMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds16);
                        layoutParams2.bottomMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds40);
                        blVar.bvU.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) blVar.bvU.getLayoutParams();
                        layoutParams3.topMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds20);
                        layoutParams3.bottomMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds20);
                        blVar.bvU.setLayoutParams(layoutParams3);
                    }
                }
                blVar.bvR.setText(com.baidu.tbadk.core.util.ay.j(akVar.getTime()));
                if (akVar.Ae() == 1) {
                    com.baidu.tbadk.core.util.aw.i(blVar.bvJ, com.baidu.tieba.s.cp_bg_line_d);
                    blVar.bvK.setVisibility(8);
                    blVar.bvL.setVisibility(8);
                    blVar.bvY.setVisibility(8);
                    blVar.bvR.setVisibility(8);
                    if (this.bvx) {
                        PraiseData praise = this.bvt.zK().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            blVar.bvW.setVisibility(0);
                            blVar.bvV.setVisibility(0);
                            blVar.bvX.setVisibility(0);
                            blVar.bvW.setIsFromPb(true);
                            blVar.bvW.a(praise, this.bvt.zK().getId(), praise.getPostId(), true);
                            blVar.bvW.bN(this.RD);
                        } else {
                            blVar.bvW.setVisibility(8);
                            blVar.bvV.setVisibility(8);
                            blVar.bvX.setVisibility(8);
                        }
                        com.baidu.tieba.data.ab Ah = akVar.Ah();
                        blVar.bwo.setVisibility(8);
                        if (Ah != null && !TextUtils.isEmpty(Ah.getName()) && !TextUtils.isEmpty(Ah.getName().trim())) {
                            blVar.bwl.setVisibility(0);
                            blVar.bwn.setText(Ah.getName());
                            com.baidu.tbadk.core.util.aw.b(blVar.bwn, com.baidu.tieba.s.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.aw.c(blVar.bwm, com.baidu.tieba.u.icon_posts_pin_gray);
                        } else {
                            blVar.bwl.setVisibility(8);
                        }
                    } else {
                        blVar.bvW.setVisibility(8);
                        blVar.bvV.setVisibility(8);
                        blVar.bvX.setVisibility(8);
                        blVar.bwl.setVisibility(8);
                        blVar.bwo.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) blVar.bvU.getLayoutParams()).leftMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds30);
                    ((LinearLayout.LayoutParams) blVar.bwc.getLayoutParams()).leftMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds30);
                } else {
                    com.baidu.tbadk.core.util.aw.i(blVar.bvJ, com.baidu.tieba.s.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bvx) {
                            blVar.bvK.setVisibility(8);
                            blVar.bvL.setVisibility(8);
                            PraiseData praise2 = this.bvt.zK().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                blVar.bvL.setVisibility(8);
                                blVar.bvK.setVisibility(0);
                            } else {
                                blVar.bvL.setVisibility(0);
                                blVar.bvK.setVisibility(8);
                            }
                        } else {
                            blVar.bvK.setVisibility(0);
                            blVar.bvL.setVisibility(8);
                        }
                    } else {
                        blVar.bvK.setVisibility(0);
                        blVar.bvL.setVisibility(8);
                    }
                    com.baidu.tieba.data.ab Ah2 = akVar.Ah();
                    blVar.bwl.setVisibility(8);
                    if (Ah2 != null && !TextUtils.isEmpty(Ah2.getName()) && !TextUtils.isEmpty(Ah2.getName().trim())) {
                        blVar.bwo.setVisibility(0);
                        blVar.bwq.setText(Ah2.getName());
                        com.baidu.tbadk.core.util.aw.b(blVar.bwq, com.baidu.tieba.s.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.aw.c(blVar.bwp, com.baidu.tieba.u.icon_pb_site);
                    } else {
                        blVar.bwo.setVisibility(8);
                    }
                    blVar.bvW.setVisibility(8);
                    blVar.bvV.setVisibility(8);
                    blVar.bvX.setVisibility(8);
                    blVar.bvY.setVisibility(0);
                    blVar.bvR.setVisibility(0);
                    String format = String.format(this.bvu.getString(com.baidu.tieba.y.is_floor), Integer.valueOf(akVar.Ae()));
                    blVar.bvQ.setVisibility(0);
                    blVar.bvQ.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) blVar.bvU.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) blVar.bwc.getLayoutParams();
                    if (!this.bvw) {
                        layoutParams4.leftMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds74);
                        layoutParams5.leftMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds104);
                        layoutParams5.leftMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds104);
                    }
                    linearLayout3 = blVar.bvZ;
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.bvw) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds30);
                    }
                }
                if (this.bvz != null && !this.bvz.equals("0") && this.bvz.equals(akVar.getAuthor().getUserId())) {
                    blVar.bvS.setVisibility(0);
                    com.baidu.tbadk.core.util.aw.c(blVar.bvS, com.baidu.tieba.u.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.aw.h(blVar.bvM, com.baidu.tieba.u.bg_floor_new_middle);
            blVar.bvU.setVideoImageId(com.baidu.tieba.u.pic_video);
            blVar.bvU.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.pb_listitem_content));
            com.baidu.tbadk.core.util.aw.c(blVar.bvT, com.baidu.tieba.u.btn_pb_reply_selector);
            blVar.bvU.setLinkTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.common_link_text));
            SparseArray sparseArray3 = (SparseArray) blVar.bvT.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                blVar.bvT.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, akVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_data, akVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_view, view);
            if (akVar.Ai() > 0) {
                if (this.bvA == null) {
                    this.bvA = new com.baidu.tieba.pb.sub.a(this.bvu, this.bvu.buM.byU);
                    this.bvA.setIsFromCDN(this.mIsFromCDN);
                    this.bvA.u(this.bvC);
                    boolean z7 = false;
                    String userId = this.bvt.zK().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bvA.t(this.bvt.zQ(), z7);
                    this.bvA.dY(this.bvw);
                }
                blVar.bwb.setVisibility(0);
                imageView2 = blVar.bwa;
                imageView2.setVisibility(0);
                linearLayout2 = blVar.bvZ;
                linearLayout2.setVisibility(0);
                blVar.bwb.a(akVar, view);
                blVar.bwb.setChildOnClickListener(this.aEF);
                blVar.bwb.setChildOnLongClickListener(this.NU);
                blVar.bwb.setChildOnTouchListener(this.bvB);
                blVar.bwb.setSubPbAdapter(this.bvA);
                blVar.bwb.setVisibility(0);
            } else {
                blVar.bwb.setVisibility(8);
                imageView = blVar.bwa;
                imageView.setVisibility(8);
                linearLayout = blVar.bvZ;
                linearLayout.setVisibility(8);
            }
            a(blVar, akVar, this.bvt.zR(), i);
            if (!z) {
                String portrait = akVar.getAuthor().getPortrait();
                if (akVar.getAuthor() != null) {
                    blVar.aEg.setText(akVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = akVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.aw.b(blVar.aEg, com.baidu.tieba.s.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aw.b(blVar.aEg, com.baidu.tieba.s.cp_cont_f, 1);
                    }
                    int level_id = akVar.getAuthor().getLevel_id();
                    int is_bawu = akVar.getAuthor().getIs_bawu();
                    String bawu_type = akVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        blVar.bvO.setVisibility(0);
                        blVar.bvO.setText(String.valueOf(level_id));
                        com.baidu.tbadk.core.util.aw.h((View) blVar.bvO, com.baidu.tbadk.core.util.d.bn(level_id));
                        i2 = 2;
                        blVar.bvO.setOnClickListener(null);
                    } else {
                        blVar.bvO.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            blVar.bvO.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.aw.h((View) blVar.bvO, com.baidu.tieba.u.pb_manager);
                            blVar.bvO.setOnClickListener(this.bvu.buM.byV);
                        } else if (bawu_type.equals("assist")) {
                            blVar.bvO.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.aw.h((View) blVar.bvO, com.baidu.tieba.u.pb_assist);
                            blVar.bvO.setOnClickListener(this.bvu.buM.byV);
                        }
                    }
                    if (akVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.aw.c(blVar.bvP, com.baidu.tieba.u.icon_pop_girl_square);
                        blVar.bvP.setVisibility(0);
                    } else {
                        blVar.bvP.setVisibility(8);
                    }
                    this.bvD = akVar.getAuthor().getIconInfo();
                    this.ayQ = akVar.getAuthor().getTShowInfo();
                    if (blVar.aSA != null) {
                        blVar.aSA.setOnClickListener(this.bvu.buM.byV);
                        blVar.aSA.a(this.bvD, i2, this.bvu.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.bvu.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.bvu.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                    }
                    if (blVar.azj != null) {
                        blVar.azj.setOnClickListener(this.bvu.buM.byW);
                        blVar.azj.a(this.ayQ, 3, this.bvu.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.bvu.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.bvu.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                    }
                }
                blVar.bvN.setUserId(akVar.getAuthor().getUserId());
                blVar.bvN.setUserName(akVar.getAuthor().getUserName());
                blVar.bvN.setImageDrawable(null);
                blVar.aEg.setTag(akVar.getAuthor().getUserId());
                blVar.bvN.c(portrait, 28, false);
            }
            blVar.bvU.setLinkTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.common_link_text));
            if (this.bvv) {
                blVar.bvU.setDefaultImageId(com.baidu.tieba.u.img_default_100);
            } else {
                blVar.bvU.setDefaultImageId(com.baidu.tieba.u.icon_click);
            }
            blVar.bvU.setIsFromCDN(this.mIsFromCDN);
            if (this.bvE || !this.bvF) {
                blVar.bvU.a(akVar.Af(), false);
            } else {
                blVar.bvU.a(akVar.Af(), true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bvt.zQ() != 0) {
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
                        if (blVar.bwg != null) {
                            blVar.bwg.setVisibility(0);
                            blVar.bwg.setText(com.baidu.tieba.y.manage);
                            blVar.bwg.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                            if (blVar.bwg != null) {
                                blVar.bwg.setVisibility(0);
                                blVar.bwg.setText(com.baidu.tieba.y.delete);
                                blVar.bwg.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                            if (blVar.bwg != null) {
                                blVar.bwg.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (akVar.Ae() == 1) {
                        i3 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.bvt.zQ()));
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
                        blVar.bvT.setVisibility(8);
                        com.baidu.tbadk.core.util.aw.b(blVar.bwe, com.baidu.tieba.s.subpb_listitem_time, 1);
                        blVar.bwe.setText(String.format(this.bvu.getResources().getString(com.baidu.tieba.y.write_addition_update), com.baidu.tbadk.core.util.ay.j(akVar.getTime())));
                        if (blVar.bwg.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.aw.b(blVar.bwg, com.baidu.tieba.s.common_link_text, 3);
                            blVar.bwg.setTag(sparseArray);
                            blVar.bwg.setOnClickListener(this.bvC);
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
                if (akVar.Ae() == 1) {
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
                String userId3 = this.bvt.zK().getAuthor().getUserId();
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
                if (akVar.Ae() == 1) {
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
        this.acf = sVar;
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
        if (akVar.Aj() > 0 && akVar.Ad() != null) {
            blVar.bwd.setVisibility(0);
            blVar.bwd.removeViews(0, blVar.bwd.getChildCount() - 1);
            int size = akVar.Ad().size();
            int Ak = akVar.Ak();
            for (int i2 = 0; i2 < Ak; i2++) {
                com.baidu.tieba.data.ak akVar2 = akVar.Ad().get(i2);
                View a = a(blVar.bwd, true);
                bl blVar2 = (bl) a.getTag();
                a(blVar2, akVar2, blVar.bwd, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, akVar2);
                sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
                if (TextUtils.isEmpty(akVar2.getBimg_url()) || !this.bvv) {
                    sparseArray.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    blVar2.bvU.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar2.bvU.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    blVar2.bvU.setLayoutParams(layoutParams);
                    blVar2.bvU.setPadding(0, 0, 0, 0);
                    blVar.bvU.dS(null);
                } else {
                    blVar.bvU.dS(akVar.getBimg_url());
                    blVar2.bvU.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) blVar2.bvU.getLayoutParams();
                    layoutParams2.topMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds16);
                    layoutParams2.bottomMargin = (int) this.bvu.getResources().getDimension(com.baidu.tieba.t.ds36);
                    blVar2.bvU.setLayoutParams(layoutParams2);
                }
                blVar.bwd.addView(a, blVar.bwd.getChildCount() - 1);
            }
            if (Ak < size) {
                blVar.bwh.setVisibility(0);
                com.baidu.tbadk.core.util.aw.h(blVar.bwj, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.aw.h(blVar.bwk, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.aw.b(blVar.bwi, com.baidu.tieba.s.cp_cont_f, 1);
                blVar.bwh.setOnClickListener(new bj(this, Ak, size, akVar));
                return;
            }
            blVar.bwh.setVisibility(8);
            return;
        }
        blVar.bwd.setVisibility(8);
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

    private void WA() {
        com.baidu.tieba.d.a.f fVar;
        int position;
        if (this.bvt != null) {
            ArrayList<com.baidu.tieba.data.ak> zL = this.bvt.zL();
            ArrayList<com.baidu.tieba.d.a.f> zS = this.bvt.zS();
            if (zS != null) {
                int size = zS.size();
                if (zL != null && zL.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.d.a.f> it = zS.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.d.a.f next = it.next();
                        if (next != null && next.abr() != null) {
                            sb.append(next.abr());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.d.a.f> it2 = zS.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.d.a.f next2 = it2.next();
                        if (next2 != null) {
                            next2.aAt = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.d.a.f> it3 = zS.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.d.a.f next3 = it3.next();
                        if (next3.abq() != null && next3.abq().jF() && !com.baidu.tieba.d.b.E(com.baidu.tieba.aj.wk().getContext(), next3.abq().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.d.a.f fVar2 = (com.baidu.tieba.d.a.f) sparseArray.get(sparseArray.keyAt(i));
                        if (fVar2 != null) {
                            hashMap.put(fVar2.abr(), fVar2);
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
                        if (position2 + i3 < zL.size()) {
                            if (this.bvt.zJ() != null) {
                                fVar3.bHq = this.bvt.zJ().getId();
                            }
                            if (this.bvt.zK() != null) {
                                fVar3.threadId = com.baidu.adp.lib.g.c.a(this.bvt.zK().getId(), 0L);
                            }
                            zL.add(position2 + i3, fVar3);
                            TiebaStatic.eventStat(this.bvu, "pb_show_app", "", 1, "app_name", fVar3.abq().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
