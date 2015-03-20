package com.baidu.tieba.write.write;

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
public class v extends PagerAdapter implements ViewPager.OnPageChangeListener, com.baidu.tbadk.coreExtra.view.o {
    private BaseActivity auA;
    private ImageFileInfo[] cwV;
    private w cwW;
    private x[] cwX;
    private com.baidu.tbadk.coreExtra.view.j[] cwY;
    private int cwZ;
    private int cxa;
    private int mCount;
    private int mCurrentIndex;
    private ViewPager mViewPager;

    public v(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, w wVar) {
        int i2 = 0;
        this.auA = null;
        this.cwV = null;
        this.mViewPager = null;
        this.cwW = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.cwX = null;
        this.cwY = null;
        this.cwZ = 120;
        this.cxa = 120;
        this.auA = baseActivity;
        this.cwZ = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_width);
        this.cxa = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_height);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.cwV = new ImageFileInfo[this.mCount];
        this.cwX = new x[this.mCount];
        this.cwY = new com.baidu.tbadk.coreExtra.view.j[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.cwV[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cwV[i3].addPageAction(com.baidu.tbadk.img.effect.d.x(this.cwZ, this.cxa));
                linkedList.set(i3, this.cwV[i3]);
                i2 = i3 + 1;
            } else {
                this.mCurrentIndex = i;
                this.mViewPager = viewPager;
                this.cwW = wVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jd(int i) {
        if (this.cwX[this.mCurrentIndex].aqS()) {
            this.cwV[this.mCurrentIndex].addPageAction(com.baidu.tbadk.img.effect.e.dG(i));
            if (this.cwY[this.mCurrentIndex] != null) {
                String selectedFilter = this.cwY[this.mCurrentIndex].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cwV[this.mCurrentIndex].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.et(selectedFilter));
                    this.cwX[this.mCurrentIndex].i(cloneWithoutFilterAction);
                    return;
                }
                this.cwX[this.mCurrentIndex].i(this.cwV[this.mCurrentIndex]);
                return;
            }
            this.cwX[this.mCurrentIndex].i(this.cwV[this.mCurrentIndex]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void dL(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cwV[this.mCurrentIndex].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.et(str));
            this.cwX[this.mCurrentIndex].i(cloneWithoutFilterAction);
            return;
        }
        this.cwX[this.mCurrentIndex].i(this.cwV[this.mCurrentIndex]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cwX[i] == null) {
            this.cwX[i] = new x(this, i);
        }
        this.mViewPager.addView(this.cwX[i].getView());
        return this.cwX[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.cwX[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        aqN();
        if (this.cwW != null) {
            this.cwW.a(this.cwY[i], i);
        }
    }

    private void aqN() {
        if (this.mCurrentIndex >= 0) {
            if (this.cwX != null) {
                for (int i = 0; i < this.cwX.length; i++) {
                    if (this.cwX[i] != null) {
                        this.cwX[i].anB();
                    }
                }
                if (this.cwX[this.mCurrentIndex] == null) {
                    this.cwX[this.mCurrentIndex] = new x(this, this.mCurrentIndex);
                }
            }
            String selectedFilter = this.cwY[this.mCurrentIndex].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cwV[this.mCurrentIndex].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.et(selectedFilter));
                this.cwX[this.mCurrentIndex].i(cloneWithoutFilterAction);
                return;
            }
            this.cwX[this.mCurrentIndex].i(this.cwV[this.mCurrentIndex]);
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
        this.cwY[i] = new com.baidu.tbadk.coreExtra.view.j(this.auA, this, str);
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
    public void aqO() {
        String selectedFilter;
        for (int i = 0; i < this.cwV.length; i++) {
            this.cwV[i].applayRotatePageActionToPersistAction();
            if (this.cwY[i] != null && (selectedFilter = this.cwY[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cwV[i].addPersistAction(com.baidu.tbadk.img.effect.a.et(selectedFilter));
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
