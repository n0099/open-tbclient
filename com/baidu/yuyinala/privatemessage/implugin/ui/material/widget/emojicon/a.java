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
    private static b oDK;
    private static b oDL;
    private View kGn;
    private Context mContext;
    private Emojicon[] oDM;
    private Emojicon[] oDN;

    /* loaded from: classes4.dex */
    public interface b {
        void a(Emojicon emojicon);

        void ea(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.oDM = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView dWp() {
        this.kGn = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.kGn.findViewById(a.f.Emoji_GridView);
        this.oDN = new Emojicon[this.oDM.length + 1];
        for (int i = 0; i < this.oDM.length; i++) {
            this.oDN[i] = this.oDM[i];
        }
        f(gridView);
        gridView.setAdapter((ListAdapter) new C0952a(this.mContext, this.oDN));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void f(GridView gridView) {
        int i = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGF, 0);
        if (i > 100) {
            int dimension = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_bar_height);
            int dimension2 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_pager_dot_height)) * 4;
            int dimension3 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_height)) * 3;
            int dimension4 = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_max_space);
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
            oDL = bVar;
            oDK = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void ehc() {
        oDK = null;
        oDL = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (oDK != null) {
            if (i != this.oDN.length - 1) {
                oDK.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                oDK.ea(view);
                return;
            }
        }
        oDK = oDL;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0952a extends ArrayAdapter<Emojicon> {
        public C0952a(Context context, Emojicon[] emojiconArr) {
            super(context, a.g.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.bd_im_emojicon_item, null);
                C0953a c0953a = new C0953a();
                c0953a.icon = (TextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0953a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0953a c0953a2 = (C0953a) view.getTag();
            if (c0953a2 != null && c0953a2.icon != null && item != null) {
                c0953a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0953a {
            TextView icon;

            C0953a() {
            }
        }
    }
}
