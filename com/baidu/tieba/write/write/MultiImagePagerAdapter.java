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
/* loaded from: classes8.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager Zk;
    private int bMx;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private WriteMultiImgsActivity odN;
    private ImageFileInfo[] odO;
    private a odP;
    private b[] odQ;
    private int odR;
    private LinkedList<ImageFileInfo> odS = new LinkedList<>();
    private int odT;
    private int odU;
    private j odV;
    private com.baidu.tbadk.core.dialog.a odW;

    /* loaded from: classes8.dex */
    public interface a {
        void ak(int i, boolean z);

        void dZA();

        void dZC();

        boolean dZD();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.odN = null;
        this.odO = null;
        this.Zk = null;
        this.odP = null;
        this.mCount = 0;
        this.bMx = 0;
        this.odQ = null;
        this.odT = 120;
        this.odU = 120;
        this.mIsFromIm = z;
        this.odN = writeMultiImgsActivity;
        this.odV = jVar;
        this.odT = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.odU = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bMx = b(linkedList, i);
        this.mCount = this.odS.size();
        this.odO = new ImageFileInfo[this.mCount];
        this.odQ = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.odO[i2] = this.odS.get(i2).cloneWithoutFilterAction(true);
            this.odO[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.odT, this.odU));
            linkedList.set(linkedList.indexOf(this.odS.get(i2)), this.odO[i2]);
            this.odO[i2].mCount = 0;
        }
        this.Zk = viewPager;
        this.odP = aVar;
        this.Zk.setOffscreenPageLimit(1);
        this.Zk.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.odS.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.odS.add(next);
                }
            }
            return this.odS.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dZw() {
        return this.bMx;
    }

    private boolean auW() {
        return (this.odQ == null || this.bMx >= this.odQ.length || this.odQ[this.bMx] == null || this.odO == null || this.bMx >= this.odO.length || this.odO[this.bMx] == null) ? false : true;
    }

    public boolean dZx() {
        if (this.bMx >= this.odO.length || this.odO[this.bMx] == null || !this.odO[this.bMx].isGif() || this.odO[this.bMx].mCount > 0) {
            return false;
        }
        this.odO[this.bMx].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dZx()) {
            if (this.odP != null) {
                this.odP.ak(i, z);
            }
        } else if (z) {
            ML(i);
        } else if (auW() && (bVar = this.odQ[this.bMx]) != null && (imageFileInfo = this.odO[this.bMx]) != null && bVar.dZE()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.sM(i));
            this.odN.ebb();
            bVar.k(imageFileInfo);
        }
    }

    private void ML(int i) {
        this.odR = i;
        if (this.odW == null) {
            this.odW = new com.baidu.tbadk.core.dialog.a(this.odN);
            this.odW.pa(R.string.rorate_tip);
            this.odW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.odW != null) {
                        MultiImagePagerAdapter.this.odW.dismiss();
                    }
                    MultiImagePagerAdapter.this.odV.ohc.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dZz() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dZA() {
                            MultiImagePagerAdapter.this.odP.dZA();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dZB() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.odR, false);
                }
            });
            this.odW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.odW != null) {
                        MultiImagePagerAdapter.this.odW.dismiss();
                    }
                }
            });
            this.odW.b(this.odN.getPageContext());
        }
        this.odW.btY();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.odQ[i] == null) {
            this.odQ[i] = new b(i);
        }
        this.Zk.addView(this.odQ[i].getView());
        return this.odQ[i].getView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Zk.removeView(this.odQ[i].getView());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bMx = i;
        dZy();
    }

    private void dZy() {
        if (this.bMx >= 0 && this.odQ != null && this.bMx < this.odQ.length && this.bMx < this.odO.length && this.odO[this.bMx] != null) {
            for (int i = 0; i < this.odQ.length; i++) {
                if (this.odQ[i] != null) {
                    this.odQ[i].dQS();
                }
            }
            if (this.odQ[this.bMx] == null) {
                this.odQ[this.bMx] = new b(this.bMx);
            }
            this.odQ[this.bMx].k(this.odO[this.bMx]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bMx;
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
    public void zp(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        if (this.odO != null) {
            for (int i = 0; i < this.odO.length; i++) {
                ImageFileInfo imageFileInfo = this.odO[i];
                if (imageFileInfo != null) {
                    this.odO[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!auW()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.odP != null && this.odP.dZD() && this.odV != null && this.odV.ohc != null) {
                this.odV.ohc.dkK();
                TbImageView tbImageView = this.odQ[this.bMx].abI;
                try {
                    bitmap = this.odV.ohc.ebu();
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
                        this.odO[this.bMx].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.odO[this.bMx].setContentUriStr(null);
                        this.odO[this.bMx].clearAllActions();
                        this.odO[this.bMx].clearPageActions();
                        this.odO[this.bMx].setIsGif(false);
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
                this.odO[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b {
        private TbImageView abI;
        private int index;
        private ProgressBar nmG;
        private FrameLayout odZ;
        private com.baidu.tbadk.img.b oea;

        public b(int i) {
            this.nmG = null;
            this.index = -1;
            this.index = i;
            this.odZ = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.odN.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.abI = (TbImageView) this.odZ.findViewById(R.id.progress_tb_imageview);
            this.abI.setClickable(true);
            this.abI.setDefaultResource(0);
            this.abI.setDefaultBgResource(0);
            this.abI.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.abI.setPadding(0, 0, 0, 0);
            this.oea = new com.baidu.tbadk.img.b();
            this.abI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.odP != null) {
                        MultiImagePagerAdapter.this.odP.dZC();
                    }
                }
            });
            this.nmG = (ProgressBar) this.odZ.findViewById(R.id.progress_tb_imageview_progress);
            this.nmG.setVisibility(8);
        }

        public View getView() {
            return this.odZ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.abI != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.odN), (l.getEquipmentHeight(MultiImagePagerAdapter.this.odN) - l.getDimens(MultiImagePagerAdapter.this.odN, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abI.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.abI.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.abI);
                if (MultiImagePagerAdapter.this.odV != null && MultiImagePagerAdapter.this.odV.ohc != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.odV.ohc.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.odV.ohc.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void k(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dQS();
                this.nmG.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.oea.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nmG.setVisibility(8);
                    return;
                }
                this.oea.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nmG.setVisibility(8);
                        if (MultiImagePagerAdapter.this.odV != null) {
                            MultiImagePagerAdapter.this.odV.bZo();
                        }
                    }
                }, false);
            }
        }

        public void dQS() {
            if (this.oea != null) {
                this.oea.cancelAllAsyncTask();
            }
            if (this.abI != null) {
            }
        }

        public boolean dZE() {
            return this.nmG.getVisibility() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
