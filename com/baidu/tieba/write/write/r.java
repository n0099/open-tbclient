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
import com.baidu.tieba.u;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private ViewPager atL;
    private int aue;
    private WriteMultiImgsActivity fTX;
    private ImageFileInfo[] fTY;
    private a fTZ;
    private b[] fUa;
    private com.baidu.tbadk.coreExtra.view.c[] fUb;
    private int fUc;
    private int fUd;
    private int nL;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void boO();

        void boP();

        void boQ();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fTX = null;
        this.fTY = null;
        this.atL = null;
        this.fTZ = null;
        this.nL = 0;
        this.aue = 0;
        this.fUa = null;
        this.fUb = null;
        this.fUc = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fUd = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fTX = writeMultiImgsActivity;
        this.fUc = (int) writeMultiImgsActivity.getResources().getDimension(u.e.ds720);
        this.fUd = (int) writeMultiImgsActivity.getResources().getDimension(u.e.ds1280);
        if (linkedList != null) {
            this.nL = linkedList.size();
        }
        this.fTY = new ImageFileInfo[this.nL];
        this.fUa = new b[this.nL];
        this.fUb = new com.baidu.tbadk.coreExtra.view.c[this.nL];
        while (true) {
            int i3 = i2;
            if (i3 < this.nL) {
                a(linkedList.get(i3), i3);
                this.fTY[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fTY[i3].addPageAction(com.baidu.tbadk.img.effect.d.D(this.fUc, this.fUd));
                linkedList.set(i3, this.fTY[i3]);
                i2 = i3 + 1;
            } else {
                this.aue = i;
                this.atL = viewPager;
                this.fTZ = aVar;
                this.atL.setOffscreenPageLimit(1);
                this.atL.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sP(int i) {
        if (this.fUa[this.aue].boR()) {
            this.fTY[this.aue].addPageAction(com.baidu.tbadk.img.effect.e.eE(i));
            this.fTX.bpA();
            if (this.fUb[this.aue] != null) {
                String selectedFilter = this.fUb[this.aue].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fTY[this.aue].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fR(selectedFilter));
                    this.fUa[this.aue].l(cloneWithoutFilterAction);
                    return;
                }
                this.fUa[this.aue].l(this.fTY[this.aue]);
                return;
            }
            this.fUa[this.aue].l(this.fTY[this.aue]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eJ(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fTX.bpA();
            ImageFileInfo cloneWithoutFilterAction = this.fTY[this.aue].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fR(str));
            this.fUa[this.aue].l(cloneWithoutFilterAction);
            return;
        }
        this.fTX.bpB();
        this.fUa[this.aue].l(this.fTY[this.aue]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fUa[i] == null) {
            this.fUa[i] = new b(i);
        }
        this.atL.addView(this.fUa[i].getView());
        return this.fUa[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.atL.removeView(this.fUa[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aue = i;
        boM();
        if (this.fTZ != null) {
            this.fTZ.a(this.fUb[i], i);
        }
    }

    private void boM() {
        if (this.aue >= 0) {
            if (this.fUa != null) {
                for (int i = 0; i < this.fUa.length; i++) {
                    if (this.fUa[i] != null) {
                        this.fUa[i].bgO();
                    }
                }
                if (this.fUa[this.aue] == null) {
                    this.fUa[this.aue] = new b(this.aue);
                }
            }
            String selectedFilter = this.fUb[this.aue].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fTY[this.aue].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fR(selectedFilter));
                if (this.fUa != null) {
                    this.fUa[this.aue].l(cloneWithoutFilterAction);
                }
            } else if (this.fUa != null) {
                this.fUa[this.aue].l(this.fTY[this.aue]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aue;
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
        this.fUb[i] = new com.baidu.tbadk.coreExtra.view.c(this.fTX, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.nL;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void boN() {
        String selectedFilter;
        for (int i = 0; i < this.fTY.length; i++) {
            this.fTY[i].applayRotatePageActionToPersistAction();
            if (this.fUb[i] != null && (selectedFilter = this.fUb[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fTY[i].addPersistAction(com.baidu.tbadk.img.effect.a.fR(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aHs;
        private ProgressBar eGf;
        private FrameLayout fUe;
        private com.baidu.tbadk.img.b fUf;
        private int index;

        public b(int i) {
            this.eGf = null;
            this.index = -1;
            this.index = i;
            this.fUe = (FrameLayout) LayoutInflater.from(r.this.fTX.getPageContext().getContext()).inflate(u.h.progress_tb_imageview, (ViewGroup) null);
            this.aHs = (TbImageView) this.fUe.findViewById(u.g.progress_tb_imageview);
            this.aHs.setClickable(true);
            this.aHs.setDefaultResource(0);
            this.aHs.setDefaultErrorResource(0);
            this.aHs.setDefaultBgResource(0);
            this.aHs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fUf = new com.baidu.tbadk.img.b();
            this.aHs.setOnClickListener(new s(this));
            this.eGf = (ProgressBar) this.fUe.findViewById(u.g.progress_tb_imageview_progress);
            this.eGf.setVisibility(8);
        }

        public View getView() {
            return this.fUe;
        }

        public void l(ImageFileInfo imageFileInfo) {
            bgO();
            this.aHs.setDefaultResource(0);
            this.aHs.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fUf.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aHs);
                return;
            }
            ly(false);
            this.fUf.a(imageFileInfo, new t(this), false);
        }

        public void bgO() {
            if (this.fUf != null) {
                this.fUf.CV();
            }
            if (this.aHs != null) {
                this.aHs.setImageDrawable(null);
            }
        }

        public boolean boR() {
            return this.eGf.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ly(boolean z) {
            if (z) {
                if (this.eGf.getVisibility() != 8) {
                    if (r.this.fTZ != null) {
                        r.this.fTZ.boQ();
                    }
                    this.eGf.setVisibility(8);
                    r.this.fUb[this.index].setCanbeClick(true);
                }
            } else if (this.eGf.getVisibility() != 0) {
                if (r.this.fTZ != null) {
                    r.this.fTZ.boP();
                }
                this.eGf.setVisibility(0);
                r.this.fUb[this.index].setCanbeClick(false);
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
