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
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, d.a {
    private int apY;
    private WriteMultiImgsActivity dol;
    private ImageFileInfo[] dom;
    private a don;
    private b[] doo;
    private com.baidu.tbadk.coreExtra.view.d[] dop;
    private int doq;
    private int dor;
    private ViewPager mViewPager;
    private int wB;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.d dVar, int i);

        void aCQ();

        void aCR();

        void aCS();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.dol = null;
        this.dom = null;
        this.mViewPager = null;
        this.don = null;
        this.wB = 0;
        this.apY = 0;
        this.doo = null;
        this.dop = null;
        this.doq = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dor = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dol = writeMultiImgsActivity;
        this.doq = (int) writeMultiImgsActivity.getResources().getDimension(i.d.motu_image_size_width);
        this.dor = (int) writeMultiImgsActivity.getResources().getDimension(i.d.motu_image_size_height);
        if (linkedList != null) {
            this.wB = linkedList.size();
        }
        this.dom = new ImageFileInfo[this.wB];
        this.doo = new b[this.wB];
        this.dop = new com.baidu.tbadk.coreExtra.view.d[this.wB];
        while (true) {
            int i3 = i2;
            if (i3 < this.wB) {
                a(linkedList.get(i3), i3);
                this.dom[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.dom[i3].addPageAction(com.baidu.tbadk.img.effect.d.J(this.doq, this.dor));
                linkedList.set(i3, this.dom[i3]);
                i2 = i3 + 1;
            } else {
                this.apY = i;
                this.mViewPager = viewPager;
                this.don = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mh(int i) {
        if (this.doo[this.apY].aCT()) {
            this.dom[this.apY].addPageAction(com.baidu.tbadk.img.effect.e.eo(i));
            this.dol.aDA();
            if (this.dop[this.apY] != null) {
                String selectedFilter = this.dop[this.apY].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.dom[this.apY].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fq(selectedFilter));
                    this.doo[this.apY].j(cloneWithoutFilterAction);
                    return;
                }
                this.doo[this.apY].j(this.dom[this.apY]);
                return;
            }
            this.doo[this.apY].j(this.dom[this.apY]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.d.a
    public void er(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.dol.aDA();
            ImageFileInfo cloneWithoutFilterAction = this.dom[this.apY].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fq(str));
            this.doo[this.apY].j(cloneWithoutFilterAction);
            return;
        }
        this.dol.aDB();
        this.doo[this.apY].j(this.dom[this.apY]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.doo[i] == null) {
            this.doo[i] = new b(i);
        }
        this.mViewPager.addView(this.doo[i].getView());
        return this.doo[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.doo[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.apY = i;
        aCO();
        if (this.don != null) {
            this.don.a(this.dop[i], i);
        }
    }

    private void aCO() {
        if (this.apY >= 0) {
            if (this.doo != null) {
                for (int i = 0; i < this.doo.length; i++) {
                    if (this.doo[i] != null) {
                        this.doo[i].axH();
                    }
                }
                if (this.doo[this.apY] == null) {
                    this.doo[this.apY] = new b(this.apY);
                }
            }
            String selectedFilter = this.dop[this.apY].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.dom[this.apY].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fq(selectedFilter));
                if (this.doo != null) {
                    this.doo[this.apY].j(cloneWithoutFilterAction);
                }
            } else if (this.doo != null) {
                this.doo[this.apY].j(this.dom[this.apY]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.apY;
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
        this.dop[i] = new com.baidu.tbadk.coreExtra.view.d(this.dol, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wB;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCP() {
        String selectedFilter;
        for (int i = 0; i < this.dom.length; i++) {
            this.dom[i].applayRotatePageActionToPersistAction();
            if (this.dop[i] != null && (selectedFilter = this.dop[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.dom[i].addPersistAction(com.baidu.tbadk.img.effect.a.fq(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aCK;
        private ProgressBar cwy;
        private FrameLayout dos;
        private com.baidu.tbadk.img.b dot;
        private int index;

        public b(int i) {
            this.cwy = null;
            this.index = -1;
            this.index = i;
            this.dos = (FrameLayout) LayoutInflater.from(q.this.dol.getPageContext().getContext()).inflate(i.g.progress_tb_imageview, (ViewGroup) null);
            this.aCK = (TbImageView) this.dos.findViewById(i.f.progress_tb_imageview);
            this.aCK.setClickable(true);
            this.aCK.setDefaultResource(0);
            this.aCK.setDefaultBgResource(0);
            this.aCK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.dot = new com.baidu.tbadk.img.b();
            this.aCK.setOnClickListener(new r(this));
            this.cwy = (ProgressBar) this.dos.findViewById(i.f.progress_tb_imageview_progress);
            this.cwy.setVisibility(8);
        }

        public View getView() {
            return this.dos;
        }

        public void j(ImageFileInfo imageFileInfo) {
            axH();
            this.aCK.setDefaultResource(0);
            this.aCK.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.dot.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aCK);
                return;
            }
            ha(false);
            this.dot.a(imageFileInfo, new s(this), false);
        }

        public void axH() {
            if (this.dot != null) {
                this.dot.Cm();
            }
            if (this.aCK != null) {
                this.aCK.setImageDrawable(null);
            }
        }

        public boolean aCT() {
            return this.cwy.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ha(boolean z) {
            if (z) {
                if (this.cwy.getVisibility() != 8) {
                    if (q.this.don != null) {
                        q.this.don.aCS();
                    }
                    this.cwy.setVisibility(8);
                    q.this.dop[this.index].setCanbeClick(true);
                }
            } else if (this.cwy.getVisibility() != 0) {
                if (q.this.don != null) {
                    q.this.don.aCR();
                }
                this.cwy.setVisibility(0);
                q.this.dop[this.index].setCanbeClick(false);
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
