package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
import android.view.View;
/* loaded from: classes.dex */
public interface a {
    boolean LL();

    View LV();

    View Li();

    void Mh();

    String RI();

    View RJ();

    void RK();

    int RL();

    boolean RM();

    void c(DialogInterface.OnClickListener onClickListener);

    void clearText();

    void d(DialogInterface.OnClickListener onClickListener);

    void gE(String str);

    int getGroupId();

    String getText();

    void onChangeSkinType(int i);

    void setGroupId(int i);

    void setIsLoading(boolean z);
}
