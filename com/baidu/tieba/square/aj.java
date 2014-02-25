package com.baidu.tieba.square;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class aj extends BaseAdapter {
    private Context b;
    private LayoutInflater c;
    private ForumDetailData.ThreadInfo[] a = null;
    private final int d = 3;
    private final int e = 0;
    private final int f = 2;
    private final int g = 1;

    public aj(Context context) {
        this.b = context;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void a(ForumDetailData.ThreadInfo[] threadInfoArr) {
        this.a = threadInfoArr;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.length <= 0) {
            return 0;
        }
        return this.a.length + 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == this.a.length + 1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            if (itemViewType == 1) {
                view = this.c.inflate(R.layout.square_hot_thread_item, viewGroup, false);
            } else if (itemViewType == 0) {
                view = this.c.inflate(R.layout.square_hot_thread_head, viewGroup, false);
            } else {
                view = this.c.inflate(R.layout.square_hot_thread_foot, viewGroup, false);
            }
        }
        if (itemViewType == 1) {
            a(view, i - 1);
        } else if (itemViewType == 0) {
            int al = TiebaApplication.g().al();
            TextView textView = (TextView) view.findViewById(R.id.post_recommend_title_txt);
            View findViewById = view.findViewById(R.id.post_recommend_line1);
            View findViewById2 = view.findViewById(R.id.post_recommend_line2);
            if (al == 1) {
                view.setBackgroundResource(R.color.square_header_background_1);
                textView.setTextColor(this.b.getResources().getColor(R.color.square_header_title_1));
                findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line_1));
                findViewById2.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line_1));
            } else {
                view.setBackgroundResource(R.color.square_header_background);
                textView.setTextColor(this.b.getResources().getColor(R.color.square_header_title));
                findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line));
                findViewById2.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line));
            }
        } else if (itemViewType == 2) {
            int al2 = TiebaApplication.g().al();
            TextView textView2 = (TextView) view.findViewById(R.id.post_recommend_seeall);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.post_recommend_seeall_container);
            if (al2 == 1) {
                textView2.setTextColor(this.b.getResources().getColor(R.color.frs_listmore_text_1));
                linearLayout.setBackgroundResource(R.drawable.frs_item_control_bg_1);
            } else {
                textView2.setTextColor(this.b.getResources().getColor(R.color.frs_listmore_text));
                linearLayout.setBackgroundResource(R.drawable.frs_item_control_bg);
            }
            linearLayout.setOnClickListener(new ak(this));
        }
        return view;
    }

    private void a(View view, int i) {
        ForumDetailData.ThreadInfo threadInfo = this.a[i];
        TextView textView = (TextView) view.findViewById(R.id.ht_item_title);
        TextView textView2 = (TextView) view.findViewById(R.id.ht_item_content);
        TextView textView3 = (TextView) view.findViewById(R.id.ht_item_forum);
        TextView textView4 = (TextView) view.findViewById(R.id.ht_item_reply);
        View findViewById = view.findViewById(R.id.post_recommend_line);
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
        textView3.setText(String.valueOf(threadInfo.forumName) + this.b.getString(R.string.bar));
        textView4.setText(String.valueOf(threadInfo.replyNum));
        if (TiebaApplication.g().al() == 1) {
            view.setBackgroundResource(R.drawable.square_list_item_selector_1);
            textView.setTextColor(this.b.getResources().getColor(R.color.square_forum_barfolder_name_1));
            textView2.setTextColor(this.b.getResources().getColor(R.color.square_forum_barfolder_description_1));
            textView3.setTextColor(this.b.getResources().getColor(R.color.sqaure_post_info_text_1));
            textView4.setTextColor(this.b.getResources().getColor(R.color.sqaure_post_info_text_1));
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(R.drawable.icon_little_comment_n_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            textView4.setCompoundDrawables(bitmapDrawable, null, null, null);
            findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line_1));
        } else {
            view.setBackgroundResource(R.drawable.square_list_item_selector);
            textView.setTextColor(this.b.getResources().getColor(R.color.square_forum_barfolder_name));
            textView2.setTextColor(this.b.getResources().getColor(R.color.square_forum_barfolder_description));
            textView3.setTextColor(this.b.getResources().getColor(R.color.sqaure_post_info_text));
            textView4.setTextColor(this.b.getResources().getColor(R.color.sqaure_post_info_text));
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.b.getResources().getDrawable(R.drawable.icon_little_comment_n);
            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
            textView4.setCompoundDrawables(bitmapDrawable2, null, null, null);
            findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line));
        }
        view.setOnClickListener(new al(this, i, String.valueOf(threadInfo.id)));
    }
}
