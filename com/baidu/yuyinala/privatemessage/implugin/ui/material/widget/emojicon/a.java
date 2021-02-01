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
/* loaded from: classes11.dex */
public class a implements AdapterView.OnItemClickListener {
    private static b peJ;
    private static b peK;
    private View bUP;
    private Context mContext;
    private Emojicon[] peL;
    private Emojicon[] peM;

    /* loaded from: classes11.dex */
    public interface b {
        void a(Emojicon emojicon);

        void aj(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.peL = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView XO() {
        this.bUP = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bUP.findViewById(a.f.Emoji_GridView);
        this.peM = new Emojicon[this.peL.length + 1];
        for (int i = 0; i < this.peL.length; i++) {
            this.peM[i] = this.peL[i];
        }
        c(gridView);
        gridView.setAdapter((ListAdapter) new C0970a(this.mContext, this.peM));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void c(GridView gridView) {
        int k = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.phH, 0);
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
            peK = bVar;
            peJ = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void elu() {
        peJ = null;
        peK = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (peJ != null) {
            if (i != this.peM.length - 1) {
                peJ.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                peJ.aj(view);
                return;
            }
        }
        peJ = peK;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0970a extends ArrayAdapter<Emojicon> {
        public C0970a(Context context, Emojicon[] emojiconArr) {
            super(context, a.g.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.bd_im_emojicon_item, null);
                C0971a c0971a = new C0971a();
                c0971a.icon = (TextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0971a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0971a c0971a2 = (C0971a) view.getTag();
            if (c0971a2 != null && c0971a2.icon != null && item != null) {
                c0971a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C0971a {
            TextView icon;

            C0971a() {
            }
        }
    }
}
