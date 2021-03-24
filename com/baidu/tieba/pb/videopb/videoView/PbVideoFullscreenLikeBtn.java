package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes5.dex */
public class PbVideoFullscreenLikeBtn extends PbFirstFloorUserLikeButton {
    public View.OnClickListener x;

    public PbVideoFullscreenLikeBtn(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton, d.b.h0.r.f0.q.b
    public void b(View view) {
        setText(this.s);
        setClickable(false);
        View.OnClickListener onClickListener = this.x;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setOnclickEvent(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public PbVideoFullscreenLikeBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PbVideoFullscreenLikeBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
