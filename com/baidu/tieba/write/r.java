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
    private BaseActivity UJ;
    private ImageFileInfo[] cfL;
    private s cfM;
    private t[] cfN;
    private com.baidu.tbadk.coreExtra.view.j[] cfO;
    private int cfP;
    private int cfQ;
    private int mCount;
    private int mCurrentIndex;
    private ViewPager mViewPager;

    public r(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, s sVar) {
        int i2 = 0;
        this.UJ = null;
        this.cfL = null;
        this.mViewPager = null;
        this.cfM = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.cfN = null;
        this.cfO = null;
        this.cfP = 120;
        this.cfQ = 120;
        this.UJ = baseActivity;
        this.cfP = (int) baseActivity.getResources().getDimension(com.baidu.tieba.u.motu_image_size_width);
        this.cfQ = (int) baseActivity.getResources().getDimension(com.baidu.tieba.u.motu_image_size_height);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.cfL = new ImageFileInfo[this.mCount];
        this.cfN = new t[this.mCount];
        this.cfO = new com.baidu.tbadk.coreExtra.view.j[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.cfL[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cfL[i3].addPageAction(com.baidu.tbadk.img.effect.d.z(this.cfP, this.cfQ));
                linkedList.set(i3, this.cfL[i3]);
                i2 = i3 + 1;
            } else {
                this.mCurrentIndex = i;
                this.mViewPager = viewPager;
                this.cfM = sVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void is(int i) {
        if (this.cfN[this.mCurrentIndex].akm()) {
            this.cfL[this.mCurrentIndex].addPageAction(com.baidu.tbadk.img.effect.e.dz(i));
            if (this.cfO[this.mCurrentIndex] != null) {
                String selectedFilter = this.cfO[this.mCurrentIndex].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cfL[this.mCurrentIndex].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ep(selectedFilter));
                    this.cfN[this.mCurrentIndex].h(cloneWithoutFilterAction);
                    return;
                }
                this.cfN[this.mCurrentIndex].h(this.cfL[this.mCurrentIndex]);
                return;
            }
            this.cfN[this.mCurrentIndex].h(this.cfL[this.mCurrentIndex]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void dG(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cfL[this.mCurrentIndex].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ep(str));
            this.cfN[this.mCurrentIndex].h(cloneWithoutFilterAction);
            return;
        }
        this.cfN[this.mCurrentIndex].h(this.cfL[this.mCurrentIndex]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cfN[i] == null) {
            this.cfN[i] = new t(this, i);
        }
        this.mViewPager.addView(this.cfN[i].getView());
        return this.cfN[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.cfN[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        akh();
        if (this.cfM != null) {
            this.cfM.a(this.cfO[i], i);
        }
    }

    private void akh() {
        if (this.mCurrentIndex >= 0) {
            if (this.cfN != null) {
                for (int i = 0; i < this.cfN.length; i++) {
                    if (this.cfN[i] != null) {
                        this.cfN[i].qx();
                    }
                }
                if (this.cfN[this.mCurrentIndex] == null) {
                    this.cfN[this.mCurrentIndex] = new t(this, this.mCurrentIndex);
                }
            }
            String selectedFilter = this.cfO[this.mCurrentIndex].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cfL[this.mCurrentIndex].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ep(selectedFilter));
                this.cfN[this.mCurrentIndex].h(cloneWithoutFilterAction);
                return;
            }
            this.cfN[this.mCurrentIndex].h(this.cfL[this.mCurrentIndex]);
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
        this.cfO[i] = new com.baidu.tbadk.coreExtra.view.j(this.UJ, this, str);
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
    public void aki() {
        String selectedFilter;
        for (int i = 0; i < this.cfL.length; i++) {
            this.cfL[i].applayRotatePageActionToPersistAction();
            if (this.cfO[i] != null && (selectedFilter = this.cfO[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cfL[i].addPersistAction(com.baidu.tbadk.img.effect.a.ep(selectedFilter));
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
