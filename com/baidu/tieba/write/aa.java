package com.baidu.tieba.write;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.effects.ImageOperation;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class aa extends PagerAdapter implements ViewPager.OnPageChangeListener, z {
    private Context a;
    private ImageFileInfo[] b;
    private ViewPager c;
    private ab d;
    private int e;
    private int f;
    private ac[] g;
    private v[] h;
    private int i;
    private int j;

    public aa(Context context, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, ab abVar) {
        int i2 = 0;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.j = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.a = context;
        this.i = (int) context.getResources().getDimension(R.dimen.motu_image_size_width);
        this.j = (int) context.getResources().getDimension(R.dimen.motu_image_size_height);
        if (linkedList != null) {
            this.e = linkedList.size();
        }
        this.b = new ImageFileInfo[this.e];
        this.g = new ac[this.e];
        this.h = new v[this.e];
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                a(linkedList.get(i3), i3);
                this.b[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.b[i3].addPageAction(com.baidu.tieba.img.effects.d.a(this.i, this.j));
                linkedList.set(i3, this.b[i3]);
                i2 = i3 + 1;
            } else {
                this.f = i;
                this.c = viewPager;
                this.d = abVar;
                this.c.setOffscreenPageLimit(1);
                this.c.setOnPageChangeListener(this);
                return;
            }
        }
    }

    public void a(int i) {
        if (this.g[this.f].b()) {
            this.b[this.f].addPageAction(com.baidu.tieba.img.effects.e.a(i));
            if (this.h[this.f] != null) {
                String selectedFilter = this.h[this.f].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.b[this.f].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tieba.img.effects.a.a(selectedFilter));
                    this.g[this.f].a(cloneWithoutFilterAction);
                    return;
                }
                this.g[this.f].a(this.b[this.f]);
                return;
            }
            this.g[this.f].a(this.b[this.f]);
        }
    }

    @Override // com.baidu.tieba.write.z
    public void a(String str) {
        if (str != null && !str.equals("normal")) {
            ImageFileInfo cloneWithoutFilterAction = this.b[this.f].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tieba.img.effects.a.a(str));
            this.g[this.f].a(cloneWithoutFilterAction);
            return;
        }
        this.g[this.f].a(this.b[this.f]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.g[i] == null) {
            this.g[i] = new ac(this, i);
        }
        this.c.addView(this.g[i].a());
        return this.g[i].a();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.g[i] != null) {
            this.g[i].c();
        }
        this.h[i].a();
        this.c.removeView(this.g[i].a());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f = i;
        if (this.g[i] == null) {
            this.g[i] = new ac(this, i);
        }
        this.h[i].a(this.b[i]);
        String selectedFilter = this.h[i].getSelectedFilter();
        if (selectedFilter != null && !selectedFilter.equals("normal")) {
            ImageFileInfo cloneWithoutFilterAction = this.b[i].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tieba.img.effects.a.a(selectedFilter));
            this.g[i].a(cloneWithoutFilterAction);
        } else {
            this.g[i].a(this.b[i]);
        }
        if (this.d != null) {
            this.d.a(this.h[i], i);
        }
    }

    public int a() {
        return this.f;
    }

    private void a(ImageFileInfo imageFileInfo, int i) {
        String str;
        if (imageFileInfo.getPersistActionsList() != null) {
            Iterator<ImageOperation> it = imageFileInfo.getPersistActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if ("filter".equals(next.actionName)) {
                    str = next.actionParam;
                    break;
                }
            }
        }
        str = null;
        this.h[i] = new v(this.a, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.e;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void b() {
        String selectedFilter;
        for (int i = 0; i < this.b.length; i++) {
            this.b[i].applayRotatePageActionToPersistAction();
            if (this.h[i] != null && (selectedFilter = this.h[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.b[i].addPersistAction(com.baidu.tieba.img.effects.a.a(selectedFilter));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
