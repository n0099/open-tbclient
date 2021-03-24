package com.baidu.wallet.base.widget.dialog.model;

import android.view.View;
/* loaded from: classes5.dex */
public class MultiBtnDialogModel extends BaseModel {
    public View.OnClickListener defaultClickListener;
    public View.OnClickListener firstBtnClickListener;
    public String firstBtnText;
    public int firstBtnTextId;
    public CharSequence message;
    public int messageId;
    public View.OnClickListener secondBtnClickListener;
    public String secondBtnText;
    public int secondBtnTextId;
    public View.OnClickListener thirdBtnClickListener;
    public String thirdBtnText;
    public int thirdBtnTextId;
    public int titleId;
    public String titleText;
    public boolean firstBtnTextBold = false;
    public boolean secondBtnTextBold = false;
    public boolean thirdBtnTextBold = false;
}
