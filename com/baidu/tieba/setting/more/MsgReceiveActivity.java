package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import d.a.i0.s.d.d;
import d.a.j0.v2.c.f;
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
                    MsgReceiveActivity.this.mView.j().h();
                    MsgReceiveActivity.this.mView.p(false);
                    MsgReceiveActivity.this.mView.r(false);
                    return;
                }
                MsgReceiveActivity.this.mView.j().k();
                MsgReceiveActivity.this.mView.p(true);
                MsgReceiveActivity.this.mView.r(true);
            } else if (i2 == 9) {
                if (z) {
                    return;
                }
                if (z2) {
                    MsgReceiveActivity.this.mView.l().h();
                } else {
                    MsgReceiveActivity.this.mView.l().k();
                }
            } else if (i2 == 7) {
                if (z) {
                    d.d().P(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mView.h().h();
                } else {
                    MsgReceiveActivity.this.mView.h().k();
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
            MsgReceiveActivity.this.mView.q(arrayList);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mView.j()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(8, true, this.mMsgRemindModelCallback);
                this.mView.p(true);
                this.mView.r(true);
                return;
            }
            this.mModel.v(8, false, this.mMsgRemindModelCallback);
            this.mView.p(false);
            this.mView.r(false);
        } else if (view == this.mView.l()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(9, true, this.mMsgRemindModelCallback);
            } else {
                this.mModel.v(9, false, this.mMsgRemindModelCallback);
            }
        } else if (view == this.mView.h()) {
            this.mModel.v(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
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
        if (view == this.mView.g()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f fVar = new f(this);
        this.mView = fVar;
        fVar.m();
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
        this.mOfficialPushModel.t();
    }
}
