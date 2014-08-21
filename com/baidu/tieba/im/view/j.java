package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements br {
    final /* synthetic */ HorizontalPanelView a;
    private final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(HorizontalPanelView horizontalPanelView, UserData userData) {
        this.a = horizontalPanelView;
        this.b = userData;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        List list;
        LinearLayout linearLayout;
        if (view != null && (view instanceof HeadImageView)) {
            HeadImageView headImageView = (HeadImageView) view;
            if (headImageView.getUserId() != null && headImageView.getUserId().equals(String.valueOf(this.b.getUserId()))) {
                list = this.a.f;
                list.remove(headImageView);
                linearLayout = this.a.c;
                linearLayout.removeView(headImageView);
                return false;
            }
            return false;
        }
        return false;
    }
}
