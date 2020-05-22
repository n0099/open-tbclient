package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes9.dex */
public class PbVideoFullscreenLikeBtn extends PbFirstFloorUserLikeButton {
    private View.OnClickListener keO;

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
    public void bc(View view) {
        setText(this.dYD);
        setClickable(false);
        if (this.keO != null) {
            this.keO.onClick(view);
        }
    }

    public void setOnclickEvent(View.OnClickListener onClickListener) {
        this.keO = onClickListener;
    }
}
