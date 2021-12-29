package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class CouponFragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<c> f54676b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f54677c;

    /* renamed from: d  reason: collision with root package name */
    public Context f54678d;

    /* renamed from: e  reason: collision with root package name */
    public FragmentManager f54679e;

    /* renamed from: f  reason: collision with root package name */
    public int f54680f;

    /* renamed from: g  reason: collision with root package name */
    public TabHost.OnTabChangeListener f54681g;

    /* renamed from: h  reason: collision with root package name */
    public c f54682h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54683i;

    /* loaded from: classes13.dex */
    public static class a implements TabHost.TabContentFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                View view = new View(this.a);
                view.setMinimumWidth(0);
                view.setMinimumHeight(0);
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class b extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<b> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-553026324, "Lcom/baidu/wallet/personal/ui/view/CouponFragmentTabHost$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-553026324, "Lcom/baidu/wallet/personal/ui/view/CouponFragmentTabHost$b;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<b>() { // from class: com.baidu.wallet.personal.ui.view.CouponFragmentTabHost.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public b createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new b(parcel) : (b) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public b[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new b[i2] : (b[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = parcel.readString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeString(this.a);
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final String f54684b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f54685c;

        /* renamed from: d  reason: collision with root package name */
        public final Bundle f54686d;

        /* renamed from: e  reason: collision with root package name */
        public Fragment f54687e;

        public c(String str, Class<?> cls, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cls, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54684b = str;
            this.f54685c = cls;
            this.f54686d = bundle;
            this.a = 0;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(String str, Class<?> cls, Bundle bundle, int i2) {
            this(str, cls, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cls, bundle, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (Class) objArr2[1], (Bundle) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1514506666, "Lcom/baidu/wallet/personal/ui/view/CouponFragmentTabHost;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1514506666, "Lcom/baidu/wallet/personal/ui/view/CouponFragmentTabHost;");
                return;
            }
        }
        a = CouponFragmentTabHost.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponFragmentTabHost(Context context) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54676b = new ArrayList<>();
        a(context, (AttributeSet) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f54676b = new ArrayList<>();
        a(context, attributeSet);
    }

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, fragmentTransaction)) == null) {
            c cVar = null;
            for (int i2 = 0; i2 < this.f54676b.size(); i2++) {
                c cVar2 = this.f54676b.get(i2);
                if (cVar2.f54684b.equals(str)) {
                    cVar = cVar2;
                }
            }
            if (cVar == null) {
                throw new IllegalStateException("No tab known for tag " + str);
            } else if (cVar.a == 1) {
                c cVar3 = this.f54682h;
                if (cVar3 != null && !TextUtils.isEmpty(cVar3.f54684b)) {
                    setCurrentTabByTag(this.f54682h.f54684b);
                }
                return null;
            } else {
                if (this.f54682h != cVar) {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f54679e.beginTransaction();
                    }
                    c cVar4 = this.f54682h;
                    if (cVar4 != null && cVar4.f54687e != null) {
                        if (this.f54682h.a == 2) {
                            fragmentTransaction.hide(this.f54682h.f54687e);
                        } else {
                            fragmentTransaction.detach(this.f54682h.f54687e);
                        }
                    }
                    if (cVar.f54687e == null) {
                        cVar.f54687e = Fragment.instantiate(this.f54678d, cVar.f54685c.getName(), cVar.f54686d);
                        if (!cVar.f54687e.isAdded()) {
                            fragmentTransaction.add(this.f54680f, cVar.f54687e, cVar.f54684b);
                        }
                    } else {
                        int unused = cVar.a;
                        fragmentTransaction.attach(cVar.f54687e);
                        fragmentTransaction.show(cVar.f54687e);
                    }
                    this.f54682h = cVar;
                }
                return fragmentTransaction;
            }
        }
        return (FragmentTransaction) invokeLL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            Context context = getContext();
            if (findViewById(16908307) == null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
                TabWidget tabWidget = new TabWidget(context);
                tabWidget.setId(16908307);
                tabWidget.setOrientation(0);
                linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setId(16908305);
                linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
                FrameLayout frameLayout2 = new FrameLayout(context);
                this.f54677c = frameLayout2;
                frameLayout2.setId(this.f54680f);
                linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            }
            if (this.f54677c == null) {
                FrameLayout frameLayout3 = (FrameLayout) findViewById(this.f54680f);
                this.f54677c = frameLayout3;
                if (frameLayout3 != null) {
                    return;
                }
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f54680f);
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
            this.f54680f = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
            super.setOnTabChangedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        FragmentTransaction a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String currentTabTag = getCurrentTabTag();
            FragmentTransaction fragmentTransaction = null;
            for (int i2 = 0; i2 < this.f54676b.size(); i2++) {
                c cVar = this.f54676b.get(i2);
                cVar.f54687e = this.f54679e.findFragmentByTag(cVar.f54684b);
                if (cVar.f54687e != null && !cVar.f54687e.isDetached()) {
                    if (cVar.f54684b.equals(currentTabTag)) {
                        this.f54682h = cVar;
                    } else {
                        if (fragmentTransaction == null) {
                            fragmentTransaction = this.f54679e.beginTransaction();
                        }
                        fragmentTransaction.detach(cVar.f54687e);
                    }
                }
            }
            this.f54683i = true;
            if (TextUtils.isEmpty(currentTabTag) || (a2 = a(currentTabTag, fragmentTransaction)) == null) {
                return;
            }
            a2.commitAllowingStateLoss();
            this.f54679e.executePendingTransactions();
        }
    }

    public void a(Context context, FragmentManager fragmentManager, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, fragmentManager, i2) == null) {
            super.setup();
            this.f54678d = context;
            this.f54679e = fragmentManager;
            this.f54680f = i2;
            a();
            this.f54677c.setId(i2);
            if (getId() == -1) {
                setId(16908306);
            }
        }
    }

    public void a(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tabSpec, cls, bundle, i2) == null) {
            tabSpec.setContent(new a(this.f54678d));
            String tag = tabSpec.getTag();
            c cVar = new c(tag, cls, bundle, i2);
            if (this.f54683i) {
                cVar.f54687e = this.f54679e.findFragmentByTag(tag);
                if (cVar.f54687e != null && !cVar.f54687e.isDetached()) {
                    FragmentTransaction beginTransaction = this.f54679e.beginTransaction();
                    beginTransaction.detach(cVar.f54687e);
                    beginTransaction.commitAllowingStateLoss();
                }
            }
            this.f54676b.add(cVar);
            addTab(tabSpec);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            String currentTabTag = getCurrentTabTag();
            if (TextUtils.isEmpty(currentTabTag)) {
                postDelayed(new Runnable(this) { // from class: com.baidu.wallet.personal.ui.view.CouponFragmentTabHost.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CouponFragmentTabHost a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b();
                        }
                    }
                }, 50L);
                return;
            }
            FragmentTransaction fragmentTransaction = null;
            for (int i2 = 0; i2 < this.f54676b.size(); i2++) {
                c cVar = this.f54676b.get(i2);
                cVar.f54687e = this.f54679e.findFragmentByTag(cVar.f54684b);
                if (cVar.f54687e != null && !cVar.f54687e.isDetached()) {
                    if (cVar.f54684b.equals(currentTabTag)) {
                        this.f54682h = cVar;
                    } else {
                        if (fragmentTransaction == null) {
                            fragmentTransaction = this.f54679e.beginTransaction();
                        }
                        fragmentTransaction.detach(cVar.f54687e);
                    }
                }
            }
            this.f54683i = true;
            FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
            if (a2 != null) {
                a2.commitAllowingStateLoss();
                this.f54679e.executePendingTransactions();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.f54683i = false;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, parcelable) == null) {
            b bVar = (b) parcelable;
            super.onRestoreInstanceState(bVar.getSuperState());
            setCurrentTabByTag(bVar.a);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b bVar = new b(super.onSaveInstanceState());
            bVar.a = getCurrentTabTag();
            return bVar;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        FragmentTransaction a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (this.f54683i && (a2 = a(str, (FragmentTransaction) null)) != null) {
                a2.commitAllowingStateLoss();
            }
            TabHost.OnTabChangeListener onTabChangeListener = this.f54681g;
            if (onTabChangeListener != null) {
                onTabChangeListener.onTabChanged(str);
            }
        }
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onTabChangeListener) == null) {
            this.f54681g = onTabChangeListener;
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
        }
    }
}
