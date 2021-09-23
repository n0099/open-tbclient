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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class OfficialSecondMenuPopupWindow extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f53377e;

    /* renamed from: f  reason: collision with root package name */
    public int f53378f;

    /* renamed from: g  reason: collision with root package name */
    public int f53379g;

    /* renamed from: h  reason: collision with root package name */
    public int f53380h;

    /* renamed from: i  reason: collision with root package name */
    public Context f53381i;

    /* renamed from: j  reason: collision with root package name */
    public b f53382j;
    public int k;
    public int l;
    public c m;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialSecondMenuPopupWindow f53383e;

        public a(OfficialSecondMenuPopupWindow officialSecondMenuPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialSecondMenuPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53383e = officialSecondMenuPopupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                Object item = this.f53383e.f53382j.getItem(i2);
                if (item instanceof c.a.r0.k1.g.b) {
                    c.a.r0.k1.g.b bVar = (c.a.r0.k1.g.b) item;
                    if (this.f53383e.m != null) {
                        this.f53383e.m.onItemClick(this.f53383e.k, bVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f53384e;

        /* renamed from: f  reason: collision with root package name */
        public List<c.a.r0.k1.g.b> f53385f;

        /* loaded from: classes7.dex */
        public class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public TextView f53386a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public b(Context context, List<c.a.r0.k1.g.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53384e = context;
            this.f53385f = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<c.a.r0.k1.g.b> list = this.f53385f;
                if (list == null) {
                    return 0;
                }
                return (list.size() * 2) - 1;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int itemId = (int) getItemId(i2);
                List<c.a.r0.k1.g.b> list = this.f53385f;
                if (list != null && itemId >= 0 && itemId < list.size()) {
                    return this.f53385f.get(itemId);
                }
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 % 2 == 1) {
                    return -1L;
                }
                return i2 / 2;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? getItemId(i2) == -1 ? 1 : 0 : invokeI.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                int itemViewType = getItemViewType(i2);
                View view2 = view;
                if (view == null) {
                    a aVar = new a(this);
                    if (itemViewType == 0) {
                        TextView textView = new TextView(this.f53384e);
                        textView.setLayoutParams(new AbsListView.LayoutParams(-1, c.a.r0.k1.w.c.d(this.f53384e, R.dimen.ds96)));
                        textView.setTextSize(0, c.a.r0.k1.w.c.d(this.f53384e, R.dimen.ds32));
                        textView.setTextColor(this.f53384e.getResources().getColor(R.color.CAM_X0105));
                        textView.setGravity(17);
                        textView.setBackgroundResource(R.drawable.official_bar_menu_text_bg);
                        textView.setSingleLine();
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        aVar.f53386a = textView;
                        linearLayout = textView;
                    } else {
                        linearLayout = view;
                        if (itemViewType == 1) {
                            LinearLayout linearLayout2 = new LinearLayout(this.f53384e);
                            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, c.a.r0.k1.w.c.d(this.f53384e, R.dimen.ds1)));
                            ImageView imageView = new ImageView(this.f53384e);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                            layoutParams.setMargins(c.a.r0.k1.w.c.d(this.f53384e, R.dimen.ds30), 0, c.a.r0.k1.w.c.d(this.f53384e, R.dimen.ds30), 0);
                            imageView.setLayoutParams(layoutParams);
                            imageView.setBackgroundColor(this.f53384e.getResources().getColor(R.color.CAM_X0204));
                            linearLayout2.addView(imageView);
                            linearLayout = linearLayout2;
                        }
                    }
                    linearLayout.setTag(aVar);
                    view2 = linearLayout;
                }
                a aVar2 = (a) view2.getTag();
                if (itemViewType == 0) {
                    aVar2.f53386a.setText(((c.a.r0.k1.g.b) getItem(i2)).d());
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onItemClick(int i2, c.a.r0.k1.g.b bVar);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53381i = context;
        addView(d(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = c.a.r0.k1.w.c.d(this.f53381i, R.dimen.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(R.drawable.bg_bottombar_meun_float);
        this.f53377e = c.a.r0.k1.w.c.d(this.f53381i, R.dimen.ds36);
        this.f53379g = c.a.r0.k1.w.c.d(this.f53381i, R.dimen.ds200);
        this.f53378f = c.a.r0.k1.w.c.d(this.f53381i, R.dimen.ds504);
    }

    public void applyAniamtion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                startAnimation(AnimationUtils.loadAnimation(this.f53381i, R.anim.sub_menu_up));
            } else {
                startAnimation(AnimationUtils.loadAnimation(this.f53381i, R.anim.sub_menu_down));
            }
        }
    }

    public final ListView d(List<c.a.r0.k1.g.b> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2)) == null) {
            ListView listView = new ListView(this.f53381i);
            listView.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
            listView.setCacheColorHint(this.f53381i.getResources().getColor(17170445));
            listView.setDivider(null);
            listView.setDividerHeight(0);
            b bVar = new b(this.f53381i, list);
            this.f53382j = bVar;
            listView.setAdapter((ListAdapter) bVar);
            listView.setOnItemClickListener(new a(this));
            return listView;
        }
        return (ListView) invokeLI.objValue;
    }

    public final int e(List<c.a.r0.k1.g.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            Paint paint = new Paint(1);
            paint.setColor(this.f53381i.getResources().getColor(17170443));
            paint.setTextSize(c.a.r0.k1.w.c.d(this.f53381i, R.dimen.ds32));
            float f2 = 0.0f;
            for (int i2 = 0; i2 < list.size(); i2++) {
                float measureText = paint.measureText(list.get(i2).d());
                if (measureText > f2) {
                    f2 = measureText;
                }
            }
            return (int) Math.min(Math.max((this.f53377e * 2) + f2, this.f53379g), this.f53378f);
        }
        return invokeL.intValue;
    }

    public void hidePopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(8);
            applyAniamtion(false);
        }
    }

    public void hidePopupWindowNoAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    public void setData(int i2, int i3, List<c.a.r0.k1.g.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, list) == null) || list == null) {
            return;
        }
        this.l = i2;
        this.k = i3;
        this.f53380h = e(list);
        removeAllViews();
        addView(d(list, this.f53380h));
    }

    public void setOnItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void showPopupWindow(View view) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (layoutParams = (FrameLayout.LayoutParams) getLayoutParams()) == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = (iArr[0] + (view.getWidth() / 2)) - (this.f53380h / 2);
        if (this.k == this.l - 1) {
            width = ((iArr[0] + view.getWidth()) - c.a.r0.k1.w.c.d(this.f53381i, R.dimen.ds20)) - this.f53380h;
        }
        if (width <= 0) {
            width = c.a.r0.k1.w.c.d(this.f53381i, R.dimen.ds20);
        }
        layoutParams.leftMargin = width;
        setLayoutParams(layoutParams);
        setVisibility(0);
        applyAniamtion(true);
    }
}
