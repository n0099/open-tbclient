package com.baidu.tieba.sdk.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BDLayoutInflateFactory;
import com.baidu.live.tbadk.core.BDLayoutMode;
import com.baidu.searchbox.live.base.LiveBaseActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d<T> implements TbPageContext<T> {
    private List<WeakReference<View>> animationList;
    private LiveBaseActivity mEo;
    private List<Animatable> mEq;
    private com.baidu.live.c.b mEs;
    private BdUniqueId mId = null;
    private BDLayoutInflateFactory mLayoutInflateFactory;
    private BDLayoutMode mLayoutMode;

    public d(LiveBaseActivity liveBaseActivity) {
        this.mEo = liveBaseActivity;
    }

    public void a(com.baidu.live.c.a aVar) {
        if (this.mId == null) {
            this.mId = BdUniqueId.gen();
        }
        this.mLayoutMode = new BDLayoutMode();
        this.mLayoutInflateFactory = new BDLayoutInflateFactory();
        this.mLayoutInflateFactory.setViewMode(this.mLayoutMode);
        this.mEo.getActivity().getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        CustomResponsedMessage<T> runTask = MessageManager.getInstance().runTask(2501056, com.baidu.live.c.b.class);
        if (runTask != null) {
            this.mEs = (com.baidu.live.c.b) runTask.getData();
            this.mEs.a(this, aVar);
        }
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i) {
        BdUtilHelper.showToast(this.mEo.getActivity(), this.mEo.getActivity().getResources().getString(i));
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        BdUtilHelper.showToast(this.mEo.getActivity(), str);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str) {
        BdUtilHelper.showToast(this.mEo.getActivity(), str);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        BdUtilHelper.showToast(this.mEo.getActivity(), i);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public BDLayoutMode getLayoutMode() {
        return this.mLayoutMode;
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        if (animatable != null && this.mEo != null && !this.mEo.getActivity().isFinishing()) {
            if (this.mEq == null) {
                this.mEq = new ArrayList();
            }
            synchronized (this.mEq) {
                this.mEq.add(animatable);
            }
            try {
                animatable.start();
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, final Animation.AnimationListener animationListener) {
        if (animation != null && this.mEo != null && !this.mEo.getActivity().isFinishing()) {
            final WeakReference<View> weakReference = new WeakReference<>(view);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.sdk.e.d.1
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
                    synchronized (d.this.animationList) {
                        d.this.animationList.remove(weakReference);
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
        return this.mEo.getActivity().getResources();
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
        return this.mEo.getActivity().getResources().getString(i);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Context getContext() {
        if (this.mEo == null) {
            return null;
        }
        return this.mEo.getActivity();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Activity getPageActivity() {
        if (this.mEo == null) {
            return null;
        }
        return this.mEo.getActivity();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public T getOrignalPage() {
        return (T) this.mEo;
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
        if (this.mEq != null) {
            try {
                synchronized (this.mEq) {
                    for (int i = 0; i < this.mEq.size(); i++) {
                        Animatable animatable = this.mEq.get(i);
                        if (animatable != null && animatable.isRunning()) {
                            animatable.stop();
                        }
                        this.mEq.clear();
                    }
                }
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    public void onStart() {
        if (this.mEs != null) {
            this.mEs.onStart();
        }
    }

    public void onResume() {
        if (this.mEs != null) {
            this.mEs.onResume();
        }
    }

    public void onPause() {
        if (this.mEs != null) {
            this.mEs.onPause();
        }
    }

    public void onStop() {
        if (this.mEs != null) {
            this.mEs.onStop();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.mEs != null) {
            this.mEs.onWindowFocusChanged(z);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mEs == null) {
            return false;
        }
        return this.mEs.onKeyDown(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mEs != null) {
            this.mEs.onActivityResult(i, i2, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mEs != null) {
            this.mEs.onConfigurationChanged(configuration);
        }
    }

    public void onDestroy() {
        clearAnimatable();
        clearAnimation();
        if (this.mEs != null) {
            this.mEs.onDestroy();
        }
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        this.mEo = null;
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mEs != null) {
            this.mEs.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
