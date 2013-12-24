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
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bx extends BaseAdapter {
    private Context b;
    private final boolean t;
    private com.baidu.tieba.data.an a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.i g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private com.baidu.tbadk.widget.richText.o k = null;
    private ca l = null;
    private View.OnLongClickListener m = null;
    private com.baidu.tieba.c.a n = null;
    private View.OnClickListener o = null;
    private int p = -1;
    private int q = 0;
    private LinkedList<IconData> r = null;
    private boolean s = false;

    public bx(Context context) {
        boolean z = true;
        this.b = null;
        this.t = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(com.baidu.adp.lib.h.g.a(this.b, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        g();
        this.q = TiebaApplication.h().an();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.i(this.b);
        this.g.f("pb");
        this.g.a(this.e, (int) (this.e * 1.62f));
    }

    public void a(com.baidu.tieba.data.an anVar) {
        this.a = anVar;
        if (anVar.d() != null && anVar.d().j() != null) {
            this.f = anVar.d().j().getId();
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
        if (this.a == null || this.a.e() == null) {
            return 0;
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
        this.q = TiebaApplication.h().an();
        if (view == null) {
            view = a(viewGroup);
        }
        bz bzVar = (bz) view.getTag();
        com.baidu.tieba.data.ar arVar = (com.baidu.tieba.data.ar) getItem(i);
        NewPbActivity newPbActivity = (NewPbActivity) this.b;
        newPbActivity.getLayoutMode().a(this.q == 1);
        newPbActivity.getLayoutMode().a(view);
        if (arVar != null) {
            a(bzVar, arVar, view);
        }
        if (!this.s && this.t && bzVar != null && bzVar.j.a() && (c = newPbActivity.c()) != null) {
            this.s = true;
            CompatibleUtile.getInstance().closeViewGpu(c);
        }
        return view;
    }

    private View a(ViewGroup viewGroup) {
        bz bzVar = new bz(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, viewGroup, false);
        bzVar.a = inflate.findViewById(R.id.sub_pb_more);
        bzVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        bzVar.b.setIsRound(true);
        bzVar.c = (TextView) inflate.findViewById(R.id.user_name);
        bzVar.d = (TextView) inflate.findViewById(R.id.user_rank);
        bzVar.h = (Button) inflate.findViewById(R.id.reply);
        bzVar.i = (Button) inflate.findViewById(R.id.manage_btn);
        bzVar.j = (TbRichTextView) inflate.findViewById(R.id.richText);
        bzVar.i.setOnClickListener(this.o);
        bzVar.m = (LinearLayout) inflate.findViewById(R.id.bottom_container);
        bzVar.e = (TextView) inflate.findViewById(R.id.floor);
        bzVar.g = (ImageView) inflate.findViewById(R.id.floor_owner);
        bzVar.f = (TextView) inflate.findViewById(R.id.time);
        bzVar.k = (ColumnLayout) inflate.findViewById(R.id.pb_post_header_layout);
        bzVar.l = (SubPbLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        bzVar.c.setOnClickListener(this.h);
        bzVar.h.setOnClickListener(this.j);
        bzVar.b.setOnClickListener(this.h);
        bzVar.e.setOnClickListener(this.j);
        bzVar.k.setOnLongClickListener(this.m);
        bzVar.j.setOnLongClickListener(this.m);
        bzVar.m.setOnLongClickListener(this.m);
        if (this.p < 0) {
            this.p = (((com.baidu.adp.lib.h.g.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - bzVar.j.getPaddingLeft()) - bzVar.j.getPaddingRight();
        }
        bzVar.k.setOnTouchListener(this.n);
        bzVar.j.setOnTouchListener(this.n);
        bzVar.m.setOnTouchListener(this.n);
        this.p = this.e > this.p ? this.p : this.e;
        bzVar.j.setMaxImageWidth(this.p);
        bzVar.j.setMaxImageHeight((int) (this.p * 1.618f));
        bzVar.j.setTextSize(com.baidu.tieba.data.h.q());
        if (!this.d) {
            bzVar.b.setVisibility(8);
        }
        bzVar.j.a(this.c, false);
        bzVar.j.setVoiceViewRes(R.layout.voice_play_btn);
        bzVar.j.setOnImageClickListener(this.k);
        bzVar.n = (UserIconBox) inflate.findViewById(R.id.user_icon_box);
        bzVar.n.setOnClickListener(this.i);
        inflate.setTag(bzVar);
        return inflate;
    }

    private void a(bz bzVar, com.baidu.tieba.data.ar arVar, View view) {
        boolean z;
        boolean z2;
        int i;
        if (bzVar != null && arVar != null) {
            bzVar.b.setTag(null);
            bzVar.b.setUserId(null);
            bzVar.c.setText((CharSequence) null);
            bzVar.d.setText((CharSequence) null);
            bzVar.d.setBackgroundDrawable(null);
            bzVar.l.setVisibility(0);
            bzVar.e.setText((CharSequence) null);
            bzVar.h.setVisibility(0);
            bzVar.g.setVisibility(8);
            bzVar.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            SparseArray sparseArray = (SparseArray) bzVar.k.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                bzVar.k.setTag(sparseArray);
                bzVar.j.setTag(sparseArray);
                bzVar.m.setTag(sparseArray);
                bzVar.e.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_clip_board, arVar);
            sparseArray.put(R.id.tag_is_subpb, false);
            boolean z3 = false;
            String j = this.a.j();
            if (this.a.i() && j != null && j.equals(arVar.d())) {
                z3 = true;
            }
            Resources resources = this.b.getResources();
            bzVar.f.setText(com.baidu.tieba.util.bc.b(arVar.f()));
            if (arVar.e() == 1) {
                bzVar.h.setVisibility(8);
            }
            if (this.f != null && this.f.equals(arVar.g().getId())) {
                bzVar.g.setVisibility(0);
                if (this.q == 1) {
                    bzVar.g.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    bzVar.g.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (this.q == 1) {
                bzVar.e.setBackgroundResource(R.drawable.pb_list_floor_number_1);
                if (z3) {
                    bzVar.e.setBackgroundResource(R.drawable.icon_collect_s_1);
                } else {
                    bzVar.e.setBackgroundResource(R.drawable.icon_collect_n_1);
                }
            } else {
                bzVar.e.setBackgroundResource(R.drawable.pb_list_floor_number);
                if (z3) {
                    bzVar.e.setBackgroundResource(R.drawable.icon_collect_s);
                } else {
                    bzVar.e.setBackgroundResource(R.drawable.icon_collect_n);
                }
            }
            bzVar.e.setText(String.valueOf(arVar.e()) + resources.getString(R.string.floor));
            if (TiebaApplication.h().an() == 1) {
                bzVar.a.setBackgroundResource(R.drawable.bg_floor_new_middle_1);
                bzVar.j.setVideoImageId(R.drawable.pic_video_1);
                bzVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content_1));
                bzVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                bzVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n_1, 0, 0, 0);
                bzVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                bzVar.a.setBackgroundResource(R.drawable.bg_floor_new_middle);
                bzVar.j.setVideoImageId(R.drawable.pic_video);
                bzVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content));
                bzVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
                bzVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n, 0, 0, 0);
                bzVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            SparseArray sparseArray2 = (SparseArray) bzVar.h.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bzVar.h.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, arVar);
            sparseArray2.put(R.id.tag_load_sub_view, view);
            if (arVar.j() > 0 && arVar.a() != null) {
                if (this.l == null) {
                    this.l = new ca(this.b, this.h);
                    this.l.a(this.o);
                    boolean z4 = false;
                    String id = this.a.d().j().getId();
                    if (id != null && id.equals(TiebaApplication.B())) {
                        z4 = true;
                    }
                    this.l.a(this.a.l(), z4);
                    this.l.a(this.d);
                }
                bzVar.l.a(arVar, view);
                bzVar.l.setChildOnClickListener(this.j);
                bzVar.l.setChildOnLongClickListener(this.m);
                bzVar.l.setChildOnTouchListener(this.n);
                bzVar.l.setSubPbAdapter(this.l);
            } else {
                bzVar.l.setVisibility(8);
            }
            String portrait = arVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.e c = this.g.c(portrait);
            if (arVar.g() != null) {
                bzVar.c.setText(arVar.g().getName_show());
                int level_id = arVar.g().getLevel_id();
                int isLike = arVar.g().getIsLike();
                int is_bawu = arVar.g().getIs_bawu();
                String bawu_type = arVar.g().getBawu_type();
                int i2 = 6;
                if (level_id != 0 && isLike != 0) {
                    bzVar.d.setVisibility(0);
                    bzVar.d.setText(String.valueOf(level_id));
                    bzVar.d.setBackgroundResource(com.baidu.tieba.util.m.b(level_id));
                    i2 = 5;
                    bzVar.d.setOnClickListener(null);
                } else {
                    bzVar.d.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        bzVar.d.setText((CharSequence) null);
                        bzVar.d.setBackgroundResource(this.q == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        bzVar.d.setOnClickListener(this.i);
                    } else if (bawu_type.equals("assist")) {
                        bzVar.d.setText((CharSequence) null);
                        bzVar.d.setBackgroundResource(this.q == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        bzVar.d.setOnClickListener(this.i);
                    }
                }
                this.r = arVar.g().getIconInfo();
                if (bzVar.n != null) {
                    bzVar.n.setOnClickListener(this.i);
                    bzVar.n.a(this.r, i2, this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
            }
            bzVar.b.setUserId(arVar.g().getId());
            bzVar.b.setImageBitmap(null);
            bzVar.c.setTag(arVar.g().getId());
            if (c != null) {
                c.a(bzVar.b);
            } else {
                bzVar.b.setTag(portrait);
                bzVar.b.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
            }
            if (this.q == 1) {
                bzVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                if (this.c) {
                    bzVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                } else {
                    bzVar.j.setDefaultImageId(R.drawable.icon_click_1);
                }
            } else {
                bzVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
                if (this.c) {
                    bzVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d);
                } else {
                    bzVar.j.setDefaultImageId(R.drawable.icon_click);
                }
            }
            if (this.s || !this.t) {
                bzVar.j.a(arVar.h(), false);
            } else {
                bzVar.j.a(arVar.h(), true);
            }
            boolean z5 = false;
            if (this.a.l() != 0) {
                boolean z6 = true;
                z2 = true;
                String id2 = arVar.g().getId();
                if (id2 != null && id2.equals(TiebaApplication.B())) {
                    z6 = false;
                }
                z = (id2 == null || id2.equals(SocialConstants.FALSE) || id2.length() == 0) ? false : false;
            } else {
                String id3 = this.a.d().j().getId();
                if (id3 != null && id3.equals(TiebaApplication.B())) {
                    z = false;
                    z2 = true;
                } else {
                    String id4 = arVar.g().getId();
                    if (id4 == null || !id4.equals(TiebaApplication.B())) {
                        z = false;
                        z2 = false;
                    } else {
                        z = false;
                        z2 = true;
                        z5 = true;
                    }
                }
            }
            if (TiebaApplication.h().an() == 1) {
                bzVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                bzVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            if (z2 && z) {
                bzVar.i.setVisibility(0);
                bzVar.i.setText(R.string.manage);
                if (TiebaApplication.h().an() == 1) {
                    bzVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
                } else {
                    bzVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
                }
            } else if (z2) {
                bzVar.i.setVisibility(0);
                bzVar.i.setText(R.string.delete);
                if (TiebaApplication.h().an() == 1) {
                    bzVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n_1, 0, 0, 0);
                } else {
                    bzVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n, 0, 0, 0);
                }
            } else {
                bzVar.i.setVisibility(8);
            }
            if (arVar.e() != 1) {
                i = 1;
            } else {
                i = 0;
            }
            SparseArray sparseArray3 = (SparseArray) bzVar.i.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                bzVar.i.setTag(sparseArray3);
            }
            if (bzVar.i.getVisibility() == 0) {
                sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.a.l()));
            }
            if (z2) {
                sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                sparseArray3.put(R.id.tag_del_post_type, Integer.valueOf(i));
                sparseArray3.put(R.id.tag_del_post_id, arVar.d());
            } else {
                sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                sparseArray3.put(R.id.tag_del_post_type, 0);
                sparseArray3.put(R.id.tag_del_post_id, "");
            }
            if (z) {
                sparseArray3.put(R.id.tag_forbid_user_name, arVar.g().getName());
            } else {
                sparseArray3.put(R.id.tag_forbid_user_name, "");
            }
        }
    }

    public void a(com.baidu.tbadk.widget.richText.o oVar) {
        this.k = oVar;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TiebaApplication.h().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.h().an() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }
}
