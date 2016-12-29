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
    private ViewPager aid;
    private int axc;
    private WriteMultiImgsActivity fCs;
    private ImageFileInfo[] fCt;
    private a fCu;
    private b[] fCv;
    private com.baidu.tbadk.coreExtra.view.c[] fCw;
    private int fCx;
    private int fCy;
    private int qh;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bnc();

        void bnd();

        void bne();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fCs = null;
        this.fCt = null;
        this.aid = null;
        this.fCu = null;
        this.qh = 0;
        this.axc = 0;
        this.fCv = null;
        this.fCw = null;
        this.fCx = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fCy = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fCs = writeMultiImgsActivity;
        this.fCx = (int) writeMultiImgsActivity.getResources().getDimension(r.e.ds720);
        this.fCy = (int) writeMultiImgsActivity.getResources().getDimension(r.e.ds1280);
        if (linkedList != null) {
            this.qh = linkedList.size();
        }
        this.fCt = new ImageFileInfo[this.qh];
        this.fCv = new b[this.qh];
        this.fCw = new com.baidu.tbadk.coreExtra.view.c[this.qh];
        while (true) {
            int i3 = i2;
            if (i3 < this.qh) {
                a(linkedList.get(i3), i3);
                this.fCt[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fCt[i3].addPageAction(com.baidu.tbadk.img.effect.d.F(this.fCx, this.fCy));
                linkedList.set(i3, this.fCt[i3]);
                i2 = i3 + 1;
            } else {
                this.axc = i;
                this.aid = viewPager;
                this.fCu = aVar;
                this.aid.setOffscreenPageLimit(1);
                this.aid.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sz(int i) {
        if (this.fCv[this.axc].bnf()) {
            this.fCt[this.axc].addPageAction(com.baidu.tbadk.img.effect.e.eV(i));
            this.fCs.bnN();
            if (this.fCw[this.axc] != null) {
                String selectedFilter = this.fCw[this.axc].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fCt[this.axc].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fX(selectedFilter));
                    this.fCv[this.axc].k(cloneWithoutFilterAction);
                    return;
                }
                this.fCv[this.axc].k(this.fCt[this.axc]);
                return;
            }
            this.fCv[this.axc].k(this.fCt[this.axc]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eN(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fCs.bnN();
            ImageFileInfo cloneWithoutFilterAction = this.fCt[this.axc].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fX(str));
            this.fCv[this.axc].k(cloneWithoutFilterAction);
            return;
        }
        this.fCs.bnO();
        this.fCv[this.axc].k(this.fCt[this.axc]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fCv[i] == null) {
            this.fCv[i] = new b(i);
        }
        this.aid.addView(this.fCv[i].getView());
        return this.fCv[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aid.removeView(this.fCv[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.axc = i;
        bna();
        if (this.fCu != null) {
            this.fCu.a(this.fCw[i], i);
        }
    }

    private void bna() {
        if (this.axc >= 0) {
            if (this.fCv != null) {
                for (int i = 0; i < this.fCv.length; i++) {
                    if (this.fCv[i] != null) {
                        this.fCv[i].bhk();
                    }
                }
                if (this.fCv[this.axc] == null) {
                    this.fCv[this.axc] = new b(this.axc);
                }
            }
            String selectedFilter = this.fCw[this.axc].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fCt[this.axc].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fX(selectedFilter));
                if (this.fCv != null) {
                    this.fCv[this.axc].k(cloneWithoutFilterAction);
                }
            } else if (this.fCv != null) {
                this.fCv[this.axc].k(this.fCt[this.axc]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.axc;
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
        this.fCw[i] = new com.baidu.tbadk.coreExtra.view.c(this.fCs, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.qh;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bnb() {
        String selectedFilter;
        for (int i = 0; i < this.fCt.length; i++) {
            this.fCt[i].applayRotatePageActionToPersistAction();
            if (this.fCw[i] != null && (selectedFilter = this.fCw[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fCt[i].addPersistAction(com.baidu.tbadk.img.effect.a.fX(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aKr;
        private ProgressBar ezq;
        private com.baidu.tbadk.img.b fCA;
        private FrameLayout fCz;
        private int index;

        public b(int i) {
            this.ezq = null;
            this.index = -1;
            this.index = i;
            this.fCz = (FrameLayout) LayoutInflater.from(r.this.fCs.getPageContext().getContext()).inflate(r.h.progress_tb_imageview, (ViewGroup) null);
            this.aKr = (TbImageView) this.fCz.findViewById(r.g.progress_tb_imageview);
            this.aKr.setClickable(true);
            this.aKr.setDefaultResource(0);
            this.aKr.setDefaultErrorResource(0);
            this.aKr.setDefaultBgResource(0);
            this.aKr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fCA = new com.baidu.tbadk.img.b();
            this.aKr.setOnClickListener(new s(this));
            this.ezq = (ProgressBar) this.fCz.findViewById(r.g.progress_tb_imageview_progress);
            this.ezq.setVisibility(8);
        }

        public View getView() {
            return this.fCz;
        }

        public void k(ImageFileInfo imageFileInfo) {
            bhk();
            this.aKr.setDefaultResource(0);
            this.aKr.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fCA.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aKr);
                return;
            }
            lE(false);
            this.fCA.a(imageFileInfo, new t(this), false);
        }

        public void bhk() {
            if (this.fCA != null) {
                this.fCA.Ed();
            }
            if (this.aKr != null) {
                this.aKr.setImageDrawable(null);
            }
        }

        public boolean bnf() {
            return this.ezq.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lE(boolean z) {
            if (z) {
                if (this.ezq.getVisibility() != 8) {
                    if (r.this.fCu != null) {
                        r.this.fCu.bne();
                    }
                    this.ezq.setVisibility(8);
                    r.this.fCw[this.index].setCanbeClick(true);
                }
            } else if (this.ezq.getVisibility() != 0) {
                if (r.this.fCu != null) {
                    r.this.fCu.bnd();
                }
                this.ezq.setVisibility(0);
                r.this.fCw[this.index].setCanbeClick(false);
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
