package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PersonChangeActivity personChangeActivity) {
        this.bCm = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bCm.gX(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
    }
}
