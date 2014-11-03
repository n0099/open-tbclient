package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
import android.view.View;
/* loaded from: classes.dex */
public interface a {
    boolean LP();

    View LZ();

    View Lm();

    void Ml();

    String RL();

    View RM();

    void RN();

    int RO();

    boolean RP();

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
