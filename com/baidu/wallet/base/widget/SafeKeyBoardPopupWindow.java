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
/* loaded from: classes6.dex */
public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Button f24258a;

    /* renamed from: b  reason: collision with root package name */
    public Button f24259b;

    /* renamed from: c  reason: collision with root package name */
    public Button f24260c;
    public View contentView;

    /* renamed from: d  reason: collision with root package name */
    public Button f24261d;

    /* renamed from: e  reason: collision with root package name */
    public Button f24262e;

    /* renamed from: f  reason: collision with root package name */
    public Button f24263f;

    /* renamed from: g  reason: collision with root package name */
    public Button f24264g;

    /* renamed from: h  reason: collision with root package name */
    public Button f24265h;

    /* renamed from: i  reason: collision with root package name */
    public Button f24266i;
    public Button j;
    public ImageButton k;
    public a l;
    public Button mButtonX;
    public Context mContext;
    public SafeScrollView mSafeScrollView;
    public boolean miniMode;
    public SafeKeyBoardEditText mySafeEditText;

    /* loaded from: classes6.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SafeKeyBoardPopupWindow> f24272a;

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
            this.f24272a = new WeakReference<>(safeKeyBoardPopupWindow);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f24272a.get();
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
            Button button = this.j;
            button.setText("" + a2[0]);
            this.j.setTag(Integer.valueOf(a2[0]));
            Button button2 = this.f24258a;
            button2.setText("" + a2[1]);
            this.f24258a.setTag(Integer.valueOf(a2[1]));
            Button button3 = this.f24259b;
            button3.setText("" + a2[2]);
            this.f24259b.setTag(Integer.valueOf(a2[2]));
            Button button4 = this.f24260c;
            button4.setText("" + a2[3]);
            this.f24260c.setTag(Integer.valueOf(a2[3]));
            Button button5 = this.f24261d;
            button5.setText("" + a2[4]);
            this.f24261d.setTag(Integer.valueOf(a2[4]));
            Button button6 = this.f24262e;
            button6.setText("" + a2[5]);
            this.f24262e.setTag(Integer.valueOf(a2[5]));
            Button button7 = this.f24263f;
            button7.setText("" + a2[6]);
            this.f24263f.setTag(Integer.valueOf(a2[6]));
            Button button8 = this.f24264g;
            button8.setText("" + a2[7]);
            this.f24264g.setTag(Integer.valueOf(a2[7]));
            Button button9 = this.f24265h;
            button9.setText("" + a2[8]);
            this.f24265h.setTag(Integer.valueOf(a2[8]));
            Button button10 = this.f24266i;
            button10.setText("" + a2[9]);
            this.f24266i.setTag(Integer.valueOf(a2[9]));
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
                    public final /* synthetic */ SafeKeyBoardPopupWindow f24269a;

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
                        this.f24269a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int selectionStart = this.f24269a.mySafeEditText.getSelectionStart();
                            int selectionEnd = this.f24269a.mySafeEditText.getSelectionEnd();
                            Editable text = this.f24269a.mySafeEditText.getText();
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
                public final /* synthetic */ View f24270a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopupWindow f24271b;

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
                    this.f24271b = this;
                    this.f24270a = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int selectionStart = this.f24271b.mySafeEditText.getSelectionStart();
                        int selectionEnd = this.f24271b.mySafeEditText.getSelectionEnd();
                        Editable text = this.f24271b.mySafeEditText.getText();
                        if (selectionStart >= 0) {
                            if (selectionStart < selectionEnd) {
                                text.replace(selectionStart, selectionEnd, this.f24270a.getTag().toString(), 0, this.f24270a.getTag().toString().length());
                            } else if (selectionStart == selectionEnd) {
                                text.replace(selectionStart, selectionStart, this.f24270a.getTag().toString(), 0, this.f24270a.getTag().toString().length());
                            } else {
                                text.replace(selectionEnd, selectionStart, this.f24270a.getTag().toString(), 0, this.f24270a.getTag().toString().length());
                                int selectionEnd2 = this.f24271b.mySafeEditText.getSelectionEnd() + this.f24270a.getTag().toString().length();
                                if (selectionEnd2 < 0 || selectionEnd2 > this.f24271b.mySafeEditText.getText().toString().length()) {
                                    return;
                                }
                                Selection.setSelection(this.f24271b.mySafeEditText.getEditableText(), selectionEnd2);
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
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.miniMode = a();
            View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
            this.contentView = inflate;
            setContentView(inflate);
            setHeight(-2);
            setWidth(-1);
            setBackgroundDrawable(new BitmapDrawable());
            setAnimationStyle(ResUtils.style(this.mContext, "bd_wallet_safekeyboard_popwindown_anim"));
            this.j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
            this.f24258a = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
            this.f24259b = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
            this.f24260c = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
            this.f24261d = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
            this.f24262e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
            this.f24263f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
            this.f24264g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
            this.f24265h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
            this.f24266i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
            this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
            ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
            this.k = imageButton;
            AccessibilityUtils.setContentDescription(imageButton, ResUtils.getString(this.mContext, "wallet_base_delete"));
            this.j.setOnClickListener(this);
            this.f24258a.setOnClickListener(this);
            this.f24259b.setOnClickListener(this);
            this.f24260c.setOnClickListener(this);
            this.f24261d.setOnClickListener(this);
            this.f24262e.setOnClickListener(this);
            this.f24263f.setOnClickListener(this);
            this.f24264g.setOnClickListener(this);
            this.f24265h.setOnClickListener(this);
            this.f24266i.setOnClickListener(this);
            this.mButtonX.setOnClickListener(this);
            this.k.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopupWindow f24267a;

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
                    this.f24267a = this;
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
                public final /* synthetic */ SafeKeyBoardPopupWindow f24268a;

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
                    this.f24268a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.f24268a.d();
                            return false;
                        } else if (motionEvent.getAction() == 1) {
                            this.f24268a.c();
                            return false;
                        } else if (motionEvent.getAction() != 2 || this.f24268a.k.isPressed()) {
                            return false;
                        } else {
                            this.f24268a.c();
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
