package com.baidu.tieba.personExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.repackage.cg5;
import com.repackage.oi;
import com.repackage.qf5;
import com.repackage.sf5;
import com.repackage.xf5;
import java.util.Date;
/* loaded from: classes3.dex */
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
    public cg5 mTimePickerView;
    public xf5 mTimeSelectListener;

    /* loaded from: classes3.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        public a(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                if (switchState == BdSwitchView.SwitchState.OFF) {
                    this.a.mShowStatus = 2;
                } else {
                    this.a.mShowStatus = 1;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        public b(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.mCompleteLayout) {
                    this.a.finishActivity();
                } else if (view2 != this.a.mBackImg) {
                    if (view2 == this.a.mBirthdayLayout) {
                        this.a.showTimePicker();
                    }
                } else {
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements sf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.mTimePickerView == null) {
                    return;
                }
                this.a.a.mTimePickerView.f();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.mTimePickerView == null) {
                    return;
                }
                this.a.a.mTimePickerView.B();
                this.a.a.mTimePickerView.f();
            }
        }

        public c(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // com.repackage.sf5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SkinManager.setBackgroundResource(view2, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917a7);
                textView.setOnClickListener(new a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917a6);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements xf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        public d(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // com.repackage.xf5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || date == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0de8);
                return;
            }
            this.a.mConsNameView.setText(StringHelper.dateToConstellation(date));
            this.a.mBirthdayView.setText(StringHelper.getDateStringYearMonthDay(date));
            this.a.mBirthdayTime = date.getTime() / 1000;
            if (this.a.mSwitchView.getVisibility() != 0) {
                this.a.mShowStatusTipView.setVisibility(8);
                this.a.mSwitchView.setVisibility(0);
                if (this.a.mShowStatus == 1) {
                    this.a.mSwitchView.j();
                } else {
                    this.a.mSwitchView.f();
                }
            }
        }
    }

    public PersonConstellationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static void startPersonConstellationActivity(Activity activity, long j, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{activity, Long.valueOf(j), Integer.valueOf(i)}) == null) || activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, PersonConstellationActivity.class);
        intent.putExtra(ACTIVITY_INTENT_BIRTHDAY, j);
        intent.putExtra(ACTIVITY_INTENT_SHOW_STATUS, i);
        activity.startActivityForResult(intent, 1001);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mSwitchView.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e5), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e4), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            SkinManager.setViewTextColor(this.mBirthdayLabel, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.mShowStatusLabel, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.mConsNameView, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.mBirthdayView, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.mShowStatusTipView, R.color.CAM_X0109, 1, i);
            SkinManager.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d06b9);
            initData();
            this.mRootView = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0917a9);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0e00)).setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e6, (View.OnClickListener) null);
            this.mCompleteLayout = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091aa9);
            this.mCompleteView = textView;
            textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
            this.mCompleteView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfc));
            SkinManager.setViewTextColor(this.mCompleteView, R.color.navi_op_text, 1);
            this.mCompleteLayout.setOnClickListener(this.mClickListener);
            ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d089e, (View.OnClickListener) null);
            this.mBackImg = imageView;
            imageView.setOnClickListener(this.mClickListener);
            SkinManager.setImageResource(this.mBackImg, R.drawable.selector_topbar_return_black);
            BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.obfuscated_res_0x7f0917aa);
            this.mSwitchView = bdSwitchView;
            bdSwitchView.setOnSwitchStateChangeListener(this.mSwitchChangeListener);
            oi.b(getPageContext().getPageActivity(), this.mSwitchView, 10, 10, 10, 10);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0917a5);
            this.mBirthdayLayout = relativeLayout;
            relativeLayout.setOnClickListener(this.mClickListener);
            this.mConsNameView = (TextView) findViewById(R.id.obfuscated_res_0x7f0906d0);
            this.mBirthdayView = (TextView) findViewById(R.id.obfuscated_res_0x7f0906ce);
            this.mBirthdayLabel = (TextView) findViewById(R.id.obfuscated_res_0x7f09037b);
            this.mShowStatusLabel = (TextView) findViewById(R.id.obfuscated_res_0x7f0917a8);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0917ab);
            this.mShowStatusTipView = textView2;
            if (this.mBirthdayTime == 0) {
                textView2.setVisibility(0);
                this.mSwitchView.setVisibility(8);
                return;
            }
            textView2.setVisibility(8);
            this.mSwitchView.setVisibility(0);
            if (this.mShowStatus == 1) {
                this.mSwitchView.l();
            } else {
                this.mSwitchView.i();
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
                qf5 qf5Var = new qf5(getActivity(), this.mTimeSelectListener);
                qf5Var.k(R.layout.obfuscated_res_0x7f0d06a9, new c(this));
                qf5Var.f(18);
                qf5Var.p(new boolean[]{true, true, true, false, false, false});
                qf5Var.j("年", "月", "日", "时", "分", "秒");
                qf5Var.l(2.0f);
                qf5Var.o(0, 0, 0, 0, 0, 0);
                qf5Var.b(false);
                qf5Var.i(SkinManager.getColor(R.color.CAM_X0206));
                qf5Var.m(SkinManager.getColor(R.color.CAM_X0105));
                qf5Var.n(SkinManager.getColor(R.color.CAM_X0109));
                qf5Var.d(SkinManager.getColor(R.color.black_alpha30));
                qf5Var.e(SkinManager.getColor(R.color.CAM_X0201));
                qf5Var.c(false);
                qf5Var.h(this.mRootView);
                this.mTimePickerView = qf5Var.a();
            }
            this.mTimePickerView.v();
        }
    }
}
