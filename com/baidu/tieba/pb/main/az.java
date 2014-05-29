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
import com.baidu.tbadk.core.frameworkData.MessageTypes;
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
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public class az extends BaseAdapter {
    private boolean A;
    private final CustomMessageListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private Context b;
    private final boolean y;
    private String z;
    private com.baidu.tieba.data.af a = null;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private int f = 0;
    private String g = null;
    private com.baidu.tbadk.editortool.ab h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private View.OnClickListener k = null;
    private View.OnClickListener l = null;
    private com.baidu.tbadk.widget.richText.s m = null;
    private com.baidu.tbadk.widget.richText.r n = null;
    private com.baidu.tieba.pb.sub.b o = null;
    private View.OnLongClickListener p = null;
    private com.baidu.tieba.b.a q = null;
    private View.OnClickListener r = null;
    private int s = -1;
    private int t = 0;
    private LinkedList<IconData> u = null;
    private LinkedList<IconData> v = null;
    private boolean w = false;
    private boolean x = false;

    public az(Context context) {
        boolean z = false;
        this.b = null;
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16) {
            z = true;
        }
        this.y = z;
        this.z = "[rec]";
        this.A = true;
        this.B = new ba(this, MessageTypes.CMD_FILE_DOWNLOAD);
        this.C = new bb(this);
        this.D = new bc(this);
        this.b = context;
        f();
    }

    private void f() {
        this.f = Math.min(com.baidu.adp.lib.util.k.a(this.b, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        g();
        this.t = TbadkApplication.m252getInst().getSkinType();
        if (this.b instanceof BaseActivity) {
            ((BaseActivity) this.b).registerListener(this.B);
        }
    }

    private void g() {
        this.h = new com.baidu.tbadk.editortool.ab(this.b);
        this.h.f("pb");
        this.h.a(this.f, (int) (this.f * 1.6f));
    }

    public void a(com.baidu.tieba.data.af afVar) {
        this.a = afVar;
        i();
        if (afVar.d() != null && afVar.d().y() != null) {
            this.g = afVar.d().y().getUserId();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public com.baidu.tbadk.editortool.ab a() {
        return this.h;
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

    public void e(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.p = onLongClickListener;
    }

    public View.OnLongClickListener b() {
        return this.p;
    }

    public void a(com.baidu.tieba.b.a aVar) {
        this.q = aVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.e() == null || this.a.e().size() < 1) {
            return 0;
        }
        com.baidu.tieba.data.ai aiVar = this.a.e().get(this.a.e().size() - 1);
        if (!this.e && aiVar.m() == 1) {
            return this.a.e().size() - 1;
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

    public void b(boolean z) {
        this.c = z;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.s;
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
        this.t = TbadkApplication.m252getInst().getSkinType();
        if (view == null) {
            view = h();
        }
        bi biVar = (bi) view.getTag();
        com.baidu.tieba.data.ae aeVar = (com.baidu.tieba.data.ae) getItem(i);
        Resources resources = ((PbActivity) this.b).getResources();
        if (this.t == 1) {
            biVar.D.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_b_1));
            biVar.F.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i_1));
            biVar.F.setBackgroundResource(com.baidu.tieba.u.btn_appdownload_1);
            biVar.B.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b_1);
        } else {
            biVar.D.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_b));
            biVar.F.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i));
            biVar.F.setBackgroundResource(com.baidu.tieba.u.btn_appdownload);
            biVar.B.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.z) + " " + aeVar.c() + "【" + aeVar.b() + "】");
        spannableStringBuilder.setSpan(new ImageSpan(this.b, com.baidu.tieba.u.icon_extend), 0, this.z.length(), 17);
        biVar.D.setText(spannableStringBuilder);
        if (!TextUtils.isEmpty(aeVar.g()) && com.baidu.tbadk.core.g.a().f()) {
            biVar.E.a(aeVar.g(), 17, false);
        } else {
            biVar.E.setVisibility(8);
        }
        biVar.F.setTag(Integer.valueOf(i));
        boolean b = com.baidu.tieba.frs.b.a().b(aeVar.d());
        boolean c = com.baidu.tieba.frs.b.a().c(aeVar.d());
        if (b) {
            aeVar.a(1);
        } else if (c) {
            aeVar.a(2);
        } else {
            aeVar.a(0);
        }
        if (!TextUtils.isEmpty(aeVar.e())) {
            switch (aeVar.h()) {
                case 0:
                    biVar.F.setText(com.baidu.tieba.y.pb_app_download);
                    biVar.F.setOnClickListener(this.C);
                    biVar.C.setOnClickListener(this.D);
                    biVar.F.setEnabled(true);
                    break;
                case 1:
                    biVar.F.setText(com.baidu.tieba.y.downloading2);
                    biVar.F.setOnClickListener(null);
                    biVar.C.setOnClickListener(null);
                    biVar.F.setEnabled(false);
                    break;
                case 2:
                    biVar.F.setText(com.baidu.tieba.y.downloaded);
                    biVar.F.setOnClickListener(this.C);
                    biVar.C.setOnClickListener(this.D);
                    biVar.F.setEnabled(true);
                    break;
            }
        } else {
            biVar.F.setText(com.baidu.tieba.y.pb_app_see);
            biVar.F.setOnClickListener(new be(this, aeVar));
            biVar.C.setOnClickListener(new bf(this, aeVar));
        }
        return view;
    }

    public void a(com.baidu.tieba.data.ae aeVar, int i) {
        if (!((TextUtils.isEmpty(aeVar.d()) || TextUtils.isEmpty(aeVar.b())) ? false : true)) {
            com.baidu.adp.lib.util.k.a(this.b, com.baidu.tieba.y.pb_app_error);
        } else if (UtilHelper.isNetOk()) {
            com.baidu.tbadk.f.a().b(aeVar.d(), System.currentTimeMillis());
            aeVar.a(1);
            notifyDataSetChanged();
            new com.baidu.tbadk.core.util.az("", "pb_dl", aeVar.d()).start();
            com.baidu.tieba.frs.b.a().a(aeVar.d(), aeVar.e(), aeVar.b(), i);
        } else {
            com.baidu.adp.lib.util.k.a(this.b, com.baidu.tieba.y.neterror);
        }
    }

    public void a(com.baidu.tieba.data.ae aeVar) {
        String d = aeVar.d();
        if (TextUtils.isEmpty(d)) {
            com.baidu.adp.lib.util.k.a(this.b, com.baidu.tieba.y.pb_app_error);
            return;
        }
        com.baidu.tbadk.f.a().b(aeVar.d(), System.currentTimeMillis());
        File d2 = com.baidu.tbadk.core.util.x.d(String.valueOf(d.replace(".", "_")) + ".apk");
        if (d2 != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d2), "application/vnd.android.package-archive");
            this.b.startActivity(intent);
        }
    }

    private View h() {
        bi biVar = new bi(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.pb_item_app, (ViewGroup) null);
        biVar.C = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.recommend_app_container);
        biVar.D = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_app);
        biVar.E = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_img);
        biVar.F = (Button) inflate.findViewById(com.baidu.tieba.v.recommend_btn);
        biVar.B = inflate.findViewById(com.baidu.tieba.v.divider_line);
        inflate.setTag(biVar);
        return inflate;
    }

    private View b(View view, ViewGroup viewGroup, int i) {
        ImageView imageView;
        BdListView a;
        ImageView imageView2;
        this.t = TbadkApplication.m252getInst().getSkinType();
        View a2 = view == null ? a(viewGroup, false) : view;
        bi biVar = (bi) a2.getTag();
        com.baidu.tieba.data.ai aiVar = (com.baidu.tieba.data.ai) getItem(i);
        PbActivity pbActivity = (PbActivity) this.b;
        Resources resources = pbActivity.getResources();
        if (this.t == 1) {
            biVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b_1));
            biVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b_1));
            if (biVar.u != null) {
                biVar.u.setTextColor(resources.getColor(com.baidu.tieba.s.subpb_listitem_time_1));
            }
            if (biVar.w != null) {
                biVar.w.setTextColor(resources.getColor(com.baidu.tieba.s.common_link_text_1));
            }
            biVar.f.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_f_1));
            biVar.g.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i_1));
            biVar.h.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d_1));
            biVar.i.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d_1));
            biVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector_1);
            biVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b_1));
            biVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e_1));
            biVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e_1));
            biVar.o.setImageResource(com.baidu.tieba.s.cp_bg_line_b_1);
            imageView2 = biVar.I;
            imageView2.setImageResource(com.baidu.tieba.s.cp_bg_line_b_1);
        } else {
            biVar.b.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b));
            biVar.c.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b));
            if (biVar.u != null) {
                biVar.u.setTextColor(resources.getColor(com.baidu.tieba.s.subpb_listitem_time));
            }
            if (biVar.w != null) {
                biVar.w.setTextColor(resources.getColor(com.baidu.tieba.s.common_link_text));
            }
            biVar.f.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_f));
            biVar.g.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_i));
            biVar.h.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d));
            biVar.i.setTextColor(resources.getColor(com.baidu.tieba.s.cp_cont_d));
            biVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector);
            biVar.m.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_b));
            biVar.n.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e));
            biVar.o.setBackgroundColor(resources.getColor(com.baidu.tieba.s.cp_bg_line_e));
            biVar.o.setImageResource(com.baidu.tieba.s.cp_bg_line_b);
            imageView = biVar.I;
            imageView.setImageResource(com.baidu.tieba.s.cp_bg_line_b);
        }
        if (aiVar != null) {
            a(biVar, aiVar, a2, false, i);
        }
        if (!this.x && this.y && biVar != null && biVar.l.a() && (a = pbActivity.a()) != null) {
            this.x = true;
            CompatibleUtile.getInstance().closeViewGpu(a);
        }
        return a2;
    }

    private View a(ViewGroup viewGroup, boolean z) {
        bi biVar = new bi(this, null);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.new_pb_list_item, viewGroup, false);
        biVar.d = inflate.findViewById(com.baidu.tieba.v.sub_pb_more);
        biVar.e = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
        biVar.f = (TextView) inflate.findViewById(com.baidu.tieba.v.user_name);
        biVar.g = (TextView) inflate.findViewById(com.baidu.tieba.v.user_rank);
        biVar.k = (ImageView) inflate.findViewById(com.baidu.tieba.v.reply);
        biVar.l = (TbRichTextView) inflate.findViewById(com.baidu.tieba.v.richText);
        biVar.m = inflate.findViewById(com.baidu.tieba.v.pb_item_praise_topline);
        biVar.n = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.v.pb_item_praise_view);
        biVar.o = (ImageView) inflate.findViewById(com.baidu.tieba.v.pb_item_praise_bottomline);
        biVar.j = (ImageView) inflate.findViewById(com.baidu.tieba.v.floor_owner);
        biVar.h = (TextView) inflate.findViewById(com.baidu.tieba.v.floor);
        biVar.i = (TextView) inflate.findViewById(com.baidu.tieba.v.time);
        biVar.p = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.pb_post_header_layout);
        biVar.q = (SubPbLayout) inflate.findViewById(com.baidu.tieba.v.pb_post_footer_layout);
        biVar.H = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.pb_subpb_layout_root);
        biVar.I = (ImageView) inflate.findViewById(com.baidu.tieba.v.pb_post_footer_layout_line_top);
        biVar.f.setOnClickListener(this.i);
        biVar.k.setOnClickListener(this.l);
        biVar.e.setOnClickListener(this.i);
        biVar.a = inflate;
        biVar.b = inflate.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top);
        biVar.c = inflate.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top_full);
        biVar.p.setOnLongClickListener(this.p);
        biVar.l.setOnLongClickListener(this.p);
        if (this.s < 0) {
            this.s = (((com.baidu.adp.lib.util.k.b(this.b) - inflate.getPaddingLeft()) - inflate.getPaddingRight()) - biVar.l.getPaddingLeft()) - biVar.l.getPaddingRight();
        }
        biVar.p.setOnTouchListener(this.q);
        biVar.l.setOnTouchListener(this.q);
        this.s = this.f > this.s ? this.s : this.f;
        int dimension = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds104);
        if (this.s > dimension) {
            biVar.l.setMaxImageWidth(this.s - dimension);
        } else {
            biVar.l.setMaxImageWidth(this.s);
        }
        biVar.l.setMaxImageHeight((int) (this.s * 1.618f));
        biVar.l.setTextSize(TbConfig.getContentSize());
        if (!this.d) {
            ViewGroup.LayoutParams layoutParams = biVar.e.getLayoutParams();
            layoutParams.width = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds30);
            biVar.e.setLayoutParams(layoutParams);
            biVar.e.setVisibility(4);
        } else {
            ViewGroup.LayoutParams layoutParams2 = biVar.e.getLayoutParams();
            layoutParams2.width = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds60);
            biVar.e.setLayoutParams(layoutParams2);
            biVar.e.setVisibility(0);
        }
        biVar.l.a(this.c, false);
        biVar.l.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
        biVar.l.setOnImageClickListener(this.m);
        biVar.l.setOnEmotionClickListener(this.n);
        biVar.r = (UserIconBox) inflate.findViewById(com.baidu.tieba.v.user_icon_box);
        biVar.r.setOnClickListener(this.j);
        biVar.s = (UserIconBox) inflate.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        biVar.s.setOnClickListener(this.k);
        biVar.t = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.add_post_footer_layout);
        inflate.setTag(biVar);
        if (z) {
            biVar.p.setVisibility(8);
            biVar.k.setVisibility(8);
            biVar.l.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) biVar.l.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            biVar.l.setLayoutParams(layoutParams3);
            inflate.findViewById(com.baidu.tieba.v.pb_list_item_layout).setPadding(0, 0, 0, 0);
            biVar.v = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.add_time_container);
            biVar.u = (TextView) inflate.findViewById(com.baidu.tieba.v.add_time);
            biVar.w = (Button) inflate.findViewById(com.baidu.tieba.v.manage_btn);
            biVar.v.setVisibility(0);
        }
        biVar.x = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.addition_more_container);
        biVar.y = (TextView) biVar.x.findViewById(com.baidu.tieba.v.addition_more);
        biVar.z = biVar.x.findViewById(com.baidu.tieba.v.addition_divider1);
        biVar.A = biVar.x.findViewById(com.baidu.tieba.v.addition_divider2);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0456 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x08d3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0909  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bi biVar, com.baidu.tieba.data.ai aiVar, View view, boolean z, int i) {
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
        if (biVar != null && aiVar != null) {
            if (!z) {
                biVar.e.setTag(null);
                biVar.e.setUserId(null);
                biVar.f.setText((CharSequence) null);
                biVar.g.setText((CharSequence) null);
                biVar.g.setBackgroundDrawable(null);
                biVar.q.setVisibility(0);
                biVar.k.setVisibility(0);
                biVar.j.setVisibility(8);
                SparseArray sparseArray2 = (SparseArray) biVar.p.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    biVar.p.setTag(sparseArray2);
                    biVar.l.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.v.tag_clip_board, aiVar);
                sparseArray2.put(com.baidu.tieba.v.tag_is_subpb, false);
                if (TextUtils.isEmpty(aiVar.q()) || !this.c) {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) biVar.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    biVar.l.setLayoutParams(layoutParams);
                    biVar.l.setPadding(0, 0, 0, 0);
                    biVar.l.a((String) null);
                } else {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, aiVar.q());
                    biVar.l.a(aiVar.q());
                    if (aiVar.m() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) biVar.l.getLayoutParams();
                        layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds16);
                        layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds40);
                        biVar.l.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) biVar.l.getLayoutParams();
                        layoutParams3.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds20);
                        layoutParams3.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds20);
                        biVar.l.setLayoutParams(layoutParams3);
                    }
                }
                biVar.i.setText(com.baidu.tbadk.core.util.be.a(aiVar.n()));
                if (aiVar.m() == 1) {
                    if (this.t == 1) {
                        biVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_d_1));
                    } else {
                        biVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_d));
                    }
                    biVar.b.setVisibility(8);
                    biVar.c.setVisibility(8);
                    biVar.p.setVisibility(8);
                    biVar.i.setVisibility(8);
                    if (this.e) {
                        PraiseData o = this.a.d().o();
                        if (o != null && o.getUser() != null && o.getUser().size() > 0) {
                            biVar.n.setVisibility(0);
                            biVar.m.setVisibility(0);
                            biVar.o.setVisibility(0);
                            biVar.n.setIsFromPb(true);
                            biVar.n.a(o, this.a.d().p(), o.getPostId(), true);
                            biVar.n.a(this.t);
                        } else {
                            biVar.n.setVisibility(8);
                            biVar.m.setVisibility(8);
                            biVar.o.setVisibility(8);
                        }
                    } else {
                        biVar.n.setVisibility(8);
                        biVar.m.setVisibility(8);
                        biVar.o.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) biVar.l.getLayoutParams()).leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds30);
                } else {
                    if (this.t == 1) {
                        biVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_e_1));
                    } else {
                        biVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_bg_line_e));
                    }
                    if (i == 1) {
                        if (this.e) {
                            biVar.b.setVisibility(8);
                            biVar.c.setVisibility(8);
                            PraiseData o2 = this.a.d().o();
                            if (o2 != null && o2.getUser() != null && o2.getUser().size() > 0) {
                                biVar.c.setVisibility(8);
                                biVar.b.setVisibility(0);
                            } else {
                                biVar.c.setVisibility(0);
                                biVar.b.setVisibility(8);
                            }
                        } else {
                            biVar.b.setVisibility(0);
                            biVar.c.setVisibility(8);
                        }
                    } else {
                        biVar.b.setVisibility(0);
                        biVar.c.setVisibility(8);
                    }
                    biVar.n.setVisibility(8);
                    biVar.m.setVisibility(8);
                    biVar.o.setVisibility(8);
                    biVar.p.setVisibility(0);
                    biVar.i.setVisibility(0);
                    String format = String.format(this.b.getString(com.baidu.tieba.y.is_floor), Integer.valueOf(aiVar.m()));
                    biVar.h.setVisibility(0);
                    biVar.h.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) biVar.l.getLayoutParams();
                    if (!this.d) {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds74);
                    } else {
                        layoutParams4.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds104);
                    }
                    linearLayout3 = biVar.H;
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
                    if (!this.d) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds30);
                    }
                }
                if (this.g != null && !this.g.equals("0") && this.g.equals(aiVar.o().getUserId())) {
                    biVar.j.setVisibility(0);
                    if (this.t == 1) {
                        biVar.j.setImageResource(com.baidu.tieba.u.icon_floorhost_1);
                    } else {
                        biVar.j.setImageResource(com.baidu.tieba.u.icon_floorhost);
                    }
                }
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                biVar.d.setBackgroundResource(com.baidu.tieba.u.bg_floor_new_middle_1);
                biVar.l.setVideoImageId(com.baidu.tieba.u.pic_video_1);
                biVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.pb_listitem_content_1));
                biVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector_1);
                biVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
            } else {
                biVar.d.setBackgroundResource(com.baidu.tieba.u.bg_floor_new_middle);
                biVar.l.setVideoImageId(com.baidu.tieba.u.pic_video);
                biVar.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.pb_listitem_content));
                biVar.k.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector);
                biVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text));
            }
            SparseArray sparseArray3 = (SparseArray) biVar.k.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                biVar.k.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, aiVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_data, aiVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_view, view);
            if (aiVar.s() > 0 && aiVar.i() != null && aiVar.i().size() > 0) {
                if (this.o == null) {
                    this.o = new com.baidu.tieba.pb.sub.b(this.b, this.i);
                    this.o.a(this.w);
                    this.o.a(this.r);
                    boolean z7 = false;
                    String userId = this.a.d().y().getUserId();
                    if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.o.a(this.a.l(), z7);
                    this.o.b(this.d);
                }
                biVar.q.setVisibility(0);
                imageView2 = biVar.I;
                imageView2.setVisibility(0);
                linearLayout2 = biVar.H;
                linearLayout2.setVisibility(0);
                biVar.q.a(aiVar, view);
                biVar.q.setChildOnClickListener(this.l);
                biVar.q.setChildOnLongClickListener(this.p);
                biVar.q.setChildOnTouchListener(this.q);
                biVar.q.setSubPbAdapter(this.o);
                biVar.q.setVisibility(0);
            } else {
                biVar.q.setVisibility(8);
                imageView = biVar.I;
                imageView.setVisibility(8);
                linearLayout = biVar.H;
                linearLayout.setVisibility(8);
            }
            a(biVar, aiVar, this.a.n(), i);
            if (!z) {
                String portrait = aiVar.o().getPortrait();
                if (aiVar.o() != null) {
                    biVar.f.setText(aiVar.o().getName_show());
                    LinkedList<IconData> tShowInfo = aiVar.o().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        if (this.t == 1) {
                            biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_h_1));
                        } else {
                            biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_h));
                        }
                    } else if (this.t == 1) {
                        biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f_1));
                    } else {
                        biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
                    }
                    int level_id = aiVar.o().getLevel_id();
                    int is_bawu = aiVar.o().getIs_bawu();
                    String bawu_type = aiVar.o().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        biVar.g.setVisibility(0);
                        biVar.g.setText(String.valueOf(level_id));
                        biVar.g.setBackgroundResource(com.baidu.tbadk.core.util.g.b(level_id));
                        i2 = 2;
                        biVar.g.setOnClickListener(null);
                    } else {
                        biVar.g.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            biVar.g.setText((CharSequence) null);
                            biVar.g.setBackgroundResource(this.t == 1 ? com.baidu.tieba.u.pb_manager_1 : com.baidu.tieba.u.pb_manager);
                            biVar.g.setOnClickListener(this.j);
                        } else if (bawu_type.equals("assist")) {
                            biVar.g.setText((CharSequence) null);
                            biVar.g.setBackgroundResource(this.t == 1 ? com.baidu.tieba.u.pb_assist_1 : com.baidu.tieba.u.pb_assist);
                            biVar.g.setOnClickListener(this.j);
                        }
                    }
                    this.u = aiVar.o().getIconInfo();
                    this.v = aiVar.o().getTShowInfo();
                    if (biVar.r != null) {
                        biVar.r.setOnClickListener(this.j);
                        biVar.r.a(this.u, i2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                    }
                    if (biVar.s != null) {
                        biVar.s.setOnClickListener(this.k);
                        biVar.s.a(this.v, 3, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                    }
                }
                biVar.e.setUserId(aiVar.o().getUserId());
                biVar.e.setImageBitmap(null);
                biVar.f.setTag(aiVar.o().getUserId());
                biVar.e.setDefaultResource(com.baidu.tieba.u.photo);
                biVar.e.a(portrait, 12, false);
            }
            if (this.t == 1) {
                biVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
                biVar.l.setDefaultGifId(com.baidu.tieba.u.pic_expression_upload_selector_1);
                if (this.c) {
                    biVar.l.setDefaultImageId(com.baidu.tieba.u.pic_baidu_logo_d_1);
                    biVar.l.setShowEmotion(true);
                } else {
                    biVar.l.setDefaultImageId(com.baidu.tieba.u.icon_click_1);
                    biVar.l.setShowEmotion(false);
                }
            } else {
                biVar.l.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text));
                biVar.l.setDefaultGifId(com.baidu.tieba.u.pic_expression_upload_selector);
                if (this.c) {
                    biVar.l.setDefaultImageId(com.baidu.tieba.u.pic_baidu_logo_d);
                    biVar.l.setShowEmotion(true);
                } else {
                    biVar.l.setDefaultImageId(com.baidu.tieba.u.icon_click);
                    biVar.l.setShowEmotion(false);
                }
            }
            biVar.l.setIsFromCDN(this.w);
            if (this.x || !this.y) {
                biVar.l.a(aiVar.p(), false);
            } else {
                biVar.l.a(aiVar.p(), true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.a.l() != 0) {
                z8 = true;
                z9 = true;
                String userId2 = aiVar.o().getUserId();
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
                            if (biVar.w != null) {
                                biVar.w.setVisibility(0);
                                biVar.w.setText(com.baidu.tieba.y.delete);
                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                    biVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_delete_n_1, 0, 0, 0);
                                    z6 = true;
                                } else {
                                    biVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_delete_n, 0, 0, 0);
                                    z6 = true;
                                }
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                            if (biVar.w != null) {
                                biVar.w.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    } else {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                        if (biVar.w != null) {
                            biVar.w.setVisibility(0);
                            biVar.w.setText(com.baidu.tieba.y.manage);
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                biVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_manage_n_1, 0, 0, 0);
                                z6 = true;
                            } else {
                                biVar.w.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.btn_manage_n, 0, 0, 0);
                                z6 = true;
                            }
                        }
                        z6 = z5;
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (aiVar.m() == 1) {
                        i3 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.a.l()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, aiVar.l());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, aiVar.o().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, "");
                    }
                    if (z) {
                        biVar.k.setVisibility(8);
                        if (this.t == 1) {
                            biVar.u.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.subpb_listitem_time_1));
                        } else {
                            biVar.u.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.subpb_listitem_time));
                        }
                        biVar.u.setText(String.format(this.b.getResources().getString(com.baidu.tieba.y.write_addition_update), com.baidu.tbadk.core.util.be.a(aiVar.n())));
                        if (biVar.w.getVisibility() == 0) {
                            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                biVar.w.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
                            } else {
                                biVar.w.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text));
                            }
                            biVar.w.setTag(sparseArray);
                            biVar.w.setOnClickListener(this.r);
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
                if (aiVar.m() == 1) {
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
                String userId3 = this.a.d().y().getUserId();
                if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = aiVar.o().getUserId();
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
                if (aiVar.m() == 1) {
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
        this.m = sVar;
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.n = rVar;
    }

    public void d(boolean z) {
        this.w = z;
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

    private void a(bi biVar, com.baidu.tieba.data.ai aiVar, AdditionData additionData, int i) {
        if (aiVar.t() > 0 && aiVar.k() != null) {
            biVar.t.setVisibility(0);
            biVar.t.removeViews(0, biVar.t.getChildCount() - 1);
            int size = aiVar.k().size();
            int v = aiVar.v();
            for (int i2 = 0; i2 < v; i2++) {
                com.baidu.tieba.data.ai aiVar2 = aiVar.k().get(i2);
                View a = a((ViewGroup) biVar.t, true);
                bi biVar2 = (bi) a.getTag();
                a(biVar2, aiVar2, biVar.t, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, aiVar2);
                sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
                if (TextUtils.isEmpty(aiVar2.q()) || !this.c) {
                    sparseArray.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    biVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) biVar2.l.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    biVar2.l.setLayoutParams(layoutParams);
                    biVar2.l.setPadding(0, 0, 0, 0);
                    biVar.l.a((String) null);
                } else {
                    biVar.l.a(aiVar.q());
                    biVar2.l.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) biVar2.l.getLayoutParams();
                    layoutParams2.topMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds16);
                    layoutParams2.bottomMargin = (int) this.b.getResources().getDimension(com.baidu.tieba.t.ds36);
                    biVar2.l.setLayoutParams(layoutParams2);
                }
                biVar.t.addView(a, biVar.t.getChildCount() - 1);
            }
            if (v < size) {
                biVar.x.setVisibility(0);
                if (this.t == 1) {
                    biVar.z.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b_1);
                    biVar.A.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b_1);
                    biVar.y.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f_1));
                } else {
                    biVar.z.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b);
                    biVar.A.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_b);
                    biVar.y.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
                }
                biVar.x.setOnClickListener(new bh(this, v, size, aiVar));
                return;
            }
            biVar.x.setVisibility(8);
            return;
        }
        biVar.t.setVisibility(8);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((com.baidu.tieba.data.ai) getItem(i)) instanceof com.baidu.tieba.data.ae ? 1 : 0;
    }

    private void i() {
        if (this.A) {
            this.A = false;
            ArrayList<com.baidu.tieba.data.ai> e = this.a.e();
            ArrayList<com.baidu.tieba.data.ae> p = this.a.p();
            int size = p.size();
            if (e != null && e.size() != 0 && size != 0) {
                if (this.a.o() != null) {
                    e.remove(this.a.o());
                }
                for (int i = 0; i < 3; i++) {
                    com.baidu.tieba.data.ae aeVar = p.get(new Random(System.currentTimeMillis()).nextInt(size));
                    String b = aeVar.b();
                    String d = aeVar.d();
                    if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(d)) {
                        boolean z = !com.baidu.tieba.util.r.a(com.baidu.tieba.ai.c().e(), d);
                        if (System.currentTimeMillis() - com.baidu.tbadk.f.a().a(d, 0L) < 86400000) {
                            z &= false;
                        }
                        if (z) {
                            int a = aeVar.a();
                            int size2 = e.size();
                            int i2 = a - 1;
                            if (i2 >= 1 && i2 < size2) {
                                e.add(i2, aeVar);
                                this.a.a(aeVar);
                                TiebaStatic.eventStat(this.b, "pb_show_app", "", 1, "app_name", aeVar.d());
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
