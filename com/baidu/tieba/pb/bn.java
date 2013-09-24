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
public class bn extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.ao f1559a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.a g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private com.baidu.tbadk.widget.richText.m j = null;
    private bp k = null;
    private View.OnLongClickListener l = null;
    private View.OnClickListener m = null;
    private int n = -1;
    private int o = 0;

    public bn(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(UtilHelper.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.o = TiebaApplication.g().ap();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.a(this.b);
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.f1559a = aoVar;
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
        if (this.f1559a == null || this.f1559a.d() == null) {
            return 0;
        }
        return this.f1559a.d().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f1559a == null || this.f1559a.d() == null || i < 0 || i >= this.f1559a.d().size()) {
            return null;
        }
        return this.f1559a.d().get(i);
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
        this.o = TiebaApplication.g().ap();
        if (view == null) {
            view = h();
        }
        bo boVar = (bo) view.getTag();
        com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) getItem(i);
        NewPbActivity newPbActivity = (NewPbActivity) this.b;
        newPbActivity.l().a(this.o == 1);
        newPbActivity.l().a(view);
        if (asVar != null) {
            a(boVar, asVar, view);
        }
        return view;
    }

    private View h() {
        bo boVar = new bo(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, (ViewGroup) null);
        boVar.f1560a = (HeadImageView) inflate.findViewById(R.id.photo);
        boVar.b = (TextView) inflate.findViewById(R.id.user_name);
        boVar.c = (TextView) inflate.findViewById(R.id.user_rank);
        boVar.f = (Button) inflate.findViewById(R.id.reply);
        boVar.g = (Button) inflate.findViewById(R.id.manage_btn);
        boVar.h = (TbRichTextView) inflate.findViewById(R.id.richText);
        boVar.g.setOnClickListener(this.m);
        boVar.d = (TextView) inflate.findViewById(R.id.floor);
        boVar.e = (TextView) inflate.findViewById(R.id.time);
        boVar.i = (LinearLayout) inflate.findViewById(R.id.pb_post_header_layout);
        boVar.j = (LinearLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        boVar.b.setOnClickListener(this.h);
        boVar.f.setOnClickListener(this.i);
        boVar.f1560a.setOnClickListener(this.h);
        boVar.f1560a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo_bg)));
        boVar.i.setOnLongClickListener(this.l);
        if (this.n < 0) {
            this.n = (((UtilHelper.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - boVar.h.getPaddingLeft()) - boVar.h.getPaddingRight();
        }
        this.n = this.e > this.n ? this.n : this.e;
        boVar.h.setMaxImageWidth(this.n);
        boVar.h.setMaxImageHeight((int) (this.n * 1.618f));
        boVar.h.setTextSize(com.baidu.tieba.data.g.o());
        if (!this.d) {
            boVar.f1560a.setVisibility(8);
        }
        boVar.h.setDisplayImage(this.c);
        boVar.h.setOnImageClickListener(this.j);
        inflate.setTag(boVar);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0340  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bo boVar, com.baidu.tieba.data.as asVar, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        boolean z4;
        if (boVar != null && asVar != null) {
            boVar.f1560a.setTag(null);
            boVar.f1560a.setUserId(null);
            boVar.b.setText((CharSequence) null);
            boVar.c.setText((CharSequence) null);
            boVar.c.setBackgroundResource(0);
            boVar.j.setVisibility(0);
            boVar.d.setText((CharSequence) null);
            boVar.f.setVisibility(0);
            boVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            SparseArray sparseArray3 = (SparseArray) boVar.i.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                boVar.i.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_clip_board, asVar);
            sparseArray3.put(R.id.tag_is_subpb, false);
            boolean z5 = false;
            String h = this.f1559a.h();
            if (this.f1559a.g() && h != null && h.equals(asVar.d())) {
                z5 = true;
            }
            Resources resources = this.b.getResources();
            boVar.e.setText(com.baidu.tieba.util.at.i(new Date(asVar.f())));
            if (asVar.e() == 1) {
                boVar.f.setVisibility(8);
            }
            if (this.f != null && this.f.equals(asVar.g().getId())) {
                if (this.o == 1) {
                    if (z5) {
                        boVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        boVar.d.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z5) {
                    boVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    boVar.d.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (this.o == 1) {
                    boVar.d.setBackgroundResource(R.drawable.pb_list_floor_number_1);
                    if (z5) {
                        boVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        boVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    boVar.d.setBackgroundResource(R.drawable.pb_list_floor_number);
                    if (z5) {
                        boVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        boVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                boVar.d.setText(String.valueOf(String.valueOf(asVar.e())) + resources.getString(R.string.floor));
            }
            if (TiebaApplication.g().ap() == 1) {
                boVar.h.setVideoImageId(R.drawable.pic_video_1);
                boVar.h.setTextColor(this.b.getResources().getColor(R.color.gray_night_1));
                com.baidu.tieba.util.as.e((View) boVar.f, (int) R.drawable.common_image_btn_selector_1);
                boVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
                boVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
            } else {
                boVar.h.setVideoImageId(R.drawable.pic_video);
                boVar.h.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                com.baidu.tieba.util.as.e((View) boVar.f, (int) R.drawable.common_image_btn_selector);
                boVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
                boVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
            }
            SparseArray sparseArray4 = (SparseArray) boVar.f.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                boVar.f.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, asVar);
            sparseArray4.put(R.id.tag_load_sub_view, view);
            if (asVar.j() > 0 && asVar.a() != null) {
                if (this.k == null) {
                    this.k = new bp(this.b, this.h);
                    this.k.a(this.m);
                    boolean z6 = false;
                    String id = this.f1559a.c().g().getId();
                    if (id != null && id.equals(TiebaApplication.C())) {
                        z6 = true;
                    }
                    this.k.a(this.f1559a.j(), z6);
                    this.k.a(this.d);
                }
                boVar.j.removeAllViews();
                ArrayList<com.baidu.tieba.data.as> a2 = asVar.a();
                if (a2 != null) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= a2.size()) {
                            break;
                        }
                        View b = this.k.b();
                        b.setOnClickListener(this.i);
                        b.setOnLongClickListener(this.l);
                        b.setClickable(true);
                        SparseArray sparseArray5 = (SparseArray) b.getTag();
                        if (sparseArray5 == null) {
                            SparseArray sparseArray6 = new SparseArray();
                            b.setTag(sparseArray6);
                            sparseArray2 = sparseArray6;
                        } else {
                            sparseArray2 = sparseArray5;
                        }
                        sparseArray2.put(R.id.tag_load_sub_data, asVar);
                        sparseArray2.put(R.id.tag_load_sub_view, view);
                        sparseArray2.put(R.id.tag_is_subpb, true);
                        if (a2.get(i3) != null && a2.get(i3).g() != null) {
                            sparseArray2.put(R.id.tag_photo_username, a2.get(i3).g().getName());
                            sparseArray2.put(R.id.tag_clip_board, a2.get(i3));
                        }
                        bq bqVar = (bq) sparseArray2.get(R.id.tag_holder);
                        bp bpVar = this.k;
                        com.baidu.tieba.data.as asVar2 = a2.get(i3);
                        if (asVar.j() > a2.size()) {
                            z4 = true;
                        } else {
                            z4 = a2.size() - i3 > 1;
                        }
                        bpVar.a(bqVar, asVar2, z4);
                        boVar.j.addView(b);
                        i2 = i3 + 1;
                    }
                }
                if (a2 != null && asVar.j() > a2.size()) {
                    View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
                    boVar.j.addView(inflate);
                    a(this.b, (TextView) inflate.findViewById(R.id.sub_pb_more_text), asVar.j() - a2.size());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                    if (TiebaApplication.g().ap() == 1) {
                        imageView.setBackgroundResource(R.drawable.ico_downward_1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.ico_downward);
                    }
                    inflate.setOnClickListener(this.i);
                    SparseArray sparseArray7 = (SparseArray) inflate.getTag();
                    if (sparseArray7 == null) {
                        sparseArray7 = new SparseArray();
                        inflate.setTag(sparseArray7);
                    }
                    sparseArray7.put(R.id.tag_load_sub_data, asVar);
                    sparseArray7.put(R.id.tag_load_sub_view, view);
                }
            } else {
                boVar.j.setVisibility(8);
                if (TiebaApplication.g().ap() == 1) {
                    boVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    boVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
            }
            String portrait = asVar.g().getPortrait();
            com.baidu.adp.widget.a.c c = this.g.c(portrait);
            if (asVar.g() != null) {
                boVar.b.setText(asVar.g().getName_show());
                int level_id = asVar.g().getLevel_id();
                int isLike = asVar.g().getIsLike();
                if (level_id != 0 && isLike != 0) {
                    boVar.c.setText(String.valueOf(level_id));
                    boVar.c.setBackgroundResource(com.baidu.tieba.util.e.b(level_id));
                }
            }
            boVar.f1560a.setUserId(asVar.g().getId());
            boVar.f1560a.setImageBitmap(null);
            boVar.b.setTag(asVar.g().getId());
            if (c != null) {
                c.a(boVar.f1560a);
            } else {
                boVar.f1560a.setTag(portrait);
                boVar.f1560a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo)));
            }
            if (this.o == 1) {
                boVar.h.setDefaultImageId(R.drawable.pic_image_h_not_1);
            } else {
                boVar.h.setDefaultImageId(R.drawable.pic_image_h_not);
            }
            boVar.h.setVoiceViewRes(R.layout.voice_play_btn);
            boVar.h.setText(asVar.h());
            boVar.h.a();
            boolean z7 = false;
            boolean z8 = false;
            if (this.f1559a.j() != 0) {
                z7 = true;
                z8 = true;
                String id2 = asVar.g().getId();
                if (id2 != null && id2.equals(TiebaApplication.C())) {
                    z7 = false;
                }
                if (id2 == null || id2.equals("0") || id2.length() == 0) {
                    z = false;
                    z2 = true;
                    z3 = false;
                    if (TiebaApplication.g().ap() == 1) {
                        com.baidu.tieba.util.as.e((View) boVar.g, (int) R.drawable.common_image_btn_selector_1);
                        boVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
                    } else {
                        com.baidu.tieba.util.as.e((View) boVar.g, (int) R.drawable.common_image_btn_selector);
                        boVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
                    }
                    if (!z2 && z) {
                        boVar.g.setVisibility(0);
                        boVar.g.setText(R.string.manage);
                        if (TiebaApplication.g().ap() == 1) {
                            boVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                        } else {
                            boVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                        }
                    } else if (z2) {
                        boVar.g.setVisibility(0);
                        boVar.g.setText(R.string.delete);
                        if (TiebaApplication.g().ap() == 1) {
                            boVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector_1, 0, 0, 0);
                        } else {
                            boVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector, 0, 0, 0);
                        }
                    } else {
                        boVar.g.setVisibility(8);
                    }
                    if (asVar.e() != 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    sparseArray = (SparseArray) boVar.g.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        boVar.g.setTag(sparseArray);
                    }
                    if (boVar.g.getVisibility() == 0) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f1559a.j()));
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_id, asVar.d());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    if (z) {
                        sparseArray.put(R.id.tag_forbid_user_name, asVar.g().getName());
                        return;
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        return;
                    }
                }
                z = z7;
                z2 = z8;
                z3 = false;
                if (TiebaApplication.g().ap() == 1) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (asVar.e() != 1) {
                }
                sparseArray = (SparseArray) boVar.g.getTag();
                if (sparseArray == null) {
                }
                if (boVar.g.getVisibility() == 0) {
                }
                if (z2) {
                }
                if (z) {
                }
            } else {
                String id3 = this.f1559a.c().g().getId();
                if (id3 != null && id3.equals(TiebaApplication.C())) {
                    z = false;
                    z2 = true;
                    z3 = false;
                } else {
                    String id4 = asVar.g().getId();
                    if (id4 != null && id4.equals(TiebaApplication.C())) {
                        z = false;
                        z2 = true;
                        z3 = true;
                    }
                    z = z7;
                    z2 = z8;
                    z3 = false;
                }
                if (TiebaApplication.g().ap() == 1) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (asVar.e() != 1) {
                }
                sparseArray = (SparseArray) boVar.g.getTag();
                if (sparseArray == null) {
                }
                if (boVar.g.getVisibility() == 0) {
                }
                if (z2) {
                }
                if (z) {
                }
            }
        }
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.j = mVar;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TiebaApplication.g().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.g().ap() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(-12687203), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.pb_load_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-12810784), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.pb_load_more_text));
        }
        textView.setText(spannableString);
    }
}
