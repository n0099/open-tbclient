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
    private int boZ;
    private WriteMultiImgsActivity jKY;
    private ImageFileInfo[] jKZ;
    private a jLa;
    private b[] jLb;
    private int jLc;
    private LinkedList<ImageFileInfo> jLd = new LinkedList<>();
    private int jLe;
    private int jLf;
    private h jLg;
    private com.baidu.tbadk.core.dialog.a jLh;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void U(int i, boolean z);

        void cyv();

        void cyx();

        boolean cyy();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jKY = null;
        this.jKZ = null;
        this.mViewPager = null;
        this.jLa = null;
        this.mCount = 0;
        this.boZ = 0;
        this.jLb = null;
        this.jLe = 120;
        this.jLf = 120;
        this.mIsFromIm = z;
        this.jKY = writeMultiImgsActivity;
        this.jLg = hVar;
        this.jLe = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jLf = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.boZ = e(linkedList, i);
        this.mCount = this.jLd.size();
        this.jKZ = new ImageFileInfo[this.mCount];
        this.jLb = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jKZ[i2] = this.jLd.get(i2).cloneWithoutFilterAction(true);
            this.jKZ[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jLe, this.jLf));
            linkedList.set(linkedList.indexOf(this.jLd.get(i2)), this.jKZ[i2]);
            this.jKZ[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jLa = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jLd.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jLd.add(next);
                }
            }
            return this.jLd.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cyr() {
        return this.boZ;
    }

    private boolean Vv() {
        return (this.jLb == null || this.boZ >= this.jLb.length || this.jLb[this.boZ] == null || this.jKZ == null || this.boZ >= this.jKZ.length || this.jKZ[this.boZ] == null) ? false : true;
    }

    public boolean cys() {
        if (this.boZ >= this.jKZ.length || this.jKZ[this.boZ] == null || !this.jKZ[this.boZ].isGif() || this.jKZ[this.boZ].mCount > 0) {
            return false;
        }
        this.jKZ[this.boZ].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cys()) {
            if (this.jLa != null) {
                this.jLa.U(i, z);
            }
        } else if (z) {
            CC(i);
        } else if (Vv() && (bVar = this.jLb[this.boZ]) != null && (imageFileInfo = this.jKZ[this.boZ]) != null && bVar.cyz()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.kA(i));
            this.jKY.czw();
            bVar.j(imageFileInfo);
        }
    }

    private void CC(int i) {
        this.jLc = i;
        if (this.jLh == null) {
            this.jLh = new com.baidu.tbadk.core.dialog.a(this.jKY);
            this.jLh.ho(R.string.rorate_tip);
            this.jLh.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jLh != null) {
                        MultiImagePagerAdapter.this.jLh.dismiss();
                    }
                    MultiImagePagerAdapter.this.jLg.jNv.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyu() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyv() {
                            MultiImagePagerAdapter.this.jLa.cyv();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean P(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyw() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.jLc, false);
                }
            });
            this.jLh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jLh != null) {
                        MultiImagePagerAdapter.this.jLh.dismiss();
                    }
                }
            });
            this.jLh.b(this.jKY.getPageContext());
        }
        this.jLh.afG();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jLb[i] == null) {
            this.jLb[i] = new b(i);
        }
        this.mViewPager.addView(this.jLb[i].getView());
        return this.jLb[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jLb[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.boZ = i;
        cyt();
    }

    private void cyt() {
        if (this.boZ >= 0 && this.jLb != null && this.boZ < this.jLb.length && this.boZ < this.jKZ.length && this.jKZ[this.boZ] != null) {
            for (int i = 0; i < this.jLb.length; i++) {
                if (this.jLb[i] != null) {
                    this.jLb[i].aWd();
                }
            }
            if (this.jLb[this.boZ] == null) {
                this.jLb[this.boZ] = new b(this.boZ);
            }
            this.jLb[this.boZ].j(this.jKZ[this.boZ]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.boZ;
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
    public void rV(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jKZ != null) {
            for (int i = 0; i < this.jKZ.length; i++) {
                ImageFileInfo imageFileInfo = this.jKZ[i];
                if (imageFileInfo != null) {
                    this.jKZ[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!Vv()) {
                if (!z && this.mIsFromIm) {
                    O(this.mBitmap);
                }
            } else if (this.jLa != null && this.jLa.cyy() && this.jLg != null && this.jLg.jNv != null) {
                this.jLg.jNv.bOb();
                TbImageView tbImageView = this.jLb[this.boZ].Sm;
                try {
                    bitmap = this.jLg.jNv.czZ();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.f.bf(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.f.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.jKZ[this.boZ].setFilePath(m.b(m.ahb(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jKZ[this.boZ].clearAllActions();
                        this.jKZ[this.boZ].clearPageActions();
                        this.jKZ[this.boZ].setIsGif(false);
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
                this.jKZ[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Sm;
        private ProgressBar iUf;
        private int index;
        private FrameLayout jLk;
        private com.baidu.tbadk.img.b jLl;

        public b(int i) {
            this.iUf = null;
            this.index = -1;
            this.index = i;
            this.jLk = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jKY.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Sm = (TbImageView) this.jLk.findViewById(R.id.progress_tb_imageview);
            this.Sm.setClickable(true);
            this.Sm.setDefaultResource(0);
            this.Sm.setDefaultErrorResource(0);
            this.Sm.setDefaultBgResource(0);
            this.Sm.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Sm.setPadding(0, 0, 0, 0);
            this.jLl = new com.baidu.tbadk.img.b();
            this.Sm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jLa != null) {
                        MultiImagePagerAdapter.this.jLa.cyx();
                    }
                }
            });
            this.iUf = (ProgressBar) this.jLk.findViewById(R.id.progress_tb_imageview_progress);
            this.iUf.setVisibility(8);
        }

        public View getView() {
            return this.jLk;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Sm != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.jKY), (l.ah(MultiImagePagerAdapter.this.jKY) - l.g(MultiImagePagerAdapter.this.jKY, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Sm.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.Sm.setLayoutParams(layoutParams);
                aVar.a(this.Sm);
                if (MultiImagePagerAdapter.this.jLg != null && MultiImagePagerAdapter.this.jLg.jNv != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jLg.jNv.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    MultiImagePagerAdapter.this.jLg.jNv.setLayoutParams(layoutParams2);
                }
                if (aVar.ns() != null && !aVar.ns().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.ns();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aWd();
                this.iUf.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jLl.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iUf.setVisibility(8);
                    return;
                }
                this.jLl.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iUf.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jLg != null) {
                            MultiImagePagerAdapter.this.jLg.cym();
                        }
                    }
                }, false);
            }
        }

        public void aWd() {
            if (this.jLl != null) {
                this.jLl.asz();
            }
            if (this.Sm != null) {
            }
        }

        public boolean cyz() {
            return this.iUf.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
