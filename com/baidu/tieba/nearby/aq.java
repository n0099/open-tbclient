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
    com.baidu.tieba.c.as b;
    private ArrayList c = new ArrayList();
    private com.baidu.tieba.d.a d;
    private View.OnClickListener e;

    public aq(Context context, com.baidu.tieba.c.as asVar, View.OnClickListener onClickListener) {
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.a = context;
        this.b = asVar;
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
            if (((com.baidu.tieba.c.at) getItem(i)).a() == 3) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x03b8: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:80:0x03b7 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        at atVar;
        View view4;
        ar arVar;
        int i2;
        TextView textView;
        as asVar = null;
        try {
            int itemViewType = getItemViewType(i);
            int ai = TiebaApplication.d().ai();
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (itemViewType == 0) {
                        view4 = from.inflate(R.layout.distance_node, (ViewGroup) null);
                        ar arVar2 = new ar(this);
                        arVar2.b = (TextView) view4.findViewById(R.id.distance_text);
                        arVar2.a = (ImageView) view4.findViewById(R.id.distance_icon);
                        view4.setTag(arVar2);
                        atVar = null;
                        arVar = arVar2;
                    } else if (itemViewType == 1) {
                        view4 = from.inflate(R.layout.nearby_post_node, (ViewGroup) null);
                        at atVar2 = new at(this);
                        atVar2.a = (LinearLayout) view4.findViewById(R.id.nearby_post_layout);
                        atVar2.a.setOnClickListener(this.e);
                        atVar2.b = (TextView) view4.findViewById(R.id.content_text);
                        atVar2.c = (NearbyImageView) view4.findViewById(R.id.content_image);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) atVar2.c.getLayoutParams();
                        layoutParams.width = com.baidu.tieba.d.ag.a(this.a, 284.0f);
                        if (layoutParams.width > 350) {
                            layoutParams.width = 350;
                        }
                        layoutParams.height = (int) (layoutParams.width * 2.0f);
                        atVar2.c.setLayoutParams(layoutParams);
                        atVar2.c.setFocusable(false);
                        atVar2.c.setScaleType(ImageView.ScaleType.CENTER);
                        atVar2.d = (ImageView) view4.findViewById(R.id.div_post);
                        atVar2.e = (ImageView) view4.findViewById(R.id.author_photo);
                        atVar2.f = (TextView) view4.findViewById(R.id.author_name);
                        atVar2.e.setOnClickListener(this.e);
                        atVar2.f.setOnClickListener(this.e);
                        atVar2.g = (TextView) view4.findViewById(R.id.post_time);
                        atVar2.h = (Button) view4.findViewById(R.id.comment_btn);
                        atVar2.h.setOnClickListener(this.e);
                        atVar2.i = (LinearLayout) view4.findViewById(R.id.nearby_reply_layout);
                        atVar2.i.setOnClickListener(this.e);
                        atVar2.j = (LinearLayout) view4.findViewById(R.id.more_reply_layout);
                        atVar2.k = (ImageView) view4.findViewById(R.id.points);
                        atVar2.l = (ImageView) view4.findViewById(R.id.div_reply);
                        atVar2.m = (TextView) view4.findViewById(R.id.view_more_reply);
                        atVar2.n = (ImageView) view4.findViewById(R.id.replyer_photo);
                        atVar2.o = (TextView) view4.findViewById(R.id.reply_content);
                        atVar2.p = (TextView) view4.findViewById(R.id.reply_time);
                        view4.setTag(atVar2);
                        atVar = atVar2;
                        arVar = null;
                    } else {
                        if (itemViewType == 2) {
                            view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                            asVar = new as(this);
                            asVar.a = (TextView) view4.findViewById(R.id.page_text);
                            asVar.b = (ProgressBar) view4.findViewById(R.id.progress);
                            view4.setTag(asVar);
                            this.c.add(asVar.b);
                            atVar = null;
                            arVar = null;
                        }
                        atVar = null;
                        view4 = view;
                        arVar = null;
                    }
                } else if (itemViewType == 0) {
                    atVar = null;
                    view4 = view;
                    arVar = (ar) view.getTag();
                } else if (itemViewType == 1) {
                    atVar = (at) view.getTag();
                    arVar = null;
                    view4 = view;
                } else {
                    if (itemViewType == 2) {
                        asVar = (as) view.getTag();
                        atVar = null;
                        view4 = view;
                        arVar = null;
                    }
                    atVar = null;
                    view4 = view;
                    arVar = null;
                }
                com.baidu.tieba.c.at atVar3 = (com.baidu.tieba.c.at) getItem(i);
                if (itemViewType == 0) {
                    arVar.b.setText(atVar3.b());
                    if (ai == 1) {
                        arVar.a.setBackgroundResource(R.drawable.icon_distance_node_1);
                        return view4;
                    }
                    arVar.a.setBackgroundResource(R.drawable.icon_distance_node);
                    return view4;
                } else if (itemViewType == 1) {
                    atVar.c.setVisibility(8);
                    atVar.b.setVisibility(8);
                    if (atVar3.a() == 0) {
                        atVar.a.setEnabled(true);
                        atVar.a.setTag(R.id.tag_nearby_thread_id, atVar3.h());
                        atVar.a.setTag(R.id.tag_nearby_url, "");
                        atVar.a.setTag(R.id.tag_nearby_guid_post, false);
                    } else {
                        atVar.a.setTag(R.id.tag_nearby_thread_id, "");
                        atVar.a.setTag(R.id.tag_nearby_url, atVar3.q());
                        if (atVar3.a() == 1) {
                            atVar.a.setTag(R.id.tag_nearby_guid_post, true);
                        } else {
                            atVar.a.setTag(R.id.tag_nearby_guid_post, false);
                        }
                        if (atVar3.q().equals("")) {
                            atVar.a.setEnabled(false);
                        } else {
                            atVar.a.setEnabled(true);
                        }
                    }
                    ArrayList c = atVar3.c();
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
                                    TextView textView3 = atVar.b;
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
                                atVar.b.setVisibility(0);
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
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) atVar.c.getLayoutParams();
                                layoutParams2.width = i4;
                                layoutParams2.height = c2;
                                atVar.c.setLayoutParams(layoutParams2);
                                atVar.c.setTag(kVar.f());
                                atVar.c.setVisibility(0);
                            } else {
                                textView = textView2;
                            }
                            i3++;
                            textView2 = textView;
                        }
                    }
                    atVar.g.setText(atVar3.f());
                    if (atVar3.l() != null) {
                        atVar.f.setText(atVar3.l().d());
                        atVar.f.setTag(R.id.tag_nearby_person_id, atVar3.l().a());
                        atVar.f.setTag(R.id.tag_nearby_person_name, atVar3.l().c());
                        String e = atVar3.l().e();
                        Bitmap bitmap = null;
                        if (e != null && e.length() > 0) {
                            bitmap = this.d.b(e);
                            if (bitmap != null) {
                                atVar.e.setImageBitmap(bitmap);
                            } else {
                                atVar.e.setTag(e);
                            }
                        }
                        if (bitmap == null) {
                            atVar.e.setImageBitmap(com.baidu.tieba.d.e.a((int) R.drawable.photo));
                        }
                        atVar.e.setTag(R.id.tag_nearby_person_id, atVar3.l().a());
                        atVar.e.setTag(R.id.tag_nearby_person_name, atVar3.l().c());
                    }
                    if (atVar3.a() == 0) {
                        atVar.h.setTag(R.id.tag_nearby_thread_id, atVar3.h());
                        atVar.h.setTag(R.id.tag_nearby_forum_id, atVar3.i());
                        atVar.h.setTag(R.id.tag_nearby_forum_name, atVar3.j());
                        atVar.h.setVisibility(0);
                    } else {
                        atVar.h.setVisibility(8);
                    }
                    if (atVar3.d() == 0) {
                        atVar.i.setVisibility(8);
                    } else {
                        atVar.i.setVisibility(0);
                        atVar.i.setTag(R.id.tag_nearby_thread_id, atVar3.h());
                        atVar.i.setTag(R.id.tag_nearby_url, "");
                        if (atVar3.d() == 1) {
                            atVar.j.setVisibility(8);
                            atVar.l.setVisibility(8);
                        } else {
                            atVar.l.setVisibility(0);
                            atVar.j.setVisibility(0);
                            StringBuilder sb = new StringBuilder(this.a.getString(R.string.more));
                            sb.append(atVar3.d() - 1);
                            sb.append(this.a.getString(R.string.comment_number));
                            atVar.m.setText(sb.toString());
                        }
                        atVar.p.setText(atVar3.e());
                        if (atVar3.m() != null) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(atVar3.m().d()) + "：");
                            int length = spannableStringBuilder.length();
                            ArrayList k = atVar3.k();
                            if (k != null) {
                                for (int i6 = 0; i6 < k.size(); i6++) {
                                    com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) k.get(i6);
                                    if (kVar2.a() == 0) {
                                        spannableStringBuilder.append((CharSequence) kVar2.d());
                                    } else if (kVar2.a() != 2) {
                                        break;
                                    } else {
                                        spannableStringBuilder.append((CharSequence) kVar2.a(this.a, atVar.o.getLineHeight(), (int) atVar.o.getTextSize()));
                                    }
                                }
                            }
                            if (ai == 1) {
                                i2 = -12687203;
                            } else {
                                i2 = -16610584;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), 0, length, 18);
                            atVar.o.setText(spannableStringBuilder);
                            String e2 = atVar3.m().e();
                            Bitmap bitmap2 = null;
                            if (e2 != null && e2.length() > 0) {
                                atVar.n.setVisibility(0);
                                bitmap2 = this.d.b(e2);
                                if (bitmap2 != null) {
                                    atVar.n.setImageBitmap(bitmap2);
                                } else {
                                    atVar.n.setTag(e2);
                                }
                            } else {
                                atVar.n.setVisibility(8);
                            }
                            if (bitmap2 == null) {
                                atVar.n.setImageBitmap(com.baidu.tieba.d.e.a((int) R.drawable.photo));
                            }
                        }
                    }
                    if (ai == 1) {
                        com.baidu.tieba.d.ac.h(atVar.a, (int) R.drawable.nearby_post_content_bg_selector_1);
                        com.baidu.tieba.d.ac.h(atVar.i, (int) R.drawable.nearby_post_reply_bg_selector_1);
                        atVar.b.setTextColor(-8682095);
                        atVar.f.setTextColor(-12687203);
                        atVar.o.setTextColor(-10523526);
                        atVar.p.setTextColor(-11446171);
                        atVar.g.setTextColor(-11446171);
                        atVar.d.setBackgroundColor(-13552064);
                        atVar.k.setBackgroundResource(R.drawable.points_image_1);
                        atVar.l.setBackgroundColor(-15132386);
                        atVar.m.setTextColor(-10523526);
                        atVar.h.setTextColor(-9207399);
                        atVar.h.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.nearby_post_comment_btn_1), (Drawable) null, (Drawable) null, (Drawable) null);
                        return view4;
                    }
                    com.baidu.tieba.d.ac.h(atVar.a, (int) R.drawable.nearby_post_content_bg_selector);
                    com.baidu.tieba.d.ac.h(atVar.i, (int) R.drawable.nearby_post_reply_bg_selector);
                    atVar.b.setTextColor(-14277082);
                    atVar.f.setTextColor(-16610584);
                    atVar.o.setTextColor(-14277082);
                    atVar.p.setTextColor(-6710887);
                    atVar.g.setTextColor(-6710887);
                    atVar.d.setBackgroundColor(-1052689);
                    atVar.k.setBackgroundResource(R.drawable.points_image);
                    atVar.l.setBackgroundColor(-1184275);
                    atVar.m.setTextColor(-14277082);
                    atVar.h.setTextColor(-16610584);
                    atVar.h.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.nearby_post_comment_btn), (Drawable) null, (Drawable) null, (Drawable) null);
                    return view4;
                } else if (itemViewType == 2) {
                    if (this.b.c().e() == 1) {
                        asVar.a.setText(R.string.load_more);
                    } else {
                        asVar.a.setText(R.string.no_more_to_load);
                    }
                    if (((NearbyPostActivity) this.a).m()) {
                        asVar.b.setVisibility(0);
                    } else {
                        asVar.b.setVisibility(8);
                    }
                    if (ai == 1) {
                        asVar.a.setTextColor(-3618616);
                        return view4;
                    }
                    asVar.a.setTextColor(-16777216);
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
