package com.baidu.tieba.personExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes8.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b fvL;
    private ImageView hSM;
    private TextView kUS;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private View mtD;
    private BdSwitchView mtE;
    private RelativeLayout mtF;
    private TextView mtG;
    private TextView mtH;
    private TextView mtI;
    private TextView mtJ;
    private TextView mtK;
    private int mtL;
    private BdSwitchView.a mtM = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.mtL = 2;
            } else {
                PersonConstellationActivity.this.mtL = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.mtD) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hSM) {
                if (view == PersonConstellationActivity.this.mtF) {
                    PersonConstellationActivity.this.dzs();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e mtN = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.mtG.setText(at.p(date));
                PersonConstellationActivity.this.mtH.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.mtE.getVisibility() != 0) {
                    PersonConstellationActivity.this.mtI.setVisibility(8);
                    PersonConstellationActivity.this.mtE.setVisibility(0);
                    if (PersonConstellationActivity.this.mtL == 1) {
                        PersonConstellationActivity.this.mtE.turnOn();
                    } else {
                        PersonConstellationActivity.this.mtE.turnOff();
                    }
                }
            }
        }
    };

    public static void a(Activity activity, long j, int i) {
        if (activity != null) {
            Intent intent = new Intent();
            intent.setClass(activity, PersonConstellationActivity.class);
            intent.putExtra("constellation_birthday", j);
            intent.putExtra("constellation_show_status", i);
            activity.startActivityForResult(intent, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_constellation_layout);
        initData();
        this.mRootView = (RelativeLayout) findViewById(R.id.person_constellation_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.person_constellation_title)).setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.mtD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kUS = (TextView) this.mtD.findViewById(R.id.right_textview);
        this.kUS.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kUS.setText(getPageContext().getString(R.string.person_constellation_complete));
        ao.setViewTextColor(this.kUS, R.color.navi_op_text, 1);
        this.mtD.setOnClickListener(this.mClickListener);
        this.hSM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hSM.setOnClickListener(this.mClickListener);
        ao.setImageResource(this.hSM, R.drawable.selector_topbar_return_black);
        this.mtE = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.mtE.setOnSwitchStateChangeListener(this.mtM);
        l.addToParentArea(getPageContext().getPageActivity(), this.mtE, 10, 10, 10, 10);
        this.mtF = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.mtF.setOnClickListener(this.mClickListener);
        this.mtG = (TextView) findViewById(R.id.constellation_name);
        this.mtH = (TextView) findViewById(R.id.constellation_birthday);
        this.mtJ = (TextView) findViewById(R.id.birthday_label);
        this.mtK = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.mtI = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.mtI.setVisibility(0);
            this.mtE.setVisibility(8);
            return;
        }
        this.mtI.setVisibility(8);
        this.mtE.setVisibility(0);
        if (this.mtL == 1) {
            this.mtE.turnOnNoCallback();
        } else {
            this.mtE.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.mtG.setText(at.p(date));
        this.mtH.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.mtL = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.mtL);
        setResult(-1, intent);
        finish();
    }

    public void dzs() {
        if (this.fvL == null) {
            this.fvL = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.mtN).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bM(View view) {
                    ao.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fvL != null) {
                                PersonConstellationActivity.this.fvL.dismiss();
                            }
                        }
                    });
                    ao.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ao.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fvL != null) {
                                PersonConstellationActivity.this.fvL.bMf();
                                PersonConstellationActivity.this.fvL.dismiss();
                            }
                        }
                    });
                }
            }).tU(18).a(new boolean[]{true, true, true, false, false, false}).d("年", "月", "日", "时", "分", "秒").au(2.0f).g(0, 0, 0, 0, 0, 0).lO(false).tV(ao.getColor(R.color.CAM_X0206)).tX(ao.getColor(R.color.CAM_X0105)).tY(ao.getColor(R.color.CAM_X0109)).tW(ao.getColor(R.color.black_alpha30)).tT(ao.getColor(R.color.CAM_X0201)).lN(false).N(this.mRootView).bLX();
        }
        this.fvL.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mtE.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setViewTextColor(this.mtJ, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mtK, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mtG, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.mtH, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.mtI, R.color.CAM_X0109, 1, i);
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
    }
}
