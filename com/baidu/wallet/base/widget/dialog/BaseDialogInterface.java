package com.baidu.wallet.base.widget.dialog;

import android.text.SpannableString;
import android.view.View;
/* loaded from: classes5.dex */
public interface BaseDialogInterface {
    void hideButtons();

    void hideNegativeButton();

    void hidePositiveButton();

    void hideTitle();

    void hideTitleLine();

    void setNegativeBtn(int i2, View.OnClickListener onClickListener);

    void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener);

    void setNegativeBtn(View.OnClickListener onClickListener);

    void setNegativeBtn(String str, View.OnClickListener onClickListener);

    void setPositiveBtn(int i2, View.OnClickListener onClickListener);

    void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener);

    void setPositiveBtn(View.OnClickListener onClickListener);

    void setPositiveBtn(String str, View.OnClickListener onClickListener);

    void setTitleText(int i2);

    void setTitleText(String str);

    void setTitleTextBackgroud(int i2);

    void showCloseBtn(boolean z);
}
