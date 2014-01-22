package com.baidu.tieba.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.im.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.tieba.util.cg {
    final /* synthetic */ UserData a;
    final /* synthetic */ HorizontalPanelView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(HorizontalPanelView horizontalPanelView, UserData userData) {
        this.b = horizontalPanelView;
        this.a = userData;
    }

    @Override // com.baidu.tieba.util.cg
    public boolean a(View view) {
        List list;
        LinearLayout linearLayout;
        if (view != null && (view instanceof HeadImageView)) {
            HeadImageView headImageView = (HeadImageView) view;
            if (headImageView.getUserId() != null && headImageView.getUserId().equals(String.valueOf(this.a.getUserId()))) {
                list = this.b.g;
                list.remove(headImageView);
                linearLayout = this.b.d;
                linearLayout.removeView(headImageView);
                return false;
            }
            return false;
        }
        return false;
    }
}
