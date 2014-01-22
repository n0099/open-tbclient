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
public class bz extends BaseAdapter {
    private Context b;
    private final boolean w;
    private com.baidu.tieba.data.ao a = null;
    private boolean c = true;
    private boolean d = true;
    private int e = 0;
    private String f = null;
    private com.baidu.tieba.util.i g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private View.OnClickListener k = null;
    private com.baidu.tbadk.widget.richText.r l = null;
    private com.baidu.tbadk.widget.richText.q m = null;
    private cc n = null;
    private View.OnLongClickListener o = null;
    private com.baidu.tieba.d.a p = null;
    private View.OnClickListener q = null;
    private int r = -1;
    private int s = 0;
    private LinkedList<IconData> t = null;
    private LinkedList<IconData> u = null;
    private boolean v = false;

    public bz(Context context) {
        boolean z = true;
        this.b = null;
        this.w = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(com.baidu.adp.lib.g.g.a(this.b, 427.0f), 640);
        g();
        this.s = TiebaApplication.h().al();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.i(this.b);
        this.g.f("pb");
        this.g.a(this.e, (int) (this.e * 1.6f));
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.a = aoVar;
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

    public void d(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.o = onLongClickListener;
    }

    public View.OnLongClickListener b() {
        return this.o;
    }

    public void e(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void a(com.baidu.tieba.d.a aVar) {
        this.p = aVar;
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
        return this.r;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListView c;
        this.s = TiebaApplication.h().al();
        if (view == null) {
            view = a(viewGroup);
        }
        cb cbVar = (cb) view.getTag();
        com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) getItem(i);
        NewPbActivity newPbActivity = (NewPbActivity) this.b;
        newPbActivity.getLayoutMode().a(this.s == 1);
        newPbActivity.getLayoutMode().a(view);
        if (asVar != null) {
            a(cbVar, asVar, view);
        }
        if (!this.v && this.w && cbVar != null && cbVar.j.a() && (c = newPbActivity.c()) != null) {
            this.v = true;
            CompatibleUtile.getInstance().closeViewGpu(c);
        }
        return view;
    }

    private View a(ViewGroup viewGroup) {
        cb cbVar = new cb(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, viewGroup, false);
        cbVar.a = inflate.findViewById(R.id.sub_pb_more);
        cbVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        cbVar.b.setIsRound(true);
        cbVar.c = (TextView) inflate.findViewById(R.id.user_name);
        cbVar.d = (TextView) inflate.findViewById(R.id.user_rank);
        cbVar.h = (Button) inflate.findViewById(R.id.reply);
        cbVar.i = (Button) inflate.findViewById(R.id.manage_btn);
        cbVar.j = (TbRichTextView) inflate.findViewById(R.id.richText);
        cbVar.i.setOnClickListener(this.q);
        cbVar.m = (LinearLayout) inflate.findViewById(R.id.bottom_container);
        cbVar.e = (TextView) inflate.findViewById(R.id.floor);
        cbVar.g = (ImageView) inflate.findViewById(R.id.floor_owner);
        cbVar.f = (TextView) inflate.findViewById(R.id.time);
        cbVar.k = (ColumnLayout) inflate.findViewById(R.id.pb_post_header_layout);
        cbVar.l = (SubPbLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        cbVar.c.setOnClickListener(this.h);
        cbVar.h.setOnClickListener(this.k);
        cbVar.b.setOnClickListener(this.h);
        cbVar.e.setOnClickListener(this.k);
        cbVar.k.setOnLongClickListener(this.o);
        cbVar.j.setOnLongClickListener(this.o);
        cbVar.m.setOnLongClickListener(this.o);
        if (this.r < 0) {
            this.r = (((com.baidu.adp.lib.g.g.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - cbVar.j.getPaddingLeft()) - cbVar.j.getPaddingRight();
        }
        cbVar.k.setOnTouchListener(this.p);
        cbVar.j.setOnTouchListener(this.p);
        cbVar.m.setOnTouchListener(this.p);
        this.r = this.e > this.r ? this.r : this.e;
        cbVar.j.setMaxImageWidth(this.r);
        cbVar.j.setMaxImageHeight((int) (this.r * 1.618f));
        cbVar.j.setTextSize(com.baidu.tieba.data.h.q());
        if (!this.d) {
            cbVar.b.setVisibility(8);
        }
        cbVar.j.a(this.c, false);
        cbVar.j.setVoiceViewRes(R.layout.voice_play_btn);
        cbVar.j.setOnImageClickListener(this.l);
        cbVar.j.setOnEmotionClickListener(this.m);
        cbVar.n = (UserIconBox) inflate.findViewById(R.id.user_icon_box);
        cbVar.n.setOnClickListener(this.i);
        cbVar.o = (UserIconBox) inflate.findViewById(R.id.user_tshow_icon_box);
        cbVar.o.setOnClickListener(this.j);
        inflate.setTag(cbVar);
        return inflate;
    }

    private void a(cb cbVar, com.baidu.tieba.data.as asVar, View view) {
        boolean z;
        boolean z2;
        int i;
        if (cbVar != null && asVar != null) {
            cbVar.b.setTag(null);
            cbVar.b.setUserId(null);
            cbVar.c.setText((CharSequence) null);
            cbVar.d.setText((CharSequence) null);
            cbVar.d.setBackgroundDrawable(null);
            cbVar.l.setVisibility(0);
            cbVar.e.setText((CharSequence) null);
            cbVar.h.setVisibility(0);
            cbVar.g.setVisibility(8);
            cbVar.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            SparseArray sparseArray = (SparseArray) cbVar.k.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                cbVar.k.setTag(sparseArray);
                cbVar.j.setTag(sparseArray);
                cbVar.m.setTag(sparseArray);
                cbVar.e.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_clip_board, asVar);
            sparseArray.put(R.id.tag_is_subpb, false);
            boolean z3 = false;
            String j = this.a.j();
            if (this.a.i() && j != null && j.equals(asVar.d())) {
                z3 = true;
            }
            Resources resources = this.b.getResources();
            cbVar.f.setText(com.baidu.tieba.util.bu.a(asVar.f()));
            if (asVar.e() == 1) {
                cbVar.h.setVisibility(8);
            }
            if (this.f != null && !this.f.equals(SocialConstants.FALSE) && this.f.equals(asVar.g().getId())) {
                cbVar.g.setVisibility(0);
                if (this.s == 1) {
                    cbVar.g.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    cbVar.g.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (this.s == 1) {
                cbVar.e.setBackgroundResource(R.drawable.pb_list_floor_number_1);
                if (z3) {
                    cbVar.e.setBackgroundResource(R.drawable.icon_collect_s_1);
                } else {
                    cbVar.e.setBackgroundResource(R.drawable.icon_collect_n_1);
                }
            } else {
                cbVar.e.setBackgroundResource(R.drawable.pb_list_floor_number);
                if (z3) {
                    cbVar.e.setBackgroundResource(R.drawable.icon_collect_s);
                } else {
                    cbVar.e.setBackgroundResource(R.drawable.icon_collect_n);
                }
            }
            cbVar.e.setText(String.valueOf(asVar.e()) + resources.getString(R.string.floor));
            if (TiebaApplication.h().al() == 1) {
                cbVar.a.setBackgroundResource(R.drawable.bg_floor_new_middle_1);
                cbVar.j.setVideoImageId(R.drawable.pic_video_1);
                cbVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content_1));
                cbVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                cbVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n_1, 0, 0, 0);
                cbVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                cbVar.a.setBackgroundResource(R.drawable.bg_floor_new_middle);
                cbVar.j.setVideoImageId(R.drawable.pic_video);
                cbVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content));
                cbVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
                cbVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n, 0, 0, 0);
                cbVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            SparseArray sparseArray2 = (SparseArray) cbVar.h.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                cbVar.h.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, asVar);
            sparseArray2.put(R.id.tag_load_sub_view, view);
            if (asVar.j() > 0 && asVar.a() != null) {
                if (this.n == null) {
                    this.n = new cc(this.b, this.h);
                    this.n.a(this.q);
                    boolean z4 = false;
                    String id = this.a.d().j().getId();
                    if (id != null && id.equals(TiebaApplication.A())) {
                        z4 = true;
                    }
                    this.n.a(this.a.l(), z4);
                    this.n.a(this.d);
                }
                cbVar.l.a(asVar, view);
                cbVar.l.setChildOnClickListener(this.k);
                cbVar.l.setChildOnLongClickListener(this.o);
                cbVar.l.setChildOnTouchListener(this.p);
                cbVar.l.setSubPbAdapter(this.n);
            } else {
                cbVar.l.setVisibility(8);
            }
            String portrait = asVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.d c = this.g.c(portrait);
            if (asVar.g() != null) {
                cbVar.c.setText(asVar.g().getName_show());
                int level_id = asVar.g().getLevel_id();
                int isLike = asVar.g().getIsLike();
                int is_bawu = asVar.g().getIs_bawu();
                String bawu_type = asVar.g().getBawu_type();
                int i2 = 3;
                if (level_id != 0 && isLike != 0) {
                    cbVar.d.setVisibility(0);
                    cbVar.d.setText(String.valueOf(level_id));
                    cbVar.d.setBackgroundResource(com.baidu.tieba.util.n.b(level_id));
                    i2 = 2;
                    cbVar.d.setOnClickListener(null);
                } else {
                    cbVar.d.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        cbVar.d.setText((CharSequence) null);
                        cbVar.d.setBackgroundResource(this.s == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        cbVar.d.setOnClickListener(this.i);
                    } else if (bawu_type.equals("assist")) {
                        cbVar.d.setText((CharSequence) null);
                        cbVar.d.setBackgroundResource(this.s == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        cbVar.d.setOnClickListener(this.i);
                    }
                }
                this.t = asVar.g().getIconInfo();
                this.u = asVar.g().getTShowInfo();
                if (cbVar.n != null) {
                    cbVar.n.setOnClickListener(this.i);
                    cbVar.n.a(this.t, i2, this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
                if (cbVar.o != null) {
                    cbVar.o.setOnClickListener(this.j);
                    cbVar.o.a(this.u, 3, this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
                }
            }
            cbVar.b.setUserId(asVar.g().getId());
            cbVar.b.setImageBitmap(null);
            cbVar.c.setTag(asVar.g().getId());
            if (c != null) {
                c.a(cbVar.b);
            } else {
                cbVar.b.setTag(portrait);
                cbVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
            }
            if (this.s == 1) {
                cbVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                if (this.c) {
                    cbVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                    cbVar.j.setShowEmotion(true);
                } else {
                    cbVar.j.setDefaultImageId(R.drawable.icon_click_1);
                    cbVar.j.setShowEmotion(false);
                }
            } else {
                cbVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
                if (this.c) {
                    cbVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d);
                    cbVar.j.setShowEmotion(true);
                } else {
                    cbVar.j.setDefaultImageId(R.drawable.icon_click);
                    cbVar.j.setShowEmotion(false);
                }
            }
            if (this.v || !this.w) {
                cbVar.j.a(asVar.h(), false);
            } else {
                cbVar.j.a(asVar.h(), true);
            }
            boolean z5 = false;
            if (this.a.l() != 0) {
                boolean z6 = true;
                z2 = true;
                String id2 = asVar.g().getId();
                if (id2 != null && id2.equals(TiebaApplication.A())) {
                    z6 = false;
                }
                z = (id2 == null || id2.equals(SocialConstants.FALSE) || id2.length() == 0) ? false : false;
            } else {
                String id3 = this.a.d().j().getId();
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
            if (TiebaApplication.h().al() == 1) {
                cbVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                cbVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            if (z2 && z) {
                cbVar.i.setVisibility(0);
                cbVar.i.setText(R.string.manage);
                if (TiebaApplication.h().al() == 1) {
                    cbVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
                } else {
                    cbVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
                }
            } else if (z2) {
                cbVar.i.setVisibility(0);
                cbVar.i.setText(R.string.delete);
                if (TiebaApplication.h().al() == 1) {
                    cbVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n_1, 0, 0, 0);
                } else {
                    cbVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n, 0, 0, 0);
                }
            } else {
                cbVar.i.setVisibility(8);
            }
            if (asVar.e() != 1) {
                i = 1;
            } else {
                i = 0;
            }
            SparseArray sparseArray3 = (SparseArray) cbVar.i.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                cbVar.i.setTag(sparseArray3);
            }
            if (cbVar.i.getVisibility() == 0) {
                sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.a.l()));
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

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.l = rVar;
    }

    public void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.m = qVar;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TiebaApplication.h().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.h().al() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }
}
