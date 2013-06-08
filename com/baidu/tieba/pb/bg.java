package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bg extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.a.am a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.d.a g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private com.baidu.tbadk.widget.richText.m j = null;
    private bi k = null;
    private View.OnLongClickListener l = null;
    private View.OnClickListener m = null;
    private int n = -1;
    private int o = 0;

    public bg(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(com.baidu.tieba.d.ag.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.o = TiebaApplication.d().ar();
    }

    private void g() {
        this.g = new com.baidu.tieba.d.a(this.b);
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.a.am amVar) {
        this.a = amVar;
        if (amVar.b() != null && amVar.b().g() != null) {
            this.f = amVar.b().g().a();
        }
    }

    public com.baidu.tieba.d.a a() {
        return this.g;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.l = onLongClickListener;
    }

    public View.OnLongClickListener b() {
        return this.l;
    }

    public void c(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.d() == null) {
            return 0;
        }
        return this.a.d().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || this.a.d() == null || i < 0 || i >= this.a.d().size()) {
            return null;
        }
        return this.a.d().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.n;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = h();
        }
        bh bhVar = (bh) view.getTag();
        com.baidu.tieba.a.ar arVar = (com.baidu.tieba.a.ar) getItem(i);
        if (arVar != null) {
            a(bhVar, arVar, view);
        }
        return view;
    }

    private View h() {
        bh bhVar = new bh(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, (ViewGroup) null);
        bhVar.a = (HeadImageView) inflate.findViewById(R.id.photo);
        bhVar.b = (TextView) inflate.findViewById(R.id.user_name);
        bhVar.c = (TextView) inflate.findViewById(R.id.user_rank);
        bhVar.f = (Button) inflate.findViewById(R.id.reply);
        bhVar.g = (Button) inflate.findViewById(R.id.manage_btn);
        bhVar.h = (TbRichTextView) inflate.findViewById(R.id.richText);
        bhVar.g.setOnClickListener(this.m);
        bhVar.d = (TextView) inflate.findViewById(R.id.floor);
        bhVar.e = (TextView) inflate.findViewById(R.id.time);
        bhVar.i = (LinearLayout) inflate.findViewById(R.id.pb_post_header_layout);
        bhVar.j = (LinearLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        bhVar.b.setOnClickListener(this.h);
        bhVar.f.setOnClickListener(this.i);
        bhVar.a.setOnClickListener(this.h);
        bhVar.a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.d.d.a((int) R.drawable.photo_bg)));
        bhVar.i.setOnLongClickListener(this.l);
        if (this.n < 0) {
            this.n = (((com.baidu.tieba.d.ag.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bhVar.h.getPaddingLeft()) - bhVar.h.getPaddingRight();
        }
        this.n = this.e > this.n ? this.n : this.e;
        bhVar.h.setMaxImageWidth(this.n);
        bhVar.h.setMaxImageHeight((int) (this.n * 1.618f));
        bhVar.h.setTextSize(com.baidu.tieba.a.i.n());
        if (!this.d) {
            bhVar.a.setVisibility(8);
        }
        bhVar.h.setDisplayImage(this.c);
        bhVar.h.setOnImageClickListener(this.j);
        com.baidu.tieba.d.ac.e(bhVar.b, this.o);
        com.baidu.tieba.d.ac.d(bhVar.e, this.o);
        if (TiebaApplication.d().ar() == 1) {
            bhVar.h.setTextColor(this.b.getResources().getColor(R.color.gray_night_1));
            com.baidu.tieba.d.ac.h((View) bhVar.f, (int) R.drawable.common_image_btn_selector_1);
            bhVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            bhVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            bhVar.h.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
            com.baidu.tieba.d.ac.h((View) bhVar.f, (int) R.drawable.common_image_btn_selector);
            bhVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            bhVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        inflate.setTag(bhVar);
        return inflate;
    }

    private void a(bh bhVar, com.baidu.tieba.a.ar arVar, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        SparseArray sparseArray;
        if (bhVar != null && arVar != null) {
            bhVar.a.setTag(null);
            bhVar.a.setUserId(null);
            bhVar.b.setText((CharSequence) null);
            bhVar.c.setText((CharSequence) null);
            bhVar.c.setBackgroundResource(0);
            bhVar.j.setVisibility(0);
            bhVar.d.setText((CharSequence) null);
            bhVar.f.setVisibility(0);
            bhVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (TiebaApplication.d().ar() == 1) {
                bhVar.i.setBackgroundResource(R.drawable.bg_list_top_1);
                bhVar.j.setBackgroundResource(R.drawable.bg_list_bottom_1);
                bhVar.h.setVideoImageId(R.drawable.pic_video_1);
            } else {
                bhVar.i.setBackgroundResource(R.drawable.bg_list_top);
                bhVar.j.setBackgroundResource(R.drawable.bg_list_bottom);
                bhVar.h.setVideoImageId(R.drawable.pic_video);
            }
            SparseArray sparseArray2 = (SparseArray) bhVar.i.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bhVar.i.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_clip_board, arVar);
            String h = this.a.h();
            boolean z4 = this.a.g() && h != null && h.equals(arVar.d());
            Resources resources = this.b.getResources();
            bhVar.e.setText(com.baidu.tieba.d.ad.e(new Date(arVar.g())));
            if (arVar.f() == 1) {
                bhVar.f.setVisibility(8);
            }
            if (this.f != null && this.f.equals(arVar.h().a())) {
                if (this.o == 1) {
                    if (z4) {
                        bhVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        bhVar.d.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z4) {
                    bhVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    bhVar.d.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (this.o == 1) {
                    com.baidu.tieba.d.ac.h((View) bhVar.d, (int) R.drawable.pb_list_floor_number_1);
                    if (z4) {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    com.baidu.tieba.d.ac.h((View) bhVar.d, (int) R.drawable.pb_list_floor_number);
                    if (z4) {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                bhVar.d.setText(String.valueOf(String.valueOf(arVar.f())) + resources.getString(R.string.floor));
            }
            SparseArray sparseArray3 = (SparseArray) bhVar.f.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                bhVar.f.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, arVar);
            sparseArray3.put(R.id.tag_load_sub_view, view);
            if (arVar.k() > 0 && arVar.a() != null) {
                if (this.k == null) {
                    this.k = new bi(this.b, this.h);
                    this.k.a(this.m);
                    String a = this.a.b().g().a();
                    this.k.a(this.a.l(), a != null && a.equals(TiebaApplication.B()));
                    this.k.a(this.d);
                }
                bhVar.j.removeAllViews();
                ArrayList a2 = arVar.a();
                if (a2 != null) {
                    for (int i = 0; i < a2.size(); i++) {
                        View b = this.k.b();
                        b.setOnClickListener(this.i);
                        b.setOnLongClickListener(this.l);
                        b.setClickable(true);
                        SparseArray sparseArray4 = (SparseArray) b.getTag();
                        if (sparseArray4 == null) {
                            SparseArray sparseArray5 = new SparseArray();
                            b.setTag(sparseArray5);
                            sparseArray = sparseArray5;
                        } else {
                            sparseArray = sparseArray4;
                        }
                        sparseArray.put(R.id.tag_load_sub_data, arVar);
                        sparseArray.put(R.id.tag_load_sub_view, view);
                        if (a2.get(i) != null && ((com.baidu.tieba.a.ar) a2.get(i)).h() != null) {
                            sparseArray.put(R.id.tag_photo_username, ((com.baidu.tieba.a.ar) a2.get(i)).h().c());
                            sparseArray.put(R.id.tag_clip_board, a2.get(i));
                        }
                        this.k.a((bj) sparseArray.get(R.id.tag_holder), (com.baidu.tieba.a.ar) a2.get(i), a2.size() - i > 1);
                        bhVar.j.addView(b);
                    }
                }
                if (a2 != null && arVar.k() > a2.size()) {
                    View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
                    bhVar.j.addView(inflate);
                    a((TextView) inflate.findViewById(R.id.sub_pb_more_text), arVar.k() - a2.size());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                    if (TiebaApplication.d().ar() == 1) {
                        imageView.setBackgroundResource(R.drawable.icon_little_down_1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.icon_little_down);
                    }
                    inflate.setOnClickListener(this.i);
                    SparseArray sparseArray6 = (SparseArray) inflate.getTag();
                    if (sparseArray6 == null) {
                        sparseArray6 = new SparseArray();
                        inflate.setTag(sparseArray6);
                    }
                    sparseArray6.put(R.id.tag_load_sub_data, arVar);
                    sparseArray6.put(R.id.tag_load_sub_view, view);
                }
            } else {
                bhVar.j.setVisibility(8);
                if (TiebaApplication.d().ar() == 1) {
                    bhVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    bhVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
            }
            String e = arVar.h().e();
            com.baidu.adp.widget.a.b b2 = this.g.b(e);
            if (arVar.h() != null) {
                bhVar.b.setText(arVar.h().d());
                int m = arVar.h().m();
                int f = arVar.h().f();
                if (m != 0 && f != 0) {
                    bhVar.c.setText(String.valueOf(m));
                    bhVar.c.setBackgroundResource(com.baidu.tieba.d.d.b(m));
                }
            }
            bhVar.a.setUserId(arVar.h().a());
            bhVar.b.setTag(arVar.h().a());
            if (b2 != null) {
                b2.a(bhVar.a);
            } else {
                bhVar.a.setTag(e);
                bhVar.a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.d.d.a((int) R.drawable.photo)));
            }
            bhVar.h.setText(arVar.i());
            bhVar.h.a();
            if (this.a.l() != 0) {
                String a3 = arVar.h().a();
                boolean z5 = a3 == null || !a3.equals(TiebaApplication.B());
                if (a3 == null || a3.equals("0") || a3.length() == 0) {
                    z = false;
                    z2 = true;
                    z3 = false;
                } else {
                    z2 = true;
                    z3 = z5;
                    z = false;
                }
            } else {
                String a4 = this.a.b().g().a();
                if (a4 == null || !a4.equals(TiebaApplication.B())) {
                    String a5 = arVar.h().a();
                    if (a5 == null || !a5.equals(TiebaApplication.B())) {
                        z = false;
                        z2 = false;
                        z3 = false;
                    } else {
                        z = true;
                        z2 = true;
                        z3 = false;
                    }
                } else {
                    z = false;
                    z2 = true;
                    z3 = false;
                }
            }
            if (TiebaApplication.d().ar() == 1) {
                com.baidu.tieba.d.ac.h((View) bhVar.g, (int) R.drawable.common_image_btn_selector_1);
                bhVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            } else {
                com.baidu.tieba.d.ac.h((View) bhVar.g, (int) R.drawable.common_image_btn_selector);
                bhVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            }
            if (z2 && z3) {
                bhVar.g.setVisibility(0);
                bhVar.g.setText(R.string.manage);
                if (TiebaApplication.d().ar() == 1) {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                } else {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                }
            } else if (z2) {
                bhVar.g.setVisibility(0);
                bhVar.g.setText(R.string.delete);
                if (TiebaApplication.d().ar() == 1) {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector_1, 0, 0, 0);
                } else {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector, 0, 0, 0);
                }
            } else {
                bhVar.g.setVisibility(8);
            }
            int i2 = arVar.f() == 1 ? 0 : 1;
            if (bhVar.g.getVisibility() == 0) {
                bhVar.g.setTag(R.id.tag_manage_user_identity, Integer.valueOf(this.a.l()));
            }
            if (z2) {
                bhVar.g.setTag(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                bhVar.g.setTag(R.id.tag_del_post_type, Integer.valueOf(i2));
                bhVar.g.setTag(R.id.tag_del_post_id, arVar.d());
            } else {
                bhVar.g.setTag(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                bhVar.g.setTag(R.id.tag_del_post_type, 0);
                bhVar.g.setTag(R.id.tag_del_post_id, "");
            }
            if (z3) {
                bhVar.g.setTag(R.id.tag_forbid_user_name, arVar.h().c());
            } else {
                bhVar.g.setTag(R.id.tag_forbid_user_name, "");
            }
        }
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.j = mVar;
    }

    public static void a(TextView textView, int i) {
        String string = TiebaApplication.d().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.d().ar() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(-12687203), indexOf, valueOf.length() + indexOf, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-12810784), indexOf, valueOf.length() + indexOf, 33);
        }
        textView.setText(spannableString);
    }
}
