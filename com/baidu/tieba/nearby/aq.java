package com.baidu.tieba.nearby;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NearbyImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aq extends BaseAdapter {
    Context a;
    com.baidu.tieba.c.av b;
    private ArrayList c = new ArrayList();
    private com.baidu.tieba.d.a d;
    private View.OnClickListener e;

    public aq(Context context, com.baidu.tieba.c.av avVar, View.OnClickListener onClickListener) {
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.a = context;
        this.b = avVar;
        this.d = new com.baidu.tieba.d.a(this.a);
        int a = com.baidu.tieba.d.ag.a(this.a, 284.0f);
        int i = a <= 350 ? a : 350;
        this.d.a(i, (int) (i * 2.0f));
        this.e = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.a().size() == 0) {
            return 0;
        }
        return (TiebaApplication.d().aq() ? 2 : 1) + this.b.a().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (TiebaApplication.d().aq()) {
            if (this.b != null && i - 1 >= 0 && i - 1 < this.b.a().size()) {
                return this.b.a().get(i - 1);
            }
        } else if (this.b != null && i >= 0 && i < this.b.a().size()) {
            return this.b.a().get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.b == null) {
            return 0;
        }
        return TiebaApplication.d().aq() ? 4 : 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0 && TiebaApplication.d().aq()) {
            return 3;
        }
        if (getItem(i) != null) {
            if (((com.baidu.tieba.c.aw) getItem(i)).a() == 3) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0410: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:93:0x040f */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        au auVar;
        View view4;
        as asVar;
        int i2;
        TextView textView;
        Bitmap a;
        at atVar = null;
        try {
            int itemViewType = getItemViewType(i);
            int ar = TiebaApplication.d().ar();
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (itemViewType == 3) {
                        view4 = from.inflate(R.layout.local_popularize, (ViewGroup) null);
                        ImageView imageView = (ImageView) view4.findViewById(R.id.img_local_popularize);
                        com.baidu.adp.widget.a.b c = com.baidu.tbadk.a.e.a().c("lbs_local_banner");
                        if (c == null) {
                            if (com.baidu.adp.lib.e.c.b(this.a, "com.baidu.tieba.local")) {
                                a = com.baidu.tieba.d.d.a((int) R.drawable.lbs_local_banner2);
                            } else {
                                a = com.baidu.tieba.d.d.a((int) R.drawable.lbs_local_banner1);
                            }
                            c = new com.baidu.adp.widget.a.b(a, false);
                            com.baidu.tbadk.a.e.a().b("lbs_local_banner", c);
                        }
                        c.b(imageView);
                        imageView.setOnClickListener(new ar(this));
                        auVar = null;
                        asVar = null;
                    } else if (itemViewType == 0) {
                        view4 = from.inflate(R.layout.distance_node, (ViewGroup) null);
                        as asVar2 = new as(this);
                        asVar2.b = (TextView) view4.findViewById(R.id.distance_text);
                        asVar2.a = (ImageView) view4.findViewById(R.id.distance_icon);
                        view4.setTag(asVar2);
                        auVar = null;
                        asVar = asVar2;
                    } else if (itemViewType == 1) {
                        view4 = from.inflate(R.layout.nearby_post_node, (ViewGroup) null);
                        au auVar2 = new au(this);
                        auVar2.a = (LinearLayout) view4.findViewById(R.id.nearby_post_layout);
                        auVar2.a.setOnClickListener(this.e);
                        auVar2.b = (TextView) view4.findViewById(R.id.content_text);
                        auVar2.c = (NearbyImageView) view4.findViewById(R.id.content_image);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) auVar2.c.getLayoutParams();
                        layoutParams.width = com.baidu.tieba.d.ag.a(this.a, 284.0f);
                        if (layoutParams.width > 350) {
                            layoutParams.width = 350;
                        }
                        layoutParams.height = (int) (layoutParams.width * 2.0f);
                        auVar2.c.setLayoutParams(layoutParams);
                        auVar2.c.setFocusable(false);
                        auVar2.c.setScaleType(ImageView.ScaleType.CENTER);
                        auVar2.d = (ImageView) view4.findViewById(R.id.div_post);
                        auVar2.e = (ImageView) view4.findViewById(R.id.author_photo);
                        auVar2.f = (TextView) view4.findViewById(R.id.author_name);
                        auVar2.e.setOnClickListener(this.e);
                        auVar2.f.setOnClickListener(this.e);
                        auVar2.g = (TextView) view4.findViewById(R.id.post_time);
                        auVar2.h = (Button) view4.findViewById(R.id.comment_btn);
                        auVar2.h.setOnClickListener(this.e);
                        auVar2.i = (LinearLayout) view4.findViewById(R.id.nearby_reply_layout);
                        auVar2.i.setOnClickListener(this.e);
                        auVar2.j = (LinearLayout) view4.findViewById(R.id.more_reply_layout);
                        auVar2.k = (ImageView) view4.findViewById(R.id.points);
                        auVar2.l = (ImageView) view4.findViewById(R.id.div_reply);
                        auVar2.m = (TextView) view4.findViewById(R.id.view_more_reply);
                        auVar2.n = (ImageView) view4.findViewById(R.id.replyer_photo);
                        auVar2.o = (TextView) view4.findViewById(R.id.reply_content);
                        auVar2.p = (TextView) view4.findViewById(R.id.reply_time);
                        view4.setTag(auVar2);
                        auVar = auVar2;
                        asVar = null;
                    } else {
                        if (itemViewType == 2) {
                            view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                            atVar = new at(this);
                            atVar.a = (TextView) view4.findViewById(R.id.page_text);
                            atVar.b = (ProgressBar) view4.findViewById(R.id.progress);
                            view4.setTag(atVar);
                            this.c.add(atVar.b);
                            auVar = null;
                            asVar = null;
                        }
                        auVar = null;
                        view4 = view;
                        asVar = null;
                    }
                } else if (itemViewType == 0) {
                    auVar = null;
                    view4 = view;
                    asVar = (as) view.getTag();
                } else if (itemViewType == 1) {
                    auVar = (au) view.getTag();
                    asVar = null;
                    view4 = view;
                } else {
                    if (itemViewType == 2) {
                        atVar = (at) view.getTag();
                        auVar = null;
                        view4 = view;
                        asVar = null;
                    }
                    auVar = null;
                    view4 = view;
                    asVar = null;
                }
                com.baidu.tieba.c.aw awVar = (com.baidu.tieba.c.aw) getItem(i);
                if (itemViewType == 0) {
                    asVar.b.setText(awVar.b());
                    if (ar == 1) {
                        asVar.a.setBackgroundResource(R.drawable.icon_distance_node_1);
                        return view4;
                    }
                    asVar.a.setBackgroundResource(R.drawable.icon_distance_node);
                    return view4;
                } else if (itemViewType == 1) {
                    auVar.c.setVisibility(8);
                    auVar.b.setVisibility(8);
                    if (awVar.a() == 0) {
                        auVar.a.setEnabled(true);
                        auVar.a.setTag(R.id.tag_nearby_thread_id, awVar.h());
                        auVar.a.setTag(R.id.tag_nearby_url, "");
                        auVar.a.setTag(R.id.tag_nearby_guid_post, false);
                    } else {
                        auVar.a.setTag(R.id.tag_nearby_thread_id, "");
                        auVar.a.setTag(R.id.tag_nearby_url, awVar.q());
                        if (awVar.a() == 1) {
                            auVar.a.setTag(R.id.tag_nearby_guid_post, true);
                        } else {
                            auVar.a.setTag(R.id.tag_nearby_guid_post, false);
                        }
                        if (awVar.q().equals("")) {
                            auVar.a.setEnabled(false);
                        } else {
                            auVar.a.setEnabled(true);
                        }
                    }
                    ArrayList c2 = awVar.c();
                    if (c2 != null) {
                        TextView textView2 = null;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= c2.size()) {
                                break;
                            }
                            com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) c2.get(i3);
                            if (kVar.a() == 0 || kVar.a() == 2) {
                                if (textView2 == null) {
                                    TextView textView3 = auVar.b;
                                    if (kVar.a() == 0) {
                                        textView3.setText(kVar.d());
                                        textView = textView3;
                                    } else {
                                        textView3.setText(kVar.a(this.a, textView3.getLineHeight(), (int) textView3.getTextSize()));
                                        textView = textView3;
                                    }
                                } else if (kVar.a() == 0) {
                                    textView2.append(kVar.d());
                                    textView = textView2;
                                } else {
                                    textView2.append(kVar.a(this.a, textView2.getLineHeight(), (int) textView2.getTextSize()));
                                    textView = textView2;
                                }
                                auVar.b.setVisibility(0);
                            } else if (kVar.a() == 3) {
                                int b = kVar.b();
                                int c3 = kVar.c();
                                int i4 = 350;
                                int i5 = (int) (350 * 2.0f);
                                if (b > 350) {
                                    c3 = (c3 * 350) / b;
                                } else {
                                    i4 = b;
                                }
                                if (c3 > i5) {
                                    i4 = (i4 * i5) / c3;
                                    c3 = i5;
                                }
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) auVar.c.getLayoutParams();
                                layoutParams2.width = i4;
                                layoutParams2.height = c3;
                                auVar.c.setLayoutParams(layoutParams2);
                                auVar.c.setTag(kVar.f());
                                auVar.c.setVisibility(0);
                            } else {
                                textView = textView2;
                            }
                            i3++;
                            textView2 = textView;
                        }
                    }
                    auVar.g.setText(awVar.f());
                    if (awVar.l() != null) {
                        auVar.f.setText(awVar.l().d());
                        auVar.f.setTag(R.id.tag_nearby_person_id, awVar.l().a());
                        auVar.f.setTag(R.id.tag_nearby_person_name, awVar.l().c());
                        String e = awVar.l().e();
                        com.baidu.adp.widget.a.b bVar = null;
                        if (e != null && e.length() > 0) {
                            bVar = this.d.b(e);
                            if (bVar != null) {
                                bVar.b(auVar.e);
                            } else {
                                auVar.e.setTag(e);
                            }
                        }
                        if (bVar == null) {
                            auVar.e.setImageBitmap(com.baidu.tieba.d.d.a((int) R.drawable.photo));
                        }
                        auVar.e.setTag(R.id.tag_nearby_person_id, awVar.l().a());
                        auVar.e.setTag(R.id.tag_nearby_person_name, awVar.l().c());
                    }
                    if (awVar.a() == 0) {
                        auVar.h.setTag(R.id.tag_nearby_thread_id, awVar.h());
                        auVar.h.setTag(R.id.tag_nearby_forum_id, awVar.i());
                        auVar.h.setTag(R.id.tag_nearby_forum_name, awVar.j());
                        auVar.h.setVisibility(0);
                    } else {
                        auVar.h.setVisibility(8);
                    }
                    if (awVar.d() == 0) {
                        auVar.i.setVisibility(8);
                    } else {
                        auVar.i.setVisibility(0);
                        auVar.i.setTag(R.id.tag_nearby_thread_id, awVar.h());
                        auVar.i.setTag(R.id.tag_nearby_url, "");
                        if (awVar.d() == 1) {
                            auVar.j.setVisibility(8);
                            auVar.l.setVisibility(8);
                        } else {
                            auVar.l.setVisibility(0);
                            auVar.j.setVisibility(0);
                            StringBuilder sb = new StringBuilder(this.a.getString(R.string.more));
                            sb.append(awVar.d() - 1);
                            sb.append(this.a.getString(R.string.comment_number));
                            auVar.m.setText(sb.toString());
                        }
                        auVar.p.setText(awVar.e());
                        if (awVar.m() != null) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(awVar.m().d()) + "：");
                            int length = spannableStringBuilder.length();
                            ArrayList k = awVar.k();
                            if (k != null) {
                                for (int i6 = 0; i6 < k.size(); i6++) {
                                    com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) k.get(i6);
                                    if (kVar2.a() == 0) {
                                        spannableStringBuilder.append((CharSequence) kVar2.d());
                                    } else if (kVar2.a() != 2) {
                                        break;
                                    } else {
                                        spannableStringBuilder.append((CharSequence) kVar2.a(this.a, auVar.o.getLineHeight(), (int) auVar.o.getTextSize()));
                                    }
                                }
                            }
                            if (ar == 1) {
                                i2 = -12687203;
                            } else {
                                i2 = -16610584;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), 0, length, 18);
                            auVar.o.setText(spannableStringBuilder);
                            String e2 = awVar.m().e();
                            com.baidu.adp.widget.a.b bVar2 = null;
                            if (e2 != null && e2.length() > 0) {
                                auVar.n.setVisibility(0);
                                bVar2 = this.d.b(e2);
                                if (bVar2 != null) {
                                    bVar2.b(auVar.n);
                                } else {
                                    auVar.n.setTag(e2);
                                }
                            } else {
                                auVar.n.setVisibility(8);
                            }
                            if (bVar2 == null) {
                                auVar.n.setImageBitmap(com.baidu.tieba.d.d.a((int) R.drawable.photo));
                            }
                        }
                    }
                    if (ar == 1) {
                        com.baidu.tieba.d.ac.h(auVar.a, (int) R.drawable.nearby_post_content_bg_selector_1);
                        com.baidu.tieba.d.ac.h(auVar.i, (int) R.drawable.nearby_post_reply_bg_selector_1);
                        auVar.b.setTextColor(-8682095);
                        auVar.f.setTextColor(-12687203);
                        auVar.o.setTextColor(-10523526);
                        auVar.p.setTextColor(-11446171);
                        auVar.g.setTextColor(-11446171);
                        auVar.d.setBackgroundColor(-13552064);
                        auVar.k.setBackgroundResource(R.drawable.points_image_1);
                        auVar.l.setBackgroundColor(-15132386);
                        auVar.m.setTextColor(-10523526);
                        auVar.h.setTextColor(-9207399);
                        auVar.h.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.nearby_post_comment_btn_1), (Drawable) null, (Drawable) null, (Drawable) null);
                        return view4;
                    }
                    com.baidu.tieba.d.ac.h(auVar.a, (int) R.drawable.nearby_post_content_bg_selector);
                    com.baidu.tieba.d.ac.h(auVar.i, (int) R.drawable.nearby_post_reply_bg_selector);
                    auVar.b.setTextColor(-14277082);
                    auVar.f.setTextColor(-16610584);
                    auVar.o.setTextColor(-14277082);
                    auVar.p.setTextColor(-6710887);
                    auVar.g.setTextColor(-6710887);
                    auVar.d.setBackgroundColor(-1052689);
                    auVar.k.setBackgroundResource(R.drawable.points_image);
                    auVar.l.setBackgroundColor(-1184275);
                    auVar.m.setTextColor(-14277082);
                    auVar.h.setTextColor(-16610584);
                    auVar.h.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.nearby_post_comment_btn), (Drawable) null, (Drawable) null, (Drawable) null);
                    return view4;
                } else if (itemViewType == 2) {
                    if (this.b.c().f() == 1) {
                        atVar.a.setText(R.string.load_more);
                    } else {
                        atVar.a.setText(R.string.no_more_to_load);
                    }
                    if (((NearbyPostActivity) this.a).m()) {
                        atVar.b.setVisibility(0);
                    } else {
                        atVar.b.setVisibility(8);
                    }
                    if (ar == 1) {
                        atVar.a.setTextColor(-3618616);
                        return view4;
                    }
                    atVar.a.setTextColor(-16777216);
                    return view4;
                } else {
                    return view4;
                }
            } catch (Exception e3) {
                exc = e3;
                view2 = view3;
                com.baidu.tieba.d.ae.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e4) {
            exc = e4;
            view2 = view;
        }
    }

    public com.baidu.tieba.d.a a() {
        return this.d;
    }

    public void b() {
        if (this.c != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.c.size()) {
                    try {
                        ((ProgressBar) this.c.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.d.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.c.clear();
                    return;
                }
            }
        }
    }
}
