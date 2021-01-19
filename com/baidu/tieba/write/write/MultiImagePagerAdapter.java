package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager Zi;
    private int bHL;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private WriteMultiImgsActivity nZh;
    private ImageFileInfo[] nZi;
    private a nZj;
    private b[] nZk;
    private int nZl;
    private LinkedList<ImageFileInfo> nZm = new LinkedList<>();
    private int nZn;
    private int nZo;
    private j nZp;
    private com.baidu.tbadk.core.dialog.a nZq;

    /* loaded from: classes7.dex */
    public interface a {
        void ak(int i, boolean z);

        void dVI();

        void dVK();

        boolean dVL();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.nZh = null;
        this.nZi = null;
        this.Zi = null;
        this.nZj = null;
        this.mCount = 0;
        this.bHL = 0;
        this.nZk = null;
        this.nZn = 120;
        this.nZo = 120;
        this.mIsFromIm = z;
        this.nZh = writeMultiImgsActivity;
        this.nZp = jVar;
        this.nZn = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.nZo = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bHL = b(linkedList, i);
        this.mCount = this.nZm.size();
        this.nZi = new ImageFileInfo[this.mCount];
        this.nZk = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.nZi[i2] = this.nZm.get(i2).cloneWithoutFilterAction(true);
            this.nZi[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.nZn, this.nZo));
            linkedList.set(linkedList.indexOf(this.nZm.get(i2)), this.nZi[i2]);
            this.nZi[i2].mCount = 0;
        }
        this.Zi = viewPager;
        this.nZj = aVar;
        this.Zi.setOffscreenPageLimit(1);
        this.Zi.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.nZm.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.nZm.add(next);
                }
            }
            return this.nZm.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dVE() {
        return this.bHL;
    }

    private boolean arb() {
        return (this.nZk == null || this.bHL >= this.nZk.length || this.nZk[this.bHL] == null || this.nZi == null || this.bHL >= this.nZi.length || this.nZi[this.bHL] == null) ? false : true;
    }

    public boolean dVF() {
        if (this.bHL >= this.nZi.length || this.nZi[this.bHL] == null || !this.nZi[this.bHL].isGif() || this.nZi[this.bHL].mCount > 0) {
            return false;
        }
        this.nZi[this.bHL].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dVF()) {
            if (this.nZj != null) {
                this.nZj.ak(i, z);
            }
        } else if (z) {
            Le(i);
        } else if (arb() && (bVar = this.nZk[this.bHL]) != null && (imageFileInfo = this.nZi[this.bHL]) != null && bVar.dVM()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rg(i));
            this.nZh.dXj();
            bVar.k(imageFileInfo);
        }
    }

    private void Le(int i) {
        this.nZl = i;
        if (this.nZq == null) {
            this.nZq = new com.baidu.tbadk.core.dialog.a(this.nZh);
            this.nZq.nu(R.string.rorate_tip);
            this.nZq.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nZq != null) {
                        MultiImagePagerAdapter.this.nZq.dismiss();
                    }
                    MultiImagePagerAdapter.this.nZp.ocx.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dVH() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dVI() {
                            MultiImagePagerAdapter.this.nZj.dVI();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dVJ() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.nZl, false);
                }
            });
            this.nZq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nZq != null) {
                        MultiImagePagerAdapter.this.nZq.dismiss();
                    }
                }
            });
            this.nZq.b(this.nZh.getPageContext());
        }
        this.nZq.bqe();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.nZk[i] == null) {
            this.nZk[i] = new b(i);
        }
        this.Zi.addView(this.nZk[i].getView());
        return this.nZk[i].getView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Zi.removeView(this.nZk[i].getView());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bHL = i;
        dVG();
    }

    private void dVG() {
        if (this.bHL >= 0 && this.nZk != null && this.bHL < this.nZk.length && this.bHL < this.nZi.length && this.nZi[this.bHL] != null) {
            for (int i = 0; i < this.nZk.length; i++) {
                if (this.nZk[i] != null) {
                    this.nZk[i].dNa();
                }
            }
            if (this.nZk[this.bHL] == null) {
                this.nZk[this.bHL] = new b(this.bHL);
            }
            this.nZk[this.bHL].k(this.nZi[this.bHL]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bHL;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            n.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zl(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        if (this.nZi != null) {
            for (int i = 0; i < this.nZi.length; i++) {
                ImageFileInfo imageFileInfo = this.nZi[i];
                if (imageFileInfo != null) {
                    this.nZi[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!arb()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.nZj != null && this.nZj.dVL() && this.nZp != null && this.nZp.ocx != null) {
                this.nZp.ocx.dgS();
                TbImageView tbImageView = this.nZk[this.bHL].abG;
                try {
                    bitmap = this.nZp.ocx.dXC();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.g.bZ(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = null;
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.g.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.nZi[this.bHL].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.nZi[this.bHL].setContentUriStr(null);
                        this.nZi[this.bHL].clearAllActions();
                        this.nZi[this.bHL].clearPageActions();
                        this.nZi[this.bHL].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            T(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                T(this.mBitmap);
            }
        }
    }

    private void T(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.nZi[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b {
        private TbImageView abG;
        private int index;
        private FrameLayout nZt;
        private com.baidu.tbadk.img.b nZu;
        private ProgressBar nib;

        public b(int i) {
            this.nib = null;
            this.index = -1;
            this.index = i;
            this.nZt = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.nZh.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.abG = (TbImageView) this.nZt.findViewById(R.id.progress_tb_imageview);
            this.abG.setClickable(true);
            this.abG.setDefaultResource(0);
            this.abG.setDefaultBgResource(0);
            this.abG.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.abG.setPadding(0, 0, 0, 0);
            this.nZu = new com.baidu.tbadk.img.b();
            this.abG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.nZj != null) {
                        MultiImagePagerAdapter.this.nZj.dVK();
                    }
                }
            });
            this.nib = (ProgressBar) this.nZt.findViewById(R.id.progress_tb_imageview_progress);
            this.nib.setVisibility(8);
        }

        public View getView() {
            return this.nZt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.abG != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.nZh), (l.getEquipmentHeight(MultiImagePagerAdapter.this.nZh) - l.getDimens(MultiImagePagerAdapter.this.nZh, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abG.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.abG.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.abG);
                if (MultiImagePagerAdapter.this.nZp != null && MultiImagePagerAdapter.this.nZp.ocx != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.nZp.ocx.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.nZp.ocx.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void k(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dNa();
                this.nib.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.nZu.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nib.setVisibility(8);
                    return;
                }
                this.nZu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nib.setVisibility(8);
                        if (MultiImagePagerAdapter.this.nZp != null) {
                            MultiImagePagerAdapter.this.nZp.bVw();
                        }
                    }
                }, false);
            }
        }

        public void dNa() {
            if (this.nZu != null) {
                this.nZu.cancelAllAsyncTask();
            }
            if (this.abG != null) {
            }
        }

        public boolean dVM() {
            return this.nib.getVisibility() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
