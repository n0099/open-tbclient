package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.b;
import com.baidu.adp.lib.a.d;
/* loaded from: classes.dex */
public abstract class AbstractSwitch {
    protected String[] mKey;
    protected String mName;
    protected int mDefaultType = 0;
    protected int mOffType = 1;
    protected int mCrashTimes = 10;
    protected b mSwitchListener = new b() { // from class: com.baidu.tieba.switchs.features.AbstractSwitch.1
        @Override // com.baidu.adp.lib.a.b
        public void callback(String str, int i) {
            AbstractSwitch.this.changeSettingByType(i);
        }
    };

    protected abstract void changeSettingByType(int i);

    protected abstract void initData();

    protected void addToManager() {
        a aVar = new a(this.mName, this.mDefaultType, this.mSwitchListener);
        aVar.a(this.mCrashTimes, this.mKey, this.mOffType);
        d.a().a(aVar);
    }

    public AbstractSwitch() {
        initData();
        addToManager();
    }
}
