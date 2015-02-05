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
    private BaseActivity UG;
    private ImageFileInfo[] cfK;
    private s cfL;
    private t[] cfM;
    private com.baidu.tbadk.coreExtra.view.j[] cfN;
    private int cfO;
    private int cfP;
    private int mCount;
    private int mCurrentIndex;
    private ViewPager mViewPager;

    public r(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, s sVar) {
        int i2 = 0;
        this.UG = null;
        this.cfK = null;
        this.mViewPager = null;
        this.cfL = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.cfM = null;
        this.cfN = null;
        this.cfO = 120;
        this.cfP = 120;
        this.UG = baseActivity;
        this.cfO = (int) baseActivity.getResources().getDimension(com.baidu.tieba.u.motu_image_size_width);
        this.cfP = (int) baseActivity.getResources().getDimension(com.baidu.tieba.u.motu_image_size_height);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.cfK = new ImageFileInfo[this.mCount];
        this.cfM = new t[this.mCount];
        this.cfN = new com.baidu.tbadk.coreExtra.view.j[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.cfK[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cfK[i3].addPageAction(com.baidu.tbadk.img.effect.d.z(this.cfO, this.cfP));
                linkedList.set(i3, this.cfK[i3]);
                i2 = i3 + 1;
            } else {
                this.mCurrentIndex = i;
                this.mViewPager = viewPager;
                this.cfL = sVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void is(int i) {
        if (this.cfM[this.mCurrentIndex].akh()) {
            this.cfK[this.mCurrentIndex].addPageAction(com.baidu.tbadk.img.effect.e.dz(i));
            if (this.cfN[this.mCurrentIndex] != null) {
                String selectedFilter = this.cfN[this.mCurrentIndex].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cfK[this.mCurrentIndex].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.em(selectedFilter));
                    this.cfM[this.mCurrentIndex].h(cloneWithoutFilterAction);
                    return;
                }
                this.cfM[this.mCurrentIndex].h(this.cfK[this.mCurrentIndex]);
                return;
            }
            this.cfM[this.mCurrentIndex].h(this.cfK[this.mCurrentIndex]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void dD(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cfK[this.mCurrentIndex].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.em(str));
            this.cfM[this.mCurrentIndex].h(cloneWithoutFilterAction);
            return;
        }
        this.cfM[this.mCurrentIndex].h(this.cfK[this.mCurrentIndex]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cfM[i] == null) {
            this.cfM[i] = new t(this, i);
        }
        this.mViewPager.addView(this.cfM[i].getView());
        return this.cfM[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.cfM[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        akc();
        if (this.cfL != null) {
            this.cfL.a(this.cfN[i], i);
        }
    }

    private void akc() {
        if (this.mCurrentIndex >= 0) {
            if (this.cfM != null) {
                for (int i = 0; i < this.cfM.length; i++) {
                    if (this.cfM[i] != null) {
                        this.cfM[i].qq();
                    }
                }
                if (this.cfM[this.mCurrentIndex] == null) {
                    this.cfM[this.mCurrentIndex] = new t(this, this.mCurrentIndex);
                }
            }
            String selectedFilter = this.cfN[this.mCurrentIndex].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cfK[this.mCurrentIndex].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.em(selectedFilter));
                this.cfM[this.mCurrentIndex].h(cloneWithoutFilterAction);
                return;
            }
            this.cfM[this.mCurrentIndex].h(this.cfK[this.mCurrentIndex]);
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
        this.cfN[i] = new com.baidu.tbadk.coreExtra.view.j(this.UG, this, str);
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
    public void akd() {
        String selectedFilter;
        for (int i = 0; i < this.cfK.length; i++) {
            this.cfK[i].applayRotatePageActionToPersistAction();
            if (this.cfN[i] != null && (selectedFilter = this.cfN[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cfK[i].addPersistAction(com.baidu.tbadk.img.effect.a.em(selectedFilter));
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
