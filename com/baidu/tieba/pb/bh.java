package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bh extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.a.al a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.d.a g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private com.baidu.tbadk.widget.richText.m j = null;
    private bj k = null;
    private View.OnLongClickListener l = null;
    private View.OnClickListener m = null;
    private int n = -1;
    private int o = 0;

    public bh(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(com.baidu.tieba.d.ag.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.o = TiebaApplication.d().ai();
    }

    private void g() {
        this.g = new com.baidu.tieba.d.a(this.b);
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.a.al alVar) {
        this.a = alVar;
        if (alVar.b() != null && alVar.b().g() != null) {
            this.f = alVar.b().g().a();
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
        bi biVar = (bi) view.getTag();
        com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) getItem(i);
        if (aqVar != null) {
            a(biVar, aqVar, view);
        }
        return view;
    }

    private View h() {
        bi biVar = new bi(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, (ViewGroup) null);
        biVar.a = (ImageView) inflate.findViewById(R.id.photo);
        biVar.b = (TextView) inflate.findViewById(R.id.user_name);
        biVar.c = (TextView) inflate.findViewById(R.id.user_rank);
        biVar.f = (Button) inflate.findViewById(R.id.reply);
        biVar.g = (Button) inflate.findViewById(R.id.manage_btn);
        biVar.h = (TbRichTextView) inflate.findViewById(R.id.richText);
        biVar.g.setOnClickListener(this.m);
        biVar.d = (TextView) inflate.findViewById(R.id.floor);
        biVar.e = (TextView) inflate.findViewById(R.id.time);
        biVar.i = (LinearLayout) inflate.findViewById(R.id.pb_post_header_layout);
        biVar.j = (LinearLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        biVar.a.setOnClickListener(this.h);
        biVar.b.setOnClickListener(this.h);
        biVar.f.setOnClickListener(this.i);
        biVar.a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.d.e.a((int) R.drawable.photo_bg)));
        biVar.i.setOnLongClickListener(this.l);
        if (this.n < 0) {
            this.n = (((com.baidu.tieba.d.ag.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - biVar.h.getPaddingLeft()) - biVar.h.getPaddingRight();
        }
        this.n = this.e > this.n ? this.n : this.e;
        biVar.h.setMaxImageWidth(this.n);
        biVar.h.setMaxImageHeight((int) (this.n * 1.618f));
        biVar.h.setTextSize(com.baidu.tieba.a.i.m());
        if (!this.d) {
            biVar.a.setVisibility(8);
        }
        biVar.h.setDisplayImage(this.c);
        biVar.h.setOnImageClickListener(this.j);
        com.baidu.tieba.d.ac.e(biVar.b, this.o);
        com.baidu.tieba.d.ac.d(biVar.e, this.o);
        if (TiebaApplication.d().ai() == 1) {
            biVar.h.setTextColor(this.b.getResources().getColor(R.color.gray_night_1));
            com.baidu.tieba.d.ac.h((View) biVar.f, (int) R.drawable.common_image_btn_selector_1);
            biVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            biVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            biVar.h.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
            com.baidu.tieba.d.ac.h((View) biVar.f, (int) R.drawable.common_image_btn_selector);
            biVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            biVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        inflate.setTag(biVar);
        return inflate;
    }

    private void a(bi biVar, com.baidu.tieba.a.aq aqVar, View view) {
        boolean z;
        boolean z2;
        if (biVar != null && aqVar != null) {
            biVar.a.setTag(null);
            biVar.a.setTag(R.id.tag_photo_userid, null);
            biVar.a.setTag(R.id.tag_photo_username, null);
            biVar.b.setText((CharSequence) null);
            biVar.c.setText((CharSequence) null);
            biVar.c.setBackgroundResource(0);
            biVar.j.setVisibility(0);
            biVar.d.setText((CharSequence) null);
            biVar.f.setVisibility(0);
            biVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (TiebaApplication.d().ai() == 1) {
                biVar.i.setBackgroundResource(R.drawable.bg_list_top_1);
                biVar.j.setBackgroundResource(R.drawable.bg_list_bottom_1);
                biVar.h.setVideoImageId(R.drawable.pic_video_1);
            } else {
                biVar.i.setBackgroundResource(R.drawable.bg_list_top);
                biVar.j.setBackgroundResource(R.drawable.bg_list_bottom);
                biVar.h.setVideoImageId(R.drawable.pic_video);
            }
            biVar.i.setTag(R.id.tag_clip_board, aqVar);
            String h = this.a.h();
            boolean z3 = this.a.g() && h != null && h.equals(aqVar.d());
            Resources resources = this.b.getResources();
            biVar.e.setText(com.baidu.tieba.d.ad.d(new Date(aqVar.g())));
            if (aqVar.f() == 1) {
                biVar.f.setVisibility(8);
            }
            if (this.f != null && this.f.equals(aqVar.h().a())) {
                if (this.o == 1) {
                    if (z3) {
                        biVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        biVar.d.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z3) {
                    biVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    biVar.d.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (this.o == 1) {
                    com.baidu.tieba.d.ac.h((View) biVar.d, (int) R.drawable.pb_list_floor_number_1);
                    if (z3) {
                        biVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        biVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    com.baidu.tieba.d.ac.h((View) biVar.d, (int) R.drawable.pb_list_floor_number);
                    if (z3) {
                        biVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        biVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                biVar.d.setText(String.valueOf(String.valueOf(aqVar.f())) + resources.getString(R.string.floor));
            }
            biVar.f.setTag(R.id.tag_load_sub_data, aqVar);
            biVar.f.setTag(R.id.tag_load_sub_view, view);
            if (aqVar.k() > 0 && aqVar.a() != null) {
                if (this.k == null) {
                    this.k = new bj(this.b);
                    this.k.b(this.i);
                    this.k.c(this.m);
                    this.k.a(this.h);
                    String a = this.a.b().g().a();
                    this.k.a(this.a.l(), a != null && a.equals(TiebaApplication.z()));
                    this.k.a(this.d);
                }
                biVar.j.removeAllViews();
                ArrayList a2 = aqVar.a();
                if (a2 != null) {
                    for (int i = 0; i < a2.size(); i++) {
                        View b = this.k.b();
                        if (a2.get(i) != null && ((com.baidu.tieba.a.aq) a2.get(i)).h() != null) {
                            b.setTag(R.id.tag_photo_username, ((com.baidu.tieba.a.aq) a2.get(i)).h().c());
                            b.setClickable(true);
                        }
                        b.setOnClickListener(this.i);
                        b.setOnLongClickListener(this.l);
                        b.setTag(R.id.tag_load_sub_data, aqVar);
                        b.setTag(R.id.tag_load_sub_view, view);
                        b.setTag(R.id.tag_clip_board, a2.get(i));
                        this.k.a((bk) b.getTag(), (com.baidu.tieba.a.aq) a2.get(i), a2.size() - i > 1);
                        biVar.j.addView(b);
                    }
                }
                if (a2 != null && aqVar.k() > a2.size()) {
                    View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
                    biVar.j.addView(inflate);
                    a((TextView) inflate.findViewById(R.id.sub_pb_more_text), aqVar.k() - a2.size());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                    if (TiebaApplication.d().ai() == 1) {
                        imageView.setBackgroundResource(R.drawable.icon_little_down_1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.icon_little_down);
                    }
                    inflate.setOnClickListener(this.i);
                    inflate.setTag(R.id.tag_load_sub_data, aqVar);
                    inflate.setTag(R.id.tag_load_sub_view, view);
                }
            } else {
                biVar.j.setVisibility(8);
                if (TiebaApplication.d().ai() == 1) {
                    biVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    biVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
            }
            String e = aqVar.h().e();
            Bitmap b2 = this.g.b(e);
            if (aqVar.h() != null) {
                biVar.b.setText(aqVar.h().d());
                int k = aqVar.h().k();
                int f = aqVar.h().f();
                if (k != 0 && f != 0) {
                    biVar.c.setText(String.valueOf(k));
                    biVar.c.setBackgroundResource(com.baidu.tieba.d.e.b(k));
                }
            }
            biVar.a.setTag(R.id.tag_photo_userid, aqVar.h().a());
            biVar.a.setTag(R.id.tag_photo_username, aqVar.h().c());
            biVar.b.setTag(R.id.tag_photo_userid, aqVar.h().a());
            biVar.b.setTag(R.id.tag_photo_username, aqVar.h().c());
            if (b2 != null) {
                biVar.a.setBackgroundDrawable(new BitmapDrawable(b2));
            } else {
                biVar.a.setTag(e);
                biVar.a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.d.e.a((int) R.drawable.photo)));
            }
            biVar.h.setText(aqVar.a(this.b));
            if (this.a.l() != 0) {
                String a3 = aqVar.h().a();
                boolean z4 = a3 == null || !a3.equals(TiebaApplication.z());
                if (a3 == null || a3.equals("0") || a3.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z4;
                    z = true;
                }
            } else {
                String a4 = this.a.b().g().a();
                if (a4 == null || !a4.equals(TiebaApplication.z())) {
                    z = false;
                    z2 = false;
                } else {
                    z = true;
                    z2 = false;
                }
            }
            if (TiebaApplication.d().ai() == 1) {
                com.baidu.tieba.d.ac.h((View) biVar.g, (int) R.drawable.common_image_btn_selector_1);
                biVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            } else {
                com.baidu.tieba.d.ac.h((View) biVar.g, (int) R.drawable.common_image_btn_selector);
                biVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            }
            if (z && z2) {
                biVar.g.setVisibility(0);
                biVar.g.setText(R.string.manage);
                if (TiebaApplication.d().ai() == 1) {
                    biVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                } else {
                    biVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                }
            } else if (z) {
                biVar.g.setVisibility(0);
                biVar.g.setText(R.string.delete);
                if (TiebaApplication.d().ai() == 1) {
                    biVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector_1, 0, 0, 0);
                } else {
                    biVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector, 0, 0, 0);
                }
            } else {
                biVar.g.setVisibility(8);
            }
            int i2 = aqVar.f() == 1 ? 0 : 1;
            if (biVar.g.getVisibility() == 0) {
                biVar.g.setTag(R.id.tag_manage_user_identity, Integer.valueOf(this.a.l()));
            }
            if (z) {
                biVar.g.setTag(R.id.tag_del_post_type, Integer.valueOf(i2));
                biVar.g.setTag(R.id.tag_del_post_id, aqVar.d());
            } else {
                biVar.g.setTag(R.id.tag_del_post_type, 0);
                biVar.g.setTag(R.id.tag_del_post_id, "");
            }
            if (z2) {
                biVar.g.setTag(R.id.tag_forbid_user_name, aqVar.h().c());
            } else {
                biVar.g.setTag(R.id.tag_forbid_user_name, "");
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
        if (TiebaApplication.d().ai() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(-12687203), indexOf, valueOf.length() + indexOf, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-12810784), indexOf, valueOf.length() + indexOf, 33);
        }
        textView.setText(spannableString);
    }
}
