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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes21.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    private s erc;
    private ImageView fPM;
    private RoundRelativeLayout mCN;
    private ImageView mCO;
    private TextView mCP;
    private TextView mCQ;
    private TextView mCR;
    private NewUserRedPackageData mCS;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.fPM.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.mCR.getId()) {
                    TiebaStatic.log(new ar("c13684").ak("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.mCS != null) {
                            bf.bqF().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.mCS.clickUrl});
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
            TiebaStatic.log(new ar("c13684").ak("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.mCN = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.mCN.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.mCO = (ImageView) findViewById(R.id.top_pic);
        this.fPM = (ImageView) findViewById(R.id.img_close);
        this.fPM.setOnClickListener(this.mOnClickListener);
        this.mCP = (TextView) findViewById(R.id.money_count);
        this.mCQ = (TextView) findViewById(R.id.money_info);
        this.mCR = (TextView) findViewById(R.id.btn_receive);
        this.mCR.setOnClickListener(this.mOnClickListener);
        setData();
        TiebaStatic.log(new ar("c13684").ak("obj_type", 1));
        this.erc = new s();
    }

    private void setData() {
        if (getIntent() != null) {
            this.mCS = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.mCS != null) {
                a aVar = (a) c.mS().loadResourceFromMemery(this.mCS.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.mCO.setImageBitmap(aVar.getRawBitmap());
                }
                this.mCP.setText(String.format(getString(R.string.new_user_red_package_money_count), this.mCS.money));
                this.mCQ.setText(getString(R.string.new_user_red_package_money_info));
                this.mCR.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mCN, R.color.CAM_X0201);
        ap.setViewTextColor(this.mCP, R.color.CAM_X0105);
        ap.setViewTextColor(this.mCQ, R.color.CAM_X0105);
        ap.setViewTextColor(this.mCR, R.color.CAM_X0302);
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
        if (i == 25046 && this.mCS != null) {
            this.erc.bgy();
            bf.bqF().b(getPageContext(), new String[]{this.mCS.clickUrl});
            finish();
        }
    }
}
