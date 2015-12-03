package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class a {
    private static final String cGm = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private final PbActivity cCy;
    public final View.OnClickListener cGn = new b(this);
    public final View.OnClickListener bdv = new c(this);
    public final View.OnClickListener cGo = new d(this);
    public final TbRichTextView.c cGp = new e(this);

    public a(PbActivity pbActivity) {
        this.cCy = pbActivity;
    }
}
