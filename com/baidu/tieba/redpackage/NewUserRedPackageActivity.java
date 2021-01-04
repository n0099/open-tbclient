package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.e.d;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    private s eHt;
    private ImageView ghE;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.ghE.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.mWu.getId()) {
                    TiebaStatic.log(new aq("c13684").an("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.mWv != null) {
                            be.bwu().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.mWv.clickUrl});
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
            TiebaStatic.log(new aq("c13684").an("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };
    private RoundRelativeLayout mWq;
    private ImageView mWr;
    private TextView mWs;
    private TextView mWt;
    private TextView mWu;
    private NewUserRedPackageData mWv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.mWq = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.mWq.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.mWr = (ImageView) findViewById(R.id.top_pic);
        this.ghE = (ImageView) findViewById(R.id.img_close);
        this.ghE.setOnClickListener(this.mOnClickListener);
        this.mWs = (TextView) findViewById(R.id.money_count);
        this.mWt = (TextView) findViewById(R.id.money_info);
        this.mWu = (TextView) findViewById(R.id.btn_receive);
        this.mWu.setOnClickListener(this.mOnClickListener);
        cKl();
        TiebaStatic.log(new aq("c13684").an("obj_type", 1));
        this.eHt = new s();
    }

    private void cKl() {
        if (getIntent() != null) {
            this.mWv = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.mWv != null) {
                a aVar = (a) d.mx().loadResourceFromMemery(this.mWv.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.mWr.setImageBitmap(aVar.getRawBitmap());
                }
                this.mWs.setText(String.format(getString(R.string.new_user_red_package_money_count), this.mWv.money));
                this.mWt.setText(getString(R.string.new_user_red_package_money_info));
                this.mWu.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mWq, R.color.CAM_X0201);
        ao.setViewTextColor(this.mWs, R.color.CAM_X0105);
        ao.setViewTextColor(this.mWt, R.color.CAM_X0105);
        ao.setViewTextColor(this.mWu, R.color.CAM_X0302);
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
        if (i == 25046 && this.mWv != null) {
            this.eHt.blT();
            be.bwu().b(getPageContext(), new String[]{this.mWv.clickUrl});
            finish();
        }
    }
}
