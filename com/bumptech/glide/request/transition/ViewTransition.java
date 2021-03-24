package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes5.dex */
public class ViewTransition<R> implements Transition<R> {
    public final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    /* loaded from: classes5.dex */
    public interface ViewTransitionAnimationFactory {
        Animation build(Context context);
    }

    public ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.viewTransitionAnimationFactory.build(view.getContext()));
            return false;
        }
        return false;
    }
}
