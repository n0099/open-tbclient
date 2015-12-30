package com.baidu.tieba.write.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, d.a {
    private int auZ;
    private WriteMultiImgsActivity dXc;
    private ImageFileInfo[] dXd;
    private a dXe;
    private b[] dXf;
    private com.baidu.tbadk.coreExtra.view.d[] dXg;
    private int dXh;
    private int dXi;
    private ViewPager mViewPager;
    private int wJ;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.d dVar, int i);

        void aLG();

        void aLH();

        void aLI();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.dXc = null;
        this.dXd = null;
        this.mViewPager = null;
        this.dXe = null;
        this.wJ = 0;
        this.auZ = 0;
        this.dXf = null;
        this.dXg = null;
        this.dXh = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dXi = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dXc = writeMultiImgsActivity;
        this.dXh = (int) writeMultiImgsActivity.getResources().getDimension(n.e.motu_image_size_width);
        this.dXi = (int) writeMultiImgsActivity.getResources().getDimension(n.e.motu_image_size_height);
        if (linkedList != null) {
            this.wJ = linkedList.size();
        }
        this.dXd = new ImageFileInfo[this.wJ];
        this.dXf = new b[this.wJ];
        this.dXg = new com.baidu.tbadk.coreExtra.view.d[this.wJ];
        while (true) {
            int i3 = i2;
            if (i3 < this.wJ) {
                a(linkedList.get(i3), i3);
                this.dXd[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.dXd[i3].addPageAction(com.baidu.tbadk.img.effect.d.K(this.dXh, this.dXi));
                linkedList.set(i3, this.dXd[i3]);
                i2 = i3 + 1;
            } else {
                this.auZ = i;
                this.mViewPager = viewPager;
                this.dXe = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oB(int i) {
        if (this.dXf[this.auZ].aLJ()) {
            this.dXd[this.auZ].addPageAction(com.baidu.tbadk.img.effect.e.eu(i));
            this.dXc.aMs();
            if (this.dXg[this.auZ] != null) {
                String selectedFilter = this.dXg[this.auZ].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.dXd[this.auZ].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fK(selectedFilter));
                    this.dXf[this.auZ].i(cloneWithoutFilterAction);
                    return;
                }
                this.dXf[this.auZ].i(this.dXd[this.auZ]);
                return;
            }
            this.dXf[this.auZ].i(this.dXd[this.auZ]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.d.a
    public void eE(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.dXc.aMs();
            ImageFileInfo cloneWithoutFilterAction = this.dXd[this.auZ].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fK(str));
            this.dXf[this.auZ].i(cloneWithoutFilterAction);
            return;
        }
        this.dXc.aMt();
        this.dXf[this.auZ].i(this.dXd[this.auZ]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.dXf[i] == null) {
            this.dXf[i] = new b(i);
        }
        this.mViewPager.addView(this.dXf[i].getView());
        return this.dXf[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.dXf[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.auZ = i;
        aLE();
        if (this.dXe != null) {
            this.dXe.a(this.dXg[i], i);
        }
    }

    private void aLE() {
        if (this.auZ >= 0) {
            if (this.dXf != null) {
                for (int i = 0; i < this.dXf.length; i++) {
                    if (this.dXf[i] != null) {
                        this.dXf[i].aGC();
                    }
                }
                if (this.dXf[this.auZ] == null) {
                    this.dXf[this.auZ] = new b(this.auZ);
                }
            }
            String selectedFilter = this.dXg[this.auZ].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.dXd[this.auZ].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fK(selectedFilter));
                if (this.dXf != null) {
                    this.dXf[this.auZ].i(cloneWithoutFilterAction);
                }
            } else if (this.dXf != null) {
                this.dXf[this.auZ].i(this.dXd[this.auZ]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.auZ;
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
        this.dXg[i] = new com.baidu.tbadk.coreExtra.view.d(this.dXc, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wJ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLF() {
        String selectedFilter;
        for (int i = 0; i < this.dXd.length; i++) {
            this.dXd[i].applayRotatePageActionToPersistAction();
            if (this.dXg[i] != null && (selectedFilter = this.dXg[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.dXd[i].addPersistAction(com.baidu.tbadk.img.effect.a.fK(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aGb;
        private FrameLayout dXj;
        private com.baidu.tbadk.img.b dXk;
        private ProgressBar daK;
        private int index;

        public b(int i) {
            this.daK = null;
            this.index = -1;
            this.index = i;
            this.dXj = (FrameLayout) LayoutInflater.from(q.this.dXc.getPageContext().getContext()).inflate(n.h.progress_tb_imageview, (ViewGroup) null);
            this.aGb = (TbImageView) this.dXj.findViewById(n.g.progress_tb_imageview);
            this.aGb.setClickable(true);
            this.aGb.setDefaultResource(0);
            this.aGb.setDefaultBgResource(0);
            this.aGb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.dXk = new com.baidu.tbadk.img.b();
            this.aGb.setOnClickListener(new r(this));
            this.daK = (ProgressBar) this.dXj.findViewById(n.g.progress_tb_imageview_progress);
            this.daK.setVisibility(8);
        }

        public View getView() {
            return this.dXj;
        }

        public void i(ImageFileInfo imageFileInfo) {
            aGC();
            this.aGb.setDefaultResource(0);
            this.aGb.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.dXk.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aGb);
                return;
            }
            hU(false);
            this.dXk.a(imageFileInfo, new s(this), false);
        }

        public void aGC() {
            if (this.dXk != null) {
                this.dXk.CS();
            }
            if (this.aGb != null) {
                this.aGb.setImageDrawable(null);
            }
        }

        public boolean aLJ() {
            return this.daK.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hU(boolean z) {
            if (z) {
                if (this.daK.getVisibility() != 8) {
                    if (q.this.dXe != null) {
                        q.this.dXe.aLI();
                    }
                    this.daK.setVisibility(8);
                    q.this.dXg[this.index].setCanbeClick(true);
                }
            } else if (this.daK.getVisibility() != 0) {
                if (q.this.dXe != null) {
                    q.this.dXe.aLH();
                }
                this.daK.setVisibility(0);
                q.this.dXg[this.index].setCanbeClick(false);
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
