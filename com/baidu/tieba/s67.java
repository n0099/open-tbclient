package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes7.dex */
public class s67 extends e9<TbTitleActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbTitleActivity a;
    public RelativeLayout b;
    public NoNetworkView c;
    public NavigationBar d;
    public ScrollView e;
    public LinearLayout f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public View l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public RelativeLayout s;
    public View.OnClickListener t;
    public List<LevelInfo> u;
    public DataRes v;
    public b w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s67 a;

        public a(s67 s67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getPageContext().getContext()).createNormalCfg(this.a.getPageContext().getString(R.string.tieba_text), "from")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;

        public b(s67 s67Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s67Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onClick(view2);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s67(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbTitleActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((g9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new b(this, new a(this));
        this.a = tbTitleActivity;
        this.t = onClickListener;
        C();
    }

    public void G(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && bVar != null) {
            this.c.a(bVar);
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.e.setVisibility(8);
            this.a.showNetRefreshView(this.b, str, true);
            this.a.setNetRefreshViewTopMargin(400);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setVisibility(0);
            this.a.hideNetRefreshView(this.b);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j.setOnClickListener(this.t);
            this.i.setOnClickListener(this.t);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.setVisibility(8);
            this.a.showLoadingView(this.b, true);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.setVisibility(0);
            this.a.hideLoadingView(this.b);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String string = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f1585);
            String string2 = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f1586);
            int length = string2.length();
            int indexOf = string.indexOf(string2);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(this.w, indexOf, length + indexOf, 33);
            this.i.setText(spannableString);
            this.i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d091a, (ViewGroup) null);
            this.b = relativeLayout;
            this.a.setContentView(relativeLayout);
            this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092881);
            this.n = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d3f);
            this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a7c);
            this.p = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b9c);
            this.q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09246c);
            this.r = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0928df);
            this.s = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092878);
            this.l = this.b.findViewById(R.id.obfuscated_res_0x7f09251d);
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + ri.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07036f);
            } else {
                this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + ri.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07040f);
            }
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
            this.d = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1588));
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.showBottomLine();
            this.e = (ScrollView) this.b.findViewById(R.id.obfuscated_res_0x7f092356);
            this.k = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090af1);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092355);
            this.f = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09227b);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092731);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090edc);
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092357);
            this.c = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
            B();
            F();
        }
    }

    public void D(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i);
            }
            NoNetworkView noNetworkView = this.c;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), i);
            }
            y(this.u);
            x(this.v);
            hx4 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (!z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams.height = UtilHelper.getLightStatusBarHeight() + ri.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07036f);
                this.l.setLayoutParams(layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.height = UtilHelper.getLightStatusBarHeight() + ri.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07040f);
            this.l.setLayoutParams(layoutParams2);
        }
    }

    public void x(DataRes dataRes) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) {
            this.v = dataRes;
            if (dataRes == null) {
                return;
            }
            if (dataRes.is_like.intValue() == 1 && (linearLayout = this.k) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.g != null) {
                if (StringUtils.isNull(this.v.level_name, true)) {
                    this.g.setText(this.v.level_name);
                } else {
                    this.g.setVisibility(8);
                }
            }
            if (this.h != null) {
                if (this.v.user_level.intValue() > 0 && this.v.user_level.intValue() <= 18) {
                    SkinManager.setImageResource(this.h, BitmapHelper.getGradeResourceIdNew(this.v.user_level.intValue()));
                } else {
                    this.h.setVisibility(8);
                }
            }
        }
    }

    public void y(List<LevelInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.u = list;
            if (this.f != null && list != null && list.size() != 0) {
                this.f.removeAllViews();
                for (int i = 1; i <= list.size(); i++) {
                    LevelInfo levelInfo = list.get(i - 1);
                    View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d091b, (ViewGroup) null);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09227c);
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09227e);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09227f);
                    View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f092354);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09227d);
                    if (i % 2 != 0) {
                        SkinManager.setBackgroundResource(linearLayout, R.color.CAM_X0205);
                    }
                    SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
                    SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(this.q, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
                    SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                    textView.setText(levelInfo.name);
                    if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                        textView2.setText(levelInfo.score + "");
                    } else if (levelInfo.score.intValue() <= 0) {
                        textView2.setText("0");
                    } else {
                        textView2.setText("3000000");
                    }
                    this.f.addView(inflate);
                }
            }
        }
    }
}
