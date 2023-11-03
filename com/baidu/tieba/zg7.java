package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.PrivateForumInfo;
/* loaded from: classes9.dex */
public final class zg7 extends og7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final sk7 c;
    public NavigationBar d;
    public ImageView e;
    public View f;
    public BarImageView g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public cq6 k;
    public pjc l;
    public TextView m;

    public zg7(FragmentActivity activity, sk7 navBarStat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, navBarStat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(navBarStat, "navBarStat");
        this.b = activity;
        this.c = navBarStat;
    }

    public static final Pair A(NewsRemindMessage newsRemindMessage, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, newsRemindMessage, bool)) == null) {
            return Pair.create(newsRemindMessage, bool);
        }
        return (Pair) invokeLL.objValue;
    }

    public static final NewsRemindMessage B(Pair pair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pair)) == null) {
            return (NewsRemindMessage) pair.first;
        }
        return (NewsRemindMessage) invokeL.objValue;
    }

    public static final Boolean z(NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, newsRemindMessage)) == null) {
            if (newsRemindMessage != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public static final void C(zg7 this$0, NewsRemindMessage newsRemindMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, newsRemindMessage) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
            if (!newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            if (TbadkCoreApplication.isLogin()) {
                cq6 cq6Var = this$0.k;
                if (cq6Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                    cq6Var = null;
                }
                cq6Var.g(z, msgCount);
            }
        }
    }

    public static final void t(zg7 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (ViewHelper.checkUpIsLogin(this$0.b)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this$0.b)));
                cq6 cq6Var = this$0.k;
                cq6 cq6Var2 = null;
                if (cq6Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                    cq6Var = null;
                }
                cq6Var.e();
                sk7 sk7Var = this$0.c;
                cq6 cq6Var3 = this$0.k;
                if (cq6Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                } else {
                    cq6Var2 = cq6Var3;
                }
                sk7Var.a(cq6Var2.a());
            }
        }
    }

    public static final void u(zg7 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewModel viewModel = new ViewModelProvider(this$0.b).get(ForumViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
            hh7 value = ((ForumViewModel) viewModel).a().getValue();
            if (value != null) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).shareForum(this$0.b, value.a());
            }
            this$0.c.b();
        }
    }

    public static final void r(zg7 this$0, gh7 forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, forumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            sb.append(UtilHelper.getFixedBarText(forumData.e(), 7, true, false));
            sb.append((char) 21543);
            String sb2 = sb.toString();
            TextView textView = this$0.h;
            NavigationBar navigationBar = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
                textView = null;
            }
            textView.setText(sb2);
            BarImageView barImageView = this$0.g;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                barImageView = null;
            }
            barImageView.startLoad(forumData.c(), 45, false);
            String l = forumData.l();
            if (l.length() != 0) {
                z = false;
            }
            if (z) {
                l = "#142354";
            }
            NavigationBar navigationBar2 = this$0.d;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            } else {
                navigationBar = navigationBar2;
            }
            navigationBar.getBarBgView().setBackgroundColor(aqa.f(l));
            Intrinsics.checkNotNullExpressionValue(forumData, "forumData");
            this$0.q(forumData);
        }
    }

    public static final void s(zg7 this$0, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewModel viewModel = new ViewModelProvider(this$0.b).get(ForumViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
            ForumViewModel forumViewModel = (ForumViewModel) viewModel;
            MessageManager messageManager = MessageManager.getInstance();
            FragmentActivity fragmentActivity = this$0.b;
            gh7 value = forumViewModel.c().getValue();
            Long l = null;
            if (value != null) {
                str = value.e();
            } else {
                str = null;
            }
            gh7 value2 = forumViewModel.c().getValue();
            if (value2 != null) {
                l = Long.valueOf(value2.d());
            }
            messageManager.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(fragmentActivity, str, String.valueOf(l))));
            this$0.c.d();
        }
    }

    public static final void x(zg7 this$0, String urlStr, gh7 forumData, int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{this$0, urlStr, forumData, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(urlStr, "$urlStr");
            Intrinsics.checkNotNullParameter(forumData, "$forumData");
            this$0.c.c(urlStr, forumData.d(), forumData.e(), i);
            UrlManager.getInstance().dealOneLink(new String[]{urlStr});
        }
    }

    @Override // com.baidu.tieba.og7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.i(i);
            SvgManager svgManager = SvgManager.getInstance();
            ImageView imageView = this.e;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TaskUIData.keyBackBtn);
                imageView = null;
            }
            svgManager.setPureDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            TextView textView2 = this.h;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
                textView2 = null;
            }
            EMManager.from(textView2).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02);
            SvgManager svgManager2 = SvgManager.getInstance();
            ImageView imageView2 = this.j;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
                imageView2 = null;
            }
            svgManager2.setPureDrawableWithDayNightModeAutoChange(imageView2, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            cq6 cq6Var = this.k;
            if (cq6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                cq6Var = null;
            }
            cq6Var.f(i);
            cq6 cq6Var2 = this.k;
            if (cq6Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                cq6Var2 = null;
            }
            cq6Var2.c().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            SvgManager svgManager3 = SvgManager.getInstance();
            ImageView imageView3 = this.i;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
                imageView3 = null;
            }
            svgManager3.setPureDrawableWithDayNightModeAutoChange(imageView3, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = BdUtilHelper.getDimens(this.b, R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            TextView textView3 = this.m;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                textView3 = null;
            }
            textView3.setCompoundDrawables(null, null, drawable, null);
            TextView textView4 = this.m;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
            } else {
                textView = textView4;
            }
            EMManager.from(textView).setCorner(R.string.J_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.white_alpha100).setBackGroundColor(R.color.black_alpha20);
        }
    }

    public final void w(final gh7 gh7Var) {
        Integer num;
        int intValue;
        boolean z;
        final String format;
        Integer b;
        PrivateForumInfo a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gh7Var) == null) {
            nh7 i = gh7Var.i();
            TextView textView = null;
            if (i != null && (a = i.a()) != null) {
                num = a.private_forum_audit_status;
            } else {
                num = null;
            }
            int i2 = -1;
            if (num == null) {
                intValue = -1;
            } else {
                intValue = num.intValue();
            }
            nh7 i3 = gh7Var.i();
            if (i3 != null && (b = i3.b()) != null) {
                i2 = b.intValue();
            }
            final int i4 = 2;
            if (intValue == 2) {
                TextView textView2 = this.m;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    textView2 = null;
                }
                textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f118e));
                TextView textView3 = this.m;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format(ph7.b(), Arrays.copyOf(new Object[]{Long.valueOf(gh7Var.d())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                if (i2 >= 0 && i2 < 101) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    TextView textView4 = this.m;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                        textView4 = null;
                    }
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string = this.b.getString(R.string.obfuscated_res_0x7f0f118f);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…atus_check_task_progress)");
                    String format2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    textView4.setText(format2);
                    TextView textView5 = this.m;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                        textView5 = null;
                    }
                    textView5.setVisibility(0);
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    format = String.format(ph7.a(), Arrays.copyOf(new Object[]{Long.valueOf(gh7Var.d()), gh7Var.e()}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    i4 = 1;
                } else {
                    TextView textView6 = this.m;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    } else {
                        textView = textView6;
                    }
                    textView.setVisibility(8);
                    return;
                }
            }
            TextView textView7 = this.m;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
            } else {
                textView = textView7;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        zg7.x(zg7.this, format, gh7Var, i4, view2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.og7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            NavigationBar navigationBar = binding.p;
            Intrinsics.checkNotNullExpressionValue(navigationBar, "binding.navBar");
            this.d = navigationBar;
            NavigationBar navigationBar2 = null;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar = null;
            }
            View findViewById = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
            Intrinsics.checkNotNullExpressionValue(findViewById, "backBtnLayout.findViewBy….widget_navi_back_button)");
            this.e = (ImageView) findViewById;
            NavigationBar navigationBar3 = this.d;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar3 = null;
            }
            View addCustomView = navigationBar3.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0317, (View.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(addCustomView, "navigationBar.addCustomV…fo_layout, null\n        )");
            this.f = addCustomView;
            NavigationBar navigationBar4 = this.d;
            if (navigationBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar4 = null;
            }
            View addCustomView2 = navigationBar4.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d03b1, (View.OnClickListener) null);
            if (addCustomView2 != null) {
                TextView textView = (TextView) addCustomView2;
                this.m = textView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    textView = null;
                }
                textView.setVisibility(8);
                View view2 = this.f;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumInfoLayout");
                    view2 = null;
                }
                View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f091133);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "forumInfoLayout.findViewById(R.id.img_forum_icon)");
                BarImageView barImageView = (BarImageView) findViewById2;
                this.g = barImageView;
                if (barImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView = null;
                }
                barImageView.setShowOval(true);
                BarImageView barImageView2 = this.g;
                if (barImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView2 = null;
                }
                barImageView2.setAutoChangeStyle(true);
                BarImageView barImageView3 = this.g;
                if (barImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView3 = null;
                }
                barImageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                BarImageView barImageView4 = this.g;
                if (barImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView4 = null;
                }
                barImageView4.setPlaceHolder(1);
                View view3 = this.f;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumInfoLayout");
                    view3 = null;
                }
                View findViewById3 = view3.findViewById(R.id.obfuscated_res_0x7f092514);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "forumInfoLayout.findViewById(R.id.text_forum_name)");
                this.h = (TextView) findViewById3;
                ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().observe(this.b, new Observer() { // from class: com.baidu.tieba.yf7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            zg7.r(zg7.this, (gh7) obj);
                        }
                    }
                });
                v(0.0f);
                NavigationBar navigationBar5 = this.d;
                if (navigationBar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                    navigationBar5 = null;
                }
                View addCustomView3 = navigationBar5.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0319, new View.OnClickListener() { // from class: com.baidu.tieba.ig7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                            zg7.s(zg7.this, view4);
                        }
                    }
                });
                if (addCustomView3 != null) {
                    this.i = (ImageView) addCustomView3;
                    this.k = new cq6(this.b);
                    NavigationBar navigationBar6 = this.d;
                    if (navigationBar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                        navigationBar6 = null;
                    }
                    NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
                    cq6 cq6Var = this.k;
                    if (cq6Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                        cq6Var = null;
                    }
                    navigationBar6.addCustomView(controlAlign, cq6Var.d(), new View.OnClickListener() { // from class: com.baidu.tieba.ef7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                                zg7.t(zg7.this, view4);
                            }
                        }
                    });
                    NavigationBar navigationBar7 = this.d;
                    if (navigationBar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                        navigationBar7 = null;
                    }
                    View addCustomView4 = navigationBar7.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d031a, new View.OnClickListener() { // from class: com.baidu.tieba.of7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                                zg7.u(zg7.this, view4);
                            }
                        }
                    });
                    if (addCustomView4 != null) {
                        this.j = (ImageView) addCustomView4;
                        y();
                        cq6 cq6Var2 = this.k;
                        if (cq6Var2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                            cq6Var2 = null;
                        }
                        NavigationBar navigationBar8 = this.d;
                        if (navigationBar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                        } else {
                            navigationBar2 = navigationBar8;
                        }
                        cq6Var2.l(navigationBar2, true);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    @Override // com.baidu.tieba.og7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.l();
            pjc pjcVar = this.l;
            if (pjcVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSubscription");
                pjcVar = null;
            }
            pjcVar.unsubscribe();
        }
    }

    public final boolean o(gh7 gh7Var) {
        InterceptResult invokeL;
        PrivateForumInfo privateForumInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gh7Var)) == null) {
            nh7 i = gh7Var.i();
            if (i != null) {
                privateForumInfo = i.a();
            } else {
                privateForumInfo = null;
            }
            if (privateForumInfo != null) {
                UserData o = gh7Var.o();
                if (o != null && o.getIs_manager() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void q(gh7 gh7Var) {
        PrivateForumInfo a;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gh7Var) == null) {
            if (!o(gh7Var)) {
                nh7 i = gh7Var.i();
                boolean z = true;
                if ((i == null || (a = i.a()) == null || (num = a.private_forum_status) == null || num.intValue() != 1) ? false : false) {
                    w(gh7Var);
                    return;
                }
            }
            TextView textView = this.m;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                textView = null;
            }
            textView.setVisibility(8);
        }
    }

    public final void v(float f) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            View view2 = this.f;
            TextView textView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumInfoLayout");
                view2 = null;
            }
            view2.setAlpha(f);
            NavigationBar navigationBar = this.d;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar = null;
            }
            navigationBar.getBarBgView().setAlpha(f);
            TextView textView2 = this.m;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
            } else {
                textView = textView2;
            }
            float f2 = 0.0f;
            if (f == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                f2 = 1.0f;
            }
            textView.setAlpha(f2);
        }
    }

    public final void y() {
        v95 v95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (v95Var = (v95) ServiceManager.getService(v95.a)) != null) {
            pjc H = ijc.c(v95Var.g().k(new bkc() { // from class: com.baidu.tieba.kg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.bkc
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? zg7.z((NewsRemindMessage) obj) : invokeL.objValue;
                }
            }), v95Var.c(), new ckc() { // from class: com.baidu.tieba.vf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ckc
                public final Object a(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? zg7.A((NewsRemindMessage) obj, (Boolean) obj2) : invokeLL.objValue;
                }
            }).p(new bkc() { // from class: com.baidu.tieba.if7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.bkc
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? zg7.B((Pair) obj) : invokeL.objValue;
                }
            }).H(new wjc() { // from class: com.baidu.tieba.wf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.wjc
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        zg7.C(zg7.this, (NewsRemindMessage) obj);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(H, "combineLatest<NewsRemind…  }\n                    }");
            this.l = H;
        }
    }
}
