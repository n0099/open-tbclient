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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes9.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    private s dBc;
    private ImageView eVv;
    private RoundRelativeLayout lms;
    private ImageView lmt;
    private TextView lmu;
    private TextView lmv;
    private TextView lmw;
    private NewUserRedPackageData lmx;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.eVv.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.lmw.getId()) {
                    TiebaStatic.log(new ao("c13684").ag("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.lmx != null) {
                            bc.aWU().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.lmx.clickUrl});
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
            TiebaStatic.log(new ao("c13684").ag("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.lms = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.lms.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.lmt = (ImageView) findViewById(R.id.top_pic);
        this.eVv = (ImageView) findViewById(R.id.img_close);
        this.eVv.setOnClickListener(this.mOnClickListener);
        this.lmu = (TextView) findViewById(R.id.money_count);
        this.lmv = (TextView) findViewById(R.id.money_info);
        this.lmw = (TextView) findViewById(R.id.btn_receive);
        this.lmw.setOnClickListener(this.mOnClickListener);
        setData();
        TiebaStatic.log(new ao("c13684").ag("obj_type", 1));
        this.dBc = new s();
    }

    private void setData() {
        if (getIntent() != null) {
            this.lmx = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.lmx != null) {
                a aVar = (a) c.ln().loadResourceFromMemery(this.lmx.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.lmt.setImageBitmap(aVar.getRawBitmap());
                }
                this.lmu.setText(String.format(getString(R.string.new_user_red_package_money_count), this.lmx.money));
                this.lmv.setText(getString(R.string.new_user_red_package_money_info));
                this.lmw.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setBackgroundColor(this.lms, R.color.cp_bg_line_d);
        an.setViewTextColor(this.lmu, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.lmv, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.lmw, (int) R.color.cp_link_tip_a);
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
        if (i == 25046 && this.lmx != null) {
            this.dBc.aNn();
            bc.aWU().b(getPageContext(), new String[]{this.lmx.clickUrl});
            finish();
        }
    }
}
