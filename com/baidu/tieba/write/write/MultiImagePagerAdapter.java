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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager Ze;
    private int bLv;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private WriteMultiImgsActivity ojC;
    private ImageFileInfo[] ojD;
    private a ojE;
    private b[] ojF;
    private int ojG;
    private LinkedList<ImageFileInfo> ojH = new LinkedList<>();
    private int ojI;
    private int ojJ;
    private j ojK;
    private com.baidu.tbadk.core.dialog.a ojL;

    /* loaded from: classes8.dex */
    public interface a {
        void ak(int i, boolean z);

        void dYb();

        void dYd();

        boolean dYe();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.ojC = null;
        this.ojD = null;
        this.Ze = null;
        this.ojE = null;
        this.mCount = 0;
        this.bLv = 0;
        this.ojF = null;
        this.ojI = 120;
        this.ojJ = 120;
        this.mIsFromIm = z;
        this.ojC = writeMultiImgsActivity;
        this.ojK = jVar;
        this.ojI = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.ojJ = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bLv = b(linkedList, i);
        this.mCount = this.ojH.size();
        this.ojD = new ImageFileInfo[this.mCount];
        this.ojF = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.ojD[i2] = this.ojH.get(i2).cloneWithoutFilterAction(true);
            this.ojD[i2].addPageAction(com.baidu.tbadk.img.effect.d.bd(this.ojI, this.ojJ));
            linkedList.set(linkedList.indexOf(this.ojH.get(i2)), this.ojD[i2]);
            this.ojD[i2].mCount = 0;
        }
        this.Ze = viewPager;
        this.ojE = aVar;
        this.Ze.setOffscreenPageLimit(1);
        this.Ze.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.ojH.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.ojH.add(next);
                }
            }
            return this.ojH.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dXX() {
        return this.bLv;
    }

    private boolean arz() {
        return (this.ojF == null || this.bLv >= this.ojF.length || this.ojF[this.bLv] == null || this.ojD == null || this.bLv >= this.ojD.length || this.ojD[this.bLv] == null) ? false : true;
    }

    public boolean dXY() {
        if (this.bLv >= this.ojD.length || this.ojD[this.bLv] == null || !this.ojD[this.bLv].isGif() || this.ojD[this.bLv].mCount > 0) {
            return false;
        }
        this.ojD[this.bLv].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dXY()) {
            if (this.ojE != null) {
                this.ojE.ak(i, z);
            }
        } else if (z) {
            Lz(i);
        } else if (arz() && (bVar = this.ojF[this.bLv]) != null && (imageFileInfo = this.ojD[this.bLv]) != null && bVar.dYf()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rl(i));
            this.ojC.dZC();
            bVar.k(imageFileInfo);
        }
    }

    private void Lz(int i) {
        this.ojG = i;
        if (this.ojL == null) {
            this.ojL = new com.baidu.tbadk.core.dialog.a(this.ojC);
            this.ojL.nx(R.string.rorate_tip);
            this.ojL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ojL != null) {
                        MultiImagePagerAdapter.this.ojL.dismiss();
                    }
                    MultiImagePagerAdapter.this.ojK.omP.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dYa() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dYb() {
                            MultiImagePagerAdapter.this.ojE.dYb();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean T(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dYc() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.ojG, false);
                }
            });
            this.ojL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ojL != null) {
                        MultiImagePagerAdapter.this.ojL.dismiss();
                    }
                }
            });
            this.ojL.b(this.ojC.getPageContext());
        }
        this.ojL.bqx();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ojF[i] == null) {
            this.ojF[i] = new b(i);
        }
        this.Ze.addView(this.ojF[i].getView());
        return this.ojF[i].getView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Ze.removeView(this.ojF[i].getView());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bLv = i;
        dXZ();
    }

    private void dXZ() {
        if (this.bLv >= 0 && this.ojF != null && this.bLv < this.ojF.length && this.bLv < this.ojD.length && this.ojD[this.bLv] != null) {
            for (int i = 0; i < this.ojF.length; i++) {
                if (this.ojF[i] != null) {
                    this.ojF[i].dPt();
                }
            }
            if (this.ojF[this.bLv] == null) {
                this.ojF[this.bLv] = new b(this.bLv);
            }
            this.ojF[this.bLv].k(this.ojD[this.bLv]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bLv;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            o.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (o.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void zG(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        if (this.ojD != null) {
            for (int i = 0; i < this.ojD.length; i++) {
                ImageFileInfo imageFileInfo = this.ojD[i];
                if (imageFileInfo != null) {
                    this.ojD[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!arz()) {
                if (!z && this.mIsFromIm) {
                    S(this.mBitmap);
                }
            } else if (this.ojE != null && this.ojE.dYe() && this.ojK != null && this.ojK.omP != null) {
                this.ojK.omP.dja();
                TbImageView tbImageView = this.ojF[this.bLv].abB;
                try {
                    bitmap = this.ojK.omP.dZV();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.h.bV(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = null;
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.h.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.ojD[this.bLv].setFilePath(o.saveFileAsPNG(o.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.ojD[this.bLv].setContentUriStr(null);
                        this.ojD[this.bLv].clearAllActions();
                        this.ojD[this.bLv].clearPageActions();
                        this.ojD[this.bLv].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            S(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                S(this.mBitmap);
            }
        }
    }

    private void S(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.ojD[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b {
        private TbImageView abB;
        private int index;
        private ProgressBar nsk;
        private FrameLayout ojO;
        private com.baidu.tbadk.img.b ojP;

        public b(int i) {
            this.nsk = null;
            this.index = -1;
            this.index = i;
            this.ojO = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.ojC.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.abB = (TbImageView) this.ojO.findViewById(R.id.progress_tb_imageview);
            this.abB.setClickable(true);
            this.abB.setDefaultResource(0);
            this.abB.setDefaultBgResource(0);
            this.abB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.abB.setPadding(0, 0, 0, 0);
            this.ojP = new com.baidu.tbadk.img.b();
            this.abB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.ojE != null) {
                        MultiImagePagerAdapter.this.ojE.dYd();
                    }
                }
            });
            this.nsk = (ProgressBar) this.ojO.findViewById(R.id.progress_tb_imageview_progress);
            this.nsk.setVisibility(8);
        }

        public View getView() {
            return this.ojO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.abB != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.ojC), (l.getEquipmentHeight(MultiImagePagerAdapter.this.ojC) - l.getDimens(MultiImagePagerAdapter.this.ojC, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abB.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.abB.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.abB);
                if (MultiImagePagerAdapter.this.ojK != null && MultiImagePagerAdapter.this.ojK.omP != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.ojK.omP.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.ojK.omP.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void k(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dPt();
                this.nsk.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.ojP.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nsk.setVisibility(8);
                    return;
                }
                this.ojP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nsk.setVisibility(8);
                        if (MultiImagePagerAdapter.this.ojK != null) {
                            MultiImagePagerAdapter.this.ojK.bWh();
                        }
                    }
                }, false);
            }
        }

        public void dPt() {
            if (this.ojP != null) {
                this.ojP.cancelAllAsyncTask();
            }
            if (this.abB != null) {
            }
        }

        public boolean dYf() {
            return this.nsk.getVisibility() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
