package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import d.a.m0.s.d.d;
import d.a.n0.w2.c.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.b {
    public MsgRemindModel mModel;
    public OfficialAccountPushModel mOfficialPushModel;
    public f mView;
    public MsgRemindModel.e mMsgRemindModelCallback = new a();
    public OfficialAccountPushModel.b mCallback = new b();

    /* loaded from: classes5.dex */
    public class a implements MsgRemindModel.e {
        public a() {
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i2, boolean z, boolean z2) {
            if (i2 == 8) {
                if (z) {
                    return;
                }
                if (z2) {
                    MsgReceiveActivity.this.mView.k().h();
                    MsgReceiveActivity.this.mView.q(false);
                    MsgReceiveActivity.this.mView.s(false);
                    return;
                }
                MsgReceiveActivity.this.mView.k().k();
                MsgReceiveActivity.this.mView.q(true);
                MsgReceiveActivity.this.mView.s(true);
            } else if (i2 == 9) {
                if (z) {
                    return;
                }
                if (z2) {
                    MsgReceiveActivity.this.mView.m().h();
                } else {
                    MsgReceiveActivity.this.mView.m().k();
                }
            } else if (i2 == 7) {
                if (z) {
                    d.d().P(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mView.i().h();
                } else {
                    MsgReceiveActivity.this.mView.i().k();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements OfficialAccountPushModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i2, String str) {
            if (i2 != OfficialAccountPushModel.NET_SUCCESS || MsgReceiveActivity.this.mView == null) {
                return;
            }
            MsgReceiveActivity.this.mView.r(arrayList);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mView.k()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.z(8, true, this.mMsgRemindModelCallback);
                this.mView.q(true);
                this.mView.s(true);
                return;
            }
            this.mModel.z(8, false, this.mMsgRemindModelCallback);
            this.mView.q(false);
            this.mView.s(false);
        } else if (view == this.mView.m()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.z(9, true, this.mMsgRemindModelCallback);
            } else {
                this.mModel.z(9, false, this.mMsgRemindModelCallback);
            }
        } else if (view == this.mView.i()) {
            this.mModel.z(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mView.h()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f fVar = new f(this);
        this.mView = fVar;
        fVar.n();
        this.mModel = new MsgRemindModel(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OfficialAccountPushModel officialAccountPushModel = this.mOfficialPushModel;
        if (officialAccountPushModel != null) {
            officialAccountPushModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mOfficialPushModel == null) {
            this.mOfficialPushModel = new OfficialAccountPushModel(this.mCallback);
        }
        this.mOfficialPushModel.x();
    }
}
