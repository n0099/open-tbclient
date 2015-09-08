package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class a {
    private static final String cgj = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private final PbActivity ccs;
    public final View.OnClickListener cgk = new b(this);
    public final View.OnClickListener aXJ = new c(this);
    public final View.OnClickListener cgl = new d(this);
    public final TbRichTextView.b cgm = new e(this);

    public a(PbActivity pbActivity) {
        this.ccs = pbActivity;
    }
}
