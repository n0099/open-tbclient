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
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.PbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ar extends BaseAdapter {
    Context a;
    com.baidu.tieba.b.o b;
    private ArrayList c = new ArrayList();
    private com.baidu.tieba.c.a d;
    private View.OnClickListener e;

    public ar(Context context, com.baidu.tieba.b.o oVar, View.OnClickListener onClickListener) {
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.a = context;
        this.b = oVar;
        this.d = new com.baidu.tieba.c.a(this.a);
        int a = com.baidu.tieba.c.ai.a(this.a, 284.0f);
        int i = a <= 350 ? a : 350;
        this.d.a(i, (int) (i * 2.0f));
        this.e = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.a().size() == 0) {
            return 0;
        }
        return this.b.a().size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.a().size()) {
            return null;
        }
        return this.b.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.b == null ? 0 : 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItem(i) != null) {
            if (((com.baidu.tieba.b.p) getItem(i)).a() == 3) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x038f: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:77:0x038e */
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
        at atVar = null;
        try {
            int itemViewType = getItemViewType(i);
            int ag = TiebaApplication.b().ag();
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (itemViewType == 0) {
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
                        auVar2.c = (PbImageView) view4.findViewById(R.id.content_image);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) auVar2.c.getLayoutParams();
                        layoutParams.width = com.baidu.tieba.c.ai.a(this.a, 284.0f);
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
                com.baidu.tieba.b.p pVar = (com.baidu.tieba.b.p) getItem(i);
                if (itemViewType == 0) {
                    asVar.b.setText(pVar.b());
                    if (ag == 1) {
                        asVar.a.setBackgroundResource(R.drawable.icon_distance_node_1);
                        return view4;
                    }
                    asVar.a.setBackgroundResource(R.drawable.icon_distance_node);
                    return view4;
                } else if (itemViewType == 1) {
                    auVar.c.setVisibility(8);
                    auVar.b.setVisibility(8);
                    if (pVar.a() == 0) {
                        auVar.a.setEnabled(true);
                        auVar.a.setTag(R.id.tag_nearby_thread_id, pVar.h());
                        auVar.a.setTag(R.id.tag_nearby_url, "");
                    } else {
                        auVar.a.setTag(R.id.tag_nearby_thread_id, "");
                        auVar.a.setTag(R.id.tag_nearby_url, pVar.q());
                        if (pVar.q().equals("")) {
                            auVar.a.setEnabled(false);
                        } else {
                            auVar.a.setEnabled(true);
                        }
                    }
                    ArrayList c = pVar.c();
                    if (c != null) {
                        TextView textView2 = null;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= c.size()) {
                                break;
                            }
                            com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) c.get(i3);
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
                                int c2 = kVar.c();
                                int i4 = 350;
                                int i5 = (int) (350 * 2.0f);
                                if (b > 350) {
                                    c2 = (c2 * 350) / b;
                                } else {
                                    i4 = b;
                                }
                                if (c2 > i5) {
                                    i4 = (i4 * i5) / c2;
                                    c2 = i5;
                                }
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) auVar.c.getLayoutParams();
                                layoutParams2.width = i4;
                                layoutParams2.height = c2;
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
                    auVar.g.setText(pVar.f());
                    if (pVar.l() != null) {
                        auVar.f.setText(pVar.l().c());
                        auVar.f.setTag(R.id.tag_nearby_person_id, pVar.l().a());
                        auVar.f.setTag(R.id.tag_nearby_person_name, pVar.l().b());
                        String d = pVar.l().d();
                        Bitmap bitmap = null;
                        if (d != null && d.length() > 0) {
                            bitmap = this.d.b(d);
                            if (bitmap != null) {
                                auVar.e.setImageBitmap(bitmap);
                            } else {
                                auVar.e.setTag(d);
                            }
                        }
                        if (bitmap == null) {
                            auVar.e.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                        }
                        auVar.e.setTag(R.id.tag_nearby_person_id, pVar.l().a());
                        auVar.e.setTag(R.id.tag_nearby_person_name, pVar.l().b());
                    }
                    if (pVar.a() == 0) {
                        auVar.h.setTag(R.id.tag_nearby_thread_id, pVar.h());
                        auVar.h.setTag(R.id.tag_nearby_forum_id, pVar.i());
                        auVar.h.setTag(R.id.tag_nearby_forum_name, pVar.j());
                        auVar.h.setVisibility(0);
                    } else {
                        auVar.h.setVisibility(8);
                    }
                    if (pVar.d() == 0) {
                        auVar.i.setVisibility(8);
                    } else {
                        auVar.i.setVisibility(0);
                        auVar.i.setTag(R.id.tag_nearby_thread_id, pVar.h());
                        auVar.i.setTag(R.id.tag_nearby_url, "");
                        if (pVar.d() == 1) {
                            auVar.j.setVisibility(8);
                            auVar.l.setVisibility(8);
                        } else {
                            auVar.l.setVisibility(0);
                            auVar.j.setVisibility(0);
                            StringBuilder sb = new StringBuilder(this.a.getString(R.string.more));
                            sb.append(pVar.d() - 1);
                            sb.append(this.a.getString(R.string.comment_number));
                            auVar.m.setText(sb.toString());
                        }
                        auVar.p.setText(pVar.e());
                        if (pVar.m() != null) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(pVar.m().c()) + "：");
                            int length = spannableStringBuilder.length();
                            ArrayList k = pVar.k();
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
                            if (ag == 1) {
                                i2 = -9989158;
                            } else {
                                i2 = -16610584;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), 0, length, 18);
                            auVar.o.setText(spannableStringBuilder);
                            String d2 = pVar.m().d();
                            Bitmap bitmap2 = null;
                            if (d2 != null && d2.length() > 0) {
                                auVar.n.setVisibility(0);
                                bitmap2 = this.d.b(d2);
                                if (bitmap2 != null) {
                                    auVar.n.setImageBitmap(bitmap2);
                                } else {
                                    auVar.n.setTag(d2);
                                }
                            } else {
                                auVar.n.setVisibility(8);
                            }
                            if (bitmap2 == null) {
                                auVar.n.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                            }
                        }
                    }
                    if (ag == 1) {
                        com.baidu.tieba.c.ae.i(auVar.a, R.drawable.nearby_post_content_bg_selector_1);
                        com.baidu.tieba.c.ae.i(auVar.i, R.drawable.nearby_post_reply_bg_selector_1);
                        auVar.b.setTextColor(-6710887);
                        auVar.f.setTextColor(-9989158);
                        auVar.o.setTextColor(-6710887);
                        auVar.p.setTextColor(-10066330);
                        auVar.d.setBackgroundColor(-13421773);
                        auVar.k.setBackgroundResource(R.drawable.points_image_1);
                        auVar.l.setBackgroundColor(-14737633);
                        auVar.m.setTextColor(-6710887);
                        auVar.h.setTextColor(-9989158);
                        auVar.h.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.nearby_post_comment_btn_1), (Drawable) null, (Drawable) null, (Drawable) null);
                        return view4;
                    }
                    com.baidu.tieba.c.ae.i(auVar.a, R.drawable.nearby_post_content_bg_selector);
                    com.baidu.tieba.c.ae.i(auVar.i, R.drawable.nearby_post_reply_bg_selector);
                    auVar.b.setTextColor(-14277082);
                    auVar.f.setTextColor(-16610584);
                    auVar.o.setTextColor(-14277082);
                    auVar.p.setTextColor(-6710887);
                    auVar.d.setBackgroundColor(-1052689);
                    auVar.k.setBackgroundResource(R.drawable.points_image);
                    auVar.l.setBackgroundColor(-1184275);
                    auVar.m.setTextColor(-14277082);
                    auVar.h.setTextColor(-16610584);
                    auVar.h.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.nearby_post_comment_btn), (Drawable) null, (Drawable) null, (Drawable) null);
                    return view4;
                } else if (itemViewType == 2) {
                    if (this.b.c().c() == 1) {
                        atVar.a.setText(R.string.load_more);
                    } else {
                        atVar.a.setText(R.string.no_more_to_load);
                    }
                    if (((NearbyPostActivity) this.a).l()) {
                        atVar.b.setVisibility(0);
                    } else {
                        atVar.b.setVisibility(8);
                    }
                    if (ag == 1) {
                        atVar.a.setTextColor(-3618616);
                        return view4;
                    }
                    atVar.a.setTextColor(-16777216);
                    return view4;
                } else {
                    return view4;
                }
            } catch (Exception e) {
                exc = e;
                view2 = view3;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public com.baidu.tieba.c.a a() {
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
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
