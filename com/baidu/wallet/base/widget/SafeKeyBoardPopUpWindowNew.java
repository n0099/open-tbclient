package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class SafeKeyBoardPopUpWindowNew extends SafeKeyBoardPopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public ImageButton f23712a;
    public Button btConfirm;

    public SafeKeyBoardPopUpWindowNew(Context context) {
        super(context);
        this.btConfirm = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_confirm"));
        ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_hide"));
        this.f23712a = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopUpWindowNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                EventBus.getInstance().post(new EventBus.Event(SafeScrollView.HIDE_KEYBOARD_LISTENER, null));
            }
        });
    }

    @Override // com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow
    public int getLayoutId() {
        return ResUtils.layout(this.mContext, this.miniMode ? "wallet_base_safekeyboard_popupwindow_new_mini" : "wallet_base_safekeyboard_popupwindow_new");
    }

    @Override // com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow
    public void initKeyNum(boolean z) {
        super.initKeyNum(z);
        SafeKeyBoardEditText safeKeyBoardEditText = this.mySafeEditText;
        if (safeKeyBoardEditText != null) {
            String obj = safeKeyBoardEditText.getEditableText().toString();
            SafeKeyBoardEditText safeKeyBoardEditText2 = this.mySafeEditText;
            if (safeKeyBoardEditText2 != null && safeKeyBoardEditText2.getCheckFunc() != null) {
                this.btConfirm.setEnabled(this.mySafeEditText.getCheckFunc().check(obj));
            }
        }
        this.mySafeEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopUpWindowNew.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    SafeKeyBoardPopUpWindowNew.this.btConfirm.setEnabled(false);
                    return;
                }
                String obj2 = editable.toString();
                SafeKeyBoardEditText safeKeyBoardEditText3 = SafeKeyBoardPopUpWindowNew.this.mySafeEditText;
                if (safeKeyBoardEditText3 == null || safeKeyBoardEditText3.getCheckFunc() == null) {
                    return;
                }
                SafeKeyBoardPopUpWindowNew.this.btConfirm.setEnabled(SafeKeyBoardPopUpWindowNew.this.mySafeEditText.getCheckFunc().check(obj2));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                String charSequence2 = charSequence.toString();
                SafeKeyBoardEditText safeKeyBoardEditText3 = SafeKeyBoardPopUpWindowNew.this.mySafeEditText;
                if (safeKeyBoardEditText3 == null || safeKeyBoardEditText3.getCheckFunc() == null) {
                    return;
                }
                SafeKeyBoardPopUpWindowNew.this.btConfirm.setEnabled(SafeKeyBoardPopUpWindowNew.this.mySafeEditText.getCheckFunc().check(charSequence2));
            }
        });
        this.btConfirm.setOnClickListener(this.mySafeEditText.getOnConfirmListener());
        this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_safekeyboard_numkey_selector"));
    }

    @Override // com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow
    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        super.setSafeEditTet(safeKeyBoardEditText);
        if (this.mySafeEditText != null) {
            String obj = safeKeyBoardEditText.getEditableText().toString();
            if (safeKeyBoardEditText.getCheckFunc() != null) {
                this.btConfirm.setEnabled(safeKeyBoardEditText.getCheckFunc().check(obj));
            }
        }
    }
}
