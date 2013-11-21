package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.service.DealIntentService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(GuideActivity guideActivity) {
        this.f2710a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        str = this.f2710a.m;
        if (str.equals(GuideActivity.f1000a)) {
            Intent intent = new Intent(this.f2710a, DealIntentService.class);
            intent.putExtra("class", 2);
            intent.putExtra("fname", this.f2710a.getString(R.string.guide_ten_years));
            intent.putExtra("from", "guide_ten_year");
            TiebaApplication.a(intent);
            this.f2710a.setResult(-1);
        } else {
            FrsActivity.a(this.f2710a, this.f2710a.getString(R.string.guide_ten_years), "guide_ten_year");
        }
        this.f2710a.closeActivity();
    }
}
