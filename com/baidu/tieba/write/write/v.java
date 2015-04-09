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
    private BaseActivity auI;
    private ImageFileInfo[] cxo;
    private w cxp;
    private x[] cxq;
    private com.baidu.tbadk.coreExtra.view.j[] cxr;
    private int cxs;
    private int cxt;
    private int mCount;
    private int mCurrentIndex;
    private ViewPager mViewPager;

    public v(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, w wVar) {
        int i2 = 0;
        this.auI = null;
        this.cxo = null;
        this.mViewPager = null;
        this.cxp = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.cxq = null;
        this.cxr = null;
        this.cxs = 120;
        this.cxt = 120;
        this.auI = baseActivity;
        this.cxs = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_width);
        this.cxt = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_height);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.cxo = new ImageFileInfo[this.mCount];
        this.cxq = new x[this.mCount];
        this.cxr = new com.baidu.tbadk.coreExtra.view.j[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.cxo[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cxo[i3].addPageAction(com.baidu.tbadk.img.effect.d.x(this.cxs, this.cxt));
                linkedList.set(i3, this.cxo[i3]);
                i2 = i3 + 1;
            } else {
                this.mCurrentIndex = i;
                this.mViewPager = viewPager;
                this.cxp = wVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jg(int i) {
        if (this.cxq[this.mCurrentIndex].arh()) {
            this.cxo[this.mCurrentIndex].addPageAction(com.baidu.tbadk.img.effect.e.dG(i));
            if (this.cxr[this.mCurrentIndex] != null) {
                String selectedFilter = this.cxr[this.mCurrentIndex].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cxo[this.mCurrentIndex].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ew(selectedFilter));
                    this.cxq[this.mCurrentIndex].i(cloneWithoutFilterAction);
                    return;
                }
                this.cxq[this.mCurrentIndex].i(this.cxo[this.mCurrentIndex]);
                return;
            }
            this.cxq[this.mCurrentIndex].i(this.cxo[this.mCurrentIndex]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void dO(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cxo[this.mCurrentIndex].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ew(str));
            this.cxq[this.mCurrentIndex].i(cloneWithoutFilterAction);
            return;
        }
        this.cxq[this.mCurrentIndex].i(this.cxo[this.mCurrentIndex]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cxq[i] == null) {
            this.cxq[i] = new x(this, i);
        }
        this.mViewPager.addView(this.cxq[i].getView());
        return this.cxq[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.cxq[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        arc();
        if (this.cxp != null) {
            this.cxp.a(this.cxr[i], i);
        }
    }

    private void arc() {
        if (this.mCurrentIndex >= 0) {
            if (this.cxq != null) {
                for (int i = 0; i < this.cxq.length; i++) {
                    if (this.cxq[i] != null) {
                        this.cxq[i].anQ();
                    }
                }
                if (this.cxq[this.mCurrentIndex] == null) {
                    this.cxq[this.mCurrentIndex] = new x(this, this.mCurrentIndex);
                }
            }
            String selectedFilter = this.cxr[this.mCurrentIndex].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cxo[this.mCurrentIndex].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.ew(selectedFilter));
                this.cxq[this.mCurrentIndex].i(cloneWithoutFilterAction);
                return;
            }
            this.cxq[this.mCurrentIndex].i(this.cxo[this.mCurrentIndex]);
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
        this.cxr[i] = new com.baidu.tbadk.coreExtra.view.j(this.auI, this, str);
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
    public void ard() {
        String selectedFilter;
        for (int i = 0; i < this.cxo.length; i++) {
            this.cxo[i].applayRotatePageActionToPersistAction();
            if (this.cxr[i] != null && (selectedFilter = this.cxr[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cxo[i].addPersistAction(com.baidu.tbadk.img.effect.a.ew(selectedFilter));
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
