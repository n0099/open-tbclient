package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class a {
    private static final String clM = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private final PbActivity ciU;
    public final View.OnClickListener clN = new b(this);
    public final View.OnClickListener aXo = new c(this);
    public final View.OnClickListener clO = new d(this);
    public final TbRichTextView.b clP = new e(this);

    public a(PbActivity pbActivity) {
        this.ciU = pbActivity;
    }
}
