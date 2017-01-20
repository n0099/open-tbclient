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
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private int awg;
    private WriteMultiImgsActivity fKN;
    private ImageFileInfo[] fKO;
    private a fKP;
    private b[] fKQ;
    private com.baidu.tbadk.coreExtra.view.c[] fKR;
    private int fKS;
    private int fKT;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void boA();

        void boB();

        void boC();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fKN = null;
        this.fKO = null;
        this.mViewPager = null;
        this.fKP = null;
        this.mCount = 0;
        this.awg = 0;
        this.fKQ = null;
        this.fKR = null;
        this.fKS = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fKT = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fKN = writeMultiImgsActivity;
        this.fKS = (int) writeMultiImgsActivity.getResources().getDimension(r.f.ds720);
        this.fKT = (int) writeMultiImgsActivity.getResources().getDimension(r.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.fKO = new ImageFileInfo[this.mCount];
        this.fKQ = new b[this.mCount];
        this.fKR = new com.baidu.tbadk.coreExtra.view.c[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.fKO[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fKO[i3].addPageAction(com.baidu.tbadk.img.effect.d.G(this.fKS, this.fKT));
                linkedList.set(i3, this.fKO[i3]);
                i2 = i3 + 1;
            } else {
                this.awg = i;
                this.mViewPager = viewPager;
                this.fKP = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tk(int i) {
        if (this.fKQ[this.awg].boD()) {
            this.fKO[this.awg].addPageAction(com.baidu.tbadk.img.effect.e.eW(i));
            this.fKN.bpl();
            if (this.fKR[this.awg] != null) {
                String selectedFilter = this.fKR[this.awg].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fKO[this.awg].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fU(selectedFilter));
                    this.fKQ[this.awg].k(cloneWithoutFilterAction);
                    return;
                }
                this.fKQ[this.awg].k(this.fKO[this.awg]);
                return;
            }
            this.fKQ[this.awg].k(this.fKO[this.awg]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eK(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fKN.bpl();
            ImageFileInfo cloneWithoutFilterAction = this.fKO[this.awg].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fU(str));
            this.fKQ[this.awg].k(cloneWithoutFilterAction);
            return;
        }
        this.fKN.bpm();
        this.fKQ[this.awg].k(this.fKO[this.awg]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fKQ[i] == null) {
            this.fKQ[i] = new b(i);
        }
        this.mViewPager.addView(this.fKQ[i].getView());
        return this.fKQ[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.fKQ[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.awg = i;
        boy();
        if (this.fKP != null) {
            this.fKP.a(this.fKR[i], i);
        }
    }

    private void boy() {
        if (this.awg >= 0) {
            if (this.fKQ != null) {
                for (int i = 0; i < this.fKQ.length; i++) {
                    if (this.fKQ[i] != null) {
                        this.fKQ[i].PV();
                    }
                }
                if (this.fKQ[this.awg] == null) {
                    this.fKQ[this.awg] = new b(this.awg);
                }
            }
            String selectedFilter = this.fKR[this.awg].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fKO[this.awg].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fU(selectedFilter));
                if (this.fKQ != null) {
                    this.fKQ[this.awg].k(cloneWithoutFilterAction);
                }
            } else if (this.fKQ != null) {
                this.fKQ[this.awg].k(this.fKO[this.awg]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.awg;
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
        this.fKR[i] = new com.baidu.tbadk.coreExtra.view.c(this.fKN, this, str);
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
    public void boz() {
        String selectedFilter;
        for (int i = 0; i < this.fKO.length; i++) {
            this.fKO[i].applayRotatePageActionToPersistAction();
            if (this.fKR[i] != null && (selectedFilter = this.fKR[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fKO[i].addPersistAction(com.baidu.tbadk.img.effect.a.fU(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aIY;
        private ProgressBar eJm;
        private FrameLayout fKU;
        private com.baidu.tbadk.img.b fKV;
        private int index;

        public b(int i) {
            this.eJm = null;
            this.index = -1;
            this.index = i;
            this.fKU = (FrameLayout) LayoutInflater.from(q.this.fKN.getPageContext().getContext()).inflate(r.j.progress_tb_imageview, (ViewGroup) null);
            this.aIY = (TbImageView) this.fKU.findViewById(r.h.progress_tb_imageview);
            this.aIY.setClickable(true);
            this.aIY.setDefaultResource(0);
            this.aIY.setDefaultErrorResource(0);
            this.aIY.setDefaultBgResource(0);
            this.aIY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fKV = new com.baidu.tbadk.img.b();
            this.aIY.setOnClickListener(new r(this));
            this.eJm = (ProgressBar) this.fKU.findViewById(r.h.progress_tb_imageview_progress);
            this.eJm.setVisibility(8);
        }

        public View getView() {
            return this.fKU;
        }

        public void k(ImageFileInfo imageFileInfo) {
            PV();
            this.aIY.setDefaultResource(0);
            this.aIY.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fKV.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aIY);
                return;
            }
            lN(false);
            this.fKV.a(imageFileInfo, new s(this), false);
        }

        public void PV() {
            if (this.fKV != null) {
                this.fKV.DY();
            }
            if (this.aIY != null) {
                this.aIY.setImageDrawable(null);
            }
        }

        public boolean boD() {
            return this.eJm.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lN(boolean z) {
            if (z) {
                if (this.eJm.getVisibility() != 8) {
                    if (q.this.fKP != null) {
                        q.this.fKP.boC();
                    }
                    this.eJm.setVisibility(8);
                    q.this.fKR[this.index].setCanbeClick(true);
                }
            } else if (this.eJm.getVisibility() != 0) {
                if (q.this.fKP != null) {
                    q.this.fKP.boB();
                }
                this.eJm.setVisibility(0);
                q.this.fKR[this.index].setCanbeClick(false);
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
