package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.Emojicon;
/* loaded from: classes10.dex */
public class a implements AdapterView.OnItemClickListener {
    private static b pho;
    private static b php;
    private View bWp;
    private Context mContext;
    private Emojicon[] phq;
    private Emojicon[] phr;

    /* loaded from: classes10.dex */
    public interface b {
        void a(Emojicon emojicon);

        void aj(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.phq = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView XR() {
        this.bWp = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bWp.findViewById(a.f.Emoji_GridView);
        this.phr = new Emojicon[this.phq.length + 1];
        for (int i = 0; i < this.phq.length; i++) {
            this.phr[i] = this.phq[i];
        }
        c(gridView);
        gridView.setAdapter((ListAdapter) new C0978a(this.mContext, this.phr));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void c(GridView gridView) {
        int j = com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkq, 0);
        if (j > 100) {
            int dimension = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_bar_height);
            int dimension2 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_pager_dot_height)) * 4;
            int dimension3 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_height)) * 3;
            int dimension4 = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_max_space);
            int i = (((j - dimension) - dimension2) - dimension3) / 2;
            int i2 = i > 0 ? i : 0;
            if (i2 <= dimension4) {
                dimension4 = i2;
            }
            gridView.setVerticalSpacing(dimension4);
        }
    }

    public static void a(b bVar) {
        if (bVar instanceof b) {
            php = bVar;
            pho = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void elM() {
        pho = null;
        php = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (pho != null) {
            if (i != this.phr.length - 1) {
                pho.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                pho.aj(view);
                return;
            }
        }
        pho = php;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0978a extends ArrayAdapter<Emojicon> {
        public C0978a(Context context, Emojicon[] emojiconArr) {
            super(context, a.g.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.bd_im_emojicon_item, null);
                C0979a c0979a = new C0979a();
                c0979a.icon = (TextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0979a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0979a c0979a2 = (C0979a) view.getTag();
            if (c0979a2 != null && c0979a2.icon != null && item != null) {
                c0979a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C0979a {
            TextView icon;

            C0979a() {
            }
        }
    }
}
