package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.common.CommonListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes9.dex */
public final class a implements TTAdManager {
    public static final a a = new a();
    public volatile TTAdManager b;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0578a<T> {
        void a(T t);
    }

    /* loaded from: classes9.dex */
    public interface b<T> {
        void a(InterfaceC0578a<T> interfaceC0578a);
    }

    /* loaded from: classes9.dex */
    public interface c<T> extends InterfaceC0578a<T> {
        void a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "4.5.2.6";
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements b<TTAdNative> {
        public TTAdNative a;
        public final /* synthetic */ WeakReference b;

        public AnonymousClass1(WeakReference weakReference) {
            this.b = weakReference;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(final InterfaceC0578a<TTAdNative> interfaceC0578a) {
            TTAdNative tTAdNative = this.a;
            if (tTAdNative != null) {
                interfaceC0578a.a(tTAdNative);
            } else {
                a.this.call(new InterfaceC0578a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                    public void a(TTAdManager tTAdManager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.a = tTAdManager.createAdNative((Context) anonymousClass1.b.get());
                        interfaceC0578a.a(AnonymousClass1.this.a);
                    }
                });
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class d implements TTAdNative {
        public b<TTAdNative> a;

        public d(b<TTAdNative> bVar) {
            this.a = bVar;
        }

        private final void a(CommonListener commonListener, InterfaceC0578a<TTAdNative> interfaceC0578a) {
            try {
                this.a.a(interfaceC0578a);
            } catch (Throwable th) {
                if (commonListener != null) {
                    commonListener.onError(4202, "Load ad failed: " + th.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerAd(final AdSlot adSlot, final TTAdNative.BannerAdListener bannerAdListener) {
            a(bannerAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerAd(adSlot, bannerAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(final AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            a(drawFeedAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadDrawFeedAd(adSlot, drawFeedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadExpressDrawFeedAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            a(feedAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadFeedAd(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(final AdSlot adSlot, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            a(fullScreenVideoAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadFullScreenVideoAd(adSlot, fullScreenVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionAd(final AdSlot adSlot, final TTAdNative.InteractionAdListener interactionAdListener) {
            a(interactionAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadInteractionAd(adSlot, interactionAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadInteractionExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(final AdSlot adSlot, final TTAdNative.NativeAdListener nativeAdListener) {
            a(nativeAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeAd(adSlot, nativeAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(final AdSlot adSlot, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            a(rewardVideoAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadRewardVideoAd(adSlot, rewardVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener) {
            a(splashAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            a(feedAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadStream(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, final int i) {
            a(splashAdListener, new InterfaceC0578a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener, i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        if (this.b != null) {
            return this.b.getPluginVersion();
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        if (this.b != null) {
            return this.b.getThemeStatus();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        return new d(new AnonymousClass1(new WeakReference(context)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        if (this.b != null) {
            return this.b.getBiddingToken(adSlot);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(final Object obj) {
        final Bundle bundle;
        if (obj instanceof TTPluginListener) {
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            bundle = e.a(TTAppContextHolder.getContext()).a(tTPluginListener.packageName(), tTPluginListener.config());
        } else {
            bundle = obj;
        }
        call(new InterfaceC0578a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.register(bundle);
                if (obj instanceof TTPluginListener) {
                    e.a(TTAppContextHolder.getContext()).a((TTPluginListener) obj);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(final Context context) {
        call(new InterfaceC0578a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.requestPermissionIfNecessary(context);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(final int i) {
        call(new InterfaceC0578a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
            public void a(TTAdManager tTAdManager) {
                a.this.b.setThemeStatus(i);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(final Object obj) {
        call(new InterfaceC0578a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.unregister(obj);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
        if (this.b != null) {
            return (T) this.b.getExtra(cls, bundle);
        }
        if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
            call(new c<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                public void a() {
                    com.bytedance.sdk.openadsdk.api.plugin.d.a(bundle);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
                public void a(TTAdManager tTAdManager) {
                    tTAdManager.getExtra(cls, bundle);
                }
            });
            return null;
        }
        call(new InterfaceC0578a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0578a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.getExtra(cls, bundle);
            }
        });
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        if (this.b != null && this.b.tryShowInstallDialogWhenExit(activity, exitInstallListener)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void call(final InterfaceC0578a<TTAdManager> interfaceC0578a) {
        if (this.b != null) {
            try {
                interfaceC0578a.a(this.b);
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.a.d("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                e.a(th);
                return;
            }
        }
        ScheduledExecutorService scheduledExecutorService = f.a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (a.this.b != null) {
                            interfaceC0578a.a(a.this.b);
                            return;
                        }
                        if (interfaceC0578a instanceof c) {
                            ((c) interfaceC0578a).a();
                        }
                        com.bytedance.sdk.openadsdk.api.a.d("PluginDefaultAdManager", "Not ready, no manager");
                    } catch (Throwable th2) {
                        com.bytedance.sdk.openadsdk.api.a.d("PluginDefaultAdManager", "Unexpected manager call error: " + th2.getMessage());
                        e.a(th2);
                    }
                }
            });
        } else {
            com.bytedance.sdk.openadsdk.api.a.d("PluginDefaultAdManager", "Not ready, no executor");
        }
    }

    public void a(TTAdManager tTAdManager) {
        this.b = tTAdManager;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
        if (this.b != null) {
            return this.b.getBiddingToken(adSlot, z, i);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (this.b != null) {
            return this.b.onlyVerityPlayable(str, i, str2, str3, str4);
        }
        return false;
    }
}
