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
    private ViewPager aiC;
    private int axF;
    private WriteMultiImgsActivity gnP;
    private ImageFileInfo[] gnQ;
    private a gnR;
    private b[] gnS;
    private com.baidu.tbadk.coreExtra.view.c[] gnT;
    private int gnU;
    private int gnV;
    private int qh;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bwe();

        void bwf();

        void bwg();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gnP = null;
        this.gnQ = null;
        this.aiC = null;
        this.gnR = null;
        this.qh = 0;
        this.axF = 0;
        this.gnS = null;
        this.gnT = null;
        this.gnU = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.gnV = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.gnP = writeMultiImgsActivity;
        this.gnU = (int) writeMultiImgsActivity.getResources().getDimension(r.e.ds720);
        this.gnV = (int) writeMultiImgsActivity.getResources().getDimension(r.e.ds1280);
        if (linkedList != null) {
            this.qh = linkedList.size();
        }
        this.gnQ = new ImageFileInfo[this.qh];
        this.gnS = new b[this.qh];
        this.gnT = new com.baidu.tbadk.coreExtra.view.c[this.qh];
        while (true) {
            int i3 = i2;
            if (i3 < this.qh) {
                a(linkedList.get(i3), i3);
                this.gnQ[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gnQ[i3].addPageAction(com.baidu.tbadk.img.effect.d.F(this.gnU, this.gnV));
                linkedList.set(i3, this.gnQ[i3]);
                i2 = i3 + 1;
            } else {
                this.axF = i;
                this.aiC = viewPager;
                this.gnR = aVar;
                this.aiC.setOffscreenPageLimit(1);
                this.aiC.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ua(int i) {
        if (this.gnS[this.axF].bwh()) {
            this.gnQ[this.axF].addPageAction(com.baidu.tbadk.img.effect.e.eU(i));
            this.gnP.bwO();
            if (this.gnT[this.axF] != null) {
                String selectedFilter = this.gnT[this.axF].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.gnQ[this.axF].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gb(selectedFilter));
                    this.gnS[this.axF].l(cloneWithoutFilterAction);
                    return;
                }
                this.gnS[this.axF].l(this.gnQ[this.axF]);
                return;
            }
            this.gnS[this.axF].l(this.gnQ[this.axF]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eR(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.gnP.bwO();
            ImageFileInfo cloneWithoutFilterAction = this.gnQ[this.axF].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gb(str));
            this.gnS[this.axF].l(cloneWithoutFilterAction);
            return;
        }
        this.gnP.bwP();
        this.gnS[this.axF].l(this.gnQ[this.axF]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gnS[i] == null) {
            this.gnS[i] = new b(i);
        }
        this.aiC.addView(this.gnS[i].getView());
        return this.gnS[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aiC.removeView(this.gnS[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.axF = i;
        bwc();
        if (this.gnR != null) {
            this.gnR.a(this.gnT[i], i);
        }
    }

    private void bwc() {
        if (this.axF >= 0) {
            if (this.gnS != null) {
                for (int i = 0; i < this.gnS.length; i++) {
                    if (this.gnS[i] != null) {
                        this.gnS[i].bnq();
                    }
                }
                if (this.gnS[this.axF] == null) {
                    this.gnS[this.axF] = new b(this.axF);
                }
            }
            String selectedFilter = this.gnT[this.axF].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.gnQ[this.axF].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gb(selectedFilter));
                if (this.gnS != null) {
                    this.gnS[this.axF].l(cloneWithoutFilterAction);
                }
            } else if (this.gnS != null) {
                this.gnS[this.axF].l(this.gnQ[this.axF]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.axF;
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
        this.gnT[i] = new com.baidu.tbadk.coreExtra.view.c(this.gnP, this, str);
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
    public void bwd() {
        String selectedFilter;
        for (int i = 0; i < this.gnQ.length; i++) {
            this.gnQ[i].applayRotatePageActionToPersistAction();
            if (this.gnT[i] != null && (selectedFilter = this.gnT[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.gnQ[i].addPersistAction(com.baidu.tbadk.img.effect.a.gb(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aLa;
        private ProgressBar eVP;
        private FrameLayout gnW;
        private com.baidu.tbadk.img.b gnX;
        private int index;

        public b(int i) {
            this.eVP = null;
            this.index = -1;
            this.index = i;
            this.gnW = (FrameLayout) LayoutInflater.from(r.this.gnP.getPageContext().getContext()).inflate(r.h.progress_tb_imageview, (ViewGroup) null);
            this.aLa = (TbImageView) this.gnW.findViewById(r.g.progress_tb_imageview);
            this.aLa.setClickable(true);
            this.aLa.setDefaultResource(0);
            this.aLa.setDefaultErrorResource(0);
            this.aLa.setDefaultBgResource(0);
            this.aLa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gnX = new com.baidu.tbadk.img.b();
            this.aLa.setOnClickListener(new s(this));
            this.eVP = (ProgressBar) this.gnW.findViewById(r.g.progress_tb_imageview_progress);
            this.eVP.setVisibility(8);
        }

        public View getView() {
            return this.gnW;
        }

        public void l(ImageFileInfo imageFileInfo) {
            bnq();
            this.aLa.setDefaultResource(0);
            this.aLa.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gnX.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aLa);
                return;
            }
            mp(false);
            this.gnX.a(imageFileInfo, new t(this), false);
        }

        public void bnq() {
            if (this.gnX != null) {
                this.gnX.Ev();
            }
            if (this.aLa != null) {
                this.aLa.setImageDrawable(null);
            }
        }

        public boolean bwh() {
            return this.eVP.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mp(boolean z) {
            if (z) {
                if (this.eVP.getVisibility() != 8) {
                    if (r.this.gnR != null) {
                        r.this.gnR.bwg();
                    }
                    this.eVP.setVisibility(8);
                    r.this.gnT[this.index].setCanbeClick(true);
                }
            } else if (this.eVP.getVisibility() != 0) {
                if (r.this.gnR != null) {
                    r.this.gnR.bwf();
                }
                this.eVP.setVisibility(0);
                r.this.gnT[this.index].setCanbeClick(false);
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
