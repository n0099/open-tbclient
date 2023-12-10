package com.baidu.tieba;

import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.square.flist.ForumListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar A;
    public boolean B;
    public int C;
    public LinearLayout a;
    public final View b;
    public final View c;
    public ViewPager d;
    public LinearLayout e;
    public NavigationBar f;
    public TextView g;
    public ImageView h;
    public BdListView i;
    public BdListView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;
    public ImageView o;
    public LinearLayout p;
    public TextView q;
    public ImageView r;
    public q55 s;
    public q55 t;
    public PopupWindow u;
    public View v;
    public ForumListActivity w;
    public ListView x;
    public xsa y;
    public LinearLayout z;

    /* loaded from: classes9.dex */
    public class a implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zsa a;

        public a(zsa zsaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zsaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zsaVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (i == 4 && this.a.u.isShowing()) {
                    zsa zsaVar = this.a;
                    yb.d(zsaVar.u, zsaVar.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zsa a;

        public b(zsa zsaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zsaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zsaVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.u.isShowing()) {
                    zsa zsaVar = this.a;
                    yb.d(zsaVar.u, zsaVar.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zsa a;

        public c(zsa zsaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zsaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zsaVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B = false;
            }
        }
    }

    public zsa(ForumListActivity forumListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = false;
        this.C = 0;
        this.a = (LinearLayout) forumListActivity.findViewById(R.id.obfuscated_res_0x7f090c51);
        ViewPager viewPager = (ViewPager) forumListActivity.findViewById(R.id.obfuscated_res_0x7f092a64);
        this.d = viewPager;
        viewPager.setOnPageChangeListener(forumListActivity);
        this.e = (LinearLayout) forumListActivity.findViewById(R.id.obfuscated_res_0x7f092477);
        NavigationBar navigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LinearLayout linearLayout = (LinearLayout) this.f.setTitleView(R.layout.obfuscated_res_0x7f0d0723, null);
        this.z = linearLayout;
        this.g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0926b2);
        this.h = (ImageView) this.z.findViewById(R.id.obfuscated_res_0x7f090c54);
        TextView textView = (TextView) forumListActivity.findViewById(R.id.obfuscated_res_0x7f092476);
        this.k = textView;
        textView.setOnClickListener(forumListActivity);
        TextView textView2 = (TextView) forumListActivity.findViewById(R.id.obfuscated_res_0x7f09246c);
        this.l = textView2;
        textView2.setOnClickListener(forumListActivity);
        this.s = new q55(forumListActivity.getPageContext());
        this.t = new q55(forumListActivity.getPageContext());
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.m = linearLayout2;
        this.b = linearLayout2.findViewById(R.id.footer_background);
        this.n = (TextView) this.m.findViewById(R.id.footer_text);
        this.o = (ImageView) this.m.findViewById(R.id.footer_icon);
        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.p = linearLayout3;
        this.c = linearLayout3.findViewById(R.id.footer_background);
        this.q = (TextView) this.p.findViewById(R.id.footer_text);
        this.r = (ImageView) this.p.findViewById(R.id.footer_icon);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091702);
        this.B = false;
        this.w = forumListActivity;
        this.y = new xsa(this.w.getPageContext().getContext());
    }

    public View b(int i, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, onItemClickListener)) == null) {
            View inflate = LayoutInflater.from(this.w.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0315, (ViewGroup) null);
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090916);
            this.x = listView;
            listView.setOnItemClickListener(onItemClickListener);
            inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
            this.C = this.y.getCount();
            this.x.setAdapter((ListAdapter) this.y);
            return inflate;
        }
        return (View) invokeIL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setVisibility(8);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setVisibility(4);
            this.z.setClickable(false);
            this.z.setOnClickListener(null);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.setVisibility(0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.setVisibility(0);
        }
    }

    public void d() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ProgressBar progressBar = this.A;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ViewPager viewPager = this.d;
            if (viewPager == null) {
                return;
            }
            if (viewPager.getCurrentItem() == 0 && (bdListView = this.i) != null) {
                bdListView.z(0L);
                return;
            }
            BdListView bdListView2 = this.j;
            if (bdListView2 != null) {
                bdListView2.z(0L);
            }
        }
    }

    public void f(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onItemClickListener) == null) {
            if (!this.B) {
                this.B = true;
                if (this.v == null) {
                    this.v = b(0, onItemClickListener);
                }
                int dip2px = (BdUtilHelper.dip2px(this.w.getPageContext().getPageActivity(), 160.0f) - this.z.getWidth()) / 2;
                if (this.u == null) {
                    PopupWindow popupWindow = new PopupWindow(this.v, BdUtilHelper.dip2px(this.w.getPageContext().getPageActivity(), 160.0f), -2, true);
                    this.u = popupWindow;
                    popupWindow.setBackgroundDrawable(new ColorDrawable(17170445));
                    if (this.C > 6) {
                        this.u.setHeight(BdUtilHelper.dip2px(this.w.getPageContext().getPageActivity(), 272.0f));
                    }
                }
                this.u.setOutsideTouchable(true);
                this.u.setFocusable(true);
                GreyUtil.grey(this.u);
                this.v.setFocusable(true);
                this.v.setFocusableInTouchMode(true);
                yb.l(this.u, this.z, 0 - dip2px, BdUtilHelper.dip2px(this.w.getPageContext().getPageActivity(), 0.0f));
                this.v.setOnKeyListener(new a(this));
                this.v.setOnTouchListener(new b(this));
                this.u.setOnDismissListener(new c(this));
                return;
            }
            yb.d(this.u, this.w.getPageContext().getPageActivity());
            this.B = false;
        }
    }
}
