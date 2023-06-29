package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.gc8;
import com.baidu.tieba.s88;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class OfficialSecondMenuPopupWindow extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public Context e;
    public b f;
    public int g;
    public int h;
    public c i;

    /* loaded from: classes6.dex */
    public interface c {
        void t0(int i, s88 s88Var);
    }

    /* loaded from: classes6.dex */
    public static class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public List<s88> b;

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes6.dex */
        public class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public TextView a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public b(Context context, List<s88> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<s88> list = this.b;
                if (list == null) {
                    return 0;
                }
                return (list.size() * 2) - 1;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                int itemId = (int) getItemId(i);
                List<s88> list = this.b;
                if (list == null || itemId < 0 || itemId >= list.size()) {
                    return null;
                }
                return this.b.get(itemId);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i % 2 == 1) {
                    return -1L;
                }
                return i / 2;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (getItemId(i) == -1) {
                    return 1;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                int itemViewType = getItemViewType(i);
                View view3 = view2;
                if (view2 == null) {
                    a aVar = new a(this);
                    if (itemViewType == 0) {
                        TextView textView = new TextView(this.a);
                        textView.setLayoutParams(new AbsListView.LayoutParams(-1, gc8.i(this.a, R.dimen.obfuscated_res_0x7f070281)));
                        textView.setTextSize(0, gc8.i(this.a, R.dimen.obfuscated_res_0x7f070207));
                        textView.setTextColor(this.a.getResources().getColor(R.color.CAM_X0105));
                        textView.setGravity(17);
                        textView.setBackgroundResource(R.drawable.official_bar_menu_text_bg);
                        textView.setSingleLine();
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        aVar.a = textView;
                        linearLayout = textView;
                    } else {
                        linearLayout = view2;
                        if (itemViewType == 1) {
                            LinearLayout linearLayout2 = new LinearLayout(this.a);
                            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, gc8.i(this.a, R.dimen.obfuscated_res_0x7f070198)));
                            ImageView imageView = new ImageView(this.a);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                            layoutParams.setMargins(gc8.i(this.a, R.dimen.obfuscated_res_0x7f070201), 0, gc8.i(this.a, R.dimen.obfuscated_res_0x7f070201), 0);
                            imageView.setLayoutParams(layoutParams);
                            imageView.setBackgroundColor(this.a.getResources().getColor(R.color.CAM_X0204));
                            linearLayout2.addView(imageView);
                            linearLayout = linearLayout2;
                        }
                    }
                    linearLayout.setTag(aVar);
                    view3 = linearLayout;
                }
                a aVar2 = (a) view3.getTag();
                if (itemViewType == 0) {
                    aVar2.a.setText(((s88) getItem(i)).d());
                }
                return view3;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialSecondMenuPopupWindow a;

        public a(OfficialSecondMenuPopupWindow officialSecondMenuPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialSecondMenuPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialSecondMenuPopupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                Object item = this.a.f.getItem(i);
                if (item instanceof s88) {
                    s88 s88Var = (s88) item;
                    if (this.a.i != null) {
                        this.a.i.t0(this.a.g, s88Var);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialSecondMenuPopupWindow(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = context;
        addView(e(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = gc8.i(this.e, R.dimen.obfuscated_res_0x7f0701b2);
        setLayoutParams(layoutParams);
        setBackgroundResource(R.drawable.obfuscated_res_0x7f0802b6);
        this.a = gc8.i(this.e, R.dimen.obfuscated_res_0x7f070215);
        this.c = gc8.i(this.e, R.dimen.obfuscated_res_0x7f070389);
        this.b = gc8.i(this.e, R.dimen.obfuscated_res_0x7f0703e8);
    }

    public final int f(List<s88> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            Paint paint = new Paint(1);
            paint.setColor(this.e.getResources().getColor(17170443));
            paint.setTextSize(gc8.i(this.e, R.dimen.obfuscated_res_0x7f070207));
            float f = 0.0f;
            for (int i = 0; i < list.size(); i++) {
                float measureText = paint.measureText(list.get(i).d());
                if (measureText > f) {
                    f = measureText;
                }
            }
            return (int) Math.min(Math.max((this.a * 2) + f, this.c), this.b);
        }
        return invokeL.intValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.obfuscated_res_0x7f010163));
            } else {
                startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.obfuscated_res_0x7f010162));
            }
        }
    }

    public void setOnItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public final ListView e(List<s88> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i)) == null) {
            ListView listView = new ListView(this.e);
            listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
            listView.setCacheColorHint(this.e.getResources().getColor(17170445));
            listView.setDivider(null);
            listView.setDividerHeight(0);
            b bVar = new b(this.e, list);
            this.f = bVar;
            listView.setAdapter((ListAdapter) bVar);
            listView.setOnItemClickListener(new a(this));
            return listView;
        }
        return (ListView) invokeLI.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(8);
            d(false);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    public void i(View view2) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (layoutParams = (FrameLayout.LayoutParams) getLayoutParams()) != null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int width = (iArr[0] + (view2.getWidth() / 2)) - (this.d / 2);
            if (this.g == this.h - 1) {
                width = ((iArr[0] + view2.getWidth()) - gc8.i(this.e, R.dimen.obfuscated_res_0x7f0701d5)) - this.d;
            }
            if (width <= 0) {
                width = gc8.i(this.e, R.dimen.obfuscated_res_0x7f0701d5);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            d(true);
        }
    }

    public void setData(int i, int i2, List<s88> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048582, this, i, i2, list) != null) || list == null) {
            return;
        }
        this.h = i;
        this.g = i2;
        this.d = f(list);
        removeAllViews();
        addView(e(list, this.d));
    }
}
