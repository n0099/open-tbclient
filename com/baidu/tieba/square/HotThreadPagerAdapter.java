package com.baidu.tieba.square;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class HotThreadPagerAdapter extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    private ForumDetailData.ThreadInfo[] f2350a;
    private LayoutInflater b;
    private Context c;

    public HotThreadPagerAdapter(Context context, ForumDetailData.ThreadInfo[] threadInfoArr) {
        this.c = context;
        if (threadInfoArr != null && threadInfoArr.length != 0) {
            this.f2350a = threadInfoArr;
            this.b = LayoutInflater.from(this.c);
        }
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        if (this.f2350a == null) {
            return 0;
        }
        return this.f2350a.length;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ForumDetailData.ThreadInfo threadInfo = this.f2350a[i];
        View inflate = this.b.inflate(R.layout.square_hot_thread_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.ht_item_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ht_item_content);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ht_item_forum);
        TextView textView4 = (TextView) inflate.findViewById(R.id.ht_item_reply);
        View findViewById = inflate.findViewById(R.id.post_recommend_line);
        textView.setText(threadInfo.title);
        StringBuilder sb = new StringBuilder();
        int length = threadInfo.abstracts.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (threadInfo.abstracts[i2].type == 0) {
                sb.append(threadInfo.abstracts[i2].text);
            }
        }
        textView2.setText(sb.toString());
        textView3.setVisibility(0);
        textView3.setText(threadInfo.forumName + this.c.getString(R.string.bar));
        textView4.setText(String.valueOf(threadInfo.replyNum));
        if (TiebaApplication.g().ap() == 1) {
            textView.setTextColor(this.c.getResources().getColor(R.color.square_forum_barfolder_name_1));
            textView2.setTextColor(this.c.getResources().getColor(R.color.square_forum_barfolder_description_1));
            textView3.setTextColor(this.c.getResources().getColor(R.color.sqaure_post_info_text_1));
            textView4.setTextColor(this.c.getResources().getColor(R.color.sqaure_post_info_text_1));
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.icon_little_comment_n_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            textView4.setCompoundDrawables(bitmapDrawable, null, null, null);
            findViewById.setBackgroundColor(this.c.getResources().getColor(R.color.square_dividing_line_1));
        } else {
            textView.setTextColor(this.c.getResources().getColor(R.color.square_forum_barfolder_name));
            textView2.setTextColor(this.c.getResources().getColor(R.color.square_forum_barfolder_description));
            textView3.setTextColor(this.c.getResources().getColor(R.color.sqaure_post_info_text));
            textView4.setTextColor(this.c.getResources().getColor(R.color.sqaure_post_info_text));
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.icon_little_comment_n);
            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
            textView4.setCompoundDrawables(bitmapDrawable2, null, null, null);
            findViewById.setBackgroundColor(this.c.getResources().getColor(R.color.square_dividing_line));
        }
        inflate.setOnClickListener(new ah(this, i, String.valueOf(threadInfo.id)));
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public int getItemPosition(Object obj) {
        return -2;
    }
}
