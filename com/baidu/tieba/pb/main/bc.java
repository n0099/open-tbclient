package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.pb.sub.SubPbLayout;
import com.baidu.tieba.view.BaobaoTailView;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public class bc extends BaseAdapter {
    private final CustomMessageListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private Context b;
    private final boolean x;
    private String y;
    private boolean z;
    private com.baidu.tieba.data.ai a = null;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private int f = 0;
    private String g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private View.OnClickListener k = null;
    private com.baidu.tbadk.widget.richText.s l = null;
    private com.baidu.tbadk.widget.richText.r m = null;
    private com.baidu.tieba.pb.sub.b n = null;
    private View.OnLongClickListener o = null;
    private com.baidu.tieba.c.a p = null;
    private View.OnClickListener q = null;
    private int r = -1;
    private int s = 0;
    private LinkedList<IconData> t = null;
    private LinkedList<IconData> u = null;
    private boolean v = false;
    private boolean w = false;

    public bc(Context context) {
        boolean z = false;
        this.b = null;
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16) {
            z = true;
        }
        this.x = z;
        this.y = "[rec]";
        this.z = true;
        this.A = new bd(this, 2001122);
        this.B = new be(this);
        this.C = new bf(this);
        this.b = context;
        e();
    }

    private void e() {
        this.f = Math.min(com.baidu.adp.lib.util.j.a(this.b, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.s = TbadkApplication.m252getInst().getSkinType();
        if (this.b instanceof BaseActivity) {
            ((BaseActivity) this.b).registerListener(this.A);
        }
    }

    public void a(com.baidu.tieba.data.ai aiVar) {
        this.a = aiVar;
        g();
        if (aiVar.c() != null && aiVar.c().y() != null) {
            this.g = aiVar.c().y().getUserId();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void c(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void e(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.o = onLongClickListener;
    }

    public View.OnLongClickListener a() {
        return this.o;
    }

    public void a(com.baidu.tieba.c.a aVar) {
        this.p = aVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.d() == null || this.a.d().size() < 1) {
            return 0;
        }
        com.baidu.tieba.data.am amVar = this.a.d().get(this.a.d().size() - 1);
        if (!this.e && amVar.m() == 1) {
            return this.a.d().size() - 1;
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

    public void b(boolean z) {
        this.c = z;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public int d() {
        return this.r;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return b(view, viewGroup, i);
        }
        if (itemViewType == 1) {
            return a(view, viewGroup, i);
        }
        return null;
    }

    private View a(View view, ViewGroup viewGroup, int i) {
        this.s = TbadkApplication.m252getInst().getSkinType();
        if (view == null) {
            view = f();
        }
        bl blVar = (bl) view.getTag();
        com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) getItem(i);
        Resources resources = ((PbActivity) this.b).getResources();
        if (this.s == 1) {
            blVar.E.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_b_1));
            blVar.G.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i_1));
            blVar.G.setBackgroundResource(com.baidu.tieba.u.btn_appdownload_1);
            blVar.C.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b_1);
        } else {
            blVar.E.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_b));
            blVar.G.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i));
            blVar.G.setBackgroundResource(com.baidu.tieba.u.btn_appdownload);
            blVar.C.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.y) + " " + ahVar.c() + "【" + ahVar.b() + "】");
        spannableStringBuilder.setSpan(new ImageSpan(this.b, com.baidu.tieba.u.icon_extend), 0, this.y.length(), 17);
        blVar.E.setText(spannableStringBuilder);
        if (!TextUtils.isEmpty(ahVar.g()) && com.baidu.tbadk.core.h.a().f()) {
            blVar.F.a(ahVar.g(), 17, false);
        } else {
            blVar.F.setVisibility(8);
        }
        blVar.G.setTag(Integer.valueOf(i));
        boolean b = com.baidu.tieba.frs.b.a().b(ahVar.d());
        boolean c = com.baidu.tieba.frs.b.a().c(ahVar.d());
        if (b) {
            ahVar.a(1);
        } else if (c) {
            ahVar.a(2);
        } else {
            ahVar.a(0);
        }
        if (!TextUtils.isEmpty(ahVar.e())) {
            switch (ahVar.h()) {
                case 0:
                    blVar.G.setText(com.baidu.tieba.y.pb_app_download);
                    blVar.G.setOnClickListener(this.B);
                    blVar.D.setOnClickListener(this.C);
                    blVar.G.setEnabled(true);
                    break;
                case 1:
                    blVar.G.setText(com.baidu.tieba.y.downloading2);
                    blVar.G.setOnClickListener(null);
                    blVar.D.setOnClickListener(null);
                    blVar.G.setEnabled(false);
                    break;
                case 2:
                    blVar.G.setText(com.baidu.tieba.y.downloaded);
                    blVar.G.setOnClickListener(this.B);
                    blVar.D.setOnClickListener(this.C);
                    blVar.G.setEnabled(true);
                    break;
            }
        } else {
            blVar.G.setText(com.baidu.tieba.y.pb_app_see);
            blVar.G.setOnClickListener(new bh(this, ahVar));
            blVar.D.setOnClickListener(new bi(this, ahVar));
        }
        return view;
    }

    public void a(com.baidu.tieba.data.ah ahVar, int i) {
        if (!((TextUtils.isEmpty(ahVar.d()) || TextUtils.isEmpty(ahVar.b())) ? false : true)) {
            com.baidu.adp.lib.util.j.a(this.b, com.baidu.tieba.y.pb_app_error);
        } else if (UtilHelper.isNetOk()) {
            com.baidu.tbadk.i.a().b(ahVar.d(), System.currentTimeMillis());
            ahVar.a(1);
            notifyDataSetChanged();
            TiebaStatic.eventStat(this.b, "pb_dl_app", null, 1, "app_name", ahVar.d());
            com.baidu.tieba.frs.b.a().a(ahVar.d(), ahVar.e(), ahVar.b(), i);
        } else {
            com.baidu.adp.lib.util.j.a(this.b, com.baidu.tieba.y.neterror);
        }
    }

    public void a(com.baidu.tieba.data.ah ahVar) {
        String d = ahVar.d();
        if (TextUtils.isEmpty(d)) {
            com.baidu.adp.lib.util.j.a(this.b, com.baidu.tieba.y.pb_app_error);
            return;
        }
        com.baidu.tbadk.i.a().b(ahVar.d(), System.currentTimeMillis());
        File d2 = com.baidu.tbadk.core.util.z.d(String.valueOf(d.replace(".", "_")) + ".apk");
        if (d2 != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d2), "application/vnd.android.package-archive");
            this.b.startActivity(intent);
        }
    }

    private View f() {
        bl blVar = new bl(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.pb_item_app, (ViewGroup) null);
        blVar.D = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.recommend_app_container);
        blVar.E = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_app);
        blVar.F = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_img);
        blVar.G = (Button) inflate.findViewById(com.baidu.tieba.v.recommend_btn);
        blVar.C = inflate.findViewById(com.baidu.tieba.v.divider_line);
        inflate.setTag(blVar);
        return inflate;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView a;
        ImageView imageView2;
        this.s = TbadkApplication.m252getInst().getSkinType();
        View a2 = view == null ? a(viewGroup, false) : view;
        bl blVar = (bl) a2.getTag();
        com.baidu.tieba.data.am amVar = (com.baidu.tieba.data.am) getItem(i);
        PbActivity pbActivity = (PbActivity) this.b;
        Resources resources = pbActivity.getResources();
        if (this.s == 1) {
            blVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b_1));
            blVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b_1));
            if (blVar.v != null) {
                blVar.v.setTextColor(resources.getColor(com.baidu.tieba.s.subpb_listitem_time_1));
            }
            if (blVar.x != null) {
                blVar.x.setTextColor(resources.getColor(com.baidu.tieba.s.common_link_text_1));
            }
            blVar.f.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_f_1));
            blVar.g.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i_1));
            blVar.h.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d_1));
            blVar.i.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d_1));
            blVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector_1);
            blVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b_1));
            blVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e_1));
            blVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e_1));
            blVar.o.setImageResource(com.baidu.tieba.s.cp_bg_line_b_1);
            imageView2 = blVar.J;
            imageView2.setImageResource(com.baidu.tieba.s.cp_bg_line_b_1);
        } else {
            blVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b));
            blVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b));
            if (blVar.v != null) {
                blVar.v.setTextColor(resources.getColor(com.baidu.tieba.s.subpb_listitem_time));
            }
            if (blVar.x != null) {
                blVar.x.setTextColor(resources.getColor(com.baidu.tieba.s.common_link_text));
            }
            blVar.f.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_f));
            blVar.g.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i));
            blVar.h.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d));
            blVar.i.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d));
            blVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector);
            blVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b));
            blVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e));
            blVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e));
            blVar.o.setImageResource(com.baidu.tieba.s.cp_bg_line_b);
            imageView = blVar.J;
            imageView.setImageResource(com.baidu.tieba.s.cp_bg_line_b);
        }
        if (amVar != null) {
            a(blVar, amVar, a2, false, i);
        }
        if (!this.w && this.x && blVar != null && blVar.l.a() && (a = pbActivity.a()) != null) {
            this.w = true;
            CompatibleUtile.getInstance().closeViewGpu(a);
        }
        return a2;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bl blVar = new bl(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.new_pb_list_item, viewGroup, false);
        blVar.d = inflate.findViewById(com.baidu.tieba.v.sub_pb_more);
        blVar.e = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
        blVar.f = (TextView) inflate.findViewById(com.baidu.tieba.v.user_name);
        blVar.g = (TextView) inflate.findViewById(com.baidu.tieba.v.user_rank);
        blVar.k = (ImageView) inflate.findViewById(com.baidu.tieba.v.reply);
        blVar.l = (TbRichTextView) inflate.findViewById(com.baidu.tieba.v.richText);
        blVar.m = inflate.findViewById(com.baidu.tieba.v.pb_item_praise_topline);
        blVar.n = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.v.pb_item_praise_view);
        blVar.o = (ImageView) inflate.findViewById(com.baidu.tieba.v.pb_item_praise_bottomline);
        blVar.j = (ImageView) inflate.findViewById(com.baidu.tieba.v.floor_owner);
        blVar.h = (TextView) inflate.findViewById(com.baidu.tieba.v.floor);
        blVar.i = (TextView) inflate.findViewById(com.baidu.tieba.v.time);
        blVar.p = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.pb_post_header_layout);
        blVar.q = (SubPbLayout) inflate.findViewById(com.baidu.tieba.v.pb_post_footer_layout);
        blVar.I = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.pb_subpb_layout_root);
        blVar.J = (ImageView) inflate.findViewById(com.baidu.tieba.v.pb_post_footer_layout_line_top);
        blVar.f.setOnClickListener(this.h);
        blVar.k.setOnClickListener(this.k);
        blVar.e.setOnClickListener(this.h);
        blVar.a = inflate;
        blVar.b = inflate.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top);
        blVar.c = inflate.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top_full);
        blVar.p.setOnLongClickListener(this.o);
        blVar.l.setOnLongClickListener(this.o);
        if (this.r < 0) {
            this.r = (((com.baidu.adp.lib.util.j.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - blVar.l.getPaddingLeft()) - blVar.l.getPaddingRight();
        }
        blVar.p.setOnTouchListener(this.p);
        blVar.l.setOnTouchListener(this.p);
        this.r = this.f > this.r ? this.r : this.f;
        int dimension = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds104);
        if (this.r > dimension) {
            blVar.l.setMaxImageWidth(this.r - dimension);
        } else {
            blVar.l.setMaxImageWidth(this.r);
        }
        blVar.l.setMaxImageHeight((int) (this.r * 1.618f));
        blVar.l.setTextSize(TbConfig.getContentSize());
        if (!this.d) {
            ViewGroup.LayoutParams layoutParams = blVar.e.getLayoutParams();
            layoutParams.width = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds30);
            blVar.e.setLayoutParams(layoutParams);
            blVar.e.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = blVar.e.getLayoutParams();
            layoutParams2.width = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds60);
            blVar.e.setLayoutParams(layoutParams2);
            blVar.e.setVisibility(0);
        }
        blVar.l.a(this.c, false);
        blVar.l.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
        blVar.l.setOnImageClickListener(this.l);
        blVar.l.setOnEmotionClickListener(this.m);
        blVar.r = (UserIconBox) inflate.findViewById(com.baidu.tieba.v.user_icon_box);
        blVar.r.setOnClickListener(this.i);
        blVar.t = (UserIconBox) inflate.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        blVar.t.setOnClickListener(this.j);
        blVar.u = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.add_post_footer_layout);
        inflate.setTag(blVar);
        if (z) {
            blVar.p.setVisibility(8);
            blVar.k.setVisibility(8);
            blVar.l.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) blVar.l.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            blVar.l.setLayoutParams(layoutParams3);
            inflate.findViewById(com.baidu.tieba.v.pb_list_item_layout).setPadding(0, 0, 0, 0);
            blVar.w = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.add_time_container);
            blVar.v = (TextView) inflate.findViewById(com.baidu.tieba.v.add_time);
            blVar.x = (Button) inflate.findViewById(com.baidu.tieba.v.manage_btn);
            blVar.w.setVisibility(0);
        }
        blVar.y = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.addition_more_container);
        blVar.z = (TextView) blVar.y.findViewById(com.baidu.tieba.v.addition_more);
        blVar.A = blVar.y.findViewById(com.baidu.tieba.v.addition_divider1);
        blVar.B = blVar.y.findViewById(com.baidu.tieba.v.addition_divider2);
        blVar.s = (BaobaoTailView) inflate.findViewById(com.baidu.tieba.v.baobao_tail);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x047a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0989  */
    /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bl blVar, com.baidu.tieba.data.am amVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        ImageView imageView;
        LinearLayout linearLayout;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ImageView imageView2;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        if (blVar != null && amVar != null) {
            if (!z) {
                blVar.e.setTag(null);
                blVar.e.setUserId(null);
                blVar.f.setText((CharSequence) null);
                blVar.g.setText((CharSequence) null);
                blVar.g.setBackgroundDrawable(null);
                blVar.q.setVisibility(0);
                blVar.k.setVisibility(0);
                blVar.j.setVisibility(8);
                if (amVar.r() == null) {
                    blVar.s.setVisibility(8);
                } else if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && amVar.r().d() == 1) {
                    blVar.s.a(this.s);
                    blVar.s.setVisibility(0);
                    blVar.s.setData(amVar.r());
                } else {
                    blVar.s.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) blVar.p.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    blVar.p.setTag(sparseArray2);
                    blVar.l.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.v.tag_clip_board, amVar);
                sparseArray2.put(com.baidu.tieba.v.tag_is_subpb, false);
                if (TextUtils.isEmpty(amVar.q()) || !this.c) {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    blVar.l.setLayoutParams(layoutParams);
                    blVar.l.setPadding(0, 0, 0, 0);
                    blVar.l.a((String) null);
                } else {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, amVar.q());
                    blVar.l.a(amVar.q());
                    if (amVar.m() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) blVar.l.getLayoutParams();
                        layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds16);
                        layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds40);
                        blVar.l.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) blVar.l.getLayoutParams();
                        layoutParams3.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds20);
                        layoutParams3.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds20);
                        blVar.l.setLayoutParams(layoutParams3);
                    }
                }
                blVar.i.setText(com.baidu.tbadk.core.util.bm.a(amVar.n()));
                if (amVar.m() == 1) {
                    if (this.s == 1) {
                        blVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_d_1));
                    } else {
                        blVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_d));
                    }
                    blVar.b.setVisibility(8);
                    blVar.c.setVisibility(8);
                    blVar.p.setVisibility(8);
                    blVar.i.setVisibility(8);
                    if (this.e) {
                        PraiseData o = this.a.c().o();
                        if (o != null && o.getUser() != null && o.getUser().size() > 0) {
                            blVar.n.setVisibility(0);
                            blVar.m.setVisibility(0);
                            blVar.o.setVisibility(0);
                            blVar.n.setIsFromPb(true);
                            blVar.n.a(o, this.a.c().p(), o.getPostId(), true);
                            blVar.n.a(this.s);
                        } else {
                            blVar.n.setVisibility(8);
                            blVar.m.setVisibility(8);
                            blVar.o.setVisibility(8);
                        }
                    } else {
                        blVar.n.setVisibility(8);
                        blVar.m.setVisibility(8);
                        blVar.o.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) blVar.l.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds30);
                    ((LinearLayout.LayoutParams) blVar.s.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds30);
                } else {
                    if (this.s == 1) {
                        blVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_e_1));
                    } else {
                        blVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_e));
                    }
                    if (i == 1) {
                        if (this.e) {
                            blVar.b.setVisibility(8);
                            blVar.c.setVisibility(8);
                            PraiseData o2 = this.a.c().o();
                            if (o2 != null && o2.getUser() != null && o2.getUser().size() > 0) {
                                blVar.c.setVisibility(8);
                                blVar.b.setVisibility(0);
                            } else {
                                blVar.c.setVisibility(0);
                                blVar.b.setVisibility(8);
                            }
                        } else {
                            blVar.b.setVisibility(0);
                            blVar.c.setVisibility(8);
                        }
                    } else {
                        blVar.b.setVisibility(0);
                        blVar.c.setVisibility(8);
                    }
                    blVar.n.setVisibility(8);
                    blVar.m.setVisibility(8);
                    blVar.o.setVisibility(8);
                    blVar.p.setVisibility(0);
                    blVar.i.setVisibility(0);
                    String format = String.format(this.b.getString(com.baidu.tieba.y.is_floor), Integer.valueOf(amVar.m()));
                    blVar.h.setVisibility(0);
                    blVar.h.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) blVar.l.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) blVar.s.getLayoutParams();
                    if (!this.d) {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds74);
                        layoutParams5.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds104);
                        layoutParams5.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds104);
                    }
                    linearLayout3 = blVar.I;
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.d) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds30);
                    }
                }
                if (this.g != null && !this.g.equals("0") && this.g.equals(amVar.o().getUserId())) {
                    blVar.j.setVisibility(0);
                    if (this.s == 1) {
                        blVar.j.setImageResource(com.baidu.tieba.u.icon_floorhost_1);
                    } else {
                        blVar.j.setImageResource(com.baidu.tieba.u.icon_floorhost);
                    }
                }
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                blVar.d.setBackgroundResource(com.baidu.tieba.u.bg_floor_new_middle_1);
                blVar.l.setVideoImageId(com.baidu.tieba.u.pic_video_1);
                blVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.pb_listitem_content_1));
                blVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector_1);
                blVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
            } else {
                blVar.d.setBackgroundResource(com.baidu.tieba.u.bg_floor_new_middle);
                blVar.l.setVideoImageId(com.baidu.tieba.u.pic_video);
                blVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.pb_listitem_content));
                blVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector);
                blVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) blVar.k.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                blVar.k.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, amVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_data, amVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_view, view);
            if (amVar.t() > 0 && amVar.i() != null && amVar.i().size() > 0) {
                if (this.n == null) {
                    this.n = new com.baidu.tieba.pb.sub.b(this.b, this.h);
                    this.n.a(this.v);
                    this.n.a(this.q);
                    boolean z7 = false;
                    String userId = this.a.c().y().getUserId();
                    if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.n.a(this.a.k(), z7);
                    this.n.b(this.d);
                }
                blVar.q.setVisibility(0);
                imageView2 = blVar.J;
                imageView2.setVisibility(0);
                linearLayout2 = blVar.I;
                linearLayout2.setVisibility(0);
                blVar.q.a(amVar, view);
                blVar.q.setChildOnClickListener(this.k);
                blVar.q.setChildOnLongClickListener(this.o);
                blVar.q.setChildOnTouchListener(this.p);
                blVar.q.setSubPbAdapter(this.n);
                blVar.q.setVisibility(0);
            } else {
                blVar.q.setVisibility(8);
                imageView = blVar.J;
                imageView.setVisibility(8);
                linearLayout = blVar.I;
                linearLayout.setVisibility(8);
            }
            a(blVar, amVar, this.a.m(), i);
            if (!z) {
                String portrait = amVar.o().getPortrait();
                if (amVar.o() != null) {
                    blVar.f.setText(amVar.o().getName_show());
                    LinkedList<IconData> tShowInfo = amVar.o().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        if (this.s == 1) {
                            blVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_h_1));
                        } else {
                            blVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_h));
                        }
                    } else if (this.s == 1) {
                        blVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f_1));
                    } else {
                        blVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
                    }
                    int level_id = amVar.o().getLevel_id();
                    int is_bawu = amVar.o().getIs_bawu();
                    String bawu_type = amVar.o().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        blVar.g.setVisibility(0);
                        blVar.g.setText(String.valueOf(level_id));
                        blVar.g.setBackgroundResource(com.baidu.tbadk.core.util.h.b(level_id));
                        i2 = 2;
                        blVar.g.setOnClickListener(null);
                    } else {
                        blVar.g.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            blVar.g.setText((CharSequence) null);
                            blVar.g.setBackgroundResource(this.s == 1 ? com.baidu.tieba.u.pb_manager_1 : com.baidu.tieba.u.pb_manager);
                            blVar.g.setOnClickListener(this.i);
                        } else if (bawu_type.equals("assist")) {
                            blVar.g.setText((CharSequence) null);
                            blVar.g.setBackgroundResource(this.s == 1 ? com.baidu.tieba.u.pb_assist_1 : com.baidu.tieba.u.pb_assist);
                            blVar.g.setOnClickListener(this.i);
                        }
                    }
                    this.t = amVar.o().getIconInfo();
                    this.u = amVar.o().getTShowInfo();
                    if (blVar.r != null) {
                        blVar.r.setOnClickListener(this.i);
                        blVar.r.a(this.t, i2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                    }
                    if (blVar.t != null) {
                        blVar.t.setOnClickListener(this.j);
                        blVar.t.a(this.u, 3, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                    }
                }
                blVar.e.setUserId(amVar.o().getUserId());
                blVar.e.setImageBitmap(null);
                blVar.f.setTag(amVar.o().getUserId());
                blVar.e.setDefaultResource(com.baidu.tieba.u.photo);
                blVar.e.a(portrait, 12, false);
            }
            if (this.s == 1) {
                blVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
                blVar.l.setDefaultGifId(com.baidu.tieba.u.pic_expression_upload_selector_1);
                if (this.c) {
                    blVar.l.setDefaultImageId(com.baidu.tieba.u.pic_baidu_logo_d_1);
                    blVar.l.setShowEmotion(true);
                } else {
                    blVar.l.setDefaultImageId(com.baidu.tieba.u.icon_click_1);
                    blVar.l.setShowEmotion(false);
                }
            } else {
                blVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text));
                blVar.l.setDefaultGifId(com.baidu.tieba.u.pic_expression_upload_selector);
                if (this.c) {
                    blVar.l.setDefaultImageId(com.baidu.tieba.u.pic_baidu_logo_d);
                    blVar.l.setShowEmotion(true);
                } else {
                    blVar.l.setDefaultImageId(com.baidu.tieba.u.icon_click);
                    blVar.l.setShowEmotion(false);
                }
            }
            blVar.l.setIsFromCDN(this.v);
            if (this.w || !this.x) {
                blVar.l.a(amVar.p(), false);
            } else {
                blVar.l.a(amVar.p(), true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.a.k() != 0) {
                z8 = true;
                z9 = true;
                String userId2 = amVar.o().getUserId();
                if (userId2 != null && userId2.equals(TbadkApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                    if (z2 || !z3) {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                            if (blVar.x != null) {
                                blVar.x.setVisibility(0);
                                blVar.x.setText(com.baidu.tieba.y.delete);
                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                    blVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_delete_n_1, 0, 0, 0);
                                    z6 = true;
                                } else {
                                    blVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_delete_n, 0, 0, 0);
                                    z6 = true;
                                }
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                            if (blVar.x != null) {
                                blVar.x.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    } else {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                        if (blVar.x != null) {
                            blVar.x.setVisibility(0);
                            blVar.x.setText(com.baidu.tieba.y.manage);
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                blVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_manage_n_1, 0, 0, 0);
                                z6 = true;
                            } else {
                                blVar.x.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_manage_n, 0, 0, 0);
                                z6 = true;
                            }
                        }
                        z6 = z5;
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (amVar.m() == 1) {
                        i3 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.a.k()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, amVar.l());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, amVar.o().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, "");
                    }
                    if (z) {
                        blVar.k.setVisibility(8);
                        if (this.s == 1) {
                            blVar.v.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.subpb_listitem_time_1));
                        } else {
                            blVar.v.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.subpb_listitem_time));
                        }
                        blVar.v.setText(String.format(this.b.getResources().getString(com.baidu.tieba.y.write_addition_update), com.baidu.tbadk.core.util.bm.a(amVar.n())));
                        if (blVar.x.getVisibility() == 0) {
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                blVar.x.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
                            } else {
                                blVar.x.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text));
                            }
                            blVar.x.setTag(sparseArray);
                            blVar.x.setOnClickListener(this.q);
                            return;
                        }
                        return;
                    }
                    return;
                }
                z2 = z9;
                z3 = z8;
                z4 = false;
                if (z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i32 = 1;
                if (z) {
                }
                if (amVar.m() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                if (z3) {
                }
                if (z) {
                }
            } else {
                String userId3 = this.a.c().y().getUserId();
                if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = amVar.o().getUserId();
                    if (userId4 != null && userId4.equals(TbadkApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = false;
                        z4 = true;
                    }
                    z2 = z9;
                    z3 = z8;
                    z4 = false;
                }
                if (z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i322 = 1;
                if (z) {
                }
                if (amVar.m() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                if (z3) {
                }
                if (z) {
                }
            }
        }
    }

    public void a(com.baidu.tbadk.widget.richText.s sVar) {
        this.l = sVar;
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.m = rVar;
    }

    public void d(boolean z) {
        this.v = z;
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.s.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.s.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.s.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.s.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }

    private void a(bl blVar, com.baidu.tieba.data.am amVar, AdditionData additionData, int i) {
        if (amVar.u() > 0 && amVar.k() != null) {
            blVar.u.setVisibility(0);
            blVar.u.removeViews(0, blVar.u.getChildCount() - 1);
            int size = amVar.k().size();
            int v = amVar.v();
            for (int i2 = 0; i2 < v; i2++) {
                com.baidu.tieba.data.am amVar2 = amVar.k().get(i2);
                View a = a((ViewGroup) blVar.u, true);
                bl blVar2 = (bl) a.getTag();
                a(blVar2, amVar2, blVar.u, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, amVar2);
                sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
                if (TextUtils.isEmpty(amVar2.q()) || !this.c) {
                    sparseArray.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    blVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar2.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    blVar2.l.setLayoutParams(layoutParams);
                    blVar2.l.setPadding(0, 0, 0, 0);
                    blVar.l.a((String) null);
                } else {
                    blVar.l.a(amVar.q());
                    blVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) blVar2.l.getLayoutParams();
                    layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds16);
                    layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds36);
                    blVar2.l.setLayoutParams(layoutParams2);
                }
                blVar.u.addView(a, blVar.u.getChildCount() - 1);
            }
            if (v < size) {
                blVar.y.setVisibility(0);
                if (this.s == 1) {
                    blVar.A.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b_1);
                    blVar.B.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b_1);
                    blVar.z.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f_1));
                } else {
                    blVar.A.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b);
                    blVar.B.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b);
                    blVar.z.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
                }
                blVar.y.setOnClickListener(new bk(this, v, size, amVar));
                return;
            }
            blVar.y.setVisibility(8);
            return;
        }
        blVar.u.setVisibility(8);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((com.baidu.tieba.data.am) getItem(i)) instanceof com.baidu.tieba.data.ah ? 1 : 0;
    }

    private void g() {
        if (this.z) {
            this.z = false;
            ArrayList<com.baidu.tieba.data.am> d = this.a.d();
            ArrayList<com.baidu.tieba.data.ah> o = this.a.o();
            int size = o.size();
            if (d != null && d.size() != 0 && size != 0) {
                if (this.a.n() != null) {
                    d.remove(this.a.n());
                }
                for (int i = 0; i < 3; i++) {
                    com.baidu.tieba.data.ah ahVar = o.get(new Random(System.currentTimeMillis()).nextInt(size));
                    String b = ahVar.b();
                    String d2 = ahVar.d();
                    if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(d2)) {
                        boolean z = !com.baidu.tieba.util.r.a(com.baidu.tieba.ai.c().e(), d2);
                        if (System.currentTimeMillis() - com.baidu.tbadk.i.a().a(d2, 0L) < 86400000) {
                            z &= false;
                        }
                        if (z) {
                            int a = ahVar.a();
                            int size2 = d.size();
                            int i2 = a - 1;
                            if (i2 >= 1 && i2 < size2) {
                                d.add(i2, ahVar);
                                this.a.a(ahVar);
                                TiebaStatic.eventStat(this.b, "pb_show_app", "", 1, "app_name", ahVar.d());
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }
}
