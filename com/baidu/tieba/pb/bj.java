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
public class bj extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.as f1478a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.a g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private com.baidu.tbadk.widget.richText.m j = null;
    private bl k = null;
    private View.OnLongClickListener l = null;
    private View.OnClickListener m = null;
    private int n = -1;
    private int o = 0;

    public bj(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(com.baidu.tieba.util.am.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.o = TiebaApplication.f().au();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.a(this.b);
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.data.as asVar) {
        this.f1478a = asVar;
        if (asVar.b() != null && asVar.b().g() != null) {
            this.f = asVar.b().g().getId();
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
        if (this.f1478a == null || this.f1478a.c() == null) {
            return 0;
        }
        return this.f1478a.c().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f1478a == null || this.f1478a.c() == null || i < 0 || i >= this.f1478a.c().size()) {
            return null;
        }
        return this.f1478a.c().get(i);
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
        bk bkVar = (bk) view.getTag();
        com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) getItem(i);
        if (awVar != null) {
            a(bkVar, awVar, view);
        }
        return view;
    }

    private View h() {
        bk bkVar = new bk(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, (ViewGroup) null);
        bkVar.f1479a = (HeadImageView) inflate.findViewById(R.id.photo);
        bkVar.b = (TextView) inflate.findViewById(R.id.user_name);
        bkVar.c = (TextView) inflate.findViewById(R.id.user_rank);
        bkVar.f = (Button) inflate.findViewById(R.id.reply);
        bkVar.g = (Button) inflate.findViewById(R.id.manage_btn);
        bkVar.h = (TbRichTextView) inflate.findViewById(R.id.richText);
        bkVar.g.setOnClickListener(this.m);
        bkVar.d = (TextView) inflate.findViewById(R.id.floor);
        bkVar.e = (TextView) inflate.findViewById(R.id.time);
        bkVar.i = (LinearLayout) inflate.findViewById(R.id.pb_post_header_layout);
        bkVar.j = (LinearLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        bkVar.b.setOnClickListener(this.h);
        bkVar.f.setOnClickListener(this.i);
        bkVar.f1479a.setOnClickListener(this.h);
        bkVar.f1479a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo_bg)));
        bkVar.i.setOnLongClickListener(this.l);
        if (this.n < 0) {
            this.n = (((com.baidu.tieba.util.am.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bkVar.h.getPaddingLeft()) - bkVar.h.getPaddingRight();
        }
        this.n = this.e > this.n ? this.n : this.e;
        bkVar.h.setMaxImageWidth(this.n);
        bkVar.h.setMaxImageHeight((int) (this.n * 1.618f));
        bkVar.h.setTextSize(com.baidu.tieba.data.g.n());
        if (!this.d) {
            bkVar.f1479a.setVisibility(8);
        }
        bkVar.h.setDisplayImage(this.c);
        bkVar.h.setOnImageClickListener(this.j);
        com.baidu.tieba.util.ah.e(bkVar.b, this.o);
        com.baidu.tieba.util.ah.d(bkVar.e, this.o);
        if (TiebaApplication.f().au() == 1) {
            bkVar.h.setTextColor(this.b.getResources().getColor(R.color.gray_night_1));
            com.baidu.tieba.util.ah.h((View) bkVar.f, (int) R.drawable.common_image_btn_selector_1);
            bkVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            bkVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            bkVar.h.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
            com.baidu.tieba.util.ah.h((View) bkVar.f, (int) R.drawable.common_image_btn_selector);
            bkVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            bkVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        inflate.setTag(bkVar);
        return inflate;
    }

    private void a(bk bkVar, com.baidu.tieba.data.aw awVar, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        SparseArray sparseArray;
        if (bkVar != null && awVar != null) {
            bkVar.f1479a.setTag(null);
            bkVar.f1479a.setUserId(null);
            bkVar.b.setText((CharSequence) null);
            bkVar.c.setText((CharSequence) null);
            bkVar.c.setBackgroundResource(0);
            bkVar.j.setVisibility(0);
            bkVar.d.setText((CharSequence) null);
            bkVar.f.setVisibility(0);
            bkVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (TiebaApplication.f().au() == 1) {
                bkVar.i.setBackgroundResource(R.drawable.bg_list_top_1);
                bkVar.j.setBackgroundResource(R.drawable.bg_list_bottom_1);
                bkVar.h.setVideoImageId(R.drawable.pic_video_1);
            } else {
                bkVar.i.setBackgroundResource(R.drawable.bg_list_top);
                bkVar.j.setBackgroundResource(R.drawable.bg_list_bottom);
                bkVar.h.setVideoImageId(R.drawable.pic_video);
            }
            SparseArray sparseArray2 = (SparseArray) bkVar.i.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bkVar.i.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_clip_board, awVar);
            sparseArray2.put(R.id.tag_is_subpb, false);
            String g = this.f1478a.g();
            boolean z4 = this.f1478a.f() && g != null && g.equals(awVar.d());
            Resources resources = this.b.getResources();
            bkVar.e.setText(com.baidu.tieba.util.ai.e(new Date(awVar.f())));
            if (awVar.e() == 1) {
                bkVar.f.setVisibility(8);
            }
            if (this.f != null && this.f.equals(awVar.g().getId())) {
                if (this.o == 1) {
                    if (z4) {
                        bkVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        bkVar.d.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z4) {
                    bkVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    bkVar.d.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (this.o == 1) {
                    com.baidu.tieba.util.ah.h((View) bkVar.d, (int) R.drawable.pb_list_floor_number_1);
                    if (z4) {
                        bkVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        bkVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    com.baidu.tieba.util.ah.h((View) bkVar.d, (int) R.drawable.pb_list_floor_number);
                    if (z4) {
                        bkVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        bkVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                bkVar.d.setText(String.valueOf(String.valueOf(awVar.e())) + resources.getString(R.string.floor));
            }
            SparseArray sparseArray3 = (SparseArray) bkVar.f.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                bkVar.f.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, awVar);
            sparseArray3.put(R.id.tag_load_sub_view, view);
            if (awVar.j() > 0 && awVar.a() != null) {
                if (this.k == null) {
                    this.k = new bl(this.b, this.h);
                    this.k.a(this.m);
                    String id = this.f1478a.b().g().getId();
                    this.k.a(this.f1478a.i(), id != null && id.equals(TiebaApplication.E()));
                    this.k.a(this.d);
                }
                bkVar.j.removeAllViews();
                ArrayList a2 = awVar.a();
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
                        sparseArray.put(R.id.tag_load_sub_data, awVar);
                        sparseArray.put(R.id.tag_load_sub_view, view);
                        sparseArray.put(R.id.tag_is_subpb, true);
                        if (a2.get(i) != null && ((com.baidu.tieba.data.aw) a2.get(i)).g() != null) {
                            sparseArray.put(R.id.tag_photo_username, ((com.baidu.tieba.data.aw) a2.get(i)).g().getName());
                            sparseArray.put(R.id.tag_clip_board, a2.get(i));
                        }
                        this.k.a((bm) sparseArray.get(R.id.tag_holder), (com.baidu.tieba.data.aw) a2.get(i), a2.size() - i > 1);
                        bkVar.j.addView(b);
                    }
                }
                if (a2 != null && awVar.j() > a2.size()) {
                    View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
                    bkVar.j.addView(inflate);
                    a((TextView) inflate.findViewById(R.id.sub_pb_more_text), awVar.j() - a2.size());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                    if (TiebaApplication.f().au() == 1) {
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
                    sparseArray6.put(R.id.tag_load_sub_data, awVar);
                    sparseArray6.put(R.id.tag_load_sub_view, view);
                }
            } else {
                bkVar.j.setVisibility(8);
                if (TiebaApplication.f().au() == 1) {
                    bkVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    bkVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
            }
            String portrait = awVar.g().getPortrait();
            com.baidu.adp.widget.a.b c = this.g.c(portrait);
            if (awVar.g() != null) {
                bkVar.b.setText(awVar.g().getName_show());
                int level_id = awVar.g().getLevel_id();
                int isLike = awVar.g().getIsLike();
                if (level_id != 0 && isLike != 0) {
                    bkVar.c.setText(String.valueOf(level_id));
                    bkVar.c.setBackgroundResource(com.baidu.tieba.util.e.b(level_id));
                }
            }
            bkVar.f1479a.setUserId(awVar.g().getId());
            bkVar.b.setTag(awVar.g().getId());
            if (c != null) {
                c.a(bkVar.f1479a);
            } else {
                bkVar.f1479a.setTag(portrait);
                bkVar.f1479a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo)));
            }
            bkVar.h.setText(awVar.h());
            bkVar.h.a();
            if (this.f1478a.i() != 0) {
                String id2 = awVar.g().getId();
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
                String id3 = this.f1478a.b().g().getId();
                if (id3 == null || !id3.equals(TiebaApplication.E())) {
                    String id4 = awVar.g().getId();
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
            if (TiebaApplication.f().au() == 1) {
                com.baidu.tieba.util.ah.h((View) bkVar.g, (int) R.drawable.common_image_btn_selector_1);
                bkVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            } else {
                com.baidu.tieba.util.ah.h((View) bkVar.g, (int) R.drawable.common_image_btn_selector);
                bkVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            }
            if (z2 && z3) {
                bkVar.g.setVisibility(0);
                bkVar.g.setText(R.string.manage);
                if (TiebaApplication.f().au() == 1) {
                    bkVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                } else {
                    bkVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                }
            } else if (z2) {
                bkVar.g.setVisibility(0);
                bkVar.g.setText(R.string.delete);
                if (TiebaApplication.f().au() == 1) {
                    bkVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector_1, 0, 0, 0);
                } else {
                    bkVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector, 0, 0, 0);
                }
            } else {
                bkVar.g.setVisibility(8);
            }
            int i2 = awVar.e() == 1 ? 0 : 1;
            SparseArray sparseArray7 = (SparseArray) bkVar.g.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                bkVar.g.setTag(sparseArray7);
            }
            if (bkVar.g.getVisibility() == 0) {
                sparseArray7.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f1478a.i()));
            }
            if (z2) {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray7.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                sparseArray7.put(R.id.tag_del_post_id, awVar.d());
            } else {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray7.put(R.id.tag_del_post_type, 0);
                sparseArray7.put(R.id.tag_del_post_id, "");
            }
            if (z3) {
                sparseArray7.put(R.id.tag_forbid_user_name, awVar.g().getName());
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
        if (TiebaApplication.f().au() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(-12687203), indexOf, valueOf.length() + indexOf, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-12810784), indexOf, valueOf.length() + indexOf, 33);
        }
        textView.setText(spannableString);
    }
}
