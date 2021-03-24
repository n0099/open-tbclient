package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import d.b.h0.s.d.d;
import d.b.i0.u2.c.f;
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
        public void a(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (z) {
                    return;
                }
                if (z2) {
                    MsgReceiveActivity.this.mView.k().h();
                    MsgReceiveActivity.this.mView.r(false);
                    MsgReceiveActivity.this.mView.u(false);
                    return;
                }
                MsgReceiveActivity.this.mView.k().k();
                MsgReceiveActivity.this.mView.r(true);
                MsgReceiveActivity.this.mView.u(true);
            } else if (i == 9) {
                if (z) {
                    return;
                }
                if (z2) {
                    MsgReceiveActivity.this.mView.m().h();
                } else {
                    MsgReceiveActivity.this.mView.m().k();
                }
            } else if (i == 7) {
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
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i != OfficialAccountPushModel.NET_SUCCESS || MsgReceiveActivity.this.mView == null) {
                return;
            }
            MsgReceiveActivity.this.mView.s(arrayList);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mView.k()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(8, true, this.mMsgRemindModelCallback);
                this.mView.r(true);
                this.mView.u(true);
                return;
            }
            this.mModel.v(8, false, this.mMsgRemindModelCallback);
            this.mView.r(false);
            this.mView.u(false);
        } else if (view == this.mView.m()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(9, true, this.mMsgRemindModelCallback);
            } else {
                this.mModel.v(9, false, this.mMsgRemindModelCallback);
            }
        } else if (view == this.mView.i()) {
            this.mModel.v(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.onChangeSkinType(i);
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
        this.mOfficialPushModel.t();
    }
}
