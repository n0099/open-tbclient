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
    private WriteMultiImgsActivity jSa;
    private ImageFileInfo[] jSb;
    private a jSc;
    private b[] jSd;
    private int jSe;
    private LinkedList<ImageFileInfo> jSf = new LinkedList<>();
    private int jSg;
    private int jSh;
    private h jSi;
    private com.baidu.tbadk.core.dialog.a jSj;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void W(int i, boolean z);

        void cBs();

        void cBu();

        boolean cBv();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jSa = null;
        this.jSb = null;
        this.mViewPager = null;
        this.jSc = null;
        this.mCount = 0;
        this.bpM = 0;
        this.jSd = null;
        this.jSg = 120;
        this.jSh = 120;
        this.mIsFromIm = z;
        this.jSa = writeMultiImgsActivity;
        this.jSi = hVar;
        this.jSg = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jSh = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bpM = e(linkedList, i);
        this.mCount = this.jSf.size();
        this.jSb = new ImageFileInfo[this.mCount];
        this.jSd = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jSb[i2] = this.jSf.get(i2).cloneWithoutFilterAction(true);
            this.jSb[i2].addPageAction(com.baidu.tbadk.img.effect.d.al(this.jSg, this.jSh));
            linkedList.set(linkedList.indexOf(this.jSf.get(i2)), this.jSb[i2]);
            this.jSb[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jSc = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jSf.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jSf.add(next);
                }
            }
            return this.jSf.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cBo() {
        return this.bpM;
    }

    private boolean Wo() {
        return (this.jSd == null || this.bpM >= this.jSd.length || this.jSd[this.bpM] == null || this.jSb == null || this.bpM >= this.jSb.length || this.jSb[this.bpM] == null) ? false : true;
    }

    public boolean cBp() {
        if (this.bpM >= this.jSb.length || this.jSb[this.bpM] == null || !this.jSb[this.bpM].isGif() || this.jSb[this.bpM].mCount > 0) {
            return false;
        }
        this.jSb[this.bpM].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cBp()) {
            if (this.jSc != null) {
                this.jSc.W(i, z);
            }
        } else if (z) {
            Dj(i);
        } else if (Wo() && (bVar = this.jSd[this.bpM]) != null && (imageFileInfo = this.jSb[this.bpM]) != null && bVar.cBw()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.kG(i));
            this.jSa.cCt();
            bVar.j(imageFileInfo);
        }
    }

    private void Dj(int i) {
        this.jSe = i;
        if (this.jSj == null) {
            this.jSj = new com.baidu.tbadk.core.dialog.a(this.jSa);
            this.jSj.hu(R.string.rorate_tip);
            this.jSj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jSj != null) {
                        MultiImagePagerAdapter.this.jSj.dismiss();
                    }
                    MultiImagePagerAdapter.this.jSi.jUx.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cBr() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cBs() {
                            MultiImagePagerAdapter.this.jSc.cBs();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean P(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cBt() {
                        }
                    });
                    MultiImagePagerAdapter.this.V(MultiImagePagerAdapter.this.jSe, false);
                }
            });
            this.jSj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jSj != null) {
                        MultiImagePagerAdapter.this.jSj.dismiss();
                    }
                }
            });
            this.jSj.b(this.jSa.getPageContext());
        }
        this.jSj.agI();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jSd[i] == null) {
            this.jSd[i] = new b(i);
        }
        this.mViewPager.addView(this.jSd[i].getView());
        return this.jSd[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jSd[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bpM = i;
        cBq();
    }

    private void cBq() {
        if (this.bpM >= 0 && this.jSd != null && this.bpM < this.jSd.length && this.bpM < this.jSb.length && this.jSb[this.bpM] != null) {
            for (int i = 0; i < this.jSd.length; i++) {
                if (this.jSd[i] != null) {
                    this.jSd[i].aXZ();
                }
            }
            if (this.jSd[this.bpM] == null) {
                this.jSd[this.bpM] = new b(this.bpM);
            }
            this.jSd[this.bpM].j(this.jSb[this.bpM]);
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
    public void sl(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jSb != null) {
            for (int i = 0; i < this.jSb.length; i++) {
                ImageFileInfo imageFileInfo = this.jSb[i];
                if (imageFileInfo != null) {
                    this.jSb[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!Wo()) {
                if (!z && this.mIsFromIm) {
                    O(this.mBitmap);
                }
            } else if (this.jSc != null && this.jSc.cBv() && this.jSi != null && this.jSi.jUx != null) {
                this.jSi.jUx.bQL();
                TbImageView tbImageView = this.jSd[this.bpM].SD;
                try {
                    bitmap = this.jSi.jUx.cCW();
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
                        this.jSb[this.bpM].setFilePath(m.b(m.aid(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jSb[this.bpM].clearAllActions();
                        this.jSb[this.bpM].clearPageActions();
                        this.jSb[this.bpM].setIsGif(false);
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
                this.jSb[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView SD;
        private int index;
        private FrameLayout jSm;
        private com.baidu.tbadk.img.b jSn;
        private ProgressBar jaz;

        public b(int i) {
            this.jaz = null;
            this.index = -1;
            this.index = i;
            this.jSm = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jSa.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.SD = (TbImageView) this.jSm.findViewById(R.id.progress_tb_imageview);
            this.SD.setClickable(true);
            this.SD.setDefaultResource(0);
            this.SD.setDefaultErrorResource(0);
            this.SD.setDefaultBgResource(0);
            this.SD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.SD.setPadding(0, 0, 0, 0);
            this.jSn = new com.baidu.tbadk.img.b();
            this.SD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jSc != null) {
                        MultiImagePagerAdapter.this.jSc.cBu();
                    }
                }
            });
            this.jaz = (ProgressBar) this.jSm.findViewById(R.id.progress_tb_imageview_progress);
            this.jaz.setVisibility(8);
        }

        public View getView() {
            return this.jSm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.SD != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.jSa), (l.ah(MultiImagePagerAdapter.this.jSa) - l.g(MultiImagePagerAdapter.this.jSa, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.SD.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.SD.setLayoutParams(layoutParams);
                aVar.a(this.SD);
                if (MultiImagePagerAdapter.this.jSi != null && MultiImagePagerAdapter.this.jSi.jUx != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jSi.jUx.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    MultiImagePagerAdapter.this.jSi.jUx.setLayoutParams(layoutParams2);
                }
                if (aVar.nK() != null && !aVar.nK().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.nK();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aXZ();
                this.jaz.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jSn.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.jaz.setVisibility(8);
                    return;
                }
                this.jSn.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.jaz.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jSi != null) {
                            MultiImagePagerAdapter.this.jSi.cBj();
                        }
                    }
                }, false);
            }
        }

        public void aXZ() {
            if (this.jSn != null) {
                this.jSn.atG();
            }
            if (this.SD != null) {
            }
        }

        public boolean cBw() {
            return this.jaz.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
