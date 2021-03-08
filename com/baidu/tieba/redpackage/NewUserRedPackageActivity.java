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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    private s eGq;
    private ImageView ggT;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.ggT.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.ndJ.getId()) {
                    TiebaStatic.log(new ar("c13684").aq("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.ndK != null) {
                            bf.bsY().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.ndK.clickUrl});
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
            TiebaStatic.log(new ar("c13684").aq("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };
    private RoundRelativeLayout ndF;
    private ImageView ndG;
    private TextView ndH;
    private TextView ndI;
    private TextView ndJ;
    private NewUserRedPackageData ndK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.ndF = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.ndF.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.ndG = (ImageView) findViewById(R.id.top_pic);
        this.ggT = (ImageView) findViewById(R.id.img_close);
        this.ggT.setOnClickListener(this.mOnClickListener);
        this.ndH = (TextView) findViewById(R.id.money_count);
        this.ndI = (TextView) findViewById(R.id.money_info);
        this.ndJ = (TextView) findViewById(R.id.btn_receive);
        this.ndJ.setOnClickListener(this.mOnClickListener);
        cHU();
        TiebaStatic.log(new ar("c13684").aq("obj_type", 1));
        this.eGq = new s();
    }

    private void cHU() {
        if (getIntent() != null) {
            this.ndK = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.ndK != null) {
                a aVar = (a) d.mw().loadResourceFromMemery(this.ndK.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.ndG.setImageBitmap(aVar.getRawBitmap());
                }
                this.ndH.setText(String.format(getString(R.string.new_user_red_package_money_count), this.ndK.money));
                this.ndI.setText(getString(R.string.new_user_red_package_money_info));
                this.ndJ.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.ndF, R.color.CAM_X0201);
        ap.setViewTextColor(this.ndH, R.color.CAM_X0105);
        ap.setViewTextColor(this.ndI, R.color.CAM_X0105);
        ap.setViewTextColor(this.ndJ, R.color.CAM_X0302);
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
        if (i == 25046 && this.ndK != null) {
            this.eGq.bip();
            bf.bsY().b(getPageContext(), new String[]{this.ndK.clickUrl});
            finish();
        }
    }
}
