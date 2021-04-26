package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;
/* loaded from: classes5.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    public Transition<R> transition;
    public final ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    /* loaded from: classes5.dex */
    public static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        public final Animation animation;

        public ConcreteViewTransitionAnimationFactory(Animation animation) {
            this.animation = animation;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context context) {
            return this.animation;
        }
    }

    /* loaded from: classes5.dex */
    public static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        public final int animationId;

        public ResourceViewTransitionAnimationFactory(int i2) {
            this.animationId = i2;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context context) {
            return AnimationUtils.loadAnimation(context, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this(new ConcreteViewTransitionAnimationFactory(animation));
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource != DataSource.MEMORY_CACHE && z) {
            if (this.transition == null) {
                this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
            }
            return this.transition;
        }
        return NoTransition.get();
    }

    public ViewAnimationFactory(int i2) {
        this(new ResourceViewTransitionAnimationFactory(i2));
    }

    public ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }
}
