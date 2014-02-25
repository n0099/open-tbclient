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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class cd extends BaseAdapter {
    private Context b;
    private final boolean w;
    private com.baidu.tieba.data.am a = null;
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
    private cf n = null;
    private View.OnLongClickListener o = null;
    private com.baidu.tieba.g.a p = null;
    private View.OnClickListener q = null;
    private int r = -1;
    private int s = 0;
    private LinkedList<IconData> t = null;
    private LinkedList<IconData> u = null;
    private boolean v = false;

    public cd(Context context) {
        boolean z = true;
        this.b = null;
        this.w = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        f();
    }

    private void f() {
        this.e = Math.min(BdUtilHelper.a(this.b, 427.0f), 640);
        g();
        this.s = TiebaApplication.g().al();
    }

    private void g() {
        this.g = new com.baidu.tieba.util.i(this.b);
        this.g.f("pb");
        this.g.a(this.e, (int) (this.e * 1.6f));
    }

    public void a(com.baidu.tieba.data.am amVar) {
        this.a = amVar;
        if (amVar.d() != null && amVar.d().j() != null) {
            this.f = amVar.d().j().getUserId();
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

    public void a(com.baidu.tieba.g.a aVar) {
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
        this.s = TiebaApplication.g().al();
        if (view == null) {
            view = a(viewGroup);
        }
        ce ceVar = (ce) view.getTag();
        com.baidu.tieba.data.aq aqVar = (com.baidu.tieba.data.aq) getItem(i);
        NewPbActivity newPbActivity = (NewPbActivity) this.b;
        newPbActivity.getLayoutMode().a(this.s == 1);
        newPbActivity.getLayoutMode().a(view);
        if (aqVar != null) {
            a(ceVar, aqVar, view);
        }
        if (!this.v && this.w && ceVar != null && ceVar.j.a() && (c = newPbActivity.c()) != null) {
            this.v = true;
            CompatibleUtile.getInstance().closeViewGpu(c);
        }
        return view;
    }

    private View a(ViewGroup viewGroup) {
        ce ceVar = new ce(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, viewGroup, false);
        ceVar.a = inflate.findViewById(R.id.sub_pb_more);
        ceVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        ceVar.b.setIsRound(true);
        ceVar.c = (TextView) inflate.findViewById(R.id.user_name);
        ceVar.d = (TextView) inflate.findViewById(R.id.user_rank);
        ceVar.h = (Button) inflate.findViewById(R.id.reply);
        ceVar.i = (Button) inflate.findViewById(R.id.manage_btn);
        ceVar.j = (TbRichTextView) inflate.findViewById(R.id.richText);
        ceVar.i.setOnClickListener(this.q);
        ceVar.m = (LinearLayout) inflate.findViewById(R.id.bottom_container);
        ceVar.e = (TextView) inflate.findViewById(R.id.floor);
        ceVar.g = (ImageView) inflate.findViewById(R.id.floor_owner);
        ceVar.f = (TextView) inflate.findViewById(R.id.time);
        ceVar.k = (ColumnLayout) inflate.findViewById(R.id.pb_post_header_layout);
        ceVar.l = (SubPbLayout) inflate.findViewById(R.id.pb_post_footer_layout);
        ceVar.c.setOnClickListener(this.h);
        ceVar.h.setOnClickListener(this.k);
        ceVar.b.setOnClickListener(this.h);
        ceVar.e.setOnClickListener(this.k);
        ceVar.k.setOnLongClickListener(this.o);
        ceVar.j.setOnLongClickListener(this.o);
        ceVar.m.setOnLongClickListener(this.o);
        if (this.r < 0) {
            this.r = (((BdUtilHelper.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - ceVar.j.getPaddingLeft()) - ceVar.j.getPaddingRight();
        }
        ceVar.k.setOnTouchListener(this.p);
        ceVar.j.setOnTouchListener(this.p);
        ceVar.m.setOnTouchListener(this.p);
        this.r = this.e > this.r ? this.r : this.e;
        ceVar.j.setMaxImageWidth(this.r);
        ceVar.j.setMaxImageHeight((int) (this.r * 1.618f));
        ceVar.j.setTextSize(com.baidu.tieba.data.i.B());
        if (!this.d) {
            ceVar.b.setVisibility(8);
        }
        ceVar.j.a(this.c, false);
        ceVar.j.setVoiceViewRes(R.layout.voice_play_btn);
        ceVar.j.setOnImageClickListener(this.l);
        ceVar.j.setOnEmotionClickListener(this.m);
        ceVar.n = (UserIconBox) inflate.findViewById(R.id.user_icon_box);
        ceVar.n.setOnClickListener(this.i);
        ceVar.o = (UserIconBox) inflate.findViewById(R.id.user_tshow_icon_box);
        ceVar.o.setOnClickListener(this.j);
        inflate.setTag(ceVar);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03e0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ce ceVar, com.baidu.tieba.data.aq aqVar, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        SparseArray sparseArray;
        if (ceVar != null && aqVar != null) {
            ceVar.b.setTag(null);
            ceVar.b.setUserId(null);
            ceVar.c.setText((CharSequence) null);
            ceVar.d.setText((CharSequence) null);
            ceVar.d.setBackgroundDrawable(null);
            ceVar.l.setVisibility(0);
            ceVar.e.setText((CharSequence) null);
            ceVar.h.setVisibility(0);
            ceVar.g.setVisibility(8);
            ceVar.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            SparseArray sparseArray2 = (SparseArray) ceVar.k.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                ceVar.k.setTag(sparseArray2);
                ceVar.j.setTag(sparseArray2);
                ceVar.m.setTag(sparseArray2);
                ceVar.e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_clip_board, aqVar);
            sparseArray2.put(R.id.tag_is_subpb, false);
            boolean z4 = false;
            String j = this.a.j();
            if (this.a.i() && j != null && j.equals(aqVar.d())) {
                z4 = true;
            }
            Resources resources = this.b.getResources();
            ceVar.f.setText(com.baidu.tieba.util.bs.a(aqVar.f()));
            if (aqVar.e() == 1) {
                ceVar.h.setVisibility(8);
            }
            if (this.f != null && !this.f.equals(SocialConstants.FALSE) && this.f.equals(aqVar.g().getUserId())) {
                ceVar.g.setVisibility(0);
                if (this.s == 1) {
                    ceVar.g.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    ceVar.g.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (this.s == 1) {
                ceVar.e.setBackgroundResource(R.drawable.pb_list_floor_number_1);
                if (z4) {
                    ceVar.e.setBackgroundResource(R.drawable.icon_collect_s_1);
                } else {
                    ceVar.e.setBackgroundResource(R.drawable.icon_collect_n_1);
                }
            } else {
                ceVar.e.setBackgroundResource(R.drawable.pb_list_floor_number);
                if (z4) {
                    ceVar.e.setBackgroundResource(R.drawable.icon_collect_s);
                } else {
                    ceVar.e.setBackgroundResource(R.drawable.icon_collect_n);
                }
            }
            ceVar.e.setText(String.valueOf(String.valueOf(aqVar.e())) + resources.getString(R.string.floor));
            if (TiebaApplication.g().al() == 1) {
                ceVar.a.setBackgroundResource(R.drawable.bg_floor_new_middle_1);
                ceVar.j.setVideoImageId(R.drawable.pic_video_1);
                ceVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content_1));
                ceVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                ceVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n_1, 0, 0, 0);
                ceVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                ceVar.a.setBackgroundResource(R.drawable.bg_floor_new_middle);
                ceVar.j.setVideoImageId(R.drawable.pic_video);
                ceVar.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content));
                ceVar.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
                ceVar.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n, 0, 0, 0);
                ceVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) ceVar.h.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                ceVar.h.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, aqVar);
            sparseArray3.put(R.id.tag_load_sub_view, view);
            if (aqVar.j() > 0 && aqVar.a() != null) {
                if (this.n == null) {
                    this.n = new cf(this.b, this.h);
                    this.n.a(this.q);
                    boolean z5 = false;
                    String userId = this.a.d().j().getUserId();
                    if (userId != null && userId.equals(TiebaApplication.A())) {
                        z5 = true;
                    }
                    this.n.a(this.a.l(), z5);
                    this.n.a(this.d);
                }
                ceVar.l.a(aqVar, view);
                ceVar.l.setChildOnClickListener(this.k);
                ceVar.l.setChildOnLongClickListener(this.o);
                ceVar.l.setChildOnTouchListener(this.p);
                ceVar.l.setSubPbAdapter(this.n);
            } else {
                ceVar.l.setVisibility(8);
            }
            String portrait = aqVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.b c = this.g.c(portrait);
            if (aqVar.g() != null) {
                ceVar.c.setText(aqVar.g().getName_show());
                int level_id = aqVar.g().getLevel_id();
                int isLike = aqVar.g().getIsLike();
                int is_bawu = aqVar.g().getIs_bawu();
                String bawu_type = aqVar.g().getBawu_type();
                int i2 = 3;
                if (level_id != 0 && isLike != 0) {
                    ceVar.d.setVisibility(0);
                    ceVar.d.setText(String.valueOf(level_id));
                    ceVar.d.setBackgroundResource(com.baidu.tieba.util.n.b(level_id));
                    i2 = 2;
                    ceVar.d.setOnClickListener(null);
                } else {
                    ceVar.d.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ceVar.d.setText((CharSequence) null);
                        ceVar.d.setBackgroundResource(this.s == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        ceVar.d.setOnClickListener(this.i);
                    } else if (bawu_type.equals("assist")) {
                        ceVar.d.setText((CharSequence) null);
                        ceVar.d.setBackgroundResource(this.s == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        ceVar.d.setOnClickListener(this.i);
                    }
                }
                this.t = aqVar.g().getIconInfo();
                this.u = aqVar.g().getTShowInfo();
                if (ceVar.n != null) {
                    ceVar.n.setOnClickListener(this.i);
                    ceVar.n.a(this.t, i2, this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
                if (ceVar.o != null) {
                    ceVar.o.setOnClickListener(this.j);
                    ceVar.o.a(this.u, 3, this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
                }
            }
            ceVar.b.setUserId(aqVar.g().getUserId());
            ceVar.b.setImageBitmap(null);
            ceVar.c.setTag(aqVar.g().getUserId());
            if (c != null) {
                c.a(ceVar.b);
            } else {
                ceVar.b.setTag(portrait);
                ceVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
            }
            if (this.s == 1) {
                ceVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                ceVar.j.setDefaultGifId(R.drawable.pic_expression_upload_selector_1);
                if (this.c) {
                    ceVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                    ceVar.j.setShowEmotion(true);
                } else {
                    ceVar.j.setDefaultImageId(R.drawable.icon_click_1);
                    ceVar.j.setShowEmotion(false);
                }
            } else {
                ceVar.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
                ceVar.j.setDefaultGifId(R.drawable.pic_expression_upload_selector);
                if (this.c) {
                    ceVar.j.setDefaultImageId(R.drawable.pic_baidu_logo_d);
                    ceVar.j.setShowEmotion(true);
                } else {
                    ceVar.j.setDefaultImageId(R.drawable.icon_click);
                    ceVar.j.setShowEmotion(false);
                }
            }
            if (this.v || !this.w) {
                ceVar.j.a(aqVar.h(), false);
            } else {
                ceVar.j.a(aqVar.h(), true);
            }
            boolean z6 = false;
            boolean z7 = false;
            if (this.a.l() != 0) {
                z6 = true;
                z7 = true;
                String userId2 = aqVar.g().getUserId();
                if (userId2 != null && userId2.equals(TiebaApplication.A())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals(SocialConstants.FALSE) || userId2.length() == 0) {
                    z = false;
                    z2 = true;
                    z3 = false;
                    if (TiebaApplication.g().al() == 1) {
                        ceVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                    } else {
                        ceVar.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
                    }
                    if (!z2 && z) {
                        ceVar.i.setVisibility(0);
                        ceVar.i.setText(R.string.manage);
                        if (TiebaApplication.g().al() == 1) {
                            ceVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
                        } else {
                            ceVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
                        }
                    } else if (z2) {
                        ceVar.i.setVisibility(0);
                        ceVar.i.setText(R.string.delete);
                        if (TiebaApplication.g().al() == 1) {
                            ceVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n_1, 0, 0, 0);
                        } else {
                            ceVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n, 0, 0, 0);
                        }
                    } else {
                        ceVar.i.setVisibility(8);
                    }
                    if (aqVar.e() != 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    sparseArray = (SparseArray) ceVar.i.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        ceVar.i.setTag(sparseArray);
                    }
                    if (ceVar.i.getVisibility() == 0) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.a.l()));
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_id, aqVar.d());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    if (z) {
                        sparseArray.put(R.id.tag_forbid_user_name, aqVar.g().getUserName());
                        return;
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        return;
                    }
                }
                z = z6;
                z2 = z7;
                z3 = false;
                if (TiebaApplication.g().al() == 1) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (aqVar.e() != 1) {
                }
                sparseArray = (SparseArray) ceVar.i.getTag();
                if (sparseArray == null) {
                }
                if (ceVar.i.getVisibility() == 0) {
                }
                if (z2) {
                }
                if (z) {
                }
            } else {
                String userId3 = this.a.d().j().getUserId();
                if (userId3 != null && userId3.equals(TiebaApplication.A())) {
                    z = false;
                    z2 = true;
                    z3 = false;
                } else {
                    String userId4 = aqVar.g().getUserId();
                    if (userId4 != null && userId4.equals(TiebaApplication.A())) {
                        z = false;
                        z2 = true;
                        z3 = true;
                    }
                    z = z6;
                    z2 = z7;
                    z3 = false;
                }
                if (TiebaApplication.g().al() == 1) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (aqVar.e() != 1) {
                }
                sparseArray = (SparseArray) ceVar.i.getTag();
                if (sparseArray == null) {
                }
                if (ceVar.i.getVisibility() == 0) {
                }
                if (z2) {
                }
                if (z) {
                }
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
        String string = TiebaApplication.g().b().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.g().al() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }
}
