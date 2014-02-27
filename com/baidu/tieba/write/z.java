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
public final class z extends PagerAdapter implements ViewPager.OnPageChangeListener, y {
    private Context a;
    private ImageFileInfo[] b;
    private ViewPager c;
    private aa d;
    private int e;
    private int f;
    private ab[] g;
    private v[] h;
    private int i;
    private int j;

    public z(Context context, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, aa aaVar) {
        String str;
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
        this.g = new ab[this.e];
        this.h = new v[this.e];
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                ImageFileInfo imageFileInfo = linkedList.get(i3);
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
                this.h[i3] = new v(this.a, this, str);
                this.b[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.b[i3].addPageAction(com.baidu.tieba.img.effects.d.a(this.i, this.j));
                linkedList.set(i3, this.b[i3]);
                i2 = i3 + 1;
            } else {
                this.f = i;
                this.c = viewPager;
                this.d = aaVar;
                this.c.setOffscreenPageLimit(1);
                this.c.setOnPageChangeListener(this);
                return;
            }
        }
    }

    public final void a(int i) {
        if (this.g[this.f].c()) {
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

    @Override // com.baidu.tieba.write.y
    public final void a(String str) {
        if (str != null && !str.equals("normal")) {
            ImageFileInfo cloneWithoutFilterAction = this.b[this.f].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tieba.img.effects.a.a(str));
            this.g[this.f].a(cloneWithoutFilterAction);
            return;
        }
        this.g[this.f].a(this.b[this.f]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.g[i] == null) {
            this.g[i] = new ab(this, i);
        }
        this.c.addView(this.g[i].a());
        return this.g[i].a();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.c.removeView(this.g[i].a());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        this.f = i;
        if (this.f >= 0) {
            if (this.g != null) {
                for (int i2 = 0; i2 < this.g.length; i2++) {
                    if (this.g[i2] != null) {
                        this.g[i2].b();
                    }
                }
            }
            if (this.g[this.f] == null) {
                this.g[this.f] = new ab(this, this.f);
            }
            String selectedFilter = this.h[this.f].getSelectedFilter();
            if (selectedFilter == null || selectedFilter.equals("normal")) {
                this.g[this.f].a(this.b[this.f]);
            } else {
                ImageFileInfo cloneWithoutFilterAction = this.b[this.f].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tieba.img.effects.a.a(selectedFilter));
                this.g[this.f].a(cloneWithoutFilterAction);
            }
        }
        if (this.d != null) {
            this.d.a(this.h[i], i);
        }
    }

    public final int a() {
        return this.f;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.e;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void b() {
        String selectedFilter;
        for (int i = 0; i < this.b.length; i++) {
            this.b[i].applayRotatePageActionToPersistAction();
            if (this.h[i] != null && (selectedFilter = this.h[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.b[i].addPersistAction(com.baidu.tieba.img.effects.a.a(selectedFilter));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }
}
