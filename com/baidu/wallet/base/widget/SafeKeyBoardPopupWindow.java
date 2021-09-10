package com.baidu.wallet.base.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes8.dex */
public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Button f60608a;

    /* renamed from: b  reason: collision with root package name */
    public Button f60609b;

    /* renamed from: c  reason: collision with root package name */
    public Button f60610c;
    public View contentView;

    /* renamed from: d  reason: collision with root package name */
    public Button f60611d;

    /* renamed from: e  reason: collision with root package name */
    public Button f60612e;

    /* renamed from: f  reason: collision with root package name */
    public Button f60613f;

    /* renamed from: g  reason: collision with root package name */
    public Button f60614g;

    /* renamed from: h  reason: collision with root package name */
    public Button f60615h;

    /* renamed from: i  reason: collision with root package name */
    public Button f60616i;

    /* renamed from: j  reason: collision with root package name */
    public Button f60617j;
    public ImageButton k;
    public a l;
    public Button mButtonX;
    public Context mContext;
    public SafeScrollView mSafeScrollView;
    public boolean miniMode;
    public SafeKeyBoardEditText mySafeEditText;

    /* loaded from: classes8.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SafeKeyBoardPopupWindow> f60623a;

        public a(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60623a = new WeakReference<>(safeKeyBoardPopupWindow);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f60623a.get();
                if (safeKeyBoardPopupWindow == null) {
                    return;
                }
                if (!TextUtils.isEmpty(safeKeyBoardPopupWindow.mySafeEditText.getText())) {
                    int selectionStart = safeKeyBoardPopupWindow.mySafeEditText.getSelectionStart();
                    int selectionEnd = safeKeyBoardPopupWindow.mySafeEditText.getSelectionEnd();
                    Editable text = safeKeyBoardPopupWindow.mySafeEditText.getText();
                    if (selectionStart >= 0) {
                        if (selectionStart < selectionEnd) {
                            text.replace(selectionStart, selectionEnd, "", 0, 0);
                        } else if (selectionStart != selectionEnd) {
                            text.replace(selectionEnd, selectionStart, "", 0, 0);
                        } else if (selectionStart > 0) {
                            text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                        }
                        removeCallbacksAndMessages(null);
                        sendEmptyMessageDelayed(1, 200L);
                        return;
                    }
                    return;
                }
                removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardPopupWindow(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.l == null) {
                this.l = new a(this);
            }
            this.l.sendEmptyMessage(1);
        }
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ResUtils.layout(this.mContext, this.miniMode ? "wallet_base_safekeyboard_popupwindow_mini" : "wallet_base_safekeyboard_popupwindow");
        }
        return invokeV.intValue;
    }

    public int getPopupWindowHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.contentView.getHeight() : invokeV.intValue;
    }

    public void initKeyNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int[] a2 = a(z);
            Button button = this.f60617j;
            button.setText("" + a2[0]);
            this.f60617j.setTag(Integer.valueOf(a2[0]));
            Button button2 = this.f60608a;
            button2.setText("" + a2[1]);
            this.f60608a.setTag(Integer.valueOf(a2[1]));
            Button button3 = this.f60609b;
            button3.setText("" + a2[2]);
            this.f60609b.setTag(Integer.valueOf(a2[2]));
            Button button4 = this.f60610c;
            button4.setText("" + a2[3]);
            this.f60610c.setTag(Integer.valueOf(a2[3]));
            Button button5 = this.f60611d;
            button5.setText("" + a2[4]);
            this.f60611d.setTag(Integer.valueOf(a2[4]));
            Button button6 = this.f60612e;
            button6.setText("" + a2[5]);
            this.f60612e.setTag(Integer.valueOf(a2[5]));
            Button button7 = this.f60613f;
            button7.setText("" + a2[6]);
            this.f60613f.setTag(Integer.valueOf(a2[6]));
            Button button8 = this.f60614g;
            button8.setText("" + a2[7]);
            this.f60614g.setTag(Integer.valueOf(a2[7]));
            Button button9 = this.f60615h;
            button9.setText("" + a2[8]);
            this.f60615h.setTag(Integer.valueOf(a2[8]));
            Button button10 = this.f60616i;
            button10.setText("" + a2[9]);
            this.f60616i.setTag(Integer.valueOf(a2[9]));
            if (this.mySafeEditText.getUseKeyX()) {
                this.mButtonX.setEnabled(true);
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_safekeyboard_numkey_selector"));
                this.mButtonX.setText("X");
                this.mButtonX.setTag("X");
            } else if (this.mySafeEditText.getUseKeyDot()) {
                this.mButtonX.setEnabled(true);
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_safekeyboard_numkey_selector"));
                this.mButtonX.setText(".");
                this.mButtonX.setTag(".");
            } else {
                this.mButtonX.setEnabled(false);
                this.mButtonX.setText("");
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_safekeyboard_delkey_selector"));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getId() == ResUtils.id(this.mContext, "btn_del")) {
                if (TextUtils.isEmpty(this.mySafeEditText.getText())) {
                    return;
                }
                new Handler().post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SafeKeyBoardPopupWindow f60620a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60620a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int selectionStart = this.f60620a.mySafeEditText.getSelectionStart();
                            int selectionEnd = this.f60620a.mySafeEditText.getSelectionEnd();
                            Editable text = this.f60620a.mySafeEditText.getText();
                            if (selectionStart >= 0) {
                                if (selectionStart < selectionEnd) {
                                    text.replace(selectionStart, selectionEnd, "", 0, 0);
                                } else if (selectionStart != selectionEnd) {
                                    text.replace(selectionEnd, selectionStart, "", 0, 0);
                                } else if (selectionStart > 0) {
                                    text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                                }
                            }
                        }
                    }
                });
                return;
            }
            new Handler().post(new Runnable(this, view) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f60621a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopupWindow f60622b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60622b = this;
                    this.f60621a = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int selectionStart = this.f60622b.mySafeEditText.getSelectionStart();
                        int selectionEnd = this.f60622b.mySafeEditText.getSelectionEnd();
                        Editable text = this.f60622b.mySafeEditText.getText();
                        if (selectionStart >= 0) {
                            if (selectionStart < selectionEnd) {
                                text.replace(selectionStart, selectionEnd, this.f60621a.getTag().toString(), 0, this.f60621a.getTag().toString().length());
                            } else if (selectionStart == selectionEnd) {
                                text.replace(selectionStart, selectionStart, this.f60621a.getTag().toString(), 0, this.f60621a.getTag().toString().length());
                            } else {
                                text.replace(selectionEnd, selectionStart, this.f60621a.getTag().toString(), 0, this.f60621a.getTag().toString().length());
                                int selectionEnd2 = this.f60622b.mySafeEditText.getSelectionEnd() + this.f60621a.getTag().toString().length();
                                if (selectionEnd2 < 0 || selectionEnd2 > this.f60622b.mySafeEditText.getText().toString().length()) {
                                    return;
                                }
                                Selection.setSelection(this.f60622b.mySafeEditText.getEditableText(), selectionEnd2);
                            }
                        }
                    }
                }
            });
        }
    }

    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, safeKeyBoardEditText) == null) {
            this.mySafeEditText = safeKeyBoardEditText;
        }
    }

    public void setScrollView(SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, safeScrollView) == null) {
            this.mSafeScrollView = safeScrollView;
        }
    }

    @Override // android.widget.PopupWindow
    public void update() {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.update();
            if (!isShowing() || (safeKeyBoardEditText = this.mySafeEditText) == null) {
                return;
            }
            safeKeyBoardEditText.isShowLogoLockAnim();
        }
    }

    @TargetApi(24)
    private boolean a() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (context = this.mContext) == null) {
                return false;
            }
            return ((Activity) context).isInMultiWindowMode();
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.miniMode = a();
            View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
            this.contentView = inflate;
            setContentView(inflate);
            setHeight(-2);
            setWidth(-1);
            setBackgroundDrawable(new BitmapDrawable());
            setAnimationStyle(ResUtils.style(this.mContext, "bd_wallet_safekeyboard_popwindown_anim"));
            this.f60617j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
            this.f60608a = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
            this.f60609b = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
            this.f60610c = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
            this.f60611d = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
            this.f60612e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
            this.f60613f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
            this.f60614g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
            this.f60615h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
            this.f60616i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
            this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
            ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
            this.k = imageButton;
            AccessibilityUtils.setContentDescription(imageButton, ResUtils.getString(this.mContext, "wallet_base_delete"));
            this.f60617j.setOnClickListener(this);
            this.f60608a.setOnClickListener(this);
            this.f60609b.setOnClickListener(this);
            this.f60610c.setOnClickListener(this);
            this.f60611d.setOnClickListener(this);
            this.f60612e.setOnClickListener(this);
            this.f60613f.setOnClickListener(this);
            this.f60614g.setOnClickListener(this);
            this.f60615h.setOnClickListener(this);
            this.f60616i.setOnClickListener(this);
            this.mButtonX.setOnClickListener(this);
            this.k.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopupWindow f60618a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60618a = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) {
                    }
                }
            });
            this.k.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopupWindow f60619a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60619a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.f60619a.d();
                            return false;
                        } else if (motionEvent.getAction() == 1) {
                            this.f60619a.c();
                            return false;
                        } else if (motionEvent.getAction() != 2 || this.f60619a.k.isPressed()) {
                            return false;
                        } else {
                            this.f60619a.c();
                            return false;
                        }
                    }
                    return invokeLL.booleanValue;
                }
            });
            setSoftInputMode(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.l == null) {
                this.l = new a(this);
            }
            this.l.removeCallbacksAndMessages(null);
        }
    }

    private int[] a(boolean z) {
        InterceptResult invokeZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                if (i3 >= 10) {
                    break;
                }
                arrayList.add(Integer.valueOf(i3));
                i3++;
            }
            int[] iArr = new int[10];
            if (z) {
                Random random = new Random();
                for (i2 = 10; i2 > 0; i2--) {
                    int nextInt = random.nextInt(i2);
                    iArr[10 - i2] = ((Integer) arrayList.get(nextInt)).intValue();
                    arrayList.remove(nextInt);
                }
            } else {
                for (int i4 = 0; i4 < 10; i4++) {
                    iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                }
            }
            return iArr;
        }
        return (int[]) invokeZ.objValue;
    }
}
