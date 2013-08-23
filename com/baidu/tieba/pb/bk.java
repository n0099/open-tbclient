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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bk extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.ao f1514a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.a g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private com.baidu.tbadk.widget.richText.m j = null;
    private bm k = null;
    private View.OnLongClickListener l = null;
    private View.OnClickListener m = null;
    private int n = -1;
    private int o = 0;

    public bk(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(UtilHelper.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.o = TiebaApplication.g().an();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.a(this.b);
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.f1514a = aoVar;
        if (aoVar.c() != null && aoVar.c().g() != null) {
            this.f = aoVar.c().g().getId();
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
        if (this.f1514a == null || this.f1514a.d() == null) {
            return 0;
        }
        return this.f1514a.d().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f1514a == null || this.f1514a.d() == null || i < 0 || i >= this.f1514a.d().size()) {
            return null;
        }
        return this.f1514a.d().get(i);
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
        bl blVar = (bl) view.getTag();
        com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) getItem(i);
        if (asVar != null) {
            a(blVar, asVar, view);
        }
        return view;
    }

    private View h() {
        bl blVar = new bl(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, (ViewGroup) null);
        blVar.f1515a = (HeadImageView) inflate.findViewById(R.id.photo);
        blVar.b = (TextView) inflate.findViewById(R.id.user_name);
        blVar.c = (TextView) inflate.findViewById(R.id.user_rank);
        blVar.f = (Button) inflate.findViewById(R.id.reply);
        blVar.g = (Button) inflate.findViewById(R.id.manage_btn);
        blVar.h = (TbRichTextView) inflate.findViewById(R.id.richText);
        blVar.g.setOnClickListener(this.m);
        blVar.d = (TextView) inflate.findViewById(R.id.floor);
        blVar.e = (TextView) inflate.findViewById(R.id.time);
        blVar.i = (LinearLayout) inflate.findViewById(R.id.pb_post_header_layout);
        blVar.j = (LinearLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        blVar.b.setOnClickListener(this.h);
        blVar.f.setOnClickListener(this.i);
        blVar.f1515a.setOnClickListener(this.h);
        blVar.f1515a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo_bg)));
        blVar.i.setOnLongClickListener(this.l);
        if (this.n < 0) {
            this.n = (((UtilHelper.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - blVar.h.getPaddingLeft()) - blVar.h.getPaddingRight();
        }
        this.n = this.e > this.n ? this.n : this.e;
        blVar.h.setMaxImageWidth(this.n);
        blVar.h.setMaxImageHeight((int) (this.n * 1.618f));
        blVar.h.setTextSize(com.baidu.tieba.data.g.o());
        if (!this.d) {
            blVar.f1515a.setVisibility(8);
        }
        blVar.h.setDisplayImage(this.c);
        blVar.h.setOnImageClickListener(this.j);
        com.baidu.tieba.util.ao.e(blVar.b, this.o);
        com.baidu.tieba.util.ao.d(blVar.e, this.o);
        if (TiebaApplication.g().an() == 1) {
            blVar.h.setTextColor(this.b.getResources().getColor(R.color.gray_night_1));
            com.baidu.tieba.util.ao.g((View) blVar.f, (int) R.drawable.common_image_btn_selector_1);
            blVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            blVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            blVar.h.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
            com.baidu.tieba.util.ao.g((View) blVar.f, (int) R.drawable.common_image_btn_selector);
            blVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            blVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        inflate.setTag(blVar);
        return inflate;
    }

    private void a(bl blVar, com.baidu.tieba.data.as asVar, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        SparseArray sparseArray;
        if (blVar != null && asVar != null) {
            blVar.f1515a.setTag(null);
            blVar.f1515a.setUserId(null);
            blVar.b.setText((CharSequence) null);
            blVar.c.setText((CharSequence) null);
            blVar.c.setBackgroundResource(0);
            blVar.j.setVisibility(0);
            blVar.d.setText((CharSequence) null);
            blVar.f.setVisibility(0);
            blVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (TiebaApplication.g().an() == 1) {
                blVar.i.setBackgroundResource(R.drawable.bg_list_top_1);
                blVar.j.setBackgroundResource(R.drawable.bg_list_bottom_1);
                blVar.h.setVideoImageId(R.drawable.pic_video_1);
            } else {
                blVar.i.setBackgroundResource(R.drawable.bg_list_top);
                blVar.j.setBackgroundResource(R.drawable.bg_list_bottom);
                blVar.h.setVideoImageId(R.drawable.pic_video);
            }
            SparseArray sparseArray2 = (SparseArray) blVar.i.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                blVar.i.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_clip_board, asVar);
            sparseArray2.put(R.id.tag_is_subpb, false);
            String h = this.f1514a.h();
            boolean z4 = this.f1514a.g() && h != null && h.equals(asVar.d());
            Resources resources = this.b.getResources();
            blVar.e.setText(com.baidu.tieba.util.ap.g(new Date(asVar.f())));
            if (asVar.e() == 1) {
                blVar.f.setVisibility(8);
            }
            if (this.f != null && this.f.equals(asVar.g().getId())) {
                if (this.o == 1) {
                    if (z4) {
                        blVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        blVar.d.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z4) {
                    blVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    blVar.d.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (this.o == 1) {
                    com.baidu.tieba.util.ao.g((View) blVar.d, (int) R.drawable.pb_list_floor_number_1);
                    if (z4) {
                        blVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        blVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    com.baidu.tieba.util.ao.g((View) blVar.d, (int) R.drawable.pb_list_floor_number);
                    if (z4) {
                        blVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        blVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                blVar.d.setText(String.valueOf(String.valueOf(asVar.e())) + resources.getString(R.string.floor));
            }
            SparseArray sparseArray3 = (SparseArray) blVar.f.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                blVar.f.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, asVar);
            sparseArray3.put(R.id.tag_load_sub_view, view);
            if (asVar.j() > 0 && asVar.a() != null) {
                if (this.k == null) {
                    this.k = new bm(this.b, this.h);
                    this.k.a(this.m);
                    String id = this.f1514a.c().g().getId();
                    this.k.a(this.f1514a.j(), id != null && id.equals(TiebaApplication.E()));
                    this.k.a(this.d);
                }
                blVar.j.removeAllViews();
                ArrayList a2 = asVar.a();
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
                        sparseArray.put(R.id.tag_load_sub_data, asVar);
                        sparseArray.put(R.id.tag_load_sub_view, view);
                        sparseArray.put(R.id.tag_is_subpb, true);
                        if (a2.get(i) != null && ((com.baidu.tieba.data.as) a2.get(i)).g() != null) {
                            sparseArray.put(R.id.tag_photo_username, ((com.baidu.tieba.data.as) a2.get(i)).g().getName());
                            sparseArray.put(R.id.tag_clip_board, a2.get(i));
                        }
                        this.k.a((bn) sparseArray.get(R.id.tag_holder), (com.baidu.tieba.data.as) a2.get(i), a2.size() - i > 1);
                        blVar.j.addView(b);
                    }
                }
                if (a2 != null && asVar.j() > a2.size()) {
                    View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
                    blVar.j.addView(inflate);
                    a((TextView) inflate.findViewById(R.id.sub_pb_more_text), asVar.j() - a2.size());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                    if (TiebaApplication.g().an() == 1) {
                        imageView.setBackgroundResource(R.drawable.ico_downward_1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.ico_downward);
                    }
                    inflate.setOnClickListener(this.i);
                    SparseArray sparseArray6 = (SparseArray) inflate.getTag();
                    if (sparseArray6 == null) {
                        sparseArray6 = new SparseArray();
                        inflate.setTag(sparseArray6);
                    }
                    sparseArray6.put(R.id.tag_load_sub_data, asVar);
                    sparseArray6.put(R.id.tag_load_sub_view, view);
                }
            } else {
                blVar.j.setVisibility(8);
                if (TiebaApplication.g().an() == 1) {
                    blVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    blVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
            }
            String portrait = asVar.g().getPortrait();
            com.baidu.adp.widget.a.b c = this.g.c(portrait);
            if (asVar.g() != null) {
                blVar.b.setText(asVar.g().getName_show());
                int level_id = asVar.g().getLevel_id();
                int isLike = asVar.g().getIsLike();
                if (level_id != 0 && isLike != 0) {
                    blVar.c.setText(String.valueOf(level_id));
                    blVar.c.setBackgroundResource(com.baidu.tieba.util.e.b(level_id));
                }
            }
            blVar.f1515a.setUserId(asVar.g().getId());
            blVar.f1515a.setImageBitmap(null);
            blVar.b.setTag(asVar.g().getId());
            if (c != null) {
                c.a(blVar.f1515a);
            } else {
                blVar.f1515a.setTag(portrait);
                blVar.f1515a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo)));
            }
            if (this.o == 1) {
                blVar.h.setDefaultImageId(R.drawable.pic_image_h_not_1);
            } else {
                blVar.h.setDefaultImageId(R.drawable.pic_image_h_not);
            }
            blVar.h.setText(asVar.h());
            blVar.h.a();
            if (this.f1514a.j() != 0) {
                String id2 = asVar.g().getId();
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
                String id3 = this.f1514a.c().g().getId();
                if (id3 == null || !id3.equals(TiebaApplication.E())) {
                    String id4 = asVar.g().getId();
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
            if (TiebaApplication.g().an() == 1) {
                com.baidu.tieba.util.ao.g((View) blVar.g, (int) R.drawable.common_image_btn_selector_1);
                blVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            } else {
                com.baidu.tieba.util.ao.g((View) blVar.g, (int) R.drawable.common_image_btn_selector);
                blVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            }
            if (z2 && z3) {
                blVar.g.setVisibility(0);
                blVar.g.setText(R.string.manage);
                if (TiebaApplication.g().an() == 1) {
                    blVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                } else {
                    blVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                }
            } else if (z2) {
                blVar.g.setVisibility(0);
                blVar.g.setText(R.string.delete);
                if (TiebaApplication.g().an() == 1) {
                    blVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector_1, 0, 0, 0);
                } else {
                    blVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector, 0, 0, 0);
                }
            } else {
                blVar.g.setVisibility(8);
            }
            int i2 = asVar.e() == 1 ? 0 : 1;
            SparseArray sparseArray7 = (SparseArray) blVar.g.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                blVar.g.setTag(sparseArray7);
            }
            if (blVar.g.getVisibility() == 0) {
                sparseArray7.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f1514a.j()));
            }
            if (z2) {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray7.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                sparseArray7.put(R.id.tag_del_post_id, asVar.d());
            } else {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray7.put(R.id.tag_del_post_type, 0);
                sparseArray7.put(R.id.tag_del_post_id, "");
            }
            if (z3) {
                sparseArray7.put(R.id.tag_forbid_user_name, asVar.g().getName());
            } else {
                sparseArray7.put(R.id.tag_forbid_user_name, "");
            }
        }
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.j = mVar;
    }

    public static void a(TextView textView, int i) {
        String string = TiebaApplication.g().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.g().an() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(-12687203), indexOf, valueOf.length() + indexOf, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-12810784), indexOf, valueOf.length() + indexOf, 33);
        }
        textView.setText(spannableString);
    }
}
