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
    private static b pfj;
    private static b pfk;
    private View bUP;
    private Context mContext;
    private Emojicon[] pfl;
    private Emojicon[] pfm;

    /* loaded from: classes11.dex */
    public interface b {
        void a(Emojicon emojicon);

        void aj(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.pfl = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView XO() {
        this.bUP = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bUP.findViewById(a.f.Emoji_GridView);
        this.pfm = new Emojicon[this.pfl.length + 1];
        for (int i = 0; i < this.pfl.length; i++) {
            this.pfm[i] = this.pfl[i];
        }
        c(gridView);
        gridView.setAdapter((ListAdapter) new C0972a(this.mContext, this.pfm));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void c(GridView gridView) {
        int k = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pij, 0);
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
            pfk = bVar;
            pfj = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void elC() {
        pfj = null;
        pfk = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (pfj != null) {
            if (i != this.pfm.length - 1) {
                pfj.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                pfj.aj(view);
                return;
            }
        }
        pfj = pfk;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0972a extends ArrayAdapter<Emojicon> {
        public C0972a(Context context, Emojicon[] emojiconArr) {
            super(context, a.g.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.bd_im_emojicon_item, null);
                C0973a c0973a = new C0973a();
                c0973a.icon = (TextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0973a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0973a c0973a2 = (C0973a) view.getTag();
            if (c0973a2 != null && c0973a2.icon != null && item != null) {
                c0973a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C0973a {
            TextView icon;

            C0973a() {
            }
        }
    }
}
