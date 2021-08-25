package com.baidu.tieba.personExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.d1.p.a.d.f;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes7.dex */
public class PersonConstellationActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_INTENT_BIRTHDAY = "constellation_birthday";
    public static final String ACTIVITY_INTENT_SHOW_STATUS = "constellation_show_status";
    public static final int START_ACTIVITY_REQUEST_CODE = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mBackImg;
    public TextView mBirthdayLabel;
    public RelativeLayout mBirthdayLayout;
    public long mBirthdayTime;
    public TextView mBirthdayView;
    public View.OnClickListener mClickListener;
    public View mCompleteLayout;
    public TextView mCompleteView;
    public TextView mConsNameView;
    public NavigationBar mNavigationBar;
    public RelativeLayout mRootView;
    public int mShowStatus;
    public TextView mShowStatusLabel;
    public TextView mShowStatusTipView;
    public BdSwitchView.b mSwitchChangeListener;
    public BdSwitchView mSwitchView;
    public c.a.p0.d1.p.a.f.b mTimePickerView;
    public f mTimeSelectListener;

    /* loaded from: classes7.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonConstellationActivity f55767e;

        public a(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55767e = personConstellationActivity;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (switchState == BdSwitchView.SwitchState.OFF) {
                    this.f55767e.mShowStatus = 2;
                } else {
                    this.f55767e.mShowStatus = 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonConstellationActivity f55768e;

        public b(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55768e = personConstellationActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f55768e.mCompleteLayout) {
                    this.f55768e.finishActivity();
                } else if (view != this.f55768e.mBackImg) {
                    if (view == this.f55768e.mBirthdayLayout) {
                        this.f55768e.showTimePicker();
                    }
                } else {
                    this.f55768e.finish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.p0.d1.p.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonConstellationActivity f55769a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f55770e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55770e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55770e.f55769a.mTimePickerView == null) {
                    return;
                }
                this.f55770e.f55769a.mTimePickerView.f();
            }
        }

        /* loaded from: classes7.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f55771e;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55771e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55771e.f55769a.mTimePickerView == null) {
                    return;
                }
                this.f55771e.f55769a.mTimePickerView.A();
                this.f55771e.f55769a.mTimePickerView.f();
            }
        }

        public c(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55769a = personConstellationActivity;
        }

        @Override // c.a.p0.d1.p.a.d.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SkinManager.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                textView.setOnClickListener(new a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonConstellationActivity f55772a;

        public d(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55772a = personConstellationActivity;
        }

        @Override // c.a.p0.d1.p.a.d.f
        public void a(Date date, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view) == null) || date == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                this.f55772a.showToast(R.string.person_center_birthday_time_limit);
                return;
            }
            this.f55772a.mConsNameView.setText(StringHelper.dateToConstellation(date));
            this.f55772a.mBirthdayView.setText(StringHelper.getDateStringYearMonthDay(date));
            this.f55772a.mBirthdayTime = date.getTime() / 1000;
            if (this.f55772a.mSwitchView.getVisibility() != 0) {
                this.f55772a.mShowStatusTipView.setVisibility(8);
                this.f55772a.mSwitchView.setVisibility(0);
                if (this.f55772a.mShowStatus == 1) {
                    this.f55772a.mSwitchView.turnOn();
                } else {
                    this.f55772a.mSwitchView.turnOff();
                }
            }
        }
    }

    public PersonConstellationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSwitchChangeListener = new a(this);
        this.mClickListener = new b(this);
        this.mTimeSelectListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            Intent intent = new Intent();
            intent.putExtra(ACTIVITY_INTENT_BIRTHDAY, this.mBirthdayTime);
            intent.putExtra(ACTIVITY_INTENT_SHOW_STATUS, this.mShowStatus);
            setResult(-1, intent);
            finish();
        }
    }

    private void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mBirthdayTime = intent.getLongExtra(ACTIVITY_INTENT_BIRTHDAY, 0L);
        this.mShowStatus = intent.getIntExtra(ACTIVITY_INTENT_SHOW_STATUS, 1);
    }

    public static void startPersonConstellationActivity(Activity activity, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{activity, Long.valueOf(j2), Integer.valueOf(i2)}) == null) || activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, PersonConstellationActivity.class);
        intent.putExtra(ACTIVITY_INTENT_BIRTHDAY, j2);
        intent.putExtra(ACTIVITY_INTENT_SHOW_STATUS, i2);
        activity.startActivityForResult(intent, 1001);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mSwitchView.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            SkinManager.setViewTextColor(this.mBirthdayLabel, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.mShowStatusLabel, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.mConsNameView, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.mBirthdayView, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.mShowStatusTipView, R.color.CAM_X0109, 1, i2);
            SkinManager.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.person_constellation_layout);
            initData();
            this.mRootView = (RelativeLayout) findViewById(R.id.person_constellation_root_view);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.person_constellation_title)).setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.mCompleteLayout = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.mCompleteView = textView;
            textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
            this.mCompleteView.setText(getPageContext().getString(R.string.person_constellation_complete));
            SkinManager.setViewTextColor(this.mCompleteView, R.color.navi_op_text, 1);
            this.mCompleteLayout.setOnClickListener(this.mClickListener);
            ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
            this.mBackImg = imageView;
            imageView.setOnClickListener(this.mClickListener);
            SkinManager.setImageResource(this.mBackImg, R.drawable.selector_topbar_return_black);
            BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.person_constellation_switch);
            this.mSwitchView = bdSwitchView;
            bdSwitchView.setOnSwitchStateChangeListener(this.mSwitchChangeListener);
            l.c(getPageContext().getPageActivity(), this.mSwitchView, 10, 10, 10, 10);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
            this.mBirthdayLayout = relativeLayout;
            relativeLayout.setOnClickListener(this.mClickListener);
            this.mConsNameView = (TextView) findViewById(R.id.constellation_name);
            this.mBirthdayView = (TextView) findViewById(R.id.constellation_birthday);
            this.mBirthdayLabel = (TextView) findViewById(R.id.birthday_label);
            this.mShowStatusLabel = (TextView) findViewById(R.id.person_constellation_permission_label);
            TextView textView2 = (TextView) findViewById(R.id.person_constellation_tip);
            this.mShowStatusTipView = textView2;
            if (this.mBirthdayTime == 0) {
                textView2.setVisibility(0);
                this.mSwitchView.setVisibility(8);
                return;
            }
            textView2.setVisibility(8);
            this.mSwitchView.setVisibility(0);
            if (this.mShowStatus == 1) {
                this.mSwitchView.turnOnNoCallback();
            } else {
                this.mSwitchView.turnOffNoCallback();
            }
            Date date = new Date(this.mBirthdayTime * 1000);
            this.mConsNameView.setText(StringHelper.dateToConstellation(date));
            this.mBirthdayView.setText(StringHelper.getDateStringYearMonthDay(date));
        }
    }

    public void showTimePicker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mTimePickerView == null) {
                c.a.p0.d1.p.a.b.a aVar = new c.a.p0.d1.p.a.b.a(getActivity(), this.mTimeSelectListener);
                aVar.k(R.layout.person_birthday_select_layout, new c(this));
                aVar.f(18);
                aVar.p(new boolean[]{true, true, true, false, false, false});
                aVar.j("年", "月", "日", "时", "分", "秒");
                aVar.l(2.0f);
                aVar.o(0, 0, 0, 0, 0, 0);
                aVar.b(false);
                aVar.i(SkinManager.getColor(R.color.CAM_X0206));
                aVar.m(SkinManager.getColor(R.color.CAM_X0105));
                aVar.n(SkinManager.getColor(R.color.CAM_X0109));
                aVar.d(SkinManager.getColor(R.color.black_alpha30));
                aVar.e(SkinManager.getColor(R.color.CAM_X0201));
                aVar.c(false);
                aVar.h(this.mRootView);
                this.mTimePickerView = aVar.a();
            }
            this.mTimePickerView.u();
        }
    }
}
