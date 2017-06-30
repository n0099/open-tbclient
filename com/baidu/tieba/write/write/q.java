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
    private int aCI;
    private WriteMultiImgsActivity gkl;
    private ImageFileInfo[] gkm;
    private a gkn;
    private b[] gko;
    private com.baidu.tbadk.coreExtra.view.c[] gkp;
    private int gkq;
    private int gkr;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void btW();

        void btX();

        void btY();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gkl = null;
        this.gkm = null;
        this.mViewPager = null;
        this.gkn = null;
        this.mCount = 0;
        this.aCI = 0;
        this.gko = null;
        this.gkp = null;
        this.gkq = 120;
        this.gkr = 120;
        this.gkl = writeMultiImgsActivity;
        this.gkq = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds720);
        this.gkr = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gkm = new ImageFileInfo[this.mCount];
        this.gko = new b[this.mCount];
        this.gkp = new com.baidu.tbadk.coreExtra.view.c[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gkm[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gkm[i3].addPageAction(com.baidu.tbadk.img.effect.d.L(this.gkq, this.gkr));
                linkedList.set(i3, this.gkm[i3]);
                i2 = i3 + 1;
            } else {
                this.aCI = i;
                this.mViewPager = viewPager;
                this.gkn = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ub(int i) {
        if (this.gko[this.aCI].btZ()) {
            this.gkm[this.aCI].addPageAction(com.baidu.tbadk.img.effect.e.eT(i));
            this.gkl.buK();
            if (this.gkp[this.aCI] != null) {
                String selectedFilter = this.gkp[this.aCI].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.gkm[this.aCI].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gg(selectedFilter));
                    this.gko[this.aCI].i(cloneWithoutFilterAction);
                    return;
                }
                this.gko[this.aCI].i(this.gkm[this.aCI]);
                return;
            }
            this.gko[this.aCI].i(this.gkm[this.aCI]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eW(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.gkl.buK();
            ImageFileInfo cloneWithoutFilterAction = this.gkm[this.aCI].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gg(str));
            this.gko[this.aCI].i(cloneWithoutFilterAction);
            return;
        }
        this.gkl.buL();
        this.gko[this.aCI].i(this.gkm[this.aCI]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gko[i] == null) {
            this.gko[i] = new b(i);
        }
        this.mViewPager.addView(this.gko[i].getView());
        return this.gko[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gko[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aCI = i;
        btU();
        if (this.gkn != null) {
            this.gkn.a(this.gkp[i], i);
        }
    }

    private void btU() {
        if (this.aCI >= 0) {
            if (this.gko != null) {
                for (int i = 0; i < this.gko.length; i++) {
                    if (this.gko[i] != null) {
                        this.gko[i].TK();
                    }
                }
                if (this.gko[this.aCI] == null) {
                    this.gko[this.aCI] = new b(this.aCI);
                }
            }
            String selectedFilter = this.gkp[this.aCI].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.gkm[this.aCI].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gg(selectedFilter));
                if (this.gko != null) {
                    this.gko[this.aCI].i(cloneWithoutFilterAction);
                }
            } else if (this.gko != null) {
                this.gko[this.aCI].i(this.gkm[this.aCI]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aCI;
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
        this.gkp[i] = new com.baidu.tbadk.coreExtra.view.c(this.gkl, this, str);
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
    public void btV() {
        String selectedFilter;
        for (int i = 0; i < this.gkm.length; i++) {
            this.gkm[i].applayRotatePageActionToPersistAction();
            if (this.gkp[i] != null && (selectedFilter = this.gkp[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.gkm[i].addPersistAction(com.baidu.tbadk.img.effect.a.gg(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aQx;
        private ProgressBar fca;
        private FrameLayout gks;
        private com.baidu.tbadk.img.b gkt;
        private int index;

        public b(int i) {
            this.fca = null;
            this.index = -1;
            this.index = i;
            this.gks = (FrameLayout) LayoutInflater.from(q.this.gkl.getPageContext().getContext()).inflate(w.j.progress_tb_imageview, (ViewGroup) null);
            this.aQx = (TbImageView) this.gks.findViewById(w.h.progress_tb_imageview);
            this.aQx.setClickable(true);
            this.aQx.setDefaultResource(0);
            this.aQx.setDefaultErrorResource(0);
            this.aQx.setDefaultBgResource(0);
            this.aQx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gkt = new com.baidu.tbadk.img.b();
            this.aQx.setOnClickListener(new r(this));
            this.fca = (ProgressBar) this.gks.findViewById(w.h.progress_tb_imageview_progress);
            this.fca.setVisibility(8);
        }

        public View getView() {
            return this.gks;
        }

        public void i(ImageFileInfo imageFileInfo) {
            TK();
            this.aQx.setDefaultResource(0);
            this.aQx.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gkt.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aQx);
                return;
            }
            mC(false);
            this.gkt.a(imageFileInfo, new s(this), false);
        }

        public void TK() {
            if (this.gkt != null) {
                this.gkt.Ek();
            }
            if (this.aQx != null) {
                this.aQx.setImageDrawable(null);
            }
        }

        public boolean btZ() {
            return this.fca.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mC(boolean z) {
            if (z) {
                if (this.fca.getVisibility() != 8) {
                    if (q.this.gkn != null) {
                        q.this.gkn.btY();
                    }
                    this.fca.setVisibility(8);
                    q.this.gkp[this.index].setCanbeClick(true);
                }
            } else if (this.fca.getVisibility() != 0) {
                if (q.this.gkn != null) {
                    q.this.gkn.btX();
                }
                this.fca.setVisibility(0);
                q.this.gkp[this.index].setCanbeClick(false);
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
