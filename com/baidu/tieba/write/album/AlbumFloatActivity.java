package com.baidu.tieba.write.album;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import d.a.m0.t0.a;
import d.a.n0.w3.k.e;
/* loaded from: classes5.dex */
public class AlbumFloatActivity extends SuspendedActivity {
    public e albumView;

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        if (this.albumView == null) {
            e eVar = new e(this, null, linearLayout.getId(), R.id.root_stub);
            this.albumView = eVar;
            eVar.M(navigationBar);
        }
        return this.albumView;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            this.albumView.H(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.albumView.v();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.x();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.y(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.z();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.B();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.F();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
    }
}
