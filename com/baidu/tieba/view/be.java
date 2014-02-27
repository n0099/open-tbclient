package com.baidu.tieba.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class be implements com.baidu.tieba.util.cj {
    final /* synthetic */ HorizontalPanelView a;
    private final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(HorizontalPanelView horizontalPanelView, UserData userData) {
        this.a = horizontalPanelView;
        this.b = userData;
    }

    @Override // com.baidu.tieba.util.cj
    public final boolean a(View view) {
        List list;
        LinearLayout linearLayout;
        if (view != null && (view instanceof HeadImageView)) {
            HeadImageView headImageView = (HeadImageView) view;
            if (headImageView.getUserId() != null && headImageView.getUserId().equals(String.valueOf(this.b.getUserId()))) {
                list = this.a.g;
                list.remove(headImageView);
                linearLayout = this.a.d;
                linearLayout.removeView(headImageView);
                return false;
            }
            return false;
        }
        return false;
    }
}
