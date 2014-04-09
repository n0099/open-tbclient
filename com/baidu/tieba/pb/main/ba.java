package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.pb.sub.SubPbLayout;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class ba extends BaseAdapter {
    private Context b;
    private int f;
    private com.baidu.tbadk.editortool.ab h;
    private int t;
    private final boolean x;
    private com.baidu.tieba.data.ae a = null;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private String g = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private View.OnClickListener k = null;
    private View.OnClickListener l = null;
    private com.baidu.tbadk.widget.richText.r m = null;
    private com.baidu.tbadk.widget.richText.q n = null;
    private com.baidu.tieba.pb.sub.b o = null;
    private View.OnLongClickListener p = null;
    private com.baidu.tieba.c.a q = null;
    private View.OnClickListener r = null;
    private int s = -1;
    private LinkedList<IconData> u = null;
    private LinkedList<IconData> v = null;
    private boolean w = false;

    public ba(Context context) {
        boolean z = true;
        this.b = null;
        this.f = 0;
        this.h = null;
        this.t = 0;
        this.x = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        this.f = Math.min(com.baidu.adp.lib.util.i.a(this.b, 427.0f), 640);
        this.h = new com.baidu.tbadk.editortool.ab(this.b);
        this.h.b("pb");
        this.h.a(this.f, (int) (this.f * 1.6f));
        this.t = TbadkApplication.j().l();
    }

    public final void a(com.baidu.tieba.data.ae aeVar) {
        this.a = aeVar;
        if (aeVar.d() != null && aeVar.d().t() != null) {
            this.g = aeVar.d().t().getUserId();
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public final com.baidu.tbadk.editortool.ab a() {
        return this.h;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public final void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public final void d(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public final void e(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.p = onLongClickListener;
    }

    public final View.OnLongClickListener b() {
        return this.p;
    }

    public final void a(com.baidu.tieba.c.a aVar) {
        this.q = aVar;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a == null || this.a.e() == null || this.a.e().size() <= 0) {
            return 0;
        }
        com.baidu.tieba.data.ai aiVar = this.a.e().get(this.a.e().size() - 1);
        if (!this.e && aiVar.e() == 1) {
            return this.a.e().size() - 1;
        }
        return this.a.e().size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.a == null || this.a.e() == null || i < 0 || i >= this.a.e().size()) {
            return null;
        }
        return this.a.e().get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final void c(boolean z) {
        this.d = z;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final int e() {
        return this.s;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        ListView a;
        ImageView imageView2;
        this.t = TbadkApplication.j().l();
        View a2 = view == null ? a(viewGroup, false) : view;
        bc bcVar = (bc) a2.getTag();
        com.baidu.tieba.data.ai aiVar = (com.baidu.tieba.data.ai) getItem(i);
        PbActivity pbActivity = (PbActivity) this.b;
        Resources resources = pbActivity.getResources();
        if (this.t == 1) {
            bcVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_b_1));
            bcVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_b_1));
            if (bcVar.u != null) {
                bcVar.u.setTextColor(resources.getColor(com.baidu.tieba.a.e.subpb_listitem_time_1));
            }
            if (bcVar.w != null) {
                bcVar.w.setTextColor(resources.getColor(com.baidu.tieba.a.e.common_link_text_1));
            }
            bcVar.f.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_f_1));
            bcVar.g.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_i_1));
            bcVar.h.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_d_1));
            bcVar.i.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_d_1));
            bcVar.k.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector_1);
            bcVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_b_1));
            bcVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_e_1));
            bcVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_e_1));
            bcVar.o.setImageResource(com.baidu.tieba.a.e.cp_bg_line_b_1);
            imageView2 = bcVar.D;
            imageView2.setImageResource(com.baidu.tieba.a.e.cp_bg_line_b_1);
        } else {
            bcVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_b));
            bcVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_b));
            if (bcVar.u != null) {
                bcVar.u.setTextColor(resources.getColor(com.baidu.tieba.a.e.subpb_listitem_time));
            }
            if (bcVar.w != null) {
                bcVar.w.setTextColor(resources.getColor(com.baidu.tieba.a.e.common_link_text));
            }
            bcVar.f.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_f));
            bcVar.g.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_i));
            bcVar.h.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_d));
            bcVar.i.setTextColor(resources.getColor(com.baidu.tieba.a.e.cp_cont_d));
            bcVar.k.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector);
            bcVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_b));
            bcVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_e));
            bcVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.a.e.cp_bg_line_e));
            bcVar.o.setImageResource(com.baidu.tieba.a.e.cp_bg_line_b);
            imageView = bcVar.D;
            imageView.setImageResource(com.baidu.tieba.a.e.cp_bg_line_b);
        }
        if (aiVar != null) {
            a(bcVar, aiVar, a2, false, i);
        }
        if (!this.w && this.x && bcVar != null && bcVar.l.a() && (a = pbActivity.a()) != null) {
            this.w = true;
            CompatibleUtile.getInstance().closeViewGpu(a);
        }
        return a2;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bc bcVar = new bc(this, (byte) 0);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.new_pb_list_item, viewGroup, false);
        bcVar.d = inflate.findViewById(com.baidu.tieba.a.h.sub_pb_more);
        bcVar.e = (HeadImageView) inflate.findViewById(com.baidu.tieba.a.h.photo);
        bcVar.f = (TextView) inflate.findViewById(com.baidu.tieba.a.h.user_name);
        bcVar.g = (TextView) inflate.findViewById(com.baidu.tieba.a.h.user_rank);
        bcVar.k = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.reply);
        bcVar.l = (TbRichTextView) inflate.findViewById(com.baidu.tieba.a.h.richText);
        bcVar.m = inflate.findViewById(com.baidu.tieba.a.h.pb_item_praise_topline);
        bcVar.n = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.a.h.pb_item_praise_view);
        bcVar.o = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.pb_item_praise_bottomline);
        bcVar.j = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.floor_owner);
        bcVar.h = (TextView) inflate.findViewById(com.baidu.tieba.a.h.floor);
        bcVar.i = (TextView) inflate.findViewById(com.baidu.tieba.a.h.time);
        bcVar.p = (RelativeLayout) inflate.findViewById(com.baidu.tieba.a.h.pb_post_header_layout);
        bcVar.q = (SubPbLayout) inflate.findViewById(com.baidu.tieba.a.h.pb_post_footer_layout);
        bcVar.C = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.pb_subpb_layout_root);
        bcVar.D = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.pb_post_footer_layout_line_top);
        bcVar.f.setOnClickListener(this.i);
        bcVar.k.setOnClickListener(this.l);
        bcVar.e.setOnClickListener(this.i);
        bcVar.a = inflate;
        bcVar.b = inflate.findViewById(com.baidu.tieba.a.h.new_pb_list_item_line_top);
        bcVar.c = inflate.findViewById(com.baidu.tieba.a.h.new_pb_list_item_line_top_full);
        bcVar.p.setOnLongClickListener(this.p);
        bcVar.l.setOnLongClickListener(this.p);
        if (this.s < 0) {
            this.s = (((com.baidu.adp.lib.util.i.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bcVar.l.getPaddingLeft()) - bcVar.l.getPaddingRight();
        }
        bcVar.p.setOnTouchListener(this.q);
        bcVar.l.setOnTouchListener(this.q);
        this.s = this.f > this.s ? this.s : this.f;
        int dimension = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds104);
        if (this.s > dimension) {
            bcVar.l.setMaxImageWidth(this.s - dimension);
        } else {
            bcVar.l.setMaxImageWidth(this.s);
        }
        bcVar.l.setMaxImageHeight((int) (this.s * 1.618f));
        bcVar.l.setTextSize(com.baidu.tbadk.core.data.n.p());
        if (!this.d) {
            ViewGroup.LayoutParams layoutParams = bcVar.e.getLayoutParams();
            layoutParams.width = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds30);
            bcVar.e.setLayoutParams(layoutParams);
            bcVar.e.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = bcVar.e.getLayoutParams();
            layoutParams2.width = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds60);
            bcVar.e.setLayoutParams(layoutParams2);
            bcVar.e.setVisibility(0);
        }
        bcVar.l.a(this.c, false);
        bcVar.l.setVoiceViewRes(com.baidu.tieba.a.i.voice_play_btn);
        bcVar.l.setOnImageClickListener(this.m);
        bcVar.l.setOnEmotionClickListener(this.n);
        bcVar.r = (UserIconBox) inflate.findViewById(com.baidu.tieba.a.h.user_icon_box);
        bcVar.r.setOnClickListener(this.j);
        bcVar.s = (UserIconBox) inflate.findViewById(com.baidu.tieba.a.h.user_tshow_icon_box);
        bcVar.s.setOnClickListener(this.k);
        bcVar.t = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.add_post_footer_layout);
        inflate.setTag(bcVar);
        if (z) {
            bcVar.p.setVisibility(8);
            bcVar.k.setVisibility(8);
            bcVar.l.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bcVar.l.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            bcVar.l.setLayoutParams(layoutParams3);
            inflate.findViewById(com.baidu.tieba.a.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            bcVar.v = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.add_time_container);
            bcVar.u = (TextView) inflate.findViewById(com.baidu.tieba.a.h.add_time);
            bcVar.w = (Button) inflate.findViewById(com.baidu.tieba.a.h.manage_btn);
            bcVar.v.setVisibility(0);
        }
        bcVar.x = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.addition_more_container);
        bcVar.y = (TextView) bcVar.x.findViewById(com.baidu.tieba.a.h.addition_more);
        bcVar.z = bcVar.x.findViewById(com.baidu.tieba.a.h.addition_divider1);
        bcVar.A = bcVar.x.findViewById(com.baidu.tieba.a.h.addition_divider2);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x045d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x08a9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x08ea  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x091f  */
    /* JADX WARN: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bc bcVar, com.baidu.tieba.data.ai aiVar, View view, boolean z, int i) {
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
        if (bcVar != null && aiVar != null) {
            if (!z) {
                bcVar.e.setTag(null);
                bcVar.e.setUserId(null);
                bcVar.f.setText((CharSequence) null);
                bcVar.g.setText((CharSequence) null);
                bcVar.g.setBackgroundDrawable(null);
                bcVar.q.setVisibility(0);
                bcVar.k.setVisibility(0);
                bcVar.j.setVisibility(8);
                SparseArray sparseArray2 = (SparseArray) bcVar.p.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bcVar.p.setTag(sparseArray2);
                    bcVar.l.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.a.h.tag_clip_board, aiVar);
                sparseArray2.put(com.baidu.tieba.a.h.tag_is_subpb, false);
                if (TextUtils.isEmpty(aiVar.i()) || !this.c) {
                    sparseArray2.put(com.baidu.tieba.a.h.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bcVar.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bcVar.l.setLayoutParams(layoutParams);
                    bcVar.l.setPadding(0, 0, 0, 0);
                    bcVar.l.setBackgroundDrawable(null);
                    bcVar.l.setBackgroundImageUrl(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.a.h.tag_richtext_bg, aiVar.i());
                    if (aiVar.e() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bcVar.l.getLayoutParams();
                        layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds16);
                        layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds40);
                        bcVar.l.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bcVar.l.getLayoutParams();
                        layoutParams3.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds20);
                        layoutParams3.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds20);
                        bcVar.l.setLayoutParams(layoutParams3);
                    }
                    a(aiVar.i(), bcVar.l);
                }
                bcVar.i.setText(com.baidu.tbadk.core.util.bc.a(aiVar.f()));
                if (aiVar.e() == 1) {
                    if (this.t == 1) {
                        bcVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_d_1));
                    } else {
                        bcVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_d));
                    }
                    bcVar.b.setVisibility(8);
                    bcVar.c.setVisibility(8);
                    bcVar.p.setVisibility(8);
                    bcVar.i.setVisibility(8);
                    if (this.e) {
                        PraiseData k = this.a.d().k();
                        if (k != null && k.getUser() != null && k.getUser().size() > 0) {
                            bcVar.n.setVisibility(0);
                            bcVar.m.setVisibility(0);
                            bcVar.o.setVisibility(0);
                            bcVar.n.setImageLoad(this.h);
                            bcVar.n.setIsFromPb(true);
                            bcVar.n.a(k, this.a.d().l(), k.getPostId(), true);
                            bcVar.n.a(this.t);
                        } else {
                            bcVar.n.setVisibility(8);
                            bcVar.m.setVisibility(8);
                            bcVar.o.setVisibility(8);
                        }
                    } else {
                        bcVar.n.setVisibility(8);
                        bcVar.m.setVisibility(8);
                        bcVar.o.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) bcVar.l.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds30);
                } else {
                    if (this.t == 1) {
                        bcVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_e_1));
                    } else {
                        bcVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_e));
                    }
                    if (i == 1) {
                        if (this.e) {
                            bcVar.b.setVisibility(8);
                            bcVar.c.setVisibility(8);
                            PraiseData k2 = this.a.d().k();
                            if (k2 != null && k2.getUser() != null && k2.getUser().size() > 0) {
                                bcVar.c.setVisibility(8);
                                bcVar.b.setVisibility(0);
                            } else {
                                bcVar.c.setVisibility(0);
                                bcVar.b.setVisibility(8);
                            }
                        } else {
                            bcVar.b.setVisibility(0);
                            bcVar.c.setVisibility(8);
                        }
                    } else {
                        bcVar.b.setVisibility(0);
                        bcVar.c.setVisibility(8);
                    }
                    bcVar.n.setVisibility(8);
                    bcVar.m.setVisibility(8);
                    bcVar.o.setVisibility(8);
                    bcVar.p.setVisibility(0);
                    bcVar.i.setVisibility(0);
                    String format = String.format(this.b.getString(com.baidu.tieba.a.k.is_floor), Integer.valueOf(aiVar.e()));
                    bcVar.h.setVisibility(0);
                    bcVar.h.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) bcVar.l.getLayoutParams();
                    if (!this.d) {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds104);
                    }
                    linearLayout3 = bcVar.C;
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.d) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds30);
                    }
                }
                if (this.g != null && !this.g.equals("0") && this.g.equals(aiVar.g().getUserId())) {
                    bcVar.j.setVisibility(0);
                    if (this.t == 1) {
                        bcVar.j.setImageResource(com.baidu.tieba.a.g.icon_floorhost_1);
                    } else {
                        bcVar.j.setImageResource(com.baidu.tieba.a.g.icon_floorhost);
                    }
                }
            }
            if (TbadkApplication.j().l() == 1) {
                bcVar.d.setBackgroundResource(com.baidu.tieba.a.g.bg_floor_new_middle_1);
                bcVar.l.setVideoImageId(com.baidu.tieba.a.g.pic_video_1);
                bcVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.pb_listitem_content_1));
                bcVar.k.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector_1);
                bcVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text_1));
            } else {
                bcVar.d.setBackgroundResource(com.baidu.tieba.a.g.bg_floor_new_middle);
                bcVar.l.setVideoImageId(com.baidu.tieba.a.g.pic_video);
                bcVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.pb_listitem_content));
                bcVar.k.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector);
                bcVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) bcVar.k.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bcVar.k.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.a.h.tag_clip_board, aiVar);
            sparseArray.put(com.baidu.tieba.a.h.tag_load_sub_data, aiVar);
            sparseArray.put(com.baidu.tieba.a.h.tag_load_sub_view, view);
            if (aiVar.k() > 0 && aiVar.a() != null && aiVar.a().size() > 0) {
                if (this.o == null) {
                    this.o = new com.baidu.tieba.pb.sub.b(this.b, this.i);
                    this.o.a(this.r);
                    boolean z7 = false;
                    String userId = this.a.d().t().getUserId();
                    if (userId != null && userId.equals(TbadkApplication.E())) {
                        z7 = true;
                    }
                    this.o.a(this.a.l(), z7);
                    com.baidu.tieba.pb.sub.b bVar = this.o;
                    boolean z8 = this.d;
                    bVar.b();
                }
                bcVar.q.setVisibility(0);
                imageView2 = bcVar.D;
                imageView2.setVisibility(0);
                linearLayout2 = bcVar.C;
                linearLayout2.setVisibility(0);
                bcVar.q.a(aiVar, view);
                bcVar.q.setChildOnClickListener(this.l);
                bcVar.q.setChildOnLongClickListener(this.p);
                bcVar.q.setChildOnTouchListener(this.q);
                bcVar.q.setSubPbAdapter(this.o);
                bcVar.q.setVisibility(0);
            } else {
                bcVar.q.setVisibility(8);
                imageView = bcVar.D;
                imageView.setVisibility(8);
                linearLayout = bcVar.C;
                linearLayout.setVisibility(8);
            }
            this.a.n();
            a(bcVar, aiVar, i);
            if (!z) {
                String portrait = aiVar.g().getPortrait();
                com.baidu.tbadk.editortool.ab abVar = this.h;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                if (aiVar.g() != null) {
                    bcVar.f.setText(aiVar.g().getName_show());
                    LinkedList<IconData> tShowInfo = aiVar.g().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        if (this.t == 1) {
                            bcVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_h_1));
                        } else {
                            bcVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_h));
                        }
                    } else if (this.t == 1) {
                        bcVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f_1));
                    } else {
                        bcVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f));
                    }
                    int level_id = aiVar.g().getLevel_id();
                    int isLike = aiVar.g().getIsLike();
                    int is_bawu = aiVar.g().getIs_bawu();
                    String bawu_type = aiVar.g().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0 && isLike != 0) {
                        bcVar.g.setVisibility(0);
                        bcVar.g.setText(String.valueOf(level_id));
                        bcVar.g.setBackgroundResource(com.baidu.tbadk.core.util.g.b(level_id));
                        i2 = 2;
                        bcVar.g.setOnClickListener(null);
                    } else {
                        bcVar.g.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            bcVar.g.setText((CharSequence) null);
                            bcVar.g.setBackgroundResource(this.t == 1 ? com.baidu.tieba.a.g.pb_manager_1 : com.baidu.tieba.a.g.pb_manager);
                            bcVar.g.setOnClickListener(this.j);
                        } else if (bawu_type.equals("assist")) {
                            bcVar.g.setText((CharSequence) null);
                            bcVar.g.setBackgroundResource(this.t == 1 ? com.baidu.tieba.a.g.pb_assist_1 : com.baidu.tieba.a.g.pb_assist);
                            bcVar.g.setOnClickListener(this.j);
                        }
                    }
                    this.u = aiVar.g().getIconInfo();
                    this.v = aiVar.g().getTShowInfo();
                    if (bcVar.r != null) {
                        bcVar.r.setOnClickListener(this.j);
                        bcVar.r.a(this.u, i2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_margin));
                    }
                    if (bcVar.s != null) {
                        bcVar.s.setOnClickListener(this.k);
                        bcVar.s.a(this.v, 3, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_margin), true);
                    }
                }
                bcVar.e.setUserId(aiVar.g().getUserId());
                bcVar.e.setImageBitmap(null);
                bcVar.f.setTag(aiVar.g().getUserId());
                if (b != null) {
                    b.a(bcVar.e);
                } else {
                    bcVar.e.setTag(portrait);
                    bcVar.e.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
                }
            }
            if (this.t == 1) {
                bcVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text_1));
                bcVar.l.setDefaultGifId(com.baidu.tieba.a.g.pic_expression_upload_selector_1);
                if (this.c) {
                    bcVar.l.setDefaultImageId(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
                    bcVar.l.setShowEmotion(true);
                } else {
                    bcVar.l.setDefaultImageId(com.baidu.tieba.a.g.icon_click_1);
                    bcVar.l.setShowEmotion(false);
                }
            } else {
                bcVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text));
                bcVar.l.setDefaultGifId(com.baidu.tieba.a.g.pic_expression_upload_selector);
                if (this.c) {
                    bcVar.l.setDefaultImageId(com.baidu.tieba.a.g.pic_baidu_logo_d);
                    bcVar.l.setShowEmotion(true);
                } else {
                    bcVar.l.setDefaultImageId(com.baidu.tieba.a.g.icon_click);
                    bcVar.l.setShowEmotion(false);
                }
            }
            if (this.w || !this.x) {
                bcVar.l.a(aiVar.h(), false);
            } else {
                bcVar.l.a(aiVar.h(), true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.a.l() != 0) {
                z9 = true;
                z10 = true;
                String userId2 = aiVar.g().getUserId();
                if (userId2 != null && userId2.equals(TbadkApplication.E())) {
                    z9 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                    if (z2 || !z3) {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.a.h.tag_should_manage_visible, true);
                            if (bcVar.w != null) {
                                bcVar.w.setVisibility(0);
                                bcVar.w.setText(com.baidu.tieba.a.k.delete);
                                if (TbadkApplication.j().l() == 1) {
                                    bcVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_delete_n_1, 0, 0, 0);
                                    z6 = true;
                                } else {
                                    bcVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_delete_n, 0, 0, 0);
                                    z6 = true;
                                }
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.a.h.tag_should_manage_visible, false);
                            if (bcVar.w != null) {
                                bcVar.w.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    } else {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.a.h.tag_should_manage_visible, true);
                        if (bcVar.w != null) {
                            bcVar.w.setVisibility(0);
                            bcVar.w.setText(com.baidu.tieba.a.k.manage);
                            if (TbadkApplication.j().l() == 1) {
                                bcVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_manage_n_1, 0, 0, 0);
                                z6 = true;
                            } else {
                                bcVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_manage_n, 0, 0, 0);
                                z6 = true;
                            }
                        }
                        z6 = z5;
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (aiVar.e() == 1) {
                        i3 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.a.h.tag_manage_user_identity, Integer.valueOf(this.a.l()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_id, aiVar.d());
                    } else {
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.a.h.tag_forbid_user_name, aiVar.g().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.a.h.tag_forbid_user_name, "");
                    }
                    if (z) {
                        bcVar.k.setVisibility(8);
                        if (this.t == 1) {
                            bcVar.u.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.subpb_listitem_time_1));
                        } else {
                            bcVar.u.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.subpb_listitem_time));
                        }
                        bcVar.u.setText(String.format(this.b.getResources().getString(com.baidu.tieba.a.k.write_addition_update), com.baidu.tbadk.core.util.bc.a(aiVar.f())));
                        if (bcVar.w.getVisibility() == 0) {
                            if (TbadkApplication.j().l() == 1) {
                                bcVar.w.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text_1));
                            } else {
                                bcVar.w.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text));
                            }
                            bcVar.w.setTag(sparseArray);
                            bcVar.w.setOnClickListener(this.r);
                            return;
                        }
                        return;
                    }
                    return;
                }
                z2 = z10;
                z3 = z9;
                z4 = false;
                if (z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i32 = 1;
                if (z) {
                }
                if (aiVar.e() == 1) {
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
                String userId3 = this.a.d().t().getUserId();
                if (userId3 != null && userId3.equals(TbadkApplication.E())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = aiVar.g().getUserId();
                    if (userId4 != null && userId4.equals(TbadkApplication.E())) {
                        z2 = true;
                        z3 = false;
                        z4 = true;
                    }
                    z2 = z10;
                    z3 = z9;
                    z4 = false;
                }
                if (z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i322 = 1;
                if (z) {
                }
                if (aiVar.e() == 1) {
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

    private void a(String str, TbRichTextView tbRichTextView) {
        if (str != null && !str.equals(tbRichTextView.getBackgroundImageUrl())) {
            com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(str);
            if (c != null) {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.b.getResources(), c.h(), c.h().getNinePatchChunk(), c.l(), null);
                if (TbadkApplication.j().l() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(bm.a);
                }
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
                tbRichTextView.setBackgroundImageUrl(str);
                return;
            }
            tbRichTextView.setBackgroundImageUrl(null);
            tbRichTextView.setBackgroundDrawable(null);
        }
    }

    public final void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.m = rVar;
    }

    public final void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.n = qVar;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkApplication.j().b().getString(com.baidu.tieba.a.k.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TbadkApplication.j().l() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.a.e.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.a.e.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.a.e.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.a.e.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }

    private void a(bc bcVar, com.baidu.tieba.data.ai aiVar, int i) {
        if (aiVar.l() > 0 && aiVar.c() != null) {
            bcVar.t.setVisibility(0);
            bcVar.t.removeViews(0, bcVar.t.getChildCount() - 1);
            int size = aiVar.c().size();
            int n = aiVar.n();
            for (int i2 = 0; i2 < n; i2++) {
                com.baidu.tieba.data.ai aiVar2 = aiVar.c().get(i2);
                View a = a((ViewGroup) bcVar.t, true);
                bc bcVar2 = (bc) a.getTag();
                a(bcVar2, aiVar2, bcVar.t, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.a.h.tag_clip_board, aiVar2);
                sparseArray.put(com.baidu.tieba.a.h.tag_is_subpb, true);
                if (TextUtils.isEmpty(aiVar2.i()) || !this.c) {
                    sparseArray.put(com.baidu.tieba.a.h.tag_richtext_bg, null);
                    bcVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bcVar2.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bcVar2.l.setLayoutParams(layoutParams);
                    bcVar2.l.setPadding(0, 0, 0, 0);
                    bcVar2.l.setBackgroundImageUrl(null);
                    bcVar2.l.setBackgroundDrawable(null);
                } else {
                    sparseArray.put(com.baidu.tieba.a.h.tag_richtext_bg, aiVar2.i());
                    bcVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bcVar2.l.getLayoutParams();
                    layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds16);
                    layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds36);
                    bcVar2.l.setLayoutParams(layoutParams2);
                    a(aiVar2.i(), bcVar2.l);
                }
                bcVar.t.addView(a, bcVar.t.getChildCount() - 1);
            }
            if (n < size) {
                bcVar.x.setVisibility(0);
                if (this.t == 1) {
                    bcVar.z.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b_1);
                    bcVar.A.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b_1);
                    bcVar.y.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f_1));
                } else {
                    bcVar.z.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b);
                    bcVar.A.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b);
                    bcVar.y.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f));
                }
                bcVar.x.setOnClickListener(new bb(this, n, size, aiVar));
                return;
            }
            bcVar.x.setVisibility(8);
            return;
        }
        bcVar.t.setVisibility(8);
    }
}
