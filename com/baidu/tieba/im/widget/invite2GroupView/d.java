package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g<Boolean> {
    private final /* synthetic */ TbPageContext Pz;
    final /* synthetic */ Invite2GroupView crO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.crO = invite2GroupView;
        this.Pz = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        TextView textView;
        TextView textView2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            textView = this.crO.OE;
            textView.setTextColor(this.crO.getContext().getResources().getColor(t.d.group_info_join_disable_color));
            textView2 = this.crO.OE;
            textView2.setOnClickListener(new e(this, this.Pz));
        }
    }
}
