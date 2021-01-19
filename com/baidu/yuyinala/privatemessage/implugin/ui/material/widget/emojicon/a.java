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
    private static b oUw;
    private static b oUx;
    private View bRa;
    private Context mContext;
    private Emojicon[] oUy;
    private Emojicon[] oUz;

    /* loaded from: classes10.dex */
    public interface b {
        void a(Emojicon emojicon);

        void al(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.oUy = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView Wf() {
        this.bRa = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bRa.findViewById(a.f.Emoji_GridView);
        this.oUz = new Emojicon[this.oUy.length + 1];
        for (int i = 0; i < this.oUy.length; i++) {
            this.oUz[i] = this.oUy[i];
        }
        c(gridView);
        gridView.setAdapter((ListAdapter) new C0966a(this.mContext, this.oUz));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void c(GridView gridView) {
        int k = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXu, 0);
        if (k > 100) {
            int dimension = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_bar_height);
            int dimension2 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_pager_dot_height)) * 4;
            int dimension3 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_height)) * 3;
            int dimension4 = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_max_space);
            int i = (((k - dimension) - dimension2) - dimension3) / 2;
            int i2 = i > 0 ? i : 0;
            if (i2 <= dimension4) {
                dimension4 = i2;
            }
            gridView.setVerticalSpacing(dimension4);
        }
    }

    public static void a(b bVar) {
        if (bVar instanceof b) {
            oUx = bVar;
            oUw = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void eja() {
        oUw = null;
        oUx = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (oUw != null) {
            if (i != this.oUz.length - 1) {
                oUw.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                oUw.al(view);
                return;
            }
        }
        oUw = oUx;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0966a extends ArrayAdapter<Emojicon> {
        public C0966a(Context context, Emojicon[] emojiconArr) {
            super(context, a.g.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.bd_im_emojicon_item, null);
                C0967a c0967a = new C0967a();
                c0967a.icon = (TextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0967a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0967a c0967a2 = (C0967a) view.getTag();
            if (c0967a2 != null && c0967a2.icon != null && item != null) {
                c0967a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C0967a {
            TextView icon;

            C0967a() {
            }
        }
    }
}
