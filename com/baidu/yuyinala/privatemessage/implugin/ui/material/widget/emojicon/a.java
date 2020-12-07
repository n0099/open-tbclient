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
    private static b oSQ;
    private static b oSR;
    private View kTF;
    private Context mContext;
    private Emojicon[] oSS;
    private Emojicon[] oST;

    /* loaded from: classes4.dex */
    public interface b {
        void a(Emojicon emojicon);

        void el(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.oSS = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView ebM() {
        this.kTF = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.kTF.findViewById(a.f.Emoji_GridView);
        this.oST = new Emojicon[this.oSS.length + 1];
        for (int i = 0; i < this.oSS.length; i++) {
            this.oST[i] = this.oSS[i];
        }
        f(gridView);
        gridView.setAdapter((ListAdapter) new C0969a(this.mContext, this.oST));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void f(GridView gridView) {
        int j = com.baidu.yuyinala.privatemessage.implugin.util.b.b.j(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVL, 0);
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
            oSR = bVar;
            oSQ = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void emQ() {
        oSQ = null;
        oSR = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (oSQ != null) {
            if (i != this.oST.length - 1) {
                oSQ.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                oSQ.el(view);
                return;
            }
        }
        oSQ = oSR;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0969a extends ArrayAdapter<Emojicon> {
        public C0969a(Context context, Emojicon[] emojiconArr) {
            super(context, a.g.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.bd_im_emojicon_item, null);
                C0970a c0970a = new C0970a();
                c0970a.icon = (TextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0970a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0970a c0970a2 = (C0970a) view.getTag();
            if (c0970a2 != null && c0970a2.icon != null && item != null) {
                c0970a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0970a {
            TextView icon;

            C0970a() {
            }
        }
    }
}
