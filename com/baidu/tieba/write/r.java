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
    private ViewPager Cu;
    private BaseActivity Or;
    private int RO;
    private ImageFileInfo[] bTf;
    private s bTg;
    private t[] bTh;
    private com.baidu.tbadk.coreExtra.view.j[] bTi;
    private int bTj;
    private int bTk;
    private int mq;

    public r(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, s sVar) {
        int i2 = 0;
        this.Or = null;
        this.bTf = null;
        this.Cu = null;
        this.bTg = null;
        this.mq = 0;
        this.RO = 0;
        this.bTh = null;
        this.bTi = null;
        this.bTj = 120;
        this.bTk = 120;
        this.Or = baseActivity;
        this.bTj = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_width);
        this.bTk = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_height);
        if (linkedList != null) {
            this.mq = linkedList.size();
        }
        this.bTf = new ImageFileInfo[this.mq];
        this.bTh = new t[this.mq];
        this.bTi = new com.baidu.tbadk.coreExtra.view.j[this.mq];
        while (true) {
            int i3 = i2;
            if (i3 < this.mq) {
                a(linkedList.get(i3), i3);
                this.bTf[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.bTf[i3].addPageAction(com.baidu.tbadk.img.effect.d.w(this.bTj, this.bTk));
                linkedList.set(i3, this.bTf[i3]);
                i2 = i3 + 1;
            } else {
                this.RO = i;
                this.Cu = viewPager;
                this.bTg = sVar;
                this.Cu.setOffscreenPageLimit(1);
                this.Cu.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hF(int i) {
        if (this.bTh[this.RO].afl()) {
            this.bTf[this.RO].addPageAction(com.baidu.tbadk.img.effect.e.cT(i));
            if (this.bTi[this.RO] != null) {
                String selectedFilter = this.bTi[this.RO].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.bTf[this.RO].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.dv(selectedFilter));
                    this.bTh[this.RO].h(cloneWithoutFilterAction);
                    return;
                }
                this.bTh[this.RO].h(this.bTf[this.RO]);
                return;
            }
            this.bTh[this.RO].h(this.bTf[this.RO]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void cL(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.bTf[this.RO].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.dv(str));
            this.bTh[this.RO].h(cloneWithoutFilterAction);
            return;
        }
        this.bTh[this.RO].h(this.bTf[this.RO]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bTh[i] == null) {
            this.bTh[i] = new t(this, i);
        }
        this.Cu.addView(this.bTh[i].getView());
        return this.bTh[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Cu.removeView(this.bTh[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.RO = i;
        afg();
        if (this.bTg != null) {
            this.bTg.a(this.bTi[i], i);
        }
    }

    private void afg() {
        if (this.RO >= 0) {
            if (this.bTh != null) {
                for (int i = 0; i < this.bTh.length; i++) {
                    if (this.bTh[i] != null) {
                        this.bTh[i].adq();
                    }
                }
                if (this.bTh[this.RO] == null) {
                    this.bTh[this.RO] = new t(this, this.RO);
                }
            }
            String selectedFilter = this.bTi[this.RO].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.bTf[this.RO].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.dv(selectedFilter));
                this.bTh[this.RO].h(cloneWithoutFilterAction);
                return;
            }
            this.bTh[this.RO].h(this.bTf[this.RO]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.RO;
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
        this.bTi[i] = new com.baidu.tbadk.coreExtra.view.j(this.Or, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mq;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void afh() {
        String selectedFilter;
        for (int i = 0; i < this.bTf.length; i++) {
            this.bTf[i].applayRotatePageActionToPersistAction();
            if (this.bTi[i] != null && (selectedFilter = this.bTi[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.bTf[i].addPersistAction(com.baidu.tbadk.img.effect.a.dv(selectedFilter));
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
