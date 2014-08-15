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
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class bf extends BaseAdapter {
    private Context b;
    private final boolean x;
    private final CustomMessageListener y;
    private com.baidu.tieba.data.aj a = null;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private int f = 0;
    private String g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private View.OnClickListener k = null;
    private com.baidu.tbadk.widget.richText.s l = null;
    private com.baidu.tbadk.widget.richText.r m = null;
    private com.baidu.tieba.pb.sub.a n = null;
    private View.OnLongClickListener o = null;
    private com.baidu.tieba.c.a p = null;
    private View.OnClickListener q = null;
    private int r = -1;
    private int s = 0;
    private LinkedList<IconData> t = null;
    private LinkedList<IconData> u = null;
    private boolean v = false;
    private boolean w = false;

    public bf(Context context) {
        boolean z = true;
        this.b = null;
        this.x = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.y = new bg(this, 2001122);
        this.b = context;
        e();
    }

    private void e() {
        this.f = Math.min(com.baidu.adp.lib.util.j.a(this.b, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.s = TbadkApplication.m252getInst().getSkinType();
        if (this.b instanceof BaseActivity) {
            ((BaseActivity) this.b).registerListener(this.y);
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar) {
        boolean z;
        if (this.a != ajVar) {
            z = true;
            if (ajVar != null && !ajVar.a()) {
                z = false;
            }
        } else {
            z = false;
        }
        this.a = ajVar;
        if (z) {
            f();
            if (ajVar != null) {
                ajVar.a(false);
            }
        }
        if (ajVar != null && ajVar.d() != null && ajVar.d().q() != null) {
            this.g = ajVar.d().q().getUserId();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void c(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void e(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.o = onLongClickListener;
    }

    public View.OnLongClickListener a() {
        return this.o;
    }

    public void a(com.baidu.tieba.c.a aVar) {
        this.p = aVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.e() == null || this.a.e().size() < 1) {
            return 0;
        }
        com.baidu.tieba.data.an anVar = this.a.e().get(this.a.e().size() - 1);
        if (!this.e && anVar.e() == 1) {
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

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public int d() {
        return this.r;
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
        this.s = TbadkApplication.m252getInst().getSkinType();
        com.baidu.tieba.d.a.f fVar = (com.baidu.tieba.d.a.f) getItem(i);
        if (view == null) {
            com.baidu.tieba.d.c.a b = com.baidu.tieba.d.a.a().b(LayoutInflater.from(this.b));
            view = b.f();
            aVar = b;
        } else {
            aVar = (com.baidu.tieba.d.c.a) view.getTag();
        }
        ((BaseActivity) this.b).getLayoutMode().a(this.s == 1);
        ((BaseActivity) this.b).getLayoutMode().a(view);
        aVar.a(fVar, i, this.v);
        return view;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        com.baidu.tieba.d.c.a aVar;
        this.s = TbadkApplication.m252getInst().getSkinType();
        com.baidu.tieba.d.a.f fVar = (com.baidu.tieba.d.a.f) getItem(i);
        if (view == null) {
            com.baidu.tieba.d.c.a a = com.baidu.tieba.d.a.a().a(LayoutInflater.from(this.b));
            view = a.f();
            aVar = a;
        } else {
            aVar = (com.baidu.tieba.d.c.a) view.getTag();
        }
        ((BaseActivity) this.b).getLayoutMode().a(this.s == 1);
        ((BaseActivity) this.b).getLayoutMode().a(view);
        aVar.a(fVar, i, this.v);
        return view;
    }

    private View c(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView a;
        ImageView imageView2;
        this.s = TbadkApplication.m252getInst().getSkinType();
        View a2 = view == null ? a(viewGroup, false) : view;
        bj bjVar = (bj) a2.getTag();
        com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) getItem(i);
        PbActivity pbActivity = (PbActivity) this.b;
        Resources resources = pbActivity.getResources();
        if (this.s == 1) {
            bjVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_b_1));
            bjVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_b_1));
            if (bjVar.v != null) {
                bjVar.v.setTextColor(resources.getColor(com.baidu.tieba.r.subpb_listitem_time_1));
            }
            if (bjVar.x != null) {
                bjVar.x.setTextColor(resources.getColor(com.baidu.tieba.r.common_link_text_1));
            }
            bjVar.f.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_f_1));
            bjVar.g.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_i_1));
            bjVar.h.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_d_1));
            bjVar.i.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_d_1));
            bjVar.k.setImageResource(com.baidu.tieba.t.btn_pb_reply_selector_1);
            bjVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_b_1));
            bjVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_e_1));
            bjVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_e_1));
            bjVar.o.setImageResource(com.baidu.tieba.r.cp_bg_line_b_1);
            imageView2 = bjVar.E;
            imageView2.setImageResource(com.baidu.tieba.r.cp_bg_line_b_1);
        } else {
            bjVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_b));
            bjVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_b));
            if (bjVar.v != null) {
                bjVar.v.setTextColor(resources.getColor(com.baidu.tieba.r.subpb_listitem_time));
            }
            if (bjVar.x != null) {
                bjVar.x.setTextColor(resources.getColor(com.baidu.tieba.r.common_link_text));
            }
            bjVar.f.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_f));
            bjVar.g.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_i));
            bjVar.h.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_d));
            bjVar.i.setTextColor(resources.getColor(com.baidu.tieba.r.cp_cont_d));
            bjVar.k.setImageResource(com.baidu.tieba.t.btn_pb_reply_selector);
            bjVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_b));
            bjVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_e));
            bjVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.r.cp_bg_line_e));
            bjVar.o.setImageResource(com.baidu.tieba.r.cp_bg_line_b);
            imageView = bjVar.E;
            imageView.setImageResource(com.baidu.tieba.r.cp_bg_line_b);
        }
        if (anVar != null) {
            a(bjVar, anVar, a2, false, i);
        }
        if (!this.w && this.x && bjVar != null && bjVar.l.a() && (a = pbActivity.a()) != null) {
            this.w = true;
            CompatibleUtile.getInstance().closeViewGpu(a);
        }
        return a2;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bj bjVar = new bj(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.new_pb_list_item, viewGroup, false);
        bjVar.d = inflate.findViewById(com.baidu.tieba.u.sub_pb_more);
        bjVar.e = (HeadImageView) inflate.findViewById(com.baidu.tieba.u.photo);
        bjVar.f = (TextView) inflate.findViewById(com.baidu.tieba.u.user_name);
        bjVar.g = (TextView) inflate.findViewById(com.baidu.tieba.u.user_rank);
        bjVar.k = (ImageView) inflate.findViewById(com.baidu.tieba.u.reply);
        bjVar.l = (TbRichTextView) inflate.findViewById(com.baidu.tieba.u.richText);
        bjVar.m = inflate.findViewById(com.baidu.tieba.u.pb_item_praise_topline);
        bjVar.n = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.u.pb_item_praise_view);
        bjVar.o = (ImageView) inflate.findViewById(com.baidu.tieba.u.pb_item_praise_bottomline);
        bjVar.j = (ImageView) inflate.findViewById(com.baidu.tieba.u.floor_owner);
        bjVar.h = (TextView) inflate.findViewById(com.baidu.tieba.u.floor);
        bjVar.i = (TextView) inflate.findViewById(com.baidu.tieba.u.time);
        bjVar.p = (RelativeLayout) inflate.findViewById(com.baidu.tieba.u.pb_post_header_layout);
        bjVar.q = (SubPbLayout) inflate.findViewById(com.baidu.tieba.u.pb_post_footer_layout);
        bjVar.D = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.pb_subpb_layout_root);
        bjVar.E = (ImageView) inflate.findViewById(com.baidu.tieba.u.pb_post_footer_layout_line_top);
        bjVar.f.setOnClickListener(this.h);
        bjVar.k.setOnClickListener(this.k);
        bjVar.e.setOnClickListener(this.h);
        bjVar.a = inflate;
        bjVar.b = inflate.findViewById(com.baidu.tieba.u.new_pb_list_item_line_top);
        bjVar.c = inflate.findViewById(com.baidu.tieba.u.new_pb_list_item_line_top_full);
        bjVar.p.setOnLongClickListener(this.o);
        bjVar.l.setOnLongClickListener(this.o);
        if (this.r < 0) {
            this.r = (((com.baidu.adp.lib.util.j.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bjVar.l.getPaddingLeft()) - bjVar.l.getPaddingRight();
        }
        bjVar.p.setOnTouchListener(this.p);
        bjVar.l.setOnTouchListener(this.p);
        this.r = this.f > this.r ? this.r : this.f;
        int dimension = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds104);
        if (this.r > dimension) {
            bjVar.l.setMaxImageWidth(this.r - dimension);
        } else {
            bjVar.l.setMaxImageWidth(this.r);
        }
        bjVar.l.setMaxImageHeight((int) (this.r * 1.618f));
        bjVar.l.setTextSize(TbConfig.getContentSize());
        if (!this.d) {
            ViewGroup.LayoutParams layoutParams = bjVar.e.getLayoutParams();
            layoutParams.width = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds30);
            bjVar.e.setLayoutParams(layoutParams);
            bjVar.e.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = bjVar.e.getLayoutParams();
            layoutParams2.width = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds60);
            bjVar.e.setLayoutParams(layoutParams2);
            bjVar.e.setVisibility(0);
        }
        bjVar.l.a(this.c, false);
        bjVar.l.setVoiceViewRes(com.baidu.tieba.v.voice_play_btn);
        bjVar.l.setOnImageClickListener(this.l);
        bjVar.l.setOnEmotionClickListener(this.m);
        bjVar.r = (UserIconBox) inflate.findViewById(com.baidu.tieba.u.user_icon_box);
        bjVar.r.setOnClickListener(this.i);
        bjVar.t = (UserIconBox) inflate.findViewById(com.baidu.tieba.u.user_tshow_icon_box);
        bjVar.t.setOnClickListener(this.j);
        bjVar.u = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.add_post_footer_layout);
        inflate.setTag(bjVar);
        if (z) {
            bjVar.p.setVisibility(8);
            bjVar.k.setVisibility(8);
            bjVar.l.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bjVar.l.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            bjVar.l.setLayoutParams(layoutParams3);
            inflate.findViewById(com.baidu.tieba.u.pb_list_item_layout).setPadding(0, 0, 0, 0);
            bjVar.w = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.add_time_container);
            bjVar.v = (TextView) inflate.findViewById(com.baidu.tieba.u.add_time);
            bjVar.x = (Button) inflate.findViewById(com.baidu.tieba.u.manage_btn);
            bjVar.w.setVisibility(0);
        }
        bjVar.y = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.addition_more_container);
        bjVar.z = (TextView) bjVar.y.findViewById(com.baidu.tieba.u.addition_more);
        bjVar.A = bjVar.y.findViewById(com.baidu.tieba.u.addition_divider1);
        bjVar.B = bjVar.y.findViewById(com.baidu.tieba.u.addition_divider2);
        bjVar.s = (BaobaoTailView) inflate.findViewById(com.baidu.tieba.u.baobao_tail);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0473 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x08f2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0933  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x094c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bj bjVar, com.baidu.tieba.data.an anVar, View view, boolean z, int i) {
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
        if (bjVar != null && anVar != null) {
            if (!z) {
                bjVar.e.setTag(null);
                bjVar.e.setUserId(null);
                bjVar.f.setText((CharSequence) null);
                bjVar.g.setText((CharSequence) null);
                bjVar.g.setBackgroundDrawable(null);
                bjVar.q.setVisibility(0);
                bjVar.k.setVisibility(0);
                bjVar.j.setVisibility(8);
                if (anVar.j() == null) {
                    bjVar.s.setVisibility(8);
                } else if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && anVar.j().d() == 1) {
                    bjVar.s.a(this.s);
                    bjVar.s.setVisibility(0);
                    bjVar.s.setData(anVar.j());
                } else {
                    bjVar.s.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) bjVar.p.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bjVar.p.setTag(sparseArray2);
                    bjVar.l.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.u.tag_clip_board, anVar);
                sparseArray2.put(com.baidu.tieba.u.tag_is_subpb, false);
                if (TextUtils.isEmpty(anVar.i()) || !this.c) {
                    sparseArray2.put(com.baidu.tieba.u.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bjVar.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bjVar.l.setLayoutParams(layoutParams);
                    bjVar.l.setPadding(0, 0, 0, 0);
                    bjVar.l.a((String) null);
                } else {
                    sparseArray2.put(com.baidu.tieba.u.tag_richtext_bg, anVar.i());
                    bjVar.l.a(anVar.i());
                    if (anVar.e() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bjVar.l.getLayoutParams();
                        layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds16);
                        layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds40);
                        bjVar.l.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bjVar.l.getLayoutParams();
                        layoutParams3.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds20);
                        layoutParams3.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds20);
                        bjVar.l.setLayoutParams(layoutParams3);
                    }
                }
                bjVar.i.setText(com.baidu.tbadk.core.util.ba.a(anVar.o_()));
                if (anVar.e() == 1) {
                    if (this.s == 1) {
                        bjVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_bg_line_d_1));
                    } else {
                        bjVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_bg_line_d));
                    }
                    bjVar.b.setVisibility(8);
                    bjVar.c.setVisibility(8);
                    bjVar.p.setVisibility(8);
                    bjVar.i.setVisibility(8);
                    if (this.e) {
                        PraiseData g = this.a.d().g();
                        if (g != null && g.getUser() != null && g.getUser().size() > 0) {
                            bjVar.n.setVisibility(0);
                            bjVar.m.setVisibility(0);
                            bjVar.o.setVisibility(0);
                            bjVar.n.setIsFromPb(true);
                            bjVar.n.a(g, this.a.d().h(), g.getPostId(), true);
                            bjVar.n.a(this.s);
                        } else {
                            bjVar.n.setVisibility(8);
                            bjVar.m.setVisibility(8);
                            bjVar.o.setVisibility(8);
                        }
                    } else {
                        bjVar.n.setVisibility(8);
                        bjVar.m.setVisibility(8);
                        bjVar.o.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) bjVar.l.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds30);
                    ((LinearLayout.LayoutParams) bjVar.s.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds30);
                } else {
                    if (this.s == 1) {
                        bjVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_bg_line_e_1));
                    } else {
                        bjVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_bg_line_e));
                    }
                    if (i == 1) {
                        if (this.e) {
                            bjVar.b.setVisibility(8);
                            bjVar.c.setVisibility(8);
                            PraiseData g2 = this.a.d().g();
                            if (g2 != null && g2.getUser() != null && g2.getUser().size() > 0) {
                                bjVar.c.setVisibility(8);
                                bjVar.b.setVisibility(0);
                            } else {
                                bjVar.c.setVisibility(0);
                                bjVar.b.setVisibility(8);
                            }
                        } else {
                            bjVar.b.setVisibility(0);
                            bjVar.c.setVisibility(8);
                        }
                    } else {
                        bjVar.b.setVisibility(0);
                        bjVar.c.setVisibility(8);
                    }
                    bjVar.n.setVisibility(8);
                    bjVar.m.setVisibility(8);
                    bjVar.o.setVisibility(8);
                    bjVar.p.setVisibility(0);
                    bjVar.i.setVisibility(0);
                    String format = String.format(this.b.getString(com.baidu.tieba.x.is_floor), Integer.valueOf(anVar.e()));
                    bjVar.h.setVisibility(0);
                    bjVar.h.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) bjVar.l.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) bjVar.s.getLayoutParams();
                    if (!this.d) {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds74);
                        layoutParams5.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds104);
                        layoutParams5.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds104);
                    }
                    linearLayout3 = bjVar.D;
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.d) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds30);
                    }
                }
                if (this.g != null && !this.g.equals("0") && this.g.equals(anVar.g().getUserId())) {
                    bjVar.j.setVisibility(0);
                    if (this.s == 1) {
                        bjVar.j.setImageResource(com.baidu.tieba.t.icon_floorhost_1);
                    } else {
                        bjVar.j.setImageResource(com.baidu.tieba.t.icon_floorhost);
                    }
                }
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                bjVar.d.setBackgroundResource(com.baidu.tieba.t.bg_floor_new_middle_1);
                bjVar.l.setVideoImageId(com.baidu.tieba.t.pic_video_1);
                bjVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.pb_listitem_content_1));
                bjVar.k.setImageResource(com.baidu.tieba.t.btn_pb_reply_selector_1);
                bjVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text_1));
            } else {
                bjVar.d.setBackgroundResource(com.baidu.tieba.t.bg_floor_new_middle);
                bjVar.l.setVideoImageId(com.baidu.tieba.t.pic_video);
                bjVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.pb_listitem_content));
                bjVar.k.setImageResource(com.baidu.tieba.t.btn_pb_reply_selector);
                bjVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) bjVar.k.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bjVar.k.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.u.tag_clip_board, anVar);
            sparseArray.put(com.baidu.tieba.u.tag_load_sub_data, anVar);
            sparseArray.put(com.baidu.tieba.u.tag_load_sub_view, view);
            if (anVar.l() > 0 && anVar.n_() != null && anVar.n_().size() > 0) {
                if (this.n == null) {
                    this.n = new com.baidu.tieba.pb.sub.a(this.b, this.h);
                    this.n.a(this.v);
                    this.n.a(this.q);
                    boolean z7 = false;
                    String userId = this.a.d().q().getUserId();
                    if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.n.a(this.a.l(), z7);
                    this.n.b(this.d);
                }
                bjVar.q.setVisibility(0);
                imageView2 = bjVar.E;
                imageView2.setVisibility(0);
                linearLayout2 = bjVar.D;
                linearLayout2.setVisibility(0);
                bjVar.q.a(anVar, view);
                bjVar.q.setChildOnClickListener(this.k);
                bjVar.q.setChildOnLongClickListener(this.o);
                bjVar.q.setChildOnTouchListener(this.p);
                bjVar.q.setSubPbAdapter(this.n);
                bjVar.q.setVisibility(0);
            } else {
                bjVar.q.setVisibility(8);
                imageView = bjVar.E;
                imageView.setVisibility(8);
                linearLayout = bjVar.D;
                linearLayout.setVisibility(8);
            }
            a(bjVar, anVar, this.a.n(), i);
            if (!z) {
                String portrait = anVar.g().getPortrait();
                if (anVar.g() != null) {
                    bjVar.f.setText(anVar.g().getName_show());
                    LinkedList<IconData> tShowInfo = anVar.g().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        if (this.s == 1) {
                            bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_h_1));
                        } else {
                            bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_h));
                        }
                    } else if (this.s == 1) {
                        bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f_1));
                    } else {
                        bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f));
                    }
                    int level_id = anVar.g().getLevel_id();
                    int is_bawu = anVar.g().getIs_bawu();
                    String bawu_type = anVar.g().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        bjVar.g.setVisibility(0);
                        bjVar.g.setText(String.valueOf(level_id));
                        bjVar.g.setBackgroundResource(com.baidu.tbadk.core.util.d.b(level_id));
                        i2 = 2;
                        bjVar.g.setOnClickListener(null);
                    } else {
                        bjVar.g.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            bjVar.g.setText((CharSequence) null);
                            bjVar.g.setBackgroundResource(this.s == 1 ? com.baidu.tieba.t.pb_manager_1 : com.baidu.tieba.t.pb_manager);
                            bjVar.g.setOnClickListener(this.i);
                        } else if (bawu_type.equals("assist")) {
                            bjVar.g.setText((CharSequence) null);
                            bjVar.g.setBackgroundResource(this.s == 1 ? com.baidu.tieba.t.pb_assist_1 : com.baidu.tieba.t.pb_assist);
                            bjVar.g.setOnClickListener(this.i);
                        }
                    }
                    this.t = anVar.g().getIconInfo();
                    this.u = anVar.g().getTShowInfo();
                    if (bjVar.r != null) {
                        bjVar.r.setOnClickListener(this.i);
                        bjVar.r.a(this.t, i2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_margin));
                    }
                    if (bjVar.t != null) {
                        bjVar.t.setOnClickListener(this.j);
                        bjVar.t.a(this.u, 3, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_margin), true);
                    }
                }
                bjVar.e.setUserId(anVar.g().getUserId());
                bjVar.e.setUserName(anVar.g().getUserName());
                bjVar.e.setImageDrawable(null);
                bjVar.f.setTag(anVar.g().getUserId());
                bjVar.e.a(portrait, 12, false);
            }
            if (this.s == 1) {
                bjVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text_1));
                if (this.c) {
                    bjVar.l.setDefaultImageId(com.baidu.tieba.t.img_default_100_1);
                } else {
                    bjVar.l.setDefaultImageId(com.baidu.tieba.t.icon_click_1);
                }
            } else {
                bjVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text));
                if (this.c) {
                    bjVar.l.setDefaultImageId(com.baidu.tieba.t.img_default_100);
                } else {
                    bjVar.l.setDefaultImageId(com.baidu.tieba.t.icon_click);
                }
            }
            bjVar.l.setIsFromCDN(this.v);
            if (this.w || !this.x) {
                bjVar.l.a(anVar.h(), false);
            } else {
                bjVar.l.a(anVar.h(), true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.a.l() != 0) {
                z8 = true;
                z9 = true;
                String userId2 = anVar.g().getUserId();
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
                            sparseArray.put(com.baidu.tieba.u.tag_should_manage_visible, true);
                            if (bjVar.x != null) {
                                bjVar.x.setVisibility(0);
                                bjVar.x.setText(com.baidu.tieba.x.delete);
                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                    bjVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.btn_delete_n_1, 0, 0, 0);
                                    z6 = true;
                                } else {
                                    bjVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.btn_delete_n, 0, 0, 0);
                                    z6 = true;
                                }
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.u.tag_should_manage_visible, false);
                            if (bjVar.x != null) {
                                bjVar.x.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    } else {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.u.tag_should_manage_visible, true);
                        if (bjVar.x != null) {
                            bjVar.x.setVisibility(0);
                            bjVar.x.setText(com.baidu.tieba.x.manage);
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                bjVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.btn_manage_n_1, 0, 0, 0);
                                z6 = true;
                            } else {
                                bjVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.btn_manage_n, 0, 0, 0);
                                z6 = true;
                            }
                        }
                        z6 = z5;
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (anVar.e() == 1) {
                        i3 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.u.tag_manage_user_identity, Integer.valueOf(this.a.l()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.u.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.u.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(com.baidu.tieba.u.tag_del_post_id, anVar.d());
                    } else {
                        sparseArray.put(com.baidu.tieba.u.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.u.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.u.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.u.tag_forbid_user_name, anVar.g().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.u.tag_forbid_user_name, "");
                    }
                    if (z) {
                        bjVar.k.setVisibility(8);
                        if (this.s == 1) {
                            bjVar.v.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.subpb_listitem_time_1));
                        } else {
                            bjVar.v.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.subpb_listitem_time));
                        }
                        bjVar.v.setText(String.format(this.b.getResources().getString(com.baidu.tieba.x.write_addition_update), com.baidu.tbadk.core.util.ba.a(anVar.o_())));
                        if (bjVar.x.getVisibility() == 0) {
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                bjVar.x.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text_1));
                            } else {
                                bjVar.x.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text));
                            }
                            bjVar.x.setTag(sparseArray);
                            bjVar.x.setOnClickListener(this.q);
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
                if (anVar.e() == 1) {
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
                String userId3 = this.a.d().q().getUserId();
                if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = anVar.g().getUserId();
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
                if (anVar.e() == 1) {
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
        this.l = sVar;
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.m = rVar;
    }

    public void d(boolean z) {
        this.v = z;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }

    private void a(bj bjVar, com.baidu.tieba.data.an anVar, AdditionData additionData, int i) {
        if (anVar.m() > 0 && anVar.c() != null) {
            bjVar.u.setVisibility(0);
            bjVar.u.removeViews(0, bjVar.u.getChildCount() - 1);
            int size = anVar.c().size();
            int n = anVar.n();
            for (int i2 = 0; i2 < n; i2++) {
                com.baidu.tieba.data.an anVar2 = anVar.c().get(i2);
                View a = a(bjVar.u, true);
                bj bjVar2 = (bj) a.getTag();
                a(bjVar2, anVar2, bjVar.u, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.u.tag_clip_board, anVar2);
                sparseArray.put(com.baidu.tieba.u.tag_is_subpb, true);
                if (TextUtils.isEmpty(anVar2.i()) || !this.c) {
                    sparseArray.put(com.baidu.tieba.u.tag_richtext_bg, null);
                    bjVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bjVar2.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bjVar2.l.setLayoutParams(layoutParams);
                    bjVar2.l.setPadding(0, 0, 0, 0);
                    bjVar.l.a((String) null);
                } else {
                    bjVar.l.a(anVar.i());
                    bjVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bjVar2.l.getLayoutParams();
                    layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds16);
                    layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds36);
                    bjVar2.l.setLayoutParams(layoutParams2);
                }
                bjVar.u.addView(a, bjVar.u.getChildCount() - 1);
            }
            if (n < size) {
                bjVar.y.setVisibility(0);
                if (this.s == 1) {
                    bjVar.A.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_b_1);
                    bjVar.B.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_b_1);
                    bjVar.z.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f_1));
                } else {
                    bjVar.A.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_b);
                    bjVar.B.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_b);
                    bjVar.z.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f));
                }
                bjVar.y.setOnClickListener(new bh(this, n, size, anVar));
                return;
            }
            bjVar.y.setVisibility(8);
            return;
        }
        bjVar.u.setVisibility(8);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) getItem(i);
        if (anVar instanceof com.baidu.tieba.d.a.f) {
            return ((com.baidu.tieba.d.a.f) anVar).v() == 1 ? 1 : 2;
        }
        return 0;
    }

    private void f() {
        com.baidu.tieba.d.a.f fVar;
        int w;
        ArrayList<com.baidu.tieba.data.an> e = this.a.e();
        ArrayList<com.baidu.tieba.d.a.f> o = this.a.o();
        int size = o.size();
        if (e != null && e.size() != 0 && size != 0) {
            SparseArray sparseArray = new SparseArray();
            Iterator<com.baidu.tieba.d.a.f> it = o.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.d.a.f next = it.next();
                if (next.p() != null && next.p().a() && !com.baidu.tieba.d.b.a(com.baidu.tieba.ai.c().e(), next.p().g) && (w = next.w()) >= 2 && w < 30) {
                    sparseArray.put(w, next);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                com.baidu.tieba.d.a.f fVar2 = (com.baidu.tieba.d.a.f) sparseArray.get(sparseArray.keyAt(i));
                if (fVar2 != null) {
                    hashMap.put(fVar2.q(), fVar2);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (fVar = (com.baidu.tieba.d.a.f) entry.getValue()) != null) {
                    sparseArray.put(fVar.w(), fVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList, new bi(this));
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                com.baidu.tieba.d.a.f fVar3 = (com.baidu.tieba.d.a.f) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                int w2 = fVar3.w();
                if (w2 + i3 < e.size()) {
                    if (this.a.c() != null) {
                        fVar3.b = this.a.c().getId();
                    }
                    if (this.a.d() != null) {
                        fVar3.c = com.baidu.adp.lib.e.b.a(this.a.d().h(), 0L);
                    }
                    e.add(w2 + i3, fVar3);
                    TiebaStatic.eventStat(this.b, "pb_show_app", "", 1, "app_name", fVar3.p().g);
                } else {
                    return;
                }
            }
        }
    }
}
