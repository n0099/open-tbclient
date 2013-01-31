package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ah;
import com.baidu.tieba.view.ImageViewDrawer;
import java.util.Date;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.l b;
    private com.baidu.tieba.c.a c;

    public w(Context context, com.baidu.tieba.b.l lVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = lVar;
        this.c = new com.baidu.tieba.c.a(this.a);
        this.c.a("_mini");
        this.c.c(true);
        this.c.a(ah.a(this.a, 40.0f), ah.a(this.a, 40.0f));
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x017d: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:31:0x017c */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int itemViewType;
        View view3;
        y yVar;
        x xVar;
        View view4;
        String str;
        z zVar = null;
        try {
            itemViewType = getItemViewType(i);
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                if (itemViewType == 0) {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.nearby_forum, (ViewGroup) null);
                    xVar = new x(this, null);
                    xVar.a = (TextView) view4.findViewById(R.id.forum_name);
                    xVar.b = (RatingBar) view4.findViewById(R.id.forum_ratingbar);
                    view4.setTag(xVar);
                    yVar = null;
                } else if (itemViewType == 1) {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.nearby_thread, (ViewGroup) null);
                    z zVar2 = new z(this, null);
                    zVar2.a = (ImageViewDrawer) view4.findViewById(R.id.abstract_pic);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) zVar2.a.getLayoutParams();
                    layoutParams.width = ah.a(this.a, 40.0f);
                    layoutParams.height = ah.a(this.a, 40.0f);
                    zVar2.a.setLayoutParams(layoutParams);
                    zVar2.b = (ImageView) view4.findViewById(R.id.video_pic);
                    zVar2.c = (TextView) view4.findViewById(R.id.title);
                    zVar2.e = (TextView) view4.findViewById(R.id.reply_num);
                    zVar2.d = (ImageView) view4.findViewById(R.id.reply_icon);
                    zVar2.f = (TextView) view4.findViewById(R.id.time);
                    zVar2.g = (TextView) view4.findViewById(R.id.distance);
                    view4.setTag(zVar2);
                    yVar = null;
                    xVar = null;
                    zVar = zVar2;
                } else {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.page_item, (ViewGroup) null);
                    y yVar2 = new y(this, null);
                    yVar2.a = (TextView) view4.findViewById(R.id.page_text);
                    yVar2.a.setText(R.string.click_to_refresh);
                    view4.setTag(yVar2);
                    yVar = yVar2;
                    xVar = null;
                }
            } else if (itemViewType == 0) {
                xVar = (x) view.getTag();
                view4 = view;
                yVar = null;
            } else if (itemViewType == 1) {
                xVar = null;
                view4 = view;
                zVar = (z) view.getTag();
                yVar = null;
            } else {
                yVar = (y) view.getTag();
                xVar = null;
                view4 = view;
            }
            if (itemViewType == 0) {
                com.baidu.tieba.b.n nVar = (com.baidu.tieba.b.n) getItem(i);
                if (TiebaApplication.b().af() == 1) {
                    xVar.a.setTextColor(ad.a(1));
                } else {
                    xVar.a.setTextColor(-14277082);
                }
                xVar.a.setText(String.valueOf(nVar.a()) + this.a.getResources().getString(R.string.forum));
                xVar.b.setRating(Integer.valueOf(nVar.b()).intValue());
                return view4;
            } else if (itemViewType == 1) {
                com.baidu.tieba.b.o oVar = (com.baidu.tieba.b.o) getItem(i);
                if (oVar.a() == 0) {
                    zVar.a.setVisibility(8);
                    zVar.b.setVisibility(8);
                } else if (oVar.a() == 1) {
                    zVar.a.setTag(oVar.g());
                    zVar.a.setImageSearchUrl(String.valueOf(oVar.g()) + "_mini");
                    zVar.a.setDefaultId(R.drawable.lbs_def_image);
                    zVar.a.setVisibility(0);
                    zVar.b.setVisibility(8);
                } else {
                    zVar.a.setVisibility(8);
                    zVar.b.setVisibility(0);
                }
                if (TiebaApplication.b().af() == 1) {
                    zVar.c.setTextColor(ad.a(1));
                } else {
                    zVar.c.setTextColor(-14277082);
                }
                zVar.c.setText(oVar.c());
                Date date = new Date();
                date.setTime(oVar.e());
                String e2 = ae.e(date);
                if (TiebaApplication.b().af() == 1) {
                    zVar.f.setTextColor(ad.b(1));
                } else {
                    zVar.f.setTextColor(-5066062);
                }
                zVar.f.setText(e2);
                if (oVar.d().equals("0")) {
                    zVar.d.setVisibility(8);
                    zVar.e.setVisibility(8);
                } else {
                    zVar.d.setVisibility(0);
                    zVar.e.setVisibility(0);
                    zVar.e.setText(oVar.d());
                }
                int f = oVar.f();
                String string = this.a.getResources().getString(R.string.dis_prefix);
                if (f < 1000) {
                    str = String.valueOf(string) + String.valueOf(f) + this.a.getResources().getString(R.string.dis_suffix_m);
                } else {
                    str = String.valueOf(string) + String.valueOf((f % LocationClientOption.MIN_SCAN_SPAN < 500 ? 0 : 1) + (f / LocationClientOption.MIN_SCAN_SPAN)) + this.a.getResources().getString(R.string.dis_suffix_km);
                }
                if (TiebaApplication.b().af() == 1) {
                    zVar.g.setTextColor(ad.b(1));
                } else {
                    zVar.g.setTextColor(-5066062);
                }
                zVar.g.setText(str);
                return view4;
            } else if (TiebaApplication.b().af() == 1) {
                yVar.a.setTextColor(ad.a(1));
                return view4;
            } else {
                yVar.a.setTextColor(-16777216);
                return view4;
            }
        } catch (Exception e3) {
            view2 = view3;
            exc = e3;
            af.b(getClass().getName(), "", "NearbyListAdapter.getView error = " + exc.getMessage());
            return view2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.b == null) {
            return 2;
        }
        long itemId = getItemId(i);
        if (itemId < this.b.a().size()) {
            return 0;
        }
        return itemId < ((long) (this.b.a().size() + this.b.b().size())) ? 1 : 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.b == null || (itemId = (int) getItemId(i)) < 0) {
            return null;
        }
        int size = this.b.a().size();
        int size2 = this.b.b().size();
        if (itemId < size) {
            return this.b.a().get(itemId);
        }
        if (itemId >= size2 + size) {
            return null;
        }
        return this.b.b().get(itemId - size);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 1;
        }
        return 1 + this.b.a().size() + this.b.b().size();
    }

    public void a(com.baidu.tieba.b.l lVar) {
        this.b = lVar;
    }

    public com.baidu.tieba.c.a a() {
        return this.c;
    }
}
