package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class a {
    private static final String cKl = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private final PbActivity cGj;
    public final View.OnClickListener cKm = new b(this);
    public final View.OnClickListener bhv = new c(this);
    public final View.OnClickListener cKn = new d(this);
    public final TbRichTextView.c cKo = new e(this);

    public a(PbActivity pbActivity) {
        this.cGj = pbActivity;
    }
}
