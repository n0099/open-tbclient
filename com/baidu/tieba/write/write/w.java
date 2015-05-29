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
public class w extends PagerAdapter implements ViewPager.OnPageChangeListener, com.baidu.tbadk.coreExtra.view.o {
    private BaseActivity awl;
    private ImageFileInfo[] cBG;
    private x cBH;
    private y[] cBI;
    private com.baidu.tbadk.coreExtra.view.j[] cBJ;
    private int cBK;
    private int cBL;
    private int mCount;
    private int mCurrentIndex;
    private ViewPager mViewPager;

    public w(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, x xVar) {
        int i2 = 0;
        this.awl = null;
        this.cBG = null;
        this.mViewPager = null;
        this.cBH = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.cBI = null;
        this.cBJ = null;
        this.cBK = 120;
        this.cBL = 120;
        this.awl = baseActivity;
        this.cBK = (int) baseActivity.getResources().getDimension(com.baidu.tieba.o.motu_image_size_width);
        this.cBL = (int) baseActivity.getResources().getDimension(com.baidu.tieba.o.motu_image_size_height);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.cBG = new ImageFileInfo[this.mCount];
        this.cBI = new y[this.mCount];
        this.cBJ = new com.baidu.tbadk.coreExtra.view.j[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.cBG[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cBG[i3].addPageAction(com.baidu.tbadk.img.effect.d.y(this.cBK, this.cBL));
                linkedList.set(i3, this.cBG[i3]);
                i2 = i3 + 1;
            } else {
                this.mCurrentIndex = i;
                this.mViewPager = viewPager;
                this.cBH = xVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jC(int i) {
        if (this.cBI[this.mCurrentIndex].asX()) {
            this.cBG[this.mCurrentIndex].addPageAction(com.baidu.tbadk.img.effect.e.dP(i));
            if (this.cBJ[this.mCurrentIndex] != null) {
                String selectedFilter = this.cBJ[this.mCurrentIndex].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cBG[this.mCurrentIndex].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.eN(selectedFilter));
                    this.cBI[this.mCurrentIndex].i(cloneWithoutFilterAction);
                    return;
                }
                this.cBI[this.mCurrentIndex].i(this.cBG[this.mCurrentIndex]);
                return;
            }
            this.cBI[this.mCurrentIndex].i(this.cBG[this.mCurrentIndex]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void ef(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cBG[this.mCurrentIndex].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.eN(str));
            this.cBI[this.mCurrentIndex].i(cloneWithoutFilterAction);
            return;
        }
        this.cBI[this.mCurrentIndex].i(this.cBG[this.mCurrentIndex]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cBI[i] == null) {
            this.cBI[i] = new y(this, i);
        }
        this.mViewPager.addView(this.cBI[i].getView());
        return this.cBI[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.cBI[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        asS();
        if (this.cBH != null) {
            this.cBH.a(this.cBJ[i], i);
        }
    }

    private void asS() {
        if (this.mCurrentIndex >= 0) {
            if (this.cBI != null) {
                for (int i = 0; i < this.cBI.length; i++) {
                    if (this.cBI[i] != null) {
                        this.cBI[i].apI();
                    }
                }
                if (this.cBI[this.mCurrentIndex] == null) {
                    this.cBI[this.mCurrentIndex] = new y(this, this.mCurrentIndex);
                }
            }
            String selectedFilter = this.cBJ[this.mCurrentIndex].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cBG[this.mCurrentIndex].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.eN(selectedFilter));
                this.cBI[this.mCurrentIndex].i(cloneWithoutFilterAction);
                return;
            }
            this.cBI[this.mCurrentIndex].i(this.cBG[this.mCurrentIndex]);
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
        this.cBJ[i] = new com.baidu.tbadk.coreExtra.view.j(this.awl, this, str);
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
    public void asT() {
        String selectedFilter;
        for (int i = 0; i < this.cBG.length; i++) {
            this.cBG[i].applayRotatePageActionToPersistAction();
            if (this.cBJ[i] != null && (selectedFilter = this.cBJ[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cBG[i].addPersistAction(com.baidu.tbadk.img.effect.a.eN(selectedFilter));
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
