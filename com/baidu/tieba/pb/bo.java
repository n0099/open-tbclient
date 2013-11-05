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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bo extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.ao f2077a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.a g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private com.baidu.tbadk.widget.richText.m j = null;
    private br k = null;
    private View.OnLongClickListener l = null;
    private View.OnClickListener m = null;
    private int n = -1;
    private int o = 0;

    public bo(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(UtilHelper.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.o = TiebaApplication.g().as();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.a(this.b);
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.f2077a = aoVar;
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
        if (this.f2077a == null || this.f2077a.d() == null) {
            return 0;
        }
        return this.f2077a.d().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f2077a == null || this.f2077a.d() == null || i < 0 || i >= this.f2077a.d().size()) {
            return null;
        }
        return this.f2077a.d().get(i);
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
        this.o = TiebaApplication.g().as();
        if (view == null) {
            view = h();
        }
        bq bqVar = (bq) view.getTag();
        com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) getItem(i);
        NewPbActivity newPbActivity = (NewPbActivity) this.b;
        newPbActivity.m().a(this.o == 1);
        newPbActivity.m().a(view);
        if (asVar != null) {
            a(bqVar, asVar, view);
        }
        return view;
    }

    private View h() {
        bq bqVar = new bq(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, (ViewGroup) null);
        bqVar.f2078a = (HeadImageView) inflate.findViewById(R.id.photo);
        bqVar.b = (TextView) inflate.findViewById(R.id.user_name);
        bqVar.c = (TextView) inflate.findViewById(R.id.user_rank);
        bqVar.f = (Button) inflate.findViewById(R.id.reply);
        bqVar.g = (Button) inflate.findViewById(R.id.manage_btn);
        bqVar.h = (TbRichTextView) inflate.findViewById(R.id.richText);
        bqVar.g.setOnClickListener(this.m);
        bqVar.d = (TextView) inflate.findViewById(R.id.floor);
        bqVar.e = (TextView) inflate.findViewById(R.id.time);
        bqVar.i = (LinearLayout) inflate.findViewById(R.id.pb_post_header_layout);
        bqVar.j = (LinearLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        bqVar.b.setOnClickListener(this.h);
        bqVar.f.setOnClickListener(this.i);
        bqVar.f2078a.setOnClickListener(this.h);
        bqVar.f2078a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo_bg)));
        bqVar.i.setOnLongClickListener(this.l);
        if (this.n < 0) {
            this.n = (((UtilHelper.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bqVar.h.getPaddingLeft()) - bqVar.h.getPaddingRight();
        }
        this.n = this.e > this.n ? this.n : this.e;
        bqVar.h.setMaxImageWidth(this.n);
        bqVar.h.setMaxImageHeight((int) (this.n * 1.618f));
        bqVar.h.setTextSize(com.baidu.tieba.data.h.o());
        if (!this.d) {
            bqVar.f2078a.setVisibility(8);
        }
        bqVar.h.setDisplayImage(this.c);
        bqVar.h.setOnImageClickListener(this.j);
        inflate.setTag(bqVar);
        return inflate;
    }

    private void a(bq bqVar, com.baidu.tieba.data.as asVar, View view) {
        boolean z;
        boolean z2;
        int i;
        SparseArray sparseArray;
        boolean z3;
        if (bqVar != null && asVar != null) {
            bqVar.f2078a.setTag(null);
            bqVar.f2078a.setUserId(null);
            bqVar.b.setText((CharSequence) null);
            bqVar.c.setText((CharSequence) null);
            bqVar.c.setBackgroundDrawable(null);
            bqVar.j.setVisibility(0);
            bqVar.d.setText((CharSequence) null);
            bqVar.f.setVisibility(0);
            bqVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            SparseArray sparseArray2 = (SparseArray) bqVar.i.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bqVar.i.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_clip_board, asVar);
            sparseArray2.put(R.id.tag_is_subpb, false);
            boolean z4 = false;
            String h = this.f2077a.h();
            if (this.f2077a.g() && h != null && h.equals(asVar.d())) {
                z4 = true;
            }
            Resources resources = this.b.getResources();
            bqVar.e.setText(com.baidu.tieba.util.bc.h(new Date(asVar.f())));
            if (asVar.e() == 1) {
                bqVar.f.setVisibility(8);
            }
            if (this.f != null && this.f.equals(asVar.g().getId())) {
                if (this.o == 1) {
                    if (z4) {
                        bqVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        bqVar.d.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z4) {
                    bqVar.d.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    bqVar.d.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (this.o == 1) {
                    bqVar.d.setBackgroundResource(R.drawable.pb_list_floor_number_1);
                    if (z4) {
                        bqVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        bqVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    bqVar.d.setBackgroundResource(R.drawable.pb_list_floor_number);
                    if (z4) {
                        bqVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        bqVar.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                bqVar.d.setText(String.valueOf(asVar.e()) + resources.getString(R.string.floor));
            }
            if (TiebaApplication.g().as() == 1) {
                bqVar.h.setVideoImageId(R.drawable.pic_video_1);
                bqVar.h.setTextColor(this.b.getResources().getColor(R.color.gray_night_1));
                com.baidu.tieba.util.bb.e((View) bqVar.f, (int) R.drawable.common_image_btn_selector_1);
                bqVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
                bqVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
            } else {
                bqVar.h.setVideoImageId(R.drawable.pic_video);
                bqVar.h.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                com.baidu.tieba.util.bb.e((View) bqVar.f, (int) R.drawable.common_image_btn_selector);
                bqVar.f.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
                bqVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
            }
            SparseArray sparseArray3 = (SparseArray) bqVar.f.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                bqVar.f.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, asVar);
            sparseArray3.put(R.id.tag_load_sub_view, view);
            if (asVar.j() > 0 && asVar.a() != null) {
                if (this.k == null) {
                    this.k = new br(this.b, this.h);
                    this.k.a(this.m);
                    boolean z5 = false;
                    String id = this.f2077a.c().g().getId();
                    if (id != null && id.equals(TiebaApplication.C())) {
                        z5 = true;
                    }
                    this.k.a(this.f2077a.j(), z5);
                    this.k.a(this.d);
                }
                bqVar.j.removeAllViews();
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
                        if (a2.get(i3) != null && a2.get(i3).g() != null) {
                            sparseArray.put(R.id.tag_photo_username, a2.get(i3).g().getName());
                            sparseArray.put(R.id.tag_clip_board, a2.get(i3));
                        }
                        bs bsVar = (bs) sparseArray.get(R.id.tag_holder);
                        br brVar = this.k;
                        com.baidu.tieba.data.as asVar2 = a2.get(i3);
                        if (asVar.j() > a2.size()) {
                            z3 = true;
                        } else {
                            z3 = a2.size() - i3 > 1;
                        }
                        brVar.a(bsVar, asVar2, z3);
                        bqVar.j.addView(b);
                        i2 = i3 + 1;
                    }
                }
                if (a2 != null && asVar.j() > a2.size()) {
                    View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
                    bqVar.j.addView(inflate);
                    a(this.b, (TextView) inflate.findViewById(R.id.sub_pb_more_text), asVar.j() - a2.size());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                    if (TiebaApplication.g().as() == 1) {
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
                bqVar.j.setVisibility(8);
                if (TiebaApplication.g().as() == 1) {
                    bqVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    bqVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
            }
            String portrait = asVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.e c = this.g.c(portrait);
            if (asVar.g() != null) {
                bqVar.b.setText(asVar.g().getName_show());
                int level_id = asVar.g().getLevel_id();
                int isLike = asVar.g().getIsLike();
                if (level_id != 0 && isLike != 0) {
                    bqVar.c.setText(String.valueOf(level_id));
                    bqVar.c.setBackgroundResource(com.baidu.tieba.util.e.b(level_id));
                }
            }
            bqVar.f2078a.setUserId(asVar.g().getId());
            bqVar.f2078a.setImageBitmap(null);
            bqVar.b.setTag(asVar.g().getId());
            if (c != null) {
                c.a(bqVar.f2078a);
            } else {
                bqVar.f2078a.setTag(portrait);
                bqVar.f2078a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo)));
            }
            if (this.o == 1) {
                bqVar.h.setDefaultImageId(R.drawable.pic_image_h_not_1);
            } else {
                bqVar.h.setDefaultImageId(R.drawable.pic_image_h_not);
            }
            bqVar.h.setVoiceViewRes(R.layout.voice_play_btn);
            bqVar.h.setText(asVar.h());
            bqVar.h.a();
            boolean z6 = false;
            if (this.f2077a.j() != 0) {
                boolean z7 = true;
                z2 = true;
                String id2 = asVar.g().getId();
                if (id2 != null && id2.equals(TiebaApplication.C())) {
                    z7 = false;
                }
                z = (id2 == null || id2.equals(SocialConstants.FALSE) || id2.length() == 0) ? false : false;
            } else {
                String id3 = this.f2077a.c().g().getId();
                if (id3 != null && id3.equals(TiebaApplication.C())) {
                    z = false;
                    z2 = true;
                } else {
                    String id4 = asVar.g().getId();
                    if (id4 == null || !id4.equals(TiebaApplication.C())) {
                        z = false;
                        z2 = false;
                    } else {
                        z = false;
                        z2 = true;
                        z6 = true;
                    }
                }
            }
            if (TiebaApplication.g().as() == 1) {
                com.baidu.tieba.util.bb.e((View) bqVar.g, (int) R.drawable.common_image_btn_selector_1);
                bqVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
            } else {
                com.baidu.tieba.util.bb.e((View) bqVar.g, (int) R.drawable.common_image_btn_selector);
                bqVar.g.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
            }
            if (z2 && z) {
                bqVar.g.setVisibility(0);
                bqVar.g.setText(R.string.manage);
                if (TiebaApplication.g().as() == 1) {
                    bqVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                } else {
                    bqVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                }
            } else if (z2) {
                bqVar.g.setVisibility(0);
                bqVar.g.setText(R.string.delete);
                if (TiebaApplication.g().as() == 1) {
                    bqVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector_1, 0, 0, 0);
                } else {
                    bqVar.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_dl_selector, 0, 0, 0);
                }
            } else {
                bqVar.g.setVisibility(8);
            }
            if (asVar.e() != 1) {
                i = 1;
            } else {
                i = 0;
            }
            SparseArray sparseArray7 = (SparseArray) bqVar.g.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                bqVar.g.setTag(sparseArray7);
            }
            if (bqVar.g.getVisibility() == 0) {
                sparseArray7.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f2077a.j()));
            }
            if (z2) {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                sparseArray7.put(R.id.tag_del_post_type, Integer.valueOf(i));
                sparseArray7.put(R.id.tag_del_post_id, asVar.d());
            } else {
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                sparseArray7.put(R.id.tag_del_post_type, 0);
                sparseArray7.put(R.id.tag_del_post_id, "");
            }
            if (z) {
                sparseArray7.put(R.id.tag_forbid_user_name, asVar.g().getName());
            } else {
                sparseArray7.put(R.id.tag_forbid_user_name, "");
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
        if (TiebaApplication.g().as() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(-12687203), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.pb_load_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-12810784), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.pb_load_more_text));
        }
        textView.setText(spannableString);
    }
}
