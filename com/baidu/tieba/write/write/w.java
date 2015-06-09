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
    private BaseActivity awm;
    private ImageFileInfo[] cBH;
    private x cBI;
    private y[] cBJ;
    private com.baidu.tbadk.coreExtra.view.j[] cBK;
    private int cBL;
    private int cBM;
    private int mCount;
    private int mCurrentIndex;
    private ViewPager mViewPager;

    public w(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, x xVar) {
        int i2 = 0;
        this.awm = null;
        this.cBH = null;
        this.mViewPager = null;
        this.cBI = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.cBJ = null;
        this.cBK = null;
        this.cBL = 120;
        this.cBM = 120;
        this.awm = baseActivity;
        this.cBL = (int) baseActivity.getResources().getDimension(com.baidu.tieba.o.motu_image_size_width);
        this.cBM = (int) baseActivity.getResources().getDimension(com.baidu.tieba.o.motu_image_size_height);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.cBH = new ImageFileInfo[this.mCount];
        this.cBJ = new y[this.mCount];
        this.cBK = new com.baidu.tbadk.coreExtra.view.j[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.cBH[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cBH[i3].addPageAction(com.baidu.tbadk.img.effect.d.y(this.cBL, this.cBM));
                linkedList.set(i3, this.cBH[i3]);
                i2 = i3 + 1;
            } else {
                this.mCurrentIndex = i;
                this.mViewPager = viewPager;
                this.cBI = xVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jC(int i) {
        if (this.cBJ[this.mCurrentIndex].asY()) {
            this.cBH[this.mCurrentIndex].addPageAction(com.baidu.tbadk.img.effect.e.dP(i));
            if (this.cBK[this.mCurrentIndex] != null) {
                String selectedFilter = this.cBK[this.mCurrentIndex].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cBH[this.mCurrentIndex].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.eN(selectedFilter));
                    this.cBJ[this.mCurrentIndex].i(cloneWithoutFilterAction);
                    return;
                }
                this.cBJ[this.mCurrentIndex].i(this.cBH[this.mCurrentIndex]);
                return;
            }
            this.cBJ[this.mCurrentIndex].i(this.cBH[this.mCurrentIndex]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void ef(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cBH[this.mCurrentIndex].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.eN(str));
            this.cBJ[this.mCurrentIndex].i(cloneWithoutFilterAction);
            return;
        }
        this.cBJ[this.mCurrentIndex].i(this.cBH[this.mCurrentIndex]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cBJ[i] == null) {
            this.cBJ[i] = new y(this, i);
        }
        this.mViewPager.addView(this.cBJ[i].getView());
        return this.cBJ[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.cBJ[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        asT();
        if (this.cBI != null) {
            this.cBI.a(this.cBK[i], i);
        }
    }

    private void asT() {
        if (this.mCurrentIndex >= 0) {
            if (this.cBJ != null) {
                for (int i = 0; i < this.cBJ.length; i++) {
                    if (this.cBJ[i] != null) {
                        this.cBJ[i].apJ();
                    }
                }
                if (this.cBJ[this.mCurrentIndex] == null) {
                    this.cBJ[this.mCurrentIndex] = new y(this, this.mCurrentIndex);
                }
            }
            String selectedFilter = this.cBK[this.mCurrentIndex].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cBH[this.mCurrentIndex].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.eN(selectedFilter));
                this.cBJ[this.mCurrentIndex].i(cloneWithoutFilterAction);
                return;
            }
            this.cBJ[this.mCurrentIndex].i(this.cBH[this.mCurrentIndex]);
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
        this.cBK[i] = new com.baidu.tbadk.coreExtra.view.j(this.awm, this, str);
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
    public void asU() {
        String selectedFilter;
        for (int i = 0; i < this.cBH.length; i++) {
            this.cBH[i].applayRotatePageActionToPersistAction();
            if (this.cBK[i] != null && (selectedFilter = this.cBK[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cBH[i].addPersistAction(com.baidu.tbadk.img.effect.a.eN(selectedFilter));
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
