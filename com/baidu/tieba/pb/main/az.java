package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdditionData;
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
public class az extends BaseAdapter {
    private Context b;
    private final boolean y;
    private com.baidu.tieba.data.ae a = null;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private int f = 0;
    private String g = null;
    private com.baidu.tbadk.editortool.ab h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private View.OnClickListener k = null;
    private View.OnClickListener l = null;
    private com.baidu.tbadk.widget.richText.s m = null;
    private com.baidu.tbadk.widget.richText.r n = null;
    private com.baidu.tieba.pb.sub.b o = null;
    private View.OnLongClickListener p = null;
    private com.baidu.tieba.b.a q = null;
    private View.OnClickListener r = null;
    private int s = -1;
    private int t = 0;
    private LinkedList<IconData> u = null;
    private LinkedList<IconData> v = null;
    private boolean w = false;
    private boolean x = false;

    public az(Context context) {
        boolean z = true;
        this.b = null;
        this.y = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        f();
    }

    private void f() {
        this.f = Math.min(com.baidu.adp.lib.util.h.a(this.b, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        g();
        this.t = TbadkApplication.m252getInst().getSkinType();
    }

    private void g() {
        this.h = new com.baidu.tbadk.editortool.ab(this.b);
        this.h.f("pb");
        this.h.a(this.f, (int) (this.f * 1.6f));
    }

    public void a(com.baidu.tieba.data.ae aeVar) {
        this.a = aeVar;
        if (aeVar.d() != null && aeVar.d().t() != null) {
            this.g = aeVar.d().t().getUserId();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public com.baidu.tbadk.editortool.ab a() {
        return this.h;
    }

    public void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void d(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void e(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.p = onLongClickListener;
    }

    public View.OnLongClickListener b() {
        return this.p;
    }

    public void a(com.baidu.tieba.b.a aVar) {
        this.q = aVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.e() == null || this.a.e().size() < 1) {
            return 0;
        }
        com.baidu.tieba.data.ah ahVar = this.a.e().get(this.a.e().size() - 1);
        if (!this.e && ahVar.e() == 1) {
            return this.a.e().size() - 1;
        }
        return this.a.e().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || this.a.e() == null || i < 0 || i >= this.a.e().size()) {
            return null;
        }
        return this.a.e().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.s;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        ListView a;
        ImageView imageView2;
        this.t = TbadkApplication.m252getInst().getSkinType();
        View a2 = view == null ? a(viewGroup, false) : view;
        bb bbVar = (bb) a2.getTag();
        com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) getItem(i);
        PbActivity pbActivity = (PbActivity) this.b;
        Resources resources = pbActivity.getResources();
        if (this.t == 1) {
            bbVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_b_1));
            bbVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_b_1));
            if (bbVar.u != null) {
                bbVar.u.setTextColor(resources.getColor(com.baidu.tieba.o.subpb_listitem_time_1));
            }
            if (bbVar.w != null) {
                bbVar.w.setTextColor(resources.getColor(com.baidu.tieba.o.common_link_text_1));
            }
            bbVar.f.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_f_1));
            bbVar.g.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_i_1));
            bbVar.h.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_d_1));
            bbVar.i.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_d_1));
            bbVar.k.setImageResource(com.baidu.tieba.q.btn_pb_reply_selector_1);
            bbVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_b_1));
            bbVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_e_1));
            bbVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_e_1));
            bbVar.o.setImageResource(com.baidu.tieba.o.cp_bg_line_b_1);
            imageView2 = bbVar.D;
            imageView2.setImageResource(com.baidu.tieba.o.cp_bg_line_b_1);
        } else {
            bbVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_b));
            bbVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_b));
            if (bbVar.u != null) {
                bbVar.u.setTextColor(resources.getColor(com.baidu.tieba.o.subpb_listitem_time));
            }
            if (bbVar.w != null) {
                bbVar.w.setTextColor(resources.getColor(com.baidu.tieba.o.common_link_text));
            }
            bbVar.f.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_f));
            bbVar.g.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_i));
            bbVar.h.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_d));
            bbVar.i.setTextColor(resources.getColor(com.baidu.tieba.o.cp_cont_d));
            bbVar.k.setImageResource(com.baidu.tieba.q.btn_pb_reply_selector);
            bbVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_b));
            bbVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_e));
            bbVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.o.cp_bg_line_e));
            bbVar.o.setImageResource(com.baidu.tieba.o.cp_bg_line_b);
            imageView = bbVar.D;
            imageView.setImageResource(com.baidu.tieba.o.cp_bg_line_b);
        }
        if (ahVar != null) {
            a(bbVar, ahVar, a2, false, i);
        }
        if (!this.x && this.y && bbVar != null && bbVar.l.a() && (a = pbActivity.a()) != null) {
            this.x = true;
            CompatibleUtile.getInstance().closeViewGpu(a);
        }
        return a2;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bb bbVar = new bb(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.s.new_pb_list_item, viewGroup, false);
        bbVar.d = inflate.findViewById(com.baidu.tieba.r.sub_pb_more);
        bbVar.e = (HeadImageView) inflate.findViewById(com.baidu.tieba.r.photo);
        bbVar.f = (TextView) inflate.findViewById(com.baidu.tieba.r.user_name);
        bbVar.g = (TextView) inflate.findViewById(com.baidu.tieba.r.user_rank);
        bbVar.k = (ImageView) inflate.findViewById(com.baidu.tieba.r.reply);
        bbVar.l = (TbRichTextView) inflate.findViewById(com.baidu.tieba.r.richText);
        bbVar.m = inflate.findViewById(com.baidu.tieba.r.pb_item_praise_topline);
        bbVar.n = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.r.pb_item_praise_view);
        bbVar.o = (ImageView) inflate.findViewById(com.baidu.tieba.r.pb_item_praise_bottomline);
        bbVar.j = (ImageView) inflate.findViewById(com.baidu.tieba.r.floor_owner);
        bbVar.h = (TextView) inflate.findViewById(com.baidu.tieba.r.floor);
        bbVar.i = (TextView) inflate.findViewById(com.baidu.tieba.r.time);
        bbVar.p = (RelativeLayout) inflate.findViewById(com.baidu.tieba.r.pb_post_header_layout);
        bbVar.q = (SubPbLayout) inflate.findViewById(com.baidu.tieba.r.pb_post_footer_layout);
        bbVar.C = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.pb_subpb_layout_root);
        bbVar.D = (ImageView) inflate.findViewById(com.baidu.tieba.r.pb_post_footer_layout_line_top);
        bbVar.f.setOnClickListener(this.i);
        bbVar.k.setOnClickListener(this.l);
        bbVar.e.setOnClickListener(this.i);
        bbVar.a = inflate;
        bbVar.b = inflate.findViewById(com.baidu.tieba.r.new_pb_list_item_line_top);
        bbVar.c = inflate.findViewById(com.baidu.tieba.r.new_pb_list_item_line_top_full);
        bbVar.p.setOnLongClickListener(this.p);
        bbVar.l.setOnLongClickListener(this.p);
        if (this.s < 0) {
            this.s = (((com.baidu.adp.lib.util.h.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bbVar.l.getPaddingLeft()) - bbVar.l.getPaddingRight();
        }
        bbVar.p.setOnTouchListener(this.q);
        bbVar.l.setOnTouchListener(this.q);
        this.s = this.f > this.s ? this.s : this.f;
        int dimension = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds104);
        if (this.s > dimension) {
            bbVar.l.setMaxImageWidth(this.s - dimension);
        } else {
            bbVar.l.setMaxImageWidth(this.s);
        }
        bbVar.l.setMaxImageHeight((int) (this.s * 1.618f));
        bbVar.l.setTextSize(TbConfig.getContentSize());
        if (!this.d) {
            ViewGroup.LayoutParams layoutParams = bbVar.e.getLayoutParams();
            layoutParams.width = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds30);
            bbVar.e.setLayoutParams(layoutParams);
            bbVar.e.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = bbVar.e.getLayoutParams();
            layoutParams2.width = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds60);
            bbVar.e.setLayoutParams(layoutParams2);
            bbVar.e.setVisibility(0);
        }
        bbVar.l.a(this.c, false);
        bbVar.l.setVoiceViewRes(com.baidu.tieba.s.voice_play_btn);
        bbVar.l.setOnImageClickListener(this.m);
        bbVar.l.setOnEmotionClickListener(this.n);
        bbVar.r = (UserIconBox) inflate.findViewById(com.baidu.tieba.r.user_icon_box);
        bbVar.r.setOnClickListener(this.j);
        bbVar.s = (UserIconBox) inflate.findViewById(com.baidu.tieba.r.user_tshow_icon_box);
        bbVar.s.setOnClickListener(this.k);
        bbVar.t = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.add_post_footer_layout);
        inflate.setTag(bbVar);
        if (z) {
            bbVar.p.setVisibility(8);
            bbVar.k.setVisibility(8);
            bbVar.l.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bbVar.l.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            bbVar.l.setLayoutParams(layoutParams3);
            inflate.findViewById(com.baidu.tieba.r.pb_list_item_layout).setPadding(0, 0, 0, 0);
            bbVar.v = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.add_time_container);
            bbVar.u = (TextView) inflate.findViewById(com.baidu.tieba.r.add_time);
            bbVar.w = (Button) inflate.findViewById(com.baidu.tieba.r.manage_btn);
            bbVar.v.setVisibility(0);
        }
        bbVar.x = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.addition_more_container);
        bbVar.y = (TextView) bbVar.x.findViewById(com.baidu.tieba.r.addition_more);
        bbVar.z = bbVar.x.findViewById(com.baidu.tieba.r.addition_divider1);
        bbVar.A = bbVar.x.findViewById(com.baidu.tieba.r.addition_divider2);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0456 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x08d3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0909  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bb bbVar, com.baidu.tieba.data.ah ahVar, View view, boolean z, int i) {
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
        if (bbVar != null && ahVar != null) {
            if (!z) {
                bbVar.e.setTag(null);
                bbVar.e.setUserId(null);
                bbVar.f.setText((CharSequence) null);
                bbVar.g.setText((CharSequence) null);
                bbVar.g.setBackgroundDrawable(null);
                bbVar.q.setVisibility(0);
                bbVar.k.setVisibility(0);
                bbVar.j.setVisibility(8);
                SparseArray sparseArray2 = (SparseArray) bbVar.p.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bbVar.p.setTag(sparseArray2);
                    bbVar.l.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.r.tag_clip_board, ahVar);
                sparseArray2.put(com.baidu.tieba.r.tag_is_subpb, false);
                if (TextUtils.isEmpty(ahVar.i()) || !this.c) {
                    sparseArray2.put(com.baidu.tieba.r.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bbVar.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bbVar.l.setLayoutParams(layoutParams);
                    bbVar.l.setPadding(0, 0, 0, 0);
                    bbVar.l.a((String) null);
                } else {
                    sparseArray2.put(com.baidu.tieba.r.tag_richtext_bg, ahVar.i());
                    bbVar.l.a(ahVar.i());
                    if (ahVar.e() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bbVar.l.getLayoutParams();
                        layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds16);
                        layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds40);
                        bbVar.l.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bbVar.l.getLayoutParams();
                        layoutParams3.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds20);
                        layoutParams3.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds20);
                        bbVar.l.setLayoutParams(layoutParams3);
                    }
                }
                bbVar.i.setText(com.baidu.tbadk.core.util.be.a(ahVar.f()));
                if (ahVar.e() == 1) {
                    if (this.t == 1) {
                        bbVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_bg_line_d_1));
                    } else {
                        bbVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_bg_line_d));
                    }
                    bbVar.b.setVisibility(8);
                    bbVar.c.setVisibility(8);
                    bbVar.p.setVisibility(8);
                    bbVar.i.setVisibility(8);
                    if (this.e) {
                        PraiseData j = this.a.d().j();
                        if (j != null && j.getUser() != null && j.getUser().size() > 0) {
                            bbVar.n.setVisibility(0);
                            bbVar.m.setVisibility(0);
                            bbVar.o.setVisibility(0);
                            bbVar.n.setIsFromPb(true);
                            bbVar.n.a(j, this.a.d().k(), j.getPostId(), true);
                            bbVar.n.a(this.t);
                        } else {
                            bbVar.n.setVisibility(8);
                            bbVar.m.setVisibility(8);
                            bbVar.o.setVisibility(8);
                        }
                    } else {
                        bbVar.n.setVisibility(8);
                        bbVar.m.setVisibility(8);
                        bbVar.o.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) bbVar.l.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds30);
                } else {
                    if (this.t == 1) {
                        bbVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_bg_line_e_1));
                    } else {
                        bbVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_bg_line_e));
                    }
                    if (i == 1) {
                        if (this.e) {
                            bbVar.b.setVisibility(8);
                            bbVar.c.setVisibility(8);
                            PraiseData j2 = this.a.d().j();
                            if (j2 != null && j2.getUser() != null && j2.getUser().size() > 0) {
                                bbVar.c.setVisibility(8);
                                bbVar.b.setVisibility(0);
                            } else {
                                bbVar.c.setVisibility(0);
                                bbVar.b.setVisibility(8);
                            }
                        } else {
                            bbVar.b.setVisibility(0);
                            bbVar.c.setVisibility(8);
                        }
                    } else {
                        bbVar.b.setVisibility(0);
                        bbVar.c.setVisibility(8);
                    }
                    bbVar.n.setVisibility(8);
                    bbVar.m.setVisibility(8);
                    bbVar.o.setVisibility(8);
                    bbVar.p.setVisibility(0);
                    bbVar.i.setVisibility(0);
                    String format = String.format(this.b.getString(com.baidu.tieba.u.is_floor), Integer.valueOf(ahVar.e()));
                    bbVar.h.setVisibility(0);
                    bbVar.h.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) bbVar.l.getLayoutParams();
                    if (!this.d) {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds104);
                    }
                    linearLayout3 = bbVar.C;
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.d) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds30);
                    }
                }
                if (this.g != null && !this.g.equals("0") && this.g.equals(ahVar.g().getUserId())) {
                    bbVar.j.setVisibility(0);
                    if (this.t == 1) {
                        bbVar.j.setImageResource(com.baidu.tieba.q.icon_floorhost_1);
                    } else {
                        bbVar.j.setImageResource(com.baidu.tieba.q.icon_floorhost);
                    }
                }
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                bbVar.d.setBackgroundResource(com.baidu.tieba.q.bg_floor_new_middle_1);
                bbVar.l.setVideoImageId(com.baidu.tieba.q.pic_video_1);
                bbVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.pb_listitem_content_1));
                bbVar.k.setImageResource(com.baidu.tieba.q.btn_pb_reply_selector_1);
                bbVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.o.common_link_text_1));
            } else {
                bbVar.d.setBackgroundResource(com.baidu.tieba.q.bg_floor_new_middle);
                bbVar.l.setVideoImageId(com.baidu.tieba.q.pic_video);
                bbVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.pb_listitem_content));
                bbVar.k.setImageResource(com.baidu.tieba.q.btn_pb_reply_selector);
                bbVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.o.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) bbVar.k.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bbVar.k.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.r.tag_clip_board, ahVar);
            sparseArray.put(com.baidu.tieba.r.tag_load_sub_data, ahVar);
            sparseArray.put(com.baidu.tieba.r.tag_load_sub_view, view);
            if (ahVar.k() > 0 && ahVar.a() != null && ahVar.a().size() > 0) {
                if (this.o == null) {
                    this.o = new com.baidu.tieba.pb.sub.b(this.b, this.i);
                    this.o.a(this.w);
                    this.o.a(this.r);
                    boolean z7 = false;
                    String userId = this.a.d().t().getUserId();
                    if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.o.a(this.a.l(), z7);
                    this.o.b(this.d);
                }
                bbVar.q.setVisibility(0);
                imageView2 = bbVar.D;
                imageView2.setVisibility(0);
                linearLayout2 = bbVar.C;
                linearLayout2.setVisibility(0);
                bbVar.q.a(ahVar, view);
                bbVar.q.setChildOnClickListener(this.l);
                bbVar.q.setChildOnLongClickListener(this.p);
                bbVar.q.setChildOnTouchListener(this.q);
                bbVar.q.setSubPbAdapter(this.o);
                bbVar.q.setVisibility(0);
            } else {
                bbVar.q.setVisibility(8);
                imageView = bbVar.D;
                imageView.setVisibility(8);
                linearLayout = bbVar.C;
                linearLayout.setVisibility(8);
            }
            a(bbVar, ahVar, this.a.n(), i);
            if (!z) {
                String portrait = ahVar.g().getPortrait();
                if (ahVar.g() != null) {
                    bbVar.f.setText(ahVar.g().getName_show());
                    LinkedList<IconData> tShowInfo = ahVar.g().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        if (this.t == 1) {
                            bbVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_cont_h_1));
                        } else {
                            bbVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_cont_h));
                        }
                    } else if (this.t == 1) {
                        bbVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_cont_f_1));
                    } else {
                        bbVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_cont_f));
                    }
                    int level_id = ahVar.g().getLevel_id();
                    int is_bawu = ahVar.g().getIs_bawu();
                    String bawu_type = ahVar.g().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        bbVar.g.setVisibility(0);
                        bbVar.g.setText(String.valueOf(level_id));
                        bbVar.g.setBackgroundResource(com.baidu.tbadk.core.util.g.b(level_id));
                        i2 = 2;
                        bbVar.g.setOnClickListener(null);
                    } else {
                        bbVar.g.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            bbVar.g.setText((CharSequence) null);
                            bbVar.g.setBackgroundResource(this.t == 1 ? com.baidu.tieba.q.pb_manager_1 : com.baidu.tieba.q.pb_manager);
                            bbVar.g.setOnClickListener(this.j);
                        } else if (bawu_type.equals("assist")) {
                            bbVar.g.setText((CharSequence) null);
                            bbVar.g.setBackgroundResource(this.t == 1 ? com.baidu.tieba.q.pb_assist_1 : com.baidu.tieba.q.pb_assist);
                            bbVar.g.setOnClickListener(this.j);
                        }
                    }
                    this.u = ahVar.g().getIconInfo();
                    this.v = ahVar.g().getTShowInfo();
                    if (bbVar.r != null) {
                        bbVar.r.setOnClickListener(this.j);
                        bbVar.r.a(this.u, i2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.pb_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.pb_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.pb_icon_margin));
                    }
                    if (bbVar.s != null) {
                        bbVar.s.setOnClickListener(this.k);
                        bbVar.s.a(this.v, 3, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_margin), true);
                    }
                }
                bbVar.e.setUserId(ahVar.g().getUserId());
                bbVar.e.setImageBitmap(null);
                bbVar.f.setTag(ahVar.g().getUserId());
                bbVar.e.setDefaultResource(com.baidu.tieba.q.photo);
                bbVar.e.a(portrait, 12, false);
            }
            if (this.t == 1) {
                bbVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.o.common_link_text_1));
                bbVar.l.setDefaultGifId(com.baidu.tieba.q.pic_expression_upload_selector_1);
                if (this.c) {
                    bbVar.l.setDefaultImageId(com.baidu.tieba.q.pic_baidu_logo_d_1);
                    bbVar.l.setShowEmotion(true);
                } else {
                    bbVar.l.setDefaultImageId(com.baidu.tieba.q.icon_click_1);
                    bbVar.l.setShowEmotion(false);
                }
            } else {
                bbVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.o.common_link_text));
                bbVar.l.setDefaultGifId(com.baidu.tieba.q.pic_expression_upload_selector);
                if (this.c) {
                    bbVar.l.setDefaultImageId(com.baidu.tieba.q.pic_baidu_logo_d);
                    bbVar.l.setShowEmotion(true);
                } else {
                    bbVar.l.setDefaultImageId(com.baidu.tieba.q.icon_click);
                    bbVar.l.setShowEmotion(false);
                }
            }
            bbVar.l.setIsFromCDN(this.w);
            if (this.x || !this.y) {
                bbVar.l.a(ahVar.h(), false);
            } else {
                bbVar.l.a(ahVar.h(), true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.a.l() != 0) {
                z8 = true;
                z9 = true;
                String userId2 = ahVar.g().getUserId();
                if (userId2 != null && userId2.equals(TbadkApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                    if (z2 || !z3) {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.r.tag_should_manage_visible, true);
                            if (bbVar.w != null) {
                                bbVar.w.setVisibility(0);
                                bbVar.w.setText(com.baidu.tieba.u.delete);
                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                    bbVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.btn_delete_n_1, 0, 0, 0);
                                    z6 = true;
                                } else {
                                    bbVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.btn_delete_n, 0, 0, 0);
                                    z6 = true;
                                }
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.r.tag_should_manage_visible, false);
                            if (bbVar.w != null) {
                                bbVar.w.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    } else {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.r.tag_should_manage_visible, true);
                        if (bbVar.w != null) {
                            bbVar.w.setVisibility(0);
                            bbVar.w.setText(com.baidu.tieba.u.manage);
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                bbVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.btn_manage_n_1, 0, 0, 0);
                                z6 = true;
                            } else {
                                bbVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.btn_manage_n, 0, 0, 0);
                                z6 = true;
                            }
                        }
                        z6 = z5;
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (ahVar.e() == 1) {
                        i3 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.r.tag_manage_user_identity, Integer.valueOf(this.a.l()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.r.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.r.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(com.baidu.tieba.r.tag_del_post_id, ahVar.d());
                    } else {
                        sparseArray.put(com.baidu.tieba.r.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.r.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.r.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.r.tag_forbid_user_name, ahVar.g().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.r.tag_forbid_user_name, "");
                    }
                    if (z) {
                        bbVar.k.setVisibility(8);
                        if (this.t == 1) {
                            bbVar.u.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.subpb_listitem_time_1));
                        } else {
                            bbVar.u.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.subpb_listitem_time));
                        }
                        bbVar.u.setText(String.format(this.b.getResources().getString(com.baidu.tieba.u.write_addition_update), com.baidu.tbadk.core.util.be.a(ahVar.f())));
                        if (bbVar.w.getVisibility() == 0) {
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                bbVar.w.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.common_link_text_1));
                            } else {
                                bbVar.w.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.common_link_text));
                            }
                            bbVar.w.setTag(sparseArray);
                            bbVar.w.setOnClickListener(this.r);
                            return;
                        }
                        return;
                    }
                    return;
                }
                z2 = z9;
                z3 = z8;
                z4 = false;
                if (z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i32 = 1;
                if (z) {
                }
                if (ahVar.e() == 1) {
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
                if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = ahVar.g().getUserId();
                    if (userId4 != null && userId4.equals(TbadkApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = false;
                        z4 = true;
                    }
                    z2 = z9;
                    z3 = z8;
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
                if (ahVar.e() == 1) {
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

    public void a(com.baidu.tbadk.widget.richText.s sVar) {
        this.m = sVar;
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.n = rVar;
    }

    public void d(boolean z) {
        this.w = z;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.u.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }

    private void a(bb bbVar, com.baidu.tieba.data.ah ahVar, AdditionData additionData, int i) {
        if (ahVar.l() > 0 && ahVar.c() != null) {
            bbVar.t.setVisibility(0);
            bbVar.t.removeViews(0, bbVar.t.getChildCount() - 1);
            int size = ahVar.c().size();
            int n = ahVar.n();
            for (int i2 = 0; i2 < n; i2++) {
                com.baidu.tieba.data.ah ahVar2 = ahVar.c().get(i2);
                View a = a(bbVar.t, true);
                bb bbVar2 = (bb) a.getTag();
                a(bbVar2, ahVar2, bbVar.t, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.r.tag_clip_board, ahVar2);
                sparseArray.put(com.baidu.tieba.r.tag_is_subpb, true);
                if (TextUtils.isEmpty(ahVar2.i()) || !this.c) {
                    sparseArray.put(com.baidu.tieba.r.tag_richtext_bg, null);
                    bbVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bbVar2.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bbVar2.l.setLayoutParams(layoutParams);
                    bbVar2.l.setPadding(0, 0, 0, 0);
                    bbVar.l.a((String) null);
                } else {
                    bbVar.l.a(ahVar.i());
                    bbVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bbVar2.l.getLayoutParams();
                    layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds16);
                    layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.p.ds36);
                    bbVar2.l.setLayoutParams(layoutParams2);
                }
                bbVar.t.addView(a, bbVar.t.getChildCount() - 1);
            }
            if (n < size) {
                bbVar.x.setVisibility(0);
                if (this.t == 1) {
                    bbVar.z.setBackgroundResource(com.baidu.tieba.o.cp_bg_line_b_1);
                    bbVar.A.setBackgroundResource(com.baidu.tieba.o.cp_bg_line_b_1);
                    bbVar.y.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_cont_f_1));
                } else {
                    bbVar.z.setBackgroundResource(com.baidu.tieba.o.cp_bg_line_b);
                    bbVar.A.setBackgroundResource(com.baidu.tieba.o.cp_bg_line_b);
                    bbVar.y.setTextColor(this.b.getResources().getColor(com.baidu.tieba.o.cp_cont_f));
                }
                bbVar.x.setOnClickListener(new ba(this, n, size, ahVar));
                return;
            }
            bbVar.x.setVisibility(8);
            return;
        }
        bbVar.t.setVisibility(8);
    }
}
