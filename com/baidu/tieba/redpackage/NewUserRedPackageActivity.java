package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes16.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    private s dQf;
    private ImageView fmw;
    private RoundRelativeLayout lLd;
    private ImageView lLe;
    private TextView lLf;
    private TextView lLg;
    private TextView lLh;
    private NewUserRedPackageData lLi;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.fmw.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.lLh.getId()) {
                    TiebaStatic.log(new aq("c13684").ai("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.lLi != null) {
                            be.bju().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.lLi.clickUrl});
                            NewUserRedPackageActivity.this.finish();
                            return;
                        }
                        return;
                    }
                    NewUserRedPackageActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewUserRedPackageActivity.this.getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13684").ai("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.lLd = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.lLd.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.lLe = (ImageView) findViewById(R.id.top_pic);
        this.fmw = (ImageView) findViewById(R.id.img_close);
        this.fmw.setOnClickListener(this.mOnClickListener);
        this.lLf = (TextView) findViewById(R.id.money_count);
        this.lLg = (TextView) findViewById(R.id.money_info);
        this.lLh = (TextView) findViewById(R.id.btn_receive);
        this.lLh.setOnClickListener(this.mOnClickListener);
        setData();
        TiebaStatic.log(new aq("c13684").ai("obj_type", 1));
        this.dQf = new s();
    }

    private void setData() {
        if (getIntent() != null) {
            this.lLi = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.lLi != null) {
                a aVar = (a) c.mM().loadResourceFromMemery(this.lLi.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.lLe.setImageBitmap(aVar.getRawBitmap());
                }
                this.lLf.setText(String.format(getString(R.string.new_user_red_package_money_count), this.lLi.money));
                this.lLg.setText(getString(R.string.new_user_red_package_money_info));
                this.lLh.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.lLd, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.lLf, R.color.cp_cont_b);
        ap.setViewTextColor(this.lLg, R.color.cp_cont_b);
        ap.setViewTextColor(this.lLh, R.color.cp_link_tip_a);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25046 && this.lLi != null) {
            this.dQf.aZr();
            be.bju().b(getPageContext(), new String[]{this.lLi.clickUrl});
            finish();
        }
    }
}
