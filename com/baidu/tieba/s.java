package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class s extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f2313a;
    public Button b;
    public Context c;

    public s(Context context, int i) {
        super(context, i);
        this.f2313a = null;
        this.b = null;
        this.c = null;
        this.c = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_private_group_tip_dialog);
        this.f2313a = (LinearLayout) findViewById(R.id.dialogparent);
        this.b = (Button) findViewById(R.id.isee);
        this.b.setOnClickListener(new t(this));
    }

    public void a(int i) {
        if (this.c instanceof CreateGroupStepActivity) {
            CreateGroupStepActivity createGroupStepActivity = (CreateGroupStepActivity) this.c;
            createGroupStepActivity.getLayoutMode().a(i == 1);
            createGroupStepActivity.getLayoutMode().a(this.f2313a);
        }
    }
}
