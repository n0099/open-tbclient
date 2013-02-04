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
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.view.ImageViewDrawer;
import java.util.Date;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.j b;
    private com.baidu.tieba.c.a c;

    public w(Context context, com.baidu.tieba.b.j jVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = jVar;
        this.c = new com.baidu.tieba.c.a(this.a);
        this.c.a("_mini");
        this.c.c(true);
        this.c.a(ag.a(this.a, 40.0f), ag.a(this.a, 40.0f));
    }

    public com.baidu.tieba.c.a a() {
        return this.c;
    }

    public void a(com.baidu.tieba.b.j jVar) {
        this.b = jVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return 1 + this.b.a().size() + this.b.b().size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.b != null && (itemId = (int) getItemId(i)) >= 0) {
            int size = this.b.a().size();
            int size2 = this.b.b().size();
            if (itemId < size) {
                return this.b.a().get(itemId);
            }
            if (itemId < size2 + size) {
                return this.b.b().get(itemId - size);
            }
            return null;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0228: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:40:0x0227 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        x xVar;
        View view4;
        String str;
        z zVar = null;
        try {
            int itemViewType = getItemViewType(i);
            try {
                if (view == null) {
                    if (itemViewType == 0) {
                        view4 = LayoutInflater.from(this.a).inflate(R.layout.nearby_forum, (ViewGroup) null);
                        xVar = new x(this, null);
                        xVar.a = (TextView) view4.findViewById(R.id.forum_name);
                        xVar.b = (RatingBar) view4.findViewById(R.id.forum_ratingbar);
                        view4.setTag(xVar);
                    } else if (itemViewType == 1) {
                        view4 = LayoutInflater.from(this.a).inflate(R.layout.nearby_thread, (ViewGroup) null);
                        z zVar2 = new z(this, null);
                        zVar2.a = (ImageViewDrawer) view4.findViewById(R.id.abstract_pic);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) zVar2.a.getLayoutParams();
                        layoutParams.width = ag.a(this.a, 40.0f);
                        layoutParams.height = ag.a(this.a, 40.0f);
                        zVar2.a.setLayoutParams(layoutParams);
                        zVar2.b = (ImageView) view4.findViewById(R.id.video_pic);
                        zVar2.c = (TextView) view4.findViewById(R.id.title);
                        zVar2.e = (TextView) view4.findViewById(R.id.reply_num);
                        zVar2.d = (ImageView) view4.findViewById(R.id.reply_icon);
                        zVar2.f = (TextView) view4.findViewById(R.id.time);
                        zVar2.g = (TextView) view4.findViewById(R.id.distance);
                        view4.setTag(zVar2);
                        xVar = null;
                        zVar = zVar2;
                    } else {
                        view4 = LayoutInflater.from(this.a).inflate(R.layout.page_item, (ViewGroup) null);
                        y yVar = new y(this, null);
                        yVar.a = (TextView) view4.findViewById(R.id.page_text);
                        yVar.a.setText(R.string.click_to_refresh);
                        view4.setTag(yVar);
                        xVar = null;
                    }
                } else if (itemViewType == 0) {
                    xVar = (x) view.getTag();
                    view4 = view;
                } else if (itemViewType == 1) {
                    xVar = null;
                    view4 = view;
                    zVar = (z) view.getTag();
                } else {
                    xVar = null;
                    view4 = view;
                }
                if (itemViewType == 0) {
                    com.baidu.tieba.b.l lVar = (com.baidu.tieba.b.l) getItem(i);
                    xVar.a.setText(String.valueOf(lVar.a()) + this.a.getResources().getString(R.string.forum));
                    xVar.b.setRating(Integer.valueOf(lVar.b()).intValue());
                    return view4;
                } else if (itemViewType == 1) {
                    com.baidu.tieba.b.m mVar = (com.baidu.tieba.b.m) getItem(i);
                    if (mVar.a() == 0) {
                        zVar.a.setVisibility(8);
                        zVar.b.setVisibility(8);
                    } else if (mVar.a() == 1) {
                        zVar.a.setTag(mVar.g());
                        zVar.a.setImageSearchUrl(String.valueOf(mVar.g()) + "_mini");
                        zVar.a.setDefaultId(R.drawable.lbs_def_image);
                        zVar.a.setVisibility(0);
                        zVar.b.setVisibility(8);
                    } else {
                        zVar.a.setVisibility(8);
                        zVar.b.setVisibility(0);
                    }
                    zVar.c.setText(mVar.c());
                    Date date = new Date();
                    date.setTime(mVar.e());
                    zVar.f.setText(ad.d(date));
                    if (mVar.d().equals("0")) {
                        zVar.d.setVisibility(8);
                        zVar.e.setVisibility(8);
                    } else {
                        zVar.d.setVisibility(0);
                        zVar.e.setVisibility(0);
                        zVar.e.setText(mVar.d());
                    }
                    int f = mVar.f();
                    String string = this.a.getResources().getString(R.string.dis_prefix);
                    if (f < 1000) {
                        str = String.valueOf(string) + String.valueOf(f) + this.a.getResources().getString(R.string.dis_suffix_m);
                    } else {
                        str = String.valueOf(string) + String.valueOf((f % LocationClientOption.MIN_SCAN_SPAN < 500 ? 0 : 1) + (f / LocationClientOption.MIN_SCAN_SPAN)) + this.a.getResources().getString(R.string.dis_suffix_km);
                    }
                    zVar.g.setText(str);
                    return view4;
                } else {
                    return view4;
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                ae.b(getClass().getName(), "", "NearbyListAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
