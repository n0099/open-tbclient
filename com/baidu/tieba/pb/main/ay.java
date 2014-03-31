package com.baidu.tieba.pb.main;

import android.content.Context;
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
public final class ay extends BaseAdapter {
    private Context b;
    private int f;
    private com.baidu.tbadk.editortool.aa h;
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

    public ay(Context context) {
        boolean z = true;
        this.b = null;
        this.f = 0;
        this.h = null;
        this.t = 0;
        this.x = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        this.f = Math.min(com.baidu.adp.lib.util.i.a(this.b, 427.0f), 640);
        this.h = new com.baidu.tbadk.editortool.aa(this.b);
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

    public final com.baidu.tbadk.editortool.aa a() {
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
        ListView a;
        this.t = TbadkApplication.j().l();
        View a2 = view == null ? a(viewGroup, false) : view;
        ba baVar = (ba) a2.getTag();
        com.baidu.tieba.data.ai aiVar = (com.baidu.tieba.data.ai) getItem(i);
        PbActivity pbActivity = (PbActivity) this.b;
        pbActivity.getLayoutMode().a(this.t == 1);
        pbActivity.getLayoutMode().a(a2);
        if (aiVar != null) {
            a(baVar, aiVar, a2, false, i);
        }
        if (!this.w && this.x && baVar != null && baVar.m.a() && (a = pbActivity.a()) != null) {
            this.w = true;
            CompatibleUtile.getInstance().closeViewGpu(a);
        }
        return a2;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        ba baVar = new ba(this, (byte) 0);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.new_pb_list_item, viewGroup, false);
        baVar.e = inflate.findViewById(com.baidu.tieba.a.h.sub_pb_more);
        baVar.f = (HeadImageView) inflate.findViewById(com.baidu.tieba.a.h.photo);
        baVar.g = (TextView) inflate.findViewById(com.baidu.tieba.a.h.user_name);
        baVar.h = (TextView) inflate.findViewById(com.baidu.tieba.a.h.user_rank);
        baVar.l = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.reply);
        baVar.m = (TbRichTextView) inflate.findViewById(com.baidu.tieba.a.h.richText);
        baVar.n = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.pb_item_praise_topline);
        baVar.o = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.a.h.pb_item_praise_view);
        baVar.p = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.pb_item_praise_bottomline);
        baVar.k = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.floor_owner);
        baVar.i = (TextView) inflate.findViewById(com.baidu.tieba.a.h.floor);
        baVar.j = (TextView) inflate.findViewById(com.baidu.tieba.a.h.time);
        baVar.q = (RelativeLayout) inflate.findViewById(com.baidu.tieba.a.h.pb_post_header_layout);
        baVar.r = (SubPbLayout) inflate.findViewById(com.baidu.tieba.a.h.pb_post_footer_layout);
        baVar.D = inflate.findViewById(com.baidu.tieba.a.h.pb_post_footer_layout_line_top);
        baVar.g.setOnClickListener(this.i);
        baVar.l.setOnClickListener(this.l);
        baVar.f.setOnClickListener(this.i);
        baVar.a = inflate.findViewById(com.baidu.tieba.a.h.new_pb_list_item_blank_top);
        baVar.b = inflate;
        baVar.c = inflate.findViewById(com.baidu.tieba.a.h.new_pb_list_item_line_top);
        baVar.d = inflate.findViewById(com.baidu.tieba.a.h.new_pb_list_item_line_top_full);
        baVar.q.setOnLongClickListener(this.p);
        baVar.m.setOnLongClickListener(this.p);
        if (this.s < 0) {
            this.s = (((com.baidu.adp.lib.util.i.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - baVar.m.getPaddingLeft()) - baVar.m.getPaddingRight();
        }
        baVar.q.setOnTouchListener(this.q);
        baVar.m.setOnTouchListener(this.q);
        this.s = this.f > this.s ? this.s : this.f;
        baVar.m.setMaxImageWidth(this.s);
        baVar.m.setMaxImageHeight((int) (this.s * 1.618f));
        baVar.m.setTextSize(com.baidu.tbadk.core.data.n.p());
        if (!this.d) {
            baVar.f.setVisibility(8);
        }
        baVar.m.a(this.c, false);
        baVar.m.setVoiceViewRes(com.baidu.tieba.a.i.voice_play_btn);
        baVar.m.setOnImageClickListener(this.m);
        baVar.m.setOnEmotionClickListener(this.n);
        baVar.s = (UserIconBox) inflate.findViewById(com.baidu.tieba.a.h.user_icon_box);
        baVar.s.setOnClickListener(this.j);
        baVar.t = (UserIconBox) inflate.findViewById(com.baidu.tieba.a.h.user_tshow_icon_box);
        baVar.t.setOnClickListener(this.k);
        baVar.u = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.add_post_footer_layout);
        inflate.setTag(baVar);
        if (z) {
            baVar.q.setVisibility(8);
            baVar.l.setVisibility(8);
            baVar.m.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baVar.m.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            baVar.m.setLayoutParams(layoutParams);
            inflate.findViewById(com.baidu.tieba.a.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            baVar.w = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.add_time_container);
            baVar.v = (TextView) inflate.findViewById(com.baidu.tieba.a.h.add_time);
            baVar.x = (Button) inflate.findViewById(com.baidu.tieba.a.h.manage_btn);
            baVar.w.setVisibility(0);
        }
        baVar.y = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.addition_more_container);
        baVar.z = (TextView) baVar.y.findViewById(com.baidu.tieba.a.h.addition_more);
        baVar.A = baVar.y.findViewById(com.baidu.tieba.a.h.addition_divider1);
        baVar.B = baVar.y.findViewById(com.baidu.tieba.a.h.addition_divider2);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x044b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0849  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ba baVar, com.baidu.tieba.data.ai aiVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        View view2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        View view3;
        if (baVar != null && aiVar != null) {
            if (!z) {
                baVar.f.setTag(null);
                baVar.f.setUserId(null);
                baVar.g.setText((CharSequence) null);
                baVar.h.setText((CharSequence) null);
                baVar.h.setBackgroundDrawable(null);
                baVar.r.setVisibility(0);
                baVar.l.setVisibility(0);
                baVar.k.setVisibility(8);
                SparseArray sparseArray2 = (SparseArray) baVar.q.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    baVar.q.setTag(sparseArray2);
                    baVar.m.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.a.h.tag_clip_board, aiVar);
                sparseArray2.put(com.baidu.tieba.a.h.tag_is_subpb, false);
                if (TextUtils.isEmpty(aiVar.i()) || !this.c) {
                    sparseArray2.put(com.baidu.tieba.a.h.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baVar.m.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    baVar.m.setLayoutParams(layoutParams);
                    baVar.m.setPadding(0, 0, 0, 0);
                    baVar.m.setBackgroundDrawable(null);
                    baVar.m.setBackgroundImageUrl(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.a.h.tag_richtext_bg, aiVar.i());
                    if (aiVar.e() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) baVar.m.getLayoutParams();
                        layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds16);
                        layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds40);
                        baVar.m.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) baVar.m.getLayoutParams();
                        layoutParams3.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds20);
                        layoutParams3.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds20);
                        baVar.m.setLayoutParams(layoutParams3);
                    }
                    a(aiVar.i(), baVar.m);
                }
                baVar.j.setText(com.baidu.tbadk.core.util.bc.a(aiVar.f()));
                if (aiVar.e() == 1) {
                    baVar.a.setVisibility(8);
                    if (this.t == 1) {
                        baVar.b.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_d_1));
                    } else {
                        baVar.b.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_d));
                    }
                    baVar.c.setVisibility(8);
                    baVar.d.setVisibility(8);
                    baVar.q.setVisibility(8);
                    baVar.j.setVisibility(8);
                    if (this.e) {
                        PraiseData k = this.a.d().k();
                        if (k != null && k.getUser() != null && k.getUser().size() > 0) {
                            baVar.o.setVisibility(0);
                            baVar.n.setVisibility(0);
                            baVar.p.setVisibility(0);
                            baVar.o.setImageLoad(this.h);
                            baVar.o.a(k, this.a.d().C(), true);
                        } else {
                            baVar.o.setVisibility(8);
                            baVar.n.setVisibility(8);
                            baVar.p.setVisibility(8);
                        }
                    } else {
                        baVar.o.setVisibility(8);
                        baVar.n.setVisibility(8);
                        baVar.p.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) baVar.m.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds30);
                } else {
                    baVar.a.setVisibility(0);
                    if (this.t == 1) {
                        baVar.b.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_e_1));
                    } else {
                        baVar.b.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_bg_line_e));
                    }
                    if (i == 1) {
                        if (this.e) {
                            baVar.c.setVisibility(8);
                            PraiseData k2 = this.a.d().k();
                            if (k2 != null && k2.getUser() != null && k2.getUser().size() > 0) {
                                baVar.d.setVisibility(8);
                            } else {
                                baVar.d.setVisibility(0);
                            }
                        } else {
                            baVar.c.setVisibility(0);
                            baVar.d.setVisibility(8);
                        }
                    } else {
                        baVar.c.setVisibility(0);
                        baVar.d.setVisibility(8);
                    }
                    baVar.o.setVisibility(8);
                    baVar.n.setVisibility(8);
                    baVar.p.setVisibility(8);
                    baVar.q.setVisibility(0);
                    baVar.j.setVisibility(0);
                    String format = String.format(this.b.getString(com.baidu.tieba.a.k.is_floor), Integer.valueOf(aiVar.e()));
                    baVar.i.setVisibility(0);
                    baVar.i.setText(format);
                    ((LinearLayout.LayoutParams) baVar.m.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds110);
                }
                if (this.g != null && !this.g.equals("0") && this.g.equals(aiVar.g().getUserId())) {
                    baVar.k.setVisibility(0);
                    if (this.t == 1) {
                        baVar.k.setImageResource(com.baidu.tieba.a.g.icon_floorhost_1);
                    } else {
                        baVar.k.setImageResource(com.baidu.tieba.a.g.icon_floorhost);
                    }
                }
            }
            if (TbadkApplication.j().l() == 1) {
                baVar.e.setBackgroundResource(com.baidu.tieba.a.g.bg_floor_new_middle_1);
                baVar.m.setVideoImageId(com.baidu.tieba.a.g.pic_video_1);
                baVar.m.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.pb_listitem_content_1));
                baVar.l.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector_1);
                baVar.m.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text_1));
            } else {
                baVar.e.setBackgroundResource(com.baidu.tieba.a.g.bg_floor_new_middle);
                baVar.m.setVideoImageId(com.baidu.tieba.a.g.pic_video);
                baVar.m.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.pb_listitem_content));
                baVar.l.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector);
                baVar.m.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) baVar.l.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                baVar.l.setTag(sparseArray4);
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
                baVar.r.setVisibility(0);
                view3 = baVar.D;
                view3.setVisibility(0);
                baVar.r.a(aiVar, view);
                baVar.r.setChildOnClickListener(this.l);
                baVar.r.setChildOnLongClickListener(this.p);
                baVar.r.setChildOnTouchListener(this.q);
                baVar.r.setSubPbAdapter(this.o);
                baVar.r.setVisibility(0);
            } else {
                baVar.r.setVisibility(8);
                view2 = baVar.D;
                view2.setVisibility(8);
            }
            this.a.n();
            a(baVar, aiVar, i);
            if (!z) {
                String portrait = aiVar.g().getPortrait();
                com.baidu.tbadk.editortool.aa aaVar = this.h;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                if (aiVar.g() != null) {
                    baVar.g.setText(aiVar.g().getName_show());
                    LinkedList<IconData> tShowInfo = aiVar.g().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        if (this.t == 1) {
                            baVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_h_1));
                        } else {
                            baVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_h));
                        }
                    } else if (this.t == 1) {
                        baVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f_1));
                    } else {
                        baVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f));
                    }
                    int level_id = aiVar.g().getLevel_id();
                    int isLike = aiVar.g().getIsLike();
                    int is_bawu = aiVar.g().getIs_bawu();
                    String bawu_type = aiVar.g().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0 && isLike != 0) {
                        baVar.h.setVisibility(0);
                        baVar.h.setText(String.valueOf(level_id));
                        baVar.h.setBackgroundResource(com.baidu.tbadk.core.util.g.b(level_id));
                        i2 = 2;
                        baVar.h.setOnClickListener(null);
                    } else {
                        baVar.h.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            baVar.h.setText((CharSequence) null);
                            baVar.h.setBackgroundResource(this.t == 1 ? com.baidu.tieba.a.g.pb_manager_1 : com.baidu.tieba.a.g.pb_manager);
                            baVar.h.setOnClickListener(this.j);
                        } else if (bawu_type.equals("assist")) {
                            baVar.h.setText((CharSequence) null);
                            baVar.h.setBackgroundResource(this.t == 1 ? com.baidu.tieba.a.g.pb_assist_1 : com.baidu.tieba.a.g.pb_assist);
                            baVar.h.setOnClickListener(this.j);
                        }
                    }
                    this.u = aiVar.g().getIconInfo();
                    this.v = aiVar.g().getTShowInfo();
                    if (baVar.s != null) {
                        baVar.s.setOnClickListener(this.j);
                        baVar.s.a(this.u, i2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_margin));
                    }
                    if (baVar.t != null) {
                        baVar.t.setOnClickListener(this.k);
                        baVar.t.a(this.v, 3, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_margin), true);
                    }
                }
                baVar.f.setUserId(aiVar.g().getUserId());
                baVar.f.setImageBitmap(null);
                baVar.g.setTag(aiVar.g().getUserId());
                if (b != null) {
                    b.a(baVar.f);
                } else {
                    baVar.f.setTag(portrait);
                    baVar.f.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
                }
            }
            if (this.t == 1) {
                baVar.m.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text_1));
                baVar.m.setDefaultGifId(com.baidu.tieba.a.g.pic_expression_upload_selector_1);
                if (this.c) {
                    baVar.m.setDefaultImageId(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
                    baVar.m.setShowEmotion(true);
                } else {
                    baVar.m.setDefaultImageId(com.baidu.tieba.a.g.icon_click_1);
                    baVar.m.setShowEmotion(false);
                }
            } else {
                baVar.m.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text));
                baVar.m.setDefaultGifId(com.baidu.tieba.a.g.pic_expression_upload_selector);
                if (this.c) {
                    baVar.m.setDefaultImageId(com.baidu.tieba.a.g.pic_baidu_logo_d);
                    baVar.m.setShowEmotion(true);
                } else {
                    baVar.m.setDefaultImageId(com.baidu.tieba.a.g.icon_click);
                    baVar.m.setShowEmotion(false);
                }
            }
            if (this.w || !this.x) {
                baVar.m.a(aiVar.h(), false);
            } else {
                baVar.m.a(aiVar.h(), true);
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
                    z2 = false;
                    z3 = false;
                    z4 = true;
                    if (z4 || !z2) {
                        if (z4) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.a.h.tag_should_manage_visible, true);
                            if (baVar.x != null) {
                                baVar.x.setVisibility(0);
                                baVar.x.setText(com.baidu.tieba.a.k.delete);
                                if (TbadkApplication.j().l() == 1) {
                                    baVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_delete_n_1, 0, 0, 0);
                                    z6 = true;
                                } else {
                                    baVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_delete_n, 0, 0, 0);
                                    z6 = true;
                                }
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.a.h.tag_should_manage_visible, false);
                            if (baVar.x != null) {
                                baVar.x.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    } else {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.a.h.tag_should_manage_visible, true);
                        if (baVar.x != null) {
                            baVar.x.setVisibility(0);
                            baVar.x.setText(com.baidu.tieba.a.k.manage);
                            if (TbadkApplication.j().l() == 1) {
                                baVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_manage_n_1, 0, 0, 0);
                                z6 = true;
                            } else {
                                baVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.btn_manage_n, 0, 0, 0);
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
                    if (z4) {
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_id, aiVar.d());
                    } else {
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_id, "");
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.a.h.tag_forbid_user_name, aiVar.g().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.a.h.tag_forbid_user_name, "");
                    }
                    if (z) {
                        baVar.l.setVisibility(8);
                        if (this.t == 1) {
                            baVar.v.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.subpb_listitem_time_1));
                        } else {
                            baVar.v.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.subpb_listitem_time));
                        }
                        baVar.v.setText(String.format(this.b.getResources().getString(com.baidu.tieba.a.k.write_addition_update), com.baidu.tbadk.core.util.bc.a(aiVar.f())));
                        if (baVar.x.getVisibility() == 0) {
                            if (TbadkApplication.j().l() == 1) {
                                baVar.x.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text_1));
                            } else {
                                baVar.x.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text));
                            }
                            baVar.x.setTag(sparseArray);
                            baVar.x.setOnClickListener(this.r);
                            return;
                        }
                        return;
                    }
                    return;
                }
                z2 = z9;
                z3 = false;
                z4 = z10;
                if (z4) {
                }
                if (z4) {
                }
                z6 = z5;
                int i32 = 1;
                if (z) {
                }
                if (aiVar.e() == 1) {
                }
                if (z6) {
                }
                if (z4) {
                }
                if (z2) {
                }
                if (z) {
                }
            } else {
                String userId3 = this.a.d().t().getUserId();
                if (userId3 != null && userId3.equals(TbadkApplication.E())) {
                    z2 = false;
                    z3 = false;
                    z4 = true;
                } else {
                    String userId4 = aiVar.g().getUserId();
                    if (userId4 != null && userId4.equals(TbadkApplication.E())) {
                        z2 = false;
                        z3 = true;
                        z4 = true;
                    }
                    z2 = z9;
                    z3 = false;
                    z4 = z10;
                }
                if (z4) {
                }
                if (z4) {
                }
                z6 = z5;
                int i322 = 1;
                if (z) {
                }
                if (aiVar.e() == 1) {
                }
                if (z6) {
                }
                if (z4) {
                }
                if (z2) {
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
                    ninePatchDrawable.getPaint().setAlpha(bk.a);
                }
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
                tbRichTextView.setBackgroundImageUrl(str);
                return;
            }
            tbRichTextView.setBackgroundDrawable(null);
            tbRichTextView.setBackgroundImageUrl(null);
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

    private void a(ba baVar, com.baidu.tieba.data.ai aiVar, int i) {
        if (aiVar.l() > 0 && aiVar.c() != null) {
            baVar.u.setVisibility(0);
            baVar.u.removeViews(0, baVar.u.getChildCount() - 1);
            int size = aiVar.c().size();
            int n = aiVar.n();
            for (int i2 = 0; i2 < n; i2++) {
                com.baidu.tieba.data.ai aiVar2 = aiVar.c().get(i2);
                View a = a((ViewGroup) baVar.u, true);
                ba baVar2 = (ba) a.getTag();
                a(baVar2, aiVar2, baVar.u, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.a.h.tag_clip_board, aiVar2);
                sparseArray.put(com.baidu.tieba.a.h.tag_is_subpb, true);
                if (TextUtils.isEmpty(aiVar2.i()) || !this.c) {
                    sparseArray.put(com.baidu.tieba.a.h.tag_richtext_bg, null);
                    baVar2.m.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baVar2.m.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    baVar2.m.setLayoutParams(layoutParams);
                    baVar2.m.setPadding(0, 0, 0, 0);
                    baVar2.m.setBackgroundDrawable(null);
                    baVar2.m.setBackgroundImageUrl(null);
                } else {
                    sparseArray.put(com.baidu.tieba.a.h.tag_richtext_bg, aiVar2.i());
                    baVar2.m.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) baVar2.m.getLayoutParams();
                    layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds16);
                    layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.a.f.ds36);
                    baVar2.m.setLayoutParams(layoutParams2);
                    a(aiVar2.i(), baVar2.m);
                }
                baVar.u.addView(a, baVar.u.getChildCount() - 1);
            }
            if (n < size) {
                baVar.y.setVisibility(0);
                if (this.t == 1) {
                    baVar.A.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b_1);
                    baVar.B.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b_1);
                    baVar.z.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f_1));
                } else {
                    baVar.A.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b);
                    baVar.B.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_b);
                    baVar.z.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f));
                }
                baVar.y.setOnClickListener(new az(this, n, size, aiVar));
                return;
            }
            baVar.y.setVisibility(8);
            return;
        }
        baVar.u.setVisibility(8);
    }
}
