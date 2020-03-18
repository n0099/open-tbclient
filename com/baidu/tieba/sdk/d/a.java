package com.baidu.tieba.sdk.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BDLayoutInflateFactory;
import com.baidu.live.tbadk.core.BDLayoutMode;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tieba.ala.player.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements TbPageContext<T> {
    private List<WeakReference<View>> animationList;
    private MAActivity jRL;
    private com.baidu.tieba.ala.player.a jRM;
    private List<Animatable> jRN;
    private BdUniqueId mId = null;
    private BDLayoutInflateFactory mLayoutInflateFactory;
    private BDLayoutMode mLayoutMode;

    public a(MAActivity mAActivity) {
        this.jRL = mAActivity;
    }

    public void a(c cVar) {
        if (this.mId == null) {
            this.mId = BdUniqueId.gen();
        }
        this.mLayoutMode = new BDLayoutMode();
        this.mLayoutInflateFactory = new BDLayoutInflateFactory();
        this.mLayoutInflateFactory.setViewMode(this.mLayoutMode);
        this.jRL.getActivity().getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        this.jRM = new com.baidu.tieba.ala.player.a(this, cVar);
        this.jRM.init();
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i) {
        BdUtilHelper.showToast(this.jRL.getActivity(), this.jRL.getActivity().getResources().getString(i));
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        BdUtilHelper.showToast(this.jRL.getActivity(), str);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str) {
        BdUtilHelper.showToast(this.jRL.getActivity(), str);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        BdUtilHelper.showToast(this.jRL.getActivity(), i);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public BDLayoutMode getLayoutMode() {
        return this.mLayoutMode;
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        if (animatable != null && this.jRL != null && !this.jRL.getActivity().isFinishing()) {
            if (this.jRN == null) {
                this.jRN = new ArrayList();
            }
            synchronized (this.jRN) {
                this.jRN.add(animatable);
            }
            try {
                animatable.start();
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, final Animation.AnimationListener animationListener) {
        if (animation != null && this.jRL != null && !this.jRL.getActivity().isFinishing()) {
            final WeakReference<View> weakReference = new WeakReference<>(view);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.sdk.d.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    if (animationListener != null) {
                        animationListener.onAnimationStart(animation2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                    if (animationListener != null) {
                        animationListener.onAnimationRepeat(animation2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(animation2);
                    }
                    synchronized (a.this.animationList) {
                        a.this.animationList.remove(weakReference);
                    }
                }
            });
            if (this.animationList == null) {
                this.animationList = new ArrayList();
            }
            synchronized (this.animationList) {
                this.animationList.add(weakReference);
            }
            try {
                view.startAnimation(animation);
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Resources getResources() {
        return this.jRL.getActivity().getResources();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void sendMessage(Message<?> message) {
        if (message != null) {
            if (message.getTag() == null) {
                message.setTag(this.mId);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void sendMessage(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == null) {
                netMessage.setTag(this.mId);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(NetMessageListener netMessageListener) {
        if (netMessageListener != null && netMessageListener.getTag() == null) {
            netMessageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(netMessageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(int i, NetMessageListener netMessageListener) {
        if (netMessageListener != null && netMessageListener.getTag() == null) {
            netMessageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, netMessageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(int i, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public String getString(int i) {
        return this.jRL.getActivity().getResources().getString(i);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Context getContext() {
        return this.jRL.getActivity();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Activity getPageActivity() {
        if (this.jRL == null) {
            return null;
        }
        return this.jRL.getActivity();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public T getOrignalPage() {
        return (T) this.jRL;
    }

    public void clearAnimation() {
        View view;
        if (this.animationList != null) {
            synchronized (this.animationList) {
                for (int i = 0; i < this.animationList.size(); i++) {
                    WeakReference<View> weakReference = this.animationList.get(i);
                    if (weakReference != null && (view = weakReference.get()) != null) {
                        view.clearAnimation();
                    }
                }
                this.animationList.clear();
            }
        }
    }

    public void clearAnimatable() {
        if (this.jRN != null) {
            try {
                synchronized (this.jRN) {
                    for (int i = 0; i < this.jRN.size(); i++) {
                        Animatable animatable = this.jRN.get(i);
                        if (animatable != null && animatable.isRunning()) {
                            animatable.stop();
                        }
                        this.jRN.clear();
                    }
                }
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    public void onStart() {
        this.jRM.onStart();
    }

    public void onResume() {
        this.jRM.onResume();
    }

    public void onPause() {
        this.jRM.onPause();
    }

    public void onStop() {
        this.jRM.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        this.jRM.onWindowFocusChanged(z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.jRM.onKeyDown(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.jRM.onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jRM.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        clearAnimatable();
        clearAnimation();
        this.jRM.onDestroy();
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        this.jRL = null;
    }
}
