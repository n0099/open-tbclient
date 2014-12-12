package com.baidu.tieba.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends PagerAdapter implements ViewPager.OnPageChangeListener, com.baidu.tbadk.coreExtra.view.o {
    private BaseActivity Ud;
    private ImageFileInfo[] cem;
    private s cen;
    private t[] ceo;
    private com.baidu.tbadk.coreExtra.view.j[] cep;
    private int ceq;
    private int cer;
    private int mCount;
    private int mCurrentIndex;
    private ViewPager mViewPager;

    public r(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, s sVar) {
        int i2 = 0;
        this.Ud = null;
        this.cem = null;
        this.mViewPager = null;
        this.cen = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.ceo = null;
        this.cep = null;
        this.ceq = 120;
        this.cer = 120;
        this.Ud = baseActivity;
        this.ceq = (int) baseActivity.getResources().getDimension(com.baidu.tieba.u.motu_image_size_width);
        this.cer = (int) baseActivity.getResources().getDimension(com.baidu.tieba.u.motu_image_size_height);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.cem = new ImageFileInfo[this.mCount];
        this.ceo = new t[this.mCount];
        this.cep = new com.baidu.tbadk.coreExtra.view.j[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.cem[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cem[i3].addPageAction(com.baidu.tbadk.img.effect.d.z(this.ceq, this.cer));
                linkedList.set(i3, this.cem[i3]);
                i2 = i3 + 1;
            } else {
                this.mCurrentIndex = i;
                this.mViewPager = viewPager;
                this.cen = sVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void in(int i) {
        if (this.ceo[this.mCurrentIndex].ajP()) {
            this.cem[this.mCurrentIndex].addPageAction(com.baidu.tbadk.img.effect.e.ds(i));
            if (this.cep[this.mCurrentIndex] != null) {
                String selectedFilter = this.cep[this.mCurrentIndex].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cem[this.mCurrentIndex].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ep(selectedFilter));
                    this.ceo[this.mCurrentIndex].h(cloneWithoutFilterAction);
                    return;
                }
                this.ceo[this.mCurrentIndex].h(this.cem[this.mCurrentIndex]);
                return;
            }
            this.ceo[this.mCurrentIndex].h(this.cem[this.mCurrentIndex]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void dH(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cem[this.mCurrentIndex].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ep(str));
            this.ceo[this.mCurrentIndex].h(cloneWithoutFilterAction);
            return;
        }
        this.ceo[this.mCurrentIndex].h(this.cem[this.mCurrentIndex]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ceo[i] == null) {
            this.ceo[i] = new t(this, i);
        }
        this.mViewPager.addView(this.ceo[i].getView());
        return this.ceo[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.ceo[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        ajK();
        if (this.cen != null) {
            this.cen.a(this.cep[i], i);
        }
    }

    private void ajK() {
        if (this.mCurrentIndex >= 0) {
            if (this.ceo != null) {
                for (int i = 0; i < this.ceo.length; i++) {
                    if (this.ceo[i] != null) {
                        this.ceo[i].qm();
                    }
                }
                if (this.ceo[this.mCurrentIndex] == null) {
                    this.ceo[this.mCurrentIndex] = new t(this, this.mCurrentIndex);
                }
            }
            String selectedFilter = this.cep[this.mCurrentIndex].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cem[this.mCurrentIndex].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ep(selectedFilter));
                this.ceo[this.mCurrentIndex].h(cloneWithoutFilterAction);
                return;
            }
            this.ceo[this.mCurrentIndex].h(this.cem[this.mCurrentIndex]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurrentIndex;
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
        this.cep[i] = new com.baidu.tbadk.coreExtra.view.j(this.Ud, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ajL() {
        String selectedFilter;
        for (int i = 0; i < this.cem.length; i++) {
            this.cem[i].applayRotatePageActionToPersistAction();
            if (this.cep[i] != null && (selectedFilter = this.cep[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cem[i].addPersistAction(com.baidu.tbadk.img.effect.a.ep(selectedFilter));
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
