package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
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
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bv extends BaseAdapter {
    private Context b;
    private final boolean t;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.ao f2104a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.i g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private com.baidu.tbadk.widget.richText.n k = null;
    private by l = null;
    private View.OnLongClickListener m = null;
    private com.baidu.tieba.c.a n = null;
    private View.OnClickListener o = null;
    private int p = -1;
    private int q = 0;
    private LinkedList<com.baidu.tieba.data.aa> r = null;
    private boolean s = false;

    public bv(Context context) {
        boolean z = true;
        this.b = null;
        this.t = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(UtilHelper.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.q = TiebaApplication.g().ap();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.i(this.b);
        this.g.f("pb");
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.f2104a = aoVar;
        if (aoVar.d() != null && aoVar.d().j() != null) {
            this.f = aoVar.d().j().getId();
        }
    }

    public com.baidu.tieba.util.i a() {
        return this.g;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.m = onLongClickListener;
    }

    public View.OnLongClickListener b() {
        return this.m;
    }

    public void d(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void a(com.baidu.tieba.c.a aVar) {
        this.n = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f2104a == null || this.f2104a.e() == null) {
            return 0;
        }
        return this.f2104a.e().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f2104a == null || this.f2104a.e() == null || i < 0 || i >= this.f2104a.e().size()) {
            return null;
        }
        return this.f2104a.e().get(i);
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
        return this.p;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListView c;
        this.q = TiebaApplication.g().ap();
        if (view == null) {
            view = a(viewGroup);
        }
        bx bxVar = (bx) view.getTag();
        com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) getItem(i);
        NewPbActivity newPbActivity = (NewPbActivity) this.b;
        newPbActivity.getLayoutMode().a(this.q == 1);
        newPbActivity.getLayoutMode().a(view);
        if (asVar != null) {
            a(bxVar, asVar, view);
        }
        if (!this.s && this.t && bxVar != null && bxVar.j.a() && (c = newPbActivity.c()) != null) {
            this.s = true;
            CompatibleUtile.getInstance().closeViewGpu(c);
        }
        return view;
    }

    private View a(ViewGroup viewGroup) {
        bx bxVar = new bx(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, viewGroup, false);
        bxVar.f2105a = inflate.findViewById(R.id.sub_pb_more);
        bxVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        bxVar.b.setIsRound(true);
        bxVar.c = (TextView) inflate.findViewById(R.id.user_name);
        bxVar.d = (TextView) inflate.findViewById(R.id.user_rank);
        bxVar.h = (Button) inflate.findViewById(R.id.reply);
        bxVar.i = (Button) inflate.findViewById(R.id.manage_btn);
        bxVar.j = (TbRichTextView) inflate.findViewById(R.id.richText);
        bxVar.i.setOnClickListener(this.o);
        bxVar.m = (LinearLayout) inflate.findViewById(R.id.bottom_container);
        bxVar.e = (TextView) inflate.findViewById(R.id.floor);
        bxVar.g = (ImageView) inflate.findViewById(R.id.floor_owner);
        bxVar.f = (TextView) inflate.findViewById(R.id.time);
        bxVar.k = (ColumnLayout) inflate.findViewById(R.id.pb_post_header_layout);
        bxVar.l = (SubPbLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        bxVar.c.setOnClickListener(this.h);
        bxVar.h.setOnClickListener(this.j);
        bxVar.b.setOnClickListener(this.h);
        bxVar.e.setOnClickListener(this.j);
        bxVar.k.setOnLongClickListener(this.m);
        bxVar.j.setOnLongClickListener(this.m);
        bxVar.m.setOnLongClickListener(this.m);
        if (this.p < 0) {
            this.p = (((UtilHelper.a(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bxVar.j.getPaddingLeft()) - bxVar.j.getPaddingRight();
        }
        bxVar.k.setOnTouchListener(this.n);
        bxVar.j.setOnTouchListener(this.n);
        bxVar.m.setOnTouchListener(this.n);
        this.p = this.e > this.p ? this.p : this.e;
        bxVar.j.setMaxImageWidth(this.p);
        bxVar.j.setMaxImageHeight((int) (this.p * 1.618f));
        bxVar.j.setTextSize(com.baidu.tieba.data.h.o());
        if (!this.d) {
            bxVar.b.setVisibility(8);
        }
        bxVar.j.a(this.c, false);
        bxVar.j.setVoiceViewRes(R.layout.voice_play_btn);
        bxVar.j.setOnImageClickListener(this.k);
        bxVar.n = (UserIconBox) inflate.findViewById(R.id.user_icon_box);
        bxVar.n.setOnClickListener(this.i);
        inflate.setTag(bxVar);
        return inflate;
    }

    private void a(bx bxVar, com.baidu.tieba.data.as asVar, View view) {
        boolean z;
        boolean z2;
        int i;
        if (bxVar != null && asVar != null) {
            bxVar.b.setTag(null);
            bxVar.b.setUserId(null);
            bxVar.c.setText((CharSequence) null);
            bxVar.d.setText((CharSequence) null);
            bxVar.d.setBackgroundDrawable(null);
            bxVar.l.setVisibility(0);
            bxVar.e.setText((CharSequence) null);
            bxVar.h.setVisibility(0);
            bxVar.g.setVisibility(8);
            bxVar.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            SparseArray sparseArray = (SparseArray) bxVar.k.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                bxVar.k.setTag(sparseArray);
                bxVar.j.setTag(sparseArray);
                bxVar.m.setTag(sparseArray);
                bxVar.e.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_clip_board, asVar);
            sparseArray.put(R.id.tag_is_subpb, false);
            boolean z3 = false;
            String j = this.f2104a.j();
            if (this.f2104a.i() && j != null && j.equals(asVar.d())) {
                z3 = true;
            }
            Resources resources = this.b.getResources();
            bxVar.f.setText(com.baidu.tieba.util.be.b(asVar.f()));
            if (asVar.e() == 1) {
                bxVar.h.setVisibility(8);
            }
            if (this.f != null && this.f.equals(asVar.g().getId())) {
                bxVar.g.setVisibility(0);
                if (this.q == 1) {
                    bxVar.g.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    bxVar.g.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (this.q == 1) {
                bxVar.e.setBackgroundResource(R.drawable.pb_list_floor_number_1);
                if (z3) {
                    bxVar.e.setBackgroundResource(R.drawable.icon_collect_s_1);
                } else {
                    bxVar.e.setBackgroundResource(R.drawable.icon_collect_n_1);
                }
            } else {
                bxVar.e.setBackgroundResource(R.drawable.pb_list_floor_number);
                if (z3) {
                    bxVar.e.setBackgroundResource(R.drawable.icon_collect_s);
                } else {
                    bxVar.e.setBackgroundResource(R.drawable.icon_collect_n);
                }
            }
            bxVar.e.setText(String.valueOf(asVar.e()) + resources.getString(R.string.floor));
            if (TiebaApplication.g().ap() == 1) {
                bxVar.f2105a.setBackgroundResource(R.drawable.bg_floor_new_middle_1);
                bxVar.j.setVideoImageId(R.drawable.pic_video_1);
                bxVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content_1));
                bxVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                bxVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n_1, 0, 0, 0);
                bxVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                bxVar.f2105a.setBackgroundResource(R.drawable.bg_floor_new_middle);
                bxVar.j.setVideoImageId(R.drawable.pic_video);
                bxVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content));
                bxVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
                bxVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n, 0, 0, 0);
                bxVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            SparseArray sparseArray2 = (SparseArray) bxVar.h.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bxVar.h.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, asVar);
            sparseArray2.put(R.id.tag_load_sub_view, view);
            if (asVar.j() > 0 && asVar.a() != null) {
                if (this.l == null) {
                    this.l = new by(this.b, this.h);
                    this.l.a(this.o);
                    boolean z4 = false;
                    String id = this.f2104a.d().j().getId();
                    if (id != null && id.equals(TiebaApplication.A())) {
                        z4 = true;
                    }
                    this.l.a(this.f2104a.l(), z4);
                    this.l.a(this.d);
                }
                bxVar.l.a(asVar, view);
                bxVar.l.setChildOnClickListener(this.j);
                bxVar.l.setChildOnLongClickListener(this.m);
                bxVar.l.setChildOnTouchListener(this.n);
                bxVar.l.setSubPbAdapter(this.l);
            } else {
                bxVar.l.setVisibility(8);
            }
            String portrait = asVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.e c = this.g.c(portrait);
            if (asVar.g() != null) {
                bxVar.c.setText(asVar.g().getName_show());
                int level_id = asVar.g().getLevel_id();
                int isLike = asVar.g().getIsLike();
                int is_bawu = asVar.g().getIs_bawu();
                String bawu_type = asVar.g().getBawu_type();
                int i2 = 6;
                if (level_id != 0 && isLike != 0) {
                    bxVar.d.setVisibility(0);
                    bxVar.d.setText(String.valueOf(level_id));
                    bxVar.d.setBackgroundResource(com.baidu.tieba.util.m.b(level_id));
                    i2 = 5;
                    bxVar.d.setOnClickListener(null);
                } else {
                    bxVar.d.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        bxVar.d.setText((CharSequence) null);
                        bxVar.d.setBackgroundResource(this.q == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        bxVar.d.setOnClickListener(this.i);
                    } else if (bawu_type.equals("assist")) {
                        bxVar.d.setText((CharSequence) null);
                        bxVar.d.setBackgroundResource(this.q == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        bxVar.d.setOnClickListener(this.i);
                    }
                }
                this.r = asVar.g().getIconInfo();
                if (bxVar.n != null) {
                    bxVar.n.setOnClickListener(this.i);
                    bxVar.n.a(this.r, i2, this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
            }
            bxVar.b.setUserId(asVar.g().getId());
            bxVar.b.setImageBitmap(null);
            bxVar.c.setTag(asVar.g().getId());
            if (c != null) {
                c.a(bxVar.b);
            } else {
                bxVar.b.setTag(portrait);
                bxVar.b.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
            }
            if (this.q == 1) {
                bxVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                if (this.c) {
                    bxVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                } else {
                    bxVar.j.setDefaultImageId(R.drawable.icon_click_1);
                }
            } else {
                bxVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
                if (this.c) {
                    bxVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d);
                } else {
                    bxVar.j.setDefaultImageId(R.drawable.icon_click);
                }
            }
            if (this.s || !this.t) {
                bxVar.j.a(asVar.h(), false);
            } else {
                bxVar.j.a(asVar.h(), true);
            }
            boolean z5 = false;
            if (this.f2104a.l() != 0) {
                boolean z6 = true;
                z2 = true;
                String id2 = asVar.g().getId();
                if (id2 != null && id2.equals(TiebaApplication.A())) {
                    z6 = false;
                }
                z = (id2 == null || id2.equals(SocialConstants.FALSE) || id2.length() == 0) ? false : false;
            } else {
                String id3 = this.f2104a.d().j().getId();
                if (id3 != null && id3.equals(TiebaApplication.A())) {
                    z = false;
                    z2 = true;
                } else {
                    String id4 = asVar.g().getId();
                    if (id4 == null || !id4.equals(TiebaApplication.A())) {
                        z = false;
                        z2 = false;
                    } else {
                        z = false;
                        z2 = true;
                        z5 = true;
                    }
                }
            }
            if (TiebaApplication.g().ap() == 1) {
                bxVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                bxVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            if (z2 && z) {
                bxVar.i.setVisibility(0);
                bxVar.i.setText(R.string.manage);
                if (TiebaApplication.g().ap() == 1) {
                    bxVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
                } else {
                    bxVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
                }
            } else if (z2) {
                bxVar.i.setVisibility(0);
                bxVar.i.setText(R.string.delete);
                if (TiebaApplication.g().ap() == 1) {
                    bxVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n_1, 0, 0, 0);
                } else {
                    bxVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n, 0, 0, 0);
                }
            } else {
                bxVar.i.setVisibility(8);
            }
            if (asVar.e() != 1) {
                i = 1;
            } else {
                i = 0;
            }
            SparseArray sparseArray3 = (SparseArray) bxVar.i.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                bxVar.i.setTag(sparseArray3);
            }
            if (bxVar.i.getVisibility() == 0) {
                sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f2104a.l()));
            }
            if (z2) {
                sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                sparseArray3.put(R.id.tag_del_post_type, Integer.valueOf(i));
                sparseArray3.put(R.id.tag_del_post_id, asVar.d());
            } else {
                sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                sparseArray3.put(R.id.tag_del_post_type, 0);
                sparseArray3.put(R.id.tag_del_post_id, "");
            }
            if (z) {
                sparseArray3.put(R.id.tag_forbid_user_name, asVar.g().getName());
            } else {
                sparseArray3.put(R.id.tag_forbid_user_name, "");
            }
        }
    }

    public void a(com.baidu.tbadk.widget.richText.n nVar) {
        this.k = nVar;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TiebaApplication.g().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.g().ap() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }
}
