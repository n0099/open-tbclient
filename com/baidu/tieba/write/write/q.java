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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, d.a {
    private int ary;
    private BaseActivity atD;
    private ImageFileInfo[] dcu;
    private a dcv;
    private b[] dcw;
    private com.baidu.tbadk.coreExtra.view.d[] dcx;
    private int dcy;
    private int dcz;
    private ViewPager mViewPager;
    private int wA;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.d dVar, int i);

        void azk();

        void azl();

        void azm();
    }

    public q(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.atD = null;
        this.dcu = null;
        this.mViewPager = null;
        this.dcv = null;
        this.wA = 0;
        this.ary = 0;
        this.dcw = null;
        this.dcx = null;
        this.dcy = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dcz = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.atD = baseActivity;
        this.dcy = (int) baseActivity.getResources().getDimension(i.d.motu_image_size_width);
        this.dcz = (int) baseActivity.getResources().getDimension(i.d.motu_image_size_height);
        if (linkedList != null) {
            this.wA = linkedList.size();
        }
        this.dcu = new ImageFileInfo[this.wA];
        this.dcw = new b[this.wA];
        this.dcx = new com.baidu.tbadk.coreExtra.view.d[this.wA];
        while (true) {
            int i3 = i2;
            if (i3 < this.wA) {
                a(linkedList.get(i3), i3);
                this.dcu[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.dcu[i3].addPageAction(com.baidu.tbadk.img.effect.d.J(this.dcy, this.dcz));
                linkedList.set(i3, this.dcu[i3]);
                i2 = i3 + 1;
            } else {
                this.ary = i;
                this.mViewPager = viewPager;
                this.dcv = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lk(int i) {
        if (this.dcw[this.ary].azn()) {
            this.dcu[this.ary].addPageAction(com.baidu.tbadk.img.effect.e.en(i));
            if (this.dcx[this.ary] != null) {
                String selectedFilter = this.dcx[this.ary].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.dcu[this.ary].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fl(selectedFilter));
                    this.dcw[this.ary].i(cloneWithoutFilterAction);
                    return;
                }
                this.dcw[this.ary].i(this.dcu[this.ary]);
                return;
            }
            this.dcw[this.ary].i(this.dcu[this.ary]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.d.a
    public void ep(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.dcu[this.ary].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fl(str));
            this.dcw[this.ary].i(cloneWithoutFilterAction);
            return;
        }
        this.dcw[this.ary].i(this.dcu[this.ary]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.dcw[i] == null) {
            this.dcw[i] = new b(i);
        }
        this.mViewPager.addView(this.dcw[i].getView());
        return this.dcw[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.dcw[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.ary = i;
        azi();
        if (this.dcv != null) {
            this.dcv.a(this.dcx[i], i);
        }
    }

    private void azi() {
        if (this.ary >= 0) {
            if (this.dcw != null) {
                for (int i = 0; i < this.dcw.length; i++) {
                    if (this.dcw[i] != null) {
                        this.dcw[i].avt();
                    }
                }
                if (this.dcw[this.ary] == null) {
                    this.dcw[this.ary] = new b(this.ary);
                }
            }
            String selectedFilter = this.dcx[this.ary].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.dcu[this.ary].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fl(selectedFilter));
                if (this.dcw != null) {
                    this.dcw[this.ary].i(cloneWithoutFilterAction);
                }
            } else if (this.dcw != null) {
                this.dcw[this.ary].i(this.dcu[this.ary]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.ary;
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
        this.dcx[i] = new com.baidu.tbadk.coreExtra.view.d(this.atD, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wA;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void azj() {
        String selectedFilter;
        for (int i = 0; i < this.dcu.length; i++) {
            this.dcu[i].applayRotatePageActionToPersistAction();
            if (this.dcx[i] != null && (selectedFilter = this.dcx[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.dcu[i].addPersistAction(com.baidu.tbadk.img.effect.a.fl(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView cad;
        private ProgressBar cqy;
        private FrameLayout dcA;
        private com.baidu.tbadk.img.b dcB;
        private int index;

        public b(int i) {
            this.cqy = null;
            this.index = -1;
            this.index = i;
            this.dcA = (FrameLayout) LayoutInflater.from(q.this.atD.getPageContext().getContext()).inflate(i.g.progress_tb_imageview, (ViewGroup) null);
            this.cad = (TbImageView) this.dcA.findViewById(i.f.progress_tb_imageview);
            this.cad.setClickable(true);
            this.cad.setDefaultResource(0);
            this.cad.setDefaultBgResource(0);
            this.cad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.dcB = new com.baidu.tbadk.img.b();
            this.cad.setOnClickListener(new r(this));
            this.cqy = (ProgressBar) this.dcA.findViewById(i.f.progress_tb_imageview_progress);
            this.cqy.setVisibility(8);
        }

        public View getView() {
            return this.dcA;
        }

        public void i(ImageFileInfo imageFileInfo) {
            avt();
            this.cad.setDefaultResource(0);
            this.cad.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.dcB.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.cad);
                return;
            }
            gJ(false);
            this.dcB.a(imageFileInfo, new s(this), false);
        }

        public void avt() {
            if (this.dcB != null) {
                this.dcB.Cz();
            }
            if (this.cad != null) {
                this.cad.setImageDrawable(null);
            }
        }

        public boolean azn() {
            return this.cqy.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void gJ(boolean z) {
            if (z) {
                if (this.cqy.getVisibility() != 8) {
                    if (q.this.dcv != null) {
                        q.this.dcv.azm();
                    }
                    this.cqy.setVisibility(8);
                    q.this.dcx[this.index].setCanbeClick(true);
                }
            } else if (this.cqy.getVisibility() != 0) {
                if (q.this.dcv != null) {
                    q.this.dcv.azl();
                }
                this.cqy.setVisibility(0);
                q.this.dcx[this.index].setCanbeClick(false);
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
