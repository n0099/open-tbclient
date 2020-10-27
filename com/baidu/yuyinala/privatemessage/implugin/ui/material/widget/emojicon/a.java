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
/* loaded from: classes4.dex */
public class a implements AdapterView.OnItemClickListener {
    private static b osN;
    private static b osO;
    private View kAe;
    private Context mContext;
    private Emojicon[] osP;
    private Emojicon[] osQ;

    /* loaded from: classes4.dex */
    public interface b {
        void a(Emojicon emojicon);

        void dL(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.osP = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView dTQ() {
        this.kAe = LayoutInflater.from(this.mContext).inflate(a.h.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.kAe.findViewById(a.g.Emoji_GridView);
        this.osQ = new Emojicon[this.osP.length + 1];
        for (int i = 0; i < this.osP.length; i++) {
            this.osQ[i] = this.osP[i];
        }
        f(gridView);
        gridView.setAdapter((ListAdapter) new C0931a(this.mContext, this.osQ));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void f(GridView gridView) {
        int i = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovJ, 0);
        if (i > 100) {
            int dimension = (int) this.mContext.getResources().getDimension(a.e.bd_im_emoji_bar_height);
            int dimension2 = ((int) this.mContext.getResources().getDimension(a.e.bd_im_emoji_pager_dot_height)) * 4;
            int dimension3 = ((int) this.mContext.getResources().getDimension(a.e.bd_im_emoji_row_height)) * 3;
            int dimension4 = (int) this.mContext.getResources().getDimension(a.e.bd_im_emoji_row_max_space);
            int i2 = (((i - dimension) - dimension2) - dimension3) / 2;
            int i3 = i2 > 0 ? i2 : 0;
            if (i3 <= dimension4) {
                dimension4 = i3;
            }
            gridView.setVerticalSpacing(dimension4);
        }
    }

    public static void a(b bVar) {
        if (bVar instanceof b) {
            osO = bVar;
            osN = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void edp() {
        osN = null;
        osO = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (osN != null) {
            if (i != this.osQ.length - 1) {
                osN.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                osN.dL(view);
                return;
            }
        }
        osN = osO;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0931a extends ArrayAdapter<Emojicon> {
        public C0931a(Context context, Emojicon[] emojiconArr) {
            super(context, a.h.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.h.bd_im_emojicon_item, null);
                C0932a c0932a = new C0932a();
                c0932a.icon = (TextView) view.findViewById(a.g.emojicon_icon);
                view.setTag(c0932a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.h.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0932a c0932a2 = (C0932a) view.getTag();
            if (c0932a2 != null && c0932a2.icon != null && item != null) {
                c0932a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0932a {
            TextView icon;

            C0932a() {
            }
        }
    }
}
