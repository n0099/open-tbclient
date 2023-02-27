package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes7.dex */
public class ViewTransition<R> implements Transition<R> {
    public final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    /* loaded from: classes7.dex */
    public interface ViewTransitionAnimationFactory {
        Animation build(Context context);
    }

    public ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        View view2 = viewAdapter.getView();
        if (view2 != null) {
            view2.clearAnimation();
            view2.startAnimation(this.viewTransitionAnimationFactory.build(view2.getContext()));
            return false;
        }
        return false;
    }
}
