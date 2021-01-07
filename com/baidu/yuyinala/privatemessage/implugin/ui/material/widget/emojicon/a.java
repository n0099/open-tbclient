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
    private static b oYX;
    private static b oYY;
    private View bVM;
    private Context mContext;
    private Emojicon[] oYZ;
    private Emojicon[] oZa;

    /* loaded from: classes11.dex */
    public interface b {
        void a(Emojicon emojicon);

        void al(View view);
    }

    public static a a(Context context, Emojicon[] emojiconArr) {
        return new a(context, emojiconArr);
    }

    public a(Context context, Emojicon[] emojiconArr) {
        this.oYZ = emojiconArr;
        this.mContext = context;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "EmojiconGridFragment is creating, emojicons.length = " + emojiconArr.length);
    }

    public GridView ZY() {
        this.bVM = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bVM.findViewById(a.f.Emoji_GridView);
        this.oZa = new Emojicon[this.oYZ.length + 1];
        for (int i = 0; i < this.oYZ.length; i++) {
            this.oZa[i] = this.oYZ[i];
        }
        c(gridView);
        gridView.setAdapter((ListAdapter) new C0983a(this.mContext, this.oZa));
        gridView.setOnItemClickListener(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconGridFragment", "onViewCreated, gridView.count = " + gridView.getCount());
        return gridView;
    }

    private void c(GridView gridView) {
        int k = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbX, 0);
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
            oYY = bVar;
            oYX = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    public static void emU() {
        oYX = null;
        oYY = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (oYX != null) {
            if (i != this.oZa.length - 1) {
                oYX.a((Emojicon) adapterView.getItemAtPosition(i));
                return;
            } else {
                oYX.al(view);
                return;
            }
        }
        oYX = oYY;
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconGridFragment", "mOnEmojiconClickedListener is null");
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0983a extends ArrayAdapter<Emojicon> {
        public C0983a(Context context, Emojicon[] emojiconArr) {
            super(context, a.g.bd_im_emojicon_item, emojiconArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.bd_im_emojicon_item, null);
                C0984a c0984a = new C0984a();
                c0984a.icon = (TextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0984a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            Emojicon item = getItem(i);
            C0984a c0984a2 = (C0984a) view.getTag();
            if (c0984a2 != null && c0984a2.icon != null && item != null) {
                c0984a2.icon.setText(item.getEmoji());
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C0984a {
            TextView icon;

            C0984a() {
            }
        }
    }
}
