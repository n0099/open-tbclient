package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter implements View.OnClickListener {
    private final Context a;
    private ArrayList<FeedData> b;
    private final String c;
    private ListView d;
    private int h;
    private m j;
    private boolean[] l = new boolean[0];
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private final ArrayList<ProgressBar> k = new ArrayList<>();
    private int i = 3;

    public k(Context context, ArrayList<FeedData> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(com.baidu.tieba.x.forum).toString();
    }

    public void a() {
        if (this.k != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.k.size()) {
                    try {
                        this.k.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.k.clear();
                    return;
                }
            }
        }
    }

    public void a(ArrayList<FeedData> arrayList, boolean z) {
        if (!z) {
            this.l = new boolean[Math.min(100, com.baidu.tbadk.coreExtra.messageCenter.a.a().f(this.h))];
        }
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.f;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public boolean c() {
        return this.g;
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public int d() {
        return this.i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (size > 0) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i == getCount() - 1) {
            i = -2;
        }
        return i;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x01aa: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:48:0x01a9 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        o oVar;
        View view4;
        Object obj;
        this.d = (ListView) viewGroup;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        if (this.b != null) {
            FeedData feedData = getItemViewType(i) == 0 ? (FeedData) getItem(i) : null;
            try {
                if (view == null) {
                    if (getItemViewType(i) == 0) {
                        if (this.h == 1) {
                            view4 = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.mention_replyme_item, null);
                        } else {
                            view4 = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.mention_atme_item, null);
                        }
                        o oVar2 = new o(this, null);
                        oVar2.q = (LinearLayout) view4.findViewById(com.baidu.tieba.u.reply_container);
                        oVar2.e = (HeadImageView) view4.findViewById(com.baidu.tieba.u.photo);
                        oVar2.f = (TextView) view4.findViewById(com.baidu.tieba.u.user_name);
                        oVar2.h = (TextView) view4.findViewById(com.baidu.tieba.u.time);
                        oVar2.j = view4.findViewById(com.baidu.tieba.u.line);
                        oVar2.i = (TextView) view4.findViewById(com.baidu.tieba.u.content);
                        if (this.h == 1) {
                            oVar2.k = (TextView) view4.findViewById(com.baidu.tieba.u.title);
                            oVar2.l = (TextView) view4.findViewById(com.baidu.tieba.u.forum);
                            oVar2.m = (TextView) view4.findViewById(com.baidu.tieba.u.reply_type);
                            oVar2.n = (LinearLayout) view4.findViewById(com.baidu.tieba.u.ll_quick_reply);
                            oVar2.o = (ImageView) view4.findViewById(com.baidu.tieba.u.iv_quick_reply_icon);
                            oVar2.p = (TextView) view4.findViewById(com.baidu.tieba.u.tv_quick_reply_text);
                        }
                        oVar2.g = (TextView) view4.findViewById(com.baidu.tieba.u.add_friend_button);
                        oVar2.c = new l(this, null);
                        oVar2.g.setOnClickListener(oVar2.c);
                        oVar2.d = new n(this);
                        oVar2.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        oVar2.e.setOnClickListener(oVar2.d);
                        obj = oVar2;
                    } else {
                        view4 = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.new_pb_list_more, null);
                        o oVar3 = new o(this, null);
                        oVar3.a = (TextView) view4.findViewById(com.baidu.tieba.u.pb_more_text);
                        oVar3.b = (ProgressBar) view4.findViewById(com.baidu.tieba.u.progress);
                        this.k.add(oVar3.b);
                        obj = oVar3;
                    }
                    view4.setTag(obj);
                    oVar = obj;
                } else {
                    oVar = (o) view.getTag();
                    view4 = view;
                }
                if (oVar.n != null) {
                    if (feedData != null && !TextUtils.isEmpty(feedData.getPraiseItemType()) && feedData.getPraiseItemType().equals(FeedData.TYPE_ZAN)) {
                        oVar.n.setVisibility(8);
                    } else {
                        oVar.n.setVisibility(0);
                        oVar.n.setTag(Integer.valueOf(i));
                        oVar.n.setOnClickListener(this);
                    }
                }
            } catch (Exception e2) {
                exc = e2;
                view2 = view3;
                BdLog.e(exc.getMessage());
                return view2;
            }
            if (getItemViewType(i) == 1) {
                long itemId = getItemId(i);
                if (itemId == -1) {
                    if (this.f) {
                        oVar.b.setVisibility(0);
                        oVar.a.setText(com.baidu.tieba.x.loading);
                    } else {
                        oVar.b.setVisibility(8);
                        oVar.a.setText(com.baidu.tieba.x.refresh);
                    }
                } else if (itemId == -2) {
                    if (this.g) {
                        oVar.b.setVisibility(0);
                        oVar.a.setText(com.baidu.tieba.x.loading);
                    } else if (this.e) {
                        oVar.b.setVisibility(0);
                        oVar.a.setText(com.baidu.tieba.x.loading);
                    } else {
                        oVar.b.setVisibility(8);
                        oVar.a.setText(com.baidu.tieba.x.no_more_msg);
                    }
                }
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    oVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d));
                } else {
                    oVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
                }
                return view4;
            }
            if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                List<com.baidu.tieba.data.y> praiseList = feedData.getPraiseList();
                if (praiseList != null && praiseList.size() > 0) {
                    com.baidu.tieba.data.y yVar = praiseList.get(0);
                    oVar.f.setText(yVar.c());
                    if (yVar.e() == 1) {
                        oVar.g.setVisibility(8);
                    } else {
                        oVar.g.setVisibility(0);
                        oVar.c.a(feedData);
                    }
                    oVar.h.setText(ba.a(feedData.getTime()));
                    if (praiseList.size() > 3) {
                        oVar.i.setText(String.format(this.a.getString(com.baidu.tieba.x.message_praise_like_list_more), praiseList.get(0).c(), praiseList.get(1).c(), praiseList.get(2).c(), String.valueOf(feedData.getPraiseNum())));
                    } else if (praiseList.size() > 2) {
                        oVar.i.setText(String.format(this.a.getString(com.baidu.tieba.x.message_praise_like_list_3), praiseList.get(0).c(), praiseList.get(1).c(), praiseList.get(2).c()));
                    } else if (praiseList.size() > 1) {
                        oVar.i.setText(String.format(this.a.getString(com.baidu.tieba.x.message_praise_like_list_2), praiseList.get(0).c(), praiseList.get(1).c()));
                    } else {
                        oVar.i.setText(String.format(this.a.getString(com.baidu.tieba.x.message_praise_like_list_1), praiseList.get(0).c()));
                    }
                    oVar.m.setText(this.a.getString(com.baidu.tieba.x.mention_praiseme_post));
                    oVar.k.setText(feedData.getTitle());
                    if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                        oVar.l.setVisibility(0);
                        oVar.l.setText(ba.a(feedData.getFname(), 12).concat(this.c));
                    } else {
                        oVar.l.setVisibility(8);
                    }
                    oVar.e.setVisibility(0);
                    String d = yVar.d();
                    if (d != null && d.length() > 0) {
                        oVar.e.a(d, 12, false);
                    } else {
                        oVar.e.setImageResource(com.baidu.tieba.t.photo);
                    }
                    oVar.d.b(yVar.a());
                    oVar.d.a(yVar.b());
                    oVar.e.setOnClickListener(oVar.d);
                }
            } else {
                oVar.f.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    oVar.g.setVisibility(8);
                } else {
                    oVar.g.setVisibility(0);
                    oVar.c.a(feedData);
                }
                oVar.h.setText(ba.a(feedData.getTime()));
                oVar.i.setText(feedData.getContent());
                if (this.h == 1) {
                    if (feedData.getType() == 1) {
                        oVar.m.setText(this.a.getString(com.baidu.tieba.x.mention_replyme_post));
                        oVar.k.setText(feedData.getQuote_content());
                    } else {
                        oVar.m.setText(this.a.getString(com.baidu.tieba.x.mention_replyme_thread));
                        oVar.k.setText(feedData.getTitle());
                    }
                    if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                        oVar.l.setVisibility(0);
                        oVar.l.setText(ba.a(feedData.getFname(), 12).concat(this.c));
                    } else {
                        oVar.l.setVisibility(8);
                    }
                }
                oVar.e.setVisibility(0);
                String portrait = feedData.getReplyer().getPortrait();
                oVar.e.setTag(null);
                if (portrait != null && portrait.length() > 0) {
                    oVar.e.a(portrait, 12, false);
                } else {
                    oVar.e.setImageResource(com.baidu.tieba.t.photo);
                }
                oVar.d.b(feedData.getReplyer().getUserId());
                oVar.d.a(feedData.getReplyer().getUserName());
                oVar.e.setOnClickListener(oVar.d);
            }
            a(oVar, view4);
            view2 = view4;
            return view2;
        }
        return view;
    }

    private void a(o oVar, View view) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType == 1) {
            ay.e(view, com.baidu.tieba.t.list_selector_1);
        } else {
            ay.e(view, com.baidu.tieba.t.list_selector);
        }
        ay.f(oVar.j, com.baidu.tieba.r.cp_bg_line_b);
        if (skinType == 1) {
            if (oVar.q != null) {
                oVar.q.setBackgroundResource(com.baidu.tieba.t.nearby_reply_bg_pressed_1);
            }
            if (oVar.k != null) {
                oVar.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_5f6c7a));
            }
            if (oVar.l != null) {
                oVar.l.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_515865));
            }
            if (oVar.h != null) {
                oVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_515865));
                Bitmap a = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.icon_little_time_1);
                if (a != null) {
                    oVar.h.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), a), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
            if (oVar.i != null) {
                oVar.i.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_7b8591));
            }
            if (oVar.m != null) {
                oVar.m.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_5f6c7a));
            }
            if (oVar.f != null) {
                oVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_515865));
            }
            if (oVar.g != null) {
                oVar.g.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_link_tip_c_1));
                oVar.g.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), com.baidu.tieba.t.icon_friend_add_1)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            if (oVar.q != null) {
                oVar.q.setBackgroundResource(com.baidu.tieba.t.search_preycotbj);
            }
            if (oVar.l != null) {
                oVar.l.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_b2b6ba));
            }
            if (oVar.h != null) {
                oVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_b2b6ba));
                Bitmap a2 = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.icon_little_time);
                if (a2 != null) {
                    oVar.h.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), a2), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
            if (oVar.k != null) {
                oVar.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.search_text_title));
            }
            if (oVar.i != null) {
                oVar.i.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.c_262626));
            }
            if (oVar.m != null) {
                oVar.m.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.search_text_title));
            }
            if (oVar.f != null) {
                oVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.search_text_title));
            }
            if (oVar.g != null) {
                oVar.g.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_link_tip_c));
                oVar.g.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), com.baidu.tieba.t.icon_friend_add)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        ay.a(oVar.p, com.baidu.tieba.r.cp_cont_c, 1);
        ay.c(oVar.o, com.baidu.tieba.t.icon_reply_n);
    }

    public void a(m mVar) {
        this.j = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.j != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.d.getChildAt(intValue - (this.d.getFirstVisiblePosition() - this.d.getHeaderViewsCount()));
            this.j.a(intValue, view, childAt, (FeedData) getItem(intValue));
        }
    }
}
