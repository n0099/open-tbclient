package com.baidu.tieba.personExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.b1.o.a.d.e;
import java.util.Date;
/* loaded from: classes3.dex */
public class PersonConstellationActivity extends BaseActivity {
    public static final String ACTIVITY_INTENT_BIRTHDAY = "constellation_birthday";
    public static final String ACTIVITY_INTENT_SHOW_STATUS = "constellation_show_status";
    public static final int START_ACTIVITY_REQUEST_CODE = 1001;
    public ImageView mBackImg;
    public TextView mBirthdayLabel;
    public RelativeLayout mBirthdayLayout;
    public long mBirthdayTime;
    public TextView mBirthdayView;
    public View mCompleteLayout;
    public TextView mCompleteView;
    public TextView mConsNameView;
    public NavigationBar mNavigationBar;
    public RelativeLayout mRootView;
    public int mShowStatus;
    public TextView mShowStatusLabel;
    public TextView mShowStatusTipView;
    public BdSwitchView mSwitchView;
    public d.b.i0.b1.o.a.f.b mTimePickerView;
    public BdSwitchView.b mSwitchChangeListener = new a();
    public View.OnClickListener mClickListener = new b();
    public e mTimeSelectListener = new d();

    /* loaded from: classes3.dex */
    public class a implements BdSwitchView.b {
        public a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.mShowStatus = 2;
            } else {
                PersonConstellationActivity.this.mShowStatus = 1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.mCompleteLayout) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.mBackImg) {
                if (view == PersonConstellationActivity.this.mBirthdayLayout) {
                    PersonConstellationActivity.this.showTimePicker();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.i0.b1.o.a.d.a {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonConstellationActivity.this.mTimePickerView != null) {
                    PersonConstellationActivity.this.mTimePickerView.f();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonConstellationActivity.this.mTimePickerView != null) {
                    PersonConstellationActivity.this.mTimePickerView.E();
                    PersonConstellationActivity.this.mTimePickerView.f();
                }
            }
        }

        public c() {
        }

        @Override // d.b.i0.b1.o.a.d.a
        public void a(View view) {
            SkinManager.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
            TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
            textView.setOnClickListener(new a());
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
            TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
            textView2.setOnClickListener(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements e {
        public d() {
        }

        @Override // d.b.i0.b1.o.a.d.e
        public void a(Date date, View view) {
            if (date == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                return;
            }
            PersonConstellationActivity.this.mConsNameView.setText(StringHelper.dateToConstellation(date));
            PersonConstellationActivity.this.mBirthdayView.setText(StringHelper.getDateStringYearMonthDay(date));
            PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
            if (PersonConstellationActivity.this.mSwitchView.getVisibility() != 0) {
                PersonConstellationActivity.this.mShowStatusTipView.setVisibility(8);
                PersonConstellationActivity.this.mSwitchView.setVisibility(0);
                if (PersonConstellationActivity.this.mShowStatus == 1) {
                    PersonConstellationActivity.this.mSwitchView.i();
                } else {
                    PersonConstellationActivity.this.mSwitchView.f();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra(ACTIVITY_INTENT_BIRTHDAY, this.mBirthdayTime);
        intent.putExtra(ACTIVITY_INTENT_SHOW_STATUS, this.mShowStatus);
        setResult(-1, intent);
        finish();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra(ACTIVITY_INTENT_BIRTHDAY, 0L);
            this.mShowStatus = intent.getIntExtra(ACTIVITY_INTENT_SHOW_STATUS, 1);
        }
    }

    public static void startPersonConstellationActivity(Activity activity, long j, int i) {
        if (activity == null) {
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
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mSwitchView.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        SkinManager.setViewTextColor(this.mBirthdayLabel, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.mShowStatusLabel, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.mConsNameView, R.color.CAM_X0109, 1, i);
        SkinManager.setViewTextColor(this.mBirthdayView, R.color.CAM_X0109, 1, i);
        SkinManager.setViewTextColor(this.mShowStatusTipView, R.color.CAM_X0109, 1, i);
        SkinManager.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
            this.mSwitchView.k();
        } else {
            this.mSwitchView.h();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.mConsNameView.setText(StringHelper.dateToConstellation(date));
        this.mBirthdayView.setText(StringHelper.getDateStringYearMonthDay(date));
    }

    public void showTimePicker() {
        if (this.mTimePickerView == null) {
            d.b.i0.b1.o.a.b.a aVar = new d.b.i0.b1.o.a.b.a(getActivity(), this.mTimeSelectListener);
            aVar.k(R.layout.person_birthday_select_layout, new c());
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
        this.mTimePickerView.w();
    }
}
