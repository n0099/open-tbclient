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
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public final class a implements TTAdManager {
    public static final a a = new a();

    /* renamed from: b  reason: collision with root package name */
    public volatile TTAdManager f53230b;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements b<TTAdNative> {
        public TTAdNative a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f53231b;

        public AnonymousClass1(Context context) {
            this.f53231b = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(final InterfaceC2051a<TTAdNative> interfaceC2051a) {
            TTAdNative tTAdNative = this.a;
            if (tTAdNative != null) {
                interfaceC2051a.a(tTAdNative);
            } else {
                a.this.call(new InterfaceC2051a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                    public void a(TTAdManager tTAdManager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.a = tTAdManager.createAdNative(anonymousClass1.f53231b);
                        interfaceC2051a.a(AnonymousClass1.this.a);
                    }
                });
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2051a<T> {
        void a(T t);
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        void a(InterfaceC2051a<T> interfaceC2051a);
    }

    /* loaded from: classes2.dex */
    public interface c<T> extends InterfaceC2051a<T> {
        void a();
    }

    /* loaded from: classes2.dex */
    public static final class d implements TTAdNative {
        public b<TTAdNative> a;

        public d(b<TTAdNative> bVar) {
            this.a = bVar;
        }

        private final void a(CommonListener commonListener, InterfaceC2051a<TTAdNative> interfaceC2051a) {
            try {
                this.a.a(interfaceC2051a);
            } catch (Throwable th) {
                if (commonListener != null) {
                    commonListener.onError(4202, "Load ad failed: " + th.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerAd(final AdSlot adSlot, final TTAdNative.BannerAdListener bannerAdListener) {
            a(bannerAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerAd(adSlot, bannerAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(final AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            a(drawFeedAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadDrawFeedAd(adSlot, drawFeedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadExpressDrawFeedAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            a(feedAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadFeedAd(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(final AdSlot adSlot, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            a(fullScreenVideoAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadFullScreenVideoAd(adSlot, fullScreenVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionAd(final AdSlot adSlot, final TTAdNative.InteractionAdListener interactionAdListener) {
            a(interactionAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadInteractionAd(adSlot, interactionAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadInteractionExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(final AdSlot adSlot, final TTAdNative.NativeAdListener nativeAdListener) {
            a(nativeAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeAd(adSlot, nativeAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(final AdSlot adSlot, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            a(rewardVideoAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadRewardVideoAd(adSlot, rewardVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, final int i2) {
            a(splashAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener, i2);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            a(feedAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadStream(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener) {
            a(splashAdListener, new InterfaceC2051a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void call(final InterfaceC2051a<TTAdManager> interfaceC2051a) {
        if (this.f53230b != null) {
            try {
                interfaceC2051a.a(this.f53230b);
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                return;
            }
        }
        ScheduledExecutorService scheduledExecutorService = g.a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (a.this.f53230b != null) {
                            interfaceC2051a.a(a.this.f53230b);
                            return;
                        }
                        if (interfaceC2051a instanceof c) {
                            ((c) interfaceC2051a).a();
                        }
                        com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Not ready, no manager");
                    } catch (Throwable th2) {
                        com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th2.getMessage());
                    }
                }
            });
        } else {
            com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Not ready, no executor");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        return new d(new AnonymousClass1(context));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        if (this.f53230b != null) {
            return this.f53230b.getBiddingToken(adSlot);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
        if (this.f53230b != null) {
            return (T) this.f53230b.getExtra(cls, bundle);
        }
        if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
            call(new c<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                public void a() {
                    e.a(bundle);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
                public void a(TTAdManager tTAdManager) {
                    tTAdManager.getExtra(cls, bundle);
                }
            });
            return null;
        }
        call(new InterfaceC2051a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.getExtra(cls, bundle);
            }
        });
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        return this.f53230b != null ? this.f53230b.getPluginVersion() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "4.0.2.2";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        if (this.f53230b != null) {
            return this.f53230b.getThemeStatus();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4) {
        if (this.f53230b != null) {
            return this.f53230b.onlyVerityPlayable(str, i2, str2, str3, str4);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(final Object obj) {
        final Bundle bundle;
        if (obj instanceof TTPluginListener) {
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            bundle = f.a(TTAppContextHolder.getContext()).a(tTPluginListener.packageName(), tTPluginListener.config());
        } else {
            bundle = obj;
        }
        call(new InterfaceC2051a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
            public void a(TTAdManager tTAdManager) {
                if (obj instanceof TTPluginListener) {
                    f.a(TTAppContextHolder.getContext()).a((TTPluginListener) obj);
                }
                tTAdManager.register(bundle);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(final Context context) {
        call(new InterfaceC2051a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.requestPermissionIfNecessary(context);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(final int i2) {
        call(new InterfaceC2051a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
            public void a(TTAdManager tTAdManager) {
                a.this.f53230b.setThemeStatus(i2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        return this.f53230b != null && this.f53230b.tryShowInstallDialogWhenExit(activity, exitInstallListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(final Object obj) {
        call(new InterfaceC2051a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2051a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.unregister(obj);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
        if (this.f53230b != null) {
            return this.f53230b.getBiddingToken(adSlot, z, i2);
        }
        return null;
    }

    public void a(TTAdManager tTAdManager) {
        this.f53230b = tTAdManager;
    }
}
