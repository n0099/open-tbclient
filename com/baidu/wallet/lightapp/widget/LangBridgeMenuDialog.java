package com.baidu.wallet.lightapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.GridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class LangBridgeMenuDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdMenuItem.OnItemClickListener f25923a;

    /* renamed from: b  reason: collision with root package name */
    public GridLayout f25924b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25925c;

    /* renamed from: d  reason: collision with root package name */
    public List<BdMenuItem> f25926d;
    public boolean mMenuLoaded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LangBridgeMenuDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMenuLoaded = false;
        a();
    }

    public void add(int i2, CharSequence charSequence, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, charSequence, drawable) == null) {
            BdMenuItem bdMenuItem = new BdMenuItem(getContext(), i2, charSequence, drawable);
            bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangBridgeMenuDialog f25928a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25928a = this;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem2) == null) {
                        this.f25928a.dismiss();
                        if (this.f25928a.f25923a != null) {
                            this.f25928a.f25923a.onClick(bdMenuItem2);
                        }
                    }
                }
            });
            this.f25926d.add(bdMenuItem);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void layoutMenu() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mMenuLoaded) {
            return;
        }
        this.f25924b.removeAllViews();
        if (this.f25926d.size() <= 0) {
            return;
        }
        for (BdMenuItem bdMenuItem : this.f25926d) {
            this.f25924b.addView(a(bdMenuItem));
        }
        this.mMenuLoaded = true;
    }

    public void setMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onItemClickListener) == null) {
            this.f25923a = onItemClickListener;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                super.show();
            } catch (Exception unused) {
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f25926d = new ArrayList();
            requestWindowFeature(1);
            setContentView(ResUtils.layout(getContext(), "wallet_langbridge_menu"));
            Window window = getWindow();
            window.setWindowAnimations(ResUtils.style(getContext(), "wallet_base_bottom_dialog_anim"));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = window.getWindowManager().getDefaultDisplay().getHeight();
            attributes.width = -1;
            attributes.height = -2;
            onWindowAttributesChanged(attributes);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            this.f25924b = (GridLayout) findViewById(ResUtils.id(getContext(), "menu_grid_layout"));
            this.f25925c = (TextView) findViewById(ResUtils.id(getContext(), "menu_cancel"));
            this.f25924b.setColumnCount(5);
            this.f25924b.setHorizontalSpacing(0);
            this.f25924b.setVerticalSpacing(DisplayUtils.dip2px(getContext(), 0.5f));
            this.f25924b.setSeparateLine(ResUtils.getColor(getContext(), "wallet_base_color_D8D8D8"), DisplayUtils.dip2px(getContext(), 18.0f));
            this.f25925c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangBridgeMenuDialog f25927a;

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
                    this.f25927a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f25927a.dismiss();
                    }
                }
            });
            layoutMenu();
        }
    }

    public void add(int i2, CharSequence charSequence, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charSequence, str) == null) {
            BdMenuItem bdMenuItem = new BdMenuItem(getContext(), i2, charSequence, str);
            bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangBridgeMenuDialog f25929a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25929a = this;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem2) == null) {
                        this.f25929a.dismiss();
                        if (this.f25929a.f25923a != null) {
                            this.f25929a.f25923a.onClick(bdMenuItem2);
                        }
                    }
                }
            });
            this.f25926d.add(bdMenuItem);
        }
    }

    private View a(BdMenuItem bdMenuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bdMenuItem)) == null) {
            Context context = getContext();
            View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_langbridge_menu_item"), (ViewGroup) null);
            NetImageView netImageView = (NetImageView) inflate.findViewById(ResUtils.id(context, "menu_item_img"));
            ((TextView) inflate.findViewById(ResUtils.id(context, "menu_item_txt"))).setText(bdMenuItem.getTitle());
            if (!TextUtils.isEmpty(bdMenuItem.getIconUrl())) {
                netImageView.setImageUrl(bdMenuItem.getIconUrl());
            } else {
                Drawable icon = bdMenuItem.getIcon();
                if (icon != null) {
                    netImageView.setImageDrawable(icon);
                }
            }
            inflate.setOnClickListener(new View.OnClickListener(this, bdMenuItem) { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BdMenuItem f25930a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangBridgeMenuDialog f25931b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bdMenuItem};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25931b = this;
                    this.f25930a = bdMenuItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BdMenuItem.OnItemClickListener onClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onClickListener = this.f25930a.getOnClickListener()) == null) {
                        return;
                    }
                    onClickListener.onClick(this.f25930a);
                }
            });
            return inflate;
        }
        return (View) invokeL.objValue;
    }
}
