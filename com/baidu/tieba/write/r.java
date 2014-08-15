package com.baidu.tieba.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends PagerAdapter implements ViewPager.OnPageChangeListener, com.baidu.tbadk.coreExtra.view.p {
    private BaseActivity a;
    private ImageFileInfo[] b;
    private ViewPager c;
    private s d;
    private int e;
    private int f;
    private t[] g;
    private com.baidu.tbadk.coreExtra.view.k[] h;
    private int i;
    private int j;

    public r(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, s sVar) {
        int i2 = 0;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = 120;
        this.j = 120;
        this.a = baseActivity;
        this.i = (int) baseActivity.getResources().getDimension(com.baidu.tieba.s.motu_image_size_width);
        this.j = (int) baseActivity.getResources().getDimension(com.baidu.tieba.s.motu_image_size_height);
        if (linkedList != null) {
            this.e = linkedList.size();
        }
        this.b = new ImageFileInfo[this.e];
        this.g = new t[this.e];
        this.h = new com.baidu.tbadk.coreExtra.view.k[this.e];
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                a(linkedList.get(i3), i3);
                this.b[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.b[i3].addPageAction(com.baidu.tbadk.img.effect.d.a(this.i, this.j));
                linkedList.set(i3, this.b[i3]);
                i2 = i3 + 1;
            } else {
                this.f = i;
                this.c = viewPager;
                this.d = sVar;
                this.c.setOffscreenPageLimit(1);
                this.c.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.g[this.f].c()) {
            this.b[this.f].addPageAction(com.baidu.tbadk.img.effect.e.a(i));
            if (this.h[this.f] != null) {
                String selectedFilter = this.h[this.f].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.b[this.f].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.a(selectedFilter));
                    this.g[this.f].a(cloneWithoutFilterAction);
                    return;
                }
                this.g[this.f].a(this.b[this.f]);
                return;
            }
            this.g[this.f].a(this.b[this.f]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.p
    public void a(String str) {
        if (str != null && !str.equals("normal")) {
            ImageFileInfo cloneWithoutFilterAction = this.b[this.f].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.a(str));
            this.g[this.f].a(cloneWithoutFilterAction);
            return;
        }
        this.g[this.f].a(this.b[this.f]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.g[i] == null) {
            this.g[i] = new t(this, i);
        }
        this.c.addView(this.g[i].a());
        return this.g[i].a();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.c.removeView(this.g[i].a());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f = i;
        c();
        if (this.d != null) {
            this.d.a(this.h[i], i);
        }
    }

    private void c() {
        if (this.f >= 0) {
            if (this.g != null) {
                for (int i = 0; i < this.g.length; i++) {
                    if (this.g[i] != null) {
                        this.g[i].b();
                    }
                }
            }
            if (this.g[this.f] == null) {
                this.g[this.f] = new t(this, this.f);
            }
            String selectedFilter = this.h[this.f].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.b[this.f].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.a(selectedFilter));
                this.g[this.f].a(cloneWithoutFilterAction);
                return;
            }
            this.g[this.f].a(this.b[this.f]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        this.h[i] = new com.baidu.tbadk.coreExtra.view.k(this.a, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.e;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        String selectedFilter;
        for (int i = 0; i < this.b.length; i++) {
            this.b[i].applayRotatePageActionToPersistAction();
            if (this.h[i] != null && (selectedFilter = this.h[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.b[i].addPersistAction(com.baidu.tbadk.img.effect.a.a(selectedFilter));
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
