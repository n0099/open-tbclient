package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes22.dex */
public class PbVideoFullscreenLikeBtn extends PbFirstFloorUserLikeButton {
    private View.OnClickListener lOX;

    public PbVideoFullscreenLikeBtn(Context context) {
        super(context);
    }

    public PbVideoFullscreenLikeBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PbVideoFullscreenLikeBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void bv(View view) {
        setText(this.eZv);
        setClickable(false);
        if (this.lOX != null) {
            this.lOX.onClick(view);
        }
    }

    public void setOnclickEvent(View.OnClickListener onClickListener) {
        this.lOX = onClickListener;
    }
}
