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
    private static HashMap<Point, Integer> bBr = new HashMap<>();
    private final CustomMessageListener aDM;
    private final boolean bBq;
    private TbPageContext<PbActivity> mContext;
    private com.baidu.tieba.tbadkCore.b.i bBf = null;
    private ArrayList<com.baidu.tieba.tbadkCore.b.k> bBg = new ArrayList<>();
    private boolean bBh = true;
    private boolean bBi = true;
    private boolean bBj = true;
    private int mImageMaxWidth = 0;
    private String bBk = null;
    private View.OnClickListener aHz = null;
    private com.baidu.tbadk.widget.richText.s akw = null;
    private com.baidu.tieba.pb.sub.a bBl = null;
    private View.OnLongClickListener Un = null;
    private com.baidu.tieba.b.d bBm = null;
    private View.OnClickListener bBn = null;
    private int width = -1;
    private int Yh = 0;
    private ArrayList<IconData> bBo = null;
    private ArrayList<IconData> aBY = null;
    private boolean mIsFromCDN = false;
    private boolean bBp = false;

    static {
        bBr.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.z.i_want_lottery));
        bBr.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.z.look_result));
        bBr.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.z.i_want_lottery));
        bBr.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.z.i_want_share_picture));
        bBr.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.z.look_result));
        bBr.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.z.i_want_share_picture));
    }

    public bi(PbActivity pbActivity) {
        boolean z = true;
        this.mContext = null;
        this.bBq = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.aDM = new bj(this, 2001122);
        this.mContext = pbActivity.getPageContext();
        init();
    }

    private void init() {
        this.mImageMaxWidth = com.baidu.adp.lib.util.l.M(this.mContext.getPageActivity());
        this.Yh = TbadkCoreApplication.m255getInst().getSkinType();
        this.mContext.registerListener(this.aDM);
    }

    public void b(com.baidu.tieba.tbadkCore.b.i iVar) {
        boolean z;
        if (this.bBf != iVar) {
            z = true;
            if ((iVar != null && !iVar.ahd()) || !TbadkCoreApplication.m255getInst().isRecAppExist()) {
                z = false;
            }
        } else {
            z = false;
        }
        this.bBf = iVar;
        if (z) {
            XA();
            if (iVar != null) {
                iVar.eC(false);
            }
        }
        this.bBg.clear();
        if (this.bBf != null && this.bBf.ahf() != null && this.bBf.ahf().size() > 0) {
            this.bBg.addAll(this.bBf.ahf());
        }
        if (iVar != null && iVar.ahe() != null && iVar.ahe().getAuthor() != null) {
            this.bBk = iVar.ahe().getAuthor().getUserId();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        this.bBn = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aHz = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Un = onLongClickListener;
    }

    public View.OnLongClickListener Xx() {
        return this.Un;
    }

    public void a(com.baidu.tieba.b.d dVar) {
        this.bBm = dVar;
    }

    public void dN(boolean z) {
        this.bBj = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBg.size() < 1) {
            return 0;
        }
        com.baidu.tieba.tbadkCore.b.k kVar = this.bBg.get(this.bBg.size() - 1);
        if (!this.bBj && kVar.aht() == 1) {
            return this.bBg.size() - 1;
        }
        return this.bBg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.bBg.size()) {
            return null;
        }
        return this.bBg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void dO(boolean z) {
        this.bBh = z;
    }

    public void dP(boolean z) {
        this.bBi = z;
    }

    public boolean Xy() {
        return this.bBh;
    }

    public boolean Xz() {
        return this.bBi;
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
        this.Yh = TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tieba.tbadkCore.b.j jVar = (com.baidu.tieba.tbadkCore.b.j) getItem(i);
        if (view == null) {
            pbRecBaseViewHolder = com.baidu.tieba.recapp.a.ach().j(this.mContext.getContext(), 1);
            view = pbRecBaseViewHolder.getRootView();
        } else {
            pbRecBaseViewHolder = (PbRecBaseViewHolder) view.getTag();
        }
        this.mContext.getLayoutMode().ab(this.Yh == 1);
        this.mContext.getLayoutMode().h(view);
        pbRecBaseViewHolder.update(jVar, i, this.mIsFromCDN);
        return view;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        PbRecBaseViewHolder pbRecBaseViewHolder;
        this.Yh = TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tieba.tbadkCore.b.j jVar = (com.baidu.tieba.tbadkCore.b.j) getItem(i);
        if (view == null) {
            pbRecBaseViewHolder = com.baidu.tieba.recapp.a.ach().j(this.mContext.getContext(), 2);
            view = pbRecBaseViewHolder.getRootView();
        } else {
            pbRecBaseViewHolder = (PbRecBaseViewHolder) view.getTag();
        }
        this.mContext.getLayoutMode().ab(this.Yh == 1);
        this.mContext.getLayoutMode().h(view);
        pbRecBaseViewHolder.update(jVar, i, this.mIsFromCDN);
        return view;
    }

    private View c(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView listView;
        this.Yh = TbadkCoreApplication.m255getInst().getSkinType();
        View a = view == null ? a(viewGroup, false) : view;
        bo boVar = (bo) a.getTag();
        com.baidu.tieba.tbadkCore.b.k kVar = (com.baidu.tieba.tbadkCore.b.k) getItem(i);
        com.baidu.tbadk.core.util.bc.j(boVar.bBx, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.j(boVar.bBy, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.b(boVar.bBU, com.baidu.tieba.t.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBW, com.baidu.tieba.t.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.bc.b(boVar.aHc, com.baidu.tieba.t.cp_cont_f, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBC, com.baidu.tieba.t.cp_cont_i, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBE, com.baidu.tieba.t.cp_cont_d, 1);
        com.baidu.tbadk.core.util.bc.b(boVar.bBF, com.baidu.tieba.t.cp_cont_d, 1);
        com.baidu.tbadk.core.util.bc.c(boVar.bBH, com.baidu.tieba.v.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.bc.j(boVar.bBL, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.j(boVar.bBM, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.bc.j(boVar.bBN, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.bc.c(boVar.bBN, com.baidu.tieba.t.cp_bg_line_b);
        imageView = boVar.bBQ;
        com.baidu.tbadk.core.util.bc.c(imageView, com.baidu.tieba.t.cp_bg_line_b);
        int nA = this.bBf.ahe().nA();
        if (nA == 1 || nA == 4) {
            com.baidu.tbadk.core.util.bc.b(boVar.bBJ, com.baidu.tieba.t.cp_cont_i, 1);
            com.baidu.tbadk.core.util.bc.i((View) boVar.bBJ, com.baidu.tieba.v.buy_yinji_btn_bg);
        } else if (nA == 2) {
            com.baidu.tbadk.core.util.bc.b(boVar.bBJ, com.baidu.tieba.t.cp_cont_b, 1);
            com.baidu.tbadk.core.util.bc.i((View) boVar.bBJ, com.baidu.tieba.v.btn_pb_bottom_comment_selector);
        }
        if (kVar != null) {
            a(boVar, kVar, a, false, i);
        }
        if (!this.bBp && this.bBq && boVar != null && boVar.bBI.Ap() && (listView = this.mContext.getOrignalPage().getListView()) != null) {
            this.bBp = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return a;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bo boVar = new bo(this, null);
        View a = com.baidu.adp.lib.g.b.ei().a(this.mContext.getContext(), com.baidu.tieba.x.new_pb_list_item, viewGroup, false);
        boVar.bBA = a.findViewById(com.baidu.tieba.w.sub_pb_more);
        boVar.bBB = (HeadImageView) a.findViewById(com.baidu.tieba.w.photo);
        boVar.aHc = (TextView) a.findViewById(com.baidu.tieba.w.user_name);
        boVar.bBC = (TextView) a.findViewById(com.baidu.tieba.w.user_rank);
        boVar.bBD = (ImageView) a.findViewById(com.baidu.tieba.w.user_gender);
        boVar.bBH = (ImageView) a.findViewById(com.baidu.tieba.w.reply);
        boVar.bBI = (TbRichTextView) a.findViewById(com.baidu.tieba.w.richText);
        boVar.bBJ = (TextView) a.findViewById(com.baidu.tieba.w.pb_act_btn);
        boVar.bBK = (TbRichTextView) a.findViewById(com.baidu.tieba.w.pb_act_img);
        boVar.bBL = a.findViewById(com.baidu.tieba.w.pb_item_praise_topline);
        boVar.bBM = (FrsPraiseView) a.findViewById(com.baidu.tieba.w.pb_item_praise_view);
        boVar.bBN = (ImageView) a.findViewById(com.baidu.tieba.w.pb_item_praise_bottomline);
        boVar.bCb = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_item_location_container);
        boVar.bCd = (TextView) a.findViewById(com.baidu.tieba.w.pb_item_location_address);
        boVar.bCc = (ImageView) a.findViewById(com.baidu.tieba.w.pb_item_location_img);
        boVar.bCe = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_reply_location_container);
        boVar.bCg = (TextView) a.findViewById(com.baidu.tieba.w.pb_reply_location_address);
        boVar.bCf = (ImageView) a.findViewById(com.baidu.tieba.w.pb_reply_location_img);
        boVar.bBG = (ImageView) a.findViewById(com.baidu.tieba.w.floor_owner);
        boVar.bBE = (TextView) a.findViewById(com.baidu.tieba.w.floor);
        boVar.bBF = (TextView) a.findViewById(com.baidu.tieba.w.time);
        boVar.bBO = (RelativeLayout) a.findViewById(com.baidu.tieba.w.pb_post_header_layout);
        boVar.bBR = (SubPbLayout) a.findViewById(com.baidu.tieba.w.pb_post_footer_layout);
        boVar.bBP = (LinearLayout) a.findViewById(com.baidu.tieba.w.pb_subpb_layout_root);
        boVar.bBQ = (ImageView) a.findViewById(com.baidu.tieba.w.pb_post_footer_layout_line_top);
        boVar.aHc.setOnClickListener(this.mContext.getOrignalPage().bAx.bEO);
        boVar.bBH.setOnClickListener(this.aHz);
        boVar.bBB.setOnClickListener(this.mContext.getOrignalPage().bAx.bEO);
        boVar.bBw = a;
        boVar.bBx = a.findViewById(com.baidu.tieba.w.new_pb_list_item_line_top);
        boVar.bBy = a.findViewById(com.baidu.tieba.w.new_pb_list_item_line_top_full);
        boVar.bBz = a.findViewById(com.baidu.tieba.w.new_pb_list_item_blank_top);
        boVar.bBO.setOnLongClickListener(this.Un);
        boVar.bBI.setImageViewStretch(true);
        boVar.bBI.setOnLongClickListener(this.Un);
        if (this.width < 0) {
            this.width = (((com.baidu.adp.lib.util.l.M(this.mContext.getContext()) - a.getPaddingLeft()) - a.getPaddingRight()) - boVar.bBI.getPaddingLeft()) - boVar.bBI.getPaddingRight();
        }
        boVar.bBK.setMaxImageWidth(com.baidu.adp.lib.util.l.M(this.mContext.getContext()) - (((int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30)) * 2));
        boVar.bBK.setMaxImageHeight((int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds484));
        boVar.bBO.setOnTouchListener(this.bBm);
        boVar.bBI.setOnTouchListener(this.bBm);
        this.width = this.mImageMaxWidth > this.width ? this.width : this.mImageMaxWidth;
        int dimension = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds60);
        if (this.width > dimension) {
            boVar.bBI.setMaxImageWidth(this.width - dimension);
        } else {
            boVar.bBI.setMaxImageWidth(this.width);
        }
        boVar.bBI.setMaxImageHeight((int) (this.width * 1.618f));
        boVar.bBI.setTextSize(TbConfig.getContentSize());
        if (!this.bBi) {
            ViewGroup.LayoutParams layoutParams = boVar.bBB.getLayoutParams();
            layoutParams.width = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
            boVar.bBB.setLayoutParams(layoutParams);
            boVar.bBB.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = boVar.bBB.getLayoutParams();
            layoutParams2.width = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds60);
            boVar.bBB.setLayoutParams(layoutParams2);
            boVar.bBB.setVisibility(0);
        }
        boVar.bBI.c(this.bBh, false);
        boVar.bBI.setVoiceViewRes(com.baidu.tieba.x.voice_play_btn);
        boVar.bBI.setOnImageClickListener(this.akw);
        boVar.bBK.setOnImageClickListener(this.akw);
        boVar.bBI.setOnEmotionClickListener(this.mContext.getOrignalPage().bAx.bER);
        boVar.aVt = (UserIconBox) a.findViewById(com.baidu.tieba.w.user_icon_box);
        boVar.aVt.setOnClickListener(this.mContext.getOrignalPage().bAx.bEP);
        boVar.aCl = (UserIconBox) a.findViewById(com.baidu.tieba.w.user_tshow_icon_box);
        boVar.aCl.setOnClickListener(this.mContext.getOrignalPage().bAx.bEQ);
        boVar.bBT = (LinearLayout) a.findViewById(com.baidu.tieba.w.add_post_footer_layout);
        a.setTag(boVar);
        if (z) {
            boVar.bBO.setVisibility(8);
            boVar.bBH.setVisibility(8);
            boVar.bBI.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) boVar.bBI.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            boVar.bBI.setLayoutParams(layoutParams3);
            a.findViewById(com.baidu.tieba.w.pb_list_item_layout).setPadding(0, 0, 0, 0);
            boVar.bBV = (LinearLayout) a.findViewById(com.baidu.tieba.w.add_time_container);
            boVar.bBU = (TextView) a.findViewById(com.baidu.tieba.w.add_time);
            boVar.bBW = (Button) a.findViewById(com.baidu.tieba.w.manage_btn);
            boVar.bBV.setVisibility(0);
        }
        boVar.bBX = (LinearLayout) a.findViewById(com.baidu.tieba.w.addition_more_container);
        boVar.bBY = (TextView) boVar.bBX.findViewById(com.baidu.tieba.w.addition_more);
        boVar.bBZ = boVar.bBX.findViewById(com.baidu.tieba.w.addition_divider1);
        boVar.bCa = boVar.bBX.findViewById(com.baidu.tieba.w.addition_divider2);
        boVar.bBS = (BaobaoTailView) a.findViewById(com.baidu.tieba.w.baobao_tail);
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
                boVar.bBB.setTag(null);
                boVar.bBB.setUserId(null);
                boVar.aHc.setText((CharSequence) null);
                boVar.bBC.setText((CharSequence) null);
                boVar.bBC.setBackgroundDrawable(null);
                boVar.bBR.setVisibility(0);
                boVar.bBH.setVisibility(0);
                boVar.bBG.setVisibility(8);
                if (kVar.ahv() == null) {
                    boVar.bBS.setVisibility(8);
                } else if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && kVar.ahv().uw() == 1) {
                    boVar.bBS.changeSkinType(this.Yh);
                    boVar.bBS.setVisibility(0);
                    boVar.bBS.setData(kVar.ahv());
                } else {
                    boVar.bBS.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) boVar.bBO.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    boVar.bBO.setTag(sparseArray2);
                    boVar.bBI.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.w.tag_clip_board, kVar);
                sparseArray2.put(com.baidu.tieba.w.tag_is_subpb, false);
                a(boVar.bBI, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.bBh) {
                    sparseArray2.put(com.baidu.tieba.w.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boVar.bBI.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    boVar.bBI.setLayoutParams(layoutParams);
                    boVar.bBI.setPadding(0, 0, 0, 0);
                    boVar.bBI.eJ(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.w.tag_richtext_bg, kVar.getBimg_url());
                    boVar.bBI.eJ(kVar.getBimg_url());
                    if (kVar.aht() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) boVar.bBI.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds40);
                        boVar.bBI.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) boVar.bBI.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds20);
                        boVar.bBI.setLayoutParams(layoutParams3);
                    }
                }
                boVar.bBF.setText(com.baidu.tbadk.core.util.bf.n(kVar.getTime()));
                if (kVar.aht() == 1) {
                    com.baidu.tbadk.core.util.bc.j(boVar.bBw, com.baidu.tieba.t.cp_bg_line_d);
                    boVar.bBx.setVisibility(8);
                    boVar.bBy.setVisibility(8);
                    boVar.bBz.setVisibility(8);
                    boVar.bBO.setVisibility(8);
                    boVar.bBF.setVisibility(8);
                    if (this.bBj) {
                        PraiseData praise = this.bBf.ahe().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            boVar.bBM.setVisibility(0);
                            boVar.bBL.setVisibility(0);
                            boVar.bBN.setVisibility(0);
                            boVar.bBM.setIsFromPb(true);
                            boVar.bBM.a(praise, this.bBf.ahe().getId(), praise.getPostId(), true);
                            boVar.bBM.ct(this.Yh);
                        } else {
                            boVar.bBM.setVisibility(8);
                            boVar.bBL.setVisibility(8);
                            boVar.bBN.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d ahw = kVar.ahw();
                        boVar.bCe.setVisibility(8);
                        if (ahw != null && !TextUtils.isEmpty(ahw.getName()) && !TextUtils.isEmpty(ahw.getName().trim())) {
                            String name = ahw.getName();
                            String lat = ahw.getLat();
                            String lng = ahw.getLng();
                            boVar.bCb.setVisibility(0);
                            com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), boVar.bCb, 0, 10, 0, 10);
                            boVar.bCd.setText(ahw.getName());
                            com.baidu.tbadk.core.util.bc.b(boVar.bCd, com.baidu.tieba.t.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.bc.c(boVar.bCc, com.baidu.tieba.v.icon_frs_site);
                            boVar.bCb.setOnClickListener(new bk(this, lat, lng, name));
                        } else {
                            boVar.bCb.setVisibility(8);
                        }
                    } else {
                        boVar.bBM.setVisibility(8);
                        boVar.bBL.setVisibility(8);
                        boVar.bBN.setVisibility(8);
                        boVar.bCb.setVisibility(8);
                        boVar.bCe.setVisibility(8);
                    }
                    a(boVar.bBI, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30));
                    ((LinearLayout.LayoutParams) boVar.bBS.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
                } else {
                    boVar.bBz.setVisibility(0);
                    com.baidu.tbadk.core.util.bc.j(boVar.bBw, com.baidu.tieba.t.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bBj) {
                            boVar.bBx.setVisibility(8);
                            boVar.bBy.setVisibility(8);
                            PraiseData praise2 = this.bBf.ahe().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                boVar.bBy.setVisibility(8);
                                boVar.bBx.setVisibility(0);
                            } else {
                                boVar.bBy.setVisibility(0);
                                boVar.bBx.setVisibility(8);
                            }
                        } else {
                            boVar.bBx.setVisibility(0);
                            boVar.bBy.setVisibility(8);
                        }
                    } else {
                        boVar.bBx.setVisibility(0);
                        boVar.bBy.setVisibility(8);
                    }
                    com.baidu.tbadk.data.d ahw2 = kVar.ahw();
                    boVar.bCb.setVisibility(8);
                    if (ahw2 != null && !TextUtils.isEmpty(ahw2.getName()) && !TextUtils.isEmpty(ahw2.getName().trim())) {
                        String name2 = ahw2.getName();
                        String lat2 = ahw2.getLat();
                        String lng2 = ahw2.getLng();
                        boVar.bCe.setVisibility(0);
                        boVar.bCg.setText(ahw2.getName());
                        com.baidu.tbadk.core.util.bc.b(boVar.bCg, com.baidu.tieba.t.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.bc.c(boVar.bCf, com.baidu.tieba.v.icon_frs_site);
                        boVar.bCe.setOnClickListener(new bl(this, lat2, lng2, name2));
                    } else {
                        boVar.bCe.setVisibility(8);
                    }
                    boVar.bBM.setVisibility(8);
                    boVar.bBL.setVisibility(8);
                    boVar.bBN.setVisibility(8);
                    boVar.bBO.setVisibility(0);
                    boVar.bBF.setVisibility(0);
                    String format = String.format(this.mContext.getContext().getString(com.baidu.tieba.z.is_floor), Integer.valueOf(kVar.aht()));
                    boVar.bBE.setVisibility(0);
                    boVar.bBE.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) boVar.bBS.getLayoutParams();
                    if (!this.bBi) {
                        a(boVar.bBI, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds74);
                    } else {
                        a(boVar.bBI, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds104);
                    }
                    linearLayout3 = boVar.bBP;
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.bBi) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds30);
                    }
                }
                if (this.bBk != null && !this.bBk.equals("0") && this.bBk.equals(kVar.getAuthor().getUserId())) {
                    boVar.bBG.setVisibility(0);
                    com.baidu.tbadk.core.util.bc.c(boVar.bBG, com.baidu.tieba.v.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.bc.i(boVar.bBA, com.baidu.tieba.v.bg_floor_new_middle);
            boVar.bBI.setVideoImageId(com.baidu.tieba.v.pic_video);
            boVar.bBI.setTextColor(com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.pb_listitem_content));
            com.baidu.tbadk.core.util.bc.c(boVar.bBH, com.baidu.tieba.v.btn_pb_reply_selector);
            boVar.bBI.setLinkTextColor(com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) boVar.bBH.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                boVar.bBH.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.w.tag_clip_board, kVar);
            sparseArray.put(com.baidu.tieba.w.tag_load_sub_data, kVar);
            sparseArray.put(com.baidu.tieba.w.tag_load_sub_view, view);
            if (kVar.ahx() > 0) {
                if (this.bBl == null) {
                    this.bBl = new com.baidu.tieba.pb.sub.a(this.mContext.getContext(), this.mContext.getOrignalPage().bAx.bEO);
                    this.bBl.setIsFromCDN(this.mIsFromCDN);
                    this.bBl.B(this.bBn);
                    boolean z7 = false;
                    String userId = this.bBf.ahe().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bBl.u(this.bBf.ahg(), z7);
                    this.bBl.dP(this.bBi);
                }
                boVar.bBR.setVisibility(0);
                imageView2 = boVar.bBQ;
                imageView2.setVisibility(0);
                linearLayout2 = boVar.bBP;
                linearLayout2.setVisibility(0);
                boVar.bBR.a(kVar, view);
                boVar.bBR.setChildOnClickListener(this.aHz);
                boVar.bBR.setChildOnLongClickListener(this.Un);
                boVar.bBR.setChildOnTouchListener(this.bBm);
                boVar.bBR.setSubPbAdapter(this.bBl);
                boVar.bBR.setVisibility(0);
            } else {
                boVar.bBR.setVisibility(8);
                imageView = boVar.bBQ;
                imageView.setVisibility(8);
                linearLayout = boVar.bBP;
                linearLayout.setVisibility(8);
            }
            a(boVar, kVar, this.bBf.ahh(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    boVar.aHc.setText(kVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.bc.b(boVar.aHc, com.baidu.tieba.t.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.bc.b(boVar.aHc, com.baidu.tieba.t.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        boVar.bBC.setVisibility(0);
                        boVar.bBC.setText(String.valueOf(level_id));
                        com.baidu.tbadk.core.util.bc.i((View) boVar.bBC, com.baidu.tbadk.core.util.d.bP(level_id));
                        i2 = 2;
                        boVar.bBC.setOnClickListener(null);
                    } else {
                        boVar.bBC.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            boVar.bBC.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.bc.i((View) boVar.bBC, com.baidu.tieba.v.pb_manager);
                            boVar.bBC.setOnClickListener(this.mContext.getOrignalPage().bAx.bEP);
                        } else if (bawu_type.equals("assist")) {
                            boVar.bBC.setText((CharSequence) null);
                            com.baidu.tbadk.core.util.bc.i((View) boVar.bBC, com.baidu.tieba.v.pb_assist);
                            boVar.bBC.setOnClickListener(this.mContext.getOrignalPage().bAx.bEP);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.bc.c(boVar.bBD, com.baidu.tieba.v.icon_pop_girl_square);
                        boVar.bBD.setVisibility(0);
                    } else {
                        boVar.bBD.setVisibility(8);
                    }
                    this.bBo = kVar.getAuthor().getIconInfo();
                    this.aBY = kVar.getAuthor().getTShowInfo();
                    if (boVar.aVt != null) {
                        boVar.aVt.setOnClickListener(this.mContext.getOrignalPage().bAx.bEP);
                        boVar.aVt.a(this.bBo, i2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_margin));
                    }
                    if (boVar.aCl != null) {
                        boVar.aCl.setOnClickListener(this.mContext.getOrignalPage().bAx.bEQ);
                        boVar.aCl.a(this.aBY, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_margin), true);
                    }
                }
                boVar.bBB.setUserId(kVar.getAuthor().getUserId());
                boVar.bBB.setUserName(kVar.getAuthor().getUserName());
                boVar.bBB.setImageDrawable(null);
                boVar.aHc.setTag(com.baidu.tieba.w.tag_user_id, kVar.getAuthor().getUserId());
                boVar.aHc.setTag(com.baidu.tieba.w.tag_user_name, kVar.getAuthor().getUserName());
                boVar.bBB.d(portrait, 28, false);
            }
            boVar.bBI.setLinkTextColor(com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_link_tip_c));
            if (this.bBh) {
                boVar.bBI.setDefaultImageId(com.baidu.tieba.v.img_default_100);
            } else {
                boVar.bBI.setDefaultImageId(com.baidu.tieba.v.icon_click);
            }
            boVar.bBI.setIsFromCDN(this.mIsFromCDN);
            if (this.bBh) {
                boVar.bBK.setDefaultImageId(com.baidu.tieba.v.img_default_100);
            } else {
                boVar.bBK.setDefaultImageId(com.baidu.tieba.v.icon_click);
            }
            boVar.bBK.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (kVar.aht() == 1 && this.bBf.ahe().nC()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a ahu = kVar.ahu();
                if (ahu != null && ahu.zZ() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> zZ = ahu.zZ();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= zZ.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = zZ.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.g Ae = cVar.Ae();
                            Ae.setWidth(boVar.bBK.getMaxImageWidth());
                            Ae.setHeight(boVar.bBK.getMaxImageHeight());
                            Ae.bc(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext.getContext(), arrayList2);
                boVar.bBJ.setVisibility(8);
                boVar.bBK.setVisibility(8);
                if (arrayList.size() >= 1) {
                    boVar.bBK.setVisibility(0);
                }
                int nA = this.bBf.ahe().nA();
                if (nA == 1 || nA == 2 || nA == 4) {
                    boVar.bBJ.setVisibility(0);
                    boVar.bBJ.setOnClickListener(this.aHz);
                    boVar.bBJ.setEnabled(true);
                }
                Integer num = bBr.get(new Point(this.bBf.ahe().nB(), nA));
                if (num != null) {
                    boVar.bBJ.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                boVar.bBJ.setVisibility(8);
                boVar.bBK.setVisibility(8);
            }
            if (aVar == null) {
                aVar = kVar.ahu();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext.getContext(), arrayList);
            if (this.bBp || !this.bBq) {
                boVar.bBI.a(aVar, false);
                boVar.bBK.a(aVar3, false);
            } else {
                boVar.bBI.a(aVar, true);
                boVar.bBK.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bBf.ahg() != 0) {
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
                        if (boVar.bBW != null) {
                            boVar.bBW.setVisibility(0);
                            boVar.bBW.setText(com.baidu.tieba.z.manage);
                            boVar.bBW.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, true);
                            if (boVar.bBW != null) {
                                boVar.bBW.setVisibility(0);
                                boVar.bBW.setText(com.baidu.tieba.z.delete);
                                boVar.bBW.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, false);
                            if (boVar.bBW != null) {
                                boVar.bBW.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (kVar.aht() == 1) {
                        i5 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(this.bBf.ahg()));
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
                        boVar.bBH.setVisibility(8);
                        com.baidu.tbadk.core.util.bc.b(boVar.bBU, com.baidu.tieba.t.subpb_listitem_time, 1);
                        boVar.bBU.setText(String.format(this.mContext.getResources().getString(com.baidu.tieba.z.write_addition_update), com.baidu.tbadk.core.util.bf.n(kVar.getTime())));
                        if (boVar.bBW.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.bc.b(boVar.bBW, com.baidu.tieba.t.cp_link_tip_c, 3);
                            boVar.bBW.setTag(sparseArray);
                            boVar.bBW.setOnClickListener(this.bBn);
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
                if (kVar.aht() == 1) {
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
                String userId3 = this.bBf.ahe().getAuthor().getUserId();
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
                if (kVar.aht() == 1) {
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
        this.akw = sVar;
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
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(bo boVar, com.baidu.tieba.tbadkCore.b.k kVar, AdditionData additionData, int i) {
        if (kVar.ahy() > 0 && kVar.ahs() != null) {
            boVar.bBT.setVisibility(0);
            boVar.bBT.removeViews(0, boVar.bBT.getChildCount() - 1);
            int size = kVar.ahs().size();
            int ahz = kVar.ahz();
            for (int i2 = 0; i2 < ahz; i2++) {
                com.baidu.tieba.tbadkCore.b.k kVar2 = kVar.ahs().get(i2);
                View a = a((ViewGroup) boVar.bBT, true);
                bo boVar2 = (bo) a.getTag();
                a(boVar2, kVar2, boVar.bBT, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.w.tag_clip_board, kVar2);
                sparseArray.put(com.baidu.tieba.w.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.bBh) {
                    sparseArray.put(com.baidu.tieba.w.tag_richtext_bg, null);
                    boVar2.bBI.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boVar2.bBI.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    boVar2.bBI.setLayoutParams(layoutParams);
                    boVar2.bBI.setPadding(0, 0, 0, 0);
                    boVar.bBI.eJ(null);
                } else {
                    boVar.bBI.eJ(kVar.getBimg_url());
                    boVar2.bBI.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) boVar2.bBI.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.ds36);
                    boVar2.bBI.setLayoutParams(layoutParams2);
                }
                boVar.bBT.addView(a, boVar.bBT.getChildCount() - 1);
            }
            if (ahz < size) {
                boVar.bBX.setVisibility(0);
                com.baidu.tbadk.core.util.bc.i(boVar.bBZ, com.baidu.tieba.t.cp_bg_line_b);
                com.baidu.tbadk.core.util.bc.i(boVar.bCa, com.baidu.tieba.t.cp_bg_line_b);
                com.baidu.tbadk.core.util.bc.b(boVar.bBY, com.baidu.tieba.t.cp_cont_f, 1);
                boVar.bBX.setOnClickListener(new bm(this, ahz, size, kVar));
                return;
            }
            boVar.bBX.setVisibility(8);
            return;
        }
        boVar.bBT.setVisibility(8);
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

    private void XA() {
        com.baidu.tieba.tbadkCore.b.j jVar;
        int position;
        if (this.bBf != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = this.bBf.ahf();
            ArrayList<com.baidu.tieba.tbadkCore.b.j> ahi = this.bBf.ahi();
            if (ahi != null) {
                int size = ahi.size();
                if (ahf != null && ahf.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it = ahi.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next = it.next();
                        if (next != null && next.ahk() != null) {
                            sb.append(next.ahk());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it2 = ahi.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next2 = it2.next();
                        if (next2 != null) {
                            next2.aCT = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it3 = ahi.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next3 = it3.next();
                        if (next3.ahj() != null && next3.ahj().mn() && !com.baidu.tieba.tbadkCore.ar.isInstalledPackage(TbadkCoreApplication.m255getInst().getContext(), next3.ahj().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.b.j jVar2 = (com.baidu.tieba.tbadkCore.b.j) sparseArray.get(sparseArray.keyAt(i));
                        if (jVar2 != null) {
                            hashMap.put(jVar2.ahk(), jVar2);
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
                        if (position2 + i3 < ahf.size()) {
                            if (this.bBf.aeI() != null) {
                                jVar3.bYF = this.bBf.aeI().getId();
                            }
                            if (this.bBf.ahe() != null) {
                                jVar3.threadId = com.baidu.adp.lib.g.c.a(this.bBf.ahe().getId(), 0L);
                            }
                            ahf.add(position2 + i3, jVar3);
                            TiebaStatic.eventStat(this.mContext.getContext(), "pb_show_app", "", 1, "app_name", jVar3.ahj().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
