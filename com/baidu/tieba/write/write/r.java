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
    private ViewPager asW;
    private int atp;
    private WriteMultiImgsActivity fIg;
    private ImageFileInfo[] fIh;
    private a fIi;
    private b[] fIj;
    private com.baidu.tbadk.coreExtra.view.c[] fIk;
    private int fIl;
    private int fIm;
    private int ni;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void blT();

        void blU();

        void blV();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fIg = null;
        this.fIh = null;
        this.asW = null;
        this.fIi = null;
        this.ni = 0;
        this.atp = 0;
        this.fIj = null;
        this.fIk = null;
        this.fIl = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fIm = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fIg = writeMultiImgsActivity;
        this.fIl = (int) writeMultiImgsActivity.getResources().getDimension(u.e.ds720);
        this.fIm = (int) writeMultiImgsActivity.getResources().getDimension(u.e.ds1280);
        if (linkedList != null) {
            this.ni = linkedList.size();
        }
        this.fIh = new ImageFileInfo[this.ni];
        this.fIj = new b[this.ni];
        this.fIk = new com.baidu.tbadk.coreExtra.view.c[this.ni];
        while (true) {
            int i3 = i2;
            if (i3 < this.ni) {
                a(linkedList.get(i3), i3);
                this.fIh[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fIh[i3].addPageAction(com.baidu.tbadk.img.effect.d.D(this.fIl, this.fIm));
                linkedList.set(i3, this.fIh[i3]);
                i2 = i3 + 1;
            } else {
                this.atp = i;
                this.asW = viewPager;
                this.fIi = aVar;
                this.asW.setOffscreenPageLimit(1);
                this.asW.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sB(int i) {
        if (this.fIj[this.atp].blW()) {
            this.fIh[this.atp].addPageAction(com.baidu.tbadk.img.effect.e.eE(i));
            this.fIg.bmG();
            if (this.fIk[this.atp] != null) {
                String selectedFilter = this.fIk[this.atp].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fIh[this.atp].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fT(selectedFilter));
                    this.fIj[this.atp].l(cloneWithoutFilterAction);
                    return;
                }
                this.fIj[this.atp].l(this.fIh[this.atp]);
                return;
            }
            this.fIj[this.atp].l(this.fIh[this.atp]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eL(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fIg.bmG();
            ImageFileInfo cloneWithoutFilterAction = this.fIh[this.atp].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fT(str));
            this.fIj[this.atp].l(cloneWithoutFilterAction);
            return;
        }
        this.fIg.bmH();
        this.fIj[this.atp].l(this.fIh[this.atp]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fIj[i] == null) {
            this.fIj[i] = new b(i);
        }
        this.asW.addView(this.fIj[i].getView());
        return this.fIj[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.asW.removeView(this.fIj[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.atp = i;
        blR();
        if (this.fIi != null) {
            this.fIi.a(this.fIk[i], i);
        }
    }

    private void blR() {
        if (this.atp >= 0) {
            if (this.fIj != null) {
                for (int i = 0; i < this.fIj.length; i++) {
                    if (this.fIj[i] != null) {
                        this.fIj[i].bdx();
                    }
                }
                if (this.fIj[this.atp] == null) {
                    this.fIj[this.atp] = new b(this.atp);
                }
            }
            String selectedFilter = this.fIk[this.atp].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fIh[this.atp].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fT(selectedFilter));
                if (this.fIj != null) {
                    this.fIj[this.atp].l(cloneWithoutFilterAction);
                }
            } else if (this.fIj != null) {
                this.fIj[this.atp].l(this.fIh[this.atp]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.atp;
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
        this.fIk[i] = new com.baidu.tbadk.coreExtra.view.c(this.fIg, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ni;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void blS() {
        String selectedFilter;
        for (int i = 0; i < this.fIh.length; i++) {
            this.fIh[i].applayRotatePageActionToPersistAction();
            if (this.fIk[i] != null && (selectedFilter = this.fIk[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fIh[i].addPersistAction(com.baidu.tbadk.img.effect.a.fT(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aGB;
        private ProgressBar euu;
        private FrameLayout fIn;
        private com.baidu.tbadk.img.b fIo;
        private int index;

        public b(int i) {
            this.euu = null;
            this.index = -1;
            this.index = i;
            this.fIn = (FrameLayout) LayoutInflater.from(r.this.fIg.getPageContext().getContext()).inflate(u.h.progress_tb_imageview, (ViewGroup) null);
            this.aGB = (TbImageView) this.fIn.findViewById(u.g.progress_tb_imageview);
            this.aGB.setClickable(true);
            this.aGB.setDefaultResource(0);
            this.aGB.setDefaultErrorResource(0);
            this.aGB.setDefaultBgResource(0);
            this.aGB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fIo = new com.baidu.tbadk.img.b();
            this.aGB.setOnClickListener(new s(this));
            this.euu = (ProgressBar) this.fIn.findViewById(u.g.progress_tb_imageview_progress);
            this.euu.setVisibility(8);
        }

        public View getView() {
            return this.fIn;
        }

        public void l(ImageFileInfo imageFileInfo) {
            bdx();
            this.aGB.setDefaultResource(0);
            this.aGB.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fIo.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aGB);
                return;
            }
            lm(false);
            this.fIo.a(imageFileInfo, new t(this), false);
        }

        public void bdx() {
            if (this.fIo != null) {
                this.fIo.CW();
            }
            if (this.aGB != null) {
                this.aGB.setImageDrawable(null);
            }
        }

        public boolean blW() {
            return this.euu.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lm(boolean z) {
            if (z) {
                if (this.euu.getVisibility() != 8) {
                    if (r.this.fIi != null) {
                        r.this.fIi.blV();
                    }
                    this.euu.setVisibility(8);
                    r.this.fIk[this.index].setCanbeClick(true);
                }
            } else if (this.euu.getVisibility() != 0) {
                if (r.this.fIi != null) {
                    r.this.fIi.blU();
                }
                this.euu.setVisibility(0);
                r.this.fIk[this.index].setCanbeClick(false);
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
