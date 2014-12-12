package com.baidu.tieba.pb.main;

import android.content.Context;
import android.graphics.Point;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.sub.SubPbLayout;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.view.BaobaoTailView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class bi extends BaseAdapter {
    private static HashMap<Point, Integer> bzI = new HashMap<>();
    private final CustomMessageListener aCO;
    private final boolean bzH;
    private TbPageContext<PbActivity> mContext;
    private com.baidu.tieba.tbadkCore.b.i bzw = null;
    private ArrayList<com.baidu.tieba.tbadkCore.b.k> bzx = new ArrayList<>();
    private boolean bzy = true;
    private boolean bzz = true;
    private boolean bzA = true;
    private int mImageMaxWidth = 0;
    private String bzB = null;
    private View.OnClickListener aGs = null;
    private com.baidu.tbadk.widget.richText.s ajW = null;
    private com.baidu.tieba.pb.sub.a bzC = null;
    private View.OnLongClickListener TL = null;
    private com.baidu.tieba.b.d bzD = null;
    private View.OnClickListener bzE = null;
    private int width = -1;
    private int XE = 0;
    private ArrayList<IconData> bzF = null;
    private ArrayList<IconData> aBa = null;
    private boolean mIsFromCDN = false;
    private boolean bzG = false;

    static {
        bzI.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.z.i_want_lottery));
        bzI.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.z.look_result));
        bzI.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.z.i_want_lottery));
        bzI.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.z.i_want_share_picture));
        bzI.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.z.look_result));
        bzI.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.z.i_want_share_picture));
    }

    public bi(PbActivity pbActivity) {
        boolean z = true;
        this.mContext = null;
        this.bzH = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.aCO = new bj(this, 2001122);
        this.mContext = pbActivity.getPageContext();
        init();
    }

    private void init() {
        this.mImageMaxWidth = Math.min(com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.XE = TbadkCoreApplication.m255getInst().getSkinType();
        this.mContext.registerListener(this.aCO);
    }

    public void b(com.baidu.tieba.tbadkCore.b.i iVar) {
        boolean z;
        if (this.bzw != iVar) {
            z = true;
            if ((iVar != null && !iVar.agD()) || !TbadkCoreApplication.m255getInst().isRecAppExist()) {
                z = false;
            }
        } else {
            z = false;
        }
        this.bzw = iVar;
        if (z) {
            Xa();
            if (iVar != null) {
                iVar.ev(false);
            }
        }
        this.bzx.clear();
        if (this.bzw != null && this.bzw.agF() != null && this.bzw.agF().size() > 0) {
            this.bzx.addAll(this.bzw.agF());
        }
        if (iVar != null && iVar.agE() != null && iVar.agE().getAuthor() != null) {
            this.bzB = iVar.agE().getAuthor().getUserId();
        }
    }

    public void y(View.OnClickListener onClickListener) {
        this.bzE = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aGs = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.TL = onLongClickListener;
    }

    public View.OnLongClickListener WX() {
        return this.TL;
    }

    public void a(com.baidu.tieba.b.d dVar) {
        this.bzD = dVar;
    }

    public void dH(boolean z) {
        this.bzA = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bzx.size() < 1) {
            return 0;
        }
        com.baidu.tieba.tbadkCore.b.k kVar = this.bzx.get(this.bzx.size() - 1);
        if (!this.bzA && kVar.agT() == 1) {
            return this.bzx.size() - 1;
        }
        return this.bzx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.bzx.size()) {
            return null;
        }
        return this.bzx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void dI(boolean z) {
        this.bzy = z;
    }

    public void dJ(boolean z) {
        this.bzz = z;
    }

    public boolean WY() {
        return this.bzy;
    }

    public boolean WZ() {
        return this.bzz;
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
        PbRecBaseViewHolder pbRecBaseViewHolder;
        this.XE = TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tieba.tbadkCore.b.j jVar = (com.baidu.tieba.tbadkCore.b.j) getItem(i);
        if (view == null) {
            pbRecBaseViewHolder = com.baidu.tieba.recapp.a.abI().k(this.mContext.getContext(), 1);
            view = pbRecBaseViewHolder.getRootView();
        } else {
            pbRecBaseViewHolder = (PbRecBaseViewHolder) view.getTag();
        }
        this.mContext.getLayoutMode().ab(this.XE == 1);
        this.mContext.getLayoutMode().h(view);
        pbRecBaseViewHolder.update(jVar, i, this.mIsFromCDN);
        return view;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        PbRecBaseViewHolder pbRecBaseViewHolder;
        this.XE = TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tieba.tbadkCore.b.j jVar = (com.baidu.tieba.tbadkCore.b.j) getItem(i);
        if (view == null) {
            pbRecBaseViewHolder = com.baidu.tieba.recapp.a.abI().k(this.mContext.getContext(), 2);
            view = pbRecBaseViewHolder.getRootView();
        } else {
            pbRecBaseViewHolder = (PbRecBaseViewHolder) view.getTag();
        }
        this.mContext.getLayoutMode().ab(this.XE == 1);
        this.mContext.getLayoutMode().h(view);
        pbRecBaseViewHolder.update(jVar, i, this.mIsFromCDN);
        return view;
    }

    private View c(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView listView;
        this.XE = TbadkCoreApplication.m255getInst().getSkinType();
        View a = view == null ? a(viewGroup, false) : view;
        bo boVar = (bo) a.getTag();
        com.baidu.tieba.tbadkCore.b.k kVar = (com.baidu.tieba.tbadkCore.b.k) getItem(i);
        com.baidu.tbadk.core.util.ax.j(boVar.bzO, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.ax.j(boVar.bzP, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.ax.b(boVar.bAl, com.baidu.tieba.t.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.ax.b(boVar.bAn, com.baidu.tieba.t.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.ax.b(boVar.aFV, com.baidu.tieba.t.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ax.b(boVar.bzT, com.baidu.tieba.t.cp_cont_i, 1);
        com.baidu.tbadk.core.util.ax.b(boVar.bzV, com.baidu.tieba.t.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ax.b(boVar.bzW, com.baidu.tieba.t.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ax.c(boVar.bzY, com.baidu.tieba.v.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.ax.j(boVar.bAc, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.ax.j(boVar.bAd, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.ax.j(boVar.bAe, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.ax.c(boVar.bAe, com.baidu.tieba.t.cp_bg_line_b);
        imageView = boVar.bAh;
        com.baidu.tbadk.core.util.ax.c(imageView, com.baidu.tieba.t.cp_bg_line_b);
        int nF = this.bzw.agE().nF();
        if (nF == 1 || nF == 4) {
            com.baidu.tbadk.core.util.ax.b(boVar.bAa, com.baidu.tieba.t.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ax.i((View) boVar.bAa, com.baidu.tieba.v.buy_yinji_btn_bg);
        } else if (nF == 2) {
            com.baidu.tbadk.core.util.ax.b(boVar.bAa, com.baidu.tieba.t.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ax.i((View) boVar.bAa, com.baidu.tieba.v.btn_pb_bottom_comment_selector);
        }
        if (kVar != null) {
            a(boVar, kVar, a, false, i);
        }
        if (!this.bzG && this.bzH && boVar != null && boVar.bzZ.Ab() && (listView = this.mContext.getOrignalPage().getListView()) != null) {
            this.bzG = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return a;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bo boVar = new bo(this, null);
        View a = com.baidu.adp.lib.g.b.ek().a(this.mContext.getContext(), com.baidu.tieba.x.new_pb_list_item, viewGroup, false);
        boVar.bzR = a.findViewById(com.baidu.tieba.w.sub_pb_more);
        boVar.bzS = (HeadImageView) a.findViewById(com.baidu.tieba.w.photo);
        boVar.aFV = (TextView) a.findViewById(com.baidu.tieba.w.user_name);
        boVar.bzT = (TextView) a.findViewById(com.baidu.tieba.w.user_rank);
        boVar.bzU = (ImageView) a.findViewById(com.baidu.tieba.w.user_gender);
        boVar.bzY = (ImageView) a.findViewById(com.baidu.tieba.w.reply);
        boVar.bzZ = (TbRichTextView) a.findViewById(com.baidu.tieba.w.richText);
        boVar.bAa = (TextView) a.findViewById(com.baidu.tieba.w.pb_act_btn);
        boVar.bAb = (TbRichTextView) a.findViewById(com.baidu.tieba.w.pb_act_img);
        boVar.bAc = a.findViewById(com.baidu.tieba.w.pb_item_praise_topline);
        boVar.bAd = (FrsPraiseView) a.findViewById(com.baidu.tieba.w.pb_item_praise_view);
        boVar.bAe = (ImageView) a.findViewById(com.baidu.tieba.w.pb_item_praise_bottomline);
        boVar.bAs = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_item_location_container);
        boVar.bAu = (TextView) a.findViewById(com.baidu.tieba.w.pb_item_location_address);
        boVar.bAt = (ImageView) a.findViewById(com.baidu.tieba.w.pb_item_location_img);
        boVar.bAv = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_reply_location_container);
        boVar.bAx = (TextView) a.findViewById(com.baidu.tieba.w.pb_reply_location_address);
        boVar.bAw = (ImageView) a.findViewById(com.baidu.tieba.w.pb_reply_location_img);
        boVar.bzX = (ImageView) a.findViewById(com.baidu.tieba.w.floor_owner);
        boVar.bzV = (TextView) a.findViewById(com.baidu.tieba.w.floor);
        boVar.bzW = (TextView) a.findViewById(com.baidu.tieba.w.time);
        boVar.bAf = (RelativeLayout) a.findViewById(com.baidu.tieba.w.pb_post_header_layout);
        boVar.bAi = (SubPbLayout) a.findViewById(com.baidu.tieba.w.pb_post_footer_layout);
        boVar.bAg = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_subpb_layout_root);
        boVar.bAh = (ImageView) a.findViewById(com.baidu.tieba.w.pb_post_footer_layout_line_top);
        boVar.aFV.setOnClickListener(this.mContext.getOrignalPage().byP.bDe);
        boVar.bzY.setOnClickListener(this.aGs);
        boVar.bzS.setOnClickListener(this.mContext.getOrignalPage().byP.bDe);
        boVar.bzN = a;
        boVar.bzO = a.findViewById(com.baidu.tieba.w.new_pb_list_item_line_top);
        boVar.bzP = a.findViewById(com.baidu.tieba.w.new_pb_list_item_line_top_full);
        boVar.bzQ = a.findViewById(com.baidu.tieba.w.new_pb_list_item_blank_top);
        boVar.bAf.setOnLongClickListener(this.TL);
        boVar.bzZ.setOnLongClickListener(this.TL);
        if (this.width < 0) {
            this.width = (((com.baidu.adp.lib.util.l.M(this.mContext.getContext()) - a.getPaddingLeft()) - a.getPaddingRight()) - boVar.bzZ.getPaddingLeft()) - boVar.bzZ.getPaddingRight();
        }
        boVar.bAb.setMaxImageWidth(com.baidu.adp.lib.util.l.M(this.mContext.getContext()) - (((int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30)) * 2));
        boVar.bAb.setMaxImageHeight((int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds484));
        boVar.bAf.setOnTouchListener(this.bzD);
        boVar.bzZ.setOnTouchListener(this.bzD);
        this.width = this.mImageMaxWidth > this.width ? this.width : this.mImageMaxWidth;
        int dimension = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds104);
        if (this.width > dimension) {
            boVar.bzZ.setMaxImageWidth(this.width - dimension);
        } else {
            boVar.bzZ.setMaxImageWidth(this.width);
        }
        boVar.bzZ.setMaxImageHeight((int) (this.width * 1.618f));
        boVar.bzZ.setTextSize(TbConfig.getContentSize());
        if (!this.bzz) {
            ViewGroup.LayoutParams layoutParams = boVar.bzS.getLayoutParams();
            layoutParams.width = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
            boVar.bzS.setLayoutParams(layoutParams);
            boVar.bzS.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = boVar.bzS.getLayoutParams();
            layoutParams2.width = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds60);
            boVar.bzS.setLayoutParams(layoutParams2);
            boVar.bzS.setVisibility(0);
        }
        boVar.bzZ.c(this.bzy, false);
        boVar.bzZ.setVoiceViewRes(com.baidu.tieba.x.voice_play_btn);
        boVar.bzZ.setOnImageClickListener(this.ajW);
        boVar.bAb.setOnImageClickListener(this.ajW);
        boVar.bzZ.setOnEmotionClickListener(this.mContext.getOrignalPage().byP.bDh);
        boVar.aUb = (UserIconBox) a.findViewById(com.baidu.tieba.w.user_icon_box);
        boVar.aUb.setOnClickListener(this.mContext.getOrignalPage().byP.bDf);
        boVar.aBn = (UserIconBox) a.findViewById(com.baidu.tieba.w.user_tshow_icon_box);
        boVar.aBn.setOnClickListener(this.mContext.getOrignalPage().byP.bDg);
        boVar.bAk = (LinearLayout) a.findViewById(com.baidu.tieba.w.add_post_footer_layout);
        a.setTag(boVar);
        if (z) {
            boVar.bAf.setVisibility(8);
            boVar.bzY.setVisibility(8);
            boVar.bzZ.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) boVar.bzZ.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            boVar.bzZ.setLayoutParams(layoutParams3);
            a.findViewById(com.baidu.tieba.w.pb_list_item_layout).setPadding(0, 0, 0, 0);
            boVar.bAm = (LinearLayout) a.findViewById(com.baidu.tieba.w.add_time_container);
            boVar.bAl = (TextView) a.findViewById(com.baidu.tieba.w.add_time);
            boVar.bAn = (Button) a.findViewById(com.baidu.tieba.w.manage_btn);
            boVar.bAm.setVisibility(0);
        }
        boVar.bAo = (LinearLayout) a.findViewById(com.baidu.tieba.w.addition_more_container);
        boVar.bAp = (TextView) boVar.bAo.findViewById(com.baidu.tieba.w.addition_more);
        boVar.bAq = boVar.bAo.findViewById(com.baidu.tieba.w.addition_divider1);
        boVar.bAr = boVar.bAo.findViewById(com.baidu.tieba.w.addition_divider2);
        boVar.bAj = (BaobaoTailView) a.findViewById(com.baidu.tieba.w.baobao_tail);
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x05a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x09fc  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0a29  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0a42  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0a5e  */
    /* JADX WARN: Removed duplicated region for block: B:246:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bo boVar, com.baidu.tieba.tbadkCore.b.k kVar, View view, boolean z, int i) {
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
        if (boVar != null && kVar != null) {
            if (!z) {
                boVar.bzS.setTag(null);
                boVar.bzS.setUserId(null);
                boVar.aFV.setText((CharSequence) null);
                boVar.bzT.setText((CharSequence) null);
                boVar.bzT.setBackgroundDrawable(null);
                boVar.bAi.setVisibility(0);
                boVar.bzY.setVisibility(0);
                boVar.bzX.setVisibility(8);
                if (kVar.agV() == null) {
                    boVar.bAj.setVisibility(8);
                } else if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && kVar.agV().ul() == 1) {
                    boVar.bAj.changeSkinType(this.XE);
                    boVar.bAj.setVisibility(0);
                    boVar.bAj.setData(kVar.agV());
                } else {
                    boVar.bAj.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) boVar.bAf.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    boVar.bAf.setTag(sparseArray2);
                    boVar.bzZ.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.w.tag_clip_board, kVar);
                sparseArray2.put(com.baidu.tieba.w.tag_is_subpb, false);
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.bzy) {
                    sparseArray2.put(com.baidu.tieba.w.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boVar.bzZ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    boVar.bzZ.setLayoutParams(layoutParams);
                    boVar.bzZ.setPadding(0, 0, 0, 0);
                    boVar.bzZ.eL(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.w.tag_richtext_bg, kVar.getBimg_url());
                    boVar.bzZ.eL(kVar.getBimg_url());
                    if (kVar.agT() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) boVar.bzZ.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds40);
                        boVar.bzZ.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) boVar.bzZ.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds20);
                        boVar.bzZ.setLayoutParams(layoutParams3);
                    }
                }
                boVar.bzW.setText(com.baidu.tbadk.core.util.ba.n(kVar.getTime()));
                if (kVar.agT() == 1) {
                    com.baidu.tbadk.core.util.ax.j(boVar.bzN, com.baidu.tieba.t.cp_bg_line_d);
                    boVar.bzO.setVisibility(8);
                    boVar.bzP.setVisibility(8);
                    boVar.bzQ.setVisibility(8);
                    boVar.bAf.setVisibility(8);
                    boVar.bzW.setVisibility(8);
                    if (this.bzA) {
                        PraiseData praise = this.bzw.agE().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            boVar.bAd.setVisibility(0);
                            boVar.bAc.setVisibility(0);
                            boVar.bAe.setVisibility(0);
                            boVar.bAd.setIsFromPb(true);
                            boVar.bAd.a(praise, this.bzw.agE().getId(), praise.getPostId(), true);
                            boVar.bAd.cm(this.XE);
                        } else {
                            boVar.bAd.setVisibility(8);
                            boVar.bAc.setVisibility(8);
                            boVar.bAe.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d agW = kVar.agW();
                        boVar.bAv.setVisibility(8);
                        if (agW != null && !TextUtils.isEmpty(agW.getName()) && !TextUtils.isEmpty(agW.getName().trim())) {
                            String name = agW.getName();
                            String lat = agW.getLat();
                            String lng = agW.getLng();
                            boVar.bAs.setVisibility(0);
                            com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), boVar.bAs, 0, 10, 0, 10);
                            boVar.bAu.setText(agW.getName());
                            com.baidu.tbadk.core.util.ax.b(boVar.bAu, com.baidu.tieba.t.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.ax.c(boVar.bAt, com.baidu.tieba.v.icon_frs_site);
                            boVar.bAs.setOnClickListener(new bk(this, lat, lng, name));
                        } else {
                            boVar.bAs.setVisibility(8);
                        }
                    } else {
                        boVar.bAd.setVisibility(8);
                        boVar.bAc.setVisibility(8);
                        boVar.bAe.setVisibility(8);
                        boVar.bAs.setVisibility(8);
                        boVar.bAv.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) boVar.bzZ.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
                    ((LinearLayout.LayoutParams) boVar.bAj.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
                } else {
                    com.baidu.tbadk.core.util.ax.j(boVar.bzN, com.baidu.tieba.t.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bzA) {
                            boVar.bzO.setVisibility(8);
                            boVar.bzP.setVisibility(8);
                            PraiseData praise2 = this.bzw.agE().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                boVar.bzP.setVisibility(8);
                                boVar.bzO.setVisibility(0);
                            } else {
                                boVar.bzP.setVisibility(0);
                                boVar.bzO.setVisibility(8);
                            }
                        } else {
                            boVar.bzO.setVisibility(0);
                            boVar.bzP.setVisibility(8);
                        }
                    } else {
                        boVar.bzO.setVisibility(0);
                        boVar.bzP.setVisibility(8);
                    }
                    com.baidu.tbadk.data.d agW2 = kVar.agW();
                    boVar.bAs.setVisibility(8);
                    if (agW2 != null && !TextUtils.isEmpty(agW2.getName()) && !TextUtils.isEmpty(agW2.getName().trim())) {
                        String name2 = agW2.getName();
                        String lat2 = agW2.getLat();
                        String lng2 = agW2.getLng();
                        boVar.bAv.setVisibility(0);
                        boVar.bAx.setText(agW2.getName());
                        com.baidu.tbadk.core.util.ax.b(boVar.bAx, com.baidu.tieba.t.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.ax.c(boVar.bAw, com.baidu.tieba.v.icon_frs_site);
                        boVar.bAv.setOnClickListener(new bl(this, lat2, lng2, name2));
                    } else {
                        boVar.bAv.setVisibility(8);
                    }
                    boVar.bAd.setVisibility(8);
                    boVar.bAc.setVisibility(8);
                    boVar.bAe.setVisibility(8);
                    boVar.bAf.setVisibility(0);
                    boVar.bzW.setVisibility(0);
                    String format = String.format(this.mContext.getContext().getString(com.baidu.tieba.z.is_floor), Integer.valueOf(kVar.agT()));
                    boVar.bzV.setVisibility(0);
                    boVar.bzV.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) boVar.bzZ.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) boVar.bAj.getLayoutParams();
                    if (!this.bzz) {
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds74);
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds104);
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds104);
                    }
                    linearLayout3 = boVar.bAg;
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.bzz) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
                    }
                }
                if (this.bzB != null && !this.bzB.equals("0") && this.bzB.equals(kVar.getAuthor().getUserId())) {
                    boVar.bzX.setVisibility(0);
                    com.baidu.tbadk.core.util.ax.c(boVar.bzX, com.baidu.tieba.v.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.ax.i(boVar.bzR, com.baidu.tieba.v.bg_floor_new_middle);
            boVar.bzZ.setVideoImageId(com.baidu.tieba.v.pic_video);
            boVar.bzZ.setTextColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.pb_listitem_content));
            com.baidu.tbadk.core.util.ax.c(boVar.bzY, com.baidu.tieba.v.btn_pb_reply_selector);
            boVar.bzZ.setLinkTextColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) boVar.bzY.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                boVar.bzY.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.w.tag_clip_board, kVar);
            sparseArray.put(com.baidu.tieba.w.tag_load_sub_data, kVar);
            sparseArray.put(com.baidu.tieba.w.tag_load_sub_view, view);
            if (kVar.agX() > 0) {
                if (this.bzC == null) {
                    this.bzC = new com.baidu.tieba.pb.sub.a(this.mContext.getContext(), this.mContext.getOrignalPage().byP.bDe);
                    this.bzC.setIsFromCDN(this.mIsFromCDN);
                    this.bzC.A(this.bzE);
                    boolean z7 = false;
                    String userId = this.bzw.agE().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bzC.t(this.bzw.agG(), z7);
                    this.bzC.dJ(this.bzz);
                }
                boVar.bAi.setVisibility(0);
                imageView2 = boVar.bAh;
                imageView2.setVisibility(0);
                linearLayout2 = boVar.bAg;
                linearLayout2.setVisibility(0);
                boVar.bAi.a(kVar, view);
                boVar.bAi.setChildOnClickListener(this.aGs);
                boVar.bAi.setChildOnLongClickListener(this.TL);
                boVar.bAi.setChildOnTouchListener(this.bzD);
                boVar.bAi.setSubPbAdapter(this.bzC);
                boVar.bAi.setVisibility(0);
            } else {
                boVar.bAi.setVisibility(8);
                imageView = boVar.bAh;
                imageView.setVisibility(8);
                linearLayout = boVar.bAg;
                linearLayout.setVisibility(8);
            }
            a(boVar, kVar, this.bzw.agH(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    boVar.aFV.setText(kVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.ax.b(boVar.aFV, com.baidu.tieba.t.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ax.b(boVar.aFV, com.baidu.tieba.t.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        boVar.bzT.setVisibility(0);
                        boVar.bzT.setText(String.valueOf(level_id));
                        com.baidu.tbadk.core.util.ax.i((View) boVar.bzT, com.baidu.tbadk.core.util.d.bK(level_id));
                        i2 = 2;
                        boVar.bzT.setOnClickListener(null);
                    } else {
                        boVar.bzT.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            boVar.bzT.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.ax.i((View) boVar.bzT, com.baidu.tieba.v.pb_manager);
                            boVar.bzT.setOnClickListener(this.mContext.getOrignalPage().byP.bDf);
                        } else if (bawu_type.equals("assist")) {
                            boVar.bzT.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.ax.i((View) boVar.bzT, com.baidu.tieba.v.pb_assist);
                            boVar.bzT.setOnClickListener(this.mContext.getOrignalPage().byP.bDf);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.ax.c(boVar.bzU, com.baidu.tieba.v.icon_pop_girl_square);
                        boVar.bzU.setVisibility(0);
                    } else {
                        boVar.bzU.setVisibility(8);
                    }
                    this.bzF = kVar.getAuthor().getIconInfo();
                    this.aBa = kVar.getAuthor().getTShowInfo();
                    if (boVar.aUb != null) {
                        boVar.aUb.setOnClickListener(this.mContext.getOrignalPage().byP.bDf);
                        boVar.aUb.a(this.bzF, i2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_margin));
                    }
                    if (boVar.aBn != null) {
                        boVar.aBn.setOnClickListener(this.mContext.getOrignalPage().byP.bDg);
                        boVar.aBn.a(this.aBa, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_margin), true);
                    }
                }
                boVar.bzS.setUserId(kVar.getAuthor().getUserId());
                boVar.bzS.setUserName(kVar.getAuthor().getUserName());
                boVar.bzS.setImageDrawable(null);
                boVar.aFV.setTag(com.baidu.tieba.w.tag_user_id, kVar.getAuthor().getUserId());
                boVar.aFV.setTag(com.baidu.tieba.w.tag_user_name, kVar.getAuthor().getUserName());
                boVar.bzS.d(portrait, 28, false);
            }
            boVar.bzZ.setLinkTextColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_link_tip_c));
            if (this.bzy) {
                boVar.bzZ.setDefaultImageId(com.baidu.tieba.v.img_default_100);
            } else {
                boVar.bzZ.setDefaultImageId(com.baidu.tieba.v.icon_click);
            }
            boVar.bzZ.setIsFromCDN(this.mIsFromCDN);
            if (this.bzy) {
                boVar.bAb.setDefaultImageId(com.baidu.tieba.v.img_default_100);
            } else {
                boVar.bAb.setDefaultImageId(com.baidu.tieba.v.icon_click);
            }
            boVar.bAb.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (kVar.agT() == 1 && this.bzw.agE().nH()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a agU = kVar.agU();
                if (agU != null && agU.zL() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> zL = agU.zL();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= zL.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = zL.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.g zQ = cVar.zQ();
                            zQ.setWidth(boVar.bAb.getMaxImageWidth());
                            zQ.setHeight(boVar.bAb.getMaxImageHeight());
                            zQ.ba(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext.getContext(), arrayList2);
                boVar.bAa.setVisibility(8);
                boVar.bAb.setVisibility(8);
                if (arrayList.size() >= 1) {
                    boVar.bAb.setVisibility(0);
                }
                int nF = this.bzw.agE().nF();
                if (nF == 1 || nF == 2 || nF == 4) {
                    boVar.bAa.setVisibility(0);
                    boVar.bAa.setOnClickListener(this.aGs);
                    boVar.bAa.setEnabled(true);
                }
                Integer num = bzI.get(new Point(this.bzw.agE().nG(), nF));
                if (num != null) {
                    boVar.bAa.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                boVar.bAa.setVisibility(8);
                boVar.bAb.setVisibility(8);
            }
            if (aVar == null) {
                aVar = kVar.agU();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext.getContext(), arrayList);
            if (this.bzG || !this.bzH) {
                boVar.bzZ.a(aVar, false);
                boVar.bAb.a(aVar3, false);
            } else {
                boVar.bzZ.a(aVar, true);
                boVar.bAb.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bzw.agG() != 0) {
                z8 = true;
                z9 = true;
                String userId2 = kVar.getAuthor().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                    if (!z2 && z3) {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, true);
                        if (boVar.bAn != null) {
                            boVar.bAn.setVisibility(0);
                            boVar.bAn.setText(com.baidu.tieba.z.manage);
                            boVar.bAn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, true);
                            if (boVar.bAn != null) {
                                boVar.bAn.setVisibility(0);
                                boVar.bAn.setText(com.baidu.tieba.z.delete);
                                boVar.bAn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, false);
                            if (boVar.bAn != null) {
                                boVar.bAn.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (kVar.agT() == 1) {
                        i5 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(this.bzw.agG()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.w.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(com.baidu.tieba.w.tag_del_post_id, kVar.getId());
                    } else {
                        sparseArray.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.w.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.w.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.w.tag_forbid_user_name, kVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.w.tag_forbid_user_name, "");
                    }
                    if (z) {
                        boVar.bzY.setVisibility(8);
                        com.baidu.tbadk.core.util.ax.b(boVar.bAl, com.baidu.tieba.t.subpb_listitem_time, 1);
                        boVar.bAl.setText(String.format(this.mContext.getResources().getString(com.baidu.tieba.z.write_addition_update), com.baidu.tbadk.core.util.ba.n(kVar.getTime())));
                        if (boVar.bAn.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.ax.b(boVar.bAn, com.baidu.tieba.t.cp_link_tip_c, 3);
                            boVar.bAn.setTag(sparseArray);
                            boVar.bAn.setOnClickListener(this.bzE);
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
                int i52 = 1;
                if (z) {
                }
                if (kVar.agT() == 1) {
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
                String userId3 = this.bzw.agE().getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = kVar.getAuthor().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
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
                int i522 = 1;
                if (z) {
                }
                if (kVar.agT() == 1) {
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
        this.ajW = sVar;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.ax.b(textView, com.baidu.tieba.t.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    private void a(bo boVar, com.baidu.tieba.tbadkCore.b.k kVar, AdditionData additionData, int i) {
        if (kVar.agY() > 0 && kVar.agS() != null) {
            boVar.bAk.setVisibility(0);
            boVar.bAk.removeViews(0, boVar.bAk.getChildCount() - 1);
            int size = kVar.agS().size();
            int agZ = kVar.agZ();
            for (int i2 = 0; i2 < agZ; i2++) {
                com.baidu.tieba.tbadkCore.b.k kVar2 = kVar.agS().get(i2);
                View a = a(boVar.bAk, true);
                bo boVar2 = (bo) a.getTag();
                a(boVar2, kVar2, boVar.bAk, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.w.tag_clip_board, kVar2);
                sparseArray.put(com.baidu.tieba.w.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.bzy) {
                    sparseArray.put(com.baidu.tieba.w.tag_richtext_bg, null);
                    boVar2.bzZ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boVar2.bzZ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    boVar2.bzZ.setLayoutParams(layoutParams);
                    boVar2.bzZ.setPadding(0, 0, 0, 0);
                    boVar.bzZ.eL(null);
                } else {
                    boVar.bzZ.eL(kVar.getBimg_url());
                    boVar2.bzZ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) boVar2.bzZ.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds36);
                    boVar2.bzZ.setLayoutParams(layoutParams2);
                }
                boVar.bAk.addView(a, boVar.bAk.getChildCount() - 1);
            }
            if (agZ < size) {
                boVar.bAo.setVisibility(0);
                com.baidu.tbadk.core.util.ax.i(boVar.bAq, com.baidu.tieba.t.cp_bg_line_b);
                com.baidu.tbadk.core.util.ax.i(boVar.bAr, com.baidu.tieba.t.cp_bg_line_b);
                com.baidu.tbadk.core.util.ax.b(boVar.bAp, com.baidu.tieba.t.cp_cont_f, 1);
                boVar.bAo.setOnClickListener(new bm(this, agZ, size, kVar));
                return;
            }
            boVar.bAo.setVisibility(8);
            return;
        }
        boVar.bAk.setVisibility(8);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tieba.tbadkCore.b.k kVar = (com.baidu.tieba.tbadkCore.b.k) getItem(i);
        if (kVar instanceof com.baidu.tieba.tbadkCore.b.j) {
            return ((com.baidu.tieba.tbadkCore.b.j) kVar).getShowType() == 1 ? 1 : 2;
        }
        return 0;
    }

    private void Xa() {
        com.baidu.tieba.tbadkCore.b.j jVar;
        int position;
        if (this.bzw != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = this.bzw.agF();
            ArrayList<com.baidu.tieba.tbadkCore.b.j> agI = this.bzw.agI();
            if (agI != null) {
                int size = agI.size();
                if (agF != null && agF.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it = agI.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next = it.next();
                        if (next != null && next.agK() != null) {
                            sb.append(next.agK());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it2 = agI.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next2 = it2.next();
                        if (next2 != null) {
                            next2.aBV = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it3 = agI.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next3 = it3.next();
                        if (next3.agJ() != null && next3.agJ().mu() && !com.baidu.tieba.tbadkCore.ar.isInstalledPackage(TbadkCoreApplication.m255getInst().getContext(), next3.agJ().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.b.j jVar2 = (com.baidu.tieba.tbadkCore.b.j) sparseArray.get(sparseArray.keyAt(i));
                        if (jVar2 != null) {
                            hashMap.put(jVar2.agK(), jVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (jVar = (com.baidu.tieba.tbadkCore.b.j) entry.getValue()) != null) {
                            sparseArray.put(jVar.getPosition(), jVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bn(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.b.j jVar3 = (com.baidu.tieba.tbadkCore.b.j) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = jVar3.getPosition();
                        if (position2 + i3 < agF.size()) {
                            if (this.bzw.aej() != null) {
                                jVar3.Gb = this.bzw.aej().getId();
                            }
                            if (this.bzw.agE() != null) {
                                jVar3.threadId = com.baidu.adp.lib.g.c.a(this.bzw.agE().getId(), 0L);
                            }
                            agF.add(position2 + i3, jVar3);
                            TiebaStatic.eventStat(this.mContext.getContext(), "pb_show_app", "", 1, "app_name", jVar3.agJ().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
