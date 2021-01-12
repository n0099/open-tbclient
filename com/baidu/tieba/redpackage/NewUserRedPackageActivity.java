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
    private s eCI;
    private ImageView gcW;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.gcW.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.mRI.getId()) {
                    TiebaStatic.log(new aq("c13684").an("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.mRJ != null) {
                            be.bsB().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.mRJ.clickUrl});
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
    private RoundRelativeLayout mRE;
    private ImageView mRF;
    private TextView mRG;
    private TextView mRH;
    private TextView mRI;
    private NewUserRedPackageData mRJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.mRE = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.mRE.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.mRF = (ImageView) findViewById(R.id.top_pic);
        this.gcW = (ImageView) findViewById(R.id.img_close);
        this.gcW.setOnClickListener(this.mOnClickListener);
        this.mRG = (TextView) findViewById(R.id.money_count);
        this.mRH = (TextView) findViewById(R.id.money_info);
        this.mRI = (TextView) findViewById(R.id.btn_receive);
        this.mRI.setOnClickListener(this.mOnClickListener);
        cGu();
        TiebaStatic.log(new aq("c13684").an("obj_type", 1));
        this.eCI = new s();
    }

    private void cGu() {
        if (getIntent() != null) {
            this.mRJ = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.mRJ != null) {
                a aVar = (a) d.mx().loadResourceFromMemery(this.mRJ.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.mRF.setImageBitmap(aVar.getRawBitmap());
                }
                this.mRG.setText(String.format(getString(R.string.new_user_red_package_money_count), this.mRJ.money));
                this.mRH.setText(getString(R.string.new_user_red_package_money_info));
                this.mRI.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRE, R.color.CAM_X0201);
        ao.setViewTextColor(this.mRG, R.color.CAM_X0105);
        ao.setViewTextColor(this.mRH, R.color.CAM_X0105);
        ao.setViewTextColor(this.mRI, R.color.CAM_X0302);
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
        if (i == 25046 && this.mRJ != null) {
            this.eCI.bia();
            be.bsB().b(getPageContext(), new String[]{this.mRJ.clickUrl});
            finish();
        }
    }
}
