package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes9.dex */
public class ViewPropertyTransition<R> implements Transition<R> {
    public final Animator animator;

    /* loaded from: classes9.dex */
    public interface Animator {
        void animate(View view2);
    }

    public ViewPropertyTransition(Animator animator) {
        this.animator = animator;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() != null) {
            this.animator.animate(viewAdapter.getView());
            return false;
        }
        return false;
    }
}
