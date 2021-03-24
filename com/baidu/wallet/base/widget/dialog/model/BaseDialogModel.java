package com.baidu.wallet.base.widget.dialog.model;

import android.view.View;
/* loaded from: classes5.dex */
public class BaseDialogModel extends BaseModel {
    public View.OnClickListener defaultListener;
    public View.OnClickListener negativeBtnClickListener;
    public CharSequence negativeBtnText;
    public int negativeBtnTextId;
    public View.OnClickListener positiveBtnClickListener;
    public CharSequence positiveBtnText;
    public int positiveBtnTextId;
    public CharSequence title;
    public int titleId;
    public int dialogBackgound = 0;
    public int positiveBtnTextSize = 0;
    public int positiveBtnTextColor = 0;
    public int negativeBtnTextSize = 0;
    public int negativeBtnTextColor = 0;
    public boolean hideNegativeBtn = false;
    public boolean hidePositiveBtn = false;
    public boolean hideTitle = false;
    public boolean hideButtons = false;
    public boolean negativeBtnTextBold = true;
    public boolean positiveBtnTextBold = true;
}
