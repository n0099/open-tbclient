package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.lottie.e;
import com.baidu.live.lottie.i;
import com.baidu.live.lottie.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.utils.u;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import com.yy.videoplayer.decoder.VideoConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    private static int oLb = VideoConstant.THUMBNAIL_WIDTH;
    private static b oLc;
    private HandlerThread bfv = new HandlerThread("read_image_thread");
    private Handler mHandler;

    public static b eeB() {
        if (oLc == null) {
            synchronized (b.class) {
                if (oLc == null) {
                    oLc = new b();
                }
            }
        }
        return oLc;
    }

    private b() {
        this.bfv.start();
        this.mHandler = new Handler(this.bfv.getLooper());
    }

    public void a(ViewGroup viewGroup, String str, c cVar) {
        if (viewGroup != null && viewGroup.getContext() != null && !StringUtils.isNull(str)) {
            String it = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.it(com.baidu.live.storage.b.hM(str));
            if (com.baidu.live.h.a.isDirectory(it)) {
                a(viewGroup, it, it + "/video.mp4", null, null, cVar);
            }
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, String str3, c cVar) {
        if (viewGroup != null && viewGroup.getContext() != null && !StringUtils.isNull(str)) {
            String it = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.it(com.baidu.live.storage.b.hM(str));
            if (com.baidu.live.h.a.isDirectory(it)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("image_3", str3);
                hashMap.put("image_7", str2);
                a(viewGroup, it, it + "/video.mp4", it + "/data.json", hashMap, cVar);
            }
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2, String str3, c cVar) {
        if (viewGroup != null && viewGroup.getContext() != null && !StringUtils.isNull(str)) {
            String it = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.it(com.baidu.live.storage.b.hM(str));
            if (com.baidu.live.h.a.isDirectory(it)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("image_25", str3);
                hashMap.put("image_26", str2);
                a(viewGroup, it, it + "/video.mp4", it + "/data.json", hashMap, cVar);
            }
        }
    }

    public void c(ViewGroup viewGroup, String str, String str2, String str3, c cVar) {
        if (viewGroup != null && viewGroup.getContext() != null && !StringUtils.isNull(str)) {
            String it = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.it(com.baidu.live.storage.b.hM(str));
            if (com.baidu.live.h.a.isDirectory(it)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("image_25", str3);
                hashMap.put("image_26", str2);
                a(viewGroup, it, null, it + "/data.json", hashMap, cVar);
            }
        }
    }

    private void a(ViewGroup viewGroup, String str, String str2, String str3, HashMap<String, String> hashMap, c cVar) {
        a.eew().di(viewGroup);
        a.eew().dh(viewGroup);
        if (viewGroup != null && viewGroup.getContext() != null) {
            AlaAudioVideoLayout a2 = a(viewGroup.getContext(), str2, cVar);
            if (a2 != null) {
                a2.setId(a.f.ala_audio_dating_video_view);
                int i = 0;
                if ((viewGroup instanceof AlaLiveView) && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    i = -((ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()).topMargin;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
                marginLayoutParams.topMargin = i;
                u.a(viewGroup, a2, marginLayoutParams, 450);
            }
            LottieAnimationView b = b(viewGroup.getContext(), str3, cVar);
            if (b != null) {
                b.setId(a.f.ala_audio_dating_lottie_view);
                viewGroup.addView(b);
            }
            a(str, a2, b, hashMap);
        }
    }

    private AlaAudioVideoLayout a(Context context, String str, final c cVar) {
        if (context != null && com.baidu.live.h.a.existFile(str)) {
            if (com.baidu.live.h.a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return null;
            }
            final AlaAudioVideoLayout alaAudioVideoLayout = new AlaAudioVideoLayout(context);
            alaAudioVideoLayout.setData(str);
            alaAudioVideoLayout.setVideoCallback(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.d
                public void ES(String str2) {
                    if (cVar != null) {
                        cVar.onVideoPlayStart();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.d
                public void WP(String str2) {
                    if (alaAudioVideoLayout != null && (alaAudioVideoLayout.getParent() instanceof ViewGroup)) {
                        a.eew().di((ViewGroup) alaAudioVideoLayout.getParent());
                    }
                    if (cVar != null) {
                        cVar.onVideoPlayEnd();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.d
                public void onFail(String str2) {
                    if (cVar != null) {
                        cVar.eeC();
                    }
                }
            });
            return alaAudioVideoLayout;
        }
        return null;
    }

    private LottieAnimationView b(Context context, String str, final c cVar) {
        FileInputStream fileInputStream;
        if (context != null && com.baidu.live.h.a.existFile(str)) {
            if (com.baidu.live.h.a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return null;
            }
            final TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
            tBLottieAnimationView.setRepeatCount(0);
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileInputStream = null;
            }
            if (fileInputStream != null) {
                e.a.a(fileInputStream, new o() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.b.2
                    @Override // com.baidu.live.lottie.o
                    public void c(@Nullable e eVar) {
                        tBLottieAnimationView.setComposition(eVar);
                    }
                });
                tBLottieAnimationView.setVisibility(8);
                tBLottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.b.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        super.onAnimationCancel(animator);
                        if (cVar != null) {
                            cVar.eeE();
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (tBLottieAnimationView != null && (tBLottieAnimationView.getParent() instanceof ViewGroup)) {
                            a.eew().dh((ViewGroup) tBLottieAnimationView.getParent());
                            if (cVar != null) {
                                cVar.eeD();
                            }
                        }
                    }
                });
                return tBLottieAnimationView;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final AlaAudioVideoLayout alaAudioVideoLayout, final LottieAnimationView lottieAnimationView, final HashMap<String, String> hashMap) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(str, alaAudioVideoLayout, lottieAnimationView, (HashMap<String, String>) hashMap);
                }
            });
        } else if (ListUtils.isEmpty(hashMap)) {
            a(str, alaAudioVideoLayout, lottieAnimationView, (AbstractMap<String, Bitmap>) null);
        } else {
            final HashMap hashMap2 = new HashMap();
            for (final Map.Entry<String, String> entry : hashMap.entrySet()) {
                final String urlWithResizeTag = TbImageView.getUrlWithResizeTag(entry.getValue(), oLb, oLb);
                BdResourceLoader.getInstance().loadResource(urlWithResizeTag, 25, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.b.5
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass5) bdImage, str2, i);
                        if (bdImage != null && bdImage.getRawBitmap() != null && str2 != null && str2.equals(urlWithResizeTag)) {
                            hashMap2.put(entry.getKey(), bdImage.getRawBitmap());
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onCancelled(String str2) {
                        super.onCancelled(str2);
                    }
                }, null);
            }
            do {
            } while (hashMap2.size() != hashMap.size());
            a(str, alaAudioVideoLayout, lottieAnimationView, (AbstractMap<String, Bitmap>) hashMap2);
        }
    }

    private void a(final String str, final AlaAudioVideoLayout alaAudioVideoLayout, final LottieAnimationView lottieAnimationView, final AbstractMap<String, Bitmap> abstractMap) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.b.6
            @Override // java.lang.Runnable
            public void run() {
                if (lottieAnimationView != null) {
                    lottieAnimationView.setImageAssetDelegate(new com.baidu.live.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.b.6.1
                        @Override // com.baidu.live.lottie.c
                        public Bitmap fetchBitmap(i iVar) {
                            if (iVar == null) {
                                return null;
                            }
                            if (!ListUtils.isEmpty(abstractMap) && abstractMap.containsKey(iVar.getId())) {
                                return b.this.a((Bitmap) abstractMap.get(iVar.getId()), iVar);
                            }
                            return BitmapFactory.decodeFile(str + "/" + iVar.ik().replace("/", "") + "/" + iVar.getFileName());
                        }
                    });
                    lottieAnimationView.setVisibility(0);
                    lottieAnimationView.setFrame(0);
                    lottieAnimationView.playAnimation();
                }
                if (alaAudioVideoLayout != null) {
                    alaAudioVideoLayout.startAnim();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(Bitmap bitmap, i iVar) {
        Bitmap bitmapCenterCrop;
        if (iVar == null || (bitmapCenterCrop = BitmapHelper.getBitmapCenterCrop(bitmap, iVar.getWidth(), iVar.getHeight(), false)) == null) {
            return null;
        }
        return BitmapHelper.getRoundedCornerBitmap(bitmapCenterCrop, bitmapCenterCrop.getWidth() / 2, true);
    }
}
