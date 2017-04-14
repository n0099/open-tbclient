package com.baidu.tieba.write.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private int aBR;
    private WriteMultiImgsActivity fQQ;
    private ImageFileInfo[] fQR;
    private a fQS;
    private b[] fQT;
    private com.baidu.tbadk.coreExtra.view.c[] fQU;
    private int fQV;
    private int fQW;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void boW();

        void boX();

        void boY();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fQQ = null;
        this.fQR = null;
        this.mViewPager = null;
        this.fQS = null;
        this.mCount = 0;
        this.aBR = 0;
        this.fQT = null;
        this.fQU = null;
        this.fQV = 120;
        this.fQW = 120;
        this.fQQ = writeMultiImgsActivity;
        this.fQV = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds720);
        this.fQW = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.fQR = new ImageFileInfo[this.mCount];
        this.fQT = new b[this.mCount];
        this.fQU = new com.baidu.tbadk.coreExtra.view.c[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.fQR[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fQR[i3].addPageAction(com.baidu.tbadk.img.effect.d.M(this.fQV, this.fQW));
                linkedList.set(i3, this.fQR[i3]);
                i2 = i3 + 1;
            } else {
                this.aBR = i;
                this.mViewPager = viewPager;
                this.fQS = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void th(int i) {
        if (this.fQT[this.aBR].boZ()) {
            this.fQR[this.aBR].addPageAction(com.baidu.tbadk.img.effect.e.eU(i));
            this.fQQ.bpH();
            if (this.fQU[this.aBR] != null) {
                String selectedFilter = this.fQU[this.aBR].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fQR[this.aBR].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fP(selectedFilter));
                    this.fQT[this.aBR].k(cloneWithoutFilterAction);
                    return;
                }
                this.fQT[this.aBR].k(this.fQR[this.aBR]);
                return;
            }
            this.fQT[this.aBR].k(this.fQR[this.aBR]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eF(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fQQ.bpH();
            ImageFileInfo cloneWithoutFilterAction = this.fQR[this.aBR].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fP(str));
            this.fQT[this.aBR].k(cloneWithoutFilterAction);
            return;
        }
        this.fQQ.bpI();
        this.fQT[this.aBR].k(this.fQR[this.aBR]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fQT[i] == null) {
            this.fQT[i] = new b(i);
        }
        this.mViewPager.addView(this.fQT[i].getView());
        return this.fQT[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.fQT[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aBR = i;
        boU();
        if (this.fQS != null) {
            this.fQS.a(this.fQU[i], i);
        }
    }

    private void boU() {
        if (this.aBR >= 0) {
            if (this.fQT != null) {
                for (int i = 0; i < this.fQT.length; i++) {
                    if (this.fQT[i] != null) {
                        this.fQT[i].Rm();
                    }
                }
                if (this.fQT[this.aBR] == null) {
                    this.fQT[this.aBR] = new b(this.aBR);
                }
            }
            String selectedFilter = this.fQU[this.aBR].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fQR[this.aBR].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fP(selectedFilter));
                if (this.fQT != null) {
                    this.fQT[this.aBR].k(cloneWithoutFilterAction);
                }
            } else if (this.fQT != null) {
                this.fQT[this.aBR].k(this.fQR[this.aBR]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aBR;
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
        this.fQU[i] = new com.baidu.tbadk.coreExtra.view.c(this.fQQ, this, str);
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
    public void boV() {
        String selectedFilter;
        for (int i = 0; i < this.fQR.length; i++) {
            this.fQR[i].applayRotatePageActionToPersistAction();
            if (this.fQU[i] != null && (selectedFilter = this.fQU[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fQR[i].addPersistAction(com.baidu.tbadk.img.effect.a.fP(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aOL;
        private ProgressBar eKK;
        private FrameLayout fQX;
        private com.baidu.tbadk.img.b fQY;
        private int index;

        public b(int i) {
            this.eKK = null;
            this.index = -1;
            this.index = i;
            this.fQX = (FrameLayout) LayoutInflater.from(q.this.fQQ.getPageContext().getContext()).inflate(w.j.progress_tb_imageview, (ViewGroup) null);
            this.aOL = (TbImageView) this.fQX.findViewById(w.h.progress_tb_imageview);
            this.aOL.setClickable(true);
            this.aOL.setDefaultResource(0);
            this.aOL.setDefaultErrorResource(0);
            this.aOL.setDefaultBgResource(0);
            this.aOL.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fQY = new com.baidu.tbadk.img.b();
            this.aOL.setOnClickListener(new r(this));
            this.eKK = (ProgressBar) this.fQX.findViewById(w.h.progress_tb_imageview_progress);
            this.eKK.setVisibility(8);
        }

        public View getView() {
            return this.fQX;
        }

        public void k(ImageFileInfo imageFileInfo) {
            Rm();
            this.aOL.setDefaultResource(0);
            this.aOL.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fQY.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aOL);
                return;
            }
            lP(false);
            this.fQY.a(imageFileInfo, new s(this), false);
        }

        public void Rm() {
            if (this.fQY != null) {
                this.fQY.EP();
            }
            if (this.aOL != null) {
                this.aOL.setImageDrawable(null);
            }
        }

        public boolean boZ() {
            return this.eKK.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lP(boolean z) {
            if (z) {
                if (this.eKK.getVisibility() != 8) {
                    if (q.this.fQS != null) {
                        q.this.fQS.boY();
                    }
                    this.eKK.setVisibility(8);
                    q.this.fQU[this.index].setCanbeClick(true);
                }
            } else if (this.eKK.getVisibility() != 0) {
                if (q.this.fQS != null) {
                    q.this.fQS.boX();
                }
                this.eKK.setVisibility(0);
                q.this.fQU[this.index].setCanbeClick(false);
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
