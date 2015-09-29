package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class a {
    private static final String clB = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private final PbActivity ciJ;
    public final View.OnClickListener clC = new b(this);
    public final View.OnClickListener aXd = new c(this);
    public final View.OnClickListener clD = new d(this);
    public final TbRichTextView.b clE = new e(this);

    public a(PbActivity pbActivity) {
        this.ciJ = pbActivity;
    }
}
