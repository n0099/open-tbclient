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
public final class cd extends BaseAdapter {
    private Context b;
    private int e;
    private com.baidu.tieba.util.i g;
    private int s;
    private final boolean w;
    private com.baidu.tieba.data.am a = null;
    private boolean c = true;
    private boolean d = true;
    private String f = null;
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
    private LinkedList<IconData> t = null;
    private LinkedList<IconData> u = null;
    private boolean v = false;

    public cd(Context context) {
        boolean z = true;
        this.b = null;
        this.e = 0;
        this.g = null;
        this.s = 0;
        this.w = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.b = context;
        this.e = Math.min(BdUtilHelper.a(this.b, 427.0f), 640);
        this.g = new com.baidu.tieba.util.i(this.b);
        this.g.b("pb");
        this.g.a(this.e, (int) (this.e * 1.6f));
        this.s = TiebaApplication.g().ae();
    }

    public final void a(com.baidu.tieba.data.am amVar) {
        this.a = amVar;
        if (amVar.d() != null && amVar.d().i() != null) {
            this.f = amVar.d().i().getUserId();
        }
    }

    public final com.baidu.tieba.util.i a() {
        return this.g;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public final void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public final void d(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.o = onLongClickListener;
    }

    public final View.OnLongClickListener b() {
        return this.o;
    }

    public final void e(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public final void a(com.baidu.tieba.g.a aVar) {
        this.p = aVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a == null || this.a.e() == null) {
            return 0;
        }
        return this.a.e().size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.a == null || this.a.e() == null || i < 0 || i >= this.a.e().size()) {
            return null;
        }
        return this.a.e().get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void b(boolean z) {
        this.d = z;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final int e() {
        return this.r;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x05d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x082a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0849  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0853  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        ListView c;
        boolean z;
        boolean z2;
        boolean z3;
        SparseArray sparseArray;
        this.s = TiebaApplication.g().ae();
        if (view == null) {
            ce ceVar = new ce(this, (byte) 0);
            view = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_item, viewGroup, false);
            ceVar.a = view.findViewById(R.id.sub_pb_more);
            ceVar.b = (HeadImageView) view.findViewById(R.id.photo);
            ceVar.b.setIsRound(true);
            ceVar.c = (TextView) view.findViewById(R.id.user_name);
            ceVar.d = (TextView) view.findViewById(R.id.user_rank);
            ceVar.h = (Button) view.findViewById(R.id.reply);
            ceVar.i = (Button) view.findViewById(R.id.manage_btn);
            ceVar.j = (TbRichTextView) view.findViewById(R.id.richText);
            ceVar.i.setOnClickListener(this.q);
            ceVar.m = (LinearLayout) view.findViewById(R.id.bottom_container);
            ceVar.e = (TextView) view.findViewById(R.id.floor);
            ceVar.g = (ImageView) view.findViewById(R.id.floor_owner);
            ceVar.f = (TextView) view.findViewById(R.id.time);
            ceVar.k = (ColumnLayout) view.findViewById(R.id.pb_post_header_layout);
            ceVar.l = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            ceVar.c.setOnClickListener(this.h);
            ceVar.h.setOnClickListener(this.k);
            ceVar.b.setOnClickListener(this.h);
            ceVar.e.setOnClickListener(this.k);
            ceVar.k.setOnLongClickListener(this.o);
            ceVar.j.setOnLongClickListener(this.o);
            ceVar.m.setOnLongClickListener(this.o);
            if (this.r < 0) {
                this.r = (((BdUtilHelper.b(this.b) - view.getPaddingLeft()) - view.getPaddingRight()) - ceVar.j.getPaddingLeft()) - ceVar.j.getPaddingRight();
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
            ceVar.n = (UserIconBox) view.findViewById(R.id.user_icon_box);
            ceVar.n.setOnClickListener(this.i);
            ceVar.o = (UserIconBox) view.findViewById(R.id.user_tshow_icon_box);
            ceVar.o.setOnClickListener(this.j);
            view.setTag(ceVar);
        }
        ce ceVar2 = (ce) view.getTag();
        com.baidu.tieba.data.aq aqVar = (com.baidu.tieba.data.aq) getItem(i);
        NewPbActivity newPbActivity = (NewPbActivity) this.b;
        newPbActivity.getLayoutMode().a(this.s == 1);
        newPbActivity.getLayoutMode().a(view);
        if (aqVar != null && ceVar2 != null && aqVar != null) {
            ceVar2.b.setTag(null);
            ceVar2.b.setUserId(null);
            ceVar2.c.setText((CharSequence) null);
            ceVar2.d.setText((CharSequence) null);
            ceVar2.d.setBackgroundDrawable(null);
            ceVar2.l.setVisibility(0);
            ceVar2.e.setText((CharSequence) null);
            ceVar2.h.setVisibility(0);
            ceVar2.g.setVisibility(8);
            ceVar2.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            SparseArray sparseArray2 = (SparseArray) ceVar2.k.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                ceVar2.k.setTag(sparseArray2);
                ceVar2.j.setTag(sparseArray2);
                ceVar2.m.setTag(sparseArray2);
                ceVar2.e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_clip_board, aqVar);
            sparseArray2.put(R.id.tag_is_subpb, false);
            boolean z4 = false;
            String j = this.a.j();
            if (this.a.i() && j != null && j.equals(aqVar.d())) {
                z4 = true;
            }
            Resources resources = this.b.getResources();
            ceVar2.f.setText(com.baidu.tieba.util.bs.a(aqVar.f()));
            if (aqVar.e() == 1) {
                ceVar2.h.setVisibility(8);
            }
            if (this.f != null && !this.f.equals(SocialConstants.FALSE) && this.f.equals(aqVar.g().getUserId())) {
                ceVar2.g.setVisibility(0);
                if (this.s == 1) {
                    ceVar2.g.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    ceVar2.g.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (this.s == 1) {
                ceVar2.e.setBackgroundResource(R.drawable.pb_list_floor_number_1);
                if (z4) {
                    ceVar2.e.setBackgroundResource(R.drawable.icon_collect_s_1);
                } else {
                    ceVar2.e.setBackgroundResource(R.drawable.icon_collect_n_1);
                }
            } else {
                ceVar2.e.setBackgroundResource(R.drawable.pb_list_floor_number);
                if (z4) {
                    ceVar2.e.setBackgroundResource(R.drawable.icon_collect_s);
                } else {
                    ceVar2.e.setBackgroundResource(R.drawable.icon_collect_n);
                }
            }
            ceVar2.e.setText(String.valueOf(String.valueOf(aqVar.e())) + resources.getString(R.string.floor));
            if (TiebaApplication.g().ae() == 1) {
                ceVar2.a.setBackgroundResource(R.drawable.bg_floor_new_middle_1);
                ceVar2.j.setVideoImageId(R.drawable.pic_video_1);
                ceVar2.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content_1));
                ceVar2.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                ceVar2.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n_1, 0, 0, 0);
                ceVar2.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                ceVar2.a.setBackgroundResource(R.drawable.bg_floor_new_middle);
                ceVar2.j.setVideoImageId(R.drawable.pic_video);
                ceVar2.j.setTextColor(this.b.getResources().getColor(R.color.pb_listitem_content));
                ceVar2.h.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
                ceVar2.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_comment_n, 0, 0, 0);
                ceVar2.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) ceVar2.h.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                ceVar2.h.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, aqVar);
            sparseArray3.put(R.id.tag_load_sub_view, view);
            if (aqVar.j() <= 0 || aqVar.a() == null) {
                ceVar2.l.setVisibility(8);
            } else {
                if (this.n == null) {
                    this.n = new cf(this.b, this.h);
                    this.n.a(this.q);
                    boolean z5 = false;
                    String userId = this.a.d().i().getUserId();
                    if (userId != null && userId.equals(TiebaApplication.v())) {
                        z5 = true;
                    }
                    this.n.a(this.a.l(), z5);
                    cf cfVar = this.n;
                    boolean z6 = this.d;
                    cfVar.b();
                }
                ceVar2.l.a(aqVar, view);
                ceVar2.l.setChildOnClickListener(this.k);
                ceVar2.l.setChildOnLongClickListener(this.o);
                ceVar2.l.setChildOnTouchListener(this.p);
                ceVar2.l.setSubPbAdapter(this.n);
            }
            String portrait = aqVar.g().getPortrait();
            com.baidu.tieba.util.i iVar = this.g;
            com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
            if (aqVar.g() != null) {
                ceVar2.c.setText(aqVar.g().getName_show());
                int level_id = aqVar.g().getLevel_id();
                int isLike = aqVar.g().getIsLike();
                int is_bawu = aqVar.g().getIs_bawu();
                String bawu_type = aqVar.g().getBawu_type();
                int i2 = 3;
                if (level_id == 0 || isLike == 0) {
                    ceVar2.d.setVisibility(8);
                } else {
                    ceVar2.d.setVisibility(0);
                    ceVar2.d.setText(String.valueOf(level_id));
                    ceVar2.d.setBackgroundResource(com.baidu.tieba.util.n.b(level_id));
                    i2 = 2;
                    ceVar2.d.setOnClickListener(null);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ceVar2.d.setText((CharSequence) null);
                        ceVar2.d.setBackgroundResource(this.s == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        ceVar2.d.setOnClickListener(this.i);
                    } else if (bawu_type.equals("assist")) {
                        ceVar2.d.setText((CharSequence) null);
                        ceVar2.d.setBackgroundResource(this.s == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        ceVar2.d.setOnClickListener(this.i);
                    }
                }
                this.t = aqVar.g().getIconInfo();
                this.u = aqVar.g().getTShowInfo();
                if (ceVar2.n != null) {
                    ceVar2.n.setOnClickListener(this.i);
                    ceVar2.n.a(this.t, i2, this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
                if (ceVar2.o != null) {
                    ceVar2.o.setOnClickListener(this.j);
                    ceVar2.o.a(this.u, 3, this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
                }
            }
            ceVar2.b.setUserId(aqVar.g().getUserId());
            ceVar2.b.setImageBitmap(null);
            ceVar2.c.setTag(aqVar.g().getUserId());
            if (b != null) {
                b.a(ceVar2.b);
            } else {
                ceVar2.b.setTag(portrait);
                ceVar2.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
            }
            if (this.s == 1) {
                ceVar2.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                ceVar2.j.setDefaultGifId(R.drawable.pic_expression_upload_selector_1);
                if (this.c) {
                    ceVar2.j.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                    ceVar2.j.setShowEmotion(true);
                } else {
                    ceVar2.j.setDefaultImageId(R.drawable.icon_click_1);
                    ceVar2.j.setShowEmotion(false);
                }
            } else {
                ceVar2.j.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
                ceVar2.j.setDefaultGifId(R.drawable.pic_expression_upload_selector);
                if (this.c) {
                    ceVar2.j.setDefaultImageId(R.drawable.pic_baidu_logo_d);
                    ceVar2.j.setShowEmotion(true);
                } else {
                    ceVar2.j.setDefaultImageId(R.drawable.icon_click);
                    ceVar2.j.setShowEmotion(false);
                }
            }
            if (this.v || !this.w) {
                ceVar2.j.a(aqVar.h(), false);
            } else {
                ceVar2.j.a(aqVar.h(), true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.a.l() != 0) {
                z7 = true;
                z8 = true;
                String userId2 = aqVar.g().getUserId();
                if (userId2 != null && userId2.equals(TiebaApplication.v())) {
                    z7 = false;
                }
                if (userId2 == null || userId2.equals(SocialConstants.FALSE) || userId2.length() == 0) {
                    z = false;
                    z2 = true;
                    z3 = false;
                    if (TiebaApplication.g().ae() == 1) {
                        ceVar2.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
                    } else {
                        ceVar2.i.setTextColor(this.b.getResources().getColor(R.color.common_link_text));
                    }
                    if (!z2 && z) {
                        ceVar2.i.setVisibility(0);
                        ceVar2.i.setText(R.string.manage);
                        if (TiebaApplication.g().ae() == 1) {
                            ceVar2.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
                        } else {
                            ceVar2.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
                        }
                    } else if (z2) {
                        ceVar2.i.setVisibility(0);
                        ceVar2.i.setText(R.string.delete);
                        if (TiebaApplication.g().ae() == 1) {
                            ceVar2.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n_1, 0, 0, 0);
                        } else {
                            ceVar2.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_delete_n, 0, 0, 0);
                        }
                    } else {
                        ceVar2.i.setVisibility(8);
                    }
                    int i3 = aqVar.e() == 1 ? 0 : 1;
                    sparseArray = (SparseArray) ceVar2.i.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        ceVar2.i.setTag(sparseArray);
                    }
                    if (ceVar2.i.getVisibility() == 0) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.a.l()));
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, aqVar.d());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    if (z) {
                        sparseArray.put(R.id.tag_forbid_user_name, aqVar.g().getUserName());
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                    }
                }
                z = z7;
                z2 = z8;
                z3 = false;
                if (TiebaApplication.g().ae() == 1) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (aqVar.e() == 1) {
                }
                sparseArray = (SparseArray) ceVar2.i.getTag();
                if (sparseArray == null) {
                }
                if (ceVar2.i.getVisibility() == 0) {
                }
                if (z2) {
                }
                if (z) {
                }
            } else {
                String userId3 = this.a.d().i().getUserId();
                if (userId3 == null || !userId3.equals(TiebaApplication.v())) {
                    String userId4 = aqVar.g().getUserId();
                    if (userId4 != null && userId4.equals(TiebaApplication.v())) {
                        z = false;
                        z2 = true;
                        z3 = true;
                    }
                    z = z7;
                    z2 = z8;
                    z3 = false;
                } else {
                    z = false;
                    z2 = true;
                    z3 = false;
                }
                if (TiebaApplication.g().ae() == 1) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (aqVar.e() == 1) {
                }
                sparseArray = (SparseArray) ceVar2.i.getTag();
                if (sparseArray == null) {
                }
                if (ceVar2.i.getVisibility() == 0) {
                }
                if (z2) {
                }
                if (z) {
                }
            }
        }
        if (!this.v && this.w && ceVar2 != null && ceVar2.j.a() && (c = newPbActivity.c()) != null) {
            this.v = true;
            CompatibleUtile.getInstance().closeViewGpu(c);
        }
        return view;
    }

    public final void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.l = rVar;
    }

    public final void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.m = qVar;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TiebaApplication.g().b().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.g().ae() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }
}
