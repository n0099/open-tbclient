package com.baidu.yuyinala.privatemessage.implugin.ui.fragment;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.BaseViewPager;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.Emojicon;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.c;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.d;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.e;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.f;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class EmojiconsView implements ViewPager.OnPageChangeListener {
    private LinearLayout ceK;
    private ImageView[] ceL;
    private int ceM = -1;
    private RelativeLayout ceO;
    private LinearLayout ceP;
    private Context mContext;
    private BaseViewPager pfv;
    private View rootView;

    public static EmojiconsView e(Context context, View view) {
        return new EmojiconsView(context, view);
    }

    public EmojiconsView(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.ceO = (RelativeLayout) view.findViewById(a.f.bd_im_emoji_root);
        this.ceP = (LinearLayout) view.findViewById(a.f.emojis_bar);
        this.pfv = (BaseViewPager) view.findViewById(a.f.emojis_pager);
        this.ceK = (LinearLayout) view.findViewById(a.f.emojis_viewgroup);
        this.pfv.setOnPageChangeListener(this);
        a aVar = new a(Arrays.asList(com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, c.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, f.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, e.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.b.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.a.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, d.phv).XR()));
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconsView", "emojisAdapter count =" + aVar.getCount());
        this.pfv.setAdapter(aVar);
        this.ceL = new ImageView[aVar.getCount()];
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 6.0f), 0, com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.ceL[i] = imageView;
            this.ceK.addView(this.ceL[i]);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconsView", "mImageViews length = " + this.ceL.length);
        onPageSelected(0);
    }

    private void fv(int i) {
        for (int i2 = 0; i2 < this.ceL.length; i2++) {
            if (i == i2) {
                this.ceL[i2].setImageResource(a.e.bd_im_round_dot_select);
            } else {
                this.ceL[i2].setImageResource(a.e.bd_im_round_dot_normal);
            }
        }
    }

    public void ZK() {
        this.pfv.setAdapter(new a(Arrays.asList(com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, c.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, f.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, e.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.b.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.a.phv).XR(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, d.phv).XR())));
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("EmojiconsView", "resetCurrentPage");
        onPageSelected(0);
    }

    public static void a(EditText editText, Emojicon emojicon) {
        if (editText != null && emojicon != null) {
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionStart < 0) {
                editText.append(emojicon.getEmoji());
            } else {
                editText.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), emojicon.getEmoji(), 0, emojicon.getEmoji().length());
            }
        }
    }

    public static void o(EditText editText) {
        editText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6));
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.ceM != i) {
            this.ceM = i;
            if (this.ceM >= 0) {
                fv(this.ceM);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes10.dex */
    private static class a extends PagerAdapter {
        private List<View> bbS;

        public a(List<View> list) {
            this.bbS = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ListUtils.getCount(this.bbS);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            View view = this.bbS.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0 && i < getCount()) {
                viewGroup.removeView(this.bbS.get(i));
            }
        }
    }
}
