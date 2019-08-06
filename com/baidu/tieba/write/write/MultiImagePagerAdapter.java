package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int bpM;
    private WriteMultiImgsActivity jTg;
    private ImageFileInfo[] jTh;
    private a jTi;
    private b[] jTj;
    private int jTk;
    private LinkedList<ImageFileInfo> jTl = new LinkedList<>();
    private int jTm;
    private int jTn;
    private h jTo;
    private com.baidu.tbadk.core.dialog.a jTp;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void W(int i, boolean z);

        void cBN();

        void cBP();

        boolean cBQ();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jTg = null;
        this.jTh = null;
        this.mViewPager = null;
        this.jTi = null;
        this.mCount = 0;
        this.bpM = 0;
        this.jTj = null;
        this.jTm = 120;
        this.jTn = 120;
        this.mIsFromIm = z;
        this.jTg = writeMultiImgsActivity;
        this.jTo = hVar;
        this.jTm = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jTn = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bpM = e(linkedList, i);
        this.mCount = this.jTl.size();
        this.jTh = new ImageFileInfo[this.mCount];
        this.jTj = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jTh[i2] = this.jTl.get(i2).cloneWithoutFilterAction(true);
            this.jTh[i2].addPageAction(com.baidu.tbadk.img.effect.d.al(this.jTm, this.jTn));
            linkedList.set(linkedList.indexOf(this.jTl.get(i2)), this.jTh[i2]);
            this.jTh[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jTi = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jTl.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jTl.add(next);
                }
            }
            return this.jTl.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cBJ() {
        return this.bpM;
    }

    private boolean Wo() {
        return (this.jTj == null || this.bpM >= this.jTj.length || this.jTj[this.bpM] == null || this.jTh == null || this.bpM >= this.jTh.length || this.jTh[this.bpM] == null) ? false : true;
    }

    public boolean cBK() {
        if (this.bpM >= this.jTh.length || this.jTh[this.bpM] == null || !this.jTh[this.bpM].isGif() || this.jTh[this.bpM].mCount > 0) {
            return false;
        }
        this.jTh[this.bpM].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cBK()) {
            if (this.jTi != null) {
                this.jTi.W(i, z);
            }
        } else if (z) {
            Dl(i);
        } else if (Wo() && (bVar = this.jTj[this.bpM]) != null && (imageFileInfo = this.jTh[this.bpM]) != null && bVar.cBR()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.kH(i));
            this.jTg.cCO();
            bVar.j(imageFileInfo);
        }
    }

    private void Dl(int i) {
        this.jTk = i;
        if (this.jTp == null) {
            this.jTp = new com.baidu.tbadk.core.dialog.a(this.jTg);
            this.jTp.hu(R.string.rorate_tip);
            this.jTp.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jTp != null) {
                        MultiImagePagerAdapter.this.jTp.dismiss();
                    }
                    MultiImagePagerAdapter.this.jTo.jVD.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cBM() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cBN() {
                            MultiImagePagerAdapter.this.jTi.cBN();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean P(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cBO() {
                        }
                    });
                    MultiImagePagerAdapter.this.V(MultiImagePagerAdapter.this.jTk, false);
                }
            });
            this.jTp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jTp != null) {
                        MultiImagePagerAdapter.this.jTp.dismiss();
                    }
                }
            });
            this.jTp.b(this.jTg.getPageContext());
        }
        this.jTp.agK();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jTj[i] == null) {
            this.jTj[i] = new b(i);
        }
        this.mViewPager.addView(this.jTj[i].getView());
        return this.jTj[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jTj[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bpM = i;
        cBL();
    }

    private void cBL() {
        if (this.bpM >= 0 && this.jTj != null && this.bpM < this.jTj.length && this.bpM < this.jTh.length && this.jTh[this.bpM] != null) {
            for (int i = 0; i < this.jTj.length; i++) {
                if (this.jTj[i] != null) {
                    this.jTj[i].aYb();
                }
            }
            if (this.jTj[this.bpM] == null) {
                this.jTj[this.bpM] = new b(this.bpM);
            }
            this.jTj[this.bpM].j(this.jTh[this.bpM]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bpM;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean f(String str, Bitmap bitmap) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sm(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jTh != null) {
            for (int i = 0; i < this.jTh.length; i++) {
                ImageFileInfo imageFileInfo = this.jTh[i];
                if (imageFileInfo != null) {
                    this.jTh[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!Wo()) {
                if (!z && this.mIsFromIm) {
                    O(this.mBitmap);
                }
            } else if (this.jTi != null && this.jTi.cBQ() && this.jTo != null && this.jTo.jVD != null) {
                this.jTo.jVD.bQZ();
                TbImageView tbImageView = this.jTj[this.bpM].SD;
                try {
                    bitmap = this.jTo.jVD.cDr();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.f.bh(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.f.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.jTh[this.bpM].setFilePath(m.b(m.aif(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jTh[this.bpM].clearAllActions();
                        this.jTh[this.bpM].clearPageActions();
                        this.jTh[this.bpM].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            O(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                O(this.mBitmap);
            }
        }
    }

    private void O(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (f(str, bitmap)) {
                this.jTh[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView SD;
        private int index;
        private FrameLayout jTs;
        private com.baidu.tbadk.img.b jTt;
        private ProgressBar jbD;

        public b(int i) {
            this.jbD = null;
            this.index = -1;
            this.index = i;
            this.jTs = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jTg.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.SD = (TbImageView) this.jTs.findViewById(R.id.progress_tb_imageview);
            this.SD.setClickable(true);
            this.SD.setDefaultResource(0);
            this.SD.setDefaultErrorResource(0);
            this.SD.setDefaultBgResource(0);
            this.SD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.SD.setPadding(0, 0, 0, 0);
            this.jTt = new com.baidu.tbadk.img.b();
            this.SD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jTi != null) {
                        MultiImagePagerAdapter.this.jTi.cBP();
                    }
                }
            });
            this.jbD = (ProgressBar) this.jTs.findViewById(R.id.progress_tb_imageview_progress);
            this.jbD.setVisibility(8);
        }

        public View getView() {
            return this.jTs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.SD != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.jTg), (l.ah(MultiImagePagerAdapter.this.jTg) - l.g(MultiImagePagerAdapter.this.jTg, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.SD.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.SD.setLayoutParams(layoutParams);
                aVar.a(this.SD);
                if (MultiImagePagerAdapter.this.jTo != null && MultiImagePagerAdapter.this.jTo.jVD != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jTo.jVD.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    MultiImagePagerAdapter.this.jTo.jVD.setLayoutParams(layoutParams2);
                }
                if (aVar.nK() != null && !aVar.nK().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.nK();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aYb();
                this.jbD.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jTt.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.jbD.setVisibility(8);
                    return;
                }
                this.jTt.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.jbD.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jTo != null) {
                            MultiImagePagerAdapter.this.jTo.cBE();
                        }
                    }
                }, false);
            }
        }

        public void aYb() {
            if (this.jTt != null) {
                this.jTt.atI();
            }
            if (this.SD != null) {
            }
        }

        public boolean cBR() {
            return this.jbD.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
