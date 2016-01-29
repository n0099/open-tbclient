package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class a {
    private static final String cSD = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private final PbActivity cNL;
    public final View.OnClickListener cSE = new b(this);
    public final View.OnClickListener bkj = new c(this);
    public final View.OnClickListener cSF = new d(this);
    public final TbRichTextView.c cSG = new e(this);

    public a(PbActivity pbActivity) {
        this.cNL = pbActivity;
    }
}
