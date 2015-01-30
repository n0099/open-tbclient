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
    private static HashMap<Point, Integer> bBs = new HashMap<>();
    private final CustomMessageListener aDP;
    private final boolean bBr;
    private TbPageContext<PbActivity> mContext;
    private com.baidu.tieba.tbadkCore.b.i bBg = null;
    private ArrayList<com.baidu.tieba.tbadkCore.b.k> bBh = new ArrayList<>();
    private boolean bBi = true;
    private boolean bBj = true;
    private boolean bBk = true;
    private int mImageMaxWidth = 0;
    private String bBl = null;
    private View.OnClickListener aHC = null;
    private com.baidu.tbadk.widget.richText.s akz = null;
    private com.baidu.tieba.pb.sub.a bBm = null;
    private View.OnLongClickListener Uq = null;
    private com.baidu.tieba.b.d bBn = null;
    private View.OnClickListener bBo = null;
    private int width = -1;
    private int Yk = 0;
    private ArrayList<IconData> bBp = null;
    private ArrayList<IconData> aCb = null;
    private boolean mIsFromCDN = false;
    private boolean bBq = false;

    static {
        bBs.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.z.i_want_lottery));
        bBs.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.z.look_result));
        bBs.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.z.i_want_lottery));
        bBs.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.z.i_want_share_picture));
        bBs.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.z.look_result));
        bBs.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.z.i_want_share_picture));
    }

    public bi(PbActivity pbActivity) {
        boolean z = true;
        this.mContext = null;
        this.bBr = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.aDP = new bj(this, 2001122);
        this.mContext = pbActivity.getPageContext();
        init();
    }

    private void init() {
        this.mImageMaxWidth = com.baidu.adp.lib.util.l.M(this.mContext.getPageActivity());
        this.Yk = TbadkCoreApplication.m255getInst().getSkinType();
        this.mContext.registerListener(this.aDP);
    }

    public void b(com.baidu.tieba.tbadkCore.b.i iVar) {
        boolean z;
        if (this.bBg != iVar) {
            z = true;
            if ((iVar != null && !iVar.ahi()) || !TbadkCoreApplication.m255getInst().isRecAppExist()) {
                z = false;
            }
        } else {
            z = false;
        }
        this.bBg = iVar;
        if (z) {
            XF();
            if (iVar != null) {
                iVar.eC(false);
            }
        }
        this.bBh.clear();
        if (this.bBg != null && this.bBg.ahk() != null && this.bBg.ahk().size() > 0) {
            this.bBh.addAll(this.bBg.ahk());
        }
        if (iVar != null && iVar.ahj() != null && iVar.ahj().getAuthor() != null) {
            this.bBl = iVar.ahj().getAuthor().getUserId();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        this.bBo = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aHC = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Uq = onLongClickListener;
    }

    public View.OnLongClickListener XC() {
        return this.Uq;
    }

    public void a(com.baidu.tieba.b.d dVar) {
        this.bBn = dVar;
    }

    public void dN(boolean z) {
        this.bBk = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBh.size() < 1) {
            return 0;
        }
        com.baidu.tieba.tbadkCore.b.k kVar = this.bBh.get(this.bBh.size() - 1);
        if (!this.bBk && kVar.ahy() == 1) {
            return this.bBh.size() - 1;
        }
        return this.bBh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.bBh.size()) {
            return null;
        }
        return this.bBh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void dO(boolean z) {
        this.bBi = z;
    }

    public void dP(boolean z) {
        this.bBj = z;
    }

    public boolean XD() {
        return this.bBi;
    }

    public boolean XE() {
        return this.bBj;
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
        this.Yk = TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tieba.tbadkCore.b.j jVar = (com.baidu.tieba.tbadkCore.b.j) getItem(i);
        if (view == null) {
            pbRecBaseViewHolder = com.baidu.tieba.recapp.a.acm().j(this.mContext.getContext(), 1);
            view = pbRecBaseViewHolder.getRootView();
        } else {
            pbRecBaseViewHolder = (PbRecBaseViewHolder) view.getTag();
        }
        this.mContext.getLayoutMode().ab(this.Yk == 1);
        this.mContext.getLayoutMode().h(view);
        pbRecBaseViewHolder.update(jVar, i, this.mIsFromCDN);
        return view;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        PbRecBaseViewHolder pbRecBaseViewHolder;
        this.Yk = TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tieba.tbadkCore.b.j jVar = (com.baidu.tieba.tbadkCore.b.j) getItem(i);
        if (view == null) {
            pbRecBaseViewHolder = com.baidu.tieba.recapp.a.acm().j(this.mContext.getContext(), 2);
            view = pbRecBaseViewHolder.getRootView();
        } else {
            pbRecBaseViewHolder = (PbRecBaseViewHolder) view.getTag();
        }
        this.mContext.getLayoutMode().ab(this.Yk == 1);
        this.mContext.getLayoutMode().h(view);
        pbRecBaseViewHolder.update(jVar, i, this.mIsFromCDN);
        return view;
    }

    private View c(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView listView;
        this.Yk = TbadkCoreApplication.m255getInst().getSkinType();
        View a = view == null ? a(viewGroup, false) : view;
        bo boVar = (bo) a.getTag();
        com.baidu.tieba.tbadkCore.b.k kVar = (com.baidu.tieba.tbadkCore.b.k) getItem(i);
        com.baidu.tbadk.core.util.bc.j(boVar.bBy, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.j(boVar.bBz, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.b(boVar.bBV, com.baidu.tieba.t.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBX, com.baidu.tieba.t.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.bc.b(boVar.aHf, com.baidu.tieba.t.cp_cont_f, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBD, com.baidu.tieba.t.cp_cont_i, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBF, com.baidu.tieba.t.cp_cont_d, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBG, com.baidu.tieba.t.cp_cont_d, 1);
        com.baidu.tbadk.core.util.bc.c(boVar.bBI, com.baidu.tieba.v.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.bc.j(boVar.bBM, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.j(boVar.bBN, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.bc.j(boVar.bBO, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.bc.c(boVar.bBO, com.baidu.tieba.t.cp_bg_line_b);
        imageView = boVar.bBR;
        com.baidu.tbadk.core.util.bc.c(imageView, com.baidu.tieba.t.cp_bg_line_b);
        int nH = this.bBg.ahj().nH();
        if (nH == 1 || nH == 4) {
            com.baidu.tbadk.core.util.bc.b(boVar.bBK, com.baidu.tieba.t.cp_cont_i, 1);
            com.baidu.tbadk.core.util.bc.i((View) boVar.bBK, com.baidu.tieba.v.buy_yinji_btn_bg);
        } else if (nH == 2) {
            com.baidu.tbadk.core.util.bc.b(boVar.bBK, com.baidu.tieba.t.cp_cont_b, 1);
            com.baidu.tbadk.core.util.bc.i((View) boVar.bBK, com.baidu.tieba.v.btn_pb_bottom_comment_selector);
        }
        if (kVar != null) {
            a(boVar, kVar, a, false, i);
        }
        if (!this.bBq && this.bBr && boVar != null && boVar.bBJ.Av() && (listView = this.mContext.getOrignalPage().getListView()) != null) {
            this.bBq = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return a;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bo boVar = new bo(this, null);
        View a = com.baidu.adp.lib.g.b.ei().a(this.mContext.getContext(), com.baidu.tieba.x.new_pb_list_item, viewGroup, false);
        boVar.bBB = a.findViewById(com.baidu.tieba.w.sub_pb_more);
        boVar.bBC = (HeadImageView) a.findViewById(com.baidu.tieba.w.photo);
        boVar.aHf = (TextView) a.findViewById(com.baidu.tieba.w.user_name);
        boVar.bBD = (TextView) a.findViewById(com.baidu.tieba.w.user_rank);
        boVar.bBE = (ImageView) a.findViewById(com.baidu.tieba.w.user_gender);
        boVar.bBI = (ImageView) a.findViewById(com.baidu.tieba.w.reply);
        boVar.bBJ = (TbRichTextView) a.findViewById(com.baidu.tieba.w.richText);
        boVar.bBK = (TextView) a.findViewById(com.baidu.tieba.w.pb_act_btn);
        boVar.bBL = (TbRichTextView) a.findViewById(com.baidu.tieba.w.pb_act_img);
        boVar.bBM = a.findViewById(com.baidu.tieba.w.pb_item_praise_topline);
        boVar.bBN = (FrsPraiseView) a.findViewById(com.baidu.tieba.w.pb_item_praise_view);
        boVar.bBO = (ImageView) a.findViewById(com.baidu.tieba.w.pb_item_praise_bottomline);
        boVar.bCc = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_item_location_container);
        boVar.bCe = (TextView) a.findViewById(com.baidu.tieba.w.pb_item_location_address);
        boVar.bCd = (ImageView) a.findViewById(com.baidu.tieba.w.pb_item_location_img);
        boVar.bCf = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_reply_location_container);
        boVar.bCh = (TextView) a.findViewById(com.baidu.tieba.w.pb_reply_location_address);
        boVar.bCg = (ImageView) a.findViewById(com.baidu.tieba.w.pb_reply_location_img);
        boVar.bBH = (ImageView) a.findViewById(com.baidu.tieba.w.floor_owner);
        boVar.bBF = (TextView) a.findViewById(com.baidu.tieba.w.floor);
        boVar.bBG = (TextView) a.findViewById(com.baidu.tieba.w.time);
        boVar.bBP = (RelativeLayout) a.findViewById(com.baidu.tieba.w.pb_post_header_layout);
        boVar.bBS = (SubPbLayout) a.findViewById(com.baidu.tieba.w.pb_post_footer_layout);
        boVar.bBQ = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_subpb_layout_root);
        boVar.bBR = (ImageView) a.findViewById(com.baidu.tieba.w.pb_post_footer_layout_line_top);
        boVar.aHf.setOnClickListener(this.mContext.getOrignalPage().bAy.bEP);
        boVar.bBI.setOnClickListener(this.aHC);
        boVar.bBC.setOnClickListener(this.mContext.getOrignalPage().bAy.bEP);
        boVar.bBx = a;
        boVar.bBy = a.findViewById(com.baidu.tieba.w.new_pb_list_item_line_top);
        boVar.bBz = a.findViewById(com.baidu.tieba.w.new_pb_list_item_line_top_full);
        boVar.bBA = a.findViewById(com.baidu.tieba.w.new_pb_list_item_blank_top);
        boVar.bBP.setOnLongClickListener(this.Uq);
        boVar.bBJ.setImageViewStretch(true);
        boVar.bBJ.setOnLongClickListener(this.Uq);
        if (this.width < 0) {
            this.width = (((com.baidu.adp.lib.util.l.M(this.mContext.getContext()) - a.getPaddingLeft()) - a.getPaddingRight()) - boVar.bBJ.getPaddingLeft()) - boVar.bBJ.getPaddingRight();
        }
        boVar.bBL.setMaxImageWidth(com.baidu.adp.lib.util.l.M(this.mContext.getContext()) - (((int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30)) * 2));
        boVar.bBL.setMaxImageHeight((int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds484));
        boVar.bBP.setOnTouchListener(this.bBn);
        boVar.bBJ.setOnTouchListener(this.bBn);
        this.width = this.mImageMaxWidth > this.width ? this.width : this.mImageMaxWidth;
        int dimension = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds60);
        if (this.width > dimension) {
            boVar.bBJ.setMaxImageWidth(this.width - dimension);
        } else {
            boVar.bBJ.setMaxImageWidth(this.width);
        }
        boVar.bBJ.setMaxImageHeight((int) (this.width * 1.618f));
        boVar.bBJ.setTextSize(TbConfig.getContentSize());
        if (!this.bBj) {
            ViewGroup.LayoutParams layoutParams = boVar.bBC.getLayoutParams();
            layoutParams.width = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
            boVar.bBC.setLayoutParams(layoutParams);
            boVar.bBC.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = boVar.bBC.getLayoutParams();
            layoutParams2.width = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds60);
            boVar.bBC.setLayoutParams(layoutParams2);
            boVar.bBC.setVisibility(0);
        }
        boVar.bBJ.c(this.bBi, false);
        boVar.bBJ.setVoiceViewRes(com.baidu.tieba.x.voice_play_btn);
        boVar.bBJ.setOnImageClickListener(this.akz);
        boVar.bBL.setOnImageClickListener(this.akz);
        boVar.bBJ.setOnEmotionClickListener(this.mContext.getOrignalPage().bAy.bES);
        boVar.aVu = (UserIconBox) a.findViewById(com.baidu.tieba.w.user_icon_box);
        boVar.aVu.setOnClickListener(this.mContext.getOrignalPage().bAy.bEQ);
        boVar.aCo = (UserIconBox) a.findViewById(com.baidu.tieba.w.user_tshow_icon_box);
        boVar.aCo.setOnClickListener(this.mContext.getOrignalPage().bAy.bER);
        boVar.bBU = (LinearLayout) a.findViewById(com.baidu.tieba.w.add_post_footer_layout);
        a.setTag(boVar);
        if (z) {
            boVar.bBP.setVisibility(8);
            boVar.bBI.setVisibility(8);
            boVar.bBJ.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) boVar.bBJ.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            boVar.bBJ.setLayoutParams(layoutParams3);
            a.findViewById(com.baidu.tieba.w.pb_list_item_layout).setPadding(0, 0, 0, 0);
            boVar.bBW = (LinearLayout) a.findViewById(com.baidu.tieba.w.add_time_container);
            boVar.bBV = (TextView) a.findViewById(com.baidu.tieba.w.add_time);
            boVar.bBX = (Button) a.findViewById(com.baidu.tieba.w.manage_btn);
            boVar.bBW.setVisibility(0);
        }
        boVar.bBY = (LinearLayout) a.findViewById(com.baidu.tieba.w.addition_more_container);
        boVar.bBZ = (TextView) boVar.bBY.findViewById(com.baidu.tieba.w.addition_more);
        boVar.bCa = boVar.bBY.findViewById(com.baidu.tieba.w.addition_divider1);
        boVar.bCb = boVar.bBY.findViewById(com.baidu.tieba.w.addition_divider2);
        boVar.bBT = (BaobaoTailView) a.findViewById(com.baidu.tieba.w.baobao_tail);
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x05b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0a16  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0a43  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0a5c  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0a78  */
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
                boVar.bBC.setTag(null);
                boVar.bBC.setUserId(null);
                boVar.aHf.setText((CharSequence) null);
                boVar.bBD.setText((CharSequence) null);
                boVar.bBD.setBackgroundDrawable(null);
                boVar.bBS.setVisibility(0);
                boVar.bBI.setVisibility(0);
                boVar.bBH.setVisibility(8);
                if (kVar.ahA() == null) {
                    boVar.bBT.setVisibility(8);
                } else if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && kVar.ahA().uC() == 1) {
                    boVar.bBT.changeSkinType(this.Yk);
                    boVar.bBT.setVisibility(0);
                    boVar.bBT.setData(kVar.ahA());
                } else {
                    boVar.bBT.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) boVar.bBP.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    boVar.bBP.setTag(sparseArray2);
                    boVar.bBJ.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.w.tag_clip_board, kVar);
                sparseArray2.put(com.baidu.tieba.w.tag_is_subpb, false);
                a(boVar.bBJ, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.bBi) {
                    sparseArray2.put(com.baidu.tieba.w.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boVar.bBJ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    boVar.bBJ.setLayoutParams(layoutParams);
                    boVar.bBJ.setPadding(0, 0, 0, 0);
                    boVar.bBJ.eM(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.w.tag_richtext_bg, kVar.getBimg_url());
                    boVar.bBJ.eM(kVar.getBimg_url());
                    if (kVar.ahy() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) boVar.bBJ.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds40);
                        boVar.bBJ.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) boVar.bBJ.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds20);
                        boVar.bBJ.setLayoutParams(layoutParams3);
                    }
                }
                boVar.bBG.setText(com.baidu.tbadk.core.util.bf.n(kVar.getTime()));
                if (kVar.ahy() == 1) {
                    com.baidu.tbadk.core.util.bc.j(boVar.bBx, com.baidu.tieba.t.cp_bg_line_d);
                    boVar.bBy.setVisibility(8);
                    boVar.bBz.setVisibility(8);
                    boVar.bBA.setVisibility(8);
                    boVar.bBP.setVisibility(8);
                    boVar.bBG.setVisibility(8);
                    if (this.bBk) {
                        PraiseData praise = this.bBg.ahj().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            boVar.bBN.setVisibility(0);
                            boVar.bBM.setVisibility(0);
                            boVar.bBO.setVisibility(0);
                            boVar.bBN.setIsFromPb(true);
                            boVar.bBN.a(praise, this.bBg.ahj().getId(), praise.getPostId(), true);
                            boVar.bBN.ct(this.Yk);
                        } else {
                            boVar.bBN.setVisibility(8);
                            boVar.bBM.setVisibility(8);
                            boVar.bBO.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d ahB = kVar.ahB();
                        boVar.bCf.setVisibility(8);
                        if (ahB != null && !TextUtils.isEmpty(ahB.getName()) && !TextUtils.isEmpty(ahB.getName().trim())) {
                            String name = ahB.getName();
                            String lat = ahB.getLat();
                            String lng = ahB.getLng();
                            boVar.bCc.setVisibility(0);
                            com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), boVar.bCc, 0, 10, 0, 10);
                            boVar.bCe.setText(ahB.getName());
                            com.baidu.tbadk.core.util.bc.b(boVar.bCe, com.baidu.tieba.t.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.bc.c(boVar.bCd, com.baidu.tieba.v.icon_frs_site);
                            boVar.bCc.setOnClickListener(new bk(this, lat, lng, name));
                        } else {
                            boVar.bCc.setVisibility(8);
                        }
                    } else {
                        boVar.bBN.setVisibility(8);
                        boVar.bBM.setVisibility(8);
                        boVar.bBO.setVisibility(8);
                        boVar.bCc.setVisibility(8);
                        boVar.bCf.setVisibility(8);
                    }
                    a(boVar.bBJ, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30));
                    ((LinearLayout.LayoutParams) boVar.bBT.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
                } else {
                    boVar.bBA.setVisibility(0);
                    com.baidu.tbadk.core.util.bc.j(boVar.bBx, com.baidu.tieba.t.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bBk) {
                            boVar.bBy.setVisibility(8);
                            boVar.bBz.setVisibility(8);
                            PraiseData praise2 = this.bBg.ahj().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                boVar.bBz.setVisibility(8);
                                boVar.bBy.setVisibility(0);
                            } else {
                                boVar.bBz.setVisibility(0);
                                boVar.bBy.setVisibility(8);
                            }
                        } else {
                            boVar.bBy.setVisibility(0);
                            boVar.bBz.setVisibility(8);
                        }
                    } else {
                        boVar.bBy.setVisibility(0);
                        boVar.bBz.setVisibility(8);
                    }
                    com.baidu.tbadk.data.d ahB2 = kVar.ahB();
                    boVar.bCc.setVisibility(8);
                    if (ahB2 != null && !TextUtils.isEmpty(ahB2.getName()) && !TextUtils.isEmpty(ahB2.getName().trim())) {
                        String name2 = ahB2.getName();
                        String lat2 = ahB2.getLat();
                        String lng2 = ahB2.getLng();
                        boVar.bCf.setVisibility(0);
                        boVar.bCh.setText(ahB2.getName());
                        com.baidu.tbadk.core.util.bc.b(boVar.bCh, com.baidu.tieba.t.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.bc.c(boVar.bCg, com.baidu.tieba.v.icon_frs_site);
                        boVar.bCf.setOnClickListener(new bl(this, lat2, lng2, name2));
                    } else {
                        boVar.bCf.setVisibility(8);
                    }
                    boVar.bBN.setVisibility(8);
                    boVar.bBM.setVisibility(8);
                    boVar.bBO.setVisibility(8);
                    boVar.bBP.setVisibility(0);
                    boVar.bBG.setVisibility(0);
                    String format = String.format(this.mContext.getContext().getString(com.baidu.tieba.z.is_floor), Integer.valueOf(kVar.ahy()));
                    boVar.bBF.setVisibility(0);
                    boVar.bBF.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) boVar.bBT.getLayoutParams();
                    if (!this.bBj) {
                        a(boVar.bBJ, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds74);
                    } else {
                        a(boVar.bBJ, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds104);
                    }
                    linearLayout3 = boVar.bBQ;
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.bBj) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
                    }
                }
                if (this.bBl != null && !this.bBl.equals("0") && this.bBl.equals(kVar.getAuthor().getUserId())) {
                    boVar.bBH.setVisibility(0);
                    com.baidu.tbadk.core.util.bc.c(boVar.bBH, com.baidu.tieba.v.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.bc.i(boVar.bBB, com.baidu.tieba.v.bg_floor_new_middle);
            boVar.bBJ.setVideoImageId(com.baidu.tieba.v.pic_video);
            boVar.bBJ.setTextColor(com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.pb_listitem_content));
            com.baidu.tbadk.core.util.bc.c(boVar.bBI, com.baidu.tieba.v.btn_pb_reply_selector);
            boVar.bBJ.setLinkTextColor(com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) boVar.bBI.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                boVar.bBI.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.w.tag_clip_board, kVar);
            sparseArray.put(com.baidu.tieba.w.tag_load_sub_data, kVar);
            sparseArray.put(com.baidu.tieba.w.tag_load_sub_view, view);
            if (kVar.ahC() > 0) {
                if (this.bBm == null) {
                    this.bBm = new com.baidu.tieba.pb.sub.a(this.mContext.getContext(), this.mContext.getOrignalPage().bAy.bEP);
                    this.bBm.setIsFromCDN(this.mIsFromCDN);
                    this.bBm.B(this.bBo);
                    boolean z7 = false;
                    String userId = this.bBg.ahj().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bBm.u(this.bBg.ahl(), z7);
                    this.bBm.dP(this.bBj);
                }
                boVar.bBS.setVisibility(0);
                imageView2 = boVar.bBR;
                imageView2.setVisibility(0);
                linearLayout2 = boVar.bBQ;
                linearLayout2.setVisibility(0);
                boVar.bBS.a(kVar, view);
                boVar.bBS.setChildOnClickListener(this.aHC);
                boVar.bBS.setChildOnLongClickListener(this.Uq);
                boVar.bBS.setChildOnTouchListener(this.bBn);
                boVar.bBS.setSubPbAdapter(this.bBm);
                boVar.bBS.setVisibility(0);
            } else {
                boVar.bBS.setVisibility(8);
                imageView = boVar.bBR;
                imageView.setVisibility(8);
                linearLayout = boVar.bBQ;
                linearLayout.setVisibility(8);
            }
            a(boVar, kVar, this.bBg.ahm(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    boVar.aHf.setText(kVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.bc.b(boVar.aHf, com.baidu.tieba.t.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.bc.b(boVar.aHf, com.baidu.tieba.t.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        boVar.bBD.setVisibility(0);
                        boVar.bBD.setText(String.valueOf(level_id));
                        com.baidu.tbadk.core.util.bc.i((View) boVar.bBD, com.baidu.tbadk.core.util.d.bP(level_id));
                        i2 = 2;
                        boVar.bBD.setOnClickListener(null);
                    } else {
                        boVar.bBD.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            boVar.bBD.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.bc.i((View) boVar.bBD, com.baidu.tieba.v.pb_manager);
                            boVar.bBD.setOnClickListener(this.mContext.getOrignalPage().bAy.bEQ);
                        } else if (bawu_type.equals("assist")) {
                            boVar.bBD.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.bc.i((View) boVar.bBD, com.baidu.tieba.v.pb_assist);
                            boVar.bBD.setOnClickListener(this.mContext.getOrignalPage().bAy.bEQ);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.bc.c(boVar.bBE, com.baidu.tieba.v.icon_pop_girl_square);
                        boVar.bBE.setVisibility(0);
                    } else {
                        boVar.bBE.setVisibility(8);
                    }
                    this.bBp = kVar.getAuthor().getIconInfo();
                    this.aCb = kVar.getAuthor().getTShowInfo();
                    if (boVar.aVu != null) {
                        boVar.aVu.setOnClickListener(this.mContext.getOrignalPage().bAy.bEQ);
                        boVar.aVu.a(this.bBp, i2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_margin));
                    }
                    if (boVar.aCo != null) {
                        boVar.aCo.setOnClickListener(this.mContext.getOrignalPage().bAy.bER);
                        boVar.aCo.a(this.aCb, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_margin), true);
                    }
                }
                boVar.bBC.setUserId(kVar.getAuthor().getUserId());
                boVar.bBC.setUserName(kVar.getAuthor().getUserName());
                boVar.bBC.setImageDrawable(null);
                boVar.aHf.setTag(com.baidu.tieba.w.tag_user_id, kVar.getAuthor().getUserId());
                boVar.aHf.setTag(com.baidu.tieba.w.tag_user_name, kVar.getAuthor().getUserName());
                boVar.bBC.d(portrait, 28, false);
            }
            boVar.bBJ.setLinkTextColor(com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_link_tip_c));
            if (this.bBi) {
                boVar.bBJ.setDefaultImageId(com.baidu.tieba.v.img_default_100);
            } else {
                boVar.bBJ.setDefaultImageId(com.baidu.tieba.v.icon_click);
            }
            boVar.bBJ.setIsFromCDN(this.mIsFromCDN);
            if (this.bBi) {
                boVar.bBL.setDefaultImageId(com.baidu.tieba.v.img_default_100);
            } else {
                boVar.bBL.setDefaultImageId(com.baidu.tieba.v.icon_click);
            }
            boVar.bBL.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (kVar.ahy() == 1 && this.bBg.ahj().nJ()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a ahz = kVar.ahz();
                if (ahz != null && ahz.Af() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> Af = ahz.Af();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= Af.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = Af.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.g Ak = cVar.Ak();
                            Ak.setWidth(boVar.bBL.getMaxImageWidth());
                            Ak.setHeight(boVar.bBL.getMaxImageHeight());
                            Ak.bc(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext.getContext(), arrayList2);
                boVar.bBK.setVisibility(8);
                boVar.bBL.setVisibility(8);
                if (arrayList.size() >= 1) {
                    boVar.bBL.setVisibility(0);
                }
                int nH = this.bBg.ahj().nH();
                if (nH == 1 || nH == 2 || nH == 4) {
                    boVar.bBK.setVisibility(0);
                    boVar.bBK.setOnClickListener(this.aHC);
                    boVar.bBK.setEnabled(true);
                }
                Integer num = bBs.get(new Point(this.bBg.ahj().nI(), nH));
                if (num != null) {
                    boVar.bBK.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                boVar.bBK.setVisibility(8);
                boVar.bBL.setVisibility(8);
            }
            if (aVar == null) {
                aVar = kVar.ahz();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext.getContext(), arrayList);
            if (this.bBq || !this.bBr) {
                boVar.bBJ.a(aVar, false);
                boVar.bBL.a(aVar3, false);
            } else {
                boVar.bBJ.a(aVar, true);
                boVar.bBL.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bBg.ahl() != 0) {
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
                        if (boVar.bBX != null) {
                            boVar.bBX.setVisibility(0);
                            boVar.bBX.setText(com.baidu.tieba.z.manage);
                            boVar.bBX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, true);
                            if (boVar.bBX != null) {
                                boVar.bBX.setVisibility(0);
                                boVar.bBX.setText(com.baidu.tieba.z.delete);
                                boVar.bBX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, false);
                            if (boVar.bBX != null) {
                                boVar.bBX.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (kVar.ahy() == 1) {
                        i5 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(this.bBg.ahl()));
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
                        sparseArray.put(com.baidu.tieba.w.tag_forbid_user_post_id, kVar.getId());
                    } else {
                        sparseArray.put(com.baidu.tieba.w.tag_forbid_user_name, "");
                    }
                    if (z) {
                        boVar.bBI.setVisibility(8);
                        com.baidu.tbadk.core.util.bc.b(boVar.bBV, com.baidu.tieba.t.subpb_listitem_time, 1);
                        boVar.bBV.setText(String.format(this.mContext.getResources().getString(com.baidu.tieba.z.write_addition_update), com.baidu.tbadk.core.util.bf.n(kVar.getTime())));
                        if (boVar.bBX.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.bc.b(boVar.bBX, com.baidu.tieba.t.cp_link_tip_c, 3);
                            boVar.bBX.setTag(sparseArray);
                            boVar.bBX.setOnClickListener(this.bBo);
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
                if (kVar.ahy() == 1) {
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
                String userId3 = this.bBg.ahj().getAuthor().getUserId();
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
                if (kVar.ahy() == 1) {
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
        this.akz = sVar;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.bc.b(textView, com.baidu.tieba.t.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            int i2 = layoutParams.leftMargin;
            layoutParams.leftMargin = i;
            int i3 = layoutParams.leftMargin - i2;
            if (i3 != 0) {
                tbRichTextView.setMaxImageWidth(tbRichTextView.getMaxImageWidth() - i3);
            }
        }
    }

    private void a(bo boVar, com.baidu.tieba.tbadkCore.b.k kVar, AdditionData additionData, int i) {
        if (kVar.ahD() > 0 && kVar.ahx() != null) {
            boVar.bBU.setVisibility(0);
            boVar.bBU.removeViews(0, boVar.bBU.getChildCount() - 1);
            int size = kVar.ahx().size();
            int ahE = kVar.ahE();
            for (int i2 = 0; i2 < ahE; i2++) {
                com.baidu.tieba.tbadkCore.b.k kVar2 = kVar.ahx().get(i2);
                View a = a((ViewGroup) boVar.bBU, true);
                bo boVar2 = (bo) a.getTag();
                a(boVar2, kVar2, boVar.bBU, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.w.tag_clip_board, kVar2);
                sparseArray.put(com.baidu.tieba.w.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.bBi) {
                    sparseArray.put(com.baidu.tieba.w.tag_richtext_bg, null);
                    boVar2.bBJ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boVar2.bBJ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    boVar2.bBJ.setLayoutParams(layoutParams);
                    boVar2.bBJ.setPadding(0, 0, 0, 0);
                    boVar.bBJ.eM(null);
                } else {
                    boVar.bBJ.eM(kVar.getBimg_url());
                    boVar2.bBJ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) boVar2.bBJ.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds36);
                    boVar2.bBJ.setLayoutParams(layoutParams2);
                }
                boVar.bBU.addView(a, boVar.bBU.getChildCount() - 1);
            }
            if (ahE < size) {
                boVar.bBY.setVisibility(0);
                com.baidu.tbadk.core.util.bc.i(boVar.bCa, com.baidu.tieba.t.cp_bg_line_b);
                com.baidu.tbadk.core.util.bc.i(boVar.bCb, com.baidu.tieba.t.cp_bg_line_b);
                com.baidu.tbadk.core.util.bc.b(boVar.bBZ, com.baidu.tieba.t.cp_cont_f, 1);
                boVar.bBY.setOnClickListener(new bm(this, ahE, size, kVar));
                return;
            }
            boVar.bBY.setVisibility(8);
            return;
        }
        boVar.bBU.setVisibility(8);
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

    private void XF() {
        com.baidu.tieba.tbadkCore.b.j jVar;
        int position;
        if (this.bBg != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = this.bBg.ahk();
            ArrayList<com.baidu.tieba.tbadkCore.b.j> ahn = this.bBg.ahn();
            if (ahn != null) {
                int size = ahn.size();
                if (ahk != null && ahk.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it = ahn.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next = it.next();
                        if (next != null && next.ahp() != null) {
                            sb.append(next.ahp());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it2 = ahn.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next2 = it2.next();
                        if (next2 != null) {
                            next2.aCW = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it3 = ahn.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next3 = it3.next();
                        if (next3.aho() != null && next3.aho().mu() && !com.baidu.tieba.tbadkCore.ar.isInstalledPackage(TbadkCoreApplication.m255getInst().getContext(), next3.aho().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.b.j jVar2 = (com.baidu.tieba.tbadkCore.b.j) sparseArray.get(sparseArray.keyAt(i));
                        if (jVar2 != null) {
                            hashMap.put(jVar2.ahp(), jVar2);
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
                        if (position2 + i3 < ahk.size()) {
                            if (this.bBg.aeN() != null) {
                                jVar3.bYG = this.bBg.aeN().getId();
                            }
                            if (this.bBg.ahj() != null) {
                                jVar3.threadId = com.baidu.adp.lib.g.c.a(this.bBg.ahj().getId(), 0L);
                            }
                            ahk.add(position2 + i3, jVar3);
                            TiebaStatic.eventStat(this.mContext.getContext(), "pb_show_app", "", 1, "app_name", jVar3.aho().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
