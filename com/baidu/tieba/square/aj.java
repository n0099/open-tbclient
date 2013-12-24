package com.baidu.tieba.square;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class aj extends LinearLayout {
    private Context a;
    private FrameLayout b;
    private TextView c;
    private TextView d;
    private ViewPager e;
    private IndicatorView f;
    private HotThreadPagerAdapter g;
    private View h;
    private View i;
    private ForumDetailData.ThreadInfo[] j;

    public aj(Context context) {
        this(context, null);
    }

    public aj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.posts_recommend_layout, (ViewGroup) this, true);
        this.b = (FrameLayout) findViewById(R.id.post_recommend_title);
        this.c = (TextView) findViewById(R.id.post_recommend_title_txt);
        this.d = (TextView) findViewById(R.id.post_recommend_title_all);
        this.e = (ViewPager) findViewById(R.id.post_pager);
        this.f = (IndicatorView) findViewById(R.id.post_indicator);
        this.h = findViewById(R.id.post_recommend_line1);
        this.i = findViewById(R.id.post_recommend_line2);
        this.d.setOnClickListener(new ak(this, context));
        setOrientation(1);
    }

    public void setData(ForumDetailData.ThreadInfo[] threadInfoArr) {
        if (threadInfoArr == null || threadInfoArr.length == 0) {
            setVisibility(8);
            return;
        }
        if (threadInfoArr.length > 1) {
            int length = threadInfoArr.length;
            int length2 = threadInfoArr.length + 2;
            this.j = new ForumDetailData.ThreadInfo[length2];
            this.j[0] = threadInfoArr[length - 1];
            this.j[length2 - 1] = threadInfoArr[0];
            for (int i = 1; i < length2 - 1; i++) {
                this.j[i] = threadInfoArr[i - 1];
            }
        } else {
            this.j = threadInfoArr;
        }
        setVisibility(0);
        this.g = new HotThreadPagerAdapter(this.a, this.j);
        this.e.setAdapter(this.g);
        this.e.a(this.j.length > 1 ? 1 : 0, false);
        this.e.setOnPageChangeListener(new al(this, null));
        if (this.j.length > 1) {
            this.f.setVisibility(0);
            this.f.setCount(threadInfoArr.length);
            this.f.setPosition(0.0f);
            return;
        }
        this.f.setVisibility(8);
    }

    public void a(int i) {
        int i2 = R.drawable.icon_jingxuantie_n;
        int i3 = R.drawable.icon_jingxuantie_s;
        if (i == 1) {
            i2 = R.drawable.icon_jingxuantie_n_1;
            i3 = R.drawable.icon_jingxuantie_s_1;
            this.b.setBackgroundResource(R.color.square_header_background_1);
            this.c.setTextColor(this.a.getResources().getColor(R.color.square_header_title_1));
            this.d.setTextColor(this.a.getResources().getColor(R.color.square_post_recommend_title_all_1));
            this.e.setBackgroundResource(R.color.square_list_middle_bg_n_1);
            this.h.setBackgroundColor(this.a.getResources().getColor(R.color.square_dividing_line_1));
            this.i.setBackgroundColor(this.a.getResources().getColor(R.color.square_dividing_line_1));
        } else {
            this.b.setBackgroundResource(R.color.square_header_background);
            this.c.setTextColor(this.a.getResources().getColor(R.color.square_header_title));
            this.d.setTextColor(this.a.getResources().getColor(R.color.square_post_recommend_title_all));
            this.e.setBackgroundResource(R.color.square_list_middle_bg_n);
            this.h.setBackgroundColor(this.a.getResources().getColor(R.color.square_dividing_line));
            this.i.setBackgroundColor(this.a.getResources().getColor(R.color.square_dividing_line));
        }
        this.f.setDrawable(this.a.getResources().getDrawable(i2));
        this.f.setSelector(this.a.getResources().getDrawable(i3));
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }
}
