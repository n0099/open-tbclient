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
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private int awO;
    private ViewPager awv;
    private WriteMultiImgsActivity ggl;
    private ImageFileInfo[] ggm;
    private a ggn;
    private b[] ggo;
    private com.baidu.tbadk.coreExtra.view.c[] ggp;
    private int ggq;
    private int ggr;
    private int qg;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void btJ();

        void btK();

        void btL();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.ggl = null;
        this.ggm = null;
        this.awv = null;
        this.ggn = null;
        this.qg = 0;
        this.awO = 0;
        this.ggo = null;
        this.ggp = null;
        this.ggq = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.ggr = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.ggl = writeMultiImgsActivity;
        this.ggq = (int) writeMultiImgsActivity.getResources().getDimension(r.e.ds720);
        this.ggr = (int) writeMultiImgsActivity.getResources().getDimension(r.e.ds1280);
        if (linkedList != null) {
            this.qg = linkedList.size();
        }
        this.ggm = new ImageFileInfo[this.qg];
        this.ggo = new b[this.qg];
        this.ggp = new com.baidu.tbadk.coreExtra.view.c[this.qg];
        while (true) {
            int i3 = i2;
            if (i3 < this.qg) {
                a(linkedList.get(i3), i3);
                this.ggm[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.ggm[i3].addPageAction(com.baidu.tbadk.img.effect.d.F(this.ggq, this.ggr));
                linkedList.set(i3, this.ggm[i3]);
                i2 = i3 + 1;
            } else {
                this.awO = i;
                this.awv = viewPager;
                this.ggn = aVar;
                this.awv.setOffscreenPageLimit(1);
                this.awv.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tE(int i) {
        if (this.ggo[this.awO].btM()) {
            this.ggm[this.awO].addPageAction(com.baidu.tbadk.img.effect.e.eR(i));
            this.ggl.buv();
            if (this.ggp[this.awO] != null) {
                String selectedFilter = this.ggp[this.awO].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.ggm[this.awO].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fY(selectedFilter));
                    this.ggo[this.awO].l(cloneWithoutFilterAction);
                    return;
                }
                this.ggo[this.awO].l(this.ggm[this.awO]);
                return;
            }
            this.ggo[this.awO].l(this.ggm[this.awO]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eP(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.ggl.buv();
            ImageFileInfo cloneWithoutFilterAction = this.ggm[this.awO].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fY(str));
            this.ggo[this.awO].l(cloneWithoutFilterAction);
            return;
        }
        this.ggl.buw();
        this.ggo[this.awO].l(this.ggm[this.awO]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ggo[i] == null) {
            this.ggo[i] = new b(i);
        }
        this.awv.addView(this.ggo[i].getView());
        return this.ggo[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.awv.removeView(this.ggo[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.awO = i;
        btH();
        if (this.ggn != null) {
            this.ggn.a(this.ggp[i], i);
        }
    }

    private void btH() {
        if (this.awO >= 0) {
            if (this.ggo != null) {
                for (int i = 0; i < this.ggo.length; i++) {
                    if (this.ggo[i] != null) {
                        this.ggo[i].bla();
                    }
                }
                if (this.ggo[this.awO] == null) {
                    this.ggo[this.awO] = new b(this.awO);
                }
            }
            String selectedFilter = this.ggp[this.awO].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.ggm[this.awO].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fY(selectedFilter));
                if (this.ggo != null) {
                    this.ggo[this.awO].l(cloneWithoutFilterAction);
                }
            } else if (this.ggo != null) {
                this.ggo[this.awO].l(this.ggm[this.awO]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.awO;
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
        this.ggp[i] = new com.baidu.tbadk.coreExtra.view.c(this.ggl, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.qg;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void btI() {
        String selectedFilter;
        for (int i = 0; i < this.ggm.length; i++) {
            this.ggm[i].applayRotatePageActionToPersistAction();
            if (this.ggp[i] != null && (selectedFilter = this.ggp[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.ggm[i].addPersistAction(com.baidu.tbadk.img.effect.a.fY(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aKh;
        private ProgressBar ePs;
        private FrameLayout ggs;
        private com.baidu.tbadk.img.b ggt;
        private int index;

        public b(int i) {
            this.ePs = null;
            this.index = -1;
            this.index = i;
            this.ggs = (FrameLayout) LayoutInflater.from(r.this.ggl.getPageContext().getContext()).inflate(r.h.progress_tb_imageview, (ViewGroup) null);
            this.aKh = (TbImageView) this.ggs.findViewById(r.g.progress_tb_imageview);
            this.aKh.setClickable(true);
            this.aKh.setDefaultResource(0);
            this.aKh.setDefaultErrorResource(0);
            this.aKh.setDefaultBgResource(0);
            this.aKh.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.ggt = new com.baidu.tbadk.img.b();
            this.aKh.setOnClickListener(new s(this));
            this.ePs = (ProgressBar) this.ggs.findViewById(r.g.progress_tb_imageview_progress);
            this.ePs.setVisibility(8);
        }

        public View getView() {
            return this.ggs;
        }

        public void l(ImageFileInfo imageFileInfo) {
            bla();
            this.aKh.setDefaultResource(0);
            this.aKh.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.ggt.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aKh);
                return;
            }
            lQ(false);
            this.ggt.a(imageFileInfo, new t(this), false);
        }

        public void bla() {
            if (this.ggt != null) {
                this.ggt.Eq();
            }
            if (this.aKh != null) {
                this.aKh.setImageDrawable(null);
            }
        }

        public boolean btM() {
            return this.ePs.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lQ(boolean z) {
            if (z) {
                if (this.ePs.getVisibility() != 8) {
                    if (r.this.ggn != null) {
                        r.this.ggn.btL();
                    }
                    this.ePs.setVisibility(8);
                    r.this.ggp[this.index].setCanbeClick(true);
                }
            } else if (this.ePs.getVisibility() != 0) {
                if (r.this.ggn != null) {
                    r.this.ggn.btK();
                }
                this.ePs.setVisibility(0);
                r.this.ggp[this.index].setCanbeClick(false);
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
