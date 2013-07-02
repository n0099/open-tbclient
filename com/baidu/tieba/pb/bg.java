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
    private com.baidu.tieba.data.aj a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.a g = null;
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
        this.e = Math.min(com.baidu.tieba.util.ab.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.o = TiebaApplication.f().at();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.a(this.b);
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.data.aj ajVar) {
        this.a = ajVar;
        if (ajVar.b() != null && ajVar.b().g() != null) {
            this.f = ajVar.b().g().getId();
        }
    }

    public com.baidu.tieba.util.a a() {
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
        com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) getItem(i);
        if (anVar != null) {
            a(bhVar, anVar, view);
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
        bhVar.a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.d.a((int) R.drawable.photo_bg)));
        bhVar.i.setOnLongClickListener(this.l);
        if (this.n < 0) {
            this.n = (((com.baidu.tieba.util.ab.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bhVar.h.getPaddingLeft()) - bhVar.h.getPaddingRight();
        }
        this.n = this.e > this.n ? this.n : this.e;
        bhVar.h.setMaxImageWidth(this.n);
        bhVar.h.setMaxImageHeight((int) (this.n * 1.618f));
        bhVar.h.setTextSize(com.baidu.tieba.data.g.n());
        if (!this.d) {
            bhVar.a.setVisibility(8);
        }
        bhVar.h.setDisplayImage(this.c);
        bhVar.h.setOnImageClickListener(this.j);
        com.baidu.tieba.util.x.e(bhVar.b, this.o);
        com.baidu.tieba.util.x.d(bhVar.e, this.o);
        if (TiebaApplication.f().at() == 1) {
            bhVar.h.setTextColor(this.b.getResources().getColor(R.color.gray_night_1));
            com.baidu.tieba.util.x.h((View) bhVar.f, (int) R.drawable.common_image_btn_selector_1);
            bhVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            bhVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            bhVar.h.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
            com.baidu.tieba.util.x.h((View) bhVar.f, (int) R.drawable.common_image_btn_selector);
            bhVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            bhVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        inflate.setTag(bhVar);
        return inflate;
    }

    private void a(bh bhVar, com.baidu.tieba.data.an anVar, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        SparseArray sparseArray;
        if (bhVar != null && anVar != null) {
            bhVar.a.setTag(null);
            bhVar.a.setUserId(null);
            bhVar.b.setText((CharSequence) null);
            bhVar.c.setText((CharSequence) null);
            bhVar.c.setBackgroundResource(0);
            bhVar.j.setVisibility(0);
            bhVar.d.setText((CharSequence) null);
            bhVar.f.setVisibility(0);
            bhVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (TiebaApplication.f().at() == 1) {
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
            sparseArray2.put(R.id.tag_clip_board, anVar);
            String h = this.a.h();
            boolean z4 = this.a.g() && h != null && h.equals(anVar.d());
            Resources resources = this.b.getResources();
            bhVar.e.setText(com.baidu.tieba.util.y.e(new Date(anVar.g())));
            if (anVar.f() == 1) {
                bhVar.f.setVisibility(8);
            }
            if (this.f != null && this.f.equals(anVar.h().getId())) {
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
                    com.baidu.tieba.util.x.h((View) bhVar.d, (int) R.drawable.pb_list_floor_number_1);
                    if (z4) {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    com.baidu.tieba.util.x.h((View) bhVar.d, (int) R.drawable.pb_list_floor_number);
                    if (z4) {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        bhVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                bhVar.d.setText(String.valueOf(String.valueOf(anVar.f())) + resources.getString(R.string.floor));
            }
            SparseArray sparseArray3 = (SparseArray) bhVar.f.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                bhVar.f.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, anVar);
            sparseArray3.put(R.id.tag_load_sub_view, view);
            if (anVar.k() > 0 && anVar.a() != null) {
                if (this.k == null) {
                    this.k = new bi(this.b, this.h);
                    this.k.a(this.m);
                    String id = this.a.b().g().getId();
                    this.k.a(this.a.l(), id != null && id.equals(TiebaApplication.E()));
                    this.k.a(this.d);
                }
                bhVar.j.removeAllViews();
                ArrayList a = anVar.a();
                if (a != null) {
                    for (int i = 0; i < a.size(); i++) {
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
                        sparseArray.put(R.id.tag_load_sub_data, anVar);
                        sparseArray.put(R.id.tag_load_sub_view, view);
                        if (a.get(i) != null && ((com.baidu.tieba.data.an) a.get(i)).h() != null) {
                            sparseArray.put(R.id.tag_photo_username, ((com.baidu.tieba.data.an) a.get(i)).h().getName());
                            sparseArray.put(R.id.tag_clip_board, a.get(i));
                        }
                        this.k.a((bj) sparseArray.get(R.id.tag_holder), (com.baidu.tieba.data.an) a.get(i), a.size() - i > 1);
                        bhVar.j.addView(b);
                    }
                }
                if (a != null && anVar.k() > a.size()) {
                    View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
                    bhVar.j.addView(inflate);
                    a((TextView) inflate.findViewById(R.id.sub_pb_more_text), anVar.k() - a.size());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                    if (TiebaApplication.f().at() == 1) {
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
                    sparseArray6.put(R.id.tag_load_sub_data, anVar);
                    sparseArray6.put(R.id.tag_load_sub_view, view);
                }
            } else {
                bhVar.j.setVisibility(8);
                if (TiebaApplication.f().at() == 1) {
                    bhVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    bhVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
            }
            String portrait = anVar.h().getPortrait();
            com.baidu.adp.widget.a.b b2 = this.g.b(portrait);
            if (anVar.h() != null) {
                bhVar.b.setText(anVar.h().getName_show());
                int level_id = anVar.h().getLevel_id();
                int isLike = anVar.h().getIsLike();
                if (level_id != 0 && isLike != 0) {
                    bhVar.c.setText(String.valueOf(level_id));
                    bhVar.c.setBackgroundResource(com.baidu.tieba.util.d.b(level_id));
                }
            }
            bhVar.a.setUserId(anVar.h().getId());
            bhVar.b.setTag(anVar.h().getId());
            if (b2 != null) {
                b2.a(bhVar.a);
            } else {
                bhVar.a.setTag(portrait);
                bhVar.a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.d.a((int) R.drawable.photo)));
            }
            bhVar.h.setText(anVar.i());
            bhVar.h.a();
            if (this.a.l() != 0) {
                String id2 = anVar.h().getId();
                boolean z5 = id2 == null || !id2.equals(TiebaApplication.E());
                if (id2 == null || id2.equals("0") || id2.length() == 0) {
                    z = false;
                    z2 = true;
                    z3 = false;
                } else {
                    z = false;
                    z2 = true;
                    z3 = z5;
                }
            } else {
                String id3 = this.a.b().g().getId();
                if (id3 == null || !id3.equals(TiebaApplication.E())) {
                    String id4 = anVar.h().getId();
                    if (id4 == null || !id4.equals(TiebaApplication.E())) {
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
            if (TiebaApplication.f().at() == 1) {
                com.baidu.tieba.util.x.h((View) bhVar.g, (int) R.drawable.common_image_btn_selector_1);
                bhVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            } else {
                com.baidu.tieba.util.x.h((View) bhVar.g, (int) R.drawable.common_image_btn_selector);
                bhVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            }
            if (z2 && z3) {
                bhVar.g.setVisibility(0);
                bhVar.g.setText(R.string.manage);
                if (TiebaApplication.f().at() == 1) {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                } else {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                }
            } else if (z2) {
                bhVar.g.setVisibility(0);
                bhVar.g.setText(R.string.delete);
                if (TiebaApplication.f().at() == 1) {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector_1, 0, 0, 0);
                } else {
                    bhVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector, 0, 0, 0);
                }
            } else {
                bhVar.g.setVisibility(8);
            }
            int i2 = anVar.f() == 1 ? 0 : 1;
            SparseArray sparseArray7 = (SparseArray) bhVar.g.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                bhVar.g.setTag(sparseArray7);
            }
            if (bhVar.g.getVisibility() == 0) {
                sparseArray7.put(R.id.tag_manage_user_identity, Integer.valueOf(this.a.l()));
            }
            if (z2) {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray7.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                sparseArray7.put(R.id.tag_del_post_id, anVar.d());
            } else {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray7.put(R.id.tag_del_post_type, 0);
                sparseArray7.put(R.id.tag_del_post_id, "");
            }
            if (z3) {
                sparseArray7.put(R.id.tag_forbid_user_name, anVar.h().getName());
            } else {
                sparseArray7.put(R.id.tag_forbid_user_name, "");
            }
        }
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.j = mVar;
    }

    public static void a(TextView textView, int i) {
        String string = TiebaApplication.f().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.f().at() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(-12687203), indexOf, valueOf.length() + indexOf, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-12810784), indexOf, valueOf.length() + indexOf, 33);
        }
        textView.setText(spannableString);
    }
}
