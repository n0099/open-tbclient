package com.baidu.yuyinala.privatemessage.implugin.ui.fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
/* loaded from: classes4.dex */
public class EmojiconsFragment implements ViewPager.OnPageChangeListener {
    private Context mContext;
    private LinearLayout oBM;
    private ImageView[] oBN;
    private int oBO = -1;
    private BaseViewPager oBP;
    private RelativeLayout oBQ;
    private LinearLayout oBR;
    private View rootView;

    public static EmojiconsFragment d(Context context, View view) {
        return new EmojiconsFragment(context, view);
    }

    public EmojiconsFragment(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.oBQ = (RelativeLayout) view.findViewById(a.f.bd_im_emoji_root);
        this.oBR = (LinearLayout) view.findViewById(a.f.emojis_bar);
        this.oBP = (BaseViewPager) view.findViewById(a.f.emojis_pager);
        this.oBM = (LinearLayout) view.findViewById(a.f.emojis_viewgroup);
        this.oBP.setOnPageChangeListener(this);
        a aVar = new a(Arrays.asList(com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, c.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, f.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, e.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.b.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.a.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, d.oDR).dWp()));
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconsFragment", "emojisAdapter count =" + aVar.getCount());
        this.oBP.setAdapter(aVar);
        this.oBN = new ImageView[aVar.getCount()];
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 6.0f), 0, com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.oBN[i] = imageView;
            this.oBM.addView(this.oBN[i]);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("EmojiconsFragment", "mImageViews length = " + this.oBN.length);
        onPageSelected(0);
    }

    private void Og(int i) {
        for (int i2 = 0; i2 < this.oBN.length; i2++) {
            if (i == i2) {
                this.oBN[i2].setImageResource(a.e.bd_im_round_dot_select);
            } else {
                this.oBN[i2].setImageResource(a.e.bd_im_round_dot_normal);
            }
        }
    }

    public void egB() {
        this.oBP.setAdapter(new a(Arrays.asList(com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, c.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, f.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, e.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.b.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.a.oDR).dWp(), com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this.mContext, d.oDR).dWp())));
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("EmojiconsFragment", "resetCurrentPage");
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

    public static void n(EditText editText) {
        editText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6));
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.oBO != i) {
            this.oBO = i;
            if (this.oBO >= 0) {
                Og(this.oBO);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes4.dex */
    private static class a extends PagerAdapter {
        private List<View> aXd;

        public a(List<View> list) {
            this.aXd = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ListUtils.getCount(this.aXd);
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            View view = this.aXd.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0 && i < getCount()) {
                viewGroup.removeView(this.aXd.get(i));
            }
        }
    }
}
