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
    private ViewPager Ct;
    private BaseActivity On;
    private int RK;
    private ImageFileInfo[] bSQ;
    private s bSR;
    private t[] bSS;
    private com.baidu.tbadk.coreExtra.view.j[] bST;
    private int bSU;
    private int bSV;
    private int mq;

    public r(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, s sVar) {
        int i2 = 0;
        this.On = null;
        this.bSQ = null;
        this.Ct = null;
        this.bSR = null;
        this.mq = 0;
        this.RK = 0;
        this.bSS = null;
        this.bST = null;
        this.bSU = 120;
        this.bSV = 120;
        this.On = baseActivity;
        this.bSU = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_width);
        this.bSV = (int) baseActivity.getResources().getDimension(com.baidu.tieba.t.motu_image_size_height);
        if (linkedList != null) {
            this.mq = linkedList.size();
        }
        this.bSQ = new ImageFileInfo[this.mq];
        this.bSS = new t[this.mq];
        this.bST = new com.baidu.tbadk.coreExtra.view.j[this.mq];
        while (true) {
            int i3 = i2;
            if (i3 < this.mq) {
                a(linkedList.get(i3), i3);
                this.bSQ[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.bSQ[i3].addPageAction(com.baidu.tbadk.img.effect.d.w(this.bSU, this.bSV));
                linkedList.set(i3, this.bSQ[i3]);
                i2 = i3 + 1;
            } else {
                this.RK = i;
                this.Ct = viewPager;
                this.bSR = sVar;
                this.Ct.setOffscreenPageLimit(1);
                this.Ct.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hF(int i) {
        if (this.bSS[this.RK].afi()) {
            this.bSQ[this.RK].addPageAction(com.baidu.tbadk.img.effect.e.cT(i));
            if (this.bST[this.RK] != null) {
                String selectedFilter = this.bST[this.RK].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.bSQ[this.RK].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.dv(selectedFilter));
                    this.bSS[this.RK].h(cloneWithoutFilterAction);
                    return;
                }
                this.bSS[this.RK].h(this.bSQ[this.RK]);
                return;
            }
            this.bSS[this.RK].h(this.bSQ[this.RK]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.o
    public void cL(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.bSQ[this.RK].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.dv(str));
            this.bSS[this.RK].h(cloneWithoutFilterAction);
            return;
        }
        this.bSS[this.RK].h(this.bSQ[this.RK]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bSS[i] == null) {
            this.bSS[i] = new t(this, i);
        }
        this.Ct.addView(this.bSS[i].getView());
        return this.bSS[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Ct.removeView(this.bSS[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.RK = i;
        afd();
        if (this.bSR != null) {
            this.bSR.a(this.bST[i], i);
        }
    }

    private void afd() {
        if (this.RK >= 0) {
            if (this.bSS != null) {
                for (int i = 0; i < this.bSS.length; i++) {
                    if (this.bSS[i] != null) {
                        this.bSS[i].adn();
                    }
                }
                if (this.bSS[this.RK] == null) {
                    this.bSS[this.RK] = new t(this, this.RK);
                }
            }
            String selectedFilter = this.bST[this.RK].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.bSQ[this.RK].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.dv(selectedFilter));
                this.bSS[this.RK].h(cloneWithoutFilterAction);
                return;
            }
            this.bSS[this.RK].h(this.bSQ[this.RK]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.RK;
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
        this.bST[i] = new com.baidu.tbadk.coreExtra.view.j(this.On, this, str);
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
    public void afe() {
        String selectedFilter;
        for (int i = 0; i < this.bSQ.length; i++) {
            this.bSQ[i].applayRotatePageActionToPersistAction();
            if (this.bST[i] != null && (selectedFilter = this.bST[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.bSQ[i].addPersistAction(com.baidu.tbadk.img.effect.a.dv(selectedFilter));
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
